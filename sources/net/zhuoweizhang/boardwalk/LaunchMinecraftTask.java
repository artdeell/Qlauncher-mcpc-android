package net.zhuoweizhang.boardwalk;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import net.zhuoweizhang.boardwalk.downloader.MinecraftAssetsDownloader;
import net.zhuoweizhang.boardwalk.downloader.MinecraftDownloader;
import net.zhuoweizhang.boardwalk.downloader.MinecraftLaunch;
import net.zhuoweizhang.boardwalk.model.DependentLibrary;
import net.zhuoweizhang.boardwalk.model.MinecraftVersion;
import net.zhuoweizhang.boardwalk.util.AssetsUtil;
import net.zhuoweizhang.boardwalk.util.IoUtil;

public class LaunchMinecraftTask extends AsyncTask<Void, String, String> {
    public static final int MY_VERSION = 8;
    private Thread assetsThread;
    private Context context;
    private boolean forceDex;
    private Listener listener;

    public interface Listener {
        void onLaunchError();

        void onProgressUpdate(String str);
    }

    public LaunchMinecraftTask(Context context2, Listener listener2) {
        Listener listener3 = listener2;
        this.context = context2;
        this.listener = listener3;
    }

    private void dexOptMinecraft(MinecraftVersion minecraftVersion) {
        DexClassLoader dexClassLoader;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        publishProgress(new String[]{this.context.getResources().getString(C0646R.string.convert_preparing_to_launch_minecraft)});
        File dir = this.context.getDir("dalvik-cache", 0);
        boolean mkdirs = dir.mkdirs();
        DexClassLoader dexClassLoader2 = dexClassLoader;
        DexClassLoader dexClassLoader3 = new DexClassLoader(MinecraftLaunch.getClassPath(minecraftVersion2), dir.getAbsolutePath(), LibrariesRepository.MOJANG_MAVEN_REPO, getClass().getClassLoader());
    }

