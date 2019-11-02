package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

final class LinuxPbufferPeerInfo extends LinuxPeerInfo {
    LinuxPbufferPeerInfo(int i, int i2, PixelFormat pixelFormat) throws LWJGLException {
        int i3 = i;
        int i4 = i2;
        PixelFormat pixelFormat2 = pixelFormat;
        LinuxDisplay.lockAWT();
        try {
            GLContext.loadOpenGLLibrary();
            try {
                LinuxDisplay.incDisplay();
                nInitHandle(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), getHandle(), i3, i4, pixelFormat2);
                LinuxDisplay.unlockAWT();
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                LinuxDisplay.decDisplay();
                throw lWJGLException;
            } catch (LWJGLException e2) {
                LWJGLException lWJGLException2 = e2;
                GLContext.unloadOpenGLLibrary();
                throw lWJGLException2;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            LinuxDisplay.unlockAWT();
            throw th2;
        }
    }

    private static native void nDestroy(ByteBuffer byteBuffer);

    private static native void nInitHandle(long j, int i, ByteBuffer byteBuffer, int i2, int i3, PixelFormat pixelFormat) throws LWJGLException;

    public void destroy() {
        LinuxDisplay.lockAWT();
        nDestroy(getHandle());
        LinuxDisplay.decDisplay();
        GLContext.unloadOpenGLLibrary();
        LinuxDisplay.unlockAWT();
    }

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
    }

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
    }
}
