package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn */
public final class PlainInsn extends Insn {
    public PlainInsn(Rop rop, SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        this(rop, sourcePosition, registerSpec, RegisterSpecList.make(registerSpec2));
    }

    public PlainInsn(Rop rop, SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        Rop rop2 = rop;
        RegisterSpec registerSpec2 = registerSpec;
        super(rop2, sourcePosition, registerSpec2, registerSpecList);
        switch (rop2.getBranchingness()) {
            case 5:
            case 6:
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("bogus branchingness");
                throw illegalArgumentException3;
            default:
                if (registerSpec2 != null && rop2.getBranchingness() != 1) {
                    IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
                    IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("can't mix branchingness with result");
                    throw illegalArgumentException5;
                }
                return;
        }
    }

    public void accept(Visitor visitor) {
        visitor.visitPlainInsn(this);
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
        PlainInsn plainInsn;
        PlainInsn plainInsn2 = plainInsn;
        PlainInsn plainInsn3 = new PlainInsn(getOpcode(), getPosition(), registerSpec, registerSpecList);
        return plainInsn2;
    }

    public Insn withRegisterOffset(int i) {
        PlainInsn plainInsn;
        int i2 = i;
        PlainInsn plainInsn2 = plainInsn;
        PlainInsn plainInsn3 = new PlainInsn(getOpcode(), getPosition(), getResult().withOffset(i2), getSources().withOffset(i2));
        return plainInsn2;
    }

    public Insn withSourceLiteral() {
        Constant constant;
        int i;
        PlainCstInsn plainCstInsn;
        PlainCstInsn plainCstInsn2;
        RegisterSpecList sources = getSources();
        int size = sources.size();
        if (size != 0) {
            TypeBearer typeBearer = sources.get(size - 1).getTypeBearer();
            if (!typeBearer.isConstant()) {
                TypeBearer typeBearer2 = sources.get(0).getTypeBearer();
                if (size == 2 && typeBearer2.isConstant()) {
                    Constant constant2 = (Constant) typeBearer2;
                    RegisterSpecList withoutFirst = sources.withoutFirst();
                    PlainCstInsn plainCstInsn3 = plainCstInsn2;
                    PlainCstInsn plainCstInsn4 = new PlainCstInsn(Rops.ropFor(getOpcode().getOpcode(), getResult(), withoutFirst, constant2), getPosition(), getResult(), withoutFirst, constant2);
                    return plainCstInsn3;
                }
            } else {
                Constant constant3 = (Constant) typeBearer;
                RegisterSpecList withoutLast = sources.withoutLast();
                try {
                    int opcode = getOpcode().getOpcode();
                    if (opcode != 15 || !(constant3 instanceof CstInteger)) {
                        constant = constant3;
                        i = opcode;
                    } else {
                        constant = CstInteger.make(-((CstInteger) constant3).getValue());
                        i = 14;
                    }
                    PlainCstInsn plainCstInsn5 = plainCstInsn;
                    PlainCstInsn plainCstInsn6 = new PlainCstInsn(Rops.ropFor(i, getResult(), withoutLast, constant), getPosition(), getResult(), withoutLast, constant);
                    return plainCstInsn5;
                } catch (IllegalArgumentException e) {
                    IllegalArgumentException illegalArgumentException = e;
                    return this;
                }
            }
        }
        return this;
    }
}
