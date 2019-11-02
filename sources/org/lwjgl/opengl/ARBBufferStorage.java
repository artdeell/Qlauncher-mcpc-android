package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBBufferStorage {
    public static final int GL_BUFFER_IMMUTABLE_STORAGE = 33311;
    public static final int GL_BUFFER_STORAGE_FLAGS = 33312;
    public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 16384;
    public static final int GL_CLIENT_STORAGE_BIT = 512;
    public static final int GL_DYNAMIC_STORAGE_BIT = 256;
    public static final int GL_MAP_COHERENT_BIT = 128;
    public static final int GL_MAP_PERSISTENT_BIT = 64;

    private ARBBufferStorage() {
    }

    public static void glBufferStorage(int i, long j, int i2) {
        GL44.glBufferStorage(i, j, i2);
    }

    public static void glBufferStorage(int i, ByteBuffer byteBuffer, int i2) {
        GL44.glBufferStorage(i, byteBuffer, i2);
    }

    public static void glBufferStorage(int i, DoubleBuffer doubleBuffer, int i2) {
        GL44.glBufferStorage(i, doubleBuffer, i2);
    }

    public static void glBufferStorage(int i, FloatBuffer floatBuffer, int i2) {
        GL44.glBufferStorage(i, floatBuffer, i2);
    }

    public static void glBufferStorage(int i, IntBuffer intBuffer, int i2) {
        GL44.glBufferStorage(i, intBuffer, i2);
    }

    public static void glBufferStorage(int i, LongBuffer longBuffer, int i2) {
        GL44.glBufferStorage(i, longBuffer, i2);
    }

    public static void glBufferStorage(int i, ShortBuffer shortBuffer, int i2) {
        GL44.glBufferStorage(i, shortBuffer, i2);
    }

    public static void glNamedBufferStorageEXT(int i, long j, int i2) {
        int i3 = i;
        long j2 = j;
        int i4 = i2;
        long j3 = GLContext.getCapabilities().glNamedBufferStorageEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglNamedBufferStorageEXT(i3, j2, 0, i4, j3);
    }

    public static void glNamedBufferStorageEXT(int i, ByteBuffer byteBuffer, int i2) {
        int i3 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferStorageEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglNamedBufferStorageEXT(i3, (long) byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), i4, j);
    }

    public static void glNamedBufferStorageEXT(int i, DoubleBuffer doubleBuffer, int i2) {
        int i3 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferStorageEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglNamedBufferStorageEXT(i3, (long) (doubleBuffer2.remaining() << 3), MemoryUtil.getAddress(doubleBuffer2), i4, j);
    }

    public static void glNamedBufferStorageEXT(int i, FloatBuffer floatBuffer, int i2) {
        int i3 = i;
        FloatBuffer floatBuffer2 = floatBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferStorageEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglNamedBufferStorageEXT(i3, (long) (floatBuffer2.remaining() << 2), MemoryUtil.getAddress(floatBuffer2), i4, j);
    }

    public static void glNamedBufferStorageEXT(int i, IntBuffer intBuffer, int i2) {
        int i3 = i;
        IntBuffer intBuffer2 = intBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferStorageEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglNamedBufferStorageEXT(i3, (long) (intBuffer2.remaining() << 2), MemoryUtil.getAddress(intBuffer2), i4, j);
    }

    public static void glNamedBufferStorageEXT(int i, LongBuffer longBuffer, int i2) {
        int i3 = i;
        LongBuffer longBuffer2 = longBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferStorageEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(longBuffer2);
        nglNamedBufferStorageEXT(i3, (long) (longBuffer2.remaining() << 3), MemoryUtil.getAddress(longBuffer2), i4, j);
    }

    public static void glNamedBufferStorageEXT(int i, ShortBuffer shortBuffer, int i2) {
        int i3 = i;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNamedBufferStorageEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglNamedBufferStorageEXT(i3, (long) (shortBuffer2.remaining() << 1), MemoryUtil.getAddress(shortBuffer2), i4, j);
    }

    static native void nglNamedBufferStorageEXT(int i, long j, long j2, int i2, long j3);
}
