package com.google.android.gms.internal;

import android.content.Context;

@zzhb
public class zzgr {

    public interface zza {
        void zzb(zzif zzif);
    }

    public zzgr() {
    }

    /* JADX WARNING: type inference failed for: r22v0 */
    /* JADX WARNING: type inference failed for: r14v13 */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r14v20 */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: type inference failed for: r14v22 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r14v36 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r15v9, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r14v42, types: [com.google.android.gms.internal.zzit] */
    /* JADX WARNING: type inference failed for: r14v44 */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.zzit] */
    /* JADX WARNING: type inference failed for: r22v8 */
    /* JADX WARNING: type inference failed for: r14v46 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 15 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzit zza(android.content.Context r24, com.google.android.gms.ads.internal.zza r25, com.google.android.gms.internal.zzif.zza r26, com.google.android.gms.internal.zzan r27, com.google.android.gms.internal.zzjp r28, com.google.android.gms.internal.zzex r29, com.google.android.gms.internal.zzgr.zza r30, com.google.android.gms.internal.zzcb r31) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r14 = r3
            com.google.android.gms.ads.internal.request.AdResponseParcel r14 = r14.zzLe
            r9 = r14
            r14 = r9
            boolean r14 = r14.zzHT
            if (r14 == 0) goto L_0x0060
            com.google.android.gms.internal.zzgu r14 = new com.google.android.gms.internal.zzgu
            r22 = r14
            r14 = r22
            r15 = r22
            r16 = r1
            r17 = r3
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r5
            r15.<init>(r16, r17, r18, r19, r20, r21)
            r10 = r14
        L_0x0033:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r22 = r14
            r14 = r22
            r15 = r22
            r15.<init>()
            java.lang.String r15 = "AdRenderer: "
            java.lang.StringBuilder r14 = r14.append(r15)
            r15 = r10
            java.lang.Class r15 = r15.getClass()
            java.lang.String r15 = r15.getName()
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            com.google.android.gms.internal.zzin.zzaI(r14)
            r14 = r10
            java.lang.Object r14 = r14.zzgd()
            r14 = r10
            r0 = r14
            return r0
        L_0x0060:
            r14 = r9
            boolean r14 = r14.zzuk
            if (r14 == 0) goto L_0x00cf
            r14 = r2
            boolean r14 = r14 instanceof com.google.android.gms.ads.internal.zzp
            if (r14 == 0) goto L_0x008e
            com.google.android.gms.internal.zzgv r14 = new com.google.android.gms.internal.zzgv
            r22 = r14
            r14 = r22
            r15 = r22
            r16 = r1
            r17 = r2
            com.google.android.gms.ads.internal.zzp r17 = (com.google.android.gms.ads.internal.zzp) r17
            com.google.android.gms.internal.zzee r18 = new com.google.android.gms.internal.zzee
            r22 = r18
            r18 = r22
            r19 = r22
            r19.<init>()
            r19 = r3
            r20 = r4
            r21 = r7
            r15.<init>(r16, r17, r18, r19, r20, r21)
            r10 = r14
            goto L_0x0033
        L_0x008e:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r22 = r14
            r14 = r22
            r15 = r22
            r15.<init>()
            java.lang.String r15 = "Invalid NativeAdManager type. Found: "
            java.lang.StringBuilder r14 = r14.append(r15)
            r12 = r14
            r14 = r2
            if (r14 == 0) goto L_0x00cb
            r14 = r2
            java.lang.Class r14 = r14.getClass()
            java.lang.String r14 = r14.getName()
            r13 = r14
        L_0x00ad:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            r22 = r14
            r14 = r22
            r15 = r22
            r16 = r12
            r17 = r13
            java.lang.StringBuilder r16 = r16.append(r17)
            java.lang.String r17 = "; Required: NativeAdManager."
            java.lang.StringBuilder r16 = r16.append(r17)
            java.lang.String r16 = r16.toString()
            r15.<init>(r16)
            throw r14
        L_0x00cb:
            java.lang.String r14 = "null"
            r13 = r14
            goto L_0x00ad
        L_0x00cf:
            r14 = r9
            boolean r14 = r14.zzHZ
            if (r14 == 0) goto L_0x00ea
            com.google.android.gms.internal.zzgp r14 = new com.google.android.gms.internal.zzgp
            r22 = r14
            r14 = r22
            r15 = r22
            r16 = r1
            r17 = r3
            r18 = r5
            r19 = r7
            r15.<init>(r16, r17, r18, r19)
            r10 = r14
            goto L_0x0033
        L_0x00ea:
            com.google.android.gms.internal.zzbp<java.lang.Boolean> r14 = com.google.android.gms.internal.zzbt.zzwu
            java.lang.Object r14 = r14.get()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0123
            boolean r14 = com.google.android.gms.internal.zzne.zzsk()
            if (r14 == 0) goto L_0x0123
            boolean r14 = com.google.android.gms.internal.zzne.isAtLeastL()
            if (r14 != 0) goto L_0x0123
            r14 = r5
            com.google.android.gms.ads.internal.client.AdSizeParcel r14 = r14.zzaN()
            boolean r14 = r14.zzui
            if (r14 == 0) goto L_0x0123
            com.google.android.gms.internal.zzgt r14 = new com.google.android.gms.internal.zzgt
            r22 = r14
            r14 = r22
            r15 = r22
            r16 = r1
            r17 = r3
            r18 = r5
            r19 = r7
            r15.<init>(r16, r17, r18, r19)
            r10 = r14
            goto L_0x0033
        L_0x0123:
            com.google.android.gms.internal.zzgs r14 = new com.google.android.gms.internal.zzgs
            r22 = r14
            r14 = r22
            r15 = r22
            r16 = r1
            r17 = r3
            r18 = r5
            r19 = r7
            r15.<init>(r16, r17, r18, r19)
            r10 = r14
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgr.zza(android.content.Context, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzif$zza, com.google.android.gms.internal.zzan, com.google.android.gms.internal.zzjp, com.google.android.gms.internal.zzex, com.google.android.gms.internal.zzgr$zza, com.google.android.gms.internal.zzcb):com.google.android.gms.internal.zzit");
    }

    public zzit zza(Context context, String str, com.google.android.gms.internal.zzif.zza zza2, zzht zzht) {
        zzhz zzhz;
        StringBuilder sb;
        zzhz zzhz2 = zzhz;
        zzhz zzhz3 = new zzhz(context, str, zza2, zzht);
        zzhz zzhz4 = zzhz2;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzin.zzaI(sb2.append("AdRenderer: ").append(zzhz4.getClass().getName()).toString());
        Object zzgd = zzhz4.zzgd();
        return zzhz4;
    }
}
