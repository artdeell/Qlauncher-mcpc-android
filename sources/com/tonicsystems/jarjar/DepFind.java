package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.ClassHeaderReader;
import com.tonicsystems.jarjar.util.ClassPathEntry;
import com.tonicsystems.jarjar.util.ClassPathIterator;
import com.tonicsystems.jarjar.util.RuntimeIOException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import org.objectweb.asm.ClassReader;

public class DepFind {
    private File curDir;

    public DepFind() {
        File file;
        File file2 = file;
        File file3 = new File(System.getProperty("user.dir"));
        this.curDir = file2;
    }

    public void run(String str, String str2, DepHandler depHandler) throws IOException {
        ClassHeaderReader classHeaderReader;
        HashMap hashMap;
        ClassPathIterator classPathIterator;
        ClassPathIterator classPathIterator2;
        ClassPathIterator classPathIterator3;
        ClassPathIterator classPathIterator4;
        StringBuilder sb;
        ClassReader classReader;
        DepFindVisitor depFindVisitor;
        StringBuilder sb2;
        String str3 = str;
        String str4 = str2;
        DepHandler depHandler2 = depHandler;
        try {
            ClassHeaderReader classHeaderReader2 = classHeaderReader;
            ClassHeaderReader classHeaderReader3 = new ClassHeaderReader();
            ClassHeaderReader classHeaderReader4 = classHeaderReader2;
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = hashMap2;
            ClassPathIterator classPathIterator5 = classPathIterator;
            ClassPathIterator classPathIterator6 = new ClassPathIterator(this.curDir, str4, null);
            classPathIterator2 = classPathIterator5;
            while (classPathIterator2.hasNext()) {
                ClassPathEntry next = classPathIterator2.next();
                InputStream openStream = next.openStream();
                try {
                    classHeaderReader4.read(openStream);
                    Object put = hashMap4.put(classHeaderReader4.getClassName(), next.getSource());
                    openStream.close();
                } catch (Exception e) {
                    Exception exc = e;
                    PrintStream printStream = System.err;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    printStream.println(sb3.append("Error reading ").append(next.getName()).append(": ").append(exc.getMessage()).toString());
                    openStream.close();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    openStream.close();
                    throw th2;
                }
            }
            classPathIterator2.close();
            depHandler2.handleStart();
            ClassPathIterator classPathIterator7 = classPathIterator3;
            ClassPathIterator classPathIterator8 = new ClassPathIterator(this.curDir, str3, null);
            classPathIterator4 = classPathIterator7;
            while (classPathIterator4.hasNext()) {
                ClassPathEntry next2 = classPathIterator4.next();
                InputStream openStream2 = next2.openStream();
                try {
                    ClassReader classReader2 = classReader;
                    ClassReader classReader3 = new ClassReader(openStream2);
                    DepFindVisitor depFindVisitor2 = depFindVisitor;
                    DepFindVisitor depFindVisitor3 = new DepFindVisitor(hashMap4, next2.getSource(), depHandler2);
                    classReader2.accept(depFindVisitor2, 2);
                    openStream2.close();
                } catch (Exception e2) {
                    Exception exc2 = e2;
                    PrintStream printStream2 = System.err;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    printStream2.println(sb5.append("Error reading ").append(next2.getName()).append(": ").append(exc2.getMessage()).toString());
                    openStream2.close();
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    openStream2.close();
                    throw th4;
                }
            }
            classPathIterator4.close();
            depHandler2.handleEnd();
        } catch (RuntimeIOException e3) {
            throw ((IOException) e3.getCause());
        } catch (Throwable th5) {
            Throwable th6 = th5;
            classPathIterator2.close();
            throw th6;
        }
    }

    public void setCurrentDirectory(File file) {
        File file2 = file;
        this.curDir = file2;
    }
}
