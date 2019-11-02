package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzif.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzht extends zzb implements zzhw {
    private static final zzew zzKv;
    private final Map<String, zzia> zzKw;
    private boolean zzKx;

    static {
        zzew zzew;
        zzew zzew2 = zzew;
        zzew zzew3 = new zzew();
        zzKv = zzew2;
    }

    public zzht(Context context, zzd zzd, AdSizeParcel adSizeParcel, zzex zzex, VersionInfoParcel versionInfoParcel) {
        HashMap hashMap;
        super(context, adSizeParcel, null, zzex, versionInfoParcel, zzd);
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.zzKw = hashMap2;
    }

    private zza zzc(zza zza) {
        JSONObject jSONObject;
        zzen zzen;
        zzeo zzeo;
        zza zza2;
        zza zza3 = zza;
        zzin.m20v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject2 = zzhe.zzc(zza3.zzLe).toString();
            JSONObject jSONObject3 = jSONObject;
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = jSONObject3;
            JSONObject put = jSONObject5.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zza3.zzLd.zzrj);
            String jSONObject6 = jSONObject5.toString();
            zzen zzen2 = zzen;
            String str = jSONObject2;
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "com.google.ads.mediation.admob.AdMobAdapter";
            zzen zzen3 = new zzen(str, null, Arrays.asList(strArr2), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject6, null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null);
            zzen zzen4 = zzen2;
            zzeo zzeo2 = zzeo;
            zzen[] zzenArr = new zzen[1];
            zzen[] zzenArr2 = zzenArr;
            zzenArr[0] = zzen4;
            zzeo zzeo3 = new zzeo(Arrays.asList(zzenArr2), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), LibrariesRepository.MOJANG_MAVEN_REPO, -1, 0, 1, null, 0, -1, -1);
            zzeo zzeo4 = zzeo2;
            zza zza4 = zza2;
            zza zza5 = new zza(zza3.zzLd, zza3.zzLe, zzeo4, zza3.zzrp, zza3.errorCode, zza3.zzKY, zza3.zzKZ, zza3.zzKT);
            return zza4;
        } catch (JSONException e) {
            zzin.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return zzd(zza3);
        }
    }

    private zza zzd(zza zza) {
        zza zza2;
        zza zza3 = zza;
        zza zza4 = zza2;
        zza zza5 = new zza(zza3.zzLd, zza3.zzLe, null, zza3.zzrp, 0, zza3.zzKY, zza3.zzKZ, zza3.zzKT);
        return zza4;
    }

    public void destroy() {
        StringBuilder sb;
        zzx.zzcD("destroy must be called on the main UI thread.");
        for (String str : this.zzKw.keySet()) {
            try {
                zzia zzia = (zzia) this.zzKw.get(str);
                if (!(zzia == null || zzia.zzgP() == null)) {
                    zzia.zzgP().destroy();
                }
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaK(sb2.append("Fail to destroy adapter: ").append(str).toString());
            }
        }
    }

    public boolean isLoaded() {
        zzx.zzcD("isLoaded must be called on the main UI thread.");
        return this.zzpj.zzrn == null && this.zzpj.zzro == null && this.zzpj.zzrq != null && !this.zzKx;
    }

    public void onRewardedVideoAdClosed() {
        zzaQ();
    }

    public void onRewardedVideoAdLeftApplication() {
        zzaR();
    }

    public void onRewardedVideoAdOpened() {
        zza(this.zzpj.zzrq, false);
        zzaS();
    }

    public void onRewardedVideoStarted() {
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzCp == null)) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzCp.zzBH);
        }
        zzaU();
    }

    public void pause() {
        StringBuilder sb;
        zzx.zzcD("pause must be called on the main UI thread.");
        for (String str : this.zzKw.keySet()) {
            try {
                zzia zzia = (zzia) this.zzKw.get(str);
                if (!(zzia == null || zzia.zzgP() == null)) {
                    zzia.zzgP().pause();
                }
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaK(sb2.append("Fail to pause adapter: ").append(str).toString());
            }
        }
    }

    public void resume() {
        StringBuilder sb;
        zzx.zzcD("resume must be called on the main UI thread.");
        for (String str : this.zzKw.keySet()) {
            try {
                zzia zzia = (zzia) this.zzKw.get(str);
                if (!(zzia == null || zzia.zzgP() == null)) {
                    zzia.zzgP().resume();
                }
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                zzin.zzaK(sb2.append("Fail to resume adapter: ").append(str).toString());
            }
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel2 = rewardedVideoAdRequestParcel;
        zzx.zzcD("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel2.zzrj)) {
            zzin.zzaK("Invalid ad unit id. Aborting.");
            return;
        }
        this.zzKx = false;
        this.zzpj.zzrj = rewardedVideoAdRequestParcel2.zzrj;
        boolean zzb = super.zzb(rewardedVideoAdRequestParcel2.zzHt);
    }

    public void zza(zza zza, zzcb zzcb) {
        C03971 r9;
        zza zza2 = zza;
        zzcb zzcb2 = zzcb;
        if (zza2.errorCode != -2) {
            Handler handler = zzir.zzMc;
            C03971 r4 = r9;
            final zza zza3 = zza2;
            C03971 r5 = new Runnable(this) {
                final /* synthetic */ zzht zzKy;

                {
                    zza zza = r7;
                    this.zzKy = r6;
                }

                public void run() {
                    zzif zzif;
                    zzht zzht = this.zzKy;
                    zzif zzif2 = zzif;
                    zzif zzif3 = new zzif(zza3, null, null, null, null, null, null);
                    zzht.zzb(zzif2);
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        this.zzpj.zzrr = zza2;
        if (zza2.zzKV == null) {
            this.zzpj.zzrr = zzc(zza2);
        }
        this.zzpj.zzrL = 0;
        this.zzpj.zzro = zzr.zzbB().zza(this.zzpj.context, this.zzpj.getUserId(), this.zzpj.zzrr, this);
    }

    public boolean zza(zzif zzif, zzif zzif2) {
        zzif zzif3 = zzif;
        zzif zzif4 = zzif2;
        return true;
    }

    @Nullable
    public zzia zzaw(String str) {
        Throwable th;
        StringBuilder sb;
        zzia zzia;
        String str2 = str;
        zzia zzia2 = (zzia) this.zzKw.get(str2);
        if (zzia2 == null) {
            try {
                zzia zzia3 = zzia;
                zzia zzia4 = new zzia(("com.google.ads.mediation.admob.AdMobAdapter".equals(str2) ? zzKv : this.zzpn).zzaf(str2), this);
                zzia zzia5 = zzia3;
                try {
                    Object put = this.zzKw.put(str2, zzia5);
                    zzia2 = zzia5;
                } catch (Exception e) {
                    zzia2 = zzia5;
                    th = e;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    zzin.zzd(sb2.append("Fail to instantiate adapter ").append(str2).toString(), th);
                    return zzia2;
                }
            } catch (Exception e2) {
                th = e2;
                StringBuilder sb22 = sb;
                StringBuilder sb32 = new StringBuilder();
                zzin.zzd(sb22.append("Fail to instantiate adapter ").append(str2).toString(), th);
                return zzia2;
            }
        }
        return zzia2;
    }

    public void zzc(@Nullable RewardItemParcel rewardItemParcel) {
        RewardItemParcel rewardItemParcel2;
        RewardItemParcel rewardItemParcel3 = rewardItemParcel;
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzCp == null)) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzCp.zzBI);
        }
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzKV == null || TextUtils.isEmpty(this.zzpj.zzrq.zzKV.zzBV))) {
            RewardItemParcel rewardItemParcel4 = rewardItemParcel2;
            RewardItemParcel rewardItemParcel5 = new RewardItemParcel(this.zzpj.zzrq.zzKV.zzBV, this.zzpj.zzrq.zzKV.zzBW);
            rewardItemParcel3 = rewardItemParcel4;
        }
        zza(rewardItemParcel3);
    }

    public void zzgL() {
        zzx.zzcD("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzin.zzaK("The reward video has not loaded.");
            return;
        }
        this.zzKx = true;
        zzia zzaw = zzaw(this.zzpj.zzrq.zzCr);
        if (zzaw != null && zzaw.zzgP() != null) {
            try {
                zzaw.zzgP().showVideo();
            } catch (RemoteException e) {
                zzin.zzd("Could not call showVideo.", e);
            }
        }
    }

    public void zzgM() {
        onAdClicked();
    }
}
