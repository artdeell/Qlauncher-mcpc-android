package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form22b */
public final class Form22b extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form22b form22b;
        Form22b form22b2 = form22b;
        Form22b form22b3 = new Form22b();
        THE_ONE = form22b2;
    }

    private Form22b() {
    }

    public int codeSize() {
        return 2;
    }

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        BitSet bitSet;
        RegisterSpecList registers = dalvInsn.getRegisters();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(2);
        BitSet bitSet4 = bitSet2;
        bitSet4.set(0, unsignedFitsInByte(registers.get(0).getReg()));
        bitSet4.set(1, unsignedFitsInByte(registers.get(1).getReg()));
        return bitSet4;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        CstLiteralBits cstLiteralBits = (CstLiteralBits) ((CstInsn) dalvInsn2).getConstant();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registers.get(0).regString()).append(", ").append(registers.get(1).regString()).append(", ").append(literalBitsString(cstLiteralBits)).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        boolean z2 = z;
        return literalBitsComment((CstLiteralBits) ((CstInsn) dalvInsn).getConstant(), 8);
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        if ((dalvInsn2 instanceof CstInsn) && registers.size() == 2 && unsignedFitsInByte(registers.get(0).getReg()) && unsignedFitsInByte(registers.get(1).getReg())) {
            Constant constant = ((CstInsn) dalvInsn2).getConstant();
            if (constant instanceof CstLiteralBits) {
                CstLiteralBits cstLiteralBits = (CstLiteralBits) constant;
                return cstLiteralBits.fitsInInt() && signedFitsInByte(cstLiteralBits.getIntBits());
            }
        }
        return false;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, registers.get(0).getReg()), codeUnit(registers.get(1).getReg(), ((CstLiteralBits) ((CstInsn) dalvInsn2).getConstant()).getIntBits() & 255));
    }
}
