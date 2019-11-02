package org.lwjgl.opencl;

public final class CLSampler extends CLObjectChild<CLContext> {
    private static final InfoUtil<CLSampler> util = CLPlatform.getInfoUtilInstance(CLSampler.class, "CL_SAMPLER_UTIL");

    CLSampler(long j, CLContext cLContext) {
        CLContext cLContext2 = cLContext;
        super(j, cLContext2);
        if (isValid()) {
            cLContext2.getCLSamplerRegistry().registerObject(this);
        }
    }

    public int getInfoInt(int i) {
        return util.getInfoInt(this, i);
    }

    public long getInfoLong(int i) {
        return util.getInfoLong(this, i);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public int release() {
        try {
            int release = super.release();
            if (!isValid()) {
                ((CLContext) getParent()).getCLSamplerRegistry().unregisterObject(this);
            }
            return release;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!isValid()) {
                ((CLContext) getParent()).getCLSamplerRegistry().unregisterObject(this);
            }
            throw th2;
        }
    }
}
