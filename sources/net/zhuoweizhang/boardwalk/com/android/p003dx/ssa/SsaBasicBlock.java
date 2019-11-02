package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.InsnList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntSet;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock */
public final class SsaBasicBlock {
    public static final Comparator<SsaBasicBlock> LABEL_COMPARATOR;
    private final ArrayList<SsaBasicBlock> domChildren;
    private int index;
    private ArrayList<SsaInsn> insns;
    private IntSet liveIn;
    private IntSet liveOut;
    private int movesFromPhisAtBeginning = 0;
    private int movesFromPhisAtEnd = 0;
    private SsaMethod parent;
    private BitSet predecessors;
    private int primarySuccessor = -1;
    private int reachable = -1;
    /* access modifiers changed from: private */
    public int ropLabel;
    private IntList successorList;
    private BitSet successors;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock$LabelComparator */
    public static final class LabelComparator implements Comparator<SsaBasicBlock> {
        public LabelComparator() {
        }

        public int compare(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
            SsaBasicBlock ssaBasicBlock3 = ssaBasicBlock2;
            int access$000 = ssaBasicBlock.ropLabel;
            int access$0002 = ssaBasicBlock3.ropLabel;
            if (access$000 < access$0002) {
                return -1;
            }
            return access$000 > access$0002 ? 1 : 0;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock$Visitor */
    public interface Visitor {
        void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2);
    }

    static {
        LabelComparator labelComparator;
        LabelComparator labelComparator2 = labelComparator;
        LabelComparator labelComparator3 = new LabelComparator();
        LABEL_COMPARATOR = labelComparator2;
    }

    public SsaBasicBlock(int i, int i2, SsaMethod ssaMethod) {
        ArrayList<SsaInsn> arrayList;
        BitSet bitSet;
        BitSet bitSet2;
        IntList intList;
        ArrayList<SsaBasicBlock> arrayList2;
        int i3 = i;
        int i4 = i2;
        SsaMethod ssaMethod2 = ssaMethod;
        this.parent = ssaMethod2;
        this.index = i3;
        ArrayList<SsaInsn> arrayList3 = arrayList;
        ArrayList<SsaInsn> arrayList4 = new ArrayList<>();
        this.insns = arrayList3;
        this.ropLabel = i4;
        BitSet bitSet3 = bitSet;
        BitSet bitSet4 = new BitSet(ssaMethod2.getBlocks().size());
        this.predecessors = bitSet3;
        BitSet bitSet5 = bitSet2;
        BitSet bitSet6 = new BitSet(ssaMethod2.getBlocks().size());
        this.successors = bitSet5;
        IntList intList2 = intList;
        IntList intList3 = new IntList();
        this.successorList = intList2;
        ArrayList<SsaBasicBlock> arrayList5 = arrayList2;
        ArrayList<SsaBasicBlock> arrayList6 = new ArrayList<>();
        this.domChildren = arrayList5;
    }

    private static boolean checkRegUsed(BitSet bitSet, RegisterSpec registerSpec) {
        BitSet bitSet2 = bitSet;
        RegisterSpec registerSpec2 = registerSpec;
        int reg = registerSpec2.getReg();
        return bitSet2.get(reg) || (registerSpec2.getCategory() == 2 && bitSet2.get(reg + 1));
    }

    private int getCountPhiInsns() {
        int size = this.insns.size();
        int i = 0;
        while (i < size && (((SsaInsn) this.insns.get(i)) instanceof PhiInsn)) {
            i++;
        }
        return i;
    }

