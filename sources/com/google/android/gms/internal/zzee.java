package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

@zzhb
public class zzee {

    private static class zza<JavascriptEngine> extends zzjd<JavascriptEngine> {
        JavascriptEngine zzAR;

        private zza() {
        }

        /* synthetic */ zza(C03261 r4) {
            C03261 r1 = r4;
            this();
        }
    }

    public zzee() {
    }

    /* access modifiers changed from: private */
    public zzed zza(Context context, VersionInfoParcel versionInfoParcel, zza<zzed> zza2, zzan zzan) {
        zzef zzef;
        C03272 r11;
        zza<zzed> zza3 = zza2;
        zzef zzef2 = zzef;
        zzef zzef3 = new zzef(context, versionInfoParcel, zzan);
        zzef zzef4 = zzef2;
        zza3.zzAR = zzef4;
        zzef zzef5 = zzef4;
        C03272 r7 = r11;
        final zza<zzed> zza4 = zza3;
        C03272 r8 = new com.google.android.gms.internal.zzed.zza(this) {
            final /* synthetic */ zzee zzAQ;

            {
                zza zza = r7;
                this.zzAQ = r6;
            }

            public void zzeo() {
                zza4.zzg(zza4.zzAR);
            }
        };
        zzef5.zza(r7);
        return zzef4;
    }

    public Future<zzed> zza(Context context, VersionInfoParcel versionInfoParcel, String str, zzan zzan) {
        zza zza2;
        C03261 r15;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        String str2 = str;
        zzan zzan2 = zzan;
        zza zza3 = zza2;
        zza zza4 = new zza(null);
        zza zza5 = zza3;
        Handler handler = zzir.zzMc;
        C03261 r7 = r15;
        final Context context3 = context2;
        final VersionInfoParcel versionInfoParcel3 = versionInfoParcel2;
        final zza zza6 = zza5;
        final zzan zzan3 = zzan2;
        final String str3 = str2;
        C03261 r8 = new Runnable(this) {
            final /* synthetic */ zzee zzAQ;

            {
                Context context = r11;
                VersionInfoParcel versionInfoParcel = r12;
                zza zza = r13;
                zzan zzan = r14;
                String str = r15;
                this.zzAQ = r10;
            }

            public void run() {
                this.zzAQ.zza(context3, versionInfoParcel3, zza6, zzan3).zzaa(str3);
            }
        };
        boolean post = handler.post(r7);
        return zza5;
    }
}
