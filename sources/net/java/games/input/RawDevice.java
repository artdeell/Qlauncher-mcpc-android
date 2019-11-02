package net.java.games.input;

import java.io.IOException;

final class RawDevice {
    public static final int MOUSE_ATTRIBUTES_CHANGED = 4;
    public static final int MOUSE_MOVE_ABSOLUTE = 1;
    public static final int MOUSE_MOVE_RELATIVE = 0;
    public static final int MOUSE_VIRTUAL_DESKTOP = 2;
    public static final int RIM_TYPEHID = 2;
    public static final int RIM_TYPEKEYBOARD = 1;
    public static final int RIM_TYPEMOUSE = 0;
    public static final int RI_MOUSE_BUTTON_1_DOWN = 1;
    public static final int RI_MOUSE_BUTTON_1_UP = 2;
    public static final int RI_MOUSE_BUTTON_2_DOWN = 4;
    public static final int RI_MOUSE_BUTTON_2_UP = 8;
    public static final int RI_MOUSE_BUTTON_3_DOWN = 16;
    public static final int RI_MOUSE_BUTTON_3_UP = 32;
    public static final int RI_MOUSE_BUTTON_4_DOWN = 64;
    public static final int RI_MOUSE_BUTTON_4_UP = 128;
    public static final int RI_MOUSE_BUTTON_5_DOWN = 256;
    public static final int RI_MOUSE_BUTTON_5_UP = 512;
    public static final int RI_MOUSE_LEFT_BUTTON_DOWN = 1;
    public static final int RI_MOUSE_LEFT_BUTTON_UP = 2;
    public static final int RI_MOUSE_MIDDLE_BUTTON_DOWN = 16;
    public static final int RI_MOUSE_MIDDLE_BUTTON_UP = 32;
    public static final int RI_MOUSE_RIGHT_BUTTON_DOWN = 4;
    public static final int RI_MOUSE_RIGHT_BUTTON_UP = 8;
    public static final int RI_MOUSE_WHEEL = 1024;
    public static final int WM_KEYDOWN = 256;
    public static final int WM_KEYUP = 257;
    public static final int WM_SYSKEYDOWN = 260;
    public static final int WM_SYSKEYUP = 261;
    static Class class$net$java$games$input$RawKeyboardEvent;
    static Class class$net$java$games$input$RawMouseEvent;
    private final boolean[] button_states = new boolean[5];
    private int event_last_x;
    private int event_last_y;
    private int event_relative_x;
    private int event_relative_y;
    private final long handle;
    private final boolean[] key_states = new boolean[255];
    private DataQueue keyboard_events;
    private int last_x;
    private int last_y;
    private DataQueue mouse_events;
    private DataQueue processed_keyboard_events;
    private DataQueue processed_mouse_events;
    private final RawInputEventQueue queue;
    private int relative_x;
    private int relative_y;
    private final int type;
    private int wheel;

    public RawDevice(RawInputEventQueue rawInputEventQueue, long j, int i) {
        RawInputEventQueue rawInputEventQueue2 = rawInputEventQueue;
        long j2 = j;
        int i2 = i;
        this.queue = rawInputEventQueue2;
        this.handle = j2;
        this.type = i2;
        setBufferSize(32);
    }

