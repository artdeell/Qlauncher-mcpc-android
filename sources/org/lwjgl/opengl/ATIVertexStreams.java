package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ATIVertexStreams {
    public static final int GL_MAX_VERTEX_STREAMS_ATI = 34667;
    public static final int GL_VERTEX_SOURCE_ATI = 34668;
    public static final int GL_VERTEX_STREAM0_ATI = 34669;
    public static final int GL_VERTEX_STREAM1_ATI = 34670;
    public static final int GL_VERTEX_STREAM2_ATI = 34671;
    public static final int GL_VERTEX_STREAM3_ATI = 34672;
    public static final int GL_VERTEX_STREAM4_ATI = 34673;
    public static final int GL_VERTEX_STREAM5_ATI = 34674;
    public static final int GL_VERTEX_STREAM6_ATI = 34675;
    public static final int GL_VERTEX_STREAM7_ATI = 34676;

    private ATIVertexStreams() {
    }

    public static void glClientActiveVertexStreamATI(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glClientActiveVertexStreamATI;
        BufferChecks.checkFunctionAddress(j);
        nglClientActiveVertexStreamATI(i2, j);
    }

    public static void glNormalStream3bATI(int i, byte b, byte b2, byte b3) {
        int i2 = i;
        byte b4 = b;
        byte b5 = b2;
        byte b6 = b3;
        long j = GLContext.getCapabilities().glNormalStream3bATI;
        BufferChecks.checkFunctionAddress(j);
        nglNormalStream3bATI(i2, b4, b5, b6, j);
    }

    public static void glNormalStream3dATI(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glNormalStream3dATI;
        BufferChecks.checkFunctionAddress(j);
        nglNormalStream3dATI(i2, d4, d5, d6, j);
    }

    public static void glNormalStream3fATI(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glNormalStream3fATI;
        BufferChecks.checkFunctionAddress(j);
        nglNormalStream3fATI(i2, f4, f5, f6, j);
    }

    public static void glNormalStream3iATI(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glNormalStream3iATI;
        BufferChecks.checkFunctionAddress(j);
        nglNormalStream3iATI(i5, i6, i7, i8, j);
    }

    public static void glNormalStream3sATI(int i, short s, short s2, short s3) {
        int i2 = i;
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glNormalStream3sATI;
        BufferChecks.checkFunctionAddress(j);
        nglNormalStream3sATI(i2, s4, s5, s6, j);
    }

    public static void glVertexBlendEnvfATI(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glVertexBlendEnvfATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexBlendEnvfATI(i2, f2, j);
    }

    public static void glVertexBlendEnviATI(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexBlendEnviATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexBlendEnviATI(i3, i4, j);
    }

    public static void glVertexStream2dATI(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glVertexStream2dATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream2dATI(i2, d3, d4, j);
    }

    public static void glVertexStream2fATI(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glVertexStream2fATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream2fATI(i2, f3, f4, j);
    }

    public static void glVertexStream2iATI(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexStream2iATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream2iATI(i4, i5, i6, j);
    }

    public static void glVertexStream2sATI(int i, short s, short s2) {
        int i2 = i;
        short s3 = s;
        short s4 = s2;
        long j = GLContext.getCapabilities().glVertexStream2sATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream2sATI(i2, s3, s4, j);
    }

    public static void glVertexStream3dATI(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glVertexStream3dATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream3dATI(i2, d4, d5, d6, j);
    }

    public static void glVertexStream3fATI(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glVertexStream3fATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream3fATI(i2, f4, f5, f6, j);
    }

    public static void glVertexStream3iATI(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glVertexStream3iATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream3iATI(i5, i6, i7, i8, j);
    }

    public static void glVertexStream3sATI(int i, short s, short s2, short s3) {
        int i2 = i;
        short s4 = s;
        short s5 = s2;
        short s6 = s3;
        long j = GLContext.getCapabilities().glVertexStream3sATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream3sATI(i2, s4, s5, s6, j);
    }

    public static void glVertexStream4dATI(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glVertexStream4dATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream4dATI(i2, d5, d6, d7, d8, j);
    }

    public static void glVertexStream4fATI(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glVertexStream4fATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream4fATI(i2, f5, f6, f7, f8, j);
    }

    public static void glVertexStream4iATI(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glVertexStream4iATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream4iATI(i6, i7, i8, i9, i10, j);
    }

    public static void glVertexStream4sATI(int i, short s, short s2, short s3, short s4) {
        int i2 = i;
        short s5 = s;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        long j = GLContext.getCapabilities().glVertexStream4sATI;
        BufferChecks.checkFunctionAddress(j);
        nglVertexStream4sATI(i2, s5, s6, s7, s8, j);
    }

    static native void nglClientActiveVertexStreamATI(int i, long j);

    static native void nglNormalStream3bATI(int i, byte b, byte b2, byte b3, long j);

    static native void nglNormalStream3dATI(int i, double d, double d2, double d3, long j);

    static native void nglNormalStream3fATI(int i, float f, float f2, float f3, long j);

    static native void nglNormalStream3iATI(int i, int i2, int i3, int i4, long j);

    static native void nglNormalStream3sATI(int i, short s, short s2, short s3, long j);

    static native void nglVertexBlendEnvfATI(int i, float f, long j);

    static native void nglVertexBlendEnviATI(int i, int i2, long j);

    static native void nglVertexStream2dATI(int i, double d, double d2, long j);

    static native void nglVertexStream2fATI(int i, float f, float f2, long j);

    static native void nglVertexStream2iATI(int i, int i2, int i3, long j);

    static native void nglVertexStream2sATI(int i, short s, short s2, long j);

    static native void nglVertexStream3dATI(int i, double d, double d2, double d3, long j);

    static native void nglVertexStream3fATI(int i, float f, float f2, float f3, long j);

    static native void nglVertexStream3iATI(int i, int i2, int i3, int i4, long j);

    static native void nglVertexStream3sATI(int i, short s, short s2, short s3, long j);

    static native void nglVertexStream4dATI(int i, double d, double d2, double d3, double d4, long j);

    static native void nglVertexStream4fATI(int i, float f, float f2, float f3, float f4, long j);

    static native void nglVertexStream4iATI(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglVertexStream4sATI(int i, short s, short s2, short s3, short s4, long j);
}
