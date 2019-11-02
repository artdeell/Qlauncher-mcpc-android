package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GL13 {
    public static final int GL_ACTIVE_TEXTURE = 34016;
    public static final int GL_ADD_SIGNED = 34164;
    public static final int GL_CLAMP_TO_BORDER = 33069;
    public static final int GL_CLIENT_ACTIVE_TEXTURE = 34017;
    public static final int GL_COMBINE = 34160;
    public static final int GL_COMBINE_ALPHA = 34162;
    public static final int GL_COMBINE_RGB = 34161;
    public static final int GL_COMPRESSED_ALPHA = 34025;
    public static final int GL_COMPRESSED_INTENSITY = 34028;
    public static final int GL_COMPRESSED_LUMINANCE = 34026;
    public static final int GL_COMPRESSED_LUMINANCE_ALPHA = 34027;
    public static final int GL_COMPRESSED_RGB = 34029;
    public static final int GL_COMPRESSED_RGBA = 34030;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467;
    public static final int GL_CONSTANT = 34166;
    public static final int GL_DOT3_RGB = 34478;
    public static final int GL_DOT3_RGBA = 34479;
    public static final int GL_INTERPOLATE = 34165;
    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076;
    public static final int GL_MAX_TEXTURE_UNITS = 34018;
    public static final int GL_MULTISAMPLE = 32925;
    public static final int GL_MULTISAMPLE_BIT = 536870912;
    public static final int GL_NORMAL_MAP = 34065;
    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466;
    public static final int GL_OPERAND0_ALPHA = 34200;
    public static final int GL_OPERAND0_RGB = 34192;
    public static final int GL_OPERAND1_ALPHA = 34201;
    public static final int GL_OPERAND1_RGB = 34193;
    public static final int GL_OPERAND2_ALPHA = 34202;
    public static final int GL_OPERAND2_RGB = 34194;
    public static final int GL_PREVIOUS = 34168;
    public static final int GL_PRIMARY_COLOR = 34167;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP = 34075;
    public static final int GL_REFLECTION_MAP = 34066;
    public static final int GL_RGB_SCALE = 34163;
    public static final int GL_SAMPLES = 32937;
    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926;
    public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927;
    public static final int GL_SAMPLE_BUFFERS = 32936;
    public static final int GL_SAMPLE_COVERAGE = 32928;
    public static final int GL_SAMPLE_COVERAGE_INVERT = 32939;
    public static final int GL_SAMPLE_COVERAGE_VALUE = 32938;
    public static final int GL_SOURCE0_ALPHA = 34184;
    public static final int GL_SOURCE0_RGB = 34176;
    public static final int GL_SOURCE1_ALPHA = 34185;
    public static final int GL_SOURCE1_RGB = 34177;
    public static final int GL_SOURCE2_ALPHA = 34186;
    public static final int GL_SOURCE2_RGB = 34178;
    public static final int GL_SUBTRACT = 34023;
    public static final int GL_TEXTURE0 = 33984;
    public static final int GL_TEXTURE1 = 33985;
    public static final int GL_TEXTURE10 = 33994;
    public static final int GL_TEXTURE11 = 33995;
    public static final int GL_TEXTURE12 = 33996;
    public static final int GL_TEXTURE13 = 33997;
    public static final int GL_TEXTURE14 = 33998;
    public static final int GL_TEXTURE15 = 33999;
    public static final int GL_TEXTURE16 = 34000;
    public static final int GL_TEXTURE17 = 34001;
    public static final int GL_TEXTURE18 = 34002;
    public static final int GL_TEXTURE19 = 34003;
    public static final int GL_TEXTURE2 = 33986;
    public static final int GL_TEXTURE20 = 34004;
    public static final int GL_TEXTURE21 = 34005;
    public static final int GL_TEXTURE22 = 34006;
    public static final int GL_TEXTURE23 = 34007;
    public static final int GL_TEXTURE24 = 34008;
    public static final int GL_TEXTURE25 = 34009;
    public static final int GL_TEXTURE26 = 34010;
    public static final int GL_TEXTURE27 = 34011;
    public static final int GL_TEXTURE28 = 34012;
    public static final int GL_TEXTURE29 = 34013;
    public static final int GL_TEXTURE3 = 33987;
    public static final int GL_TEXTURE30 = 34014;
    public static final int GL_TEXTURE31 = 34015;
    public static final int GL_TEXTURE4 = 33988;
    public static final int GL_TEXTURE5 = 33989;
    public static final int GL_TEXTURE6 = 33990;
    public static final int GL_TEXTURE7 = 33991;
    public static final int GL_TEXTURE8 = 33992;
    public static final int GL_TEXTURE9 = 33993;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068;
    public static final int GL_TEXTURE_COMPRESSED = 34465;
    public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 34464;
    public static final int GL_TEXTURE_COMPRESSION_HINT = 34031;
    public static final int GL_TEXTURE_CUBE_MAP = 34067;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073;
    public static final int GL_TRANSPOSE_COLOR_MATRIX = 34022;
    public static final int GL_TRANSPOSE_MODELVIEW_MATRIX = 34019;
    public static final int GL_TRANSPOSE_PROJECTION_MATRIX = 34020;
    public static final int GL_TRANSPOSE_TEXTURE_MATRIX = 34021;

    private GL13() {
    }

    public static void glActiveTexture(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glActiveTexture;
        BufferChecks.checkFunctionAddress(j);
        nglActiveTexture(i2, j);
    }

    public static void glClientActiveTexture(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glClientActiveTexture;
        BufferChecks.checkFunctionAddress(j);
        StateTracker.getReferences(capabilities).glClientActiveTexture = i2 - 33984;
        nglClientActiveTexture(i2, j);
    }

    public static void glCompressedTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexImage1D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexImage1DBO(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glCompressedTexImage1D(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexImage1D(i6, i7, i8, i9, i10, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexImage2D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexImage2DBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexImage2D(i7, i8, i9, i10, i11, i12, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexImage3D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexImage3DBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glCompressedTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexImage3D(i8, i9, i10, i11, i12, i13, i14, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexSubImage1D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexSubImage1DBO(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glCompressedTexSubImage1D(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexSubImage1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexSubImage1D(i6, i7, i8, i9, i10, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexSubImage2D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexSubImage2DBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexSubImage2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexSubImage2D(i8, i9, i10, i11, i12, i13, i14, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j) {
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
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexSubImage3D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexSubImage3DBO(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j2, j3);
    }

    public static void glCompressedTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ByteBuffer byteBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexSubImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexSubImage3D(i10, i11, i12, i13, i14, i15, i16, i17, i18, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetCompressedTexImage(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetCompressedTexImage;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetCompressedTexImageBO(i3, i4, j2, j3);
    }

    public static void glGetCompressedTexImage(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedTexImage;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetCompressedTexImage(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetCompressedTexImage(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedTexImage;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetCompressedTexImage(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetCompressedTexImage(int i, int i2, ShortBuffer shortBuffer) {
        int i3 = i;
        int i4 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedTexImage;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetCompressedTexImage(i3, i4, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glLoadTransposeMatrix(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glLoadTransposeMatrixd;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglLoadTransposeMatrixd(MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glLoadTransposeMatrix(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glLoadTransposeMatrixf;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglLoadTransposeMatrixf(MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultTransposeMatrix(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMultTransposeMatrixd;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglMultTransposeMatrixd(MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMultTransposeMatrix(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMultTransposeMatrixf;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglMultTransposeMatrixf(MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultiTexCoord1d(int i, double d) {
        int i2 = i;
        double d2 = d;
        long j = GLContext.getCapabilities().glMultiTexCoord1d;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord1d(i2, d2, j);
    }

    public static void glMultiTexCoord1f(int i, float f) {
        int i2 = i;
        float f2 = f;
        long j = GLContext.getCapabilities().glMultiTexCoord1f;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord1f(i2, f2, j);
    }

    public static void glMultiTexCoord2d(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glMultiTexCoord2d;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord2d(i2, d3, d4, j);
    }

    public static void glMultiTexCoord2f(int i, float f, float f2) {
        int i2 = i;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glMultiTexCoord2f;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord2f(i2, f3, f4, j);
    }

    public static void glMultiTexCoord3d(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glMultiTexCoord3d;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord3d(i2, d4, d5, d6, j);
    }

    public static void glMultiTexCoord3f(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glMultiTexCoord3f;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord3f(i2, f4, f5, f6, j);
    }

    public static void glMultiTexCoord4d(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glMultiTexCoord4d;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord4d(i2, d5, d6, d7, d8, j);
    }

    public static void glMultiTexCoord4f(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glMultiTexCoord4f;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexCoord4f(i2, f5, f6, f7, f8, j);
    }

    public static void glSampleCoverage(float f, boolean z) {
        float f2 = f;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glSampleCoverage;
        BufferChecks.checkFunctionAddress(j);
        nglSampleCoverage(f2, z2, j);
    }

    static native void nglActiveTexture(int i, long j);

    static native void nglClientActiveTexture(int i, long j);

    static native void nglCompressedTexImage1D(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglCompressedTexImage1DBO(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedTexImage2DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTexImage3DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTexSubImage1D(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglCompressedTexSubImage1DBO(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTexSubImage2DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglCompressedTexSubImage3DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglGetCompressedTexImage(int i, int i2, long j, long j2);

    static native void nglGetCompressedTexImageBO(int i, int i2, long j, long j2);

    static native void nglLoadTransposeMatrixd(long j, long j2);

    static native void nglLoadTransposeMatrixf(long j, long j2);

    static native void nglMultTransposeMatrixd(long j, long j2);

    static native void nglMultTransposeMatrixf(long j, long j2);

    static native void nglMultiTexCoord1d(int i, double d, long j);

    static native void nglMultiTexCoord1f(int i, float f, long j);

    static native void nglMultiTexCoord2d(int i, double d, double d2, long j);

    static native void nglMultiTexCoord2f(int i, float f, float f2, long j);

    static native void nglMultiTexCoord3d(int i, double d, double d2, double d3, long j);

    static native void nglMultiTexCoord3f(int i, float f, float f2, float f3, long j);

    static native void nglMultiTexCoord4d(int i, double d, double d2, double d3, double d4, long j);

    static native void nglMultiTexCoord4f(int i, float f, float f2, float f3, float f4, long j);

    static native void nglSampleCoverage(float f, boolean z, long j);
}
