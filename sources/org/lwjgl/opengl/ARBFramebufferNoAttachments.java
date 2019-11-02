package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBFramebufferNoAttachments {
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;

    private ARBFramebufferNoAttachments() {
    }

    public static void glFramebufferParameteri(int i, int i2, int i3) {
        GL43.glFramebufferParameteri(i, i2, i3);
    }

    public static void glGetFramebufferParameter(int i, int i2, IntBuffer intBuffer) {
        GL43.glGetFramebufferParameter(i, i2, intBuffer);
    }

    public static int glGetFramebufferParameteri(int i, int i2) {
        return GL43.glGetFramebufferParameteri(i, i2);
    }

    public static int glGetNamedFramebufferParameterEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedFramebufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetNamedFramebufferParameterivEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetNamedFramebufferParameterEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetNamedFramebufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetNamedFramebufferParameterivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glNamedFramebufferParameteriEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glNamedFramebufferParameteriEXT;
        BufferChecks.checkFunctionAddress(j);
        nglNamedFramebufferParameteriEXT(i4, i5, i6, j);
    }

    static native void nglGetNamedFramebufferParameterivEXT(int i, int i2, long j, long j2);

    static native void nglNamedFramebufferParameteriEXT(int i, int i2, int i3, long j);
}
