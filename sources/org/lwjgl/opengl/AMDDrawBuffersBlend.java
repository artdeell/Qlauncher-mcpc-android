package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class AMDDrawBuffersBlend {
    private AMDDrawBuffersBlend() {
    }

    public static void glBlendEquationIndexedAMD(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBlendEquationIndexedAMD;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationIndexedAMD(i3, i4, j);
    }

    public static void glBlendEquationSeparateIndexedAMD(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBlendEquationSeparateIndexedAMD;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationSeparateIndexedAMD(i4, i5, i6, j);
    }

    public static void glBlendFuncIndexedAMD(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBlendFuncIndexedAMD;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFuncIndexedAMD(i4, i5, i6, j);
    }

    public static void glBlendFuncSeparateIndexedAMD(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glBlendFuncSeparateIndexedAMD;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFuncSeparateIndexedAMD(i6, i7, i8, i9, i10, j);
    }

    static native void nglBlendEquationIndexedAMD(int i, int i2, long j);

    static native void nglBlendEquationSeparateIndexedAMD(int i, int i2, int i3, long j);

    static native void nglBlendFuncIndexedAMD(int i, int i2, int i3, long j);

    static native void nglBlendFuncSeparateIndexedAMD(int i, int i2, int i3, int i4, int i5, long j);
}
