package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.LabeledItem;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlock */
public final class BasicBlock implements LabeledItem {
    private final InsnList insns;
    private final int label;
    private final int primarySuccessor;
    private final IntList successors;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlock$Visitor */
    public interface Visitor {
        void visitBlock(BasicBlock basicBlock);
    }

    public BasicBlock(int i, InsnList insnList, IntList intList, int i2) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException5;
        IllegalArgumentException illegalArgumentException6;
        int i3 = i;
        InsnList insnList2 = insnList;
        IntList intList2 = intList;
        int i4 = i2;
        if (i3 < 0) {
            IllegalArgumentException illegalArgumentException7 = illegalArgumentException6;
            IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException("label < 0");
            throw illegalArgumentException7;
        }
        try {
            insnList2.throwIfMutable();
            int size = insnList2.size();
            if (size == 0) {
                IllegalArgumentException illegalArgumentException9 = illegalArgumentException5;
                IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("insns.size() == 0");
                throw illegalArgumentException9;
            }
            for (int i5 = size - 2; i5 >= 0; i5--) {
                if (insnList2.get(i5).getOpcode().getBranchingness() != 1) {
                    IllegalArgumentException illegalArgumentException11 = illegalArgumentException4;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException(sb3.append("insns[").append(i5).append("] is a ").append("branch or can throw").toString());
                    throw illegalArgumentException11;
                }
            }
            if (insnList2.get(size - 1).getOpcode().getBranchingness() == 1) {
                IllegalArgumentException illegalArgumentException13 = illegalArgumentException3;
                IllegalArgumentException illegalArgumentException14 = new IllegalArgumentException("insns does not end with a branch or throwing instruction");
                throw illegalArgumentException13;
            }
            try {
                intList2.throwIfMutable();
                if (i4 < -1) {
                    IllegalArgumentException illegalArgumentException15 = illegalArgumentException2;
                    IllegalArgumentException illegalArgumentException16 = new IllegalArgumentException("primarySuccessor < -1");
                    throw illegalArgumentException15;
                } else if (i4 < 0 || intList2.contains(i4)) {
                    this.label = i3;
                    this.insns = insnList2;
                    this.successors = intList2;
                    this.primarySuccessor = i4;
                } else {
                    IllegalArgumentException illegalArgumentException17 = illegalArgumentException;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException18 = new IllegalArgumentException(sb5.append("primarySuccessor ").append(i4).append(" not in successors ").append(intList2).toString());
                    throw illegalArgumentException17;
                }
            } catch (NullPointerException e) {
                NullPointerException nullPointerException3 = e;
                NullPointerException nullPointerException4 = nullPointerException2;
                NullPointerException nullPointerException5 = new NullPointerException("successors == null");
                throw nullPointerException4;
            }
        } catch (NullPointerException e2) {
            NullPointerException nullPointerException6 = e2;
            NullPointerException nullPointerException7 = nullPointerException;
            NullPointerException nullPointerException8 = new NullPointerException("insns == null");
            throw nullPointerException7;
        }
    }

    public boolean canThrow() {
        return this.insns.getLast().canThrow();
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public TypeList getExceptionHandlerTypes() {
        return this.insns.getLast().getCatches();
    }

    public Insn getFirstInsn() {
        return this.insns.get(0);
    }

    public InsnList getInsns() {
        return this.insns;
    }

    public int getLabel() {
        return this.label;
    }

    public Insn getLastInsn() {
        return this.insns.getLast();
    }

    public int getPrimarySuccessor() {
        return this.primarySuccessor;
    }

    public int getSecondarySuccessor() {
        UnsupportedOperationException unsupportedOperationException;
        if (this.successors.size() != 2) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("block doesn't have exactly two successors");
            throw unsupportedOperationException2;
        }
        int i = this.successors.get(0);
        if (i == this.primarySuccessor) {
            i = this.successors.get(1);
        }
        return i;
    }

    public IntList getSuccessors() {
        return this.successors;
    }

    public boolean hasExceptionHandlers() {
        return this.insns.getLast().getCatches().size() != 0;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append('{').append(Hex.m51u2(this.label)).append('}').toString();
    }

    public BasicBlock withRegisterOffset(int i) {
        BasicBlock basicBlock;
        BasicBlock basicBlock2 = basicBlock;
        BasicBlock basicBlock3 = new BasicBlock(this.label, this.insns.withRegisterOffset(i), this.successors, this.primarySuccessor);
        return basicBlock2;
    }
}
