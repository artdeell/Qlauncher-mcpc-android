package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class EXTDirectStateAccess {
    public static final int GL_PROGRAM_MATRIX_EXT = 36397;
    public static final int GL_PROGRAM_MATRIX_STACK_DEPTH_EXT = 36399;
    public static final int GL_TRANSPOSE_PROGRAM_MATRIX_EXT = 36398;

    private EXTDirectStateAccess() {
    }

    public static void glBindMultiTextureEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBindMultiTextureEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBindMultiTextureEXT(i4, i5, i6, j);
    }

    public static int glCheckNamedFramebufferStatusEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glCheckNamedFramebufferStatusEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglCheckNamedFramebufferStatusEXT(i3, i4, j);
    }

    public static void glClientAttribDefaultEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glClientAttribDefaultEXT;
        BufferChecks.checkFunctionAddress(j);
        nglClientAttribDefaultEXT(i2, j);
    }

    public static void glCompressedMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedMultiTexImage1DEXTBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glCompressedMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedMultiTexImage1DEXT(i7, i8, i9, i10, i11, i12, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
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
        long j3 = capabilities.glCompressedMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedMultiTexImage2DEXTBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glCompressedMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedMultiTexImage2DEXT(i8, i9, i10, i11, i12, i13, i14, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedMultiTexImage3DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedMultiTexImage3DEXTBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glCompressedMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedMultiTexImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedMultiTexImage3DEXT(i9, i10, i11, i12, i13, i14, i15, i16, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedMultiTexSubImage1DEXTBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glCompressedMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedMultiTexSubImage1DEXT(i7, i8, i9, i10, i11, i12, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedMultiTexSubImage2DEXTBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glCompressedMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedMultiTexSubImage2DEXT(i9, i10, i11, i12, i13, i14, i15, i16, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedMultiTexSubImage3DEXTBO(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, j2, j3);
    }

    public static void glCompressedMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ByteBuffer byteBuffer) {
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
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedMultiTexSubImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTextureImage1DEXTBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glCompressedTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTextureImage1DEXT(i7, i8, i9, i10, i11, i12, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
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
        long j3 = capabilities.glCompressedTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTextureImage2DEXTBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glCompressedTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTextureImage2DEXT(i8, i9, i10, i11, i12, i13, i14, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTextureImage3DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTextureImage3DEXTBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glCompressedTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTextureImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTextureImage3DEXT(i9, i10, i11, i12, i13, i14, i15, i16, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTextureSubImage1DEXTBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glCompressedTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTextureSubImage1DEXT(i7, i8, i9, i10, i11, i12, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTextureSubImage2DEXTBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glCompressedTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTextureSubImage2DEXT(i9, i10, i11, i12, i13, i14, i15, i16, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTextureSubImage3DEXTBO(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, j2, j3);
    }

    public static void glCompressedTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ByteBuffer byteBuffer) {
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
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTextureSubImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCopyMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j = GLContext.getCapabilities().glCopyMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyMultiTexImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, j);
    }

    public static void glCopyMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j = GLContext.getCapabilities().glCopyMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyMultiTexImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, j);
    }

    public static void glCopyMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j = GLContext.getCapabilities().glCopyMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyMultiTexSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, j);
    }

    public static void glCopyMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j = GLContext.getCapabilities().glCopyMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyMultiTexSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, j);
    }

    public static void glCopyMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
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
        long j = GLContext.getCapabilities().glCopyMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyMultiTexSubImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j);
    }

    public static void glCopyTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        long j = GLContext.getCapabilities().glCopyTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTextureImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, j);
    }

    public static void glCopyTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j = GLContext.getCapabilities().glCopyTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTextureImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, j);
    }

    public static void glCopyTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j = GLContext.getCapabilities().glCopyTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTextureSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, j);
    }

    public static void glCopyTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j = GLContext.getCapabilities().glCopyTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTextureSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, j);
    }

    public static void glCopyTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
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
        long j = GLContext.getCapabilities().glCopyTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTextureSubImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j);
    }

    public static void glDisableClientStateIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDisableClientStateIndexedEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDisableClientStateIndexedEXT(i3, i4, j);
    }

    public static void glDisableClientStateiEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDisableClientStateiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDisableClientStateiEXT(i3, i4, j);
    }

    public static void glDisableIndexedEXT(int i, int i2) {
        EXTDrawBuffers2.glDisableIndexedEXT(i, i2);
    }

    public static void glDisableVertexArrayAttribEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDisableVertexArrayAttribEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDisableVertexArrayAttribEXT(i3, i4, j);
    }

    public static void glDisableVertexArrayEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDisableVertexArrayEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDisableVertexArrayEXT(i3, i4, j);
    }

    public static void glEnableClientStateIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEnableClientStateIndexedEXT;
        BufferChecks.checkFunctionAddress(j);
        nglEnableClientStateIndexedEXT(i3, i4, j);
    }

    public static void glEnableClientStateiEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEnableClientStateiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglEnableClientStateiEXT(i3, i4, j);
    }

    public static void glEnableIndexedEXT(int i, int i2) {
        EXTDrawBuffers2.glEnableIndexedEXT(i, i2);
    }

    public static void glEnableVertexArrayAttribEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEnableVertexArrayAttribEXT;
        BufferChecks.checkFunctionAddress(j);
        nglEnableVertexArrayAttribEXT(i3, i4, j);
    }

    public static void glEnableVertexArrayEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEnableVertexArrayEXT;
        BufferChecks.checkFunctionAddress(j);
        nglEnableVertexArrayEXT(i3, i4, j);
    }

    public static void glFlushMappedNamedBufferRangeEXT(int i, long j, long j2) {
        int i2 = i;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glFlushMappedNamedBufferRangeEXT;
        BufferChecks.checkFunctionAddress(j5);
        nglFlushMappedNamedBufferRangeEXT(i2, j3, j4, j5);
    }

    public static void glFramebufferDrawBufferEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glFramebufferDrawBufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferDrawBufferEXT(i3, i4, j);
    }

    public static void glFramebufferDrawBuffersEXT(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glFramebufferDrawBuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglFramebufferDrawBuffersEXT(i2, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glFramebufferReadBufferEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glFramebufferReadBufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferReadBufferEXT(i3, i4, j);
    }

    public static void glGenerateMultiTexMipmapEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glGenerateMultiTexMipmapEXT;
        BufferChecks.checkFunctionAddress(j);
        nglGenerateMultiTexMipmapEXT(i3, i4, j);
    }

    public static void glGenerateTextureMipmapEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glGenerateTextureMipmapEXT;
        BufferChecks.checkFunctionAddress(j);
        nglGenerateTextureMipmapEXT(i3, i4, j);
    }

    public static void glGetBooleanIndexedEXT(int i, int i2, ByteBuffer byteBuffer) {
        EXTDrawBuffers2.glGetBooleanIndexedEXT(i, i2, byteBuffer);
    }

    public static boolean glGetBooleanIndexedEXT(int i, int i2) {
        return EXTDrawBuffers2.glGetBooleanIndexedEXT(i, i2);
    }

    public static void glGetCompressedMultiTexImageEXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetCompressedMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetCompressedMultiTexImageEXTBO(i4, i5, i6, j2, j3);
    }

    public static void glGetCompressedMultiTexImageEXT(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetCompressedMultiTexImageEXT(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetCompressedMultiTexImageEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetCompressedMultiTexImageEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetCompressedMultiTexImageEXT(int i, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetCompressedMultiTexImageEXT(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetCompressedTextureImageEXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetCompressedTextureImageEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetCompressedTextureImageEXTBO(i4, i5, i6, j2, j3);
    }

    public static void glGetCompressedTextureImageEXT(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedTextureImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetCompressedTextureImageEXT(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetCompressedTextureImageEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedTextureImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglGetCompressedTextureImageEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetCompressedTextureImageEXT(int i, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedTextureImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetCompressedTextureImageEXT(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static double glGetDoubleEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetDoublei_vEXT;
        BufferChecks.checkFunctionAddress(j);
        DoubleBuffer bufferDouble = APIUtil.getBufferDouble(capabilities);
        nglGetDoublei_vEXT(i3, i4, MemoryUtil.getAddress(bufferDouble), j);
        return bufferDouble.get(0);
    }

    public static void glGetDoubleEXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetDoublei_vEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglGetDoublei_vEXT(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static double glGetDoubleIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetDoubleIndexedvEXT;
        BufferChecks.checkFunctionAddress(j);
        DoubleBuffer bufferDouble = APIUtil.getBufferDouble(capabilities);
        nglGetDoubleIndexedvEXT(i3, i4, MemoryUtil.getAddress(bufferDouble), j);
        return bufferDouble.get(0);
    }

    public static void glGetDoubleIndexedEXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetDoubleIndexedvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglGetDoubleIndexedvEXT(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static float glGetFloatEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFloati_vEXT;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetFloati_vEXT(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static void glGetFloatEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetFloati_vEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglGetFloati_vEXT(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static float glGetFloatIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFloatIndexedvEXT;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetFloatIndexedvEXT(i3, i4, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static void glGetFloatIndexedEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetFloatIndexedvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglGetFloatIndexedvEXT(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static int glGetFramebufferParameterEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFramebufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetFramebufferParameterivEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetFramebufferParameterEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetFramebufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetFramebufferParameterivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetIntegerIndexedEXT(int i, int i2) {
        return EXTDrawBuffers2.glGetIntegerIndexedEXT(i, i2);
    }

    public static void glGetIntegerIndexedEXT(int i, int i2, IntBuffer intBuffer) {
        EXTDrawBuffers2.glGetIntegerIndexedEXT(i, i2, intBuffer);
    }

    public static void glGetMultiTexEnvEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexEnvfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMultiTexEnvfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMultiTexEnvEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexEnvivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMultiTexEnvivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMultiTexGenEXT(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexGendvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetMultiTexGendvEXT(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetMultiTexGenEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexGenfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMultiTexGenfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMultiTexGenEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexGenivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMultiTexGenivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMultiTexImageEXT(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetMultiTexImageEXTBO(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glGetMultiTexImageEXT(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i9, i10, 1, 1, 1));
        nglGetMultiTexImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetMultiTexImageEXT(int i, int i2, int i3, int i4, int i5, DoubleBuffer doubleBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i9, i10, 1, 1, 1));
        nglGetMultiTexImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetMultiTexImageEXT(int i, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i9, i10, 1, 1, 1));
        nglGetMultiTexImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMultiTexImageEXT(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i9, i10, 1, 1, 1));
        nglGetMultiTexImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMultiTexImageEXT(int i, int i2, int i3, int i4, int i5, ShortBuffer shortBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i9, i10, 1, 1, 1));
        nglGetMultiTexImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetMultiTexLevelParameterEXT(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexLevelParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMultiTexLevelParameterfvEXT(i5, i6, i7, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMultiTexLevelParameterEXT(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexLevelParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMultiTexLevelParameterivEXT(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetMultiTexLevelParameterfEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexLevelParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetMultiTexLevelParameterfvEXT(i5, i6, i7, i8, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetMultiTexLevelParameteriEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexLevelParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetMultiTexLevelParameterivEXT(i5, i6, i7, i8, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetMultiTexParameterEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetMultiTexParameterfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetMultiTexParameterEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMultiTexParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetMultiTexParameterIEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMultiTexParameterIivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetMultiTexParameterIiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetMultiTexParameterIivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetMultiTexParameterIuEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetMultiTexParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetMultiTexParameterIuivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetMultiTexParameterIuiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetMultiTexParameterIuivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static float glGetMultiTexParameterfEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetMultiTexParameterfvEXT(i4, i5, i6, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetMultiTexParameteriEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetMultiTexParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetMultiTexParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glGetNamedBufferParameterEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedBufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetNamedBufferParameterivEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetNamedBufferParameterEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetNamedBufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetNamedBufferParameterivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static ByteBuffer glGetNamedBufferPointerEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedBufferPointervEXT;
        BufferChecks.checkFunctionAddress(j);
        ByteBuffer nglGetNamedBufferPointervEXT = nglGetNamedBufferPointervEXT(i3, i4, (long) GLChecks.getNamedBufferObjectSize(capabilities, i3), j);
        if (!LWJGLUtil.CHECKS || nglGetNamedBufferPointervEXT != null) {
            return nglGetNamedBufferPointervEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glGetNamedBufferSubDataEXT(int i, long j, ByteBuffer byteBuffer) {
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glGetNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetNamedBufferSubDataEXT(i2, j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j3);
    }

    public static void glGetNamedBufferSubDataEXT(int i, long j, DoubleBuffer doubleBuffer) {
        int i2 = i;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j3 = GLContext.getCapabilities().glGetNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetNamedBufferSubDataEXT(i2, j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), j3);
    }

    public static void glGetNamedBufferSubDataEXT(int i, long j, FloatBuffer floatBuffer) {
        int i2 = i;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j3 = GLContext.getCapabilities().glGetNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetNamedBufferSubDataEXT(i2, j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), j3);
    }

    public static void glGetNamedBufferSubDataEXT(int i, long j, IntBuffer intBuffer) {
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = GLContext.getCapabilities().glGetNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer2);
        nglGetNamedBufferSubDataEXT(i2, j2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), j3);
    }

    public static void glGetNamedBufferSubDataEXT(int i, long j, ShortBuffer shortBuffer) {
        int i2 = i;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j3 = GLContext.getCapabilities().glGetNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetNamedBufferSubDataEXT(i2, j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), j3);
    }

    public static int glGetNamedFramebufferAttachmentParameterEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedFramebufferAttachmentParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetNamedFramebufferAttachmentParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetNamedFramebufferAttachmentParameterEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetNamedFramebufferAttachmentParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetNamedFramebufferAttachmentParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetNamedProgramEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedProgramivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetNamedProgramivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetNamedProgramEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetNamedProgramivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetNamedProgramivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetNamedProgramLocalParameterEXT(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetNamedProgramLocalParameterdvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetNamedProgramLocalParameterdvEXT(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetNamedProgramLocalParameterEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetNamedProgramLocalParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetNamedProgramLocalParameterfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetNamedProgramLocalParameterIEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetNamedProgramLocalParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetNamedProgramLocalParameterIivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetNamedProgramLocalParameterIuEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetNamedProgramLocalParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetNamedProgramLocalParameterIuivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static String glGetNamedProgramStringEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedProgramStringEXT;
        BufferChecks.checkFunctionAddress(j);
        int glGetNamedProgramEXT = glGetNamedProgramEXT(i4, i5, 34343);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, glGetNamedProgramEXT);
        nglGetNamedProgramStringEXT(i4, i5, i6, MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(glGetNamedProgramEXT);
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetNamedProgramStringEXT(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetNamedProgramStringEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetNamedProgramStringEXT(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetNamedRenderbufferParameterEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedRenderbufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetNamedRenderbufferParameterivEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetNamedRenderbufferParameterEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetNamedRenderbufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetNamedRenderbufferParameterivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static ByteBuffer glGetPointerEXT(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetPointeri_vEXT;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetPointeri_vEXT = nglGetPointeri_vEXT(i3, i4, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetPointeri_vEXT != null) {
            return nglGetPointeri_vEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static ByteBuffer glGetPointerIndexedEXT(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetPointerIndexedvEXT;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetPointerIndexedvEXT = nglGetPointerIndexedvEXT(i3, i4, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetPointerIndexedvEXT != null) {
            return nglGetPointerIndexedvEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glGetTextureImageEXT(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetTextureImageEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetTextureImageEXTBO(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glGetTextureImageEXT(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i9, i10, 1, 1, 1));
        nglGetTextureImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetTextureImageEXT(int i, int i2, int i3, int i4, int i5, DoubleBuffer doubleBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i9, i10, 1, 1, 1));
        nglGetTextureImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetTextureImageEXT(int i, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i9, i10, 1, 1, 1));
        nglGetTextureImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTextureImageEXT(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i9, i10, 1, 1, 1));
        nglGetTextureImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetTextureImageEXT(int i, int i2, int i3, int i4, int i5, ShortBuffer shortBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureImageEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i9, i10, 1, 1, 1));
        nglGetTextureImageEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetTextureLevelParameterEXT(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetTextureLevelParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetTextureLevelParameterfvEXT(i5, i6, i7, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTextureLevelParameterEXT(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTextureLevelParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTextureLevelParameterivEXT(i5, i6, i7, i8, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static float glGetTextureLevelParameterfEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureLevelParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetTextureLevelParameterfvEXT(i5, i6, i7, i8, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetTextureLevelParameteriEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureLevelParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTextureLevelParameterivEXT(i5, i6, i7, i8, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetTextureParameterEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetTextureParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetTextureParameterfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetTextureParameterEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTextureParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTextureParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetTextureParameterIEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTextureParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTextureParameterIivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetTextureParameterIiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTextureParameterIivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetTextureParameterIuEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTextureParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTextureParameterIuivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetTextureParameterIuiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTextureParameterIuivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static float glGetTextureParameterfEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        FloatBuffer bufferFloat = APIUtil.getBufferFloat(capabilities);
        nglGetTextureParameterfvEXT(i4, i5, i6, MemoryUtil.getAddress(bufferFloat), j);
        return bufferFloat.get(0);
    }

    public static int glGetTextureParameteriEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTextureParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTextureParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glGetVertexArrayIntegerEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVertexArrayIntegervEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetVertexArrayIntegervEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetVertexArrayIntegerEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexArrayIntegeri_vEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 16);
        nglGetVertexArrayIntegeri_vEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetVertexArrayIntegerEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVertexArrayIntegervEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 16);
        nglGetVertexArrayIntegervEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetVertexArrayIntegeriEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetVertexArrayIntegeri_vEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetVertexArrayIntegeri_vEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static ByteBuffer glGetVertexArrayPointerEXT(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetVertexArrayPointervEXT;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetVertexArrayPointervEXT = nglGetVertexArrayPointervEXT(i3, i4, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetVertexArrayPointervEXT != null) {
            return nglGetVertexArrayPointervEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static ByteBuffer glGetVertexArrayPointeri_EXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glGetVertexArrayPointeri_vEXT;
        BufferChecks.checkFunctionAddress(j3);
        ByteBuffer nglGetVertexArrayPointeri_vEXT = nglGetVertexArrayPointeri_vEXT(i4, i5, i6, j2, j3);
        if (!LWJGLUtil.CHECKS || nglGetVertexArrayPointeri_vEXT != null) {
            return nglGetVertexArrayPointeri_vEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static boolean glIsEnabledIndexedEXT(int i, int i2) {
        return EXTDrawBuffers2.glIsEnabledIndexedEXT(i, i2);
    }

    public static ByteBuffer glMapNamedBufferEXT(int i, int i2, long j, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glMapNamedBufferEXT;
        BufferChecks.checkFunctionAddress(j3);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapNamedBufferEXT = nglMapNamedBufferEXT(i3, i4, j2, byteBuffer2, j3);
        if (!LWJGLUtil.CHECKS || nglMapNamedBufferEXT != null) {
            return nglMapNamedBufferEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static ByteBuffer glMapNamedBufferEXT(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMapNamedBufferEXT;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapNamedBufferEXT = nglMapNamedBufferEXT(i3, i4, (long) GLChecks.getNamedBufferObjectSize(capabilities, i3), byteBuffer2, j);
        if (!LWJGLUtil.CHECKS || nglMapNamedBufferEXT != null) {
            return nglMapNamedBufferEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static ByteBuffer glMapNamedBufferRangeEXT(int i, long j, long j2, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        long j3 = j;
        long j4 = j2;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j5 = GLContext.getCapabilities().glMapNamedBufferRangeEXT;
        BufferChecks.checkFunctionAddress(j5);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        ByteBuffer nglMapNamedBufferRangeEXT = nglMapNamedBufferRangeEXT(i3, j3, j4, i4, byteBuffer2, j5);
        if (!LWJGLUtil.CHECKS || nglMapNamedBufferRangeEXT != null) {
            return nglMapNamedBufferRangeEXT.order(ByteOrder.nativeOrder());
        }
        return null;
    }

    public static void glMatrixFrustumEXT(int i, double d, double d2, double d3, double d4, double d5, double d6) {
        int i2 = i;
        double d7 = d;
        double d8 = d2;
        double d9 = d3;
        double d10 = d4;
        double d11 = d5;
        double d12 = d6;
        long j = GLContext.getCapabilities().glMatrixFrustumEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixFrustumEXT(i2, d7, d8, d9, d10, d11, d12, j);
    }

    public static void glMatrixLoadEXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMatrixLoaddEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglMatrixLoaddEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMatrixLoadEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMatrixLoadfEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglMatrixLoadfEXT(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMatrixLoadIdentityEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glMatrixLoadIdentityEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixLoadIdentityEXT(i2, j);
    }

    public static void glMatrixLoadTransposeEXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMatrixLoadTransposedEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglMatrixLoadTransposedEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMatrixLoadTransposeEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMatrixLoadTransposefEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglMatrixLoadTransposefEXT(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMatrixMultEXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMatrixMultdEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglMatrixMultdEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMatrixMultEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMatrixMultfEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglMatrixMultfEXT(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMatrixMultTransposeEXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMatrixMultTransposedEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 16);
        nglMatrixMultTransposedEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMatrixMultTransposeEXT(int i, FloatBuffer floatBuffer) {
        int i2 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMatrixMultTransposefEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglMatrixMultTransposefEXT(i2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMatrixOrthoEXT(int i, double d, double d2, double d3, double d4, double d5, double d6) {
        int i2 = i;
        double d7 = d;
        double d8 = d2;
        double d9 = d3;
        double d10 = d4;
        double d11 = d5;
        double d12 = d6;
        long j = GLContext.getCapabilities().glMatrixOrthoEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixOrthoEXT(i2, d7, d8, d9, d10, d11, d12, j);
    }

    public static void glMatrixPopEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glMatrixPopEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixPopEXT(i2, j);
    }

    public static void glMatrixPushEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glMatrixPushEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixPushEXT(i2, j);
    }

    public static void glMatrixRotatedEXT(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glMatrixRotatedEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixRotatedEXT(i2, d5, d6, d7, d8, j);
    }

    public static void glMatrixRotatefEXT(int i, float f, float f2, float f3, float f4) {
        int i2 = i;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glMatrixRotatefEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixRotatefEXT(i2, f5, f6, f7, f8, j);
    }

    public static void glMatrixScaledEXT(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glMatrixScaledEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixScaledEXT(i2, d4, d5, d6, j);
    }

    public static void glMatrixScalefEXT(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glMatrixScalefEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixScalefEXT(i2, f4, f5, f6, j);
    }

    public static void glMatrixTranslatedEXT(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glMatrixTranslatedEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixTranslatedEXT(i2, d4, d5, d6, j);
    }

    public static void glMatrixTranslatefEXT(int i, float f, float f2, float f3) {
        int i2 = i;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glMatrixTranslatefEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMatrixTranslatefEXT(i2, f4, f5, f6, j);
    }

    public static void glMultiTexBufferEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glMultiTexBufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexBufferEXT(i5, i6, i7, i8, j);
    }

    public static void glMultiTexCoordPointerEXT(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiTexCoordPointerEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglMultiTexCoordPointerEXTBO(i5, i6, i7, i8, j2, j3);
    }

    public static void glMultiTexCoordPointerEXT(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexCoordPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        nglMultiTexCoordPointerEXT(i4, i5, 5130, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMultiTexCoordPointerEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexCoordPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        nglMultiTexCoordPointerEXT(i4, i5, GL11.GL_FLOAT, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultiTexEnvEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMultiTexEnvfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglMultiTexEnvfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultiTexEnvEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexEnvivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglMultiTexEnvivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexEnvfEXT(int i, int i2, int i3, float f) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        float f2 = f;
        long j = GLContext.getCapabilities().glMultiTexEnvfEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexEnvfEXT(i4, i5, i6, f2, j);
    }

    public static void glMultiTexEnviEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glMultiTexEnviEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexEnviEXT(i5, i6, i7, i8, j);
    }

    public static void glMultiTexGenEXT(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMultiTexGendvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglMultiTexGendvEXT(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMultiTexGenEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMultiTexGenfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglMultiTexGenfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultiTexGenEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexGenivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglMultiTexGenivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexGendEXT(int i, int i2, int i3, double d) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        double d2 = d;
        long j = GLContext.getCapabilities().glMultiTexGendEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexGendEXT(i4, i5, i6, d2, j);
    }

    public static void glMultiTexGenfEXT(int i, int i2, int i3, float f) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        float f2 = f;
        long j = GLContext.getCapabilities().glMultiTexGenfEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexGenfEXT(i4, i5, i6, f2, j);
    }

    public static void glMultiTexGeniEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glMultiTexGeniEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexGeniEXT(i5, i6, i7, i8, j);
    }

    public static void glMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
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
        long j3 = capabilities.glMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglMultiTexImage1DEXTBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage1DStorage(byteBuffer2, i15, i16, i13));
        }
        nglMultiTexImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DoubleBuffer doubleBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage1DStorage(doubleBuffer2, i15, i16, i13));
        }
        nglMultiTexImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, FloatBuffer floatBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage1DStorage(floatBuffer2, i15, i16, i13));
        }
        nglMultiTexImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, IntBuffer intBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage1DStorage(intBuffer2, i15, i16, i13));
        }
        nglMultiTexImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ShortBuffer shortBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage1DStorage(shortBuffer2, i15, i16, i13));
        }
        nglMultiTexImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglMultiTexImage2DEXTBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ByteBuffer byteBuffer) {
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
        long j = capabilities.glMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage2DStorage(byteBuffer2, i17, i18, i14, i15));
        }
        nglMultiTexImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, DoubleBuffer doubleBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage2DStorage(doubleBuffer2, i17, i18, i14, i15));
        }
        nglMultiTexImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, FloatBuffer floatBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage2DStorage(floatBuffer2, i17, i18, i14, i15));
        }
        nglMultiTexImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IntBuffer intBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage2DStorage(intBuffer2, i17, i18, i14, i15));
        }
        nglMultiTexImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ShortBuffer shortBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage2DStorage(shortBuffer2, i17, i18, i14, i15));
        }
        nglMultiTexImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j) {
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
        long j3 = capabilities.glMultiTexImage3DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglMultiTexImage3DEXTBO(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j2, j3);
    }

    public static void glMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ByteBuffer byteBuffer) {
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
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage3DStorage(byteBuffer2, i19, i20, i15, i16, i17));
        }
        nglMultiTexImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, DoubleBuffer doubleBuffer) {
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
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage3DStorage(doubleBuffer2, i19, i20, i15, i16, i17));
        }
        nglMultiTexImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, FloatBuffer floatBuffer) {
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
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage3DStorage(floatBuffer2, i19, i20, i15, i16, i17));
        }
        nglMultiTexImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IntBuffer intBuffer) {
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
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage3DStorage(intBuffer2, i19, i20, i15, i16, i17));
        }
        nglMultiTexImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ShortBuffer shortBuffer) {
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
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage3DStorage(shortBuffer2, i19, i20, i15, i16, i17));
        }
        nglMultiTexImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glMultiTexParameterEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMultiTexParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglMultiTexParameterfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultiTexParameterEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglMultiTexParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexParameterIEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexParameterIivEXT(i5, i6, i7, APIUtil.getInt(capabilities, i8), j);
    }

    public static void glMultiTexParameterIEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglMultiTexParameterIivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexParameterIuEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexParameterIuivEXT(i5, i6, i7, APIUtil.getInt(capabilities, i8), j);
    }

    public static void glMultiTexParameterIuEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glMultiTexParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglMultiTexParameterIuivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexParameterfEXT(int i, int i2, int i3, float f) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        float f2 = f;
        long j = GLContext.getCapabilities().glMultiTexParameterfEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexParameterfEXT(i4, i5, i6, f2, j);
    }

    public static void glMultiTexParameteriEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glMultiTexParameteriEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexParameteriEXT(i5, i6, i7, i8, j);
    }

    public static void glMultiTexRenderbufferEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glMultiTexRenderbufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglMultiTexRenderbufferEXT(i4, i5, i6, j);
    }

    public static void glMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglMultiTexSubImage1DEXTBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i13, i14, i12, 1, 1));
        nglMultiTexSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, DoubleBuffer doubleBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i13, i14, i12, 1, 1));
        nglMultiTexSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, FloatBuffer floatBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i13, i14, i12, 1, 1));
        nglMultiTexSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, IntBuffer intBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i13, i14, i12, 1, 1));
        nglMultiTexSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, ShortBuffer shortBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i13, i14, i12, 1, 1));
        nglMultiTexSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglMultiTexSubImage2DEXTBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ByteBuffer byteBuffer) {
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
        long j = capabilities.glMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i17, i18, i15, i16, 1));
        nglMultiTexSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, DoubleBuffer doubleBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i17, i18, i15, i16, 1));
        nglMultiTexSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, FloatBuffer floatBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i17, i18, i15, i16, 1));
        nglMultiTexSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IntBuffer intBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i17, i18, i15, i16, 1));
        nglMultiTexSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ShortBuffer shortBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i17, i18, i15, i16, 1));
        nglMultiTexSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglMultiTexSubImage3DEXTBO(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, j2, j3);
    }

    public static void glMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, ByteBuffer byteBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i21, i22, i18, i19, i20));
        nglMultiTexSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, DoubleBuffer doubleBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i21, i22, i18, i19, i20));
        nglMultiTexSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, FloatBuffer floatBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i21, i22, i18, i19, i20));
        nglMultiTexSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, IntBuffer intBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i21, i22, i18, i19, i20));
        nglMultiTexSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, ShortBuffer shortBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glMultiTexSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i21, i22, i18, i19, i20));
        nglMultiTexSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glNamedBufferDataEXT(int i, long j, int i2) {
        int i3 = i;
        long j2 = j;
        int i4 = i2;
        long j3 = GLContext.getCapabilities().glNamedBufferDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglNamedBufferDataEXT(i3, j2, 0, i4, j3);
    }

    public static void glNamedBufferDataEXT(int i, ByteBuffer byteBuffer, int i2) {
        int i3 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferDataEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglNamedBufferDataEXT(i3, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), i4, j);
    }

    public static void glNamedBufferDataEXT(int i, DoubleBuffer doubleBuffer, int i2) {
        int i3 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferDataEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglNamedBufferDataEXT(i3, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), i4, j);
    }

    public static void glNamedBufferDataEXT(int i, FloatBuffer floatBuffer, int i2) {
        int i3 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferDataEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglNamedBufferDataEXT(i3, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), i4, j);
    }

    public static void glNamedBufferDataEXT(int i, IntBuffer intBuffer, int i2) {
        int i3 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferDataEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglNamedBufferDataEXT(i3, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), i4, j);
    }

    public static void glNamedBufferDataEXT(int i, ShortBuffer shortBuffer, int i2) {
        int i3 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferDataEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglNamedBufferDataEXT(i3, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), i4, j);
    }

    public static void glNamedBufferSubDataEXT(int i, long j, ByteBuffer byteBuffer) {
        int i2 = i;
        long j2 = j;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = GLContext.getCapabilities().glNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(byteBuffer2);
        nglNamedBufferSubDataEXT(i2, j2, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j3);
    }

    public static void glNamedBufferSubDataEXT(int i, long j, DoubleBuffer doubleBuffer) {
        int i2 = i;
        long j2 = j;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j3 = GLContext.getCapabilities().glNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(doubleBuffer2);
        nglNamedBufferSubDataEXT(i2, j2, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), j3);
    }

    public static void glNamedBufferSubDataEXT(int i, long j, FloatBuffer floatBuffer) {
        int i2 = i;
        long j2 = j;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j3 = GLContext.getCapabilities().glNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(floatBuffer2);
        nglNamedBufferSubDataEXT(i2, j2, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), j3);
    }

    public static void glNamedBufferSubDataEXT(int i, long j, IntBuffer intBuffer) {
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        long j3 = GLContext.getCapabilities().glNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(intBuffer2);
        nglNamedBufferSubDataEXT(i2, j2, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), j3);
    }

    public static void glNamedBufferSubDataEXT(int i, long j, ShortBuffer shortBuffer) {
        int i2 = i;
        long j2 = j;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j3 = GLContext.getCapabilities().glNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkDirect(shortBuffer2);
        nglNamedBufferSubDataEXT(i2, j2, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), j3);
    }

    public static void glNamedCopyBufferSubDataEXT(int i, int i2, long j, long j2, long j3) {
        int i3 = i;
        int i4 = i2;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long j7 = GLContext.getCapabilities().glNamedCopyBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(j7);
        nglNamedCopyBufferSubDataEXT(i3, i4, j4, j5, j6, j7);
    }

    public static void glNamedFramebufferRenderbufferEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glNamedFramebufferRenderbufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedFramebufferRenderbufferEXT(i5, i6, i7, i8, j);
    }

    public static void glNamedFramebufferTexture1DEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glNamedFramebufferTexture1DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedFramebufferTexture1DEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glNamedFramebufferTexture2DEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glNamedFramebufferTexture2DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedFramebufferTexture2DEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glNamedFramebufferTexture3DEXT(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glNamedFramebufferTexture3DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedFramebufferTexture3DEXT(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glNamedFramebufferTextureEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glNamedFramebufferTextureEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedFramebufferTextureEXT(i5, i6, i7, i8, j);
    }

    public static void glNamedFramebufferTextureFaceEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glNamedFramebufferTextureFaceEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedFramebufferTextureFaceEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glNamedFramebufferTextureLayerEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glNamedFramebufferTextureLayerEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedFramebufferTextureLayerEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glNamedProgramLocalParameter4EXT(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameter4dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglNamedProgramLocalParameter4dvEXT(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glNamedProgramLocalParameter4EXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameter4fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglNamedProgramLocalParameter4fvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glNamedProgramLocalParameter4dEXT(int i, int i2, int i3, double d, double d2, double d3, double d4) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameter4dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedProgramLocalParameter4dEXT(i4, i5, i6, d5, d6, d7, d8, j);
    }

    public static void glNamedProgramLocalParameter4fEXT(int i, int i2, int i3, float f, float f2, float f3, float f4) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameter4fEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedProgramLocalParameter4fEXT(i4, i5, i6, f5, f6, f7, f8, j);
    }

    public static void glNamedProgramLocalParameterI4EXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameterI4ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglNamedProgramLocalParameterI4ivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glNamedProgramLocalParameterI4iEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameterI4iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedProgramLocalParameterI4iEXT(i8, i9, i10, i11, i12, i13, i14, j);
    }

    public static void glNamedProgramLocalParameterI4uEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameterI4uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglNamedProgramLocalParameterI4uivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glNamedProgramLocalParameterI4uiEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameterI4uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedProgramLocalParameterI4uiEXT(i8, i9, i10, i11, i12, i13, i14, j);
    }

    public static void glNamedProgramLocalParameters4EXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glNamedProgramLocalParameters4fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglNamedProgramLocalParameters4fvEXT(i4, i5, i6, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glNamedProgramLocalParametersI4EXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glNamedProgramLocalParametersI4ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglNamedProgramLocalParametersI4ivEXT(i4, i5, i6, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glNamedProgramLocalParametersI4uEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glNamedProgramLocalParametersI4uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglNamedProgramLocalParametersI4uivEXT(i4, i5, i6, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glNamedProgramStringEXT(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glNamedProgramStringEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedProgramStringEXT(i4, i5, i6, charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glNamedProgramStringEXT(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glNamedProgramStringEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglNamedProgramStringEXT(i4, i5, i6, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glNamedRenderbufferStorageEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glNamedRenderbufferStorageEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedRenderbufferStorageEXT(i5, i6, i7, i8, j);
    }

    public static void glNamedRenderbufferStorageMultisampleCoverageEXT(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glNamedRenderbufferStorageMultisampleCoverageEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedRenderbufferStorageMultisampleCoverageEXT(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glNamedRenderbufferStorageMultisampleEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glNamedRenderbufferStorageMultisampleEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedRenderbufferStorageMultisampleEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glProgramUniform1EXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniform1fvEXT(i3, i4, floatBuffer2.remaining(), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniform1EXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform1ivEXT(i3, i4, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform1fEXT(int i, int i2, float f) {
        int i3 = i;
        int i4 = i2;
        float f2 = f;
        long j = GLContext.getCapabilities().glProgramUniform1fEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform1fEXT(i3, i4, f2, j);
    }

    public static void glProgramUniform1iEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glProgramUniform1iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform1iEXT(i4, i5, i6, j);
    }

    public static void glProgramUniform1uEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform1uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform1uivEXT(i3, i4, intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform1uiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glProgramUniform1uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform1uiEXT(i4, i5, i6, j);
    }

    public static void glProgramUniform2EXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniform2fvEXT(i3, i4, floatBuffer2.remaining() >> 1, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniform2EXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform2ivEXT(i3, i4, intBuffer2.remaining() >> 1, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform2fEXT(int i, int i2, float f, float f2) {
        int i3 = i;
        int i4 = i2;
        float f3 = f;
        float f4 = f2;
        long j = GLContext.getCapabilities().glProgramUniform2fEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform2fEXT(i3, i4, f3, f4, j);
    }

    public static void glProgramUniform2iEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glProgramUniform2iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform2iEXT(i5, i6, i7, i8, j);
    }

    public static void glProgramUniform2uEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform2uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform2uivEXT(i3, i4, intBuffer2.remaining() >> 1, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform2uiEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glProgramUniform2uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform2uiEXT(i5, i6, i7, i8, j);
    }

    public static void glProgramUniform3EXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniform3fvEXT(i3, i4, floatBuffer2.remaining() / 3, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniform3EXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform3ivEXT(i3, i4, intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform3fEXT(int i, int i2, float f, float f2, float f3) {
        int i3 = i;
        int i4 = i2;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glProgramUniform3fEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform3fEXT(i3, i4, f4, f5, f6, j);
    }

    public static void glProgramUniform3iEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glProgramUniform3iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform3iEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glProgramUniform3uEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform3uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform3uivEXT(i3, i4, intBuffer2.remaining() / 3, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform3uiEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glProgramUniform3uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform3uiEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glProgramUniform4EXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniform4fvEXT(i3, i4, floatBuffer2.remaining() >> 2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniform4EXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4ivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform4ivEXT(i3, i4, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform4fEXT(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = i;
        int i4 = i2;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        long j = GLContext.getCapabilities().glProgramUniform4fEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform4fEXT(i3, i4, f5, f6, f7, f8, j);
    }

    public static void glProgramUniform4iEXT(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glProgramUniform4iEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform4iEXT(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glProgramUniform4uEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glProgramUniform4uivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglProgramUniform4uivEXT(i3, i4, intBuffer2.remaining() >> 2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glProgramUniform4uiEXT(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glProgramUniform4uiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglProgramUniform4uiEXT(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glProgramUniformMatrix2EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix2fvEXT(i3, i4, floatBuffer2.remaining() >> 2, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix2x3EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2x3fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix2x3fvEXT(i3, i4, floatBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix2x4EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix2x4fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix2x4fvEXT(i3, i4, floatBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix3EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix3fvEXT(i3, i4, floatBuffer2.remaining() / 9, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix3x2EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3x2fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix3x2fvEXT(i3, i4, floatBuffer2.remaining() / 6, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix3x4EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix3x4fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix3x4fvEXT(i3, i4, floatBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix4EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix4fvEXT(i3, i4, floatBuffer2.remaining() >> 4, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix4x2EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4x2fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix4x2fvEXT(i3, i4, floatBuffer2.remaining() >> 3, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glProgramUniformMatrix4x3EXT(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glProgramUniformMatrix4x3fvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglProgramUniformMatrix4x3fvEXT(i3, i4, floatBuffer2.remaining() / 12, z2, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glPushClientAttribDefaultEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glPushClientAttribDefaultEXT;
        BufferChecks.checkFunctionAddress(j);
        nglPushClientAttribDefaultEXT(i2, j);
    }

    public static void glTextureBufferEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glTextureBufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureBufferEXT(i5, i6, i7, i8, j);
    }

    public static void glTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
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
        long j3 = capabilities.glTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTextureImage1DEXTBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage1DStorage(byteBuffer2, i15, i16, i13));
        }
        nglTextureImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DoubleBuffer doubleBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage1DStorage(doubleBuffer2, i15, i16, i13));
        }
        nglTextureImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, FloatBuffer floatBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage1DStorage(floatBuffer2, i15, i16, i13));
        }
        nglTextureImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, IntBuffer intBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage1DStorage(intBuffer2, i15, i16, i13));
        }
        nglTextureImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ShortBuffer shortBuffer) {
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage1DStorage(shortBuffer2, i15, i16, i13));
        }
        nglTextureImage1DEXT(i9, i10, i11, i12, i13, i14, i15, i16, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTextureImage2DEXTBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ByteBuffer byteBuffer) {
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
        long j = capabilities.glTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage2DStorage(byteBuffer2, i17, i18, i14, i15));
        }
        nglTextureImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, DoubleBuffer doubleBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage2DStorage(doubleBuffer2, i17, i18, i14, i15));
        }
        nglTextureImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, FloatBuffer floatBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage2DStorage(floatBuffer2, i17, i18, i14, i15));
        }
        nglTextureImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IntBuffer intBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage2DStorage(intBuffer2, i17, i18, i14, i15));
        }
        nglTextureImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ShortBuffer shortBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage2DStorage(shortBuffer2, i17, i18, i14, i15));
        }
        nglTextureImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j) {
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
        long j3 = capabilities.glTextureImage3DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTextureImage3DEXTBO(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j2, j3);
    }

    public static void glTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ByteBuffer byteBuffer) {
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
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage3DStorage(byteBuffer2, i19, i20, i15, i16, i17));
        }
        nglTextureImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, DoubleBuffer doubleBuffer) {
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
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage3DStorage(doubleBuffer2, i19, i20, i15, i16, i17));
        }
        nglTextureImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, FloatBuffer floatBuffer) {
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
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage3DStorage(floatBuffer2, i19, i20, i15, i16, i17));
        }
        nglTextureImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IntBuffer intBuffer) {
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
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage3DStorage(intBuffer2, i19, i20, i15, i16, i17));
        }
        nglTextureImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ShortBuffer shortBuffer) {
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
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage3DStorage(shortBuffer2, i19, i20, i15, i16, i17));
        }
        nglTextureImage3DEXT(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glTextureParameterEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glTextureParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglTextureParameterfvEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTextureParameterEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTextureParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTextureParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTextureParameterIEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureParameterIivEXT(i5, i6, i7, APIUtil.getInt(capabilities, i8), j);
    }

    public static void glTextureParameterIEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTextureParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTextureParameterIivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTextureParameterIuEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureParameterIuivEXT(i5, i6, i7, APIUtil.getInt(capabilities, i8), j);
    }

    public static void glTextureParameterIuEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTextureParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTextureParameterIuivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTextureParameterfEXT(int i, int i2, int i3, float f) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        float f2 = f;
        long j = GLContext.getCapabilities().glTextureParameterfEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureParameterfEXT(i4, i5, i6, f2, j);
    }

    public static void glTextureParameteriEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glTextureParameteriEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureParameteriEXT(i5, i6, i7, i8, j);
    }

    public static void glTextureRenderbufferEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glTextureRenderbufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTextureRenderbufferEXT(i4, i5, i6, j);
    }

    public static void glTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTextureSubImage1DEXTBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i13, i14, i12, 1, 1));
        nglTextureSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, DoubleBuffer doubleBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i13, i14, i12, 1, 1));
        nglTextureSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, FloatBuffer floatBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i13, i14, i12, 1, 1));
        nglTextureSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, IntBuffer intBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i13, i14, i12, 1, 1));
        nglTextureSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, ShortBuffer shortBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage1DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i13, i14, i12, 1, 1));
        nglTextureSubImage1DEXT(i8, i9, i10, i11, i12, i13, i14, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTextureSubImage2DEXTBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ByteBuffer byteBuffer) {
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
        long j = capabilities.glTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i17, i18, i15, i16, 1));
        nglTextureSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, DoubleBuffer doubleBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i17, i18, i15, i16, 1));
        nglTextureSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, FloatBuffer floatBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i17, i18, i15, i16, 1));
        nglTextureSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IntBuffer intBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i17, i18, i15, i16, 1));
        nglTextureSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ShortBuffer shortBuffer) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage2DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i17, i18, i15, i16, 1));
        nglTextureSubImage2DEXT(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTextureSubImage3DEXTBO(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, j2, j3);
    }

    public static void glTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, ByteBuffer byteBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i21, i22, i18, i19, i20));
        nglTextureSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, DoubleBuffer doubleBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i21, i22, i18, i19, i20));
        nglTextureSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, FloatBuffer floatBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i21, i22, i18, i19, i20));
        nglTextureSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, IntBuffer intBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i21, i22, i18, i19, i20));
        nglTextureSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, ShortBuffer shortBuffer) {
        int i12 = i;
        int i13 = i2;
        int i14 = i3;
        int i15 = i4;
        int i16 = i5;
        int i17 = i6;
        int i18 = i7;
        int i19 = i8;
        int i20 = i9;
        int i21 = i10;
        int i22 = i11;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTextureSubImage3DEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i21, i22, i18, i19, i20));
        nglTextureSubImage3DEXT(i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static boolean glUnmapNamedBufferEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glUnmapNamedBufferEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglUnmapNamedBufferEXT(i2, j);
    }

    public static void glVertexArrayColorOffsetEXT(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayColorOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayColorOffsetEXT(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glVertexArrayEdgeFlagOffsetEXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayEdgeFlagOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayEdgeFlagOffsetEXT(i4, i5, i6, j2, j3);
    }

    public static void glVertexArrayFogCoordOffsetEXT(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayFogCoordOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayFogCoordOffsetEXT(i5, i6, i7, i8, j2, j3);
    }

    public static void glVertexArrayIndexOffsetEXT(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayIndexOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayIndexOffsetEXT(i5, i6, i7, i8, j2, j3);
    }

    public static void glVertexArrayMultiTexCoordOffsetEXT(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayMultiTexCoordOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayMultiTexCoordOffsetEXT(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glVertexArrayNormalOffsetEXT(int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayNormalOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayNormalOffsetEXT(i5, i6, i7, i8, j2, j3);
    }

    public static void glVertexArraySecondaryColorOffsetEXT(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArraySecondaryColorOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArraySecondaryColorOffsetEXT(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glVertexArrayTexCoordOffsetEXT(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayTexCoordOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayTexCoordOffsetEXT(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glVertexArrayVertexAttribIOffsetEXT(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayVertexAttribIOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayVertexAttribIOffsetEXT(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glVertexArrayVertexAttribOffsetEXT(int i, int i2, int i3, int i4, int i5, boolean z, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        boolean z2 = z;
        int i12 = i6;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayVertexAttribOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayVertexAttribOffsetEXT(i7, i8, i9, i10, i11, z2, i12, j2, j3);
    }

    public static void glVertexArrayVertexOffsetEXT(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayVertexOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayVertexOffsetEXT(i6, i7, i8, i9, i10, j2, j3);
    }

    static native void nglBindMultiTextureEXT(int i, int i2, int i3, long j);

    static native int nglCheckNamedFramebufferStatusEXT(int i, int i2, long j);

    static native void nglClientAttribDefaultEXT(int i, long j);

    static native void nglCompressedMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedMultiTexImage1DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedMultiTexImage2DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglCompressedMultiTexImage3DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglCompressedMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedMultiTexSubImage1DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglCompressedMultiTexSubImage2DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglCompressedMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, long j2);

    static native void nglCompressedMultiTexSubImage3DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, long j2);

    static native void nglCompressedTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedTextureImage1DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTextureImage2DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglCompressedTextureImage3DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglCompressedTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedTextureSubImage1DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglCompressedTextureSubImage2DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglCompressedTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, long j2);

    static native void nglCompressedTextureSubImage3DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, long j2);

    static native void nglCopyMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    static native void nglCopyMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j);

    static native void nglCopyMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    static native void nglCopyMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j);

    static native void nglCopyMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j);

    static native void nglCopyTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    static native void nglCopyTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j);

    static native void nglCopyTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    static native void nglCopyTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j);

    static native void nglCopyTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j);

    static native void nglDisableClientStateIndexedEXT(int i, int i2, long j);

    static native void nglDisableClientStateiEXT(int i, int i2, long j);

    static native void nglDisableVertexArrayAttribEXT(int i, int i2, long j);

    static native void nglDisableVertexArrayEXT(int i, int i2, long j);

    static native void nglEnableClientStateIndexedEXT(int i, int i2, long j);

    static native void nglEnableClientStateiEXT(int i, int i2, long j);

    static native void nglEnableVertexArrayAttribEXT(int i, int i2, long j);

    static native void nglEnableVertexArrayEXT(int i, int i2, long j);

    static native void nglFlushMappedNamedBufferRangeEXT(int i, long j, long j2, long j3);

    static native void nglFramebufferDrawBufferEXT(int i, int i2, long j);

    static native void nglFramebufferDrawBuffersEXT(int i, int i2, long j, long j2);

    static native void nglFramebufferReadBufferEXT(int i, int i2, long j);

    static native void nglGenerateMultiTexMipmapEXT(int i, int i2, long j);

    static native void nglGenerateTextureMipmapEXT(int i, int i2, long j);

    static native void nglGetCompressedMultiTexImageEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetCompressedMultiTexImageEXTBO(int i, int i2, int i3, long j, long j2);

    static native void nglGetCompressedTextureImageEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetCompressedTextureImageEXTBO(int i, int i2, int i3, long j, long j2);

    static native void nglGetDoubleIndexedvEXT(int i, int i2, long j, long j2);

    static native void nglGetDoublei_vEXT(int i, int i2, long j, long j2);

    static native void nglGetFloatIndexedvEXT(int i, int i2, long j, long j2);

    static native void nglGetFloati_vEXT(int i, int i2, long j, long j2);

    static native void nglGetFramebufferParameterivEXT(int i, int i2, long j, long j2);

    static native void nglGetMultiTexEnvfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetMultiTexEnvivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetMultiTexGendvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetMultiTexGenfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetMultiTexGenivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetMultiTexImageEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglGetMultiTexImageEXTBO(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglGetMultiTexLevelParameterfvEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetMultiTexLevelParameterivEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetMultiTexParameterIivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetMultiTexParameterIuivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetMultiTexParameterfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetMultiTexParameterivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetNamedBufferParameterivEXT(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetNamedBufferPointervEXT(int i, int i2, long j, long j2);

    static native void nglGetNamedBufferSubDataEXT(int i, long j, long j2, long j3, long j4);

    static native void nglGetNamedFramebufferAttachmentParameterivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetNamedProgramLocalParameterIivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetNamedProgramLocalParameterIuivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetNamedProgramLocalParameterdvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetNamedProgramLocalParameterfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetNamedProgramStringEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetNamedProgramivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetNamedRenderbufferParameterivEXT(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetPointerIndexedvEXT(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetPointeri_vEXT(int i, int i2, long j, long j2);

    static native void nglGetTextureImageEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglGetTextureImageEXTBO(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglGetTextureLevelParameterfvEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetTextureLevelParameterivEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglGetTextureParameterIivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetTextureParameterIuivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetTextureParameterfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetTextureParameterivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetVertexArrayIntegeri_vEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetVertexArrayIntegervEXT(int i, int i2, long j, long j2);

    static native ByteBuffer nglGetVertexArrayPointeri_vEXT(int i, int i2, int i3, long j, long j2);

    static native ByteBuffer nglGetVertexArrayPointervEXT(int i, int i2, long j, long j2);

    static native ByteBuffer nglMapNamedBufferEXT(int i, int i2, long j, ByteBuffer byteBuffer, long j2);

    static native ByteBuffer nglMapNamedBufferRangeEXT(int i, long j, long j2, int i2, ByteBuffer byteBuffer, long j3);

    static native void nglMatrixFrustumEXT(int i, double d, double d2, double d3, double d4, double d5, double d6, long j);

    static native void nglMatrixLoadIdentityEXT(int i, long j);

    static native void nglMatrixLoadTransposedEXT(int i, long j, long j2);

    static native void nglMatrixLoadTransposefEXT(int i, long j, long j2);

    static native void nglMatrixLoaddEXT(int i, long j, long j2);

    static native void nglMatrixLoadfEXT(int i, long j, long j2);

    static native void nglMatrixMultTransposedEXT(int i, long j, long j2);

    static native void nglMatrixMultTransposefEXT(int i, long j, long j2);

    static native void nglMatrixMultdEXT(int i, long j, long j2);

    static native void nglMatrixMultfEXT(int i, long j, long j2);

    static native void nglMatrixOrthoEXT(int i, double d, double d2, double d3, double d4, double d5, double d6, long j);

    static native void nglMatrixPopEXT(int i, long j);

    static native void nglMatrixPushEXT(int i, long j);

    static native void nglMatrixRotatedEXT(int i, double d, double d2, double d3, double d4, long j);

    static native void nglMatrixRotatefEXT(int i, float f, float f2, float f3, float f4, long j);

    static native void nglMatrixScaledEXT(int i, double d, double d2, double d3, long j);

    static native void nglMatrixScalefEXT(int i, float f, float f2, float f3, long j);

    static native void nglMatrixTranslatedEXT(int i, double d, double d2, double d3, long j);

    static native void nglMatrixTranslatefEXT(int i, float f, float f2, float f3, long j);

    static native void nglMultiTexBufferEXT(int i, int i2, int i3, int i4, long j);

    static native void nglMultiTexCoordPointerEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglMultiTexCoordPointerEXTBO(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglMultiTexEnvfEXT(int i, int i2, int i3, float f, long j);

    static native void nglMultiTexEnvfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexEnviEXT(int i, int i2, int i3, int i4, long j);

    static native void nglMultiTexEnvivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexGendEXT(int i, int i2, int i3, double d, long j);

    static native void nglMultiTexGendvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexGenfEXT(int i, int i2, int i3, float f, long j);

    static native void nglMultiTexGenfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexGeniEXT(int i, int i2, int i3, int i4, long j);

    static native void nglMultiTexGenivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglMultiTexImage1DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglMultiTexImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglMultiTexImage2DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglMultiTexImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglMultiTexImage3DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglMultiTexParameterIivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexParameterIuivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexParameterfEXT(int i, int i2, int i3, float f, long j);

    static native void nglMultiTexParameterfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexParameteriEXT(int i, int i2, int i3, int i4, long j);

    static native void nglMultiTexParameterivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglMultiTexRenderbufferEXT(int i, int i2, int i3, long j);

    static native void nglMultiTexSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglMultiTexSubImage1DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglMultiTexSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglMultiTexSubImage2DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglMultiTexSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, long j2);

    static native void nglMultiTexSubImage3DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, long j2);

    static native void nglNamedBufferDataEXT(int i, long j, long j2, int i2, long j3);

    static native void nglNamedBufferSubDataEXT(int i, long j, long j2, long j3, long j4);

    static native void nglNamedCopyBufferSubDataEXT(int i, int i2, long j, long j2, long j3, long j4);

    static native void nglNamedFramebufferRenderbufferEXT(int i, int i2, int i3, int i4, long j);

    static native void nglNamedFramebufferTexture1DEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglNamedFramebufferTexture2DEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglNamedFramebufferTexture3DEXT(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglNamedFramebufferTextureEXT(int i, int i2, int i3, int i4, long j);

    static native void nglNamedFramebufferTextureFaceEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglNamedFramebufferTextureLayerEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglNamedProgramLocalParameter4dEXT(int i, int i2, int i3, double d, double d2, double d3, double d4, long j);

    static native void nglNamedProgramLocalParameter4dvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglNamedProgramLocalParameter4fEXT(int i, int i2, int i3, float f, float f2, float f3, float f4, long j);

    static native void nglNamedProgramLocalParameter4fvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglNamedProgramLocalParameterI4iEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    static native void nglNamedProgramLocalParameterI4ivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglNamedProgramLocalParameterI4uiEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j);

    static native void nglNamedProgramLocalParameterI4uivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglNamedProgramLocalParameters4fvEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglNamedProgramLocalParametersI4ivEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglNamedProgramLocalParametersI4uivEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglNamedProgramStringEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglNamedRenderbufferStorageEXT(int i, int i2, int i3, int i4, long j);

    static native void nglNamedRenderbufferStorageMultisampleCoverageEXT(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglNamedRenderbufferStorageMultisampleEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglProgramUniform1fEXT(int i, int i2, float f, long j);

    static native void nglProgramUniform1fvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform1iEXT(int i, int i2, int i3, long j);

    static native void nglProgramUniform1ivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform1uiEXT(int i, int i2, int i3, long j);

    static native void nglProgramUniform1uivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2fEXT(int i, int i2, float f, float f2, long j);

    static native void nglProgramUniform2fvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2iEXT(int i, int i2, int i3, int i4, long j);

    static native void nglProgramUniform2ivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform2uiEXT(int i, int i2, int i3, int i4, long j);

    static native void nglProgramUniform2uivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3fEXT(int i, int i2, float f, float f2, float f3, long j);

    static native void nglProgramUniform3fvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3iEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglProgramUniform3ivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform3uiEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglProgramUniform3uivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4fEXT(int i, int i2, float f, float f2, float f3, float f4, long j);

    static native void nglProgramUniform4fvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4iEXT(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglProgramUniform4ivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniform4uiEXT(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglProgramUniform4uivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglProgramUniformMatrix2fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2x3fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix2x4fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3x2fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix3x4fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4x2fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglProgramUniformMatrix4x3fvEXT(int i, int i2, int i3, boolean z, long j, long j2);

    static native void nglPushClientAttribDefaultEXT(int i, long j);

    static native void nglTextureBufferEXT(int i, int i2, int i3, int i4, long j);

    static native void nglTextureImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglTextureImage1DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglTextureImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglTextureImage2DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglTextureImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglTextureImage3DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglTextureParameterIivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglTextureParameterIuivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglTextureParameterfEXT(int i, int i2, int i3, float f, long j);

    static native void nglTextureParameterfvEXT(int i, int i2, int i3, long j, long j2);

    static native void nglTextureParameteriEXT(int i, int i2, int i3, int i4, long j);

    static native void nglTextureParameterivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglTextureRenderbufferEXT(int i, int i2, int i3, long j);

    static native void nglTextureSubImage1DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglTextureSubImage1DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglTextureSubImage2DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglTextureSubImage2DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglTextureSubImage3DEXT(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, long j2);

    static native void nglTextureSubImage3DEXTBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j, long j2);

    static native boolean nglUnmapNamedBufferEXT(int i, long j);

    static native void nglVertexArrayColorOffsetEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglVertexArrayEdgeFlagOffsetEXT(int i, int i2, int i3, long j, long j2);

    static native void nglVertexArrayFogCoordOffsetEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexArrayIndexOffsetEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexArrayMultiTexCoordOffsetEXT(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglVertexArrayNormalOffsetEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexArraySecondaryColorOffsetEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglVertexArrayTexCoordOffsetEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglVertexArrayVertexAttribIOffsetEXT(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglVertexArrayVertexAttribOffsetEXT(int i, int i2, int i3, int i4, int i5, boolean z, int i6, long j, long j2);

    static native void nglVertexArrayVertexOffsetEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);
}
