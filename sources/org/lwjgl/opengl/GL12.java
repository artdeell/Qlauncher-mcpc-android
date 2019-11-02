package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class GL12 {
    public static final int GL_ALIASED_LINE_WIDTH_RANGE = 33902;
    public static final int GL_ALIASED_POINT_SIZE_RANGE = 33901;
    public static final int GL_BGR = 32992;
    public static final int GL_BGRA = 32993;
    public static final int GL_CLAMP_TO_EDGE = 33071;
    public static final int GL_LIGHT_MODEL_COLOR_CONTROL = 33272;
    public static final int GL_MAX_3D_TEXTURE_SIZE = 32883;
    public static final int GL_MAX_ELEMENTS_INDICES = 33001;
    public static final int GL_MAX_ELEMENTS_VERTICES = 33000;
    public static final int GL_PACK_IMAGE_HEIGHT = 32876;
    public static final int GL_PACK_SKIP_IMAGES = 32875;
    public static final int GL_PROXY_TEXTURE_3D = 32880;
    public static final int GL_RESCALE_NORMAL = 32826;
    public static final int GL_SEPARATE_SPECULAR_COLOR = 33274;
    public static final int GL_SINGLE_COLOR = 33273;
    public static final int GL_SMOOTH_LINE_WIDTH_GRANULARITY = 2851;
    public static final int GL_SMOOTH_LINE_WIDTH_RANGE = 2850;
    public static final int GL_SMOOTH_POINT_SIZE_GRANULARITY = 2835;
    public static final int GL_SMOOTH_POINT_SIZE_RANGE = 2834;
    public static final int GL_TEXTURE_3D = 32879;
    public static final int GL_TEXTURE_BASE_LEVEL = 33084;
    public static final int GL_TEXTURE_BINDING_3D = 32874;
    public static final int GL_TEXTURE_DEPTH = 32881;
    public static final int GL_TEXTURE_MAX_LEVEL = 33085;
    public static final int GL_TEXTURE_MAX_LOD = 33083;
    public static final int GL_TEXTURE_MIN_LOD = 33082;
    public static final int GL_TEXTURE_WRAP_R = 32882;
    public static final int GL_UNPACK_IMAGE_HEIGHT = 32878;
    public static final int GL_UNPACK_SKIP_IMAGES = 32877;
    public static final int GL_UNSIGNED_BYTE_2_3_3_REV = 33634;
    public static final int GL_UNSIGNED_BYTE_3_3_2 = 32818;
    public static final int GL_UNSIGNED_INT_10_10_10_2 = 32822;
    public static final int GL_UNSIGNED_INT_2_10_10_10_REV = 33640;
    public static final int GL_UNSIGNED_INT_8_8_8_8 = 32821;
    public static final int GL_UNSIGNED_INT_8_8_8_8_REV = 33639;
    public static final int GL_UNSIGNED_SHORT_1_5_5_5_REV = 33638;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV = 33637;
    public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820;
    public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635;
    public static final int GL_UNSIGNED_SHORT_5_6_5_REV = 33636;

    private GL12() {
    }

    public static void glCopyTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        long j = GLContext.getCapabilities().glCopyTexSubImage3D;
        BufferChecks.checkFunctionAddress(j);
        nglCopyTexSubImage3D(i10, i11, i12, i13, i14, i15, i16, i17, i18, j);
    }

    public static void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawRangeElements;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawRangeElementsBO(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glDrawRangeElements(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElements;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawRangeElements(i4, i5, i6, byteBuffer2.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDrawRangeElements(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElements;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawRangeElements(i4, i5, i6, intBuffer2.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDrawRangeElements(int i, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElements;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawRangeElements(i4, i5, i6, shortBuffer2.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
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
        long j3 = capabilities.glTexImage3D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTexImage3DBO(i10, i11, i12, i13, i14, i15, i16, i17, i18, j2, j3);
    }

    public static void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ByteBuffer byteBuffer) {
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
        long j = capabilities.glTexImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateTexImage3DStorage(byteBuffer2, i17, i18, i13, i14, i15));
        }
        nglTexImage3D(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, DoubleBuffer doubleBuffer) {
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
        long j = capabilities.glTexImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateTexImage3DStorage(doubleBuffer2, i17, i18, i13, i14, i15));
        }
        nglTexImage3D(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, FloatBuffer floatBuffer) {
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
        long j = capabilities.glTexImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateTexImage3DStorage(floatBuffer2, i17, i18, i13, i14, i15));
        }
        nglTexImage3D(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, IntBuffer intBuffer) {
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
        long j = capabilities.glTexImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateTexImage3DStorage(intBuffer2, i17, i18, i13, i14, i15));
        }
        nglTexImage3D(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, ShortBuffer shortBuffer) {
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
        long j = capabilities.glTexImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateTexImage3DStorage(shortBuffer2, i17, i18, i13, i14, i15));
        }
        nglTexImage3D(i10, i11, i12, i13, i14, i15, i16, i17, i18, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j) {
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
        long j3 = capabilities.glTexSubImage3D;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureUnpackPBOenabled(capabilities);
        nglTexSubImage3DBO(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, j2, j3);
    }

    public static void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ByteBuffer byteBuffer) {
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
        long j = capabilities.glTexSubImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i19, i20, i16, i17, i18));
        nglTexSubImage3D(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, DoubleBuffer doubleBuffer) {
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
        long j = capabilities.glTexSubImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i19, i20, i16, i17, i18));
        nglTexSubImage3D(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, FloatBuffer floatBuffer) {
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
        long j = capabilities.glTexSubImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i19, i20, i16, i17, i18));
        nglTexSubImage3D(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IntBuffer intBuffer) {
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
        long j = capabilities.glTexSubImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i19, i20, i16, i17, i18));
        nglTexSubImage3D(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ShortBuffer shortBuffer) {
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
        long j = capabilities.glTexSubImage3D;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureUnpackPBOdisabled(capabilities);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i19, i20, i16, i17, i18));
        nglTexSubImage3D(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglCopyTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j);

    static native void nglDrawRangeElements(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglDrawRangeElementsBO(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglTexImage3DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, long j2);

    static native void nglTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);

    static native void nglTexSubImage3DBO(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);
}
