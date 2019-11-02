package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.HexParser */
public final class HexParser {
    private HexParser() {
    }

    public static byte[] parse(String str) {
        RuntimeException runtimeException;
        StringBuilder sb;
        RuntimeException runtimeException2;
        StringBuilder sb2;
        RuntimeException runtimeException3;
        StringBuilder sb3;
        int i;
        RuntimeException runtimeException4;
        StringBuilder sb4;
        RuntimeException runtimeException5;
        StringBuilder sb5;
        String str2 = str;
        int length = str2.length();
        byte[] bArr = new byte[(length / 2)];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < length) {
                int indexOf = str2.indexOf(10, i4);
                if (indexOf < 0) {
                    indexOf = length;
                }
                int indexOf2 = str2.indexOf(35, i4);
                String substring = (indexOf2 < 0 || indexOf2 >= indexOf) ? str2.substring(i4, indexOf) : str2.substring(i4, indexOf2);
                int i5 = indexOf + 1;
                int indexOf3 = substring.indexOf(58);
                if (indexOf3 != -1) {
                    int indexOf4 = substring.indexOf(34);
                    if (indexOf4 == -1 || indexOf4 >= indexOf3) {
                        String trim = substring.substring(0, indexOf3).trim();
                        substring = substring.substring(indexOf3 + 1);
                        if (Integer.parseInt(trim, 16) != i2) {
                            RuntimeException runtimeException6 = runtimeException5;
                            StringBuilder sb6 = sb5;
                            StringBuilder sb7 = new StringBuilder();
                            RuntimeException runtimeException7 = new RuntimeException(sb6.append("bogus offset marker: ").append(trim).toString());
                            throw runtimeException6;
                        }
                    }
                }
                int length2 = substring.length();
                int i6 = 0;
                boolean z = false;
                int i7 = -1;
                while (i6 < length2) {
                    char charAt = substring.charAt(i6);
                    if (z) {
                        if (charAt == '\"') {
                            z = false;
                            i = i2;
                        } else {
                            bArr[i2] = (byte) charAt;
                            i = i2 + 1;
                        }
                    } else if (charAt <= ' ') {
                        i = i2;
                    } else if (charAt != '\"') {
                        int digit = Character.digit(charAt, 16);
                        if (digit == -1) {
                            RuntimeException runtimeException8 = runtimeException3;
                            StringBuilder sb8 = sb3;
                            StringBuilder sb9 = new StringBuilder();
                            RuntimeException runtimeException9 = new RuntimeException(sb8.append("bogus digit character: \"").append(charAt).append("\"").toString());
                            throw runtimeException8;
                        } else if (i7 == -1) {
                            i7 = digit;
                            i = i2;
                        } else {
                            bArr[i2] = (byte) (digit | (i7 << 4));
                            i = i2 + 1;
                            i7 = -1;
                        }
                    } else if (i7 != -1) {
                        RuntimeException runtimeException10 = runtimeException4;
                        StringBuilder sb10 = sb4;
                        StringBuilder sb11 = new StringBuilder();
                        RuntimeException runtimeException11 = new RuntimeException(sb10.append("spare digit around offset ").append(Hex.m53u4(i2)).toString());
                        throw runtimeException10;
                    } else {
                        z = true;
                        i = i2;
                    }
                    i6++;
                    i2 = i;
                }
                if (i7 != -1) {
                    RuntimeException runtimeException12 = runtimeException;
                    StringBuilder sb12 = sb;
                    StringBuilder sb13 = new StringBuilder();
                    RuntimeException runtimeException13 = new RuntimeException(sb12.append("spare digit around offset ").append(Hex.m53u4(i2)).toString());
                    throw runtimeException12;
                } else if (z) {
                    RuntimeException runtimeException14 = runtimeException2;
                    StringBuilder sb14 = sb2;
                    StringBuilder sb15 = new StringBuilder();
                    RuntimeException runtimeException15 = new RuntimeException(sb14.append("unterminated quote around offset ").append(Hex.m53u4(i2)).toString());
                    throw runtimeException14;
                } else {
                    i3 = i5;
                }
            } else {
                if (i2 >= bArr.length) {
                    return bArr;
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                return bArr2;
            }
        }
    }
}
