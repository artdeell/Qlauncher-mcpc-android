package org.lwjgl.opengl;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengles.ContextAttribs;
import org.lwjgl.opengles.EGL;
import org.lwjgl.opengles.EGLConfig;
import org.lwjgl.opengles.EGLDisplay;
import org.lwjgl.opengles.EGLSurface;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.PixelFormat;
import org.lwjgl.opengles.PowerManagementEventException;
import org.lwjgl.opengles.Util;

abstract class DrawableGLES implements DrawableLWJGL {
    protected ContextGLES context;
    protected EGLConfig eglConfig;
    protected EGLDisplay eglDisplay;
    protected EGLSurface eglSurface;
    protected PixelFormat pixel_format;
    protected Drawable shared_drawable;

    protected DrawableGLES() {
    }

    /* access modifiers changed from: protected */
    public void checkDestroyed() {
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

    public void createContext(ContextAttribs contextAttribs, Drawable drawable) throws LWJGLException {
        ContextGLES contextGLES;
        ContextGLES contextGLES2;
        ContextAttribs contextAttribs2 = contextAttribs;
        Drawable drawable2 = drawable;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            if (drawable2 != null) {
                try {
                    contextGLES = ((DrawableGLES) drawable2).getContext();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            } else {
                contextGLES = null;
            }
            ContextGLES contextGLES3 = contextGLES2;
            ContextGLES contextGLES4 = new ContextGLES(this, contextAttribs2, contextGLES);
            this.context = contextGLES3;
            this.shared_drawable = drawable2;
        }
    }

    public Context createSharedContext() throws LWJGLException {
        ContextGLES contextGLES;
        ContextGLES contextGLES2 = GlobalLock.lock;
        synchronized (contextGLES2) {
            try {
                checkDestroyed();
                ContextGLES contextGLES3 = contextGLES;
                ContextGLES contextGLES4 = new ContextGLES(this, this.context.getContextAttribs(), this.context);
                th = contextGLES3;
            } finally {
                Throwable th = th;
                ContextGLES contextGLES5 = contextGLES2;
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
                    try {
                        releaseContext();
                    } catch (PowerManagementEventException e) {
                        PowerManagementEventException powerManagementEventException = e;
                    }
                    this.context.forceDestroy();
                    this.context = null;
                }
                if (this.eglSurface != null) {
                    this.eglSurface.destroy();
                    this.eglSurface = null;
                }
                if (this.eglDisplay != null) {
                    this.eglDisplay.terminate();
                    this.eglDisplay = null;
                }
                this.pixel_format = null;
                this.shared_drawable = null;
            } catch (LWJGLException e2) {
                LWJGLException lWJGLException = e2;
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

    public ContextGLES getContext() {
        ContextGLES contextGLES = GlobalLock.lock;
        synchronized (contextGLES) {
            try {
                th = this.context;
            } finally {
                Throwable th = th;
                ContextGLES contextGLES2 = contextGLES;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public EGLConfig getEGLConfig() {
        EGLConfig eGLConfig = GlobalLock.lock;
        synchronized (eGLConfig) {
            try {
                th = this.eglConfig;
            } finally {
                Throwable th = th;
                EGLConfig eGLConfig2 = eGLConfig;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public EGLDisplay getEGLDisplay() {
        EGLDisplay eGLDisplay = GlobalLock.lock;
        synchronized (eGLDisplay) {
            try {
                th = this.eglDisplay;
            } finally {
                Throwable th = th;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public EGLSurface getEGLSurface() {
        EGLSurface eGLSurface = GlobalLock.lock;
        synchronized (eGLSurface) {
            try {
                th = this.eglSurface;
            } finally {
                Throwable th = th;
                EGLSurface eGLSurface2 = eGLSurface;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public PixelFormatLWJGL getPixelFormat() {
        PixelFormat pixelFormat = GlobalLock.lock;
        synchronized (pixelFormat) {
            try {
                th = this.pixel_format;
            } finally {
                Throwable th = th;
                PixelFormat pixelFormat2 = pixelFormat;
                Throwable th2 = th;
            }
        }
        return th;
    }

    /* access modifiers changed from: 0000 */
    public Drawable getSharedDrawable() {
        Drawable drawable = GlobalLock.lock;
        synchronized (drawable) {
            try {
                th = this.shared_drawable;
            } finally {
                Throwable th = th;
                Drawable drawable2 = drawable;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void initContext(float f, float f2, float f3) {
        GLES20.glClearColor(f, f2, f3, 0.0f);
        GLES20.glClear(16384);
    }

    /* JADX INFO: finally extract failed */
    public void initialize(long j, long j2, int i, PixelFormat pixelFormat) throws LWJGLException {
        LWJGLException lWJGLException;
        long j3 = j;
        long j4 = j2;
        int i2 = i;
        PixelFormat pixelFormat2 = pixelFormat;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                if (this.eglSurface != null) {
                    this.eglSurface.destroy();
                    this.eglSurface = null;
                }
                if (this.eglDisplay != null) {
                    this.eglDisplay.terminate();
                    this.eglDisplay = null;
                }
                EGLDisplay eglGetDisplay = EGL.eglGetDisplay((long) ((int) j4));
                EGLConfig[] chooseConfig = eglGetDisplay.chooseConfig(pixelFormat2.getAttribBuffer(eglGetDisplay, i2, new int[]{12329, 0, 12352, 4, 12333, 0}), null, BufferUtils.createIntBuffer(1));
                if (chooseConfig.length == 0) {
                    LWJGLException lWJGLException2 = lWJGLException;
                    LWJGLException lWJGLException3 = new LWJGLException("No EGLConfigs found for the specified PixelFormat.");
                    throw lWJGLException2;
                }
                EGLConfig bestMatch = pixelFormat2.getBestMatch(chooseConfig);
                EGLSurface createWindowSurface = eglGetDisplay.createWindowSurface(bestMatch, j3, null);
                pixelFormat2.setSurfaceAttribs(createWindowSurface);
                this.eglDisplay = eglGetDisplay;
                this.eglConfig = bestMatch;
                this.eglSurface = createWindowSurface;
                if (this.context != null) {
                    this.context.getEGLContext().setDisplay(eglGetDisplay);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
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

    public void makeCurrent() throws LWJGLException, PowerManagementEventException {
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

    public void releaseContext() throws LWJGLException, PowerManagementEventException {
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
        UnsupportedOperationException unsupportedOperationException;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL) throws LWJGLException {
        PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
        Object obj = GlobalLock.lock;
        synchronized (obj) {
            try {
                this.pixel_format = (PixelFormat) pixelFormatLWJGL2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setSwapInterval(int i) {
        ContextGLES.setSwapInterval(i);
    }

    public void swapBuffers() throws LWJGLException {
        ContextGLES.swapBuffers();
    }
}
