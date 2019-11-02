package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.FillArrayDataInsn */
public final class FillArrayDataInsn extends Insn {
    private final Constant arrayType;
    private final ArrayList<Constant> initValues;

    public FillArrayDataInsn(Rop rop, SourcePosition sourcePosition, RegisterSpecList registerSpecList, ArrayList<Constant> arrayList, Constant constant) {
        IllegalArgumentException illegalArgumentException;
        Rop rop2 = rop;
        ArrayList<Constant> arrayList2 = arrayList;
        Constant constant2 = constant;
        super(rop2, sourcePosition, null, registerSpecList);
        if (rop2.getBranchingness() != 1) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus branchingness");
            throw illegalArgumentException2;
        }
        this.initValues = arrayList2;
        this.arrayType = constant2;
    }

    public void accept(Visitor visitor) {
        visitor.visitFillArrayDataInsn(this);
    }

    public TypeList getCatches() {
        return StdTypeList.EMPTY;
    }

    public Constant getConstant() {
        return this.arrayType;
    }

    public ArrayList<Constant> getInitValues() {
        return this.initValues;
    }

    public Insn withAddedCatch(Type type) {
        UnsupportedOperationException unsupportedOperationException;
        Type type2 = type;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("unsupported");
        throw unsupportedOperationException2;
    }

    public Insn withNewRegisters(RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        FillArrayDataInsn fillArrayDataInsn;
        RegisterSpec registerSpec2 = registerSpec;
        FillArrayDataInsn fillArrayDataInsn2 = fillArrayDataInsn;
        FillArrayDataInsn fillArrayDataInsn3 = new FillArrayDataInsn(getOpcode(), getPosition(), registerSpecList, this.initValues, this.arrayType);
        return fillArrayDataInsn2;
    }

    public Insn withRegisterOffset(int i) {
        FillArrayDataInsn fillArrayDataInsn;
        FillArrayDataInsn fillArrayDataInsn2 = fillArrayDataInsn;
        FillArrayDataInsn fillArrayDataInsn3 = new FillArrayDataInsn(getOpcode(), getPosition(), getSources().withOffset(i), this.initValues, this.arrayType);
        return fillArrayDataInsn2;
    }
}
