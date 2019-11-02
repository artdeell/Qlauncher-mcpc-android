package net.zhuoweizhang.boardwalk;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.TextView;
import java.util.UUID;
import net.minecraft.kdt.C0634R;
import net.zhuoweizhang.boardwalk.yggdrasil.AuthenticateResponse;
import net.zhuoweizhang.boardwalk.yggdrasil.YggdrasilAuthenticator;

public class LoginTask extends AsyncTask<String, Void, String> {
    private LauncherActivity activity;
    private YggdrasilAuthenticator authenticator;

    public LoginTask(LauncherActivity launcherActivity) {
        YggdrasilAuthenticator yggdrasilAuthenticator;
        LauncherActivity launcherActivity2 = launcherActivity;
        YggdrasilAuthenticator yggdrasilAuthenticator2 = yggdrasilAuthenticator;
        YggdrasilAuthenticator yggdrasilAuthenticator3 = new YggdrasilAuthenticator();
        this.authenticator = yggdrasilAuthenticator2;
        this.activity = launcherActivity2;
    }

    private UUID getClientId() {
        SharedPreferences sharedPreferences = this.activity.getSharedPreferences("launcher_prefs", 0);
        String string = sharedPreferences.getString("auth_clientId", null);
        boolean z = sharedPreferences.getBoolean("auth_importedCredentials", false);
        if (string != null && !z) {
            return UUID.fromString(string);
        }
        UUID randomUUID = UUID.randomUUID();
        sharedPreferences.edit().putString("auth_clientId", randomUUID.toString()).putBoolean("auth_importedCredentials", false).apply();
        return randomUUID;
    }

    public String doInBackground(String... strArr) {
        String[] strArr2 = strArr;
        try {
            AuthenticateResponse authenticate = this.authenticator.authenticate(strArr2[0], strArr2[1], getClientId());
            if (authenticate == null) {
                return "Response is null?";
            }
            if (authenticate.selectedProfile == null) {
                return this.activity.getResources().getString(C0634R.string.control_right);
            }
            this.activity.getSharedPreferences("launcher_prefs", 0).edit().putString("auth_accessToken", authenticate.accessToken).putString("auth_profile_name", authenticate.selectedProfile.name).putString("auth_profile_id", authenticate.selectedProfile.f185id).apply();
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
        this.activity.progressBar.setVisibility(8);
        this.activity.loginButton.setEnabled(true);
        if (str2 == null) {
            this.activity.progressText.setText(LibrariesRepository.MOJANG_MAVEN_REPO);
            this.activity.passwordText.setText(LibrariesRepository.MOJANG_MAVEN_REPO);
        } else {
            TextView textView = this.activity.progressText;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            textView.setText(sb2.append(this.activity.getResources().getString(C0634R.string.control_thirdperson)).append(" ").append(str2).toString());
        }
        this.activity.updateUiWithLoginStatus();
    }

    public void onPreExecute() {
        this.activity.progressBar.setVisibility(0);
        this.activity.loginButton.setEnabled(false);
        this.activity.importCredentialsButton.setEnabled(false);
        this.activity.progressText.setText(C0634R.string.control_down);
        SharedPreferences sharedPreferences = this.activity.getSharedPreferences("launcher_prefs", 0);
    }
}
