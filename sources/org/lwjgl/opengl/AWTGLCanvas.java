package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Sys;

public class AWTGLCanvas extends Canvas implements DrawableLWJGL, ComponentListener, HierarchyListener {
    private static final AWTCanvasImplementation implementation = createImplementation();
    private static final long serialVersionUID = 1;
    private Object SYNC_LOCK;
    private final ContextAttribs attribs;
    private ContextGL context;
    private final Drawable drawable;
    private boolean first_run;
    private PeerInfo peer_info;
    private final PixelFormat pixel_format;
    private int reentry_count;
    private boolean update_context;

    static {
        Sys.initialize();
    }

    public AWTGLCanvas() throws LWJGLException {
        PixelFormat pixelFormat;
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat();
        this(pixelFormat2);
    }

    public AWTGLCanvas(GraphicsDevice graphicsDevice, PixelFormat pixelFormat) throws LWJGLException {
        this(graphicsDevice, pixelFormat, null);
    }

    public AWTGLCanvas(GraphicsDevice graphicsDevice, PixelFormat pixelFormat, Drawable drawable2) throws LWJGLException {
        this(graphicsDevice, pixelFormat, drawable2, null);
    }

    public AWTGLCanvas(GraphicsDevice graphicsDevice, PixelFormat pixelFormat, Drawable drawable2, ContextAttribs contextAttribs) throws LWJGLException {
        Object obj;
        NullPointerException nullPointerException;
        PixelFormat pixelFormat2 = pixelFormat;
        Drawable drawable3 = drawable2;
        ContextAttribs contextAttribs2 = contextAttribs;
        super(implementation.findConfiguration(graphicsDevice, pixelFormat2));
        Object obj2 = obj;
        Object obj3 = new Object();
        this.SYNC_LOCK = obj2;
        if (pixelFormat2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("Pixel format must be non-null");
            throw nullPointerException2;
        }
        addHierarchyListener(this);
        addComponentListener(this);
        this.drawable = drawable3;
        this.pixel_format = pixelFormat2;
        this.attribs = contextAttribs2;
    }

    public AWTGLCanvas(PixelFormat pixelFormat) throws LWJGLException {
        this(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(), pixelFormat);
    }

