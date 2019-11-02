package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTProvokingVertex {
    public static final int GL_FIRST_VERTEX_CONVENTION_EXT = 36429;
    public static final int GL_LAST_VERTEX_CONVENTION_EXT = 36430;
    public static final int GL_PROVOKING_VERTEX_EXT = 36431;
    public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION_EXT = 36428;

    private EXTProvokingVertex() {
    }

    public static void glProvokingVertexEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glProvokingVertexEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProvokingVertexEXT(i2, j);
    }

    static native void nglProvokingVertexEXT(int i, long j);
}
