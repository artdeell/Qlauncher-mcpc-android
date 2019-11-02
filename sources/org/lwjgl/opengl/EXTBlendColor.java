package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTBlendColor {
    public static final int GL_BLEND_COLOR_EXT = 32773;
    public static final int GL_CONSTANT_ALPHA_EXT = 32771;
    public static final int GL_CONSTANT_COLOR_EXT = 32769;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA_EXT = 32772;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR_EXT = 32770;

    private EXTBlendColor() {
    }

    public static void glBlendColorEXT(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glBlendColorEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBlendColorEXT(f5, f6, f7, f8, j);
    }

    static native void nglBlendColorEXT(float f, float f2, float f3, float f4, long j);
}
