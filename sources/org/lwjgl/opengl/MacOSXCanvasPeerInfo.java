package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

abstract class MacOSXCanvasPeerInfo extends MacOSXPeerInfo {
    private final AWTSurfaceLock awt_surface;
    public ByteBuffer window_handle;

    protected MacOSXCanvasPeerInfo(PixelFormat pixelFormat, ContextAttribs contextAttribs, boolean z) throws LWJGLException {
        AWTSurfaceLock aWTSurfaceLock;
        super(pixelFormat, contextAttribs, true, true, z, true);
        AWTSurfaceLock aWTSurfaceLock2 = aWTSurfaceLock;
        AWTSurfaceLock aWTSurfaceLock3 = new AWTSurfaceLock();
        this.awt_surface = aWTSurfaceLock2;
    }

    private void addComponentListener(Canvas canvas) {
        ComponentListener componentListener;
        Canvas canvas2 = canvas;
        ComponentListener[] componentListeners = canvas2.getComponentListeners();
        int i = 0;
        while (i < componentListeners.length) {
            if (componentListeners[i].toString() != "CanvasPeerInfoListener") {
                i++;
            } else {
                return;
            }
        }
        Canvas canvas3 = canvas2;
        ComponentListener componentListener2 = componentListener;
        final Canvas canvas4 = canvas2;
        ComponentListener r6 = new ComponentListener(this) {
            final /* synthetic */ MacOSXCanvasPeerInfo this$0;

            {
                Canvas canvas = r7;
                this.this$0 = r6;
            }

            public void componentHidden(ComponentEvent componentEvent) {
            }

            public void componentMoved(ComponentEvent componentEvent) {
                ComponentEvent componentEvent2 = componentEvent;
                Insets access$000 = this.this$0.getInsets(canvas4);
                int i = access$000 != null ? access$000.top : 0;
                int i2 = 0;
                if (access$000 != null) {
                    i2 = access$000.left;
                }
                MacOSXCanvasPeerInfo.nSetLayerPosition(this.this$0.getHandle(), canvas4.getX() - i2, canvas4.getY() - i);
            }

            public void componentResized(ComponentEvent componentEvent) {
                ComponentEvent componentEvent2 = componentEvent;
                Insets access$000 = this.this$0.getInsets(canvas4);
                int i = access$000 != null ? access$000.top : 0;
                int i2 = 0;
                if (access$000 != null) {
                    i2 = access$000.left;
                }
                MacOSXCanvasPeerInfo.nSetLayerPosition(this.this$0.getHandle(), canvas4.getX() - i2, canvas4.getY() - i);
            }

            public void componentShown(ComponentEvent componentEvent) {
            }

            public String toString() {
                return "CanvasPeerInfoListener";
            }
        };
        canvas3.addComponentListener(componentListener2);
    }

    /* access modifiers changed from: private */
    public Insets getInsets(Canvas canvas) {
        Container parent = canvas.getParent();
        while (true) {
            Container container = parent;
            if (container == null) {
                return null;
            }
            if (container instanceof Container) {
                return container.getInsets();
            }
            parent = container.getParent();
        }
    }

    private static native ByteBuffer nInitHandle(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, boolean z, int i, int i2) throws LWJGLException;

    /* access modifiers changed from: private */
    public static native void nSetLayerPosition(ByteBuffer byteBuffer, int i, int i2);

    /* access modifiers changed from: protected */
    public void doUnlock() throws LWJGLException {
        this.awt_surface.unlock();
    }

    /* access modifiers changed from: protected */
    public void initHandle(Canvas canvas) throws LWJGLException {
        Canvas canvas2 = canvas;
        boolean z = true;
        String property = System.getProperty("java.version");
        if (property.startsWith("1.5") || property.startsWith("1.6")) {
            z = false;
        }
        Insets insets = getInsets(canvas2);
        int i = insets != null ? insets.top : 0;
        int i2 = 0;
        if (insets != null) {
            i2 = insets.left;
        }
        this.window_handle = nInitHandle(this.awt_surface.lockAndGetHandle(canvas2), getHandle(), this.window_handle, z, canvas2.getX() - i2, canvas2.getY() - i);
        if (property.startsWith("1.7")) {
            addComponentListener(canvas2);
        }
    }
}
