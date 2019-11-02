package org.lwjgl.opencl;

abstract class CLObjectRetainable extends CLObject {
    private int refCount;

    protected CLObjectRetainable(long j) {
        super(j);
        if (super.isValid()) {
            this.refCount = 1;
        }
    }

    public final int getReferenceCount() {
        return this.refCount;
    }

    public final boolean isValid() {
        return this.refCount > 0;
    }

    /* access modifiers changed from: 0000 */
    public int release() {
        checkValid();
        int i = -1 + this.refCount;
        this.refCount = i;
        return i;
    }

    /* access modifiers changed from: 0000 */
    public int retain() {
        checkValid();
        int i = 1 + this.refCount;
        this.refCount = i;
        return i;
    }
}
