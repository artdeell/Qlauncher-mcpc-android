package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form22c */
public final class Form22c extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form22c form22c;
        Form22c form22c2 = form22c;
        Form22c form22c3 = new Form22c();
        THE_ONE = form22c2;
    }

    private Form22c() {
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
        bitSet4.set(0, unsignedFitsInNibble(registers.get(0).getReg()));
        bitSet4.set(1, unsignedFitsInNibble(registers.get(1).getReg()));
        return bitSet4;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registers.get(0).regString()).append(", ").append(registers.get(1).regString()).append(", ").append(cstString(dalvInsn2)).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        return z ? cstComment(dalvInsn) : LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        if ((dalvInsn2 instanceof CstInsn) && registers.size() == 2 && unsignedFitsInNibble(registers.get(0).getReg()) && unsignedFitsInNibble(registers.get(1).getReg())) {
            CstInsn cstInsn = (CstInsn) dalvInsn2;
            if (unsignedFitsInShort(cstInsn.getIndex())) {
                Constant constant = cstInsn.getConstant();
                if ((constant instanceof CstType) || (constant instanceof CstFieldRef)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, makeByte(registers.get(0).getReg(), registers.get(1).getReg())), (short) ((CstInsn) dalvInsn2).getIndex());
    }
}
