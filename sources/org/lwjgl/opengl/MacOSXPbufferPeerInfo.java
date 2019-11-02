package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

final class MacOSXPbufferPeerInfo extends MacOSXPeerInfo {
    MacOSXPbufferPeerInfo(int i, int i2, PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        int i3 = i;
        int i4 = i2;
        super(pixelFormat, contextAttribs, false, false, true, false);
        nCreate(getHandle(), i3, i4);
    }

    private static native void nCreate(ByteBuffer byteBuffer, int i, int i2) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer);

    public void destroy() {
        nDestroy(getHandle());
    }

    /* access modifiers changed from: protected */
    public void doLockAndInitHandle() throws LWJGLException {
    }

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
    }
}
