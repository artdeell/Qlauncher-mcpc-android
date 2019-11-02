package net.zhuoweizhang.boardwalk;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class LibrariesRepository {
    public static final String MOJANG_MAVEN_REPO = "";
    public static List<String> builtInLibs;
    public static File dexOutputDir;
    public static File downloadDir;
    public static File[] localDexDirs;
    public static File[] localDirs;

    static {
        String[] strArr = new String[5];
        String[] strArr2 = strArr;
        strArr[0] = "gson";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "jinput";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "jutils";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = "lwjgl";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "lwjgl_util";
        builtInLibs = Arrays.asList(strArr10);
    }

    public LibrariesRepository() {
    }

    public static String artifactToPath(String str, String str2, String str3) {
        StringBuilder sb;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(str4.replaceAll("\\.", "/")).append("/").append(str5).append("/").append(str6).append("/").append(str5).append("-").append(str6).append(".jar").toString();
    }

    public static File getDexLocalPath(String str, String str2, String str3) {
        File file;
        String artifactToPath = artifactToPath(str, str2, str3);
        File[] fileArr = localDexDirs;
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file2 = file;
            File file3 = new File(fileArr[i], artifactToPath);
            File file4 = file2;
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    public static File getDexTargetPath(String str, String str2, String str3) {
        File file;
        File file2 = file;
        File file3 = new File(dexOutputDir, artifactToPath(str, str2, str3));
        return file2;
    }

    public static File getDownloadTargetPath(String str, String str2, String str3) {
        File file;
        File file2 = file;
        File file3 = new File(downloadDir, artifactToPath(str, str2, str3));
        return file2;
    }

    public static File getLocalPath(String str, String str2, String str3) {
        File file;
        String artifactToPath = artifactToPath(str, str2, str3);
        File[] fileArr = localDirs;
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file2 = file;
            File file3 = new File(fileArr[i], artifactToPath);
            File file4 = file2;
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    public static boolean isBlackListedLibrary(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str3;
        return str2.endsWith("-platform");
    }

    public static boolean isBuiltInToLauncher(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str3;
        return builtInLibs.contains(str2);
    }

    public static boolean needsDownload(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        return !isBuiltInToLauncher(str4, str5, str6) && getLocalPath(str4, str5, str6) == null && getDexLocalPath(str4, str5, str6) == null && !isBlackListedLibrary(str4, str5, str6);
    }

    public static void setLocalDexPath(File[] fileArr, File file) {
        File file2 = file;
        localDexDirs = fileArr;
        dexOutputDir = file2;
    }

    public static void setLocalLibPath(File[] fileArr, File file) {
        File file2 = file;
        localDirs = fileArr;
        downloadDir = file2;
    }
}
