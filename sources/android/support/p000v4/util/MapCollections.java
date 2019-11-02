package android.support.p000v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.util.MapCollections */
abstract class MapCollections<K, V> {
    EntrySet mEntrySet;
    KeySet mKeySet;
    ValuesCollection mValues;

    /* renamed from: android.support.v4.util.MapCollections$ArrayIterator */
    final class ArrayIterator<T> implements Iterator<T> {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;
        final /* synthetic */ MapCollections this$0;

        ArrayIterator(MapCollections mapCollections, int i) {
            MapCollections mapCollections2 = mapCollections;
            int i2 = i;
            this.this$0 = mapCollections2;
            this.mOffset = i2;
            this.mSize = mapCollections2.colGetSize();
        }

        public boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        public T next() {
            Object colGetEntry = this.this$0.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex = 1 + this.mIndex;
            this.mCanRemove = true;
            return colGetEntry;
        }

        public void remove() {
            IllegalStateException illegalStateException;
            if (!this.mCanRemove) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException();
                throw illegalStateException2;
            }
            this.mIndex = -1 + this.mIndex;
            this.mSize = -1 + this.mSize;
            this.mCanRemove = false;
            this.this$0.colRemoveAt(this.mIndex);
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$EntrySet */
    final class EntrySet implements Set<Entry<K, V>> {
        final /* synthetic */ MapCollections this$0;

        EntrySet(MapCollections mapCollections) {
            this.this$0 = mapCollections;
        }

        public boolean add(Entry<K, V> entry) {
            UnsupportedOperationException unsupportedOperationException;
            Entry<K, V> entry2 = entry;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            Collection<? extends Entry<K, V>> collection2 = collection;
            int colGetSize = this.this$0.colGetSize();
            for (Entry entry : collection2) {
                this.this$0.colPut(entry.getKey(), entry.getValue());
            }
            return colGetSize != this.this$0.colGetSize();
        }

        public void clear() {
            this.this$0.colClear();
        }

