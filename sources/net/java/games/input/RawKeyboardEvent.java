package net.java.games.input;

final class RawKeyboardEvent {
    private long extra_information;
    private int flags;
    private int make_code;
    private int message;
    private long millis;
    private int vkey;

    RawKeyboardEvent() {
    }

    public final int getMessage() {
        return this.message;
    }

    public final long getNanos() {
        return 1000000 * this.millis;
    }

    public final int getVKey() {
        return this.vkey;
    }

    public final void set(long j, int i, int i2, int i3, int i4, long j2) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j3 = j2;
        this.millis = j;
        this.make_code = i5;
        this.flags = i6;
        this.vkey = i7;
        this.message = i8;
        this.extra_information = j3;
    }

    public final void set(RawKeyboardEvent rawKeyboardEvent) {
        RawKeyboardEvent rawKeyboardEvent2 = rawKeyboardEvent;
        set(rawKeyboardEvent2.millis, rawKeyboardEvent2.make_code, rawKeyboardEvent2.flags, rawKeyboardEvent2.vkey, rawKeyboardEvent2.message, rawKeyboardEvent2.extra_information);
    }
}
