package net.java.games.input;

final class DIDeviceObjectData {
    private int data;
    private int format_offset;
    private int millis;
    private int sequence;

    DIDeviceObjectData() {
    }

    public final int getData() {
        return this.data;
    }

    public final int getFormatOffset() {
        return this.format_offset;
    }

    public final long getNanos() {
        return 1000000 * ((long) this.millis);
    }

    public final void set(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        this.format_offset = i;
        this.data = i5;
        this.millis = i6;
        this.sequence = i7;
    }

    public final void set(DIDeviceObjectData dIDeviceObjectData) {
        DIDeviceObjectData dIDeviceObjectData2 = dIDeviceObjectData;
        set(dIDeviceObjectData2.format_offset, dIDeviceObjectData2.data, dIDeviceObjectData2.millis, dIDeviceObjectData2.sequence);
    }
}
