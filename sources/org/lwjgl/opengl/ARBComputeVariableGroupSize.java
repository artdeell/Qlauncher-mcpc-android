package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ARBComputeVariableGroupSize {
    public static final int GL_MAX_COMPUTE_FIXED_GROUP_INVOCATIONS_ARB = 37099;
    public static final int GL_MAX_COMPUTE_FIXED_GROUP_SIZE_ARB = 37311;
    public static final int GL_MAX_COMPUTE_VARIABLE_GROUP_INVOCATIONS_ARB = 37700;
    public static final int GL_MAX_COMPUTE_VARIABLE_GROUP_SIZE_ARB = 37701;

    private ARBComputeVariableGroupSize() {
    }

    public static void glDispatchComputeGroupSizeARB(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glDispatchComputeGroupSizeARB;
        BufferChecks.checkFunctionAddress(j);
        nglDispatchComputeGroupSizeARB(i7, i8, i9, i10, i11, i12, j);
    }

    static native void nglDispatchComputeGroupSizeARB(int i, int i2, int i3, int i4, int i5, int i6, long j);
}
