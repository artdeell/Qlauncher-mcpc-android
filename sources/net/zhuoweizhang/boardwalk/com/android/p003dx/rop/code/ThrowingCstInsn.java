package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingCstInsn */
public final class ThrowingCstInsn extends CstInsn {
    private final TypeList catches;

    public ThrowingCstInsn(Rop rop, SourcePosition sourcePosition, RegisterSpecList registerSpecList, TypeList typeList, Constant constant) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        Rop rop2 = rop;
        TypeList typeList2 = typeList;
        super(rop2, sourcePosition, null, registerSpecList, constant);
        if (rop2.getBranchingness() != 6) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus branchingness");
            throw illegalArgumentException2;
        } else if (typeList2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("catches == null");
            throw nullPointerException2;
        } else {
            this.catches = typeList2;
        }
    }

    public void accept(Visitor visitor) {
        visitor.visitThrowingCstInsn(this);
    }

    public TypeList getCatches() {
        return this.catches;
    }

    public String getInlineString() {
        StringBuilder sb;
        Constant constant = getConstant();
        String str = constant instanceof CstString ? ((CstString) constant).toQuoted() : constant.toHuman();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(str).append(" ").append(ThrowingInsn.toCatchString(this.catches)).toString();
    }

    public Insn withAddedCatch(Type type) {
        ThrowingCstInsn throwingCstInsn;
        ThrowingCstInsn throwingCstInsn2 = throwingCstInsn;
        ThrowingCstInsn throwingCstInsn3 = new ThrowingCstInsn(getOpcode(), getPosition(), getSources(), this.catches.withAddedType(type), getConstant());
        return throwingCstInsn2;
    }

    public Insn withNewRegisters(RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        ThrowingCstInsn throwingCstInsn;
        RegisterSpec registerSpec2 = registerSpec;
        ThrowingCstInsn throwingCstInsn2 = throwingCstInsn;
        ThrowingCstInsn throwingCstInsn3 = new ThrowingCstInsn(getOpcode(), getPosition(), registerSpecList, this.catches, getConstant());
        return throwingCstInsn2;
    }

    public Insn withRegisterOffset(int i) {
        ThrowingCstInsn throwingCstInsn;
        ThrowingCstInsn throwingCstInsn2 = throwingCstInsn;
        ThrowingCstInsn throwingCstInsn3 = new ThrowingCstInsn(getOpcode(), getPosition(), getSources().withOffset(i), this.catches, getConstant());
        return throwingCstInsn2;
    }
}
