package net.zhuoweizhang.boardwalk;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.TextView;
import com.google.gson.Gson;
import java.util.UUID;
import net.minecraft.kdt.C0634R;
import net.zhuoweizhang.boardwalk.yggdrasil.RefreshResponse;
import net.zhuoweizhang.boardwalk.yggdrasil.YggdrasilAuthenticator;

public class RefreshAuthTokenTask extends AsyncTask<String, Void, String> {
    private LauncherActivity activity;
    private YggdrasilAuthenticator authenticator;
    private Gson gson;

    public RefreshAuthTokenTask(LauncherActivity launcherActivity) {
        YggdrasilAuthenticator yggdrasilAuthenticator;
        Gson gson2;
        LauncherActivity launcherActivity2 = launcherActivity;
        YggdrasilAuthenticator yggdrasilAuthenticator2 = yggdrasilAuthenticator;
        YggdrasilAuthenticator yggdrasilAuthenticator3 = new YggdrasilAuthenticator();
        this.authenticator = yggdrasilAuthenticator2;
        Gson gson3 = gson2;
        Gson gson4 = new Gson();
        this.gson = gson3;
        this.activity = launcherActivity2;
    }

    public String doInBackground(String... strArr) {
        String[] strArr2 = strArr;
        try {
            SharedPreferences sharedPreferences = this.activity.getSharedPreferences("launcher_prefs", 0);
            RefreshResponse refresh = this.authenticator.refresh(sharedPreferences.getString("auth_accessToken", null), UUID.fromString(sharedPreferences.getString("auth_clientId", sharedPreferences.getString("auth_clientToken", null))));
            if (refresh == null) {
                return "Response is null?";
            }
            if (refresh.selectedProfile == null) {
                return this.activity.getResources().getString(C0634R.string.control_right);
            }
            sharedPreferences.edit().putString("auth_clientId", refresh.clientToken.toString()).putString("auth_accessToken", refresh.accessToken).putString("auth_profile_name", refresh.selectedProfile.name).putString("auth_profile_id", refresh.selectedProfile.f185id).apply();
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
        if (str2 == null) {
            this.activity.refreshedToken = true;
        } else {
            this.activity.refreshedToken = false;
            TextView textView = this.activity.progressText;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            textView.setText(sb2.append(this.activity.getResources().getString(C0634R.string.control_thirdperson)).append(" ").append(str2).toString());
        }
        this.activity.updateUiWithLoginStatus();
    }

    public void onPreExecute() {
    }
}
