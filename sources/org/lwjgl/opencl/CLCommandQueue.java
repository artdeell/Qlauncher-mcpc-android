package org.lwjgl.opencl;

import org.lwjgl.PointerBuffer;

public final class CLCommandQueue extends CLObjectChild<CLContext> {
    private static final InfoUtil<CLCommandQueue> util = CLPlatform.getInfoUtilInstance(CLCommandQueue.class, "CL_COMMAND_QUEUE_UTIL");
    private final CLObjectRegistry<CLEvent> clEvents;
    private final CLDevice device;

    CLCommandQueue(long j, CLContext cLContext, CLDevice cLDevice) {
        CLObjectRegistry<CLEvent> cLObjectRegistry;
        CLContext cLContext2 = cLContext;
        CLDevice cLDevice2 = cLDevice;
        super(j, cLContext2);
        if (isValid()) {
            this.device = cLDevice2;
            CLObjectRegistry<CLEvent> cLObjectRegistry2 = cLObjectRegistry;
            CLObjectRegistry<CLEvent> cLObjectRegistry3 = new CLObjectRegistry<>();
            this.clEvents = cLObjectRegistry2;
            cLContext2.getCLCommandQueueRegistry().registerObject(this);
            return;
        }
        this.device = null;
        this.clEvents = null;
    }

    public CLDevice getCLDevice() {
        return this.device;
    }

    public CLEvent getCLEvent(long j) {
        return (CLEvent) this.clEvents.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLEvent> getCLEventRegistry() {
        return this.clEvents;
    }

    public int getInfoInt(int i) {
        return util.getInfoInt(this, i);
    }

    /* access modifiers changed from: 0000 */
    public void registerCLEvent(PointerBuffer pointerBuffer) {
        CLEvent cLEvent;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        if (pointerBuffer2 != null) {
            CLEvent cLEvent2 = cLEvent;
            CLEvent cLEvent3 = new CLEvent(pointerBuffer2.get(pointerBuffer2.position()), this);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public int release() {
        try {
            int release = super.release();
            if (!isValid()) {
                ((CLContext) getParent()).getCLCommandQueueRegistry().unregisterObject(this);
            }
            return release;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!isValid()) {
                ((CLContext) getParent()).getCLCommandQueueRegistry().unregisterObject(this);
            }
            throw th2;
        }
    }
}
