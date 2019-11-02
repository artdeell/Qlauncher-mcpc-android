package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlw;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzsz.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class zzb {
    public static final Api<NoOptions> API;
    public static final com.google.android.gms.common.api.Api.zzc<zzlw> zzUI;
    public static final com.google.android.gms.common.api.Api.zza<zzlw, NoOptions> zzUJ;
    public static final zzc zzaeQ;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final String zzTJ;
    /* access modifiers changed from: private */
    public final int zzaeR;
    /* access modifiers changed from: private */
    public String zzaeS;
    /* access modifiers changed from: private */
    public int zzaeT;
    /* access modifiers changed from: private */
    public String zzaeU;
    /* access modifiers changed from: private */
    public String zzaeV;
    /* access modifiers changed from: private */
    public final boolean zzaeW;
    /* access modifiers changed from: private */
    public int zzaeX;
    /* access modifiers changed from: private */
    public final zzc zzaeY;
    /* access modifiers changed from: private */
    public final zza zzaeZ;
    /* access modifiers changed from: private */
    public zzc zzafa;
    /* access modifiers changed from: private */
    public final zzmq zzqW;

    public class zza {
        private String zzaeS;
        private int zzaeT;
        private String zzaeU;
        private String zzaeV;
        private int zzaeX;
        private final C0878zzb zzafb;
        private C0878zzb zzafc;
        private ArrayList<Integer> zzafd;
        private final zzd zzafe;
        private boolean zzaff;
        final /* synthetic */ zzb zzafg;

        private zza(zzb zzb, byte[] bArr) {
            this(zzb, bArr, (C0878zzb) null);
        }

        /* synthetic */ zza(zzb zzb, byte[] bArr, C02201 r10) {
            C02201 r3 = r10;
            this(zzb, bArr);
        }

        private zza(zzb zzb, byte[] bArr, C0878zzb zzb2) {
            zzd zzd;
            zzb zzb3 = zzb;
            byte[] bArr2 = bArr;
            C0878zzb zzb4 = zzb2;
            this.zzafg = zzb3;
            this.zzaeT = this.zzafg.zzaeT;
            this.zzaeS = this.zzafg.zzaeS;
            this.zzaeU = this.zzafg.zzaeU;
            this.zzaeV = this.zzafg.zzaeV;
            this.zzaeX = this.zzafg.zzaeX;
            this.zzafd = null;
            zzd zzd2 = zzd;
            zzd zzd3 = new zzd();
            this.zzafe = zzd2;
            this.zzaff = false;
            this.zzaeU = zzb3.zzaeU;
            this.zzaeV = zzb3.zzaeV;
            this.zzafe.zzbuR = zzb3.zzqW.currentTimeMillis();
            this.zzafe.zzbuS = zzb3.zzqW.elapsedRealtime();
            this.zzafe.zzbvi = (long) zzb3.zzaeZ.zzah(zzb3.mContext);
            this.zzafe.zzbvd = zzb3.zzafa.zzC(this.zzafe.zzbuR);
            if (bArr2 != null) {
                this.zzafe.zzbuY = bArr2;
            }
            this.zzafb = zzb4;
        }

        public zza zzbq(int i) {
            this.zzafe.zzbuU = i;
            return this;
        }

        public zza zzbr(int i) {
            this.zzafe.zzob = i;
            return this;
        }

        public PendingResult<Status> zzd(GoogleApiClient googleApiClient) {
            IllegalStateException illegalStateException;
            GoogleApiClient googleApiClient2 = googleApiClient;
            if (this.zzaff) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("do not reuse LogEventBuilder");
                throw illegalStateException2;
            }
            this.zzaff = true;
            return this.zzafg.zzaeY.zza(googleApiClient2, zzoE());
        }

        public LogEventParcelable zzoE() {
            LogEventParcelable logEventParcelable;
            PlayLoggerContext playLoggerContext;
            LogEventParcelable logEventParcelable2 = logEventParcelable;
            PlayLoggerContext playLoggerContext2 = playLoggerContext;
            PlayLoggerContext playLoggerContext3 = new PlayLoggerContext(this.zzafg.zzTJ, this.zzafg.zzaeR, this.zzaeT, this.zzaeS, this.zzaeU, this.zzaeV, this.zzafg.zzaeW, this.zzaeX);
            LogEventParcelable logEventParcelable3 = new LogEventParcelable(playLoggerContext2, this.zzafe, this.zzafb, this.zzafc, zzb.zzb(this.zzafd));
            return logEventParcelable2;
        }
    }

    /* renamed from: com.google.android.gms.clearcut.zzb$zzb reason: collision with other inner class name */
    public interface C0878zzb {
        byte[] zzoF();
    }

    public static class zzc {
        public zzc() {
        }

        public long zzC(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    static {
        com.google.android.gms.common.api.Api.zzc<zzlw> zzc2;
        C02201 r5;
        Api<NoOptions> api;
        zzlv zzlv;
        com.google.android.gms.common.api.Api.zzc<zzlw> zzc3 = zzc2;
        com.google.android.gms.common.api.Api.zzc<zzlw> zzc4 = new com.google.android.gms.common.api.Api.zzc<>();
        zzUI = zzc3;
        C02201 r0 = r5;
        C02201 r1 = new com.google.android.gms.common.api.Api.zza<zzlw, NoOptions>() {
            /* renamed from: zze */
            public zzlw zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
                zzlw zzlw;
                NoOptions noOptions2 = noOptions;
                zzlw zzlw2 = zzlw;
                zzlw zzlw3 = new zzlw(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
                return zzlw2;
            }
        };
        zzUJ = r0;
        Api<NoOptions> api2 = api;
        Api<NoOptions> api3 = new Api<>("ClearcutLogger.API", zzUJ, zzUI);
        API = api2;
        zzlv zzlv2 = zzlv;
        zzlv zzlv3 = new zzlv();
        zzaeQ = zzlv2;
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, zzc zzc2, zzmq zzmq, zzc zzc3, zza zza2) {
        zzc zzc4;
        Context context2 = context;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        boolean z2 = z;
        zzc zzc5 = zzc2;
        zzmq zzmq2 = zzmq;
        zzc zzc6 = zzc3;
        zza zza3 = zza2;
        this.zzaeT = -1;
        this.zzaeX = 0;
        Context applicationContext = context2.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context2;
        }
        this.mContext = applicationContext;
        this.zzTJ = context2.getPackageName();
        this.zzaeR = zzai(context2);
        this.zzaeT = i2;
        this.zzaeS = str4;
        this.zzaeU = str5;
        this.zzaeV = str6;
        this.zzaeW = z2;
        this.zzaeY = zzc5;
        this.zzqW = zzmq2;
        if (zzc6 == null) {
            zzc zzc7 = zzc4;
            zzc zzc8 = new zzc();
            zzc6 = zzc7;
        }
        this.zzafa = zzc6;
        this.zzaeZ = zza3;
        this.zzaeX = 0;
        if (this.zzaeW) {
            zzx.zzb(this.zzaeU == null, (Object) "can't be anonymous with an upload account");
        }
    }

    @Deprecated
    public zzb(Context context, String str, String str2, String str3) {
        this(context, -1, str, str2, str3, false, zzaeQ, zzmt.zzsc(), null, zza.zzaeP);
    }

    private int zzai(Context context) {
        Context context2 = context;
        try {
            return context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            NameNotFoundException nameNotFoundException = e;
            int wtf = Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int[] zzb(ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2 = arrayList;
        if (arrayList2 == null) {
            return null;
        }
        int[] iArr = new int[arrayList2.size()];
        Iterator it = arrayList2.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            int i3 = i2 + 1;
            iArr[i2] = ((Integer) it.next()).intValue();
            i = i3;
        }
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        return this.zzaeY.zza(googleApiClient, j, timeUnit);
    }

    public zza zzi(byte[] bArr) {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza(this, bArr, (C02201) null);
        return zza3;
    }
}
