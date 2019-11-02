package org.lwjgl.opencl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.opengl.GLSync;

public final class KHRGLEvent {
    public static final int CL_COMMAND_GL_FENCE_SYNC_OBJECT_KHR = 8205;

    private KHRGLEvent() {
    }

    public static CLEvent clCreateEventFromGLsyncKHR(CLContext cLContext, GLSync gLSync, IntBuffer intBuffer) {
        CLEvent cLEvent;
        CLContext cLContext2 = cLContext;
        GLSync gLSync2 = gLSync;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clCreateEventFromGLsyncKHR;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        CLEvent cLEvent2 = cLEvent;
        CLEvent cLEvent3 = new CLEvent(nclCreateEventFromGLsyncKHR(cLContext2.getPointer(), gLSync2.getPointer(), MemoryUtil.getAddressSafe(intBuffer2), j), cLContext2);
        return cLEvent2;
    }

    static native long nclCreateEventFromGLsyncKHR(long j, long j2, long j3, long j4);
}
