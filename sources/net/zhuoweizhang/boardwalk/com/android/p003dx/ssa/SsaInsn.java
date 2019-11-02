package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn */
public abstract class SsaInsn implements ToHuman, Cloneable {
    private final SsaBasicBlock block;
    private RegisterSpec result;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn$Visitor */
    public interface Visitor {
        void visitMoveInsn(NormalSsaInsn normalSsaInsn);

        void visitNonMoveInsn(NormalSsaInsn normalSsaInsn);

        void visitPhiInsn(PhiInsn phiInsn);
    }

    protected SsaInsn(RegisterSpec registerSpec, SsaBasicBlock ssaBasicBlock) {
        NullPointerException nullPointerException;
        RegisterSpec registerSpec2 = registerSpec;
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        if (ssaBasicBlock2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("block == null");
            throw nullPointerException2;
        }
        this.block = ssaBasicBlock2;
        this.result = registerSpec2;
    }

    public static SsaInsn makeFromRop(Insn insn, SsaBasicBlock ssaBasicBlock) {
        NormalSsaInsn normalSsaInsn;
        NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
        NormalSsaInsn normalSsaInsn3 = new NormalSsaInsn(insn, ssaBasicBlock);
        return normalSsaInsn2;
    }

    public abstract void accept(Visitor visitor);

    public abstract boolean canThrow();

    public void changeResultReg(int i) {
        int i2 = i;
        if (this.result != null) {
            this.result = this.result.withReg(i2);
        }
    }

    public SsaInsn clone() {
        RuntimeException runtimeException;
        try {
            return (SsaInsn) super.clone();
        } catch (CloneNotSupportedException e) {
            CloneNotSupportedException cloneNotSupportedException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("unexpected", cloneNotSupportedException);
            throw runtimeException2;
        }
    }

    public SsaBasicBlock getBlock() {
        return this.block;
    }

    public RegisterSpec getLocalAssignment() {
        if (this.result == null || this.result.getLocalItem() == null) {
            return null;
        }
        return this.result;
    }

    public abstract Rop getOpcode();

    public abstract Insn getOriginalRopInsn();

    public RegisterSpec getResult() {
        return this.result;
    }

    public abstract RegisterSpecList getSources();

    public abstract boolean hasSideEffect();

    public boolean isMoveException() {
        return false;
    }

    public boolean isNormalMoveInsn() {
        return false;
    }

    public abstract boolean isPhiOrMove();

    public boolean isRegASource(int i) {
        return getSources().specForRegister(i) != null;
    }

    public boolean isResultReg(int i) {
        return this.result != null && this.result.getReg() == i;
    }

    public final void mapRegisters(RegisterMapper registerMapper) {
        RegisterMapper registerMapper2 = registerMapper;
        RegisterSpec registerSpec = this.result;
        this.result = registerMapper2.map(this.result);
        this.block.getParent().updateOneDefinition(this, registerSpec);
        mapSourceRegisters(registerMapper2);
    }

    public abstract void mapSourceRegisters(RegisterMapper registerMapper);

    /* access modifiers changed from: protected */
    public void setResult(RegisterSpec registerSpec) {
        NullPointerException nullPointerException;
        RegisterSpec registerSpec2 = registerSpec;
        if (registerSpec2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("result == null");
            throw nullPointerException2;
        }
        this.result = registerSpec2;
    }

    public final void setResultLocal(LocalItem localItem) {
        LocalItem localItem2 = localItem;
        if (localItem2 == this.result.getLocalItem()) {
            return;
        }
        if (localItem2 == null || !localItem2.equals(this.result.getLocalItem())) {
            this.result = RegisterSpec.makeLocalOptional(this.result.getReg(), this.result.getType(), localItem2);
        }
    }

    public abstract Insn toRopInsn();
}
