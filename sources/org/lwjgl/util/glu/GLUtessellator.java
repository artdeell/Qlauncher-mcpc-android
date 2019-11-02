package org.lwjgl.util.glu;

public interface GLUtessellator {
    void gluBeginPolygon();

    void gluDeleteTess();

    void gluEndPolygon();

    void gluGetTessProperty(int i, double[] dArr, int i2);

    void gluNextContour(int i);

    void gluTessBeginContour();

    void gluTessBeginPolygon(Object obj);

    void gluTessCallback(int i, GLUtessellatorCallback gLUtessellatorCallback);

    void gluTessEndContour();

    void gluTessEndPolygon();

    void gluTessNormal(double d, double d2, double d3);

    void gluTessProperty(int i, double d);

    void gluTessVertex(double[] dArr, int i, Object obj);
}
