package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVDrawTexture {
    private NVDrawTexture() {
    }

    public static void glDrawTextureNV(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        int i3 = i;
        int i4 = i2;
        float f10 = f;
        float f11 = f2;
        float f12 = f3;
        float f13 = f4;
        float f14 = f5;
        float f15 = f6;
        float f16 = f7;
        float f17 = f8;
        float f18 = f9;
        long j = GLContext.getCapabilities().glDrawTextureNV;
        BufferChecks.checkFunctionAddress(j);
        nglDrawTextureNV(i3, i4, f10, f11, f12, f13, f14, f15, f16, f17, f18, j);
    }

    static native void nglDrawTextureNV(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j);
}