    static AWTCanvasImplementation createImplementation() {
        MacOSXCanvasImplementation macOSXCanvasImplementation;
        WindowsCanvasImplementation windowsCanvasImplementation;
        LinuxCanvasImplementation linuxCanvasImplementation;
        IllegalStateException illegalStateException;
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                LinuxCanvasImplementation linuxCanvasImplementation2 = linuxCanvasImplementation;
                LinuxCanvasImplementation linuxCanvasImplementation3 = new LinuxCanvasImplementation();
                return linuxCanvasImplementation2;
            case 2:
                MacOSXCanvasImplementation macOSXCanvasImplementation2 = macOSXCanvasImplementation;
                MacOSXCanvasImplementation macOSXCanvasImplementation3 = new MacOSXCanvasImplementation();
                return macOSXCanvasImplementation2;
            case 3:
                WindowsCanvasImplementation windowsCanvasImplementation2 = windowsCanvasImplementation;
                WindowsCanvasImplementation windowsCanvasImplementation3 = new WindowsCanvasImplementation();
                return windowsCanvasImplementation2;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Unsupported platform");
                throw illegalStateException2;
        }
    }

    private void setUpdate() {
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                this.update_context = true;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void addNotify() {
        AWTGLCanvas.super.addNotify();
    }

    public void checkGLError() {
        Util.checkGLError();
    }

    public void componentHidden(ComponentEvent componentEvent) {
    }

    public void componentMoved(ComponentEvent componentEvent) {
        ComponentEvent componentEvent2 = componentEvent;
        setUpdate();
    }

    public void componentResized(ComponentEvent componentEvent) {
        ComponentEvent componentEvent2 = componentEvent;
        setUpdate();
    }

    public void componentShown(ComponentEvent componentEvent) {
    }

    public ContextGL createSharedContext() throws LWJGLException {
        ContextGL contextGL;
        ContextGL contextGL2;
        IllegalStateException illegalStateException;
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                if (this.context == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Canvas not yet displayable");
                    throw illegalStateException2;
                }
                th = contextGL2;
                ContextGL contextGL3 = new ContextGL(this.peer_info, this.context.getContextAttribs(), this.context);
            } finally {
                contextGL = th;
                Object obj2 = obj;
                Throwable th = contextGL;
            }
        }
        return contextGL;
    }

    public final void destroy() {
        RuntimeException runtimeException;
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                if (this.context != null) {
                    this.context.forceDestroy();
                    this.context = null;
                    this.reentry_count = 0;
                    this.peer_info.destroy();
                    this.peer_info = null;
                }
            } catch (LWJGLException e) {
                LWJGLException lWJGLException = e;
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
                throw runtimeException2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void exceptionOccurred(LWJGLException lWJGLException) {
        StringBuilder sb;
        LWJGLException lWJGLException2 = lWJGLException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        LWJGLUtil.log(sb2.append("Unhandled exception occurred, skipping paint(): ").append(lWJGLException2).toString());
    }

    public ContextGL getContext() {
        return this.context;
    }

    public PixelFormatLWJGL getPixelFormat() {
        return this.pixel_format;
    }

    public void hierarchyChanged(HierarchyEvent hierarchyEvent) {
        HierarchyEvent hierarchyEvent2 = hierarchyEvent;
        setUpdate();
    }

    public void initContext(float f, float f2, float f3) {
        GL11.glClearColor(f, f2, f3, 0.0f);
        GL11.glClear(16384);
    }

    /* access modifiers changed from: protected */
    public void initGL() {
    }

    public boolean isCurrent() throws LWJGLException {
        boolean z;
        IllegalStateException illegalStateException;
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                if (this.context == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Canvas not yet displayable");
                    throw illegalStateException2;
                }
                th = this.context.isCurrent();
            } finally {
                z = th;
                Object obj2 = obj;
                Throwable th = z;
            }
        }
        return z;
    }

    public void makeCurrent() throws LWJGLException {
        IllegalStateException illegalStateException;
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                if (this.context == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Canvas not yet displayable");
                    throw illegalStateException2;
                }
                this.context.makeCurrent();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c1, code lost:
        if (r3 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c3, code lost:
        exceptionOccurred(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void paint(java.awt.Graphics r21) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r13 = 0
            r3 = r13
            r13 = r1
            java.lang.Object r13 = r13.SYNC_LOCK
            r4 = r13
            r13 = r4
            monitor-enter(r13)
            r13 = r1
            boolean r13 = r13.isDisplayable()     // Catch:{ all -> 0x00f3 }
            if (r13 != 0) goto L_0x0016
            r13 = r4
            monitor-exit(r13)     // Catch:{ all -> 0x00f3 }
        L_0x0015:
            return
        L_0x0016:
            r13 = r1
            org.lwjgl.opengl.PeerInfo r13 = r13.peer_info     // Catch:{ LWJGLException -> 0x00ee }
            if (r13 != 0) goto L_0x0035
            r13 = r1
            org.lwjgl.opengl.AWTCanvasImplementation r14 = implementation     // Catch:{ LWJGLException -> 0x00ee }
            r15 = r1
            r16 = r1
            r0 = r16
            org.lwjgl.opengl.PixelFormat r0 = r0.pixel_format     // Catch:{ LWJGLException -> 0x00ee }
            r16 = r0
            r17 = r1
            r0 = r17
            org.lwjgl.opengl.ContextAttribs r0 = r0.attribs     // Catch:{ LWJGLException -> 0x00ee }
            r17 = r0
            org.lwjgl.opengl.PeerInfo r14 = r14.createPeerInfo(r15, r16, r17)     // Catch:{ LWJGLException -> 0x00ee }
            r13.peer_info = r14     // Catch:{ LWJGLException -> 0x00ee }
        L_0x0035:
            r13 = r1
            org.lwjgl.opengl.PeerInfo r13 = r13.peer_info     // Catch:{ LWJGLException -> 0x00ee }
            java.nio.ByteBuffer r13 = r13.lockAndGetHandle()     // Catch:{ LWJGLException -> 0x00ee }
            r13 = r1
            org.lwjgl.opengl.ContextGL r13 = r13.context     // Catch:{ all -> 0x00e4 }
            if (r13 != 0) goto L_0x0072
            r13 = r1
            org.lwjgl.opengl.PeerInfo r13 = r13.peer_info     // Catch:{ all -> 0x00e4 }
            r10 = r13
            r13 = r1
            org.lwjgl.opengl.ContextAttribs r13 = r13.attribs     // Catch:{ all -> 0x00e4 }
            r11 = r13
            r13 = r1
            org.lwjgl.opengl.Drawable r13 = r13.drawable     // Catch:{ all -> 0x00e4 }
            if (r13 == 0) goto L_0x00ca
            r13 = r1
            org.lwjgl.opengl.Drawable r13 = r13.drawable     // Catch:{ all -> 0x00e4 }
            org.lwjgl.opengl.DrawableLWJGL r13 = (org.lwjgl.opengl.DrawableLWJGL) r13     // Catch:{ all -> 0x00e4 }
            org.lwjgl.opengl.Context r13 = r13.getContext()     // Catch:{ all -> 0x00e4 }
            org.lwjgl.opengl.ContextGL r13 = (org.lwjgl.opengl.ContextGL) r13     // Catch:{ all -> 0x00e4 }
            r12 = r13
        L_0x005a:
            r13 = r1
            org.lwjgl.opengl.ContextGL r14 = new org.lwjgl.opengl.ContextGL     // Catch:{ all -> 0x00e4 }
            r19 = r14
            r14 = r19
            r15 = r19
            r16 = r10
            r17 = r11
            r18 = r12
            r15.<init>(r16, r17, r18)     // Catch:{ all -> 0x00e4 }
            r13.context = r14     // Catch:{ all -> 0x00e4 }
            r13 = r1
            r14 = 1
            r13.first_run = r14     // Catch:{ all -> 0x00e4 }
        L_0x0072:
            r13 = r1
            int r13 = r13.reentry_count     // Catch:{ all -> 0x00e4 }
            if (r13 != 0) goto L_0x007d
            r13 = r1
            org.lwjgl.opengl.ContextGL r13 = r13.context     // Catch:{ all -> 0x00e4 }
            r13.makeCurrent()     // Catch:{ all -> 0x00e4 }
        L_0x007d:
            r13 = r1
            r14 = 1
            r15 = r1
            int r15 = r15.reentry_count     // Catch:{ all -> 0x00e4 }
            int r14 = r14 + r15
            r13.reentry_count = r14     // Catch:{ all -> 0x00e4 }
            r13 = r1
            boolean r13 = r13.update_context     // Catch:{ all -> 0x00cd }
            if (r13 == 0) goto L_0x0094
            r13 = r1
            org.lwjgl.opengl.ContextGL r13 = r13.context     // Catch:{ all -> 0x00cd }
            r13.update()     // Catch:{ all -> 0x00cd }
            r13 = r1
            r14 = 0
            r13.update_context = r14     // Catch:{ all -> 0x00cd }
        L_0x0094:
            r13 = r1
            boolean r13 = r13.first_run     // Catch:{ all -> 0x00cd }
            if (r13 == 0) goto L_0x00a1
            r13 = r1
            r14 = 0
            r13.first_run = r14     // Catch:{ all -> 0x00cd }
            r13 = r1
            r13.initGL()     // Catch:{ all -> 0x00cd }
        L_0x00a1:
            r13 = r1
            r13.paintGL()     // Catch:{ all -> 0x00cd }
            r13 = r1
            r14 = -1
            r15 = r1
            int r15 = r15.reentry_count     // Catch:{ all -> 0x00e4 }
            int r14 = r14 + r15
            r13.reentry_count = r14     // Catch:{ all -> 0x00e4 }
            r13 = r1
            int r13 = r13.reentry_count     // Catch:{ all -> 0x00e4 }
            if (r13 != 0) goto L_0x00b8
            r13 = r1
            org.lwjgl.opengl.ContextGL r13 = r13.context     // Catch:{ all -> 0x00e4 }
            r13.releaseCurrent()     // Catch:{ all -> 0x00e4 }
        L_0x00b8:
            r13 = r1
            org.lwjgl.opengl.PeerInfo r13 = r13.peer_info     // Catch:{ LWJGLException -> 0x00ee }
            r13.unlock()     // Catch:{ LWJGLException -> 0x00ee }
        L_0x00be:
            r13 = r4
            monitor-exit(r13)     // Catch:{ all -> 0x00f3 }
            r13 = r3
            if (r13 == 0) goto L_0x0015
            r13 = r1
            r14 = r3
            r13.exceptionOccurred(r14)
            goto L_0x0015
        L_0x00ca:
            r13 = 0
            r12 = r13
            goto L_0x005a
        L_0x00cd:
            r13 = move-exception
            r9 = r13
            r13 = r1
            r14 = -1
            r15 = r1
            int r15 = r15.reentry_count     // Catch:{ all -> 0x00e4 }
            int r14 = r14 + r15
            r13.reentry_count = r14     // Catch:{ all -> 0x00e4 }
            r13 = r1
            int r13 = r13.reentry_count     // Catch:{ all -> 0x00e4 }
            if (r13 != 0) goto L_0x00e2
            r13 = r1
            org.lwjgl.opengl.ContextGL r13 = r13.context     // Catch:{ all -> 0x00e4 }
            r13.releaseCurrent()     // Catch:{ all -> 0x00e4 }
        L_0x00e2:
            r13 = r9
            throw r13     // Catch:{ all -> 0x00e4 }
        L_0x00e4:
            r13 = move-exception
            r8 = r13
            r13 = r1
            org.lwjgl.opengl.PeerInfo r13 = r13.peer_info     // Catch:{ LWJGLException -> 0x00ee }
            r13.unlock()     // Catch:{ LWJGLException -> 0x00ee }
            r13 = r8
            throw r13     // Catch:{ LWJGLException -> 0x00ee }
        L_0x00ee:
            r13 = move-exception
            r6 = r13
            r13 = r6
            r3 = r13
            goto L_0x00be
        L_0x00f3:
            r13 = move-exception
            r5 = r13
            r13 = r4
            monitor-exit(r13)     // Catch:{ all -> 0x00f3 }
            r13 = r5
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.AWTGLCanvas.paint(java.awt.Graphics):void");
    }

    /* access modifiers changed from: protected */
    public void paintGL() {
    }

    public void releaseContext() throws LWJGLException {
        IllegalStateException illegalStateException;
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                if (this.context == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Canvas not yet displayable");
                    throw illegalStateException2;
                } else if (this.context.isCurrent()) {
                    this.context.releaseCurrent();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void removeNotify() {
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                destroy();
                AWTGLCanvas.super.removeNotify();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        AWTGLCanvas.super.setBounds(i, i2, i3, i4);
        setUpdate();
    }

    public final void setCLSharingProperties(PointerBuffer pointerBuffer) throws LWJGLException {
        IllegalStateException illegalStateException;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                if (this.context == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Canvas not yet displayable");
                    throw illegalStateException2;
                }
                this.context.setCLSharingProperties(pointerBuffer2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setLocation(int i, int i2) {
        AWTGLCanvas.super.setLocation(i, i2);
        setUpdate();
    }

    public void setLocation(Point point) {
        AWTGLCanvas.super.setLocation(point);
        setUpdate();
    }

    public void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL) throws LWJGLException {
        UnsupportedOperationException unsupportedOperationException;
        PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void setPixelFormat(PixelFormatLWJGL pixelFormatLWJGL, ContextAttribs contextAttribs) throws LWJGLException {
        UnsupportedOperationException unsupportedOperationException;
        PixelFormatLWJGL pixelFormatLWJGL2 = pixelFormatLWJGL;
        ContextAttribs contextAttribs2 = contextAttribs;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public void setSize(int i, int i2) {
        AWTGLCanvas.super.setSize(i, i2);
        setUpdate();
    }

    public void setSize(Dimension dimension) {
        AWTGLCanvas.super.setSize(dimension);
        setUpdate();
    }

    public void setSwapInterval(int i) {
        IllegalStateException illegalStateException;
        int i2 = i;
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                if (this.context == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Canvas not yet displayable");
                    throw illegalStateException2;
                }
                ContextGL.setSwapInterval(i2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void setVSyncEnabled(boolean z) {
        setSwapInterval(z ? 1 : 0);
    }

    public void swapBuffers() throws LWJGLException {
        IllegalStateException illegalStateException;
        Object obj = this.SYNC_LOCK;
        synchronized (obj) {
            try {
                if (this.context == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("Canvas not yet displayable");
                    throw illegalStateException2;
                }
                ContextGL.swapBuffers();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void update(Graphics graphics) {
        paint(graphics);
    }
}
