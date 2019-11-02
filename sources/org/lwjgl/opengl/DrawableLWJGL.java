package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;

interface DrawableLWJGL extends Drawable {
    void checkGLError();

    Context createSharedContext() throws LWJGLException;

    Context getContext();

    PixelFormatLWJGL getPixelFormat();

    void initContext(float f, float f2, float f3);

    void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL) throws LWJGLException;

    void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL, ContextAttribs contextAttribs) throws LWJGLException;

    void setSwapInterval(int i);

    void swapBuffers() throws LWJGLException;
}
