package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public interface zzsz {

    public static final class zza extends zzso<zza> {
        public String[] zzbuI;
        public String[] zzbuJ;
        public int[] zzbuK;
        public long[] zzbuL;

        public zza() {
            zza zzJC = zzJC();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
            if (r4.zzbuj.isEmpty() != false) goto L_0x0078;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r13) {
            /*
                r12 = this;
                r0 = r12
                r1 = r13
                r10 = r1
                r11 = r0
                if (r10 != r11) goto L_0x000b
                r10 = 1
                r3 = r10
            L_0x0008:
                r10 = r3
                r0 = r10
            L_0x000a:
                return r0
            L_0x000b:
                r10 = r1
                boolean r10 = r10 instanceof com.google.android.gms.internal.zzsz.zza
                r2 = r10
                r10 = 0
                r3 = r10
                r10 = r2
                if (r10 == 0) goto L_0x0008
                r10 = r1
                com.google.android.gms.internal.zzsz$zza r10 = (com.google.android.gms.internal.zzsz.zza) r10
                r4 = r10
                r10 = r0
                java.lang.String[] r10 = r10.zzbuI
                r11 = r4
                java.lang.String[] r11 = r11.zzbuI
                boolean r10 = com.google.android.gms.internal.zzss.equals(r10, r11)
                r5 = r10
                r10 = 0
                r3 = r10
                r10 = r5
                if (r10 == 0) goto L_0x0008
                r10 = r0
                java.lang.String[] r10 = r10.zzbuJ
                r11 = r4
                java.lang.String[] r11 = r11.zzbuJ
                boolean r10 = com.google.android.gms.internal.zzss.equals(r10, r11)
                r6 = r10
                r10 = 0
                r3 = r10
                r10 = r6
                if (r10 == 0) goto L_0x0008
                r10 = r0
                int[] r10 = r10.zzbuK
                r11 = r4
                int[] r11 = r11.zzbuK
                boolean r10 = com.google.android.gms.internal.zzss.equals(r10, r11)
                r7 = r10
                r10 = 0
                r3 = r10
                r10 = r7
                if (r10 == 0) goto L_0x0008
                r10 = r0
                long[] r10 = r10.zzbuL
                r11 = r4
                long[] r11 = r11.zzbuL
                boolean r10 = com.google.android.gms.internal.zzss.equals(r10, r11)
                r8 = r10
                r10 = 0
                r3 = r10
                r10 = r8
                if (r10 == 0) goto L_0x0008
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                if (r10 == 0) goto L_0x0066
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                boolean r10 = r10.isEmpty()
                if (r10 == 0) goto L_0x007b
            L_0x0066:
                r10 = r4
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                if (r10 == 0) goto L_0x0078
                r10 = r4
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                boolean r10 = r10.isEmpty()
                r9 = r10
                r10 = 0
                r3 = r10
                r10 = r9
                if (r10 == 0) goto L_0x0008
            L_0x0078:
                r10 = 1
                r0 = r10
                goto L_0x000a
            L_0x007b:
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                r11 = r4
                com.google.android.gms.internal.zzsq r11 = r11.zzbuj
                boolean r10 = r10.equals(r11)
                r0 = r10
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + (31 * ((31 * ((31 * ((31 * ((31 * (527 + getClass().getName().hashCode())) + zzss.hashCode((Object[]) this.zzbuI))) + zzss.hashCode((Object[]) this.zzbuJ))) + zzss.hashCode(this.zzbuK))) + zzss.hashCode(this.zzbuL)));
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn zzsn2 = zzsn;
            if (this.zzbuI != null && this.zzbuI.length > 0) {
                for (int i = 0; i < this.zzbuI.length; i++) {
                    String str = this.zzbuI[i];
                    if (str != null) {
                        zzsn2.zzn(1, str);
                    }
                }
            }
            if (this.zzbuJ != null && this.zzbuJ.length > 0) {
                for (int i2 = 0; i2 < this.zzbuJ.length; i2++) {
                    String str2 = this.zzbuJ[i2];
                    if (str2 != null) {
                        zzsn2.zzn(2, str2);
                    }
                }
            }
            if (this.zzbuK != null && this.zzbuK.length > 0) {
                for (int i3 = 0; i3 < this.zzbuK.length; i3++) {
                    zzsn2.zzA(3, this.zzbuK[i3]);
                }
            }
            if (this.zzbuL != null) {
                if (this.zzbuL.length > 0) {
                    for (int i4 = 0; i4 < this.zzbuL.length; i4++) {
                        zzsn2.zzb(4, this.zzbuL[i4]);
                    }
                }
            }
            super.writeTo(zzsn2);
        }

        public zza zzJC() {
            this.zzbuI = zzsx.zzbuB;
            this.zzbuJ = zzsx.zzbuB;
            this.zzbuK = zzsx.zzbuw;
            this.zzbuL = zzsx.zzbux;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzS */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            int length;
            int length2;
            int length3;
            int length4;
            int length5;
            int length6;
            zzsm zzsm2 = zzsm;
            while (true) {
                int zzIX = zzsm2.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm2, 10);
                        if (this.zzbuI == null) {
                            length6 = 0;
                        } else {
                            length6 = this.zzbuI.length;
                        }
                        String[] strArr = new String[(zzc + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzbuI, 0, strArr, 0, length6);
                        }
                        while (length6 < -1 + strArr.length) {
                            strArr[length6] = zzsm2.readString();
                            int zzIX2 = zzsm2.zzIX();
                            length6++;
                        }
                        strArr[length6] = zzsm2.readString();
                        this.zzbuI = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzsx.zzc(zzsm2, 18);
                        if (this.zzbuJ == null) {
                            length5 = 0;
                        } else {
                            length5 = this.zzbuJ.length;
                        }
                        String[] strArr2 = new String[(zzc2 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzbuJ, 0, strArr2, 0, length5);
                        }
                        while (length5 < -1 + strArr2.length) {
                            strArr2[length5] = zzsm2.readString();
                            int zzIX3 = zzsm2.zzIX();
                            length5++;
                        }
                        strArr2[length5] = zzsm2.readString();
                        this.zzbuJ = strArr2;
                        continue;
                    case 24:
                        int zzc3 = zzsx.zzc(zzsm2, 24);
                        if (this.zzbuK == null) {
                            length4 = 0;
                        } else {
                            length4 = this.zzbuK.length;
                        }
                        int[] iArr = new int[(zzc3 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbuK, 0, iArr, 0, length4);
                        }
                        while (length4 < -1 + iArr.length) {
                            iArr[length4] = zzsm2.zzJb();
                            int zzIX4 = zzsm2.zzIX();
                            length4++;
                        }
                        iArr[length4] = zzsm2.zzJb();
                        this.zzbuK = iArr;
                        continue;
                    case 26:
                        int zzmq = zzsm2.zzmq(zzsm2.zzJf());
                        int position = zzsm2.getPosition();
                        int i = 0;
                        while (zzsm2.zzJk() > 0) {
                            int zzJb = zzsm2.zzJb();
                            i++;
                        }
                        zzsm2.zzms(position);
                        if (this.zzbuK == null) {
                            length3 = 0;
                        } else {
                            length3 = this.zzbuK.length;
                        }
                        int[] iArr2 = new int[(i + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbuK, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzsm2.zzJb();
                            length3++;
                        }
                        this.zzbuK = iArr2;
                        zzsm2.zzmr(zzmq);
                        continue;
                    case 32:
                        int zzc4 = zzsx.zzc(zzsm2, 32);
                        if (this.zzbuL == null) {
                            length2 = 0;
                        } else {
                            length2 = this.zzbuL.length;
                        }
                        long[] jArr = new long[(zzc4 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbuL, 0, jArr, 0, length2);
                        }
                        while (length2 < -1 + jArr.length) {
                            jArr[length2] = zzsm2.zzJa();
                            int zzIX5 = zzsm2.zzIX();
                            length2++;
                        }
                        jArr[length2] = zzsm2.zzJa();
                        this.zzbuL = jArr;
                        continue;
                    case 34:
                        int zzmq2 = zzsm2.zzmq(zzsm2.zzJf());
                        int position2 = zzsm2.getPosition();
                        int i2 = 0;
                        while (zzsm2.zzJk() > 0) {
                            long zzJa = zzsm2.zzJa();
                            i2++;
                        }
                        zzsm2.zzms(position2);
                        if (this.zzbuL == null) {
                            length = 0;
                        } else {
                            length = this.zzbuL.length;
                        }
                        long[] jArr2 = new long[(i2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbuL, 0, jArr2, 0, length);
                        }
                        while (length < jArr2.length) {
                            jArr2[length] = zzsm2.zzJa();
                            length++;
                        }
                        this.zzbuL = jArr2;
                        zzsm2.zzmr(zzmq2);
                        continue;
                    default:
                        if (!zza(zzsm2, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00f2  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x015c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int zzz() {
            /*
                r20 = this;
                r2 = r20
                r17 = 0
                r3 = r17
                r17 = r2
                int r17 = super.zzz()
                r4 = r17
                r17 = r2
                r0 = r17
                java.lang.String[] r0 = r0.zzbuI
                r17 = r0
                if (r17 == 0) goto L_0x01bd
                r17 = r2
                r0 = r17
                java.lang.String[] r0 = r0.zzbuI
                r17 = r0
                r0 = r17
                int r0 = r0.length
                r17 = r0
                if (r17 <= 0) goto L_0x01bd
                r17 = 0
                r13 = r17
                r17 = 0
                r14 = r17
                r17 = 0
                r15 = r17
            L_0x0033:
                r17 = r13
                r18 = r2
                r0 = r18
                java.lang.String[] r0 = r0.zzbuI
                r18 = r0
                r0 = r18
                int r0 = r0.length
                r18 = r0
                r0 = r17
                r1 = r18
                if (r0 >= r1) goto L_0x006b
                r17 = r2
                r0 = r17
                java.lang.String[] r0 = r0.zzbuI
                r17 = r0
                r18 = r13
                r17 = r17[r18]
                r16 = r17
                r17 = r16
                if (r17 == 0) goto L_0x0068
                int r15 = r15 + 1
                r17 = r14
                r18 = r16
                int r18 = com.google.android.gms.internal.zzsn.zzgO(r18)
                int r17 = r17 + r18
                r14 = r17
            L_0x0068:
                int r13 = r13 + 1
                goto L_0x0033
            L_0x006b:
                r17 = r4
                r18 = r14
                int r17 = r17 + r18
                r18 = r15
                r19 = 1
                int r18 = r18 * 1
                int r17 = r17 + r18
                r5 = r17
            L_0x007b:
                r17 = r2
                r0 = r17
                java.lang.String[] r0 = r0.zzbuJ
                r17 = r0
                if (r17 == 0) goto L_0x00e8
                r17 = r2
                r0 = r17
                java.lang.String[] r0 = r0.zzbuJ
                r17 = r0
                r0 = r17
                int r0 = r0.length
                r17 = r0
                if (r17 <= 0) goto L_0x00e8
                r17 = 0
                r9 = r17
                r17 = 0
                r10 = r17
                r17 = 0
                r11 = r17
            L_0x00a0:
                r17 = r9
                r18 = r2
                r0 = r18
                java.lang.String[] r0 = r0.zzbuJ
                r18 = r0
                r0 = r18
                int r0 = r0.length
                r18 = r0
                r0 = r17
                r1 = r18
                if (r0 >= r1) goto L_0x00d8
                r17 = r2
                r0 = r17
                java.lang.String[] r0 = r0.zzbuJ
                r17 = r0
                r18 = r9
                r17 = r17[r18]
                r12 = r17
                r17 = r12
                if (r17 == 0) goto L_0x00d5
                int r11 = r11 + 1
                r17 = r10
                r18 = r12
                int r18 = com.google.android.gms.internal.zzsn.zzgO(r18)
                int r17 = r17 + r18
                r10 = r17
            L_0x00d5:
                int r9 = r9 + 1
                goto L_0x00a0
            L_0x00d8:
                r17 = r5
                r18 = r10
                int r17 = r17 + r18
                r18 = r11
                r19 = 1
                int r18 = r18 * 1
                int r17 = r17 + r18
                r5 = r17
            L_0x00e8:
                r17 = r2
                r0 = r17
                int[] r0 = r0.zzbuK
                r17 = r0
                if (r17 == 0) goto L_0x0152
                r17 = r2
                r0 = r17
                int[] r0 = r0.zzbuK
                r17 = r0
                r0 = r17
                int r0 = r0.length
                r17 = r0
                if (r17 <= 0) goto L_0x0152
                r17 = 0
                r7 = r17
                r17 = 0
                r8 = r17
            L_0x0109:
                r17 = r7
                r18 = r2
                r0 = r18
                int[] r0 = r0.zzbuK
                r18 = r0
                r0 = r18
                int r0 = r0.length
                r18 = r0
                r0 = r17
                r1 = r18
                if (r0 >= r1) goto L_0x0137
                r17 = r8
                r18 = r2
                r0 = r18
                int[] r0 = r0.zzbuK
                r18 = r0
                r19 = r7
                r18 = r18[r19]
                int r18 = com.google.android.gms.internal.zzsn.zzmx(r18)
                int r17 = r17 + r18
                r8 = r17
                int r7 = r7 + 1
                goto L_0x0109
            L_0x0137:
                r17 = r5
                r18 = r8
                int r17 = r17 + r18
                r18 = 1
                r19 = r2
                r0 = r19
                int[] r0 = r0.zzbuK
                r19 = r0
                r0 = r19
                int r0 = r0.length
                r19 = r0
                int r18 = r18 * r19
                int r17 = r17 + r18
                r5 = r17
            L_0x0152:
                r17 = r2
                r0 = r17
                long[] r0 = r0.zzbuL
                r17 = r0
                if (r17 == 0) goto L_0x01b8
                r17 = r2
                r0 = r17
                long[] r0 = r0.zzbuL
                r17 = r0
                r0 = r17
                int r0 = r0.length
                r17 = r0
                if (r17 <= 0) goto L_0x01b8
                r17 = 0
                r6 = r17
            L_0x016f:
                r17 = r3
                r18 = r2
                r0 = r18
                long[] r0 = r0.zzbuL
                r18 = r0
                r0 = r18
                int r0 = r0.length
                r18 = r0
                r0 = r17
                r1 = r18
                if (r0 >= r1) goto L_0x019d
                r17 = r6
                r18 = r2
                r0 = r18
                long[] r0 = r0.zzbuL
                r18 = r0
                r19 = r3
                r18 = r18[r19]
                int r18 = com.google.android.gms.internal.zzsn.zzas(r18)
                int r17 = r17 + r18
                r6 = r17
                int r3 = r3 + 1
                goto L_0x016f
            L_0x019d:
                r17 = r5
                r18 = r6
                int r17 = r17 + r18
                r18 = 1
                r19 = r2
                r0 = r19
                long[] r0 = r0.zzbuL
                r19 = r0
                r0 = r19
                int r0 = r0.length
                r19 = r0
                int r18 = r18 * r19
                int r17 = r17 + r18
                r5 = r17
            L_0x01b8:
                r17 = r5
                r2 = r17
                return r2
            L_0x01bd:
                r17 = r4
                r5 = r17
                goto L_0x007b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zzz():int");
        }
    }

    public static final class zzb extends zzso<zzb> {
        public String version;
        public int zzbuM;
        public String zzbuN;

        public zzb() {
            zzb zzJD = zzJD();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
            if (r4.zzbuN == null) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            if (r4.version == null) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
            if (r4.zzbuj.isEmpty() != false) goto L_0x0062;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r13) {
            /*
                r12 = this;
                r0 = r12
                r1 = r13
                r10 = r1
                r11 = r0
                if (r10 != r11) goto L_0x000b
                r10 = 1
                r3 = r10
            L_0x0008:
                r10 = r3
                r0 = r10
            L_0x000a:
                return r0
            L_0x000b:
                r10 = r1
                boolean r10 = r10 instanceof com.google.android.gms.internal.zzsz.zzb
                r2 = r10
                r10 = 0
                r3 = r10
                r10 = r2
                if (r10 == 0) goto L_0x0008
                r10 = r1
                com.google.android.gms.internal.zzsz$zzb r10 = (com.google.android.gms.internal.zzsz.zzb) r10
                r4 = r10
                r10 = r0
                int r10 = r10.zzbuM
                r5 = r10
                r10 = r4
                int r10 = r10.zzbuM
                r6 = r10
                r10 = 0
                r3 = r10
                r10 = r5
                r11 = r6
                if (r10 != r11) goto L_0x0008
                r10 = r0
                java.lang.String r10 = r10.zzbuN
                if (r10 != 0) goto L_0x0065
                r10 = r4
                java.lang.String r10 = r10.zzbuN
                r9 = r10
                r10 = 0
                r3 = r10
                r10 = r9
                if (r10 != 0) goto L_0x0008
            L_0x0034:
                r10 = r0
                java.lang.String r10 = r10.version
                if (r10 != 0) goto L_0x0074
                r10 = r4
                java.lang.String r10 = r10.version
                r8 = r10
                r10 = 0
                r3 = r10
                r10 = r8
                if (r10 != 0) goto L_0x0008
            L_0x0042:
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                if (r10 == 0) goto L_0x0050
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                boolean r10 = r10.isEmpty()
                if (r10 == 0) goto L_0x0083
            L_0x0050:
                r10 = r4
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                if (r10 == 0) goto L_0x0062
                r10 = r4
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                boolean r10 = r10.isEmpty()
                r7 = r10
                r10 = 0
                r3 = r10
                r10 = r7
                if (r10 == 0) goto L_0x0008
            L_0x0062:
                r10 = 1
                r0 = r10
                goto L_0x000a
            L_0x0065:
                r10 = r0
                java.lang.String r10 = r10.zzbuN
                r11 = r4
                java.lang.String r11 = r11.zzbuN
                boolean r10 = r10.equals(r11)
                if (r10 != 0) goto L_0x0034
                r10 = 0
                r0 = r10
                goto L_0x000a
            L_0x0074:
                r10 = r0
                java.lang.String r10 = r10.version
                r11 = r4
                java.lang.String r11 = r11.version
                boolean r10 = r10.equals(r11)
                if (r10 != 0) goto L_0x0042
                r10 = 0
                r0 = r10
                goto L_0x000a
            L_0x0083:
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                r11 = r4
                com.google.android.gms.internal.zzsq r11 = r11.zzbuj
                boolean r10 = r10.equals(r11)
                r0 = r10
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zzb.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = 31 * ((this.version == null ? 0 : this.version.hashCode()) + (31 * ((this.zzbuN == null ? 0 : this.zzbuN.hashCode()) + (31 * ((31 * (527 + getClass().getName().hashCode())) + this.zzbuM)))));
            int i = 0;
            if (this.zzbuj != null) {
                i = 0;
                if (!this.zzbuj.isEmpty()) {
                    i = this.zzbuj.hashCode();
                }
            }
            return hashCode + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn zzsn2 = zzsn;
            if (this.zzbuM != 0) {
                zzsn2.zzA(1, this.zzbuM);
            }
            if (!this.zzbuN.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzsn2.zzn(2, this.zzbuN);
            }
            if (!this.version.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzsn2.zzn(3, this.version);
            }
            super.writeTo(zzsn2);
        }

        public zzb zzJD() {
            this.zzbuM = 0;
            this.zzbuN = LibrariesRepository.MOJANG_MAVEN_REPO;
            this.version = LibrariesRepository.MOJANG_MAVEN_REPO;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzT */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            zzsm zzsm2 = zzsm;
            while (true) {
                int zzIX = zzsm2.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        int zzJb = zzsm2.zzJb();
                        switch (zzJb) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzbuM = zzJb;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzbuN = zzsm2.readString();
                        continue;
                    case 26:
                        this.version = zzsm2.readString();
                        continue;
                    default:
                        if (!zza(zzsm2, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (this.zzbuM != 0) {
                zzz += zzsn.zzC(1, this.zzbuM);
            }
            if (!this.zzbuN.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzz += zzsn.zzo(2, this.zzbuN);
            }
            if (!this.version.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzz += zzsn.zzo(3, this.version);
            }
            return zzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        public byte[] zzbuO;
        public byte[][] zzbuP;
        public boolean zzbuQ;

        public zzc() {
            zzc zzJE = zzJE();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
            if (r4.zzbuj.isEmpty() != false) goto L_0x0066;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r13) {
            /*
                r12 = this;
                r0 = r12
                r1 = r13
                r10 = r1
                r11 = r0
                if (r10 != r11) goto L_0x000b
                r10 = 1
                r3 = r10
            L_0x0008:
                r10 = r3
                r0 = r10
            L_0x000a:
                return r0
            L_0x000b:
                r10 = r1
                boolean r10 = r10 instanceof com.google.android.gms.internal.zzsz.zzc
                r2 = r10
                r10 = 0
                r3 = r10
                r10 = r2
                if (r10 == 0) goto L_0x0008
                r10 = r1
                com.google.android.gms.internal.zzsz$zzc r10 = (com.google.android.gms.internal.zzsz.zzc) r10
                r4 = r10
                r10 = r0
                byte[] r10 = r10.zzbuO
                r11 = r4
                byte[] r11 = r11.zzbuO
                boolean r10 = java.util.Arrays.equals(r10, r11)
                r5 = r10
                r10 = 0
                r3 = r10
                r10 = r5
                if (r10 == 0) goto L_0x0008
                r10 = r0
                byte[][] r10 = r10.zzbuP
                r11 = r4
                byte[][] r11 = r11.zzbuP
                boolean r10 = com.google.android.gms.internal.zzss.zza(r10, r11)
                r6 = r10
                r10 = 0
                r3 = r10
                r10 = r6
                if (r10 == 0) goto L_0x0008
                r10 = r0
                boolean r10 = r10.zzbuQ
                r7 = r10
                r10 = r4
                boolean r10 = r10.zzbuQ
                r8 = r10
                r10 = 0
                r3 = r10
                r10 = r7
                r11 = r8
                if (r10 != r11) goto L_0x0008
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                if (r10 == 0) goto L_0x0054
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                boolean r10 = r10.isEmpty()
                if (r10 == 0) goto L_0x0069
            L_0x0054:
                r10 = r4
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                if (r10 == 0) goto L_0x0066
                r10 = r4
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                boolean r10 = r10.isEmpty()
                r9 = r10
                r10 = 0
                r3 = r10
                r10 = r9
                if (r10 == 0) goto L_0x0008
            L_0x0066:
                r10 = 1
                r0 = r10
                goto L_0x000a
            L_0x0069:
                r10 = r0
                com.google.android.gms.internal.zzsq r10 = r10.zzbuj
                r11 = r4
                com.google.android.gms.internal.zzsq r11 = r11.zzbuj
                boolean r10 = r10.equals(r11)
                r0 = r10
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zzc.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + (31 * ((this.zzbuQ ? 1231 : 1237) + (31 * ((31 * ((31 * (527 + getClass().getName().hashCode())) + Arrays.hashCode(this.zzbuO))) + zzss.zza(this.zzbuP)))));
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn zzsn2 = zzsn;
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                zzsn2.zza(1, this.zzbuO);
            }
            if (this.zzbuP != null && this.zzbuP.length > 0) {
                for (int i = 0; i < this.zzbuP.length; i++) {
                    byte[] bArr = this.zzbuP[i];
                    if (bArr != null) {
                        zzsn2.zza(2, bArr);
                    }
                }
            }
            if (this.zzbuQ) {
                zzsn2.zze(3, this.zzbuQ);
            }
            super.writeTo(zzsn2);
        }

        public zzc zzJE() {
            this.zzbuO = zzsx.zzbuD;
            this.zzbuP = zzsx.zzbuC;
            this.zzbuQ = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzU */
        public zzc mergeFrom(zzsm zzsm) throws IOException {
            zzsm zzsm2 = zzsm;
            while (true) {
                int zzIX = zzsm2.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.zzbuO = zzsm2.readBytes();
                        continue;
                    case 18:
                        int zzc = zzsx.zzc(zzsm2, 18);
                        int length = this.zzbuP == null ? 0 : this.zzbuP.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.zzbuP, 0, bArr, 0, length);
                        }
                        while (length < -1 + bArr.length) {
                            bArr[length] = zzsm2.readBytes();
                            int zzIX2 = zzsm2.zzIX();
                            length++;
                        }
                        bArr[length] = zzsm2.readBytes();
                        this.zzbuP = bArr;
                        continue;
                    case 24:
                        this.zzbuQ = zzsm2.zzJc();
                        continue;
                    default:
                        if (!zza(zzsm2, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                zzz += zzsn.zzb(1, this.zzbuO);
            }
            if (this.zzbuP != null && this.zzbuP.length > 0) {
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < this.zzbuP.length; i3++) {
                    byte[] bArr = this.zzbuP[i3];
                    if (bArr != null) {
                        i2++;
                        i += zzsn.zzG(bArr);
                    }
                }
                zzz = zzz + i + (i2 * 1);
            }
            if (this.zzbuQ) {
                zzz += zzsn.zzf(3, this.zzbuQ);
            }
            return zzz;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public String tag;
        public long zzbuR;
        public long zzbuS;
        public long zzbuT;
        public int zzbuU;
        public boolean zzbuV;
        public zze[] zzbuW;
        public zzb zzbuX;
        public byte[] zzbuY;
        public byte[] zzbuZ;
        public byte[] zzbva;
        public zza zzbvb;
        public String zzbvc;
        public long zzbvd;
        public zzc zzbve;
        public byte[] zzbvf;
        public int zzbvg;
        public int[] zzbvh;
        public long zzbvi;
        public int zzob;

        public zzd() {
            zzd zzJF = zzJF();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x009d, code lost:
            if (r6.tag == null) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x013d, code lost:
            if (r6.zzbuX == null) goto L_0x013f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x01b3, code lost:
            if (r6.zzbvb == null) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01cf, code lost:
            if (r6.zzbvc == null) goto L_0x01d1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0207, code lost:
            if (r6.zzbve == null) goto L_0x0209;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x02b9, code lost:
            if (r6.zzbuj.isEmpty() != false) goto L_0x02bb;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r37) {
            /*
                r36 = this;
                r2 = r36
                r3 = r37
                r32 = r3
                r33 = r2
                r0 = r32
                r1 = r33
                if (r0 != r1) goto L_0x0017
                r32 = 1
                r5 = r32
            L_0x0012:
                r32 = r5
                r2 = r32
            L_0x0016:
                return r2
            L_0x0017:
                r32 = r3
                r0 = r32
                boolean r0 = r0 instanceof com.google.android.gms.internal.zzsz.zzd
                r32 = r0
                r4 = r32
                r32 = 0
                r5 = r32
                r32 = r4
                if (r32 == 0) goto L_0x0012
                r32 = r3
                com.google.android.gms.internal.zzsz$zzd r32 = (com.google.android.gms.internal.zzsz.zzd) r32
                r6 = r32
                r32 = r2
                r0 = r32
                long r0 = r0.zzbuR
                r32 = r0
                r34 = r6
                r0 = r34
                long r0 = r0.zzbuR
                r34 = r0
                int r32 = (r32 > r34 ? 1 : (r32 == r34 ? 0 : -1))
                r7 = r32
                r32 = 0
                r5 = r32
                r32 = r7
                if (r32 != 0) goto L_0x0012
                r32 = r2
                r0 = r32
                long r0 = r0.zzbuS
                r32 = r0
                r34 = r6
                r0 = r34
                long r0 = r0.zzbuS
                r34 = r0
                int r32 = (r32 > r34 ? 1 : (r32 == r34 ? 0 : -1))
                r8 = r32
                r32 = 0
                r5 = r32
                r32 = r8
                if (r32 != 0) goto L_0x0012
                r32 = r2
                r0 = r32
                long r0 = r0.zzbuT
                r32 = r0
                r34 = r6
                r0 = r34
                long r0 = r0.zzbuT
                r34 = r0
                int r32 = (r32 > r34 ? 1 : (r32 == r34 ? 0 : -1))
                r9 = r32
                r32 = 0
                r5 = r32
                r32 = r9
                if (r32 != 0) goto L_0x0012
                r32 = r2
                r0 = r32
                java.lang.String r0 = r0.tag
                r32 = r0
                if (r32 != 0) goto L_0x02c1
                r32 = r6
                r0 = r32
                java.lang.String r0 = r0.tag
                r32 = r0
                r31 = r32
                r32 = 0
                r5 = r32
                r32 = r31
                if (r32 != 0) goto L_0x0012
            L_0x009f:
                r32 = r2
                r0 = r32
                int r0 = r0.zzbuU
                r32 = r0
                r10 = r32
                r32 = r6
                r0 = r32
                int r0 = r0.zzbuU
                r32 = r0
                r11 = r32
                r32 = 0
                r5 = r32
                r32 = r10
                r33 = r11
                r0 = r32
                r1 = r33
                if (r0 != r1) goto L_0x0012
                r32 = r2
                r0 = r32
                int r0 = r0.zzob
                r32 = r0
                r12 = r32
                r32 = r6
                r0 = r32
                int r0 = r0.zzob
                r32 = r0
                r13 = r32
                r32 = 0
                r5 = r32
                r32 = r12
                r33 = r13
                r0 = r32
                r1 = r33
                if (r0 != r1) goto L_0x0012
                r32 = r2
                r0 = r32
                boolean r0 = r0.zzbuV
                r32 = r0
                r14 = r32
                r32 = r6
                r0 = r32
                boolean r0 = r0.zzbuV
                r32 = r0
                r15 = r32
                r32 = 0
                r5 = r32
                r32 = r14
                r33 = r15
                r0 = r32
                r1 = r33
                if (r0 != r1) goto L_0x0012
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsz$zze[] r0 = r0.zzbuW
                r32 = r0
                r33 = r6
                r0 = r33
                com.google.android.gms.internal.zzsz$zze[] r0 = r0.zzbuW
                r33 = r0
                boolean r32 = com.google.android.gms.internal.zzss.equals(r32, r33)
                r16 = r32
                r32 = 0
                r5 = r32
                r32 = r16
                if (r32 == 0) goto L_0x0012
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsz$zzb r0 = r0.zzbuX
                r32 = r0
                if (r32 != 0) goto L_0x02dd
                r32 = r6
                r0 = r32
                com.google.android.gms.internal.zzsz$zzb r0 = r0.zzbuX
                r32 = r0
                r30 = r32
                r32 = 0
                r5 = r32
                r32 = r30
                if (r32 != 0) goto L_0x0012
            L_0x013f:
                r32 = r2
                r0 = r32
                byte[] r0 = r0.zzbuY
                r32 = r0
                r33 = r6
                r0 = r33
                byte[] r0 = r0.zzbuY
                r33 = r0
                boolean r32 = java.util.Arrays.equals(r32, r33)
                r17 = r32
                r32 = 0
                r5 = r32
                r32 = r17
                if (r32 == 0) goto L_0x0012
                r32 = r2
                r0 = r32
                byte[] r0 = r0.zzbuZ
                r32 = r0
                r33 = r6
                r0 = r33
                byte[] r0 = r0.zzbuZ
                r33 = r0
                boolean r32 = java.util.Arrays.equals(r32, r33)
                r18 = r32
                r32 = 0
                r5 = r32
                r32 = r18
                if (r32 == 0) goto L_0x0012
                r32 = r2
                r0 = r32
                byte[] r0 = r0.zzbva
                r32 = r0
                r33 = r6
                r0 = r33
                byte[] r0 = r0.zzbva
                r33 = r0
                boolean r32 = java.util.Arrays.equals(r32, r33)
                r19 = r32
                r32 = 0
                r5 = r32
                r32 = r19
                if (r32 == 0) goto L_0x0012
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsz$zza r0 = r0.zzbvb
                r32 = r0
                if (r32 != 0) goto L_0x02f9
                r32 = r6
                r0 = r32
                com.google.android.gms.internal.zzsz$zza r0 = r0.zzbvb
                r32 = r0
                r29 = r32
                r32 = 0
                r5 = r32
                r32 = r29
                if (r32 != 0) goto L_0x0012
            L_0x01b5:
                r32 = r2
                r0 = r32
                java.lang.String r0 = r0.zzbvc
                r32 = r0
                if (r32 != 0) goto L_0x0315
                r32 = r6
                r0 = r32
                java.lang.String r0 = r0.zzbvc
                r32 = r0
                r28 = r32
                r32 = 0
                r5 = r32
                r32 = r28
                if (r32 != 0) goto L_0x0012
            L_0x01d1:
                r32 = r2
                r0 = r32
                long r0 = r0.zzbvd
                r32 = r0
                r34 = r6
                r0 = r34
                long r0 = r0.zzbvd
                r34 = r0
                int r32 = (r32 > r34 ? 1 : (r32 == r34 ? 0 : -1))
                r20 = r32
                r32 = 0
                r5 = r32
                r32 = r20
                if (r32 != 0) goto L_0x0012
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsz$zzc r0 = r0.zzbve
                r32 = r0
                if (r32 != 0) goto L_0x0331
                r32 = r6
                r0 = r32
                com.google.android.gms.internal.zzsz$zzc r0 = r0.zzbve
                r32 = r0
                r27 = r32
                r32 = 0
                r5 = r32
                r32 = r27
                if (r32 != 0) goto L_0x0012
            L_0x0209:
                r32 = r2
                r0 = r32
                byte[] r0 = r0.zzbvf
                r32 = r0
                r33 = r6
                r0 = r33
                byte[] r0 = r0.zzbvf
                r33 = r0
                boolean r32 = java.util.Arrays.equals(r32, r33)
                r21 = r32
                r32 = 0
                r5 = r32
                r32 = r21
                if (r32 == 0) goto L_0x0012
                r32 = r2
                r0 = r32
                int r0 = r0.zzbvg
                r32 = r0
                r22 = r32
                r32 = r6
                r0 = r32
                int r0 = r0.zzbvg
                r32 = r0
                r23 = r32
                r32 = 0
                r5 = r32
                r32 = r22
                r33 = r23
                r0 = r32
                r1 = r33
                if (r0 != r1) goto L_0x0012
                r32 = r2
                r0 = r32
                int[] r0 = r0.zzbvh
                r32 = r0
                r33 = r6
                r0 = r33
                int[] r0 = r0.zzbvh
                r33 = r0
                boolean r32 = com.google.android.gms.internal.zzss.equals(r32, r33)
                r24 = r32
                r32 = 0
                r5 = r32
                r32 = r24
                if (r32 == 0) goto L_0x0012
                r32 = r2
                r0 = r32
                long r0 = r0.zzbvi
                r32 = r0
                r34 = r6
                r0 = r34
                long r0 = r0.zzbvi
                r34 = r0
                int r32 = (r32 > r34 ? 1 : (r32 == r34 ? 0 : -1))
                r25 = r32
                r32 = 0
                r5 = r32
                r32 = r25
                if (r32 != 0) goto L_0x0012
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsq r0 = r0.zzbuj
                r32 = r0
                if (r32 == 0) goto L_0x029b
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsq r0 = r0.zzbuj
                r32 = r0
                boolean r32 = r32.isEmpty()
                if (r32 == 0) goto L_0x034d
            L_0x029b:
                r32 = r6
                r0 = r32
                com.google.android.gms.internal.zzsq r0 = r0.zzbuj
                r32 = r0
                if (r32 == 0) goto L_0x02bb
                r32 = r6
                r0 = r32
                com.google.android.gms.internal.zzsq r0 = r0.zzbuj
                r32 = r0
                boolean r32 = r32.isEmpty()
                r26 = r32
                r32 = 0
                r5 = r32
                r32 = r26
                if (r32 == 0) goto L_0x0012
            L_0x02bb:
                r32 = 1
                r2 = r32
                goto L_0x0016
            L_0x02c1:
                r32 = r2
                r0 = r32
                java.lang.String r0 = r0.tag
                r32 = r0
                r33 = r6
                r0 = r33
                java.lang.String r0 = r0.tag
                r33 = r0
                boolean r32 = r32.equals(r33)
                if (r32 != 0) goto L_0x009f
                r32 = 0
                r2 = r32
                goto L_0x0016
            L_0x02dd:
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsz$zzb r0 = r0.zzbuX
                r32 = r0
                r33 = r6
                r0 = r33
                com.google.android.gms.internal.zzsz$zzb r0 = r0.zzbuX
                r33 = r0
                boolean r32 = r32.equals(r33)
                if (r32 != 0) goto L_0x013f
                r32 = 0
                r2 = r32
                goto L_0x0016
            L_0x02f9:
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsz$zza r0 = r0.zzbvb
                r32 = r0
                r33 = r6
                r0 = r33
                com.google.android.gms.internal.zzsz$zza r0 = r0.zzbvb
                r33 = r0
                boolean r32 = r32.equals(r33)
                if (r32 != 0) goto L_0x01b5
                r32 = 0
                r2 = r32
                goto L_0x0016
            L_0x0315:
                r32 = r2
                r0 = r32
                java.lang.String r0 = r0.zzbvc
                r32 = r0
                r33 = r6
                r0 = r33
                java.lang.String r0 = r0.zzbvc
                r33 = r0
                boolean r32 = r32.equals(r33)
                if (r32 != 0) goto L_0x01d1
                r32 = 0
                r2 = r32
                goto L_0x0016
            L_0x0331:
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsz$zzc r0 = r0.zzbve
                r32 = r0
                r33 = r6
                r0 = r33
                com.google.android.gms.internal.zzsz$zzc r0 = r0.zzbve
                r33 = r0
                boolean r32 = r32.equals(r33)
                if (r32 != 0) goto L_0x0209
                r32 = 0
                r2 = r32
                goto L_0x0016
            L_0x034d:
                r32 = r2
                r0 = r32
                com.google.android.gms.internal.zzsq r0 = r0.zzbuj
                r32 = r0
                r33 = r6
                r0 = r33
                com.google.android.gms.internal.zzsq r0 = r0.zzbuj
                r33 = r0
                boolean r32 = r32.equals(r33)
                r2 = r32
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zzd.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = 31 * ((31 * ((31 * ((31 * ((31 * ((this.zzbve == null ? 0 : this.zzbve.hashCode()) + (31 * ((31 * ((this.zzbvc == null ? 0 : this.zzbvc.hashCode()) + (31 * ((this.zzbvb == null ? 0 : this.zzbvb.hashCode()) + (31 * ((31 * ((31 * ((31 * ((this.zzbuX == null ? 0 : this.zzbuX.hashCode()) + (31 * ((31 * ((this.zzbuV ? 1231 : 1237) + (31 * ((31 * ((31 * ((this.tag == null ? 0 : this.tag.hashCode()) + (31 * ((31 * ((31 * ((31 * (527 + getClass().getName().hashCode())) + ((int) (this.zzbuR ^ (this.zzbuR >>> 32))))) + ((int) (this.zzbuS ^ (this.zzbuS >>> 32))))) + ((int) (this.zzbuT ^ (this.zzbuT >>> 32))))))) + this.zzbuU)) + this.zzob)))) + zzss.hashCode((Object[]) this.zzbuW))))) + Arrays.hashCode(this.zzbuY))) + Arrays.hashCode(this.zzbuZ))) + Arrays.hashCode(this.zzbva))))))) + ((int) (this.zzbvd ^ (this.zzbvd >>> 32))))))) + Arrays.hashCode(this.zzbvf))) + this.zzbvg)) + zzss.hashCode(this.zzbvh))) + ((int) (this.zzbvi ^ (this.zzbvi >>> 32))));
            int i = 0;
            if (this.zzbuj != null) {
                i = 0;
                if (!this.zzbuj.isEmpty()) {
                    i = this.zzbuj.hashCode();
                }
            }
            return hashCode + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn zzsn2 = zzsn;
            if (this.zzbuR != 0) {
                zzsn2.zzb(1, this.zzbuR);
            }
            if (!this.tag.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzsn2.zzn(2, this.tag);
            }
            if (this.zzbuW != null && this.zzbuW.length > 0) {
                for (int i = 0; i < this.zzbuW.length; i++) {
                    zze zze = this.zzbuW[i];
                    if (zze != null) {
                        zzsn2.zza(3, (zzsu) zze);
                    }
                }
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                zzsn2.zza(6, this.zzbuY);
            }
            if (this.zzbvb != null) {
                zzsn2.zza(7, (zzsu) this.zzbvb);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                zzsn2.zza(8, this.zzbuZ);
            }
            if (this.zzbuX != null) {
                zzsn2.zza(9, (zzsu) this.zzbuX);
            }
            if (this.zzbuV) {
                zzsn2.zze(10, this.zzbuV);
            }
            if (this.zzbuU != 0) {
                zzsn2.zzA(11, this.zzbuU);
            }
            if (this.zzob != 0) {
                zzsn2.zzA(12, this.zzob);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                zzsn2.zza(13, this.zzbva);
            }
            if (!this.zzbvc.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzsn2.zzn(14, this.zzbvc);
            }
            if (this.zzbvd != 180000) {
                zzsn2.zzc(15, this.zzbvd);
            }
            if (this.zzbve != null) {
                zzsn2.zza(16, (zzsu) this.zzbve);
            }
            if (this.zzbuS != 0) {
                zzsn2.zzb(17, this.zzbuS);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                zzsn2.zza(18, this.zzbvf);
            }
            if (this.zzbvg != 0) {
                zzsn2.zzA(19, this.zzbvg);
            }
            if (this.zzbvh != null) {
                if (this.zzbvh.length > 0) {
                    for (int i2 = 0; i2 < this.zzbvh.length; i2++) {
                        zzsn2.zzA(20, this.zzbvh[i2]);
                    }
                }
            }
            if (this.zzbuT != 0) {
                zzsn2.zzb(21, this.zzbuT);
            }
            if (this.zzbvi != 0) {
                zzsn2.zzb(22, this.zzbvi);
            }
            super.writeTo(zzsn2);
        }

        public zzd zzJF() {
            this.zzbuR = 0;
            this.zzbuS = 0;
            this.zzbuT = 0;
            this.tag = LibrariesRepository.MOJANG_MAVEN_REPO;
            this.zzbuU = 0;
            this.zzob = 0;
            this.zzbuV = false;
            this.zzbuW = zze.zzJG();
            this.zzbuX = null;
            this.zzbuY = zzsx.zzbuD;
            this.zzbuZ = zzsx.zzbuD;
            this.zzbva = zzsx.zzbuD;
            this.zzbvb = null;
            this.zzbvc = LibrariesRepository.MOJANG_MAVEN_REPO;
            this.zzbvd = 180000;
            this.zzbve = null;
            this.zzbvf = zzsx.zzbuD;
            this.zzbvg = 0;
            this.zzbvh = zzsx.zzbuw;
            this.zzbvi = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzV */
        public zzd mergeFrom(zzsm zzsm) throws IOException {
            int length;
            int length2;
            zzc zzc;
            zzb zzb;
            zza zza;
            int length3;
            zze zze;
            zze zze2;
            zzsm zzsm2 = zzsm;
            while (true) {
                int zzIX = zzsm2.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbuR = zzsm2.zzJa();
                        continue;
                    case 18:
                        this.tag = zzsm2.readString();
                        continue;
                    case 26:
                        int zzc2 = zzsx.zzc(zzsm2, 26);
                        if (this.zzbuW == null) {
                            length3 = 0;
                        } else {
                            length3 = this.zzbuW.length;
                        }
                        zze[] zzeArr = new zze[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbuW, 0, zzeArr, 0, length3);
                        }
                        while (length3 < -1 + zzeArr.length) {
                            zze[] zzeArr2 = zzeArr;
                            int i = length3;
                            zze zze3 = zze2;
                            zze zze4 = new zze();
                            zzeArr2[i] = zze3;
                            zzsm2.zza(zzeArr[length3]);
                            int zzIX2 = zzsm2.zzIX();
                            length3++;
                        }
                        zze[] zzeArr3 = zzeArr;
                        int i2 = length3;
                        zze zze5 = zze;
                        zze zze6 = new zze();
                        zzeArr3[i2] = zze5;
                        zzsm2.zza(zzeArr[length3]);
                        this.zzbuW = zzeArr;
                        continue;
                    case 50:
                        this.zzbuY = zzsm2.readBytes();
                        continue;
                    case 58:
                        if (this.zzbvb == null) {
                            zza zza2 = zza;
                            zza zza3 = new zza();
                            this.zzbvb = zza2;
                        }
                        zzsm2.zza(this.zzbvb);
                        continue;
                    case 66:
                        this.zzbuZ = zzsm2.readBytes();
                        continue;
                    case 74:
                        if (this.zzbuX == null) {
                            zzb zzb2 = zzb;
                            zzb zzb3 = new zzb();
                            this.zzbuX = zzb2;
                        }
                        zzsm2.zza(this.zzbuX);
                        continue;
                    case 80:
                        this.zzbuV = zzsm2.zzJc();
                        continue;
                    case 88:
                        this.zzbuU = zzsm2.zzJb();
                        continue;
                    case 96:
                        this.zzob = zzsm2.zzJb();
                        continue;
                    case 106:
                        this.zzbva = zzsm2.readBytes();
                        continue;
                    case 114:
                        this.zzbvc = zzsm2.readString();
                        continue;
                    case 120:
                        this.zzbvd = zzsm2.zzJe();
                        continue;
                    case 130:
                        if (this.zzbve == null) {
                            zzc zzc3 = zzc;
                            zzc zzc4 = new zzc();
                            this.zzbve = zzc3;
                        }
                        zzsm2.zza(this.zzbve);
                        continue;
                    case 136:
                        this.zzbuS = zzsm2.zzJa();
                        continue;
                    case 146:
                        this.zzbvf = zzsm2.readBytes();
                        continue;
                    case 152:
                        int zzJb = zzsm2.zzJb();
                        switch (zzJb) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzbvg = zzJb;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        int zzc5 = zzsx.zzc(zzsm2, 160);
                        if (this.zzbvh == null) {
                            length2 = 0;
                        } else {
                            length2 = this.zzbvh.length;
                        }
                        int[] iArr = new int[(zzc5 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbvh, 0, iArr, 0, length2);
                        }
                        while (length2 < -1 + iArr.length) {
                            iArr[length2] = zzsm2.zzJb();
                            int zzIX3 = zzsm2.zzIX();
                            length2++;
                        }
                        iArr[length2] = zzsm2.zzJb();
                        this.zzbvh = iArr;
                        continue;
                    case 162:
                        int zzmq = zzsm2.zzmq(zzsm2.zzJf());
                        int position = zzsm2.getPosition();
                        int i3 = 0;
                        while (zzsm2.zzJk() > 0) {
                            int zzJb2 = zzsm2.zzJb();
                            i3++;
                        }
                        zzsm2.zzms(position);
                        if (this.zzbvh == null) {
                            length = 0;
                        } else {
                            length = this.zzbvh.length;
                        }
                        int[] iArr2 = new int[(i3 + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbvh, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length) {
                            iArr2[length] = zzsm2.zzJb();
                            length++;
                        }
                        this.zzbvh = iArr2;
                        zzsm2.zzmr(zzmq);
                        continue;
                    case 168:
                        this.zzbuT = zzsm2.zzJa();
                        continue;
                    case 176:
                        this.zzbvi = zzsm2.zzJa();
                        continue;
                    default:
                        if (!zza(zzsm2, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (this.zzbuR != 0) {
                zzz += zzsn.zzd(1, this.zzbuR);
            }
            if (!this.tag.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzz += zzsn.zzo(2, this.tag);
            }
            if (this.zzbuW != null && this.zzbuW.length > 0) {
                int i = zzz;
                for (int i2 = 0; i2 < this.zzbuW.length; i2++) {
                    zze zze = this.zzbuW[i2];
                    if (zze != null) {
                        i += zzsn.zzc(3, (zzsu) zze);
                    }
                }
                zzz = i;
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                zzz += zzsn.zzb(6, this.zzbuY);
            }
            if (this.zzbvb != null) {
                zzz += zzsn.zzc(7, (zzsu) this.zzbvb);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                zzz += zzsn.zzb(8, this.zzbuZ);
            }
            if (this.zzbuX != null) {
                zzz += zzsn.zzc(9, (zzsu) this.zzbuX);
            }
            if (this.zzbuV) {
                zzz += zzsn.zzf(10, this.zzbuV);
            }
            if (this.zzbuU != 0) {
                zzz += zzsn.zzC(11, this.zzbuU);
            }
            if (this.zzob != 0) {
                zzz += zzsn.zzC(12, this.zzob);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                zzz += zzsn.zzb(13, this.zzbva);
            }
            if (!this.zzbvc.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzz += zzsn.zzo(14, this.zzbvc);
            }
            if (this.zzbvd != 180000) {
                zzz += zzsn.zze(15, this.zzbvd);
            }
            if (this.zzbve != null) {
                zzz += zzsn.zzc(16, (zzsu) this.zzbve);
            }
            if (this.zzbuS != 0) {
                zzz += zzsn.zzd(17, this.zzbuS);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                zzz += zzsn.zzb(18, this.zzbvf);
            }
            if (this.zzbvg != 0) {
                zzz += zzsn.zzC(19, this.zzbvg);
            }
            if (this.zzbvh != null && this.zzbvh.length > 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < this.zzbvh.length; i4++) {
                    i3 += zzsn.zzmx(this.zzbvh[i4]);
                }
                zzz = zzz + i3 + (2 * this.zzbvh.length);
            }
            if (this.zzbuT != 0) {
                zzz += zzsn.zzd(21, this.zzbuT);
            }
            if (this.zzbvi != 0) {
                zzz += zzsn.zzd(22, this.zzbvi);
            }
            return zzz;
        }
    }

    public static final class zze extends zzso<zze> {
        private static volatile zze[] zzbvj;
        public String key;
        public String value;

        public zze() {
            zze zzJH = zzJH();
        }

        public static zze[] zzJG() {
            if (zzbvj == null) {
                Object obj = zzss.zzbut;
                synchronized (obj) {
                    try {
                        if (zzbvj == null) {
                            zzbvj = new zze[0];
                        }
                    } catch (Throwable th) {
                        while (true) {
                            Throwable th2 = th;
                            Object obj2 = obj;
                            throw th2;
                        }
                    }
                }
            }
            return zzbvj;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
            if (r4.value == null) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            if (r4.zzbuj.isEmpty() != false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (r4.key == null) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r11) {
            /*
                r10 = this;
                r0 = r10
                r1 = r11
                r8 = r1
                r9 = r0
                if (r8 != r9) goto L_0x000b
                r8 = 1
                r3 = r8
            L_0x0008:
                r8 = r3
                r0 = r8
            L_0x000a:
                return r0
            L_0x000b:
                r8 = r1
                boolean r8 = r8 instanceof com.google.android.gms.internal.zzsz.zze
                r2 = r8
                r8 = 0
                r3 = r8
                r8 = r2
                if (r8 == 0) goto L_0x0008
                r8 = r1
                com.google.android.gms.internal.zzsz$zze r8 = (com.google.android.gms.internal.zzsz.zze) r8
                r4 = r8
                r8 = r0
                java.lang.String r8 = r8.key
                if (r8 != 0) goto L_0x0057
                r8 = r4
                java.lang.String r8 = r8.key
                r7 = r8
                r8 = 0
                r3 = r8
                r8 = r7
                if (r8 != 0) goto L_0x0008
            L_0x0026:
                r8 = r0
                java.lang.String r8 = r8.value
                if (r8 != 0) goto L_0x0066
                r8 = r4
                java.lang.String r8 = r8.value
                r6 = r8
                r8 = 0
                r3 = r8
                r8 = r6
                if (r8 != 0) goto L_0x0008
            L_0x0034:
                r8 = r0
                com.google.android.gms.internal.zzsq r8 = r8.zzbuj
                if (r8 == 0) goto L_0x0042
                r8 = r0
                com.google.android.gms.internal.zzsq r8 = r8.zzbuj
                boolean r8 = r8.isEmpty()
                if (r8 == 0) goto L_0x0075
            L_0x0042:
                r8 = r4
                com.google.android.gms.internal.zzsq r8 = r8.zzbuj
                if (r8 == 0) goto L_0x0054
                r8 = r4
                com.google.android.gms.internal.zzsq r8 = r8.zzbuj
                boolean r8 = r8.isEmpty()
                r5 = r8
                r8 = 0
                r3 = r8
                r8 = r5
                if (r8 == 0) goto L_0x0008
            L_0x0054:
                r8 = 1
                r0 = r8
                goto L_0x000a
            L_0x0057:
                r8 = r0
                java.lang.String r8 = r8.key
                r9 = r4
                java.lang.String r9 = r9.key
                boolean r8 = r8.equals(r9)
                if (r8 != 0) goto L_0x0026
                r8 = 0
                r0 = r8
                goto L_0x000a
            L_0x0066:
                r8 = r0
                java.lang.String r8 = r8.value
                r9 = r4
                java.lang.String r9 = r9.value
                boolean r8 = r8.equals(r9)
                if (r8 != 0) goto L_0x0034
                r8 = 0
                r0 = r8
                goto L_0x000a
            L_0x0075:
                r8 = r0
                com.google.android.gms.internal.zzsq r8 = r8.zzbuj
                r9 = r4
                com.google.android.gms.internal.zzsq r9 = r9.zzbuj
                boolean r8 = r8.equals(r9)
                r0 = r8
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zze.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int hashCode = 31 * ((this.value == null ? 0 : this.value.hashCode()) + (31 * ((this.key == null ? 0 : this.key.hashCode()) + (31 * (527 + getClass().getName().hashCode())))));
            int i = 0;
            if (this.zzbuj != null) {
                i = 0;
                if (!this.zzbuj.isEmpty()) {
                    i = this.zzbuj.hashCode();
                }
            }
            return hashCode + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn zzsn2 = zzsn;
            if (!this.key.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzsn2.zzn(1, this.key);
            }
            if (!this.value.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzsn2.zzn(2, this.value);
            }
            super.writeTo(zzsn2);
        }

        public zze zzJH() {
            this.key = LibrariesRepository.MOJANG_MAVEN_REPO;
            this.value = LibrariesRepository.MOJANG_MAVEN_REPO;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzW */
        public zze mergeFrom(zzsm zzsm) throws IOException {
            zzsm zzsm2 = zzsm;
            while (true) {
                int zzIX = zzsm2.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzsm2.readString();
                        continue;
                    case 18:
                        this.value = zzsm2.readString();
                        continue;
                    default:
                        if (!zza(zzsm2, zzIX)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!this.key.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzz += zzsn.zzo(1, this.key);
            }
            if (!this.value.equals(LibrariesRepository.MOJANG_MAVEN_REPO)) {
                zzz += zzsn.zzo(2, this.value);
            }
            return zzz;
        }
    }
}
