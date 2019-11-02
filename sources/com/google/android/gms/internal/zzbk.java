package com.google.android.gms.internal;

import java.util.PriorityQueue;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zzbk {

    public static class zza {
        final long value;
        final String zztx;
        final int zzty;

        zza(long j, String str, int i) {
            String str2 = str;
            int i2 = i;
            this.value = j;
            this.zztx = str2;
            this.zzty = i2;
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            if (obj2 == null || !(obj2 instanceof zza)) {
                return false;
            }
            return ((zza) obj2).value == this.value && ((zza) obj2).zzty == this.zzty;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    static long zza(int i, int i2, long j, long j2, long j3) {
        return (((j3 * (((j + 1073807359) - ((j2 * ((2147483647L + ((long) i)) % 1073807359)) % 1073807359)) % 1073807359)) % 1073807359) + ((2147483647L + ((long) i2)) % 1073807359)) % 1073807359;
    }

    static long zza(long j, int i) {
        long j2 = j;
        int i2 = i;
        if (i2 == 0) {
            j2 = 1;
        } else if (i2 != 1) {
            return i2 % 2 == 0 ? zza((j2 * j2) % 1073807359, i2 / 2) % 1073807359 : (j2 * (zza((j2 * j2) % 1073807359, i2 / 2) % 1073807359)) % 1073807359;
        }
        return j2;
    }

    static String zza(String[] strArr, int i, int i2) {
        StringBuffer stringBuffer;
        String[] strArr2 = strArr;
        int i3 = i;
        int i4 = i2;
        if (strArr2.length < i3 + i4) {
            zzin.m19e("Unable to construct shingle");
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        for (int i5 = i3; i5 < -1 + i3 + i4; i5++) {
            StringBuffer append = stringBuffer4.append(strArr2[i5]);
            StringBuffer append2 = stringBuffer4.append(' ');
        }
        StringBuffer append3 = stringBuffer4.append(strArr2[-1 + i3 + i4]);
        return stringBuffer4.toString();
    }

    static void zza(int i, long j, String str, int i2, PriorityQueue<zza> priorityQueue) {
        zza zza2;
        int i3 = i;
        PriorityQueue<zza> priorityQueue2 = priorityQueue;
        zza zza3 = zza2;
        zza zza4 = new zza(j, str, i2);
        zza zza5 = zza3;
        if ((priorityQueue2.size() != i3 || ((zza) priorityQueue2.peek()).value <= zza5.value) && !priorityQueue2.contains(zza5)) {
            boolean add = priorityQueue2.add(zza5);
            if (priorityQueue2.size() > i3) {
                Object poll = priorityQueue2.poll();
            }
        }
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zza> priorityQueue) {
        String[] strArr2 = strArr;
        int i3 = i;
        int i4 = i2;
        PriorityQueue<zza> priorityQueue2 = priorityQueue;
        if (strArr2.length < i4) {
            zza(i3, zzb(strArr2, 0, strArr2.length), zza(strArr2, 0, strArr2.length), strArr2.length, priorityQueue2);
            return;
        }
        long zzb = zzb(strArr2, 0, i4);
        zza(i3, zzb, zza(strArr2, 0, i4), i4, priorityQueue2);
        long zza2 = zza(16785407, i4 - 1);
        int i5 = 1;
        while (i5 < 1 + (strArr2.length - i4)) {
            long zza3 = zza(zzbi.zzx(strArr2[i5 - 1]), zzbi.zzx(strArr2[-1 + i5 + i4]), zzb, zza2, 16785407);
            zza(i3, zza3, zza(strArr2, i5, i4), strArr2.length, priorityQueue2);
            i5++;
            zzb = zza3;
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        String[] strArr2 = strArr;
        int i3 = i;
        long zzx = (2147483647L + ((long) zzbi.zzx(strArr2[i3]))) % 1073807359;
        for (int i4 = i3 + 1; i4 < i3 + i2; i4++) {
            zzx = (((zzx * 16785407) % 1073807359) + ((2147483647L + ((long) zzbi.zzx(strArr2[i4]))) % 1073807359)) % 1073807359;
        }
        return zzx;
    }
}
