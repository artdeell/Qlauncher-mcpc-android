package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTStencilTwoSide {
    public static final int GL_ACTIVE_STENCIL_FACE_EXT = 35089;
    public static final int GL_STENCIL_TEST_TWO_SIDE_EXT = 35088;

    private EXTStencilTwoSide() {
    }

    public static void glActiveStencilFaceEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glActiveStencilFaceEXT;
        BufferChecks.checkFunctionAddress(j);
        nglActiveStencilFaceEXT(i2, j);
    }

    static native void nglActiveStencilFaceEXT(int i, long j);
}
