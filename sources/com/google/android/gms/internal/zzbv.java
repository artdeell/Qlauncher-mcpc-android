package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzhb
public class zzbv {
    final Context mContext;
    final String zzsy;
    String zzxj;
    BlockingQueue<zzcb> zzxl;
    ExecutorService zzxm;
    LinkedHashMap<String, String> zzxn;
    Map<String, zzby> zzxo;
    private AtomicBoolean zzxp;
    private File zzxq;

    public zzbv(Context context, String str, String str2, Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap;
        HashMap hashMap;
        AtomicBoolean atomicBoolean;
        ArrayBlockingQueue arrayBlockingQueue;
        C02801 r17;
        File file;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        Map<String, String> map2 = map;
        LinkedHashMap<String, String> linkedHashMap2 = linkedHashMap;
        LinkedHashMap<String, String> linkedHashMap3 = new LinkedHashMap<>();
        this.zzxn = linkedHashMap2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.zzxo = hashMap2;
        this.mContext = context2;
        this.zzsy = str3;
        this.zzxj = str4;
        AtomicBoolean atomicBoolean2 = atomicBoolean;
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
        this.zzxp = atomicBoolean2;
        this.zzxp.set(((Boolean) zzbt.zzwi.get()).booleanValue());
        if (this.zzxp.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                File file2 = file;
                File file3 = new File(externalStorageDirectory, "sdk_csi_data.txt");
                this.zzxq = file2;
            }
        }
        for (Entry entry : map2.entrySet()) {
            Object put = this.zzxn.put(entry.getKey(), entry.getValue());
        }
        ArrayBlockingQueue arrayBlockingQueue2 = arrayBlockingQueue;
        ArrayBlockingQueue arrayBlockingQueue3 = new ArrayBlockingQueue(30);
        this.zzxl = arrayBlockingQueue2;
        this.zzxm = Executors.newSingleThreadExecutor();
        ExecutorService executorService = this.zzxm;
        C02801 r13 = r17;
        C02801 r14 = new Runnable(this) {
            final /* synthetic */ zzbv zzxr;

            {
                this.zzxr = r5;
            }

            public void run() {
                this.zzxr.zzdx();
            }
        };
        executorService.execute(r13);
        Object put2 = this.zzxo.put("action", zzby.zzxt);
        Object put3 = this.zzxo.put("ad_format", zzby.zzxt);
        Object put4 = this.zzxo.put("e", zzby.zzxu);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(java.io.File r15, java.lang.String r16) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            r9 = r1
            if (r9 == 0) goto L_0x0063
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0032, all -> 0x004d }
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = r1
            r12 = 1
            r10.<init>(r11, r12)     // Catch:{ IOException -> 0x0032, all -> 0x004d }
            r3 = r9
            r9 = r3
            r10 = r2
            byte[] r10 = r10.getBytes()     // Catch:{ IOException -> 0x006c }
            r9.write(r10)     // Catch:{ IOException -> 0x006c }
            r9 = r3
            r10 = 10
            r9.write(r10)     // Catch:{ IOException -> 0x006c }
            r9 = r3
            if (r9 == 0) goto L_0x0028
            r9 = r3
            r9.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0028:
            return
        L_0x0029:
            r9 = move-exception
            r8 = r9
            java.lang.String r9 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            r10 = r8
            com.google.android.gms.internal.zzin.zzd(r9, r10)
            goto L_0x0028
        L_0x0032:
            r9 = move-exception
            r4 = r9
            r9 = 0
            r3 = r9
        L_0x0036:
            java.lang.String r9 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            r10 = r4
            com.google.android.gms.internal.zzin.zzd(r9, r10)     // Catch:{ all -> 0x0069 }
            r9 = r3
            if (r9 == 0) goto L_0x0028
            r9 = r3
            r9.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0028
        L_0x0044:
            r9 = move-exception
            r7 = r9
            java.lang.String r9 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            r10 = r7
            com.google.android.gms.internal.zzin.zzd(r9, r10)
            goto L_0x0028
        L_0x004d:
            r9 = move-exception
            r5 = r9
            r9 = 0
            r3 = r9
        L_0x0051:
            r9 = r3
            if (r9 == 0) goto L_0x0058
            r9 = r3
            r9.close()     // Catch:{ IOException -> 0x005a }
        L_0x0058:
            r9 = r5
            throw r9
        L_0x005a:
            r9 = move-exception
            r6 = r9
            java.lang.String r9 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            r10 = r6
            com.google.android.gms.internal.zzin.zzd(r9, r10)
            goto L_0x0058
        L_0x0063:
            java.lang.String r9 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.zzin.zzaK(r9)
            goto L_0x0028
        L_0x0069:
            r9 = move-exception
            r5 = r9
            goto L_0x0051
        L_0x006c:
            r9 = move-exception
            r4 = r9
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbv.zza(java.io.File, java.lang.String):void");
    }

    private void zzc(Map<String, String> map, String str) {
        String zza = zza(this.zzxj, map, str);
        if (this.zzxp.get()) {
            zza(this.zzxq, zza);
        } else {
            zzr.zzbC().zzc(this.mContext, this.zzsy, zza);
        }
    }

    /* access modifiers changed from: private */
    public void zzdx() {
        while (true) {
            try {
                zzcb zzcb = (zzcb) this.zzxl.take();
                String zzdD = zzcb.zzdD();
                if (!TextUtils.isEmpty(zzdD)) {
                    zzc(zza((Map<String, String>) this.zzxn, zzcb.zzn()), zzdD);
                }
            } catch (InterruptedException e) {
                zzin.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public zzby zzL(String str) {
        zzby zzby = (zzby) this.zzxo.get(str);
        return zzby != null ? zzby : zzby.zzxs;
    }

    /* access modifiers changed from: 0000 */
    public String zza(String str, Map<String, String> map, @NonNull String str2) {
        StringBuilder sb;
        Map<String, String> map2 = map;
        String str3 = str2;
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map2.entrySet()) {
            Builder appendQueryParameter = buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(buildUpon.build().toString());
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("&").append("it").append("=").append(str3);
        return sb4.toString();
    }

    /* access modifiers changed from: 0000 */
    public Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap;
        Map<String, String> map3 = map2;
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(map);
        LinkedHashMap linkedHashMap4 = linkedHashMap2;
        if (map3 == null) {
            return linkedHashMap4;
        }
        for (Entry entry : map3.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap4.get(str);
            Object put = linkedHashMap4.put(str, zzL(str).zzb(str2, (String) entry.getValue()));
        }
        return linkedHashMap4;
    }

    public boolean zza(zzcb zzcb) {
        return this.zzxl.offer(zzcb);
    }

    public void zzb(List<String> list) {
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            Object put = this.zzxn.put("e", TextUtils.join(",", list2));
        }
    }
}
