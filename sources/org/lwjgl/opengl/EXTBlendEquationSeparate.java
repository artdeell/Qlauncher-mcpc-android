package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTBlendEquationSeparate {
    public static final int GL_BLEND_EQUATION_ALPHA_EXT = 34877;
    public static final int GL_BLEND_EQUATION_RGB_EXT = 32777;

    private EXTBlendEquationSeparate() {
    }

    public static void glBlendEquationSeparateEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBlendEquationSeparateEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationSeparateEXT(i3, i4, j);
    }

    static native void nglBlendEquationSeparateEXT(int i, int i2, long j);
}
