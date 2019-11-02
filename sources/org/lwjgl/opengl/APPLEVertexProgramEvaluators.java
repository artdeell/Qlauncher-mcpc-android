package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class APPLEVertexProgramEvaluators {
    public static final int GL_VERTEX_ATTRIB_MAP1_APPLE = 35328;
    public static final int GL_VERTEX_ATTRIB_MAP1_COEFF_APPLE = 35331;
    public static final int GL_VERTEX_ATTRIB_MAP1_DOMAIN_APPLE = 35333;
    public static final int GL_VERTEX_ATTRIB_MAP1_ORDER_APPLE = 35332;
    public static final int GL_VERTEX_ATTRIB_MAP1_SIZE_APPLE = 35330;
    public static final int GL_VERTEX_ATTRIB_MAP2_APPLE = 35329;
    public static final int GL_VERTEX_ATTRIB_MAP2_COEFF_APPLE = 35335;
    public static final int GL_VERTEX_ATTRIB_MAP2_DOMAIN_APPLE = 35337;
    public static final int GL_VERTEX_ATTRIB_MAP2_ORDER_APPLE = 35336;
    public static final int GL_VERTEX_ATTRIB_MAP2_SIZE_APPLE = 35334;

    private APPLEVertexProgramEvaluators() {
    }

    public static void glDisableVertexAttribAPPLE(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glDisableVertexAttribAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglDisableVertexAttribAPPLE(i3, i4, j);
    }

    public static void glEnableVertexAttribAPPLE(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glEnableVertexAttribAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglEnableVertexAttribAPPLE(i3, i4, j);
    }

    public static boolean glIsVertexAttribEnabledAPPLE(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glIsVertexAttribEnabledAPPLE;
        BufferChecks.checkFunctionAddress(j);
        return nglIsVertexAttribEnabledAPPLE(i3, i4, j);
    }

    public static void glMapVertexAttrib1dAPPLE(int i, int i2, double d, double d2, int i3, int i4, DoubleBuffer doubleBuffer) {
        int i5 = i;
        int i6 = i2;
        double d3 = d;
        double d4 = d2;
        int i7 = i3;
        int i8 = i4;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMapVertexAttrib1dAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglMapVertexAttrib1dAPPLE(i5, i6, d3, d4, i7, i8, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMapVertexAttrib1fAPPLE(int i, int i2, float f, float f2, int i3, int i4, FloatBuffer floatBuffer) {
        int i5 = i;
        int i6 = i2;
        float f3 = f;
        float f4 = f2;
        int i7 = i3;
        int i8 = i4;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMapVertexAttrib1fAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglMapVertexAttrib1fAPPLE(i5, i6, f3, f4, i7, i8, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glMapVertexAttrib2dAPPLE(int i, int i2, double d, double d2, int i3, int i4, double d3, double d4, int i5, int i6, DoubleBuffer doubleBuffer) {
        int i7 = i;
        int i8 = i2;
        double d5 = d;
        double d6 = d2;
        int i9 = i3;
        int i10 = i4;
        double d7 = d3;
        double d8 = d4;
        int i11 = i5;
        int i12 = i6;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glMapVertexAttrib2dAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglMapVertexAttrib2dAPPLE(i7, i8, d5, d6, i9, i10, d7, d8, i11, i12, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glMapVertexAttrib2fAPPLE(int i, int i2, float f, float f2, int i3, int i4, float f3, float f4, int i5, int i6, FloatBuffer floatBuffer) {
        int i7 = i;
        int i8 = i2;
        float f5 = f;
        float f6 = f2;
        int i9 = i3;
        int i10 = i4;
        float f7 = f3;
        float f8 = f4;
        int i11 = i5;
        int i12 = i6;
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glMapVertexAttrib2fAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglMapVertexAttrib2fAPPLE(i7, i8, f5, f6, i9, i10, f7, f8, i11, i12, MemoryUtil.getAddress(floatBuffer2), j);
    }

    static native void nglDisableVertexAttribAPPLE(int i, int i2, long j);

    static native void nglEnableVertexAttribAPPLE(int i, int i2, long j);

    static native boolean nglIsVertexAttribEnabledAPPLE(int i, int i2, long j);

    static native void nglMapVertexAttrib1dAPPLE(int i, int i2, double d, double d2, int i3, int i4, long j, long j2);

    static native void nglMapVertexAttrib1fAPPLE(int i, int i2, float f, float f2, int i3, int i4, long j, long j2);

    static native void nglMapVertexAttrib2dAPPLE(int i, int i2, double d, double d2, int i3, int i4, double d3, double d4, int i5, int i6, long j, long j2);

    static native void nglMapVertexAttrib2fAPPLE(int i, int i2, float f, float f2, int i3, int i4, float f3, float f4, int i5, int i6, long j, long j2);
}
