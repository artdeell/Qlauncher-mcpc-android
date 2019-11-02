package net.zhuoweizhang.boardwalk.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class IoUtil {
    private IoUtil() {
    }

    public static void clearDirectory(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    clearDirectory(file2);
                }
                boolean delete = file2.delete();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static void copy(File file, File file2, byte[] bArr) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File file3 = file2;
        byte[] bArr2 = bArr;
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file);
        FileInputStream fileInputStream4 = fileInputStream2;
        try {
            FileOutputStream fileOutputStream3 = fileOutputStream;
            FileOutputStream fileOutputStream4 = new FileOutputStream(file3);
            fileOutputStream2 = fileOutputStream3;
            pipe(fileInputStream4, fileOutputStream2, bArr2);
            fileOutputStream2.close();
            fileInputStream4.close();
        } catch (Throwable th) {
            Throwable th2 = th;
            fileInputStream4.close();
            throw th2;
        }
    }

    public static void copyZipWithoutEmptyDirectories(File file, File file2) throws IOException {
        ZipFile zipFile;
        ZipOutputStream zipOutputStream;
        FileOutputStream fileOutputStream;
        ArrayList arrayList;
        C07341 r22;
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
                boolean add = arrayList4.add((ZipEntry) entries.nextElement());
            }
            ArrayList arrayList5 = arrayList4;
            C07341 r18 = r22;
            C07341 r19 = new Comparator<ZipEntry>() {
                public int compare(ZipEntry zipEntry, ZipEntry zipEntry2) {
                    return zipEntry.getName().compareTo(zipEntry2.getName());
                }
            };
            Collections.sort(arrayList5, r18);
            int size = -1 + arrayList4.size();
            while (size >= 0) {
                ZipEntry zipEntry2 = (ZipEntry) arrayList4.get(size);
                String name = zipEntry2.getName();
                if (zipEntry2.isDirectory()) {
                    z = size == -1 + arrayList4.size() ? true : !((ZipEntry) arrayList4.get(size + 1)).getName().startsWith(name);
                } else {
                    z = false;
                }
                if (z) {
                    boolean remove = arrayList4.remove(zipEntry2);
                } else {
                    ZipOutputStream zipOutputStream5 = zipOutputStream4;
                    ZipEntry zipEntry3 = zipEntry;
                    ZipEntry zipEntry4 = new ZipEntry(zipEntry2);
                    zipOutputStream5.putNextEntry(zipEntry3);
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                    InputStream inputStream = zipFile4.getInputStream(zipEntry2);
                    pipe(inputStream, byteArrayOutputStream4, bArr);
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

    public static void pipe(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        byte[] bArr2 = bArr;
        while (true) {
            int read = inputStream2.read(bArr2);
            if (read >= 0) {
                outputStream2.write(bArr2, 0, read);
            } else {
                return;
            }
        }
    }
}
