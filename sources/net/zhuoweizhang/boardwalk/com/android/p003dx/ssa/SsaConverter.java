package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.DomFront.DomInfo;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntIterator;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaConverter */
public class SsaConverter {
    public static final boolean DEBUG = false;

    public SsaConverter() {
    }

    public static SsaMethod convertToSsaMethod(RopMethod ropMethod, int i, boolean z) {
        SsaRenamer ssaRenamer;
        SsaMethod newFromRopMethod = SsaMethod.newFromRopMethod(ropMethod, i, z);
        edgeSplit(newFromRopMethod);
        placePhiFunctions(newFromRopMethod, LocalVariableExtractor.extract(newFromRopMethod), 0);
        SsaRenamer ssaRenamer2 = ssaRenamer;
        SsaRenamer ssaRenamer3 = new SsaRenamer(newFromRopMethod);
        ssaRenamer2.run();
        newFromRopMethod.makeExitBlock();
        return newFromRopMethod;
    }

    private static void edgeSplit(SsaMethod ssaMethod) {
        SsaMethod ssaMethod2 = ssaMethod;
        edgeSplitPredecessors(ssaMethod2);
        edgeSplitMoveExceptionsAndResults(ssaMethod2);
        edgeSplitSuccessors(ssaMethod2);
    }

