package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziv;
import com.google.android.gms.internal.zziv.zza;
import com.google.android.gms.internal.zziv.zzb;
import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.util.concurrent.TimeUnit;

@zzhb
public class zzt {
    private final Context mContext;
    private final String zzEY;
    private final VersionInfoParcel zzEZ;
    @Nullable
    private final zzbz zzFa;
    @Nullable
    private final zzcb zzFb;
    private final zziv zzFc;
    private final long[] zzFd;
    private final String[] zzFe;
    @Nullable
    private zzbz zzFf;
    @Nullable
    private zzbz zzFg;
    @Nullable
    private zzbz zzFh;
    @Nullable
    private zzbz zzFi;
    private boolean zzFj;
    private zzi zzFk;
    private boolean zzFl;
    private boolean zzFm;
    private long zzFn = -1;

    public zzt(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzcb zzcb, @Nullable zzbz zzbz) {
        zzb zzb;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        String str2 = str;
        zzcb zzcb2 = zzcb;
        zzbz zzbz2 = zzbz;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        this.zzFc = zzb2.zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzhA();
        this.mContext = context2;
        this.zzEZ = versionInfoParcel2;
        this.zzEY = str2;
        this.zzFb = zzcb2;
        this.zzFa = zzbz2;
        String str3 = (String) zzbt.zzvV.get();
        if (str3 == null) {
            this.zzFe = new String[0];
            this.zzFd = new long[0];
            return;
        }
        String[] split = TextUtils.split(str3, ",");
        this.zzFe = new String[split.length];
        this.zzFd = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzFd[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzin.zzd("Unable to parse frame hash target time number.", e);
                this.zzFd[i] = -1;
            }
        }
    }

    private void zzc(zzi zzi) {
        zzi zzi2 = zzi;
        long longValue = ((Long) zzbt.zzvW.get()).longValue();
        long currentPosition = (long) zzi2.getCurrentPosition();
        for (int i = 0; i < this.zzFe.length; i++) {
            if (this.zzFe[i] == null && longValue > Math.abs(currentPosition - this.zzFd[i])) {
                this.zzFe[i] = zza((TextureView) zzi2);
                return;
            }
        }
    }

    private void zzfN() {
        if (this.zzFh != null && this.zzFi == null) {
            zzcb zzcb = this.zzFb;
            zzbz zzbz = this.zzFh;
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "vff";
            boolean zza = zzbx.zza(zzcb, zzbz, strArr2);
            zzcb zzcb2 = this.zzFb;
            zzbz zzbz2 = this.zzFa;
            String[] strArr3 = new String[1];
            String[] strArr4 = strArr3;
            strArr3[0] = "vtt";
            boolean zza2 = zzbx.zza(zzcb2, zzbz2, strArr4);
            this.zzFi = zzbx.zzb(this.zzFb);
        }
        long nanoTime = zzr.zzbG().nanoTime();
        if (this.zzFj && this.zzFm && this.zzFn != -1) {
            this.zzFc.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzFn)));
        }
        this.zzFm = this.zzFj;
        this.zzFn = nanoTime;
    }

    public void onStop() {
        Bundle bundle;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        if (((Boolean) zzbt.zzvU.get()).booleanValue() && !this.zzFl) {
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            Bundle bundle4 = bundle2;
            bundle4.putString(MimeTypeParser.TAG_TYPE, "native-player-metrics");
            bundle4.putString("request", this.zzEY);
            bundle4.putString("player", this.zzFk.zzeZ());
            for (zza zza : this.zzFc.getBuckets()) {
                Bundle bundle5 = bundle4;
                StringBuilder sb4 = sb2;
                StringBuilder sb5 = new StringBuilder();
                bundle5.putString(sb4.append("fps_c_").append(zza.name).toString(), Integer.toString(zza.count));
                Bundle bundle6 = bundle4;
                StringBuilder sb6 = sb3;
                StringBuilder sb7 = new StringBuilder();
                bundle6.putString(sb6.append("fps_p_").append(zza.name).toString(), Double.toString(zza.zzMu));
            }
            for (int i = 0; i < this.zzFd.length; i++) {
                String str = this.zzFe[i];
                if (str != null) {
                    Bundle bundle7 = bundle4;
                    StringBuilder sb8 = sb;
                    StringBuilder sb9 = new StringBuilder();
                    bundle7.putString(sb8.append("fh_").append(Long.valueOf(this.zzFd[i])).toString(), str);
                }
            }
            zzr.zzbC().zza(this.mContext, this.zzEZ.afmaVersion, "gmob-apps", bundle4, true);
            this.zzFl = true;
        }
    }

    /* access modifiers changed from: 0000 */
    public String zza(TextureView textureView) {
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j = 0;
        long j2 = 63;
        int i = 0;
        while (i < 8) {
            long j3 = j;
            long j4 = j2;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 8) {
                    break;
                }
                int pixel = bitmap.getPixel(i3, i);
                j3 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j4);
                j4--;
                i2 = i3 + 1;
            }
            i++;
            j2 = j4;
            j = j3;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j)});
    }

    public void zza(zzi zzi) {
        zzi zzi2 = zzi;
        zzcb zzcb = this.zzFb;
        zzbz zzbz = this.zzFa;
        String[] strArr = new String[1];
        String[] strArr2 = strArr;
        strArr[0] = "vpc";
        boolean zza = zzbx.zza(zzcb, zzbz, strArr2);
        this.zzFf = zzbx.zzb(this.zzFb);
        this.zzFk = zzi2;
    }

    public void zzb(zzi zzi) {
        zzi zzi2 = zzi;
        zzfN();
        zzc(zzi2);
    }

    public void zzfO() {
        this.zzFj = true;
        if (this.zzFg != null && this.zzFh == null) {
            zzcb zzcb = this.zzFb;
            zzbz zzbz = this.zzFg;
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "vfp";
            boolean zza = zzbx.zza(zzcb, zzbz, strArr2);
            this.zzFh = zzbx.zzb(this.zzFb);
        }
    }

    public void zzfP() {
        this.zzFj = false;
    }

    public void zzfz() {
        if (this.zzFf != null && this.zzFg == null) {
            zzcb zzcb = this.zzFb;
            zzbz zzbz = this.zzFf;
            String[] strArr = new String[1];
            String[] strArr2 = strArr;
            strArr[0] = "vfr";
            boolean zza = zzbx.zza(zzcb, zzbz, strArr2);
            this.zzFg = zzbx.zzb(this.zzFb);
        }
    }
}
