package net.java.games.input;

final class LinuxJoystickEvent {
    private long nanos;
    private int number;
    private int type;
    private int value;

    LinuxJoystickEvent() {
    }

    public final long getNanos() {
        return this.nanos;
    }

    public final int getNumber() {
        return this.number;
    }

    public final int getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public final void set(long j, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.nanos = 1000000 * j;
        this.value = i4;
        this.type = i5;
        this.number = i6;
    }
}
