package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;

public final class NVPresentVideoUtil {
    private NVPresentVideoUtil() {
    }

    private static void checkExtension() {
        IllegalStateException illegalStateException;
        if (LWJGLUtil.CHECKS && !GLContext.getCapabilities().GL_NV_present_video) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("NV_present_video is not supported");
            throw illegalStateException2;
        }
    }

    private static ByteBuffer getPeerInfo() {
        return ContextGL.getCurrentContext().getPeerInfo().getHandle();
    }

    public static boolean glBindVideoDeviceNV(int i, long j, IntBuffer intBuffer) {
        int i2 = i;
        long j2 = j;
        IntBuffer intBuffer2 = intBuffer;
        checkExtension();
        if (intBuffer2 != null) {
            BufferChecks.checkNullTerminated(intBuffer2);
        }
        return nglBindVideoDeviceNV(getPeerInfo(), i2, j2, intBuffer2, intBuffer2 == null ? 0 : intBuffer2.position());
    }

    public static int glEnumerateVideoDevicesNV(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        checkExtension();
        if (longBuffer2 != null) {
            BufferChecks.checkBuffer(longBuffer2, 1);
        }
        return nglEnumerateVideoDevicesNV(getPeerInfo(), longBuffer2, longBuffer2 == null ? 0 : longBuffer2.position());
    }

    public static boolean glQueryContextNV(int i, IntBuffer intBuffer) {
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        checkExtension();
        BufferChecks.checkBuffer(intBuffer2, 1);
        ContextGL currentContext = ContextGL.getCurrentContext();
        return nglQueryContextNV(currentContext.getPeerInfo().getHandle(), currentContext.getHandle(), i2, intBuffer2, intBuffer2.position());
    }

    private static native boolean nglBindVideoDeviceNV(ByteBuffer byteBuffer, int i, long j, IntBuffer intBuffer, int i2);

    private static native int nglEnumerateVideoDevicesNV(ByteBuffer byteBuffer, LongBuffer longBuffer, int i);

    private static native boolean nglQueryContextNV(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, IntBuffer intBuffer, int i2);
}
