package net.java.games.input;

class OSXEvent {
    private long cookie;
    private long nanos;
    private long type;
    private int value;

    OSXEvent() {
    }

    public long getCookie() {
        return this.cookie;
    }

    public long getNanos() {
        return this.nanos;
    }

    public long getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;
    }

    public void set(long j, long j2, int i, long j3) {
        long j4 = j2;
        int i2 = i;
        long j5 = j3;
        this.type = j;
        this.cookie = j4;
        this.value = i2;
        this.nanos = j5;
    }
}
