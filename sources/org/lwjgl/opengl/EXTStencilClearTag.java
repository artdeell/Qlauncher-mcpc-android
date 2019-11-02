package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTStencilClearTag {
    public static final int GL_STENCIL_CLEAR_TAG_VALUE_EXT = 35059;
    public static final int GL_STENCIL_TAG_BITS_EXT = 35058;

    private EXTStencilClearTag() {
    }

    public static void glStencilClearTagEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glStencilClearTagEXT;
        BufferChecks.checkFunctionAddress(j);
        nglStencilClearTagEXT(i3, i4, j);
    }

    static native void nglStencilClearTagEXT(int i, int i2, long j);
}
