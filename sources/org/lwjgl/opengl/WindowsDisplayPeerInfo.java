package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengles.GLContext;

final class WindowsDisplayPeerInfo extends WindowsPeerInfo {
    final boolean egl;

    WindowsDisplayPeerInfo(boolean z) throws LWJGLException {
        boolean z2 = z;
        this.egl = z2;
        if (z2) {
            GLContext.loadOpenGLLibrary();
        } else {
            GLContext.loadOpenGLLibrary();
        }
    }

    private static native void nInitDC(ByteBuffer byteBuffer, long j, long j2);

    public void destroy() {
        super.destroy();
        if (this.egl) {
            GLContext.unloadOpenGLLibrary();
        } else {
            GLContext.unloadOpenGLLibrary();
        }
    }

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
    }

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
    }

    /* access modifiers changed from: 0000 */
    public void initDC(long j, long j2) throws LWJGLException {
        long j3 = j;
        long j4 = j2;
        nInitDC(getHandle(), j3, j4);
    }
}
