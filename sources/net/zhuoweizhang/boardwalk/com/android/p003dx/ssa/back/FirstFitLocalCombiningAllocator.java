package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.InterferenceRegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.NormalSsaInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.PhiInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.RegisterMapper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntIterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntSet;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.FirstFitLocalCombiningAllocator */
public class FirstFitLocalCombiningAllocator extends RegisterAllocator {
    private static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public final ArrayList<NormalSsaInsn> invokeRangeInsns;
    /* access modifiers changed from: private */
    public final Map<LocalItem, ArrayList<RegisterSpec>> localVariables;
    private final InterferenceRegisterMapper mapper;
    private final boolean minimizeRegisters;
    /* access modifiers changed from: private */
    public final ArrayList<NormalSsaInsn> moveResultPseudoInsns;
    private final int paramRangeEnd;
    /* access modifiers changed from: private */
    public final ArrayList<PhiInsn> phiInsns;
    private final BitSet reservedRopRegs;
    private final BitSet ssaRegsMapped;
    private final BitSet usedRopRegs;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.FirstFitLocalCombiningAllocator$Multiset */
    private static class Multiset {
        private final int[] count;
        private final int[] reg;
        private int size = 0;

        public Multiset(int i) {
            int i2 = i;
            this.reg = new int[i2];
            this.count = new int[i2];
        }

        public void add(int i) {
            int i2 = i;
            for (int i3 = 0; i3 < this.size; i3++) {
                if (this.reg[i3] == i2) {
                    int[] iArr = this.count;
                    iArr[i3] = 1 + iArr[i3];
                    return;
                }
            }
            this.reg[this.size] = i2;
            this.count[this.size] = 1;
            this.size = 1 + this.size;
        }

        public int getAndRemoveHighestCount() {
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < this.size; i4++) {
                if (i < this.count[i4]) {
                    i2 = this.reg[i4];
                    i = this.count[i4];
                    i3 = i4;
                }
            }
            this.count[i3] = 0;
            return i2;
        }

