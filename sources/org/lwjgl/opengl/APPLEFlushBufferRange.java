package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class APPLEFlushBufferRange {
    public static final int GL_BUFFER_FLUSHING_UNMAP_APPLE = 35347;
    public static final int GL_BUFFER_SERIALIZED_MODIFY_APPLE = 35346;

    private APPLEFlushBufferRange() {
    }

    public static void glBufferParameteriAPPLE(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j = GLContext.getCapabilities().glBufferParameteriAPPLE;
        BufferChecks.checkFunctionAddress(j);
        nglBufferParameteriAPPLE(i4, i5, i6, j);
    }

    public static void glFlushMappedBufferRangeAPPLE(int i, long j, long j2) {
        int i2 = i;
        long j3 = j;
        long j4 = j2;
        long j5 = GLContext.getCapabilities().glFlushMappedBufferRangeAPPLE;
        BufferChecks.checkFunctionAddress(j5);
        nglFlushMappedBufferRangeAPPLE(i2, j3, j4, j5);
    }

    static native void nglBufferParameteriAPPLE(int i, int i2, int i3, long j);

    static native void nglFlushMappedBufferRangeAPPLE(int i, long j, long j2, long j3);
}
