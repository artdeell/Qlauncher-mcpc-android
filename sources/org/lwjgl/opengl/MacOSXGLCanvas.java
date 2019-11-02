package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Graphics;

final class MacOSXGLCanvas extends Canvas {
    private static final long serialVersionUID = 6916664741667434870L;
    private boolean canvas_painted;
    private boolean dirty;

    MacOSXGLCanvas() {
    }

    public void paint(Graphics graphics) {
        Graphics graphics2 = graphics;
        synchronized (this) {
            try {
                this.dirty = true;
                this.canvas_painted = true;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public boolean syncCanvasPainted() {
        synchronized (this) {
            try {
                th = this.canvas_painted;
                this.canvas_painted = false;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public boolean syncIsDirty() {
        synchronized (this) {
            try {
                th = this.dirty;
                this.dirty = false;
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public void update(Graphics graphics) {
        paint(graphics);
    }
}
