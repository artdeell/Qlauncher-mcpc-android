package com.kdtmarken.mojangauth;

import android.os.AsyncTask;
import com.google.gson.Gson;
import java.util.UUID;
import net.minecraft.kdt.MCProfile;
import net.minecraft.kdt.MCProfile.Builder;
import net.zhuoweizhang.boardwalk.yggdrasil.RefreshResponse;
import net.zhuoweizhang.boardwalk.yggdrasil.YggdrasilAuthenticator;

public class RefreshTokenTask extends AsyncTask<String, Void, String> {
    private YggdrasilAuthenticator authenticator;
    private Gson gson;
    private RefreshListener listener;
    private Builder profilePath;
    private boolean refreshedToken;

    public /* bridge */ Object doInBackground(Object[] objArr) {
        return doInBackground((String[]) objArr);
    }

    public /* bridge */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    public void onPreExecute() {
    }

    public RefreshTokenTask(RefreshListener refreshListener) {
        YggdrasilAuthenticator yggdrasilAuthenticator;
        Gson gson2;
        RefreshListener refreshListener2 = refreshListener;
        YggdrasilAuthenticator yggdrasilAuthenticator2 = yggdrasilAuthenticator;
        YggdrasilAuthenticator yggdrasilAuthenticator3 = new YggdrasilAuthenticator();
        this.authenticator = yggdrasilAuthenticator2;
        Gson gson3 = gson2;
        Gson gson4 = new Gson();
        this.gson = gson3;
        this.listener = refreshListener2;
    }

    public String doInBackground(String... strArr) {
        try {
            this.profilePath = MCProfile.load(strArr[0]);
            RefreshResponse refresh = this.authenticator.refresh(this.profilePath.getAccessToken(), UUID.fromString(this.profilePath.getClientID()));
            if (refresh == null) {
                return "Response is null?";
            }
            if (refresh.selectedProfile == null) {
                return "Can't refresh a demo account";
            }
            this.profilePath.setClientID(refresh.clientToken.toString());
            this.profilePath.setAccessToken(refresh.accessToken);
            this.profilePath.setNickname(refresh.selectedProfile.name);
            this.profilePath.setProfileID(refresh.selectedProfile.f185id);
            String build = MCProfile.build(this.profilePath);
            return null;
        } catch (Exception e) {
            Exception exc = e;
            exc.printStackTrace();
            this.listener.onException(exc);
            return exc.toString();
        }
    }

    public void onPostExecute(String str) {
        String str2 = str;
        if (str2 == null) {
            this.refreshedToken = true;
        } else {
            this.refreshedToken = false;
        }
        this.listener.onRefreshDone(this.refreshedToken, str2);
    }
}