    private void downloadLibraries(MinecraftVersion minecraftVersion) throws Exception {
        StringBuilder sb;
        StringBuilder sb2;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        DependentLibrary[] dependentLibraryArr = minecraftVersion2.libraries;
        int length = dependentLibraryArr.length;
        for (int i = 0; i < length; i++) {
            DependentLibrary dependentLibrary = dependentLibraryArr[i];
            String[] split = dependentLibrary.name.split(":");
            if (LibrariesRepository.needsDownload(split[0], split[1], split[2])) {
                try {
                    String[] strArr = new String[1];
                    String[] strArr2 = strArr;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    strArr2[0] = sb3.append(this.context.getResources().getString(C0646R.string.convert_downloading)).append(" ").append(dependentLibrary.name).toString();
                    publishProgress(strArr);
                    MinecraftDownloader.downloadLibrary(dependentLibrary);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        DependentLibrary[] dependentLibraryArr2 = minecraftVersion2.libraries;
        int length2 = dependentLibraryArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            DependentLibrary dependentLibrary2 = dependentLibraryArr2[i2];
            String[] split2 = dependentLibrary2.name.split(":");
            File localPath = LibrariesRepository.getLocalPath(split2[0], split2[1], split2[2]);
            if (localPath != null && LibrariesRepository.getDexLocalPath(split2[0], split2[1], split2[2]) == null) {
                String[] strArr3 = new String[1];
                String[] strArr4 = strArr3;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                strArr4[0] = sb5.append(this.context.getResources().getString(C0646R.string.convert_converting)).append(" ").append(dependentLibrary2.name).toString();
                publishProgress(strArr3);
                MinecraftLaunch.runConvert(localPath, LibrariesRepository.getDexTargetPath(split2[0], split2[1], split2[2]), true, null);
            }
        }
    }

    private void downloadMinecraft(MinecraftVersion minecraftVersion) throws Exception {
        StringBuilder sb;
        StringBuilder sb2;
        MinecraftVersion minecraftVersion2 = minecraftVersion;
        if (!MinecraftDownloader.getMinecraftVersionFile(minecraftVersion2).exists()) {
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            strArr2[0] = sb3.append(this.context.getResources().getString(C0646R.string.convert_downloading)).append(" Minecraft ").append(minecraftVersion2.f184id).toString();
            publishProgress(strArr);
            MinecraftDownloader.downloadMinecraftVersion(minecraftVersion2);
        }
        if (this.forceDex || !MinecraftLaunch.canUseExistingDexPack(minecraftVersion2)) {
            String[] strArr3 = new String[1];
            String[] strArr4 = strArr3;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            strArr4[0] = sb5.append(this.context.getResources().getString(C0646R.string.convert_converting)).append(" Minecraft ").append(minecraftVersion2.f184id).toString();
            publishProgress(strArr3);
            MinecraftLaunch.createDexPack(minecraftVersion2);
        }
    }

    private void extractDefaultOptions() throws IOException {
        File file;
        File file2;
        File file3;
        File file4;
        File file5 = file;
        File file6 = new File("/sdcard/boardwalk");
        File file7 = file5;
        File file8 = file2;
        File file9 = new File(file7, "gamedir");
        File file10 = file8;
        boolean mkdirs = file10.mkdirs();
        File file11 = file3;
        File file12 = new File(file10, "options.txt");
        File file13 = file11;
        if (!file13.exists()) {
            AssetsUtil.extractFileFromAssets(this.context, "options.txt", file13);
        }
        File file14 = file4;
        File file15 = new File(file7, ".nomedia");
        File file16 = file14;
        if (!file16.exists()) {
            boolean createNewFile = file16.createNewFile();
        }
    }

    private int getLauncherDirVersion() {
        return this.context.getSharedPreferences("launcher_prefs", 0).getInt("working_dir_version", 0);
    }

    private MinecraftVersion getMinecraftVersion(String str) throws IOException {
        return MinecraftDownloader.getVersionInfo(str);
    }

    private void populateWorkingDir() throws IOException {
        File file;
        File file2;
        publishProgress(new String[]{this.context.getResources().getString(C0646R.string.convert_populating_working_directory)});
        File file3 = MinecraftLaunch.dexDir;
        if (this.forceDex) {
            IoUtil.clearDirectory(file3);
        }
        AssetsUtil.extractDirFromAssets(this.context, "dexed_libraries", file3);
        File file4 = file;
        File file5 = new File(MinecraftLaunch.launcherDir, "jarjarrules.txt");
        AssetsUtil.extractFileFromAssets(this.context, "jarjarrules.txt", file4);
        File file6 = file2;
        File file7 = new File(MinecraftLaunch.launcherDir, "jarjarrules_minecraft.txt");
        AssetsUtil.extractFileFromAssets(this.context, "jarjarrules_minecraft.txt", file6);
        writeLauncherDirVersion();
    }

    public static void setupWorkingDir(Context context2) {
        StringBuilder sb;
        Context context3 = context2;
        MinecraftLaunch.init(context3.getDir("working_dir", 0));
        String[] strArr = new String[4];
        strArr[0] = "dalvikvm";
        String[] strArr2 = strArr;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        strArr2[1] = sb2.append("-Djava.library.path=").append(System.getProperty("java.library.path")).toString();
        strArr[2] = "-classpath";
        strArr[3] = context3.getPackageCodePath();
        MinecraftLaunch.javaVMCmd = Arrays.asList(strArr);
    }

    private void startAssetsDownload(MinecraftVersion minecraftVersion) {
        Thread thread;
        C06371 r9;
        Thread thread2 = thread;
        C06371 r5 = r9;
        final String str = minecraftVersion.assets;
        C06371 r6 = new Runnable(this) {
            final /* synthetic */ LaunchMinecraftTask this$0;

            {
                String str = r7;
                this.this$0 = r6;
            }

            public void run() {
                File file;
                try {
                    String str = str;
                    File file2 = file;
                    File file3 = new File("/sdcard/boardwalk/gamedir/assets");
                    MinecraftAssetsDownloader.downloadAssets(str, file2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread3 = new Thread(r5);
        this.assetsThread = thread2;
        this.assetsThread.start();
    }

    private void waitForAssetsDownload() {
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = "Waiting for sound and language files to download...";
        publishProgress(strArr2);
        try {
            this.assetsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void writeLauncherDirVersion() {
        this.context.getSharedPreferences("launcher_prefs", 0).edit().putInt("working_dir_version", 8).apply();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (r6.exists() != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doInBackground(java.lang.Void... r12) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r6 = 0
            android.os.Process.setThreadPriority(r6)
            r6 = r0
            android.content.Context r6 = r6.context     // Catch:{ Exception -> 0x0099 }
            setupWorkingDir(r6)     // Catch:{ Exception -> 0x0099 }
            r6 = r0
            int r6 = r6.getLauncherDirVersion()     // Catch:{ Exception -> 0x0099 }
            r7 = 8
            if (r6 != r7) goto L_0x0029
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0099 }
            r10 = r6
            r6 = r10
            r7 = r10
            java.lang.String r8 = "/sdcard/boardwalk/dexme"
            r7.<init>(r8)     // Catch:{ Exception -> 0x0099 }
            boolean r6 = r6.exists()     // Catch:{ Exception -> 0x0099 }
            r5 = r6
            r6 = 0
            r3 = r6
            r6 = r5
            if (r6 == 0) goto L_0x002b
        L_0x0029:
            r6 = 1
            r3 = r6
        L_0x002b:
            r6 = r0
            r7 = r3
            r6.forceDex = r7     // Catch:{ Exception -> 0x0099 }
            r6 = r0
            r7 = r0
            android.content.Context r7 = r7.context     // Catch:{ Exception -> 0x0099 }
            java.lang.String r8 = "launcher_prefs"
            r9 = 0
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r8, r9)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r8 = "selected_version"
            java.lang.String r9 = "1.9"
            java.lang.String r7 = r7.getString(r8, r9)     // Catch:{ Exception -> 0x0099 }
            net.zhuoweizhang.boardwalk.model.MinecraftVersion r6 = r6.getMinecraftVersion(r7)     // Catch:{ Exception -> 0x0099 }
            r4 = r6
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ Exception -> 0x0099 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r10 = r7
            r7 = r10
            r8 = r10
            r8.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r8 = "Can use existing dex pack: "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ Exception -> 0x0099 }
            r8 = r4
            boolean r8 = net.zhuoweizhang.boardwalk.downloader.MinecraftLaunch.canUseExistingDexPack(r8)     // Catch:{ Exception -> 0x0099 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0099 }
            r6.println(r7)     // Catch:{ Exception -> 0x0099 }
            r6 = r0
            r7 = r4
            r6.startAssetsDownload(r7)     // Catch:{ Exception -> 0x0099 }
            r6 = r0
            boolean r6 = r6.forceDex     // Catch:{ Exception -> 0x0099 }
            if (r6 != 0) goto L_0x0078
            r6 = r4
            boolean r6 = net.zhuoweizhang.boardwalk.downloader.MinecraftLaunch.canUseExistingDexPack(r6)     // Catch:{ Exception -> 0x0099 }
            if (r6 != 0) goto L_0x008b
        L_0x0078:
            r6 = r0
            r6.populateWorkingDir()     // Catch:{ Exception -> 0x0099 }
            r6 = r0
            r7 = r4
            r6.downloadLibraries(r7)     // Catch:{ Exception -> 0x0099 }
            r6 = r0
            r7 = r4
            r6.downloadMinecraft(r7)     // Catch:{ Exception -> 0x0099 }
            r6 = r0
            r7 = r4
            r6.dexOptMinecraft(r7)     // Catch:{ Exception -> 0x0099 }
        L_0x008b:
            r6 = r0
            r6.waitForAssetsDownload()     // Catch:{ Exception -> 0x0099 }
            r6 = r0
            r6.extractDefaultOptions()     // Catch:{ Exception -> 0x0099 }
            java.lang.System.gc()
            r6 = 0
            r0 = r6
        L_0x0098:
            return r0
        L_0x0099:
            r6 = move-exception
            r2 = r6
            r6 = r2
            r6.printStackTrace()
            r6 = r2
            java.lang.String r6 = r6.toString()
            r0 = r6
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.LaunchMinecraftTask.doInBackground(java.lang.Void[]):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        Intent intent;
        StringBuilder sb;
        String str2 = str;
        if (str2 != null) {
            Listener listener2 = this.listener;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            listener2.onProgressUpdate(sb2.append("Device: ").append(Build.MANUFACTURER).append(" ").append(Build.MODEL).append(" Android ").append(VERSION.RELEASE).append("\nError: ").append(str2).toString());
            this.listener.onLaunchError();
            return;
        }
        Context context2 = this.context;
        Intent intent2 = intent;
        Intent intent3 = new Intent(this.context, MainActivity.class);
        context2.startActivity(intent2);
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(String... strArr) {
        StringBuilder sb;
        String[] strArr2 = strArr;
        Listener listener2 = this.listener;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        listener2.onProgressUpdate(sb2.append("Installing - this should take about 4 minutes. Please don't leave this application during the install process. ").append(strArr2[0]).toString());
    }
}
