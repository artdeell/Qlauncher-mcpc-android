package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray */
public final class ByteArray {
    /* access modifiers changed from: private */
    public final byte[] bytes;
    /* access modifiers changed from: private */
    public final int size;
    /* access modifiers changed from: private */
    public final int start;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray$GetCursor */
    public interface GetCursor {
        int getCursor();
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray$MyDataInputStream */
    public static class MyDataInputStream extends DataInputStream {
        private final MyInputStream wrapped;

        public MyDataInputStream(MyInputStream myInputStream) {
            MyInputStream myInputStream2 = myInputStream;
            super(myInputStream2);
            this.wrapped = myInputStream2;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray$MyInputStream */
    public class MyInputStream extends InputStream {
        private int cursor = 0;
        private int mark = 0;
        final /* synthetic */ ByteArray this$0;

        public MyInputStream(ByteArray byteArray) {
            this.this$0 = byteArray;
        }

        public int available() {
            return this.this$0.size - this.cursor;
        }

        public void mark(int i) {
            int i2 = i;
            this.mark = this.cursor;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() throws IOException {
            if (this.cursor >= this.this$0.size) {
                return -1;
            }
            int access$100 = this.this$0.getUnsignedByte0(this.cursor);
            this.cursor = 1 + this.cursor;
            return access$100;
        }

        public int read(byte[] bArr, int i, int i2) {
            byte[] bArr2 = bArr;
            int i3 = i;
            int i4 = i2;
            if (i3 + i4 > bArr2.length) {
                i4 = bArr2.length - i3;
            }
            int access$000 = this.this$0.size - this.cursor;
            if (i4 > access$000) {
                i4 = access$000;
            }
            System.arraycopy(this.this$0.bytes, this.cursor + this.this$0.start, bArr2, i3, i4);
            this.cursor = i4 + this.cursor;
            return i4;
        }

        public void reset() {
            this.cursor = this.mark;
        }
    }

    public ByteArray(byte[] bArr) {
        byte[] bArr2 = bArr;
        this(bArr2, 0, bArr2.length);
    }

    public ByteArray(byte[] bArr, int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        NullPointerException nullPointerException;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        if (bArr2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("bytes == null");
            throw nullPointerException2;
        } else if (i3 < 0) {
            IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("start < 0");
            throw illegalArgumentException4;
        } else if (i4 < i3) {
            IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("end < start");
            throw illegalArgumentException6;
        } else if (i4 > bArr2.length) {
            IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("end > bytes.length");
            throw illegalArgumentException8;
        } else {
            this.bytes = bArr2;
            this.start = i3;
            this.size = i4 - i3;
        }
    }

    private void checkOffsets(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        if (i3 < 0 || i4 < i3 || i4 > this.size) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("bad range: ").append(i3).append("..").append(i4).append("; actual size ").append(this.size).toString());
            throw illegalArgumentException2;
        }
    }

    private int getByte0(int i) {
        return this.bytes[i + this.start];
    }

    /* access modifiers changed from: private */
    public int getUnsignedByte0(int i) {
        return 255 & this.bytes[i + this.start];
    }

    public int getByte(int i) {
        int i2 = i;
        checkOffsets(i2, i2 + 1);
        return getByte0(i2);
    }

    public void getBytes(byte[] bArr, int i) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        byte[] bArr2 = bArr;
        int i2 = i;
        if (bArr2.length - i2 < this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException("(out.length - offset) < size()");
            throw indexOutOfBoundsException2;
        }
        System.arraycopy(this.bytes, this.start, bArr2, i2, this.size);
    }

    public int getInt(int i) {
        int i2 = i;
        checkOffsets(i2, i2 + 4);
        return (getByte0(i2) << 24) | (getUnsignedByte0(i2 + 1) << 16) | (getUnsignedByte0(i2 + 2) << 8) | getUnsignedByte0(i2 + 3);
    }

    public long getLong(int i) {
        int i2 = i;
        checkOffsets(i2, i2 + 8);
        return (4294967295L & ((long) ((getByte0(i2 + 4) << 24) | (getUnsignedByte0(i2 + 5) << 16) | (getUnsignedByte0(i2 + 6) << 8) | getUnsignedByte0(i2 + 7)))) | (((long) ((((getByte0(i2) << 24) | (getUnsignedByte0(i2 + 1) << 16)) | (getUnsignedByte0(i2 + 2) << 8)) | getUnsignedByte0(i2 + 3))) << 32);
    }

    public int getShort(int i) {
        int i2 = i;
        checkOffsets(i2, i2 + 2);
        return (getByte0(i2) << 8) | getUnsignedByte0(i2 + 1);
    }

    public int getUnsignedByte(int i) {
        int i2 = i;
        checkOffsets(i2, i2 + 1);
        return getUnsignedByte0(i2);
    }

    public int getUnsignedShort(int i) {
        int i2 = i;
        checkOffsets(i2, i2 + 2);
        return (getUnsignedByte0(i2) << 8) | getUnsignedByte0(i2 + 1);
    }

    public MyDataInputStream makeDataInputStream() {
        MyDataInputStream myDataInputStream;
        MyDataInputStream myDataInputStream2 = myDataInputStream;
        MyDataInputStream myDataInputStream3 = new MyDataInputStream(makeInputStream());
        return myDataInputStream2;
    }

    public MyInputStream makeInputStream() {
        MyInputStream myInputStream;
        MyInputStream myInputStream2 = myInputStream;
        MyInputStream myInputStream3 = new MyInputStream(this);
        return myInputStream2;
    }

    public int size() {
        return this.size;
    }

    public ByteArray slice(int i, int i2) {
        ByteArray byteArray;
        int i3 = i;
        int i4 = i2;
        checkOffsets(i3, i4);
        ByteArray byteArray2 = byteArray;
        ByteArray byteArray3 = new ByteArray(this.bytes, i3 + this.start, i4 + this.start);
        return byteArray2;
    }

    public int underlyingOffset(int i, byte[] bArr) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (bArr == this.bytes) {
            return i2 + this.start;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("wrong bytes");
        throw illegalArgumentException2;
    }
}
