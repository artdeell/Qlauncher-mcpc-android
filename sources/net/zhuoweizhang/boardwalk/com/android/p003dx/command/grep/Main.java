package net.zhuoweizhang.boardwalk.com.android.p003dx.command.grep;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.grep.Main */
public final class Main {
    public Main() {
    }

    public static void main(String[] strArr) throws IOException {
        Grep grep;
        Dex dex;
        File file;
        PrintWriter printWriter;
        String[] strArr2 = strArr;
        String str = strArr2[0];
        String str2 = strArr2[1];
        Grep grep2 = grep;
        Dex dex2 = dex;
        File file2 = file;
        File file3 = new File(str);
        Dex dex3 = new Dex(file2);
        Pattern compile = Pattern.compile(str2);
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(System.out);
        Grep grep3 = new Grep(dex2, compile, printWriter2);
        int i = 0;
        if (grep2.grep() <= 0) {
            i = 1;
        }
        System.exit(i);
    }
}
