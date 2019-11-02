package net.zhuoweizhang.boardwalk.com.android.p003dx.command.findusages;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.findusages.Main */
public final class Main {
    public Main() {
    }

    public static void main(String[] strArr) throws IOException {
        Dex dex;
        File file;
        PrintWriter printWriter;
        FindUsages findUsages;
        String[] strArr2 = strArr;
        String str = strArr2[0];
        String str2 = strArr2[1];
        String str3 = strArr2[2];
        Dex dex2 = dex;
        File file2 = file;
        File file3 = new File(str);
        Dex dex3 = new Dex(file2);
        Dex dex4 = dex2;
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(System.out);
        PrintWriter printWriter4 = printWriter2;
        FindUsages findUsages2 = findUsages;
        FindUsages findUsages3 = new FindUsages(dex4, str2, str3, printWriter4);
        findUsages2.findUsages();
        printWriter4.flush();
    }
}
