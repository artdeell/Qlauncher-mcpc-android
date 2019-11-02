package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.PointerBuffer;

public final class CLProgram extends CLObjectChild<CLContext> {
    private static final CLProgramUtil util = ((CLProgramUtil) CLPlatform.getInfoUtilInstance(CLProgram.class, "CL_PROGRAM_UTIL"));
    private final CLObjectRegistry<CLKernel> clKernels;

    interface CLProgramUtil extends InfoUtil<CLProgram> {
        CLKernel[] createKernelsInProgram(CLProgram cLProgram);

        int getBuildInfoInt(CLProgram cLProgram, CLDevice cLDevice, int i);

        String getBuildInfoString(CLProgram cLProgram, CLDevice cLDevice, int i);

        ByteBuffer getInfoBinaries(CLProgram cLProgram, ByteBuffer byteBuffer);

        ByteBuffer[] getInfoBinaries(CLProgram cLProgram, ByteBuffer[] byteBufferArr);

        CLDevice[] getInfoDevices(CLProgram cLProgram);
    }

    CLProgram(long j, CLContext cLContext) {
        CLObjectRegistry<CLKernel> cLObjectRegistry;
        CLContext cLContext2 = cLContext;
        super(j, cLContext2);
        if (isValid()) {
            cLContext2.getCLProgramRegistry().registerObject(this);
            CLObjectRegistry<CLKernel> cLObjectRegistry2 = cLObjectRegistry;
            CLObjectRegistry<CLKernel> cLObjectRegistry3 = new CLObjectRegistry<>();
            this.clKernels = cLObjectRegistry2;
            return;
        }
        this.clKernels = null;
    }

    public CLKernel[] createKernelsInProgram() {
        return util.createKernelsInProgram(this);
    }

    public int getBuildInfoInt(CLDevice cLDevice, int i) {
        return util.getBuildInfoInt(this, cLDevice, i);
    }

    public String getBuildInfoString(CLDevice cLDevice, int i) {
        return util.getBuildInfoString(this, cLDevice, i);
    }

    public CLKernel getCLKernel(long j) {
        return (CLKernel) this.clKernels.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLKernel> getCLKernelRegistry() {
        return this.clKernels;
    }

    public ByteBuffer getInfoBinaries(ByteBuffer byteBuffer) {
        return util.getInfoBinaries(this, byteBuffer);
    }

    public ByteBuffer[] getInfoBinaries(ByteBuffer[] byteBufferArr) {
        return util.getInfoBinaries(this, byteBufferArr);
    }

    public CLDevice[] getInfoDevices() {
        return util.getInfoDevices(this);
    }

    public int getInfoInt(int i) {
        return util.getInfoInt(this, i);
    }

    public long[] getInfoSizeArray(int i) {
        return util.getInfoSizeArray(this, i);
    }

    public String getInfoString(int i) {
        return util.getInfoString(this, i);
    }

    /* access modifiers changed from: 0000 */
    public void registerCLKernels(PointerBuffer pointerBuffer) {
        CLKernel cLKernel;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        for (int position = pointerBuffer2.position(); position < pointerBuffer2.limit(); position++) {
            long j = pointerBuffer2.get(position);
            if (j != 0) {
                CLKernel cLKernel2 = cLKernel;
                CLKernel cLKernel3 = new CLKernel(j, this);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public int release() {
        try {
            int release = super.release();
            if (!isValid()) {
                ((CLContext) getParent()).getCLProgramRegistry().unregisterObject(this);
            }
            return release;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!isValid()) {
                ((CLContext) getParent()).getCLProgramRegistry().unregisterObject(this);
            }
            throw th2;
        }
    }
}
