package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBTextureStorage {
    public static final int GL_TEXTURE_IMMUTABLE_FORMAT = 37167;

    private ARBTextureStorage() {
    }

    public static void glTexStorage1D(int i, int i2, int i3, int i4) {
        GL42.glTexStorage1D(i, i2, i3, i4);
    }

    public static void glTexStorage2D(int i, int i2, int i3, int i4, int i5) {
        GL42.glTexStorage2D(i, i2, i3, i4, i5);
    }

    public static void glTexStorage3D(int i, int i2, int i3, int i4, int i5, int i6) {
        GL42.glTexStorage3D(i, i2, i3, i4, i5, i6);
    }

    public static void glTextureStorage1DEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glTextureStorage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureStorage1DEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glTextureStorage2DEXT(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glTextureStorage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureStorage2DEXT(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glTextureStorage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j = GLContext.getCapabilities().glTextureStorage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureStorage3DEXT(i8, i9, i10, i11, i12, i13, i14, j);
    }

    static native void nglTextureStorage1DEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglTextureStorage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglTextureStorage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);
}
