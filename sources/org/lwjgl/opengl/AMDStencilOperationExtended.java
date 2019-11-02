package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class AMDStencilOperationExtended {
    public static final int GL_AND = 5377;
    public static final int GL_EQUIV = 5385;
    public static final int GL_NAND = 5390;
    public static final int GL_NOR = 5384;
    public static final int GL_OR = 5383;
    public static final int GL_REPLACE_VALUE_AMD = 34635;
    public static final int GL_SET_AMD = 34634;
    public static final int GL_STENCIL_BACK_OP_VALUE_AMD = 34637;
    public static final int GL_STENCIL_OP_VALUE_AMD = 34636;
    public static final int GL_XOR = 5382;

    private AMDStencilOperationExtended() {
    }

    public static void glStencilOpValueAMD(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glStencilOpValueAMD;
        BufferChecks.checkFunctionAddress(j);
        nglStencilOpValueAMD(i3, i4, j);
    }

    static native void nglStencilOpValueAMD(int i, int i2, long j);
}
