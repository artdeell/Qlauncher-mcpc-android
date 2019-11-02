package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

final class MacOSXCanvasListener implements ComponentListener, HierarchyListener {
    /* access modifiers changed from: private */
    public final Canvas canvas;
    private boolean context_update;
    private int height;
    private boolean resized;
    private int width;

    MacOSXCanvasListener(Canvas canvas2) {
        Canvas canvas3 = canvas2;
        this.canvas = canvas3;
        canvas3.addComponentListener(this);
        canvas3.addHierarchyListener(this);
        setUpdate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setUpdate() {
        /*
            r5 = this;
            r0 = r5
            r3 = r0
            monitor-enter(r3)
            r3 = r0
            monitor-enter(r3)     // Catch:{ all -> 0x0028 }
            r3 = r0
            r4 = r0
            java.awt.Canvas r4 = r4.canvas     // Catch:{ all -> 0x0022 }
            int r4 = r4.getWidth()     // Catch:{ all -> 0x0022 }
            r3.width = r4     // Catch:{ all -> 0x0022 }
            r3 = r0
            r4 = r0
            java.awt.Canvas r4 = r4.canvas     // Catch:{ all -> 0x0022 }
            int r4 = r4.getHeight()     // Catch:{ all -> 0x0022 }
            r3.height = r4     // Catch:{ all -> 0x0022 }
            r3 = r0
            r4 = 1
            r3.context_update = r4     // Catch:{ all -> 0x0022 }
            r3 = r0
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            r3 = r0
            monitor-exit(r3)
            return
        L_0x0022:
            r3 = move-exception
            r2 = r3
            r3 = r0
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            r3 = r2
            throw r3     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r3 = move-exception
            r1 = r3
            r3 = r0
            monitor-exit(r3)
            r3 = r1
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.MacOSXCanvasListener.setUpdate():void");
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
        this.resized = true;
    }

    public void componentShown(ComponentEvent componentEvent) {
    }

    public void disableListeners() {
        C08031 r4;
        C08031 r1 = r4;
        C08031 r2 = new Runnable(this) {
            final /* synthetic */ MacOSXCanvasListener this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                this.this$0.canvas.removeComponentListener(this.this$0);
                this.this$0.canvas.removeHierarchyListener(this.this$0);
            }
        };
        EventQueue.invokeLater(r1);
    }

    public void hierarchyChanged(HierarchyEvent hierarchyEvent) {
        HierarchyEvent hierarchyEvent2 = hierarchyEvent;
        setUpdate();
    }

    public int syncGetHeight() {
        synchronized (this) {
            try {
                th = this.height;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public int syncGetWidth() {
        synchronized (this) {
            try {
                th = this.width;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean syncShouldUpdateContext() {
        synchronized (this) {
            try {
                th = this.context_update;
                this.context_update = false;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean wasResized() {
        boolean z = false;
        if (this.resized) {
            this.resized = false;
            z = true;
        }
        return z;
    }
}
