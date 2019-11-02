package org.lwjgl.util.glu.tessellation;

class GLUmesh {
    GLUhalfEdge eHead;
    GLUhalfEdge eHeadSym;
    GLUface fHead;
    GLUvertex vHead;

    GLUmesh() {
        GLUvertex gLUvertex;
        GLUface gLUface;
        GLUhalfEdge gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge2;
        GLUvertex gLUvertex2 = gLUvertex;
        GLUvertex gLUvertex3 = new GLUvertex();
        this.vHead = gLUvertex2;
        GLUface gLUface2 = gLUface;
        GLUface gLUface3 = new GLUface();
        this.fHead = gLUface2;
        GLUhalfEdge gLUhalfEdge3 = gLUhalfEdge;
        GLUhalfEdge gLUhalfEdge4 = new GLUhalfEdge(true);
        this.eHead = gLUhalfEdge3;
        GLUhalfEdge gLUhalfEdge5 = gLUhalfEdge2;
        GLUhalfEdge gLUhalfEdge6 = new GLUhalfEdge(false);
        this.eHeadSym = gLUhalfEdge5;
    }
}
