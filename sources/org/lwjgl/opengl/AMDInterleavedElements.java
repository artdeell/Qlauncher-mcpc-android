package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class AMDInterleavedElements {
    public static final int GL_VERTEX_ELEMENT_SWIZZLE_AMD = 37284;
    public static final int GL_VERTEX_ID_SWIZZLE_AMD = 37285;

    private AMDInterleavedElements() {
    }

    public static void glVertexAttribParameteriAMD(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glVertexAttribParameteriAMD;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribParameteriAMD(i4, i5, i6, j);
    }

    static native void nglVertexAttribParameteriAMD(int i, int i2, int i3, long j);
}
