package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;

public final class GREMEDYFrameTerminator {
    private GREMEDYFrameTerminator() {
    }

    public static void glFrameTerminatorGREMEDY() {
        long j = GLContext.getCapabilities().glFrameTerminatorGREMEDY;
        BufferChecks.checkFunctionAddress(j);
        nglFrameTerminatorGREMEDY(j);
    }

    static native void nglFrameTerminatorGREMEDY(long j);
}
