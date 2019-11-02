package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

final class MacOSXContextImplementation implements ContextImplementation {
    MacOSXContextImplementation() {
    }

    private static native void clearDrawable(ByteBuffer byteBuffer) throws LWJGLException;

    private static native ByteBuffer nCreate(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer) throws LWJGLException;

    private static native boolean nIsCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nMakeCurrent(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nReleaseCurrentContext() throws LWJGLException;

    private static native void nSetSwapInterval(ByteBuffer byteBuffer, int i);

    private static native void nSwapBuffers(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nUpdate(ByteBuffer byteBuffer);

    static void resetView(PeerInfo peerInfo, ContextGL contextGL) throws LWJGLException {
        Throwable th;
        PeerInfo peerInfo2 = peerInfo;
        ContextGL contextGL2 = contextGL;
        ByteBuffer lockAndGetHandle = peerInfo2.lockAndGetHandle();
        try {
            synchronized (contextGL2) {
                clearDrawable(contextGL2.getHandle());
                setView(lockAndGetHandle, contextGL2.getHandle());
            }
            peerInfo2.unlock();
        } catch (Throwable th2) {
            Throwable th3 = th2;
            peerInfo2.unlock();
            throw th3;
        }
    }

    private static native void setView(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    /* JADX INFO: finally extract failed */
    public ByteBuffer create(PeerInfo peerInfo, IntBuffer intBuffer, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        IntBuffer intBuffer2 = intBuffer;
        try {
            ByteBuffer nCreate = nCreate(peerInfo2.lockAndGetHandle(), byteBuffer);
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
    public native long getCGLShareGroup(ByteBuffer byteBuffer);

    public boolean isCurrent(ByteBuffer byteBuffer) throws LWJGLException {
        return nIsCurrent(byteBuffer);
    }

    public void makeCurrent(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        ByteBuffer byteBuffer2 = byteBuffer;
        try {
            setView(peerInfo2.lockAndGetHandle(), byteBuffer2);
            nMakeCurrent(byteBuffer2);
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
        clearDrawable(byteBuffer);
    }

    public void setSwapInterval(int i) {
        int i2 = i;
        ContextGL currentContext = ContextGL.getCurrentContext();
        synchronized (currentContext) {
            try {
                nSetSwapInterval(currentContext.getHandle(), i2);
            } catch (Throwable th) {
                Throwable th2 = th;
                ContextGL contextGL = currentContext;
                throw th2;
            }
        }
    }

    public void swapBuffers() throws LWJGLException {
        IllegalStateException illegalStateException;
        ContextGL currentContext = ContextGL.getCurrentContext();
        if (currentContext == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("No context is current");
            throw illegalStateException2;
        }
        synchronized (currentContext) {
            try {
                nSwapBuffers(currentContext.getHandle());
            } catch (Throwable th) {
                Throwable th2 = th;
                ContextGL contextGL = currentContext;
                throw th2;
            }
        }
    }

    public void update(ByteBuffer byteBuffer) {
        nUpdate(byteBuffer);
    }
}
