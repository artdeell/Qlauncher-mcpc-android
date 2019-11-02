package org.lwjgl.util.glu.tessellation;

class GLUvertex {
    public GLUhalfEdge anEdge;
    public double[] coords = new double[3];
    public Object data;
    public GLUvertex next;
    public int pqHandle;
    public GLUvertex prev;

    /* renamed from: s */
    public double f242s;

    /* renamed from: t */
    public double f243t;

    GLUvertex() {
    }
}
