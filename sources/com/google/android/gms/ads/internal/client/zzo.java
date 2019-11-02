package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzx.zza;
import com.google.android.gms.internal.zzhb;
import java.util.Random;

@zzhb
public class zzo extends zza {
    private Object zzpV;
    private final Random zzuy;
    private long zzuz;

    public zzo() {
        Object obj;
        Random random;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        Random random2 = random;
        Random random3 = new Random();
        this.zzuy = random2;
        zzcY();
    }

    public long getValue() {
        return this.zzuz;
    }

    public void zzcY() {
        Object obj = this.zzpV;
        synchronized (obj) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                try {
                    j = 2147483648L + ((long) this.zzuy.nextInt());
                    if (j != this.zzuz && j != 0) {
                        break;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
            this.zzuz = j;
        }
    }
}
