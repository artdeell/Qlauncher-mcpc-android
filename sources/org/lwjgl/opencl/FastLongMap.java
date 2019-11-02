package org.lwjgl.opencl;

import java.util.Iterator;

final class FastLongMap<V> implements Iterable<Entry<V>> {
    private int capacity;
    private int mask;
    private int size;
    /* access modifiers changed from: private */
    public Entry[] table;
    private int threshold;

    static final class Entry<T> {
        final long key;
        Entry<T> next;
        T value;

        Entry(long j, T t, Entry<T> entry) {
            T t2 = t;
            Entry<T> entry2 = entry;
            this.key = j;
            this.value = t2;
            this.next = entry2;
        }

        public long getKey() {
            return this.key;
        }

        public T getValue() {
            return this.value;
        }
    }

    public class EntryIterator implements Iterator<Entry<V>> {
        private Entry<V> current;
        private int nextIndex;
        final /* synthetic */ FastLongMap this$0;

        EntryIterator(FastLongMap fastLongMap) {
            this.this$0 = fastLongMap;
            reset();
        }

        public boolean hasNext() {
            if (this.nextIndex < 0) {
                Entry<V> entry = this.current;
                if (entry == null || entry.next == null) {
                    return false;
                }
            }
            return true;
        }

        public Entry<V> next() {
            Entry<V> entry = this.current;
            if (entry != null) {
                Entry<T> entry2 = entry.next;
                if (entry2 != null) {
                    this.current = entry2;
                    return entry2;
                }
            }
            Entry[] access$000 = this.this$0.table;
            int i = this.nextIndex;
            Entry entry3 = access$000[i];
            this.current = entry3;
            do {
                i--;
                if (i < 0) {
                    break;
                }
            } while (access$000[i] == null);
            this.nextIndex = i;
            return entry3;
        }

        public void remove() {
            Object remove = this.this$0.remove(this.current.key);
        }

        public void reset() {
            this.current = null;
            Entry[] access$000 = this.this$0.table;
            int length = -1 + access$000.length;
            while (length >= 0 && access$000[length] == null) {
                length--;
            }
            this.nextIndex = length;
        }
    }

    FastLongMap() {
        this(16, 0.75f);
    }

    FastLongMap(int i) {
        this(i, 0.75f);
    }

