package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import org.lwjgl.LWJGLException;

final class WindowsKeyboard {
    private static final int BUFFER_SIZE = 50;
    private static final int MAPVK_VK_TO_VSC = 0;
    private final EventQueue event_queue;
    private boolean grabbed;
    private boolean has_retained_event;
    private final long hwnd;
    private final byte[] key_down_buffer = new byte[256];
    private int retained_char;
    private int retained_key_code;
    private long retained_millis;
    private boolean retained_repeat;
    private byte retained_state;
    private final ByteBuffer tmp_event;
    private final byte[] virt_key_down_buffer = new byte[256];

    WindowsKeyboard(long j) throws LWJGLException {
        EventQueue eventQueue;
        long j2 = j;
        EventQueue eventQueue2 = eventQueue;
        EventQueue eventQueue3 = new EventQueue(18);
        this.event_queue = eventQueue2;
        this.tmp_event = ByteBuffer.allocate(18);
        this.hwnd = j2;
    }

    private static native short GetAsyncKeyState(int i);

    private static native short GetKeyState(int i);

    private static native int GetKeyboardState(ByteBuffer byteBuffer);

    private static native int MapVirtualKey(int i, int i2);

    private static native int ToAscii(int i, int i2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i3);

    private static native int ToUnicode(int i, int i2, ByteBuffer byteBuffer, CharBuffer charBuffer, int i3, int i4);

    private boolean checkShiftKey(int i, byte b) {
        int i2 = i;
        byte b2 = b;
        return this.key_down_buffer[WindowsKeycodes.mapVirtualKeyToLWJGLCode(i2)] == 1 - b2 && (1 & (GetKeyState(i2) >>> 15)) == b2;
    }

    private void flushRetained() {
        if (this.has_retained_event) {
            this.has_retained_event = false;
            putEvent(this.retained_key_code, this.retained_state, this.retained_char, this.retained_millis, this.retained_repeat);
        }
    }

    private static boolean isKeyPressed(int i) {
        return (i & 1) == 1;
    }

    private static native boolean isWindowsNT();

    private void putEvent(int i, byte b, int i2, long j, boolean z) {
        int i3 = i;
        byte b2 = b;
        int i4 = i2;
        long j2 = j;
        boolean z2 = z;
        Buffer clear = this.tmp_event.clear();
        ByteBuffer put = this.tmp_event.putInt(i3).put(b2).putInt(i4).putLong(1000000 * j2).put(z2 ? (byte) 1 : 0);
        Buffer flip = this.tmp_event.flip();
        boolean putEvent = this.event_queue.putEvent(this.tmp_event);
    }

    private int translateExtended(int i, int i2, byte b, boolean z) {
        int i3 = i;
        int i4 = i2;
        byte b2 = b;
        boolean z2 = z;
        switch (i3) {
            case 16:
                return translateShift(i4, b2);
            case 17:
                return z2 ? 163 : 162;
            case 18:
                return z2 ? 165 : 164;
            default:
                return i3;
        }
    }

    private int translateShift(int i, byte b) {
        int i2 = i;
        byte b2 = b;
        if (!checkShiftKey(160, b2)) {
            if (checkShiftKey(161, b2)) {
                return 161;
            }
            if (i2 != 42 && i2 == 54) {
                return 161;
            }
        }
        return 160;
    }

    public void destroy() {
    }

    public void fireLostKeyEvents() {
        for (int i = 0; i < this.virt_key_down_buffer.length; i++) {
            if (isKeyPressed(this.virt_key_down_buffer[i]) && (32768 & GetAsyncKeyState(i)) == 0) {
                handleKey(i, 0, false, 0, System.currentTimeMillis(), false);
            }
        }
    }

    public void grab(boolean z) {
        if (z) {
            if (!this.grabbed) {
                this.grabbed = true;
            }
        } else if (this.grabbed) {
            this.grabbed = false;
        }
    }

    public void handleChar(int i, long j, boolean z) {
        int i2 = i;
        long j2 = j;
        boolean z2 = z;
        if (this.has_retained_event && this.retained_char != 0) {
            flushRetained();
        }
        if (!this.has_retained_event) {
            putEvent(0, 0, i2, j2, z2);
            return;
        }
        this.retained_char = i2;
    }

    public void handleKey(int i, int i2, boolean z, byte b, long j, boolean z2) {
        byte b2 = b;
        long j2 = j;
        boolean z3 = z2;
        int translateExtended = translateExtended(i, i2, b2, z);
        if (z3 || isKeyPressed(b2) != isKeyPressed(this.virt_key_down_buffer[translateExtended])) {
            flushRetained();
            this.has_retained_event = true;
            int mapVirtualKeyToLWJGLCode = WindowsKeycodes.mapVirtualKeyToLWJGLCode(translateExtended);
            if (mapVirtualKeyToLWJGLCode < this.key_down_buffer.length) {
                this.key_down_buffer[mapVirtualKeyToLWJGLCode] = b2;
                this.virt_key_down_buffer[translateExtended] = b2;
            }
            this.retained_key_code = mapVirtualKeyToLWJGLCode;
            this.retained_state = b2;
            this.retained_millis = j2;
            this.retained_char = 0;
            this.retained_repeat = z3;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isKeyDown(int i) {
        return this.key_down_buffer[i] == 1;
    }

    public void poll(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int position = byteBuffer2.position();
        ByteBuffer put = byteBuffer2.put(this.key_down_buffer);
        Buffer position2 = byteBuffer2.position(position);
    }

    public void read(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        flushRetained();
        this.event_queue.copyEvents(byteBuffer2);
    }
}
