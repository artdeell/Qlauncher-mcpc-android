package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;

final class LinuxMouse {
    private static final int Button1 = 1;
    private static final int Button2 = 2;
    private static final int Button3 = 3;
    private static final int Button4 = 4;
    private static final int Button5 = 5;
    private static final int Button6 = 6;
    private static final int Button7 = 7;
    private static final int Button8 = 8;
    private static final int Button9 = 9;
    private static final int ButtonPress = 4;
    private static final int ButtonRelease = 5;
    private static final int POINTER_WARP_BORDER = 10;
    private static final int WHEEL_SCALE = 120;
    private int accum_dx;
    private int accum_dy;
    private int accum_dz;
    private int button_count;
    private byte[] buttons;
    private final long display;
    private final ByteBuffer event_buffer = ByteBuffer.allocate(22);
    private EventQueue event_queue;
    private final long input_window;
    private long last_event_nanos;
    private int last_x;
    private int last_y;
    private final IntBuffer query_pointer_buffer = BufferUtils.createIntBuffer(4);
    private final long warp_atom;
    private final long window;

    LinuxMouse(long j, long j2, long j3) throws LWJGLException {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        this.display = j4;
        this.window = j5;
        this.input_window = j6;
        this.warp_atom = LinuxDisplay.nInternAtom(j4, "_LWJGL", false);
        this.button_count = nGetButtonCount(j4);
        this.buttons = new byte[this.button_count];
        reset(false, false);
    }

    private void doHandlePointerMotion(boolean z, boolean z2, long j, int i, int i2, int i3, int i4, long j2) {
        boolean z3 = z2;
        long j3 = j;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        setCursorPos(z, i7, i8, j2);
        if (z3) {
            int nGetWindowHeight = nGetWindowHeight(this.display, j3);
            int nGetWindowWidth = nGetWindowWidth(this.display, j3);
            int i9 = i5 - i7;
            int i10 = i6 - i8;
            int nGetWindowWidth2 = i9 + nGetWindowWidth(this.display, this.window);
            int nGetWindowHeight2 = i10 + nGetWindowHeight(this.display, this.window);
            int max = Math.max(0, i9);
            int max2 = Math.max(0, i10);
            int min = Math.min(nGetWindowWidth, nGetWindowWidth2);
            int min2 = Math.min(nGetWindowHeight, nGetWindowHeight2);
            if (i5 < max + 10 || i6 < max2 + 10 || i5 > min + -10 || i6 > min2 + -10) {
                doWarpPointer((min - max) / 2, (min2 - max2) / 2);
            }
        }
    }

    private void doWarpPointer(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        nSendWarpEvent(this.display, this.input_window, this.warp_atom, i3, i4);
        nWarpCursor(this.display, this.window, i3, i4);
    }

    private void handleButton(boolean z, int i, byte b, long j) {
        byte b2;
        boolean z2 = z;
        int i2 = i;
        byte b3 = b;
        long j2 = j;
        switch (i2) {
            case 1:
                b2 = 0;
                break;
            case 2:
                b2 = 2;
                break;
            case 3:
                b2 = 1;
                break;
            case 6:
                b2 = 5;
                break;
            case 7:
                b2 = 6;
                break;
            case 8:
                b2 = 3;
                break;
            case 9:
                b2 = 4;
                break;
            default:
                if (i2 > 9 && i2 <= this.button_count) {
                    b2 = (byte) (i2 - 1);
                    break;
                } else {
                    return;
                }
        }
        this.buttons[b2] = b3;
        putMouseEvent(z2, b2, b3, 0, j2);
    }

    private void handleButtonEvent(boolean z, long j, int i, byte b) {
        boolean z2 = z;
        byte b2 = b;
        long j2 = j * 1000000;
        switch (i) {
            case 4:
                handleButtonPress(z2, b2, j2);
                return;
            case 5:
                handleButton(z2, b2, 0, j2);
                return;
            default:
                return;
        }
    }

    private void handleButtonPress(boolean z, byte b, long j) {
        boolean z2 = z;
        byte b2 = b;
        long j2 = j;
        switch (b2) {
            case 4:
                putMouseEvent(z2, -1, 0, 120, j2);
                this.accum_dz = 120 + this.accum_dz;
                return;
            case 5:
                putMouseEvent(z2, -1, 0, -120, j2);
                this.accum_dz = -120 + this.accum_dz;
                return;
            default:
                handleButton(z2, b2, 1, j2);
                return;
        }
    }

    private void handlePointerMotion(boolean z, boolean z2, long j, long j2, int i, int i2, int i3, int i4) {
        doHandlePointerMotion(z, z2, j2, i, i2, i3, i4, j * 1000000);
    }

    private void handleWarpEvent(int i, int i2) {
        resetCursor(i, i2);
    }

