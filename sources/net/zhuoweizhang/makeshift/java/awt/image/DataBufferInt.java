package net.zhuoweizhang.makeshift.java.awt.image;

public class DataBufferInt extends DataBuffer {
    private int[] array;

    public DataBufferInt(int[] iArr, int i) {
        int i2 = i;
        this.array = iArr;
    }

    public int[] getData() {
        return this.array;
    }
}
