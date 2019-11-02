package net.minecraft.kdt;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileAccess {
    public static int ADDED_LIBS = (TOTAL_LIBS + 1);
    public static String MAIN_PATH = "/sdcard/games/minecraft";
    private static int TOTAL_LIBS = 26;

    public static File lastFileModified(String str) {
        File file;
        AnonymousClass100000000 r15;
        File file2 = file;
        File file3 = new File(str);
        File file4 = file2;
        AnonymousClass100000000 r12 = r15;
        AnonymousClass100000000 r13 = new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        };
        long j = Long.MIN_VALUE;
        File file5 = null;
        File[] listFiles = file4.listFiles(r12);
        for (int i = 0; i < listFiles.length; i++) {
            File file6 = listFiles[i];
            if (file6.lastModified() > j) {
                file5 = file6;
                j = file6.lastModified();
            }
        }
        return file5;
    }

    public static byte[] getByteArray(String str) throws Exception {
        File file;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        File file2 = file;
        File file3 = new File(str);
        File file4 = file2;
        byte[] bArr = new byte[((int) file4.length())];
        BufferedInputStream bufferedInputStream2 = bufferedInputStream;
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file4);
        BufferedInputStream bufferedInputStream3 = new BufferedInputStream(fileInputStream2);
        BufferedInputStream bufferedInputStream4 = bufferedInputStream2;
        int read = bufferedInputStream4.read(bArr, 0, bArr.length);
        bufferedInputStream4.close();
        return bArr;
    }

    public static String read(String str) throws Exception {
        String str2;
        String str3 = str2;
        String str4 = new String(getByteArray(str));
        return str3;
    }

    public static void write(String str, byte[] bArr) throws Exception {
        FileOutputStream fileOutputStream;
        byte[] bArr2 = bArr;
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(str);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        fileOutputStream4.write(bArr2);
        fileOutputStream4.close();
    }

    public static void write(String str, String str2) throws Exception {
        write(str, str2.getBytes());
    }

    public static byte[] loadFromAssetToByte(Context context, String str) {
        byte[] bArr = new byte[0];
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr2 = new byte[open.available()];
            int read = open.read(bArr2);
            open.close();
            bArr = bArr2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    public static void copyAssetToFolderIfNonExist(Context context, String str, String str2) throws Exception {
        File file;
        File file2;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        FileOutputStream fileOutputStream;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        File file3 = file;
        File file4 = new File(str4);
        File file5 = file3;
        if (!file5.exists()) {
            boolean mkdirs = file5.mkdirs();
        }
        File file6 = file2;
        StringBuffer stringBuffer3 = stringBuffer;
        StringBuffer stringBuffer4 = new StringBuffer();
        StringBuffer stringBuffer5 = stringBuffer2;
        StringBuffer stringBuffer6 = new StringBuffer();
        File file7 = new File(stringBuffer3.append(stringBuffer5.append(str4).append("/").toString()).append(str3).toString());
        File file8 = file6;
        if (!file8.exists()) {
            boolean createNewFile = file8.createNewFile();
            FileOutputStream fileOutputStream2 = fileOutputStream;
            FileOutputStream fileOutputStream3 = new FileOutputStream(file8);
            fileOutputStream2.write(loadFromAssetToByte(context2, str3));
        }
    }

    public FileAccess() {
    }
}