    static Class class$(String str) {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError();
            throw noClassDefFoundError2.initCause(classNotFoundException);
        }
    }

    private static final native RawDeviceInfo nGetInfo(RawDevice rawDevice, long j) throws IOException;

    private static final native String nGetName(long j) throws IOException;

    private final boolean processKeyboardEvent(RawKeyboardEvent rawKeyboardEvent) {
        RawKeyboardEvent rawKeyboardEvent2 = rawKeyboardEvent;
        int message = rawKeyboardEvent2.getMessage();
        int vKey = rawKeyboardEvent2.getVKey();
        if (vKey < this.key_states.length) {
            if (message == 256 || message == 260) {
                this.key_states[vKey] = true;
                return true;
            } else if (message == 257 || message == 261) {
                this.key_states[vKey] = false;
                return true;
            }
        }
        return false;
    }

    private final boolean processMouseEvent(RawMouseEvent rawMouseEvent) {
        int lastX;
        int lastY;
        RawMouseEvent rawMouseEvent2 = rawMouseEvent;
        int buttonFlags = rawMouseEvent2.getButtonFlags();
        boolean z = updateButtonState(4, buttonFlags, 256, 512) || (updateButtonState(3, buttonFlags, 64, 128) || (updateButtonState(2, buttonFlags, 16, 32) || (updateButtonState(1, buttonFlags, 4, 8) || (updateButtonState(0, buttonFlags, 1, 2) || 0 != 0))));
        if ((1 & rawMouseEvent2.getFlags()) != 0) {
            lastX = rawMouseEvent2.getLastX() - this.last_x;
            lastY = rawMouseEvent2.getLastY() - this.last_y;
            this.last_x = rawMouseEvent2.getLastX();
            this.last_y = rawMouseEvent2.getLastY();
        } else {
            lastX = rawMouseEvent2.getLastX();
            lastY = rawMouseEvent2.getLastY();
        }
        int i = 0;
        if ((buttonFlags & 1024) != 0) {
            i = rawMouseEvent2.getWheelDelta();
        }
        this.relative_x = lastX + this.relative_x;
        this.relative_y = lastY + this.relative_y;
        this.wheel = i + this.wheel;
        return (lastX == 0 && lastY == 0 && i == 0 && !z) ? false : true;
    }

    private final boolean updateButtonState(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (i5 < this.button_states.length) {
            if ((i6 & i7) != 0) {
                this.button_states[i5] = true;
                return true;
            } else if ((i6 & i8) != 0) {
                this.button_states[i5] = false;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    public final void addKeyboardEvent(long j, int i, int i2, int i3, int i4, long j2) {
        long j3 = j;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j4 = j2;
        synchronized (this) {
            try {
                if (this.keyboard_events.hasRemaining()) {
                    ((RawKeyboardEvent) this.keyboard_events.get()).set(j3, i5, i6, i7, i8, j4);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void addMouseEvent(long j, int i, int i2, int i3, long j2, long j3, long j4, long j5) {
        long j6 = j;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j7 = j2;
        long j8 = j3;
        long j9 = j4;
        long j10 = j5;
        synchronized (this) {
            try {
                if (this.mouse_events.hasRemaining()) {
                    ((RawMouseEvent) this.mouse_events.get()).set(j6, i4, i5, i6, j7, j8, j9, j10);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final boolean getButtonState(int i) {
        int i2 = i;
        if (i2 >= this.button_states.length) {
            return false;
        }
        return this.button_states[i2];
    }

    public final int getEventRelativeX() {
        return this.event_relative_x;
    }

    public final int getEventRelativeY() {
        return this.event_relative_y;
    }

    public final long getHandle() {
        return this.handle;
    }

    public final RawDeviceInfo getInfo() throws IOException {
        return nGetInfo(this, this.handle);
    }

    public final String getName() throws IOException {
        return nGetName(this.handle);
    }

    public final boolean getNextKeyboardEvent(RawKeyboardEvent rawKeyboardEvent) {
        boolean z;
        RawKeyboardEvent rawKeyboardEvent2 = rawKeyboardEvent;
        synchronized (this) {
            try {
                this.processed_keyboard_events.flip();
                if (!this.processed_keyboard_events.hasRemaining()) {
                    this.processed_keyboard_events.compact();
                    z = false;
                } else {
                    rawKeyboardEvent2.set((RawKeyboardEvent) this.processed_keyboard_events.get());
                    this.processed_keyboard_events.compact();
                    z = true;
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public final boolean getNextMouseEvent(RawMouseEvent rawMouseEvent) {
        boolean z;
        RawMouseEvent rawMouseEvent2 = rawMouseEvent;
        synchronized (this) {
            try {
                this.processed_mouse_events.flip();
                if (!this.processed_mouse_events.hasRemaining()) {
                    this.processed_mouse_events.compact();
                    z = false;
                } else {
                    RawMouseEvent rawMouseEvent3 = (RawMouseEvent) this.processed_mouse_events.get();
                    if ((1 & rawMouseEvent3.getFlags()) != 0) {
                        this.event_relative_x = rawMouseEvent3.getLastX() - this.event_last_x;
                        this.event_relative_y = rawMouseEvent3.getLastY() - this.event_last_y;
                        this.event_last_x = rawMouseEvent3.getLastX();
                        this.event_last_y = rawMouseEvent3.getLastY();
                    } else {
                        this.event_relative_x = rawMouseEvent3.getLastX();
                        this.event_relative_y = rawMouseEvent3.getLastY();
                    }
                    rawMouseEvent2.set(rawMouseEvent3);
                    this.processed_mouse_events.compact();
                    z = true;
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public final int getRelativeX() {
        return this.relative_x;
    }

    public final int getRelativeY() {
        return this.relative_y;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWheel() {
        return this.wheel;
    }

    public final boolean isKeyDown(int i) {
        return this.key_states[i];
    }

    /* JADX INFO: finally extract failed */
    public final void pollKeyboard() {
        synchronized (this) {
            try {
                this.keyboard_events.flip();
                while (this.keyboard_events.hasRemaining()) {
                    RawKeyboardEvent rawKeyboardEvent = (RawKeyboardEvent) this.keyboard_events.get();
                    if (processKeyboardEvent(rawKeyboardEvent) && this.processed_keyboard_events.hasRemaining()) {
                        ((RawKeyboardEvent) this.processed_keyboard_events.get()).set(rawKeyboardEvent);
                    }
                }
                this.keyboard_events.compact();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void pollMouse() {
        synchronized (this) {
            try {
                this.wheel = 0;
                this.relative_y = 0;
                this.relative_x = 0;
                this.mouse_events.flip();
                while (this.mouse_events.hasRemaining()) {
                    RawMouseEvent rawMouseEvent = (RawMouseEvent) this.mouse_events.get();
                    if (processMouseEvent(rawMouseEvent) && this.processed_mouse_events.hasRemaining()) {
                        ((RawMouseEvent) this.processed_mouse_events.get()).set(rawMouseEvent);
                    }
                }
                this.mouse_events.compact();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final void setBufferSize(int i) {
        Class cls;
        DataQueue dataQueue;
        Class cls2;
        DataQueue dataQueue2;
        Class cls3;
        DataQueue dataQueue3;
        Class cls4;
        DataQueue dataQueue4;
        int i2 = i;
        if (class$net$java$games$input$RawKeyboardEvent == null) {
            cls = class$("net.java.games.input.RawKeyboardEvent");
            class$net$java$games$input$RawKeyboardEvent = cls;
        } else {
            cls = class$net$java$games$input$RawKeyboardEvent;
        }
        DataQueue dataQueue5 = dataQueue;
        DataQueue dataQueue6 = new DataQueue(i2, cls);
        this.keyboard_events = dataQueue5;
        if (class$net$java$games$input$RawMouseEvent == null) {
            cls2 = class$("net.java.games.input.RawMouseEvent");
            class$net$java$games$input$RawMouseEvent = cls2;
        } else {
            cls2 = class$net$java$games$input$RawMouseEvent;
        }
        DataQueue dataQueue7 = dataQueue2;
        DataQueue dataQueue8 = new DataQueue(i2, cls2);
        this.mouse_events = dataQueue7;
        if (class$net$java$games$input$RawKeyboardEvent == null) {
            cls3 = class$("net.java.games.input.RawKeyboardEvent");
            class$net$java$games$input$RawKeyboardEvent = cls3;
        } else {
            cls3 = class$net$java$games$input$RawKeyboardEvent;
        }
        DataQueue dataQueue9 = dataQueue3;
        DataQueue dataQueue10 = new DataQueue(i2, cls3);
        this.processed_keyboard_events = dataQueue9;
        if (class$net$java$games$input$RawMouseEvent == null) {
            cls4 = class$("net.java.games.input.RawMouseEvent");
            class$net$java$games$input$RawMouseEvent = cls4;
        } else {
            cls4 = class$net$java$games$input$RawMouseEvent;
        }
        DataQueue dataQueue11 = dataQueue4;
        DataQueue dataQueue12 = new DataQueue(i2, cls4);
        this.processed_mouse_events = dataQueue11;
    }
}
