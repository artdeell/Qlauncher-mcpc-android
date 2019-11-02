package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class EXTVertexWeighting {
    public static final int GL_CURRENT_VERTEX_WEIGHT_EXT = 34059;
    public static final int GL_MODELVIEW0_EXT = 5888;
    public static final int GL_MODELVIEW0_MATRIX_EXT = 2982;
    public static final int GL_MODELVIEW0_STACK_DEPTH_EXT = 2979;
    public static final int GL_MODELVIEW1_EXT = 34058;
    public static final int GL_MODELVIEW1_MATRIX_EXT = 34054;
    public static final int GL_MODELVIEW1_STACK_DEPTH_EXT = 34050;
    public static final int GL_VERTEX_WEIGHTING_EXT = 34057;
    public static final int GL_VERTEX_WEIGHT_ARRAY_EXT = 34060;
    public static final int GL_VERTEX_WEIGHT_ARRAY_POINTER_EXT = 34064;
    public static final int GL_VERTEX_WEIGHT_ARRAY_SIZE_EXT = 34061;
    public static final int GL_VERTEX_WEIGHT_ARRAY_STRIDE_EXT = 34063;
    public static final int GL_VERTEX_WEIGHT_ARRAY_TYPE_EXT = 34062;

    private EXTVertexWeighting() {
    }

    public static void glVertexWeightPointerEXT(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glVertexWeightPointerEXT;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglVertexWeightPointerEXTBO(i4, i5, i6, j2, j3);
    }

    public static void glVertexWeightPointerEXT(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glVertexWeightPointerEXT;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).EXT_vertex_weighting_glVertexWeightPointerEXT_pPointer = floatBuffer2;
        }
        nglVertexWeightPointerEXT(i3, GL11.GL_FLOAT, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glVertexWeightfEXT(float f) {
        float f2 = f;
        long j = GLContext.getCapabilities().glVertexWeightfEXT;
        BufferChecks.checkFunctionAddress(j);
        nglVertexWeightfEXT(f2, j);
    }

    static native void nglVertexWeightPointerEXT(int i, int i2, int i3, long j, long j2);

    static native void nglVertexWeightPointerEXTBO(int i, int i2, int i3, long j, long j2);

    static native void nglVertexWeightfEXT(float f, long j);
}
