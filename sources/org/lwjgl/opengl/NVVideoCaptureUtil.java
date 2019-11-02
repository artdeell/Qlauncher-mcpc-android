package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;

public final class NVVideoCaptureUtil {
    private NVVideoCaptureUtil() {
    }

    private static void checkExtension() {
        IllegalStateException illegalStateException;
        if (LWJGLUtil.CHECKS && !GLContext.getCapabilities().GL_NV_video_capture) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("NV_video_capture is not supported");
            throw illegalStateException2;
        }
    }

    private static ByteBuffer getPeerInfo() {
        return ContextGL.getCurrentContext().getPeerInfo().getHandle();
    }

    public static boolean glBindVideoCaptureDeviceNV(int i, long j) {
        int i2 = i;
        long j2 = j;
        checkExtension();
        return nglBindVideoCaptureDeviceNV(getPeerInfo(), i2, j2);
    }

    public static int glEnumerateVideoCaptureDevicesNV(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        checkExtension();
        if (longBuffer2 != null) {
            BufferChecks.checkBuffer(longBuffer2, 1);
        }
        return nglEnumerateVideoCaptureDevicesNV(getPeerInfo(), longBuffer2, longBuffer2 == null ? 0 : longBuffer2.position());
    }

    public static boolean glLockVideoCaptureDeviceNV(long j) {
        long j2 = j;
        checkExtension();
        return nglLockVideoCaptureDeviceNV(getPeerInfo(), j2);
    }

    public static boolean glQueryVideoCaptureDeviceNV(long j, int i, IntBuffer intBuffer) {
        long j2 = j;
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        checkExtension();
        BufferChecks.checkBuffer(intBuffer2, 1);
        return nglQueryVideoCaptureDeviceNV(getPeerInfo(), j2, i2, intBuffer2, intBuffer2.position());
    }

    public static boolean glReleaseVideoCaptureDeviceNV(long j) {
        long j2 = j;
        checkExtension();
        return nglReleaseVideoCaptureDeviceNV(getPeerInfo(), j2);
    }

    private static native boolean nglBindVideoCaptureDeviceNV(ByteBuffer byteBuffer, int i, long j);

    private static native int nglEnumerateVideoCaptureDevicesNV(ByteBuffer byteBuffer, LongBuffer longBuffer, int i);

    private static native boolean nglLockVideoCaptureDeviceNV(ByteBuffer byteBuffer, long j);

    private static native boolean nglQueryVideoCaptureDeviceNV(ByteBuffer byteBuffer, long j, int i, IntBuffer intBuffer, int i2);

    private static native boolean nglReleaseVideoCaptureDeviceNV(ByteBuffer byteBuffer, long j);
}
