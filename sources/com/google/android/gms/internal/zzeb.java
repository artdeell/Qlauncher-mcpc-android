package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public class zzeb extends zza {
    private zzk zzAD;
    private zzdx zzAJ;
    private zzgh zzAK;
    private String zzAL;
    private zzdv zzAz;
    private String zzpS;

    public zzeb(Context context, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        zzdv zzdv;
        String str2 = str;
        zzdv zzdv2 = zzdv;
        zzdv zzdv3 = new zzdv(context.getApplicationContext(), zzex, versionInfoParcel, zzd);
        this(str2, zzdv2);
    }

    public zzeb(String str, zzdv zzdv) {
        zzdx zzdx;
        zzdv zzdv2 = zzdv;
        this.zzpS = str;
        this.zzAz = zzdv2;
        zzdx zzdx2 = zzdx;
        zzdx zzdx3 = new zzdx();
        this.zzAJ = zzdx2;
        zzr.zzbN().zza(zzdv2);
    }

    private void zzel() {
        if (this.zzAD != null && this.zzAK != null) {
            this.zzAD.zza(this.zzAK, this.zzAL);
        }
    }

    /* access modifiers changed from: 0000 */
    public void abort() {
        if (this.zzAD == null) {
            this.zzAD = this.zzAz.zzX(this.zzpS);
            this.zzAJ.zzc(this.zzAD);
            zzel();
        }
    }

    public void destroy() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.destroy();
        }
    }

    public String getMediationAdapterClassName() throws RemoteException {
        if (this.zzAD != null) {
            return this.zzAD.getMediationAdapterClassName();
        }
        return null;
    }

    public boolean isLoading() throws RemoteException {
        return this.zzAD != null && this.zzAD.isLoading();
    }

    public boolean isReady() throws RemoteException {
        return this.zzAD != null && this.zzAD.isReady();
    }

    public void pause() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.pause();
        }
    }

    public void resume() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.resume();
        }
    }

    public void setManualImpressionsEnabled(boolean z) throws RemoteException {
        boolean z2 = z;
        abort();
        if (this.zzAD != null) {
            this.zzAD.setManualImpressionsEnabled(z2);
        }
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.showInterstitial();
        } else {
            zzin.zzaK("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public void stopLoading() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.stopLoading();
        }
    }

    public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        if (this.zzAD != null) {
            this.zzAD.zza(adSizeParcel2);
        }
    }

    public void zza(zzp zzp) throws RemoteException {
        this.zzAJ.zzAt = zzp;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    public void zza(zzq zzq) throws RemoteException {
        this.zzAJ.zzpK = zzq;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    public void zza(zzw zzw) throws RemoteException {
        this.zzAJ.zzAq = zzw;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    public void zza(zzx zzx) throws RemoteException {
        zzx zzx2 = zzx;
        abort();
        if (this.zzAD != null) {
            this.zzAD.zza(zzx2);
        }
    }

    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzd) {
        this.zzAJ.zzAu = zzd;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    public void zza(zzcf zzcf) throws RemoteException {
        this.zzAJ.zzAs = zzcf;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    public void zza(zzgd zzgd) throws RemoteException {
        this.zzAJ.zzAr = zzgd;
        if (this.zzAD != null) {
            this.zzAJ.zzc(this.zzAD);
        }
    }

    public void zza(zzgh zzgh, String str) throws RemoteException {
        String str2 = str;
        this.zzAK = zzgh;
        this.zzAL = str2;
        zzel();
    }

    public com.google.android.gms.dynamic.zzd zzaM() throws RemoteException {
        if (this.zzAD != null) {
            return this.zzAD.zzaM();
        }
        return null;
    }

    public AdSizeParcel zzaN() throws RemoteException {
        if (this.zzAD != null) {
            return this.zzAD.zzaN();
        }
        return null;
    }

    public void zzaP() throws RemoteException {
        if (this.zzAD != null) {
            this.zzAD.zzaP();
        } else {
            zzin.zzaK("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        if (zzi(adRequestParcel2)) {
            abort();
        }
        if (adRequestParcel2.zztJ != null) {
            abort();
        }
        if (this.zzAD != null) {
            return this.zzAD.zzb(adRequestParcel2);
        }
        zza zza = zzr.zzbN().zza(adRequestParcel2, this.zzpS);
        if (zza != null) {
            if (!zza.zzAG) {
                zza.zzh(adRequestParcel2);
            }
            this.zzAD = zza.zzAD;
            zza.zzc(this.zzAz);
            zza.zzAE.zza(this.zzAJ);
            this.zzAJ.zzc(this.zzAD);
            zzel();
            return zza.zzAH;
        }
        this.zzAD = this.zzAz.zzX(this.zzpS);
        this.zzAJ.zzc(this.zzAD);
        zzel();
        return this.zzAD.zzb(adRequestParcel2);
    }

    /* access modifiers changed from: 0000 */
    public boolean zzi(AdRequestParcel adRequestParcel) {
        Bundle bundle = adRequestParcel.zztM;
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getCanonicalName());
            if (bundle2 != null) {
                return bundle2.keySet().contains("gw");
            }
        }
        return false;
    }
}
