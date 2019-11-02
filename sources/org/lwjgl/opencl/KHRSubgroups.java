package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class KHRSubgroups {
    private KHRSubgroups() {
    }

    public static int clGetKernelSubGroupInfoKHR(CLKernel cLKernel, CLDevice cLDevice, int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, PointerBuffer pointerBuffer) {
        CLKernel cLKernel2 = cLKernel;
        CLDevice cLDevice2 = cLDevice;
        int i2 = i;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = CLCapabilities.clGetKernelSubGroupInfoKHR;
        BufferChecks.checkFunctionAddress(j);
        if (byteBuffer3 != null) {
            BufferChecks.checkDirect(byteBuffer3);
        }
        if (byteBuffer4 != null) {
            BufferChecks.checkDirect(byteBuffer4);
        }
        if (pointerBuffer2 != null) {
            BufferChecks.checkBuffer(pointerBuffer2, 1);
        }
        return nclGetKernelSubGroupInfoKHR(cLKernel2.getPointer(), cLDevice2 == null ? 0 : cLDevice2.getPointer(), i2, (long) (byteBuffer3 == null ? 0 : byteBuffer3.remaining()), MemoryUtil.getAddressSafe(byteBuffer3), (long) (byteBuffer4 == null ? 0 : byteBuffer4.remaining()), MemoryUtil.getAddressSafe(byteBuffer4), MemoryUtil.getAddressSafe(pointerBuffer2), j);
    }

    static native int nclGetKernelSubGroupInfoKHR(long j, long j2, int i, long j3, long j4, long j5, long j6, long j7, long j8);
}
