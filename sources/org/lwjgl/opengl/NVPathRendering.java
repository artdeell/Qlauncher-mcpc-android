package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVPathRendering {
    public static final int GL_ACCUM_ADJACENT_PAIRS_NV = 37037;
    public static final int GL_ADJACENT_PAIRS_NV = 37038;
    public static final int GL_AFFINE_2D_NV = 37010;
    public static final int GL_AFFINE_3D_NV = 37012;
    public static final int GL_ARC_TO_NV = 254;
    public static final int GL_BEVEL_NV = 37030;
    public static final int GL_BOLD_BIT_NV = 1;
    public static final int GL_BOUNDING_BOX_NV = 37005;
    public static final int GL_BOUNDING_BOX_OF_BOUNDING_BOXES_NV = 37020;
    public static final int GL_CIRCULAR_CCW_ARC_TO_NV = 248;
    public static final int GL_CIRCULAR_CW_ARC_TO_NV = 250;
    public static final int GL_CIRCULAR_TANGENT_ARC_TO_NV = 252;
    public static final int GL_CLOSE_PATH_NV = 0;
    public static final int GL_CONVEX_HULL_NV = 37003;
    public static final int GL_COUNT_DOWN_NV = 37001;
    public static final int GL_COUNT_UP_NV = 37000;
    public static final int GL_CUBIC_CURVE_TO_NV = 12;
    public static final int GL_FILE_NAME_NV = 36980;
    public static final int GL_FIRST_TO_REST_NV = 37039;
    public static final int GL_FONT_ASCENDER_NV = 2097152;
    public static final int GL_FONT_DESCENDER_NV = 4194304;
    public static final int GL_FONT_HAS_KERNING_NV = 268435456;
    public static final int GL_FONT_HEIGHT_NV = 8388608;
    public static final int GL_FONT_MAX_ADVANCE_HEIGHT_NV = 33554432;
    public static final int GL_FONT_MAX_ADVANCE_WIDTH_NV = 16777216;
    public static final int GL_FONT_UNDERLINE_POSITION_NV = 67108864;
    public static final int GL_FONT_UNDERLINE_THICKNESS_NV = 134217728;
    public static final int GL_FONT_UNITS_PER_EM_NV = 1048576;
    public static final int GL_FONT_X_MAX_BOUNDS_NV = 262144;
    public static final int GL_FONT_X_MIN_BOUNDS_NV = 65536;
    public static final int GL_FONT_Y_MAX_BOUNDS_NV = 524288;
    public static final int GL_FONT_Y_MIN_BOUNDS_NV = 131072;
    public static final int GL_GLYPH_HAS_KERNING_NV = 256;
    public static final int GL_GLYPH_HEIGHT_BIT_NV = 2;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_ADVANCE_BIT_NV = 16;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_X_BIT_NV = 4;
    public static final int GL_GLYPH_HORIZONTAL_BEARING_Y_BIT_NV = 8;
    public static final int GL_GLYPH_VERTICAL_BEARING_ADVANCE_BIT_NV = 128;
    public static final int GL_GLYPH_VERTICAL_BEARING_X_BIT_NV = 32;
    public static final int GL_GLYPH_VERTICAL_BEARING_Y_BIT_NV = 64;
    public static final int GL_GLYPH_WIDTH_BIT_NV = 1;
    public static final int GL_HORIZONTAL_LINE_TO_NV = 6;
    public static final int GL_ITALIC_BIT_NV = 2;
    public static final int GL_LARGE_CCW_ARC_TO_NV = 22;
    public static final int GL_LARGE_CW_ARC_TO_NV = 24;
    public static final int GL_LINE_TO_NV = 4;
    public static final int GL_MITER_REVERT_NV = 37031;
    public static final int GL_MITER_TRUNCATE_NV = 37032;
    public static final int GL_MOVE_TO_CONTINUES_NV = 37046;
    public static final int GL_MOVE_TO_NV = 2;
    public static final int GL_MOVE_TO_RESETS_NV = 37045;
    public static final int GL_PATH_CLIENT_LENGTH_NV = 36991;
    public static final int GL_PATH_COMMAND_COUNT_NV = 37021;
    public static final int GL_PATH_COMPUTED_LENGTH_NV = 37024;
    public static final int GL_PATH_COORD_COUNT_NV = 37022;
    public static final int GL_PATH_COVER_DEPTH_FUNC_NV = 37055;
    public static final int GL_PATH_DASH_ARRAY_COUNT_NV = 37023;
    public static final int GL_PATH_DASH_CAPS_NV = 36987;
    public static final int GL_PATH_DASH_OFFSET_NV = 36990;
    public static final int GL_PATH_DASH_OFFSET_RESET_NV = 37044;
    public static final int GL_PATH_END_CAPS_NV = 36982;
    public static final int GL_PATH_ERROR_POSITION_NV = 37035;
    public static final int GL_PATH_FILL_BOUNDING_BOX_NV = 37025;
    public static final int GL_PATH_FILL_COVER_MODE_NV = 36994;
    public static final int GL_PATH_FILL_MASK_NV = 36993;
    public static final int GL_PATH_FILL_MODE_NV = 36992;
    public static final int GL_PATH_FOG_GEN_MODE_NV = 37036;
    public static final int GL_PATH_FORMAT_PS_NV = 36977;
    public static final int GL_PATH_FORMAT_SVG_NV = 36976;
    public static final int GL_PATH_GEN_COEFF_NV = 37041;
    public static final int GL_PATH_GEN_COLOR_FORMAT_NV = 37042;
    public static final int GL_PATH_GEN_COMPONENTS_NV = 37043;
    public static final int GL_PATH_GEN_MODE_NV = 37040;
    public static final int GL_PATH_INITIAL_DASH_CAP_NV = 36988;
    public static final int GL_PATH_INITIAL_END_CAP_NV = 36983;
    public static final int GL_PATH_JOIN_STYLE_NV = 36985;
    public static final int GL_PATH_MITER_LIMIT_NV = 36986;
    public static final int GL_PATH_OBJECT_BOUNDING_BOX_NV = 37002;
    public static final int GL_PATH_STENCIL_DEPTH_OFFSET_FACTOR_NV = 37053;
    public static final int GL_PATH_STENCIL_DEPTH_OFFSET_UNITS_NV = 37054;
    public static final int GL_PATH_STENCIL_FUNC_NV = 37047;
    public static final int GL_PATH_STENCIL_REF_NV = 37048;
    public static final int GL_PATH_STENCIL_VALUE_MASK_NV = 37049;
    public static final int GL_PATH_STROKE_BOUNDING_BOX_NV = 37026;
    public static final int GL_PATH_STROKE_COVER_MODE_NV = 36995;
    public static final int GL_PATH_STROKE_MASK_NV = 36996;
    public static final int GL_PATH_STROKE_WIDTH_NV = 36981;
    public static final int GL_PATH_TERMINAL_DASH_CAP_NV = 36989;
    public static final int GL_PATH_TERMINAL_END_CAP_NV = 36984;
    public static final int GL_PRIMARY_COLOR = 34167;
    public static final int GL_PRIMARY_COLOR_NV = 34092;
    public static final int GL_QUADRATIC_CURVE_TO_NV = 10;
    public static final int GL_RELATIVE_ARC_TO_NV = 255;
    public static final int GL_RELATIVE_CUBIC_CURVE_TO_NV = 13;
    public static final int GL_RELATIVE_HORIZONTAL_LINE_TO_NV = 7;
    public static final int GL_RELATIVE_LARGE_CCW_ARC_TO_NV = 23;
    public static final int GL_RELATIVE_LARGE_CW_ARC_TO_NV = 25;
    public static final int GL_RELATIVE_LINE_TO_NV = 5;
    public static final int GL_RELATIVE_MOVE_TO_NV = 3;
    public static final int GL_RELATIVE_QUADRATIC_CURVE_TO_NV = 11;
    public static final int GL_RELATIVE_SMALL_CCW_ARC_TO_NV = 19;
    public static final int GL_RELATIVE_SMALL_CW_ARC_TO_NV = 21;
    public static final int GL_RELATIVE_SMOOTH_CUBIC_CURVE_TO_NV = 17;
    public static final int GL_RELATIVE_SMOOTH_QUADRATIC_CURVE_TO_NV = 15;
    public static final int GL_RELATIVE_VERTICAL_LINE_TO_NV = 9;
    public static final int GL_ROUND_NV = 37028;
    public static final int GL_SECONDARY_COLOR_NV = 34093;
    public static final int GL_SKIP_MISSING_GLYPH_NV = 37033;
    public static final int GL_SMALL_CCW_ARC_TO_NV = 18;
    public static final int GL_SMALL_CW_ARC_TO_NV = 20;
    public static final int GL_SMOOTH_CUBIC_CURVE_TO_NV = 16;
    public static final int GL_SMOOTH_QUADRATIC_CURVE_TO_NV = 14;
    public static final int GL_SQUARE_NV = 37027;
    public static final int GL_STANDARD_FONT_NAME_NV = 36978;
    public static final int GL_SYSTEM_FONT_NAME_NV = 36979;
    public static final int GL_TRANSLATE_2D_NV = 37008;
    public static final int GL_TRANSLATE_3D_NV = 37009;
    public static final int GL_TRANSLATE_X_NV = 37006;
    public static final int GL_TRANSLATE_Y_NV = 37007;
    public static final int GL_TRANSPOSE_AFFINE_2D_NV = 37014;
    public static final int GL_TRANSPOSE_AFFINE_3D_NV = 37016;
    public static final int GL_TRIANGULAR_NV = 37029;
    public static final int GL_USE_MISSING_GLYPH_NV = 37034;
    public static final int GL_UTF16_NV = 37019;
    public static final int GL_UTF8_NV = 37018;
    public static final int GL_VERTICAL_LINE_TO_NV = 8;

    private NVPathRendering() {
    }

    public static void glCopyPathNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glCopyPathNV;
        BufferChecks.checkFunctionAddress(j);
        nglCopyPathNV(i3, i4, j);
    }

    public static void glCoverFillPathInstancedNV(int i, ByteBuffer byteBuffer, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glCoverFillPathInstancedNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTransformPathValues(i8));
        }
        nglCoverFillPathInstancedNV(byteBuffer2.remaining() / GLChecks.calculateBytesPerPathName(i5), i5, MemoryUtil.getAddress(byteBuffer2), i6, i7, i8, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glCoverFillPathNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glCoverFillPathNV;
        BufferChecks.checkFunctionAddress(j);
        nglCoverFillPathNV(i3, i4, j);
    }

    public static void glCoverStrokePathInstancedNV(int i, ByteBuffer byteBuffer, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glCoverStrokePathInstancedNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTransformPathValues(i8));
        }
        nglCoverStrokePathInstancedNV(byteBuffer2.remaining() / GLChecks.calculateBytesPerPathName(i5), i5, MemoryUtil.getAddress(byteBuffer2), i6, i7, i8, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glCoverStrokePathNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glCoverStrokePathNV;
        BufferChecks.checkFunctionAddress(j);
        nglCoverStrokePathNV(i3, i4, j);
    }

    public static void glDeletePathsNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDeletePathsNV;
        BufferChecks.checkFunctionAddress(j);
        nglDeletePathsNV(i3, i4, j);
    }

    public static int glGenPathsNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGenPathsNV;
        BufferChecks.checkFunctionAddress(j);
        return nglGenPathsNV(i2, j);
    }

    public static void glGetPathColorGenNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetPathColorGenfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglGetPathColorGenfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetPathColorGenNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetPathColorGenivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 16);
        nglGetPathColorGenivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetPathColorGenfNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPathColorGenfvNV;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetPathColorGenfvNV(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetPathColorGeniNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPathColorGenivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetPathColorGenivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetPathCommandsNV(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetPathCommandsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetPathCommandsNV(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetPathCoordsNV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetPathCoordsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetPathCoordsNV(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetPathDashArrayNV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetPathDashArrayNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetPathDashArrayNV(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static float glGetPathLengthNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glGetPathLengthNV;
        BufferChecks.checkFunctionAddress(j);
        return nglGetPathLengthNV(i4, i5, i6, j);
    }

    public static void glGetPathMetricRangeNV(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetPathMetricRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateMetricsSize(i5, i8));
        nglGetPathMetricRangeNV(i5, i6, i7, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetPathMetricsNV(int i, int i2, ByteBuffer byteBuffer, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetPathMetricsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateMetricsSize(i5, i8));
        nglGetPathMetricsNV(i5, byteBuffer2.remaining() / GLChecks.calculateBytesPerPathName(i6), i6, MemoryUtil.getAddress(byteBuffer2), i7, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetPathParameterNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetPathParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetPathParameterivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetPathParameterfNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPathParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetPathParameterfvNV(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static void glGetPathParameterfvNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetPathParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetPathParameterfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static int glGetPathParameteriNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPathParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetPathParameterivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetPathSpacingNV(int i, int i2, ByteBuffer byteBuffer, int i3, float f, float f2, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i3;
        float f3 = f;
        float f4 = f2;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetPathSpacingNV;
        BufferChecks.checkFunctionAddress(j);
        int remaining = byteBuffer2.remaining() / GLChecks.calculateBytesPerPathName(i6);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkBuffer(floatBuffer2, remaining - 1);
        nglGetPathSpacingNV(i5, remaining, i6, MemoryUtil.getAddress(byteBuffer2), i7, f3, f4, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetPathTexGenNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetPathTexGenfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglGetPathTexGenfvNV(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetPathTexGenNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetPathTexGenivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 16);
        nglGetPathTexGenivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetPathTexGenfNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPathTexGenfvNV;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetPathTexGenfvNV(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetPathTexGeniNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetPathTexGenivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetPathTexGenivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glInterpolatePathsNV(int i, int i2, int i3, float f) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        float f2 = f;
        long j = GLContext.getCapabilities().glInterpolatePathsNV;
        BufferChecks.checkFunctionAddress(j);
        nglInterpolatePathsNV(i4, i5, i6, f2, j);
    }

    public static boolean glIsPathNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsPathNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsPathNV(i2, j);
    }

    public static boolean glIsPointInFillPathNV(int i, int i2, float f, float f2) {
        int i3 = i;
        int i4 = i2;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glIsPointInFillPathNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsPointInFillPathNV(i3, i4, f3, f4, j);
    }

    public static boolean glIsPointInStrokePathNV(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glIsPointInStrokePathNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsPointInStrokePathNV(i2, f3, f4, j);
    }

    public static void glPathColorGenNV(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPathColorGenNV;
        BufferChecks.checkFunctionAddress(j);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculatePathColorGenCoeffsCount(i5, i6));
        }
        nglPathColorGenNV(i4, i5, i6, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glPathCommandsNV(int i, ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2) {
        int i3 = i;
        ByteBuffer byteBuffer3 = byteBuffer;
        int i4 = i2;
        ByteBuffer byteBuffer4 = byteBuffer2;
        long j = GLContext.getCapabilities().glPathCommandsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglPathCommandsNV(i3, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), byteBuffer4.remaining(), i4, MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glPathCoordsNV(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glPathCoordsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglPathCoordsNV(i3, byteBuffer2.remaining(), i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glPathCoverDepthFuncNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glPathCoverDepthFuncNV;
        BufferChecks.checkFunctionAddress(j);
        nglPathCoverDepthFuncNV(i2, j);
    }

    public static void glPathDashArrayNV(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPathDashArrayNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglPathDashArrayNV(i2, floatBuffer2.remaining(), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPathFogGenNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glPathFogGenNV;
        BufferChecks.checkFunctionAddress(j);
        nglPathFogGenNV(i2, j);
    }

    public static void glPathGlyphRangeNV(int i, int i2, ByteBuffer byteBuffer, int i3, int i4, int i5, int i6, int i7, float f) {
        int i8 = i;
        int i9 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        float f2 = f;
        long j = GLContext.getCapabilities().glPathGlyphRangeNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        nglPathGlyphRangeNV(i8, i9, MemoryUtil.getAddress(byteBuffer2), i10, i11, i12, i13, i14, f2, j);
    }

    public static void glPathGlyphsNV(int i, int i2, ByteBuffer byteBuffer, int i3, int i4, ByteBuffer byteBuffer2, int i5, int i6, float f) {
        int i7 = i;
        int i8 = i2;
        ByteBuffer byteBuffer3 = byteBuffer;
        int i9 = i3;
        int i10 = i4;
        ByteBuffer byteBuffer4 = byteBuffer2;
        int i11 = i5;
        int i12 = i6;
        float f2 = f;
        long j = GLContext.getCapabilities().glPathGlyphsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkNullTerminated(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglPathGlyphsNV(i7, i8, MemoryUtil.getAddress(byteBuffer3), i9, byteBuffer4.remaining() / GLChecks.calculateBytesPerCharCode(i10), i10, MemoryUtil.getAddress(byteBuffer4), i11, i12, f2, j);
    }

    public static void glPathParameterNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glPathParameterivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglPathParameterivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glPathParameterfNV(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glPathParameterfNV;
        BufferChecks.checkFunctionAddress(j);
        nglPathParameterfNV(i3, i4, f2, j);
    }

    public static void glPathParameterfNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glPathParameterfvNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglPathParameterfvNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glPathParameteriNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glPathParameteriNV;
        BufferChecks.checkFunctionAddress(j);
        nglPathParameteriNV(i4, i5, i6, j);
    }

    public static void glPathStencilDepthOffsetNV(float f, int i) {
        float f2 = f;
        int i2 = i;
        long j = GLContext.getCapabilities().glPathStencilDepthOffsetNV;
        BufferChecks.checkFunctionAddress(j);
        nglPathStencilDepthOffsetNV(f2, i2, j);
    }

    public static void glPathStencilFuncNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glPathStencilFuncNV;
        BufferChecks.checkFunctionAddress(j);
        nglPathStencilFuncNV(i4, i5, i6, j);
    }

    public static void glPathStringNV(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glPathStringNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglPathStringNV(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glPathSubCommandsNV(int i, int i2, int i3, ByteBuffer byteBuffer, int i4, ByteBuffer byteBuffer2) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        int i8 = i4;
        ByteBuffer byteBuffer4 = byteBuffer2;
        long j = GLContext.getCapabilities().glPathSubCommandsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglPathSubCommandsNV(i5, i6, i7, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), byteBuffer4.remaining(), i8, MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glPathSubCoordsNV(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glPathSubCoordsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglPathSubCoordsNV(i4, i5, byteBuffer2.remaining(), i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glPathTexGenNV(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glPathTexGenNV;
        BufferChecks.checkFunctionAddress(j);
        if (floatBuffer2 != null) {
            BufferChecks.checkDirect(floatBuffer2);
        }
        nglPathTexGenNV(i3, i4, GLChecks.calculatePathTextGenCoeffsPerComponent(floatBuffer2, i4), MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static boolean glPointAlongPathNV(int i, int i2, int i3, float f, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, FloatBuffer floatBuffer3, FloatBuffer floatBuffer4) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        float f2 = f;
        FloatBuffer floatBuffer5 = floatBuffer;
        FloatBuffer floatBuffer6 = floatBuffer2;
        FloatBuffer floatBuffer7 = floatBuffer3;
        FloatBuffer floatBuffer8 = floatBuffer4;
        long j = GLContext.getCapabilities().glPointAlongPathNV;
        BufferChecks.checkFunctionAddress(j);
        if (floatBuffer5 != null) {
            BufferChecks.checkBuffer(floatBuffer5, 1);
        }
        if (floatBuffer6 != null) {
            BufferChecks.checkBuffer(floatBuffer6, 1);
        }
        if (floatBuffer7 != null) {
            BufferChecks.checkBuffer(floatBuffer7, 1);
        }
        if (floatBuffer8 != null) {
            BufferChecks.checkBuffer(floatBuffer8, 1);
        }
        return nglPointAlongPathNV(i4, i5, i6, f2, MemoryUtil.getAddressSafe(floatBuffer5), MemoryUtil.getAddressSafe(floatBuffer6), MemoryUtil.getAddressSafe(floatBuffer7), MemoryUtil.getAddressSafe(floatBuffer8), j);
    }

    public static void glStencilFillPathInstancedNV(int i, ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glStencilFillPathInstancedNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTransformPathValues(i10));
        }
        nglStencilFillPathInstancedNV(byteBuffer2.remaining() / GLChecks.calculateBytesPerPathName(i6), i6, MemoryUtil.getAddress(byteBuffer2), i7, i8, i9, i10, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glStencilFillPathNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glStencilFillPathNV;
        BufferChecks.checkFunctionAddress(j);
        nglStencilFillPathNV(i4, i5, i6, j);
    }

    public static void glStencilStrokePathInstancedNV(int i, ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glStencilStrokePathInstancedNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTransformPathValues(i10));
        }
        nglStencilStrokePathInstancedNV(byteBuffer2.remaining() / GLChecks.calculateBytesPerPathName(i6), i6, MemoryUtil.getAddress(byteBuffer2), i7, i8, i9, i10, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glStencilStrokePathNV(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glStencilStrokePathNV;
        BufferChecks.checkFunctionAddress(j);
        nglStencilStrokePathNV(i4, i5, i6, j);
    }

    public static void glTransformPathNV(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glTransformPathNV;
        BufferChecks.checkFunctionAddress(j);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTransformPathValues(i6));
        }
        nglTransformPathNV(i4, i5, i6, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glWeightPathsNV(int i, IntBuffer intBuffer, FloatBuffer floatBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glWeightPathsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkBuffer(floatBuffer2, intBuffer2.remaining());
        nglWeightPathsNV(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglCopyPathNV(int i, int i2, long j);

    static native void nglCoverFillPathInstancedNV(int i, int i2, long j, int i3, int i4, int i5, long j2, long j3);

    static native void nglCoverFillPathNV(int i, int i2, long j);

    static native void nglCoverStrokePathInstancedNV(int i, int i2, long j, int i3, int i4, int i5, long j2, long j3);

    static native void nglCoverStrokePathNV(int i, int i2, long j);

    static native void nglDeletePathsNV(int i, int i2, long j);

    static native int nglGenPathsNV(int i, long j);

    static native void nglGetPathColorGenfvNV(int i, int i2, long j, long j2);

    static native void nglGetPathColorGenivNV(int i, int i2, long j, long j2);

    static native void nglGetPathCommandsNV(int i, long j, long j2);

    static native void nglGetPathCoordsNV(int i, long j, long j2);

    static native void nglGetPathDashArrayNV(int i, long j, long j2);

    static native float nglGetPathLengthNV(int i, int i2, int i3, long j);

    static native void nglGetPathMetricRangeNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetPathMetricsNV(int i, int i2, int i3, long j, int i4, int i5, long j2, long j3);

    static native void nglGetPathParameterfvNV(int i, int i2, long j, long j2);

    static native void nglGetPathParameterivNV(int i, int i2, long j, long j2);

    static native void nglGetPathSpacingNV(int i, int i2, int i3, long j, int i4, float f, float f2, int i5, long j2, long j3);

    static native void nglGetPathTexGenfvNV(int i, int i2, long j, long j2);

    static native void nglGetPathTexGenivNV(int i, int i2, long j, long j2);

    static native void nglInterpolatePathsNV(int i, int i2, int i3, float f, long j);

    static native boolean nglIsPathNV(int i, long j);

    static native boolean nglIsPointInFillPathNV(int i, int i2, float f, float f2, long j);

    static native boolean nglIsPointInStrokePathNV(int i, float f, float f2, long j);

    static native void nglPathColorGenNV(int i, int i2, int i3, long j, long j2);

    static native void nglPathCommandsNV(int i, int i2, long j, int i3, int i4, long j2, long j3);

    static native void nglPathCoordsNV(int i, int i2, int i3, long j, long j2);

    static native void nglPathCoverDepthFuncNV(int i, long j);

    static native void nglPathDashArrayNV(int i, int i2, long j, long j2);

    static native void nglPathFogGenNV(int i, long j);

    static native void nglPathGlyphRangeNV(int i, int i2, long j, int i3, int i4, int i5, int i6, int i7, float f, long j2);

    static native void nglPathGlyphsNV(int i, int i2, long j, int i3, int i4, int i5, long j2, int i6, int i7, float f, long j3);

    static native void nglPathParameterfNV(int i, int i2, float f, long j);

    static native void nglPathParameterfvNV(int i, int i2, long j, long j2);

    static native void nglPathParameteriNV(int i, int i2, int i3, long j);

    static native void nglPathParameterivNV(int i, int i2, long j, long j2);

    static native void nglPathStencilDepthOffsetNV(float f, int i, long j);

    static native void nglPathStencilFuncNV(int i, int i2, int i3, long j);

    static native void nglPathStringNV(int i, int i2, int i3, long j, long j2);

    static native void nglPathSubCommandsNV(int i, int i2, int i3, int i4, long j, int i5, int i6, long j2, long j3);

    static native void nglPathSubCoordsNV(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglPathTexGenNV(int i, int i2, int i3, long j, long j2);

    static native boolean nglPointAlongPathNV(int i, int i2, int i3, float f, long j, long j2, long j3, long j4, long j5);

    static native void nglStencilFillPathInstancedNV(int i, int i2, long j, int i3, int i4, int i5, int i6, long j2, long j3);

    static native void nglStencilFillPathNV(int i, int i2, int i3, long j);

    static native void nglStencilStrokePathInstancedNV(int i, int i2, long j, int i3, int i4, int i5, int i6, long j2, long j3);

    static native void nglStencilStrokePathNV(int i, int i2, int i3, long j);

    static native void nglTransformPathNV(int i, int i2, int i3, long j, long j2);

    static native void nglWeightPathsNV(int i, int i2, long j, long j2, long j3);
}
