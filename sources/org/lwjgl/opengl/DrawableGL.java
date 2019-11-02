package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;

abstract class DrawableGL implements DrawableLWJGL {
    protected ContextGL context;
    protected PeerInfo peer_info;
    protected PixelFormat pixel_format;

    protected DrawableGL() {
    }

    /* access modifiers changed from: protected */
    public final void checkDestroyed() {
        IllegalStateException illegalStateException;
        if (this.context == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("The Drawable has no context available.");
            throw illegalStateException2;
        }
    }

    public void checkGLError() {
        Util.checkGLError();
    }

    public ContextGL createSharedContext() throws LWJGLException {
        ContextGL contextGL;
        ContextGL contextGL2 = GlobalLock.lock;
        synchronized (contextGL2) {
            try {
                checkDestroyed();
                ContextGL contextGL3 = contextGL;
                ContextGL contextGL4 = new ContextGL(this.peer_info, this.context.getContextAttribs(), this.context);
                th = contextGL3;
            } finally {
                Throwable th = th;
                ContextGL contextGL5 = contextGL2;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void destroy() {
        StringBuilder sb;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (this.context != null) {
                    releaseContext();
                    this.context.forceDestroy();
                    this.context = null;
                    if (this.peer_info != null) {
                        this.peer_info.destroy();
                        this.peer_info = null;
                    }
                }
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Exception occurred while destroying Drawable: ").append(lWJGLException).toString());
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public ContextGL getContext() {
        ContextGL contextGL = GlobalLock.lock;
        synchronized (contextGL) {
            try {
                th = this.context;
            } finally {
                Throwable th = th;
                ContextGL contextGL2 = contextGL;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public PixelFormatLWJGL getPixelFormat() {
        return this.pixel_format;
    }

    public void initContext(float f, float f2, float f3) {
        GL11.glClearColor(f, f2, f3, 0.0f);
        GL11.glClear(16384);
    }

    public boolean isCurrent() throws LWJGLException {
        boolean z = GlobalLock.lock;
        synchronized (z) {
            try {
                checkDestroyed();
                th = this.context.isCurrent();
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void makeCurrent() throws LWJGLException {
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                checkDestroyed();
                this.context.makeCurrent();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void releaseContext() throws LWJGLException {
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                checkDestroyed();
                if (this.context.isCurrent()) {
                    this.context.releaseCurrent();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setCLSharingProperties(PointerBuffer pointerBuffer) throws LWJGLException {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                checkDestroyed();
                this.context.setCLSharingProperties(pointerBuffer2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL) throws LWJGLException {
        UnsupportedOperationException unsupportedOperationException;
        PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL, ContextAttribs contextAttribs) throws LWJGLException {
        ContextAttribs contextAttribs2 = contextAttribs;
        this.pixel_format = (PixelFormat) pixelFormatLWJGL;
        this.peer_info = Display.getImplementation().createPeerInfo(this.pixel_format, contextAttribs2);
    }

    public void setSwapInterval(int i) {
        ContextGL.setSwapInterval(i);
    }

    public void swapBuffers() throws LWJGLException {
        ContextGL.swapBuffers();
    }
}
