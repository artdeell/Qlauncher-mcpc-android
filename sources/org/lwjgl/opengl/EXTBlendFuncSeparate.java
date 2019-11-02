package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTBlendFuncSeparate {
    public static final int GL_BLEND_DST_ALPHA_EXT = 32970;
    public static final int GL_BLEND_DST_RGB_EXT = 32968;
    public static final int GL_BLEND_SRC_ALPHA_EXT = 32971;
    public static final int GL_BLEND_SRC_RGB_EXT = 32969;

    private EXTBlendFuncSeparate() {
    }

    public static void glBlendFuncSeparateEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glBlendFuncSeparateEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFuncSeparateEXT(i5, i6, i7, i8, j);
    }

    static native void nglBlendFuncSeparateEXT(int i, int i2, int i3, int i4, long j);
}
