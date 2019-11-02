package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form3rc */
public final class Form3rc extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form3rc form3rc;
        Form3rc form3rc2 = form3rc;
        Form3rc form3rc3 = new Form3rc();
        THE_ONE = form3rc2;
    }

    private Form3rc() {
    }

    public int codeSize() {
        return 3;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        DalvInsn dalvInsn2 = dalvInsn;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(regRangeString(dalvInsn2.getRegisters())).append(", ").append(cstString(dalvInsn2)).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        return z ? cstComment(dalvInsn) : LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        if (dalvInsn2 instanceof CstInsn) {
            CstInsn cstInsn = (CstInsn) dalvInsn2;
            int index = cstInsn.getIndex();
            Constant constant = cstInsn.getConstant();
            if (unsignedFitsInShort(index) && ((constant instanceof CstMethodRef) || (constant instanceof CstType))) {
                RegisterSpecList registers = cstInsn.getRegisters();
                int size = registers.size();
                if (registers.size() == 0 || (isRegListSequential(registers) && unsignedFitsInShort(registers.get(0).getReg()) && unsignedFitsInByte(registers.getWordCount()))) {
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
        write(annotatedOutput2, opcodeUnit(dalvInsn2, registers.getWordCount()), (short) ((CstInsn) dalvInsn2).getIndex(), (short) (registers.size() == 0 ? 0 : registers.get(0).getReg()));
    }
}
