package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class APPLEVertexArrayObject {
    public static final int GL_VERTEX_ARRAY_BINDING_APPLE = 34229;

    private APPLEVertexArrayObject() {
    }

    public static void glBindVertexArrayAPPLE(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glBindVertexArrayAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglBindVertexArrayAPPLE(i2, j);
    }

    public static void glDeleteVertexArraysAPPLE(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteVertexArraysAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteVertexArraysAPPLE(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteVertexArraysAPPLE(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteVertexArraysAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteVertexArraysAPPLE(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenVertexArraysAPPLE() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenVertexArraysAPPLE;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenVertexArraysAPPLE(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenVertexArraysAPPLE(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenVertexArraysAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenVertexArraysAPPLE(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsVertexArrayAPPLE(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsVertexArrayAPPLE;
        BufferChecks.checkFunctionAddress(j);
        return nglIsVertexArrayAPPLE(i2, j);
    }

    static native void nglBindVertexArrayAPPLE(int i, long j);

    static native void nglDeleteVertexArraysAPPLE(int i, long j, long j2);

    static native void nglGenVertexArraysAPPLE(int i, long j, long j2);

    static native boolean nglIsVertexArrayAPPLE(int i, long j);
}
