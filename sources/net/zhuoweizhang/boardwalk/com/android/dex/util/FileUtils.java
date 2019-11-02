package net.zhuoweizhang.boardwalk.com.android.dex.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class FileUtils {
    private FileUtils() {
    }

    public static boolean hasArchiveSuffix(String str) {
        String str2 = str;
        return str2.endsWith(".zip") || str2.endsWith(".jar") || str2.endsWith(".apk");
    }

    public static byte[] readFile(File file) {
        RuntimeException runtimeException;
        StringBuilder sb;
        FileInputStream fileInputStream;
        RuntimeException runtimeException2;
        StringBuilder sb2;
        RuntimeException runtimeException3;
        StringBuilder sb3;
        RuntimeException runtimeException4;
        StringBuilder sb4;
        RuntimeException runtimeException5;
        StringBuilder sb5;
        RuntimeException runtimeException6;
        StringBuilder sb6;
        File file2 = file;
        if (!file2.exists()) {
            RuntimeException runtimeException7 = runtimeException6;
            StringBuilder sb7 = sb6;
            StringBuilder sb8 = new StringBuilder();
            RuntimeException runtimeException8 = new RuntimeException(sb7.append(file2).append(": file not found").toString());
            throw runtimeException7;
        } else if (!file2.isFile()) {
            RuntimeException runtimeException9 = runtimeException5;
            StringBuilder sb9 = sb5;
            StringBuilder sb10 = new StringBuilder();
            RuntimeException runtimeException10 = new RuntimeException(sb9.append(file2).append(": not a file").toString());
            throw runtimeException9;
        } else if (!file2.canRead()) {
            RuntimeException runtimeException11 = runtimeException4;
            StringBuilder sb11 = sb4;
            StringBuilder sb12 = new StringBuilder();
            RuntimeException runtimeException12 = new RuntimeException(sb11.append(file2).append(": file not readable").toString());
            throw runtimeException11;
        } else {
            long length = file2.length();
            int i = (int) length;
            if (((long) i) != length) {
                RuntimeException runtimeException13 = runtimeException3;
                StringBuilder sb13 = sb3;
                StringBuilder sb14 = new StringBuilder();
                RuntimeException runtimeException14 = new RuntimeException(sb13.append(file2).append(": file too long").toString());
                throw runtimeException13;
            }
            byte[] bArr = new byte[i];
            try {
                FileInputStream fileInputStream2 = fileInputStream;
                FileInputStream fileInputStream3 = new FileInputStream(file2);
                FileInputStream fileInputStream4 = fileInputStream2;
                int i2 = 0;
                while (i > 0) {
                    int read = fileInputStream4.read(bArr, i2, i);
                    if (read == -1) {
                        RuntimeException runtimeException15 = runtimeException2;
                        StringBuilder sb15 = sb2;
                        StringBuilder sb16 = new StringBuilder();
                        RuntimeException runtimeException16 = new RuntimeException(sb15.append(file2).append(": unexpected EOF").toString());
                        throw runtimeException15;
                    }
                    i2 += read;
                    i -= read;
                }
                fileInputStream4.close();
                return bArr;
            } catch (IOException e) {
                IOException iOException = e;
                RuntimeException runtimeException17 = runtimeException;
                StringBuilder sb17 = sb;
                StringBuilder sb18 = new StringBuilder();
                RuntimeException runtimeException18 = new RuntimeException(sb17.append(file2).append(": trouble reading").toString(), iOException);
                throw runtimeException17;
            }
        }
    }

    public static byte[] readFile(String str) {
        File file;
        File file2 = file;
        File file3 = new File(str);
        return readFile(file2);
    }
}
