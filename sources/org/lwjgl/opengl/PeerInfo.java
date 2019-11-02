package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

abstract class PeerInfo {
    private final ByteBuffer handle;
    private int lock_count;
    private Thread locking_thread;

    protected PeerInfo(ByteBuffer byteBuffer) {
        this.handle = byteBuffer;
    }

    private void lockAndInitHandle() throws LWJGLException {
        doLockAndInitHandle();
    }

    public void destroy() {
    }

    /* access modifiers changed from: protected */
    public abstract void doLockAndInitHandle() throws LWJGLException;

    /* access modifiers changed from: protected */
    public abstract void doUnlock() throws LWJGLException;

    /* access modifiers changed from: protected */
    public final ByteBuffer getHandle() {
        return this.handle;
    }

    public final ByteBuffer lockAndGetHandle() throws LWJGLException {
        ByteBuffer handle2;
        StringBuilder sb;
        synchronized (this) {
            try {
                Thread currentThread = Thread.currentThread();
                while (this.locking_thread != null && this.locking_thread != currentThread) {
                    wait();
                }
                if (this.lock_count == 0) {
                    this.locking_thread = currentThread;
                    doLockAndInitHandle();
                }
                this.lock_count = 1 + this.lock_count;
                handle2 = getHandle();
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Interrupted while waiting for PeerInfo lock: ").append(interruptedException).toString());
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
        return handle2;
    }

    public final void unlock() throws LWJGLException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        synchronized (this) {
            try {
                if (this.lock_count <= 0) {
                    IllegalStateException illegalStateException3 = illegalStateException2;
                    IllegalStateException illegalStateException4 = new IllegalStateException("PeerInfo not locked!");
                    throw illegalStateException3;
                } else if (Thread.currentThread() != this.locking_thread) {
                    IllegalStateException illegalStateException5 = illegalStateException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalStateException illegalStateException6 = new IllegalStateException(sb2.append("PeerInfo already locked by ").append(this.locking_thread).toString());
                    throw illegalStateException5;
                } else {
                    this.lock_count = -1 + this.lock_count;
                    if (this.lock_count == 0) {
                        doUnlock();
                        this.locking_thread = null;
                        notify();
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
