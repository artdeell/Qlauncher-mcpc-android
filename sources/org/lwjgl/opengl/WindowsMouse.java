package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

final class WindowsMouse {
    private int accum_dwheel;
    private int accum_dx;
    private int accum_dy;
    private final Object blank_cursor;
    private byte[] button_states;
    private final EventQueue event_queue;
    private final boolean has_wheel;
    private final long hwnd;
    private int last_x;
    private int last_y;
    private final int mouse_button_count;
    private final ByteBuffer mouse_event = ByteBuffer.allocate(22);
    private boolean mouse_grabbed;

    WindowsMouse(long j) throws LWJGLException {
        EventQueue eventQueue;
        long j2 = j;
        EventQueue eventQueue2 = eventQueue;
        EventQueue eventQueue3 = new EventQueue(22);
        this.event_queue = eventQueue2;
        this.hwnd = j2;
        this.mouse_button_count = Math.min(5, WindowsDisplay.getSystemMetrics(43));
        this.has_wheel = WindowsDisplay.getSystemMetrics(75) != 0;
        this.blank_cursor = createBlankCursor();
        this.button_states = new byte[this.mouse_button_count];
    }

    private void centerCursor() {
        WindowsDisplay.centerCursor(this.hwnd);
    }

    private Object createBlankCursor() throws LWJGLException {
        int systemMetrics = WindowsDisplay.getSystemMetrics(13);
        int systemMetrics2 = WindowsDisplay.getSystemMetrics(14);
        return WindowsDisplay.doCreateCursor(systemMetrics, systemMetrics2, 0, 0, 1, BufferUtils.createIntBuffer(systemMetrics * systemMetrics2), null);
    }

    private void putMouseEvent(byte b, byte b2, int i, long j) {
        byte b3 = b;
        byte b4 = b2;
        int i2 = i;
        long j2 = j;
        if (this.mouse_grabbed) {
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
        Buffer clear = this.mouse_event.clear();
        ByteBuffer putLong = this.mouse_event.put(b3).put(b4).putInt(i4).putInt(i5).putInt(i6).putLong(j2);
        Buffer flip = this.mouse_event.flip();
        boolean putEvent = this.event_queue.putEvent(this.mouse_event);
    }

    public void destroy() {
        WindowsDisplay.doDestroyCursor(this.blank_cursor);
    }

    public Object getBlankCursor() {
        return this.blank_cursor;
    }

    public int getButtonCount() {
        return this.mouse_button_count;
    }

    public void grab(boolean z, boolean z2) {
        StringBuilder sb;
        boolean z3 = z2;
        if (z) {
            if (!this.mouse_grabbed) {
                this.mouse_grabbed = true;
                if (z3) {
                    try {
                        WindowsDisplay.setupCursorClipping(this.hwnd);
                    } catch (LWJGLException e) {
                        LWJGLException lWJGLException = e;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        LWJGLUtil.log(sb2.append("Failed to setup cursor clipping: ").append(lWJGLException).toString());
                    }
                    centerCursor();
                }
            }
        } else if (this.mouse_grabbed) {
            this.mouse_grabbed = false;
            WindowsDisplay.resetCursorClipping();
        }
        this.event_queue.clearEvents();
    }

    public void handleMouseButton(byte b, byte b2, long j) {
        byte b3 = b;
        byte b4 = b2;
        putMouseEvent(b3, b4, 0, j * 1000000);
        if (b3 < this.button_states.length) {
            byte[] bArr = this.button_states;
            byte b5 = 0;
            if (b4 != 0) {
                b5 = 1;
            }
            bArr[b3] = b5;
        }
    }

    public void handleMouseMoved(int i, int i2, long j, boolean z) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        boolean z2 = z;
        int i5 = i3 - this.last_x;
        int i6 = i4 - this.last_y;
        if (i5 != 0 || i6 != 0) {
            this.accum_dx = i5 + this.accum_dx;
            this.accum_dy = i6 + this.accum_dy;
            this.last_x = i3;
            this.last_y = i4;
            long j3 = j2 * 1000000;
            if (this.mouse_grabbed) {
                putMouseEventWithCoords(-1, 0, i5, i6, 0, j3);
                if (z2) {
                    centerCursor();
                    return;
                }
                return;
            }
            putMouseEventWithCoords(-1, 0, i3, i4, 0, j3);
        }
    }

    public void handleMouseScrolled(int i, long j) {
        int i2 = i;
        long j2 = j;
        this.accum_dwheel = i2 + this.accum_dwheel;
        putMouseEvent(-1, 0, i2, 1000000 * j2);
    }

    public boolean hasWheel() {
        return this.has_wheel;
    }

    public boolean isGrabbed() {
        return this.mouse_grabbed;
    }

    public void poll(IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        for (int i = 0; i < intBuffer2.remaining(); i++) {
            IntBuffer put = intBuffer2.put(i + intBuffer2.position(), 0);
        }
        int i2 = this.mouse_button_count;
        IntBuffer put2 = intBuffer2.put(2 + intBuffer2.position(), this.accum_dwheel);
        if (i2 > this.button_states.length) {
            i2 = this.button_states.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer put3 = byteBuffer2.put(i3 + byteBuffer2.position(), this.button_states[i3]);
        }
        if (isGrabbed()) {
            IntBuffer put4 = intBuffer2.put(0 + intBuffer2.position(), this.accum_dx);
            IntBuffer put5 = intBuffer2.put(1 + intBuffer2.position(), this.accum_dy);
        } else {
            IntBuffer put6 = intBuffer2.put(0 + intBuffer2.position(), this.last_x);
            IntBuffer put7 = intBuffer2.put(1 + intBuffer2.position(), this.last_y);
        }
        this.accum_dwheel = 0;
        this.accum_dy = 0;
        this.accum_dx = 0;
    }

    public void read(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.event_queue.copyEvents(byteBuffer2);
    }

    public void setPosition(int i, int i2) {
        int i3 = i2;
        this.last_x = i;
        this.last_y = i3;
    }
}
