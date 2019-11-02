package net.zhuoweizhang.boardwalk.downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import net.zhuoweizhang.boardwalk.model.MinecraftAssetInfo;
import net.zhuoweizhang.boardwalk.model.MinecraftAssets;

public class MinecraftAssetsDownloader {
    public static final String MINECRAFT_RES = "http://resources.download.minecraft.net/";

    public MinecraftAssetsDownloader() {
    }

    public static void downloadAsset(MinecraftAssetInfo minecraftAssetInfo, File file) throws IOException {
        StringBuilder sb;
        File file2;
        StringBuilder sb2;
        MinecraftAssetInfo minecraftAssetInfo2 = minecraftAssetInfo;
        File file3 = file;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        String sb5 = sb3.append(minecraftAssetInfo2.hash.substring(0, 2)).append("/").append(minecraftAssetInfo2.hash).toString();
        File file4 = file2;
        File file5 = new File(file3, sb5);
        File file6 = file4;
        if (!file6.exists()) {
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            DownloadUtils.downloadFile(sb6.append(MINECRAFT_RES).append(sb5).toString(), file6);
        }
    }

    public static void downloadAssets(String str, File file) throws IOException {
        File file2;
        StringBuilder sb;
        StringBuilder sb2;
        File file3;
        StringBuilder sb3;
        File file4;
        StringBuilder sb4;
        String str2 = str;
        File file5 = file;
        File file6 = file2;
        File file7 = file5;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        File file8 = new File(file7, sb5.append("downloaded/").append(str2).append(".downloaded").toString());
        File file9 = file6;
        if (!file9.exists()) {
            PrintStream printStream = System.out;
            StringBuilder sb7 = sb2;
            StringBuilder sb8 = new StringBuilder();
            printStream.println(sb7.append("Assets begin time: ").append(System.currentTimeMillis()).toString());
            String str3 = str2;
            File file10 = file3;
            File file11 = file5;
            StringBuilder sb9 = sb3;
            StringBuilder sb10 = new StringBuilder();
            File file12 = new File(file11, sb9.append("indexes/").append(str2).append(".json").toString());
            MinecraftAssets downloadIndex = downloadIndex(str3, file10);
            File file13 = file4;
            File file14 = new File(file5, "objects");
            File file15 = file13;
            for (MinecraftAssetInfo downloadAsset : downloadIndex.objects.values()) {
                downloadAsset(downloadAsset, file15);
            }
            boolean mkdirs = file9.getParentFile().mkdirs();
            boolean createNewFile = file9.createNewFile();
            PrintStream printStream2 = System.out;
            StringBuilder sb11 = sb4;
            StringBuilder sb12 = new StringBuilder();
            printStream2.println(sb11.append("Assets end time: ").append(System.currentTimeMillis()).toString());
        }
    }

    public static MinecraftAssets downloadIndex(String str, File file) throws IOException {
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        String str2 = str;
        File file2 = file;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String downloadString = DownloadUtils.downloadString(sb2.append("http://s3.amazonaws.com/Minecraft.Download/indexes/").append(str2).append(".json").toString());
        MinecraftAssets minecraftAssets = (MinecraftAssets) MinecraftDownloader.gson.fromJson(downloadString, MinecraftAssets.class);
        boolean mkdirs = file2.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        fileOutputStream4.write(downloadString.getBytes(Charset.forName("UTF-8")));
        fileOutputStream4.close();
        return minecraftAssets;
    }

    public static void main(String[] strArr) throws IOException {
        File file;
        String[] strArr2 = strArr;
        String str = strArr2[0];
        File file2 = file;
        File file3 = new File(strArr2[1]);
        downloadAssets(str, file2);
    }
}
