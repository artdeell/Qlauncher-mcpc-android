package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class AMDSparseTexture {
    public static final int GL_MAX_SPARSE_3D_TEXTURE_SIZE_AMD = 37273;
    public static final int GL_MAX_SPARSE_ARRAY_TEXTURE_LAYERS = 37274;
    public static final int GL_MAX_SPARSE_TEXTURE_SIZE_AMD = 37272;
    public static final int GL_MIN_LOD_WARNING_AMD = 37276;
    public static final int GL_MIN_SPARSE_LEVEL_AMD = 37275;
    public static final int GL_TEXTURE_STORAGE_SPARSE_BIT_AMD = 1;
    public static final int GL_VIRTUAL_PAGE_SIZE_X_AMD = 37269;
    public static final int GL_VIRTUAL_PAGE_SIZE_Y_AMD = 37270;
    public static final int GL_VIRTUAL_PAGE_SIZE_Z_AMD = 37271;

    private AMDSparseTexture() {
    }

    public static void glTexStorageSparseAMD(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j = GLContext.getCapabilities().glTexStorageSparseAMD;
        BufferChecks.checkFunctionAddress(j);
        nglTexStorageSparseAMD(i8, i9, i10, i11, i12, i13, i14, j);
    }

    public static void glTextureStorageSparseAMD(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j = GLContext.getCapabilities().glTextureStorageSparseAMD;
        BufferChecks.checkFunctionAddress(j);
        nglTextureStorageSparseAMD(i9, i10, i11, i12, i13, i14, i15, i16, j);
    }

    static native void nglTexStorageSparseAMD(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    static native void nglTextureStorageSparseAMD(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);
}