    public static SsaBasicBlock newFromRop(RopMethod ropMethod, int i, SsaMethod ssaMethod) {
        SsaBasicBlock ssaBasicBlock;
        NormalSsaInsn normalSsaInsn;
        RopMethod ropMethod2 = ropMethod;
        int i2 = i;
        SsaMethod ssaMethod2 = ssaMethod;
        BasicBlockList blocks = ropMethod2.getBlocks();
        BasicBlock basicBlock = blocks.get(i2);
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        SsaBasicBlock ssaBasicBlock3 = new SsaBasicBlock(i2, basicBlock.getLabel(), ssaMethod2);
        SsaBasicBlock ssaBasicBlock4 = ssaBasicBlock2;
        InsnList insns2 = basicBlock.getInsns();
        ssaBasicBlock4.insns.ensureCapacity(insns2.size());
        int size = insns2.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<SsaInsn> arrayList = ssaBasicBlock4.insns;
            NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
            NormalSsaInsn normalSsaInsn3 = new NormalSsaInsn(insns2.get(i3), ssaBasicBlock4);
            boolean add = arrayList.add(normalSsaInsn2);
        }
        ssaBasicBlock4.predecessors = SsaMethod.bitSetFromLabelList(blocks, ropMethod2.labelToPredecessors(basicBlock.getLabel()));
        ssaBasicBlock4.successors = SsaMethod.bitSetFromLabelList(blocks, basicBlock.getSuccessors());
        ssaBasicBlock4.successorList = SsaMethod.indexListFromLabelList(blocks, basicBlock.getSuccessors());
        if (ssaBasicBlock4.successorList.size() != 0) {
            int primarySuccessor2 = basicBlock.getPrimarySuccessor();
            ssaBasicBlock4.primarySuccessor = primarySuccessor2 < 0 ? -1 : blocks.indexOfLabel(primarySuccessor2);
        }
        return ssaBasicBlock4;
    }

    private void scheduleUseBeforeAssigned(List<SsaInsn> list) {
        BitSet bitSet;
        BitSet bitSet2;
        int i;
        int i2;
        SsaInsn ssaInsn;
        NormalSsaInsn normalSsaInsn;
        PlainInsn plainInsn;
        NormalSsaInsn normalSsaInsn2;
        PlainInsn plainInsn2;
        int i3;
        List<SsaInsn> list2 = list;
        BitSet bitSet3 = bitSet;
        BitSet bitSet4 = new BitSet(this.parent.getRegCount());
        BitSet bitSet5 = bitSet3;
        BitSet bitSet6 = bitSet2;
        BitSet bitSet7 = new BitSet(this.parent.getRegCount());
        BitSet bitSet8 = bitSet6;
        int size = list2.size();
        int i4 = 0;
        while (i4 < size) {
            for (int i5 = i4; i5 < size; i5++) {
                setRegsUsed(bitSet5, ((SsaInsn) list2.get(i5)).getSources().get(0));
                setRegsUsed(bitSet8, ((SsaInsn) list2.get(i5)).getResult());
            }
            int i6 = i4;
            int i7 = i4;
            while (true) {
                i = i7;
                if (i6 >= size) {
                    break;
                }
                if (!checkRegUsed(bitSet5, ((SsaInsn) list2.get(i6)).getResult())) {
                    i3 = i + 1;
                    Collections.swap(list2, i6, i);
                } else {
                    i3 = i;
                }
                i6++;
                i7 = i3;
            }
            if (i4 == i) {
                int i8 = i;
                while (true) {
                    if (i8 >= size) {
                        ssaInsn = null;
                        break;
                    }
                    ssaInsn = (SsaInsn) list2.get(i8);
                    if (checkRegUsed(bitSet5, ssaInsn.getResult()) && checkRegUsed(bitSet8, ssaInsn.getSources().get(0))) {
                        Collections.swap(list2, i, i8);
                        break;
                    }
                    i8++;
                }
                RegisterSpec result = ssaInsn.getResult();
                RegisterSpec withReg = result.withReg(this.parent.borrowSpareRegister(result.getCategory()));
                NormalSsaInsn normalSsaInsn3 = normalSsaInsn;
                PlainInsn plainInsn3 = plainInsn;
                PlainInsn plainInsn4 = new PlainInsn(Rops.opMove(result.getType()), SourcePosition.NO_INFO, withReg, ssaInsn.getSources());
                NormalSsaInsn normalSsaInsn4 = new NormalSsaInsn(plainInsn3, this);
                int i9 = i + 1;
                list2.add(i, normalSsaInsn3);
                List<SsaInsn> list3 = list2;
                int i10 = i9;
                NormalSsaInsn normalSsaInsn5 = normalSsaInsn2;
                PlainInsn plainInsn5 = plainInsn2;
                PlainInsn plainInsn6 = new PlainInsn(Rops.opMove(result.getType()), SourcePosition.NO_INFO, result, RegisterSpecList.make(withReg));
                NormalSsaInsn normalSsaInsn6 = new NormalSsaInsn(plainInsn5, this);
                Object obj = list3.set(i10, normalSsaInsn5);
                i2 = list2.size();
                i = i9;
            } else {
                i2 = size;
            }
            bitSet5.clear();
            bitSet8.clear();
            i4 = i;
            size = i2;
        }
    }

