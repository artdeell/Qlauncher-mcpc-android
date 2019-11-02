package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class EXTCompiledVertexArray {
    public static final int GL_ARRAY_ELEMENT_LOCK_COUNT_EXT = 33193;
    public static final int GL_ARRAY_ELEMENT_LOCK_FIRST_EXT = 33192;

    private EXTCompiledVertexArray() {
    }

    public static void glLockArraysEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glLockArraysEXT;
        BufferChecks.checkFunctionAddress(j);
        nglLockArraysEXT(i3, i4, j);
    }

    public static void glUnlockArraysEXT() {
        long j = GLContext.getCapabilities().glUnlockArraysEXT;
        BufferChecks.checkFunctionAddress(j);
        nglUnlockArraysEXT(j);
    }

    static native void nglLockArraysEXT(int i, int i2, long j);

    static native void nglUnlockArraysEXT(long j);
}
