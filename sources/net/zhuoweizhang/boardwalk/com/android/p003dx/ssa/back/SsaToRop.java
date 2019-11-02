package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.InsnList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.BasicRegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.PhiInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.PhiInsn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.RegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.SsaToRop */
public class SsaToRop {
    private static final boolean DEBUG = false;
    private final InterferenceGraph interference;
    private final boolean minimizeRegisters;
    /* access modifiers changed from: private */
    public final SsaMethod ssaMeth;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.SsaToRop$PhiVisitor */
    private static class PhiVisitor implements Visitor {
        private final ArrayList<SsaBasicBlock> blocks;

        public PhiVisitor(ArrayList<SsaBasicBlock> arrayList) {
            this.blocks = arrayList;
        }

        public void visitPhiInsn(PhiInsn phiInsn) {
            PhiInsn phiInsn2 = phiInsn;
            RegisterSpecList sources = phiInsn2.getSources();
            RegisterSpec result = phiInsn2.getResult();
            int size = sources.size();
            for (int i = 0; i < size; i++) {
                ((SsaBasicBlock) this.blocks.get(phiInsn2.predBlockIndexForSourcesIndex(i))).addMoveToEnd(result, sources.get(i));
            }
        }
    }

    private SsaToRop(SsaMethod ssaMethod, boolean z) {
        SsaMethod ssaMethod2 = ssaMethod;
        this.minimizeRegisters = z;
        this.ssaMeth = ssaMethod2;
        this.interference = LivenessAnalyzer.constructInterferenceGraph(ssaMethod2);
    }

    private RopMethod convert() {
        FirstFitLocalCombiningAllocator firstFitLocalCombiningAllocator;
        IdenticalBlockCombiner identicalBlockCombiner;
        RopMethod ropMethod;
        FirstFitLocalCombiningAllocator firstFitLocalCombiningAllocator2 = firstFitLocalCombiningAllocator;
        FirstFitLocalCombiningAllocator firstFitLocalCombiningAllocator3 = new FirstFitLocalCombiningAllocator(this.ssaMeth, this.interference, this.minimizeRegisters);
        FirstFitLocalCombiningAllocator firstFitLocalCombiningAllocator4 = firstFitLocalCombiningAllocator2;
        RegisterMapper allocateRegisters = firstFitLocalCombiningAllocator4.allocateRegisters();
        this.ssaMeth.setBackMode();
        this.ssaMeth.mapRegisters(allocateRegisters);
        removePhiFunctions();
        if (firstFitLocalCombiningAllocator4.wantsParamsMovedHigh()) {
            moveParametersToHighRegisters();
        }
        removeEmptyGotos();
        IdenticalBlockCombiner identicalBlockCombiner2 = identicalBlockCombiner;
        RopMethod ropMethod2 = ropMethod;
        RopMethod ropMethod3 = new RopMethod(convertBasicBlocks(), this.ssaMeth.blockIndexToRopLabel(this.ssaMeth.getEntryBlockIndex()));
        IdenticalBlockCombiner identicalBlockCombiner3 = new IdenticalBlockCombiner(ropMethod2);
        return identicalBlockCombiner2.process();
    }

    private BasicBlock convertBasicBlock(SsaBasicBlock ssaBasicBlock) {
        IntList intList;
        BasicBlock basicBlock;
        RuntimeException runtimeException;
        StringBuilder sb;
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        int i = -1;
        IntList ropLabelSuccessorList = ssaBasicBlock2.getRopLabelSuccessorList();
        int primarySuccessorRopLabel = ssaBasicBlock2.getPrimarySuccessorRopLabel();
        SsaBasicBlock exitBlock = this.ssaMeth.getExitBlock();
        if (!ropLabelSuccessorList.contains(exitBlock == null ? -1 : exitBlock.getRopLabel())) {
            i = primarySuccessorRopLabel;
            intList = ropLabelSuccessorList;
        } else if (ropLabelSuccessorList.size() > 1) {
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            RuntimeException runtimeException3 = new RuntimeException(sb2.append("Exit predecessor must have no other successors").append(Hex.m51u2(ssaBasicBlock2.getRopLabel())).toString());
            throw runtimeException2;
        } else {
            intList = IntList.EMPTY;
            verifyValidExitPredecessor(ssaBasicBlock2);
        }
        intList.setImmutable();
        BasicBlock basicBlock2 = basicBlock;
        BasicBlock basicBlock3 = new BasicBlock(ssaBasicBlock2.getRopLabel(), convertInsns(ssaBasicBlock2.getInsns()), intList, i);
        return basicBlock2;
    }

