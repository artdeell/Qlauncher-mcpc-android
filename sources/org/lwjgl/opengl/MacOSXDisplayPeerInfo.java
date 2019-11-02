package org.lwjgl.opengl;

import java.awt.Canvas;
import org.lwjgl.LWJGLException;

final class MacOSXDisplayPeerInfo extends MacOSXCanvasPeerInfo {
    private boolean locked;

    MacOSXDisplayPeerInfo(PixelFormat pixelFormat, ContextAttribs contextAttribs, boolean z) throws LWJGLException {
        super(pixelFormat, contextAttribs, z);
    }

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
        RuntimeException runtimeException;
        if (this.locked) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Already locked");
            throw runtimeException2;
        }
        Canvas canvas = ((MacOSXDisplay) Display.getImplementation()).getCanvas();
        if (canvas != null) {
            initHandle(canvas);
            this.locked = true;
        }
    }

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
        if (this.locked) {
            super.doUnlock();
            this.locked = false;
        }
    }
}
