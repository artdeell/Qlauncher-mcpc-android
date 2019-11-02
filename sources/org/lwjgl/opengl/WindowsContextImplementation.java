package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

final class WindowsContextImplementation implements ContextImplementation {
    WindowsContextImplementation() {
    }

    private static native ByteBuffer nCreate(ByteBuffer byteBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer) throws LWJGLException;

    private static native boolean nIsCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nMakeCurrent(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native void nReleaseCurrentContext() throws LWJGLException;

    private static native boolean nSetSwapInterval(int i);

    private static native void nSwapBuffers(ByteBuffer byteBuffer) throws LWJGLException;

    /* JADX INFO: finally extract failed */
    public ByteBuffer create(PeerInfo peerInfo, IntBuffer intBuffer, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        try {
            ByteBuffer nCreate = nCreate(peerInfo2.lockAndGetHandle(), intBuffer, byteBuffer);
            peerInfo2.unlock();
            return nCreate;
        } catch (Throwable th) {
            Throwable th2 = th;
            peerInfo2.unlock();
            throw th2;
        }
    }

    public void destroy(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        nDestroy(byteBuffer);
    }

    /* access modifiers changed from: 0000 */
    public native long getHDC(ByteBuffer byteBuffer);

    /* access modifiers changed from: 0000 */
    public native long getHGLRC(ByteBuffer byteBuffer);

    public boolean isCurrent(ByteBuffer byteBuffer) throws LWJGLException {
        return nIsCurrent(byteBuffer);
    }

    public void makeCurrent(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        try {
            nMakeCurrent(peerInfo2.lockAndGetHandle(), byteBuffer);
            peerInfo2.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            peerInfo2.unlock();
            throw th2;
        }
    }

    public void releaseCurrentContext() throws LWJGLException {
        nReleaseCurrentContext();
    }

    public void releaseDrawable(ByteBuffer byteBuffer) throws LWJGLException {
    }

    public void setSwapInterval(int i) {
        if (!nSetSwapInterval(i)) {
            LWJGLUtil.log("Failed to set swap interval");
        }
        Util.checkGLError();
    }

    /* JADX INFO: finally extract failed */
    public void swapBuffers() throws LWJGLException {
        PeerInfo peerInfo;
        IllegalStateException illegalStateException;
        ContextGL currentContext = ContextGL.getCurrentContext();
        if (currentContext == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No context is current");
            throw illegalStateException2;
        }
        synchronized (currentContext) {
            try {
                peerInfo = currentContext.getPeerInfo();
                nSwapBuffers(peerInfo.lockAndGetHandle());
                peerInfo.unlock();
            } catch (Throwable th) {
                Throwable th2 = th;
                ContextGL contextGL = currentContext;
                throw th2;
            }
        }
    }

    public void update(ByteBuffer byteBuffer) {
    }
}
