package net.zhuoweizhang.boardwalk.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CleanZipUtil {
    public CleanZipUtil() {
    }

    public static void main(String[] strArr) throws Exception {
        File file;
        File file2;
        String[] strArr2 = strArr;
        PrintStream printStream = System.out;
        File file3 = file;
        File file4 = new File(strArr2[0]);
        File file5 = file2;
        File file6 = new File(strArr2[1]);
        printStream.println(shardZip(file3, file5, Integer.parseInt(strArr2[2])));
    }

    public static void process(File file, File file2) throws IOException {
        ZipFile zipFile;
        ZipOutputStream zipOutputStream;
        FileOutputStream fileOutputStream;
        ArrayList arrayList;
        C07331 r23;
        boolean z;
        ZipEntry zipEntry;
        ByteArrayOutputStream byteArrayOutputStream;
        File file3 = file2;
        byte[] bArr = new byte[8192];
        ZipFile zipFile2 = zipFile;
        ZipFile zipFile3 = new ZipFile(file);
        ZipFile zipFile4 = zipFile2;
        ZipOutputStream zipOutputStream2 = zipOutputStream;
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
        ZipOutputStream zipOutputStream3 = new ZipOutputStream(fileOutputStream2);
        ZipOutputStream zipOutputStream4 = zipOutputStream2;
        try {
            Enumeration entries = zipFile4.entries();
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry2 = (ZipEntry) entries.nextElement();
                if (!zipEntry2.getName().startsWith("META-INF")) {
                    boolean add = arrayList4.add(zipEntry2);
                }
            }
            ArrayList arrayList5 = arrayList4;
            C07331 r19 = r23;
            C07331 r20 = new Comparator<ZipEntry>() {
                public int compare(ZipEntry zipEntry, ZipEntry zipEntry2) {
                    return zipEntry.getName().compareTo(zipEntry2.getName());
                }
            };
            Collections.sort(arrayList5, r19);
            int size = -1 + arrayList4.size();
            while (size >= 0) {
                ZipEntry zipEntry3 = (ZipEntry) arrayList4.get(size);
                String name = zipEntry3.getName();
                if (zipEntry3.isDirectory()) {
                    z = size == -1 + arrayList4.size() ? true : !((ZipEntry) arrayList4.get(size + 1)).getName().startsWith(name);
                } else {
                    z = false;
                }
                if (z) {
                    boolean remove = arrayList4.remove(zipEntry3);
                } else {
                    ZipOutputStream zipOutputStream5 = zipOutputStream4;
                    ZipEntry zipEntry4 = zipEntry;
                    ZipEntry zipEntry5 = new ZipEntry(zipEntry3);
                    zipOutputStream5.putNextEntry(zipEntry4);
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                    InputStream inputStream = zipFile4.getInputStream(zipEntry3);
                    IoUtil.pipe(inputStream, byteArrayOutputStream4, bArr);
                    inputStream.close();
                    zipOutputStream4.write(byteArrayOutputStream4.toByteArray());
                }
                size--;
            }
            zipOutputStream4.close();
        } catch (Throwable th) {
            Throwable th2 = th;
            zipOutputStream4.close();
            throw th2;
        }
    }

    public static List<File> shardZip(File file, File file2, int i) throws IOException {
        ArrayList arrayList;
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        ZipOutputStream zipOutputStream2;
        FileOutputStream fileOutputStream;
        File file3 = file;
        File file4 = file2;
        int i2 = i;
        byte[] bArr = new byte[8192];
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        ZipInputStream zipInputStream2 = zipInputStream;
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file3);
        ZipInputStream zipInputStream3 = new ZipInputStream(fileInputStream2);
        ZipInputStream zipInputStream4 = zipInputStream2;
        File file5 = null;
        int i3 = 0;
        ZipOutputStream zipOutputStream3 = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream4.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream4.close();
                    zipOutputStream3.close();
                    return arrayList4;
                } else if (!nextEntry.getName().startsWith("META-INF") && !nextEntry.isDirectory()) {
                    if (file5 == null || i3 == i2) {
                        if (zipOutputStream3 != null) {
                            zipOutputStream3.close();
                        }
                        file5 = File.createTempFile(file3.getName(), ".jar", file4);
                        boolean add = arrayList4.add(file5);
                        ZipOutputStream zipOutputStream4 = zipOutputStream2;
                        FileOutputStream fileOutputStream2 = fileOutputStream;
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file5);
                        ZipOutputStream zipOutputStream5 = new ZipOutputStream(fileOutputStream2);
                        zipOutputStream = zipOutputStream4;
                        i3 = 0;
                    } else {
                        zipOutputStream = zipOutputStream3;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                        nextEntry.setCompressedSize(-1);
                        zipOutputStream.putNextEntry(nextEntry);
                        IoUtil.pipe(zipInputStream4, zipOutputStream, bArr);
                        if (nextEntry.getName().endsWith(".class")) {
                            i3++;
                        }
                        zipOutputStream3 = zipOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        zipInputStream4.close();
                        zipOutputStream.close();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = zipOutputStream3;
                zipInputStream4.close();
                zipOutputStream.close();
                throw th;
            }
        }
    }
}
