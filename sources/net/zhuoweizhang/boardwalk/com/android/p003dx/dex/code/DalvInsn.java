package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.TwoColumnOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.DalvInsn */
public abstract class DalvInsn {
    private int address;
    private final Dop opcode;
    private final SourcePosition position;
    private final RegisterSpecList registers;

    public DalvInsn(Dop dop, SourcePosition sourcePosition, RegisterSpecList registerSpecList) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        Dop dop2 = dop;
        SourcePosition sourcePosition2 = sourcePosition;
        RegisterSpecList registerSpecList2 = registerSpecList;
        if (dop2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("opcode == null");
            throw nullPointerException4;
        } else if (sourcePosition2 == null) {
            NullPointerException nullPointerException6 = nullPointerException2;
            NullPointerException nullPointerException7 = new NullPointerException("position == null");
            throw nullPointerException6;
        } else if (registerSpecList2 == null) {
            NullPointerException nullPointerException8 = nullPointerException;
            NullPointerException nullPointerException9 = new NullPointerException("registers == null");
            throw nullPointerException8;
        } else {
            this.address = -1;
            this.opcode = dop2;
            this.position = sourcePosition2;
            this.registers = registerSpecList2;
        }
    }

    public static SimpleInsn makeMove(SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        SimpleInsn simpleInsn;
        SourcePosition sourcePosition2 = sourcePosition;
        RegisterSpec registerSpec3 = registerSpec;
        RegisterSpec registerSpec4 = registerSpec2;
        boolean z = true;
        if (registerSpec3.getCategory() != 1) {
            z = false;
        }
        boolean isReference = registerSpec3.getType().isReference();
        int reg = registerSpec3.getReg();
        Dop dop = (reg | registerSpec4.getReg()) < 16 ? isReference ? Dops.MOVE_OBJECT : z ? Dops.MOVE : Dops.MOVE_WIDE : reg < 256 ? isReference ? Dops.MOVE_OBJECT_FROM16 : z ? Dops.MOVE_FROM16 : Dops.MOVE_WIDE_FROM16 : isReference ? Dops.MOVE_OBJECT_16 : z ? Dops.MOVE_16 : Dops.MOVE_WIDE_16;
        SimpleInsn simpleInsn2 = simpleInsn;
        SimpleInsn simpleInsn3 = new SimpleInsn(dop, sourcePosition2, RegisterSpecList.make(registerSpec3, registerSpec4));
        return simpleInsn2;
    }

    /* access modifiers changed from: protected */
    public abstract String argString();

    public abstract int codeSize();

    public DalvInsn expandedPrefix(BitSet bitSet) {
        HighRegisterPrefix highRegisterPrefix;
        BitSet bitSet2 = bitSet;
        RegisterSpecList registerSpecList = this.registers;
        boolean z = bitSet2.get(0);
        if (hasResult()) {
            bitSet2.set(0);
        }
        RegisterSpecList subset = registerSpecList.subset(bitSet2);
        if (hasResult()) {
            bitSet2.set(0, z);
        }
        if (subset.size() == 0) {
            return null;
        }
        HighRegisterPrefix highRegisterPrefix2 = highRegisterPrefix;
        HighRegisterPrefix highRegisterPrefix3 = new HighRegisterPrefix(this.position, subset);
        return highRegisterPrefix2;
    }

    public DalvInsn expandedSuffix(BitSet bitSet) {
        BitSet bitSet2 = bitSet;
        if (!hasResult() || bitSet2.get(0)) {
            return null;
        }
        RegisterSpec registerSpec = this.registers.get(0);
        return makeMove(this.position, registerSpec, registerSpec.withReg(0));
    }

    public DalvInsn expandedVersion(BitSet bitSet) {
        return withRegisters(this.registers.withExpandedRegisters(0, hasResult(), bitSet));
    }

    public final int getAddress() {
        RuntimeException runtimeException;
        if (this.address >= 0) {
            return this.address;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("address not yet known");
        throw runtimeException2;
    }

    public DalvInsn getLowRegVersion() {
        return withRegisters(this.registers.withExpandedRegisters(0, hasResult(), null));
    }

    public final int getMinimumRegisterRequirement(BitSet bitSet) {
        BitSet bitSet2 = bitSet;
        boolean hasResult = hasResult();
        int size = this.registers.size();
        int i = (!hasResult || bitSet2.get(0)) ? 0 : this.registers.get(0).getCategory();
        int i2 = 0;
        for (int i3 = hasResult ? 1 : 0; i3 < size; i3++) {
            if (!bitSet2.get(i3)) {
                i2 += this.registers.get(i3).getCategory();
            }
        }
        return Math.max(i2, i);
    }

    public final int getNextAddress() {
        return getAddress() + codeSize();
    }

    public final Dop getOpcode() {
        return this.opcode;
    }

    public final SourcePosition getPosition() {
        return this.position;
    }

    public final RegisterSpecList getRegisters() {
        return this.registers;
    }

    public final boolean hasAddress() {
        return this.address >= 0;
    }

    public final boolean hasResult() {
        return this.opcode.hasResult();
    }

    public final String identifierString() {
        if (this.address == -1) {
            return Hex.m53u4(System.identityHashCode(this));
        }
        return String.format("%04x", new Object[]{Integer.valueOf(this.address)});
    }

    public final String listingString(String str, int i, boolean z) {
        StringBuilder sb;
        String str2 = str;
        int i2 = i;
        String listingString0 = listingString0(z);
        if (listingString0 == null) {
            return null;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append(str2).append(identifierString()).append(": ").toString();
        int length = sb4.length();
        return TwoColumnOutput.toString(sb4, length, LibrariesRepository.MOJANG_MAVEN_REPO, listingString0, i2 == 0 ? listingString0.length() : i2 - length);
    }

    /* access modifiers changed from: protected */
    public abstract String listingString0(boolean z);

    public final void setAddress(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("address < 0");
            throw illegalArgumentException2;
        }
        this.address = i2;
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(identifierString());
        StringBuffer append2 = stringBuffer4.append(' ');
        StringBuffer append3 = stringBuffer4.append(this.position);
        StringBuffer append4 = stringBuffer4.append(": ");
        StringBuffer append5 = stringBuffer4.append(this.opcode.getName());
        boolean z = false;
        if (this.registers.size() != 0) {
            StringBuffer append6 = stringBuffer4.append(this.registers.toHuman(" ", ", ", null));
            z = true;
        }
        String argString = argString();
        if (argString != null) {
            if (z) {
                StringBuffer append7 = stringBuffer4.append(',');
            }
            StringBuffer append8 = stringBuffer4.append(' ');
            StringBuffer append9 = stringBuffer4.append(argString);
        }
        return stringBuffer4.toString();
    }

    public abstract DalvInsn withOpcode(Dop dop);

    public abstract DalvInsn withRegisterOffset(int i);

    public abstract DalvInsn withRegisters(RegisterSpecList registerSpecList);

    public abstract void writeTo(AnnotatedOutput annotatedOutput);
}