    private BasicBlockList convertBasicBlocks() {
        BasicBlockList basicBlockList;
        RuntimeException runtimeException;
        int i = 0;
        ArrayList blocks = this.ssaMeth.getBlocks();
        SsaBasicBlock exitBlock = this.ssaMeth.getExitBlock();
        this.ssaMeth.computeReachability();
        BasicBlockList basicBlockList2 = basicBlockList;
        BasicBlockList basicBlockList3 = new BasicBlockList(this.ssaMeth.getCountReachableBlocks() - ((exitBlock == null || !exitBlock.isReachable()) ? 0 : 1));
        BasicBlockList basicBlockList4 = basicBlockList2;
        Iterator it = blocks.iterator();
        while (it.hasNext()) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) it.next();
            if (ssaBasicBlock.isReachable() && ssaBasicBlock != exitBlock) {
                int i2 = i + 1;
                basicBlockList4.set(i, convertBasicBlock(ssaBasicBlock));
                i = i2;
            }
        }
        if (exitBlock == null || exitBlock.getInsns().size() == 0) {
            return basicBlockList4;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("Exit block must have no insns when leaving SSA form");
        throw runtimeException2;
    }

    private InsnList convertInsns(ArrayList<SsaInsn> arrayList) {
        InsnList insnList;
        ArrayList<SsaInsn> arrayList2 = arrayList;
        int size = arrayList2.size();
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList(size);
        InsnList insnList4 = insnList2;
        for (int i = 0; i < size; i++) {
            insnList4.set(i, ((SsaInsn) arrayList2.get(i)).toRopInsn());
        }
        insnList4.setImmutable();
        return insnList4;
    }

    public static RopMethod convertToRopMethod(SsaMethod ssaMethod, boolean z) {
        SsaToRop ssaToRop;
        SsaToRop ssaToRop2 = ssaToRop;
        SsaToRop ssaToRop3 = new SsaToRop(ssaMethod, z);
        return ssaToRop2.convert();
    }

    private void moveParametersToHighRegisters() {
        BasicRegisterMapper basicRegisterMapper;
        int paramWidth = this.ssaMeth.getParamWidth();
        BasicRegisterMapper basicRegisterMapper2 = basicRegisterMapper;
        BasicRegisterMapper basicRegisterMapper3 = new BasicRegisterMapper(this.ssaMeth.getRegCount());
        BasicRegisterMapper basicRegisterMapper4 = basicRegisterMapper2;
        int regCount = this.ssaMeth.getRegCount();
        for (int i = 0; i < regCount; i++) {
            if (i < paramWidth) {
                basicRegisterMapper4.addMapping(i, i + (regCount - paramWidth), 1);
            } else {
                basicRegisterMapper4.addMapping(i, i - paramWidth, 1);
            }
        }
        this.ssaMeth.mapRegisters(basicRegisterMapper4);
    }

    private void removeEmptyGotos() {
        C07291 r8;
        ArrayList blocks = this.ssaMeth.getBlocks();
        SsaMethod ssaMethod = this.ssaMeth;
        C07291 r4 = r8;
        final ArrayList arrayList = blocks;
        C07291 r5 = new SsaBasicBlock.Visitor(this) {
            final /* synthetic */ SsaToRop this$0;

            {
                ArrayList arrayList = r7;
                this.this$0 = r6;
            }

            public void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
                SsaBasicBlock ssaBasicBlock3 = ssaBasicBlock;
                SsaBasicBlock ssaBasicBlock4 = ssaBasicBlock2;
                ArrayList insns = ssaBasicBlock3.getInsns();
                if (insns.size() == 1 && ((SsaInsn) insns.get(0)).getOpcode() == Rops.GOTO) {
                    BitSet bitSet = (BitSet) ssaBasicBlock3.getPredecessors().clone();
                    int nextSetBit = bitSet.nextSetBit(0);
                    while (true) {
                        int i = nextSetBit;
                        if (i >= 0) {
                            ((SsaBasicBlock) arrayList.get(i)).replaceSuccessor(ssaBasicBlock3.getIndex(), ssaBasicBlock3.getPrimarySuccessorIndex());
                            nextSetBit = bitSet.nextSetBit(i + 1);
                        } else {
                            return;
                        }
                    }
                }
            }
        };
        ssaMethod.forEachBlockDepthFirst(false, r4);
    }

    private void removePhiFunctions() {
        PhiVisitor phiVisitor;
        ArrayList blocks = this.ssaMeth.getBlocks();
        Iterator it = blocks.iterator();
        while (it.hasNext()) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) it.next();
            SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
            PhiVisitor phiVisitor2 = phiVisitor;
            PhiVisitor phiVisitor3 = new PhiVisitor(blocks);
            ssaBasicBlock2.forEachPhiInsn(phiVisitor2);
            ssaBasicBlock.removeAllPhiInsns();
        }
        Iterator it2 = blocks.iterator();
        while (it2.hasNext()) {
            ((SsaBasicBlock) it2.next()).scheduleMovesFromPhis();
        }
    }

    private void verifyValidExitPredecessor(SsaBasicBlock ssaBasicBlock) {
        RuntimeException runtimeException;
        ArrayList insns = ssaBasicBlock.getInsns();
        Rop opcode = ((SsaInsn) insns.get(-1 + insns.size())).getOpcode();
        if (opcode.getBranchingness() != 2 && opcode != Rops.THROW) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Exit predecessor must end in valid exit statement.");
            throw runtimeException2;
        }
    }

    public int[] getRegistersByFrequency() {
        C07302 r10;
        int regCount = this.ssaMeth.getRegCount();
        Integer[] numArr = new Integer[regCount];
        for (int i = 0; i < regCount; i++) {
            numArr[i] = Integer.valueOf(i);
        }
        Integer[] numArr2 = numArr;
        C07302 r7 = r10;
        C07302 r8 = new Comparator<Integer>(this) {
            final /* synthetic */ SsaToRop this$0;

            {
                this.this$0 = r5;
            }

            public int compare(Integer num, Integer num2) {
                return this.this$0.ssaMeth.getUseListForRegister(num2.intValue()).size() - this.this$0.ssaMeth.getUseListForRegister(num.intValue()).size();
            }
        };
        Arrays.sort(numArr2, r7);
        int[] iArr = new int[regCount];
        for (int i2 = 0; i2 < regCount; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }
}
