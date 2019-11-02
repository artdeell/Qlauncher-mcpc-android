package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

final class AWTSurfaceLock {
    private static final int WAIT_DELAY_MILLIS = 100;
    private boolean firstLockSucceeded;
    /* access modifiers changed from: private */
    public final ByteBuffer lock_buffer = createHandle();

    AWTSurfaceLock() {
    }

    private static native ByteBuffer createHandle();

    /* access modifiers changed from: private */
    public static native boolean lockAndInitHandle(ByteBuffer byteBuffer, Canvas canvas) throws LWJGLException;

    private static native void nUnlock(ByteBuffer byteBuffer) throws LWJGLException;

    private boolean privilegedLockAndInitHandle(Canvas canvas) throws LWJGLException {
        C07801 r9;
        Canvas canvas2 = canvas;
        if (this.firstLockSucceeded) {
            return lockAndInitHandle(this.lock_buffer, canvas2);
        }
        try {
            C07801 r5 = r9;
            final Canvas canvas3 = canvas2;
            C07801 r6 = new PrivilegedExceptionAction<Boolean>(this) {
                final /* synthetic */ AWTSurfaceLock this$0;

                {
                    Canvas canvas = r7;
                    this.this$0 = r6;
                }

                public Boolean run() throws LWJGLException {
                    return Boolean.valueOf(AWTSurfaceLock.lockAndInitHandle(this.this$0.lock_buffer, canvas3));
                }
            };
            this.firstLockSucceeded = ((Boolean) AccessController.doPrivileged(r5)).booleanValue();
            return this.firstLockSucceeded;
        } catch (PrivilegedActionException e) {
            throw ((LWJGLException) e.getException());
        }
    }

    public ByteBuffer lockAndGetHandle(Canvas canvas) throws LWJGLException {
        StringBuilder sb;
        Canvas canvas2 = canvas;
        while (!privilegedLockAndInitHandle(canvas2)) {
            LWJGLUtil.log("Could not get drawing surface info, retrying...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Interrupted while retrying: ").append(interruptedException).toString());
            }
        }
        return this.lock_buffer;
    }

    /* access modifiers changed from: 0000 */
    public void unlock() throws LWJGLException {
        nUnlock(this.lock_buffer);
    }
}
