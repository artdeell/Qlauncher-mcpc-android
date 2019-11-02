package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteInput;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteOutput;

public final class EncodedValueCodec {
    private EncodedValueCodec() {
    }

    public static int readSignedInt(ByteInput byteInput, int i) {
        ByteInput byteInput2 = byteInput;
        int i2 = i;
        int i3 = 0;
        for (int i4 = i2; i4 >= 0; i4--) {
            i3 = (i3 >>> 8) | ((255 & byteInput2.readByte()) << 24);
        }
        return i3 >> (8 * (3 - i2));
    }

    public static long readSignedLong(ByteInput byteInput, int i) {
        ByteInput byteInput2 = byteInput;
        int i2 = i;
        long j = 0;
        for (int i3 = i2; i3 >= 0; i3--) {
            j = (j >>> 8) | ((255 & ((long) byteInput2.readByte())) << 56);
        }
        return j >> (8 * (7 - i2));
    }

    public static int readUnsignedInt(ByteInput byteInput, int i, boolean z) {
        ByteInput byteInput2 = byteInput;
        int i2 = i;
        int i3 = 0;
        if (!z) {
            int i4 = 0;
            for (int i5 = i2; i5 >= 0; i5--) {
                i4 = (i4 >>> 8) | ((255 & byteInput2.readByte()) << 24);
            }
            i3 = i4 >>> (8 * (3 - i2));
        } else {
            while (i2 >= 0) {
                i3 = (i3 >>> 8) | ((255 & byteInput2.readByte()) << 24);
                i2--;
            }
        }
        return i3;
    }

    public static long readUnsignedLong(ByteInput byteInput, int i, boolean z) {
        ByteInput byteInput2 = byteInput;
        int i2 = i;
        long j = 0;
        if (!z) {
            long j2 = 0;
            for (int i3 = i2; i3 >= 0; i3--) {
                j2 = (j2 >>> 8) | ((255 & ((long) byteInput2.readByte())) << 56);
            }
            j = j2 >>> (8 * (7 - i2));
        } else {
            while (i2 >= 0) {
                j = (j >>> 8) | ((255 & ((long) byteInput2.readByte())) << 56);
                i2--;
            }
        }
        return j;
    }

    public static void writeRightZeroExtendedValue(ByteOutput byteOutput, int i, long j) {
        ByteOutput byteOutput2 = byteOutput;
        int i2 = i;
        long j2 = j;
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j2);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        int i3 = (numberOfTrailingZeros + 7) >> 3;
        long j3 = j2 >> (64 - (i3 * 8));
        byteOutput2.writeByte(i2 | ((i3 - 1) << 5));
        while (i3 > 0) {
            byteOutput2.writeByte((byte) ((int) j3));
            j3 >>= 8;
            i3--;
        }
    }

    public static void writeSignedIntegralValue(ByteOutput byteOutput, int i, long j) {
        ByteOutput byteOutput2 = byteOutput;
        long j2 = j;
        int numberOfLeadingZeros = (7 + (65 - Long.numberOfLeadingZeros(j2 ^ (j2 >> 63)))) >> 3;
        byteOutput2.writeByte(i | ((numberOfLeadingZeros - 1) << 5));
        while (numberOfLeadingZeros > 0) {
            byteOutput2.writeByte((byte) ((int) j2));
            j2 >>= 8;
            numberOfLeadingZeros--;
        }
    }

    public static void writeUnsignedIntegralValue(ByteOutput byteOutput, int i, long j) {
        ByteOutput byteOutput2 = byteOutput;
        int i2 = i;
        long j2 = j;
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j2);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        int i3 = (numberOfLeadingZeros + 7) >> 3;
        byteOutput2.writeByte(i2 | ((i3 - 1) << 5));
        while (i3 > 0) {
            byteOutput2.writeByte((byte) ((int) j2));
            j2 >>= 8;
            i3--;
        }
    }
}
