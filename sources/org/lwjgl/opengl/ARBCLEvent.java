package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLEvent;

public final class ARBCLEvent {
    public static final int GL_SYNC_CL_EVENT_ARB = 33344;
    public static final int GL_SYNC_CL_EVENT_COMPLETE_ARB = 33345;

    private ARBCLEvent() {
    }

    public static GLSync glCreateSyncFromCLeventARB(CLContext cLContext, CLEvent cLEvent, int i) {
        GLSync gLSync;
        CLContext cLContext2 = cLContext;
        CLEvent cLEvent2 = cLEvent;
        int i2 = i;
        long j = GLContext.getCapabilities().glCreateSyncFromCLeventARB;
        BufferChecks.checkFunctionAddress(j);
        GLSync gLSync2 = gLSync;
        GLSync gLSync3 = new GLSync(nglCreateSyncFromCLeventARB(cLContext2.getPointer(), cLEvent2.getPointer(), i2, j));
        return gLSync2;
    }

    static native long nglCreateSyncFromCLeventARB(long j, long j2, int i, long j3);
}
