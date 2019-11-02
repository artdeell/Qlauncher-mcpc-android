package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;

public final class KHRGLSharing {
    public static final int CL_CGL_SHAREGROUP_KHR = 8204;
    public static final int CL_CURRENT_DEVICE_FOR_GL_CONTEXT_KHR = 8198;
    public static final int CL_DEVICES_FOR_GL_CONTEXT_KHR = 8199;
    public static final int CL_EGL_DISPLAY_KHR = 8201;
    public static final int CL_GLX_DISPLAY_KHR = 8202;
    public static final int CL_GL_CONTEXT_KHR = 8200;
    public static final int CL_INVALID_GL_SHAREGROUP_REFERENCE_KHR = -1000;
    public static final int CL_WGL_HDC_KHR = 8203;

    private KHRGLSharing() {
    }

    public static int clGetGLContextInfoKHR(PointerBuffer pointerBuffer, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer2) {
        PointerBuffer pointerBuffer3 = pointerBuffer;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer4 = pointerBuffer2;
        long j = CLCapabilities.clGetGLContextInfoKHR;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(pointerBuffer3);
        BufferChecks.checkNullTerminated(pointerBuffer3);
        if (byteBuffer2 != null) {
            BufferChecks.checkDirect(byteBuffer2);
        }
        if (pointerBuffer4 != null) {
            BufferChecks.checkBuffer(pointerBuffer4, 1);
        }
        if (pointerBuffer4 == null && APIUtil.isDevicesParam(i2)) {
            pointerBuffer4 = APIUtil.getBufferPointer();
        }
        int nclGetGLContextInfoKHR = nclGetGLContextInfoKHR(MemoryUtil.getAddress(pointerBuffer3), i2, (long) (byteBuffer2 == null ? 0 : byteBuffer2.remaining()), MemoryUtil.getAddressSafe(byteBuffer2), MemoryUtil.getAddressSafe(pointerBuffer4), j);
        if (nclGetGLContextInfoKHR == 0 && byteBuffer2 != null && APIUtil.isDevicesParam(i2)) {
            APIUtil.getCLPlatform(pointerBuffer3).registerCLDevices(byteBuffer2, pointerBuffer4);
        }
        return nclGetGLContextInfoKHR;
    }

    static native int nclGetGLContextInfoKHR(long j, int i, long j2, long j3, long j4, long j5);
}
