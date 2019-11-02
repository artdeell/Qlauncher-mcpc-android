package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBTextureCompression {
    public static final int GL_COMPRESSED_ALPHA_ARB = 34025;
    public static final int GL_COMPRESSED_INTENSITY_ARB = 34028;
    public static final int GL_COMPRESSED_LUMINANCE_ALPHA_ARB = 34027;
    public static final int GL_COMPRESSED_LUMINANCE_ARB = 34026;
    public static final int GL_COMPRESSED_RGBA_ARB = 34030;
    public static final int GL_COMPRESSED_RGB_ARB = 34029;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS_ARB = 34467;
    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS_ARB = 34466;
    public static final int GL_TEXTURE_COMPRESSED_ARB = 34465;
    public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE_ARB = 34464;
    public static final int GL_TEXTURE_COMPRESSION_HINT_ARB = 34031;

    private ARBTextureCompression() {
    }

    public static void glCompressedTexImage1DARB(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexImage1DARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexImage1DARBBO(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glCompressedTexImage1DARB(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexImage1DARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexImage1DARB(i6, i7, i8, i9, i10, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexImage2DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexImage2DARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexImage2DARBBO(i8, i9, i10, i11, i12, i13, i14, j2, j3);
    }

    public static void glCompressedTexImage2DARB(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexImage2DARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexImage2DARB(i7, i8, i9, i10, i11, i12, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexImage3DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
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
        long j3 = capabilities.glCompressedTexImage3DARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexImage3DARBBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glCompressedTexImage3DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexImage3DARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexImage3DARB(i8, i9, i10, i11, i12, i13, i14, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexSubImage1DARB(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glCompressedTexSubImage1DARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexSubImage1DARBBO(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glCompressedTexSubImage1DARB(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexSubImage1DARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexSubImage1DARB(i6, i7, i8, i9, i10, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexSubImage2DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
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
        long j3 = capabilities.glCompressedTexSubImage2DARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexSubImage2DARBBO(i9, i10, i11, i12, i13, i14, i15, i16, j2, j3);
    }

    public static void glCompressedTexSubImage2DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer) {
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompressedTexSubImage2DARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexSubImage2DARB(i8, i9, i10, i11, i12, i13, i14, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glCompressedTexSubImage3DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j) {
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
        long j3 = capabilities.glCompressedTexSubImage3DARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglCompressedTexSubImage3DARBBO(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j2, j3);
    }

    public static void glCompressedTexSubImage3DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ByteBuffer byteBuffer) {
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
        long j = capabilities.glCompressedTexSubImage3DARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglCompressedTexSubImage3DARB(i10, i11, i12, i13, i14, i15, i16, i17, i18, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetCompressedTexImageARB(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glGetCompressedTexImageARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensurePackPBOenabled(capabilities);
        nglGetCompressedTexImageARBBO(i3, i4, j2, j3);
    }

    public static void glGetCompressedTexImageARB(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetCompressedTexImageARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensurePackPBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetCompressedTexImageARB(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    static native void nglCompressedTexImage1DARB(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglCompressedTexImage1DARBBO(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglCompressedTexImage2DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedTexImage2DARBBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, long j2);

    static native void nglCompressedTexImage3DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTexImage3DARBBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTexSubImage1DARB(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglCompressedTexSubImage1DARBBO(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);

    static native void nglCompressedTexSubImage2DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTexSubImage2DARBBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, long j2);

    static native void nglCompressedTexSubImage3DARB(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglCompressedTexSubImage3DARBBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglGetCompressedTexImageARB(int i, int i2, long j, long j2);

    static native void nglGetCompressedTexImageARBBO(int i, int i2, long j, long j2);
}
