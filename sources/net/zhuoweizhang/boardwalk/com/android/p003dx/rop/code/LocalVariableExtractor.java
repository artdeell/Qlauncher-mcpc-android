package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Bits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalVariableExtractor */
public final class LocalVariableExtractor {
    private final BasicBlockList blocks;
    private final RopMethod method;
    private final LocalVariableInfo resultInfo;
    private final int[] workSet;

    private LocalVariableExtractor(RopMethod ropMethod) {
        LocalVariableInfo localVariableInfo;
        NullPointerException nullPointerException;
        RopMethod ropMethod2 = ropMethod;
        if (ropMethod2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("method == null");
            throw nullPointerException2;
        }
        BasicBlockList blocks2 = ropMethod2.getBlocks();
        int maxLabel = blocks2.getMaxLabel();
        this.method = ropMethod2;
        this.blocks = blocks2;
        LocalVariableInfo localVariableInfo2 = localVariableInfo;
        LocalVariableInfo localVariableInfo3 = new LocalVariableInfo(ropMethod2);
        this.resultInfo = localVariableInfo2;
        this.workSet = Bits.makeBitSet(maxLabel);
    }

    private LocalVariableInfo doit() {
        int firstLabel = this.method.getFirstLabel();
        while (true) {
            int i = firstLabel;
            if (i >= 0) {
                Bits.clear(this.workSet, i);
                processBlock(i);
                firstLabel = Bits.findFirst(this.workSet, 0);
            } else {
                this.resultInfo.setImmutable();
                return this.resultInfo;
            }
        }
    }

    public static LocalVariableInfo extract(RopMethod ropMethod) {
        LocalVariableExtractor localVariableExtractor;
        LocalVariableExtractor localVariableExtractor2 = localVariableExtractor;
        LocalVariableExtractor localVariableExtractor3 = new LocalVariableExtractor(ropMethod);
        return localVariableExtractor2.doit();
    }

    private void processBlock(int i) {
        int i2 = i;
        RegisterSpecSet mutableCopyOfStarts = this.resultInfo.mutableCopyOfStarts(i2);
        BasicBlock labelToBlock = this.blocks.labelToBlock(i2);
        InsnList insns = labelToBlock.getInsns();
        int size = insns.size();
        boolean z = labelToBlock.hasExceptionHandlers() && insns.getLast().getResult() != null;
        int i3 = size - 1;
        RegisterSpecSet registerSpecSet = mutableCopyOfStarts;
        for (int i4 = 0; i4 < size; i4++) {
            if (z && i4 == i3) {
                registerSpecSet.setImmutable();
                registerSpecSet = registerSpecSet.mutableCopy();
            }
            Insn insn = insns.get(i4);
            RegisterSpec localAssignment = insn.getLocalAssignment();
            if (localAssignment == null) {
                RegisterSpec result = insn.getResult();
                if (!(result == null || registerSpecSet.get(result.getReg()) == null)) {
                    registerSpecSet.remove(registerSpecSet.get(result.getReg()));
                }
            } else {
                RegisterSpec withSimpleType = localAssignment.withSimpleType();
                if (!withSimpleType.equals(registerSpecSet.get(withSimpleType))) {
                    RegisterSpec localItemToSpec = registerSpecSet.localItemToSpec(withSimpleType.getLocalItem());
                    if (!(localItemToSpec == null || localItemToSpec.getReg() == withSimpleType.getReg())) {
                        registerSpecSet.remove(localItemToSpec);
                    }
                    this.resultInfo.addAssignment(insn, withSimpleType);
                    registerSpecSet.put(withSimpleType);
                }
            }
        }
        registerSpecSet.setImmutable();
        IntList successors = labelToBlock.getSuccessors();
        int size2 = successors.size();
        int primarySuccessor = labelToBlock.getPrimarySuccessor();
        for (int i5 = 0; i5 < size2; i5++) {
            int i6 = successors.get(i5);
            if (this.resultInfo.mergeStarts(i6, i6 == primarySuccessor ? registerSpecSet : mutableCopyOfStarts)) {
                Bits.set(this.workSet, i6);
            }
        }
    }
}
