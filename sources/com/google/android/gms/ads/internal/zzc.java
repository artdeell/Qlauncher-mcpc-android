package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzif.zza;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public abstract class zzc extends zzb implements zzg, zzft {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzex, versionInfoParcel, zzd);
    }

    /* access modifiers changed from: protected */
    public zzjp zza(zza zza, zze zze) {
        zzjp zzjp;
        zza zza2 = zza;
        zze zze2 = zze;
        View nextView = this.zzpj.zzrm.getNextView();
        if (nextView instanceof zzjp) {
            zzin.zzaI("Reusing webview...");
            zzjp zzjp2 = (zzjp) nextView;
            zzjp2.zza(this.zzpj.context, this.zzpj.zzrp, this.zzpe);
            zzjp = zzjp2;
        } else {
            if (nextView != null) {
                this.zzpj.zzrm.removeView(nextView);
            }
            zzjp zza3 = zzr.zzbD().zza(this.zzpj.context, this.zzpj.zzrp, false, false, this.zzpj.zzrk, this.zzpj.zzrl, this.zzpe, this.zzpm);
            if (this.zzpj.zzrp.zzuj == null) {
                zzb(zza3.getView());
            }
            zzjp = zza3;
        }
        zzjp.zzhU().zzb(this, this, this, this, false, this, null, zze2, this);
        zza((zzeh) zzjp);
        zzjp.zzaM(zza2.zzLd.zzHI);
        return zzjp;
    }

    public void zza(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        zzaS();
    }

    public void zza(zzcf zzcf) {
        zzcf zzcf2 = zzcf;
        zzx.zzcD("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzpj.zzrE = zzcf2;
    }

    /* access modifiers changed from: protected */
    public void zza(zzeh zzeh) {
        C01961 r7;
        C01961 r4 = r7;
        C01961 r5 = new zzdf(this) {
            final /* synthetic */ zzc zzpr;

            {
                this.zzpr = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                if (this.zzpr.zzpj.zzrq != null) {
                    zzau zza = this.zzpr.zzpl.zza(this.zzpr.zzpj.zzrp, this.zzpr.zzpj.zzrq, zzjp2.getView(), (zzeh) zzjp2);
                } else {
                    zzin.zzaK("Request to enable ActiveView before adState is available.");
                }
            }
        };
        zzeh.zza("/trackActiveViewUnit", (zzdf) r4);
    }

    /* access modifiers changed from: protected */
    public void zza(zza zza, zzcb zzcb) {
        C01983 r13;
        C01972 r132;
        zza zza2 = zza;
        zzcb zzcb2 = zzcb;
        if (zza2.errorCode != -2) {
            Handler handler = zzir.zzMc;
            C01972 r4 = r132;
            final zza zza3 = zza2;
            C01972 r5 = new Runnable(this) {
                final /* synthetic */ zzc zzpr;

                {
                    zza zza = r7;
                    this.zzpr = r6;
                }

                public void run() {
                    zzif zzif;
                    zzc zzc = this.zzpr;
                    zzif zzif2 = zzif;
                    zzif zzif3 = new zzif(zza3, null, null, null, null, null, null);
                    zzc.zzb(zzif2);
                }
            };
            boolean post = handler.post(r4);
            return;
        }
        if (zza2.zzrp != null) {
            this.zzpj.zzrp = zza2.zzrp;
        }
        if (!zza2.zzLe.zzHT || zza2.zzLe.zzum) {
            Handler handler2 = zzir.zzMc;
            C01983 r42 = r13;
            final zza zza4 = zza2;
            final zzcb zzcb3 = zzcb2;
            C01983 r52 = new Runnable(this) {
                final /* synthetic */ zzc zzpr;

                {
                    zza zza = r8;
                    zzcb zzcb = r9;
                    this.zzpr = r7;
                }

                public void run() {
                    zze zze;
                    zzb zzb;
                    C01991 r18;
                    C02002 r182;
                    zzcc zzcc;
                    if (zza4.zzLe.zzIc && this.zzpr.zzpj.zzrE != null) {
                        String str = null;
                        if (zza4.zzLe.zzEF != null) {
                            str = zzr.zzbC().zzaC(zza4.zzLe.zzEF);
                        }
                        zzcc zzcc2 = zzcc;
                        zzcc zzcc3 = new zzcc(this.zzpr, str, zza4.zzLe.body);
                        zzcc zzcc4 = zzcc2;
                        this.zzpr.zzpj.zzrL = 1;
                        try {
                            this.zzpr.zzph = false;
                            this.zzpr.zzpj.zzrE.zza(zzcc4);
                            return;
                        } catch (RemoteException e) {
                            zzin.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
                            this.zzpr.zzph = true;
                        }
                    }
                    zze zze2 = zze;
                    zze zze3 = new zze();
                    zze zze4 = zze2;
                    zzjp zza = this.zzpr.zza(zza4, zze4);
                    zze zze5 = zze4;
                    zzb zzb2 = zzb;
                    zzb zzb3 = new zzb(zza4, zza);
                    zze5.zza(zzb2);
                    zzjp zzjp = zza;
                    C01991 r9 = r18;
                    final zze zze6 = zze4;
                    C01991 r10 = new OnTouchListener(this) {
                        final /* synthetic */ C01983 zzpv;

                        {
                            zze zze = r7;
                            this.zzpv = r6;
                        }

                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            View view2 = view;
                            MotionEvent motionEvent2 = motionEvent;
                            zze6.recordClick();
                            return false;
                        }
                    };
                    zzjp.setOnTouchListener(r9);
                    zzjp zzjp2 = zza;
                    C02002 r92 = r182;
                    final zze zze7 = zze4;
                    C02002 r102 = new OnClickListener(this) {
                        final /* synthetic */ C01983 zzpv;

                        {
                            zze zze = r7;
                            this.zzpv = r6;
                        }

                        public void onClick(View view) {
                            View view2 = view;
                            zze7.recordClick();
                        }
                    };
                    zzjp2.setOnClickListener(r92);
                    this.zzpr.zzpj.zzrL = 0;
                    this.zzpr.zzpj.zzro = zzr.zzbB().zza(this.zzpr.zzpj.context, this.zzpr, zza4, this.zzpr.zzpj.zzrk, zza, this.zzpr.zzpn, this.zzpr, zzcb3);
                }
            };
            boolean post2 = handler2.post(r42);
            return;
        }
        this.zzpj.zzrL = 0;
        this.zzpj.zzro = zzr.zzbB().zza(this.zzpj.context, this, zza2, this.zzpj.zzrk, null, this.zzpn, this, zzcb2);
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzif zzif, zzif zzif2) {
        zzif zzif3 = zzif;
        zzif zzif4 = zzif2;
        if (this.zzpj.zzbW() && this.zzpj.zzrm != null) {
            this.zzpj.zzrm.zzcc().zzaF(zzif4.zzHY);
        }
        return super.zza(zzif3, zzif4);
    }

    public void zzbd() {
        onAdClicked();
    }

    public void zzbe() {
        recordImpression();
        zzaP();
    }

    public void zzbf() {
        zzaQ();
    }

    public void zzc(View view) {
        zzif zzif;
        this.zzpj.zzrK = view;
        zzif zzif2 = zzif;
        zzif zzif3 = new zzif(this.zzpj.zzrr, null, null, null, null, null, null);
        zzb(zzif2);
    }
}
