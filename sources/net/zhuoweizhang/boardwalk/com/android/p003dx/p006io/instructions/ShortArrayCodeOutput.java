package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.ShortArrayCodeOutput */
public final class ShortArrayCodeOutput extends BaseCodeCursor implements CodeOutput {
    private final short[] array;

    public ShortArrayCodeOutput(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("maxSize < 0");
            throw illegalArgumentException2;
        }
        this.array = new short[i2];
    }

    public short[] getArray() {
        int cursor = cursor();
        if (cursor == this.array.length) {
            return this.array;
        }
        short[] sArr = new short[cursor];
        System.arraycopy(this.array, 0, sArr, 0, cursor);
        return sArr;
    }

    public void write(short s) {
        this.array[cursor()] = s;
        advance(1);
    }

    public void write(short s, short s2) {
        short s3 = s2;
        write(s);
        write(s3);
    }

    public void write(short s, short s2, short s3) {
        short s4 = s2;
        short s5 = s3;
        write(s);
        write(s4);
        write(s5);
    }

    public void write(short s, short s2, short s3, short s4) {
        short s5 = s2;
        short s6 = s3;
        short s7 = s4;
        write(s);
        write(s5);
        write(s6);
        write(s7);
    }

    public void write(short s, short s2, short s3, short s4, short s5) {
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        short s9 = s5;
        write(s);
        write(s6);
        write(s7);
        write(s8);
        write(s9);
    }

    public void write(byte[] bArr) {
        boolean z;
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        boolean z2 = true;
        byte b = 0;
        for (int i = 0; i < length; i++) {
            byte b2 = bArr2[i];
            if (z2) {
                b = b2 & 255;
                z = false;
            } else {
                byte b3 = b | (b2 << 8);
                write((short) b3);
                b = b3;
                z = true;
            }
            z2 = z;
        }
        if (!z2) {
            write((short) b);
        }
    }

    public void write(int[] iArr) {
        int[] iArr2 = iArr;
        int length = iArr2.length;
        for (int i = 0; i < length; i++) {
            writeInt(iArr2[i]);
        }
    }

    public void write(long[] jArr) {
        long[] jArr2 = jArr;
        int length = jArr2.length;
        for (int i = 0; i < length; i++) {
            writeLong(jArr2[i]);
        }
    }

    public void write(short[] sArr) {
        short[] sArr2 = sArr;
        int length = sArr2.length;
        for (int i = 0; i < length; i++) {
            write(sArr2[i]);
        }
    }

    public void writeInt(int i) {
        int i2 = i;
        write((short) i2);
        write((short) (i2 >> 16));
    }

    public void writeLong(long j) {
        long j2 = j;
        write((short) ((int) j2));
        write((short) ((int) (j2 >> 16)));
        write((short) ((int) (j2 >> 32)));
        write((short) ((int) (j2 >> 48)));
    }
}
