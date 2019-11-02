package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTPalettedTexture {
    public static final int GL_COLOR_INDEX12_EXT = 32998;
    public static final int GL_COLOR_INDEX16_EXT = 32999;
    public static final int GL_COLOR_INDEX1_EXT = 32994;
    public static final int GL_COLOR_INDEX2_EXT = 32995;
    public static final int GL_COLOR_INDEX4_EXT = 32996;
    public static final int GL_COLOR_INDEX8_EXT = 32997;
    public static final int GL_COLOR_TABLE_ALPHA_SIZE_EXT = 32989;
    public static final int GL_COLOR_TABLE_BLUE_SIZE_EXT = 32988;
    public static final int GL_COLOR_TABLE_FORMAT_EXT = 32984;
    public static final int GL_COLOR_TABLE_GREEN_SIZE_EXT = 32987;
    public static final int GL_COLOR_TABLE_INTENSITY_SIZE_EXT = 32991;
    public static final int GL_COLOR_TABLE_LUMINANCE_SIZE_EXT = 32990;
    public static final int GL_COLOR_TABLE_RED_SIZE_EXT = 32986;
    public static final int GL_COLOR_TABLE_WIDTH_EXT = 32985;
    public static final int GL_TEXTURE_INDEX_SIZE_EXT = 33005;

    private EXTPalettedTexture() {
    }

    public static void glColorSubTableEXT(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glColorSubTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i9, i10, i8, 1, 1));
        nglColorSubTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glColorSubTableEXT(int i, int i2, int i3, int i4, int i5, DoubleBuffer doubleBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glColorSubTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i9, i10, i8, 1, 1));
        nglColorSubTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glColorSubTableEXT(int i, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glColorSubTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i9, i10, i8, 1, 1));
        nglColorSubTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glColorSubTableEXT(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glColorSubTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i9, i10, i8, 1, 1));
        nglColorSubTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glColorSubTableEXT(int i, int i2, int i3, int i4, int i5, ShortBuffer shortBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glColorSubTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i9, i10, i8, 1, 1));
        nglColorSubTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glColorTableEXT(int i, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, GLChecks.calculateImageStorage(byteBuffer2, i9, i10, i8, 1, 1));
        nglColorTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glColorTableEXT(int i, int i2, int i3, int i4, int i5, DoubleBuffer doubleBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, GLChecks.calculateImageStorage(doubleBuffer2, i9, i10, i8, 1, 1));
        nglColorTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glColorTableEXT(int i, int i2, int i3, int i4, int i5, FloatBuffer floatBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, GLChecks.calculateImageStorage(floatBuffer2, i9, i10, i8, 1, 1));
        nglColorTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glColorTableEXT(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, GLChecks.calculateImageStorage(intBuffer2, i9, i10, i8, 1, 1));
        nglColorTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glColorTableEXT(int i, int i2, int i3, int i4, int i5, ShortBuffer shortBuffer) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(shortBuffer2, GLChecks.calculateImageStorage(shortBuffer2, i9, i10, i8, 1, 1));
        nglColorTableEXT(i6, i7, i8, i9, i10, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetColorTableEXT(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetColorTableEXT(i4, i5, i6, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetColorTableEXT(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglGetColorTableEXT(i4, i5, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glGetColorTableEXT(int i, int i2, int i3, FloatBuffer floatBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetColorTableEXT(i4, i5, i6, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetColorTableEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetColorTableEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetColorTableEXT(int i, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glGetColorTableEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglGetColorTableEXT(i4, i5, i6, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glGetColorTableParameterEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetColorTableParameterfvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetColorTableParameterfvEXT(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetColorTableParameterEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetColorTableParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetColorTableParameterivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    static native void nglColorSubTableEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglColorTableEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglGetColorTableEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetColorTableParameterfvEXT(int i, int i2, long j, long j2);

    static native void nglGetColorTableParameterivEXT(int i, int i2, long j, long j2);
}
