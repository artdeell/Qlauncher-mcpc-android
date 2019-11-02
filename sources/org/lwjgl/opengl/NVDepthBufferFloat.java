package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVDepthBufferFloat {
    public static final int GL_DEPTH32F_STENCIL8_NV = 36268;
    public static final int GL_DEPTH_BUFFER_FLOAT_MODE_NV = 36271;
    public static final int GL_DEPTH_COMPONENT32F_NV = 36267;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV_NV = 36269;

    private NVDepthBufferFloat() {
    }

    public static void glClearDepthdNV(double d) {
        double d2 = d;
        long j = GLContext.getCapabilities().glClearDepthdNV;
        BufferChecks.checkFunctionAddress(j);
        nglClearDepthdNV(d2, j);
    }

    public static void glDepthBoundsdNV(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glDepthBoundsdNV;
        BufferChecks.checkFunctionAddress(j);
        nglDepthBoundsdNV(d3, d4, j);
    }

    public static void glDepthRangedNV(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glDepthRangedNV;
        BufferChecks.checkFunctionAddress(j);
        nglDepthRangedNV(d3, d4, j);
    }

    static native void nglClearDepthdNV(double d, long j);

    static native void nglDepthBoundsdNV(double d, double d2, long j);

    static native void nglDepthRangedNV(double d, double d2, long j);
}
