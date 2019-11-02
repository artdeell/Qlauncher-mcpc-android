package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class GL44 {
    public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
    public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
    public static final int GL_CLEAR_TEXTURE = 37733;
    public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
    public static final int GL_CLIENT_STORAGE_BIT = 512;
    public static final int GL_DYNAMIC_STORAGE_BIT = 256;
    public static final int GL_LOCATION_COMPONENT = 37706;
    public static final int GL_MAP_COHERENT_BIT = 128;
    public static final int GL_MAP_PERSISTENT_BIT = 64;
    public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 33509;
    public static final int GL_MIRROR_CLAMP_TO_EDGE = 34627;
    public static final int GL_QUERY_BUFFER = 37266;
    public static final int GL_QUERY_BUFFER_BARRIER_BIT = 32768;
    public static final int GL_QUERY_BUFFER_BINDING = 37267;
    public static final int GL_QUERY_RESULT_NO_WAIT = 37268;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 37707;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 37708;

    private GL44() {
    }

    public static void glBindBuffersBase(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glBindBuffersBase;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, i6);
        }
        nglBindBuffersBase(i4, i5, i6, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glBindBuffersRange(int i, int i2, int i3, IntBuffer intBuffer, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = GLContext.getCapabilities().glBindBuffersRange;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, i6);
        }
        if (pointerBuffer3 != null) {
            BufferChecks.checkBuffer(pointerBuffer3, i6);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, i6);
        }
        nglBindBuffersRange(i4, i5, i6, MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j);
    }

    public static void glBindImageTextures(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glBindImageTextures;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, i4);
        }
        nglBindImageTextures(i3, i4, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glBindSamplers(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glBindSamplers;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, i4);
        }
        nglBindSamplers(i3, i4, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glBindTextures(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glBindTextures;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, i4);
        }
        nglBindTextures(i3, i4, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glBindVertexBuffers(int i, int i2, IntBuffer intBuffer, PointerBuffer pointerBuffer, IntBuffer intBuffer2) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer3 = intBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glBindVertexBuffers;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer3 != null) {
            BufferChecks.checkBuffer(intBuffer3, i4);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, i4);
        }
        if (intBuffer4 != null) {
            BufferChecks.checkBuffer(intBuffer4, i4);
        }
        nglBindVertexBuffers(i3, i4, MemoryUtil.getAddressSafe(intBuffer3), MemoryUtil.getAddressSafe(pointerBuffer2), MemoryUtil.getAddressSafe(intBuffer4), j);
    }

    public static void glBufferStorage(int i, long j, int i2) {
        int i3 = i;
        long j2 = j;
        int i4 = i2;
        long j3 = GLContext.getCapabilities().glBufferStorage;
        BufferChecks.checkFunctionAddress(j3);
        nglBufferStorage(i3, j2, 0, i4, j3);
    }

    public static void glBufferStorage(int i, ByteBuffer byteBuffer, int i2) {
        int i3 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferStorage;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglBufferStorage(i3, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), i4, j);
    }

    public static void glBufferStorage(int i, DoubleBuffer doubleBuffer, int i2) {
        int i3 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferStorage;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglBufferStorage(i3, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), i4, j);
    }

    public static void glBufferStorage(int i, FloatBuffer floatBuffer, int i2) {
        int i3 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferStorage;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglBufferStorage(i3, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), i4, j);
    }

    public static void glBufferStorage(int i, IntBuffer intBuffer, int i2) {
        int i3 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferStorage;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglBufferStorage(i3, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), i4, j);
    }

    public static void glBufferStorage(int i, LongBuffer longBuffer, int i2) {
        int i3 = i;
        LongBuffer longBuffer2 = longBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferStorage;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglBufferStorage(i3, (long) (longBuffer2.remaining() << 3), MemoryUtil.getAddress(longBuffer2), i4, j);
    }

    public static void glBufferStorage(int i, ShortBuffer shortBuffer, int i2) {
        int i3 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBufferStorage;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglBufferStorage(i3, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), i4, j);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glClearTexImage;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, 1);
        }
        nglClearTexImage(i5, i6, i7, i8, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, DoubleBuffer doubleBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glClearTexImage;
        BufferChecks.checkFunctionAddress(j);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, 1);
        }
        nglClearTexImage(i5, i6, i7, i8, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glClearTexImage;
        BufferChecks.checkFunctionAddress(j);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, 1);
        }
        nglClearTexImage(i5, i6, i7, i8, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glClearTexImage;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        nglClearTexImage(i5, i6, i7, i8, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, LongBuffer longBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glClearTexImage;
        BufferChecks.checkFunctionAddress(j);
        if (longBuffer2 != null) {
            BufferChecks.checkBuffer(longBuffer2, 1);
        }
        nglClearTexImage(i5, i6, i7, i8, MemoryUtil.getAddressSafe(longBuffer2), j);
    }

    public static void glClearTexImage(int i, int i2, int i3, int i4, ShortBuffer shortBuffer) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glClearTexImage;
        BufferChecks.checkFunctionAddress(j);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, 1);
        }
        nglClearTexImage(i5, i6, i7, i8, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ByteBuffer byteBuffer) {
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
        long j = GLContext.getCapabilities().glClearTexSubImage;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer2 != null) {
            BufferChecks.checkBuffer(byteBuffer2, 1);
        }
        nglClearTexSubImage(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(byteBuffer2), j);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, DoubleBuffer doubleBuffer) {
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
        long j = GLContext.getCapabilities().glClearTexSubImage;
        BufferChecks.checkFunctionAddress(j);
        if (doubleBuffer2 != null) {
            BufferChecks.checkBuffer(doubleBuffer2, 1);
        }
        nglClearTexSubImage(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(doubleBuffer2), j);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, FloatBuffer floatBuffer) {
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
        long j = GLContext.getCapabilities().glClearTexSubImage;
        BufferChecks.checkFunctionAddress(j);
        if (floatBuffer2 != null) {
            BufferChecks.checkBuffer(floatBuffer2, 1);
        }
        nglClearTexSubImage(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(floatBuffer2), j);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IntBuffer intBuffer) {
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
        long j = GLContext.getCapabilities().glClearTexSubImage;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        nglClearTexSubImage(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, LongBuffer longBuffer) {
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
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glClearTexSubImage;
        BufferChecks.checkFunctionAddress(j);
        if (longBuffer2 != null) {
            BufferChecks.checkBuffer(longBuffer2, 1);
        }
        nglClearTexSubImage(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(longBuffer2), j);
    }

    public static void glClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, ShortBuffer shortBuffer) {
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
        long j = GLContext.getCapabilities().glClearTexSubImage;
        BufferChecks.checkFunctionAddress(j);
        if (shortBuffer2 != null) {
            BufferChecks.checkBuffer(shortBuffer2, 1);
        }
        nglClearTexSubImage(i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, MemoryUtil.getAddressSafe(shortBuffer2), j);
    }

    static native void nglBindBuffersBase(int i, int i2, int i3, long j, long j2);

    static native void nglBindBuffersRange(int i, int i2, int i3, long j, long j2, long j3, long j4);

    static native void nglBindImageTextures(int i, int i2, long j, long j2);

    static native void nglBindSamplers(int i, int i2, long j, long j2);

    static native void nglBindTextures(int i, int i2, long j, long j2);

    static native void nglBindVertexBuffers(int i, int i2, long j, long j2, long j3, long j4);

    static native void nglBufferStorage(int i, long j, long j2, int i2, long j3);

    static native void nglClearTexImage(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglClearTexSubImage(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j, long j2);
}
