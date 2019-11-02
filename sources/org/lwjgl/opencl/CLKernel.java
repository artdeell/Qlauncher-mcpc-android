package org.lwjgl.opencl;

public final class CLKernel extends CLObjectChild<CLProgram> {
    private static final CLKernelUtil util = ((CLKernelUtil) CLPlatform.getInfoUtilInstance(CLKernel.class, "CL_KERNEL_UTIL"));

    interface CLKernelUtil extends InfoUtil<CLKernel> {
        long getWorkGroupInfoLong(CLKernel cLKernel, CLDevice cLDevice, int i);

        long getWorkGroupInfoSize(CLKernel cLKernel, CLDevice cLDevice, int i);

        long[] getWorkGroupInfoSizeArray(CLKernel cLKernel, CLDevice cLDevice, int i);

        void setArg(CLKernel cLKernel, int i, byte b);

        void setArg(CLKernel cLKernel, int i, double d);

        void setArg(CLKernel cLKernel, int i, float f);

        void setArg(CLKernel cLKernel, int i, int i2);

        void setArg(CLKernel cLKernel, int i, long j);

        void setArg(CLKernel cLKernel, int i, CLObject cLObject);

        void setArg(CLKernel cLKernel, int i, short s);

        void setArgSize(CLKernel cLKernel, int i, long j);
    }

    CLKernel(long j, CLProgram cLProgram) {
        CLProgram cLProgram2 = cLProgram;
        super(j, cLProgram2);
        if (isValid()) {
            cLProgram2.getCLKernelRegistry().registerObject(this);
        }
    }

    public int getInfoInt(int i) {
        return util.getInfoInt(this, i);
    }

    public String getInfoString(int i) {
        return util.getInfoString(this, i);
    }

    public long getWorkGroupInfoLong(CLDevice cLDevice, int i) {
        return util.getWorkGroupInfoLong(this, cLDevice, i);
    }

    public long getWorkGroupInfoSize(CLDevice cLDevice, int i) {
        return util.getWorkGroupInfoSize(this, cLDevice, i);
    }

    public long[] getWorkGroupInfoSizeArray(CLDevice cLDevice, int i) {
        return util.getWorkGroupInfoSizeArray(this, cLDevice, i);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public int release() {
        try {
            int release = super.release();
            if (!isValid()) {
                ((CLProgram) getParent()).getCLKernelRegistry().unregisterObject(this);
            }
            return release;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!isValid()) {
                ((CLProgram) getParent()).getCLKernelRegistry().unregisterObject(this);
            }
            throw th2;
        }
    }

    public CLKernel setArg(int i, byte b) {
        util.setArg(this, i, b);
        return this;
    }

    public CLKernel setArg(int i, double d) {
        util.setArg(this, i, d);
        return this;
    }

    public CLKernel setArg(int i, float f) {
        util.setArg(this, i, f);
        return this;
    }

    public CLKernel setArg(int i, int i2) {
        util.setArg(this, i, i2);
        return this;
    }

    public CLKernel setArg(int i, long j) {
        util.setArg(this, i, j);
        return this;
    }

    public CLKernel setArg(int i, CLObject cLObject) {
        util.setArg(this, i, cLObject);
        return this;
    }

    public CLKernel setArg(int i, short s) {
        util.setArg(this, i, s);
        return this;
    }

    public CLKernel setArgSize(int i, long j) {
        util.setArgSize(this, i, j);
        return this;
    }
}
