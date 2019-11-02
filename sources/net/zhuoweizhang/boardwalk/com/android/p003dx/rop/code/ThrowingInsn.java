package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ThrowingInsn */
public final class ThrowingInsn extends Insn {
    private final TypeList catches;

    public ThrowingInsn(Rop rop, SourcePosition sourcePosition, RegisterSpecList registerSpecList, TypeList typeList) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        Rop rop2 = rop;
        TypeList typeList2 = typeList;
        super(rop2, sourcePosition, null, registerSpecList);
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

    public static String toCatchString(TypeList typeList) {
        StringBuffer stringBuffer;
        TypeList typeList2 = typeList;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append("catch");
        int size = typeList2.size();
        for (int i = 0; i < size; i++) {
            StringBuffer append2 = stringBuffer4.append(" ");
            StringBuffer append3 = stringBuffer4.append(typeList2.getType(i).toHuman());
        }
        return stringBuffer4.toString();
    }

    public void accept(Visitor visitor) {
        visitor.visitThrowingInsn(this);
    }

    public TypeList getCatches() {
        return this.catches;
    }

    public String getInlineString() {
        return toCatchString(this.catches);
    }

    public Insn withAddedCatch(Type type) {
        ThrowingInsn throwingInsn;
        ThrowingInsn throwingInsn2 = throwingInsn;
        ThrowingInsn throwingInsn3 = new ThrowingInsn(getOpcode(), getPosition(), getSources(), this.catches.withAddedType(type));
        return throwingInsn2;
    }

    public Insn withNewRegisters(RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        ThrowingInsn throwingInsn;
        RegisterSpec registerSpec2 = registerSpec;
        ThrowingInsn throwingInsn2 = throwingInsn;
        ThrowingInsn throwingInsn3 = new ThrowingInsn(getOpcode(), getPosition(), registerSpecList, this.catches);
        return throwingInsn2;
    }

    public Insn withRegisterOffset(int i) {
        ThrowingInsn throwingInsn;
        ThrowingInsn throwingInsn2 = throwingInsn;
        ThrowingInsn throwingInsn3 = new ThrowingInsn(getOpcode(), getPosition(), getSources().withOffset(i), this.catches);
        return throwingInsn2;
    }
}
