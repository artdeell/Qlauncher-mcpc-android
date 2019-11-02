package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVCopyImage {
    private NVCopyImage() {
    }

    public static void glCopyImageSubDataNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = i;
        int i17 = i2;
        int i18 = i3;
        int i19 = i4;
        int i20 = i5;
        int i21 = i6;
        int i22 = i7;
        int i23 = i8;
        int i24 = i9;
        int i25 = i10;
        int i26 = i11;
        int i27 = i12;
        int i28 = i13;
        int i29 = i14;
        int i30 = i15;
        long j = GLContext.getCapabilities().glCopyImageSubDataNV;
        BufferChecks.checkFunctionAddress(j);
        nglCopyImageSubDataNV(i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, j);
    }

    static native void nglCopyImageSubDataNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, long j);
}
