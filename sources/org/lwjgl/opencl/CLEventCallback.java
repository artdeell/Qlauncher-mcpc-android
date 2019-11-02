package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

public abstract class CLEventCallback extends PointerWrapperAbstract {
    private CLObjectRegistry<CLEvent> eventRegistry;

    protected CLEventCallback() {
        super(CallbackUtil.getEventCallback());
    }

    private void handleMessage(long j, int i) {
        int i2 = i;
        handleMessage((CLEvent) this.eventRegistry.getObject(j), i2);
    }

    /* access modifiers changed from: protected */
    public abstract void handleMessage(CLEvent cLEvent, int i);

    /* access modifiers changed from: 0000 */
    public void setRegistry(CLObjectRegistry<CLEvent> cLObjectRegistry) {
        CLObjectRegistry<CLEvent> cLObjectRegistry2 = cLObjectRegistry;
        this.eventRegistry = cLObjectRegistry2;
    }
}
