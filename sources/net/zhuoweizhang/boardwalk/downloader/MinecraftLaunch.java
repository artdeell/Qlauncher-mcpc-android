package net.zhuoweizhang.boardwalk.downloader;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.tonicsystems.jarjar.Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.model.DependentLibrary;
import net.zhuoweizhang.boardwalk.model.MinecraftVersion;
import net.zhuoweizhang.boardwalk.util.CleanZipUtil;
import net.zhuoweizhang.boardwalk.util.IoUtil;
import net.zhuoweizhang.boardwalk.util.PlatformUtils;

public class MinecraftLaunch {
    public static File dexDir;
    public static File dexPackDir;
    public static List<String> javaVMCmd;
    public static File launcherDir;
    public static List<String> libsToRename;
    public static File tmpDir;

    static {
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = "vecmath";
        libsToRename = Arrays.asList(strArr2);
    }

    public MinecraftLaunch() {
    }

    public static boolean canUseExistingDexPack(MinecraftVersion minecraftVersion) {
        StringBuilder sb;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        File minecraftVersionFile = MinecraftDownloader.getMinecraftVersionFile(minecraftVersion2);
        File dexPackFile = getDexPackFile(minecraftVersion2);
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Dex pack: ").append(dexPackFile).toString());
        return dexPackFile.exists() && minecraftVersionFile.lastModified() <= dexPackFile.lastModified();
    }

    public static void createDexPack(MinecraftVersion minecraftVersion) throws Exception {
        File file;
        ArrayList arrayList;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        File minecraftVersionFile = MinecraftDownloader.getMinecraftVersionFile(minecraftVersion2);
        File dexPackFile = getDexPackFile(minecraftVersion2);
        File createTempFile = File.createTempFile(dexPackFile.getName(), ".jar", tmpDir);
        boolean mkdirs = dexPackFile.getParentFile().mkdirs();
        File file2 = file;
        File file3 = new File(launcherDir, "jarjarrules_minecraft.txt");
        runRename(file2, minecraftVersionFile, createTempFile);
        List<File> shardZip = CleanZipUtil.shardZip(createTempFile, tmpDir, getShardCount());
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(shardZip.size());
        ArrayList<File> arrayList4 = arrayList2;
        for (File file4 : shardZip) {
            File createTempFile2 = File.createTempFile(dexPackFile.getName(), ".jar", tmpDir);
            boolean add = arrayList4.add(createTempFile2);
            File[] fileArr = new File[1];
            File[] fileArr2 = fileArr;
            fileArr[0] = file4;
            runDex(Arrays.asList(fileArr2), createTempFile2);
            boolean delete = file4.delete();
        }
        runDex(arrayList4, dexPackFile);
        for (File delete2 : arrayList4) {
            boolean delete3 = delete2.delete();
        }
        boolean delete4 = createTempFile.delete();
    }

