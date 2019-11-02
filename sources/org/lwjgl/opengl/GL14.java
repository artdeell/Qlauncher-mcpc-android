package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class GL14 {
    public static final int GL_BLEND_COLOR = 32773;
    public static final int GL_BLEND_DST_ALPHA = 32970;
    public static final int GL_BLEND_DST_RGB = 32968;
    public static final int GL_BLEND_EQUATION = 32777;
    public static final int GL_BLEND_SRC_ALPHA = 32971;
    public static final int GL_BLEND_SRC_RGB = 32969;
    public static final int GL_COLOR_SUM = 33880;
    public static final int GL_COMPARE_R_TO_TEXTURE = 34894;
    public static final int GL_CURRENT_FOG_COORDINATE = 33875;
    public static final int GL_CURRENT_SECONDARY_COLOR = 33881;
    public static final int GL_DECR_WRAP = 34056;
    public static final int GL_DEPTH_COMPONENT16 = 33189;
    public static final int GL_DEPTH_COMPONENT24 = 33190;
    public static final int GL_DEPTH_COMPONENT32 = 33191;
    public static final int GL_DEPTH_TEXTURE_MODE = 34891;
    public static final int GL_FOG_COORDINATE = 33873;
    public static final int GL_FOG_COORDINATE_ARRAY = 33879;
    public static final int GL_FOG_COORDINATE_ARRAY_POINTER = 33878;
    public static final int GL_FOG_COORDINATE_ARRAY_STRIDE = 33877;
    public static final int GL_FOG_COORDINATE_ARRAY_TYPE = 33876;
    public static final int GL_FOG_COORDINATE_SOURCE = 33872;
    public static final int GL_FRAGMENT_DEPTH = 33874;
    public static final int GL_FUNC_ADD = 32774;
    public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
    public static final int GL_FUNC_SUBTRACT = 32778;
    public static final int GL_GENERATE_MIPMAP = 33169;
    public static final int GL_GENERATE_MIPMAP_HINT = 33170;
    public static final int GL_INCR_WRAP = 34055;
    public static final int GL_MAX = 32776;
    public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045;
    public static final int GL_MIN = 32775;
    public static final int GL_MIRRORED_REPEAT = 33648;
    public static final int GL_POINT_DISTANCE_ATTENUATION = 33065;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064;
    public static final int GL_POINT_SIZE_MAX = 33063;
    public static final int GL_POINT_SIZE_MIN = 33062;
    public static final int GL_SECONDARY_COLOR_ARRAY = 33886;
    public static final int GL_SECONDARY_COLOR_ARRAY_POINTER = 33885;
    public static final int GL_SECONDARY_COLOR_ARRAY_SIZE = 33882;
    public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE = 33884;
    public static final int GL_SECONDARY_COLOR_ARRAY_TYPE = 33883;
    public static final int GL_TEXTURE_COMPARE_FUNC = 34893;
    public static final int GL_TEXTURE_COMPARE_MODE = 34892;
    public static final int GL_TEXTURE_DEPTH_SIZE = 34890;
    public static final int GL_TEXTURE_FILTER_CONTROL = 34048;
    public static final int GL_TEXTURE_LOD_BIAS = 34049;

    private GL14() {
    }

    public static void glBlendColor(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glBlendColor;
        BufferChecks.checkFunctionAddress(j);
        nglBlendColor(f5, f6, f7, f8, j);
    }

    public static void glBlendEquation(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBlendEquation;
        BufferChecks.checkFunctionAddress(j);
        nglBlendEquation(i2, j);
    }

    public static void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glBlendFuncSeparate;
        BufferChecks.checkFunctionAddress(j);
        nglBlendFuncSeparate(i5, i6, i7, i8, j);
    }

    public static void glFogCoordPointer(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glFogCoordPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglFogCoordPointerBO(i3, i4, j2, j3);
    }

    public static void glFogCoordPointer(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glFogCoordPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL14_glFogCoordPointer_data = doubleBuffer2;
        }
        nglFogCoordPointer(5130, i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glFogCoordPointer(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glFogCoordPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).GL14_glFogCoordPointer_data = floatBuffer2;
        }
        nglFogCoordPointer(GL11.GL_FLOAT, i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glFogCoordd(double d) {
        double d2 = d;
        long j = GLContext.getCapabilities().glFogCoordd;
        BufferChecks.checkFunctionAddress(j);
        nglFogCoordd(d2, j);
    }

    public static void glFogCoordf(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glFogCoordf;
        BufferChecks.checkFunctionAddress(j);
        nglFogCoordf(f2, j);
    }

    public static void glMultiDrawArrays(int i, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i2 = i;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glMultiDrawArrays;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkBuffer(intBuffer4, intBuffer3.remaining());
        nglMultiDrawArrays(i2, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), intBuffer3.remaining(), j);
    }

    public static void glPointParameter(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPointParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglPointParameterfv(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPointParameter(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glPointParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglPointParameteriv(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glPointParameterf(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glPointParameterf;
        BufferChecks.checkFunctionAddress(j);
        nglPointParameterf(i2, f2, j);
    }

    public static void glPointParameteri(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glPointParameteri;
        BufferChecks.checkFunctionAddress(j);
        nglPointParameteri(i3, i4, j);
    }

    public static void glSecondaryColor3b(byte b, byte b2, byte b3) {
        byte b4 = b;
        byte b5 = b2;
        byte b6 = b3;
        long j = GLContext.getCapabilities().glSecondaryColor3b;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3b(b4, b5, b6, j);
    }

    public static void glSecondaryColor3d(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glSecondaryColor3d;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3d(d4, d5, d6, j);
    }

    public static void glSecondaryColor3f(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glSecondaryColor3f;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3f(f4, f5, f6, j);
    }

    public static void glSecondaryColor3ub(byte b, byte b2, byte b3) {
        byte b4 = b;
        byte b5 = b2;
        byte b6 = b3;
        long j = GLContext.getCapabilities().glSecondaryColor3ub;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3ub(b4, b5, b6, j);
    }

    public static void glSecondaryColorPointer(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glSecondaryColorPointer;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglSecondaryColorPointerBO(i4, i5, i6, j2, j3);
    }

    public static void glSecondaryColorPointer(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSecondaryColorPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglSecondaryColorPointer(i3, 5130, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glSecondaryColorPointer(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSecondaryColorPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglSecondaryColorPointer(i3, GL11.GL_FLOAT, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSecondaryColorPointer(int i, boolean z, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSecondaryColorPointer;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglSecondaryColorPointer(i3, z2 ? 5121 : 5120, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glWindowPos2d(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glWindowPos2d;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos2d(d3, d4, j);
    }

    public static void glWindowPos2f(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glWindowPos2f;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos2f(f3, f4, j);
    }

    public static void glWindowPos2i(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glWindowPos2i;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos2i(i3, i4, j);
    }

    public static void glWindowPos3d(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glWindowPos3d;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos3d(d4, d5, d6, j);
    }

    public static void glWindowPos3f(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glWindowPos3f;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos3f(f4, f5, f6, j);
    }

    public static void glWindowPos3i(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glWindowPos3i;
        BufferChecks.checkFunctionAddress(j);
        nglWindowPos3i(i4, i5, i6, j);
    }

    static native void nglBlendColor(float f, float f2, float f3, float f4, long j);

    static native void nglBlendEquation(int i, long j);

    static native void nglBlendFuncSeparate(int i, int i2, int i3, int i4, long j);

    static native void nglFogCoordPointer(int i, int i2, long j, long j2);

    static native void nglFogCoordPointerBO(int i, int i2, long j, long j2);

    static native void nglFogCoordd(double d, long j);

    static native void nglFogCoordf(float f, long j);

    static native void nglMultiDrawArrays(int i, long j, long j2, int i2, long j3);

    static native void nglPointParameterf(int i, float f, long j);

    static native void nglPointParameterfv(int i, long j, long j2);

    static native void nglPointParameteri(int i, int i2, long j);

    static native void nglPointParameteriv(int i, long j, long j2);

    static native void nglSecondaryColor3b(byte b, byte b2, byte b3, long j);

    static native void nglSecondaryColor3d(double d, double d2, double d3, long j);

    static native void nglSecondaryColor3f(float f, float f2, float f3, long j);

    static native void nglSecondaryColor3ub(byte b, byte b2, byte b3, long j);

    static native void nglSecondaryColorPointer(int i, int i2, int i3, long j, long j2);

    static native void nglSecondaryColorPointerBO(int i, int i2, int i3, long j, long j2);

    static native void nglWindowPos2d(double d, double d2, long j);

    static native void nglWindowPos2f(float f, float f2, long j);

    static native void nglWindowPos2i(int i, int i2, long j);

    static native void nglWindowPos3d(double d, double d2, double d3, long j);

    static native void nglWindowPos3f(float f, float f2, float f3, long j);

    static native void nglWindowPos3i(int i, int i2, int i3, long j);
}
