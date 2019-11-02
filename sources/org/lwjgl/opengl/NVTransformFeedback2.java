package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class NVTransformFeedback2 {
    public static final int GL_TRANSFORM_FEEDBACK_BINDING_NV = 36389;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE_NV = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED_NV = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_NV = 36386;

    private NVTransformFeedback2() {
    }

    public static void glBindTransformFeedbackNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindTransformFeedbackNV;
        BufferChecks.checkFunctionAddress(j);
        nglBindTransformFeedbackNV(i3, i4, j);
    }

    public static void glDeleteTransformFeedbacksNV(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteTransformFeedbacksNV;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteTransformFeedbacksNV(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteTransformFeedbacksNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteTransformFeedbacksNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteTransformFeedbacksNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDrawTransformFeedbackNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDrawTransformFeedbackNV;
        BufferChecks.checkFunctionAddress(j);
        nglDrawTransformFeedbackNV(i3, i4, j);
    }

    public static int glGenTransformFeedbacksNV() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenTransformFeedbacksNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenTransformFeedbacksNV(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenTransformFeedbacksNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenTransformFeedbacksNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenTransformFeedbacksNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsTransformFeedbackNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsTransformFeedbackNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsTransformFeedbackNV(i2, j);
    }

    public static void glPauseTransformFeedbackNV() {
        long j = GLContext.getCapabilities().glPauseTransformFeedbackNV;
        BufferChecks.checkFunctionAddress(j);
        nglPauseTransformFeedbackNV(j);
    }

    public static void glResumeTransformFeedbackNV() {
        long j = GLContext.getCapabilities().glResumeTransformFeedbackNV;
        BufferChecks.checkFunctionAddress(j);
        nglResumeTransformFeedbackNV(j);
    }

    static native void nglBindTransformFeedbackNV(int i, int i2, long j);

    static native void nglDeleteTransformFeedbacksNV(int i, long j, long j2);

    static native void nglDrawTransformFeedbackNV(int i, int i2, long j);

    static native void nglGenTransformFeedbacksNV(int i, long j, long j2);

    static native boolean nglIsTransformFeedbackNV(int i, long j);

    static native void nglPauseTransformFeedbackNV(long j);

    static native void nglResumeTransformFeedbackNV(long j);
}