    public static void doPreDex(String str, List<String> list) throws Exception {
        StringBuilder sb;
        List<String> list2 = list;
        MinecraftVersion downloadVersionInfo = MinecraftDownloader.downloadVersionInfo(str);
        DependentLibrary[] dependentLibraryArr = downloadVersionInfo.libraries;
        int length = dependentLibraryArr.length;
        for (int i = 0; i < length; i++) {
            String[] split = dependentLibraryArr[i].name.split(":");
            if (!list2.contains(split[1]) && LibrariesRepository.needsDownload(split[0], split[1], split[2])) {
                try {
                    MinecraftDownloader.downloadLibrary(split[0], split[1], split[2]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        DependentLibrary[] dependentLibraryArr2 = downloadVersionInfo.libraries;
        int length2 = dependentLibraryArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            DependentLibrary dependentLibrary = dependentLibraryArr2[i2];
            String[] split2 = dependentLibrary.name.split(":");
            if (!list2.contains(split2[1])) {
                File localPath = LibrariesRepository.getLocalPath(split2[0], split2[1], split2[2]);
                if (localPath != null) {
                    if (LibrariesRepository.getDexLocalPath(split2[0], split2[1], split2[2]) != null) {
                        PrintStream printStream = System.out;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        printStream.println(sb2.append("Using pre-dexed ").append(dependentLibrary.name).toString());
                    } else {
                        runConvert(localPath, LibrariesRepository.getDexTargetPath(split2[0], split2[1], split2[2]), true, null);
                    }
                }
            }
        }
    }

    private static void extractExtraDex(File file) throws IOException {
        File file2;
        StringBuilder sb;
        ZipFile zipFile;
        StringBuilder sb2;
        FileOutputStream fileOutputStream;
        File file3;
        File file4 = file;
        File file5 = file2;
        File parentFile = file4.getParentFile();
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        File file6 = new File(parentFile, sb3.append(file4.getName()).append("_multidex").toString());
        File file7 = file5;
        boolean mkdirs = file7.mkdirs();
        IoUtil.clearDirectory(file7);
        ZipFile zipFile2 = zipFile;
        ZipFile zipFile3 = new ZipFile(file4);
        ZipFile zipFile4 = zipFile2;
        byte[] bArr = new byte[8192];
        int i = 2;
        while (true) {
            ZipFile zipFile5 = zipFile4;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            ZipEntry entry = zipFile5.getEntry(sb5.append("classes").append(i).append(".dex").toString());
            if (entry == null) {
                zipFile4.close();
                return;
            }
            InputStream inputStream = zipFile4.getInputStream(entry);
            FileOutputStream fileOutputStream2 = fileOutputStream;
            File file8 = file3;
            File file9 = new File(file7, entry.getName());
            FileOutputStream fileOutputStream3 = new FileOutputStream(file8);
            FileOutputStream fileOutputStream4 = fileOutputStream2;
            IoUtil.pipe(inputStream, fileOutputStream4, bArr);
            inputStream.close();
            fileOutputStream4.close();
            i++;
        }
    }

    public static String getClassPath(MinecraftVersion minecraftVersion) {
        StringBuilder sb;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(getDexPackFile(minecraftVersion2).getAbsolutePath());
        for (File file : getDexedLibsForVersion(minecraftVersion2)) {
            StringBuilder append2 = sb4.append(":");
            StringBuilder append3 = sb4.append(file.getAbsolutePath());
        }
        return sb4.toString();
    }

    public static File getDexPackFile(MinecraftVersion minecraftVersion) {
        File file;
        StringBuilder sb;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        File file2 = file;
        File file3 = dexPackDir;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        File file4 = new File(file3, sb2.append(minecraftVersion2.f184id).append(".jar").toString());
        return file2;
    }

    private static List<File> getDexedLibsForVersion(MinecraftVersion minecraftVersion) {
        ArrayList arrayList;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        DependentLibrary[] dependentLibraryArr = minecraftVersion2.libraries;
        int length = dependentLibraryArr.length;
        for (int i = 0; i < length; i++) {
            String[] split = dependentLibraryArr[i].name.split(":");
            File dexLocalPath = LibrariesRepository.getDexLocalPath(split[0], split[1], split[2]);
            if (dexLocalPath != null) {
                boolean add = arrayList4.add(dexLocalPath);
            }
        }
        return arrayList4;
    }

    public static int getShardCount() {
        return 2 * (((int) ((PlatformUtils.getTotalMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / 2);
    }

    public static void init(File file) {
        File file2;
        File file3;
        File file4;
        File file5;
        File file6;
        File file7;
        File file8 = file;
        launcherDir = file8;
        File file9 = file2;
        File file10 = new File(file8, "libraries");
        File file11 = file9;
        File[] fileArr = new File[2];
        File[] fileArr2 = fileArr;
        File[] fileArr3 = fileArr;
        File file12 = file3;
        File file13 = new File(file8, "override_libraries");
        fileArr3[0] = file12;
        File[] fileArr4 = fileArr2;
        File[] fileArr5 = fileArr4;
        fileArr4[1] = file11;
        LibrariesRepository.setLocalLibPath(fileArr5, file11);
        File file14 = file4;
        File file15 = new File(file8, "dexed_libraries");
        dexDir = file14;
        File file16 = file5;
        File file17 = new File(file8, "dex_pack");
        dexPackDir = file16;
        LibrariesRepository.setLocalDexPath(new File[]{dexDir}, dexDir);
        File file18 = file6;
        File file19 = new File(file8, "versions");
        MinecraftDownloader.versionsDir = file18;
        File file20 = file7;
        File file21 = new File(file8, "tmp");
        tmpDir = file20;
        boolean mkdirs = tmpDir.mkdirs();
    }

    public static void main(String[] strArr) throws Exception {
        File file;
        StringBuilder sb;
        String[] strArr2 = strArr;
        File file2 = file;
        File file3 = new File(strArr2[0]);
        init(file2);
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Launcher dir: ").append(launcherDir).append(" tmpDir: ").append(tmpDir).toString());
        if (strArr2.length < 2) {
            System.out.println("Needs to specify version");
            return;
        }
        javaVMCmd = Arrays.asList(new String[]{"java", "-server", "-classpath", System.getProperty("java.class.path")});
        String str = strArr2[1];
        String[] strArr3 = new String[7];
        String[] strArr4 = strArr3;
        strArr3[0] = "gson";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[1] = "jinput";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[2] = "jutils";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[3] = "lwjgl";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[4] = "lwjgl_util";
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[5] = "authlib";
        String[] strArr15 = strArr14;
        String[] strArr16 = strArr15;
        strArr15[6] = "realms";
        doPreDex(str, Arrays.asList(strArr16));
    }

    public static void runConvert(File file, File file2, boolean z, String str) throws Exception {
        File file3;
        File file4 = file;
        File file5 = file2;
        boolean z2 = z;
        String str2 = str;
        if (str2 == null) {
            str2 = "jarjarrules.txt";
        }
        boolean mkdirs = file5.getParentFile().mkdirs();
        File file6 = null;
        if (z2) {
            file6 = File.createTempFile(file4.getName(), "renamed.jar", tmpDir);
        }
        File createTempFile = File.createTempFile(file4.getName(), "dexed.jar", tmpDir);
        if (z2) {
            try {
                File file7 = file3;
                File file8 = new File(launcherDir, str2);
                runRename(file7, file4, file6);
                File[] fileArr = new File[1];
                File[] fileArr2 = fileArr;
                fileArr[0] = file6;
                runDex(Arrays.asList(fileArr2), createTempFile);
            } catch (Throwable th) {
                Throwable th2 = th;
                if (file6 != null) {
                    boolean delete = file6.delete();
                }
                boolean delete2 = createTempFile.delete();
                throw th2;
            }
        } else {
            File[] fileArr3 = new File[1];
            File[] fileArr4 = fileArr3;
            fileArr3[0] = file4;
            runDex(Arrays.asList(fileArr4), createTempFile);
        }
        boolean renameTo = createTempFile.renameTo(file5);
        if (file6 != null) {
            boolean delete3 = file6.delete();
        }
        boolean delete4 = createTempFile.delete();
    }

    public static void runDex(List<File> list, File file) {
        List<File> list2 = list;
        File file2 = file;
        String[] strArr = new String[3];
        String[] strArr2 = strArr;
        strArr[0] = "--num-threads=4";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "--no-optimize";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "--debug";
        List asList = Arrays.asList(strArr6);
        if (!((String) javaVMCmd.get(0)).equals("dalvikvm")) {
            String[] strArr7 = new String[2];
            String[] strArr8 = strArr7;
            strArr7[0] = "--num-threads=4";
            String[] strArr9 = strArr8;
            String[] strArr10 = strArr9;
            strArr9[1] = "--debug";
            asList = Arrays.asList(strArr10);
        }
        runDex(list2, file2, asList);
    }

    public static void runDex(List<File> list, File file, List<String> list2) {
        StringBuilder sb;
        StringBuilder sb2;
        ArrayList arrayList;
        RuntimeException runtimeException;
        List<File> list3 = list;
        File file2 = file;
        List<String> list4 = list2;
        PrintStream printStream = System.out;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        printStream.println(sb3.append("Running dex: ").append(list3).append(" out: ").append(file2).toString());
        String[] strArr = new String[2];
        strArr[0] = "--dex";
        String[] strArr2 = strArr;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        strArr2[1] = sb5.append("--output=").append(file2.getAbsolutePath()).toString();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(strArr.length + list3.size());
        ArrayList arrayList4 = arrayList2;
        boolean addAll = arrayList4.addAll(Arrays.asList(strArr));
        if (list4 != null) {
            boolean addAll2 = arrayList4.addAll(list4);
        }
        for (File absolutePath : list3) {
            boolean add = arrayList4.add(absolutePath.getAbsolutePath());
        }
        try {
            System.gc();
            runExt("net.zhuoweizhang.boardwalk.com.android.dx.command.Main", arrayList4);
            System.out.println("Done executing dex");
        } catch (Exception e) {
            Exception exc = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc);
            throw runtimeException2;
        }
    }

    public static void runExt(String str, List<String> list) throws IOException, InterruptedException {
        ArrayList arrayList;
        ProcessBuilder processBuilder;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        StringBuffer stringBuffer;
        RuntimeException runtimeException;
        StringBuilder sb;
        String str2 = str;
        List<String> list2 = list;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean addAll = arrayList4.addAll(javaVMCmd);
        boolean add = arrayList4.add("-Xms128M");
        boolean add2 = arrayList4.add("-Xmx768M");
        boolean add3 = arrayList4.add("-Xss256K");
        if (((String) javaVMCmd.get(0)).equals("dalvikvm") && PlatformUtils.getAndroidVersion() >= 17) {
            boolean add4 = arrayList4.add("-XX:HeapMaxFree=128M");
        }
        boolean add5 = arrayList4.add(str2);
        boolean addAll2 = arrayList4.addAll(list2);
        ProcessBuilder processBuilder2 = processBuilder;
        ProcessBuilder processBuilder3 = new ProcessBuilder(arrayList4);
        Process start = processBuilder2.redirectErrorStream(true).start();
        BufferedReader bufferedReader2 = bufferedReader;
        InputStreamReader inputStreamReader2 = inputStreamReader;
        InputStreamReader inputStreamReader3 = new InputStreamReader(start.getInputStream());
        BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
        BufferedReader bufferedReader4 = bufferedReader2;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        while (true) {
            String readLine = bufferedReader4.readLine();
            if (readLine == null) {
                break;
            }
            System.out.println(readLine);
            StringBuffer append = stringBuffer4.append(readLine);
            StringBuffer append2 = stringBuffer4.append(10);
        }
        int waitFor = start.waitFor();
        if (waitFor != 0) {
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            RuntimeException runtimeException3 = new RuntimeException(sb2.append("Dex returned ").append(waitFor).append(" with error: \n").append(stringBuffer4).toString());
            throw runtimeException2;
        }
    }

    public static void runRename(File file, File file2, File file3) {
        StringBuilder sb;
        RuntimeException runtimeException;
        File file4 = file;
        File file5 = file2;
        File file6 = file3;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Renaming: ").append(file5).append(" to ").append(file6).toString());
        boolean delete = file6.delete();
        try {
            Main.main(new String[]{"process", file4.getAbsolutePath(), file5.getAbsolutePath(), file6.getAbsolutePath()});
        } catch (Exception e) {
            Exception exc = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc);
            throw runtimeException2;
        }
    }
}
