package org.lwjgl.opencl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class KHRICD {
    public static final int CL_PLATFORM_ICD_SUFFIX_KHR = 2336;
    public static final int CL_PLATFORM_NOT_FOUND_KHR = -1001;

    private KHRICD() {
    }

    public static int clIcdGetPlatformIDsKHR(PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        long j = CLCapabilities.clIcdGetPlatformIDsKHR;
        BufferChecks.checkFunctionAddress(j);
        if (pointerBuffer2 != null) {
            BufferChecks.checkDirect(pointerBuffer2);
        }
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        return nclIcdGetPlatformIDsKHR(pointerBuffer2 == null ? 0 : pointerBuffer2.remaining(), MemoryUtil.getAddressSafe(pointerBuffer2), MemoryUtil.getAddressSafe(intBuffer2), j);
    }

    static native int nclIcdGetPlatformIDsKHR(int i, long j, long j2, long j3);
}
