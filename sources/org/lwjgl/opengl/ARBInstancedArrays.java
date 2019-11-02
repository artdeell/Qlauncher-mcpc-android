package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBInstancedArrays {
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB = 35070;

    private ARBInstancedArrays() {
    }

    public static void glVertexAttribDivisorARB(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glVertexAttribDivisorARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexAttribDivisorARB(i3, i4, j);
    }

    static native void nglVertexAttribDivisorARB(int i, int i2, long j);
}
