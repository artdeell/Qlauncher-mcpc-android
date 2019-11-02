package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.SimpleInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form23x */
public final class Form23x extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form23x form23x;
        Form23x form23x2 = form23x;
        Form23x form23x3 = new Form23x();
        THE_ONE = form23x2;
    }

    private Form23x() {
    }

    public int codeSize() {
        return 2;
    }

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        BitSet bitSet;
        RegisterSpecList registers = dalvInsn.getRegisters();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(3);
        BitSet bitSet4 = bitSet2;
        bitSet4.set(0, unsignedFitsInByte(registers.get(0).getReg()));
        bitSet4.set(1, unsignedFitsInByte(registers.get(1).getReg()));
        bitSet4.set(2, unsignedFitsInByte(registers.get(2).getReg()));
        return bitSet4;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        RegisterSpecList registers = dalvInsn.getRegisters();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registers.get(0).regString()).append(", ").append(registers.get(1).regString()).append(", ").append(registers.get(2).regString()).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z2 = z;
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        return (dalvInsn2 instanceof SimpleInsn) && registers.size() == 3 && unsignedFitsInByte(registers.get(0).getReg()) && unsignedFitsInByte(registers.get(1).getReg()) && unsignedFitsInByte(registers.get(2).getReg());
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, registers.get(0).getReg()), codeUnit(registers.get(1).getReg(), registers.get(2).getReg()));
    }
}
