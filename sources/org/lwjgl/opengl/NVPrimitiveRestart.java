package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVPrimitiveRestart {
    public static final int GL_PRIMITIVE_RESTART_INDEX_NV = 34137;
    public static final int GL_PRIMITIVE_RESTART_NV = 34136;

    private NVPrimitiveRestart() {
    }

    public static void glPrimitiveRestartIndexNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glPrimitiveRestartIndexNV;
        BufferChecks.checkFunctionAddress(j);
        nglPrimitiveRestartIndexNV(i2, j);
    }

    public static void glPrimitiveRestartNV() {
        long j = GLContext.getCapabilities().glPrimitiveRestartNV;
        BufferChecks.checkFunctionAddress(j);
        nglPrimitiveRestartNV(j);
    }

    static native void nglPrimitiveRestartIndexNV(int i, long j);

    static native void nglPrimitiveRestartNV(long j);
}
