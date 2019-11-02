package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

final class WindowsPbufferPeerInfo extends WindowsPeerInfo {
    WindowsPbufferPeerInfo(int i, int i2, PixelFormat pixelFormat, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        nCreate(getHandle(), i, i2, pixelFormat, intBuffer, intBuffer2);
    }

    private static native void nBindTexImageToPbuffer(ByteBuffer byteBuffer, int i);

    private static native void nCreate(ByteBuffer byteBuffer, int i, int i2, PixelFormat pixelFormat, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer);

    private static native boolean nIsBufferLost(ByteBuffer byteBuffer);

    private static native void nReleaseTexImageFromPbuffer(ByteBuffer byteBuffer, int i);

    private static native void nSetPbufferAttrib(ByteBuffer byteBuffer, int i, int i2);

    public void bindTexImageToPbuffer(int i) {
        int i2 = i;
        nBindTexImageToPbuffer(getHandle(), i2);
    }

    public void destroy() {
        nDestroy(getHandle());
    }

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
    }

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
    }

    public boolean isBufferLost() {
        return nIsBufferLost(getHandle());
    }

    public void releaseTexImageFromPbuffer(int i) {
        int i2 = i;
        nReleaseTexImageFromPbuffer(getHandle(), i2);
    }

    public void setPbufferAttrib(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        nSetPbufferAttrib(getHandle(), i3, i4);
    }
}
