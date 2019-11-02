package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhj.zza;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;

@zzhb
public class zzdy {
    private final Map<zzdz, zzea> zzAx;
    private final LinkedList<zzdz> zzAy;
    private zzdv zzAz;

    public zzdy() {
        HashMap hashMap;
        LinkedList<zzdz> linkedList;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.zzAx = hashMap2;
        LinkedList<zzdz> linkedList2 = linkedList;
        LinkedList<zzdz> linkedList3 = new LinkedList<>();
        this.zzAy = linkedList2;
    }

    private String[] zzY(String str) {
        String[] strArr;
        String str2;
        try {
            strArr = str.split(DexFormat.MAGIC_SUFFIX);
            for (int i = 0; i < strArr.length; i++) {
                String[] strArr2 = strArr;
                int i2 = i;
                String str3 = str2;
                String str4 = new String(Base64.decode(strArr[i], 0), "UTF-8");
                strArr2[i2] = str3;
            }
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            strArr = new String[0];
        }
        return strArr;
    }

    private static void zza(String str, zzdz zzdz) {
        String str2 = str;
        zzdz zzdz2 = zzdz;
        if (zzin.zzQ(2)) {
            String str3 = str2;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = zzdz2;
            zzin.m20v(String.format(str3, objArr2));
        }
    }

    private String zzef() {
        StringBuilder sb;
        try {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = sb2;
            Iterator it = this.zzAy.iterator();
            while (it.hasNext()) {
                StringBuilder append = sb4.append(Base64.encodeToString(((zzdz) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    StringBuilder append2 = sb4.append(DexFormat.MAGIC_SUFFIX);
                }
            }
            return sb4.toString();
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
    }

    /* access modifiers changed from: 0000 */
    public void flush() {
        while (this.zzAy.size() > 0) {
            zzdz zzdz = (zzdz) this.zzAy.remove();
            zzea zzea = (zzea) this.zzAx.get(zzdz);
            zza("Flushing interstitial queue for %s.", zzdz);
            while (zzea.size() > 0) {
                zzea.zzej().zzAD.zzbp();
            }
            Object remove = this.zzAx.remove(zzdz);
        }
    }

    /* access modifiers changed from: 0000 */
    public void restore() {
        HashMap hashMap;
        zzec zzec;
        zzdz zzdz;
        zzea zzea;
        if (this.zzAz != null) {
            SharedPreferences sharedPreferences = this.zzAz.zzed().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            flush();
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = hashMap2;
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                try {
                    if (!((String) entry.getKey()).equals("PoolKeys")) {
                        zzec zzec2 = zzec;
                        zzec zzec3 = new zzec((String) entry.getValue());
                        zzec zzec4 = zzec2;
                        zzdz zzdz2 = zzdz;
                        zzdz zzdz3 = new zzdz(zzec4.zzqH, zzec4.zzpS, zzec4.zzAC);
                        zzdz zzdz4 = zzdz2;
                        if (!this.zzAx.containsKey(zzdz4)) {
                            zzea zzea2 = zzea;
                            zzea zzea3 = new zzea(zzec4.zzqH, zzec4.zzpS, zzec4.zzAC);
                            Object put = this.zzAx.put(zzdz4, zzea2);
                            Object put2 = hashMap4.put(zzdz4.toString(), zzdz4);
                            zza("Restored interstitial queue for %s.", zzdz4);
                        }
                    }
                } catch (IOException | ClassCastException e) {
                    zzin.zzd("Malformed preferences value for InterstitialAdPool.", e);
                }
            }
            String[] zzY = zzY(sharedPreferences.getString("PoolKeys", LibrariesRepository.MOJANG_MAVEN_REPO));
            int length = zzY.length;
            for (int i = 0; i < length; i++) {
                zzdz zzdz5 = (zzdz) hashMap4.get(zzY[i]);
                if (this.zzAx.containsKey(zzdz5)) {
                    boolean add = this.zzAy.add(zzdz5);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void save() {
        zzec zzec;
        if (this.zzAz != null) {
            Editor edit = this.zzAz.zzed().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            Editor clear = edit.clear();
            for (Entry entry : this.zzAx.entrySet()) {
                zzdz zzdz = (zzdz) entry.getKey();
                if (zzdz.zzeh()) {
                    zzec zzec2 = zzec;
                    zzec zzec3 = new zzec((zzea) entry.getValue());
                    Editor putString = edit.putString(zzdz.toString(), zzec2.zzem());
                    zza("Saved interstitial queue for %s.", zzdz);
                }
            }
            Editor putString2 = edit.putString("PoolKeys", zzef());
            boolean commit = edit.commit();
        }
    }

    /* access modifiers changed from: 0000 */
    public zza zza(AdRequestParcel adRequestParcel, String str) {
        zza zza;
        zzdz zzdz;
        zzea zzea;
        zzea zzea2;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String str2 = str;
        zza zza2 = zza;
        zza zza3 = new zza(this.zzAz.zzed());
        int i = zza2.zzgI().zzKc;
        zzdz zzdz2 = zzdz;
        zzdz zzdz3 = new zzdz(adRequestParcel2, str2, i);
        zzdz zzdz4 = zzdz2;
        zzea zzea3 = (zzea) this.zzAx.get(zzdz4);
        if (zzea3 == null) {
            zza("Interstitial pool created at %s.", zzdz4);
            zzea zzea4 = zzea2;
            zzea zzea5 = new zzea(adRequestParcel2, str2, i);
            zzea zzea6 = zzea4;
            Object put = this.zzAx.put(zzdz4, zzea6);
            zzea = zzea6;
        } else {
            zzea = zzea3;
        }
        boolean remove = this.zzAy.remove(zzdz4);
        boolean add = this.zzAy.add(zzdz4);
        zzdz4.zzeg();
        while (this.zzAy.size() > ((Integer) zzbt.zzwG.get()).intValue()) {
            zzdz zzdz5 = (zzdz) this.zzAy.remove();
            zzea zzea7 = (zzea) this.zzAx.get(zzdz5);
            zza("Evicting interstitial queue for %s.", zzdz5);
            while (zzea7.size() > 0) {
                zzea7.zzej().zzAD.zzbp();
            }
            Object remove2 = this.zzAx.remove(zzdz5);
        }
        while (zzea.size() > 0) {
            zza zzej = zzea.zzej();
            if (!zzej.zzAG || zzr.zzbG().currentTimeMillis() - zzej.zzAF <= 1000 * ((long) ((Integer) zzbt.zzwI.get()).intValue())) {
                zza("Pooled interstitial returned at %s.", zzdz4);
                return zzej;
            }
            zza("Expired interstitial at %s.", zzdz4);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzdv zzdv) {
        zzdv zzdv2 = zzdv;
        if (this.zzAz == null) {
            this.zzAz = zzdv2;
            restore();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzee() {
        if (this.zzAz != null) {
            for (Entry entry : this.zzAx.entrySet()) {
                zzdz zzdz = (zzdz) entry.getKey();
                zzea zzea = (zzea) entry.getValue();
                while (zzea.size() < ((Integer) zzbt.zzwH.get()).intValue()) {
                    zza("Pooling one interstitial for %s.", zzdz);
                    zzea.zzb(this.zzAz);
                }
            }
            save();
        }
    }
}
