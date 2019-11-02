package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString */
public final class CstString extends TypedConstant {
    public static final CstString EMPTY_STRING;
    private final ByteArray bytes;
    private final String string;

    static {
        CstString cstString;
        CstString cstString2 = cstString;
        CstString cstString3 = new CstString(LibrariesRepository.MOJANG_MAVEN_REPO);
        EMPTY_STRING = cstString2;
    }

    public CstString(String str) {
        ByteArray byteArray;
        NullPointerException nullPointerException;
        String str2 = str;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("string == null");
            throw nullPointerException2;
        }
        this.string = str2.intern();
        ByteArray byteArray2 = byteArray;
        ByteArray byteArray3 = new ByteArray(stringToUtf8Bytes(str2));
        this.bytes = byteArray2;
    }

    public CstString(ByteArray byteArray) {
        NullPointerException nullPointerException;
        ByteArray byteArray2 = byteArray;
        if (byteArray2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("bytes == null");
            throw nullPointerException2;
        }
        this.bytes = byteArray2;
        this.string = utf8BytesToString(byteArray2).intern();
    }

    public static byte[] stringToUtf8Bytes(String str) {
        String str2 = str;
        int length = str2.length();
        byte[] bArr = new byte[(length * 3)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str2.charAt(i2);
            if (charAt != 0 && charAt < 128) {
                bArr[i] = (byte) charAt;
                i++;
            } else if (charAt < 2048) {
                bArr[i] = (byte) (192 | (31 & (charAt >> 6)));
                bArr[i + 1] = (byte) (128 | (charAt & '?'));
                i += 2;
            } else {
                bArr[i] = (byte) (224 | (15 & (charAt >> 12)));
                bArr[i + 1] = (byte) (128 | (63 & (charAt >> 6)));
                bArr[i + 2] = (byte) (128 | (charAt & '?'));
                i += 3;
            }
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    private static String throwBadUtf8(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("bad utf-8 byte ").append(Hex.m50u1(i3)).append(" at offset ").append(Hex.m53u4(i4)).toString());
        throw illegalArgumentException2;
    }

    public static String utf8BytesToString(ByteArray byteArray) {
        String str;
        char c;
        ByteArray byteArray2 = byteArray;
        int size = byteArray2.size();
        char[] cArr = new char[size];
        int i = 0;
        int i2 = 0;
        while (size > 0) {
            int unsignedByte = byteArray2.getUnsignedByte(i);
            switch (unsignedByte >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    size--;
                    if (unsignedByte != 0) {
                        c = (char) unsignedByte;
                        i++;
                        break;
                    } else {
                        return throwBadUtf8(unsignedByte, i);
                    }
                case 12:
                case 13:
                    size -= 2;
                    if (size < 0) {
                        return throwBadUtf8(unsignedByte, i);
                    }
                    int unsignedByte2 = byteArray2.getUnsignedByte(i + 1);
                    if ((unsignedByte2 & 192) != 128) {
                        return throwBadUtf8(unsignedByte2, i + 1);
                    }
                    int i3 = ((unsignedByte & 31) << 6) | (unsignedByte2 & 63);
                    if (i3 == 0 || i3 >= 128) {
                        c = (char) i3;
                        i += 2;
                        break;
                    } else {
                        return throwBadUtf8(unsignedByte2, i + 1);
                    }
                case 14:
                    size -= 3;
                    if (size >= 0) {
                        int unsignedByte3 = byteArray2.getUnsignedByte(i + 1);
                        if ((unsignedByte3 & 192) == 128) {
                            int unsignedByte4 = byteArray2.getUnsignedByte(i + 2);
                            if ((unsignedByte3 & 192) == 128) {
                                int i4 = ((unsignedByte & 15) << 12) | ((unsignedByte3 & 63) << 6) | (unsignedByte4 & 63);
                                if (i4 >= 2048) {
                                    c = (char) i4;
                                    i += 3;
                                    break;
                                } else {
                                    return throwBadUtf8(unsignedByte4, i + 2);
                                }
                            } else {
                                return throwBadUtf8(unsignedByte4, i + 2);
                            }
                        } else {
                            return throwBadUtf8(unsignedByte3, i + 1);
                        }
                    } else {
                        return throwBadUtf8(unsignedByte, i);
                    }
                default:
                    return throwBadUtf8(unsignedByte, i);
            }
            cArr[i2] = c;
            i2++;
        }
        String str2 = str;
        String str3 = new String(cArr, 0, i2);
        return str2;
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        return this.string.compareTo(((CstString) constant).string);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof CstString)) {
            return false;
        }
        return this.string.equals(((CstString) obj2).string);
    }

    public ByteArray getBytes() {
        return this.bytes;
    }

    public String getString() {
        return this.string;
    }

    public Type getType() {
        return Type.STRING;
    }

    public int getUtf16Size() {
        return this.string.length();
    }

    public int getUtf8Size() {
        return this.bytes.size();
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    public boolean isCategory2() {
        return false;
    }

    public String toHuman() {
        StringBuilder sb;
        int length = this.string.length();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder((length * 3) / 2);
        StringBuilder sb4 = sb2;
        int i = 0;
        while (i < length) {
            char charAt = this.string.charAt(i);
            if (charAt >= ' ' && charAt < 127) {
                if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                    StringBuilder append = sb4.append('\\');
                }
                StringBuilder append2 = sb4.append(charAt);
            } else if (charAt <= 127) {
                switch (charAt) {
                    case 9:
                        StringBuilder append3 = sb4.append("\\t");
                        break;
                    case 10:
                        StringBuilder append4 = sb4.append("\\n");
                        break;
                    case 13:
                        StringBuilder append5 = sb4.append("\\r");
                        break;
                    default:
                        char c = i < length + -1 ? this.string.charAt(i + 1) : 0;
                        boolean z = c >= '0' && c <= '7';
                        StringBuilder append6 = sb4.append('\\');
                        for (int i2 = 6; i2 >= 0; i2 -= 3) {
                            char c2 = (char) (48 + (7 & (charAt >> i2)));
                            if (c2 != '0' || z) {
                                StringBuilder append7 = sb4.append(c2);
                                z = true;
                            }
                        }
                        if (z) {
                            break;
                        } else {
                            StringBuilder append8 = sb4.append('0');
                            break;
                        }
                        break;
                }
            } else {
                StringBuilder append9 = sb4.append("\\u");
                StringBuilder append10 = sb4.append(Character.forDigit(charAt >> 12, 16));
                StringBuilder append11 = sb4.append(Character.forDigit(15 & (charAt >> 8), 16));
                StringBuilder append12 = sb4.append(Character.forDigit(15 & (charAt >> 4), 16));
                StringBuilder append13 = sb4.append(Character.forDigit(charAt & 15, 16));
            }
            i++;
        }
        return sb4.toString();
    }

    public String toQuoted() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append('\"').append(toHuman()).append('\"').toString();
    }

    public String toQuoted(int i) {
        String str;
        StringBuilder sb;
        int i2 = i;
        String human = toHuman();
        if (human.length() <= i2 - 2) {
            str = LibrariesRepository.MOJANG_MAVEN_REPO;
        } else {
            human = human.substring(0, i2 - 5);
            str = "...";
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append('\"').append(human).append(str).append('\"').toString();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("string{\"").append(toHuman()).append("\"}").toString();
    }

    public String typeName() {
        return "utf8";
    }
}
