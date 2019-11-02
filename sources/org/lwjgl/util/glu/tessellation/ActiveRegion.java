package org.lwjgl.util.glu.tessellation;

class ActiveRegion {
    boolean dirty;
    GLUhalfEdge eUp;
    boolean fixUpperEdge;
    boolean inside;
    DictNode nodeUp;
    boolean sentinel;
    int windingNumber;

    ActiveRegion() {
    }
}
