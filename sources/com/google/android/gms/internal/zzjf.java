package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzhb
public class zzjf {

    public interface zza<D, R> {
        R zzf(D d);
    }

    public static <A, B> zzjg<B> zza(zzjg<A> zzjg, zza<A, B> zza2) {
        zzjd zzjd;
        C04271 r9;
        zzjg<A> zzjg2 = zzjg;
        zza<A, B> zza3 = zza2;
        zzjd zzjd2 = zzjd;
        zzjd zzjd3 = new zzjd();
        zzjd zzjd4 = zzjd2;
        zzjg<A> zzjg3 = zzjg2;
        C04271 r4 = r9;
        final zzjd zzjd5 = zzjd4;
        final zza<A, B> zza4 = zza3;
        final zzjg<A> zzjg4 = zzjg2;
        C04271 r5 = new Runnable() {
            {
                zza zza = r8;
                zzjg zzjg = r9;
            }

            public void run() {
                try {
                    zzjd5.zzg(zza4.zzf(zzjg4.get()));
                    return;
                } catch (CancellationException e) {
                    CancellationException cancellationException = e;
                } catch (InterruptedException e2) {
                    InterruptedException interruptedException = e2;
                } catch (ExecutionException e3) {
                    ExecutionException executionException = e3;
                }
                boolean cancel = zzjd5.cancel(true);
            }
        };
        zzjg3.zzb(r4);
        return zzjd4;
    }

    public static <V> zzjg<List<V>> zzl(List<zzjg<V>> list) {
        zzjd zzjd;
        AtomicInteger atomicInteger;
        C04282 r12;
        List<zzjg<V>> list2 = list;
        zzjd zzjd2 = zzjd;
        zzjd zzjd3 = new zzjd();
        zzjd zzjd4 = zzjd2;
        int size = list2.size();
        AtomicInteger atomicInteger2 = atomicInteger;
        AtomicInteger atomicInteger3 = new AtomicInteger(0);
        AtomicInteger atomicInteger4 = atomicInteger2;
        for (zzjg zzjg : list2) {
            C04282 r6 = r12;
            final AtomicInteger atomicInteger5 = atomicInteger4;
            final int i = size;
            final zzjd zzjd5 = zzjd4;
            final List<zzjg<V>> list3 = list2;
            C04282 r7 = new Runnable() {
                {
                    int i = r9;
                    zzjd zzjd = r10;
                    List list = r11;
                }

                public void run() {
                    Throwable th;
                    if (atomicInteger5.incrementAndGet() >= i) {
                        try {
                            zzjd5.zzg(zzjf.zzm(list3));
                            return;
                        } catch (ExecutionException e) {
                            th = e;
                        } catch (InterruptedException e2) {
                            th = e2;
                        }
                    } else {
                        return;
                    }
                    zzin.zzd("Unable to convert list of futures to a future of list", th);
                }
            };
            zzjg.zzb(r6);
        }
        return zzjd4;
    }

    /* access modifiers changed from: private */
    public static <V> List<V> zzm(List<zzjg<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList;
        List<zzjg<V>> list2 = list;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (zzjg zzjg : list2) {
            Object obj = zzjg.get();
            if (obj != null) {
                boolean add = arrayList4.add(obj);
            }
        }
        return arrayList4;
    }
}
