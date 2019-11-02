package org.lwjgl.opengl;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

final class MacOSXMouseEventQueue extends MouseEventQueue {
    private static boolean is_grabbed;
    private final IntBuffer delta_buffer = BufferUtils.createIntBuffer(2);
    private boolean skip_event;

    MacOSXMouseEventQueue(Component component) {
        super(component);
    }

    private static native void getMouseDeltas(IntBuffer intBuffer);

    private static void grabMouse(boolean z) {
        boolean z2 = z;
        synchronized (MacOSXMouseEventQueue.class) {
            try {
                is_grabbed = z2;
                if (!z2) {
                    nGrabMouse(z2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<MacOSXMouseEventQueue> cls = MacOSXMouseEventQueue.class;
                throw th2;
            }
        }
    }

    static native void nGrabMouse(boolean z);

    private static native void nWarpCursor(int i, int i2);

    /* access modifiers changed from: protected */
    public void resetCursorToCenter() {
        super.resetCursorToCenter();
        getMouseDeltas(this.delta_buffer);
    }

    public void setGrabbed(boolean z) {
        boolean z2 = z;
        if (is_grabbed != z2) {
            super.setGrabbed(z2);
            warpCursor();
            grabMouse(z2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void updateDeltas(long j) {
        long j2 = j;
        super.updateDeltas(j2);
        synchronized (this) {
            try {
                getMouseDeltas(this.delta_buffer);
                int i = this.delta_buffer.get(0);
                int i2 = -this.delta_buffer.get(1);
                if (this.skip_event) {
                    this.skip_event = false;
                    nGrabMouse(isGrabbed());
                    return;
                }
                if (!(i == 0 && i2 == 0)) {
                    putMouseEventWithCoords(-1, 0, i, i2, 0, j2);
                    addDelta(i, i2);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public void warpCursor() {
        synchronized (this) {
            try {
                this.skip_event = isGrabbed();
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
        if (isGrabbed()) {
            Rectangle bounds = getComponent().getBounds();
            Point locationOnScreen = getComponent().getLocationOnScreen();
            nWarpCursor(locationOnScreen.x + (bounds.width / 2), locationOnScreen.y + (bounds.height / 2));
        }
    }
}
