package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;

public class zzrp {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzbhl = "*gcore*:";
    private final Context mContext;
    private final String zzanQ;
    private final WakeLock zzbhm;
    private WorkSource zzbhn;
    private final int zzbho;
    private final String zzbhp;
    private boolean zzbhq;
    private int zzbhr;
    private int zzbhs;

    public zzrp(Context context, int i, String str) {
        Context context2 = context;
        this(context2, i, str, null, context2 == null ? null : context2.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzrp(Context context, int i, String str, String str2, String str3) {
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb2;
        Context context2 = context;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        this.zzbhq = true;
        String zzh = zzx.zzh(str4, "Wake lock name can NOT be empty");
        this.zzbho = i2;
        this.zzbhp = str5;
        this.mContext = context2.getApplicationContext();
        if (zzni.zzcV(str6) || "com.google.android.gms" == str6) {
            this.zzanQ = str4;
        } else {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            this.zzanQ = sb3.append(zzbhl).append(str4).toString();
        }
        this.zzbhm = ((PowerManager) context2.getSystemService("power")).newWakeLock(i2, str4);
        if (zznj.zzaA(this.mContext)) {
            if (zzni.zzcV(str6)) {
                if (!zzd.zzakE || !zzlz.isInitialized()) {
                    str6 = context2.getPackageName();
                } else {
                    String str7 = TAG;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    String sb7 = sb5.append("callingPackage is not supposed to be empty for wakelock ").append(this.zzanQ).append("!").toString();
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
                    int e = Log.e(str7, sb7, illegalArgumentException2);
                    str6 = "com.google.android.gms";
                }
            }
            this.zzbhn = zznj.zzl(context2, str6);
            zzc(this.zzbhn);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0092, code lost:
        if (r2 == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009d, code lost:
        if (r0.zzbhs == 1) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzfJ(java.lang.String r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r6 = r0
            r7 = r1
            boolean r6 = r6.zzfK(r7)
            r2 = r6
            r6 = r0
            r7 = r1
            r8 = r2
            java.lang.String r6 = r6.zzn(r7, r8)
            r3 = r6
            boolean r6 = DEBUG
            if (r6 == 0) goto L_0x007d
            java.lang.String r6 = TAG
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r14 = r7
            r7 = r14
            r8 = r14
            r8.<init>()
            java.lang.String r8 = "Release:\n mWakeLockName: "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r0
            java.lang.String r8 = r8.zzanQ
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "\n mSecondaryName: "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r0
            java.lang.String r8 = r8.zzbhp
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "\nmReferenceCounted: "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r0
            boolean r8 = r8.zzbhq
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "\nreason: "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r1
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "\n mOpenEventCount"
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r0
            int r8 = r8.zzbhs
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "\nuseWithReason: "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r2
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "\ntrackingName: "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r3
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            int r6 = android.util.Log.d(r6, r7)
        L_0x007d:
            r6 = r0
            monitor-enter(r6)
            r6 = r0
            boolean r6 = r6.zzbhq     // Catch:{ all -> 0x00cc }
            if (r6 == 0) goto L_0x0094
            r6 = -1
            r7 = r0
            int r7 = r7.zzbhr     // Catch:{ all -> 0x00cc }
            int r6 = r6 + r7
            r5 = r6
            r6 = r0
            r7 = r5
            r6.zzbhr = r7     // Catch:{ all -> 0x00cc }
            r6 = r5
            if (r6 == 0) goto L_0x009f
            r6 = r2
            if (r6 != 0) goto L_0x009f
        L_0x0094:
            r6 = r0
            boolean r6 = r6.zzbhq     // Catch:{ all -> 0x00cc }
            if (r6 != 0) goto L_0x00c9
            r6 = r0
            int r6 = r6.zzbhs     // Catch:{ all -> 0x00cc }
            r7 = 1
            if (r6 != r7) goto L_0x00c9
        L_0x009f:
            com.google.android.gms.common.stats.zzi r6 = com.google.android.gms.common.stats.zzi.zzrZ()     // Catch:{ all -> 0x00cc }
            r7 = r0
            android.content.Context r7 = r7.mContext     // Catch:{ all -> 0x00cc }
            r8 = r0
            android.os.PowerManager$WakeLock r8 = r8.zzbhm     // Catch:{ all -> 0x00cc }
            r9 = r3
            java.lang.String r8 = com.google.android.gms.common.stats.zzg.zza(r8, r9)     // Catch:{ all -> 0x00cc }
            r9 = 8
            r10 = r0
            java.lang.String r10 = r10.zzanQ     // Catch:{ all -> 0x00cc }
            r11 = r3
            r12 = r0
            int r12 = r12.zzbho     // Catch:{ all -> 0x00cc }
            r13 = r0
            android.os.WorkSource r13 = r13.zzbhn     // Catch:{ all -> 0x00cc }
            java.util.List r13 = com.google.android.gms.internal.zznj.zzb(r13)     // Catch:{ all -> 0x00cc }
            r6.zza(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00cc }
            r6 = r0
            r7 = -1
            r8 = r0
            int r8 = r8.zzbhs     // Catch:{ all -> 0x00cc }
            int r7 = r7 + r8
            r6.zzbhs = r7     // Catch:{ all -> 0x00cc }
        L_0x00c9:
            r6 = r0
            monitor-exit(r6)     // Catch:{ all -> 0x00cc }
            return
        L_0x00cc:
            r6 = move-exception
            r4 = r6
            r6 = r0
            monitor-exit(r6)     // Catch:{ all -> 0x00cc }
            r6 = r4
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrp.zzfJ(java.lang.String):void");
    }

    private boolean zzfK(String str) {
        String str2 = str;
        return !TextUtils.isEmpty(str2) && !str2.equals(this.zzbhp);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00a4, code lost:
        if (r4 == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00ae, code lost:
        if (r0.zzbhs == 0) goto L_0x00b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzj(java.lang.String r20, long r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r8 = r0
            r9 = r1
            boolean r8 = r8.zzfK(r9)
            r4 = r8
            r8 = r0
            r9 = r1
            r10 = r4
            java.lang.String r8 = r8.zzn(r9, r10)
            r5 = r8
            boolean r8 = DEBUG
            if (r8 == 0) goto L_0x008e
            java.lang.String r8 = TAG
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r18 = r9
            r9 = r18
            r10 = r18
            r10.<init>()
            java.lang.String r10 = "Acquire:\n mWakeLockName: "
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r0
            java.lang.String r10 = r10.zzanQ
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = "\n mSecondaryName: "
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r0
            java.lang.String r10 = r10.zzbhp
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = "\nmReferenceCounted: "
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r0
            boolean r10 = r10.zzbhq
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = "\nreason: "
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r1
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = "\nmOpenEventCount"
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r0
            int r10 = r10.zzbhs
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = "\nuseWithReason: "
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r4
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = "\ntrackingName: "
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r5
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = "\ntimeout: "
            java.lang.StringBuilder r9 = r9.append(r10)
            r10 = r2
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            int r8 = android.util.Log.d(r8, r9)
        L_0x008e:
            r8 = r0
            monitor-enter(r8)
            r8 = r0
            boolean r8 = r8.zzbhq     // Catch:{ all -> 0x00de }
            if (r8 == 0) goto L_0x00a6
            r8 = r0
            int r8 = r8.zzbhr     // Catch:{ all -> 0x00de }
            r7 = r8
            r8 = r0
            r9 = r7
            r10 = 1
            int r9 = r9 + 1
            r8.zzbhr = r9     // Catch:{ all -> 0x00de }
            r8 = r7
            if (r8 == 0) goto L_0x00b0
            r8 = r4
            if (r8 != 0) goto L_0x00b0
        L_0x00a6:
            r8 = r0
            boolean r8 = r8.zzbhq     // Catch:{ all -> 0x00de }
            if (r8 != 0) goto L_0x00db
            r8 = r0
            int r8 = r8.zzbhs     // Catch:{ all -> 0x00de }
            if (r8 != 0) goto L_0x00db
        L_0x00b0:
            com.google.android.gms.common.stats.zzi r8 = com.google.android.gms.common.stats.zzi.zzrZ()     // Catch:{ all -> 0x00de }
            r9 = r0
            android.content.Context r9 = r9.mContext     // Catch:{ all -> 0x00de }
            r10 = r0
            android.os.PowerManager$WakeLock r10 = r10.zzbhm     // Catch:{ all -> 0x00de }
            r11 = r5
            java.lang.String r10 = com.google.android.gms.common.stats.zzg.zza(r10, r11)     // Catch:{ all -> 0x00de }
            r11 = 7
            r12 = r0
            java.lang.String r12 = r12.zzanQ     // Catch:{ all -> 0x00de }
            r13 = r5
            r14 = r0
            int r14 = r14.zzbho     // Catch:{ all -> 0x00de }
            r15 = r0
            android.os.WorkSource r15 = r15.zzbhn     // Catch:{ all -> 0x00de }
            java.util.List r15 = com.google.android.gms.internal.zznj.zzb(r15)     // Catch:{ all -> 0x00de }
            r16 = r2
            r8.zza(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x00de }
            r8 = r0
            r9 = 1
            r10 = r0
            int r10 = r10.zzbhs     // Catch:{ all -> 0x00de }
            int r9 = r9 + r10
            r8.zzbhs = r9     // Catch:{ all -> 0x00de }
        L_0x00db:
            r8 = r0
            monitor-exit(r8)     // Catch:{ all -> 0x00de }
            return
        L_0x00de:
            r8 = move-exception
            r6 = r8
            r8 = r0
            monitor-exit(r8)     // Catch:{ all -> 0x00de }
            r8 = r6
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrp.zzj(java.lang.String, long):void");
    }

    private String zzn(String str, boolean z) {
        return this.zzbhq ? z ? str : this.zzbhp : this.zzbhp;
    }

    public void acquire(long j) {
        StringBuilder sb;
        long j2 = j;
        if (!zzne.zzsg() && this.zzbhq) {
            String str = TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int wtf = Log.wtf(str, sb2.append("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ").append(this.zzanQ).toString());
        }
        zzj(null, j2);
        this.zzbhm.acquire(j2);
    }

    public boolean isHeld() {
        return this.zzbhm.isHeld();
    }

    public void release() {
        zzfJ(null);
        this.zzbhm.release();
    }

    public void setReferenceCounted(boolean z) {
        boolean z2 = z;
        this.zzbhm.setReferenceCounted(z2);
        this.zzbhq = z2;
    }

    public void zzc(WorkSource workSource) {
        WorkSource workSource2 = workSource;
        if (zznj.zzaA(this.mContext) && workSource2 != null) {
            if (this.zzbhn != null) {
                boolean add = this.zzbhn.add(workSource2);
            } else {
                this.zzbhn = workSource2;
            }
            this.zzbhm.setWorkSource(this.zzbhn);
        }
    }
}
