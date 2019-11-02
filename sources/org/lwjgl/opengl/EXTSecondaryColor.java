package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class EXTSecondaryColor {
    public static final int GL_COLOR_SUM_EXT = 33880;
    public static final int GL_CURRENT_SECONDARY_COLOR_EXT = 33881;
    public static final int GL_SECONDARY_COLOR_ARRAY_EXT = 33886;
    public static final int GL_SECONDARY_COLOR_ARRAY_POINTER_EXT = 33885;
    public static final int GL_SECONDARY_COLOR_ARRAY_SIZE_EXT = 33882;
    public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE_EXT = 33884;
    public static final int GL_SECONDARY_COLOR_ARRAY_TYPE_EXT = 33883;

    private EXTSecondaryColor() {
    }

    public static void glSecondaryColor3bEXT(byte b, byte b2, byte b3) {
        byte b4 = b;
        byte b5 = b2;
        byte b6 = b3;
        long j = GLContext.getCapabilities().glSecondaryColor3bEXT;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3bEXT(b4, b5, b6, j);
    }

    public static void glSecondaryColor3dEXT(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        long j = GLContext.getCapabilities().glSecondaryColor3dEXT;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3dEXT(d4, d5, d6, j);
    }

    public static void glSecondaryColor3fEXT(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        long j = GLContext.getCapabilities().glSecondaryColor3fEXT;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3fEXT(f4, f5, f6, j);
    }

    public static void glSecondaryColor3ubEXT(byte b, byte b2, byte b3) {
        byte b4 = b;
        byte b5 = b2;
        byte b6 = b3;
        long j = GLContext.getCapabilities().glSecondaryColor3ubEXT;
        BufferChecks.checkFunctionAddress(j);
        nglSecondaryColor3ubEXT(b4, b5, b6, j);
    }

    public static void glSecondaryColorPointerEXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glSecondaryColorPointerEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglSecondaryColorPointerEXTBO(i4, i5, i6, j2, j3);
    }

    public static void glSecondaryColorPointerEXT(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSecondaryColorPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = doubleBuffer2;
        }
        nglSecondaryColorPointerEXT(i3, 5130, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glSecondaryColorPointerEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSecondaryColorPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = floatBuffer2;
        }
        nglSecondaryColorPointerEXT(i3, GL11.GL_FLOAT, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glSecondaryColorPointerEXT(int i, boolean z, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glSecondaryColorPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = byteBuffer2;
        }
        nglSecondaryColorPointerEXT(i3, z2 ? 5121 : 5120, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    static native void nglSecondaryColor3bEXT(byte b, byte b2, byte b3, long j);

    static native void nglSecondaryColor3dEXT(double d, double d2, double d3, long j);

    static native void nglSecondaryColor3fEXT(float f, float f2, float f3, long j);

    static native void nglSecondaryColor3ubEXT(byte b, byte b2, byte b3, long j);

    static native void nglSecondaryColorPointerEXT(int i, int i2, int i3, long j, long j2);

    static native void nglSecondaryColorPointerEXTBO(int i, int i2, int i3, long j, long j2);
}
