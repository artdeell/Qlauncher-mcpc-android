package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.SimpleInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form12x */
public final class Form12x extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form12x form12x;
        Form12x form12x2 = form12x;
        Form12x form12x3 = new Form12x();
        THE_ONE = form12x2;
    }

    private Form12x() {
    }

    public int codeSize() {
        return 1;
    }

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        BitSet bitSet;
        AssertionError assertionError;
        RegisterSpecList registers = dalvInsn.getRegisters();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(2);
        BitSet bitSet4 = bitSet2;
        int reg = registers.get(0).getReg();
        int reg2 = registers.get(1).getReg();
        switch (registers.size()) {
            case 2:
                bitSet4.set(0, unsignedFitsInNibble(reg));
                bitSet4.set(1, unsignedFitsInNibble(reg2));
                return bitSet4;
            case 3:
                if (reg != reg2) {
                    bitSet4.set(0, false);
                    bitSet4.set(1, false);
                } else {
                    boolean unsignedFitsInNibble = unsignedFitsInNibble(reg2);
                    bitSet4.set(0, unsignedFitsInNibble);
                    bitSet4.set(1, unsignedFitsInNibble);
                }
                bitSet4.set(2, unsignedFitsInNibble(registers.get(2).getReg()));
                return bitSet4;
            default:
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
        }
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        RegisterSpecList registers = dalvInsn.getRegisters();
        int size = registers.size();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(registers.get(size - 2).regString()).append(", ").append(registers.get(size - 1).regString()).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z2 = z;
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        RegisterSpec registerSpec;
        RegisterSpec registerSpec2;
        DalvInsn dalvInsn2 = dalvInsn;
        if (!(dalvInsn2 instanceof SimpleInsn)) {
            return false;
        }
        RegisterSpecList registers = dalvInsn2.getRegisters();
        switch (registers.size()) {
            case 2:
                registerSpec = registers.get(0);
                registerSpec2 = registers.get(1);
                break;
            case 3:
                registerSpec = registers.get(1);
                registerSpec2 = registers.get(2);
                if (registerSpec.getReg() != registers.get(0).getReg()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return unsignedFitsInNibble(registerSpec.getReg()) && unsignedFitsInNibble(registerSpec2.getReg());
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList registers = dalvInsn2.getRegisters();
        int size = registers.size();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, makeByte(registers.get(size - 2).getReg(), registers.get(size - 1).getReg())));
    }
}
