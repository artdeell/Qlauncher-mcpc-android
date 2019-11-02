package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class ARBMatrixPalette {
    public static final int GL_CURRENT_MATRIX_INDEX_ARB = 34885;
    public static final int GL_CURRENT_PALETTE_MATRIX_ARB = 34883;
    public static final int GL_MATRIX_INDEX_ARRAY_ARB = 34884;
    public static final int GL_MATRIX_INDEX_ARRAY_POINTER_ARB = 34889;
    public static final int GL_MATRIX_INDEX_ARRAY_SIZE_ARB = 34886;
    public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_ARB = 34888;
    public static final int GL_MATRIX_INDEX_ARRAY_TYPE_ARB = 34887;
    public static final int GL_MATRIX_PALETTE_ARB = 34880;
    public static final int GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB = 34881;
    public static final int GL_MAX_PALETTE_MATRICES_ARB = 34882;

    private ARBMatrixPalette() {
    }

    public static void glCurrentPaletteMatrixARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCurrentPaletteMatrixARB;
        BufferChecks.checkFunctionAddress(j);
        nglCurrentPaletteMatrixARB(i2, j);
    }

    public static void glMatrixIndexPointerARB(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMatrixIndexPointerARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglMatrixIndexPointerARBBO(i4, i5, i6, j2, j3);
    }

    public static void glMatrixIndexPointerARB(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMatrixIndexPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = byteBuffer2;
        }
        nglMatrixIndexPointerARB(i3, GL11.GL_UNSIGNED_BYTE, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glMatrixIndexPointerARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMatrixIndexPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = intBuffer2;
        }
        nglMatrixIndexPointerARB(i3, GL11.GL_UNSIGNED_INT, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMatrixIndexPointerARB(int i, int i2, ShortBuffer shortBuffer) {
        int i3 = i;
        int i4 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMatrixIndexPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = shortBuffer2;
        }
        nglMatrixIndexPointerARB(i3, GL11.GL_UNSIGNED_SHORT, i4, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glMatrixIndexuARB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glMatrixIndexubvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglMatrixIndexubvARB(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glMatrixIndexuARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMatrixIndexuivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglMatrixIndexuivARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMatrixIndexuARB(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glMatrixIndexusvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglMatrixIndexusvARB(shortBuffer2.remaining(), MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglCurrentPaletteMatrixARB(int i, long j);

    static native void nglMatrixIndexPointerARB(int i, int i2, int i3, long j, long j2);

    static native void nglMatrixIndexPointerARBBO(int i, int i2, int i3, long j, long j2);

    static native void nglMatrixIndexubvARB(int i, long j, long j2);

    static native void nglMatrixIndexuivARB(int i, long j, long j2);

    static native void nglMatrixIndexusvARB(int i, long j, long j2);
}
