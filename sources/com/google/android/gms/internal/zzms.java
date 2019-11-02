package com.google.android.gms.internal;

import android.database.CharArrayBuffer;
import android.text.TextUtils;

public final class zzms {
    public static void zzb(String str, CharArrayBuffer charArrayBuffer) {
        String str2 = str;
        CharArrayBuffer charArrayBuffer2 = charArrayBuffer;
        if (TextUtils.isEmpty(str2)) {
            charArrayBuffer2.sizeCopied = 0;
        } else if (charArrayBuffer2.data == null || charArrayBuffer2.data.length < str2.length()) {
            charArrayBuffer2.data = str2.toCharArray();
        } else {
            str2.getChars(0, str2.length(), charArrayBuffer2.data, 0);
        }
        charArrayBuffer2.sizeCopied = str2.length();
    }
}
