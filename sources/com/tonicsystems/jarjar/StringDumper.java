package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.ClassPathEntry;
import com.tonicsystems.jarjar.util.ClassPathIterator;
import com.tonicsystems.jarjar.util.RuntimeIOException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;

class StringDumper {

    private static class DumpStringReader extends StringReader {
        private String className;

        /* renamed from: pw */
        private final PrintWriter f18pw;

        public DumpStringReader(PrintWriter printWriter) {
            this.f18pw = printWriter;
        }

        public void visitString(String str, String str2, int i) {
            StringBuilder sb;
            String str3 = str;
            String str4 = str2;
            int i2 = i;
            if (str4.length() > 0) {
                if (!str3.equals(this.className)) {
                    this.className = str3;
                    this.f18pw.println(str3.replace(ClassPathElement.SEPARATOR_CHAR, '.'));
                }
                this.f18pw.print("\t");
                if (i2 >= 0) {
                    PrintWriter printWriter = this.f18pw;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    printWriter.print(sb2.append(i2).append(": ").toString());
                }
                this.f18pw.print(StringDumper.escapeStringLiteral(str4));
                this.f18pw.println();
            }
        }
    }

    public StringDumper() {
    }

    /* access modifiers changed from: private */
    public static String escapeStringLiteral(String str) {
        StringBuilder sb;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("\"");
        char[] charArray = str2.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            switch (c) {
                case 8:
                    StringBuilder append2 = sb4.append("\\b");
                    break;
                case 9:
                    StringBuilder append3 = sb4.append("\\t");
                    break;
                case 10:
                    StringBuilder append4 = sb4.append("\\n");
                    break;
                case 12:
                    StringBuilder append5 = sb4.append("\\f");
                    break;
                case 13:
                    StringBuilder append6 = sb4.append("\\r");
                    break;
                case '\"':
                    StringBuilder append7 = sb4.append("\\\"");
                    break;
                case '\\':
                    StringBuilder append8 = sb4.append("\\\\");
                    break;
                default:
                    StringBuilder append9 = sb4.append(c);
                    break;
            }
        }
        StringBuilder append10 = sb4.append("\"");
        return sb4.toString();
    }

    public void run(String str, PrintWriter printWriter) throws IOException {
        DumpStringReader dumpStringReader;
        ClassPathIterator classPathIterator;
        StringBuilder sb;
        ClassReader classReader;
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        DumpStringReader dumpStringReader2 = dumpStringReader;
        DumpStringReader dumpStringReader3 = new DumpStringReader(printWriter2);
        DumpStringReader dumpStringReader4 = dumpStringReader2;
        ClassPathIterator classPathIterator2 = classPathIterator;
        ClassPathIterator classPathIterator3 = new ClassPathIterator(str2);
        ClassPathIterator classPathIterator4 = classPathIterator2;
        while (classPathIterator4.hasNext()) {
            try {
                ClassPathEntry next = classPathIterator4.next();
                InputStream openStream = next.openStream();
                try {
                    ClassReader classReader2 = classReader;
                    ClassReader classReader3 = new ClassReader(openStream);
                    classReader2.accept(dumpStringReader4, 0);
                    openStream.close();
                } catch (Exception e) {
                    Exception exc = e;
                    PrintStream printStream = System.err;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    printStream.println(sb2.append("Error reading ").append(next.getName()).append(": ").append(exc.getMessage()).toString());
                    openStream.close();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    openStream.close();
                    throw th2;
                }
                printWriter2.flush();
            } catch (RuntimeIOException e2) {
                throw ((IOException) e2.getCause());
            } catch (Throwable th3) {
                Throwable th4 = th3;
                classPathIterator4.close();
                throw th4;
            }
        }
        classPathIterator4.close();
    }
}