    private static void setRegsUsed(BitSet bitSet, RegisterSpec registerSpec) {
        BitSet bitSet2 = bitSet;
        RegisterSpec registerSpec2 = registerSpec;
        bitSet2.set(registerSpec2.getReg());
        if (registerSpec2.getCategory() > 1) {
            bitSet2.set(1 + registerSpec2.getReg());
        }
    }

    public void addDomChild(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        boolean add = this.domChildren.add(ssaBasicBlock2);
    }

    public void addInsnToHead(Insn insn) {
        SsaInsn makeFromRop = SsaInsn.makeFromRop(insn, this);
        this.insns.add(getCountPhiInsns(), makeFromRop);
        this.parent.onInsnAdded(makeFromRop);
    }

    public void addLiveIn(int i) {
        int i2 = i;
        if (this.liveIn == null) {
            this.liveIn = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        this.liveIn.add(i2);
    }

    public void addLiveOut(int i) {
        int i2 = i;
        if (this.liveOut == null) {
            this.liveOut = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        this.liveOut.add(i2);
    }

    public void addMoveToBeginning(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        NormalSsaInsn normalSsaInsn;
        PlainInsn plainInsn;
        RegisterSpec registerSpec3 = registerSpec;
        RegisterSpec registerSpec4 = registerSpec2;
        if (registerSpec3.getReg() != registerSpec4.getReg()) {
            NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
            PlainInsn plainInsn2 = plainInsn;
            PlainInsn plainInsn3 = new PlainInsn(Rops.opMove(registerSpec3.getType()), SourcePosition.NO_INFO, registerSpec3, RegisterSpecList.make(registerSpec4));
            NormalSsaInsn normalSsaInsn3 = new NormalSsaInsn(plainInsn2, this);
            this.insns.add(getCountPhiInsns(), normalSsaInsn2);
            this.movesFromPhisAtBeginning = 1 + this.movesFromPhisAtBeginning;
        }
    }

    public void addMoveToEnd(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        NormalSsaInsn normalSsaInsn;
        PlainInsn plainInsn;
        RegisterSpec registerSpec3 = registerSpec;
        RegisterSpec registerSpec4 = registerSpec2;
        if (registerSpec3.getReg() != registerSpec4.getReg()) {
            NormalSsaInsn normalSsaInsn2 = (NormalSsaInsn) this.insns.get(-1 + this.insns.size());
            if (normalSsaInsn2.getResult() != null || normalSsaInsn2.getSources().size() > 0) {
                int nextSetBit = this.successors.nextSetBit(0);
                while (true) {
                    int i = nextSetBit;
                    if (i >= 0) {
                        ((SsaBasicBlock) this.parent.getBlocks().get(i)).addMoveToBeginning(registerSpec3, registerSpec4);
                        nextSetBit = this.successors.nextSetBit(i + 1);
                    } else {
                        return;
                    }
                }
            } else {
                NormalSsaInsn normalSsaInsn3 = normalSsaInsn;
                PlainInsn plainInsn2 = plainInsn;
                PlainInsn plainInsn3 = new PlainInsn(Rops.opMove(registerSpec3.getType()), SourcePosition.NO_INFO, registerSpec3, RegisterSpecList.make(registerSpec4));
                NormalSsaInsn normalSsaInsn4 = new NormalSsaInsn(plainInsn2, this);
                this.insns.add(-1 + this.insns.size(), normalSsaInsn3);
                this.movesFromPhisAtEnd = 1 + this.movesFromPhisAtEnd;
            }
        }
    }

    public void addPhiInsnForReg(int i) {
        PhiInsn phiInsn;
        int i2 = i;
        ArrayList<SsaInsn> arrayList = this.insns;
        PhiInsn phiInsn2 = phiInsn;
        PhiInsn phiInsn3 = new PhiInsn(i2, this);
        arrayList.add(0, phiInsn2);
    }

    public void addPhiInsnForReg(RegisterSpec registerSpec) {
        PhiInsn phiInsn;
        RegisterSpec registerSpec2 = registerSpec;
        ArrayList<SsaInsn> arrayList = this.insns;
        PhiInsn phiInsn2 = phiInsn;
        PhiInsn phiInsn3 = new PhiInsn(registerSpec2, this);
        arrayList.add(0, phiInsn2);
    }

    public void exitBlockFixup(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        if (this != ssaBasicBlock2 && this.successorList.size() == 0) {
            this.successors.set(ssaBasicBlock2.index);
            this.successorList.add(ssaBasicBlock2.index);
            this.primarySuccessor = ssaBasicBlock2.index;
            ssaBasicBlock2.predecessors.set(this.index);
        }
    }

    public void forEachInsn(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor visitor) {
        net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor visitor2 = visitor;
        int size = this.insns.size();
        for (int i = 0; i < size; i++) {
            ((SsaInsn) this.insns.get(i)).accept(visitor2);
        }
    }

    public void forEachPhiInsn(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.PhiInsn.Visitor visitor) {
        net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.PhiInsn.Visitor visitor2 = visitor;
        int size = this.insns.size();
        int i = 0;
        while (i < size) {
            SsaInsn ssaInsn = (SsaInsn) this.insns.get(i);
            if (ssaInsn instanceof PhiInsn) {
                visitor2.visitPhiInsn((PhiInsn) ssaInsn);
                i++;
            } else {
                return;
            }
        }
    }

    public ArrayList<SsaBasicBlock> getDomChildren() {
        return this.domChildren;
    }

    public int getIndex() {
        return this.index;
    }

    public ArrayList<SsaInsn> getInsns() {
        return this.insns;
    }

    public IntSet getLiveInRegs() {
        if (this.liveIn == null) {
            this.liveIn = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        return this.liveIn;
    }

    public IntSet getLiveOutRegs() {
        if (this.liveOut == null) {
            this.liveOut = SetFactory.makeLivenessSet(this.parent.getRegCount());
        }
        return this.liveOut;
    }

    public SsaMethod getParent() {
        return this.parent;
    }

    public List<SsaInsn> getPhiInsns() {
        return this.insns.subList(0, getCountPhiInsns());
    }

    public BitSet getPredecessors() {
        return this.predecessors;
    }

    public SsaBasicBlock getPrimarySuccessor() {
        if (this.primarySuccessor < 0) {
            return null;
        }
        return (SsaBasicBlock) this.parent.getBlocks().get(this.primarySuccessor);
    }

    public int getPrimarySuccessorIndex() {
        return this.primarySuccessor;
    }

    public int getPrimarySuccessorRopLabel() {
        return this.parent.blockIndexToRopLabel(this.primarySuccessor);
    }

    public int getRopLabel() {
        return this.ropLabel;
    }

    public String getRopLabelString() {
        return Hex.m51u2(this.ropLabel);
    }

    public IntList getRopLabelSuccessorList() {
        IntList intList;
        IntList intList2 = intList;
        IntList intList3 = new IntList(this.successorList.size());
        IntList intList4 = intList2;
        int size = this.successorList.size();
        for (int i = 0; i < size; i++) {
            intList4.add(this.parent.blockIndexToRopLabel(this.successorList.get(i)));
        }
        return intList4;
    }

    public IntList getSuccessorList() {
        return this.successorList;
    }

    public BitSet getSuccessors() {
        return this.successors;
    }

    public SsaBasicBlock insertNewPredecessor() {
        BitSet bitSet;
        SsaBasicBlock makeNewGotoBlock = this.parent.makeNewGotoBlock();
        makeNewGotoBlock.predecessors = this.predecessors;
        makeNewGotoBlock.successors.set(this.index);
        makeNewGotoBlock.successorList.add(this.index);
        makeNewGotoBlock.primarySuccessor = this.index;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(this.parent.getBlocks().size());
        this.predecessors = bitSet2;
        this.predecessors.set(makeNewGotoBlock.index);
        int nextSetBit = makeNewGotoBlock.predecessors.nextSetBit(0);
        while (true) {
            int i = nextSetBit;
            if (i < 0) {
                return makeNewGotoBlock;
            }
            ((SsaBasicBlock) this.parent.getBlocks().get(i)).replaceSuccessor(this.index, makeNewGotoBlock.index);
            nextSetBit = makeNewGotoBlock.predecessors.nextSetBit(i + 1);
        }
    }

    public SsaBasicBlock insertNewSuccessor(SsaBasicBlock ssaBasicBlock) {
        RuntimeException runtimeException;
        StringBuilder sb;
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        SsaBasicBlock makeNewGotoBlock = this.parent.makeNewGotoBlock();
        if (!this.successors.get(ssaBasicBlock2.index)) {
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            RuntimeException runtimeException3 = new RuntimeException(sb2.append("Block ").append(ssaBasicBlock2.getRopLabelString()).append(" not successor of ").append(getRopLabelString()).toString());
            throw runtimeException2;
        }
        makeNewGotoBlock.predecessors.set(this.index);
        makeNewGotoBlock.successors.set(ssaBasicBlock2.index);
        makeNewGotoBlock.successorList.add(ssaBasicBlock2.index);
        makeNewGotoBlock.primarySuccessor = ssaBasicBlock2.index;
        for (int size = -1 + this.successorList.size(); size >= 0; size--) {
            if (this.successorList.get(size) == ssaBasicBlock2.index) {
                this.successorList.set(size, makeNewGotoBlock.index);
            }
        }
        if (this.primarySuccessor == ssaBasicBlock2.index) {
            this.primarySuccessor = makeNewGotoBlock.index;
        }
        this.successors.clear(ssaBasicBlock2.index);
        this.successors.set(makeNewGotoBlock.index);
        ssaBasicBlock2.predecessors.set(makeNewGotoBlock.index);
        ssaBasicBlock2.predecessors.set(this.index, this.successors.get(ssaBasicBlock2.index));
        return makeNewGotoBlock;
    }

    public boolean isExitBlock() {
        return this.index == this.parent.getExitBlockIndex();
    }

    public boolean isReachable() {
        if (this.reachable == -1) {
            this.parent.computeReachability();
        }
        return this.reachable == 1;
    }

    public void removeAllPhiInsns() {
        this.insns.subList(0, getCountPhiInsns()).clear();
    }

    public void removeSuccessor(int i) {
        int i2 = i;
        int i3 = 0;
        for (int size = -1 + this.successorList.size(); size >= 0; size--) {
            if (this.successorList.get(size) == i2) {
                i3 = size;
            } else {
                this.primarySuccessor = this.successorList.get(size);
            }
        }
        this.successorList.removeIndex(i3);
        this.successors.clear(i2);
        ((SsaBasicBlock) this.parent.getBlocks().get(i2)).predecessors.clear(this.index);
    }

    public void replaceLastInsn(Insn insn) {
        IllegalArgumentException illegalArgumentException;
        Insn insn2 = insn;
        if (insn2.getOpcode().getBranchingness() == 1) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("last insn must branch");
            throw illegalArgumentException2;
        }
        SsaInsn ssaInsn = (SsaInsn) this.insns.get(-1 + this.insns.size());
        SsaInsn makeFromRop = SsaInsn.makeFromRop(insn2, this);
        Object obj = this.insns.set(-1 + this.insns.size(), makeFromRop);
        this.parent.onInsnRemoved(ssaInsn);
        this.parent.onInsnAdded(makeFromRop);
    }

    public void replaceSuccessor(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (i3 != i4) {
            this.successors.set(i4);
            if (this.primarySuccessor == i3) {
                this.primarySuccessor = i4;
            }
            for (int size = -1 + this.successorList.size(); size >= 0; size--) {
                if (this.successorList.get(size) == i3) {
                    this.successorList.set(size, i4);
                }
            }
            this.successors.clear(i3);
            ((SsaBasicBlock) this.parent.getBlocks().get(i4)).predecessors.set(this.index);
            ((SsaBasicBlock) this.parent.getBlocks().get(i3)).predecessors.clear(this.index);
        }
    }

    public void scheduleMovesFromPhis() {
        RuntimeException runtimeException;
        if (this.movesFromPhisAtBeginning > 1) {
            scheduleUseBeforeAssigned(this.insns.subList(0, this.movesFromPhisAtBeginning));
            if (((SsaInsn) this.insns.get(this.movesFromPhisAtBeginning)).isMoveException()) {
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("Unexpected: moves from phis before move-exception");
                throw runtimeException2;
            }
        }
        if (this.movesFromPhisAtEnd > 1) {
            scheduleUseBeforeAssigned(this.insns.subList(-1 + (this.insns.size() - this.movesFromPhisAtEnd), -1 + this.insns.size()));
        }
        this.parent.returnSpareRegisters();
    }

    public void setReachable(int i) {
        int i2 = i;
        this.reachable = i2;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("{").append(this.index).append(":").append(Hex.m51u2(this.ropLabel)).append('}').toString();
    }
}
