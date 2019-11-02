package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import java.io.PrintStream;
import java.util.HashMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityControl;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalVariableInfo */
public final class LocalVariableInfo extends MutabilityControl {
    private final RegisterSpecSet[] blockStarts;
    private final RegisterSpecSet emptySet;
    private final HashMap<Insn, RegisterSpec> insnAssignments;
    private final int regCount;

    public LocalVariableInfo(RopMethod ropMethod) {
        RegisterSpecSet registerSpecSet;
        HashMap<Insn, RegisterSpec> hashMap;
        NullPointerException nullPointerException;
        RopMethod ropMethod2 = ropMethod;
        if (ropMethod2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("method == null");
            throw nullPointerException2;
        }
        BasicBlockList blocks = ropMethod2.getBlocks();
        int maxLabel = blocks.getMaxLabel();
        this.regCount = blocks.getRegCount();
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        RegisterSpecSet registerSpecSet3 = new RegisterSpecSet(this.regCount);
        this.emptySet = registerSpecSet2;
        this.blockStarts = new RegisterSpecSet[maxLabel];
        HashMap<Insn, RegisterSpec> hashMap2 = hashMap;
        HashMap<Insn, RegisterSpec> hashMap3 = new HashMap<>(blocks.getInstructionCount());
        this.insnAssignments = hashMap2;
        this.emptySet.setImmutable();
    }

    private RegisterSpecSet getStarts0(int i) {
        IllegalArgumentException illegalArgumentException;
        try {
            return this.blockStarts[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus label");
            throw illegalArgumentException2;
        }
    }

    public void addAssignment(Insn insn, RegisterSpec registerSpec) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        Insn insn2 = insn;
        RegisterSpec registerSpec2 = registerSpec;
        throwIfImmutable();
        if (insn2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("insn == null");
            throw nullPointerException3;
        } else if (registerSpec2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("spec == null");
            throw nullPointerException5;
        } else {
            Object put = this.insnAssignments.put(insn2, registerSpec2);
        }
    }

    public void debugDump() {
        for (int i = 0; i < this.blockStarts.length; i++) {
            if (this.blockStarts[i] != null) {
                if (this.blockStarts[i] == this.emptySet) {
                    PrintStream printf = System.out.printf("%04x: empty set\n", new Object[]{Integer.valueOf(i)});
                } else {
                    PrintStream printf2 = System.out.printf("%04x: %s\n", new Object[]{Integer.valueOf(i), this.blockStarts[i]});
                }
            }
        }
    }

    public RegisterSpec getAssignment(Insn insn) {
        return (RegisterSpec) this.insnAssignments.get(insn);
    }

    public int getAssignmentCount() {
        return this.insnAssignments.size();
    }

    public RegisterSpecSet getStarts(int i) {
        RegisterSpecSet starts0 = getStarts0(i);
        return starts0 != null ? starts0 : this.emptySet;
    }

    public RegisterSpecSet getStarts(BasicBlock basicBlock) {
        return getStarts(basicBlock.getLabel());
    }

    public boolean mergeStarts(int i, RegisterSpecSet registerSpecSet) {
        int i2 = i;
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        RegisterSpecSet starts0 = getStarts0(i2);
        if (starts0 == null) {
            setStarts(i2, registerSpecSet2);
            return true;
        }
        RegisterSpecSet mutableCopy = starts0.mutableCopy();
        if (starts0.size() != 0) {
            mutableCopy.intersect(registerSpecSet2, true);
        } else {
            mutableCopy = registerSpecSet2.mutableCopy();
        }
        if (starts0.equals(mutableCopy)) {
            return false;
        }
        mutableCopy.setImmutable();
        setStarts(i2, mutableCopy);
        return true;
    }

    public RegisterSpecSet mutableCopyOfStarts(int i) {
        RegisterSpecSet registerSpecSet;
        RegisterSpecSet starts0 = getStarts0(i);
        if (starts0 != null) {
            return starts0.mutableCopy();
        }
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        RegisterSpecSet registerSpecSet3 = new RegisterSpecSet(this.regCount);
        return registerSpecSet2;
    }

    public void setStarts(int i, RegisterSpecSet registerSpecSet) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        int i2 = i;
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        throwIfImmutable();
        if (registerSpecSet2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("specs == null");
            throw nullPointerException2;
        }
        try {
            this.blockStarts[i2] = registerSpecSet2;
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus label");
            throw illegalArgumentException2;
        }
    }
}
