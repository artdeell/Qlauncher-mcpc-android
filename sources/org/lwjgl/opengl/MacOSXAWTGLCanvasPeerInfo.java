package org.lwjgl.opengl;

import java.awt.Canvas;
import org.lwjgl.LWJGLException;

final class MacOSXAWTGLCanvasPeerInfo extends MacOSXCanvasPeerInfo {
    private final Canvas component;

    MacOSXAWTGLCanvasPeerInfo(Canvas canvas, PixelFormat pixelFormat, ContextAttribs contextAttribs, boolean z) throws LWJGLException {
        Canvas canvas2 = canvas;
        super(pixelFormat, contextAttribs, z);
        this.component = canvas2;
    }

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
        initHandle(this.component);
    }
}
