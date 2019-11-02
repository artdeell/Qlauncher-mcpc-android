package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.IndentingWriter */
public final class IndentingWriter extends FilterWriter {
    private boolean collectingIndent;
    private int column;
    private int indent;
    private final int maxIndent;
    private final String prefix;
    private final int width;

    public IndentingWriter(Writer writer, int i) {
        this(writer, i, LibrariesRepository.MOJANG_MAVEN_REPO);
    }

    public IndentingWriter(Writer writer, int i, String str) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException2;
        Writer writer2 = writer;
        int i2 = i;
        String str2 = str;
        super(writer2);
        if (writer2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("out == null");
            throw nullPointerException3;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("width < 0");
            throw illegalArgumentException2;
        } else if (str2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("prefix == null");
            throw nullPointerException5;
        } else {
            this.width = i2 != 0 ? i2 : Integer.MAX_VALUE;
            this.maxIndent = i2 >> 1;
            if (str2.length() == 0) {
                str2 = null;
            }
            this.prefix = str2;
            bol();
        }
    }

    private void bol() {
        this.column = 0;
        this.collectingIndent = this.maxIndent != 0;
        this.indent = 0;
    }

    /* JADX INFO: finally extract failed */
    public void write(int i) throws IOException {
        int i2 = i;
        Object obj = this.lock;
        synchronized (obj) {
            try {
                if (this.collectingIndent) {
                    if (i2 == 32) {
                        this.indent = 1 + this.indent;
                        if (this.indent >= this.maxIndent) {
                            this.indent = this.maxIndent;
                            this.collectingIndent = false;
                        }
                    } else {
                        this.collectingIndent = false;
                    }
                }
                if (this.column == this.width && i2 != 10) {
                    this.out.write(10);
                    this.column = 0;
                }
                if (this.column == 0) {
                    if (this.prefix != null) {
                        this.out.write(this.prefix);
                    }
                    if (!this.collectingIndent) {
                        for (int i3 = 0; i3 < this.indent; i3++) {
                            this.out.write(32);
                        }
                        this.column = this.indent;
                    }
                }
                this.out.write(i2);
                if (i2 == 10) {
                    bol();
                } else {
                    this.column = 1 + this.column;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void write(String str, int i, int i2) throws IOException {
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        Object obj = this.lock;
        synchronized (obj) {
            while (i4 > 0) {
                try {
                    write(str2.charAt(i3));
                    i3++;
                    i4--;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        char[] cArr2 = cArr;
        int i3 = i;
        int i4 = i2;
        Object obj = this.lock;
        synchronized (obj) {
            while (i4 > 0) {
                try {
                    write(cArr2[i3]);
                    i3++;
                    i4--;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }
}
