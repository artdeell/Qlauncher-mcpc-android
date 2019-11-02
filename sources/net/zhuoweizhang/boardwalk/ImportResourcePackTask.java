package net.zhuoweizhang.boardwalk;

import android.os.AsyncTask;
import android.widget.TextView;
import java.io.File;
import net.zhuoweizhang.boardwalk.util.IoUtil;

public class ImportResourcePackTask extends AsyncTask<File, Void, String> {
    private LauncherActivity activity;

    public ImportResourcePackTask(LauncherActivity launcherActivity) {
        this.activity = launcherActivity;
    }

    public String doInBackground(File... fileArr) {
        File file;
        try {
            File file2 = fileArr[0];
            File file3 = file2;
            File file4 = file;
            File file5 = new File("/sdcard/boardwalk/gamedir/resourcepacks", file2.getName());
            IoUtil.copy(file3, file4, new byte[65536]);
            return null;
        } catch (Exception e) {
            Exception exc = e;
            exc.printStackTrace();
            return exc.toString();
        }
    }

    public void onPostExecute(String str) {
        StringBuilder sb;
        String str2 = str;
        this.activity.importResourcePackButton.setEnabled(true);
        if (str2 == null) {
            this.activity.progressText.setText("Added your pack to the list of resource packs");
            return;
        }
        TextView textView = this.activity.progressText;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        textView.setText(sb2.append("Unable to import resource pack: ").append(str2).toString());
    }

    public void onPreExecute() {
        this.activity.importResourcePackButton.setEnabled(false);
    }
}
