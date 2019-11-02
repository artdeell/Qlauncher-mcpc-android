package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class APPLEElementArray {
    public static final int GL_ELEMENT_ARRAY_APPLE = 34664;
    public static final int GL_ELEMENT_ARRAY_POINTER_APPLE = 34666;
    public static final int GL_ELEMENT_ARRAY_TYPE_APPLE = 34665;

    private APPLEElementArray() {
    }

    public static void glDrawElementArrayAPPLE(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glDrawElementArrayAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglDrawElementArrayAPPLE(i4, i5, i6, j);
    }

    public static void glDrawRangeElementArrayAPPLE(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glDrawRangeElementArrayAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglDrawRangeElementArrayAPPLE(i6, i7, i8, i9, i10, j);
    }

    public static void glElementPointerAPPLE(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glElementPointerAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglElementPointerAPPLE(GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glElementPointerAPPLE(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glElementPointerAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglElementPointerAPPLE(GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glElementPointerAPPLE(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glElementPointerAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglElementPointerAPPLE(GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glMultiDrawElementArrayAPPLE(int i, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i2 = i;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glMultiDrawElementArrayAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkBuffer(intBuffer4, intBuffer3.remaining());
        nglMultiDrawElementArrayAPPLE(i2, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), intBuffer3.remaining(), j);
    }

    public static void glMultiDrawRangeElementArrayAPPLE(int i, int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        long j = GLContext.getCapabilities().glMultiDrawRangeElementArrayAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer3);
        BufferChecks.checkBuffer(intBuffer4, intBuffer3.remaining());
        nglMultiDrawRangeElementArrayAPPLE(i4, i5, i6, MemoryUtil.getAddress(intBuffer3), MemoryUtil.getAddress(intBuffer4), intBuffer3.remaining(), j);
    }

    static native void nglDrawElementArrayAPPLE(int i, int i2, int i3, long j);

    static native void nglDrawRangeElementArrayAPPLE(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglElementPointerAPPLE(int i, long j, long j2);

    static native void nglMultiDrawElementArrayAPPLE(int i, long j, long j2, int i2, long j3);

    static native void nglMultiDrawRangeElementArrayAPPLE(int i, int i2, int i3, long j, long j2, int i4, long j3);
}
