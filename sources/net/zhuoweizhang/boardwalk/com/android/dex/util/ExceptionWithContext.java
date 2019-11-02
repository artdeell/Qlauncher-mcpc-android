package net.zhuoweizhang.boardwalk.com.android.dex.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ExceptionWithContext extends RuntimeException {
    private StringBuffer context;

    public ExceptionWithContext(String str) {
        this(str, null);
    }

    public ExceptionWithContext(String str, Throwable th) {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        String str2 = str;
        Throwable th2 = th;
        if (str2 == null) {
            str2 = th2 != null ? th2.getMessage() : null;
        }
        super(str2, th2);
        if (th2 instanceof ExceptionWithContext) {
            String stringBuffer3 = ((ExceptionWithContext) th2).context.toString();
            StringBuffer stringBuffer4 = stringBuffer2;
            StringBuffer stringBuffer5 = new StringBuffer(200 + stringBuffer3.length());
            this.context = stringBuffer4;
            StringBuffer append = this.context.append(stringBuffer3);
            return;
        }
        StringBuffer stringBuffer6 = stringBuffer;
        StringBuffer stringBuffer7 = new StringBuffer(200);
        this.context = stringBuffer6;
    }

    public ExceptionWithContext(Throwable th) {
        this(null, th);
    }

    public static ExceptionWithContext withContext(Throwable th, String str) {
        ExceptionWithContext exceptionWithContext;
        ExceptionWithContext exceptionWithContext2;
        Throwable th2 = th;
        String str2 = str;
        if (th2 instanceof ExceptionWithContext) {
            exceptionWithContext2 = (ExceptionWithContext) th2;
        } else {
            ExceptionWithContext exceptionWithContext3 = exceptionWithContext;
            ExceptionWithContext exceptionWithContext4 = new ExceptionWithContext(th2);
            exceptionWithContext2 = exceptionWithContext3;
        }
        exceptionWithContext2.addContext(str2);
        return exceptionWithContext2;
    }

    public void addContext(String str) {
        NullPointerException nullPointerException;
        String str2 = str;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("str == null");
            throw nullPointerException2;
        }
        StringBuffer append = this.context.append(str2);
        if (!str2.endsWith("\n")) {
            StringBuffer append2 = this.context.append(10);
        }
    }

    public String getContext() {
        return this.context.toString();
    }

    public void printContext(PrintStream printStream) {
        PrintStream printStream2 = printStream;
        printStream2.println(getMessage());
        printStream2.print(this.context);
    }

    public void printContext(PrintWriter printWriter) {
        PrintWriter printWriter2 = printWriter;
        printWriter2.println(getMessage());
        printWriter2.print(this.context);
    }

    public void printStackTrace(PrintStream printStream) {
        PrintStream printStream2 = printStream;
        super.printStackTrace(printStream2);
        printStream2.println(this.context);
    }

    public void printStackTrace(PrintWriter printWriter) {
        PrintWriter printWriter2 = printWriter;
        super.printStackTrace(printWriter2);
        printWriter2.println(this.context);
    }
}
