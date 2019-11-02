package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;

public class zzh extends zzj<zze> implements zzrn {
    private final zzf zzahz;
    private Integer zzale;
    private final Bundle zzbgU;
    private final boolean zzbhi;

    public zzh(Context context, Looper looper, boolean z, zzf zzf, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        boolean z2 = z;
        zzf zzf2 = zzf;
        Bundle bundle2 = bundle;
        super(context, looper, 44, zzf2, connectionCallbacks, onConnectionFailedListener);
        this.zzbhi = z2;
        this.zzahz = zzf2;
        this.zzbgU = bundle2;
        this.zzale = zzf2.zzqz();
    }

    public zzh(Context context, Looper looper, boolean z, zzf zzf, zzro zzro, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzf zzf2 = zzf;
        zzro zzro2 = zzro;
        this(context, looper, z, zzf2, zza(zzf2), connectionCallbacks, onConnectionFailedListener);
    }

    private ResolveAccountRequest zzFN() {
        ResolveAccountRequest resolveAccountRequest;
        Account zzqq = this.zzahz.zzqq();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(zzqq.name)) {
            googleSignInAccount = zzq.zzaf(getContext()).zzno();
        }
        ResolveAccountRequest resolveAccountRequest2 = resolveAccountRequest;
        ResolveAccountRequest resolveAccountRequest3 = new ResolveAccountRequest(zzqq, this.zzale.intValue(), googleSignInAccount);
        return resolveAccountRequest2;
    }

    public static Bundle zza(zzf zzf) {
        Bundle bundle;
        zzf zzf2 = zzf;
        zzro zzqy = zzf2.zzqy();
        Integer zzqz = zzf2.zzqz();
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        Bundle bundle4 = bundle2;
        bundle4.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzf2.getAccount());
        if (zzqz != null) {
            bundle4.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzqz.intValue());
        }
        if (zzqy != null) {
            bundle4.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzqy.zzFH());
            bundle4.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzqy.zzmO());
            bundle4.putString("com.google.android.gms.signin.internal.serverClientId", zzqy.zzmR());
            bundle4.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle4.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzqy.zzmQ());
            bundle4.putString("com.google.android.gms.signin.internal.hostedDomain", zzqy.zzmS());
            bundle4.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzqy.zzFI());
        }
        return bundle4;
    }

    public void connect() {
        zzf zzf;
        zzf zzf2 = zzf;
        zzf zzf3 = new zzf(this);
        zza((zza) zzf2);
    }

    public void zzFG() {
        try {
            ((zze) zzqJ()).zzka(this.zzale.intValue());
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            int w = Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void zza(zzp zzp, boolean z) {
        try {
            ((zze) zzqJ()).zza(zzp, this.zzale.intValue(), z);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            int w = Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzd zzd) {
        SignInResponse signInResponse;
        SignInRequest signInRequest;
        zzd zzd2 = zzd;
        Object zzb = zzx.zzb(zzd2, (Object) "Expecting a valid ISignInCallbacks");
        try {
            zze zze = (zze) zzqJ();
            SignInRequest signInRequest2 = signInRequest;
            SignInRequest signInRequest3 = new SignInRequest(zzFN());
            zze.zza(signInRequest2, zzd2);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            int w = Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            zzd zzd3 = zzd2;
            try {
                SignInResponse signInResponse2 = signInResponse;
                SignInResponse signInResponse3 = new SignInResponse(8);
                zzd3.zzb(signInResponse2);
            } catch (RemoteException e2) {
                RemoteException remoteException2 = e2;
                int wtf = Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", remoteException);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzec */
    public zze zzW(IBinder iBinder) {
        return zze.zza.zzeb(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public boolean zzmE() {
        return this.zzbhi;
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        if (!getContext().getPackageName().equals(this.zzahz.zzqv())) {
            this.zzbgU.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzahz.zzqv());
        }
        return this.zzbgU;
    }
}
