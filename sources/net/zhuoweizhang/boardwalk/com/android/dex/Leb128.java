package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteInput;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteOutput;

public final class Leb128 {
    private Leb128() {
    }

    public static int readSignedLeb128(ByteInput byteInput) {
        int readByte;
        DexException dexException;
        ByteInput byteInput2 = byteInput;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        do {
            readByte = 255 & byteInput2.readByte();
            i3 |= (readByte & 127) << (i * 7);
            i2 <<= 7;
            i++;
            if ((readByte & 128) != 128) {
                break;
            }
        } while (i < 5);
        if ((readByte & 128) == 128) {
            DexException dexException2 = dexException;
            DexException dexException3 = new DexException("invalid LEB128 sequence");
            throw dexException2;
        }
        if ((i3 & (i2 >> 1)) != 0) {
            i3 |= i2;
        }
        return i3;
    }

    public static int readUnsignedLeb128(ByteInput byteInput) {
        int readByte;
        DexException dexException;
        ByteInput byteInput2 = byteInput;
        int i = 0;
        int i2 = 0;
        do {
            readByte = 255 & byteInput2.readByte();
            i2 |= (readByte & 127) << (i * 7);
            i++;
            if ((readByte & 128) != 128) {
                break;
            }
        } while (i < 5);
        if ((readByte & 128) != 128) {
            return i2;
        }
        DexException dexException2 = dexException;
        DexException dexException3 = new DexException("invalid LEB128 sequence");
        throw dexException2;
    }

    public static int signedLeb128Size(int i) {
        int i2 = i;
        int i3 = i2 >> 7;
        int i4 = (Integer.MIN_VALUE & i2) == 0 ? 0 : -1;
        int i5 = 0;
        int i6 = i3;
        boolean z = true;
        while (z) {
            z = (i6 == i4 && (i6 & 1) == (1 & (i2 >> 6))) ? false : true;
            i5++;
            i2 = i6;
            i6 >>= 7;
        }
        return i5;
    }

    public static int unsignedLeb128Size(int i) {
        int i2 = i >> 7;
        int i3 = 0;
        while (i2 != 0) {
            i2 >>= 7;
            i3++;
        }
        return i3 + 1;
    }

    public static void writeSignedLeb128(ByteOutput byteOutput, int i) {
        ByteOutput byteOutput2 = byteOutput;
        int i2 = i;
        int i3 = i2 >> 7;
        int i4 = (Integer.MIN_VALUE & i2) == 0 ? 0 : -1;
        boolean z = true;
        int i5 = i3;
        while (true) {
            int i6 = i5;
            if (z) {
                z = (i6 == i4 && (i6 & 1) == (1 & (i2 >> 6))) ? false : true;
                byteOutput2.writeByte((byte) ((z ? 128 : 0) | (i2 & 127)));
                i2 = i6;
                i5 = i6 >> 7;
            } else {
                return;
            }
        }
    }

    public static void writeUnsignedLeb128(ByteOutput byteOutput, int i) {
        ByteOutput byteOutput2 = byteOutput;
        int i2 = i;
        int i3 = i2 >>> 7;
        while (true) {
            int i4 = i3;
            if (i4 != 0) {
                byteOutput2.writeByte((byte) (128 | (i2 & 127)));
                i2 = i4;
                i3 = i4 >>> 7;
            } else {
                byteOutput2.writeByte((byte) (i2 & 127));
                return;
            }
        }
    }
}
