package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.IdenticalBlockCombiner */
public class IdenticalBlockCombiner {
    private final BasicBlockList blocks = this.ropMethod.getBlocks();
    private final BasicBlockList newBlocks = this.blocks.getMutableCopy();
    private final RopMethod ropMethod;

    public IdenticalBlockCombiner(RopMethod ropMethod2) {
        this.ropMethod = ropMethod2;
    }

    private void combineBlocks(int i, IntList intList) {
        int i2 = i;
        IntList intList2 = intList;
        int size = intList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = intList2.get(i3);
            IntList labelToPredecessors = this.ropMethod.labelToPredecessors(this.blocks.labelToBlock(i4).getLabel());
            int size2 = labelToPredecessors.size();
            for (int i5 = 0; i5 < size2; i5++) {
                replaceSucc(this.newBlocks.labelToBlock(labelToPredecessors.get(i5)), i4, i2);
            }
        }
    }

    private static boolean compareInsns(BasicBlock basicBlock, BasicBlock basicBlock2) {
        return basicBlock.getInsns().contentEquals(basicBlock2.getInsns());
    }

    private void replaceSucc(BasicBlock basicBlock, int i, int i2) {
        BasicBlock basicBlock2;
        BasicBlock basicBlock3 = basicBlock;
        int i3 = i;
        int i4 = i2;
        IntList mutableCopy = basicBlock3.getSuccessors().mutableCopy();
        mutableCopy.set(mutableCopy.indexOf(i3), i4);
        int primarySuccessor = basicBlock3.getPrimarySuccessor();
        if (primarySuccessor != i3) {
            i4 = primarySuccessor;
        }
        mutableCopy.setImmutable();
        BasicBlock basicBlock4 = basicBlock2;
        BasicBlock basicBlock5 = new BasicBlock(basicBlock3.getLabel(), basicBlock3.getInsns(), mutableCopy, i4);
        this.newBlocks.set(this.newBlocks.indexOfLabel(basicBlock3.getLabel()), basicBlock4);
    }

    public RopMethod process() {
        BitSet bitSet;
        RopMethod ropMethod2;
        IntList intList;
        int size = this.blocks.size();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(this.blocks.getMaxLabel());
        BitSet bitSet4 = bitSet2;
        for (int i = 0; i < size; i++) {
            BasicBlock basicBlock = this.blocks.get(i);
            if (!bitSet4.get(basicBlock.getLabel())) {
                IntList labelToPredecessors = this.ropMethod.labelToPredecessors(basicBlock.getLabel());
                int size2 = labelToPredecessors.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    int i3 = labelToPredecessors.get(i2);
                    BasicBlock labelToBlock = this.blocks.labelToBlock(i3);
                    if (!bitSet4.get(i3) && labelToBlock.getSuccessors().size() <= 1 && labelToBlock.getFirstInsn().getOpcode().getOpcode() != 55) {
                        IntList intList2 = intList;
                        IntList intList3 = new IntList();
                        IntList intList4 = intList2;
                        for (int i4 = i2 + 1; i4 < size2; i4++) {
                            int i5 = labelToPredecessors.get(i4);
                            BasicBlock labelToBlock2 = this.blocks.labelToBlock(i5);
                            if (labelToBlock2.getSuccessors().size() == 1 && compareInsns(labelToBlock, labelToBlock2)) {
                                intList4.add(i5);
                                bitSet4.set(i5);
                            }
                        }
                        combineBlocks(i3, intList4);
                    }
                }
            }
        }
        for (int i6 = size - 1; i6 >= 0; i6--) {
            if (bitSet4.get(this.newBlocks.get(i6).getLabel())) {
                this.newBlocks.set(i6, null);
            }
        }
        this.newBlocks.shrinkToFit();
        this.newBlocks.setImmutable();
        RopMethod ropMethod3 = ropMethod2;
        RopMethod ropMethod4 = new RopMethod(this.newBlocks, this.ropMethod.getFirstLabel());
        return ropMethod3;
    }
}
