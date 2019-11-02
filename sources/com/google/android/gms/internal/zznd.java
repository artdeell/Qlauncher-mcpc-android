package com.google.android.gms.internal;

public class zznd {
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r17v12 */
    /* JADX WARNING: type inference failed for: r17v16, types: [int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0101, code lost:
        r9 = r9 | ((255 & r2[r6 + 1]) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0119, code lost:
        r10 = -862048943 * (r9 | (255 & r2[r6]));
        r11 = r7 ^ (461845907 * ((r10 << 15) | (r10 >>> 17)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x00b6, code lost:
        r12 = r11 ^ r4;
        r13 = -2048144789 * (r12 ^ (r12 >>> 16));
        r14 = -1028477387 * (r13 ^ (r13 >>> 13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x00ec, code lost:
        return r14 ^ (r14 >>> 16);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(byte[] r23, int r24, int r25, int r26) {
        /*
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r17 = r3
            r18 = r4
            r19 = -4
            r18 = r18 & -4
            int r17 = r17 + r18
            r6 = r17
            r17 = r5
            r7 = r17
        L_0x0018:
            r17 = r3
            r18 = r6
            r0 = r17
            r1 = r18
            if (r0 >= r1) goto L_0x00a1
            r17 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            r18 = 255(0xff, float:3.57E-43)
            r19 = r2
            r20 = r3
            byte r19 = r19[r20]
            r18 = r18 & r19
            r19 = 255(0xff, float:3.57E-43)
            r20 = r2
            r21 = r3
            r22 = 1
            int r21 = r21 + 1
            byte r20 = r20[r21]
            r19 = r19 & r20
            r20 = 8
            int r19 = r19 << 8
            r18 = r18 | r19
            r19 = 255(0xff, float:3.57E-43)
            r20 = r2
            r21 = r3
            r22 = 2
            int r21 = r21 + 2
            byte r20 = r20[r21]
            r19 = r19 & r20
            r20 = 16
            int r19 = r19 << 16
            r18 = r18 | r19
            r19 = r2
            r20 = r3
            r21 = 3
            int r20 = r20 + 3
            byte r19 = r19[r20]
            r20 = 24
            int r19 = r19 << 24
            r18 = r18 | r19
            int r17 = r17 * r18
            r15 = r17
            r17 = r7
            r18 = 461845907(0x1b873593, float:2.2368498E-22)
            r19 = r15
            r20 = 15
            int r19 = r19 << 15
            r20 = r15
            r21 = 17
            int r20 = r20 >>> 17
            r19 = r19 | r20
            int r18 = r18 * r19
            r17 = r17 ^ r18
            r16 = r17
            r17 = -430675100(0xffffffffe6546b64, float:-2.5078068E23)
            r18 = 5
            r19 = r16
            r20 = 13
            int r19 = r19 << 13
            r20 = r16
            r21 = 19
            int r20 = r20 >>> 19
            r19 = r19 | r20
            int r18 = r18 * r19
            int r17 = r17 + r18
            r7 = r17
            int r3 = r3 + 4
            goto L_0x0018
        L_0x00a1:
            r17 = r4
            r18 = 3
            r17 = r17 & 3
            r8 = r17
            r17 = 0
            r9 = r17
            r17 = r8
            switch(r17) {
                case 1: goto L_0x0119;
                case 2: goto L_0x0101;
                case 3: goto L_0x00ed;
                default: goto L_0x00b2;
            }
        L_0x00b2:
            r17 = r7
            r11 = r17
        L_0x00b6:
            r17 = r11
            r18 = r4
            r17 = r17 ^ r18
            r12 = r17
            r17 = -2048144789(0xffffffff85ebca6b, float:-2.217365E-35)
            r18 = r12
            r19 = r12
            r20 = 16
            int r19 = r19 >>> 16
            r18 = r18 ^ r19
            int r17 = r17 * r18
            r13 = r17
            r17 = -1028477387(0xffffffffc2b2ae35, float:-89.34025)
            r18 = r13
            r19 = r13
            r20 = 13
            int r19 = r19 >>> 13
            r18 = r18 ^ r19
            int r17 = r17 * r18
            r14 = r17
            r17 = r14
            r18 = r14
            r19 = 16
            int r18 = r18 >>> 16
            r17 = r17 ^ r18
            r2 = r17
            return r2
        L_0x00ed:
            r17 = 255(0xff, float:3.57E-43)
            r18 = r2
            r19 = r6
            r20 = 2
            int r19 = r19 + 2
            byte r18 = r18[r19]
            r17 = r17 & r18
            r18 = 16
            int r17 = r17 << 16
            r9 = r17
        L_0x0101:
            r17 = r9
            r18 = 255(0xff, float:3.57E-43)
            r19 = r2
            r20 = r6
            r21 = 1
            int r20 = r20 + 1
            byte r19 = r19[r20]
            r18 = r18 & r19
            r19 = 8
            int r18 = r18 << 8
            r17 = r17 | r18
            r9 = r17
        L_0x0119:
            r17 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            r18 = r9
            r19 = 255(0xff, float:3.57E-43)
            r20 = r2
            r21 = r6
            byte r20 = r20[r21]
            r19 = r19 & r20
            r18 = r18 | r19
            int r17 = r17 * r18
            r10 = r17
            r17 = r7
            r18 = 461845907(0x1b873593, float:2.2368498E-22)
            r19 = r10
            r20 = 15
            int r19 = r19 << 15
            r20 = r10
            r21 = 17
            int r20 = r20 >>> 17
            r19 = r19 | r20
            int r18 = r18 * r19
            r17 = r17 ^ r18
            r11 = r17
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznd.zza(byte[], int, int, int):int");
    }
}
