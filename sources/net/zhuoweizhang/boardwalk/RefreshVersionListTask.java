package net.zhuoweizhang.boardwalk;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;
import net.zhuoweizhang.boardwalk.downloader.MinecraftDownloader;
import net.zhuoweizhang.boardwalk.model.MinecraftVersionList;
import net.zhuoweizhang.boardwalk.model.MinecraftVersionList.Version;

public class RefreshVersionListTask extends AsyncTask<String, Void, String> {
    private LauncherActivity activity;
    private MinecraftVersionList versionList;
    private List<String> versionStringList;

    public RefreshVersionListTask(LauncherActivity launcherActivity) {
        this.activity = launcherActivity;
    }

    public String doInBackground(String... strArr) {
        ArrayList arrayList;
        String[] strArr2 = strArr;
        try {
            this.versionList = MinecraftDownloader.downloadVersionList();
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(this.versionList.versions.length);
            this.versionStringList = arrayList2;
            Version[] versionArr = this.versionList.versions;
            int length = versionArr.length;
            for (int i = 0; i < length; i++) {
                boolean add = this.versionStringList.add(versionArr[i].f184id);
            }
            return null;
        } catch (Exception e) {
            Exception exc = e;
            exc.printStackTrace();
            return exc.toString();
        }
    }

    public void onPostExecute(String str) {
        if (str == null) {
            this.activity.addToVersionSpinner(this.versionStringList);
        }
    }

    public void onPreExecute() {
    }
}
