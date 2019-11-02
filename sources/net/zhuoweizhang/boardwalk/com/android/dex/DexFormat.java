package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class DexFormat {
    public static final int API_CURRENT = 14;
    public static final int API_NO_EXTENDED_OPCODES = 13;
    public static final String DEX_IN_JAR_NAME = "classes.dex";
    public static final int ENDIAN_TAG = 305419896;
    public static final String MAGIC_PREFIX = "dex\n";
    public static final String MAGIC_SUFFIX = "\u0000";
    public static final int MAX_MEMBER_IDX = 65535;
    public static final int MAX_TYPE_IDX = 65535;
    public static final String VERSION_CURRENT = "036";
    public static final String VERSION_FOR_API_13 = "035";

    private DexFormat() {
    }

    public static String apiToMagic(int i) {
        StringBuilder sb;
        String str = i >= 14 ? VERSION_CURRENT : VERSION_FOR_API_13;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(MAGIC_PREFIX).append(str).append(MAGIC_SUFFIX).toString();
    }

    public static int magicToApi(byte[] bArr) {
        StringBuilder sb;
        byte[] bArr2 = bArr;
        if (bArr2.length == 8 && bArr2[0] == 100 && bArr2[1] == 101 && bArr2[2] == 120 && bArr2[3] == 10 && bArr2[7] == 0) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            String sb4 = sb2.append(LibrariesRepository.MOJANG_MAVEN_REPO).append((char) bArr2[4]).append((char) bArr2[5]).append((char) bArr2[6]).toString();
            if (sb4.equals(VERSION_CURRENT)) {
                return 14;
            }
            if (sb4.equals(VERSION_FOR_API_13)) {
                return 13;
            }
        }
        return -1;
    }
}
