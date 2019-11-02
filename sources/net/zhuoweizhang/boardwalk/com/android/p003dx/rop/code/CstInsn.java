package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.CstInsn */
public abstract class CstInsn extends Insn {
    private final Constant cst;

    public CstInsn(Rop rop, SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpecList registerSpecList, Constant constant) {
        NullPointerException nullPointerException;
        Constant constant2 = constant;
        super(rop, sourcePosition, registerSpec, registerSpecList);
        if (constant2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cst == null");
            throw nullPointerException2;
        }
        this.cst = constant2;
    }

    public boolean contentEquals(Insn insn) {
        Insn insn2 = insn;
        return super.contentEquals(insn2) && this.cst.equals(((CstInsn) insn2).getConstant());
    }

    public Constant getConstant() {
        return this.cst;
    }

    public String getInlineString() {
        return this.cst.toHuman();
    }
}
