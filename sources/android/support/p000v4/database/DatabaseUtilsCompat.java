package android.support.p000v4.database;

import android.text.TextUtils;

/* renamed from: android.support.v4.database.DatabaseUtilsCompat */
public class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    public static String[] appendSelectionArgs(String[] strArr, String[] strArr2) {
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        if (strArr3 == null || strArr3.length == 0) {
            return strArr4;
        }
        String[] strArr5 = new String[(strArr3.length + strArr4.length)];
        System.arraycopy(strArr3, 0, strArr5, 0, strArr3.length);
        System.arraycopy(strArr4, 0, strArr5, strArr3.length, strArr4.length);
        return strArr5;
    }

    public static String concatenateWhere(String str, String str2) {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        if (TextUtils.isEmpty(str3)) {
            return str4;
        }
        if (TextUtils.isEmpty(str4)) {
            return str3;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("(").append(str3).append(") AND (").append(str4).append(")").toString();
    }
}
