package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.TargetInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form21t */
public final class Form21t extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form21t form21t;
        Form21t form21t2 = form21t;
        Form21t form21t3 = new Form21t();
        THE_ONE = form21t2;
    }

    private Form21t() {
    }

    public boolean branchFits(TargetInsn targetInsn) {
        int targetOffset = targetInsn.getTargetOffset();
        return targetOffset != 0 && signedFitsInShort(targetOffset);
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
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registers.get(0).regString()).append(", ").append(branchString(dalvInsn2)).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        boolean z2 = z;
        return branchComment(dalvInsn);
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z = true;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        if (!(dalvInsn2 instanceof TargetInsn) || registers.size() != 1 || !unsignedFitsInByte(registers.get(0).getReg())) {
            z = false;
        } else {
            TargetInsn targetInsn = (TargetInsn) dalvInsn2;
            if (targetInsn.hasTargetOffset()) {
                return branchFits(targetInsn);
            }
        }
        return z;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        write(annotatedOutput, opcodeUnit(dalvInsn2, dalvInsn2.getRegisters().get(0).getReg()), (short) ((TargetInsn) dalvInsn2).getTargetOffset());
    }
}
