package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

public abstract class CLMemObjectDestructorCallback extends PointerWrapperAbstract {
    protected CLMemObjectDestructorCallback() {
        super(CallbackUtil.getMemObjectDestructorCallback());
    }

    /* access modifiers changed from: protected */
    public abstract void handleMessage(long j);
}
