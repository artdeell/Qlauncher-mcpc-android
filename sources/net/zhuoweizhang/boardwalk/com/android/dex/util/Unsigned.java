package net.zhuoweizhang.boardwalk.com.android.dex.util;

public final class Unsigned {
    private Unsigned() {
    }

    public static int compare(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (i3 == i4) {
            return 0;
        }
        return (4294967295L & ((long) i3)) < (4294967295L & ((long) i4)) ? -1 : 1;
    }

    public static int compare(short s, short s2) {
        short s3 = s;
        short s4 = s2;
        if (s3 == s4) {
            return 0;
        }
        return (s3 & 65535) < (65535 & s4) ? -1 : 1;
    }
}
