package org.lwjgl.opengl;

import java.util.Iterator;

final class FastIntMap<V> implements Iterable<Entry<V>> {
    private int capacity;
    private int mask;
    private int size;
    /* access modifiers changed from: private */
    public Entry[] table;
    private int threshold;

    static final class Entry<T> {
        final int key;
        Entry<T> next;
        T value;

        Entry(int i, T t, Entry<T> entry) {
            T t2 = t;
            Entry<T> entry2 = entry;
            this.key = i;
            this.value = t2;
            this.next = entry2;
        }

        public int getKey() {
            return this.key;
        }

        public T getValue() {
            return this.value;
        }
    }

    public class EntryIterator implements Iterator<Entry<V>> {
        private Entry<V> current;
        private int nextIndex;
        final /* synthetic */ FastIntMap this$0;

        EntryIterator(FastIntMap fastIntMap) {
            this.this$0 = fastIntMap;
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

    FastIntMap() {
        this(16, 0.75f);
    }

    FastIntMap(int i) {
        this(i, 0.75f);
    }

    FastIntMap(int i, float f) {
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

    private int index(int i) {
        return index(i, this.mask);
    }

    private static int index(int i, int i2) {
        return i & i2;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=org.lwjgl.opengl.FastIntMap$Entry<V>[], code=org.lwjgl.opengl.FastIntMap$Entry[], for r13v0, types: [org.lwjgl.opengl.FastIntMap$Entry<V>[], org.lwjgl.opengl.FastIntMap$Entry[]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void rehash(org.lwjgl.opengl.FastIntMap.Entry[] r13) {
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
            org.lwjgl.opengl.FastIntMap$Entry[] r9 = new org.lwjgl.opengl.FastIntMap.Entry[r9]
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
            org.lwjgl.opengl.FastIntMap$Entry<T> r9 = r9.next
            r7 = r9
            r9 = r6
            int r9 = r9.key
            r10 = r3
            int r9 = index(r9, r10)
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
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.FastIntMap.rehash(org.lwjgl.opengl.FastIntMap$Entry[]):void");
    }

    public void clear() {
        Entry[] entryArr = this.table;
        for (int length = -1 + entryArr.length; length >= 0; length--) {
            entryArr[length] = null;
        }
        this.size = 0;
    }

    public boolean containsKey(int i) {
        int i2 = i;
        Entry<T> entry = this.table[index(i2)];
        while (true) {
            Entry entry2 = entry;
            if (entry2 == null) {
                return false;
            }
            if (entry2.key == i2) {
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
            org.lwjgl.opengl.FastIntMap$Entry[] r5 = r5.table
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
            org.lwjgl.opengl.FastIntMap$Entry<T> r5 = r5.next
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
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.FastIntMap.containsValue(java.lang.Object):boolean");
    }

    public V get(int i) {
        int i2 = i;
        Entry<T> entry = this.table[index(i2)];
        while (true) {
            Entry entry2 = entry;
            if (entry2 == null) {
                return null;
            }
            if (entry2.key == i2) {
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

    /* JADX WARNING: Incorrect type for immutable var: ssa=V, code=java.lang.Object, for r19v0, types: [V, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V put(int r18, java.lang.Object r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r8 = r0
            org.lwjgl.opengl.FastIntMap$Entry[] r8 = r8.table
            r3 = r8
            r8 = r0
            r9 = r1
            int r8 = r8.index(r9)
            r4 = r8
            r8 = r3
            r9 = r4
            r8 = r8[r9]
            r5 = r8
        L_0x0016:
            r8 = r5
            if (r8 == 0) goto L_0x002f
            r8 = r5
            int r8 = r8.key
            r9 = r1
            if (r8 == r9) goto L_0x0024
            r8 = r5
            org.lwjgl.opengl.FastIntMap$Entry<T> r8 = r8.next
            r5 = r8
            goto L_0x0016
        L_0x0024:
            r8 = r5
            T r8 = r8.value
            r7 = r8
            r8 = r5
            r9 = r2
            r8.value = r9
            r8 = r7
            r0 = r8
        L_0x002e:
            return r0
        L_0x002f:
            r8 = r3
            r9 = r4
            org.lwjgl.opengl.FastIntMap$Entry r10 = new org.lwjgl.opengl.FastIntMap$Entry
            r16 = r10
            r10 = r16
            r11 = r16
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r4
            r14 = r14[r15]
            r11.<init>(r12, r13, r14)
            r8[r9] = r10
            r8 = r0
            int r8 = r8.size
            r6 = r8
            r8 = r0
            r9 = r6
            r10 = 1
            int r9 = r9 + 1
            r8.size = r9
            r8 = r6
            r9 = r0
            int r9 = r9.threshold
            if (r8 < r9) goto L_0x005a
            r8 = r0
            r9 = r3
            r8.rehash(r9)
        L_0x005a:
            r8 = 0
            r0 = r8
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.FastIntMap.put(int, java.lang.Object):java.lang.Object");
    }

    public V remove(int i) {
        int i2 = i;
        int index = index(i2);
        Entry entry = this.table[index];
        Entry entry2 = entry;
        while (true) {
            Entry entry3 = entry2;
            if (entry3 == null) {
                return null;
            }
            Entry entry4 = entry3.next;
            if (entry3.key == i2) {
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
