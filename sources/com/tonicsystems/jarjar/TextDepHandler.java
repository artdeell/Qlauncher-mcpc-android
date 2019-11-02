package com.tonicsystems.jarjar;

import java.io.IOException;
import java.io.PrintWriter;

public class TextDepHandler extends AbstractDepHandler {

    /* renamed from: w */
    private PrintWriter f19w;

    public TextDepHandler(PrintWriter printWriter, int i) {
        PrintWriter printWriter2 = printWriter;
        super(i);
        this.f19w = printWriter2;
    }

    /* access modifiers changed from: protected */
    public void handle(String str, String str2) throws IOException {
        StringBuilder sb;
        String str3 = str;
        String str4 = str2;
        PrintWriter printWriter = this.f19w;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printWriter.println(sb2.append(str3).append(" -> ").append(str4).toString());
    }
}
