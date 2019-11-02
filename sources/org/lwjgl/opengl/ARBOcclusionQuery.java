package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBOcclusionQuery {
    public static final int GL_CURRENT_QUERY_ARB = 34917;
    public static final int GL_QUERY_COUNTER_BITS_ARB = 34916;
    public static final int GL_QUERY_RESULT_ARB = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE_ARB = 34919;
    public static final int GL_SAMPLES_PASSED_ARB = 35092;

    private ARBOcclusionQuery() {
    }

    public static void glBeginQueryARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBeginQueryARB;
        BufferChecks.checkFunctionAddress(j);
        nglBeginQueryARB(i3, i4, j);
    }

    public static void glDeleteQueriesARB(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteQueriesARB;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteQueriesARB(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteQueriesARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteQueriesARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteQueriesARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glEndQueryARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glEndQueryARB;
        BufferChecks.checkFunctionAddress(j);
        nglEndQueryARB(i2, j);
    }

    public static int glGenQueriesARB() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenQueriesARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenQueriesARB(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenQueriesARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenQueriesARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenQueriesARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    @Deprecated
    public static int glGetQueryARB(int i, int i2) {
        return glGetQueryiARB(i, i2);
    }

    public static void glGetQueryARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetQueryivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetQueryivARB(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetQueryObjectARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetQueryObjectivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetQueryObjectivARB(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetQueryObjectiARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryObjectivARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetQueryObjectivARB(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetQueryObjectuARB(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetQueryObjectuivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetQueryObjectuivARB(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetQueryObjectuiARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryObjectuivARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetQueryObjectuivARB(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glGetQueryiARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryivARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetQueryivARB(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsQueryARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsQueryARB;
        BufferChecks.checkFunctionAddress(j);
        return nglIsQueryARB(i2, j);
    }

    static native void nglBeginQueryARB(int i, int i2, long j);

    static native void nglDeleteQueriesARB(int i, long j, long j2);

    static native void nglEndQueryARB(int i, long j);

    static native void nglGenQueriesARB(int i, long j, long j2);

    static native void nglGetQueryObjectivARB(int i, int i2, long j, long j2);

    static native void nglGetQueryObjectuivARB(int i, int i2, long j, long j2);

    static native void nglGetQueryivARB(int i, int i2, long j, long j2);

    static native boolean nglIsQueryARB(int i, long j);
}
