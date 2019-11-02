package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class NVTextureBarrier {
    private NVTextureBarrier() {
    }

    public static void glTextureBarrierNV() {
        long j = GLContext.getCapabilities().glTextureBarrierNV;
        BufferChecks.checkFunctionAddress(j);
        nglTextureBarrierNV(j);
    }

    static native void nglTextureBarrierNV(long j);
}
