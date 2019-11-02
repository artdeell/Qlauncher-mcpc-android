package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.SimpleInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form11x */
public final class Form11x extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form11x form11x;
        Form11x form11x2 = form11x;
        Form11x form11x3 = new Form11x();
        THE_ONE = form11x2;
    }

    private Form11x() {
    }

    public int codeSize() {
        return 1;
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
        return dalvInsn.getRegisters().get(0).regString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z2 = z;
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        return (dalvInsn2 instanceof SimpleInsn) && registers.size() == 1 && unsignedFitsInByte(registers.get(0).getReg());
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        write(annotatedOutput, opcodeUnit(dalvInsn2, dalvInsn2.getRegisters().get(0).getReg()));
    }
}
