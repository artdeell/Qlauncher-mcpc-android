package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.Hex */
public final class Hex {
    private Hex() {
    }

    public static String dump(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        StringBuilder sb;
        StringBuffer stringBuffer;
        String u3;
        IllegalArgumentException illegalArgumentException;
        byte[] bArr2 = bArr;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        int i11 = i6 + i7;
        if ((i11 | i6 | i7) < 0 || i11 > bArr2.length) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException(sb2.append("arr.length ").append(bArr2.length).append("; ").append(i6).append("..!").append(i11).toString());
            throw indexOutOfBoundsException2;
        } else if (i8 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("outOffset < 0");
            throw illegalArgumentException2;
        } else if (i7 == 0) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        } else {
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer(6 + (i7 * 4));
            StringBuffer stringBuffer4 = stringBuffer2;
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i7 > 0) {
                    if (i13 == 0) {
                        switch (i10) {
                            case 2:
                                u3 = m50u1(i8);
                                break;
                            case 4:
                                u3 = m51u2(i8);
                                break;
                            case 6:
                                u3 = m52u3(i8);
                                break;
                            default:
                                u3 = m53u4(i8);
                                break;
                        }
                        StringBuffer append = stringBuffer4.append(u3);
                        StringBuffer append2 = stringBuffer4.append(": ");
                    } else if ((i13 & 1) == 0) {
                        StringBuffer append3 = stringBuffer4.append(' ');
                    }
                    StringBuffer append4 = stringBuffer4.append(m50u1(bArr2[i6]));
                    i8++;
                    i6++;
                    int i14 = i13 + 1;
                    if (i14 == i9) {
                        StringBuffer append5 = stringBuffer4.append(10);
                        i14 = 0;
                    }
                    i7--;
                    i12 = i14;
                } else {
                    if (i13 != 0) {
                        StringBuffer append6 = stringBuffer4.append(10);
                    }
                    return stringBuffer4.toString();
                }
            }
        }
    }

    /* renamed from: s1 */
    public static String m46s1(int i) {
        String str;
        int i2 = i;
        int i3 = 0;
        char[] cArr = new char[3];
        if (i2 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i2 = -i2;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
            i3 = 0;
        }
        while (i3 < 2) {
            cArr[2 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
            i3++;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    /* renamed from: s2 */
    public static String m47s2(int i) {
        String str;
        int i2 = i;
        int i3 = 0;
        char[] cArr = new char[5];
        if (i2 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i2 = -i2;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
            i3 = 0;
        }
        while (i3 < 4) {
            cArr[4 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
            i3++;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    /* renamed from: s4 */
    public static String m48s4(int i) {
        String str;
        int i2 = i;
        int i3 = 0;
        char[] cArr = new char[9];
        if (i2 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i2 = -i2;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
            i3 = 0;
        }
        while (i3 < 8) {
            cArr[8 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
            i3++;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    /* renamed from: s8 */
    public static String m49s8(long j) {
        String str;
        long j2 = j;
        int i = 0;
        char[] cArr = new char[17];
        if (j2 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            j2 = -j2;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
            i = 0;
        }
        while (i < 16) {
            cArr[16 - i] = Character.forDigit(15 & ((int) j2), 16);
            j2 >>= 4;
            i++;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    /* renamed from: u1 */
    public static String m50u1(int i) {
        String str;
        int i2 = i;
        char[] cArr = new char[2];
        for (int i3 = 0; i3 < 2; i3++) {
            cArr[1 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    /* renamed from: u2 */
    public static String m51u2(int i) {
        String str;
        int i2 = i;
        char[] cArr = new char[4];
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[3 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    public static String u2or4(int i) {
        int i2 = i;
        return i2 == ((char) i2) ? m51u2(i2) : m53u4(i2);
    }

    /* renamed from: u3 */
    public static String m52u3(int i) {
        String str;
        int i2 = i;
        char[] cArr = new char[6];
        for (int i3 = 0; i3 < 6; i3++) {
            cArr[5 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    /* renamed from: u4 */
    public static String m53u4(int i) {
        String str;
        int i2 = i;
        char[] cArr = new char[8];
        for (int i3 = 0; i3 < 8; i3++) {
            cArr[7 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    /* renamed from: u8 */
    public static String m54u8(long j) {
        String str;
        long j2 = j;
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[15 - i] = Character.forDigit(15 & ((int) j2), 16);
            j2 >>= 4;
        }
        String str2 = str;
        String str3 = new String(cArr);
        return str2;
    }

    public static String uNibble(int i) {
        String str;
        String str2 = str;
        String str3 = new String(new char[]{Character.forDigit(i & 15, 16)});
        return str2;
    }
}