    private static void edgeSplitMoveExceptionsAndResults(SsaMethod ssaMethod) {
        ArrayList blocks = ssaMethod.getBlocks();
        for (int size = -1 + blocks.size(); size >= 0; size--) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) blocks.get(size);
            if (!ssaBasicBlock.isExitBlock() && ssaBasicBlock.getPredecessors().cardinality() > 1 && ((SsaInsn) ssaBasicBlock.getInsns().get(0)).isMoveException()) {
                BitSet bitSet = (BitSet) ssaBasicBlock.getPredecessors().clone();
                int nextSetBit = bitSet.nextSetBit(0);
                while (true) {
                    int i = nextSetBit;
                    if (i < 0) {
                        break;
                    }
                    ((SsaBasicBlock) blocks.get(i)).insertNewSuccessor(ssaBasicBlock).getInsns().add(0, ((SsaInsn) ssaBasicBlock.getInsns().get(0)).clone());
                    nextSetBit = bitSet.nextSetBit(i + 1);
                }
                Object remove = ssaBasicBlock.getInsns().remove(0);
            }
        }
    }

    private static void edgeSplitPredecessors(SsaMethod ssaMethod) {
        ArrayList blocks = ssaMethod.getBlocks();
        for (int size = -1 + blocks.size(); size >= 0; size--) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) blocks.get(size);
            if (nodeNeedsUniquePredecessor(ssaBasicBlock)) {
                SsaBasicBlock insertNewPredecessor = ssaBasicBlock.insertNewPredecessor();
            }
        }
    }

    private static void edgeSplitSuccessors(SsaMethod ssaMethod) {
        ArrayList blocks = ssaMethod.getBlocks();
        for (int size = -1 + blocks.size(); size >= 0; size--) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) blocks.get(size);
            BitSet bitSet = (BitSet) ssaBasicBlock.getSuccessors().clone();
            int nextSetBit = bitSet.nextSetBit(0);
            while (true) {
                int i = nextSetBit;
                if (i < 0) {
                    break;
                }
                SsaBasicBlock ssaBasicBlock2 = (SsaBasicBlock) blocks.get(i);
                if (needsNewSuccessor(ssaBasicBlock, ssaBasicBlock2)) {
                    SsaBasicBlock insertNewSuccessor = ssaBasicBlock.insertNewSuccessor(ssaBasicBlock2);
                }
                nextSetBit = bitSet.nextSetBit(i + 1);
            }
        }
    }

    private static boolean needsNewSuccessor(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
        SsaBasicBlock ssaBasicBlock3 = ssaBasicBlock2;
        ArrayList insns = ssaBasicBlock.getInsns();
        SsaInsn ssaInsn = (SsaInsn) insns.get(-1 + insns.size());
        return (ssaInsn.getResult() != null || ssaInsn.getSources().size() > 0) && ssaBasicBlock3.getPredecessors().cardinality() > 1;
    }

    private static boolean nodeNeedsUniquePredecessor(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        return ssaBasicBlock2.getPredecessors().cardinality() > 1 && ssaBasicBlock2.getSuccessors().cardinality() > 1;
    }

    private static void placePhiFunctions(SsaMethod ssaMethod, LocalVariableInfo localVariableInfo, int i) {
        DomFront domFront;
        BitSet bitSet;
        BitSet bitSet2;
        SsaMethod ssaMethod2 = ssaMethod;
        LocalVariableInfo localVariableInfo2 = localVariableInfo;
        int i2 = i;
        ArrayList blocks = ssaMethod2.getBlocks();
        int size = blocks.size();
        int regCount = ssaMethod2.getRegCount() - i2;
        DomFront domFront2 = domFront;
        DomFront domFront3 = new DomFront(ssaMethod2);
        DomInfo[] run = domFront2.run();
        BitSet[] bitSetArr = new BitSet[regCount];
        BitSet[] bitSetArr2 = new BitSet[regCount];
        for (int i3 = 0; i3 < regCount; i3++) {
            BitSet[] bitSetArr3 = bitSetArr;
            int i4 = i3;
            BitSet bitSet3 = bitSet;
            BitSet bitSet4 = new BitSet(size);
            bitSetArr3[i4] = bitSet3;
            BitSet[] bitSetArr4 = bitSetArr2;
            int i5 = i3;
            BitSet bitSet5 = bitSet2;
            BitSet bitSet6 = new BitSet(size);
            bitSetArr4[i5] = bitSet5;
        }
        int size2 = blocks.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Iterator it = ((SsaBasicBlock) blocks.get(i6)).getInsns().iterator();
            while (it.hasNext()) {
                RegisterSpec result = ((SsaInsn) it.next()).getResult();
                if (result != null && result.getReg() - i2 >= 0) {
                    bitSetArr[result.getReg() - i2].set(i6);
                }
            }
        }
        for (int i7 = 0; i7 < regCount; i7++) {
            BitSet bitSet7 = (BitSet) bitSetArr[i7].clone();
            while (true) {
                int nextSetBit = bitSet7.nextSetBit(0);
                if (nextSetBit < 0) {
                    break;
                }
                bitSet7.clear(nextSetBit);
                IntIterator it2 = run[nextSetBit].dominanceFrontiers.iterator();
                while (it2.hasNext()) {
                    int next = it2.next();
                    if (!bitSetArr2[i7].get(next)) {
                        bitSetArr2[i7].set(next);
                        int i8 = i7 + i2;
                        RegisterSpec registerSpec = localVariableInfo2.getStarts(next).get(i8);
                        if (registerSpec == null) {
                            ((SsaBasicBlock) blocks.get(next)).addPhiInsnForReg(i8);
                        } else {
                            ((SsaBasicBlock) blocks.get(next)).addPhiInsnForReg(registerSpec);
                        }
                        if (!bitSetArr[i7].get(next)) {
                            bitSet7.set(next);
                        }
                    }
                }
            }
        }
    }

    public static SsaMethod testEdgeSplit(RopMethod ropMethod, int i, boolean z) {
        SsaMethod newFromRopMethod = SsaMethod.newFromRopMethod(ropMethod, i, z);
        edgeSplit(newFromRopMethod);
        return newFromRopMethod;
    }

    public static SsaMethod testPhiPlacement(RopMethod ropMethod, int i, boolean z) {
        SsaMethod newFromRopMethod = SsaMethod.newFromRopMethod(ropMethod, i, z);
        edgeSplit(newFromRopMethod);
        placePhiFunctions(newFromRopMethod, LocalVariableExtractor.extract(newFromRopMethod), 0);
        return newFromRopMethod;
    }

    public static void updateSsaMethod(SsaMethod ssaMethod, int i) {
        SsaRenamer ssaRenamer;
        SsaMethod ssaMethod2 = ssaMethod;
        int i2 = i;
        placePhiFunctions(ssaMethod2, LocalVariableExtractor.extract(ssaMethod2), i2);
        SsaRenamer ssaRenamer2 = ssaRenamer;
        SsaRenamer ssaRenamer3 = new SsaRenamer(ssaMethod2, i2);
        ssaRenamer2.run();
    }
}
