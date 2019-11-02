package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBMultitexture {
    public static final int GL_ACTIVE_TEXTURE_ARB = 34016;
    public static final int GL_CLIENT_ACTIVE_TEXTURE_ARB = 34017;
    public static final int GL_MAX_TEXTURE_UNITS_ARB = 34018;
    public static final int GL_TEXTURE0_ARB = 33984;
    public static final int GL_TEXTURE10_ARB = 33994;
    public static final int GL_TEXTURE11_ARB = 33995;
    public static final int GL_TEXTURE12_ARB = 33996;
    public static final int GL_TEXTURE13_ARB = 33997;
    public static final int GL_TEXTURE14_ARB = 33998;
    public static final int GL_TEXTURE15_ARB = 33999;
    public static final int GL_TEXTURE16_ARB = 34000;
    public static final int GL_TEXTURE17_ARB = 34001;
    public static final int GL_TEXTURE18_ARB = 34002;
    public static final int GL_TEXTURE19_ARB = 34003;
    public static final int GL_TEXTURE1_ARB = 33985;
    public static final int GL_TEXTURE20_ARB = 34004;
    public static final int GL_TEXTURE21_ARB = 34005;
    public static final int GL_TEXTURE22_ARB = 34006;
    public static final int GL_TEXTURE23_ARB = 34007;
    public static final int GL_TEXTURE24_ARB = 34008;
    public static final int GL_TEXTURE25_ARB = 34009;
    public static final int GL_TEXTURE26_ARB = 34010;
    public static final int GL_TEXTURE27_ARB = 34011;
    public static final int GL_TEXTURE28_ARB = 34012;
    public static final int GL_TEXTURE29_ARB = 34013;
    public static final int GL_TEXTURE2_ARB = 33986;
    public static final int GL_TEXTURE30_ARB = 34014;
    public static final int GL_TEXTURE31_ARB = 34015;
    public static final int GL_TEXTURE3_ARB = 33987;
    public static final int GL_TEXTURE4_ARB = 33988;
    public static final int GL_TEXTURE5_ARB = 33989;
    public static final int GL_TEXTURE6_ARB = 33990;
    public static final int GL_TEXTURE7_ARB = 33991;
    public static final int GL_TEXTURE8_ARB = 33992;
    public static final int GL_TEXTURE9_ARB = 33993;

    private ARBMultitexture() {
    }

    public static void glActiveTextureARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glActiveTextureARB;
        BufferChecks.checkFunctionAddress(j);
        nglActiveTextureARB(i2, j);
    }

    public static void glClientActiveTextureARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glClientActiveTextureARB;
        BufferChecks.checkFunctionAddress(j);
        nglClientActiveTextureARB(i2, j);
    }

    public static void glMultiTexCoord1dARB(int i, double d) {
        int i2 = i;
        double d2 = d;
        long j = GLContext.getCapabilities().glMultiTexCoord1dARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord1dARB(i2, d2, j);
    }

    public static void glMultiTexCoord1fARB(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glMultiTexCoord1fARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord1fARB(i2, f2, j);
    }

    public static void glMultiTexCoord1iARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glMultiTexCoord1iARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord1iARB(i3, i4, j);
    }

    public static void glMultiTexCoord1sARB(int i, short s) {
        int i2 = i;
        short s2 = s;
        long j = GLContext.getCapabilities().glMultiTexCoord1sARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord1sARB(i2, s2, j);
    }

    public static void glMultiTexCoord2dARB(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glMultiTexCoord2dARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord2dARB(i2, d3, d4, j);
    }

    public static void glMultiTexCoord2fARB(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glMultiTexCoord2fARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord2fARB(i2, f3, f4, j);
    }

    public static void glMultiTexCoord2iARB(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glMultiTexCoord2iARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord2iARB(i4, i5, i6, j);
    }

    public static void glMultiTexCoord2sARB(int i, short s, short s2) {
        int i2 = i;
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glMultiTexCoord2sARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord2sARB(i2, s3, s4, j);
    }

    public static void glMultiTexCoord3dARB(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glMultiTexCoord3dARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord3dARB(i2, d4, d5, d6, j);
    }

    public static void glMultiTexCoord3fARB(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glMultiTexCoord3fARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord3fARB(i2, f4, f5, f6, j);
    }

    public static void glMultiTexCoord3iARB(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glMultiTexCoord3iARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord3iARB(i5, i6, i7, i8, j);
    }

    public static void glMultiTexCoord3sARB(int i, short s, short s2, short s3) {
        int i2 = i;
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glMultiTexCoord3sARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord3sARB(i2, s4, s5, s6, j);
    }

    public static void glMultiTexCoord4dARB(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glMultiTexCoord4dARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord4dARB(i2, d5, d6, d7, d8, j);
    }

    public static void glMultiTexCoord4fARB(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glMultiTexCoord4fARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord4fARB(i2, f5, f6, f7, f8, j);
    }

    public static void glMultiTexCoord4iARB(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glMultiTexCoord4iARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord4iARB(i6, i7, i8, i9, i10, j);
    }

    public static void glMultiTexCoord4sARB(int i, short s, short s2, short s3, short s4) {
        int i2 = i;
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glMultiTexCoord4sARB;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord4sARB(i2, s5, s6, s7, s8, j);
    }

    static native void nglActiveTextureARB(int i, long j);

    static native void nglClientActiveTextureARB(int i, long j);

    static native void nglMultiTexCoord1dARB(int i, double d, long j);

    static native void nglMultiTexCoord1fARB(int i, float f, long j);

    static native void nglMultiTexCoord1iARB(int i, int i2, long j);

    static native void nglMultiTexCoord1sARB(int i, short s, long j);

    static native void nglMultiTexCoord2dARB(int i, double d, double d2, long j);

    static native void nglMultiTexCoord2fARB(int i, float f, float f2, long j);

    static native void nglMultiTexCoord2iARB(int i, int i2, int i3, long j);

    static native void nglMultiTexCoord2sARB(int i, short s, short s2, long j);

    static native void nglMultiTexCoord3dARB(int i, double d, double d2, double d3, long j);

    static native void nglMultiTexCoord3fARB(int i, float f, float f2, float f3, long j);

    static native void nglMultiTexCoord3iARB(int i, int i2, int i3, int i4, long j);

    static native void nglMultiTexCoord3sARB(int i, short s, short s2, short s3, long j);

    static native void nglMultiTexCoord4dARB(int i, double d, double d2, double d3, double d4, long j);

    static native void nglMultiTexCoord4fARB(int i, float f, float f2, float f3, float f4, long j);

    static native void nglMultiTexCoord4iARB(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglMultiTexCoord4sARB(int i, short s, short s2, short s3, short s4, long j);
}
