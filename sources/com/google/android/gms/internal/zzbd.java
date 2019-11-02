package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzhb
public class zzbd {
    private final Object zzpV;
    private int zzsW;
    private List<zzbc> zzsX;

    public zzbd() {
        Object obj;
        LinkedList linkedList;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        this.zzsX = linkedList2;
    }

    public boolean zza(zzbc zzbc) {
        zzbc zzbc2 = zzbc;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                return this.zzsX.contains(zzbc2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public boolean zzb(zzbc zzbc) {
        th = zzbc;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                Iterator it = this.zzsX.iterator();
                while (it.hasNext()) {
                    obj = (zzbc) it.next();
                    if (th != obj && obj.zzcy().equals(th.zzcy())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            } finally {
                Throwable th = th;
                Object obj2 = obj;
                Throwable th2 = th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void zzc(zzbc zzbc) {
        StringBuilder sb;
        zzbc zzbc2 = zzbc;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzsX.size() >= 10) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    zzin.zzaI(sb2.append("Queue is full, current size = ").append(this.zzsX.size()).toString());
                    Object remove = this.zzsX.remove(0);
                }
                int i = this.zzsW;
                this.zzsW = i + 1;
                zzbc2.zzh(i);
                boolean add = this.zzsX.add(zzbc2);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public zzbc zzcF() {
        int i;
        zzbc zzbc;
        zzbc zzbc2 = null;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.zzsX.size() == 0) {
                    zzin.zzaI("Queue empty");
                    return null;
                } else if (this.zzsX.size() >= 2) {
                    int i2 = Integer.MIN_VALUE;
                    for (zzbc zzbc3 : this.zzsX) {
                        int score = zzbc3.getScore();
                        if (score > i2) {
                            zzbc = zzbc3;
                            i = score;
                        } else {
                            i = i2;
                            zzbc = zzbc2;
                        }
                        i2 = i;
                        zzbc2 = zzbc;
                    }
                    boolean remove = this.zzsX.remove(zzbc2);
                    return zzbc2;
                } else {
                    zzbc zzbc4 = (zzbc) this.zzsX.get(0);
                    zzbc4.zzcA();
                    return zzbc4;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }
}