        public int getSize() {
            return this.size;
        }
    }

    public FirstFitLocalCombiningAllocator(SsaMethod ssaMethod, InterferenceGraph interferenceGraph, boolean z) {
        BitSet bitSet;
        InterferenceRegisterMapper interferenceRegisterMapper;
        BitSet bitSet2;
        BitSet bitSet3;
        TreeMap treeMap;
        ArrayList<NormalSsaInsn> arrayList;
        ArrayList<NormalSsaInsn> arrayList2;
        ArrayList<PhiInsn> arrayList3;
        SsaMethod ssaMethod2 = ssaMethod;
        InterferenceGraph interferenceGraph2 = interferenceGraph;
        boolean z2 = z;
        super(ssaMethod2, interferenceGraph2);
        BitSet bitSet4 = bitSet;
        BitSet bitSet5 = new BitSet(ssaMethod2.getRegCount());
        this.ssaRegsMapped = bitSet4;
        InterferenceRegisterMapper interferenceRegisterMapper2 = interferenceRegisterMapper;
        InterferenceRegisterMapper interferenceRegisterMapper3 = new InterferenceRegisterMapper(interferenceGraph2, ssaMethod2.getRegCount());
        this.mapper = interferenceRegisterMapper2;
        this.minimizeRegisters = z2;
        this.paramRangeEnd = ssaMethod2.getParamWidth();
        BitSet bitSet6 = bitSet2;
        BitSet bitSet7 = new BitSet(2 * this.paramRangeEnd);
        this.reservedRopRegs = bitSet6;
        this.reservedRopRegs.set(0, this.paramRangeEnd);
        BitSet bitSet8 = bitSet3;
        BitSet bitSet9 = new BitSet(2 * this.paramRangeEnd);
        this.usedRopRegs = bitSet8;
        TreeMap treeMap2 = treeMap;
        TreeMap treeMap3 = new TreeMap();
        this.localVariables = treeMap2;
        ArrayList<NormalSsaInsn> arrayList4 = arrayList;
        ArrayList<NormalSsaInsn> arrayList5 = new ArrayList<>();
        this.moveResultPseudoInsns = arrayList4;
        ArrayList<NormalSsaInsn> arrayList6 = arrayList2;
        ArrayList<NormalSsaInsn> arrayList7 = new ArrayList<>();
        this.invokeRangeInsns = arrayList6;
        ArrayList<PhiInsn> arrayList8 = arrayList3;
        ArrayList<PhiInsn> arrayList9 = new ArrayList<>();
        this.phiInsns = arrayList8;
    }

    private void addMapping(RegisterSpec registerSpec, int i) {
        RuntimeException runtimeException;
        RegisterSpec registerSpec2 = registerSpec;
        int i2 = i;
        int reg = registerSpec2.getReg();
        if (this.ssaRegsMapped.get(reg) || !canMapReg(registerSpec2, i2)) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("attempt to add invalid register mapping");
            throw runtimeException2;
        }
        int category = registerSpec2.getCategory();
        this.mapper.addMapping(registerSpec2.getReg(), i2, category);
        this.ssaRegsMapped.set(reg);
        this.usedRopRegs.set(i2, category + i2);
    }

    private void adjustAndMapSourceRangeRange(NormalSsaInsn normalSsaInsn) {
        NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
        int findRangeAndAdjust = findRangeAndAdjust(normalSsaInsn2);
        RegisterSpecList sources = normalSsaInsn2.getSources();
        int size = sources.size();
        int i = 0;
        int i2 = findRangeAndAdjust;
        while (true) {
            int i3 = i2;
            if (i < size) {
                RegisterSpec registerSpec = sources.get(i);
                int reg = registerSpec.getReg();
                int category = registerSpec.getCategory();
                int i4 = i3 + category;
                if (!this.ssaRegsMapped.get(reg)) {
                    LocalItem localItemForReg = getLocalItemForReg(reg);
                    addMapping(registerSpec, i3);
                    if (localItemForReg != null) {
                        markReserved(i3, category);
                        ArrayList arrayList = (ArrayList) this.localVariables.get(localItemForReg);
                        int size2 = arrayList.size();
                        for (int i5 = 0; i5 < size2; i5++) {
                            RegisterSpec registerSpec2 = (RegisterSpec) arrayList.get(i5);
                            if (-1 == sources.indexOfRegister(registerSpec2.getReg())) {
                                boolean tryMapReg = tryMapReg(registerSpec2, i3, category);
                            }
                        }
                    }
                }
                i++;
                i2 = i4;
            } else {
                return;
            }
        }
    }

    private void analyzeInstructions() {
        C07271 r5;
        SsaMethod ssaMethod = this.ssaMeth;
        C07271 r2 = r5;
        C07271 r3 = new Visitor(this) {
            final /* synthetic */ FirstFitLocalCombiningAllocator this$0;

            {
                this.this$0 = r5;
            }

            private void processInsn(SsaInsn ssaInsn) {
                ArrayList arrayList;
                SsaInsn ssaInsn2 = ssaInsn;
                RegisterSpec localAssignment = ssaInsn2.getLocalAssignment();
                if (localAssignment != null) {
                    LocalItem localItem = localAssignment.getLocalItem();
                    ArrayList arrayList2 = (ArrayList) this.this$0.localVariables.get(localItem);
                    if (arrayList2 == null) {
                        ArrayList arrayList3 = arrayList;
                        ArrayList arrayList4 = new ArrayList();
                        arrayList2 = arrayList3;
                        Object put = this.this$0.localVariables.put(localItem, arrayList2);
                    }
                    boolean add = arrayList2.add(localAssignment);
                }
                if (ssaInsn2 instanceof NormalSsaInsn) {
                    if (ssaInsn2.getOpcode().getOpcode() == 56) {
                        boolean add2 = this.this$0.moveResultPseudoInsns.add((NormalSsaInsn) ssaInsn2);
                    } else if (Optimizer.getAdvice().requiresSourcesInOrder(ssaInsn2.getOriginalRopInsn().getOpcode(), ssaInsn2.getSources())) {
                        boolean add3 = this.this$0.invokeRangeInsns.add((NormalSsaInsn) ssaInsn2);
                    }
                } else if (ssaInsn2 instanceof PhiInsn) {
                    boolean add4 = this.this$0.phiInsns.add((PhiInsn) ssaInsn2);
                }
            }

            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
                processInsn(normalSsaInsn);
            }

            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                processInsn(normalSsaInsn);
            }

            public void visitPhiInsn(PhiInsn phiInsn) {
                processInsn(phiInsn);
            }
        };
        ssaMethod.forEachInsn(r2);
    }

    private boolean canMapReg(RegisterSpec registerSpec, int i) {
        RegisterSpec registerSpec2 = registerSpec;
        int i2 = i;
        return !spansParamRange(i2, registerSpec2.getCategory()) && !this.mapper.interferes(registerSpec2, i2);
    }

    private boolean canMapRegs(ArrayList<RegisterSpec> arrayList, int i) {
        int i2 = i;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RegisterSpec registerSpec = (RegisterSpec) it.next();
            if (!this.ssaRegsMapped.get(registerSpec.getReg()) && !canMapReg(registerSpec, i2)) {
                return false;
            }
        }
        return true;
    }

    private int findAnyFittingRange(NormalSsaInsn normalSsaInsn, int i, int[] iArr, BitSet bitSet) {
        NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
        int i2 = i;
        int[] iArr2 = iArr;
        BitSet bitSet2 = bitSet;
        int i3 = this.paramRangeEnd;
        while (true) {
            int findNextUnreservedRopReg = findNextUnreservedRopReg(i3, i2);
            if (fitPlanForRange(findNextUnreservedRopReg, normalSsaInsn2, iArr2, bitSet2) >= 0) {
                return findNextUnreservedRopReg;
            }
            i3 = findNextUnreservedRopReg + 1;
            bitSet2.clear();
        }
    }

    private int findNextUnreservedRopReg(int i, int i2) {
        int i3 = i2;
        int nextClearBit = this.reservedRopRegs.nextClearBit(i);
        while (true) {
            int i4 = nextClearBit;
            int i5 = 1;
            while (i5 < i3 && !this.reservedRopRegs.get(i4 + i5)) {
                i5++;
            }
            if (i5 == i3) {
                return i4;
            }
            nextClearBit = this.reservedRopRegs.nextClearBit(i4 + i5);
        }
    }

    private int findRangeAndAdjust(NormalSsaInsn normalSsaInsn) {
        int i;
        BitSet bitSet;
        BitSet bitSet2;
        NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
        RegisterSpecList sources = normalSsaInsn2.getSources();
        int size = sources.size();
        int[] iArr = new int[size];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= size) {
                break;
            }
            iArr[i2] = sources.get(i2).getCategory();
            i2++;
            i3 = i + iArr[i2];
        }
        int i4 = 0;
        BitSet bitSet3 = null;
        int i5 = -1;
        int i6 = Integer.MIN_VALUE;
        for (int i7 = 0; i7 < size; i7++) {
            int reg = sources.get(i7).getReg();
            if (i7 != 0) {
                i4 -= iArr[i7 - 1];
            }
            if (this.ssaRegsMapped.get(reg)) {
                int oldToNew = i4 + this.mapper.oldToNew(reg);
                if (oldToNew >= 0 && !spansParamRange(oldToNew, i)) {
                    BitSet bitSet4 = bitSet2;
                    BitSet bitSet5 = new BitSet(size);
                    BitSet bitSet6 = bitSet4;
                    int fitPlanForRange = fitPlanForRange(oldToNew, normalSsaInsn2, iArr, bitSet6);
                    if (fitPlanForRange >= 0) {
                        int cardinality = fitPlanForRange - bitSet6.cardinality();
                        if (cardinality > i6) {
                            bitSet3 = bitSet6;
                            i5 = oldToNew;
                            i6 = cardinality;
                        }
                        if (fitPlanForRange == i) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (i5 == -1) {
            BitSet bitSet7 = bitSet;
            BitSet bitSet8 = new BitSet(size);
            bitSet3 = bitSet7;
            i5 = findAnyFittingRange(normalSsaInsn2, i, iArr, bitSet3);
        }
        int nextSetBit = bitSet3.nextSetBit(0);
        while (true) {
            int i8 = nextSetBit;
            if (i8 < 0) {
                return i5;
            }
            normalSsaInsn2.changeOneSource(i8, insertMoveBefore(normalSsaInsn2, sources.get(i8)));
            nextSetBit = bitSet3.nextSetBit(i8 + 1);
        }
    }

    private int findRopRegForLocal(int i, int i2) {
        int i3 = i2;
        int nextClearBit = this.usedRopRegs.nextClearBit(i);
        while (true) {
            int i4 = nextClearBit;
            int i5 = 1;
            while (i5 < i3 && !this.usedRopRegs.get(i4 + i5)) {
                i5++;
            }
            if (i5 == i3) {
                return i4;
            }
            nextClearBit = this.usedRopRegs.nextClearBit(i4 + i5);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int fitPlanForRange(int r23, net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.NormalSsaInsn r24, int[] r25, java.util.BitSet r26) {
        /*
            r22 = this;
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r17 = r4
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r17 = r17.getSources()
            r7 = r17
            r17 = r7
            int r17 = r17.size()
            r8 = r17
            r17 = 0
            r9 = r17
            r17 = r2
            r18 = r4
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r18 = r18.getBlock()
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntSet r18 = r18.getLiveOutRegs()
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r17 = r17.ssaSetToSpecs(r18)
            r10 = r17
            java.util.BitSet r17 = new java.util.BitSet
            r21 = r17
            r17 = r21
            r18 = r21
            r19 = r2
            r0 = r19
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r0 = r0.ssaMeth
            r19 = r0
            int r19 = r19.getRegCount()
            r18.<init>(r19)
            r11 = r17
            r17 = 0
            r12 = r17
            r17 = r3
            r13 = r17
        L_0x0051:
            r17 = r12
            r18 = r8
            r0 = r17
            r1 = r18
            if (r0 >= r1) goto L_0x00d1
            r17 = r7
            r18 = r12
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r17 = r17.get(r18)
            r14 = r17
            r17 = r14
            int r17 = r17.getReg()
            r15 = r17
            r17 = r5
            r18 = r12
            r17 = r17[r18]
            r16 = r17
            r17 = r12
            if (r17 == 0) goto L_0x0089
            r17 = r13
            r18 = r5
            r19 = r12
            r20 = 1
            int r19 = r19 + -1
            r18 = r18[r19]
            int r17 = r17 + r18
            r13 = r17
        L_0x0089:
            r17 = r2
            r0 = r17
            java.util.BitSet r0 = r0.ssaRegsMapped
            r17 = r0
            r18 = r15
            boolean r17 = r17.get(r18)
            if (r17 == 0) goto L_0x00c1
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.InterferenceRegisterMapper r0 = r0.mapper
            r17 = r0
            r18 = r15
            int r17 = r17.oldToNew(r18)
            r18 = r13
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x00c1
            r17 = r9
            r18 = r16
            int r17 = r17 + r18
            r9 = r17
        L_0x00b7:
            r17 = r11
            r18 = r15
            r17.set(r18)
            int r12 = r12 + 1
            goto L_0x0051
        L_0x00c1:
            r17 = r2
            r18 = r13
            r19 = r16
            boolean r17 = r17.rangeContainsReserved(r18, r19)
            if (r17 == 0) goto L_0x00d6
            r17 = -1
            r9 = r17
        L_0x00d1:
            r17 = r9
            r2 = r17
        L_0x00d5:
            return r2
        L_0x00d6:
            r17 = r2
            r0 = r17
            java.util.BitSet r0 = r0.ssaRegsMapped
            r17 = r0
            r18 = r15
            boolean r17 = r17.get(r18)
            if (r17 != 0) goto L_0x0105
            r17 = r2
            r18 = r14
            r19 = r13
            boolean r17 = r17.canMapReg(r18, r19)
            if (r17 == 0) goto L_0x0105
            r17 = r11
            r18 = r15
            boolean r17 = r17.get(r18)
            if (r17 != 0) goto L_0x0105
            r17 = r9
            r18 = r16
            int r17 = r17 + r18
            r9 = r17
            goto L_0x00b7
        L_0x0105:
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.InterferenceRegisterMapper r0 = r0.mapper
            r17 = r0
            r18 = r10
            r19 = r13
            r20 = r16
            boolean r17 = r17.areAnyPinned(r18, r19, r20)
            if (r17 != 0) goto L_0x0135
            r17 = r2
            r0 = r17
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.InterferenceRegisterMapper r0 = r0.mapper
            r17 = r0
            r18 = r7
            r19 = r13
            r20 = r16
            boolean r17 = r17.areAnyPinned(r18, r19, r20)
            if (r17 != 0) goto L_0x0135
            r17 = r6
            r18 = r12
            r17.set(r18)
            goto L_0x00b7
        L_0x0135:
            r17 = -1
            r2 = r17
            goto L_0x00d5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back.FirstFitLocalCombiningAllocator.fitPlanForRange(int, net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn, int[], java.util.BitSet):int");
    }

    private LocalItem getLocalItemForReg(int i) {
        int i2 = i;
        for (Entry entry : this.localVariables.entrySet()) {
            Iterator it = ((ArrayList) entry.getValue()).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((RegisterSpec) it.next()).getReg() == i2) {
                        return (LocalItem) entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    private int getParameterIndexForReg(int i) {
        int i2 = i;
        SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i2);
        if (definitionForRegister != null) {
            Rop opcode = definitionForRegister.getOpcode();
            if (opcode != null && opcode.getOpcode() == 3) {
                return ((CstInteger) ((CstInsn) definitionForRegister.getOriginalRopInsn()).getConstant()).getValue();
            }
        }
        return -1;
    }

    private void handleCheckCastResults() {
        ArrayList arrayList;
        Iterator it = this.moveResultPseudoInsns.iterator();
        while (it.hasNext()) {
            NormalSsaInsn normalSsaInsn = (NormalSsaInsn) it.next();
            RegisterSpec result = normalSsaInsn.getResult();
            int reg = result.getReg();
            BitSet predecessors = normalSsaInsn.getBlock().getPredecessors();
            if (predecessors.cardinality() == 1) {
                ArrayList insns = ((SsaBasicBlock) this.ssaMeth.getBlocks().get(predecessors.nextSetBit(0))).getInsns();
                SsaInsn ssaInsn = (SsaInsn) insns.get(-1 + insns.size());
                if (ssaInsn.getOpcode().getOpcode() == 43) {
                    RegisterSpec registerSpec = ssaInsn.getSources().get(0);
                    int reg2 = registerSpec.getReg();
                    int category = registerSpec.getCategory();
                    boolean z = this.ssaRegsMapped.get(reg);
                    boolean z2 = this.ssaRegsMapped.get(reg2);
                    boolean z3 = (!z2) & z ? tryMapReg(registerSpec, this.mapper.oldToNew(reg), category) : z2;
                    if ((!z) && z3) {
                        z = tryMapReg(result, this.mapper.oldToNew(reg2), category);
                    }
                    if (!z || !z3) {
                        ArrayList arrayList2 = arrayList;
                        ArrayList arrayList3 = new ArrayList(2);
                        ArrayList arrayList4 = arrayList2;
                        boolean add = arrayList4.add(result);
                        boolean add2 = arrayList4.add(registerSpec);
                        for (int findNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category); !tryMapRegs(arrayList4, findNextUnreservedRopReg, category, false); findNextUnreservedRopReg = findNextUnreservedRopReg(findNextUnreservedRopReg + 1, category)) {
                        }
                    }
                    boolean z4 = ssaInsn.getOriginalRopInsn().getCatches().size() != 0;
                    int oldToNew = this.mapper.oldToNew(reg);
                    if (oldToNew != this.mapper.oldToNew(reg2) && !z4) {
                        ((NormalSsaInsn) ssaInsn).changeOneSource(0, insertMoveBefore(ssaInsn, registerSpec));
                        addMapping(ssaInsn.getSources().get(0), oldToNew);
                    }
                }
            }
        }
    }

    private void handleInvokeRangeInsns() {
        Iterator it = this.invokeRangeInsns.iterator();
        while (it.hasNext()) {
            adjustAndMapSourceRangeRange((NormalSsaInsn) it.next());
        }
    }

    private void handleLocalAssociatedOther() {
        int i;
        for (ArrayList arrayList : this.localVariables.values()) {
            boolean z = false;
            int i2 = this.paramRangeEnd;
            while (true) {
                int size = arrayList.size();
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = i4;
                    if (i3 >= size) {
                        break;
                    }
                    RegisterSpec registerSpec = (RegisterSpec) arrayList.get(i3);
                    int category = registerSpec.getCategory();
                    i3++;
                    i4 = (this.ssaRegsMapped.get(registerSpec.getReg()) || category <= i) ? i : category;
                }
                int findRopRegForLocal = findRopRegForLocal(i2, i);
                boolean z2 = canMapRegs(arrayList, findRopRegForLocal) ? tryMapRegs(arrayList, findRopRegForLocal, i, true) : z;
                int i5 = findRopRegForLocal + 1;
                if (!z2) {
                    i2 = i5;
                    z = z2;
                }
            }
        }
    }

    private void handleLocalAssociatedParams() {
        int i;
        int i2;
        for (ArrayList arrayList : this.localVariables.values()) {
            int size = arrayList.size();
            int i3 = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i = i3;
                    i2 = 0;
                    break;
                }
                RegisterSpec registerSpec = (RegisterSpec) arrayList.get(i4);
                int parameterIndexForReg = getParameterIndexForReg(registerSpec.getReg());
                if (parameterIndexForReg >= 0) {
                    int category = registerSpec.getCategory();
                    addMapping(registerSpec, parameterIndexForReg);
                    i2 = category;
                    i = parameterIndexForReg;
                    break;
                }
                i4++;
                i3 = parameterIndexForReg;
            }
            if (i >= 0) {
                boolean tryMapRegs = tryMapRegs(arrayList, i, i2, true);
            }
        }
    }

    private void handleNormalUnassociated() {
        int i;
        int regCount = this.ssaMeth.getRegCount();
        for (int i2 = 0; i2 < regCount; i2++) {
            if (!this.ssaRegsMapped.get(i2)) {
                RegisterSpec definitionSpecForSsaReg = getDefinitionSpecForSsaReg(i2);
                if (definitionSpecForSsaReg != null) {
                    int category = definitionSpecForSsaReg.getCategory();
                    int findNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category);
                    while (true) {
                        i = findNextUnreservedRopReg;
                        if (canMapReg(definitionSpecForSsaReg, i)) {
                            break;
                        }
                        findNextUnreservedRopReg = findNextUnreservedRopReg(i + 1, category);
                    }
                    addMapping(definitionSpecForSsaReg, i);
                }
            }
        }
    }

    private void handlePhiInsns() {
        Iterator it = this.phiInsns.iterator();
        while (it.hasNext()) {
            processPhiInsn((PhiInsn) it.next());
        }
    }

    private void handleUnassociatedParameters() {
        int regCount = this.ssaMeth.getRegCount();
        for (int i = 0; i < regCount; i++) {
            if (!this.ssaRegsMapped.get(i)) {
                int parameterIndexForReg = getParameterIndexForReg(i);
                RegisterSpec definitionSpecForSsaReg = getDefinitionSpecForSsaReg(i);
                if (parameterIndexForReg >= 0) {
                    addMapping(definitionSpecForSsaReg, parameterIndexForReg);
                }
            }
        }
    }

    private boolean isThisPointerReg(int i) {
        return i == 0 && !this.ssaMeth.isStatic();
    }

    private void markReserved(int i, int i2) {
        int i3 = i;
        this.reservedRopRegs.set(i3, i3 + i2, true);
    }

    private void printLocalVars() {
        StringBuilder sb;
        System.out.println("Printing local vars");
        for (Entry entry : this.localVariables.entrySet()) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = sb2;
            StringBuilder append = sb4.append('{');
            StringBuilder append2 = sb4.append(' ');
            Iterator it = ((ArrayList) entry.getValue()).iterator();
            while (it.hasNext()) {
                RegisterSpec registerSpec = (RegisterSpec) it.next();
                StringBuilder append3 = sb4.append('v');
                StringBuilder append4 = sb4.append(registerSpec.getReg());
                StringBuilder append5 = sb4.append(' ');
            }
            StringBuilder append6 = sb4.append('}');
            PrintStream printf = System.out.printf("Local: %s Registers: %s\n", new Object[]{entry.getKey(), sb4});
        }
    }

    private void processPhiInsn(PhiInsn phiInsn) {
        ArrayList arrayList;
        Multiset multiset;
        PhiInsn phiInsn2 = phiInsn;
        RegisterSpec result = phiInsn2.getResult();
        int reg = result.getReg();
        int category = result.getCategory();
        RegisterSpecList sources = phiInsn2.getSources();
        int size = sources.size();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        Multiset multiset2 = multiset;
        Multiset multiset3 = new Multiset(size + 1);
        Multiset multiset4 = multiset2;
        if (this.ssaRegsMapped.get(reg)) {
            multiset4.add(this.mapper.oldToNew(reg));
        } else {
            boolean add = arrayList4.add(result);
        }
        for (int i = 0; i < size; i++) {
            RegisterSpec result2 = this.ssaMeth.getDefinitionForRegister(sources.get(i).getReg()).getResult();
            int reg2 = result2.getReg();
            if (this.ssaRegsMapped.get(reg2)) {
                multiset4.add(this.mapper.oldToNew(reg2));
            } else {
                boolean add2 = arrayList4.add(result2);
            }
        }
        for (int i2 = 0; i2 < multiset4.getSize(); i2++) {
            boolean tryMapRegs = tryMapRegs(arrayList4, multiset4.getAndRemoveHighestCount(), category, false);
        }
        int findNextUnreservedRopReg = findNextUnreservedRopReg(this.paramRangeEnd, category);
        while (true) {
            int i3 = findNextUnreservedRopReg;
            if (!tryMapRegs(arrayList4, i3, category, false)) {
                findNextUnreservedRopReg = findNextUnreservedRopReg(i3 + 1, category);
            } else {
                return;
            }
        }
    }

    private boolean rangeContainsReserved(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            if (this.reservedRopRegs.get(i5)) {
                return true;
            }
        }
        return false;
    }

    private boolean spansParamRange(int i, int i2) {
        int i3 = i;
        return i3 < this.paramRangeEnd && i3 + i2 > this.paramRangeEnd;
    }

    private boolean tryMapReg(RegisterSpec registerSpec, int i, int i2) {
        RegisterSpec registerSpec2 = registerSpec;
        int i3 = i;
        if (registerSpec2.getCategory() > i2 || this.ssaRegsMapped.get(registerSpec2.getReg()) || !canMapReg(registerSpec2, i3)) {
            return false;
        }
        addMapping(registerSpec2, i3);
        return true;
    }

    private boolean tryMapRegs(ArrayList<RegisterSpec> arrayList, int i, int i2, boolean z) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        Iterator it = arrayList.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            RegisterSpec registerSpec = (RegisterSpec) it.next();
            if (!this.ssaRegsMapped.get(registerSpec.getReg())) {
                boolean tryMapReg = tryMapReg(registerSpec, i3, i4);
                z3 = !tryMapReg || z3;
                if (tryMapReg && z2) {
                    markReserved(i3, registerSpec.getCategory());
                }
            }
        }
        boolean z4 = false;
        if (!z3) {
            z4 = true;
        }
        return z4;
    }

    public RegisterMapper allocateRegisters() {
        analyzeInstructions();
        handleLocalAssociatedParams();
        handleUnassociatedParameters();
        handleInvokeRangeInsns();
        handleLocalAssociatedOther();
        handleCheckCastResults();
        handlePhiInsns();
        handleNormalUnassociated();
        return this.mapper;
    }

    /* access modifiers changed from: 0000 */
    public RegisterSpecList ssaSetToSpecs(IntSet intSet) {
        RegisterSpecList registerSpecList;
        IntSet intSet2 = intSet;
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(intSet2.elements());
        RegisterSpecList registerSpecList4 = registerSpecList2;
        IntIterator it = intSet2.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return registerSpecList4;
            }
            int i3 = i2 + 1;
            registerSpecList4.set(i2, getDefinitionSpecForSsaReg(it.next()));
            i = i3;
        }
    }

    public boolean wantsParamsMovedHigh() {
        return true;
    }
}
