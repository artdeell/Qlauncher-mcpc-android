package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zzbc {
    private final Object zzpV;
    private final int zzsK;
    private final int zzsL;
    private final int zzsM;
    private final zzbh zzsN;
    private ArrayList<String> zzsO;
    private ArrayList<String> zzsP;
    private int zzsQ = 0;
    private int zzsR = 0;
    private int zzsS = 0;
    private int zzsT;
    private String zzsU = LibrariesRepository.MOJANG_MAVEN_REPO;
    private String zzsV = LibrariesRepository.MOJANG_MAVEN_REPO;

    public zzbc(int i, int i2, int i3, int i4) {
        Object obj;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        zzbh zzbh;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        ArrayList<String> arrayList3 = arrayList;
        ArrayList<String> arrayList4 = new ArrayList<>();
        this.zzsO = arrayList3;
        ArrayList<String> arrayList5 = arrayList2;
        ArrayList<String> arrayList6 = new ArrayList<>();
        this.zzsP = arrayList5;
        this.zzsK = i5;
        this.zzsL = i6;
        this.zzsM = i7;
        zzbh zzbh2 = zzbh;
        zzbh zzbh3 = new zzbh(i8);
        this.zzsN = zzbh2;
    }

    private String zza(ArrayList<String> arrayList, int i) {
        StringBuffer stringBuffer;
        String stringBuffer2;
        ArrayList<String> arrayList2 = arrayList;
        int i2 = i;
        if (arrayList2.isEmpty()) {
            stringBuffer2 = LibrariesRepository.MOJANG_MAVEN_REPO;
        } else {
            StringBuffer stringBuffer3 = stringBuffer;
            StringBuffer stringBuffer4 = new StringBuffer();
            StringBuffer stringBuffer5 = stringBuffer3;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                StringBuffer append = stringBuffer5.append((String) it.next());
                StringBuffer append2 = stringBuffer5.append(' ');
                if (stringBuffer5.length() > i2) {
                    break;
                }
            }
            StringBuffer deleteCharAt = stringBuffer5.deleteCharAt(-1 + stringBuffer5.length());
            stringBuffer2 = stringBuffer5.toString();
            if (stringBuffer2.length() >= i2) {
                return stringBuffer2.substring(0, i2);
            }
        }
        return stringBuffer2;
    }

    private void zze(String str, boolean z) {
        String str2 = str;
        boolean z2 = z;
        if (str2 != null && str2.length() >= this.zzsM) {
            Object obj = this.zzpV;
            synchronized (obj) {
                try {
                    boolean add = this.zzsO.add(str2);
                    this.zzsQ += str2.length();
                    if (z2) {
                        boolean add2 = this.zzsP.add(str2);
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof zzbc) {
            if (obj2 == this) {
                return true;
            }
            zzbc zzbc = (zzbc) obj2;
            if (zzbc.zzcy() != null && zzbc.zzcy().equals(zzcy())) {
                return true;
            }
        }
        return false;
    }

    public int getScore() {
        return this.zzsT;
    }

    public int hashCode() {
        return zzcy().hashCode();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("ActivityContent fetchId: ").append(this.zzsR).append(" score:").append(this.zzsT).append(" total_length:").append(this.zzsQ).append("\n text: ").append(zza(this.zzsO, 100)).append("\n viewableText").append(zza(this.zzsP, 100)).append("\n signture: ").append(this.zzsU).append("\n viewableSignture: ").append(this.zzsV).toString();
    }

    /* access modifiers changed from: 0000 */
    public int zzb(int i, int i2) {
        return (i * this.zzsK) + (i2 * this.zzsL);
    }

    public void zzc(String str, boolean z) {
        zze(str, z);
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzsS < 0) {
                    zzin.zzaI("ActivityContent: negative number of WebViews.");
                }
                zzcD();
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzcA() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzsT = -100 + this.zzsT;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzcB() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzsS = -1 + this.zzsS;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void zzcC() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                this.zzsS = 1 + this.zzsS;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzcD() {
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                int zzb = zzb(this.zzsQ, this.zzsR);
                if (zzb > this.zzsT) {
                    this.zzsT = zzb;
                    this.zzsU = this.zzsN.zza(this.zzsO);
                    this.zzsV = this.zzsN.zza(this.zzsP);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int zzcE() {
        return this.zzsQ;
    }

    public boolean zzcx() {
        boolean z = this.zzpV;
        synchronized (z) {
            try {
                th = this.zzsS == 0;
            } finally {
                Throwable th = th;
                boolean z2 = z;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public String zzcy() {
        return this.zzsU;
    }

    public String zzcz() {
        return this.zzsV;
    }

    public void zzd(String str, boolean z) {
        zze(str, z);
    }

    public void zzh(int i) {
        int i2 = i;
        this.zzsR = i2;
    }
}
