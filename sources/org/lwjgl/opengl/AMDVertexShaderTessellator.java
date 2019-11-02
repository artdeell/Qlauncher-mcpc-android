package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class AMDVertexShaderTessellator {
    public static final int GL_CONTINUOUS_AMD = 36871;
    public static final int GL_DISCRETE_AMD = 36870;
    public static final int GL_INT_SAMPLER_BUFFER_AMD = 36866;
    public static final int GL_SAMPLER_BUFFER_AMD = 36865;
    public static final int GL_TESSELLATION_FACTOR_AMD = 36869;
    public static final int GL_TESSELLATION_MODE_AMD = 36868;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_AMD = 36867;

    private AMDVertexShaderTessellator() {
    }

    public static void glTessellationFactorAMD(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glTessellationFactorAMD;
        BufferChecks.checkFunctionAddress(j);
        nglTessellationFactorAMD(f2, j);
    }

    public static void glTessellationModeAMD(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glTessellationModeAMD;
        BufferChecks.checkFunctionAddress(j);
        nglTessellationModeAMD(i2, j);
    }

    static native void nglTessellationFactorAMD(float f, long j);

    static native void nglTessellationModeAMD(int i, long j);
}
