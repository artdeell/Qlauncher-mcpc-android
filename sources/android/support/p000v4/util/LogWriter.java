package android.support.p000v4.util;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.util.LogWriter */
public class LogWriter extends Writer {
    private StringBuilder mBuilder;
    private final String mTag;

    public LogWriter(String str) {
        StringBuilder sb;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(128);
        this.mBuilder = sb2;
        this.mTag = str2;
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            int d = Log.d(this.mTag, this.mBuilder.toString());
            StringBuilder delete = this.mBuilder.delete(0, this.mBuilder.length());
        }
    }

    public void close() {
        flushBuilder();
    }

    public void flush() {
        flushBuilder();
    }

    public void write(char[] cArr, int i, int i2) {
        char[] cArr2 = cArr;
        int i3 = i;
        int i4 = i2;
        for (int i5 = 0; i5 < i4; i5++) {
            char c = cArr2[i3 + i5];
            if (c == 10) {
                flushBuilder();
            } else {
                StringBuilder append = this.mBuilder.append(c);
            }
        }
    }
}
