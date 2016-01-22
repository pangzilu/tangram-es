/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.mapzen.tangram;

public class TangramJNI {
    public final static native long new_Properties();
    public final static native void Properties_clear(long jarg1, Properties jarg1_);
    public final static native boolean Properties_contains(long jarg1, Properties jarg1_, String jarg2);
    public final static native double Properties_getNumber(long jarg1, Properties jarg1_, String jarg2);
    public final static native String Properties_getString(long jarg1, Properties jarg1_, String jarg2);
    public final static native void Properties_set__SWIG_0(long jarg1, Properties jarg1_, String jarg2, String jarg3);
    public final static native void Properties_set__SWIG_1(long jarg1, Properties jarg1_, String jarg2, double jarg3);
    public final static native void delete_Properties(long jarg1);
    public final static native long new_Coordinates__SWIG_0();
    public final static native long new_Coordinates__SWIG_1(long jarg1);
    public final static native long Coordinates_size(long jarg1, Coordinates jarg1_);
    public final static native long Coordinates_capacity(long jarg1, Coordinates jarg1_);
    public final static native void Coordinates_reserve(long jarg1, Coordinates jarg1_, long jarg2);
    public final static native boolean Coordinates_isEmpty(long jarg1, Coordinates jarg1_);
    public final static native void Coordinates_clear(long jarg1, Coordinates jarg1_);
    public final static native void Coordinates_add__SWIG_0(long jarg1, Coordinates jarg1_, LngLat jarg2);
    public final static native LngLat Coordinates_get(long jarg1, Coordinates jarg1_, int jarg2);
    public final static native void Coordinates_set(long jarg1, Coordinates jarg1_, int jarg2, LngLat jarg3);
    public final static native void Coordinates_add__SWIG_1(long jarg1, Coordinates jarg1_, double jarg2, double jarg3);
    public final static native void delete_Coordinates(long jarg1);
    public final static native long new_Polygon__SWIG_0();
    public final static native long new_Polygon__SWIG_1(long jarg1);
    public final static native long Polygon_size(long jarg1, Polygon jarg1_);
    public final static native long Polygon_capacity(long jarg1, Polygon jarg1_);
    public final static native void Polygon_reserve(long jarg1, Polygon jarg1_, long jarg2);
    public final static native boolean Polygon_isEmpty(long jarg1, Polygon jarg1_);
    public final static native void Polygon_clear(long jarg1, Polygon jarg1_);
    public final static native void Polygon_add(long jarg1, Polygon jarg1_, long jarg2, Coordinates jarg2_);
    public final static native long Polygon_get(long jarg1, Polygon jarg1_, int jarg2);
    public final static native void Polygon_set(long jarg1, Polygon jarg1_, int jarg2, long jarg3, Coordinates jarg3_);
    public final static native void delete_Polygon(long jarg1);
    public final static native void DataSource_clearData(long jarg1, DataSource jarg1_);
    public final static native void DataSource_clearJNI(long jarg1, DataSource jarg1_);
    public final static native String DataSource_name(long jarg1, DataSource jarg1_);
    public final static native void delete_DataSource(long jarg1);
    public final static native long new_MapData(String jarg1, String jarg2);
    public final static native void MapData_addData(long jarg1, MapData jarg1_, String jarg2);
    public final static native void MapData_addPointJNI(long jarg1, MapData jarg1_, long jarg2, Properties jarg2_, LngLat jarg3);
    public final static native void MapData_addLineJNI(long jarg1, MapData jarg1_, long jarg2, Properties jarg2_, long jarg3, Coordinates jarg3_);
    public final static native void MapData_addPolyJNI(long jarg1, MapData jarg1_, long jarg2, Properties jarg2_, long jarg3, Polygon jarg3_);
    public final static native void delete_MapData(long jarg1);
    public final static native void addDataSource(long jarg1, DataSource jarg1_);
    public final static native void clearDataSource(long jarg1, DataSource jarg1_, boolean jarg2, boolean jarg3);
    public final static native void setDebugFlag(int jarg1, boolean jarg2);
    public final static native long MapData_SWIGSmartPtrUpcast(long jarg1);
}
