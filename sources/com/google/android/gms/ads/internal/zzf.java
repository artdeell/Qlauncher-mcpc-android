package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzav;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzjq.zzb;

@zzhb
public class zzf extends zzc implements OnGlobalLayoutListener, OnScrollChangedListener {
    private boolean zzpE;

    public class zza {
        final /* synthetic */ zzf zzpG;

        public zza(zzf zzf) {
            this.zzpG = zzf;
        }

        public void onClick() {
            this.zzpG.onAdClicked();
        }
    }

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzex, versionInfoParcel, zzd);
    }

    private AdSizeParcel zzb(com.google.android.gms.internal.zzif.zza zza2) {
        AdSize zzcQ;
        AdSizeParcel adSizeParcel;
        AdSize adSize;
        com.google.android.gms.internal.zzif.zza zza3 = zza2;
        if (zza3.zzLe.zzul) {
            return this.zzpj.zzrp;
        }
        String str = zza3.zzLe.zzHW;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            AdSize adSize2 = adSize;
            AdSize adSize3 = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            zzcQ = adSize2;
        } else {
            zzcQ = this.zzpj.zzrp.zzcQ();
        }
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSizeParcel adSizeParcel3 = new AdSizeParcel(this.zzpj.context, zzcQ);
        return adSizeParcel2;
    }

    private boolean zzb(zzif zzif, zzif zzif2) {
        zzif zzif3 = zzif;
        zzif zzif4 = zzif2;
        if (zzif4.zzHT) {
            View zzf = zzm.zzf(zzif4);
            if (zzf == null) {
                zzin.zzaK("Could not get mediation view");
                return false;
            }
            View nextView = this.zzpj.zzrm.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzjp) {
                    ((zzjp) nextView).destroy();
                }
                this.zzpj.zzrm.removeView(nextView);
            }
            if (!zzm.zzg(zzif4)) {
                try {
                    zzb(zzf);
                } catch (Throwable th) {
                    zzin.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(zzif4.zzKW == null || zzif4.zzED == null)) {
            zzif4.zzED.zza(zzif4.zzKW);
            this.zzpj.zzrm.removeAllViews();
            this.zzpj.zzrm.setMinimumWidth(zzif4.zzKW.widthPixels);
            this.zzpj.zzrm.setMinimumHeight(zzif4.zzKW.heightPixels);
            zzb(zzif4.zzED.getView());
        }
        if (this.zzpj.zzrm.getChildCount() > 1) {
            this.zzpj.zzrm.showNext();
        }
        if (zzif3 != null) {
            View nextView2 = this.zzpj.zzrm.getNextView();
            if (nextView2 instanceof zzjp) {
                ((zzjp) nextView2).zza(this.zzpj.context, this.zzpj.zzrp, this.zzpe);
            } else if (nextView2 != null) {
                this.zzpj.zzrm.removeView(nextView2);
            }
            this.zzpj.zzbV();
        }
        this.zzpj.zzrm.setVisibility(0);
        return true;
    }

    private void zzd(zzif zzif) {
        C02011 r7;
        zzif zzif2 = zzif;
        if (this.zzpj.zzbW()) {
            if (zzif2.zzED != null) {
                if (zzif2.zzKT != null) {
                    zzau zza2 = this.zzpl.zza(this.zzpj.zzrp, zzif2);
                }
                if (zzif2.zzcv()) {
                    this.zzpl.zza(this.zzpj.zzrp, zzif2).zza((zzav) zzif2.zzED);
                    return;
                }
                zzjq zzhU = zzif2.zzED.zzhU();
                C02011 r3 = r7;
                final zzif zzif3 = zzif2;
                C02011 r4 = new zzb(this) {
                    final /* synthetic */ zzf zzpG;

                    {
                        zzif zzif = r7;
                        this.zzpG = r6;
                    }

                    public void zzbi() {
                        this.zzpG.zzpl.zza(this.zzpG.zzpj.zzrp, zzif3).zza((zzav) zzif3.zzED);
                    }
                };
                zzhU.zza((zzb) r3);
            }
        } else if (this.zzpj.zzrK != null && zzif2.zzKT != null) {
            zzau zza3 = this.zzpl.zza(this.zzpj.zzrp, zzif2, this.zzpj.zzrK);
        }
    }

    public void onGlobalLayout() {
        zze(this.zzpj.zzrq);
    }

    public void onScrollChanged() {
        zze(this.zzpj.zzrq);
    }

    public void setManualImpressionsEnabled(boolean z) {
        boolean z2 = z;
        zzx.zzcD("setManualImpressionsEnabled must be called from the main thread.");
        this.zzpE = z2;
    }

    public void showInterstitial() {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
        throw illegalStateException2;
    }

    /* access modifiers changed from: protected */
    public zzjp zza(com.google.android.gms.internal.zzif.zza zza2, zze zze) {
        com.google.android.gms.internal.zzif.zza zza3 = zza2;
        zze zze2 = zze;
        if (this.zzpj.zzrp.zzul) {
            this.zzpj.zzrp = zzb(zza3);
        }
        return super.zza(zza3, zze2);
    }

    /* access modifiers changed from: protected */
    public void zza(zzif zzif, boolean z) {
        zza zza2;
        zzif zzif2 = zzif;
        super.zza(zzif2, z);
        if (zzm.zzg(zzif2)) {
            zzif zzif3 = zzif2;
            zza zza3 = zza2;
            zza zza4 = new zza(this);
            zzm.zza(zzif3, zza3);
        }
    }

    public boolean zza(zzif zzif, zzif zzif2) {
        zzif zzif3 = zzif;
        zzif zzif4 = zzif2;
        if (!super.zza(zzif3, zzif4)) {
            return false;
        }
        if (!this.zzpj.zzbW() || zzb(zzif3, zzif4)) {
            if (zzif4.zzIm) {
                zze(zzif4);
                zzjk.zza((View) this.zzpj.zzrm, (OnGlobalLayoutListener) this);
                zzjk.zza((View) this.zzpj.zzrm, (OnScrollChangedListener) this);
            } else if (!this.zzpj.zzbX() || ((Boolean) zzbt.zzxg.get()).booleanValue()) {
                zza(zzif4, false);
            }
            zzd(zzif4);
            return true;
        }
        zzf(0);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zzaV() {
        boolean z = true;
        if (!zzr.zzbC().zza(this.zzpj.context.getPackageManager(), this.zzpj.context.getPackageName(), "android.permission.INTERNET")) {
            zzn.zzcS().zza(this.zzpj.zzrm, this.zzpj.zzrp, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzr.zzbC().zzI(this.zzpj.context)) {
            zzn.zzcS().zza(this.zzpj.zzrm, this.zzpj.zzrp, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzpj.zzrm != null) {
            this.zzpj.zzrm.setVisibility(0);
        }
        return z;
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        return super.zzb(zze(adRequestParcel));
    }

    /* access modifiers changed from: 0000 */
    public AdRequestParcel zze(AdRequestParcel adRequestParcel) {
        AdRequestParcel adRequestParcel2;
        AdRequestParcel adRequestParcel3 = adRequestParcel;
        if (adRequestParcel3.zztH == this.zzpE) {
            return adRequestParcel3;
        }
        AdRequestParcel adRequestParcel4 = adRequestParcel2;
        AdRequestParcel adRequestParcel5 = new AdRequestParcel(adRequestParcel3.versionCode, adRequestParcel3.zztC, adRequestParcel3.extras, adRequestParcel3.zztD, adRequestParcel3.zztE, adRequestParcel3.zztF, adRequestParcel3.zztG, adRequestParcel3.zztH || this.zzpE, adRequestParcel3.zztI, adRequestParcel3.zztJ, adRequestParcel3.zztK, adRequestParcel3.zztL, adRequestParcel3.zztM, adRequestParcel3.zztN, adRequestParcel3.zztO, adRequestParcel3.zztP, adRequestParcel3.zztQ, adRequestParcel3.zztR);
        return adRequestParcel4;
    }

    /* access modifiers changed from: 0000 */
    public void zze(zzif zzif) {
        Rect rect;
        zzif zzif2 = zzif;
        if (zzif2 != null && !zzif2.zzKU && this.zzpj.zzrm != null && zzr.zzbC().zza((View) this.zzpj.zzrm, this.zzpj.context)) {
            com.google.android.gms.ads.internal.zzs.zza zza2 = this.zzpj.zzrm;
            Rect rect2 = rect;
            Rect rect3 = new Rect();
            if (zza2.getGlobalVisibleRect(rect2, null)) {
                zza(zzif2, false);
                zzif2.zzKU = true;
            }
        }
    }
}
