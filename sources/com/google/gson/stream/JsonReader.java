package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];

    /* renamed from: in */
    private final Reader f13in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    /* access modifiers changed from: private */
    public int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        C05331 r2;
        C05331 r0 = r2;
        C05331 r1 = new JsonReaderInternalAccess() {
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                IllegalStateException illegalStateException;
                StringBuilder sb;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2 instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader2).promoteNameToValue();
                    return;
                }
                int access$000 = jsonReader2.peeked;
                if (access$000 == 0) {
                    access$000 = jsonReader2.doPeek();
                }
                if (access$000 == 13) {
                    int access$002 = JsonReader.access$002(jsonReader2, 9);
                } else if (access$000 == 12) {
                    int access$0022 = JsonReader.access$002(jsonReader2, 8);
                } else if (access$000 == 14) {
                    int access$0023 = JsonReader.access$002(jsonReader2, 10);
                } else {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected a name but was ").append(jsonReader2.peek()).append(" ").append(" at line ").append(jsonReader2.getLineNumber()).append(" column ").append(jsonReader2.getColumnNumber()).toString());
                    throw illegalStateException2;
                }
            }
        };
        JsonReaderInternalAccess.INSTANCE = r0;
    }

    public JsonReader(Reader reader) {
        NullPointerException nullPointerException;
        Reader reader2 = reader;
        int[] iArr = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        iArr[i] = 6;
        if (reader2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("in == null");
            throw nullPointerException2;
        }
        this.f13in = reader2;
    }

    static /* synthetic */ int access$002(JsonReader jsonReader, int i) {
        int i2 = i;
        jsonReader.peeked = i2;
        return i2;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        int nextNonWhitespace = nextNonWhitespace(true);
        this.pos = -1 + this.pos;
        if (this.pos + NON_EXECUTE_PREFIX.length <= this.limit || fillBuffer(NON_EXECUTE_PREFIX.length)) {
            int i = 0;
            while (i < NON_EXECUTE_PREFIX.length) {
                if (this.buffer[i + this.pos] == NON_EXECUTE_PREFIX[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += NON_EXECUTE_PREFIX.length;
        }
    }

    /* access modifiers changed from: private */
    public int doPeek() throws IOException {
        IllegalStateException illegalStateException;
        int i = this.stack[-1 + this.stackSize];
        if (i == 1) {
            this.stack[-1 + this.stackSize] = 2;
        } else if (i == 2) {
            switch (nextNonWhitespace(true)) {
                case 44:
                    break;
                case 59:
                    checkLenient();
                    break;
                case 93:
                    this.peeked = 4;
                    return 4;
                default:
                    throw syntaxError("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.stack[-1 + this.stackSize] = 4;
            if (i == 5) {
                switch (nextNonWhitespace(true)) {
                    case 44:
                        break;
                    case 59:
                        checkLenient();
                        break;
                    case 125:
                        this.peeked = 2;
                        return 2;
                    default:
                        throw syntaxError("Unterminated object");
                }
            }
            int nextNonWhitespace = nextNonWhitespace(true);
            switch (nextNonWhitespace) {
                case 34:
                    this.peeked = 13;
                    return 13;
                case 39:
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.peeked = 2;
                        return 2;
                    }
                    throw syntaxError("Expected name");
                default:
                    checkLenient();
                    this.pos = -1 + this.pos;
                    if (isLiteral((char) nextNonWhitespace)) {
                        this.peeked = 14;
                        return 14;
                    }
                    throw syntaxError("Expected name");
            }
        } else if (i == 4) {
            this.stack[-1 + this.stackSize] = 5;
            switch (nextNonWhitespace(true)) {
                case 58:
                    break;
                case 61:
                    checkLenient();
                    if ((this.pos < this.limit || fillBuffer(1)) && this.buffer[this.pos] == '>') {
                        this.pos = 1 + this.pos;
                        break;
                    }
                default:
                    throw syntaxError("Expected ':'");
            }
        } else if (i == 6) {
            if (this.lenient) {
                consumeNonExecutePrefix();
            }
            this.stack[-1 + this.stackSize] = 7;
        } else if (i == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 17;
                return 17;
            }
            checkLenient();
            this.pos = -1 + this.pos;
        } else if (i == 8) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("JsonReader is closed");
            throw illegalStateException2;
        }
        switch (nextNonWhitespace(true)) {
            case 34:
                if (this.stackSize == 1) {
                    checkLenient();
                }
                this.peeked = 9;
                return 9;
            case 39:
                checkLenient();
                this.peeked = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.peeked = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.peeked = 4;
                    return 4;
                }
                break;
            case 123:
                this.peeked = 1;
                return 1;
            default:
                this.pos = -1 + this.pos;
                if (this.stackSize == 1) {
                    checkLenient();
                }
                int peekKeyword = peekKeyword();
                if (peekKeyword == 0) {
                    peekKeyword = peekNumber();
                    if (peekKeyword == 0) {
                        if (!isLiteral(this.buffer[this.pos])) {
                            throw syntaxError("Expected value");
                        }
                        checkLenient();
                        this.peeked = 10;
                        return 10;
                    }
                }
                return peekKeyword;
        }
        if (i == 1 || i == 2) {
            checkLenient();
            this.pos = -1 + this.pos;
            this.peeked = 7;
            return 7;
        }
        throw syntaxError("Unexpected value");
    }

    private boolean fillBuffer(int i) throws IOException {
        boolean z;
        int i2 = i;
        char[] cArr = this.buffer;
        this.lineStart -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        while (true) {
            int read = this.f13in.read(cArr, this.limit, cArr.length - this.limit);
            z = false;
            if (read == -1) {
                break;
            }
            this.limit = read + this.limit;
            if (this.lineNumber == 0 && this.lineStart == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos = 1 + this.pos;
                this.lineStart = 1 + this.lineStart;
                i2++;
            }
            if (this.limit >= i2) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public int getColumnNumber() {
        return 1 + (this.pos - this.lineStart);
    }

    /* access modifiers changed from: private */
    public int getLineNumber() {
        return 1 + this.lineNumber;
    }

    private boolean isLiteral(char c) throws IOException {
        switch (c) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                checkLenient();
                break;
            default:
                return true;
        }
        return false;
    }

    private int nextNonWhitespace(boolean z) throws IOException {
        EOFException eOFException;
        StringBuilder sb;
        boolean z2 = z;
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (fillBuffer(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z2) {
                    return -1;
                } else {
                    EOFException eOFException2 = eOFException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    EOFException eOFException3 = new EOFException(sb2.append("End of input at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
                    throw eOFException2;
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.lineNumber = 1 + this.lineNumber;
                this.lineStart = i3;
                i = i3;
            } else if (c == ' ' || c == 13) {
                i = i3;
            } else if (c == 9) {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos = -1 + this.pos;
                    boolean fillBuffer = fillBuffer(2);
                    this.pos = 1 + this.pos;
                    if (!fillBuffer) {
                        return c;
                    }
                }
                checkLenient();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos = 1 + this.pos;
                        if (skipTo("*/")) {
                            i = 2 + this.pos;
                            i2 = this.limit;
                            break;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    case '/':
                        this.pos = 1 + this.pos;
                        skipToEndOfLine();
                        i = this.pos;
                        i2 = this.limit;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                checkLenient();
                skipToEndOfLine();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private String nextQuotedValue(char c) throws IOException {
        StringBuilder sb;
        char c2 = c;
        char[] cArr = this.buffer;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            int i4 = i;
            while (true) {
                int i5 = i4;
                if (i5 < i2) {
                    int i6 = i5 + 1;
                    char c3 = cArr[i5];
                    if (c3 == c2) {
                        this.pos = i6;
                        StringBuilder append = sb4.append(cArr, i3, -1 + (i6 - i3));
                        return sb4.toString();
                    }
                    if (c3 == '\\') {
                        this.pos = i6;
                        StringBuilder append2 = sb4.append(cArr, i3, -1 + (i6 - i3));
                        StringBuilder append3 = sb4.append(readEscapeCharacter());
                        i6 = this.pos;
                        i2 = this.limit;
                        i3 = i6;
                    } else if (c3 == 10) {
                        this.lineNumber = 1 + this.lineNumber;
                        this.lineStart = i6;
                    }
                    i4 = i6;
                } else {
                    StringBuilder append4 = sb4.append(cArr, i3, i5 - i3);
                    this.pos = i5;
                }
            }
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private String nextUnquotedValue() throws IOException {
        StringBuilder sb;
        String sb2;
        String str;
        StringBuilder sb3 = null;
        int i = 0;
        while (true) {
            if (i + this.pos < this.limit) {
                switch (this.buffer[i + this.pos]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        checkLenient();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.buffer.length) {
                if (sb3 == null) {
                    StringBuilder sb4 = sb;
                    StringBuilder sb5 = new StringBuilder();
                    sb3 = sb4;
                }
                StringBuilder append = sb3.append(this.buffer, this.pos, i);
                this.pos = i + this.pos;
                i = 0;
                if (!fillBuffer(1)) {
                    i = 0;
                }
            } else if (fillBuffer(i + 1)) {
            }
        }
        if (sb3 == null) {
            String str2 = str;
            String str3 = new String(this.buffer, this.pos, i);
            sb2 = str2;
        } else {
            StringBuilder append2 = sb3.append(this.buffer, this.pos, i);
            sb2 = sb3.toString();
        }
        this.pos = i + this.pos;
        return sb2;
    }

    private int peekKeyword() throws IOException {
        int i;
        String str;
        String str2;
        char c = this.buffer[this.pos];
        if (c == 't' || c == 'T') {
            str2 = "true";
            str = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str2 = "false";
            str = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i = 7;
        }
        int length = str2.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (i2 + this.pos >= this.limit && !fillBuffer(i2 + 1)) {
                return 0;
            }
            char c2 = this.buffer[i2 + this.pos];
            if (c2 != str2.charAt(i2) && c2 != str.charAt(i2)) {
                return 0;
            }
        }
        if ((length + this.pos < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[length + this.pos])) {
            return 0;
        }
        this.pos = length + this.pos;
        this.peeked = i;
        return i;
    }

    private int peekNumber() throws IOException {
        char c;
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        long j = 0;
        boolean z = false;
        boolean z2 = true;
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i + i3 == i2) {
                if (i3 == cArr.length) {
                    return 0;
                }
                if (fillBuffer(i3 + 1)) {
                    i = this.pos;
                    i2 = this.limit;
                }
            }
            c = cArr[i + i3];
            switch (c) {
                case '+':
                    if (!z3) {
                        return 0;
                    }
                    z3 = true;
                    continue;
                case '-':
                    if (!z3) {
                        z = true;
                        z3 = true;
                        continue;
                    } else if (z3) {
                        z3 = true;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (!z3) {
                        return 0;
                    }
                    z3 = true;
                    continue;
                case 'E':
                case 'e':
                    if (!z3 && !z3) {
                        return 0;
                    }
                    z3 = true;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (!z3 && z3) {
                            if (!z3) {
                                if (!z3) {
                                    if (!z3 && !z3) {
                                        break;
                                    } else {
                                        z3 = true;
                                        break;
                                    }
                                } else {
                                    z3 = true;
                                    break;
                                }
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - '0'));
                                z2 &= j > MIN_INCOMPLETE_INTEGER || (j == MIN_INCOMPLETE_INTEGER && j2 < j);
                                j = j2;
                                break;
                            } else {
                                return 0;
                            }
                        } else {
                            j = (long) (-(c - '0'));
                            z3 = true;
                            continue;
                        }
                    } else {
                        break;
                    }
                    break;
            }
            i3++;
        }
        if (isLiteral(c)) {
            return 0;
        }
        if (z3 && z2 && (j != Long.MIN_VALUE || z)) {
            if (!z) {
                j = -j;
            }
            this.peekedLong = j;
            this.pos = i3 + this.pos;
            this.peeked = 15;
            return 15;
        } else if (!z3 && !z3 && !z3) {
            return 0;
        } else {
            this.peekedNumberLength = i3;
            this.peeked = 16;
            return 16;
        }
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

    private char readEscapeCharacter() throws IOException {
        NumberFormatException numberFormatException;
        StringBuilder sb;
        String str;
        char c;
        int i;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char c2 = cArr[i2];
            switch (c2) {
                case 10:
                    this.lineNumber = 1 + this.lineNumber;
                    this.lineStart = this.pos;
                    break;
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (4 + this.pos <= this.limit || fillBuffer(4)) {
                        char c3 = 0;
                        int i3 = this.pos;
                        int i4 = i3 + 4;
                        while (i3 < i4) {
                            char c4 = this.buffer[i3];
                            char c5 = (char) (c3 << 4);
                            if (c4 >= '0' && c4 <= '9') {
                                c = c5;
                                i = c4 - '0';
                            } else if (c4 >= 'a' && c4 <= 'f') {
                                c = c5;
                                i = 10 + (c4 - 'a');
                            } else if (c4 < 'A' || c4 > 'F') {
                                NumberFormatException numberFormatException2 = numberFormatException;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                StringBuilder append = sb2.append("\\u");
                                String str2 = str;
                                String str3 = new String(this.buffer, this.pos, 4);
                                NumberFormatException numberFormatException3 = new NumberFormatException(append.append(str2).toString());
                                throw numberFormatException2;
                            } else {
                                c = c5;
                                i = 10 + (c4 - 'A');
                            }
                            c3 = (char) (c + i);
                            i3++;
                        }
                        this.pos = 4 + this.pos;
                        return c3;
                    }
                    throw syntaxError("Unterminated escape sequence");
            }
            return c2;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c) throws IOException {
        char c2 = c;
        char[] cArr = this.buffer;
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (true) {
                int i4 = i3;
                if (i4 < i2) {
                    int i5 = i4 + 1;
                    char c3 = cArr[i4];
                    if (c3 == c2) {
                        this.pos = i5;
                        return;
                    }
                    if (c3 == '\\') {
                        this.pos = i5;
                        char readEscapeCharacter = readEscapeCharacter();
                        i5 = this.pos;
                        i2 = this.limit;
                    } else if (c3 == 10) {
                        this.lineNumber = 1 + this.lineNumber;
                        this.lineStart = i5;
                    }
                    i3 = i5;
                } else {
                    this.pos = i4;
                }
            }
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) throws IOException {
        String str2 = str;
        while (true) {
            if (this.pos + str2.length() > this.limit && !fillBuffer(str2.length())) {
                return false;
            }
            if (this.buffer[this.pos] == 10) {
                this.lineNumber = 1 + this.lineNumber;
                this.lineStart = 1 + this.pos;
            } else {
                int i = 0;
                while (i < str2.length()) {
                    if (this.buffer[i + this.pos] == str2.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos = 1 + this.pos;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.lineNumber = 1 + this.lineNumber;
                    this.lineStart = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    private void skipUnquotedValue() throws IOException {
        do {
            int i = 0;
            while (i + this.pos < this.limit) {
                switch (this.buffer[i + this.pos]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        checkLenient();
                        break;
                    default:
                        i++;
                }
                this.pos = i + this.pos;
                return;
            }
            this.pos = i + this.pos;
        } while (fillBuffer(1));
    }

    private IOException syntaxError(String str) throws IOException {
        MalformedJsonException malformedJsonException;
        StringBuilder sb;
        String str2 = str;
        MalformedJsonException malformedJsonException2 = malformedJsonException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        MalformedJsonException malformedJsonException3 = new MalformedJsonException(sb2.append(str2).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
        throw malformedJsonException2;
    }

    public void beginArray() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            push(1);
            this.peeked = 0;
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected BEGIN_ARRAY but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
        throw illegalStateException2;
    }

    public void beginObject() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected BEGIN_OBJECT but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
        throw illegalStateException2;
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f13in.close();
    }

    public void endArray() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 4) {
            this.stackSize = -1 + this.stackSize;
            this.peeked = 0;
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected END_ARRAY but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
        throw illegalStateException2;
    }

    public void endObject() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2) {
            this.stackSize = -1 + this.stackSize;
            this.peeked = 0;
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected END_OBJECT but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
        throw illegalStateException2;
    }

    public boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public boolean nextBoolean() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            return true;
        } else if (i == 6) {
            this.peeked = 0;
            return false;
        } else {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected a boolean but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
            throw illegalStateException2;
        }
    }

    public double nextDouble() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        MalformedJsonException malformedJsonException;
        StringBuilder sb2;
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            return (double) this.peekedLong;
        }
        if (i == 16) {
            String str2 = str;
            String str3 = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.peekedString = str2;
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9) {
            this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i != 11) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb3.append("Expected a double but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
            throw illegalStateException2;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            return parseDouble;
        }
        MalformedJsonException malformedJsonException2 = malformedJsonException;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        MalformedJsonException malformedJsonException3 = new MalformedJsonException(sb5.append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
        throw malformedJsonException2;
    }

    public int nextInt() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        NumberFormatException numberFormatException;
        StringBuilder sb2;
        String str;
        NumberFormatException numberFormatException2;
        StringBuilder sb3;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            int i2 = (int) this.peekedLong;
            if (this.peekedLong != ((long) i2)) {
                NumberFormatException numberFormatException3 = numberFormatException2;
                StringBuilder sb4 = sb3;
                StringBuilder sb5 = new StringBuilder();
                NumberFormatException numberFormatException4 = new NumberFormatException(sb4.append("Expected an int but was ").append(this.peekedLong).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
                throw numberFormatException3;
            }
            this.peeked = 0;
            return i2;
        }
        if (i == 16) {
            String str2 = str;
            String str3 = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.peekedString = str2;
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9) {
            this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                return parseInt;
            } catch (NumberFormatException e) {
                NumberFormatException numberFormatException5 = e;
            }
        } else {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb6.append("Expected an int but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
            throw illegalStateException2;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i3 = (int) parseDouble;
        if (((double) i3) != parseDouble) {
            NumberFormatException numberFormatException6 = numberFormatException;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            NumberFormatException numberFormatException7 = new NumberFormatException(sb8.append("Expected an int but was ").append(this.peekedString).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
            throw numberFormatException6;
        }
        this.peekedString = null;
        this.peeked = 0;
        return i3;
    }

    public long nextLong() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        NumberFormatException numberFormatException;
        StringBuilder sb2;
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            return this.peekedLong;
        }
        if (i == 16) {
            String str2 = str;
            String str3 = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.peekedString = str2;
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9) {
            this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                return parseLong;
            } catch (NumberFormatException e) {
                NumberFormatException numberFormatException2 = e;
            }
        } else {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb3.append("Expected a long but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
            throw illegalStateException2;
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j = (long) parseDouble;
        if (((double) j) != parseDouble) {
            NumberFormatException numberFormatException3 = numberFormatException;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            NumberFormatException numberFormatException4 = new NumberFormatException(sb5.append("Expected a long but was ").append(this.peekedString).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
            throw numberFormatException3;
        }
        this.peekedString = null;
        this.peeked = 0;
        return j;
    }

    public String nextName() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else if (i == 12) {
            nextQuotedValue = nextQuotedValue('\'');
        } else if (i == 13) {
            nextQuotedValue = nextQuotedValue('\"');
        } else {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected a name but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
            throw illegalStateException2;
        }
        this.peeked = 0;
        return nextQuotedValue;
    }

    public void nextNull() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 7) {
            this.peeked = 0;
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected null but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
        throw illegalStateException2;
    }

    public String nextString() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        String str;
        String str2;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            str2 = nextUnquotedValue();
        } else if (i == 8) {
            str2 = nextQuotedValue('\'');
        } else if (i == 9) {
            str2 = nextQuotedValue('\"');
        } else if (i == 11) {
            str2 = this.peekedString;
            this.peekedString = null;
        } else if (i == 15) {
            str2 = Long.toString(this.peekedLong);
        } else if (i == 16) {
            String str3 = str;
            String str4 = new String(this.buffer, this.pos, this.peekedNumberLength);
            str2 = str3;
            this.pos += this.peekedNumberLength;
        } else {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected a string but was ").append(peek()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
            throw illegalStateException2;
        }
        this.peeked = 0;
        return str2;
    }

    public JsonToken peek() throws IOException {
        AssertionError assertionError;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
        }
    }

    public final void setLenient(boolean z) {
        boolean z2 = z;
        this.lenient = z2;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                push(1);
                i++;
            } else if (i2 == 1) {
                push(3);
                i++;
            } else if (i2 == 4) {
                this.stackSize = -1 + this.stackSize;
                i--;
            } else if (i2 == 2) {
                this.stackSize = -1 + this.stackSize;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                skipUnquotedValue();
            } else if (i2 == 8 || i2 == 12) {
                skipQuotedValue('\'');
            } else if (i2 == 9 || i2 == 13) {
                skipQuotedValue('\"');
            } else if (i2 == 16) {
                this.pos += this.peekedNumberLength;
            }
            this.peeked = 0;
        } while (i != 0);
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(getClass().getSimpleName()).append(" at line ").append(getLineNumber()).append(" column ").append(getColumnNumber()).toString();
    }
}
