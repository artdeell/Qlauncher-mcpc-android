package net.zhuoweizhang.boardwalk.com.android.p003dx.command.dump;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ConcreteMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Member;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IndentingWriter;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.TwoColumnOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dump.BaseDumper */
public abstract class BaseDumper implements ParseObserver {
    protected Args args;

    /* renamed from: at */
    private int f166at;
    private final byte[] bytes;
    private final String filePath;
    private final int hexCols;
    private int indent;
    private final PrintStream out;
    private final boolean rawBytes;
    private String separator;
    private final boolean strictParse;
    private final int width;

    public BaseDumper(byte[] bArr, PrintStream printStream, String str, Args args2) {
        PrintStream printStream2 = printStream;
        String str2 = str;
        Args args3 = args2;
        this.bytes = bArr;
        this.rawBytes = args3.rawBytes;
        this.out = printStream2;
        this.width = args3.width <= 0 ? 79 : args3.width;
        this.filePath = str2;
        this.strictParse = args3.strictParse;
        this.indent = 0;
        this.separator = this.rawBytes ? "|" : LibrariesRepository.MOJANG_MAVEN_REPO;
        this.f166at = 0;
        this.args = args3;
        int i = -2 & (1 + ((-5 + this.width) / 15));
        if (i < 6) {
            i = 6;
        } else if (i > 10) {
            i = 10;
        }
        this.hexCols = i;
    }

    static int computeParamWidth(ConcreteMethod concreteMethod, boolean z) {
        boolean z2 = z;
        return concreteMethod.getEffectiveDescriptor().getParameterTypes().getWordCount();
    }

    public void changeIndent(int i) {
        StringBuilder sb;
        this.indent = i + this.indent;
        this.separator = this.rawBytes ? "|" : LibrariesRepository.MOJANG_MAVEN_REPO;
        for (int i2 = 0; i2 < this.indent; i2++) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            this.separator = sb2.append(this.separator).append("  ").toString();
        }
    }

    public void endParsingMember(ByteArray byteArray, int i, String str, String str2, Member member) {
    }

    /* access modifiers changed from: protected */
    public final int getAt() {
        return this.f166at;
    }

    /* access modifiers changed from: protected */
    public final byte[] getBytes() {
        return this.bytes;
    }

    /* access modifiers changed from: protected */
    public final String getFilePath() {
        return this.filePath;
    }

    /* access modifiers changed from: protected */
    public final boolean getRawBytes() {
        return this.rawBytes;
    }

    /* access modifiers changed from: protected */
    public final boolean getStrictParse() {
        return this.strictParse;
    }

    /* access modifiers changed from: protected */
    public final int getWidth1() {
        if (this.rawBytes) {
            return 5 + (2 * this.hexCols) + (this.hexCols / 2);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public final int getWidth2() {
        return (this.width - (this.rawBytes ? 1 + getWidth1() : 0)) - (2 * this.indent);
    }

    /* access modifiers changed from: protected */
    public final String hexDump(int i, int i2) {
        int i3 = i;
        return Hex.dump(this.bytes, i3, i2, i3, this.hexCols, 4);
    }

    public void parsed(ByteArray byteArray, int i, int i2, String str) {
        StringBuilder sb;
        StringBuilder sb2;
        int i3 = i2;
        String str2 = str;
        int underlyingOffset = byteArray.underlyingOffset(i, getBytes());
        boolean rawBytes2 = getRawBytes();
        if (underlyingOffset < this.f166at) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            println(sb3.append("<dump skipped backwards to ").append(Hex.m53u4(underlyingOffset)).append(">").toString());
            this.f166at = underlyingOffset;
        } else if (underlyingOffset > this.f166at) {
            String hexDump = rawBytes2 ? hexDump(this.f166at, underlyingOffset - this.f166at) : LibrariesRepository.MOJANG_MAVEN_REPO;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            print(twoColumns(hexDump, sb5.append("<skipped to ").append(Hex.m53u4(underlyingOffset)).append(">").toString()));
            this.f166at = underlyingOffset;
        }
        print(twoColumns(rawBytes2 ? hexDump(underlyingOffset, i3) : LibrariesRepository.MOJANG_MAVEN_REPO, str2));
        this.f166at = i3 + this.f166at;
    }

    /* access modifiers changed from: protected */
    public final void print(String str) {
        String str2 = str;
        this.out.print(str2);
    }

    /* access modifiers changed from: protected */
    public final void println(String str) {
        String str2 = str;
        this.out.println(str2);
    }

    /* access modifiers changed from: protected */
    public final void setAt(ByteArray byteArray, int i) {
        this.f166at = byteArray.underlyingOffset(i, this.bytes);
    }

    public void startParsingMember(ByteArray byteArray, int i, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public final String twoColumns(String str, String str2) {
        RuntimeException runtimeException;
        StringWriter stringWriter;
        IndentingWriter indentingWriter;
        String str3 = str;
        String str4 = str2;
        int width1 = getWidth1();
        int width2 = getWidth2();
        if (width1 != 0) {
            return TwoColumnOutput.toString(str3, width1, this.separator, str4, width2);
        }
        try {
            int length = str4.length();
            StringWriter stringWriter2 = stringWriter;
            StringWriter stringWriter3 = new StringWriter(length * 2);
            StringWriter stringWriter4 = stringWriter2;
            IndentingWriter indentingWriter2 = indentingWriter;
            IndentingWriter indentingWriter3 = new IndentingWriter(stringWriter4, width2, this.separator);
            IndentingWriter indentingWriter4 = indentingWriter2;
            indentingWriter4.write(str4);
            if (length == 0 || str4.charAt(length - 1) != 10) {
                indentingWriter4.write(10);
            }
            indentingWriter4.flush();
            return stringWriter4.toString();
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(iOException);
            throw runtimeException2;
        }
    }
}
