package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

@zzhb
public class zzbh {
    private final int zztp = 6;
    private final int zztq;
    private final int zztr = 0;
    private final zzbg zzts;

    static class zza {
        ByteArrayOutputStream zztu;
        Base64OutputStream zztv;

        public zza() {
            ByteArrayOutputStream byteArrayOutputStream;
            Base64OutputStream base64OutputStream;
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(4096);
            this.zztu = byteArrayOutputStream2;
            Base64OutputStream base64OutputStream2 = base64OutputStream;
            Base64OutputStream base64OutputStream3 = new Base64OutputStream(this.zztu, 10);
            this.zztv = base64OutputStream2;
        }

        public String toString() {
            try {
                this.zztv.close();
            } catch (IOException e) {
                zzin.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zztu.close();
                String byteArrayOutputStream = this.zztu.toString();
                this.zztu = null;
                this.zztv = null;
                return byteArrayOutputStream;
            } catch (IOException e2) {
                zzin.zzb("HashManager: Unable to convert to Base64.", e2);
                this.zztu = null;
                this.zztv = null;
                return LibrariesRepository.MOJANG_MAVEN_REPO;
            } catch (Throwable th) {
                Throwable th2 = th;
                this.zztu = null;
                this.zztv = null;
                throw th2;
            }
        }

        public void write(byte[] bArr) throws IOException {
            byte[] bArr2 = bArr;
            this.zztv.write(bArr2);
        }
    }

    public zzbh(int i) {
        zzbj zzbj;
        int i2 = i;
        zzbj zzbj2 = zzbj;
        zzbj zzbj3 = new zzbj();
        this.zzts = zzbj2;
        this.zztq = i2;
    }

    private String zzv(String str) {
        C02721 r10;
        String[] split = str.split("\n");
        if (split.length == 0) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        zza zzcM = zzcM();
        String[] strArr = split;
        C02721 r7 = r10;
        C02721 r8 = new Comparator<String>(this) {
            final /* synthetic */ zzbh zztt;

            {
                this.zztt = r5;
            }

            public int compare(String str, String str2) {
                return str2.length() - str.length();
            }
        };
        Arrays.sort(strArr, r7);
        int i = 0;
        while (i < split.length && i < this.zztq) {
            if (split[i].trim().length() != 0) {
                try {
                    zzcM.write(this.zzts.zzu(split[i]));
                } catch (IOException e) {
                    zzin.zzb("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return zzcM.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer;
        ArrayList<String> arrayList2 = arrayList;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            StringBuffer append = stringBuffer4.append(((String) it.next()).toLowerCase(Locale.US));
            StringBuffer append2 = stringBuffer4.append(10);
        }
        switch (this.zztr) {
            case 0:
                return zzw(stringBuffer4.toString());
            case 1:
                return zzv(stringBuffer4.toString());
            default:
                return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
    }

    /* access modifiers changed from: 0000 */
    public zza zzcM() {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza();
        return zza3;
    }

    /* access modifiers changed from: 0000 */
    public String zzw(String str) {
        PriorityQueue priorityQueue;
        C02732 r16;
        String[] split = str.split("\n");
        if (split.length == 0) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        zza zzcM = zzcM();
        PriorityQueue priorityQueue2 = priorityQueue;
        int i = this.zztq;
        C02732 r13 = r16;
        C02732 r14 = new Comparator<com.google.android.gms.internal.zzbk.zza>(this) {
            final /* synthetic */ zzbh zztt;

            {
                this.zztt = r5;
            }

            /* renamed from: zza */
            public int compare(com.google.android.gms.internal.zzbk.zza zza, com.google.android.gms.internal.zzbk.zza zza2) {
                com.google.android.gms.internal.zzbk.zza zza3 = zza;
                com.google.android.gms.internal.zzbk.zza zza4 = zza2;
                int i = zza3.zzty - zza4.zzty;
                return i != 0 ? i : (int) (zza3.value - zza4.value);
            }
        };
        PriorityQueue priorityQueue3 = new PriorityQueue(i, r13);
        PriorityQueue priorityQueue4 = priorityQueue2;
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] zzy = zzbi.zzy(split[i2]);
            if (zzy.length != 0) {
                zzbk.zza(zzy, this.zztq, this.zztp, priorityQueue4);
            }
        }
        Iterator it = priorityQueue4.iterator();
        while (it.hasNext()) {
            try {
                zzcM.write(this.zzts.zzu(((com.google.android.gms.internal.zzbk.zza) it.next()).zztx));
            } catch (IOException e) {
                zzin.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzcM.toString();
    }
}
