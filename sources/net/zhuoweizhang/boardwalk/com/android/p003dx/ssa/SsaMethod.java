package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod */
public final class SsaMethod {
    private boolean backMode = false;
    private ArrayList<SsaBasicBlock> blocks;
    private int borrowedSpareRegisters;
    /* access modifiers changed from: private */
    public SsaInsn[] definitionList;
    private int entryBlockIndex;
    private int exitBlockIndex;
    private final boolean isStatic;
    private int maxLabel;
    private final int paramWidth;
    private int registerCount;
    private int spareRegisterBase;
    private List<SsaInsn>[] unmodifiableUseList;
    /* access modifiers changed from: private */
    public ArrayList<SsaInsn>[] useList;

    private SsaMethod(RopMethod ropMethod, int i, boolean z) {
        RopMethod ropMethod2 = ropMethod;
        boolean z2 = z;
        this.paramWidth = i;
        this.isStatic = z2;
        this.maxLabel = ropMethod2.getBlocks().getMaxLabel();
        this.registerCount = ropMethod2.getBlocks().getRegCount();
        this.spareRegisterBase = this.registerCount;
    }

    static BitSet bitSetFromLabelList(BasicBlockList basicBlockList, IntList intList) {
        BitSet bitSet;
        BasicBlockList basicBlockList2 = basicBlockList;
        IntList intList2 = intList;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(basicBlockList2.size());
        BitSet bitSet4 = bitSet2;
        int size = intList2.size();
        for (int i = 0; i < size; i++) {
            bitSet4.set(basicBlockList2.indexOfLabel(intList2.get(i)));
        }
        return bitSet4;
    }

