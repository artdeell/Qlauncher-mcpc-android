package org.lwjgl.opengl;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

class MouseEventQueue extends EventQueue implements MouseListener, MouseMotionListener, MouseWheelListener {
    public static final int NUM_BUTTONS = 3;
    private static final int WHEEL_SCALE = 120;
    private int accum_dx;
    private int accum_dy;
    private int accum_dz;
    private final byte[] buttons = new byte[3];
    private final Component component;
    private final ByteBuffer event = ByteBuffer.allocate(22);
    private boolean grabbed;
    private int last_x;
    private int last_y;
    private boolean saved_control_state;

    MouseEventQueue(Component component2) {
        Component component3 = component2;
        super(22);
        this.component = component3;
    }

    private void handleButton(MouseEvent mouseEvent) {
        byte b;
        byte b2;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        MouseEvent mouseEvent2 = mouseEvent;
        switch (mouseEvent2.getID()) {
            case 501:
                b = 1;
                break;
            case 502:
                b = 0;
                break;
            default:
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(sb3.append("Not a valid event ID: ").append(mouseEvent2.getID()).toString());
                throw illegalArgumentException3;
        }
        switch (mouseEvent2.getButton()) {
            case 0:
                return;
            case 1:
                if (b == 1) {
                    this.saved_control_state = mouseEvent2.isControlDown();
                }
                if (this.saved_control_state) {
                    if (this.buttons[1] != b) {
                        b2 = 1;
                        break;
                    } else {
                        return;
                    }
                } else {
                    b2 = 0;
                    break;
                }
            case 2:
                b2 = 2;
                break;
            case 3:
                if (this.buttons[1] != b) {
                    b2 = 1;
                    break;
                } else {
                    return;
                }
            default:
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb5.append("Not a valid button: ").append(mouseEvent2.getButton()).toString());
                throw illegalArgumentException5;
        }
        setButton(b2, b, 1000000 * mouseEvent2.getWhen());
    }

    private void handleMotion(MouseEvent mouseEvent) {
        MouseEvent mouseEvent2 = mouseEvent;
        if (this.grabbed) {
            updateDeltas(1000000 * mouseEvent2.getWhen());
        } else {
            setCursorPos(mouseEvent2.getX(), mouseEvent2.getY(), 1000000 * mouseEvent2.getWhen());
        }
    }

    private void handleWheel(int i, long j) {
        int i2 = i;
        long j2 = j;
        this.accum_dz = i2 + this.accum_dz;
        putMouseEvent(-1, 0, i2, j2);
    }

    private void putMouseEvent(byte b, byte b2, int i, long j) {
        byte b3 = b;
        byte b4 = b2;
        int i2 = i;
        long j2 = j;
        if (this.grabbed) {
            putMouseEventWithCoords(b3, b4, 0, 0, i2, j2);
        } else {
            putMouseEventWithCoords(b3, b4, this.last_x, this.last_y, i2, j2);
        }
    }

    private void setButton(byte b, byte b2, long j) {
        byte b3 = b;
        byte b4 = b2;
        long j2 = j;
        this.buttons[b3] = b4;
        putMouseEvent(b3, b4, 0, j2);
    }

    private void setCursorPos(int i, int i2, long j) {
        int i3 = i;
        long j2 = j;
        int transformY = transformY(i2);
        if (!this.grabbed) {
            addDelta(i3 - this.last_x, transformY - this.last_y);
            this.last_x = i3;
            this.last_y = transformY;
            putMouseEventWithCoords(-1, 0, i3, transformY, 0, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void addDelta(int i, int i2) {
        int i3 = i2;
        this.accum_dx = i + this.accum_dx;
        this.accum_dy = i3 + this.accum_dy;
    }

    /* access modifiers changed from: protected */
    public Component getComponent() {
        return this.component;
    }

    public boolean isGrabbed() {
        boolean z;
        synchronized (this) {
            try {
                th = this.grabbed;
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z;
    }

    public void mouseClicked(MouseEvent mouseEvent) {
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        MouseEvent mouseEvent2 = mouseEvent;
        synchronized (this) {
            try {
                handleMotion(mouseEvent2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        MouseEvent mouseEvent2 = mouseEvent;
        synchronized (this) {
            try {
                handleMotion(mouseEvent2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void mousePressed(MouseEvent mouseEvent) {
        MouseEvent mouseEvent2 = mouseEvent;
        synchronized (this) {
            try {
                handleButton(mouseEvent2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        MouseEvent mouseEvent2 = mouseEvent;
        synchronized (this) {
            try {
                handleButton(mouseEvent2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        MouseWheelEvent mouseWheelEvent2 = mouseWheelEvent;
        synchronized (this) {
            try {
                handleWheel(120 * (-mouseWheelEvent2.getWheelRotation()), 1000000 * mouseWheelEvent2.getWhen());
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void poll(IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        synchronized (this) {
            try {
                if (this.grabbed) {
                    IntBuffer put = intBuffer2.put(0, this.accum_dx);
                    IntBuffer put2 = intBuffer2.put(1, this.accum_dy);
                } else {
                    IntBuffer put3 = intBuffer2.put(0, this.last_x);
                    IntBuffer put4 = intBuffer2.put(1, this.last_y);
                }
                IntBuffer put5 = intBuffer2.put(2, this.accum_dz);
                this.accum_dz = 0;
                this.accum_dy = 0;
                this.accum_dx = 0;
                int position = byteBuffer2.position();
                ByteBuffer put6 = byteBuffer2.put(this.buttons, 0, this.buttons.length);
                Buffer position2 = byteBuffer2.position(position);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void putMouseEventWithCoords(byte b, byte b2, int i, int i2, int i3, long j) {
        byte b3 = b;
        byte b4 = b2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        Buffer clear = this.event.clear();
        ByteBuffer putLong = this.event.put(b3).put(b4).putInt(i4).putInt(i5).putInt(i6).putLong(j2);
        Buffer flip = this.event.flip();
        boolean putEvent = putEvent(this.event);
    }

    public void register() {
        synchronized (this) {
            try {
                resetCursorToCenter();
                if (this.component != null) {
                    this.component.addMouseListener(this);
                    this.component.addMouseMotionListener(this);
                    this.component.addMouseWheelListener(this);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resetCursorToCenter() {
        clearEvents();
        this.accum_dy = 0;
        this.accum_dx = 0;
        if (this.component != null) {
            Point cursorPosition = AWTUtil.getCursorPosition(this.component);
            if (cursorPosition != null) {
                this.last_x = cursorPosition.x;
                this.last_y = cursorPosition.y;
            }
        }
    }

    public void setGrabbed(boolean z) {
        boolean z2 = z;
        synchronized (this) {
            try {
                this.grabbed = z2;
                resetCursorToCenter();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int transformY(int i) {
        int i2 = i;
        if (this.component != null) {
            i2 = (-1 + this.component.getHeight()) - i2;
        }
        return i2;
    }

    public void unregister() {
        synchronized (this) {
            try {
                if (this.component != null) {
                    this.component.removeMouseListener(this);
                    this.component.removeMouseMotionListener(this);
                    this.component.removeMouseWheelListener(this);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateDeltas(long j) {
    }
}
