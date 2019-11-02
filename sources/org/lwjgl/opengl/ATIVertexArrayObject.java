package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ATIVertexArrayObject {
    public static final int GL_ARRAY_OBJECT_BUFFER_ATI = 34662;
    public static final int GL_ARRAY_OBJECT_OFFSET_ATI = 34663;
    public static final int GL_DISCARD_ATI = 34659;
    public static final int GL_DYNAMIC_ATI = 34657;
    public static final int GL_OBJECT_BUFFER_SIZE_ATI = 34660;
    public static final int GL_OBJECT_BUFFER_USAGE_ATI = 34661;
    public static final int GL_PRESERVE_ATI = 34658;
    public static final int GL_STATIC_ATI = 34656;

    private ATIVertexArrayObject() {
    }

    public static void glArrayObjectATI(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glArrayObjectATI;
        BufferChecks.checkFunctionAddress(j);
        nglArrayObjectATI(i7, i8, i9, i10, i11, i12, j);
    }

    public static void glFreeObjectBufferATI(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glFreeObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        nglFreeObjectBufferATI(i2, j);
    }

    public static void glGetArrayObjectATI(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetArrayObjectfvATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetArrayObjectfvATI(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetArrayObjectATI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetArrayObjectivATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetArrayObjectivATI(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetObjectBufferATI(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetObjectBufferfvATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglGetObjectBufferfvATI(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetObjectBufferATI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetObjectBufferivATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetObjectBufferivATI(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetObjectBufferiATI(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetObjectBufferivATI;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetObjectBufferivATI(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetVariantArrayObjectATI(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glGetVariantArrayObjectfvATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 4);
        nglGetVariantArrayObjectfvATI(i3, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glGetVariantArrayObjectATI(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetVariantArrayObjectivATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetVariantArrayObjectivATI(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsObjectBufferATI(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        return nglIsObjectBufferATI(i2, j);
    }

    public static int glNewObjectBufferATI(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glNewObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        return nglNewObjectBufferATI(i3, 0, i4, j);
    }

    public static int glNewObjectBufferATI(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i2 = i;
        long j = GLContext.getCapabilities().glNewObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        return nglNewObjectBufferATI(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), i2, j);
    }

    public static int glNewObjectBufferATI(DoubleBuffer doubleBuffer, int i) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i2 = i;
        long j = GLContext.getCapabilities().glNewObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        return nglNewObjectBufferATI(doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), i2, j);
    }

    public static int glNewObjectBufferATI(FloatBuffer floatBuffer, int i) {
        FloatBuffer floatBuffer2 = floatBuffer;
        int i2 = i;
        long j = GLContext.getCapabilities().glNewObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        return nglNewObjectBufferATI(floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), i2, j);
    }

    public static int glNewObjectBufferATI(IntBuffer intBuffer, int i) {
        IntBuffer intBuffer2 = intBuffer;
        int i2 = i;
        long j = GLContext.getCapabilities().glNewObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        return nglNewObjectBufferATI(intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), i2, j);
    }

    public static int glNewObjectBufferATI(ShortBuffer shortBuffer, int i) {
        ShortBuffer shortBuffer2 = shortBuffer;
        int i2 = i;
        long j = GLContext.getCapabilities().glNewObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        return nglNewObjectBufferATI(shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), i2, j);
    }

    public static void glUpdateObjectBufferATI(int i, int i2, ByteBuffer byteBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUpdateObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglUpdateObjectBufferATI(i4, i5, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), i6, j);
    }

    public static void glUpdateObjectBufferATI(int i, int i2, DoubleBuffer doubleBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUpdateObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglUpdateObjectBufferATI(i4, i5, doubleBuffer2.remaining() << 3, MemoryUtil.getAddress(doubleBuffer2), i6, j);
    }

    public static void glUpdateObjectBufferATI(int i, int i2, FloatBuffer floatBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUpdateObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglUpdateObjectBufferATI(i4, i5, floatBuffer2.remaining() << 2, MemoryUtil.getAddress(floatBuffer2), i6, j);
    }

    public static void glUpdateObjectBufferATI(int i, int i2, IntBuffer intBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        IntBuffer intBuffer2 = intBuffer;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUpdateObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglUpdateObjectBufferATI(i4, i5, intBuffer2.remaining() << 2, MemoryUtil.getAddress(intBuffer2), i6, j);
    }

    public static void glUpdateObjectBufferATI(int i, int i2, ShortBuffer shortBuffer, int i3) {
        int i4 = i;
        int i5 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUpdateObjectBufferATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglUpdateObjectBufferATI(i4, i5, shortBuffer2.remaining() << 1, MemoryUtil.getAddress(shortBuffer2), i6, j);
    }

    public static void glVariantArrayObjectATI(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glVariantArrayObjectATI;
        BufferChecks.checkFunctionAddress(j);
        nglVariantArrayObjectATI(i6, i7, i8, i9, i10, j);
    }

    static native void nglArrayObjectATI(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglFreeObjectBufferATI(int i, long j);

    static native void nglGetArrayObjectfvATI(int i, int i2, long j, long j2);

    static native void nglGetArrayObjectivATI(int i, int i2, long j, long j2);

    static native void nglGetObjectBufferfvATI(int i, int i2, long j, long j2);

    static native void nglGetObjectBufferivATI(int i, int i2, long j, long j2);

    static native void nglGetVariantArrayObjectfvATI(int i, int i2, long j, long j2);

    static native void nglGetVariantArrayObjectivATI(int i, int i2, long j, long j2);

    static native boolean nglIsObjectBufferATI(int i, long j);

    static native int nglNewObjectBufferATI(int i, long j, int i2, long j2);

    static native void nglUpdateObjectBufferATI(int i, int i2, int i3, long j, int i4, long j2);

    static native void nglVariantArrayObjectATI(int i, int i2, int i3, int i4, int i5, long j);
}
