package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

interface DisplayImplementation extends InputImplementation {
    void bindTexImageToPbuffer(PeerInfo peerInfo, int i);

    PeerInfo createPbuffer(int i, int i2, PixelFormat pixelFormat, ContextAttribs contextAttribs, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException;

    PeerInfo createPeerInfo(PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException;

    void createWindow(DrawableLWJGL drawableLWJGL, DisplayMode displayMode, Canvas canvas, int i, int i2) throws LWJGLException;

    void destroyWindow();

    String getAdapter();

    DisplayMode[] getAvailableDisplayModes() throws LWJGLException;

    int getGammaRampLength();

    int getHeight();

    int getPbufferCapabilities();

    String getVersion();

    int getWidth();

    int getX();

    int getY();

    DisplayMode init() throws LWJGLException;

    boolean isActive();

    boolean isBufferLost(PeerInfo peerInfo);

    boolean isCloseRequested();

    boolean isDirty();

    boolean isVisible();

    void releaseTexImageFromPbuffer(PeerInfo peerInfo, int i);

    void resetDisplayMode();

    void reshape(int i, int i2, int i3, int i4);

    void setGammaRamp(FloatBuffer floatBuffer) throws LWJGLException;

    int setIcon(ByteBuffer[] byteBufferArr);

    void setPbufferAttrib(PeerInfo peerInfo, int i, int i2);

    void setResizable(boolean z);

    void setTitle(String str);

    void switchDisplayMode(DisplayMode displayMode) throws LWJGLException;

    void update();

    boolean wasResized();
}
