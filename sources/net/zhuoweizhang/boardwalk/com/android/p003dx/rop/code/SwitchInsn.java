package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SwitchInsn */
public final class SwitchInsn extends Insn {
    private final IntList cases;

    public SwitchInsn(Rop rop, SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpecList registerSpecList, IntList intList) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        Rop rop2 = rop;
        IntList intList2 = intList;
        super(rop2, sourcePosition, registerSpec, registerSpecList);
        if (rop2.getBranchingness() != 5) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus branchingness");
            throw illegalArgumentException2;
        } else if (intList2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cases == null");
            throw nullPointerException2;
        } else {
            this.cases = intList2;
        }
    }

    public void accept(Visitor visitor) {
        visitor.visitSwitchInsn(this);
    }

    public boolean contentEquals(Insn insn) {
        Insn insn2 = insn;
        return false;
    }

    public IntList getCases() {
        return this.cases;
    }

    public TypeList getCatches() {
        return StdTypeList.EMPTY;
    }

    public String getInlineString() {
        return this.cases.toString();
    }

    public Insn withAddedCatch(Type type) {
        UnsupportedOperationException unsupportedOperationException;
        Type type2 = type;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("unsupported");
        throw unsupportedOperationException2;
    }

    public Insn withNewRegisters(RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        SwitchInsn switchInsn;
        SwitchInsn switchInsn2 = switchInsn;
        SwitchInsn switchInsn3 = new SwitchInsn(getOpcode(), getPosition(), registerSpec, registerSpecList, this.cases);
        return switchInsn2;
    }

    public Insn withRegisterOffset(int i) {
        SwitchInsn switchInsn;
        int i2 = i;
        SwitchInsn switchInsn2 = switchInsn;
        SwitchInsn switchInsn3 = new SwitchInsn(getOpcode(), getPosition(), getResult().withOffset(i2), getSources().withOffset(i2), this.cases);
        return switchInsn2;
    }
}
