package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBRobustness {
    public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB = 4;
    public static final int GL_GUILTY_CONTEXT_RESET_ARB = 33363;
    public static final int GL_INNOCENT_CONTEXT_RESET_ARB = 33364;
    public static final int GL_LOSE_CONTEXT_ON_RESET_ARB = 33362;
    public static final int GL_NO_ERROR = 0;
    public static final int GL_NO_RESET_NOTIFICATION_ARB = 33377;
    public static final int GL_RESET_NOTIFICATION_STRATEGY_ARB = 33366;
    public static final int GL_UNKNOWN_CONTEXT_RESET_ARB = 33365;

    private ARBRobustness() {
    }

    public static int glGetGraphicsResetStatusARB() {
        long j = GLContext.getCapabilities().glGetGraphicsResetStatusARB;
        BufferChecks.checkFunctionAddress(j);
        return nglGetGraphicsResetStatusARB(j);
    }

    public static void glGetnColorTableARB(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetnColorTableARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnColorTableARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnColorTableARB(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetnColorTableARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnColorTableARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnColorTableARB(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetnColorTableARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnColorTableARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnCompressedTexImageARB(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetnCompressedTexImageARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetnCompressedTexImageARBBO(i4, i5, i6, j2, j3);
    }

    public static void glGetnCompressedTexImageARB(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnCompressedTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnCompressedTexImageARB(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnCompressedTexImageARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnCompressedTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnCompressedTexImageARB(i3, i4, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnCompressedTexImageARB(int i, int i2, ShortBuffer shortBuffer) {
        int i3 = i;
        int i4 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnCompressedTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnCompressedTexImageARB(i3, i4, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnConvolutionFilterARB(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetnConvolutionFilterARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetnConvolutionFilterARBBO(i5, i6, i7, i8, j2, j3);
    }

    public static void glGetnConvolutionFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnConvolutionFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnConvolutionFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnConvolutionFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnConvolutionFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnConvolutionFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnConvolutionFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnConvolutionFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnConvolutionFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnConvolutionFilterARB(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnConvolutionFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnConvolutionFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnConvolutionFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnConvolutionFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnConvolutionFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnHistogramARB(int i, boolean z, int i2, int i3, int i4, long j) {
        int i5 = i;
        boolean z2 = z;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetnHistogramARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetnHistogramARBBO(i5, z2, i6, i7, i8, j2, j3);
    }

    public static void glGetnHistogramARB(int i, boolean z, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnHistogramARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnHistogramARB(i4, z2, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnHistogramARB(int i, boolean z, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnHistogramARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnHistogramARB(i4, z2, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnHistogramARB(int i, boolean z, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnHistogramARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnHistogramARB(i4, z2, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnHistogramARB(int i, boolean z, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnHistogramARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnHistogramARB(i4, z2, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnHistogramARB(int i, boolean z, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnHistogramARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnHistogramARB(i4, z2, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnMapdvARB(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetnMapdvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnMapdvARB(i3, i4, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnMapfvARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetnMapfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnMapfvARB(i3, i4, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnMapivARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetnMapivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnMapivARB(i3, i4, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnMinmaxARB(int i, boolean z, int i2, int i3, int i4, long j) {
        int i5 = i;
        boolean z2 = z;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetnMinmaxARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetnMinmaxARBBO(i5, z2, i6, i7, i8, j2, j3);
    }

    public static void glGetnMinmaxARB(int i, boolean z, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnMinmaxARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnMinmaxARB(i4, z2, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnMinmaxARB(int i, boolean z, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnMinmaxARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnMinmaxARB(i4, z2, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnMinmaxARB(int i, boolean z, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnMinmaxARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnMinmaxARB(i4, z2, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnMinmaxARB(int i, boolean z, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnMinmaxARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnMinmaxARB(i4, z2, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnMinmaxARB(int i, boolean z, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        boolean z2 = z;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnMinmaxARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnMinmaxARB(i4, z2, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnPixelMapfvARB(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetnPixelMapfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnPixelMapfvARB(i2, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnPixelMapuivARB(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetnPixelMapuivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnPixelMapuivARB(i2, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnPixelMapusvARB(int i, ShortBuffer shortBuffer) {
        int i2 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glGetnPixelMapusvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnPixelMapusvARB(i2, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnPolygonStippleARB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetnPolygonStippleARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnPolygonStippleARB(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, int i4, long j, int i5, long j2, long j3) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        long j4 = j;
        int i10 = i5;
        long j5 = j2;
        long j6 = j3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j7 = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j7);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetnSeparableFilterARBBO(i6, i7, i8, i9, j4, i10, j5, j6, j7);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer4 = byteBuffer;
        ByteBuffer byteBuffer5 = byteBuffer2;
        ByteBuffer byteBuffer6 = byteBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(byteBuffer5);
        BufferChecks.checkDirect(byteBuffer6);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer4.remaining(), MemoryUtil.getAddress(byteBuffer4), byteBuffer5.remaining(), MemoryUtil.getAddress(byteBuffer5), MemoryUtil.getAddress(byteBuffer6), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), byteBuffer4.remaining(), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), byteBuffer4.remaining(), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), byteBuffer4.remaining(), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), byteBuffer4.remaining(), MemoryUtil.getAddress(byteBuffer4), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, FloatBuffer floatBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, FloatBuffer floatBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, FloatBuffer floatBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, IntBuffer intBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer3 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ByteBuffer byteBuffer, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), doubleBuffer4.remaining() << 3, MemoryUtil.getAddress(doubleBuffer4), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, DoubleBuffer doubleBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer4 = doubleBuffer;
        DoubleBuffer doubleBuffer5 = doubleBuffer2;
        DoubleBuffer doubleBuffer6 = doubleBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(doubleBuffer5);
        BufferChecks.checkDirect(doubleBuffer6);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer4.remaining() << 3, MemoryUtil.getAddress(doubleBuffer4), doubleBuffer5.remaining() << 3, MemoryUtil.getAddress(doubleBuffer5), MemoryUtil.getAddress(doubleBuffer6), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), doubleBuffer4.remaining() << 3, MemoryUtil.getAddress(doubleBuffer4), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), doubleBuffer4.remaining() << 3, MemoryUtil.getAddress(doubleBuffer4), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), doubleBuffer4.remaining() << 3, MemoryUtil.getAddress(doubleBuffer4), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, IntBuffer intBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, FloatBuffer floatBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer3 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ByteBuffer byteBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer3 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), floatBuffer4.remaining() << 2, MemoryUtil.getAddress(floatBuffer4), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), floatBuffer4.remaining() << 2, MemoryUtil.getAddress(floatBuffer4), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, FloatBuffer floatBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer4 = floatBuffer;
        FloatBuffer floatBuffer5 = floatBuffer2;
        FloatBuffer floatBuffer6 = floatBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer4);
        BufferChecks.checkDirect(floatBuffer5);
        BufferChecks.checkDirect(floatBuffer6);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer4.remaining() << 2, MemoryUtil.getAddress(floatBuffer4), floatBuffer5.remaining() << 2, MemoryUtil.getAddress(floatBuffer5), MemoryUtil.getAddress(floatBuffer6), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), floatBuffer4.remaining() << 2, MemoryUtil.getAddress(floatBuffer4), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), floatBuffer4.remaining() << 2, MemoryUtil.getAddress(floatBuffer4), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, FloatBuffer floatBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer3 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, IntBuffer intBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, FloatBuffer floatBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer3 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, FloatBuffer floatBuffer, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ByteBuffer byteBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, FloatBuffer floatBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, FloatBuffer floatBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, FloatBuffer floatBuffer, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), intBuffer4.remaining() << 2, MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), intBuffer4.remaining() << 2, MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), intBuffer4.remaining() << 2, MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer4 = intBuffer;
        IntBuffer intBuffer5 = intBuffer2;
        IntBuffer intBuffer6 = intBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(intBuffer5);
        BufferChecks.checkDirect(intBuffer6);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer4.remaining() << 2, MemoryUtil.getAddress(intBuffer4), intBuffer5.remaining() << 2, MemoryUtil.getAddress(intBuffer5), MemoryUtil.getAddress(intBuffer6), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), intBuffer4.remaining() << 2, MemoryUtil.getAddress(intBuffer4), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, IntBuffer intBuffer, ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ByteBuffer byteBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        DoubleBuffer doubleBuffer4 = doubleBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer3);
        BufferChecks.checkDirect(doubleBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), doubleBuffer3.remaining() << 3, MemoryUtil.getAddress(doubleBuffer3), MemoryUtil.getAddress(doubleBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, DoubleBuffer doubleBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(doubleBuffer2);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, FloatBuffer floatBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, FloatBuffer floatBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer3);
        BufferChecks.checkDirect(floatBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), floatBuffer3.remaining() << 2, MemoryUtil.getAddress(floatBuffer3), MemoryUtil.getAddress(floatBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, FloatBuffer floatBuffer, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, FloatBuffer floatBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(floatBuffer2);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkDirect(intBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), intBuffer3.remaining() << 2, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, IntBuffer intBuffer, ShortBuffer shortBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkDirect(shortBuffer4);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(shortBuffer4), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), shortBuffer4.remaining() << 1, MemoryUtil.getAddress(shortBuffer4), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), shortBuffer4.remaining() << 1, MemoryUtil.getAddress(shortBuffer4), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), shortBuffer4.remaining() << 1, MemoryUtil.getAddress(shortBuffer4), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer3 = shortBuffer;
        ShortBuffer shortBuffer4 = shortBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer3);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer3.remaining() << 1, MemoryUtil.getAddress(shortBuffer3), shortBuffer4.remaining() << 1, MemoryUtil.getAddress(shortBuffer4), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnSeparableFilterARB(int i, int i2, int i3, ShortBuffer shortBuffer, ShortBuffer shortBuffer2, ShortBuffer shortBuffer3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer4 = shortBuffer;
        ShortBuffer shortBuffer5 = shortBuffer2;
        ShortBuffer shortBuffer6 = shortBuffer3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnSeparableFilterARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer4);
        BufferChecks.checkDirect(shortBuffer5);
        BufferChecks.checkDirect(shortBuffer6);
        nglGetnSeparableFilterARB(i4, i5, i6, shortBuffer4.remaining() << 1, MemoryUtil.getAddress(shortBuffer4), shortBuffer5.remaining() << 1, MemoryUtil.getAddress(shortBuffer5), MemoryUtil.getAddress(shortBuffer6), j);
    }

    public static void glGetnTexImageARB(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetnTexImageARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetnTexImageARBBO(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glGetnTexImageARB(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetnTexImageARB(i5, i6, i7, i8, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetnTexImageARB(int i, int i2, int i3, int i4, DoubleBuffer doubleBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnTexImageARB(i5, i6, i7, i8, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnTexImageARB(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnTexImageARB(i5, i6, i7, i8, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnTexImageARB(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnTexImageARB(i5, i6, i7, i8, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnTexImageARB(int i, int i2, int i3, int i4, ShortBuffer shortBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetnTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetnTexImageARB(i5, i6, i7, i8, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetnUniformdvARB(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetnUniformdvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetnUniformdvARB(i3, i4, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetnUniformfvARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetnUniformfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetnUniformfvARB(i3, i4, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetnUniformivARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetnUniformivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnUniformivARB(i3, i4, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetnUniformuivARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetnUniformuivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetnUniformuivARB(i3, i4, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glReadnPixelsARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glReadnPixelsARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglReadnPixelsARBBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glReadnPixelsARB(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadnPixelsARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglReadnPixelsARB(i7, i8, i9, i10, i11, i12, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glReadnPixelsARB(int i, int i2, int i3, int i4, int i5, int i6, DoubleBuffer doubleBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadnPixelsARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglReadnPixelsARB(i7, i8, i9, i10, i11, i12, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glReadnPixelsARB(int i, int i2, int i3, int i4, int i5, int i6, FloatBuffer floatBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadnPixelsARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglReadnPixelsARB(i7, i8, i9, i10, i11, i12, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glReadnPixelsARB(int i, int i2, int i3, int i4, int i5, int i6, IntBuffer intBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadnPixelsARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglReadnPixelsARB(i7, i8, i9, i10, i11, i12, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glReadnPixelsARB(int i, int i2, int i3, int i4, int i5, int i6, ShortBuffer shortBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glReadnPixelsARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglReadnPixelsARB(i7, i8, i9, i10, i11, i12, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native int nglGetGraphicsResetStatusARB(long j);

    static native void nglGetnColorTableARB(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetnCompressedTexImageARB(int i, int i2, int i3, long j, long j2);

    static native void nglGetnCompressedTexImageARBBO(int i, int i2, int i3, long j, long j2);

    static native void nglGetnConvolutionFilterARB(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetnConvolutionFilterARBBO(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetnHistogramARB(int i, boolean z, int i2, int i3, int i4, long j, long j2);

    static native void nglGetnHistogramARBBO(int i, boolean z, int i2, int i3, int i4, long j, long j2);

    static native void nglGetnMapdvARB(int i, int i2, int i3, long j, long j2);

    static native void nglGetnMapfvARB(int i, int i2, int i3, long j, long j2);

    static native void nglGetnMapivARB(int i, int i2, int i3, long j, long j2);

    static native void nglGetnMinmaxARB(int i, boolean z, int i2, int i3, int i4, long j, long j2);

    static native void nglGetnMinmaxARBBO(int i, boolean z, int i2, int i3, int i4, long j, long j2);

    static native void nglGetnPixelMapfvARB(int i, int i2, long j, long j2);

    static native void nglGetnPixelMapuivARB(int i, int i2, long j, long j2);

    static native void nglGetnPixelMapusvARB(int i, int i2, long j, long j2);

    static native void nglGetnPolygonStippleARB(int i, long j, long j2);

    static native void nglGetnSeparableFilterARB(int i, int i2, int i3, int i4, long j, int i5, long j2, long j3, long j4);

    static native void nglGetnSeparableFilterARBBO(int i, int i2, int i3, int i4, long j, int i5, long j2, long j3, long j4);

    static native void nglGetnTexImageARB(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglGetnTexImageARBBO(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglGetnUniformdvARB(int i, int i2, int i3, long j, long j2);

    static native void nglGetnUniformfvARB(int i, int i2, int i3, long j, long j2);

    static native void nglGetnUniformivARB(int i, int i2, int i3, long j, long j2);

    static native void nglGetnUniformuivARB(int i, int i2, int i3, long j, long j2);

    static native void nglReadnPixelsARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglReadnPixelsARBBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);
}
