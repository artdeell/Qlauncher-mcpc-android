package org.lwjgl.opencl;

public final class CLEvent extends CLObjectChild<CLContext> {
    private static final CLEventUtil util = ((CLEventUtil) CLPlatform.getInfoUtilInstance(CLEvent.class, "CL_EVENT_UTIL"));
    private final CLCommandQueue queue;

    interface CLEventUtil extends InfoUtil<CLEvent> {
        long getProfilingInfoLong(CLEvent cLEvent, int i);
    }

    CLEvent(long j, CLCommandQueue cLCommandQueue) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        this(j, (CLContext) cLCommandQueue2.getParent(), cLCommandQueue2);
    }

    CLEvent(long j, CLContext cLContext) {
        this(j, cLContext, null);
    }

    CLEvent(long j, CLContext cLContext, CLCommandQueue cLCommandQueue) {
        CLContext cLContext2 = cLContext;
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        super(j, cLContext2);
        if (isValid()) {
            this.queue = cLCommandQueue2;
            if (cLCommandQueue2 == null) {
                cLContext2.getCLEventRegistry().registerObject(this);
            } else {
                cLCommandQueue2.getCLEventRegistry().registerObject(this);
            }
        } else {
            this.queue = null;
        }
    }

    public CLCommandQueue getCLCommandQueue() {
        return this.queue;
    }

    public int getInfoInt(int i) {
        return util.getInfoInt(this, i);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLEvent> getParentRegistry() {
        return this.queue == null ? ((CLContext) getParent()).getCLEventRegistry() : this.queue.getCLEventRegistry();
    }

    public long getProfilingInfoLong(int i) {
        return util.getProfilingInfoLong(this, i);
    }

    /* access modifiers changed from: 0000 */
    public int release() {
        try {
            int release = super.release();
            if (!isValid()) {
                if (this.queue == null) {
                    ((CLContext) getParent()).getCLEventRegistry().unregisterObject(this);
                } else {
                    this.queue.getCLEventRegistry().unregisterObject(this);
                    return release;
                }
            }
            return release;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!isValid()) {
                if (this.queue == null) {
                    ((CLContext) getParent()).getCLEventRegistry().unregisterObject(this);
                } else {
                    this.queue.getCLEventRegistry().unregisterObject(this);
                }
            }
            throw th2;
        }
    }
}
