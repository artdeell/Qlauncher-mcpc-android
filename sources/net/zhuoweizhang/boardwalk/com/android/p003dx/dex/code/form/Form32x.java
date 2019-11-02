package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.SimpleInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form32x */
public final class Form32x extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form32x form32x;
        Form32x form32x2 = form32x;
        Form32x form32x3 = new Form32x();
        THE_ONE = form32x2;
    }

    private Form32x() {
    }

    public int codeSize() {
        return 3;
    }

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        BitSet bitSet;
        RegisterSpecList registers = dalvInsn.getRegisters();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(2);
        BitSet bitSet4 = bitSet2;
        bitSet4.set(0, unsignedFitsInShort(registers.get(0).getReg()));
        bitSet4.set(1, unsignedFitsInShort(registers.get(1).getReg()));
        return bitSet4;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        RegisterSpecList registers = dalvInsn.getRegisters();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registers.get(0).regString()).append(", ").append(registers.get(1).regString()).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z2 = z;
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        return (dalvInsn2 instanceof SimpleInsn) && registers.size() == 2 && unsignedFitsInShort(registers.get(0).getReg()) && unsignedFitsInShort(registers.get(1).getReg());
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, 0), (short) registers.get(0).getReg(), (short) registers.get(1).getReg());
    }
}
