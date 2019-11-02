package org.lwjgl.opencl;

import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class EXTMigrateMemobject {
    public static final int CL_COMMAND_MIGRATE_MEM_OBJECT_EXT = 16448;
    public static final int CL_MIGRATE_MEM_OBJECT_HOST_EXT = 1;

    private EXTMigrateMemobject() {
    }

    public static int clEnqueueMigrateMemObjectEXT(CLCommandQueue cLCommandQueue, PointerBuffer pointerBuffer, long j, PointerBuffer pointerBuffer2, PointerBuffer pointerBuffer3) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        PointerBuffer pointerBuffer4 = pointerBuffer;
        long j2 = j;
        PointerBuffer pointerBuffer5 = pointerBuffer2;
        PointerBuffer pointerBuffer6 = pointerBuffer3;
        long j3 = CLCapabilities.clEnqueueMigrateMemObjectEXT;
        BufferChecks.checkFunctionAddress(j3);
        BufferChecks.checkBuffer(pointerBuffer4, 1);
        if (pointerBuffer5 != null) {
            BufferChecks.checkDirect(pointerBuffer5);
        }
        if (pointerBuffer6 != null) {
            BufferChecks.checkBuffer(pointerBuffer6, 1);
        }
        int nclEnqueueMigrateMemObjectEXT = nclEnqueueMigrateMemObjectEXT(cLCommandQueue2.getPointer(), pointerBuffer4.remaining(), MemoryUtil.getAddress(pointerBuffer4), j2, pointerBuffer5 == null ? 0 : pointerBuffer5.remaining(), MemoryUtil.getAddressSafe(pointerBuffer5), MemoryUtil.getAddressSafe(pointerBuffer6), j3);
        if (nclEnqueueMigrateMemObjectEXT == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer6);
        }
        return nclEnqueueMigrateMemObjectEXT;
    }

    public static int clEnqueueMigrateMemObjectEXT(CLCommandQueue cLCommandQueue, CLMem cLMem, long j, PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        CLMem cLMem2 = cLMem;
        long j2 = j;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j3 = CLCapabilities.clEnqueueMigrateMemObjectEXT;
        BufferChecks.checkFunctionAddress(j3);
        if (pointerBuffer3 != null) {
            BufferChecks.checkDirect(pointerBuffer3);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        int nclEnqueueMigrateMemObjectEXT = nclEnqueueMigrateMemObjectEXT(cLCommandQueue2.getPointer(), 1, APIUtil.getPointer(cLMem2), j2, pointerBuffer3 == null ? 0 : pointerBuffer3.remaining(), MemoryUtil.getAddressSafe(pointerBuffer3), MemoryUtil.getAddressSafe(pointerBuffer4), j3);
        if (nclEnqueueMigrateMemObjectEXT == 0) {
            cLCommandQueue2.registerCLEvent(pointerBuffer4);
        }
        return nclEnqueueMigrateMemObjectEXT;
    }

    static native int nclEnqueueMigrateMemObjectEXT(long j, int i, long j2, long j3, int i2, long j4, long j5, long j6);
}
