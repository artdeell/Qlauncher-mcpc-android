package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTBlendMinmax {
    public static final int GL_BLEND_EQUATION_EXT = 32777;
    public static final int GL_FUNC_ADD_EXT = 32774;
    public static final int GL_MAX_EXT = 32776;
    public static final int GL_MIN_EXT = 32775;

    private EXTBlendMinmax() {
    }

    public static void glBlendEquationEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBlendEquationEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationEXT(i2, j);
    }

    static native void nglBlendEquationEXT(int i, long j);
}
