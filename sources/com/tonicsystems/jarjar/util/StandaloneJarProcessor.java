package com.tonicsystems.jarjar.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class StandaloneJarProcessor {
    public StandaloneJarProcessor() {
    }

    public static void run(File file, File file2, JarProcessor jarProcessor) throws IOException {
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        JarOutputStream jarOutputStream;
        FileOutputStream fileOutputStream;
        HashSet hashSet;
        EntryStruct entryStruct;
        ByteArrayOutputStream byteArrayOutputStream;
        StringBuilder sb;
        StringBuilder sb2;
        JarEntry jarEntry;
        File file3 = file2;
        JarProcessor jarProcessor2 = jarProcessor;
        byte[] bArr = new byte[8192];
        ZipInputStream zipInputStream2 = zipInputStream;
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file);
        ZipInputStream zipInputStream3 = new ZipInputStream(fileInputStream2);
        ZipInputStream zipInputStream4 = zipInputStream2;
        File createTempFile = File.createTempFile("jarjar", ".jar");
        JarOutputStream jarOutputStream2 = jarOutputStream;
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(createTempFile);
        JarOutputStream jarOutputStream3 = new JarOutputStream(fileOutputStream2);
        JarOutputStream jarOutputStream4 = jarOutputStream2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        try {
            EntryStruct entryStruct2 = entryStruct;
            EntryStruct entryStruct3 = new EntryStruct();
            EntryStruct entryStruct4 = entryStruct2;
            while (true) {
                ZipEntry nextEntry = zipInputStream4.getNextEntry();
                if (nextEntry != null) {
                    entryStruct4.name = nextEntry.getName();
                    entryStruct4.time = nextEntry.getTime();
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                    IoUtil.pipe(zipInputStream4, byteArrayOutputStream4, bArr);
                    entryStruct4.data = byteArrayOutputStream4.toByteArray();
                    if (jarProcessor2.process(entryStruct4)) {
                        if (hashSet4.add(entryStruct4.name)) {
                            JarEntry jarEntry2 = jarEntry;
                            JarEntry jarEntry3 = new JarEntry(entryStruct4.name);
                            JarEntry jarEntry4 = jarEntry2;
                            jarEntry4.setTime(entryStruct4.time);
                            jarEntry4.setCompressedSize(-1);
                            jarOutputStream4.putNextEntry(jarEntry4);
                            jarOutputStream4.write(entryStruct4.data);
                        } else if (entryStruct4.name.endsWith("/")) {
                            PrintStream printStream = System.out;
                            StringBuilder sb3 = sb2;
                            StringBuilder sb4 = new StringBuilder();
                            printStream.println(sb3.append("Ignoring slash: ").append(entryStruct4.name).toString());
                        } else {
                            PrintStream printStream2 = System.err;
                            StringBuilder sb5 = sb;
                            StringBuilder sb6 = new StringBuilder();
                            printStream2.println(sb5.append("Duplicate jar entries: ").append(entryStruct4.name).toString());
                        }
                    }
                } else {
                    zipInputStream4.close();
                    jarOutputStream4.close();
                    IoUtil.copyZipWithoutEmptyDirectories(createTempFile, file3);
                    boolean delete = createTempFile.delete();
                    return;
                }
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            zipInputStream4.close();
            jarOutputStream4.close();
            throw th2;
        }
    }
}
