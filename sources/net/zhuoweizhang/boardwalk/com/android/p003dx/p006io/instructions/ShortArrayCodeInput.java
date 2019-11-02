package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import java.io.EOFException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.ShortArrayCodeInput */
public final class ShortArrayCodeInput extends BaseCodeCursor implements CodeInput {
    private final short[] array;

    public ShortArrayCodeInput(short[] sArr) {
        NullPointerException nullPointerException;
        short[] sArr2 = sArr;
        if (sArr2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("array == null");
            throw nullPointerException2;
        }
        this.array = sArr2;
    }

    public boolean hasMore() {
        return cursor() < this.array.length;
    }

    public int read() throws EOFException {
        EOFException eOFException;
        try {
            short s = this.array[cursor()];
            advance(1);
            return s & 65535;
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            EOFException eOFException2 = eOFException;
            EOFException eOFException3 = new EOFException();
            throw eOFException2;
        }
    }

    public int readInt() throws EOFException {
        return read() | (read() << 16);
    }

    public long readLong() throws EOFException {
        return ((long) read()) | (((long) read()) << 16) | (((long) read()) << 32) | (((long) read()) << 48);
    }
}