    private void buildUseList() {
        C07242 r7;
        ArrayList<SsaInsn> arrayList;
        RuntimeException runtimeException;
        if (this.backMode) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("No use list in back mode");
            throw runtimeException2;
        }
        this.useList = new ArrayList[this.registerCount];
        for (int i = 0; i < this.registerCount; i++) {
            ArrayList<SsaInsn>[] arrayListArr = this.useList;
            int i2 = i;
            ArrayList<SsaInsn> arrayList2 = arrayList;
            ArrayList<SsaInsn> arrayList3 = new ArrayList<>();
            arrayListArr[i2] = arrayList2;
        }
        C07242 r4 = r7;
        C07242 r5 = new Visitor(this) {
            final /* synthetic */ SsaMethod this$0;

            {
                this.this$0 = r5;
            }

            private void addToUses(SsaInsn ssaInsn) {
                SsaInsn ssaInsn2 = ssaInsn;
                RegisterSpecList sources = ssaInsn2.getSources();
                int size = sources.size();
                for (int i = 0; i < size; i++) {
                    boolean add = this.this$0.useList[sources.get(i).getReg()].add(ssaInsn2);
                }
            }

            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                addToUses(normalSsaInsn);
            }

            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                addToUses(normalSsaInsn);
            }

            public void visitPhiInsn(PhiInsn phiInsn) {
                addToUses(phiInsn);
            }
        };
        forEachInsn(r4);
        this.unmodifiableUseList = new List[this.registerCount];
        for (int i3 = 0; i3 < this.registerCount; i3++) {
            this.unmodifiableUseList[i3] = Collections.unmodifiableList(this.useList[i3]);
        }
    }

    private void convertRopToSsaBlocks(RopMethod ropMethod) {
        ArrayList<SsaBasicBlock> arrayList;
        RopMethod ropMethod2 = ropMethod;
        int size = ropMethod2.getBlocks().size();
        ArrayList<SsaBasicBlock> arrayList2 = arrayList;
        ArrayList<SsaBasicBlock> arrayList3 = new ArrayList<>(size + 2);
        this.blocks = arrayList2;
        for (int i = 0; i < size; i++) {
            boolean add = this.blocks.add(SsaBasicBlock.newFromRop(ropMethod2, i, this));
        }
        this.entryBlockIndex = ((SsaBasicBlock) this.blocks.get(ropMethod2.getBlocks().indexOfLabel(ropMethod2.getFirstLabel()))).insertNewPredecessor().getIndex();
        this.exitBlockIndex = -1;
    }

    private static SsaInsn getGoto(SsaBasicBlock ssaBasicBlock) {
        NormalSsaInsn normalSsaInsn;
        PlainInsn plainInsn;
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
        PlainInsn plainInsn2 = plainInsn;
        PlainInsn plainInsn3 = new PlainInsn(Rops.GOTO, SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.EMPTY);
        NormalSsaInsn normalSsaInsn3 = new NormalSsaInsn(plainInsn2, ssaBasicBlock2);
        return normalSsaInsn2;
    }

    public static IntList indexListFromLabelList(BasicBlockList basicBlockList, IntList intList) {
        IntList intList2;
        BasicBlockList basicBlockList2 = basicBlockList;
        IntList intList3 = intList;
        IntList intList4 = intList2;
        IntList intList5 = new IntList(intList3.size());
        IntList intList6 = intList4;
        int size = intList3.size();
        for (int i = 0; i < size; i++) {
            intList6.add(basicBlockList2.indexOfLabel(intList3.get(i)));
        }
        return intList6;
    }

    public static SsaMethod newFromRopMethod(RopMethod ropMethod, int i, boolean z) {
        SsaMethod ssaMethod;
        RopMethod ropMethod2 = ropMethod;
        SsaMethod ssaMethod2 = ssaMethod;
        SsaMethod ssaMethod3 = new SsaMethod(ropMethod2, i, z);
        SsaMethod ssaMethod4 = ssaMethod2;
        ssaMethod4.convertRopToSsaBlocks(ropMethod2);
        return ssaMethod4;
    }

    private void removeFromUseList(SsaInsn ssaInsn, RegisterSpecList registerSpecList) {
        RuntimeException runtimeException;
        SsaInsn ssaInsn2 = ssaInsn;
        RegisterSpecList registerSpecList2 = registerSpecList;
        if (registerSpecList2 != null) {
            int size = registerSpecList2.size();
            for (int i = 0; i < size; i++) {
                if (!this.useList[registerSpecList2.get(i).getReg()].remove(ssaInsn2)) {
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException("use not found");
                    throw runtimeException2;
                }
            }
        }
    }

    public int blockIndexToRopLabel(int i) {
        int i2 = i;
        if (i2 < 0) {
            return -1;
        }
        return ((SsaBasicBlock) this.blocks.get(i2)).getRopLabel();
    }

    public int borrowSpareRegister(int i) {
        int i2 = i;
        int i3 = this.spareRegisterBase + this.borrowedSpareRegisters;
        this.borrowedSpareRegisters = i2 + this.borrowedSpareRegisters;
        this.registerCount = Math.max(this.registerCount, i3 + i2);
        return i3;
    }

    public void computeReachability() {
        ArrayList arrayList;
        Iterator it = this.blocks.iterator();
        while (it.hasNext()) {
            ((SsaBasicBlock) it.next()).setReachable(0);
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add(getEntryBlock());
        while (!arrayList4.isEmpty()) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) arrayList4.remove(0);
            if (!ssaBasicBlock.isReachable()) {
                ssaBasicBlock.setReachable(1);
                BitSet successors = ssaBasicBlock.getSuccessors();
                int nextSetBit = successors.nextSetBit(0);
                while (true) {
                    int i = nextSetBit;
                    if (i < 0) {
                        break;
                    }
                    boolean add2 = arrayList4.add(this.blocks.get(i));
                    nextSetBit = successors.nextSetBit(i + 1);
                }
            }
        }
    }

    public void deleteInsns(Set<SsaInsn> set) {
        PlainInsn plainInsn;
        Set<SsaInsn> set2 = set;
        Iterator it = getBlocks().iterator();
        while (it.hasNext()) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) it.next();
            ArrayList insns = ssaBasicBlock.getInsns();
            for (int size = -1 + insns.size(); size >= 0; size--) {
                SsaInsn ssaInsn = (SsaInsn) insns.get(size);
                if (set2.contains(ssaInsn)) {
                    onInsnRemoved(ssaInsn);
                    Object remove = insns.remove(size);
                }
            }
            int size2 = insns.size();
            SsaInsn ssaInsn2 = size2 == 0 ? null : (SsaInsn) insns.get(size2 - 1);
            if (ssaBasicBlock != getExitBlock() && (size2 == 0 || ssaInsn2.getOriginalRopInsn() == null || ssaInsn2.getOriginalRopInsn().getOpcode().getBranchingness() == 1)) {
                ArrayList arrayList = insns;
                PlainInsn plainInsn2 = plainInsn;
                PlainInsn plainInsn3 = new PlainInsn(Rops.GOTO, SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.EMPTY);
                boolean add = arrayList.add(SsaInsn.makeFromRop(plainInsn2, ssaBasicBlock));
                BitSet successors = ssaBasicBlock.getSuccessors();
                int nextSetBit = successors.nextSetBit(0);
                while (true) {
                    int i = nextSetBit;
                    if (i < 0) {
                        break;
                    }
                    if (i != ssaBasicBlock.getPrimarySuccessorIndex()) {
                        ssaBasicBlock.removeSuccessor(i);
                    }
                    nextSetBit = successors.nextSetBit(i + 1);
                }
            }
        }
    }

    public void forEachBlockDepthFirst(boolean z, SsaBasicBlock.Visitor visitor) {
        BitSet bitSet;
        Stack stack;
        boolean z2 = z;
        SsaBasicBlock.Visitor visitor2 = visitor;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(this.blocks.size());
        BitSet bitSet4 = bitSet2;
        Stack stack2 = stack;
        Stack stack3 = new Stack();
        Stack stack4 = stack2;
        SsaBasicBlock entryBlock = z2 ? getExitBlock() : getEntryBlock();
        if (entryBlock != null) {
            boolean add = stack4.add(null);
            boolean add2 = stack4.add(entryBlock);
            while (stack4.size() > 0) {
                SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) stack4.pop();
                SsaBasicBlock ssaBasicBlock2 = (SsaBasicBlock) stack4.pop();
                if (!bitSet4.get(ssaBasicBlock.getIndex())) {
                    BitSet successors = z2 ? ssaBasicBlock.getPredecessors() : ssaBasicBlock.getSuccessors();
                    int nextSetBit = successors.nextSetBit(0);
                    while (true) {
                        int i = nextSetBit;
                        if (i < 0) {
                            break;
                        }
                        boolean add3 = stack4.add(ssaBasicBlock);
                        boolean add4 = stack4.add(this.blocks.get(i));
                        nextSetBit = successors.nextSetBit(i + 1);
                    }
                    bitSet4.set(ssaBasicBlock.getIndex());
                    visitor2.visitBlock(ssaBasicBlock, ssaBasicBlock2);
                }
            }
        }
    }

    public void forEachBlockDepthFirstDom(SsaBasicBlock.Visitor visitor) {
        BitSet bitSet;
        Stack stack;
        SsaBasicBlock.Visitor visitor2 = visitor;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(getBlocks().size());
        BitSet bitSet4 = bitSet2;
        Stack stack2 = stack;
        Stack stack3 = new Stack();
        Stack stack4 = stack2;
        boolean add = stack4.add(getEntryBlock());
        while (stack4.size() > 0) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) stack4.pop();
            ArrayList domChildren = ssaBasicBlock.getDomChildren();
            if (!bitSet4.get(ssaBasicBlock.getIndex())) {
                for (int size = -1 + domChildren.size(); size >= 0; size--) {
                    boolean add2 = stack4.add((SsaBasicBlock) domChildren.get(size));
                }
                bitSet4.set(ssaBasicBlock.getIndex());
                visitor2.visitBlock(ssaBasicBlock, null);
            }
        }
    }

    public void forEachInsn(Visitor visitor) {
        Visitor visitor2 = visitor;
        Iterator it = this.blocks.iterator();
        while (it.hasNext()) {
            ((SsaBasicBlock) it.next()).forEachInsn(visitor2);
        }
    }

    public void forEachPhiInsn(PhiInsn.Visitor visitor) {
        PhiInsn.Visitor visitor2 = visitor;
        Iterator it = this.blocks.iterator();
        while (it.hasNext()) {
            ((SsaBasicBlock) it.next()).forEachPhiInsn(visitor2);
        }
    }

    public ArrayList<SsaBasicBlock> getBlocks() {
        return this.blocks;
    }

    public int getCountReachableBlocks() {
        Iterator it = this.blocks.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((SsaBasicBlock) it.next()).isReachable() ? i2 + 1 : i2;
        }
    }

    public SsaInsn getDefinitionForRegister(int i) {
        C07231 r6;
        RuntimeException runtimeException;
        int i2 = i;
        if (this.backMode) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("No def list in back mode");
            throw runtimeException2;
        } else if (this.definitionList != null) {
            return this.definitionList[i2];
        } else {
            this.definitionList = new SsaInsn[getRegCount()];
            C07231 r3 = r6;
            C07231 r4 = new Visitor(this) {
                final /* synthetic */ SsaMethod this$0;

                {
                    this.this$0 = r5;
                }

                public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                    NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
                    this.this$0.definitionList[normalSsaInsn2.getResult().getReg()] = normalSsaInsn2;
                }

                public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                    NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
                    if (normalSsaInsn2.getResult() != null) {
                        this.this$0.definitionList[normalSsaInsn2.getResult().getReg()] = normalSsaInsn2;
                    }
                }

                public void visitPhiInsn(PhiInsn phiInsn) {
                    PhiInsn phiInsn2 = phiInsn;
                    this.this$0.definitionList[phiInsn2.getResult().getReg()] = phiInsn2;
                }
            };
            forEachInsn(r3);
            return this.definitionList[i2];
        }
    }

    public SsaBasicBlock getEntryBlock() {
        return (SsaBasicBlock) this.blocks.get(this.entryBlockIndex);
    }

    public int getEntryBlockIndex() {
        return this.entryBlockIndex;
    }

    public SsaBasicBlock getExitBlock() {
        if (this.exitBlockIndex < 0) {
            return null;
        }
        return (SsaBasicBlock) this.blocks.get(this.exitBlockIndex);
    }

    public int getExitBlockIndex() {
        return this.exitBlockIndex;
    }

    public int getParamWidth() {
        return this.paramWidth;
    }

    public int getRegCount() {
        return this.registerCount;
    }

    public ArrayList<SsaInsn>[] getUseListCopy() {
        ArrayList arrayList;
        if (this.useList == null) {
            buildUseList();
        }
        ArrayList[] arrayListArr = new ArrayList[this.registerCount];
        for (int i = 0; i < this.registerCount; i++) {
            ArrayList[] arrayListArr2 = arrayListArr;
            int i2 = i;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(this.useList[i]);
            arrayListArr2[i2] = arrayList2;
        }
        return arrayListArr;
    }

    public List<SsaInsn> getUseListForRegister(int i) {
        int i2 = i;
        if (this.unmodifiableUseList == null) {
            buildUseList();
        }
        return this.unmodifiableUseList[i2];
    }

    public boolean isRegALocal(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        SsaInsn definitionForRegister = getDefinitionForRegister(registerSpec2.getReg());
        if (definitionForRegister == null) {
            return false;
        }
        if (definitionForRegister.getLocalAssignment() != null) {
            return true;
        }
        for (SsaInsn originalRopInsn : getUseListForRegister(registerSpec2.getReg())) {
            Insn originalRopInsn2 = originalRopInsn.getOriginalRopInsn();
            if (originalRopInsn2 != null && originalRopInsn2.getOpcode().getOpcode() == 54) {
                return true;
            }
        }
        return false;
    }

    public boolean isStatic() {
        return this.isStatic;
    }

    /* access modifiers changed from: 0000 */
    public void makeExitBlock() {
        SsaBasicBlock ssaBasicBlock;
        RuntimeException runtimeException;
        if (this.exitBlockIndex >= 0) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("must be called at most once");
            throw runtimeException2;
        }
        this.exitBlockIndex = this.blocks.size();
        int i = this.exitBlockIndex;
        int i2 = this.maxLabel;
        this.maxLabel = i2 + 1;
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        SsaBasicBlock ssaBasicBlock3 = new SsaBasicBlock(i, i2, this);
        SsaBasicBlock ssaBasicBlock4 = ssaBasicBlock2;
        boolean add = this.blocks.add(ssaBasicBlock4);
        Iterator it = this.blocks.iterator();
        while (it.hasNext()) {
            ((SsaBasicBlock) it.next()).exitBlockFixup(ssaBasicBlock4);
        }
        if (ssaBasicBlock4.getPredecessors().cardinality() == 0) {
            Object remove = this.blocks.remove(this.exitBlockIndex);
            this.exitBlockIndex = -1;
            this.maxLabel = -1 + this.maxLabel;
        }
    }

    public SsaBasicBlock makeNewGotoBlock() {
        SsaBasicBlock ssaBasicBlock;
        int size = this.blocks.size();
        int i = this.maxLabel;
        this.maxLabel = i + 1;
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        SsaBasicBlock ssaBasicBlock3 = new SsaBasicBlock(size, i, this);
        SsaBasicBlock ssaBasicBlock4 = ssaBasicBlock2;
        boolean add = ssaBasicBlock4.getInsns().add(getGoto(ssaBasicBlock4));
        boolean add2 = this.blocks.add(ssaBasicBlock4);
        return ssaBasicBlock4;
    }

    public int makeNewSsaReg() {
        int i = this.registerCount;
        this.registerCount = i + 1;
        this.spareRegisterBase = this.registerCount;
        onInsnsChanged();
        return i;
    }

    public void mapRegisters(RegisterMapper registerMapper) {
        RegisterMapper registerMapper2 = registerMapper;
        Iterator it = getBlocks().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((SsaBasicBlock) it.next()).getInsns().iterator();
            while (it2.hasNext()) {
                ((SsaInsn) it2.next()).mapRegisters(registerMapper2);
            }
        }
        this.registerCount = registerMapper2.getNewRegisterCount();
        this.spareRegisterBase = this.registerCount;
    }

    /* access modifiers changed from: 0000 */
    public void onInsnAdded(SsaInsn ssaInsn) {
        SsaInsn ssaInsn2 = ssaInsn;
        onSourcesChanged(ssaInsn2, null);
        updateOneDefinition(ssaInsn2, null);
    }

    /* access modifiers changed from: 0000 */
    public void onInsnRemoved(SsaInsn ssaInsn) {
        SsaInsn ssaInsn2 = ssaInsn;
        if (this.useList != null) {
            removeFromUseList(ssaInsn2, ssaInsn2.getSources());
        }
        RegisterSpec result = ssaInsn2.getResult();
        if (this.definitionList != null && result != null) {
            this.definitionList[result.getReg()] = null;
        }
    }

    public void onInsnsChanged() {
        this.definitionList = null;
        this.useList = null;
        this.unmodifiableUseList = null;
    }

    /* access modifiers changed from: 0000 */
    public void onSourceChanged(SsaInsn ssaInsn, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        SsaInsn ssaInsn2 = ssaInsn;
        RegisterSpec registerSpec3 = registerSpec;
        RegisterSpec registerSpec4 = registerSpec2;
        if (this.useList != null) {
            if (registerSpec3 != null) {
                boolean remove = this.useList[registerSpec3.getReg()].remove(ssaInsn2);
            }
            int reg = registerSpec4.getReg();
            if (this.useList.length <= reg) {
                this.useList = null;
            } else {
                boolean add = this.useList[reg].add(ssaInsn2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void onSourcesChanged(SsaInsn ssaInsn, RegisterSpecList registerSpecList) {
        SsaInsn ssaInsn2 = ssaInsn;
        RegisterSpecList registerSpecList2 = registerSpecList;
        if (this.useList != null) {
            if (registerSpecList2 != null) {
                removeFromUseList(ssaInsn2, registerSpecList2);
            }
            RegisterSpecList sources = ssaInsn2.getSources();
            int size = sources.size();
            for (int i = 0; i < size; i++) {
                boolean add = this.useList[sources.get(i).getReg()].add(ssaInsn2);
            }
        }
    }

    public void returnSpareRegisters() {
        this.borrowedSpareRegisters = 0;
    }

    public void setBackMode() {
        this.backMode = true;
        this.useList = null;
        this.definitionList = null;
    }

    /* access modifiers changed from: 0000 */
    public void setNewRegCount(int i) {
        this.registerCount = i;
        this.spareRegisterBase = this.registerCount;
        onInsnsChanged();
    }

    /* access modifiers changed from: 0000 */
    public void updateOneDefinition(SsaInsn ssaInsn, RegisterSpec registerSpec) {
        RuntimeException runtimeException;
        SsaInsn ssaInsn2 = ssaInsn;
        RegisterSpec registerSpec2 = registerSpec;
        if (this.definitionList != null) {
            if (registerSpec2 != null) {
                this.definitionList[registerSpec2.getReg()] = null;
            }
            RegisterSpec result = ssaInsn2.getResult();
            if (result != null) {
                if (this.definitionList[result.getReg()] != null) {
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException("Duplicate add of insn");
                    throw runtimeException2;
                }
                this.definitionList[result.getReg()] = ssaInsn2;
            }
        }
    }
}
