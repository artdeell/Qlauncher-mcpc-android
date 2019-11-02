package org.lwjgl.opencl;

import org.lwjgl.BufferChecks;

public final class KHRTerminateContext {
    public static final int CL_CONTEXT_TERMINATE_KHR = 8208;
    public static final int CL_DEVICE_TERMINATE_CAPABILITY_KHR = 8207;

    private KHRTerminateContext() {
    }

    public static int clTerminateContextKHR(CLContext cLContext) {
        CLContext cLContext2 = cLContext;
        long j = CLCapabilities.clTerminateContextKHR;
        BufferChecks.checkFunctionAddress(j);
        return nclTerminateContextKHR(cLContext2.getPointer(), j);
    }

    static native int nclTerminateContextKHR(long j, long j2);
}
