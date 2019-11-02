package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBSampleShading {
    public static final int GL_MIN_SAMPLE_SHADING_VALUE_ARB = 35895;
    public static final int GL_SAMPLE_SHADING_ARB = 35894;

    private ARBSampleShading() {
    }

    public static void glMinSampleShadingARB(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glMinSampleShadingARB;
        BufferChecks.checkFunctionAddress(j);
        nglMinSampleShadingARB(f2, j);
    }

    static native void nglMinSampleShadingARB(float f, long j);
}
