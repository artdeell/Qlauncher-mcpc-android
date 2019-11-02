package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ATIElementArray {
    public static final int GL_ELEMENT_ARRAY_ATI = 34664;
    public static final int GL_ELEMENT_ARRAY_POINTER_ATI = 34666;
    public static final int GL_ELEMENT_ARRAY_TYPE_ATI = 34665;

    private ATIElementArray() {
    }

    public static void glDrawElementArrayATI(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDrawElementArrayATI;
        BufferChecks.checkFunctionAddress(j);
        nglDrawElementArrayATI(i3, i4, j);
    }

    public static void glDrawRangeElementArrayATI(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glDrawRangeElementArrayATI;
        BufferChecks.checkFunctionAddress(j);
        nglDrawRangeElementArrayATI(i5, i6, i7, i8, j);
    }

    public static void glElementPointerATI(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glElementPointerATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglElementPointerATI(GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glElementPointerATI(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glElementPointerATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglElementPointerATI(GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glElementPointerATI(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glElementPointerATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglElementPointerATI(GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglDrawElementArrayATI(int i, int i2, long j);

    static native void nglDrawRangeElementArrayATI(int i, int i2, int i3, int i4, long j);

    static native void nglElementPointerATI(int i, long j, long j2);
}
