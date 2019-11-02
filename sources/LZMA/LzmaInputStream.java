package LZMA;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LzmaInputStream extends FilterInputStream {
    static final int Align = 802;
    static final int IsMatch = 0;
    static final int IsRep = 192;
    static final int IsRep0Long = 240;
    static final int IsRepG0 = 204;
    static final int IsRepG1 = 216;
    static final int IsRepG2 = 228;
    static final int LZMA_BASE_SIZE = 1846;
    static final int LZMA_LIT_SIZE = 768;
    static final int LenCoder = 818;
    static final int Literal = 1846;
    static final int PosSlot = 432;
    static final int RepLenCoder = 1332;
    static final int SpecPos = 688;
    static final int kAlignTableSize = 16;
    static final int kBlockSize = 65536;
    static final int kEndPosModelIndex = 14;
    static final int kMatchMinLen = 2;
    static final int kNumAlignBits = 4;
    static final int kNumFullDistances = 128;
    static final int kNumLenToPosStates = 4;
    static final int kNumPosSlotBits = 6;
    static final int kNumStates = 12;
    static final int kStartPosModelIndex = 4;
    long GlobalNowPos;
    long GlobalOutSize;
    int GlobalPos;
    boolean PreviousIsMatch;
    CRangeDecoder RangeDecoder;
    int RemainLen;
    int State;
    byte[] dictionary;
    int dictionaryPos;
    int dictionarySize;
    boolean isClosed = false;

    /* renamed from: lc */
    int f0lc;

    /* renamed from: lp */
    int f1lp;

    /* renamed from: pb */
    int f2pb;
    int[] probs;
    int rep0;
    int rep1;
    int rep2;
    int rep3;
    byte[] uncompressed_buffer;
    int uncompressed_offset;
    int uncompressed_size;

    public LzmaInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        readHeader();
        fill_buffer();
    }

    private void LzmaDecode(int i) throws IOException {
        LzmaException lzmaException;
        byte b;
        int i2;
        LzmaException lzmaException2;
        int i3 = i;
        int i4 = -1 + (1 << this.f2pb);
        int i5 = -1 + (1 << this.f1lp);
        this.uncompressed_size = 0;
        if (this.RemainLen != -1) {
            while (true) {
                if (this.RemainLen <= 0) {
                    break;
                }
                if (this.uncompressed_size >= i3) {
                    break;
                }
                int i6 = this.dictionaryPos - this.rep0;
                if (i6 < 0) {
                    i6 += this.dictionarySize;
                }
                byte[] bArr = this.uncompressed_buffer;
                int i7 = this.uncompressed_size;
                this.uncompressed_size = i7 + 1;
                byte[] bArr2 = this.dictionary;
                int i8 = this.dictionaryPos;
                byte b2 = this.dictionary[i6];
                bArr2[i8] = b2;
                bArr[i7] = b2;
                int i9 = 1 + this.dictionaryPos;
                this.dictionaryPos = i9;
                if (i9 == this.dictionarySize) {
                    this.dictionaryPos = 0;
                }
                this.RemainLen = -1 + this.RemainLen;
            }
            byte b3 = this.dictionaryPos == 0 ? this.dictionary[-1 + this.dictionarySize] : this.dictionary[-1 + this.dictionaryPos];
            while (true) {
                if (this.uncompressed_size >= i3) {
                    break;
                }
                int i10 = i4 & (this.uncompressed_size + this.GlobalPos);
                if (this.RangeDecoder.BitDecode(this.probs, i10 + 0 + (this.State << 4)) != 0) {
                    this.PreviousIsMatch = true;
                    if (this.RangeDecoder.BitDecode(this.probs, 192 + this.State) == 1) {
                        if (this.RangeDecoder.BitDecode(this.probs, 204 + this.State) == 0) {
                            if (this.RangeDecoder.BitDecode(this.probs, i10 + 240 + (this.State << 4)) == 0) {
                                if (this.uncompressed_size + this.GlobalPos == 0) {
                                    LzmaException lzmaException3 = lzmaException2;
                                    LzmaException lzmaException4 = new LzmaException("LZMA : Data Error");
                                    throw lzmaException3;
                                }
                                this.State = this.State < 7 ? 9 : 11;
                                int i11 = this.dictionaryPos - this.rep0;
                                if (i11 < 0) {
                                    i11 += this.dictionarySize;
                                }
                                b = this.dictionary[i11];
                                this.dictionary[this.dictionaryPos] = b;
                                int i12 = 1 + this.dictionaryPos;
                                this.dictionaryPos = i12;
                                if (i12 == this.dictionarySize) {
                                    this.dictionaryPos = 0;
                                }
                                byte[] bArr3 = this.uncompressed_buffer;
                                int i13 = this.uncompressed_size;
                                this.uncompressed_size = i13 + 1;
                                bArr3[i13] = b;
                            }
                        } else {
                            if (this.RangeDecoder.BitDecode(this.probs, 216 + this.State) == 0) {
                                i2 = this.rep1;
                            } else {
                                if (this.RangeDecoder.BitDecode(this.probs, 228 + this.State) == 0) {
                                    i2 = this.rep2;
                                } else {
                                    i2 = this.rep3;
                                    this.rep3 = this.rep2;
                                }
                                this.rep2 = this.rep1;
                            }
                            this.rep1 = this.rep0;
                            this.rep0 = i2;
                        }
                        this.RemainLen = this.RangeDecoder.LzmaLenDecode(this.probs, RepLenCoder, i10);
                        this.State = this.State < 7 ? 8 : 11;
                    } else {
                        this.rep3 = this.rep2;
                        this.rep2 = this.rep1;
                        this.rep1 = this.rep0;
                        this.State = this.State < 7 ? 7 : 10;
                        this.RemainLen = this.RangeDecoder.LzmaLenDecode(this.probs, LenCoder, i10);
                        int BitTreeDecode = this.RangeDecoder.BitTreeDecode(this.probs, PosSlot + ((this.RemainLen < 4 ? this.RemainLen : 3) << 6), 6);
                        if (BitTreeDecode >= 4) {
                            int i14 = -1 + (BitTreeDecode >> 1);
                            this.rep0 = (2 | (BitTreeDecode & 1)) << i14;
                            if (BitTreeDecode < 14) {
                                this.rep0 += this.RangeDecoder.ReverseBitTreeDecode(this.probs, -1 + ((SpecPos + this.rep0) - BitTreeDecode), i14);
                            } else {
                                this.rep0 += this.RangeDecoder.DecodeDirectBits(i14 - 4) << 4;
                                this.rep0 += this.RangeDecoder.ReverseBitTreeDecode(this.probs, Align, 4);
                            }
                        } else {
                            this.rep0 = BitTreeDecode;
                        }
                        this.rep0 = 1 + this.rep0;
                    }
                    if (this.rep0 != 0) {
                        if (this.rep0 <= this.uncompressed_size + this.GlobalPos) {
                            this.RemainLen = 2 + this.RemainLen;
                            do {
                                int i15 = this.dictionaryPos - this.rep0;
                                if (i15 < 0) {
                                    i15 += this.dictionarySize;
                                }
                                b = this.dictionary[i15];
                                this.dictionary[this.dictionaryPos] = b;
                                int i16 = 1 + this.dictionaryPos;
                                this.dictionaryPos = i16;
                                if (i16 == this.dictionarySize) {
                                    this.dictionaryPos = 0;
                                }
                                byte[] bArr4 = this.uncompressed_buffer;
                                int i17 = this.uncompressed_size;
                                this.uncompressed_size = i17 + 1;
                                bArr4[i17] = b;
                                this.RemainLen = -1 + this.RemainLen;
                                if (this.RemainLen <= 0) {
                                    break;
                                }
                            } while (this.uncompressed_size < i3);
                        } else {
                            LzmaException lzmaException5 = lzmaException;
                            LzmaException lzmaException6 = new LzmaException("LZMA : Data Error");
                            throw lzmaException5;
                        }
                    } else {
                        this.RemainLen = -1;
                        break;
                    }
                } else {
                    int i18 = 1846 + (768 * (((i5 & (this.uncompressed_size + this.GlobalPos)) << this.f0lc) + ((b3 & 255) >> (8 - this.f0lc))));
                    if (this.State < 4) {
                        this.State = 0;
                    } else {
                        if (this.State < 10) {
                            this.State = -3 + this.State;
                        } else {
                            this.State = -6 + this.State;
                        }
                    }
                    if (this.PreviousIsMatch) {
                        int i19 = this.dictionaryPos - this.rep0;
                        if (i19 < 0) {
                            i19 += this.dictionarySize;
                        }
                        b = this.RangeDecoder.LzmaLiteralDecodeMatch(this.probs, i18, this.dictionary[i19]);
                        this.PreviousIsMatch = false;
                    } else {
                        b = this.RangeDecoder.LzmaLiteralDecode(this.probs, i18);
                    }
                    byte[] bArr5 = this.uncompressed_buffer;
                    int i20 = this.uncompressed_size;
                    this.uncompressed_size = i20 + 1;
                    bArr5[i20] = b;
                    this.dictionary[this.dictionaryPos] = b;
                    int i21 = 1 + this.dictionaryPos;
                    this.dictionaryPos = i21;
                    if (i21 == this.dictionarySize) {
                        this.dictionaryPos = 0;
                    }
                }
            }
            this.GlobalPos += this.uncompressed_size;
        }
    }

    private void fill_buffer() throws IOException {
        if (this.GlobalNowPos < this.GlobalOutSize) {
            this.uncompressed_offset = 0;
            long j = this.GlobalOutSize - this.GlobalNowPos;
            LzmaDecode(j > 65536 ? 65536 : (int) j);
            if (this.uncompressed_size == 0) {
                this.GlobalOutSize = this.GlobalNowPos;
            } else {
                this.GlobalNowPos += (long) this.uncompressed_size;
            }
        }
    }

    private void readHeader() throws IOException {
        CRangeDecoder cRangeDecoder;
        LzmaException lzmaException;
        LzmaException lzmaException2;
        LzmaException lzmaException3;
        LzmaException lzmaException4;
        byte[] bArr = new byte[5];
        if (5 != this.in.read(bArr)) {
            LzmaException lzmaException5 = lzmaException4;
            LzmaException lzmaException6 = new LzmaException("LZMA header corrupted : Properties error");
            throw lzmaException5;
        }
        this.GlobalOutSize = 0;
        for (int i = 0; i < 8; i++) {
            int read = this.in.read();
            if (read == -1) {
                LzmaException lzmaException7 = lzmaException3;
                LzmaException lzmaException8 = new LzmaException("LZMA header corrupted : Size error");
                throw lzmaException7;
            }
            this.GlobalOutSize += ((long) read) << (i * 8);
        }
        if (this.GlobalOutSize == -1) {
            this.GlobalOutSize = Long.MAX_VALUE;
        }
        int i2 = 255 & bArr[0];
        if (i2 >= 225) {
            LzmaException lzmaException9 = lzmaException2;
            LzmaException lzmaException10 = new LzmaException("LZMA header corrupted : Properties error");
            throw lzmaException9;
        }
        this.f2pb = 0;
        while (i2 >= 45) {
            this.f2pb = 1 + this.f2pb;
            i2 -= 45;
        }
        this.f1lp = 0;
        while (i2 >= 9) {
            this.f1lp = 1 + this.f1lp;
            i2 -= 9;
        }
        this.f0lc = i2;
        this.probs = new int[(1846 + (768 << (this.f0lc + this.f1lp)))];
        this.dictionarySize = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            this.dictionarySize += (255 & bArr[i3 + 1]) << (i3 * 8);
        }
        this.dictionary = new byte[this.dictionarySize];
        if (this.dictionary == null) {
            LzmaException lzmaException11 = lzmaException;
            LzmaException lzmaException12 = new LzmaException("LZMA : can't allocate");
            throw lzmaException11;
        }
        int i4 = 1846 + (768 << (this.f0lc + this.f1lp));
        CRangeDecoder cRangeDecoder2 = cRangeDecoder;
        CRangeDecoder cRangeDecoder3 = new CRangeDecoder(this.in);
        this.RangeDecoder = cRangeDecoder2;
        this.dictionaryPos = 0;
        this.GlobalPos = 0;
        this.rep3 = 1;
        this.rep2 = 1;
        this.rep1 = 1;
        this.rep0 = 1;
        this.State = 0;
        this.PreviousIsMatch = false;
        this.RemainLen = 0;
        this.dictionary[-1 + this.dictionarySize] = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            this.probs[i5] = 1024;
        }
        this.uncompressed_buffer = new byte[65536];
        this.uncompressed_size = 0;
        this.uncompressed_offset = 0;
        this.GlobalNowPos = 0;
    }

    public void close() throws IOException {
        this.isClosed = true;
        super.close();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        IndexOutOfBoundsException indexOutOfBoundsException;
        IOException iOException;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        if (this.isClosed) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException("stream closed");
            throw iOException2;
        } else if ((i3 | i4 | (i3 + i4) | (bArr2.length - (i3 + i4))) < 0) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException();
            throw indexOutOfBoundsException2;
        } else if (i4 == 0) {
            return 0;
        } else {
            if (this.uncompressed_offset == this.uncompressed_size) {
                fill_buffer();
            }
            if (this.uncompressed_offset == this.uncompressed_size) {
                return -1;
            }
            int min = Math.min(i4, this.uncompressed_size - this.uncompressed_offset);
            System.arraycopy(this.uncompressed_buffer, this.uncompressed_offset, bArr2, i3, min);
            this.uncompressed_offset = min + this.uncompressed_offset;
            return min;
        }
    }
}
