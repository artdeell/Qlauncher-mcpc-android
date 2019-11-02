package jdkregex;

import org.lwjgl.opengl.GL11;

final class ASCII {
    static final int ALNUM = 1792;
    static final int ALPHA = 768;
    static final int ASCII = 65280;
    static final int BLANK = 16384;
    static final int CNTRL = 8192;
    static final int DIGIT = 1024;
    static final int GRAPH = 5888;
    static final int HEX = 32768;
    static final int LOWER = 512;
    static final int PUNCT = 4096;
    static final int SPACE = 2048;
    static final int UNDER = 65536;
    static final int UPPER = 256;
    static final int WORD = 67328;
    static final int XDIGIT = 32768;
    private static final int[] ctype = {8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 26624, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_TEXTURE_MAG_FILTER, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 18432, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 33792, 33793, 33794, 33795, 33796, 33797, 33798, 33799, 33800, 33801, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 33034, 33035, 33036, 33037, 33038, 33039, 272, NativeDefinitions.BTN_RIGHT, NativeDefinitions.BTN_MIDDLE, NativeDefinitions.BTN_SIDE, NativeDefinitions.BTN_EXTRA, NativeDefinitions.BTN_FORWARD, NativeDefinitions.BTN_BACK, NativeDefinitions.BTN_TASK, 280, 281, 282, 283, 284, 285, 286, 287, 288, NativeDefinitions.BTN_THUMB, NativeDefinitions.BTN_THUMB2, NativeDefinitions.BTN_TOP, 4096, 4096, 4096, 4096, 69632, 4096, 33290, 33291, 33292, 33293, 33294, 33295, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 4096, 4096, 4096, 4096, 8192};

    ASCII() {
    }

    static int getType(int i) {
        int i2 = i;
        if ((i2 & -128) == 0) {
            return ctype[i2];
        }
        return 0;
    }

    static boolean isAlnum(int i) {
        return isType(i, 1792);
    }

    static boolean isAlpha(int i) {
        return isType(i, 768);
    }

    static boolean isAscii(int i) {
        return (i & -128) == 0;
    }

    static boolean isCntrl(int i) {
        return isType(i, 8192);
    }

    static boolean isDigit(int i) {
        int i2 = i;
        return ((i2 + -48) | (57 - i2)) >= 0;
    }

    static boolean isGraph(int i) {
        return isType(i, 5888);
    }

    static boolean isHexDigit(int i) {
        return isType(i, 32768);
    }

    static boolean isLower(int i) {
        int i2 = i;
        return ((i2 + -97) | (122 - i2)) >= 0;
    }

    static boolean isOctDigit(int i) {
        int i2 = i;
        return ((i2 + -48) | (55 - i2)) >= 0;
    }

    static boolean isPrint(int i) {
        int i2 = i;
        return ((i2 + -32) | (126 - i2)) >= 0;
    }

    static boolean isPunct(int i) {
        return isType(i, 4096);
    }

    static boolean isSpace(int i) {
        return isType(i, 2048);
    }

    static boolean isType(int i, int i2) {
        return (i2 & getType(i)) != 0;
    }

    static boolean isUpper(int i) {
        int i2 = i;
        return ((i2 + -65) | (90 - i2)) >= 0;
    }

    static boolean isWord(int i) {
        return isType(i, WORD);
    }

    static int toDigit(int i) {
        return 63 & ctype[i & 127];
    }

    static int toLower(int i) {
        int i2 = i;
        if (isUpper(i2)) {
            i2 += 32;
        }
        return i2;
    }

    static int toUpper(int i) {
        int i2 = i;
        if (isLower(i2)) {
            i2 -= 32;
        }
        return i2;
    }
}
