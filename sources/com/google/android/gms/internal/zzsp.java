package com.google.android.gms.internal;

import com.google.android.gms.internal.zzso;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzsp<M extends zzso<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbuk;
    protected final boolean zzbul;

    private zzsp(int i, Class<T> cls, int i2, boolean z) {
        Class<T> cls2 = cls;
        int i3 = i2;
        boolean z2 = z;
        this.type = i;
        this.zzbuk = cls2;
        this.tag = i3;
        this.zzbul = z2;
    }

    private T zzK(List<zzsw> list) {
        ArrayList arrayList;
        Object cast;
        List<zzsw> list2 = list;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < list2.size(); i++) {
            zzsw zzsw = (zzsw) list2.get(i);
            if (zzsw.zzbuv.length != 0) {
                zza(zzsw, (List<Object>) arrayList4);
            }
        }
        int size = arrayList4.size();
        if (size == 0) {
            cast = null;
        } else {
            cast = this.zzbuk.cast(Array.newInstance(this.zzbuk.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList4.get(i2));
            }
        }
        return cast;
    }

    private T zzL(List<zzsw> list) {
        List<zzsw> list2 = list;
        if (list2.isEmpty()) {
            return null;
        }
        return this.zzbuk.cast(zzP(zzsm.zzD(((zzsw) list2.get(-1 + list2.size())).zzbuv)));
    }

    public static <M extends zzso<M>, T extends zzsu> zzsp<M, T> zza(int i, Class<T> cls, long j) {
        zzsp zzsp;
        zzsp zzsp2 = zzsp;
        zzsp zzsp3 = new zzsp(i, cls, (int) j, false);
        return zzsp2;
    }

    /* access modifiers changed from: 0000 */
    public final T zzJ(List<zzsw> list) {
        List<zzsw> list2 = list;
        if (list2 == null) {
            return null;
        }
        return this.zzbul ? zzK(list2) : zzL(list2);
    }

    /* access modifiers changed from: protected */
    public Object zzP(zzsm zzsm) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException3;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException4;
        StringBuilder sb3;
        zzsm zzsm2 = zzsm;
        Class<T> cls = this.zzbul ? this.zzbuk.getComponentType() : this.zzbuk;
        try {
            switch (this.type) {
                case 10:
                    zzsu zzsu = (zzsu) cls.newInstance();
                    zzsm2.zza(zzsu, zzsx.zzmJ(this.tag));
                    return zzsu;
                case 11:
                    zzsu zzsu2 = (zzsu) cls.newInstance();
                    zzsm2.zza(zzsu2);
                    return zzsu2;
                default:
                    IllegalArgumentException illegalArgumentException5 = illegalArgumentException4;
                    StringBuilder sb4 = sb3;
                    StringBuilder sb5 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb4.append("Unknown type ").append(this.type).toString());
                    throw illegalArgumentException5;
            }
        } catch (InstantiationException e) {
            InstantiationException instantiationException = e;
            IllegalArgumentException illegalArgumentException7 = illegalArgumentException3;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException(sb6.append("Error creating instance of class ").append(cls).toString(), instantiationException);
            throw illegalArgumentException7;
        } catch (IllegalAccessException e2) {
            IllegalAccessException illegalAccessException = e2;
            IllegalArgumentException illegalArgumentException9 = illegalArgumentException2;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException(sb8.append("Error creating instance of class ").append(cls).toString(), illegalAccessException);
            throw illegalArgumentException9;
        } catch (IOException e3) {
            IOException iOException = e3;
            IllegalArgumentException illegalArgumentException11 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException("Error reading extension field", iOException);
            throw illegalArgumentException11;
        }
    }

    /* access modifiers changed from: 0000 */
    public int zzY(Object obj) {
        Object obj2 = obj;
        return this.zzbul ? zzZ(obj2) : zzaa(obj2);
    }

    /* access modifiers changed from: protected */
    public int zzZ(Object obj) {
        Object obj2 = obj;
        int i = 0;
        int length = Array.getLength(obj2);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj2, i2) != null) {
                i += zzaa(Array.get(obj2, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void zza(zzsw zzsw, List<Object> list) {
        boolean add = list.add(zzP(zzsm.zzD(zzsw.zzbuv)));
    }

    /* access modifiers changed from: 0000 */
    public void zza(Object obj, zzsn zzsn) throws IOException {
        Object obj2 = obj;
        zzsn zzsn2 = zzsn;
        if (this.zzbul) {
            zzc(obj2, zzsn2);
        } else {
            zzb(obj2, zzsn2);
        }
    }

    /* access modifiers changed from: protected */
    public int zzaa(Object obj) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Object obj2 = obj;
        int zzmJ = zzsx.zzmJ(this.tag);
        switch (this.type) {
            case 10:
                return zzsn.zzb(zzmJ, (zzsu) obj2);
            case 11:
                return zzsn.zzc(zzmJ, (zzsu) obj2);
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unknown type ").append(this.type).toString());
                throw illegalArgumentException2;
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(Object obj, zzsn zzsn) {
        IllegalStateException illegalStateException;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Object obj2 = obj;
        zzsn zzsn2 = zzsn;
        try {
            zzsn2.zzmB(this.tag);
            switch (this.type) {
                case 10:
                    zzsu zzsu = (zzsu) obj2;
                    int zzmJ = zzsx.zzmJ(this.tag);
                    zzsn2.zzb(zzsu);
                    zzsn2.zzE(zzmJ, 4);
                    return;
                case 11:
                    zzsn2.zzc((zzsu) obj2);
                    return;
                default:
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unknown type ").append(this.type).toString());
                    throw illegalArgumentException2;
            }
        } catch (IOException e) {
            IOException iOException = e;
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(iOException);
            throw illegalStateException2;
        }
        IOException iOException2 = e;
        IllegalStateException illegalStateException22 = illegalStateException;
        IllegalStateException illegalStateException32 = new IllegalStateException(iOException2);
        throw illegalStateException22;
    }

    /* access modifiers changed from: protected */
    public void zzc(Object obj, zzsn zzsn) {
        Object obj2 = obj;
        zzsn zzsn2 = zzsn;
        int length = Array.getLength(obj2);
        for (int i = 0; i < length; i++) {
            Object obj3 = Array.get(obj2, i);
            if (obj3 != null) {
                zzb(obj3, zzsn2);
            }
        }
    }
}
