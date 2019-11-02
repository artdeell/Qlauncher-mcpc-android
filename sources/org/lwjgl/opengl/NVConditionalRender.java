package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVConditionalRender {
    public static final int GL_QUERY_BY_REGION_NO_WAIT_NV = 36374;
    public static final int GL_QUERY_BY_REGION_WAIT_NV = 36373;
    public static final int GL_QUERY_NO_WAIT_NV = 36372;
    public static final int GL_QUERY_WAIT_NV = 36371;

    private NVConditionalRender() {
    }

    public static void glBeginConditionalRenderNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBeginConditionalRenderNV;
        BufferChecks.checkFunctionAddress(j);
        nglBeginConditionalRenderNV(i3, i4, j);
    }

    public static void glEndConditionalRenderNV() {
        long j = GLContext.getCapabilities().glEndConditionalRenderNV;
        BufferChecks.checkFunctionAddress(j);
        nglEndConditionalRenderNV(j);
    }

    static native void nglBeginConditionalRenderNV(int i, int i2, long j);

    static native void nglEndConditionalRenderNV(long j);
}
