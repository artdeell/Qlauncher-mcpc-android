package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.TwoColumnOutput */
public final class TwoColumnOutput {
    private final StringBuffer leftBuf;
    private final IndentingWriter leftColumn;
    private final int leftWidth;
    private final Writer out;
    private final StringBuffer rightBuf;
    private final IndentingWriter rightColumn;

    public TwoColumnOutput(OutputStream outputStream, int i, int i2, String str) {
        OutputStreamWriter outputStreamWriter;
        int i3 = i;
        int i4 = i2;
        String str2 = str;
        OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
        OutputStreamWriter outputStreamWriter3 = new OutputStreamWriter(outputStream);
        this((Writer) outputStreamWriter2, i3, i4, str2);
    }

    public TwoColumnOutput(Writer writer, int i, int i2, String str) {
        StringWriter stringWriter;
        StringWriter stringWriter2;
        IndentingWriter indentingWriter;
        IndentingWriter indentingWriter2;
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        NullPointerException nullPointerException2;
        Writer writer2 = writer;
        int i3 = i;
        int i4 = i2;
        String str2 = str;
        if (writer2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("out == null");
            throw nullPointerException3;
        } else if (i3 < 1) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("leftWidth < 1");
            throw illegalArgumentException3;
        } else if (i4 < 1) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("rightWidth < 1");
            throw illegalArgumentException5;
        } else if (str2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("spacer == null");
            throw nullPointerException5;
        } else {
            StringWriter stringWriter3 = stringWriter;
            StringWriter stringWriter4 = new StringWriter(1000);
            StringWriter stringWriter5 = stringWriter3;
            StringWriter stringWriter6 = stringWriter2;
            StringWriter stringWriter7 = new StringWriter(1000);
            StringWriter stringWriter8 = stringWriter6;
            this.out = writer2;
            this.leftWidth = i3;
            this.leftBuf = stringWriter5.getBuffer();
            this.rightBuf = stringWriter8.getBuffer();
            IndentingWriter indentingWriter3 = indentingWriter;
            IndentingWriter indentingWriter4 = new IndentingWriter(stringWriter5, i3);
            this.leftColumn = indentingWriter3;
            IndentingWriter indentingWriter5 = indentingWriter2;
            IndentingWriter indentingWriter6 = new IndentingWriter(stringWriter8, i4, str2);
            this.rightColumn = indentingWriter5;
        }
    }

    private static void appendNewlineIfNecessary(StringBuffer stringBuffer, Writer writer) throws IOException {
        StringBuffer stringBuffer2 = stringBuffer;
        Writer writer2 = writer;
        int length = stringBuffer2.length();
        if (length != 0 && stringBuffer2.charAt(length - 1) != 10) {
            writer2.write(10);
        }
    }

    private void flushLeft() throws IOException {
        appendNewlineIfNecessary(this.leftBuf, this.leftColumn);
        while (this.leftBuf.length() != 0) {
            this.rightColumn.write(10);
            outputFullLines();
        }
    }

    private void flushRight() throws IOException {
        appendNewlineIfNecessary(this.rightBuf, this.rightColumn);
        while (this.rightBuf.length() != 0) {
            this.leftColumn.write(10);
            outputFullLines();
        }
    }

    private void outputFullLines() throws IOException {
        while (true) {
            int indexOf = this.leftBuf.indexOf("\n");
            if (indexOf >= 0) {
                int indexOf2 = this.rightBuf.indexOf("\n");
                if (indexOf2 >= 0) {
                    if (indexOf != 0) {
                        this.out.write(this.leftBuf.substring(0, indexOf));
                    }
                    if (indexOf2 != 0) {
                        writeSpaces(this.out, this.leftWidth - indexOf);
                        this.out.write(this.rightBuf.substring(0, indexOf2));
                    }
                    this.out.write(10);
                    StringBuffer delete = this.leftBuf.delete(0, indexOf + 1);
                    StringBuffer delete2 = this.rightBuf.delete(0, indexOf2 + 1);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public static String toString(String str, int i, String str2, String str3, int i2) {
        StringWriter stringWriter;
        TwoColumnOutput twoColumnOutput;
        RuntimeException runtimeException;
        String str4 = str;
        int i3 = i;
        String str5 = str2;
        String str6 = str3;
        int i4 = i2;
        StringWriter stringWriter2 = stringWriter;
        StringWriter stringWriter3 = new StringWriter(3 * (str4.length() + str6.length()));
        StringWriter stringWriter4 = stringWriter2;
        TwoColumnOutput twoColumnOutput2 = twoColumnOutput;
        TwoColumnOutput twoColumnOutput3 = new TwoColumnOutput((Writer) stringWriter4, i3, i4, str5);
        TwoColumnOutput twoColumnOutput4 = twoColumnOutput2;
        try {
            twoColumnOutput4.getLeft().write(str4);
            twoColumnOutput4.getRight().write(str6);
            twoColumnOutput4.flush();
            return stringWriter4.toString();
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("shouldn't happen", iOException);
            throw runtimeException2;
        }
    }

    private static void writeSpaces(Writer writer, int i) throws IOException {
        Writer writer2 = writer;
        for (int i2 = i; i2 > 0; i2--) {
            writer2.write(32);
        }
    }

    public void flush() {
        RuntimeException runtimeException;
        try {
            appendNewlineIfNecessary(this.leftBuf, this.leftColumn);
            appendNewlineIfNecessary(this.rightBuf, this.rightColumn);
            outputFullLines();
            flushLeft();
            flushRight();
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(iOException);
            throw runtimeException2;
        }
    }

    public Writer getLeft() {
        return this.leftColumn;
    }

    public Writer getRight() {
        return this.rightColumn;
    }
}
