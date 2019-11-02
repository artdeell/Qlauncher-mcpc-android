package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBTransposeMatrix {
    public static final int GL_TRANSPOSE_COLOR_MATRIX_ARB = 34022;
    public static final int GL_TRANSPOSE_MODELVIEW_MATRIX_ARB = 34019;
    public static final int GL_TRANSPOSE_PROJECTION_MATRIX_ARB = 34020;
    public static final int GL_TRANSPOSE_TEXTURE_MATRIX_ARB = 34021;

    private ARBTransposeMatrix() {
    }

    public static void glLoadTransposeMatrixARB(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glLoadTransposeMatrixfARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglLoadTransposeMatrixfARB(MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMultTransposeMatrixARB(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMultTransposeMatrixfARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(floatBuffer2, 16);
        nglMultTransposeMatrixfARB(MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglLoadTransposeMatrixfARB(long j, long j2);

    static native void nglMultTransposeMatrixfARB(long j, long j2);
}
