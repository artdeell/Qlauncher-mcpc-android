package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBTextureStorageMultisample {
    private ARBTextureStorageMultisample() {
    }

    public static void glTexStorage2DMultisample(int i, int i2, int i3, int i4, int i5, boolean z) {
        GL43.glTexStorage2DMultisample(i, i2, i3, i4, i5, z);
    }

    public static void glTexStorage3DMultisample(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        GL43.glTexStorage3DMultisample(i, i2, i3, i4, i5, i6, z);
    }

    public static void glTextureStorage2DMultisampleEXT(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTextureStorage2DMultisampleEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureStorage2DMultisampleEXT(i7, i8, i9, i10, i11, i12, z2, j);
    }

    public static void glTextureStorage3DMultisampleEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glTextureStorage3DMultisampleEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureStorage3DMultisampleEXT(i8, i9, i10, i11, i12, i13, i14, z2, j);
    }

    static native void nglTextureStorage2DMultisampleEXT(int i, int i2, int i3, int i4, int i5, int i6, boolean z, long j);

    static native void nglTextureStorage3DMultisampleEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, long j);
}
