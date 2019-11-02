package net.zhuoweizhang.boardwalk.downloader;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.model.DependentLibrary;
import net.zhuoweizhang.boardwalk.model.MinecraftVersion;
import net.zhuoweizhang.boardwalk.model.MinecraftVersionList;

public class MinecraftDownloader {
    public static final String MINECRAFT_ASSETS = "http://s3.amazonaws.com/Minecraft.Download/";
    public static Gson gson;
    public static boolean useMavenCentral = false;
    public static File versionsDir;

    static {
        Gson gson2;
        Gson gson3 = gson2;
        Gson gson4 = new Gson();
        gson = gson3;
    }

    public MinecraftDownloader() {
    }

    public static void downloadLibraries(MinecraftVersion minecraftVersion) throws IOException {
        DependentLibrary[] dependentLibraryArr = minecraftVersion.libraries;
        int length = dependentLibraryArr.length;
        for (int i = 0; i < length; i++) {
            String[] split = dependentLibraryArr[i].name.split(":");
            if (LibrariesRepository.needsDownload(split[0], split[1], split[2])) {
                downloadLibrary(split[0], split[1], split[2]);
            }
        }
    }

    public static void downloadLibrary(String str, String str2, String str3) throws IOException {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        DownloadUtils.downloadFile(getLibraryDownloadUrl(str4, str5, str6), LibrariesRepository.getDownloadTargetPath(str4, str5, str6));
    }

    public static void downloadLibrary(DependentLibrary dependentLibrary) throws IOException {
        String[] split = dependentLibrary.name.split(":");
        downloadLibrary(split[0], split[1], split[2]);
    }

    public static void downloadMinecraftVersion(MinecraftVersion minecraftVersion) throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        File file;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        String sb5 = sb3.append(minecraftVersion2.f184id).append("/").append(minecraftVersion2.f184id).append(".jar").toString();
        StringBuilder sb6 = sb2;
        StringBuilder sb7 = new StringBuilder();
        String sb8 = sb6.append("http://s3.amazonaws.com/Minecraft.Download/versions/").append(sb5).toString();
        File file2 = file;
        File file3 = new File(versionsDir, sb5);
        DownloadUtils.downloadFile(sb8, file2);
    }

    public static MinecraftVersion downloadVersionInfo(String str) throws IOException {
        StringBuilder sb;
        StringBuilder sb2;
        File file;
        FileOutputStream fileOutputStream;
        String str2 = str;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        String downloadString = DownloadUtils.downloadString(sb3.append("http://s3.amazonaws.com/Minecraft.Download/versions/").append(str2).append("/").append(str2).append(".json").toString());
        MinecraftVersion minecraftVersion = (MinecraftVersion) gson.fromJson(downloadString, MinecraftVersion.class);
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        String sb7 = sb5.append(minecraftVersion.f184id).append("/").append(minecraftVersion.f184id).append(".json").toString();
        File file2 = file;
        File file3 = new File(versionsDir, sb7);
        File file4 = file2;
        boolean mkdirs = file4.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(file4);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        fileOutputStream4.write(downloadString.getBytes(Charset.forName("UTF-8")));
        fileOutputStream4.close();
        return minecraftVersion;
    }

    public static MinecraftVersionList downloadVersionList() throws IOException {
        return (MinecraftVersionList) gson.fromJson(DownloadUtils.downloadString("http://s3.amazonaws.com/Minecraft.Download/versions/versions.json"), MinecraftVersionList.class);
    }

    public static String getLibraryDownloadUrl(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        String artifactToPath = LibrariesRepository.artifactToPath(str, str2, str3);
        if (useMavenCentral) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            return sb3.append("https://repo1.maven.org/maven2/").append(artifactToPath).toString();
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        return sb5.append("https://libraries.minecraft.net/").append(artifactToPath).toString();
    }

    public static File getMinecraftVersionFile(MinecraftVersion minecraftVersion) {
        StringBuilder sb;
        File file;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append(minecraftVersion2.f184id).append("/").append(minecraftVersion2.f184id).append(".jar").toString();
        File file2 = file;
        File file3 = new File(versionsDir, sb4);
        return file2;
    }

    public static MinecraftVersion getVersionInfo(String str) throws IOException {
        StringBuilder sb;
        File file;
        FileInputStream fileInputStream;
        String str2;
        String str3 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append(str3).append("/").append(str3).append(".json").toString();
        File file2 = file;
        File file3 = new File(versionsDir, sb4);
        File file4 = file2;
        if (!file4.exists()) {
            return downloadVersionInfo(str3);
        }
        byte[] bArr = new byte[((int) file4.length())];
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file4);
        FileInputStream fileInputStream4 = fileInputStream2;
        int read = fileInputStream4.read(bArr);
        fileInputStream4.close();
        String str4 = str2;
        String str5 = new String(bArr, Charset.forName("UTF-8"));
        return (MinecraftVersion) gson.fromJson(str4, MinecraftVersion.class);
    }
}
