package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.TargetInsn */
public final class TargetInsn extends FixedSizeInsn {
    private CodeAddress target;

    public TargetInsn(Dop dop, SourcePosition sourcePosition, RegisterSpecList registerSpecList, CodeAddress codeAddress) {
        NullPointerException nullPointerException;
        CodeAddress codeAddress2 = codeAddress;
        super(dop, sourcePosition, registerSpecList);
        if (codeAddress2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("target == null");
            throw nullPointerException2;
        }
        this.target = codeAddress2;
    }

    /* access modifiers changed from: protected */
    public String argString() {
        return this.target == null ? "????" : this.target.identifierString();
    }

    public CodeAddress getTarget() {
        return this.target;
    }

    public int getTargetAddress() {
        return this.target.getAddress();
    }

    public int getTargetOffset() {
        return this.target.getAddress() - getAddress();
    }

    public boolean hasTargetOffset() {
        return hasAddress() && this.target.hasAddress();
    }

    public TargetInsn withNewTargetAndReversed(CodeAddress codeAddress) {
        TargetInsn targetInsn;
        TargetInsn targetInsn2 = targetInsn;
        TargetInsn targetInsn3 = new TargetInsn(getOpcode().getOppositeTest(), getPosition(), getRegisters(), codeAddress);
        return targetInsn2;
    }

    public DalvInsn withOpcode(Dop dop) {
        TargetInsn targetInsn;
        TargetInsn targetInsn2 = targetInsn;
        TargetInsn targetInsn3 = new TargetInsn(dop, getPosition(), getRegisters(), this.target);
        return targetInsn2;
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        TargetInsn targetInsn;
        TargetInsn targetInsn2 = targetInsn;
        TargetInsn targetInsn3 = new TargetInsn(getOpcode(), getPosition(), registerSpecList, this.target);
        return targetInsn2;
    }
}
