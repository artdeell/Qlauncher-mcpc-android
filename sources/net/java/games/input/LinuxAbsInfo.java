package net.java.games.input;

final class LinuxAbsInfo {
    private int flat;
    private int fuzz;
    private int maximum;
    private int minimum;
    private int value;

    LinuxAbsInfo() {
    }

    /* access modifiers changed from: 0000 */
    public final int getFlat() {
        return this.flat;
    }

    /* access modifiers changed from: 0000 */
    public final int getFuzz() {
        return this.fuzz;
    }

    /* access modifiers changed from: 0000 */
    public final int getMax() {
        return this.maximum;
    }

    /* access modifiers changed from: 0000 */
    public final int getMin() {
        return this.minimum;
    }

    public final int getValue() {
        return this.value;
    }

    public final void set(int i, int i2, int i3, int i4, int i5) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        this.value = i;
        this.minimum = i6;
        this.maximum = i7;
        this.fuzz = i8;
        this.flat = i9;
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("AbsInfo: value = ").append(this.value).append(" | min = ").append(this.minimum).append(" | max = ").append(this.maximum).append(" | fuzz = ").append(this.fuzz).append(" | flat = ").append(this.flat).toString();
    }
}
