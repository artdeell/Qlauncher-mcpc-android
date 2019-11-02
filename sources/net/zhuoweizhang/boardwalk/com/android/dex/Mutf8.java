package net.zhuoweizhang.boardwalk.com.android.dex;

import java.io.UTFDataFormatException;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteInput;

public final class Mutf8 {
    private Mutf8() {
    }

    private static long countBytes(String str, boolean z) throws UTFDataFormatException {
        UTFDataFormatException uTFDataFormatException;
        String str2 = str;
        boolean z2 = z;
        int length = str2.length();
        long j = 0;
        int i = 0;
        while (i < length) {
            char charAt = str2.charAt(i);
            j = (charAt == 0 || charAt > 127) ? charAt <= 2047 ? j + 2 : j + 3 : j + 1;
            if (!z2 || j <= 65535) {
                i++;
            } else {
                UTFDataFormatException uTFDataFormatException2 = uTFDataFormatException;
                UTFDataFormatException uTFDataFormatException3 = new UTFDataFormatException("String more than 65535 UTF bytes long");
                throw uTFDataFormatException2;
            }
        }
        return j;
    }

    public static String decode(ByteInput byteInput, char[] cArr) throws UTFDataFormatException {
        String str;
        UTFDataFormatException uTFDataFormatException;
        UTFDataFormatException uTFDataFormatException2;
        UTFDataFormatException uTFDataFormatException3;
        ByteInput byteInput2 = byteInput;
        char[] cArr2 = cArr;
        int i = 0;
        while (true) {
            char readByte = (char) (255 & byteInput2.readByte());
            if (readByte == 0) {
                String str2 = str;
                String str3 = new String(cArr2, 0, i);
                return str2;
            }
            cArr2[i] = readByte;
            if (readByte < 128) {
                i++;
            } else if ((readByte & 224) == 192) {
                byte readByte2 = 255 & byteInput2.readByte();
                if ((readByte2 & 192) != 128) {
                    UTFDataFormatException uTFDataFormatException4 = uTFDataFormatException3;
                    UTFDataFormatException uTFDataFormatException5 = new UTFDataFormatException("bad second byte");
                    throw uTFDataFormatException4;
                }
                int i2 = i + 1;
                cArr2[i] = (char) (((readByte & 31) << 6) | (readByte2 & 63));
                i = i2;
            } else if ((readByte & 240) == 224) {
                byte readByte3 = 255 & byteInput2.readByte();
                byte readByte4 = 255 & byteInput2.readByte();
                if ((readByte3 & 192) == 128 && (readByte4 & 192) == 128) {
                    int i3 = i + 1;
                    cArr2[i] = (char) (((readByte & 15) << 12) | ((readByte3 & 63) << 6) | (readByte4 & 63));
                    i = i3;
                } else {
                    UTFDataFormatException uTFDataFormatException6 = uTFDataFormatException2;
                    UTFDataFormatException uTFDataFormatException7 = new UTFDataFormatException("bad second or third byte");
                }
            } else {
                UTFDataFormatException uTFDataFormatException8 = uTFDataFormatException;
                UTFDataFormatException uTFDataFormatException9 = new UTFDataFormatException("bad byte");
                throw uTFDataFormatException8;
            }
        }
        UTFDataFormatException uTFDataFormatException62 = uTFDataFormatException2;
        UTFDataFormatException uTFDataFormatException72 = new UTFDataFormatException("bad second or third byte");
        throw uTFDataFormatException62;
    }

    public static void encode(byte[] bArr, int i, String str) {
        int i2;
        byte[] bArr2 = bArr;
        int i3 = i;
        String str2 = str;
        int length = str2.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt = str2.charAt(i4);
            if (charAt != 0 && charAt <= 127) {
                i2 = i3 + 1;
                bArr2[i3] = (byte) charAt;
            } else if (charAt <= 2047) {
                int i5 = i3 + 1;
                bArr2[i3] = (byte) (192 | (31 & (charAt >> 6)));
                i2 = i5 + 1;
                bArr2[i5] = (byte) (128 | (charAt & '?'));
            } else {
                int i6 = i3 + 1;
                bArr2[i3] = (byte) (224 | (15 & (charAt >> 12)));
                int i7 = i6 + 1;
                bArr2[i6] = (byte) (128 | (63 & (charAt >> 6)));
                i2 = i7 + 1;
                bArr2[i7] = (byte) (128 | (charAt & '?'));
            }
            i4++;
            i3 = i2;
        }
    }

    public static byte[] encode(String str) throws UTFDataFormatException {
        String str2 = str;
        byte[] bArr = new byte[((int) countBytes(str2, true))];
        encode(bArr, 0, str2);
        return bArr;
    }
}
