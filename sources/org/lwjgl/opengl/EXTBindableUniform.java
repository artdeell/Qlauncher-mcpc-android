package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTBindableUniform {
    public static final int GL_MAX_BINDABLE_UNIFORM_SIZE_EXT = 36333;
    public static final int GL_MAX_FRAGMENT_BINDABLE_UNIFORMS_EXT = 36323;
    public static final int GL_MAX_GEOMETRY_BINDABLE_UNIFORMS_EXT = 36324;
    public static final int GL_MAX_VERTEX_BINDABLE_UNIFORMS_EXT = 36322;
    public static final int GL_UNIFORM_BUFFER_BINDING_EXT = 36335;
    public static final int GL_UNIFORM_BUFFER_EXT = 36334;

    private EXTBindableUniform() {
    }

    public static int glGetUniformBufferSizeEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glGetUniformBufferSizeEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglGetUniformBufferSizeEXT(i3, i4, j);
    }

    public static long glGetUniformOffsetEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glGetUniformOffsetEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglGetUniformOffsetEXT(i3, i4, j);
    }

    public static void glUniformBufferEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glUniformBufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglUniformBufferEXT(i4, i5, i6, j);
    }

    static native int nglGetUniformBufferSizeEXT(int i, int i2, long j);

    static native long nglGetUniformOffsetEXT(int i, int i2, long j);

    static native void nglUniformBufferEXT(int i, int i2, int i3, long j);
}
