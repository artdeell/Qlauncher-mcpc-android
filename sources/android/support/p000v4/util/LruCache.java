package android.support.p000v4.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: android.support.v4.util.LruCache */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i) {
        LinkedHashMap<K, V> linkedHashMap;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("maxSize <= 0");
            throw illegalArgumentException2;
        }
        this.maxSize = i2;
        LinkedHashMap<K, V> linkedHashMap2 = linkedHashMap;
        LinkedHashMap<K, V> linkedHashMap3 = new LinkedHashMap<>(0, 0.75f, true);
        this.map = linkedHashMap2;
    }

    private int safeSizeOf(K k, V v) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        K k2 = k;
        V v2 = v;
        int sizeOf = sizeOf(k2, v2);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Negative size: ").append(k2).append("=").append(v2).toString());
        throw illegalStateException2;
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        K k2 = k;
        return null;
    }

    public final int createCount() {
        int i;
        synchronized (this) {
            try {
                th = this.createCount;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i;
        synchronized (this) {
            try {
                th = this.evictionCount;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r4 = create(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r4 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.createCount = 1 + r0.createCount;
        r6 = r0.map.put(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r6 == null) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005f, code lost:
        r7 = r0.map.put(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0069, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r6 == null) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006d, code lost:
        entryRemoved(false, r1, r4, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0.size += safeSizeOf(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0087, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0088, code lost:
        r5 = r7;
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008d, code lost:
        trimToSize(r0.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r14) {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r7 = r1
            if (r7 != 0) goto L_0x0010
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            r12 = r7
            r7 = r12
            r8 = r12
            java.lang.String r9 = "key == null"
            r8.<init>(r9)
            throw r7
        L_0x0010:
            r7 = r0
            monitor-enter(r7)
            r7 = r0
            java.util.LinkedHashMap<K, V> r7 = r7.map     // Catch:{ all -> 0x0042 }
            r8 = r1
            java.lang.Object r7 = r7.get(r8)     // Catch:{ all -> 0x0042 }
            r3 = r7
            r7 = r3
            if (r7 == 0) goto L_0x002b
            r7 = r0
            r8 = 1
            r9 = r0
            int r9 = r9.hitCount     // Catch:{ all -> 0x0042 }
            int r8 = r8 + r9
            r7.hitCount = r8     // Catch:{ all -> 0x0042 }
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0042 }
            r7 = r3
            r0 = r7
        L_0x002a:
            return r0
        L_0x002b:
            r7 = r0
            r8 = 1
            r9 = r0
            int r9 = r9.missCount     // Catch:{ all -> 0x0042 }
            int r8 = r8 + r9
            r7.missCount = r8     // Catch:{ all -> 0x0042 }
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0042 }
            r7 = r0
            r8 = r1
            java.lang.Object r7 = r7.create(r8)
            r4 = r7
            r7 = r4
            if (r7 != 0) goto L_0x0048
            r7 = 0
            r0 = r7
            goto L_0x002a
        L_0x0042:
            r7 = move-exception
            r2 = r7
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0042 }
            r7 = r2
            throw r7
        L_0x0048:
            r7 = r0
            monitor-enter(r7)
            r7 = r0
            r8 = 1
            r9 = r0
            int r9 = r9.createCount     // Catch:{ all -> 0x0087 }
            int r8 = r8 + r9
            r7.createCount = r8     // Catch:{ all -> 0x0087 }
            r7 = r0
            java.util.LinkedHashMap<K, V> r7 = r7.map     // Catch:{ all -> 0x0087 }
            r8 = r1
            r9 = r4
            java.lang.Object r7 = r7.put(r8, r9)     // Catch:{ all -> 0x0087 }
            r6 = r7
            r7 = r6
            if (r7 == 0) goto L_0x0078
            r7 = r0
            java.util.LinkedHashMap<K, V> r7 = r7.map     // Catch:{ all -> 0x0087 }
            r8 = r1
            r9 = r6
            java.lang.Object r7 = r7.put(r8, r9)     // Catch:{ all -> 0x0087 }
        L_0x0068:
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0087 }
            r7 = r6
            if (r7 == 0) goto L_0x008d
            r7 = r0
            r8 = 0
            r9 = r1
            r10 = r4
            r11 = r6
            r7.entryRemoved(r8, r9, r10, r11)
            r7 = r6
            r0 = r7
            goto L_0x002a
        L_0x0078:
            r7 = r0
            r8 = r0
            int r8 = r8.size     // Catch:{ all -> 0x0087 }
            r9 = r0
            r10 = r1
            r11 = r4
            int r9 = r9.safeSizeOf(r10, r11)     // Catch:{ all -> 0x0087 }
            int r8 = r8 + r9
            r7.size = r8     // Catch:{ all -> 0x0087 }
            goto L_0x0068
        L_0x0087:
            r7 = move-exception
            r5 = r7
            r7 = r0
            monitor-exit(r7)     // Catch:{ all -> 0x0087 }
            r7 = r5
            throw r7
        L_0x008d:
            r7 = r0
            r8 = r0
            int r8 = r8.maxSize
            r7.trimToSize(r8)
            r7 = r4
            r0 = r7
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.util.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final int hitCount() {
        int i;
        synchronized (this) {
            try {
                th = this.hitCount;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this) {
            try {
                th = this.maxSize;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this) {
            try {
                th = this.missCount;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    /* JADX INFO: finally extract failed */
    public final V put(K k, V v) {
        NullPointerException nullPointerException;
        Object put;
        K k2 = k;
        V v2 = v;
        if (k2 == null || v2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("key == null || value == null");
            throw nullPointerException2;
        }
        synchronized (this) {
            try {
                this.putCount = 1 + this.putCount;
                this.size += safeSizeOf(k2, v2);
                put = this.map.put(k2, v2);
                if (put != null) {
                    this.size -= safeSizeOf(k2, put);
                }
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
        if (put != null) {
            entryRemoved(false, k2, put, v2);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final int putCount() {
        int i;
        synchronized (this) {
            try {
                th = this.putCount;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    /* JADX INFO: finally extract failed */
    public final V remove(K k) {
        Object remove;
        NullPointerException nullPointerException;
        K k2 = k;
        if (k2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("key == null");
            throw nullPointerException2;
        }
        synchronized (this) {
            try {
                remove = this.map.remove(k2);
                if (remove != null) {
                    this.size -= safeSizeOf(k2, remove);
                }
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
        if (remove != null) {
            entryRemoved(false, k2, remove, null);
        }
        return remove;
    }

    /* JADX INFO: finally extract failed */
    public void resize(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("maxSize <= 0");
            throw illegalArgumentException2;
        }
        synchronized (this) {
            try {
                this.maxSize = i2;
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
        trimToSize(i2);
    }

    public final int size() {
        int i;
        synchronized (this) {
            try {
                th = this.size;
            } finally {
                i = th;
                Throwable th = i;
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        K k2 = k;
        V v2 = v;
        return 1;
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        synchronized (this) {
            try {
                th = linkedHashMap2;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(this.map);
            } finally {
                linkedHashMap = th;
                Throwable th = linkedHashMap;
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: finally extract failed */
    public final String toString() {
        String format;
        synchronized (this) {
            try {
                int i = this.hitCount + this.missCount;
                int i2 = 0;
                if (i != 0) {
                    i2 = (100 * this.hitCount) / i;
                }
                format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i2)});
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
        return format;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r13) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
        L_0x0002:
            r6 = r0
            monitor-enter(r6)
            r6 = r0
            int r6 = r6.size     // Catch:{ all -> 0x003f }
            if (r6 < 0) goto L_0x0017
            r6 = r0
            java.util.LinkedHashMap<K, V> r6 = r6.map     // Catch:{ all -> 0x003f }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x003f }
            if (r6 == 0) goto L_0x0045
            r6 = r0
            int r6 = r6.size     // Catch:{ all -> 0x003f }
            if (r6 == 0) goto L_0x0045
        L_0x0017:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x003f }
            r11 = r6
            r6 = r11
            r7 = r11
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r11 = r8
            r8 = r11
            r9 = r11
            r9.<init>()     // Catch:{ all -> 0x003f }
            r9 = r0
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x003f }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x003f }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x003f }
            java.lang.String r9 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x003f }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x003f }
            r7.<init>(r8)     // Catch:{ all -> 0x003f }
            throw r6     // Catch:{ all -> 0x003f }
        L_0x003f:
            r6 = move-exception
            r2 = r6
            r6 = r0
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            r6 = r2
            throw r6
        L_0x0045:
            r6 = r0
            int r6 = r6.size     // Catch:{ all -> 0x003f }
            r7 = r1
            if (r6 <= r7) goto L_0x0054
            r6 = r0
            java.util.LinkedHashMap<K, V> r6 = r6.map     // Catch:{ all -> 0x003f }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x003f }
            if (r6 == 0) goto L_0x0057
        L_0x0054:
            r6 = r0
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            return
        L_0x0057:
            r6 = r0
            java.util.LinkedHashMap<K, V> r6 = r6.map     // Catch:{ all -> 0x003f }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x003f }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x003f }
            java.lang.Object r6 = r6.next()     // Catch:{ all -> 0x003f }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x003f }
            r3 = r6
            r6 = r3
            java.lang.Object r6 = r6.getKey()     // Catch:{ all -> 0x003f }
            r4 = r6
            r6 = r3
            java.lang.Object r6 = r6.getValue()     // Catch:{ all -> 0x003f }
            r5 = r6
            r6 = r0
            java.util.LinkedHashMap<K, V> r6 = r6.map     // Catch:{ all -> 0x003f }
            r7 = r4
            java.lang.Object r6 = r6.remove(r7)     // Catch:{ all -> 0x003f }
            r6 = r0
            r7 = r0
            int r7 = r7.size     // Catch:{ all -> 0x003f }
            r8 = r0
            r9 = r4
            r10 = r5
            int r8 = r8.safeSizeOf(r9, r10)     // Catch:{ all -> 0x003f }
            int r7 = r7 - r8
            r6.size = r7     // Catch:{ all -> 0x003f }
            r6 = r0
            r7 = 1
            r8 = r0
            int r8 = r8.evictionCount     // Catch:{ all -> 0x003f }
            int r7 = r7 + r8
            r6.evictionCount = r7     // Catch:{ all -> 0x003f }
            r6 = r0
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            r6 = r0
            r7 = 1
            r8 = r4
            r9 = r5
            r10 = 0
            r6.entryRemoved(r7, r8, r9, r10)
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.util.LruCache.trimToSize(int):void");
    }
}
