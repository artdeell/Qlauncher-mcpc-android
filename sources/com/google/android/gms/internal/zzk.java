package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import org.objectweb.asm.signature.SignatureVisitor;

public abstract class zzk<T> implements Comparable<zzk<T>> {
    /* access modifiers changed from: private */
    public final zza zzD;
    private final int zzE;
    private final String zzF;
    private final int zzG;
    private final com.google.android.gms.internal.zzm.zza zzH;
    private Integer zzI;
    private zzl zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private long zzN;
    private zzo zzO;
    private com.google.android.gms.internal.zzb.zza zzP;

    public enum zza {
    }

    public zzk(int i, String str, com.google.android.gms.internal.zzm.zza zza2) {
        zza zza3;
        zzd zzd;
        zza zza4;
        int i2 = i;
        String str2 = str;
        com.google.android.gms.internal.zzm.zza zza5 = zza2;
        if (zza.zzak) {
            zza zza6 = zza4;
            zza zza7 = new zza();
            zza3 = zza6;
        } else {
            zza3 = null;
        }
        this.zzD = zza3;
        this.zzK = true;
        this.zzL = false;
        this.zzM = false;
        this.zzN = 0;
        this.zzP = null;
        this.zzE = i2;
        this.zzF = str2;
        this.zzH = zza5;
        zzd zzd2 = zzd;
        zzd zzd3 = new zzd();
        zzk zza8 = zza((zzo) zzd2);
        this.zzG = zzb(str2);
    }

    private byte[] zza(Map<String, String> map, String str) {
        StringBuilder sb;
        RuntimeException runtimeException;
        StringBuilder sb2;
        Map<String, String> map2 = map;
        String str2 = str;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = sb3;
        try {
            for (Entry entry : map2.entrySet()) {
                StringBuilder append = sb5.append(URLEncoder.encode((String) entry.getKey(), str2));
                StringBuilder append2 = sb5.append(SignatureVisitor.INSTANCEOF);
                StringBuilder append3 = sb5.append(URLEncoder.encode((String) entry.getValue(), str2));
                StringBuilder append4 = sb5.append('&');
            }
            return sb5.toString().getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            RuntimeException runtimeException3 = new RuntimeException(sb6.append("Encoding not supported: ").append(str2).toString(), unsupportedEncodingException);
            throw runtimeException2;
        }
    }

    private static int zzb(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.zzE;
    }

    public String getUrl() {
        return this.zzF;
    }

    public boolean isCanceled() {
        return this.zzL;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        String sb5 = sb3.append("0x").append(Integer.toHexString(zzg())).toString();
        StringBuilder sb6 = sb2;
        StringBuilder sb7 = new StringBuilder();
        return sb6.append(this.zzL ? "[X] " : "[ ] ").append(getUrl()).append(" ").append(sb5).append(" ").append(zzs()).append(" ").append(this.zzI).toString();
    }

    public final zzk<?> zza(int i) {
        this.zzI = Integer.valueOf(i);
        return this;
    }

    public zzk<?> zza(com.google.android.gms.internal.zzb.zza zza2) {
        this.zzP = zza2;
        return this;
    }

    public zzk<?> zza(zzl zzl) {
        this.zzJ = zzl;
        return this;
    }

    public zzk<?> zza(zzo zzo) {
        this.zzO = zzo;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzm<T> zza(zzi zzi);

    /* access modifiers changed from: protected */
    public abstract void zza(T t);

    /* access modifiers changed from: protected */
    public zzr zzb(zzr zzr) {
        return zzr;
    }

    /* renamed from: zzc */
    public int compareTo(zzk<T> zzk) {
        zzk<T> zzk2 = zzk;
        zza zzs = zzs();
        zza zzs2 = zzk2.zzs();
        return zzs == zzs2 ? this.zzI.intValue() - zzk2.zzI.intValue() : zzs2.ordinal() - zzs.ordinal();
    }

    public void zzc(zzr zzr) {
        zzr zzr2 = zzr;
        if (this.zzH != null) {
            this.zzH.zze(zzr2);
        }
    }

    public void zzc(String str) {
        String str2 = str;
        if (zza.zzak) {
            this.zzD.zza(str2, Thread.currentThread().getId());
        } else if (this.zzN == 0) {
            this.zzN = SystemClock.elapsedRealtime();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzd(String str) {
        Handler handler;
        C04381 r14;
        String str2 = str;
        if (this.zzJ != null) {
            this.zzJ.zzf(this);
        }
        if (zza.zzak) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Handler handler2 = handler;
                Handler handler3 = new Handler(Looper.getMainLooper());
                C04381 r8 = r14;
                final String str3 = str2;
                final long j = id;
                C04381 r9 = new Runnable(this) {
                    final /* synthetic */ zzk zzS;

                    {
                        String str = r10;
                        long j = r11;
                        this.zzS = r9;
                    }

                    public void run() {
                        this.zzS.zzD.zza(str3, j);
                        this.zzS.zzD.zzd(toString());
                    }
                };
                boolean post = handler2.post(r8);
                return;
            }
            this.zzD.zza(str2, id);
            this.zzD.zzd(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzN;
        if (elapsedRealtime >= 3000) {
            zzs.zzb("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    public int zzg() {
        return this.zzG;
    }

    public String zzh() {
        return getUrl();
    }

    public com.google.android.gms.internal.zzb.zza zzi() {
        return this.zzP;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Map<String, String> zzj() throws zza {
        return zzn();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String zzk() {
        return zzo();
    }

    @Deprecated
    public String zzl() {
        return zzp();
    }

    @Deprecated
    public byte[] zzm() throws zza {
        Map zzj = zzj();
        if (zzj == null || zzj.size() <= 0) {
            return null;
        }
        return zza(zzj, zzk());
    }

    /* access modifiers changed from: protected */
    public Map<String, String> zzn() throws zza {
        return null;
    }

    /* access modifiers changed from: protected */
    public String zzo() {
        return "UTF-8";
    }

    public String zzp() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("application/x-www-form-urlencoded; charset=").append(zzo()).toString();
    }

    public byte[] zzq() throws zza {
        Map zzn = zzn();
        if (zzn == null || zzn.size() <= 0) {
            return null;
        }
        return zza(zzn, zzo());
    }

    public final boolean zzr() {
        return this.zzK;
    }

    public zza zzs() {
        return zza.zzU;
    }

    public final int zzt() {
        return this.zzO.zzd();
    }

    public zzo zzu() {
        return this.zzO;
    }

    public void zzv() {
        this.zzM = true;
    }

    public boolean zzw() {
        return this.zzM;
    }
}
