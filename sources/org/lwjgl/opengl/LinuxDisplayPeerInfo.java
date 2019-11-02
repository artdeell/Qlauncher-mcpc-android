package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengles.GLContext;

final class LinuxDisplayPeerInfo extends LinuxPeerInfo {
    final boolean egl = true;

    LinuxDisplayPeerInfo() throws LWJGLException {
        GLContext.loadOpenGLLibrary();
    }

    LinuxDisplayPeerInfo(PixelFormat pixelFormat) throws LWJGLException {
        PixelFormat pixelFormat2 = pixelFormat;
        LinuxDisplay.lockAWT();
        try {
            GLContext.loadOpenGLLibrary();
            try {
                LinuxDisplay.incDisplay();
                initDefaultPeerInfo(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), getHandle(), pixelFormat2);
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

    private static native void initDefaultPeerInfo(long j, int i, ByteBuffer byteBuffer, PixelFormat pixelFormat) throws LWJGLException;

    private static native void initDrawable(long j, ByteBuffer byteBuffer);

    public void destroy() {
        super.destroy();
        if (this.egl) {
            GLContext.unloadOpenGLLibrary();
            return;
        }
        LinuxDisplay.lockAWT();
        LinuxDisplay.decDisplay();
        GLContext.unloadOpenGLLibrary();
        LinuxDisplay.unlockAWT();
    }

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            initDrawable(LinuxDisplay.getWindow(), getHandle());
            LinuxDisplay.unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            LinuxDisplay.unlockAWT();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
    }
}
