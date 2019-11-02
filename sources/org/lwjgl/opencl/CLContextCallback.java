package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.PointerWrapperAbstract;

public abstract class CLContextCallback extends PointerWrapperAbstract {
    private final boolean custom;

    protected CLContextCallback() {
        super(CallbackUtil.getContextCallback());
        this.custom = false;
    }

    protected CLContextCallback(long j) {
        RuntimeException runtimeException;
        long j2 = j;
        super(j2);
        if (j2 == 0) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Invalid callback function pointer specified.");
            throw runtimeException2;
        }
        this.custom = true;
    }

    /* access modifiers changed from: protected */
    public abstract void handleMessage(String str, ByteBuffer byteBuffer);

    /* access modifiers changed from: 0000 */
    public final boolean isCustom() {
        return this.custom;
    }
}
