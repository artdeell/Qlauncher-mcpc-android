package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form31i */
public final class Form31i extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form31i form31i;
        Form31i form31i2 = form31i;
        Form31i form31i3 = new Form31i();
        THE_ONE = form31i2;
    }

    private Form31i() {
    }

    public int codeSize() {
        return 3;
    }

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        BitSet bitSet;
        RegisterSpecList registers = dalvInsn.getRegisters();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(1);
        BitSet bitSet4 = bitSet2;
        bitSet4.set(0, unsignedFitsInByte(registers.get(0).getReg()));
        return bitSet4;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        CstLiteralBits cstLiteralBits = (CstLiteralBits) ((CstInsn) dalvInsn2).getConstant();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registers.get(0).regString()).append(", ").append(literalBitsString(cstLiteralBits)).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        boolean z2 = z;
        return literalBitsComment((CstLiteralBits) ((CstInsn) dalvInsn).getConstant(), 32);
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        if (!(dalvInsn2 instanceof CstInsn) || registers.size() != 1 || !unsignedFitsInByte(registers.get(0).getReg())) {
            return false;
        }
        Constant constant = ((CstInsn) dalvInsn2).getConstant();
        if (!(constant instanceof CstLiteralBits)) {
            return false;
        }
        return ((CstLiteralBits) constant).fitsInInt();
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, registers.get(0).getReg()), ((CstLiteralBits) ((CstInsn) dalvInsn2).getConstant()).getIntBits());
    }
}
