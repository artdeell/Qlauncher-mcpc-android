package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgc.zza;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zzd extends zza {
    private Context mContext;
    private String zzFI;
    private ArrayList<String> zzFJ;
    private String zzsy;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        ArrayList<String> arrayList2 = arrayList;
        Context context2 = context;
        String str3 = str2;
        this.zzFI = str;
        this.zzFJ = arrayList2;
        this.zzsy = str3;
        this.mContext = context2;
    }

    public String getProductId() {
        return this.zzFI;
    }

    public void recordPlayBillingResolution(int i) {
        HashMap hashMap;
        LinkedList linkedList;
        int i2 = i;
        if (i2 == 0) {
            zzfX();
        }
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("google_play_status", String.valueOf(i2));
        Object put2 = hashMap4.put("sku", this.zzFI);
        Object put3 = hashMap4.put("status", String.valueOf(zzB(i2)));
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        Iterator it = this.zzFJ.iterator();
        while (it.hasNext()) {
            boolean add = linkedList4.add(zza((String) it.next(), hashMap4));
        }
        zzr.zzbC().zza(this.mContext, this.zzsy, (List<String>) linkedList4);
    }

    public void recordResolution(int i) {
        HashMap hashMap;
        LinkedList linkedList;
        int i2 = i;
        if (i2 == 1) {
            zzfX();
        }
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = hashMap2;
        Object put = hashMap4.put("status", String.valueOf(i2));
        Object put2 = hashMap4.put("sku", this.zzFI);
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        Iterator it = this.zzFJ.iterator();
        while (it.hasNext()) {
            boolean add = linkedList4.add(zza((String) it.next(), hashMap4));
        }
        zzr.zzbC().zza(this.mContext, this.zzsy, (List<String>) linkedList4);
    }

    /* access modifiers changed from: protected */
    public int zzB(int i) {
        int i2 = i;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        return i2 == 4 ? 3 : 0;
    }

    /* access modifiers changed from: protected */
    public String zza(String str, HashMap<String, String> hashMap) {
        String str2;
        String str3 = str;
        HashMap<String, String> hashMap2 = hashMap;
        String packageName = this.mContext.getPackageName();
        try {
            str2 = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (NameNotFoundException e) {
            zzin.zzd("Error to retrieve app version", e);
            str2 = LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzr.zzbF().zzha().zzhl();
        for (String str4 : hashMap2.keySet()) {
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = str4;
            str3 = str3.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", objArr2), String.format("$1%s$2", new Object[]{hashMap2.get(str4)}));
        }
        Object[] objArr3 = new Object[1];
        Object[] objArr4 = objArr3;
        objArr3[0] = "sessionid";
        String replaceAll = str3.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", objArr4), String.format("$1%s$2", new Object[]{zzr.zzbF().getSessionId()}));
        Object[] objArr5 = new Object[1];
        Object[] objArr6 = objArr5;
        objArr5[0] = "appid";
        String format = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", objArr6);
        Object[] objArr7 = new Object[1];
        Object[] objArr8 = objArr7;
        objArr7[0] = packageName;
        String replaceAll2 = replaceAll.replaceAll(format, String.format("$1%s$2", objArr8));
        Object[] objArr9 = new Object[1];
        Object[] objArr10 = objArr9;
        objArr9[0] = "osversion";
        String replaceAll3 = replaceAll2.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", objArr10), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)}));
        Object[] objArr11 = new Object[1];
        Object[] objArr12 = objArr11;
        objArr11[0] = "sdkversion";
        String replaceAll4 = replaceAll3.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", objArr12), String.format("$1%s$2", new Object[]{this.zzsy}));
        Object[] objArr13 = new Object[1];
        Object[] objArr14 = objArr13;
        objArr13[0] = "appversion";
        String format2 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", objArr14);
        Object[] objArr15 = new Object[1];
        Object[] objArr16 = objArr15;
        objArr15[0] = str2;
        String replaceAll5 = replaceAll4.replaceAll(format2, String.format("$1%s$2", objArr16));
        Object[] objArr17 = new Object[1];
        Object[] objArr18 = objArr17;
        objArr17[0] = "timestamp";
        String replaceAll6 = replaceAll5.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", objArr18), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)}));
        Object[] objArr19 = new Object[1];
        Object[] objArr20 = objArr19;
        objArr19[0] = "[^@]+";
        String format3 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", objArr20);
        Object[] objArr21 = new Object[1];
        Object[] objArr22 = objArr21;
        objArr21[0] = LibrariesRepository.MOJANG_MAVEN_REPO;
        return replaceAll6.replaceAll(format3, String.format("$1%s$2", objArr22)).replaceAll("@@", "@");
    }

    /* access modifiers changed from: 0000 */
    public void zzfX() {
        try {
            Object invoke = this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.mContext, this.zzFI, LibrariesRepository.MOJANG_MAVEN_REPO, Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            zzin.zzaK("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            NoSuchMethodException noSuchMethodException = e2;
            zzin.zzaK("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception e3) {
            zzin.zzd("Fail to report a conversion.", e3);
        }
    }
}
