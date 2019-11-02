package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

abstract class MacOSXPeerInfo extends PeerInfo {
    MacOSXPeerInfo(PixelFormat pixelFormat, ContextAttribs contextAttribs, boolean z, boolean z2, boolean z3, boolean z4) throws LWJGLException {
        LWJGLException lWJGLException;
        PixelFormat pixelFormat2 = pixelFormat;
        ContextAttribs contextAttribs2 = contextAttribs;
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        super(createHandle());
        boolean z9 = contextAttribs2 != null && contextAttribs2.getMajorVersion() == 3 && contextAttribs2.getMinorVersion() == 2 && contextAttribs2.isProfileCore();
        if (!z9 || LWJGLUtil.isMacOSXEqualsOrBetterThan(10, 7)) {
            choosePixelFormat(pixelFormat2, z9, z5, z6, z7, z8);
            return;
        }
        LWJGLException lWJGLException2 = lWJGLException;
        LWJGLException lWJGLException3 = new LWJGLException("OpenGL 3.2 requested, but it requires MacOS X 10.7 or newer");
        throw lWJGLException2;
    }

    private void choosePixelFormat(PixelFormat pixelFormat, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) throws LWJGLException {
        PixelFormat pixelFormat2 = pixelFormat;
        boolean z6 = z;
        boolean z7 = z2;
        boolean z8 = z3;
        boolean z9 = z4;
        boolean z10 = z5;
        nChoosePixelFormat(getHandle(), pixelFormat2, z6, z7, z8, z9, z10);
    }

    private static native ByteBuffer createHandle();

    private static native void nChoosePixelFormat(ByteBuffer byteBuffer, PixelFormat pixelFormat, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) throws LWJGLException;

    private static native void nDestroy(ByteBuffer byteBuffer);

    public void destroy() {
        nDestroy(getHandle());
    }
}
