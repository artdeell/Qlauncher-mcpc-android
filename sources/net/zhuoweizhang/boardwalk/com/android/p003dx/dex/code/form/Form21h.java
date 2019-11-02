package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form21h */
public final class Form21h extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form21h form21h;
        Form21h form21h2 = form21h;
        Form21h form21h3 = new Form21h();
        THE_ONE = form21h2;
    }

    private Form21h() {
    }

    public int codeSize() {
        return 2;
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
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z2 = z;
        return literalBitsComment((CstLiteralBits) ((CstInsn) dalvInsn2).getConstant(), dalvInsn2.getRegisters().get(0).getCategory() == 1 ? 32 : 64);
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z = true;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        if ((dalvInsn2 instanceof CstInsn) && registers.size() == 1 && unsignedFitsInByte(registers.get(0).getReg())) {
            Constant constant = ((CstInsn) dalvInsn2).getConstant();
            if (constant instanceof CstLiteralBits) {
                CstLiteralBits cstLiteralBits = (CstLiteralBits) constant;
                if (registers.get(0).getCategory() == 1) {
                    return (65535 & cstLiteralBits.getIntBits()) == 0;
                }
                if ((281474976710655L & cstLiteralBits.getLongBits()) != 0) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        CstLiteralBits cstLiteralBits = (CstLiteralBits) ((CstInsn) dalvInsn2).getConstant();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, registers.get(0).getReg()), registers.get(0).getCategory() == 1 ? (short) (cstLiteralBits.getIntBits() >>> 16) : (short) ((int) (cstLiteralBits.getLongBits() >>> 48)));
    }
}
