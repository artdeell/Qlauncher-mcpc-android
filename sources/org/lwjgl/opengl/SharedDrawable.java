package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

public final class SharedDrawable extends DrawableGL {
    public SharedDrawable(Drawable drawable) throws LWJGLException {
        this.context = (ContextGL) ((DrawableLWJGL) drawable).createSharedContext();
    }

    public /* bridge */ /* synthetic */ void checkGLError() {
        super.checkGLError();
    }

    public ContextGL createSharedContext() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    public /* bridge */ /* synthetic */ ContextGL getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ PixelFormatLWJGL getPixelFormat() {
        return super.getPixelFormat();
    }

    public /* bridge */ /* synthetic */ void initContext(float f, float f2, float f3) {
        super.initContext(f, f2, f3);
    }

    public /* bridge */ /* synthetic */ boolean isCurrent() throws LWJGLException {
        return super.isCurrent();
    }

    public /* bridge */ /* synthetic */ void makeCurrent() throws LWJGLException {
        super.makeCurrent();
    }

    public /* bridge */ /* synthetic */ void releaseContext() throws LWJGLException {
        super.releaseContext();
    }

    public /* bridge */ /* synthetic */ void setCLSharingProperties(PointerBuffer pointerBuffer) throws LWJGLException {
        super.setCLSharingProperties(pointerBuffer);
    }

    public /* bridge */ /* synthetic */ void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL) throws LWJGLException {
        super.setPixelFormat(pixelFormatLWJGL);
    }

    public /* bridge */ /* synthetic */ void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL, ContextAttribs contextAttribs) throws LWJGLException {
        super.setPixelFormat(pixelFormatLWJGL, contextAttribs);
    }

    public /* bridge */ /* synthetic */ void setSwapInterval(int i) {
        super.setSwapInterval(i);
    }

    public /* bridge */ /* synthetic */ void swapBuffers() throws LWJGLException {
        super.swapBuffers();
    }
}
