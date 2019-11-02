package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeg.zzd;
import java.util.Map;
import java.util.concurrent.Future;

@zzhb
public final class zzhf {
    /* access modifiers changed from: private */
    public String zzEY;
    /* access modifiers changed from: private */
    public String zzJh;
    /* access modifiers changed from: private */
    public zzjd<zzhi> zzJi;
    zzd zzJj;
    public final zzdf zzJk;
    public final zzdf zzJl;
    zzjp zzpD;
    /* access modifiers changed from: private */
    public final Object zzpV;

    public zzhf(String str, String str2) {
        Object obj;
        zzjd<zzhi> zzjd;
        C03951 r7;
        C03962 r72;
        String str3 = str;
        String str4 = str2;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        zzjd<zzhi> zzjd2 = zzjd;
        zzjd<zzhi> zzjd3 = new zzjd<>();
        this.zzJi = zzjd2;
        C03951 r4 = r7;
        C03951 r5 = new zzdf(this) {
            final /* synthetic */ zzhf zzJm;

            {
                this.zzJm = r5;
            }

            public void zza(zzjp zzjp, Map<String, String> map) {
                zzhi zzhi;
                StringBuilder sb;
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                Object zza = this.zzJm.zzpV;
                synchronized (zza) {
                    try {
                        if (!this.zzJm.zzJi.isDone()) {
                            if (this.zzJm.zzEY.equals(map2.get("request_id"))) {
                                zzhi zzhi2 = zzhi;
                                zzhi zzhi3 = new zzhi(1, map2);
                                zzhi zzhi4 = zzhi2;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                zzin.zzaK(sb2.append("Invalid ").append(zzhi4.getType()).append(" request error: ").append(zzhi4.zzgE()).toString());
                                this.zzJm.zzJi.zzg(zzhi4);
                            }
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = zza;
                        throw th2;
                    }
                }
            }
        };
        this.zzJk = r4;
        C03962 r42 = r72;
        C03962 r52 = new zzdf(this) {
            final /* synthetic */ zzhf zzJm;

            {
                this.zzJm = r5;
            }

            /* JADX INFO: finally extract failed */
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzhi zzhi;
                StringBuilder sb;
                StringBuilder sb2;
                zzjp zzjp2 = zzjp;
                Map<String, String> map2 = map;
                Object zza = this.zzJm.zzpV;
                synchronized (zza) {
                    try {
                        if (!this.zzJm.zzJi.isDone()) {
                            zzhi zzhi2 = zzhi;
                            zzhi zzhi3 = new zzhi(-2, map2);
                            zzhi zzhi4 = zzhi2;
                            if (!this.zzJm.zzEY.equals(zzhi4.getRequestId())) {
                                StringBuilder sb3 = sb2;
                                StringBuilder sb4 = new StringBuilder();
                                zzin.zzaK(sb3.append(zzhi4.getRequestId()).append(" ==== ").append(this.zzJm.zzEY).toString());
                                return;
                            }
                            String url = zzhi4.getUrl();
                            if (url == null) {
                                zzin.zzaK("URL missing in loadAdUrl GMSG.");
                                return;
                            }
                            if (url.contains("%40mediation_adapters%40")) {
                                String replaceAll = url.replaceAll("%40mediation_adapters%40", zzil.zza(zzjp2.getContext(), (String) map2.get("check_adapters"), this.zzJm.zzJh));
                                zzhi4.setUrl(replaceAll);
                                StringBuilder sb5 = sb;
                                StringBuilder sb6 = new StringBuilder();
                                zzin.m20v(sb5.append("Ad request URL modified to ").append(replaceAll).toString());
                            }
                            this.zzJm.zzJi.zzg(zzhi4);
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Object obj = zza;
                        throw th2;
                    }
                }
            }
        };
        this.zzJl = r42;
        this.zzJh = str4;
        this.zzEY = str3;
    }

    public void zzb(zzd zzd) {
        zzd zzd2 = zzd;
        this.zzJj = zzd2;
    }

    public zzd zzgB() {
        return this.zzJj;
    }

    public Future<zzhi> zzgC() {
        return this.zzJi;
    }

    public void zzgD() {
        if (this.zzpD != null) {
            this.zzpD.destroy();
            this.zzpD = null;
        }
    }

    public void zzh(zzjp zzjp) {
        zzjp zzjp2 = zzjp;
        this.zzpD = zzjp2;
    }
}
