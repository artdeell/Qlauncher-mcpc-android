package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBWindowPos {
    private ARBWindowPos() {
    }

    public static void glWindowPos2dARB(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glWindowPos2dARB;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos2dARB(d3, d4, j);
    }

    public static void glWindowPos2fARB(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glWindowPos2fARB;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos2fARB(f3, f4, j);
    }

    public static void glWindowPos2iARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glWindowPos2iARB;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos2iARB(i3, i4, j);
    }

    public static void glWindowPos2sARB(short s, short s2) {
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glWindowPos2sARB;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos2sARB(s3, s4, j);
    }

    public static void glWindowPos3dARB(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glWindowPos3dARB;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos3dARB(d4, d5, d6, j);
    }

    public static void glWindowPos3fARB(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glWindowPos3fARB;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos3fARB(f4, f5, f6, j);
    }

    public static void glWindowPos3iARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glWindowPos3iARB;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos3iARB(i4, i5, i6, j);
    }

    public static void glWindowPos3sARB(short s, short s2, short s3) {
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glWindowPos3sARB;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos3sARB(s4, s5, s6, j);
    }

    static native void nglWindowPos2dARB(double d, double d2, long j);

    static native void nglWindowPos2fARB(float f, float f2, long j);

    static native void nglWindowPos2iARB(int i, int i2, long j);

    static native void nglWindowPos2sARB(short s, short s2, long j);

    static native void nglWindowPos3dARB(double d, double d2, double d3, long j);

    static native void nglWindowPos3fARB(float f, float f2, float f3, long j);

    static native void nglWindowPos3iARB(int i, int i2, int i3, long j);

    static native void nglWindowPos3sARB(short s, short s2, short s3, long j);
}
