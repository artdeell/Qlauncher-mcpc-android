package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVRegisterCombiners {
    public static final int GL_BIAS_BY_NEGATIVE_ONE_HALF_NV = 34113;
    public static final int GL_COLOR_SUM_CLAMP_NV = 34127;
    public static final int GL_COMBINER0_NV = 34128;
    public static final int GL_COMBINER1_NV = 34129;
    public static final int GL_COMBINER2_NV = 34130;
    public static final int GL_COMBINER3_NV = 34131;
    public static final int GL_COMBINER4_NV = 34132;
    public static final int GL_COMBINER5_NV = 34133;
    public static final int GL_COMBINER6_NV = 34134;
    public static final int GL_COMBINER7_NV = 34135;
    public static final int GL_COMBINER_AB_DOT_PRODUCT_NV = 34117;
    public static final int GL_COMBINER_AB_OUTPUT_NV = 34122;
    public static final int GL_COMBINER_BIAS_NV = 34121;
    public static final int GL_COMBINER_CD_DOT_PRODUCT_NV = 34118;
    public static final int GL_COMBINER_CD_OUTPUT_NV = 34123;
    public static final int GL_COMBINER_COMPONENT_USAGE_NV = 34116;
    public static final int GL_COMBINER_INPUT_NV = 34114;
    public static final int GL_COMBINER_MAPPING_NV = 34115;
    public static final int GL_COMBINER_MUX_SUM_NV = 34119;
    public static final int GL_COMBINER_SCALE_NV = 34120;
    public static final int GL_COMBINER_SUM_OUTPUT_NV = 34124;
    public static final int GL_CONSTANT_COLOR0_NV = 34090;
    public static final int GL_CONSTANT_COLOR1_NV = 34091;
    public static final int GL_DISCARD_NV = 34096;
    public static final int GL_EXPAND_NEGATE_NV = 34105;
    public static final int GL_EXPAND_NORMAL_NV = 34104;
    public static final int GL_E_TIMES_F_NV = 34097;
    public static final int GL_HALF_BIAS_NEGATE_NV = 34107;
    public static final int GL_HALF_BIAS_NORMAL_NV = 34106;
    public static final int GL_MAX_GENERAL_COMBINERS_NV = 34125;
    public static final int GL_NUM_GENERAL_COMBINERS_NV = 34126;
    public static final int GL_PRIMARY_COLOR_NV = 34092;
    public static final int GL_REGISTER_COMBINERS_NV = 34082;
    public static final int GL_SCALE_BY_FOUR_NV = 34111;
    public static final int GL_SCALE_BY_ONE_HALF_NV = 34112;
    public static final int GL_SCALE_BY_TWO_NV = 34110;
    public static final int GL_SECONDARY_COLOR_NV = 34093;
    public static final int GL_SIGNED_IDENTITY_NV = 34108;
    public static final int GL_SIGNED_NEGATE_NV = 34109;
    public static final int GL_SPARE0_NV = 34094;
    public static final int GL_SPARE0_PLUS_SECONDARY_COLOR_NV = 34098;
    public static final int GL_SPARE1_NV = 34095;
    public static final int GL_UNSIGNED_IDENTITY_NV = 34102;
    public static final int GL_UNSIGNED_INVERT_NV = 34103;
    public static final int GL_VARIABLE_A_NV = 34083;
    public static final int GL_VARIABLE_B_NV = 34084;
    public static final int GL_VARIABLE_C_NV = 34085;
    public static final int GL_VARIABLE_D_NV = 34086;
    public static final int GL_VARIABLE_E_NV = 34087;
    public static final int GL_VARIABLE_F_NV = 34088;
    public static final int GL_VARIABLE_G_NV = 34089;

    private NVRegisterCombiners() {
    }

    public static void glCombinerInputNV(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glCombinerInputNV;
        BufferChecks.checkFunctionAddress(j);
        nglCombinerInputNV(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glCombinerOutputNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        boolean z4 = z;
        boolean z5 = z2;
        boolean z6 = z3;
        long j = GLContext.getCapabilities().glCombinerOutputNV;
        BufferChecks.checkFunctionAddress(j);
        nglCombinerOutputNV(i8, i9, i10, i11, i12, i13, i14, z4, z5, z6, j);
    }

    public static void glCombinerParameterNV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glCombinerParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglCombinerParameterfvNV(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glCombinerParameterNV(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glCombinerParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglCombinerParameterivNV(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glCombinerParameterfNV(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glCombinerParameterfNV;
        BufferChecks.checkFunctionAddress(j);
        nglCombinerParameterfNV(i2, f2, j);
    }

    public static void glCombinerParameteriNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glCombinerParameteriNV;
        BufferChecks.checkFunctionAddress(j);
        nglCombinerParameteriNV(i3, i4, j);
    }

    public static void glFinalCombinerInputNV(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glFinalCombinerInputNV;
        BufferChecks.checkFunctionAddress(j);
        nglFinalCombinerInputNV(i5, i6, i7, i8, j);
    }

    public static void glGetCombinerInputParameterNV(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetCombinerInputParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetCombinerInputParameterfvNV(i5, i6, i7, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetCombinerInputParameterNV(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetCombinerInputParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetCombinerInputParameterivNV(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetCombinerInputParameterfNV(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCombinerInputParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetCombinerInputParameterfvNV(i5, i6, i7, i8, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetCombinerInputParameteriNV(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCombinerInputParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetCombinerInputParameterivNV(i5, i6, i7, i8, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetCombinerOutputParameterNV(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetCombinerOutputParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetCombinerOutputParameterfvNV(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetCombinerOutputParameterNV(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetCombinerOutputParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetCombinerOutputParameterivNV(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetCombinerOutputParameterfNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCombinerOutputParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetCombinerOutputParameterfvNV(i4, i5, i6, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetCombinerOutputParameteriNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCombinerOutputParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetCombinerOutputParameterivNV(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetFinalCombinerInputParameterNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetFinalCombinerInputParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetFinalCombinerInputParameterfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetFinalCombinerInputParameterNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetFinalCombinerInputParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetFinalCombinerInputParameterivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetFinalCombinerInputParameterfNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFinalCombinerInputParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetFinalCombinerInputParameterfvNV(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetFinalCombinerInputParameteriNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFinalCombinerInputParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetFinalCombinerInputParameterivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    static native void nglCombinerInputNV(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglCombinerOutputNV(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3, long j);

    static native void nglCombinerParameterfNV(int i, float f, long j);

    static native void nglCombinerParameterfvNV(int i, long j, long j2);

    static native void nglCombinerParameteriNV(int i, int i2, long j);

    static native void nglCombinerParameterivNV(int i, long j, long j2);

    static native void nglFinalCombinerInputNV(int i, int i2, int i3, int i4, long j);

    static native void nglGetCombinerInputParameterfvNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetCombinerInputParameterivNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetCombinerOutputParameterfvNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetCombinerOutputParameterivNV(int i, int i2, int i3, long j, long j2);

    static native void nglGetFinalCombinerInputParameterfvNV(int i, int i2, long j, long j2);

    static native void nglGetFinalCombinerInputParameterivNV(int i, int i2, long j, long j2);
}
