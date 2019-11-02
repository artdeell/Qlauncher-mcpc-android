package com.kdtmarken.mojangauth;

import android.os.AsyncTask;
import com.kdtmarken.mojangauth.yggdrasil.AuthenticateResponse;
import com.kdtmarken.mojangauth.yggdrasil.YggdrasilAuthenticator;
import java.util.ArrayList;
import java.util.UUID;

public class LoginTask extends AsyncTask<String, Void, String[]> {
    private String TAG = "MojangAuth-login";
    private YggdrasilAuthenticator authenticator;
    private LoginListener listener;

    /* access modifiers changed from: protected */
    public /* bridge */ Object doInBackground(Object[] objArr) {
        return doInBackground((String[]) objArr);
    }

    /* access modifiers changed from: protected */
    public /* bridge */ void onPostExecute(Object obj) {
        onPostExecute((String[]) obj);
    }

    public LoginTask setLoginListener(LoginListener loginListener) {
        this.listener = loginListener;
        return this;
    }

    private UUID getRandomUUID() {
        return UUID.randomUUID();
    }

    /* access modifiers changed from: protected */
    @Override
    public void onPreExecute() {
        this.listener.onBeforeLogin();
        super.onPreExecute();
    }

    /* access modifiers changed from: protected */
    @Override
    public String[] doInBackground(String[] strArr) {
        ArrayList arrayList;
        String[] strArr2 = strArr;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add("ERROR");
        try {
            AuthenticateResponse authenticate = this.authenticator.authenticate(strArr2[0], strArr2[1], getRandomUUID());
            if (authenticate.selectedProfile == null) {
                boolean add2 = arrayList4.add("Can't login a demo account\n");
            } else {
                boolean add3 = arrayList4.add(authenticate.accessToken);
                boolean add4 = arrayList4.add(authenticate.clientToken.toString());
                boolean add5 = arrayList4.add(authenticate.selectedProfile.f14id);
                boolean add6 = arrayList4.add(authenticate.selectedProfile.name);
                Object obj = arrayList4.set(0, "NORMAL");
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                boolean add7 = arrayList4.add(th2.getMessage());
            } catch (Exception e) {
                boolean add8 = arrayList4.add(e.getMessage());
            }
        }
        return (String[]) arrayList4.toArray(new String[0]);
    }

    /* access modifiers changed from: protected */
    @Override
    public void onPostExecute(String[] strArr) {
        String[] strArr2 = strArr;
        this.listener.onLoginDone(strArr2);
        super.onPostExecute(strArr2);
    }

    public LoginTask() {
        YggdrasilAuthenticator yggdrasilAuthenticator;
        YggdrasilAuthenticator yggdrasilAuthenticator2 = yggdrasilAuthenticator;
        YggdrasilAuthenticator yggdrasilAuthenticator3 = new YggdrasilAuthenticator();
        this.authenticator = yggdrasilAuthenticator2;
    }
}
