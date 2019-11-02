package LZMA;

import java.io.IOException;
import java.io.InputStream;

class CRangeDecoder {
    static final int LenChoice = 0;
    static final int LenChoice2 = 1;
    static final int LenHigh = 258;
    static final int LenLow = 2;
    static final int LenMid = 130;
    static final int kBitModelTotal = 2048;
    static final int kLenNumHighBits = 8;
    static final int kLenNumHighSymbols = 256;
    static final int kLenNumLowBits = 3;
    static final int kLenNumLowSymbols = 8;
    static final int kLenNumMidBits = 3;
    static final int kLenNumMidSymbols = 8;
    static final int kNumBitModelTotalBits = 11;
    static final int kNumLenProbs = 514;
    static final int kNumMoveBits = 5;
    static final int kNumPosBitsMax = 4;
    static final int kNumPosStatesMax = 16;
    static final int kNumTopBits = 24;
    static final int kTopValue = 16777216;
    static final int kTopValueMask = -16777216;
    int Code;
    int Range;
    byte[] buffer = new byte[16384];
    int buffer_ind;
    int buffer_size;
    InputStream inStream;

    CRangeDecoder(InputStream inputStream) throws IOException {
        InputStream inputStream2 = inputStream;
        this.inStream = inputStream2;
        this.Code = 0;
        this.Range = -1;
        for (int i = 0; i < 5; i++) {
            this.Code = (this.Code << 8) | Readbyte();
        }
    }

    /* access modifiers changed from: 0000 */
    public int BitDecode(int[] iArr, int i) throws IOException {
        int[] iArr2 = iArr;
        int i2 = i;
        int i3 = (this.Range >>> 11) * iArr2[i2];
        if ((4294967295L & ((long) this.Code)) < (4294967295L & ((long) i3))) {
            this.Range = i3;
            iArr2[i2] = iArr2[i2] + ((2048 - iArr2[i2]) >>> 5);
            if ((-16777216 & this.Range) == 0) {
                this.Code = (this.Code << 8) | Readbyte();
                this.Range <<= 8;
            }
            return 0;
        }
        this.Range -= i3;
        this.Code -= i3;
        iArr2[i2] = iArr2[i2] - (iArr2[i2] >>> 5);
        if ((-16777216 & this.Range) == 0) {
            this.Code = (this.Code << 8) | Readbyte();
            this.Range <<= 8;
        }
        return 1;
    }

    /* access modifiers changed from: 0000 */
    public int BitTreeDecode(int[] iArr, int i, int i2) throws IOException {
        int[] iArr2 = iArr;
        int i3 = i;
        int i4 = i2;
        int i5 = 1;
        for (int i6 = i4; i6 > 0; i6--) {
            i5 = i5 + i5 + BitDecode(iArr2, i5 + i3);
        }
        return i5 - (1 << i4);
    }

    /* access modifiers changed from: 0000 */
    public int DecodeDirectBits(int i) throws IOException {
        int i2 = 0;
        for (int i3 = i; i3 > 0; i3--) {
            this.Range >>>= 1;
            int i4 = (this.Code - this.Range) >>> 31;
            this.Code -= this.Range & (i4 - 1);
            i2 = (i2 << 1) | (1 - i4);
            if (this.Range < 16777216) {
                this.Code = (this.Code << 8) | Readbyte();
                this.Range <<= 8;
            }
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    public int LzmaLenDecode(int[] iArr, int i, int i2) throws IOException {
        int[] iArr2 = iArr;
        int i3 = i;
        int i4 = i2;
        return BitDecode(iArr2, i3 + 0) == 0 ? BitTreeDecode(iArr2, i3 + 2 + (i4 << 3), 3) : BitDecode(iArr2, i3 + 1) == 0 ? 8 + BitTreeDecode(iArr2, i3 + 130 + (i4 << 3), 3) : 16 + BitTreeDecode(iArr2, i3 + 258, 8);
    }

    /* access modifiers changed from: 0000 */
    public byte LzmaLiteralDecode(int[] iArr, int i) throws IOException {
        int[] iArr2 = iArr;
        int i2 = i;
        int i3 = 1;
        do {
            i3 = (i3 + i3) | BitDecode(iArr2, i3 + i2);
        } while (i3 < 256);
        return (byte) i3;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r16v0, types: [byte, int] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte LzmaLiteralDecodeMatch(int[] r14, int r15, int r16) throws java.io.IOException {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r7 = 1
            r4 = r7
        L_0x0007:
            r7 = 1
            r8 = r3
            r9 = 7
            int r8 = r8 >> 7
            r7 = r7 & r8
            r5 = r7
            r7 = r3
            r8 = 1
            int r7 = r7 << 1
            byte r7 = (byte) r7
            r3 = r7
            r7 = r0
            r8 = r1
            r9 = r4
            r10 = r2
            r11 = r5
            r12 = 1
            int r11 = r11 + 1
            r12 = 8
            int r11 = r11 << 8
            int r10 = r10 + r11
            int r9 = r9 + r10
            int r7 = r7.BitDecode(r8, r9)
            r6 = r7
            r7 = r6
            r8 = r4
            r9 = 1
            int r8 = r8 << 1
            r7 = r7 | r8
            r4 = r7
            r7 = r5
            r8 = r6
            if (r7 == r8) goto L_0x0046
        L_0x0032:
            r7 = r4
            r8 = 256(0x100, float:3.59E-43)
            if (r7 >= r8) goto L_0x004b
            r7 = r4
            r8 = r4
            int r7 = r7 + r8
            r8 = r0
            r9 = r1
            r10 = r4
            r11 = r2
            int r10 = r10 + r11
            int r8 = r8.BitDecode(r9, r10)
            r7 = r7 | r8
            r4 = r7
            goto L_0x0032
        L_0x0046:
            r7 = r4
            r8 = 256(0x100, float:3.59E-43)
            if (r7 < r8) goto L_0x0007
        L_0x004b:
            r7 = r4
            byte r7 = (byte) r7
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: LZMA.CRangeDecoder.LzmaLiteralDecodeMatch(int[], int, byte):byte");
    }

    /* access modifiers changed from: 0000 */
    public int Readbyte() throws IOException {
        LzmaException lzmaException;
        if (this.buffer_size == this.buffer_ind) {
            this.buffer_size = this.inStream.read(this.buffer);
            this.buffer_ind = 0;
            if (this.buffer_size < 1) {
                LzmaException lzmaException2 = lzmaException;
                LzmaException lzmaException3 = new LzmaException("LZMA : Data Error");
                throw lzmaException2;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.buffer_ind;
        this.buffer_ind = i + 1;
        return 255 & bArr[i];
    }

    /* access modifiers changed from: 0000 */
    public int ReverseBitTreeDecode(int[] iArr, int i, int i2) throws IOException {
        int[] iArr2 = iArr;
        int i3 = i;
        int i4 = i2;
        int i5 = 1;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            int BitDecode = BitDecode(iArr2, i3 + i5);
            i5 = BitDecode + i5 + i5;
            i6 |= BitDecode << i7;
        }
        return i6;
    }
}
