package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVTextureMultisample {
    public static final int GL_TEXTURE_COLOR_SAMPLES_NV = 36934;
    public static final int GL_TEXTURE_COVERAGE_SAMPLES_NV = 36933;

    private NVTextureMultisample() {
    }

    public static void glTexImage2DMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTexImage2DMultisampleCoverageNV;
        BufferChecks.checkFunctionAddress(j);
        nglTexImage2DMultisampleCoverageNV(i7, i8, i9, i10, i11, i12, z2, j);
    }

    public static void glTexImage3DMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTexImage3DMultisampleCoverageNV;
        BufferChecks.checkFunctionAddress(j);
        nglTexImage3DMultisampleCoverageNV(i8, i9, i10, i11, i12, i13, i14, z2, j);
    }

    public static void glTextureImage2DMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTextureImage2DMultisampleCoverageNV;
        BufferChecks.checkFunctionAddress(j);
        nglTextureImage2DMultisampleCoverageNV(i8, i9, i10, i11, i12, i13, i14, z2, j);
    }

    public static void glTextureImage2DMultisampleNV(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTextureImage2DMultisampleNV;
        BufferChecks.checkFunctionAddress(j);
        nglTextureImage2DMultisampleNV(i7, i8, i9, i10, i11, i12, z2, j);
    }

    public static void glTextureImage3DMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTextureImage3DMultisampleCoverageNV;
        BufferChecks.checkFunctionAddress(j);
        nglTextureImage3DMultisampleCoverageNV(i9, i10, i11, i12, i13, i14, i15, i16, z2, j);
    }

    public static void glTextureImage3DMultisampleNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTextureImage3DMultisampleNV;
        BufferChecks.checkFunctionAddress(j);
        nglTextureImage3DMultisampleNV(i8, i9, i10, i11, i12, i13, i14, z2, j);
    }

    static native void nglTexImage2DMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, boolean z, long j);

    static native void nglTexImage3DMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, long j);

    static native void nglTextureImage2DMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, long j);

    static native void nglTextureImage2DMultisampleNV(int i, int i2, int i3, int i4, int i5, int i6, boolean z, long j);

    static native void nglTextureImage3DMultisampleCoverageNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, long j);

    static native void nglTextureImage3DMultisampleNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, long j);
}
