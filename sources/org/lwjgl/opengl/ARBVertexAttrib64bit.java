package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import org.lwjgl.BufferChecks;

public final class ARBVertexAttrib64bit {
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;

    private ARBVertexAttrib64bit() {
    }

    public static void glGetVertexAttribL(int i, int i2, DoubleBuffer doubleBuffer) {
        GL41.glGetVertexAttribL(i, i2, doubleBuffer);
    }

    public static void glVertexArrayVertexAttribLOffsetEXT(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j2 = j;
        long j3 = GLContext.getCapabilities().glVertexArrayVertexAttribLOffsetEXT;
        BufferChecks.checkFunctionAddress(j3);
        nglVertexArrayVertexAttribLOffsetEXT(i7, i8, i9, i10, i11, i12, j2, j3);
    }

    public static void glVertexAttribL1(int i, DoubleBuffer doubleBuffer) {
        GL41.glVertexAttribL1(i, doubleBuffer);
    }

    public static void glVertexAttribL1d(int i, double d) {
        GL41.glVertexAttribL1d(i, d);
    }

    public static void glVertexAttribL2(int i, DoubleBuffer doubleBuffer) {
        GL41.glVertexAttribL2(i, doubleBuffer);
    }

    public static void glVertexAttribL2d(int i, double d, double d2) {
        GL41.glVertexAttribL2d(i, d, d2);
    }

    public static void glVertexAttribL3(int i, DoubleBuffer doubleBuffer) {
        GL41.glVertexAttribL3(i, doubleBuffer);
    }

    public static void glVertexAttribL3d(int i, double d, double d2, double d3) {
        GL41.glVertexAttribL3d(i, d, d2, d3);
    }

    public static void glVertexAttribL4(int i, DoubleBuffer doubleBuffer) {
        GL41.glVertexAttribL4(i, doubleBuffer);
    }

    public static void glVertexAttribL4d(int i, double d, double d2, double d3, double d4) {
        GL41.glVertexAttribL4d(i, d, d2, d3, d4);
    }

    public static void glVertexAttribLPointer(int i, int i2, int i3, long j) {
        GL41.glVertexAttribLPointer(i, i2, i3, j);
    }

    public static void glVertexAttribLPointer(int i, int i2, int i3, DoubleBuffer doubleBuffer) {
        GL41.glVertexAttribLPointer(i, i2, i3, doubleBuffer);
    }

    static native void nglVertexArrayVertexAttribLOffsetEXT(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2);
}
