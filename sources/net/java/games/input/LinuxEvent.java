package net.java.games.input;

final class LinuxEvent {
    private final LinuxAxisDescriptor descriptor;
    private long nanos;
    private int value;

    LinuxEvent() {
        LinuxAxisDescriptor linuxAxisDescriptor;
        LinuxAxisDescriptor linuxAxisDescriptor2 = linuxAxisDescriptor;
        LinuxAxisDescriptor linuxAxisDescriptor3 = new LinuxAxisDescriptor();
        this.descriptor = linuxAxisDescriptor2;
    }

    public final LinuxAxisDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final long getNanos() {
        return this.nanos;
    }

    public final int getValue() {
        return this.value;
    }

    public final void set(long j, long j2, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.nanos = 1000 * (j2 + (1000000 * j));
        this.descriptor.set(i4, i5);
        this.value = i6;
    }
}
