package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVEvaluators {
    public static final int GL_EVAL_2D_NV = 34496;
    public static final int GL_EVAL_FRACTIONAL_TESSELLATION_NV = 34501;
    public static final int GL_EVAL_TRIANGULAR_2D_NV = 34497;
    public static final int GL_EVAL_VERTEX_ATTRIB0_NV = 34502;
    public static final int GL_EVAL_VERTEX_ATTRIB10_NV = 34512;
    public static final int GL_EVAL_VERTEX_ATTRIB11_NV = 34513;
    public static final int GL_EVAL_VERTEX_ATTRIB12_NV = 34514;
    public static final int GL_EVAL_VERTEX_ATTRIB13_NV = 34515;
    public static final int GL_EVAL_VERTEX_ATTRIB14_NV = 34516;
    public static final int GL_EVAL_VERTEX_ATTRIB15_NV = 34517;
    public static final int GL_EVAL_VERTEX_ATTRIB1_NV = 34503;
    public static final int GL_EVAL_VERTEX_ATTRIB2_NV = 34504;
    public static final int GL_EVAL_VERTEX_ATTRIB3_NV = 34505;
    public static final int GL_EVAL_VERTEX_ATTRIB4_NV = 34506;
    public static final int GL_EVAL_VERTEX_ATTRIB5_NV = 34507;
    public static final int GL_EVAL_VERTEX_ATTRIB6_NV = 34508;
    public static final int GL_EVAL_VERTEX_ATTRIB7_NV = 34509;
    public static final int GL_EVAL_VERTEX_ATTRIB8_NV = 34510;
    public static final int GL_EVAL_VERTEX_ATTRIB9_NV = 34511;
    public static final int GL_MAP_ATTRIB_U_ORDER_NV = 34499;
    public static final int GL_MAP_ATTRIB_V_ORDER_NV = 34500;
    public static final int GL_MAP_TESSELLATION_NV = 34498;
    public static final int GL_MAX_MAP_TESSELLATION_NV = 34518;
    public static final int GL_MAX_RATIONAL_EVAL_ORDER_NV = 34519;

    private NVEvaluators() {
    }

    public static void glEvalMapsNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEvalMapsNV;
        BufferChecks.checkFunctionAddress(j);
        nglEvalMapsNV(i3, i4, j);
    }

    public static void glGetMapAttribParameterNV(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMapAttribParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMapAttribParameterfvNV(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMapAttribParameterNV(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMapAttribParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMapAttribParameterivNV(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMapControlPointsNV(int i, int i2, int i3, int i4, int i5, boolean z, FloatBuffer floatBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMapControlPointsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetMapControlPointsNV(i6, i7, i8, i9, i10, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMapParameterNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMapParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMapParameterfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMapParameterNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMapParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMapParameterivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMapControlPointsNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, FloatBuffer floatBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMapControlPointsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglMapControlPointsNV(i8, i9, i10, i11, i12, i13, i14, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMapParameterNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMapParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglMapParameterfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMapParameterNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMapParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglMapParameterivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    static native void nglEvalMapsNV(int i, int i2, long j);

    static native void nglGetMapAttribParameterfvNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetMapAttribParameterivNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetMapControlPointsNV(int i, int i2, int i3, int i4, int i5, boolean z, long j, long j2);

    static native void nglGetMapParameterfvNV(int i, int i2, long j, long j2);

    static native void nglGetMapParameterivNV(int i, int i2, long j, long j2);

    static native void nglMapControlPointsNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, long j, long j2);

    static native void nglMapParameterfvNV(int i, int i2, long j, long j2);

    static native void nglMapParameterivNV(int i, int i2, long j, long j2);
}
