package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.opengles.ContextAttribs;
import org.lwjgl.opengles.EGL;
import org.lwjgl.opengles.EGLConfig;
import org.lwjgl.opengles.EGLContext;
import org.lwjgl.opengles.EGLDisplay;
import org.lwjgl.opengles.GLContext;
import org.lwjgl.opengles.GLES20;
import org.lwjgl.opengles.PowerManagementEventException;

final class ContextGLES implements Context {
    private static final ThreadLocal<ContextGLES> current_context_local;
    private final ContextAttribs contextAttribs;
    private boolean destroy_requested;
    private boolean destroyed;
    private final DrawableGLES drawable;
    private final EGLContext eglContext;
    private Thread thread;

    static {
        ThreadLocal<ContextGLES> threadLocal;
        ThreadLocal<ContextGLES> threadLocal2 = threadLocal;
        ThreadLocal<ContextGLES> threadLocal3 = new ThreadLocal<>();
        current_context_local = threadLocal2;
        Sys.initialize();
    }

    ContextGLES(DrawableGLES drawableGLES, ContextAttribs contextAttribs2, ContextGLES contextGLES) throws LWJGLException {
        IntBuffer attribList;
        ContextAttribs contextAttribs3;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        DrawableGLES drawableGLES2 = drawableGLES;
        ContextAttribs contextAttribs4 = contextAttribs2;
        ContextGLES contextGLES2 = contextGLES;
        if (drawableGLES2 == null) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException();
            throw illegalArgumentException3;
        }
        ContextGLES contextGLES3 = contextGLES2 != null ? contextGLES2 : this;
        synchronized (contextGLES3) {
            if (contextGLES2 != null) {
                try {
                    if (contextGLES2.destroyed) {
                        IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                        IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Shared context is destroyed");
                        throw illegalArgumentException5;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    ContextGLES contextGLES4 = contextGLES3;
                    throw th2;
                }
            }
            this.drawable = drawableGLES2;
            this.contextAttribs = contextAttribs4;
            EGLDisplay eGLDisplay = drawableGLES2.getEGLDisplay();
            EGLConfig eGLConfig = drawableGLES2.getEGLConfig();
            EGLContext eGLContext = contextGLES2 == null ? null : contextGLES2.eglContext;
            if (contextAttribs4 == null) {
                ContextAttribs contextAttribs5 = contextAttribs3;
                ContextAttribs contextAttribs6 = new ContextAttribs(2);
                attribList = contextAttribs5.getAttribList();
            } else {
                attribList = contextAttribs4.getAttribList();
            }
            this.eglContext = eGLDisplay.createContext(eGLConfig, eGLContext, attribList);
        }
    }

    private boolean canAccess() {
        return this.thread == null || Thread.currentThread() == this.thread;
    }

    private void checkAccess() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        if (!canAccess()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("From thread ").append(Thread.currentThread()).append(": ").append(this.thread).append(" already has the context current").toString());
            throw illegalStateException2;
        }
    }

    private void checkDestroy() {
        StringBuilder sb;
        if (!this.destroyed && this.destroy_requested) {
            try {
                this.eglContext.destroy();
                this.destroyed = true;
                this.thread = null;
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Exception occurred while destroying context: ").append(lWJGLException).toString());
            }
        }
    }

    static ContextGLES getCurrentContext() {
        return (ContextGLES) current_context_local.get();
    }

    public static void setSwapInterval(int i) {
        StringBuilder sb;
        int i2 = i;
        ContextGLES currentContext = getCurrentContext();
        if (currentContext != null) {
            try {
                currentContext.drawable.getEGLDisplay().setSwapInterval(i2);
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Failed to set swap interval. Reason: ").append(lWJGLException.getMessage()).toString());
            }
        }
    }

    public static void swapBuffers() throws LWJGLException, PowerManagementEventException {
        ContextGLES currentContext = getCurrentContext();
        if (currentContext != null) {
            currentContext.drawable.getEGLSurface().swapBuffers();
        }
    }

    public void destroy() throws LWJGLException {
        OpenGLException openGLException;
        synchronized (this) {
            try {
                th = this.destroyed;
                if (!th) {
                    this.destroy_requested = true;
                    boolean isCurrent = isCurrent();
                    int i = 0;
                    if (isCurrent) {
                        i = 0;
                        if (GLContext.getCapabilities() != null) {
                            i = 0;
                            if (GLContext.getCapabilities().OpenGLES20) {
                                i = GLES20.glGetError();
                            }
                        }
                        try {
                            releaseCurrent();
                        } catch (PowerManagementEventException e) {
                            PowerManagementEventException powerManagementEventException = e;
                        }
                    }
                    checkDestroy();
                    if (isCurrent && i != 0) {
                        OpenGLException openGLException2 = openGLException;
                        OpenGLException openGLException3 = new OpenGLException(i);
                        throw openGLException2;
                    }
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
    }

    public void forceDestroy() throws LWJGLException {
        synchronized (this) {
            try {
                checkAccess();
                destroy();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public ContextAttribs getContextAttribs() {
        return this.contextAttribs;
    }

    public EGLContext getEGLContext() {
        return this.eglContext;
    }

    public boolean isCurrent() throws LWJGLException {
        boolean z;
        IllegalStateException illegalStateException;
        synchronized (this) {
            try {
                if (this.destroyed) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Context is destroyed");
                    throw illegalStateException2;
                }
                th = EGL.eglIsCurrentContext(this.eglContext);
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z;
    }

    public void makeCurrent() throws LWJGLException, PowerManagementEventException {
        IllegalStateException illegalStateException;
        synchronized (this) {
            try {
                checkAccess();
                if (this.destroyed) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Context is destroyed");
                    throw illegalStateException2;
                }
                this.thread = Thread.currentThread();
                current_context_local.set(this);
                this.eglContext.makeCurrent(this.drawable.getEGLSurface());
                GLContext.useContext(this);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void releaseCurrent() throws LWJGLException, PowerManagementEventException {
        EGL.eglReleaseCurrent(this.drawable.getEGLDisplay());
        GLContext.useContext(null);
        current_context_local.set(null);
        synchronized (this) {
            try {
                this.thread = null;
                checkDestroy();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void releaseDrawable() throws LWJGLException {
    }
}
