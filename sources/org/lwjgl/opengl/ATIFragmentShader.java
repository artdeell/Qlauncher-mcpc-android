package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ATIFragmentShader {
    public static final int GL_2X_BIT_ATI = 1;
    public static final int GL_4X_BIT_ATI = 2;
    public static final int GL_8X_BIT_ATI = 4;
    public static final int GL_ADD_ATI = 35171;
    public static final int GL_BIAS_BIT_ATI = 8;
    public static final int GL_BLUE_BIT_ATI = 4;
    public static final int GL_CND0_ATI = 35179;
    public static final int GL_CND_ATI = 35178;
    public static final int GL_COLOR_ALPHA_PAIRING_ATI = 35189;
    public static final int GL_COMP_BIT_ATI = 2;
    public static final int GL_CON_0_ATI = 35137;
    public static final int GL_CON_10_ATI = 35147;
    public static final int GL_CON_11_ATI = 35148;
    public static final int GL_CON_12_ATI = 35149;
    public static final int GL_CON_13_ATI = 35150;
    public static final int GL_CON_14_ATI = 35151;
    public static final int GL_CON_15_ATI = 35152;
    public static final int GL_CON_16_ATI = 35153;
    public static final int GL_CON_17_ATI = 35154;
    public static final int GL_CON_18_ATI = 35155;
    public static final int GL_CON_19_ATI = 35156;
    public static final int GL_CON_1_ATI = 35138;
    public static final int GL_CON_20_ATI = 35157;
    public static final int GL_CON_21_ATI = 35158;
    public static final int GL_CON_22_ATI = 35159;
    public static final int GL_CON_23_ATI = 35160;
    public static final int GL_CON_24_ATI = 35161;
    public static final int GL_CON_25_ATI = 35162;
    public static final int GL_CON_26_ATI = 35163;
    public static final int GL_CON_27_ATI = 35164;
    public static final int GL_CON_28_ATI = 35165;
    public static final int GL_CON_29_ATI = 35166;
    public static final int GL_CON_2_ATI = 35139;
    public static final int GL_CON_30_ATI = 35167;
    public static final int GL_CON_31_ATI = 35168;
    public static final int GL_CON_3_ATI = 35140;
    public static final int GL_CON_4_ATI = 35141;
    public static final int GL_CON_5_ATI = 35142;
    public static final int GL_CON_6_ATI = 35143;
    public static final int GL_CON_7_ATI = 35144;
    public static final int GL_CON_8_ATI = 35145;
    public static final int GL_CON_9_ATI = 35146;
    public static final int GL_DOT2_ADD_ATI = 35180;
    public static final int GL_DOT3_ATI = 35174;
    public static final int GL_DOT4_ATI = 35175;
    public static final int GL_EIGHTH_BIT_ATI = 32;
    public static final int GL_FRAGMENT_SHADER_ATI = 35104;
    public static final int GL_GREEN_BIT_ATI = 2;
    public static final int GL_HALF_BIT_ATI = 8;
    public static final int GL_LERP_ATI = 35177;
    public static final int GL_MAD_ATI = 35176;
    public static final int GL_MOV_ATI = 35169;
    public static final int GL_MUL_ATI = 35172;
    public static final int GL_NEGATE_BIT_ATI = 4;
    public static final int GL_NUM_FRAGMENT_CONSTANTS_ATI = 35183;
    public static final int GL_NUM_FRAGMENT_REGISTERS_ATI = 35182;
    public static final int GL_NUM_INPUT_INTERPOLATOR_COMPONENTS_ATI = 35187;
    public static final int GL_NUM_INSTRUCTIONS_PER_PASS_ATI = 35185;
    public static final int GL_NUM_INSTRUCTIONS_TOTAL_ATI = 35186;
    public static final int GL_NUM_LOOPBACK_COMPONENTS_ATI = 35188;
    public static final int GL_NUM_PASSES_ATI = 35184;
    public static final int GL_QUARTER_BIT_ATI = 16;
    public static final int GL_RED_BIT_ATI = 1;
    public static final int GL_REG_0_ATI = 35105;
    public static final int GL_REG_10_ATI = 35115;
    public static final int GL_REG_11_ATI = 35116;
    public static final int GL_REG_12_ATI = 35117;
    public static final int GL_REG_13_ATI = 35118;
    public static final int GL_REG_14_ATI = 35119;
    public static final int GL_REG_15_ATI = 35120;
    public static final int GL_REG_16_ATI = 35121;
    public static final int GL_REG_17_ATI = 35122;
    public static final int GL_REG_18_ATI = 35123;
    public static final int GL_REG_19_ATI = 35124;
    public static final int GL_REG_1_ATI = 35106;
    public static final int GL_REG_20_ATI = 35125;
    public static final int GL_REG_21_ATI = 35126;
    public static final int GL_REG_22_ATI = 35127;
    public static final int GL_REG_23_ATI = 35128;
    public static final int GL_REG_24_ATI = 35129;
    public static final int GL_REG_25_ATI = 35130;
    public static final int GL_REG_26_ATI = 35131;
    public static final int GL_REG_27_ATI = 35132;
    public static final int GL_REG_28_ATI = 35133;
    public static final int GL_REG_29_ATI = 35134;
    public static final int GL_REG_2_ATI = 35107;
    public static final int GL_REG_30_ATI = 35135;
    public static final int GL_REG_31_ATI = 35136;
    public static final int GL_REG_3_ATI = 35108;
    public static final int GL_REG_4_ATI = 35109;
    public static final int GL_REG_5_ATI = 35110;
    public static final int GL_REG_6_ATI = 35111;
    public static final int GL_REG_7_ATI = 35112;
    public static final int GL_REG_8_ATI = 35113;
    public static final int GL_REG_9_ATI = 35114;
    public static final int GL_SATURATE_BIT_ATI = 64;
    public static final int GL_SECONDARY_INTERPOLATOR_ATI = 35181;
    public static final int GL_SUB_ATI = 35173;
    public static final int GL_SWIZZLE_STQ_ATI = 35191;
    public static final int GL_SWIZZLE_STQ_DQ_ATI = 35193;
    public static final int GL_SWIZZLE_STRQ_ATI = 35194;
    public static final int GL_SWIZZLE_STRQ_DQ_ATI = 35195;
    public static final int GL_SWIZZLE_STR_ATI = 35190;
    public static final int GL_SWIZZLE_STR_DR_ATI = 35192;

    private ATIFragmentShader() {
    }

    public static void glAlphaFragmentOp1ATI(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glAlphaFragmentOp1ATI;
        BufferChecks.checkFunctionAddress(j);
        nglAlphaFragmentOp1ATI(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glAlphaFragmentOp2ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j = GLContext.getCapabilities().glAlphaFragmentOp2ATI;
        BufferChecks.checkFunctionAddress(j);
        nglAlphaFragmentOp2ATI(i10, i11, i12, i13, i14, i15, i16, i17, i18, j);
    }

    public static void glAlphaFragmentOp3ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13 = i;
        int i14 = i2;
        int i15 = i3;
        int i16 = i4;
        int i17 = i5;
        int i18 = i6;
        int i19 = i7;
        int i20 = i8;
        int i21 = i9;
        int i22 = i10;
        int i23 = i11;
        int i24 = i12;
        long j = GLContext.getCapabilities().glAlphaFragmentOp3ATI;
        BufferChecks.checkFunctionAddress(j);
        nglAlphaFragmentOp3ATI(i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, j);
    }

    public static void glBeginFragmentShaderATI() {
        long j = GLContext.getCapabilities().glBeginFragmentShaderATI;
        BufferChecks.checkFunctionAddress(j);
        nglBeginFragmentShaderATI(j);
    }

    public static void glBindFragmentShaderATI(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBindFragmentShaderATI;
        BufferChecks.checkFunctionAddress(j);
        nglBindFragmentShaderATI(i2, j);
    }

    public static void glColorFragmentOp1ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j = GLContext.getCapabilities().glColorFragmentOp1ATI;
        BufferChecks.checkFunctionAddress(j);
        nglColorFragmentOp1ATI(i8, i9, i10, i11, i12, i13, i14, j);
    }

    public static void glColorFragmentOp2ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        int i16 = i6;
        int i17 = i7;
        int i18 = i8;
        int i19 = i9;
        int i20 = i10;
        long j = GLContext.getCapabilities().glColorFragmentOp2ATI;
        BufferChecks.checkFunctionAddress(j);
        nglColorFragmentOp2ATI(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j);
    }

    public static void glColorFragmentOp3ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        int i14 = i;
        int i15 = i2;
        int i16 = i3;
        int i17 = i4;
        int i18 = i5;
        int i19 = i6;
        int i20 = i7;
        int i21 = i8;
        int i22 = i9;
        int i23 = i10;
        int i24 = i11;
        int i25 = i12;
        int i26 = i13;
        long j = GLContext.getCapabilities().glColorFragmentOp3ATI;
        BufferChecks.checkFunctionAddress(j);
        nglColorFragmentOp3ATI(i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, j);
    }

    public static void glDeleteFragmentShaderATI(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDeleteFragmentShaderATI;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteFragmentShaderATI(i2, j);
    }

    public static void glEndFragmentShaderATI() {
        long j = GLContext.getCapabilities().glEndFragmentShaderATI;
        BufferChecks.checkFunctionAddress(j);
        nglEndFragmentShaderATI(j);
    }

    public static int glGenFragmentShadersATI(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGenFragmentShadersATI;
        BufferChecks.checkFunctionAddress(j);
        return nglGenFragmentShadersATI(i2, j);
    }

    public static void glPassTexCoordATI(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glPassTexCoordATI;
        BufferChecks.checkFunctionAddress(j);
        nglPassTexCoordATI(i4, i5, i6, j);
    }

    public static void glSampleMapATI(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glSampleMapATI;
        BufferChecks.checkFunctionAddress(j);
        nglSampleMapATI(i4, i5, i6, j);
    }

    public static void glSetFragmentShaderConstantATI(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glSetFragmentShaderConstantATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglSetFragmentShaderConstantATI(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglAlphaFragmentOp1ATI(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglAlphaFragmentOp2ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j);

    static native void nglAlphaFragmentOp3ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, long j);

    static native void nglBeginFragmentShaderATI(long j);

    static native void nglBindFragmentShaderATI(int i, long j);

    static native void nglColorFragmentOp1ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    static native void nglColorFragmentOp2ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j);

    static native void nglColorFragmentOp3ATI(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, long j);

    static native void nglDeleteFragmentShaderATI(int i, long j);

    static native void nglEndFragmentShaderATI(long j);

    static native int nglGenFragmentShadersATI(int i, long j);

    static native void nglPassTexCoordATI(int i, int i2, int i3, long j);

    static native void nglSampleMapATI(int i, int i2, int i3, long j);

    static native void nglSetFragmentShaderConstantATI(int i, long j, long j2);
}
