package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;

final class MacOSXNativeMouse extends EventQueue {
    private static final int NUM_BUTTONS = 3;
    private static final int WHEEL_SCALE = 120;
    private float accum_dx;
    private float accum_dy;
    private int accum_dz;
    private final byte[] buttons = new byte[3];
    private IntBuffer delta_buffer = BufferUtils.createIntBuffer(2);
    private MacOSXDisplay display;
    private final ByteBuffer event = ByteBuffer.allocate(22);
    private boolean grabbed;
    private float last_x;
    private float last_y;
    private boolean saved_control_state;
    private int skip_event;
    private ByteBuffer window_handle;

    MacOSXNativeMouse(MacOSXDisplay macOSXDisplay, ByteBuffer byteBuffer) {
        MacOSXDisplay macOSXDisplay2 = macOSXDisplay;
        ByteBuffer byteBuffer2 = byteBuffer;
        super(22);
        this.display = macOSXDisplay2;
        this.window_handle = byteBuffer2;
    }

    public static long createCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        try {
            return nCreateCursor(i, i2, i3, i4, i5, intBuffer3, intBuffer3.position(), intBuffer4, intBuffer4 != null ? intBuffer4.position() : -1);
        } catch (LWJGLException e) {
            throw e;
        }
    }

    public static void destroyCursor(long j) {
        nDestroyCursor(j);
    }

    private static native long nCreateCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, int i6, IntBuffer intBuffer2, int i7) throws LWJGLException;

    private static native void nDestroyCursor(long j);

    public static native void nGrabMouse(boolean z);

    private native void nRegisterMouseListener(ByteBuffer byteBuffer);

    private static native void nSetCursor(long j) throws LWJGLException;

    private native void nSetCursorPosition(ByteBuffer byteBuffer, int i, int i2);

    private native void nUnregisterMouseListener(ByteBuffer byteBuffer);

    private void putMouseEvent(byte b, byte b2, int i, long j) {
        byte b3 = b;
        byte b4 = b2;
        int i2 = i;
        long j2 = j;
        if (this.grabbed) {
            putMouseEventWithCoords(b3, b4, 0, 0, i2, j2);
        } else {
            putMouseEventWithCoords(b3, b4, (int) this.last_x, (int) this.last_y, i2, j2);
        }
    }

    public static void setCursor(long j) throws LWJGLException {
        try {
            nSetCursor(j);
        } catch (LWJGLException e) {
            throw e;
        }
    }

    private void setCursorPos(float f, float f2, long j) {
        float f3 = f;
        float f4 = f2;
        long j2 = j;
        if (!this.grabbed) {
            addDelta(f3 - this.last_x, f4 - this.last_y);
            this.last_x = f3;
            this.last_y = f4;
            putMouseEventWithCoords(-1, 0, (int) f3, (int) f4, 0, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void addDelta(float f, float f2) {
        float f3 = f2;
        this.accum_dx = f + this.accum_dx;
        this.accum_dy += -f3;
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

    /* JADX INFO: finally extract failed */
    public void mouseMoved(float f, float f2, float f3, float f4, float f5, long j) {
        float f6 = f;
        float f7 = f2;
        float f8 = f3;
        float f9 = f4;
        float f10 = f5;
        long j2 = j;
        synchronized (this) {
            try {
                if (this.skip_event > 0) {
                    this.skip_event = -1 + this.skip_event;
                    if (this.skip_event == 0) {
                        this.last_x = f6;
                        this.last_y = f7;
                    }
                } else if (f10 != 0.0f) {
                    if (f9 == 0.0f) {
                        f9 = f8;
                    }
                    int i = (int) (120.0f * f9);
                    this.accum_dz = i + this.accum_dz;
                    putMouseEvent(-1, 0, i, j2);
                } else if (!this.grabbed) {
                    setCursorPos(f6, f7, j2);
                } else if (!(f8 == 0.0f && f9 == 0.0f)) {
                    putMouseEventWithCoords(-1, 0, (int) f8, (int) (-f9), 0, j2);
                    addDelta(f8, f9);
                }
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
                    IntBuffer put = intBuffer2.put(0, (int) this.accum_dx);
                    IntBuffer put2 = intBuffer2.put(1, (int) this.accum_dy);
                } else {
                    IntBuffer put3 = intBuffer2.put(0, (int) this.last_x);
                    IntBuffer put4 = intBuffer2.put(1, (int) this.last_y);
                }
                IntBuffer put5 = intBuffer2.put(2, this.accum_dz);
                this.accum_dz = 0;
                float f = (float) 0;
                this.accum_dy = f;
                this.accum_dx = f;
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
                nRegisterMouseListener(this.window_handle);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resetCursorToCenter() {
        clearEvents();
        this.accum_dy = 0.0f;
        this.accum_dx = 0.0f;
        if (this.display != null) {
            this.last_x = (float) (this.display.getWidth() / 2);
            this.last_y = (float) (this.display.getHeight() / 2);
        }
    }

    public void setButton(int i, int i2, long j) {
        int i3 = i;
        int i4 = i2;
        long j2 = j;
        synchronized (this) {
            try {
                this.buttons[i3] = (byte) i4;
                putMouseEvent((byte) i3, (byte) i4, 0, j2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void setCursorPosition(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        synchronized (this) {
            try {
                nSetCursorPosition(this.window_handle, i3, i4);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void setGrabbed(boolean z) {
        boolean z2 = z;
        synchronized (this) {
            try {
                this.grabbed = z2;
                nGrabMouse(z2);
                this.skip_event = 1;
                this.accum_dy = 0.0f;
                this.accum_dx = 0.0f;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public void unregister() {
        synchronized (this) {
            try {
                nUnregisterMouseListener(this.window_handle);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
