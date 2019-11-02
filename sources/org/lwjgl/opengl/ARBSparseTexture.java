package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBSparseTexture {
    public static final int GL_MAX_SPARSE_3D_TEXTURE_SIZE_ARB = 37273;
    public static final int GL_MAX_SPARSE_ARRAY_TEXTURE_LAYERS_ARB = 37274;
    public static final int GL_MAX_SPARSE_TEXTURE_SIZE_ARB = 37272;
    public static final int GL_NUM_SPARSE_LEVELS_ARB = 37290;
    public static final int GL_NUM_VIRTUAL_PAGE_SIZES_ARB = 37288;
    public static final int GL_SPARSE_TEXTURE_FULL_ARRAY_CUBE_MIPMAPS_ARB = 37289;
    public static final int GL_TEXTURE_SPARSE_ARB = 37286;
    public static final int GL_VIRTUAL_PAGE_SIZE_INDEX_ARB = 37287;
    public static final int GL_VIRTUAL_PAGE_SIZE_X_ARB = 37269;
    public static final int GL_VIRTUAL_PAGE_SIZE_Y_ARB = 37270;
    public static final int GL_VIRTUAL_PAGE_SIZE_Z_ARB = 37271;

    private ARBSparseTexture() {
    }

    public static void glTexPageCommitmentARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTexPageCommitmentARB;
        BufferChecks.checkFunctionAddress(j);
        nglTexPageCommitmentARB(i9, i10, i11, i12, i13, i14, i15, i16, z2, j);
    }

    public static void glTexturePageCommitmentEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTexturePageCommitmentEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTexturePageCommitmentEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, z2, j);
    }

    static native void nglTexPageCommitmentARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, long j);

    static native void nglTexturePageCommitmentEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, long j);
}
