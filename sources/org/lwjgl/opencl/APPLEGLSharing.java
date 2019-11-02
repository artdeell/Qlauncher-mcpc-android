package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class APPLEGLSharing {
    public static final int CL_CGL_DEVICES_FOR_SUPPORTED_VIRTUAL_SCREENS_APPLE = 268435459;
    public static final int CL_CGL_DEVICE_FOR_CURRENT_VIRTUAL_SCREEN_APPLE = 268435458;
    public static final int CL_CONTEXT_PROPERTY_USE_CGL_SHAREGROUP_APPLE = 268435456;
    public static final int CL_INVALID_GL_CONTEXT_APPLE = -1000;

    private APPLEGLSharing() {
    }

    public static int clGetGLContextInfoAPPLE(CLContext cLContext, PointerBuffer pointerBuffer, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer2) {
        CLContext cLContext2 = cLContext;
        PointerBuffer pointerBuffer3 = pointerBuffer;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clGetGLContextInfoAPPLE;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(pointerBuffer3, 1);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        if (pointerBuffer4 == null && APIUtil.isDevicesParam(i2)) {
            pointerBuffer4 = APIUtil.getBufferPointer();
        }
        int nclGetGLContextInfoAPPLE = nclGetGLContextInfoAPPLE(cLContext2.getPointer(), MemoryUtil.getAddress(pointerBuffer3), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer4), j);
        if (nclGetGLContextInfoAPPLE == 0 && byteBuffer2 != null && APIUtil.isDevicesParam(i2)) {
            ((CLPlatform) cLContext2.getParent()).registerCLDevices(byteBuffer2, pointerBuffer4);
        }
        return nclGetGLContextInfoAPPLE;
    }

    static native int nclGetGLContextInfoAPPLE(long j, long j2, int i, long j3, long j4, long j5, long j6);
}
