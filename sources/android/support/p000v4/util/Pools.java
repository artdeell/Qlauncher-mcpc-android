package android.support.p000v4.util;

/* renamed from: android.support.v4.util.Pools */
public final class Pools {

    /* renamed from: android.support.v4.util.Pools$Pool */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);
    }

    /* renamed from: android.support.v4.util.Pools$SimplePool */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i) {
            IllegalArgumentException illegalArgumentException;
            int i2 = i;
            if (i2 <= 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The max pool size must be > 0");
                throw illegalArgumentException2;
            }
            this.mPool = new Object[i2];
        }

        private boolean isInPool(T t) {
            T t2 = t;
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == t2) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            if (this.mPoolSize <= 0) {
                return null;
            }
            int i = -1 + this.mPoolSize;
            Object obj = this.mPool[i];
            this.mPool[i] = null;
            this.mPoolSize = -1 + this.mPoolSize;
            return obj;
        }

        public boolean release(T t) {
            IllegalStateException illegalStateException;
            T t2 = t;
            if (isInPool(t2)) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Already in the pool!");
                throw illegalStateException2;
            } else if (this.mPoolSize >= this.mPool.length) {
                return false;
            } else {
                this.mPool[this.mPoolSize] = t2;
                this.mPoolSize = 1 + this.mPoolSize;
                return true;
            }
        }
    }

    /* renamed from: android.support.v4.util.Pools$SynchronizedPool */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i) {
            Object obj;
            super(i);
            Object obj2 = obj;
            Object obj3 = new Object();
            this.mLock = obj2;
        }

        public T acquire() {
            Object obj = this.mLock;
            synchronized (obj) {
                try {
                    th = super.acquire();
                } finally {
                    Throwable th = th;
                    Object obj2 = obj;
                    Throwable th2 = th;
                }
            }
            return th;
        }

        public boolean release(T t) {
            T t2 = t;
            boolean z = this.mLock;
            synchronized (z) {
                try {
                    th = super.release(t2);
                } finally {
                    Throwable th = th;
                    boolean z2 = z;
                    Throwable th2 = th;
                }
            }
            return th;
        }
    }

    private Pools() {
    }
}
