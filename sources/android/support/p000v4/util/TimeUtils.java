package android.support.p000v4.util;

import java.io.PrintWriter;

/* renamed from: android.support.v4.util.TimeUtils */
public class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr = new char[24];
    private static final Object sFormatSync;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        sFormatSync = obj2;
    }

    public TimeUtils() {
    }

    private static int accumField(int i, int i2, boolean z, int i3) {
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        if (i4 > 99 || (z2 && i6 >= 3)) {
            return i5 + 3;
        }
        if (i4 > 9 || (z2 && i6 >= 2)) {
            return i5 + 2;
        }
        if (z2 || i4 > 0) {
            return i5 + 1;
        }
        return 0;
    }

    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        long j3 = j;
        long j4 = j2;
        PrintWriter printWriter2 = printWriter;
        if (j3 == 0) {
            printWriter2.print("--");
        } else {
            formatDuration(j3 - j4, printWriter2, 0);
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        formatDuration(j, printWriter, 0);
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        String str;
        long j2 = j;
        PrintWriter printWriter2 = printWriter;
        int i2 = i;
        Object obj = sFormatSync;
        synchronized (obj) {
            try {
                PrintWriter printWriter3 = printWriter2;
                String str2 = str;
                String str3 = new String(sFormatStr, 0, formatDurationLocked(j2, i2));
                printWriter3.print(str2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void formatDuration(long j, StringBuilder sb) {
        long j2 = j;
        StringBuilder sb2 = sb;
        Object obj = sFormatSync;
        synchronized (obj) {
            try {
                StringBuilder append = sb2.append(sFormatStr, 0, formatDurationLocked(j2, 0));
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    private static int formatDurationLocked(long j, int i) {
        char c;
        long j2 = j;
        int i2 = i;
        if (sFormatStr.length < i2) {
            sFormatStr = new char[i2];
        }
        char[] cArr = sFormatStr;
        if (j2 == 0) {
            int i3 = i2 - 1;
            while (i3 < 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j2 > 0) {
            c = '+';
        } else {
            c = '-';
            j2 = -j2;
        }
        int i4 = (int) (j2 % 1000);
        int floor = (int) Math.floor((double) (j2 / 1000));
        int i5 = 0;
        if (floor > SECONDS_PER_DAY) {
            i5 = floor / SECONDS_PER_DAY;
            floor -= SECONDS_PER_DAY * i5;
        }
        int i6 = 0;
        if (floor > SECONDS_PER_HOUR) {
            i6 = floor / SECONDS_PER_HOUR;
            floor -= i6 * SECONDS_PER_HOUR;
        }
        int i7 = 0;
        if (floor > 60) {
            i7 = floor / 60;
            floor -= i7 * 60;
        }
        int i8 = 0;
        if (i2 != 0) {
            int accumField = accumField(i5, 1, false, 0);
            int accumField2 = accumField + accumField(i6, 1, accumField > 0, 2);
            int accumField3 = accumField2 + accumField(i7, 1, accumField2 > 0, 2);
            int accumField4 = accumField3 + accumField(floor, 1, accumField3 > 0, 2);
            for (int accumField5 = accumField4 + 1 + accumField(i4, 2, true, accumField4 > 0 ? 3 : 0); accumField5 < i2; accumField5++) {
                cArr[i8] = ' ';
                i8++;
            }
        }
        cArr[i8] = c;
        int i9 = i8 + 1;
        boolean z = i2 != 0;
        int printField = printField(cArr, i5, 'd', i9, false, 0);
        int printField2 = printField(cArr, i6, 'h', printField, printField != i9, z ? 2 : 0);
        int printField3 = printField(cArr, i7, 'm', printField2, printField2 != i9, z ? 2 : 0);
        int printField4 = printField(cArr, floor, 's', printField3, printField3 != i9, z ? 2 : 0);
        int printField5 = printField(cArr, i4, 'm', printField4, true, (!z || printField4 == i9) ? 0 : 3);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        char[] cArr2 = cArr;
        int i4 = i;
        char c2 = c;
        int i5 = i2;
        boolean z2 = z;
        int i6 = i3;
        if (z2 || i4 > 0) {
            int i7 = i5;
            if ((z2 && i6 >= 3) || i4 > 99) {
                int i8 = i4 / 100;
                cArr2[i5] = (char) (i8 + 48);
                i5++;
                i4 -= i8 * 100;
            }
            if ((z2 && i6 >= 2) || i4 > 9 || i7 != i5) {
                int i9 = i4 / 10;
                cArr2[i5] = (char) (i9 + 48);
                i5++;
                i4 -= i9 * 10;
            }
            cArr2[i5] = (char) (i4 + 48);
            int i10 = i5 + 1;
            cArr2[i10] = c2;
            i5 = i10 + 1;
        }
        return i5;
    }
}
