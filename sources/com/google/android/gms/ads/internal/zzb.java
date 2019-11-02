package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzga;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@zzhb
public abstract class zzb extends zza implements zzg, zzj, zzdh, zzep {
    private final Messenger mMessenger;
    protected final zzex zzpn;
    protected transient boolean zzpo;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        zzs zzs;
        zzex zzex2 = zzex;
        zzd zzd2 = zzd;
        zzs zzs2 = zzs;
        zzs zzs3 = new zzs(context, adSizeParcel, str, versionInfoParcel);
        this(zzs2, zzex2, null, zzd2);
    }

    zzb(zzs zzs, zzex zzex, zzq zzq, zzd zzd) {
        Messenger messenger;
        zzga zzga;
        zzex zzex2 = zzex;
        super(zzs, zzq, zzd);
        this.zzpn = zzex2;
        Messenger messenger2 = messenger;
        zzga zzga2 = zzga;
        zzga zzga3 = new zzga(this.zzpj.context);
        Messenger messenger3 = new Messenger(zzga2);
        this.mMessenger = messenger2;
        this.zzpo = false;
    }

    private zza zza(AdRequestParcel adRequestParcel, Bundle bundle) {
        PackageInfo packageInfo;
        zzig zzig;
        ArrayList arrayList;
        CapabilityParcel capabilityParcel;
        zza zza;
        Bundle bundle2;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        Bundle bundle3 = bundle;
        ApplicationInfo applicationInfo = this.zzpj.context.getApplicationInfo();
        try {
            packageInfo = this.zzpj.context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzpj.context.getResources().getDisplayMetrics();
        Bundle bundle4 = null;
        if (this.zzpj.zzrm != null) {
            bundle4 = null;
            if (this.zzpj.zzrm.getParent() != null) {
                int[] iArr = new int[2];
                this.zzpj.zzrm.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                int width = this.zzpj.zzrm.getWidth();
                int height = this.zzpj.zzrm.getHeight();
                int i3 = 0;
                if (this.zzpj.zzrm.isShown()) {
                    i3 = 0;
                    if (i + width > 0) {
                        i3 = 0;
                        if (i2 + height > 0) {
                            i3 = 0;
                            if (i <= displayMetrics.widthPixels) {
                                i3 = 0;
                                if (i2 <= displayMetrics.heightPixels) {
                                    i3 = 1;
                                }
                            }
                        }
                    }
                }
                Bundle bundle5 = bundle2;
                Bundle bundle6 = new Bundle(5);
                bundle4 = bundle5;
                bundle4.putInt("x", i);
                bundle4.putInt("y", i2);
                bundle4.putInt("width", width);
                bundle4.putInt("height", height);
                bundle4.putInt("visible", i3);
            }
        }
        String zzgZ = zzr.zzbF().zzgZ();
        zzs zzs = this.zzpj;
        zzig zzig2 = zzig;
        zzig zzig3 = new zzig(zzgZ, this.zzpj.zzrj);
        zzs.zzrs = zzig2;
        this.zzpj.zzrs.zzk(adRequestParcel2);
        String zza2 = zzr.zzbC().zza(this.zzpj.context, (View) this.zzpj.zzrm, this.zzpj.zzrp);
        long j = 0;
        if (this.zzpj.zzrw != null) {
            try {
                j = this.zzpj.zzrw.getValue();
            } catch (RemoteException e2) {
                RemoteException remoteException = e2;
                zzin.zzaK("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza3 = zzr.zzbF().zza(this.zzpj.context, this, zzgZ);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        int i4 = 0;
        while (true) {
            if (i4 >= this.zzpj.zzrC.size()) {
                break;
            }
            boolean add = arrayList4.add(this.zzpj.zzrC.keyAt(i4));
            i4++;
        }
        boolean z = this.zzpj.zzrx != null;
        boolean z2 = this.zzpj.zzry != null && zzr.zzbF().zzhj();
        boolean zzfM = this.zzpm.zzpy.zzfM();
        AdSizeParcel adSizeParcel = this.zzpj.zzrp;
        String str = this.zzpj.zzrj;
        String sessionId = zzr.zzbF().getSessionId();
        VersionInfoParcel versionInfoParcel = this.zzpj.zzrl;
        List<String> list = this.zzpj.zzrH;
        boolean zzhd = zzr.zzbF().zzhd();
        Messenger messenger = this.mMessenger;
        int i5 = displayMetrics.widthPixels;
        int i6 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        List zzdr = zzbt.zzdr();
        String str2 = this.zzpj.zzri;
        NativeAdOptionsParcel nativeAdOptionsParcel = this.zzpj.zzrD;
        CapabilityParcel capabilityParcel2 = capabilityParcel;
        CapabilityParcel capabilityParcel3 = new CapabilityParcel(z, z2, zzfM);
        CapabilityParcel capabilityParcel4 = capabilityParcel2;
        zza zza4 = zza;
        zza zza5 = new zza(bundle4, adRequestParcel2, adSizeParcel, str, applicationInfo, packageInfo, zzgZ, sessionId, versionInfoParcel, zza3, list, arrayList4, bundle3, zzhd, messenger, i5, i6, f, zza2, j, uuid, zzdr, str2, nativeAdOptionsParcel, capabilityParcel4, this.zzpj.zzca(), zzr.zzbC().zzbt(), zzr.zzbC().zzR(this.zzpj.context), zzr.zzbC().zzl(this.zzpj.zzrm));
        return zza4;
    }

    public String getMediationAdapterClassName() {
        if (this.zzpj.zzrq == null) {
            return null;
        }
        return this.zzpj.zzrq.zzCr;
    }

    public void onAdClicked() {
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzpj.zzrq.zzKV == null || this.zzpj.zzrq.zzKV.zzBQ == null)) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzKV.zzBQ);
        }
        if (!(this.zzpj.zzrq.zzCp == null || this.zzpj.zzrq.zzCp.zzBE == null)) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzCp.zzBE);
        }
        super.onAdClicked();
    }

    public void onPause() {
        this.zzpl.zzk(this.zzpj.zzrq);
    }

    public void onResume() {
        this.zzpl.zzl(this.zzpj.zzrq);
    }

    public void pause() {
        zzx.zzcD("pause must be called on the main UI thread.");
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzED == null || !this.zzpj.zzbW())) {
            boolean zzi = zzr.zzbE().zzi(this.zzpj.zzrq.zzED);
        }
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzCq == null)) {
            try {
                this.zzpj.zzrq.zzCq.pause();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                zzin.zzaK("Could not pause mediation adapter.");
            }
        }
        this.zzpl.zzk(this.zzpj.zzrq);
        this.zzpi.pause();
    }

    public void recordImpression() {
        zza(this.zzpj.zzrq, false);
    }

    public void resume() {
        zzx.zzcD("resume must be called on the main UI thread.");
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzED == null || !this.zzpj.zzbW())) {
            boolean zzj = zzr.zzbE().zzj(this.zzpj.zzrq.zzED);
        }
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzCq == null)) {
            try {
                this.zzpj.zzrq.zzCq.resume();
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                zzin.zzaK("Could not resume mediation adapter.");
            }
        }
        this.zzpi.resume();
        this.zzpl.zzl(this.zzpj.zzrq);
    }

    public void showInterstitial() {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("showInterstitial is not supported for current ad type");
        throw illegalStateException2;
    }

    public void zza(zzgd zzgd) {
        zzgd zzgd2 = zzgd;
        zzx.zzcD("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzpj.zzrx = zzgd2;
    }

    public void zza(zzgh zzgh, String str) {
        zzk zzk;
        zzc zzc;
        zzgh zzgh2 = zzgh;
        String str2 = str;
        zzx.zzcD("setPlayStorePurchaseParams must be called on the main UI thread.");
        zzs zzs = this.zzpj;
        zzk zzk2 = zzk;
        zzk zzk3 = new zzk(str2);
        zzs.zzrI = zzk2;
        this.zzpj.zzry = zzgh2;
        if (!zzr.zzbF().zzhc() && zzgh2 != null) {
            zzc zzc2 = zzc;
            zzc zzc3 = new zzc(this.zzpj.context, this.zzpj.zzry, this.zzpj.zzrI);
            Future zzhn = zzc2.zzgd();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzif zzif, boolean z) {
        zzif zzif2 = zzif;
        boolean z2 = z;
        if (zzif2 == null) {
            zzin.zzaK("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(zzif2);
        if (!(zzif2.zzKV == null || zzif2.zzKV.zzBR == null)) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzif2, this.zzpj.zzrj, z2, zzif2.zzKV.zzBR);
        }
        if (zzif2.zzCp != null && zzif2.zzCp.zzBF != null) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzif2, this.zzpj.zzrj, z2, zzif2.zzCp.zzBF);
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        zzd zzd;
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel;
        String str2 = str;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd(str2, arrayList, this.zzpj.context, this.zzpj.zzrl.afmaVersion);
        zzd zzd4 = zzd2;
        if (this.zzpj.zzrx == null) {
            zzin.zzaK("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzn.zzcS().zzU(this.zzpj.context)) {
                zzin.zzaK("Google Play Service unavailable, cannot launch default purchase flow.");
            } else if (this.zzpj.zzry == null) {
                zzin.zzaK("PlayStorePurchaseListener is not set.");
            } else if (this.zzpj.zzrI == null) {
                zzin.zzaK("PlayStorePurchaseVerifier is not initialized.");
            } else if (this.zzpj.zzrM) {
                zzin.zzaK("An in-app purchase request is already in progress, abort");
            } else {
                this.zzpj.zzrM = true;
                try {
                    if (!this.zzpj.zzry.isValidPurchase(str2)) {
                        this.zzpj.zzrM = false;
                        return;
                    }
                    zzi zzbM = zzr.zzbM();
                    Context context = this.zzpj.context;
                    boolean z = this.zzpj.zzrl.zzNb;
                    GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel2 = gInAppPurchaseManagerInfoParcel;
                    GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel3 = new GInAppPurchaseManagerInfoParcel(this.zzpj.context, this.zzpj.zzrI, zzd4, this);
                    zzbM.zza(context, z, gInAppPurchaseManagerInfoParcel2);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                    zzin.zzaK("Could not start In-App purchase.");
                    this.zzpj.zzrM = false;
                }
            }
        } else {
            try {
                this.zzpj.zzrx.zza(zzd4);
            } catch (RemoteException e2) {
                RemoteException remoteException2 = e2;
                zzin.zzaK("Could not start In-App purchase.");
            }
        }
    }

    public void zza(String str, boolean z, int i, Intent intent, zzf zzf) {
        C01951 r16;
        com.google.android.gms.ads.internal.purchase.zzg zzg;
        String str2 = str;
        boolean z2 = z;
        int i2 = i;
        Intent intent2 = intent;
        zzf zzf2 = zzf;
        try {
            if (this.zzpj.zzry != null) {
                zzgh zzgh = this.zzpj.zzry;
                com.google.android.gms.ads.internal.purchase.zzg zzg2 = zzg;
                com.google.android.gms.ads.internal.purchase.zzg zzg3 = new com.google.android.gms.ads.internal.purchase.zzg(this.zzpj.context, str2, z2, i2, intent2, zzf2);
                zzgh.zza(zzg2);
            }
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            zzin.zzaK("Fail to invoke PlayStorePurchaseListener.");
        }
        Handler handler = zzir.zzMc;
        C01951 r8 = r16;
        final Intent intent3 = intent2;
        C01951 r9 = new Runnable(this) {
            final /* synthetic */ zzb zzpq;

            {
                Intent intent = r7;
                this.zzpq = r6;
            }

            public void run() {
                int zzd = zzr.zzbM().zzd(intent3);
                zzi zzbM = zzr.zzbM();
                if (!(zzd != 0 || this.zzpq.zzpj.zzrq == null || this.zzpq.zzpj.zzrq.zzED == null || this.zzpq.zzpj.zzrq.zzED.zzhS() == null)) {
                    this.zzpq.zzpj.zzrq.zzED.zzhS().close();
                }
                this.zzpq.zzpj.zzrM = false;
            }
        };
        boolean postDelayed = handler.postDelayed(r8, 500);
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzcb zzcb) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzcb zzcb2 = zzcb;
        if (!zzaV()) {
            return false;
        }
        Bundle zza = zza(zzr.zzbF().zzG(this.zzpj.context));
        this.zzpi.cancel();
        this.zzpj.zzrL = 0;
        zza zza2 = zza(adRequestParcel2, zza);
        zzcb2.zzc("seq_num", zza2.zzHw);
        zzcb2.zzc("request_id", zza2.zzHI);
        zzcb2.zzc("session_id", zza2.zzHx);
        if (zza2.zzHu != null) {
            zzcb2.zzc("app_version", String.valueOf(zza2.zzHu.versionCode));
        }
        this.zzpj.zzrn = zzr.zzby().zza(this.zzpj.context, zza2, this.zzpj.zzrk, this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zza(AdRequestParcel adRequestParcel, zzif zzif, boolean z) {
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        zzif zzif2 = zzif;
        if (!z && this.zzpj.zzbW()) {
            if (zzif2.zzBU > 0) {
                this.zzpi.zza(adRequestParcel2, zzif2.zzBU);
            } else if (zzif2.zzKV != null && zzif2.zzKV.zzBU > 0) {
                this.zzpi.zza(adRequestParcel2, zzif2.zzKV.zzBU);
            } else if (!zzif2.zzHT && zzif2.errorCode == 2) {
                this.zzpi.zzg(adRequestParcel2);
            }
        }
        return this.zzpi.zzbw();
    }

    /* access modifiers changed from: 0000 */
    public boolean zza(zzif zzif) {
        AdRequestParcel adRequestParcel;
        zzif zzif2 = zzif;
        boolean z = false;
        if (this.zzpk != null) {
            adRequestParcel = this.zzpk;
            this.zzpk = null;
        } else {
            adRequestParcel = zzif2.zzHt;
            z = false;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, zzif2, z);
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzif zzif, zzif zzif2) {
        int i;
        int i2;
        zzif zzif3 = zzif;
        zzif zzif4 = zzif2;
        if (!(zzif3 == null || zzif3.zzCs == null)) {
            zzif3.zzCs.zza((zzep) null);
        }
        if (zzif4.zzCs != null) {
            zzif4.zzCs.zza((zzep) this);
        }
        if (zzif4.zzKV != null) {
            i2 = zzif4.zzKV.zzBZ;
            i = zzif4.zzKV.zzCa;
        } else {
            i = 0;
            i2 = 0;
        }
        this.zzpj.zzrJ.zzg(i2, i);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zzaV() {
        boolean z = true;
        if (!zzr.zzbC().zza(this.zzpj.context.getPackageManager(), this.zzpj.context.getPackageName(), "android.permission.INTERNET") || !zzr.zzbC().zzI(this.zzpj.context)) {
            z = false;
        }
        return z;
    }

    public void zzaW() {
        this.zzpl.zzi(this.zzpj.zzrq);
        this.zzpo = false;
        zzaQ();
        this.zzpj.zzrs.zzgU();
    }

    public void zzaX() {
        this.zzpo = true;
        zzaS();
    }

    public void zzaY() {
        onAdClicked();
    }

    public void zzaZ() {
        zzaW();
    }

    public void zzb(zzif zzif) {
        zzif zzif2 = zzif;
        super.zzb(zzif2);
        if (zzif2.errorCode == 3 && zzif2.zzKV != null && zzif2.zzKV.zzBS != null) {
            zzin.zzaI("Pinging no fill URLs.");
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzif2, this.zzpj.zzrj, false, zzif2.zzKV.zzBS);
        }
    }

    public void zzba() {
        zzaO();
    }

    public void zzbb() {
        zzaX();
    }

    public void zzbc() {
        StringBuilder sb;
        if (this.zzpj.zzrq != null) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zzaK(sb2.append("Mediation adapter ").append(this.zzpj.zzrq.zzCr).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        zza(this.zzpj.zzrq, true);
        zzaT();
    }

    /* access modifiers changed from: protected */
    public boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzpo;
    }
}
