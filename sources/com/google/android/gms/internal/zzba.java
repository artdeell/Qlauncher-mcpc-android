package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzeg.zzd;
import com.google.android.gms.internal.zzji.zza;
import com.google.android.gms.internal.zzji.zzb;
import com.google.android.gms.internal.zzji.zzc;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzba extends zzau {
    private zzd zzsF;
    private boolean zzsG;

    public zzba(Context context, AdSizeParcel adSizeParcel, zzif zzif, VersionInfoParcel versionInfoParcel, zzbb zzbb, zzeg zzeg) {
        C02653 r16;
        C02664 r162;
        StringBuilder sb;
        C02631 r163;
        C02642 r164;
        zzbb zzbb2 = zzbb;
        zzeg zzeg2 = zzeg;
        super(context, adSizeParcel, zzif, versionInfoParcel, zzbb2);
        this.zzsF = zzeg2.zzer();
        try {
            JSONObject zzd = zzd(zzbb2.zzcq().zzco());
            zzd zzd2 = this.zzsF;
            C02631 r11 = r163;
            final JSONObject jSONObject = zzd;
            C02631 r12 = new zzc<zzeh>(this) {
                final /* synthetic */ zzba zzsI;

                {
                    JSONObject jSONObject = r7;
                    this.zzsI = r6;
                }

                /* renamed from: zzd */
                public void zze(zzeh zzeh) {
                    zzeh zzeh2 = zzeh;
                    this.zzsI.zza(jSONObject);
                }
            };
            C02642 r122 = r164;
            C02642 r13 = new zza(this) {
                final /* synthetic */ zzba zzsI;

                {
                    this.zzsI = r5;
                }

                public void run() {
                }
            };
            zzd2.zza(r11, r122);
        } catch (JSONException e) {
            JSONException jSONException = e;
        } catch (RuntimeException e2) {
            zzin.zzb("Failure while processing active view data.", e2);
        }
        zzd zzd3 = this.zzsF;
        C02653 r112 = r16;
        C02653 r123 = new zzc<zzeh>(this) {
            final /* synthetic */ zzba zzsI;

            {
                this.zzsI = r5;
            }

            /* renamed from: zzd */
            public void zze(zzeh zzeh) {
                zzeh zzeh2 = zzeh;
                boolean zza = zzba.zza(this.zzsI, true);
                this.zzsI.zzb(zzeh2);
                this.zzsI.zzcd();
                this.zzsI.zzh(false);
            }
        };
        C02664 r124 = r162;
        C02664 r132 = new zza(this) {
            final /* synthetic */ zzba zzsI;

            {
                this.zzsI = r5;
            }

            public void run() {
                this.zzsI.destroy();
            }
        };
        zzd3.zza(r112, r124);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaI(sb2.append("Tracking ad unit: ").append(this.zzrZ.zzcu()).toString());
    }

    static /* synthetic */ boolean zza(zzba zzba, boolean z) {
        boolean z2 = z;
        zzba.zzsG = z2;
        return z2;
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        C02686 r7;
        zzb zzb;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                super.destroy();
                zzd zzd = this.zzsF;
                C02686 r4 = r7;
                C02686 r5 = new zzc<zzeh>(this) {
                    final /* synthetic */ zzba zzsI;

                    {
                        this.zzsI = r5;
                    }

                    /* renamed from: zzd */
                    public void zze(zzeh zzeh) {
                        zzeh zzeh2 = zzeh;
                        this.zzsI.zzc(zzeh2);
                    }
                };
                zzb zzb2 = zzb;
                zzb zzb3 = new zzb();
                zzd.zza(r4, zzb2);
                this.zzsF.release();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(JSONObject jSONObject) {
        C02675 r7;
        zzb zzb;
        JSONObject jSONObject2 = jSONObject;
        zzd zzd = this.zzsF;
        C02675 r3 = r7;
        final JSONObject jSONObject3 = jSONObject2;
        C02675 r4 = new zzc<zzeh>(this) {
            final /* synthetic */ zzba zzsI;

            {
                JSONObject jSONObject = r7;
                this.zzsI = r6;
            }

            /* renamed from: zzd */
            public void zze(zzeh zzeh) {
                zzeh.zza("AFMA_updateActiveView", jSONObject3);
            }
        };
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        zzd.zza(r3, zzb2);
    }

    /* access modifiers changed from: protected */
    public boolean zzcl() {
        return this.zzsG;
    }
}