        public boolean contains(Object obj) {
            Object obj2 = obj;
            if (obj2 instanceof Entry) {
                Entry entry = (Entry) obj2;
                int colIndexOfKey = this.this$0.colIndexOfKey(entry.getKey());
                if (colIndexOfKey >= 0) {
                    return ContainerHelpers.equal(this.this$0.colGetEntry(colIndexOfKey, 1), entry.getValue());
                }
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int colGetSize = -1 + this.this$0.colGetSize(); colGetSize >= 0; colGetSize--) {
                Object colGetEntry = this.this$0.colGetEntry(colGetSize, 0);
                Object colGetEntry2 = this.this$0.colGetEntry(colGetSize, 1);
                i += (colGetEntry2 == null ? 0 : colGetEntry2.hashCode()) ^ (colGetEntry == null ? 0 : colGetEntry.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return this.this$0.colGetSize() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            MapIterator mapIterator;
            MapIterator mapIterator2 = mapIterator;
            MapIterator mapIterator3 = new MapIterator(this.this$0);
            return mapIterator2;
        }

        public boolean remove(Object obj) {
            UnsupportedOperationException unsupportedOperationException;
            Object obj2 = obj;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public boolean removeAll(Collection<?> collection) {
            UnsupportedOperationException unsupportedOperationException;
            Collection<?> collection2 = collection;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public boolean retainAll(Collection<?> collection) {
            UnsupportedOperationException unsupportedOperationException;
            Collection<?> collection2 = collection;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public int size() {
            return this.this$0.colGetSize();
        }

        public Object[] toArray() {
            UnsupportedOperationException unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public <T> T[] toArray(T[] tArr) {
            UnsupportedOperationException unsupportedOperationException;
            T[] tArr2 = tArr;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$KeySet */
    final class KeySet implements Set<K> {
        final /* synthetic */ MapCollections this$0;

        KeySet(MapCollections mapCollections) {
            this.this$0 = mapCollections;
        }

        public boolean add(K k) {
            UnsupportedOperationException unsupportedOperationException;
            K k2 = k;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public boolean addAll(Collection<? extends K> collection) {
            UnsupportedOperationException unsupportedOperationException;
            Collection<? extends K> collection2 = collection;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public void clear() {
            this.this$0.colClear();
        }

        public boolean contains(Object obj) {
            return this.this$0.colIndexOfKey(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return MapCollections.containsAllHelper(this.this$0.colGetMap(), collection);
        }

        public boolean equals(Object obj) {
            return MapCollections.equalsSetHelper(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int colGetSize = -1 + this.this$0.colGetSize(); colGetSize >= 0; colGetSize--) {
                Object colGetEntry = this.this$0.colGetEntry(colGetSize, 0);
                i += colGetEntry == null ? 0 : colGetEntry.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return this.this$0.colGetSize() == 0;
        }

        public Iterator<K> iterator() {
            ArrayIterator arrayIterator;
            ArrayIterator arrayIterator2 = arrayIterator;
            ArrayIterator arrayIterator3 = new ArrayIterator(this.this$0, 0);
            return arrayIterator2;
        }

        public boolean remove(Object obj) {
            int colIndexOfKey = this.this$0.colIndexOfKey(obj);
            if (colIndexOfKey < 0) {
                return false;
            }
            this.this$0.colRemoveAt(colIndexOfKey);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return MapCollections.removeAllHelper(this.this$0.colGetMap(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return MapCollections.retainAllHelper(this.this$0.colGetMap(), collection);
        }

        public int size() {
            return this.this$0.colGetSize();
        }

        public Object[] toArray() {
            return this.this$0.toArrayHelper(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.this$0.toArrayHelper(tArr, 0);
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$MapIterator */
    final class MapIterator implements Iterator<Entry<K, V>>, Entry<K, V> {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex;
        final /* synthetic */ MapCollections this$0;

        MapIterator(MapCollections mapCollections) {
            MapCollections mapCollections2 = mapCollections;
            this.this$0 = mapCollections2;
            this.mEnd = -1 + mapCollections2.colGetSize();
            this.mIndex = -1;
        }

        public final boolean equals(Object obj) {
            IllegalStateException illegalStateException;
            Object obj2 = obj;
            boolean z = true;
            if (!this.mEntryValid) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("This container does not support retaining Map.Entry objects");
                throw illegalStateException2;
            } else if (!(obj2 instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj2;
                if (!ContainerHelpers.equal(entry.getKey(), this.this$0.colGetEntry(this.mIndex, 0)) || !ContainerHelpers.equal(entry.getValue(), this.this$0.colGetEntry(this.mIndex, 1))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            IllegalStateException illegalStateException;
            if (this.mEntryValid) {
                return this.this$0.colGetEntry(this.mIndex, 0);
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException2;
        }

        public V getValue() {
            IllegalStateException illegalStateException;
            if (this.mEntryValid) {
                return this.this$0.colGetEntry(this.mIndex, 1);
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException2;
        }

        public boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        public final int hashCode() {
            IllegalStateException illegalStateException;
            if (!this.mEntryValid) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("This container does not support retaining Map.Entry objects");
                throw illegalStateException2;
            }
            Object colGetEntry = this.this$0.colGetEntry(this.mIndex, 0);
            Object colGetEntry2 = this.this$0.colGetEntry(this.mIndex, 1);
            int hashCode = colGetEntry == null ? 0 : colGetEntry.hashCode();
            int i = 0;
            if (colGetEntry2 != null) {
                i = colGetEntry2.hashCode();
            }
            return i ^ hashCode;
        }

        public Entry<K, V> next() {
            this.mIndex = 1 + this.mIndex;
            this.mEntryValid = true;
            return this;
        }

        public void remove() {
            IllegalStateException illegalStateException;
            if (!this.mEntryValid) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException();
                throw illegalStateException2;
            }
            this.this$0.colRemoveAt(this.mIndex);
            this.mIndex = -1 + this.mIndex;
            this.mEnd = -1 + this.mEnd;
            this.mEntryValid = false;
        }

        public V setValue(V v) {
            IllegalStateException illegalStateException;
            V v2 = v;
            if (this.mEntryValid) {
                return this.this$0.colSetValue(this.mIndex, v2);
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("This container does not support retaining Map.Entry objects");
            throw illegalStateException2;
        }

        public final String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append(getKey()).append("=").append(getValue()).toString();
        }
    }

    /* renamed from: android.support.v4.util.MapCollections$ValuesCollection */
    final class ValuesCollection implements Collection<V> {
        final /* synthetic */ MapCollections this$0;

        ValuesCollection(MapCollections mapCollections) {
            this.this$0 = mapCollections;
        }

        public boolean add(V v) {
            UnsupportedOperationException unsupportedOperationException;
            V v2 = v;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public boolean addAll(Collection<? extends V> collection) {
            UnsupportedOperationException unsupportedOperationException;
            Collection<? extends V> collection2 = collection;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public void clear() {
            this.this$0.colClear();
        }

        public boolean contains(Object obj) {
            return this.this$0.colIndexOfValue(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.this$0.colGetSize() == 0;
        }

        public Iterator<V> iterator() {
            ArrayIterator arrayIterator;
            ArrayIterator arrayIterator2 = arrayIterator;
            ArrayIterator arrayIterator3 = new ArrayIterator(this.this$0, 1);
            return arrayIterator2;
        }

        public boolean remove(Object obj) {
            int colIndexOfValue = this.this$0.colIndexOfValue(obj);
            if (colIndexOfValue < 0) {
                return false;
            }
            this.this$0.colRemoveAt(colIndexOfValue);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            Collection<?> collection2 = collection;
            int colGetSize = this.this$0.colGetSize();
            boolean z = false;
            int i = 0;
            while (i < colGetSize) {
                if (collection2.contains(this.this$0.colGetEntry(i, 1))) {
                    this.this$0.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            Collection<?> collection2 = collection;
            int colGetSize = this.this$0.colGetSize();
            boolean z = false;
            int i = 0;
            while (i < colGetSize) {
                if (!collection2.contains(this.this$0.colGetEntry(i, 1))) {
                    this.this$0.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.this$0.colGetSize();
        }

        public Object[] toArray() {
            return this.this$0.toArrayHelper(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.this$0.toArrayHelper(tArr, 1);
        }
    }

    MapCollections() {
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        Map<K, V> map2 = map;
        for (Object containsKey : collection) {
            if (!map2.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        boolean z;
        Set<T> set2 = set;
        Object obj2 = obj;
        boolean z2 = true;
        if (set2 == obj2) {
            z = true;
        } else {
            z = false;
            if (obj2 instanceof Set) {
                Set set3 = (Set) obj2;
                try {
                    if (set2.size() != set3.size() || !set2.containsAll(set3)) {
                        z2 = false;
                    }
                    return z2;
                } catch (NullPointerException e) {
                    NullPointerException nullPointerException = e;
                    return false;
                } catch (ClassCastException e2) {
                    ClassCastException classCastException = e2;
                    return false;
                }
            }
        }
        return z;
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        Map<K, V> map2 = map;
        Collection<?> collection2 = collection;
        int size = map2.size();
        for (Object remove : collection2) {
            Object remove2 = map2.remove(remove);
        }
        return size != map2.size();
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        Map<K, V> map2 = map;
        Collection<?> collection2 = collection;
        int size = map2.size();
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            if (!collection2.contains(it.next())) {
                it.remove();
            }
        }
        return size != map2.size();
    }

    /* access modifiers changed from: protected */
    public abstract void colClear();

    /* access modifiers changed from: protected */
    public abstract Object colGetEntry(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> colGetMap();

    /* access modifiers changed from: protected */
    public abstract int colGetSize();

    /* access modifiers changed from: protected */
    public abstract int colIndexOfKey(Object obj);

    /* access modifiers changed from: protected */
    public abstract int colIndexOfValue(Object obj);

    /* access modifiers changed from: protected */
    public abstract void colPut(K k, V v);

    /* access modifiers changed from: protected */
    public abstract void colRemoveAt(int i);

    /* access modifiers changed from: protected */
    public abstract V colSetValue(int i, V v);

    public Set<Entry<K, V>> getEntrySet() {
        EntrySet entrySet;
        if (this.mEntrySet == null) {
            EntrySet entrySet2 = entrySet;
            EntrySet entrySet3 = new EntrySet<>(this);
            this.mEntrySet = entrySet2;
        }
        return this.mEntrySet;
    }

    public Set<K> getKeySet() {
        KeySet keySet;
        if (this.mKeySet == null) {
            KeySet keySet2 = keySet;
            KeySet keySet3 = new KeySet<>(this);
            this.mKeySet = keySet2;
        }
        return this.mKeySet;
    }

    public Collection<V> getValues() {
        ValuesCollection valuesCollection;
        if (this.mValues == null) {
            ValuesCollection valuesCollection2 = valuesCollection;
            ValuesCollection valuesCollection3 = new ValuesCollection<>(this);
            this.mValues = valuesCollection2;
        }
        return this.mValues;
    }

    public Object[] toArrayHelper(int i) {
        int i2 = i;
        int colGetSize = colGetSize();
        Object[] objArr = new Object[colGetSize];
        for (int i3 = 0; i3 < colGetSize; i3++) {
            objArr[i3] = colGetEntry(i3, i2);
        }
        return objArr;
    }

    public <T> T[] toArrayHelper(T[] tArr, int i) {
        T[] tArr2 = tArr;
        int i2 = i;
        int colGetSize = colGetSize();
        if (tArr2.length < colGetSize) {
            tArr2 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), colGetSize);
        }
        for (int i3 = 0; i3 < colGetSize; i3++) {
            tArr2[i3] = colGetEntry(i3, i2);
        }
        if (tArr2.length > colGetSize) {
            tArr2[colGetSize] = null;
        }
        return tArr2;
    }
}
