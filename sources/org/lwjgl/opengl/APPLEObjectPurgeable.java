package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class APPLEObjectPurgeable {
    public static final int GL_BUFFER_OBJECT_APPLE = 34227;
    public static final int GL_PURGEABLE_APPLE = 35357;
    public static final int GL_RELEASED_APPLE = 35353;
    public static final int GL_RETAINED_APPLE = 35355;
    public static final int GL_UNDEFINED_APPLE = 35356;
    public static final int GL_VOLATILE_APPLE = 35354;

    private APPLEObjectPurgeable() {
    }

    public static void glGetObjectParameterAPPLE(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetObjectParameterivAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetObjectParameterivAPPLE(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetObjectParameteriAPPLE(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetObjectParameterivAPPLE;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetObjectParameterivAPPLE(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static int glObjectPurgeableAPPLE(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glObjectPurgeableAPPLE;
        BufferChecks.checkFunctionAddress(j);
        return nglObjectPurgeableAPPLE(i4, i5, i6, j);
    }

    public static int glObjectUnpurgeableAPPLE(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glObjectUnpurgeableAPPLE;
        BufferChecks.checkFunctionAddress(j);
        return nglObjectUnpurgeableAPPLE(i4, i5, i6, j);
    }

    static native void nglGetObjectParameterivAPPLE(int i, int i2, int i3, long j, long j2);

    static native int nglObjectPurgeableAPPLE(int i, int i2, int i3, long j);

    static native int nglObjectUnpurgeableAPPLE(int i, int i2, int i3, long j);
}
