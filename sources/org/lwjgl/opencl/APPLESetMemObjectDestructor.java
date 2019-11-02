package org.lwjgl.opencl;

import org.lwjgl.BufferChecks;

public final class APPLESetMemObjectDestructor {
    private APPLESetMemObjectDestructor() {
    }

    public static int clSetMemObjectDestructorAPPLE(CLMem cLMem, CLMemObjectDestructorCallback cLMemObjectDestructorCallback) {
        CLMem cLMem2 = cLMem;
        CLMemObjectDestructorCallback cLMemObjectDestructorCallback2 = cLMemObjectDestructorCallback;
        long j = CLCapabilities.clSetMemObjectDestructorAPPLE;
        BufferChecks.checkFunctionAddress(j);
        long createGlobalRef = CallbackUtil.createGlobalRef(cLMemObjectDestructorCallback2);
        try {
            int nclSetMemObjectDestructorAPPLE = nclSetMemObjectDestructorAPPLE(cLMem2.getPointer(), cLMemObjectDestructorCallback2.getPointer(), createGlobalRef, j);
            CallbackUtil.checkCallback(nclSetMemObjectDestructorAPPLE, createGlobalRef);
            return nclSetMemObjectDestructorAPPLE;
        } catch (Throwable th) {
            Throwable th2 = th;
            CallbackUtil.checkCallback(0, createGlobalRef);
            throw th2;
        }
    }

    static native int nclSetMemObjectDestructorAPPLE(long j, long j2, long j3, long j4);
}
