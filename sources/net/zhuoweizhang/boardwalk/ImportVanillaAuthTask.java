package net.zhuoweizhang.boardwalk;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.File;
import net.minecraft.kdt.C0634R;
import net.zhuoweizhang.boardwalk.model.vanillalauncher.LauncherAuth;
import net.zhuoweizhang.boardwalk.model.vanillalauncher.LauncherProfiles;
import net.zhuoweizhang.boardwalk.yggdrasil.RefreshResponse;
import net.zhuoweizhang.boardwalk.yggdrasil.YggdrasilAuthenticator;

public class ImportVanillaAuthTask extends AsyncTask<String, Void, String> {
    private LauncherActivity activity;
    private YggdrasilAuthenticator authenticator;
    private Gson gson;

    public ImportVanillaAuthTask(LauncherActivity launcherActivity) {
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

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private net.zhuoweizhang.boardwalk.model.vanillalauncher.LauncherProfiles getAuth(java.io.File r14) throws java.io.IOException {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r8 = 0
            r2 = r8
            r8 = r1
            long r8 = r8.length()
            int r8 = (int) r8
            byte[] r8 = new byte[r8]
            r3 = r8
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x0042 }
            r12 = r8
            r8 = r12
            r9 = r12
            r10 = r1
            r9.<init>(r10)     // Catch:{ all -> 0x0042 }
            r4 = r8
            r8 = r4
            r9 = r3
            int r8 = r8.read(r9)     // Catch:{ all -> 0x004d }
            r8 = r4
            if (r8 == 0) goto L_0x0024
            r8 = r4
            r8.close()
        L_0x0024:
            java.lang.String r8 = new java.lang.String
            r12 = r8
            r8 = r12
            r9 = r12
            r10 = r3
            java.lang.String r11 = "UTF-8"
            java.nio.charset.Charset r11 = java.nio.charset.Charset.forName(r11)
            r9.<init>(r10, r11)
            r7 = r8
            r8 = r0
            com.google.gson.Gson r8 = r8.gson
            r9 = r7
            java.lang.Class<net.zhuoweizhang.boardwalk.model.vanillalauncher.LauncherProfiles> r10 = net.zhuoweizhang.boardwalk.model.vanillalauncher.LauncherProfiles.class
            java.lang.Object r8 = r8.fromJson(r9, r10)
            net.zhuoweizhang.boardwalk.model.vanillalauncher.LauncherProfiles r8 = (net.zhuoweizhang.boardwalk.model.vanillalauncher.LauncherProfiles) r8
            r0 = r8
            return r0
        L_0x0042:
            r8 = move-exception
            r5 = r8
        L_0x0044:
            r8 = r2
            if (r8 == 0) goto L_0x004b
            r8 = r2
            r8.close()
        L_0x004b:
            r8 = r5
            throw r8
        L_0x004d:
            r8 = move-exception
            r5 = r8
            r8 = r4
            r2 = r8
            goto L_0x0044
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.ImportVanillaAuthTask.getAuth(java.io.File):net.zhuoweizhang.boardwalk.model.vanillalauncher.LauncherProfiles");
    }

    public String doInBackground(String... strArr) {
        File file;
        try {
            File file2 = file;
            File file3 = new File(strArr[0]);
            LauncherProfiles auth = getAuth(file2);
            RefreshResponse refresh = this.authenticator.refresh(((LauncherAuth) auth.authenticationDatabase.get(auth.selectedUser)).accessToken, auth.clientToken);
            if (refresh == null) {
                return "Response is null?";
            }
            if (refresh.selectedProfile == null) {
                return this.activity.getResources().getString(C0634R.string.control_right);
            }
            this.activity.getSharedPreferences("launcher_prefs", 0).edit().putString("auth_clientToken", refresh.clientToken.toString()).putString("auth_accessToken", refresh.accessToken).putString("auth_profile_name", refresh.selectedProfile.name).putString("auth_profile_id", refresh.selectedProfile.f185id).putBoolean("auth_importedCredentials", true).apply();
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
        this.activity.progressText.setText(C0634R.string.control_down);
        SharedPreferences sharedPreferences = this.activity.getSharedPreferences("launcher_prefs", 0);
    }
}
