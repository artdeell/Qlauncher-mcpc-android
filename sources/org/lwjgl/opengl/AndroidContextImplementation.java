package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.lwjgl.LWJGLException;

public final class AndroidContextImplementation implements ContextImplementation {
    public static EGLContext context;
    public static boolean current = true;
    public static EGLDisplay display;
    public static EGLSurface draw;
    public static EGLSurface read;
    public static EGL10 theEgl;

    public AndroidContextImplementation() {
    }

    public ByteBuffer create(PeerInfo peerInfo, IntBuffer intBuffer, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        return ByteBuffer.allocate(4);
    }

    public void destroy(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException {
    }

    public boolean isCurrent(ByteBuffer byteBuffer) throws LWJGLException {
        ByteBuffer byteBuffer2 = byteBuffer;
        return current;
    }

    public void makeCurrent(PeerInfo peerInfo, ByteBuffer byteBuffer) throws LWJGLException {
        PeerInfo peerInfo2 = peerInfo;
        ByteBuffer byteBuffer2 = byteBuffer;
        boolean eglMakeCurrent = theEgl.eglMakeCurrent(display, draw, read, context);
        current = true;
    }

    public void releaseCurrentContext() throws LWJGLException {
        current = false;
    }

    public void releaseDrawable(ByteBuffer byteBuffer) throws LWJGLException {
    }

    public void setSwapInterval(int i) {
    }

    public void swapBuffers() throws LWJGLException {
        boolean eglSwapBuffers = theEgl.eglSwapBuffers(display, draw);
    }

    public void update(ByteBuffer byteBuffer) {
    }
}
