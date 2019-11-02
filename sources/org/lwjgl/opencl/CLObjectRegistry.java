package org.lwjgl.opencl;

import org.lwjgl.LWJGLUtil;
import org.lwjgl.opencl.CLObjectChild;

class CLObjectRegistry<T extends CLObjectChild> {
    private FastLongMap<T> registry;

    CLObjectRegistry() {
    }

    private FastLongMap<T> getMap() {
        FastLongMap<T> fastLongMap;
        if (this.registry == null) {
            FastLongMap<T> fastLongMap2 = fastLongMap;
            FastLongMap<T> fastLongMap3 = new FastLongMap<>();
            this.registry = fastLongMap2;
        }
        return this.registry;
    }

    /* access modifiers changed from: 0000 */
    public final Iterable<Entry<T>> getAll() {
        return this.registry;
    }

    /* access modifiers changed from: 0000 */
    public final T getObject(long j) {
        long j2 = j;
        if (this.registry == null) {
            return null;
        }
        return (CLObjectChild) this.registry.get(j2);
    }

    /* access modifiers changed from: 0000 */
    public final boolean hasObject(long j) {
        return this.registry != null && this.registry.containsKey(j);
    }

    /* access modifiers changed from: 0000 */
    public final boolean isEmpty() {
        return this.registry == null || this.registry.isEmpty();
    }

    /* access modifiers changed from: 0000 */
    public void registerObject(T t) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        T t2 = t;
        FastLongMap map = getMap();
        Long valueOf = Long.valueOf(t2.getPointer());
        if (!LWJGLUtil.DEBUG || !map.containsKey(valueOf.longValue())) {
            Object put = getMap().put(t2.getPointer(), t2);
            return;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Duplicate object found: ").append(t2.getClass()).append(" - ").append(valueOf).toString());
        throw illegalStateException2;
    }

    /* access modifiers changed from: 0000 */
    public void unregisterObject(T t) {
        Object remove = getMap().remove(t.getPointerUnsafe());
    }
}
