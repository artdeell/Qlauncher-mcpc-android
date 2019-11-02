package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS = ((String[]) REPLACEMENT_CHARS.clone());
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        REPLACEMENT_CHARS[34] = "\\\"";
        REPLACEMENT_CHARS[92] = "\\\\";
        REPLACEMENT_CHARS[9] = "\\t";
        REPLACEMENT_CHARS[8] = "\\b";
        REPLACEMENT_CHARS[10] = "\\n";
        REPLACEMENT_CHARS[13] = "\\r";
        REPLACEMENT_CHARS[12] = "\\f";
        HTML_SAFE_REPLACEMENT_CHARS[60] = "\\u003c";
        HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
        HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
        HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
        HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        NullPointerException nullPointerException;
        Writer writer2 = writer;
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("out == null");
            throw nullPointerException2;
        }
        this.out = writer2;
    }

    private void beforeName() throws IOException {
        IllegalStateException illegalStateException;
        int peek = peek();
        if (peek == 5) {
            this.out.write(44);
        } else if (peek != 3) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Nesting problem.");
            throw illegalStateException2;
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue(boolean z) throws IOException {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        IllegalStateException illegalStateException3;
        boolean z2 = z;
        switch (peek()) {
            case 1:
                replaceTop(2);
                newline();
                return;
            case 2:
                Writer append = this.out.append(',');
                newline();
                return;
            case 4:
                Writer append2 = this.out.append(this.separator);
                replaceTop(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.lenient) {
                    IllegalStateException illegalStateException4 = illegalStateException2;
                    IllegalStateException illegalStateException5 = new IllegalStateException("JSON must have only one top-level value.");
                    throw illegalStateException4;
                }
                break;
            default:
                IllegalStateException illegalStateException6 = illegalStateException3;
                IllegalStateException illegalStateException7 = new IllegalStateException("Nesting problem.");
                throw illegalStateException6;
        }
        if (this.lenient || z2) {
            replaceTop(7);
            return;
        }
        IllegalStateException illegalStateException8 = illegalStateException;
        IllegalStateException illegalStateException9 = new IllegalStateException("JSON must start with an array or an object.");
        throw illegalStateException8;
    }

    private JsonWriter close(int i, int i2, String str) throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        int i3 = i;
        int i4 = i2;
        String str2 = str;
        int peek = peek();
        if (peek != i4 && peek != i3) {
            IllegalStateException illegalStateException3 = illegalStateException2;
            IllegalStateException illegalStateException4 = new IllegalStateException("Nesting problem.");
            throw illegalStateException3;
        } else if (this.deferredName != null) {
            IllegalStateException illegalStateException5 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException6 = new IllegalStateException(sb2.append("Dangling name: ").append(this.deferredName).toString());
            throw illegalStateException5;
        } else {
            this.stackSize = -1 + this.stackSize;
            if (peek == i4) {
                newline();
            }
            this.out.write(str2);
            return this;
        }
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.out.write("\n");
            int i = this.stackSize;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.indent);
            }
        }
    }

    private JsonWriter open(int i, String str) throws IOException {
        int i2 = i;
        String str2 = str;
        beforeValue(true);
        push(i2);
        this.out.write(str2);
        return this;
    }

    private int peek() {
        IllegalStateException illegalStateException;
        if (this.stackSize != 0) {
            return this.stack[-1 + this.stackSize];
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("JsonWriter is closed.");
        throw illegalStateException2;
    }

    private void push(int i) {
        int i2 = i;
        if (this.stackSize == this.stack.length) {
            int[] iArr = new int[(2 * this.stackSize)];
            System.arraycopy(this.stack, 0, iArr, 0, this.stackSize);
            this.stack = iArr;
        }
        int[] iArr2 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        iArr2[i3] = i2;
    }

    private void replaceTop(int i) {
        this.stack[-1 + this.stackSize] = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void string(java.lang.String r14) throws java.io.IOException {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r8 = r0
            boolean r8 = r8.htmlSafe
            if (r8 == 0) goto L_0x0037
            java.lang.String[] r8 = HTML_SAFE_REPLACEMENT_CHARS
            r2 = r8
        L_0x000a:
            r8 = r0
            java.io.Writer r8 = r8.out
            java.lang.String r9 = "\""
            r8.write(r9)
            r8 = 0
            r3 = r8
            r8 = r1
            int r8 = r8.length()
            r4 = r8
            r8 = 0
            r5 = r8
        L_0x001c:
            r8 = r5
            r9 = r4
            if (r8 >= r9) goto L_0x0068
            r8 = r1
            r9 = r5
            char r8 = r8.charAt(r9)
            r6 = r8
            r8 = r6
            r9 = 128(0x80, float:1.794E-43)
            if (r8 >= r9) goto L_0x003b
            r8 = r2
            r9 = r6
            r8 = r8[r9]
            r7 = r8
            r8 = r7
            if (r8 != 0) goto L_0x0043
        L_0x0034:
            int r5 = r5 + 1
            goto L_0x001c
        L_0x0037:
            java.lang.String[] r8 = REPLACEMENT_CHARS
            r2 = r8
            goto L_0x000a
        L_0x003b:
            r8 = r6
            r9 = 8232(0x2028, float:1.1535E-41)
            if (r8 != r9) goto L_0x005f
            java.lang.String r8 = "\\u2028"
            r7 = r8
        L_0x0043:
            r8 = r3
            r9 = r5
            if (r8 >= r9) goto L_0x0052
            r8 = r0
            java.io.Writer r8 = r8.out
            r9 = r1
            r10 = r3
            r11 = r5
            r12 = r3
            int r11 = r11 - r12
            r8.write(r9, r10, r11)
        L_0x0052:
            r8 = r0
            java.io.Writer r8 = r8.out
            r9 = r7
            r8.write(r9)
            r8 = r5
            r9 = 1
            int r8 = r8 + 1
            r3 = r8
            goto L_0x0034
        L_0x005f:
            r8 = r6
            r9 = 8233(0x2029, float:1.1537E-41)
            if (r8 != r9) goto L_0x0034
            java.lang.String r8 = "\\u2029"
            r7 = r8
            goto L_0x0043
        L_0x0068:
            r8 = r3
            r9 = r4
            if (r8 >= r9) goto L_0x0077
            r8 = r0
            java.io.Writer r8 = r8.out
            r9 = r1
            r10 = r3
            r11 = r4
            r12 = r3
            int r11 = r11 - r12
            r8.write(r9, r10, r11)
        L_0x0077:
            r8 = r0
            java.io.Writer r8 = r8.out
            java.lang.String r9 = "\""
            r8.write(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.string(java.lang.String):void");
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, "[");
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, "{");
    }

    public void close() throws IOException {
        IOException iOException;
        this.out.close();
        int i = this.stackSize;
        if (i > 1 || (i == 1 && this.stack[i - 1] != 7)) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException("Incomplete document");
            throw iOException2;
        }
        this.stackSize = 0;
    }

    public JsonWriter endArray() throws IOException {
        return close(1, 2, "]");
    }

    public JsonWriter endObject() throws IOException {
        return close(3, 5, "}");
    }

    public void flush() throws IOException {
        IllegalStateException illegalStateException;
        if (this.stackSize == 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("JsonWriter is closed.");
            throw illegalStateException2;
        }
        this.out.flush();
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter name(String str) throws IOException {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        NullPointerException nullPointerException;
        String str2 = str;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("name == null");
            throw nullPointerException2;
        } else if (this.deferredName != null) {
            IllegalStateException illegalStateException3 = illegalStateException2;
            IllegalStateException illegalStateException4 = new IllegalStateException();
            throw illegalStateException3;
        } else if (this.stackSize == 0) {
            IllegalStateException illegalStateException5 = illegalStateException;
            IllegalStateException illegalStateException6 = new IllegalStateException("JsonWriter is closed.");
            throw illegalStateException5;
        } else {
            this.deferredName = str2;
            return this;
        }
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue(false);
        this.out.write("null");
        return this;
    }

    public final void setHtmlSafe(boolean z) {
        boolean z2 = z;
        this.htmlSafe = z2;
    }

    public final void setIndent(String str) {
        String str2 = str;
        if (str2.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str2;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        boolean z2 = z;
        this.lenient = z2;
    }

    public final void setSerializeNulls(boolean z) {
        boolean z2 = z;
        this.serializeNulls = z2;
    }

    public JsonWriter value(double d) throws IOException {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        double d2 = d;
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Numeric values must be finite, but was ").append(d2).toString());
            throw illegalArgumentException2;
        }
        writeDeferredName();
        beforeValue(false);
        Writer append = this.out.append(Double.toString(d2));
        return this;
    }

    public JsonWriter value(long j) throws IOException {
        long j2 = j;
        writeDeferredName();
        beforeValue(false);
        this.out.write(Long.toString(j2));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Number number2 = number;
        if (number2 == null) {
            return nullValue();
        }
        writeDeferredName();
        String obj = number2.toString();
        if (this.lenient || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            beforeValue(false);
            Writer append = this.out.append(obj);
            return this;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Numeric values must be finite, but was ").append(number2).toString());
        throw illegalArgumentException2;
    }

    public JsonWriter value(String str) throws IOException {
        String str2 = str;
        if (str2 == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue(false);
        string(str2);
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        boolean z2 = z;
        writeDeferredName();
        beforeValue(false);
        this.out.write(z2 ? "true" : "false");
        return this;
    }
}
