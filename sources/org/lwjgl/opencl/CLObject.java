package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

abstract class CLObject extends PointerWrapperAbstract {
    protected CLObject(long j) {
        super(j);
    }

    /* access modifiers changed from: 0000 */
    public final long getPointerUnsafe() {
        return this.pointer;
    }
}
