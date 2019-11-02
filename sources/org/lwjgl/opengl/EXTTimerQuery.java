package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTTimerQuery {
    public static final int GL_TIME_ELAPSED_EXT = 35007;

    private EXTTimerQuery() {
    }

    public static long glGetQueryObjectEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryObjecti64vEXT;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetQueryObjecti64vEXT(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static void glGetQueryObjectEXT(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetQueryObjecti64vEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetQueryObjecti64vEXT(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    public static long glGetQueryObjectuEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetQueryObjectui64vEXT;
        BufferChecks.checkFunctionAddress(j);
        LongBuffer bufferLong = APIUtil.getBufferLong(capabilities);
        nglGetQueryObjectui64vEXT(i3, i4, MemoryUtil.getAddress(bufferLong), j);
        return bufferLong.get(0);
    }

    public static void glGetQueryObjectuEXT(int i, int i2, LongBuffer longBuffer) {
        int i3 = i;
        int i4 = i2;
        LongBuffer longBuffer2 = longBuffer;
        long j = GLContext.getCapabilities().glGetQueryObjectui64vEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(longBuffer2, 1);
        nglGetQueryObjectui64vEXT(i3, i4, MemoryUtil.getAddress(longBuffer2), j);
    }

    static native void nglGetQueryObjecti64vEXT(int i, int i2, long j, long j2);

    static native void nglGetQueryObjectui64vEXT(int i, int i2, long j, long j2);
}
