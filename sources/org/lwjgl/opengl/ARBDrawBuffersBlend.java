package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBDrawBuffersBlend {
    private ARBDrawBuffersBlend() {
    }

    public static void glBlendEquationSeparateiARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBlendEquationSeparateiARB;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationSeparateiARB(i4, i5, i6, j);
    }

    public static void glBlendEquationiARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBlendEquationiARB;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquationiARB(i3, i4, j);
    }

    public static void glBlendFuncSeparateiARB(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glBlendFuncSeparateiARB;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFuncSeparateiARB(i6, i7, i8, i9, i10, j);
    }

    public static void glBlendFunciARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBlendFunciARB;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFunciARB(i4, i5, i6, j);
    }

    static native void nglBlendEquationSeparateiARB(int i, int i2, int i3, long j);

    static native void nglBlendEquationiARB(int i, int i2, long j);

    static native void nglBlendFuncSeparateiARB(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglBlendFunciARB(int i, int i2, int i3, long j);
}
