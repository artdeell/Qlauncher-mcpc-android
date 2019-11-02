package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainCstInsn */
public final class PlainCstInsn extends CstInsn {
    public PlainCstInsn(Rop rop, SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpecList registerSpecList, Constant constant) {
        IllegalArgumentException illegalArgumentException;
        Rop rop2 = rop;
        super(rop2, sourcePosition, registerSpec, registerSpecList, constant);
        if (rop2.getBranchingness() != 1) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus branchingness");
            throw illegalArgumentException2;
        }
    }

    public void accept(Visitor visitor) {
        visitor.visitPlainCstInsn(this);
    }

    public TypeList getCatches() {
        return StdTypeList.EMPTY;
    }

    public Insn withAddedCatch(Type type) {
        UnsupportedOperationException unsupportedOperationException;
        Type type2 = type;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("unsupported");
        throw unsupportedOperationException2;
    }

    public Insn withNewRegisters(RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        PlainCstInsn plainCstInsn;
        PlainCstInsn plainCstInsn2 = plainCstInsn;
        PlainCstInsn plainCstInsn3 = new PlainCstInsn(getOpcode(), getPosition(), registerSpec, registerSpecList, getConstant());
        return plainCstInsn2;
    }

    public Insn withRegisterOffset(int i) {
        PlainCstInsn plainCstInsn;
        int i2 = i;
        PlainCstInsn plainCstInsn2 = plainCstInsn;
        PlainCstInsn plainCstInsn3 = new PlainCstInsn(getOpcode(), getPosition(), getResult().withOffset(i2), getSources().withOffset(i2), getConstant());
        return plainCstInsn2;
    }
}
