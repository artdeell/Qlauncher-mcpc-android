package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.io.PrintWriter;
import java.io.Writer;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.Writers */
public final class Writers {
    private Writers() {
    }

    public static PrintWriter printWriterFor(Writer writer) {
        PrintWriter printWriter;
        Writer writer2 = writer;
        if (writer2 instanceof PrintWriter) {
            return (PrintWriter) writer2;
        }
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(writer2);
        return printWriter2;
    }
}
