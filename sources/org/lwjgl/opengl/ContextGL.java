package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;

final class ContextGL implements Context {
    private static final ThreadLocal<ContextGL> current_context_local;
    private static final ContextImplementation implementation = createImplementation();
    private final ContextAttribs contextAttribs;
    private boolean destroy_requested;
    private boolean destroyed;
    private final boolean forwardCompatible;
    private final ByteBuffer handle;
    private final PeerInfo peer_info;
    private Thread thread;

    static {
        ThreadLocal<ContextGL> threadLocal;
        ThreadLocal<ContextGL> threadLocal2 = threadLocal;
        ThreadLocal<ContextGL> threadLocal3 = new ThreadLocal<>();
        current_context_local = threadLocal2;
        Sys.initialize();
    }

    ContextGL(PeerInfo peerInfo, ContextAttribs contextAttribs2, ContextGL contextGL) throws LWJGLException {
        IntBuffer intBuffer;
        IllegalArgumentException illegalArgumentException;
        PeerInfo peerInfo2 = peerInfo;
        ContextAttribs contextAttribs3 = contextAttribs2;
        ContextGL contextGL2 = contextGL;
        ContextGL contextGL3 = contextGL2 != null ? contextGL2 : this;
        synchronized (contextGL3) {
            if (contextGL2 != null) {
                try {
                    if (contextGL2.destroyed) {
                        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Shared context is destroyed");
                        throw illegalArgumentException2;
                    }
                } catch (LWJGLException e) {
                    LWJGLException lWJGLException = e;
                    GLContext.unloadOpenGLLibrary();
                    throw lWJGLException;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    ContextGL contextGL4 = contextGL3;
                    throw th2;
                }
            }
            GLContext.loadOpenGLLibrary();
            this.peer_info = peerInfo2;
            this.contextAttribs = contextAttribs3;
            if (contextAttribs3 != null) {
                intBuffer = contextAttribs3.getAttribList();
                this.forwardCompatible = contextAttribs3.isForwardCompatible();
            } else {
                this.forwardCompatible = false;
                intBuffer = null;
            }
            this.handle = implementation.create(peerInfo2, intBuffer, contextGL2 != null ? contextGL2.handle : null);
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
                releaseDrawable();
                implementation.destroy(this.peer_info, this.handle);
                CallbackUtil.unregisterCallbacks(this);
                this.destroyed = true;
                this.thread = null;
                GLContext.unloadOpenGLLibrary();
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Exception occurred while destroying context: ").append(lWJGLException).toString());
            }
        }
    }

    private static ContextImplementation createImplementation() {
        AndroidContextImplementation androidContextImplementation;
        MacOSXContextImplementation macOSXContextImplementation;
        WindowsContextImplementation windowsContextImplementation;
        LinuxContextImplementation linuxContextImplementation;
        IllegalStateException illegalStateException;
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                LinuxContextImplementation linuxContextImplementation2 = linuxContextImplementation;
                LinuxContextImplementation linuxContextImplementation3 = new LinuxContextImplementation();
                return linuxContextImplementation2;
            case 2:
                MacOSXContextImplementation macOSXContextImplementation2 = macOSXContextImplementation;
                MacOSXContextImplementation macOSXContextImplementation3 = new MacOSXContextImplementation();
                return macOSXContextImplementation2;
            case 3:
                WindowsContextImplementation windowsContextImplementation2 = windowsContextImplementation;
                WindowsContextImplementation windowsContextImplementation3 = new WindowsContextImplementation();
                return windowsContextImplementation2;
            case LWJGLUtil.PLATFORM_ANDROID /*1337*/:
                AndroidContextImplementation androidContextImplementation2 = androidContextImplementation;
                AndroidContextImplementation androidContextImplementation3 = new AndroidContextImplementation();
                return androidContextImplementation2;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Unsupported platform");
                throw illegalStateException2;
        }
    }

    static ContextGL getCurrentContext() {
        return (ContextGL) current_context_local.get();
    }

    public static void setSwapInterval(int i) {
        implementation.setSwapInterval(i);
    }

    public static void swapBuffers() throws LWJGLException {
        implementation.swapBuffers();
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
                            if (GLContext.getCapabilities().OpenGL11) {
                                i = GL11.glGetError();
                            }
                        }
                        releaseCurrent();
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

    /* access modifiers changed from: 0000 */
    public ByteBuffer getHandle() {
        return this.handle;
    }

    /* access modifiers changed from: 0000 */
    public PeerInfo getPeerInfo() {
        return this.peer_info;
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
                th = implementation.isCurrent(this.handle);
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z;
    }

    /* JADX INFO: finally extract failed */
    public void makeCurrent() throws LWJGLException {
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
                implementation.makeCurrent(this.peer_info, this.handle);
                GLContext.useContext(this, this.forwardCompatible);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void releaseCurrent() throws LWJGLException {
        ContextGL currentContext = getCurrentContext();
        if (currentContext != null) {
            implementation.releaseCurrentContext();
            GLContext.useContext(null);
            current_context_local.set(null);
            synchronized (currentContext) {
                try {
                    currentContext.thread = null;
                    currentContext.checkDestroy();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    ContextGL contextGL = currentContext;
                    throw th2;
                }
            }
        }
    }

    public void releaseDrawable() throws LWJGLException {
        IllegalStateException illegalStateException;
        synchronized (this) {
            try {
                if (this.destroyed) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Context is destroyed");
                    throw illegalStateException2;
                }
                implementation.releaseDrawable(getHandle());
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.peer_info.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r12 = r15;
        r13 = new java.lang.UnsupportedOperationException("CL/GL context sharing is not supported on this platform.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCLSharingProperties(org.lwjgl.PointerBuffer r17) throws org.lwjgl.LWJGLException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r12 = r0
            monitor-enter(r12)
            r12 = r0
            org.lwjgl.opengl.PeerInfo r12 = r12.peer_info     // Catch:{ all -> 0x002a }
            java.nio.ByteBuffer r12 = r12.lockAndGetHandle()     // Catch:{ all -> 0x002a }
            r3 = r12
            int r12 = org.lwjgl.LWJGLUtil.getPlatform()     // Catch:{ all -> 0x0020 }
            switch(r12) {
                case 1: goto L_0x0062;
                case 2: goto L_0x008c;
                case 3: goto L_0x0030;
                default: goto L_0x0015;
            }     // Catch:{ all -> 0x0020 }
        L_0x0015:
            java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0020 }
            r15 = r12
            r12 = r15
            r13 = r15
            java.lang.String r14 = "CL/GL context sharing is not supported on this platform."
            r13.<init>(r14)     // Catch:{ all -> 0x0020 }
            throw r12     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r12 = move-exception
            r4 = r12
            r12 = r0
            org.lwjgl.opengl.PeerInfo r12 = r12.peer_info     // Catch:{ all -> 0x002a }
            r12.unlock()     // Catch:{ all -> 0x002a }
            r12 = r4
            throw r12     // Catch:{ all -> 0x002a }
        L_0x002a:
            r12 = move-exception
            r2 = r12
            r12 = r0
            monitor-exit(r12)
            r12 = r2
            throw r12
        L_0x0030:
            org.lwjgl.opengl.ContextImplementation r12 = implementation     // Catch:{ all -> 0x0020 }
            org.lwjgl.opengl.WindowsContextImplementation r12 = (org.lwjgl.opengl.WindowsContextImplementation) r12     // Catch:{ all -> 0x0020 }
            r11 = r12
            r12 = r1
            r13 = 8200(0x2008, double:4.0513E-320)
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            r13 = r11
            r14 = r0
            java.nio.ByteBuffer r14 = r14.handle     // Catch:{ all -> 0x0020 }
            long r13 = r13.getHGLRC(r14)     // Catch:{ all -> 0x0020 }
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            r12 = r1
            r13 = 8203(0x200b, double:4.053E-320)
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            r13 = r11
            r14 = r3
            long r13 = r13.getHDC(r14)     // Catch:{ all -> 0x0020 }
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
        L_0x0059:
            r12 = r0
            org.lwjgl.opengl.PeerInfo r12 = r12.peer_info     // Catch:{ all -> 0x002a }
            r12.unlock()     // Catch:{ all -> 0x002a }
            r12 = r0
            monitor-exit(r12)
            return
        L_0x0062:
            org.lwjgl.opengl.ContextImplementation r12 = implementation     // Catch:{ all -> 0x0020 }
            org.lwjgl.opengl.LinuxContextImplementation r12 = (org.lwjgl.opengl.LinuxContextImplementation) r12     // Catch:{ all -> 0x0020 }
            r8 = r12
            r12 = r1
            r13 = 8200(0x2008, double:4.0513E-320)
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            r13 = r8
            r14 = r0
            java.nio.ByteBuffer r14 = r14.handle     // Catch:{ all -> 0x0020 }
            long r13 = r13.getGLXContext(r14)     // Catch:{ all -> 0x0020 }
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            r12 = r1
            r13 = 8202(0x200a, double:4.0523E-320)
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            r13 = r8
            r14 = r3
            long r13 = r13.getDisplay(r14)     // Catch:{ all -> 0x0020 }
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            goto L_0x0059
        L_0x008c:
            r12 = 10
            r13 = 6
            boolean r12 = org.lwjgl.LWJGLUtil.isMacOSXEqualsOrBetterThan(r12, r13)     // Catch:{ all -> 0x0020 }
            if (r12 == 0) goto L_0x0015
            org.lwjgl.opengl.ContextImplementation r12 = implementation     // Catch:{ all -> 0x0020 }
            org.lwjgl.opengl.MacOSXContextImplementation r12 = (org.lwjgl.opengl.MacOSXContextImplementation) r12     // Catch:{ all -> 0x0020 }
            r13 = r0
            java.nio.ByteBuffer r13 = r13.handle     // Catch:{ all -> 0x0020 }
            long r12 = r12.getCGLShareGroup(r13)     // Catch:{ all -> 0x0020 }
            r5 = r12
            r12 = r1
            r13 = 268435456(0x10000000, double:1.32624737E-315)
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            r13 = r5
            org.lwjgl.PointerBuffer r12 = r12.put(r13)     // Catch:{ all -> 0x0020 }
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextGL.setCLSharingProperties(org.lwjgl.PointerBuffer):void");
    }

    public void update() {
        IllegalStateException illegalStateException;
        synchronized (this) {
            try {
                if (this.destroyed) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Context is destroyed");
                    throw illegalStateException2;
                }
                implementation.update(getHandle());
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
