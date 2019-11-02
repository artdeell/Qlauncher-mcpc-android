package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class EXTVertexAttrib64bit {
    public static final int GL_DOUBLE_MAT2_EXT = 36678;
    public static final int GL_DOUBLE_MAT2x3_EXT = 36681;
    public static final int GL_DOUBLE_MAT2x4_EXT = 36682;
    public static final int GL_DOUBLE_MAT3_EXT = 36679;
    public static final int GL_DOUBLE_MAT3x2_EXT = 36683;
    public static final int GL_DOUBLE_MAT3x4_EXT = 36684;
    public static final int GL_DOUBLE_MAT4_EXT = 36680;
    public static final int GL_DOUBLE_MAT4x2_EXT = 36685;
    public static final int GL_DOUBLE_MAT4x3_EXT = 36686;
    public static final int GL_DOUBLE_VEC2_EXT = 36860;
    public static final int GL_DOUBLE_VEC3_EXT = 36861;
    public static final int GL_DOUBLE_VEC4_EXT = 36862;

    private EXTVertexAttrib64bit() {
    }

    public static void glGetVertexAttribLEXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glGetVertexAttribLdvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglGetVertexAttribLdvEXT(i3, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexArrayVertexAttribLOffsetEXT(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        ARBVertexAttrib64bit.glVertexArrayVertexAttribLOffsetEXT(i, i2, i3, i4, i5, i6, j);
    }

    public static void glVertexAttribL1EXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL1dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 1);
        nglVertexAttribL1dvEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribL1dEXT(int i, double d) {
        int i2 = i;
        double d2 = d;
        long j = GLContext.getCapabilities().glVertexAttribL1dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribL1dEXT(i2, d2, j);
    }

    public static void glVertexAttribL2EXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL2dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 2);
        nglVertexAttribL2dvEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribL2dEXT(int i, double d, double d2) {
        int i2 = i;
        double d3 = d;
        double d4 = d2;
        long j = GLContext.getCapabilities().glVertexAttribL2dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribL2dEXT(i2, d3, d4, j);
    }

    public static void glVertexAttribL3EXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL3dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 3);
        nglVertexAttribL3dvEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribL3dEXT(int i, double d, double d2, double d3) {
        int i2 = i;
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glVertexAttribL3dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribL3dEXT(i2, d4, d5, d6, j);
    }

    public static void glVertexAttribL4EXT(int i, DoubleBuffer doubleBuffer) {
        int i2 = i;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glVertexAttribL4dvEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(doubleBuffer2, 4);
        nglVertexAttribL4dvEXT(i2, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glVertexAttribL4dEXT(int i, double d, double d2, double d3, double d4) {
        int i2 = i;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j = GLContext.getCapabilities().glVertexAttribL4dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribL4dEXT(i2, d5, d6, d7, d8, j);
    }

    public static void glVertexAttribLPointerEXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexAttribLPointerEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexAttribLPointerEXTBO(i4, i5, 5130, i6, j2, j3);
    }

    public static void glVertexAttribLPointerEXT(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexAttribLPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).glVertexAttribPointer_buffer[i4] = doubleBuffer2;
        }
        nglVertexAttribLPointerEXT(i4, i5, 5130, i6, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    static native void nglGetVertexAttribLdvEXT(int i, int i2, long j, long j2);

    static native void nglVertexAttribL1dEXT(int i, double d, long j);

    static native void nglVertexAttribL1dvEXT(int i, long j, long j2);

    static native void nglVertexAttribL2dEXT(int i, double d, double d2, long j);

    static native void nglVertexAttribL2dvEXT(int i, long j, long j2);

    static native void nglVertexAttribL3dEXT(int i, double d, double d2, double d3, long j);

    static native void nglVertexAttribL3dvEXT(int i, long j, long j2);

    static native void nglVertexAttribL4dEXT(int i, double d, double d2, double d3, double d4, long j);

    static native void nglVertexAttribL4dvEXT(int i, long j, long j2);

    static native void nglVertexAttribLPointerEXT(int i, int i2, int i3, int i4, long j, long j2);

    static native void nglVertexAttribLPointerEXTBO(int i, int i2, int i3, int i4, long j, long j2);
}
