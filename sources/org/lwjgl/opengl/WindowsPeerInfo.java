package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

abstract class WindowsPeerInfo extends PeerInfo {
    protected WindowsPeerInfo() {
        super(createHandle());
    }

    protected static int choosePixelFormat(long j, int i, int i2, PixelFormat pixelFormat, IntBuffer intBuffer, boolean z, boolean z2, boolean z3, boolean z4) throws LWJGLException {
        return nChoosePixelFormat(j, i, i2, pixelFormat, intBuffer, z, z2, z3, z4);
    }

    private static native ByteBuffer createHandle();

    private static native int nChoosePixelFormat(long j, int i, int i2, PixelFormat pixelFormat, IntBuffer intBuffer, boolean z, boolean z2, boolean z3, boolean z4) throws LWJGLException;

    private static native long nGetHdc(ByteBuffer byteBuffer);

    private static native long nGetHwnd(ByteBuffer byteBuffer);

    protected static native void setPixelFormat(long j, int i) throws LWJGLException;

    public final long getHdc() {
        return nGetHdc(getHandle());
    }

    public final long getHwnd() {
        return nGetHwnd(getHandle());
    }
}
