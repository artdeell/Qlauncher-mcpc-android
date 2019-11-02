package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVFramebufferMultisampleCoverage {
    public static final int GL_MAX_MULTISAMPLE_COVERAGE_MODES_NV = 36369;
    public static final int GL_MULTISAMPLE_COVERAGE_MODES_NV = 36370;
    public static final int GL_RENDERBUFFER_COLOR_SAMPLES_NV = 36368;
    public static final int GL_RENDERBUFFER_COVERAGE_SAMPLES_NV = 36011;

    private NVFramebufferMultisampleCoverage() {
    }

    public static void glRenderbufferStorageMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glRenderbufferStorageMultisampleCoverageNV;
        BufferChecks.checkFunctionAddress(j);
        nglRenderbufferStorageMultisampleCoverageNV(i7, i8, i9, i10, i11, i12, j);
    }

    static native void nglRenderbufferStorageMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, long j);
}
