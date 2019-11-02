package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

abstract class CLProgramCallback extends PointerWrapperAbstract {
    private CLContext context;

    protected CLProgramCallback() {
        super(CallbackUtil.getProgramCallback());
    }

    private void handleMessage(long j) {
        handleMessage(this.context.getCLProgram(j));
    }

    /* access modifiers changed from: protected */
    public abstract void handleMessage(CLProgram cLProgram);

    /* access modifiers changed from: 0000 */
    public final void setContext(CLContext cLContext) {
        CLContext cLContext2 = cLContext;
        this.context = cLContext2;
    }
}
