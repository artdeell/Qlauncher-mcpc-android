package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

final class LinuxAWTGLCanvasPeerInfo extends LinuxPeerInfo {
    private final AWTSurfaceLock awt_surface;
    private final Canvas component;
    private int screen = -1;

    LinuxAWTGLCanvasPeerInfo(Canvas canvas) {
        AWTSurfaceLock aWTSurfaceLock;
        Canvas canvas2 = canvas;
        AWTSurfaceLock aWTSurfaceLock2 = aWTSurfaceLock;
        AWTSurfaceLock aWTSurfaceLock3 = new AWTSurfaceLock();
        this.awt_surface = aWTSurfaceLock2;
        this.component = canvas2;
    }

    private static native int getScreenFromSurfaceInfo(ByteBuffer byteBuffer) throws LWJGLException;

    private static native void nInitHandle(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
        StringBuilder sb;
        ByteBuffer lockAndGetHandle = this.awt_surface.lockAndGetHandle(this.component);
        if (this.screen == -1) {
            try {
                this.screen = getScreenFromSurfaceInfo(lockAndGetHandle);
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Got exception while trying to determine screen: ").append(lWJGLException).toString());
                this.screen = 0;
            }
        }
        nInitHandle(this.screen, lockAndGetHandle, getHandle());
    }

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
        this.awt_surface.unlock();
    }
}
