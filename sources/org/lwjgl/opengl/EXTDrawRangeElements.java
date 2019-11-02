package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTDrawRangeElements {
    public static final int GL_MAX_ELEMENTS_INDICES_EXT = 33001;
    public static final int GL_MAX_ELEMENTS_VERTICES_EXT = 33000;

    private EXTDrawRangeElements() {
    }

    public static void glDrawRangeElementsEXT(int i, int i2, int i3, int i4, int i5, long j) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glDrawRangeElementsEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureElementVBOenabled(capabilities);
        nglDrawRangeElementsEXTBO(i6, i7, i8, i9, i10, j2, j3);
    }

    public static void glDrawRangeElementsEXT(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElementsEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        nglDrawRangeElementsEXT(i4, i5, i6, byteBuffer2.remaining(), GL11.GL_UNSIGNED_BYTE, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glDrawRangeElementsEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElementsEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawRangeElementsEXT(i4, i5, i6, intBuffer2.remaining(), GL11.GL_UNSIGNED_INT, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDrawRangeElementsEXT(int i, int i2, int i3, ShortBuffer shortBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawRangeElementsEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureElementVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        nglDrawRangeElementsEXT(i4, i5, i6, shortBuffer2.remaining(), GL11.GL_UNSIGNED_SHORT, MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglDrawRangeElementsEXT(int i, int i2, int i3, int i4, int i5, long j, long j2);

    static native void nglDrawRangeElementsEXTBO(int i, int i2, int i3, int i4, int i5, long j, long j2);
}
