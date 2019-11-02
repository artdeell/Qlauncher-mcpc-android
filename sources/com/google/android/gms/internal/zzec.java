package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;

@zzhb
class zzec {
    final int zzAC;
    final String zzpS;
    final AdRequestParcel zzqH;

    zzec(AdRequestParcel adRequestParcel, String str, int i) {
        String str2 = str;
        int i2 = i;
        this.zzqH = adRequestParcel;
        this.zzpS = str2;
        this.zzAC = i2;
    }

    zzec(zzea zzea) {
        zzea zzea2 = zzea;
        this(zzea2.zzei(), zzea2.getAdUnitId(), zzea2.getNetworkType());
    }

    zzec(String str) throws IOException {
        IOException iOException;
        String str2;
        IOException iOException2;
        String[] split = str.split(DexFormat.MAGIC_SUFFIX);
        if (split.length != 3) {
            IOException iOException3 = iOException2;
            IOException iOException4 = new IOException("Incorrect field count for QueueSeed.");
            throw iOException3;
        }
        Parcel obtain = Parcel.obtain();
        try {
            String str3 = str2;
            String str4 = new String(Base64.decode(split[0], 0), "UTF-8");
            this.zzpS = str3;
            this.zzAC = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            this.zzqH = AdRequestParcel.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            IOException iOException5 = iOException;
            IOException iOException6 = new IOException("Malformed QueueSeed encoding.");
            throw iOException5;
        } catch (Throwable th) {
            Throwable th2 = th;
            obtain.recycle();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public String zzem() {
        StringBuilder sb;
        Parcel obtain = Parcel.obtain();
        try {
            String encodeToString = Base64.encodeToString(this.zzpS.getBytes("UTF-8"), 0);
            String num = Integer.toString(this.zzAC);
            this.zzqH.writeToParcel(obtain, 0);
            String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            String sb4 = sb2.append(encodeToString).append(DexFormat.MAGIC_SUFFIX).append(num).append(DexFormat.MAGIC_SUFFIX).append(encodeToString2).toString();
            obtain.recycle();
            return sb4;
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            zzin.m19e("QueueSeed encode failed because UTF-8 is not available.");
            obtain.recycle();
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        } catch (Throwable th) {
            Throwable th2 = th;
            obtain.recycle();
            throw th2;
        }
    }
}
