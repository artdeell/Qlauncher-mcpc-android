package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

public abstract class CLPrintfCallback extends PointerWrapperAbstract {
    protected CLPrintfCallback() {
        super(CallbackUtil.getPrintfCallback());
    }

    /* access modifiers changed from: protected */
    public abstract void handleMessage(String str);
}
