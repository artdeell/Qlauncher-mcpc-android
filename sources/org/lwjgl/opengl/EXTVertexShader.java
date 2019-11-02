package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class EXTVertexShader {
    public static final int GL_CURRENT_VERTEX_EXT = 34786;
    public static final int GL_FULL_RANGE_EXT = 34785;
    public static final int GL_INVARIANT_DATATYPE_EXT = 34795;
    public static final int GL_INVARIANT_EXT = 34754;
    public static final int GL_INVARIANT_VALUE_EXT = 34794;
    public static final int GL_LOCAL_CONSTANT_DATATYPE_EXT = 34797;
    public static final int GL_LOCAL_CONSTANT_EXT = 34755;
    public static final int GL_LOCAL_CONSTANT_VALUE_EXT = 34796;
    public static final int GL_LOCAL_EXT = 34756;
    public static final int GL_MATRIX_EXT = 34752;
    public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_INSTRUCTIONS_EXT = 34762;
    public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_INVARIANTS_EXT = 34764;
    public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_LOCALS_EXT = 34766;
    public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_LOCAL_CONSTANTS_EXT = 34765;
    public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_VARIANTS_EXT = 34763;
    public static final int GL_MAX_VERTEX_SHADER_INSTRUCTIONS_EXT = 34757;
    public static final int GL_MAX_VERTEX_SHADER_INVARIANTS_EXT = 34759;
    public static final int GL_MAX_VERTEX_SHADER_LOCALS_EXT = 34761;
    public static final int GL_MAX_VERTEX_SHADER_LOCAL_CONSTANTS_EXT = 34760;
    public static final int GL_MAX_VERTEX_SHADER_VARIANTS_EXT = 34758;
    public static final int GL_MVP_MATRIX_EXT = 34787;
    public static final int GL_NEGATIVE_ONE_EXT = 34783;
    public static final int GL_NEGATIVE_W_EXT = 34780;
    public static final int GL_NEGATIVE_X_EXT = 34777;
    public static final int GL_NEGATIVE_Y_EXT = 34778;
    public static final int GL_NEGATIVE_Z_EXT = 34779;
    public static final int GL_NORMALIZED_RANGE_EXT = 34784;
    public static final int GL_ONE_EXT = 34782;
    public static final int GL_OP_ADD_EXT = 34695;
    public static final int GL_OP_CLAMP_EXT = 34702;
    public static final int GL_OP_CROSS_PRODUCT_EXT = 34711;
    public static final int GL_OP_DOT3_EXT = 34692;
    public static final int GL_OP_DOT4_EXT = 34693;
    public static final int GL_OP_EXP_BASE_2_EXT = 34705;
    public static final int GL_OP_FLOOR_EXT = 34703;
    public static final int GL_OP_FRAC_EXT = 34697;
    public static final int GL_OP_INDEX_EXT = 34690;
    public static final int GL_OP_LOG_BASE_2_EXT = 34706;
    public static final int GL_OP_MADD_EXT = 34696;
    public static final int GL_OP_MAX_EXT = 34698;
    public static final int GL_OP_MIN_EXT = 34699;
    public static final int GL_OP_MOV_EXT = 34713;
    public static final int GL_OP_MULTIPLY_MATRIX_EXT = 34712;
    public static final int GL_OP_MUL_EXT = 34694;
    public static final int GL_OP_NEGATE_EXT = 34691;
    public static final int GL_OP_POWER_EXT = 34707;
    public static final int GL_OP_RECIP_EXT = 34708;
    public static final int GL_OP_RECIP_SQRT_EXT = 34709;
    public static final int GL_OP_ROUND_EXT = 34704;
    public static final int GL_OP_SET_GE_EXT = 34700;
    public static final int GL_OP_SET_LT_EXT = 34701;
    public static final int GL_OP_SUB_EXT = 34710;
    public static final int GL_OUTPUT_COLOR0_EXT = 34715;
    public static final int GL_OUTPUT_COLOR1_EXT = 34716;
    public static final int GL_OUTPUT_FOG_EXT = 34749;
    public static final int GL_OUTPUT_TEXTURE_COORD0_EXT = 34717;
    public static final int GL_OUTPUT_TEXTURE_COORD10_EXT = 34727;
    public static final int GL_OUTPUT_TEXTURE_COORD11_EXT = 34728;
    public static final int GL_OUTPUT_TEXTURE_COORD12_EXT = 34729;
    public static final int GL_OUTPUT_TEXTURE_COORD13_EXT = 34730;
    public static final int GL_OUTPUT_TEXTURE_COORD14_EXT = 34731;
    public static final int GL_OUTPUT_TEXTURE_COORD15_EXT = 34732;
    public static final int GL_OUTPUT_TEXTURE_COORD16_EXT = 34733;
    public static final int GL_OUTPUT_TEXTURE_COORD17_EXT = 34734;
    public static final int GL_OUTPUT_TEXTURE_COORD18_EXT = 34735;
    public static final int GL_OUTPUT_TEXTURE_COORD19_EXT = 34736;
    public static final int GL_OUTPUT_TEXTURE_COORD1_EXT = 34718;
    public static final int GL_OUTPUT_TEXTURE_COORD20_EXT = 34737;
    public static final int GL_OUTPUT_TEXTURE_COORD21_EXT = 34738;
    public static final int GL_OUTPUT_TEXTURE_COORD22_EXT = 34739;
    public static final int GL_OUTPUT_TEXTURE_COORD23_EXT = 34740;
    public static final int GL_OUTPUT_TEXTURE_COORD24_EXT = 34741;
    public static final int GL_OUTPUT_TEXTURE_COORD25_EXT = 34742;
    public static final int GL_OUTPUT_TEXTURE_COORD26_EXT = 34743;
    public static final int GL_OUTPUT_TEXTURE_COORD27_EXT = 34744;
    public static final int GL_OUTPUT_TEXTURE_COORD28_EXT = 34745;
    public static final int GL_OUTPUT_TEXTURE_COORD29_EXT = 34746;
    public static final int GL_OUTPUT_TEXTURE_COORD2_EXT = 34719;
    public static final int GL_OUTPUT_TEXTURE_COORD30_EXT = 34747;
    public static final int GL_OUTPUT_TEXTURE_COORD31_EXT = 34748;
    public static final int GL_OUTPUT_TEXTURE_COORD3_EXT = 34720;
    public static final int GL_OUTPUT_TEXTURE_COORD4_EXT = 34721;
    public static final int GL_OUTPUT_TEXTURE_COORD5_EXT = 34722;
    public static final int GL_OUTPUT_TEXTURE_COORD6_EXT = 34723;
    public static final int GL_OUTPUT_TEXTURE_COORD7_EXT = 34724;
    public static final int GL_OUTPUT_TEXTURE_COORD8_EXT = 34725;
    public static final int GL_OUTPUT_TEXTURE_COORD9_EXT = 34726;
    public static final int GL_OUTPUT_VERTEX_EXT = 34714;
    public static final int GL_SCALAR_EXT = 34750;
    public static final int GL_VARIANT_ARRAY_EXT = 34792;
    public static final int GL_VARIANT_ARRAY_POINTER_EXT = 34793;
    public static final int GL_VARIANT_ARRAY_STRIDE_EXT = 34790;
    public static final int GL_VARIANT_ARRAY_TYPE_EXT = 34791;
    public static final int GL_VARIANT_DATATYPE_EXT = 34789;
    public static final int GL_VARIANT_EXT = 34753;
    public static final int GL_VARIANT_VALUE_EXT = 34788;
    public static final int GL_VECTOR_EXT = 34751;
    public static final int GL_VERTEX_SHADER_BINDING_EXT = 34689;
    public static final int GL_VERTEX_SHADER_EXT = 34688;
    public static final int GL_VERTEX_SHADER_INSTRUCTIONS_EXT = 34767;
    public static final int GL_VERTEX_SHADER_INVARIANTS_EXT = 34769;
    public static final int GL_VERTEX_SHADER_LOCALS_EXT = 34771;
    public static final int GL_VERTEX_SHADER_LOCAL_CONSTANTS_EXT = 34770;
    public static final int GL_VERTEX_SHADER_OPTIMIZED_EXT = 34772;
    public static final int GL_VERTEX_SHADER_VARIANTS_EXT = 34768;
    public static final int GL_W_EXT = 34776;
    public static final int GL_X_EXT = 34773;
    public static final int GL_Y_EXT = 34774;
    public static final int GL_ZERO_EXT = 34781;
    public static final int GL_Z_EXT = 34775;

    private EXTVertexShader() {
    }

    public static void glBeginVertexShaderEXT() {
        long j = GLContext.getCapabilities().glBeginVertexShaderEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBeginVertexShaderEXT(j);
    }

    public static int glBindLightParameterEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindLightParameterEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglBindLightParameterEXT(i3, i4, j);
    }

    public static int glBindMaterialParameterEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindMaterialParameterEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglBindMaterialParameterEXT(i3, i4, j);
    }

    public static int glBindParameterEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBindParameterEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglBindParameterEXT(i2, j);
    }

    public static int glBindTexGenParameterEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBindTexGenParameterEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglBindTexGenParameterEXT(i4, i5, i6, j);
    }

    public static int glBindTextureUnitParameterEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindTextureUnitParameterEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglBindTextureUnitParameterEXT(i3, i4, j);
    }

    public static void glBindVertexShaderEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBindVertexShaderEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBindVertexShaderEXT(i2, j);
    }

    public static void glDeleteVertexShaderEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDeleteVertexShaderEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteVertexShaderEXT(i2, j);
    }

    public static void glDisableVariantClientStateEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glDisableVariantClientStateEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDisableVariantClientStateEXT(i2, j);
    }

    public static void glEnableVariantClientStateEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEnableVariantClientStateEXT;
        BufferChecks.checkFunctionAddress(j);
        nglEnableVariantClientStateEXT(i2, j);
    }

    public static void glEndVertexShaderEXT() {
        long j = GLContext.getCapabilities().glEndVertexShaderEXT;
        BufferChecks.checkFunctionAddress(j);
        nglEndVertexShaderEXT(j);
    }

    public static void glExtractComponentEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glExtractComponentEXT;
        BufferChecks.checkFunctionAddress(j);
        nglExtractComponentEXT(i4, i5, i6, j);
    }

    public static int glGenSymbolsEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glGenSymbolsEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglGenSymbolsEXT(i5, i6, i7, i8, j);
    }

    public static int glGenVertexShadersEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGenVertexShadersEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglGenVertexShadersEXT(i2, j);
    }

    public static void glGetInvariantBooleanEXT(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetInvariantBooleanvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglGetInvariantBooleanvEXT(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetInvariantFloatEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetInvariantFloatvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetInvariantFloatvEXT(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetInvariantIntegerEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetInvariantIntegervEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetInvariantIntegervEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetLocalConstantBooleanEXT(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetLocalConstantBooleanvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglGetLocalConstantBooleanvEXT(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetLocalConstantFloatEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetLocalConstantFloatvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetLocalConstantFloatvEXT(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetLocalConstantIntegerEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetLocalConstantIntegervEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetLocalConstantIntegervEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVariantBooleanEXT(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetVariantBooleanvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglGetVariantBooleanvEXT(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetVariantFloatEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetVariantFloatvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetVariantFloatvEXT(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetVariantIntegerEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVariantIntegervEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVariantIntegervEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static ByteBuffer glGetVariantPointerEXT(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetVariantPointervEXT;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetVariantPointervEXT = nglGetVariantPointervEXT(i3, i4, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetVariantPointervEXT != null) {
            return nglGetVariantPointervEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glInsertComponentEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glInsertComponentEXT;
        BufferChecks.checkFunctionAddress(j);
        nglInsertComponentEXT(i4, i5, i6, j);
    }

    public static boolean glIsVariantEnabledEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glIsVariantEnabledEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglIsVariantEnabledEXT(i3, i4, j);
    }

    public static void glSetInvariantEXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glSetInvariantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglSetInvariantEXT(i2, 5130, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glSetInvariantEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glSetInvariantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglSetInvariantEXT(i2, GL11.GL_FLOAT, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSetInvariantEXT(int i, boolean z, ByteBuffer byteBuffer) {
        int i2 = i;
        boolean z2 = z;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glSetInvariantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglSetInvariantEXT(i2, z2 ? 5121 : 5120, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glSetInvariantEXT(int i, boolean z, IntBuffer intBuffer) {
        int i2 = i;
        boolean z2 = z;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glSetInvariantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglSetInvariantEXT(i2, z2 ? 5125 : 5124, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSetInvariantEXT(int i, boolean z, ShortBuffer shortBuffer) {
        int i2 = i;
        boolean z2 = z;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glSetInvariantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglSetInvariantEXT(i2, z2 ? 5123 : 5122, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glSetLocalConstantEXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glSetLocalConstantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglSetLocalConstantEXT(i2, 5130, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glSetLocalConstantEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glSetLocalConstantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglSetLocalConstantEXT(i2, GL11.GL_FLOAT, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSetLocalConstantEXT(int i, boolean z, ByteBuffer byteBuffer) {
        int i2 = i;
        boolean z2 = z;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glSetLocalConstantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglSetLocalConstantEXT(i2, z2 ? 5121 : 5120, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glSetLocalConstantEXT(int i, boolean z, IntBuffer intBuffer) {
        int i2 = i;
        boolean z2 = z;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glSetLocalConstantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglSetLocalConstantEXT(i2, z2 ? 5125 : 5124, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSetLocalConstantEXT(int i, boolean z, ShortBuffer shortBuffer) {
        int i2 = i;
        boolean z2 = z;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glSetLocalConstantEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglSetLocalConstantEXT(i2, z2 ? 5123 : 5122, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glShaderOp1EXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glShaderOp1EXT;
        BufferChecks.checkFunctionAddress(j);
        nglShaderOp1EXT(i4, i5, i6, j);
    }

    public static void glShaderOp2EXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glShaderOp2EXT;
        BufferChecks.checkFunctionAddress(j);
        nglShaderOp2EXT(i5, i6, i7, i8, j);
    }

    public static void glShaderOp3EXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glShaderOp3EXT;
        BufferChecks.checkFunctionAddress(j);
        nglShaderOp3EXT(i6, i7, i8, i9, i10, j);
    }

    public static void glSwizzleEXT(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glSwizzleEXT;
        BufferChecks.checkFunctionAddress(j);
        nglSwizzleEXT(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glVariantEXT(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glVariantbvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglVariantbvEXT(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVariantEXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVariantdvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglVariantdvEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVariantEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glVariantfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglVariantfvEXT(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVariantEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVariantivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglVariantivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVariantEXT(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVariantsvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglVariantsvEXT(i2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVariantPointerEXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVariantPointerEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVariantPointerEXTBO(i4, i5, i6, j2, j3);
    }

    public static void glVariantPointerEXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVariantPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_vertex_shader_glVariantPointerEXT_pAddr = doubleBuffer2;
        }
        nglVariantPointerEXT(i3, 5130, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVariantPointerEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVariantPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_vertex_shader_glVariantPointerEXT_pAddr = floatBuffer2;
        }
        nglVariantPointerEXT(i3, GL11.GL_FLOAT, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVariantPointerEXT(int i, boolean z, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVariantPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_vertex_shader_glVariantPointerEXT_pAddr = byteBuffer2;
        }
        nglVariantPointerEXT(i3, z2 ? 5121 : 5120, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVariantPointerEXT(int i, boolean z, int i2, IntBuffer intBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVariantPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_vertex_shader_glVariantPointerEXT_pAddr = intBuffer2;
        }
        nglVariantPointerEXT(i3, z2 ? 5125 : 5124, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVariantPointerEXT(int i, boolean z, int i2, ShortBuffer shortBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVariantPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_vertex_shader_glVariantPointerEXT_pAddr = shortBuffer2;
        }
        nglVariantPointerEXT(i3, z2 ? 5123 : 5122, i4, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glVariantuEXT(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glVariantubvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglVariantubvEXT(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glVariantuEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glVariantuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglVariantuivEXT(i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glVariantuEXT(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glVariantusvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglVariantusvEXT(i2, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glWriteMaskEXT(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glWriteMaskEXT;
        BufferChecks.checkFunctionAddress(j);
        nglWriteMaskEXT(i7, i8, i9, i10, i11, i12, j);
    }

    static native void nglBeginVertexShaderEXT(long j);

    static native int nglBindLightParameterEXT(int i, int i2, long j);

    static native int nglBindMaterialParameterEXT(int i, int i2, long j);

    static native int nglBindParameterEXT(int i, long j);

    static native int nglBindTexGenParameterEXT(int i, int i2, int i3, long j);

    static native int nglBindTextureUnitParameterEXT(int i, int i2, long j);

    static native void nglBindVertexShaderEXT(int i, long j);

    static native void nglDeleteVertexShaderEXT(int i, long j);

    static native void nglDisableVariantClientStateEXT(int i, long j);

    static native void nglEnableVariantClientStateEXT(int i, long j);

    static native void nglEndVertexShaderEXT(long j);

    static native void nglExtractComponentEXT(int i, int i2, int i3, long j);

    static native int nglGenSymbolsEXT(int i, int i2, int i3, int i4, long j);

    static native int nglGenVertexShadersEXT(int i, long j);

    static native void nglGetInvariantBooleanvEXT(int i, int i2, long j, long j2);

    static native void nglGetInvariantFloatvEXT(int i, int i2, long j, long j2);

    static native void nglGetInvariantIntegervEXT(int i, int i2, long j, long j2);

    static native void nglGetLocalConstantBooleanvEXT(int i, int i2, long j, long j2);

    static native void nglGetLocalConstantFloatvEXT(int i, int i2, long j, long j2);

    static native void nglGetLocalConstantIntegervEXT(int i, int i2, long j, long j2);

    static native void nglGetVariantBooleanvEXT(int i, int i2, long j, long j2);

    static native void nglGetVariantFloatvEXT(int i, int i2, long j, long j2);

    static native void nglGetVariantIntegervEXT(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetVariantPointervEXT(int i, int i2, long j, long j2);

    static native void nglInsertComponentEXT(int i, int i2, int i3, long j);

    static native boolean nglIsVariantEnabledEXT(int i, int i2, long j);

    static native void nglSetInvariantEXT(int i, int i2, long j, long j2);

    static native void nglSetLocalConstantEXT(int i, int i2, long j, long j2);

    static native void nglShaderOp1EXT(int i, int i2, int i3, long j);

    static native void nglShaderOp2EXT(int i, int i2, int i3, int i4, long j);

    static native void nglShaderOp3EXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglSwizzleEXT(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglVariantPointerEXT(int i, int i2, int i3, long j, long j2);

    static native void nglVariantPointerEXTBO(int i, int i2, int i3, long j, long j2);

    static native void nglVariantbvEXT(int i, long j, long j2);

    static native void nglVariantdvEXT(int i, long j, long j2);

    static native void nglVariantfvEXT(int i, long j, long j2);

    static native void nglVariantivEXT(int i, long j, long j2);

    static native void nglVariantsvEXT(int i, long j, long j2);

    static native void nglVariantubvEXT(int i, long j, long j2);

    static native void nglVariantuivEXT(int i, long j, long j2);

    static native void nglVariantusvEXT(int i, long j, long j2);

    static native void nglWriteMaskEXT(int i, int i2, int i3, int i4, int i5, int i6, long j);
}
