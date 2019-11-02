package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class ATISeparateStencil {
    public static final int GL_STENCIL_BACK_FAIL_ATI = 34817;
    public static final int GL_STENCIL_BACK_FUNC_ATI = 34816;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL_ATI = 34818;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS_ATI = 34819;

    private ATISeparateStencil() {
    }

    public static void glStencilFuncSeparateATI(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glStencilFuncSeparateATI;
        BufferChecks.checkFunctionAddress(j);
        nglStencilFuncSeparateATI(i5, i6, i7, i8, j);
    }

    public static void glStencilOpSeparateATI(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glStencilOpSeparateATI;
        BufferChecks.checkFunctionAddress(j);
        nglStencilOpSeparateATI(i5, i6, i7, i8, j);
    }

    static native void nglStencilFuncSeparateATI(int i, int i2, int i3, int i4, long j);

    static native void nglStencilOpSeparateATI(int i, int i2, int i3, int i4, long j);
}
