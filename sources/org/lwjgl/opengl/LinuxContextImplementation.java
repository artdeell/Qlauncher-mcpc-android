package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

final class LinuxContextImplementation implements ContextImplementation {
    LinuxContextImplementation() {
    }

    private static native ByteBuffer nCreate(ByteBuffer byteBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native boolean nIsCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nMakeCurrent(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native void nReleaseCurrentContext(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nSetSwapInterval(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i);

    private static native void nSwapBuffers(ByteBuffer byteBuffer) throws LWJGLException;

    public ByteBuffer create(PeerInfo peerInfo, IntBuffer intBuffer, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        LinuxDisplay.lockAWT();
        try {
            ByteBuffer nCreate = nCreate(peerInfo2.lockAndGetHandle(), intBuffer2, byteBuffer2);
            peerInfo2.unlock();
            LinuxDisplay.unlockAWT();
            return nCreate;
        } catch (Throwable th) {
            Throwable th2 = th;
            LinuxDisplay.unlockAWT();
            throw th2;
        }
    }

    public void destroy(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        ByteBuffer byteBuffer2 = byteBuffer;
        LinuxDisplay.lockAWT();
        try {
            nDestroy(peerInfo2.lockAndGetHandle(), byteBuffer2);
            peerInfo2.unlock();
            LinuxDisplay.unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            LinuxDisplay.unlockAWT();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public native long getDisplay(ByteBuffer byteBuffer);

    /* access modifiers changed from: 0000 */
    public native long getGLXContext(ByteBuffer byteBuffer);

    /* JADX INFO: finally extract failed */
    public boolean isCurrent(ByteBuffer byteBuffer) throws LWJGLException {
        ByteBuffer byteBuffer2 = byteBuffer;
        LinuxDisplay.lockAWT();
        try {
            boolean nIsCurrent = nIsCurrent(byteBuffer2);
            LinuxDisplay.unlockAWT();
            return nIsCurrent;
        } catch (Throwable th) {
            Throwable th2 = th;
            LinuxDisplay.unlockAWT();
            throw th2;
        }
    }

    public void makeCurrent(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        ByteBuffer byteBuffer2 = byteBuffer;
        LinuxDisplay.lockAWT();
        try {
            nMakeCurrent(peerInfo2.lockAndGetHandle(), byteBuffer2);
            peerInfo2.unlock();
            LinuxDisplay.unlockAWT();
        } catch (Throwable th) {
            Throwable th2 = th;
            LinuxDisplay.unlockAWT();
            throw th2;
        }
    }

    public void releaseCurrentContext() throws LWJGLException {
        IllegalStateException illegalStateException;
        ByteBuffer currentContext = ContextGL.getCurrentContext();
        if (currentContext == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No context is current");
            throw illegalStateException2;
        }
        synchronized (currentContext) {
            try {
                th = currentContext.getPeerInfo();
                LinuxDisplay.lockAWT();
                try {
                    th = th.lockAndGetHandle();
                    nReleaseCurrentContext(th);
                    th.unlock();
                    LinuxDisplay.unlockAWT();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    th.unlock();
                    throw th2;
                } finally {
                    Throwable th3 = th;
                    LinuxDisplay.unlockAWT();
                    Throwable th4 = th3;
                }
            } finally {
                Throwable th5 = th;
                ByteBuffer byteBuffer = currentContext;
                Throwable th6 = th5;
            }
        }
    }

    public void releaseDrawable(ByteBuffer byteBuffer) throws LWJGLException {
    }

    public void setSwapInterval(int i) {
        Throwable th;
        IllegalStateException illegalStateException;
        int i2 = i;
        th = ContextGL.getCurrentContext();
        th = th.getPeerInfo();
        if (th == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No context is current");
            throw illegalStateException2;
        }
        synchronized (th) {
            try {
                LinuxDisplay.lockAWT();
                try {
                    th = th.lockAndGetHandle();
                    nSetSwapInterval(th, th.getHandle(), i2);
                    th.unlock();
                    LinuxDisplay.unlockAWT();
                } catch (LWJGLException th2) {
                    th2.printStackTrace();
                    LinuxDisplay.unlockAWT();
                } finally {
                    Throwable th3 = th2;
                    th.unlock();
                    Throwable th4 = th3;
                }
            } catch (Throwable th5) {
                Throwable th6 = th5;
                throw th6;
            } finally {
                th = th;
                LinuxDisplay.unlockAWT();
                Throwable th7 = th;
            }
        }
    }

    public void swapBuffers() throws LWJGLException {
        IllegalStateException illegalStateException;
        ByteBuffer currentContext = ContextGL.getCurrentContext();
        if (currentContext == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No context is current");
            throw illegalStateException2;
        }
        synchronized (currentContext) {
            try {
                th = currentContext.getPeerInfo();
                LinuxDisplay.lockAWT();
                try {
                    th = th.lockAndGetHandle();
                    nSwapBuffers(th);
                    th.unlock();
                    LinuxDisplay.unlockAWT();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    th.unlock();
                    throw th2;
                } finally {
                    Throwable th3 = th;
                    LinuxDisplay.unlockAWT();
                    Throwable th4 = th3;
                }
            } finally {
                Throwable th5 = th;
                ByteBuffer byteBuffer = currentContext;
                Throwable th6 = th5;
            }
        }
    }

    public void update(ByteBuffer byteBuffer) {
    }
}
