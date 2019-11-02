package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

final class WindowsAWTGLCanvasPeerInfo extends WindowsPeerInfo {
    private final AWTSurfaceLock awt_surface;
    private final Canvas component;
    private boolean has_pixel_format;
    private final PixelFormat pixel_format;

    WindowsAWTGLCanvasPeerInfo(Canvas canvas, PixelFormat pixelFormat) {
        AWTSurfaceLock aWTSurfaceLock;
        Canvas canvas2 = canvas;
        PixelFormat pixelFormat2 = pixelFormat;
        AWTSurfaceLock aWTSurfaceLock2 = aWTSurfaceLock;
        AWTSurfaceLock aWTSurfaceLock3 = new AWTSurfaceLock();
        this.awt_surface = aWTSurfaceLock2;
        this.component = canvas2;
        this.pixel_format = pixelFormat2;
    }

    private static native void nInitHandle(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws LWJGLException;

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
        nInitHandle(this.awt_surface.lockAndGetHandle(this.component), getHandle());
        if (!this.has_pixel_format && this.pixel_format != null) {
            setPixelFormat(getHdc(), choosePixelFormat(getHdc(), this.component.getX(), this.component.getY(), this.pixel_format, null, true, true, false, true));
            this.has_pixel_format = true;
        }
    }

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
        this.awt_surface.unlock();
    }
}
