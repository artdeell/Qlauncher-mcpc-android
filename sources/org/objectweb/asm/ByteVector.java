package org.objectweb.asm;

public class ByteVector {

    /* renamed from: a */
    byte[] f279a;

    /* renamed from: b */
    int f280b;

    public ByteVector() {
        this.f279a = new byte[64];
    }

    public ByteVector(int i) {
        this.f279a = new byte[i];
    }

    /* renamed from: a */
    private void m63a(int i) {
        int length = 2 * this.f279a.length;
        int i2 = i + this.f280b;
        if (length <= i2) {
            length = i2;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(this.f279a, 0, bArr, 0, this.f280b);
        this.f279a = bArr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ByteVector mo11110a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = this.f280b;
        if (i5 + 2 > this.f279a.length) {
            m63a(2);
        }
        byte[] bArr = this.f279a;
        int i6 = i5 + 1;
        bArr[i5] = (byte) i3;
        int i7 = i6 + 1;
        bArr[i6] = (byte) i4;
        this.f280b = i7;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ByteVector mo11111b(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = this.f280b;
        if (i5 + 3 > this.f279a.length) {
            m63a(3);
        }
        byte[] bArr = this.f279a;
        int i6 = i5 + 1;
        bArr[i5] = (byte) i3;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i4 >>> 8);
        int i8 = i7 + 1;
        bArr[i7] = (byte) i4;
        this.f280b = i8;
        return this;
    }

    public ByteVector putByte(int i) {
        int i2 = i;
        int i3 = this.f280b;
        if (i3 + 1 > this.f279a.length) {
            m63a(1);
        }
        int i4 = i3 + 1;
        this.f279a[i3] = (byte) i2;
        this.f280b = i4;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        if (i4 + this.f280b > this.f279a.length) {
            m63a(i4);
        }
        if (bArr2 != null) {
            System.arraycopy(bArr2, i3, this.f279a, this.f280b, i4);
        }
        this.f280b = i4 + this.f280b;
        return this;
    }

    public ByteVector putInt(int i) {
        int i2 = i;
        int i3 = this.f280b;
        if (i3 + 4 > this.f279a.length) {
            m63a(4);
        }
        byte[] bArr = this.f279a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 24);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i2 >>> 8);
        int i7 = i6 + 1;
        bArr[i6] = (byte) i2;
        this.f280b = i7;
        return this;
    }

    public ByteVector putLong(long j) {
        long j2 = j;
        int i = this.f280b;
        if (i + 8 > this.f279a.length) {
            m63a(8);
        }
        byte[] bArr = this.f279a;
        int i2 = (int) (j2 >>> 32);
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = (int) j2;
        int i8 = i6 + 1;
        bArr[i6] = (byte) (i7 >>> 24);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i7 >>> 8);
        int i11 = i10 + 1;
        bArr[i10] = (byte) i7;
        this.f280b = i11;
        return this;
    }

    public ByteVector putShort(int i) {
        int i2 = i;
        int i3 = this.f280b;
        if (i3 + 2 > this.f279a.length) {
            m63a(2);
        }
        byte[] bArr = this.f279a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) i2;
        this.f280b = i5;
        return this;
    }

    public ByteVector putUTF8(String str) {
        int i;
        byte[] bArr;
        int i2;
        String str2 = str;
        int length = str2.length();
        int i3 = this.f280b;
        if (length + i3 + 2 > this.f279a.length) {
            m63a(length + 2);
        }
        byte[] bArr2 = this.f279a;
        int i4 = i3 + 1;
        bArr2[i3] = (byte) (length >>> 8);
        int i5 = i4 + 1;
        bArr2[i4] = (byte) length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                i = i5;
                break;
            }
            char charAt = str2.charAt(i6);
            if (charAt < 1 || charAt > 127) {
                int i7 = i6;
            } else {
                int i8 = i5 + 1;
                bArr2[i5] = (byte) charAt;
                i6++;
                i5 = i8;
            }
        }
        int i72 = i6;
        for (int i9 = i6; i9 < length; i9++) {
            char charAt2 = str2.charAt(i9);
            i72 = (charAt2 < 1 || charAt2 > 127) ? charAt2 > 2047 ? i72 + 3 : i72 + 2 : i72 + 1;
        }
        bArr2[this.f280b] = (byte) (i72 >>> 8);
        bArr2[1 + this.f280b] = (byte) i72;
        if (i72 + 2 + this.f280b > bArr2.length) {
            this.f280b = i5;
            m63a(i72 + 2);
            bArr = this.f279a;
        } else {
            bArr = bArr2;
        }
        while (i6 < length) {
            char charAt3 = str2.charAt(i6);
            if (charAt3 >= 1 && charAt3 <= 127) {
                i2 = i5 + 1;
                bArr[i5] = (byte) charAt3;
            } else if (charAt3 > 2047) {
                int i10 = i5 + 1;
                bArr[i5] = (byte) (224 | (15 & (charAt3 >> 12)));
                int i11 = i10 + 1;
                bArr[i10] = (byte) (128 | (63 & (charAt3 >> 6)));
                i2 = i11 + 1;
                bArr[i11] = (byte) (128 | (charAt3 & '?'));
            } else {
                int i12 = i5 + 1;
                bArr[i5] = (byte) (192 | (31 & (charAt3 >> 6)));
                i2 = i12 + 1;
                bArr[i12] = (byte) (128 | (charAt3 & '?'));
            }
            i6++;
            i5 = i2;
        }
        i = i5;
        this.f280b = i;
        return this;
    }
}
