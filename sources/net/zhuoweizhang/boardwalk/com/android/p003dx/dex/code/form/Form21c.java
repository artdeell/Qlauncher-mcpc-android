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

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form21c */
public final class Form21c extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form21c form21c;
        Form21c form21c2 = form21c;
        Form21c form21c3 = new Form21c();
        THE_ONE = form21c2;
    }

    private Form21c() {
    }

    public int codeSize() {
        return 2;
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
                CstInsn cstInsn = (CstInsn) dalvInsn2;
                int index = cstInsn.getIndex();
                Constant constant = cstInsn.getConstant();
                if (unsignedFitsInShort(index)) {
                    return (constant instanceof CstType) || (constant instanceof CstFieldRef) || (constant instanceof CstString);
                }
            }
        }
        return false;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        write(annotatedOutput, opcodeUnit(dalvInsn2, dalvInsn2.getRegisters().get(0).getReg()), (short) ((CstInsn) dalvInsn2).getIndex());
    }
}
