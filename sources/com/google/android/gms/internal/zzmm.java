package com.google.android.gms.internal;

import android.support.p000v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zzmm<E> extends AbstractSet<E> {
    private final ArrayMap<E, E> zzanZ;

    public zzmm() {
        ArrayMap<E, E> arrayMap;
        ArrayMap<E, E> arrayMap2 = arrayMap;
        ArrayMap<E, E> arrayMap3 = new ArrayMap<>();
        this.zzanZ = arrayMap2;
    }

    public zzmm(int i) {
        ArrayMap<E, E> arrayMap;
        ArrayMap<E, E> arrayMap2 = arrayMap;
        ArrayMap<E, E> arrayMap3 = new ArrayMap<>(i);
        this.zzanZ = arrayMap2;
    }

    public zzmm(Collection<E> collection) {
        Collection<E> collection2 = collection;
        this(collection2.size());
        boolean addAll = addAll(collection2);
    }

    public boolean add(E e) {
        E e2 = e;
        if (this.zzanZ.containsKey(e2)) {
            return false;
        }
        Object put = this.zzanZ.put(e2, e2);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        Collection<? extends E> collection2 = collection;
        return collection2 instanceof zzmm ? zza((zzmm) collection2) : super.addAll(collection2);
    }

    public void clear() {
        this.zzanZ.clear();
    }

    public boolean contains(Object obj) {
        return this.zzanZ.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.zzanZ.keySet().iterator();
    }

    public boolean remove(Object obj) {
        Object obj2 = obj;
        if (!this.zzanZ.containsKey(obj2)) {
            return false;
        }
        Object remove = this.zzanZ.remove(obj2);
        return true;
    }

    public int size() {
        return this.zzanZ.size();
    }

    public boolean zza(zzmm<? extends E> zzmm) {
        zzmm<? extends E> zzmm2 = zzmm;
        int size = size();
        this.zzanZ.putAll(zzmm2.zzanZ);
        return size() > size;
    }
}
