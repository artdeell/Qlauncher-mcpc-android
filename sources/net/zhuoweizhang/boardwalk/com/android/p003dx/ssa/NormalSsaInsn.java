package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn */
public final class NormalSsaInsn extends SsaInsn implements Cloneable {
    private Insn insn;

    NormalSsaInsn(Insn insn2, SsaBasicBlock ssaBasicBlock) {
        Insn insn3 = insn2;
        super(insn3.getResult(), ssaBasicBlock);
        this.insn = insn3;
    }

    public void accept(Visitor visitor) {
        Visitor visitor2 = visitor;
        if (isNormalMoveInsn()) {
            visitor2.visitMoveInsn(this);
        } else {
            visitor2.visitNonMoveInsn(this);
        }
    }

    public boolean canThrow() {
        return this.insn.canThrow();
    }

    public final void changeOneSource(int i, RegisterSpec registerSpec) {
        RegisterSpecList registerSpecList;
        int i2 = i;
        RegisterSpec registerSpec2 = registerSpec;
        RegisterSpecList sources = this.insn.getSources();
        int size = sources.size();
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(size);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        int i3 = 0;
        while (i3 < size) {
            registerSpecList4.set(i3, i3 == i2 ? registerSpec2 : sources.get(i3));
            i3++;
        }
        registerSpecList4.setImmutable();
        RegisterSpec registerSpec3 = sources.get(i2);
        if (registerSpec3.getReg() != registerSpec2.getReg()) {
            getBlock().getParent().onSourceChanged(this, registerSpec3, registerSpec2);
        }
        this.insn = this.insn.withNewRegisters(getResult(), registerSpecList4);
    }

    public NormalSsaInsn clone() {
        return (NormalSsaInsn) super.clone();
    }

    public RegisterSpec getLocalAssignment() {
        RegisterSpec result = this.insn.getOpcode().getOpcode() == 54 ? this.insn.getSources().get(0) : getResult();
        if (result == null || result.getLocalItem() == null) {
            return null;
        }
        return result;
    }

    public Rop getOpcode() {
        return this.insn.getOpcode();
    }

    public Insn getOriginalRopInsn() {
        return this.insn;
    }

    public RegisterSpecList getSources() {
        return this.insn.getSources();
    }

    public boolean hasSideEffect() {
        Rop opcode = getOpcode();
        if (opcode.getBranchingness() != 1) {
            return true;
        }
        boolean z = Optimizer.getPreserveLocals() && getLocalAssignment() != null;
        switch (opcode.getOpcode()) {
            case 2:
            case 5:
            case 55:
                return z;
            default:
                return true;
        }
    }

    public boolean isMoveException() {
        return this.insn.getOpcode().getOpcode() == 4;
    }

    public boolean isNormalMoveInsn() {
        return this.insn.getOpcode().getOpcode() == 2;
    }

    public boolean isPhiOrMove() {
        return isNormalMoveInsn();
    }

    public final void mapSourceRegisters(RegisterMapper registerMapper) {
        RegisterMapper registerMapper2 = registerMapper;
        RegisterSpecList sources = this.insn.getSources();
        RegisterSpecList map = registerMapper2.map(sources);
        if (map != sources) {
            this.insn = this.insn.withNewRegisters(getResult(), map);
            getBlock().getParent().onSourcesChanged(this, sources);
        }
    }

    public final void setNewSources(RegisterSpecList registerSpecList) {
        RuntimeException runtimeException;
        RegisterSpecList registerSpecList2 = registerSpecList;
        if (this.insn.getSources().size() != registerSpecList2.size()) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Sources counts don't match");
            throw runtimeException2;
        }
        this.insn = this.insn.withNewRegisters(getResult(), registerSpecList2);
    }

    public String toHuman() {
        return toRopInsn().toHuman();
    }

    public Insn toRopInsn() {
        return this.insn.withNewRegisters(getResult(), this.insn.getSources());
    }

    public void upgradeToLiteral() {
        RegisterSpecList sources = this.insn.getSources();
        this.insn = this.insn.withSourceLiteral();
        getBlock().getParent().onSourcesChanged(this, sources);
    }
}