    private static native int nGetButtonCount(long j);

    private static native int nGetWindowHeight(long j, long j2);

    private static native int nGetWindowWidth(long j, long j2);

    private static native long nQueryPointer(long j, long j2, IntBuffer intBuffer);

    private static native void nSendWarpEvent(long j, long j2, long j3, int i, int i2);

    private static native void nWarpCursor(long j, long j2, int i, int i2);

    private void putMouseEvent(boolean z, byte b, byte b2, int i, long j) {
        byte b3 = b;
        byte b4 = b2;
        int i2 = i;
        long j2 = j;
        if (z) {
            putMouseEventWithCoords(b3, b4, 0, 0, i2, j2);
        } else {
            putMouseEventWithCoords(b3, b4, this.last_x, this.last_y, i2, j2);
        }
    }

    private void putMouseEventWithCoords(byte b, byte b2, int i, int i2, int i3, long j) {
        byte b3 = b;
        byte b4 = b2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        Buffer clear = this.event_buffer.clear();
        ByteBuffer putLong = this.event_buffer.put(b3).put(b4).putInt(i4).putInt(i5).putInt(i6).putLong(j2);
        Buffer flip = this.event_buffer.flip();
        boolean putEvent = this.event_queue.putEvent(this.event_buffer);
        this.last_event_nanos = j2;
    }

    private void reset(boolean z, boolean z2) {
        EventQueue eventQueue;
        boolean z3 = z;
        boolean z4 = z2;
        EventQueue eventQueue2 = eventQueue;
        EventQueue eventQueue3 = new EventQueue(this.event_buffer.capacity());
        this.event_queue = eventQueue2;
        this.accum_dy = 0;
        this.accum_dx = 0;
        long nQueryPointer = nQueryPointer(this.display, this.window, this.query_pointer_buffer);
        int i = this.query_pointer_buffer.get(0);
        int i2 = this.query_pointer_buffer.get(1);
        int i3 = this.query_pointer_buffer.get(2);
        int i4 = this.query_pointer_buffer.get(3);
        this.last_x = i3;
        this.last_y = transformY(i4);
        doHandlePointerMotion(z3, z4, nQueryPointer, i, i2, i3, i4, this.last_event_nanos);
    }

    private void resetCursor(int i, int i2) {
        int i3 = i2;
        this.last_x = i;
        this.last_y = transformY(i3);
    }

    private void setCursorPos(boolean z, int i, int i2, long j) {
        boolean z2 = z;
        int i3 = i;
        long j2 = j;
        int transformY = transformY(i2);
        int i4 = i3 - this.last_x;
        int i5 = transformY - this.last_y;
        if (i4 != 0 || i5 != 0) {
            this.accum_dx = i4 + this.accum_dx;
            this.accum_dy = i5 + this.accum_dy;
            this.last_x = i3;
            this.last_y = transformY;
            if (z2) {
                putMouseEventWithCoords(-1, 0, i4, i5, 0, j2);
            } else {
                putMouseEventWithCoords(-1, 0, i3, transformY, 0, j2);
            }
        }
    }

    private int transformY(int i) {
        return (-1 + nGetWindowHeight(this.display, this.window)) - i;
    }

    public void changeGrabbed(boolean z, boolean z2) {
        reset(z, z2);
    }

    public boolean filterEvent(boolean z, boolean z2, LinuxEvent linuxEvent) {
        boolean z3 = z;
        boolean z4 = z2;
        LinuxEvent linuxEvent2 = linuxEvent;
        switch (linuxEvent2.getType()) {
            case 4:
            case 5:
                handleButtonEvent(z3, linuxEvent2.getButtonTime(), linuxEvent2.getButtonType(), (byte) linuxEvent2.getButtonButton());
                return true;
            case 6:
                handlePointerMotion(z3, z4, linuxEvent2.getButtonTime(), linuxEvent2.getButtonRoot(), linuxEvent2.getButtonXRoot(), linuxEvent2.getButtonYRoot(), linuxEvent2.getButtonX(), linuxEvent2.getButtonY());
                return true;
            case 33:
                if (linuxEvent2.getClientMessageType() == this.warp_atom) {
                    handleWarpEvent(linuxEvent2.getClientData(0), linuxEvent2.getClientData(1));
                    return true;
                }
                break;
        }
        return false;
    }

    public int getButtonCount() {
        return this.buttons.length;
    }

    public void poll(boolean z, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (z) {
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
        for (int i = 0; i < this.buttons.length; i++) {
            ByteBuffer put6 = byteBuffer2.put(i, this.buttons[i]);
        }
    }

    public void read(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.event_queue.copyEvents(byteBuffer2);
    }

    public void setCursorPosition(int i, int i2) {
        nWarpCursor(this.display, this.window, i, transformY(i2));
    }
}
