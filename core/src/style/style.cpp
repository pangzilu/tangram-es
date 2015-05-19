#include "style.h"
#include "scene/scene.h"

Style::Style(std::string _name, GLenum _drawMode) : m_name(_name), m_drawMode(_drawMode) {
}

Style::~Style() {
}

void Style::setMaterial(const std::shared_ptr<Material>& _material){

    if ( m_material ) {
        m_material->removeFromProgram(m_shaderProgram);
    }

    m_material = _material;
    m_material->injectOnProgram(m_shaderProgram);
    
}

void Style::addLayer(const std::pair<std::string, StyleParams>& _layer) {
    m_layers.push_back(_layer);
}

void Style::addData(TileData& _data, MapTile& _tile, const MapProjection& _mapProjection)  const {
    prepareDataProcessing(_tile);

    VboMesh* mesh = newMesh();
    
    for (auto& layer : _data.layers) {
        
        // Skip any layers that this style doesn't have a rule for
        auto it = m_layers.begin();
        while (it != m_layers.end() && it->first != layer.name) { ++it; }
        if (it == m_layers.end()) { continue; }

        StyleParams params = it->second;
        
        // Loop over all features
        for (auto& feature : layer.features) {

            feature.props.numericProps["zoom"] = _tile.getID().z;
            
            switch (feature.geometryType) {
                case GeometryType::POINTS:
                    // Build points
                    for (auto& point : feature.points) {
                        buildPoint(point, params, feature.props, *mesh);
                    }
                    break;
                case GeometryType::LINES:
                    // Build lines
                    for (auto& line : feature.lines) {
                        buildLine(line, params, feature.props, *mesh);
                    }
                    break;
                case GeometryType::POLYGONS:
                    // Build polygons
                    for (auto& polygon : feature.polygons) {
                        buildPolygon(polygon, params, feature.props, *mesh);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    if (mesh->numVertices() == 0) {
        delete mesh;
    } else {
        mesh->compileVertexBuffer();

        _tile.addGeometry(*this, std::unique_ptr<VboMesh>(mesh));
    }
    finishDataProcessing(_tile);
}

void Style::setupFrame(const std::shared_ptr<View>& _view, const std::shared_ptr<Scene>& _scene) {
    
    // Set up material
    if (!m_material) {
        setMaterial(std::make_shared<Material>());
    }
    
    m_material->setupProgram(m_shaderProgram);
    
    // Set up lights
    for (const auto& light : _scene->getLights()) {
        light.second->setupProgram(_view,m_shaderProgram);
    }
    
    m_shaderProgram->setUniformf("u_zoom", _view->getZoom());
}

void Style::setLighting( LightingType _lType ){

    if ( _lType == LightingType::vertex ) {
        m_shaderProgram->removeSourceBlock("defines", "#define TANGRAM_LIGHTING_FRAGMENT\n");
        m_shaderProgram->addSourceBlock(   "defines", "#define TANGRAM_LIGHTING_VERTEX\n", false);
    } else if  (_lType == LightingType::fragment ) {
        m_shaderProgram->removeSourceBlock("defines", "#define TANGRAM_LIGHTING_VERTEX\n");
        m_shaderProgram->addSourceBlock(   "defines", "#define TANGRAM_LIGHTING_FRAGMENT\n", false);
    } else {
        m_shaderProgram->removeSourceBlock("defines", "#define TANGRAM_LIGHTING_VERTEX\n");
        m_shaderProgram->removeSourceBlock("defines", "#define TANGRAM_LIGHTING_FRAGMENT\n");
    }
    
}
    
void Style::setupTile(const std::shared_ptr<MapTile>& _tile) {
    // No-op by default
}

void Style::prepareDataProcessing(MapTile& _tile) const {
    // No-op by default
}

void Style::finishDataProcessing(MapTile& _tile) const {
    // No-op by default
}
