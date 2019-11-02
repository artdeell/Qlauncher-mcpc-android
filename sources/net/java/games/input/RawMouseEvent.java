package net.java.games.input;

final class RawMouseEvent {
    private static final int WHEEL_SCALE = 120;
    private int button_data;
    private int button_flags;
    private long extra_information;
    private int flags;
    private long last_x;
    private long last_y;
    private long millis;
    private long raw_buttons;

    RawMouseEvent() {
    }

    private final int getButtonData() {
        return this.button_data;
    }

    public final int getButtonFlags() {
        return this.button_flags;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final int getLastX() {
        return (int) this.last_x;
    }

    public final int getLastY() {
        return (int) this.last_y;
    }

    public final long getNanos() {
        return 1000000 * this.millis;
    }

    public final long getRawButtons() {
        return this.raw_buttons;
    }

    public final int getWheelDelta() {
        return this.button_data / 120;
    }

    public final void set(long j, int i, int i2, int i3, long j2, long j3, long j4, long j5) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j6 = j2;
        long j7 = j3;
        long j8 = j4;
        long j9 = j5;
        this.millis = j;
        this.flags = i4;
        this.button_flags = i5;
        this.button_data = i6;
        this.raw_buttons = j6;
        this.last_x = j7;
        this.last_y = j8;
        this.extra_information = j9;
    }

    public final void set(RawMouseEvent rawMouseEvent) {
        RawMouseEvent rawMouseEvent2 = rawMouseEvent;
        set(rawMouseEvent2.millis, rawMouseEvent2.flags, rawMouseEvent2.button_flags, rawMouseEvent2.button_data, rawMouseEvent2.raw_buttons, rawMouseEvent2.last_x, rawMouseEvent2.last_y, rawMouseEvent2.extra_information);
    }
}
