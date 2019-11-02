package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTDrawBuffers2 {
    private EXTDrawBuffers2() {
    }

    public static void glColorMaskIndexedEXT(int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int i2 = i;
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        long j = GLContext.getCapabilities().glColorMaskIndexedEXT;
        BufferChecks.checkFunctionAddress(j);
        nglColorMaskIndexedEXT(i2, z5, z6, z7, z8, j);
    }

    public static void glDisableIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDisableIndexedEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDisableIndexedEXT(i3, i4, j);
    }

    public static void glEnableIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEnableIndexedEXT;
        BufferChecks.checkFunctionAddress(j);
        nglEnableIndexedEXT(i3, i4, j);
    }

    public static void glGetBooleanIndexedEXT(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetBooleanIndexedvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(byteBuffer2, 4);
        nglGetBooleanIndexedvEXT(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static boolean glGetBooleanIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetBooleanIndexedvEXT;
        BufferChecks.checkFunctionAddress(j);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, 1);
        nglGetBooleanIndexedvEXT(i3, i4, MemoryUtil.getAddress(bufferByte), j);
        return bufferByte.get(0) == 1;
    }

    public static int glGetIntegerIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetIntegerIndexedvEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetIntegerIndexedvEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetIntegerIndexedEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetIntegerIndexedvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetIntegerIndexedvEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsEnabledIndexedEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glIsEnabledIndexedEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglIsEnabledIndexedEXT(i3, i4, j);
    }

    static native void nglColorMaskIndexedEXT(int i, boolean z, boolean z2, boolean z3, boolean z4, long j);

    static native void nglDisableIndexedEXT(int i, int i2, long j);

    static native void nglEnableIndexedEXT(int i, int i2, long j);

    static native void nglGetBooleanIndexedvEXT(int i, int i2, long j, long j2);

    static native void nglGetIntegerIndexedvEXT(int i, int i2, long j, long j2);

    static native boolean nglIsEnabledIndexedEXT(int i, int i2, long j);
}
