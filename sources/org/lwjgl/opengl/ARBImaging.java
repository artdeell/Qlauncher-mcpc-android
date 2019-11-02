package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBImaging {
    public static final int GL_BLEND_COLOR = 32773;
    public static final int GL_BLEND_EQUATION = 32777;
    public static final int GL_COLOR_MATRIX = 32945;
    public static final int GL_COLOR_MATRIX_STACK_DEPTH = 32946;
    public static final int GL_COLOR_TABLE = 32976;
    public static final int GL_COLOR_TABLE_ALPHA_SIZE = 32989;
    public static final int GL_COLOR_TABLE_BIAS = 32983;
    public static final int GL_COLOR_TABLE_BLUE_SIZE = 32988;
    public static final int GL_COLOR_TABLE_FORMAT = 32984;
    public static final int GL_COLOR_TABLE_GREEN_SIZE = 32987;
    public static final int GL_COLOR_TABLE_INTENSITY_SIZE = 32991;
    public static final int GL_COLOR_TABLE_LUMINANCE_SIZE = 32990;
    public static final int GL_COLOR_TABLE_RED_SIZE = 32986;
    public static final int GL_COLOR_TABLE_SCALE = 32982;
    public static final int GL_COLOR_TABLE_WIDTH = 32985;
    public static final int GL_CONSTANT_ALPHA = 32771;
    public static final int GL_CONSTANT_BORDER = 33105;
    public static final int GL_CONSTANT_COLOR = 32769;
    public static final int GL_CONVOLUTION_1D = 32784;
    public static final int GL_CONVOLUTION_2D = 32785;
    public static final int GL_CONVOLUTION_BORDER_COLOR = 33108;
    public static final int GL_CONVOLUTION_BORDER_MODE = 32787;
    public static final int GL_CONVOLUTION_FILTER_BIAS = 32789;
    public static final int GL_CONVOLUTION_FILTER_SCALE = 32788;
    public static final int GL_CONVOLUTION_FORMAT = 32791;
    public static final int GL_CONVOLUTION_HEIGHT = 32793;
    public static final int GL_CONVOLUTION_WIDTH = 32792;
    public static final int GL_FUNC_ADD = 32774;
    public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
    public static final int GL_FUNC_SUBTRACT = 32778;
    public static final int GL_HISTOGRAM = 32804;
    public static final int GL_HISTOGRAM_ALPHA_SIZE = 32811;
    public static final int GL_HISTOGRAM_BLUE_SIZE = 32810;
    public static final int GL_HISTOGRAM_FORMAT = 32807;
    public static final int GL_HISTOGRAM_GREEN_SIZE = 32809;
    public static final int GL_HISTOGRAM_LUMINANCE_SIZE = 32812;
    public static final int GL_HISTOGRAM_RED_SIZE = 32808;
    public static final int GL_HISTOGRAM_SINK = 32813;
    public static final int GL_HISTOGRAM_WIDTH = 32806;
    public static final int GL_IGNORE_BORDER = 33104;
    public static final int GL_MAX = 32776;
    public static final int GL_MAX_COLOR_MATRIX_STACK_DEPTH = 32947;
    public static final int GL_MAX_CONVOLUTION_HEIGHT = 32795;
    public static final int GL_MAX_CONVOLUTION_WIDTH = 32794;
    public static final int GL_MIN = 32775;
    public static final int GL_MINMAX = 32814;
    public static final int GL_MINMAX_FORMAT = 32815;
    public static final int GL_MINMAX_SINK = 32816;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
    public static final int GL_POST_COLOR_MATRIX_ALPHA_BIAS = 32955;
    public static final int GL_POST_COLOR_MATRIX_ALPHA_SCALE = 32951;
    public static final int GL_POST_COLOR_MATRIX_BLUE_BIAS = 32954;
    public static final int GL_POST_COLOR_MATRIX_BLUE_SCALE = 32950;
    public static final int GL_POST_COLOR_MATRIX_COLOR_TABLE = 32978;
    public static final int GL_POST_COLOR_MATRIX_GREEN_BIAS = 32953;
    public static final int GL_POST_COLOR_MATRIX_GREEN_SCALE = 32949;
    public static final int GL_POST_COLOR_MATRIX_RED_BIAS = 32952;
    public static final int GL_POST_COLOR_MATRIX_RED_SCALE = 32948;
    public static final int GL_POST_CONVOLUTION_ALPHA_BIAS = 32803;
    public static final int GL_POST_CONVOLUTION_ALPHA_SCALE = 32799;
    public static final int GL_POST_CONVOLUTION_BLUE_BIAS = 32802;
    public static final int GL_POST_CONVOLUTION_BLUE_SCALE = 32798;
    public static final int GL_POST_CONVOLUTION_COLOR_TABLE = 32977;
    public static final int GL_POST_CONVOLUTION_GREEN_BIAS = 32801;
    public static final int GL_POST_CONVOLUTION_GREEN_SCALE = 32797;
    public static final int GL_POST_CONVOLUTION_RED_BIAS = 32800;
    public static final int GL_POST_CONVOLUTION_RED_SCALE = 32796;
    public static final int GL_PROXY_COLOR_TABLE = 32979;
    public static final int GL_PROXY_HISTOGRAM = 32805;
    public static final int GL_PROXY_POST_COLOR_MATRIX_COLOR_TABLE = 32981;
    public static final int GL_PROXY_POST_CONVOLUTION_COLOR_TABLE = 32980;
    public static final int GL_REDUCE = 32790;
    public static final int GL_REPLICATE_BORDER = 33107;
    public static final int GL_SEPARABLE_2D = 32786;
    public static final int GL_TABLE_TOO_LARGE = 32817;

    private ARBImaging() {
    }

    public static void glBlendColor(float f, float f2, float f3, float f4) {
        GL14.glBlendColor(f, f2, f3, f4);
    }

    public static void glBlendEquation(int i) {
        GL14.glBlendEquation(i);
    }

    public static void glColorSubTable(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glColorSubTable;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglColorSubTableBO(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glColorSubTable(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorSubTable;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, 256);
        nglColorSubTable(i6, i7, i8, i9, i10, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glColorSubTable(int i, int i2, int i3, int i4, int i5, DoubleBuffer doubleBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorSubTable;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, 256);
        nglColorSubTable(i6, i7, i8, i9, i10, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glColorSubTable(int i, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorSubTable;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, 256);
        nglColorSubTable(i6, i7, i8, i9, i10, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glColorTable(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glColorTable;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglColorTableBO(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glColorTable(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorTable;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, 256);
        nglColorTable(i6, i7, i8, i9, i10, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glColorTable(int i, int i2, int i3, int i4, int i5, DoubleBuffer doubleBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorTable;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, 256);
        nglColorTable(i6, i7, i8, i9, i10, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glColorTable(int i, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glColorTable;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, 256);
        nglColorTable(i6, i7, i8, i9, i10, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glColorTableParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glColorTableParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglColorTableParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glColorTableParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glColorTableParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglColorTableParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glConvolutionFilter1D(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glConvolutionFilter1D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglConvolutionFilter1DBO(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glConvolutionFilter1D(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glConvolutionFilter1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i9, i10, i8, 1, 1));
        nglConvolutionFilter1D(i6, i7, i8, i9, i10, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glConvolutionFilter1D(int i, int i2, int i3, int i4, int i5, DoubleBuffer doubleBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glConvolutionFilter1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i9, i10, i8, 1, 1));
        nglConvolutionFilter1D(i6, i7, i8, i9, i10, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glConvolutionFilter1D(int i, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glConvolutionFilter1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i9, i10, i8, 1, 1));
        nglConvolutionFilter1D(i6, i7, i8, i9, i10, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glConvolutionFilter1D(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glConvolutionFilter1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i9, i10, i8, 1, 1));
        nglConvolutionFilter1D(i6, i7, i8, i9, i10, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glConvolutionFilter1D(int i, int i2, int i3, int i4, int i5, ShortBuffer shortBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glConvolutionFilter1D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i9, i10, i8, 1, 1));
        nglConvolutionFilter1D(i6, i7, i8, i9, i10, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glConvolutionFilter2D(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glConvolutionFilter2D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglConvolutionFilter2DBO(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glConvolutionFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glConvolutionFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i11, i12, i9, i10, 1));
        nglConvolutionFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glConvolutionFilter2D(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glConvolutionFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i11, i12, i9, i10, 1));
        nglConvolutionFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glConvolutionFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glConvolutionFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i11, i12, i9, i10, 1));
        nglConvolutionFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glConvolutionParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glConvolutionParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglConvolutionParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glConvolutionParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glConvolutionParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglConvolutionParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glConvolutionParameterf(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glConvolutionParameterf;
        BufferChecks.checkFunctionAddress(j);
        nglConvolutionParameterf(i3, i4, f2, j);
    }

    public static void glConvolutionParameteri(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glConvolutionParameteri;
        BufferChecks.checkFunctionAddress(j);
        nglConvolutionParameteri(i4, i5, i6, j);
    }

    public static void glCopyColorSubTable(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glCopyColorSubTable;
        BufferChecks.checkFunctionAddress(j);
        nglCopyColorSubTable(i6, i7, i8, i9, i10, j);
    }

    public static void glCopyColorTable(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glCopyColorTable;
        BufferChecks.checkFunctionAddress(j);
        nglCopyColorTable(i6, i7, i8, i9, i10, j);
    }

    public static void glCopyConvolutionFilter1D(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glCopyConvolutionFilter1D;
        BufferChecks.checkFunctionAddress(j);
        nglCopyConvolutionFilter1D(i6, i7, i8, i9, i10, j);
    }

    public static void glCopyConvolutionFilter2D(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glCopyConvolutionFilter2D;
        BufferChecks.checkFunctionAddress(j);
        nglCopyConvolutionFilter2D(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glGetColorTable(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetColorTable;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 256);
        nglGetColorTable(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetColorTable(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetColorTable;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 256);
        nglGetColorTable(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetColorTable(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetColorTable;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 256);
        nglGetColorTable(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetColorTableParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetColorTableParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetColorTableParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetColorTableParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetColorTableParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetColorTableParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetConvolutionFilter(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetConvolutionFilter;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetConvolutionFilterBO(i4, i5, i6, j2, j3);
    }

    public static void glGetConvolutionFilter(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetConvolutionFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetConvolutionFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetConvolutionFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetConvolutionFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetConvolutionFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetConvolutionFilter(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetConvolutionFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetConvolutionFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetConvolutionFilter(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetConvolutionFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetConvolutionFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetConvolutionFilter(int i, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetConvolutionFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetConvolutionFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetConvolutionParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetConvolutionParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetConvolutionParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetConvolutionParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetConvolutionParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetConvolutionParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetHistogram(int i, boolean z, int i2, int i3, long j) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetHistogram;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetHistogramBO(i4, z2, i5, i6, j2, j3);
    }

    public static void glGetHistogram(int i, boolean z, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetHistogram;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, 256);
        nglGetHistogram(i4, z2, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetHistogram(int i, boolean z, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetHistogram;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, 256);
        nglGetHistogram(i4, z2, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetHistogram(int i, boolean z, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetHistogram;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, 256);
        nglGetHistogram(i4, z2, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetHistogram(int i, boolean z, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetHistogram;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, 256);
        nglGetHistogram(i4, z2, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetHistogram(int i, boolean z, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetHistogram;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, 256);
        nglGetHistogram(i4, z2, i5, i6, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetHistogramParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetHistogramParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 256);
        nglGetHistogramParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetHistogramParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetHistogramParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 256);
        nglGetHistogramParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMinmax(int i, boolean z, int i2, int i3, long j) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetMinmax;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetMinmaxBO(i4, z2, i5, i6, j2, j3);
    }

    public static void glGetMinmax(int i, boolean z, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMinmax;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglGetMinmax(i4, z2, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetMinmax(int i, boolean z, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMinmax;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetMinmax(i4, z2, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetMinmax(int i, boolean z, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMinmax;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMinmax(i4, z2, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMinmax(int i, boolean z, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMinmax;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMinmax(i4, z2, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMinmax(int i, boolean z, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMinmax;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, 4);
        nglGetMinmax(i4, z2, i5, i6, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetMinmaxParameter(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMinmaxParameterfv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMinmaxParameterfv(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMinmaxParameter(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMinmaxParameteriv;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMinmaxParameteriv(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, long j, long j2, long j3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j7 = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j7);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetSeparableFilterBO(i4, i5, i6, j4, j5, j6, j7);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer4 = byteBuffer;
        ByteBuffer byteBuffer5 = byteBuffer2;
        ByteBuffer byteBuffer6 = byteBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(byteBuffer5);
        BufferChecks.checkDirect(byteBuffer6);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(byteBuffer5), MemoryUtil.getAddress(byteBuffer6), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, DoubleBuffer doubleBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer4 = doubleBuffer;
        DoubleBuffer doubleBuffer5 = doubleBuffer2;
        DoubleBuffer doubleBuffer6 = doubleBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(doubleBuffer5);
        BufferChecks.checkDirect(doubleBuffer6);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer4), MemoryUtil.getAddress(doubleBuffer5), MemoryUtil.getAddress(doubleBuffer6), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(intBuffer5);
        BufferChecks.checkDirect(intBuffer6);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(intBuffer2);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetSeparableFilter(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, ShortBuffer shortBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer4 = shortBuffer;
        ShortBuffer shortBuffer5 = shortBuffer2;
        ShortBuffer shortBuffer6 = shortBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetSeparableFilter;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(shortBuffer5);
        BufferChecks.checkDirect(shortBuffer6);
        nglGetSeparableFilter(i4, i5, i6, MemoryUtil.getAddress(shortBuffer4), MemoryUtil.getAddress(shortBuffer5), MemoryUtil.getAddress(shortBuffer6), j);
    }

    public static void glHistogram(int i, int i2, int i3, boolean z) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glHistogram;
        BufferChecks.checkFunctionAddress(j);
        nglHistogram(i4, i5, i6, z2, j);
    }

    public static void glMinmax(int i, int i2, boolean z) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        long j = GLContext.getCapabilities().glMinmax;
        BufferChecks.checkFunctionAddress(j);
        nglMinmax(i3, i4, z2, j);
    }

    public static void glResetHistogram(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glResetHistogram;
        BufferChecks.checkFunctionAddress(j);
        nglResetHistogram(i2, j);
    }

    public static void glResetMinmax(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glResetMinmax;
        BufferChecks.checkFunctionAddress(j);
        nglResetMinmax(i2, j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j3 = j;
        long j4 = j2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j5 = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j5);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglSeparableFilter2DBO(i7, i8, i9, i10, i11, i12, j3, j4, j5);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer, ShortBuffer shortBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, DoubleBuffer doubleBuffer, IntBuffer intBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(floatBuffer3), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer, IntBuffer intBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer, ShortBuffer shortBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer, DoubleBuffer doubleBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer, FloatBuffer floatBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer, ShortBuffer shortBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer, FloatBuffer floatBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSeparableFilter2D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglSeparableFilter2D(i7, i8, i9, i10, i11, i12, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    static native void nglColorSubTable(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglColorSubTableBO(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglColorTable(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglColorTableBO(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglColorTableParameterfv(int i, int i2, long j, long j2);

    static native void nglColorTableParameteriv(int i, int i2, long j, long j2);

    static native void nglConvolutionFilter1D(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglConvolutionFilter1DBO(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglConvolutionFilter2D(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglConvolutionFilter2DBO(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglConvolutionParameterf(int i, int i2, float f, long j);

    static native void nglConvolutionParameterfv(int i, int i2, long j, long j2);

    static native void nglConvolutionParameteri(int i, int i2, int i3, long j);

    static native void nglConvolutionParameteriv(int i, int i2, long j, long j2);

    static native void nglCopyColorSubTable(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglCopyColorTable(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglCopyConvolutionFilter1D(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglCopyConvolutionFilter2D(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglGetColorTable(int i, int i2, int i3, long j, long j2);

    static native void nglGetColorTableParameterfv(int i, int i2, long j, long j2);

    static native void nglGetColorTableParameteriv(int i, int i2, long j, long j2);

    static native void nglGetConvolutionFilter(int i, int i2, int i3, long j, long j2);

    static native void nglGetConvolutionFilterBO(int i, int i2, int i3, long j, long j2);

    static native void nglGetConvolutionParameterfv(int i, int i2, long j, long j2);

    static native void nglGetConvolutionParameteriv(int i, int i2, long j, long j2);

    static native void nglGetHistogram(int i, boolean z, int i2, int i3, long j, long j2);

    static native void nglGetHistogramBO(int i, boolean z, int i2, int i3, long j, long j2);

    static native void nglGetHistogramParameterfv(int i, int i2, long j, long j2);

    static native void nglGetHistogramParameteriv(int i, int i2, long j, long j2);

    static native void nglGetMinmax(int i, boolean z, int i2, int i3, long j, long j2);

    static native void nglGetMinmaxBO(int i, boolean z, int i2, int i3, long j, long j2);

    static native void nglGetMinmaxParameterfv(int i, int i2, long j, long j2);

    static native void nglGetMinmaxParameteriv(int i, int i2, long j, long j2);

    static native void nglGetSeparableFilter(int i, int i2, int i3, long j, long j2, long j3, long j4);

    static native void nglGetSeparableFilterBO(int i, int i2, int i3, long j, long j2, long j3, long j4);

    static native void nglHistogram(int i, int i2, int i3, boolean z, long j);

    static native void nglMinmax(int i, int i2, boolean z, long j);

    static native void nglResetHistogram(int i, long j);

    static native void nglResetMinmax(int i, long j);

    static native void nglSeparableFilter2D(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3);

    static native void nglSeparableFilter2DBO(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, long j3);
}
