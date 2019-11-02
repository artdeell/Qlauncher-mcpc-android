package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form31c */
public final class Form31c extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form31c form31c;
        Form31c form31c2 = form31c;
        Form31c form31c3 = new Form31c();
        THE_ONE = form31c2;
    }

    private Form31c() {
    }

    public int codeSize() {
        return 3;
    }

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        BitSet bitSet;
        RegisterSpecList registers = dalvInsn.getRegisters();
        int size = registers.size();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(size);
        BitSet bitSet4 = bitSet2;
        boolean unsignedFitsInByte = unsignedFitsInByte(registers.get(0).getReg());
        if (size == 1) {
            bitSet4.set(0, unsignedFitsInByte);
        } else if (registers.get(0).getReg() == registers.get(1).getReg()) {
            bitSet4.set(0, unsignedFitsInByte);
            bitSet4.set(1, unsignedFitsInByte);
            return bitSet4;
        }
        return bitSet4;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registers.get(0).regString()).append(", ").append(cstString(dalvInsn2)).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        return z ? cstComment(dalvInsn) : LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        RegisterSpec registerSpec;
        DalvInsn dalvInsn2 = dalvInsn;
        if (dalvInsn2 instanceof CstInsn) {
            RegisterSpecList registers = dalvInsn2.getRegisters();
            switch (registers.size()) {
                case 1:
                    registerSpec = registers.get(0);
                    break;
                case 2:
                    registerSpec = registers.get(0);
                    if (registerSpec.getReg() != registers.get(1).getReg()) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            if (unsignedFitsInByte(registerSpec.getReg())) {
                Constant constant = ((CstInsn) dalvInsn2).getConstant();
                return (constant instanceof CstType) || (constant instanceof CstFieldRef) || (constant instanceof CstString);
            }
        }
        return false;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, registers.get(0).getReg()), ((CstInsn) dalvInsn2).getIndex());
    }
}