    FastLongMap(int i, float f) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        int i2 = i;
        float f2 = f;
        if (i2 > 1073741824) {
            IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("initialCapacity is too large.");
            throw illegalArgumentException4;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("initialCapacity must be greater than zero.");
            throw illegalArgumentException6;
        } else if (f2 <= 0.0f) {
            IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("initialCapacity must be greater than zero.");
            throw illegalArgumentException8;
        } else {
            this.capacity = 1;
            while (this.capacity < i2) {
                this.capacity <<= 1;
            }
            this.threshold = (int) (f2 * ((float) this.capacity));
            this.table = new Entry[this.capacity];
            this.mask = -1 + this.capacity;
        }
    }

    private int index(long j) {
        return index(j, this.mask);
    }

    private static int index(long j, int i) {
        long j2 = j;
        return i & ((int) (j2 ^ (j2 >>> 32)));
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=org.lwjgl.opencl.FastLongMap$Entry<V>[], code=org.lwjgl.opencl.FastLongMap$Entry[], for r13v0, types: [org.lwjgl.opencl.FastLongMap$Entry[], org.lwjgl.opencl.FastLongMap$Entry<V>[]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void rehash(org.lwjgl.opencl.FastLongMap.Entry[] r13) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r9 = 2
            r10 = r0
            int r10 = r10.capacity
            int r9 = r9 * r10
            r2 = r9
            r9 = r2
            r10 = 1
            int r9 = r9 + -1
            r3 = r9
            r9 = r2
            org.lwjgl.opencl.FastLongMap$Entry[] r9 = new org.lwjgl.opencl.FastLongMap.Entry[r9]
            r4 = r9
            r9 = 0
            r5 = r9
        L_0x0013:
            r9 = r5
            r10 = r1
            int r10 = r10.length
            if (r9 >= r10) goto L_0x0042
            r9 = r1
            r10 = r5
            r9 = r9[r10]
            r6 = r9
            r9 = r6
            if (r9 != 0) goto L_0x0023
        L_0x0020:
            int r5 = r5 + 1
            goto L_0x0013
        L_0x0023:
            r9 = r6
            org.lwjgl.opencl.FastLongMap$Entry<T> r9 = r9.next
            r7 = r9
            r9 = r6
            long r9 = r9.key
            r11 = r3
            int r9 = index(r9, r11)
            r8 = r9
            r9 = r6
            r10 = r4
            r11 = r8
            r10 = r10[r11]
            r9.next = r10
            r9 = r4
            r10 = r8
            r11 = r6
            r9[r10] = r11
            r9 = r7
            r6 = r9
            r9 = r6
            if (r9 != 0) goto L_0x0023
            goto L_0x0020
        L_0x0042:
            r9 = r0
            r10 = r4
            r9.table = r10
            r9 = r0
            r10 = r2
            r9.capacity = r10
            r9 = r0
            r10 = r3
            r9.mask = r10
            r9 = r0
            r10 = 2
            r11 = r0
            int r11 = r11.threshold
            int r10 = r10 * r11
            r9.threshold = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.FastLongMap.rehash(org.lwjgl.opencl.FastLongMap$Entry[]):void");
    }

    public void clear() {
        Entry[] entryArr = this.table;
        for (int length = -1 + entryArr.length; length >= 0; length--) {
            entryArr[length] = null;
        }
        this.size = 0;
    }

    public boolean containsKey(long j) {
        long j2 = j;
        Entry<T> entry = this.table[index(j2)];
        while (true) {
            Entry entry2 = entry;
            if (entry2 == null) {
                return false;
            }
            if (entry2.key == j2) {
                return true;
            }
            entry = entry2.next;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r3 = r3 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsValue(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r5 = r0
            org.lwjgl.opencl.FastLongMap$Entry[] r5 = r5.table
            r2 = r5
            r5 = -1
            r6 = r2
            int r6 = r6.length
            int r5 = r5 + r6
            r3 = r5
        L_0x000b:
            r5 = r3
            if (r5 < 0) goto L_0x002b
            r5 = r2
            r6 = r3
            r5 = r5[r6]
            r4 = r5
        L_0x0013:
            r5 = r4
            if (r5 == 0) goto L_0x0028
            r5 = r4
            T r5 = r5.value
            r6 = r1
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0023
            r5 = 1
            r0 = r5
        L_0x0022:
            return r0
        L_0x0023:
            r5 = r4
            org.lwjgl.opencl.FastLongMap$Entry<T> r5 = r5.next
            r4 = r5
            goto L_0x0013
        L_0x0028:
            int r3 = r3 + -1
            goto L_0x000b
        L_0x002b:
            r5 = 0
            r0 = r5
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.FastLongMap.containsValue(java.lang.Object):boolean");
    }

    public V get(long j) {
        long j2 = j;
        Entry<T> entry = this.table[index(j2)];
        while (true) {
            Entry entry2 = entry;
            if (entry2 == null) {
                return null;
            }
            if (entry2.key == j2) {
                return entry2.value;
            }
            entry = entry2.next;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public EntryIterator iterator() {
        EntryIterator entryIterator;
        EntryIterator entryIterator2 = entryIterator;
        EntryIterator entryIterator3 = new EntryIterator(this);
        return entryIterator2;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=V, code=java.lang.Object, for r22v0, types: [V, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V put(long r20, java.lang.Object r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r22
            r9 = r0
            org.lwjgl.opencl.FastLongMap$Entry[] r9 = r9.table
            r4 = r9
            r9 = r0
            r10 = r1
            int r9 = r9.index(r10)
            r5 = r9
            r9 = r4
            r10 = r5
            r9 = r9[r10]
            r6 = r9
        L_0x0016:
            r9 = r6
            if (r9 == 0) goto L_0x0031
            r9 = r6
            long r9 = r9.key
            r11 = r1
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x0026
            r9 = r6
            org.lwjgl.opencl.FastLongMap$Entry<T> r9 = r9.next
            r6 = r9
            goto L_0x0016
        L_0x0026:
            r9 = r6
            T r9 = r9.value
            r8 = r9
            r9 = r6
            r10 = r3
            r9.value = r10
            r9 = r8
            r0 = r9
        L_0x0030:
            return r0
        L_0x0031:
            r9 = r4
            r10 = r5
            org.lwjgl.opencl.FastLongMap$Entry r11 = new org.lwjgl.opencl.FastLongMap$Entry
            r18 = r11
            r11 = r18
            r12 = r18
            r13 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r16 = r16[r17]
            r12.<init>(r13, r15, r16)
            r9[r10] = r11
            r9 = r0
            int r9 = r9.size
            r7 = r9
            r9 = r0
            r10 = r7
            r11 = 1
            int r10 = r10 + 1
            r9.size = r10
            r9 = r7
            r10 = r0
            int r10 = r10.threshold
            if (r9 < r10) goto L_0x005e
            r9 = r0
            r10 = r4
            r9.rehash(r10)
        L_0x005e:
            r9 = 0
            r0 = r9
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opencl.FastLongMap.put(long, java.lang.Object):java.lang.Object");
    }

    public V remove(long j) {
        long j2 = j;
        int index = index(j2);
        Entry entry = this.table[index];
        Entry entry2 = entry;
        while (true) {
            Entry entry3 = entry2;
            if (entry3 == null) {
                return null;
            }
            Entry entry4 = entry3.next;
            if (entry3.key == j2) {
                this.size = -1 + this.size;
                if (entry == entry3) {
                    this.table[index] = entry4;
                } else {
                    entry.next = entry4;
                }
                return entry3.value;
            }
            entry = entry3;
            entry2 = entry4;
        }
    }

    public int size() {
        return this.size;
    }
}
