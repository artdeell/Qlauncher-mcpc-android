package com.tonicsystems.jarjar.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClassPathIterator implements Iterator<ClassPathEntry> {
    /* access modifiers changed from: private */
    public static final FileFilter CLASS_FILTER;
    private static final FileFilter JAR_FILTER;
    private Iterator<ClassPathEntry> entries;
    private final Iterator<File> files;
    private ClassPathEntry next;
    private List<ZipFile> zips;

    private static class FileIterator implements Iterator<ClassPathEntry> {
        /* access modifiers changed from: private */
        public final File dir;
        private final Iterator<File> entries;

        FileIterator(File file) {
            ArrayList arrayList;
            File file2 = file;
            this.dir = file2;
            File file3 = file2;
            FileFilter access$300 = ClassPathIterator.CLASS_FILTER;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.entries = ClassPathIterator.findFiles(file3, access$300, true, arrayList2).iterator();
        }

        public boolean hasNext() {
            return this.entries.hasNext();
        }

        public ClassPathEntry next() {
            C05531 r5;
            C05531 r1 = r5;
            final File file = (File) this.entries.next();
            C05531 r2 = new ClassPathEntry(this) {
                final /* synthetic */ FileIterator this$0;

                {
                    File file = r7;
                    this.this$0 = r6;
                }

                public String getName() {
                    return file.getName();
                }

                public String getSource() throws IOException {
                    return this.this$0.dir.getCanonicalPath();
                }

                public InputStream openStream() throws IOException {
                    BufferedInputStream bufferedInputStream;
                    FileInputStream fileInputStream;
                    BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                    FileInputStream fileInputStream2 = fileInputStream;
                    FileInputStream fileInputStream3 = new FileInputStream(file);
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(fileInputStream2);
                    return bufferedInputStream2;
                }
            };
            return r1;
        }

        public void remove() {
            UnsupportedOperationException unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }
    }

    private static class ZipIterator implements Iterator<ClassPathEntry> {
        private final Enumeration<? extends ZipEntry> entries;
        /* access modifiers changed from: private */
        public final ZipFile zip;

        ZipIterator(ZipFile zipFile) {
            ZipFile zipFile2 = zipFile;
            this.zip = zipFile2;
            this.entries = zipFile2.entries();
        }

        public boolean hasNext() {
            return this.entries.hasMoreElements();
        }

        public ClassPathEntry next() {
            C05541 r5;
            C05541 r1 = r5;
            final ZipEntry zipEntry = (ZipEntry) this.entries.nextElement();
            C05541 r2 = new ClassPathEntry(this) {
                final /* synthetic */ ZipIterator this$0;

                {
                    ZipEntry zipEntry = r7;
                    this.this$0 = r6;
                }

                public String getName() {
                    return zipEntry.getName();
                }

                public String getSource() {
                    return this.this$0.zip.getName();
                }

                public InputStream openStream() throws IOException {
                    return this.this$0.zip.getInputStream(zipEntry);
                }
            };
            return r1;
        }

        public void remove() {
            UnsupportedOperationException unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }
    }

    static {
        C05511 r2;
        C05522 r22;
        C05511 r0 = r2;
        C05511 r1 = new FileFilter() {
            public boolean accept(File file) {
                File file2 = file;
                return file2.isDirectory() || ClassPathIterator.isClass(file2.getName());
            }
        };
        CLASS_FILTER = r0;
        C05522 r02 = r22;
        C05522 r12 = new FileFilter() {
            public boolean accept(File file) {
                return ClassPathIterator.hasExtension(file.getName(), ".jar");
            }
        };
        JAR_FILTER = r02;
    }

    public ClassPathIterator(File file, String str, String str2) throws IOException {
        ArrayList arrayList;
        StringTokenizer stringTokenizer;
        ArrayList arrayList2;
        boolean z;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        File file2;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException3;
        StringBuilder sb3;
        ArrayList arrayList3;
        File file3;
        IllegalArgumentException illegalArgumentException4;
        StringBuilder sb4;
        File file4 = file;
        String str3 = str;
        String str4 = str2;
        this.entries = Collections.emptyList().iterator();
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = new ArrayList();
        this.zips = arrayList4;
        if (str4 == null) {
            str4 = System.getProperty("path.separator");
        }
        StringTokenizer stringTokenizer2 = stringTokenizer;
        StringTokenizer stringTokenizer3 = new StringTokenizer(str3, str4);
        StringTokenizer stringTokenizer4 = stringTokenizer2;
        ArrayList arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = arrayList6;
        while (stringTokenizer4.hasMoreTokens()) {
            String str5 = (String) stringTokenizer4.nextElement();
            if (str5.endsWith("/*")) {
                str5 = str5.substring(0, -1 + str5.length());
                if (str5.indexOf(42) >= 0) {
                    IllegalArgumentException illegalArgumentException5 = illegalArgumentException4;
                    StringBuilder sb5 = sb4;
                    StringBuilder sb6 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb5.append("Multiple wildcards are not allowed: ").append(str5).toString());
                    throw illegalArgumentException5;
                }
                z = true;
            } else {
                z = false;
                if (str5.indexOf(42) >= 0) {
                    IllegalArgumentException illegalArgumentException7 = illegalArgumentException;
                    StringBuilder sb7 = sb;
                    StringBuilder sb8 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException(sb7.append("Incorrect wildcard usage: ").append(str5).toString());
                    throw illegalArgumentException7;
                }
            }
            File file5 = file2;
            File file6 = new File(str5);
            File file7 = file5;
            if (!file7.isAbsolute()) {
                File file8 = file3;
                File file9 = new File(file4, str5);
                file7 = file8;
            }
            if (!file7.exists()) {
                IllegalArgumentException illegalArgumentException9 = illegalArgumentException2;
                StringBuilder sb9 = sb2;
                StringBuilder sb10 = new StringBuilder();
                IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException(sb9.append("File ").append(file7).append(" does not exist").toString());
                throw illegalArgumentException9;
            } else if (!z) {
                boolean add = arrayList8.add(file7);
            } else if (!file7.isDirectory()) {
                IllegalArgumentException illegalArgumentException11 = illegalArgumentException3;
                StringBuilder sb11 = sb3;
                StringBuilder sb12 = new StringBuilder();
                IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException(sb11.append("File ").append(file7).append(" + is not a directory").toString());
                throw illegalArgumentException11;
            } else {
                ArrayList arrayList9 = arrayList8;
                File file10 = file7;
                FileFilter fileFilter = JAR_FILTER;
                ArrayList arrayList10 = arrayList3;
                ArrayList arrayList11 = new ArrayList();
                boolean addAll = arrayList9.addAll(findFiles(file10, fileFilter, false, arrayList10));
            }
        }
        this.files = arrayList8.iterator();
        advance();
    }

    public ClassPathIterator(String str) throws IOException {
        File file;
        String str2 = str;
        File file2 = file;
        File file3 = new File(System.getProperty("user.dir"));
        this(file2, str2, null);
    }

    private void advance() throws IOException {
        boolean z;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        FileIterator fileIterator;
        ZipFile zipFile;
        ZipIterator zipIterator;
        JarFile jarFile;
        ZipIterator zipIterator2;
        if (!this.entries.hasNext()) {
            if (!this.files.hasNext()) {
                this.next = null;
                return;
            }
            File file = (File) this.files.next();
            if (hasExtension(file.getName(), ".jar")) {
                JarFile jarFile2 = jarFile;
                JarFile jarFile3 = new JarFile(file);
                JarFile jarFile4 = jarFile2;
                boolean add = this.zips.add(jarFile4);
                ZipIterator zipIterator3 = zipIterator2;
                ZipIterator zipIterator4 = new ZipIterator(jarFile4);
                this.entries = zipIterator3;
            } else if (hasExtension(file.getName(), ".zip")) {
                ZipFile zipFile2 = zipFile;
                ZipFile zipFile3 = new ZipFile(file);
                ZipFile zipFile4 = zipFile2;
                boolean add2 = this.zips.add(zipFile4);
                ZipIterator zipIterator5 = zipIterator;
                ZipIterator zipIterator6 = new ZipIterator(zipFile4);
                this.entries = zipIterator5;
            } else if (file.isDirectory()) {
                FileIterator fileIterator2 = fileIterator;
                FileIterator fileIterator3 = new FileIterator(file);
                this.entries = fileIterator2;
            } else {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Do not know how to handle ").append(file).toString());
                throw illegalArgumentException2;
            }
        }
        boolean z2 = false;
        while (true) {
            z = z2;
            if (!z && this.entries.hasNext()) {
                this.next = (ClassPathEntry) this.entries.next();
                z2 = isClass(this.next.getName());
            }
        }
        if (!z) {
            advance();
        }
    }

    /* access modifiers changed from: private */
    public static List<File> findFiles(File file, FileFilter fileFilter, boolean z, List<File> list) {
        FileFilter fileFilter2 = fileFilter;
        boolean z2 = z;
        List<File> list2 = list;
        File[] listFiles = file.listFiles(fileFilter2);
        int length = listFiles.length;
        for (int i = 0; i < length; i++) {
            File file2 = listFiles[i];
            if (!z2 || !file2.isDirectory()) {
                boolean add = list2.add(file2);
            } else {
                List findFiles = findFiles(file2, fileFilter2, z2, list2);
            }
        }
        return list2;
    }

    /* access modifiers changed from: private */
    public static boolean hasExtension(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (str3.length() >= str4.length()) {
            String substring = str3.substring(str3.length() - str4.length());
            if (substring.equals(str4) || substring.equals(str4.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean isClass(String str) {
        return hasExtension(str, ".class");
    }

    public void close() throws IOException {
        this.next = null;
        for (ZipFile close : this.zips) {
            close.close();
        }
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public ClassPathEntry next() {
        RuntimeIOException runtimeIOException;
        NoSuchElementException noSuchElementException;
        if (!hasNext()) {
            NoSuchElementException noSuchElementException2 = noSuchElementException;
            NoSuchElementException noSuchElementException3 = new NoSuchElementException();
            throw noSuchElementException2;
        }
        ClassPathEntry classPathEntry = this.next;
        try {
            advance();
            return classPathEntry;
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeIOException runtimeIOException2 = runtimeIOException;
            RuntimeIOException runtimeIOException3 = new RuntimeIOException(iOException);
            throw runtimeIOException2;
        }
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }
}
