package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LocalVariableList.Item;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.InsnList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainCstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.PlainInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.ThrowingCstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.ThrowingInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.TranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Bits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper */
public final class Ropper {
    private static final int PARAM_ASSIGNMENT = -1;
    private static final int RETURN = -2;
    private static final int SPECIAL_LABEL_COUNT = 7;
    private static final int SYNCH_CATCH_1 = -6;
    private static final int SYNCH_CATCH_2 = -7;
    private static final int SYNCH_RETURN = -3;
    private static final int SYNCH_SETUP_1 = -4;
    private static final int SYNCH_SETUP_2 = -5;
    private final ByteBlockList blocks;
    private final CatchInfo[] catchInfos;
    /* access modifiers changed from: private */
    public final ExceptionSetupLabelAllocator exceptionSetupLabelAllocator;
    private boolean hasSubroutines;
    private final RopperMachine machine;
    /* access modifiers changed from: private */
    public final int maxLabel;
    private final int maxLocals;
    /* access modifiers changed from: private */
    public final ConcreteMethod method;
    private final ArrayList<BasicBlock> result;
    private final ArrayList<IntList> resultSubroutines;
    private final Simulator sim;
    private final Frame[] startFrames;
    private final Subroutine[] subroutines;
    private boolean synchNeedsExceptionHandler;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$CatchInfo */
    private class CatchInfo {
        private final Map<Type, ExceptionHandlerSetup> setups;
        final /* synthetic */ Ropper this$0;

        private CatchInfo(Ropper ropper) {
            HashMap hashMap;
            this.this$0 = ropper;
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            this.setups = hashMap2;
        }

        /* synthetic */ CatchInfo(Ropper ropper, C06501 r7) {
            C06501 r2 = r7;
            this(ropper);
        }

        /* access modifiers changed from: 0000 */
        public ExceptionHandlerSetup getSetup(Type type) {
            ExceptionHandlerSetup exceptionHandlerSetup;
            Type type2 = type;
            ExceptionHandlerSetup exceptionHandlerSetup2 = (ExceptionHandlerSetup) this.setups.get(type2);
            if (exceptionHandlerSetup2 == null) {
                ExceptionHandlerSetup exceptionHandlerSetup3 = exceptionHandlerSetup;
                ExceptionHandlerSetup exceptionHandlerSetup4 = new ExceptionHandlerSetup(type2, this.this$0.exceptionSetupLabelAllocator.getNextLabel());
                exceptionHandlerSetup2 = exceptionHandlerSetup3;
                Object put = this.setups.put(type2, exceptionHandlerSetup2);
            }
            return exceptionHandlerSetup2;
        }

        /* access modifiers changed from: 0000 */
        public Collection<ExceptionHandlerSetup> getSetups() {
            return this.setups.values();
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$ExceptionHandlerSetup */
    private static class ExceptionHandlerSetup {
        private Type caughtType;
        private int label;

        ExceptionHandlerSetup(Type type, int i) {
            int i2 = i;
            this.caughtType = type;
            this.label = i2;
        }

        /* access modifiers changed from: 0000 */
        public Type getCaughtType() {
            return this.caughtType;
        }

        public int getLabel() {
            return this.label;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$ExceptionSetupLabelAllocator */
    private class ExceptionSetupLabelAllocator extends LabelAllocator {
        int maxSetupLabel;
        final /* synthetic */ Ropper this$0;

        ExceptionSetupLabelAllocator(Ropper ropper) {
            Ropper ropper2 = ropper;
            this.this$0 = ropper2;
            super(ropper2.maxLabel);
            this.maxSetupLabel = ropper2.maxLabel + ropper2.method.getCatches().size();
        }

        /* access modifiers changed from: 0000 */
        public int getNextLabel() {
            IndexOutOfBoundsException indexOutOfBoundsException;
            if (this.nextAvailableLabel >= this.maxSetupLabel) {
                IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
                IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException();
                throw indexOutOfBoundsException2;
            }
            int i = this.nextAvailableLabel;
            this.nextAvailableLabel = i + 1;
            return i;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$LabelAllocator */
    private static class LabelAllocator {
        int nextAvailableLabel;

        LabelAllocator(int i) {
            this.nextAvailableLabel = i;
        }

        /* access modifiers changed from: 0000 */
        public int getNextLabel() {
            int i = this.nextAvailableLabel;
            this.nextAvailableLabel = i + 1;
            return i;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine */
    private class Subroutine {
        private BitSet callerBlocks;
        /* access modifiers changed from: private */
        public BitSet retBlocks;
        /* access modifiers changed from: private */
        public int startBlock;
        final /* synthetic */ Ropper this$0;

        Subroutine(Ropper ropper, int i) {
            BitSet bitSet;
            BitSet bitSet2;
            Ropper ropper2 = ropper;
            int i2 = i;
            this.this$0 = ropper2;
            this.startBlock = i2;
            BitSet bitSet3 = bitSet;
            BitSet bitSet4 = new BitSet(ropper2.maxLabel);
            this.retBlocks = bitSet3;
            BitSet bitSet5 = bitSet2;
            BitSet bitSet6 = new BitSet(ropper2.maxLabel);
            this.callerBlocks = bitSet5;
            boolean access$202 = Ropper.access$202(ropper2, true);
        }

        Subroutine(Ropper ropper, int i, int i2) {
            int i3 = i2;
            this(ropper, i);
            addRetBlock(i3);
        }

        /* access modifiers changed from: 0000 */
        public void addCallerBlock(int i) {
            int i2 = i;
            this.callerBlocks.set(i2);
        }

        /* access modifiers changed from: 0000 */
        public void addRetBlock(int i) {
            int i2 = i;
            this.retBlocks.set(i2);
        }

        /* access modifiers changed from: 0000 */
        public int getStartBlock() {
            return this.startBlock;
        }

        /* access modifiers changed from: 0000 */
        public IntList getSuccessors() {
            IntList intList;
            IntList intList2 = intList;
            IntList intList3 = new IntList(this.callerBlocks.size());
            IntList intList4 = intList2;
            int nextSetBit = this.callerBlocks.nextSetBit(0);
            while (true) {
                int i = nextSetBit;
                if (i >= 0) {
                    intList4.add(this.this$0.labelToBlock(i).getSuccessors().get(0));
                    nextSetBit = this.callerBlocks.nextSetBit(i + 1);
                } else {
                    intList4.setImmutable();
                    return intList4;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void mergeToSuccessors(Frame frame, int[] iArr) {
            Frame frame2 = frame;
            int[] iArr2 = iArr;
            int nextSetBit = this.callerBlocks.nextSetBit(0);
            while (true) {
                int i = nextSetBit;
                if (i >= 0) {
                    int i2 = this.this$0.labelToBlock(i).getSuccessors().get(0);
                    Frame subFrameForLabel = frame2.subFrameForLabel(this.startBlock, i);
                    if (subFrameForLabel != null) {
                        this.this$0.mergeAndWorkAsNecessary(i2, -1, null, subFrameForLabel, iArr2);
                    } else {
                        Bits.set(iArr2, i);
                    }
                    nextSetBit = this.callerBlocks.nextSetBit(i + 1);
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$SubroutineInliner */
    private class SubroutineInliner {
        private final LabelAllocator labelAllocator;
        private final ArrayList<IntList> labelToSubroutines;
        private final HashMap<Integer, Integer> origLabelToCopiedLabel;
        private int subroutineStart;
        private int subroutineSuccessor;
        final /* synthetic */ Ropper this$0;
        private final BitSet workList;

        SubroutineInliner(Ropper ropper, LabelAllocator labelAllocator2, ArrayList<IntList> arrayList) {
            HashMap<Integer, Integer> hashMap;
            BitSet bitSet;
            Ropper ropper2 = ropper;
            LabelAllocator labelAllocator3 = labelAllocator2;
            ArrayList<IntList> arrayList2 = arrayList;
            this.this$0 = ropper2;
            HashMap<Integer, Integer> hashMap2 = hashMap;
            HashMap<Integer, Integer> hashMap3 = new HashMap<>();
            this.origLabelToCopiedLabel = hashMap2;
            BitSet bitSet2 = bitSet;
            BitSet bitSet3 = new BitSet(ropper2.maxLabel);
            this.workList = bitSet2;
            this.labelAllocator = labelAllocator3;
            this.labelToSubroutines = arrayList2;
        }

        private void copyBlock(int i, int i2) {
            IntList intList;
            IntList intList2;
            RuntimeException runtimeException;
            StringBuilder sb;
            BasicBlock basicBlock;
            int i3 = i;
            int i4 = i2;
            BasicBlock access$300 = this.this$0.labelToBlock(i3);
            IntList successors = access$300.getSuccessors();
            int i5 = -1;
            if (this.this$0.isSubroutineCaller(access$300)) {
                intList2 = IntList.makeImmutable(mapOrAllocateLabel(successors.get(0)), successors.get(1));
            } else {
                Subroutine access$900 = this.this$0.subroutineFromRetBlock(i3);
                if (access$900 != null) {
                    if (access$900.startBlock != this.subroutineStart) {
                        RuntimeException runtimeException2 = runtimeException;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        RuntimeException runtimeException3 = new RuntimeException(sb2.append("ret instruction returns to label ").append(Hex.m51u2(access$900.startBlock)).append(" expected: ").append(Hex.m51u2(this.subroutineStart)).toString());
                        throw runtimeException2;
                    }
                    intList2 = IntList.makeImmutable(this.subroutineSuccessor);
                    i5 = this.subroutineSuccessor;
                } else {
                    int primarySuccessor = access$300.getPrimarySuccessor();
                    int size = successors.size();
                    IntList intList3 = intList;
                    IntList intList4 = new IntList(size);
                    IntList intList5 = intList3;
                    int i6 = 0;
                    while (i6 < size) {
                        int i7 = successors.get(i6);
                        int mapOrAllocateLabel = mapOrAllocateLabel(i7);
                        intList5.add(mapOrAllocateLabel);
                        if (primarySuccessor != i7) {
                            mapOrAllocateLabel = i5;
                        }
                        i6++;
                        i5 = mapOrAllocateLabel;
                    }
                    intList5.setImmutable();
                    intList2 = intList5;
                }
            }
            Ropper ropper = this.this$0;
            BasicBlock basicBlock2 = basicBlock;
            BasicBlock basicBlock3 = new BasicBlock(i4, this.this$0.filterMoveReturnAddressInsns(access$300.getInsns()), intList2, i5);
            ropper.addBlock(basicBlock2, (IntList) this.labelToSubroutines.get(i4));
        }

        private boolean involvedInSubroutine(int i, int i2) {
            IntList intList = (IntList) this.labelToSubroutines.get(i);
            return intList != null && intList.size() > 0 && intList.top() == i2;
        }

        private int mapOrAllocateLabel(int i) {
            int i2 = i;
            Integer num = (Integer) this.origLabelToCopiedLabel.get(Integer.valueOf(i2));
            if (num != null) {
                i2 = num.intValue();
            } else if (involvedInSubroutine(i2, this.subroutineStart)) {
                int nextLabel = this.labelAllocator.getNextLabel();
                this.workList.set(i2);
                Object put = this.origLabelToCopiedLabel.put(Integer.valueOf(i2), Integer.valueOf(nextLabel));
                while (this.labelToSubroutines.size() <= nextLabel) {
                    boolean add = this.labelToSubroutines.add(null);
                }
                Object obj = this.labelToSubroutines.set(nextLabel, this.labelToSubroutines.get(i2));
                return nextLabel;
            }
            return i2;
        }

        /* access modifiers changed from: 0000 */
        public void inlineSubroutineCalledFrom(BasicBlock basicBlock) {
            BasicBlock basicBlock2;
            SubroutineInliner subroutineInliner;
            BasicBlock basicBlock3 = basicBlock;
            this.subroutineSuccessor = basicBlock3.getSuccessors().get(0);
            this.subroutineStart = basicBlock3.getSuccessors().get(1);
            int mapOrAllocateLabel = mapOrAllocateLabel(this.subroutineStart);
            int nextSetBit = this.workList.nextSetBit(0);
            while (true) {
                int i = nextSetBit;
                if (i >= 0) {
                    this.workList.clear(i);
                    int intValue = ((Integer) this.origLabelToCopiedLabel.get(Integer.valueOf(i))).intValue();
                    copyBlock(i, intValue);
                    if (this.this$0.isSubroutineCaller(this.this$0.labelToBlock(i))) {
                        SubroutineInliner subroutineInliner2 = subroutineInliner;
                        SubroutineInliner subroutineInliner3 = new SubroutineInliner(this.this$0, this.labelAllocator, this.labelToSubroutines);
                        subroutineInliner2.inlineSubroutineCalledFrom(this.this$0.labelToBlock(intValue));
                    }
                    nextSetBit = this.workList.nextSetBit(0);
                } else {
                    Ropper ropper = this.this$0;
                    BasicBlock basicBlock4 = basicBlock2;
                    BasicBlock basicBlock5 = new BasicBlock(basicBlock3.getLabel(), basicBlock3.getInsns(), IntList.makeImmutable(mapOrAllocateLabel), mapOrAllocateLabel);
                    boolean access$800 = ropper.addOrReplaceBlockNoDelete(basicBlock4, (IntList) this.labelToSubroutines.get(basicBlock3.getLabel()));
                    return;
                }
            }
        }
    }

    private Ropper(ConcreteMethod concreteMethod, TranslationAdvice translationAdvice) {
        RopperMachine ropperMachine;
        Simulator simulator;
        ArrayList<BasicBlock> arrayList;
        ArrayList<IntList> arrayList2;
        Frame frame;
        ExceptionSetupLabelAllocator exceptionSetupLabelAllocator2;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        ConcreteMethod concreteMethod2 = concreteMethod;
        TranslationAdvice translationAdvice2 = translationAdvice;
        if (concreteMethod2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("method == null");
            throw nullPointerException3;
        } else if (translationAdvice2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("advice == null");
            throw nullPointerException5;
        } else {
            this.method = concreteMethod2;
            this.blocks = BasicBlocker.identifyBlocks(concreteMethod2);
            this.maxLabel = this.blocks.getMaxLabel();
            this.maxLocals = concreteMethod2.getMaxLocals();
            RopperMachine ropperMachine2 = ropperMachine;
            RopperMachine ropperMachine3 = new RopperMachine(this, concreteMethod2, translationAdvice2);
            this.machine = ropperMachine2;
            Simulator simulator2 = simulator;
            Simulator simulator3 = new Simulator(this.machine, concreteMethod2);
            this.sim = simulator2;
            this.startFrames = new Frame[this.maxLabel];
            this.subroutines = new Subroutine[this.maxLabel];
            ArrayList<BasicBlock> arrayList3 = arrayList;
            ArrayList<BasicBlock> arrayList4 = new ArrayList<>(10 + (2 * this.blocks.size()));
            this.result = arrayList3;
            ArrayList<IntList> arrayList5 = arrayList2;
            ArrayList<IntList> arrayList6 = new ArrayList<>(10 + (2 * this.blocks.size()));
            this.resultSubroutines = arrayList5;
            this.catchInfos = new CatchInfo[this.maxLabel];
            this.synchNeedsExceptionHandler = false;
            Frame[] frameArr = this.startFrames;
            Frame frame2 = frame;
            Frame frame3 = new Frame(this.maxLocals, concreteMethod2.getMaxStack());
            frameArr[0] = frame2;
            ExceptionSetupLabelAllocator exceptionSetupLabelAllocator3 = exceptionSetupLabelAllocator2;
            ExceptionSetupLabelAllocator exceptionSetupLabelAllocator4 = new ExceptionSetupLabelAllocator(this);
            this.exceptionSetupLabelAllocator = exceptionSetupLabelAllocator3;
        }
    }

    static /* synthetic */ boolean access$202(Ropper ropper, boolean z) {
        boolean z2 = z;
        ropper.hasSubroutines = z2;
        return z2;
    }

    /* access modifiers changed from: private */
    public void addBlock(BasicBlock basicBlock, IntList intList) {
        NullPointerException nullPointerException;
        BasicBlock basicBlock2 = basicBlock;
        IntList intList2 = intList;
        if (basicBlock2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("block == null");
            throw nullPointerException2;
        }
        boolean add = this.result.add(basicBlock2);
        intList2.throwIfMutable();
        boolean add2 = this.resultSubroutines.add(intList2);
    }

    private void addExceptionSetupBlocks() {
        InsnList insnList;
        PlainInsn plainInsn;
        PlainInsn plainInsn2;
        BasicBlock basicBlock;
        int length = this.catchInfos.length;
        for (int i = 0; i < length; i++) {
            CatchInfo catchInfo = this.catchInfos[i];
            if (catchInfo != null) {
                for (ExceptionHandlerSetup exceptionHandlerSetup : catchInfo.getSetups()) {
                    SourcePosition position = labelToBlock(i).getFirstInsn().getPosition();
                    InsnList insnList2 = insnList;
                    InsnList insnList3 = new InsnList(2);
                    InsnList insnList4 = insnList2;
                    InsnList insnList5 = insnList4;
                    PlainInsn plainInsn3 = plainInsn;
                    PlainInsn plainInsn4 = new PlainInsn(Rops.opMoveException(exceptionHandlerSetup.getCaughtType()), position, RegisterSpec.make(this.maxLocals, exceptionHandlerSetup.getCaughtType()), RegisterSpecList.EMPTY);
                    insnList5.set(0, plainInsn3);
                    InsnList insnList6 = insnList4;
                    PlainInsn plainInsn5 = plainInsn2;
                    PlainInsn plainInsn6 = new PlainInsn(Rops.GOTO, position, (RegisterSpec) null, RegisterSpecList.EMPTY);
                    insnList6.set(1, plainInsn5);
                    insnList4.setImmutable();
                    BasicBlock basicBlock2 = basicBlock;
                    BasicBlock basicBlock3 = new BasicBlock(exceptionHandlerSetup.getLabel(), insnList4, IntList.makeImmutable(i), i);
                    addBlock(basicBlock2, this.startFrames[i].getSubroutines());
                }
            }
        }
    }

    private boolean addOrReplaceBlock(BasicBlock basicBlock, IntList intList) {
        boolean z;
        NullPointerException nullPointerException;
        BasicBlock basicBlock2 = basicBlock;
        IntList intList2 = intList;
        if (basicBlock2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("block == null");
            throw nullPointerException2;
        }
        int labelToResultIndex = labelToResultIndex(basicBlock2.getLabel());
        if (labelToResultIndex < 0) {
            z = false;
        } else {
            removeBlockAndSpecialSuccessors(labelToResultIndex);
            z = true;
        }
        boolean add = this.result.add(basicBlock2);
        intList2.throwIfMutable();
        boolean add2 = this.resultSubroutines.add(intList2);
        return z;
    }

    /* access modifiers changed from: private */
    public boolean addOrReplaceBlockNoDelete(BasicBlock basicBlock, IntList intList) {
        boolean z;
        NullPointerException nullPointerException;
        BasicBlock basicBlock2 = basicBlock;
        IntList intList2 = intList;
        if (basicBlock2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("block == null");
            throw nullPointerException2;
        }
        int labelToResultIndex = labelToResultIndex(basicBlock2.getLabel());
        if (labelToResultIndex < 0) {
            z = false;
        } else {
            Object remove = this.result.remove(labelToResultIndex);
            Object remove2 = this.resultSubroutines.remove(labelToResultIndex);
            z = true;
        }
        boolean add = this.result.add(basicBlock2);
        intList2.throwIfMutable();
        boolean add2 = this.resultSubroutines.add(intList2);
        return z;
    }

    private void addReturnBlock() {
        int i;
        InsnList insnList;
        PlainInsn plainInsn;
        BasicBlock basicBlock;
        InsnList insnList2;
        ThrowingInsn throwingInsn;
        BasicBlock basicBlock2;
        Rop returnOp = this.machine.getReturnOp();
        if (returnOp != null) {
            SourcePosition returnPosition = this.machine.getReturnPosition();
            int specialLabel = getSpecialLabel(-2);
            if (isSynchronized()) {
                InsnList insnList3 = insnList2;
                InsnList insnList4 = new InsnList(1);
                InsnList insnList5 = insnList3;
                InsnList insnList6 = insnList5;
                ThrowingInsn throwingInsn2 = throwingInsn;
                ThrowingInsn throwingInsn3 = new ThrowingInsn(Rops.MONITOR_EXIT, returnPosition, RegisterSpecList.make(getSynchReg()), StdTypeList.EMPTY);
                insnList6.set(0, throwingInsn2);
                insnList5.setImmutable();
                i = getSpecialLabel(-3);
                BasicBlock basicBlock3 = basicBlock2;
                BasicBlock basicBlock4 = new BasicBlock(specialLabel, insnList5, IntList.makeImmutable(i), i);
                addBlock(basicBlock3, IntList.EMPTY);
            } else {
                i = specialLabel;
            }
            InsnList insnList7 = insnList;
            InsnList insnList8 = new InsnList(1);
            InsnList insnList9 = insnList7;
            TypeList sources = returnOp.getSources();
            InsnList insnList10 = insnList9;
            PlainInsn plainInsn2 = plainInsn;
            PlainInsn plainInsn3 = new PlainInsn(returnOp, returnPosition, (RegisterSpec) null, sources.size() == 0 ? RegisterSpecList.EMPTY : RegisterSpecList.make(RegisterSpec.make(0, sources.getType(0))));
            insnList10.set(0, plainInsn2);
            insnList9.setImmutable();
            BasicBlock basicBlock5 = basicBlock;
            BasicBlock basicBlock6 = new BasicBlock(i, insnList9, IntList.EMPTY, -1);
            addBlock(basicBlock5, IntList.EMPTY);
        }
    }

    private void addSetupBlocks() {
        InsnList insnList;
        PlainInsn plainInsn;
        BasicBlock basicBlock;
        InsnList insnList2;
        PlainCstInsn plainCstInsn;
        PlainInsn plainInsn2;
        InsnList insnList3;
        BasicBlock basicBlock2;
        InsnList insnList4;
        ThrowingInsn throwingInsn;
        BasicBlock basicBlock3;
        PlainInsn plainInsn3;
        ThrowingCstInsn throwingCstInsn;
        InsnList insnList5;
        PlainCstInsn plainCstInsn2;
        LocalVariableList localVariables = this.method.getLocalVariables();
        SourcePosition makeSourcePosistion = this.method.makeSourcePosistion(0);
        StdTypeList parameterTypes = this.method.getEffectiveDescriptor().getParameterTypes();
        int size = parameterTypes.size();
        InsnList insnList6 = insnList;
        InsnList insnList7 = new InsnList(size + 1);
        InsnList insnList8 = insnList6;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= size) {
                break;
            }
            Type type = parameterTypes.get(i);
            Item pcAndIndexToLocal = localVariables.pcAndIndexToLocal(0, i3);
            InsnList insnList9 = insnList8;
            int i4 = i;
            PlainCstInsn plainCstInsn3 = plainCstInsn2;
            PlainCstInsn plainCstInsn4 = new PlainCstInsn(Rops.opMoveParam(type), makeSourcePosistion, pcAndIndexToLocal == null ? RegisterSpec.make(i3, type) : RegisterSpec.makeLocalOptional(i3, type, pcAndIndexToLocal.getLocalItem()), RegisterSpecList.EMPTY, CstInteger.make(i3));
            insnList9.set(i4, plainCstInsn3);
            i++;
            i2 = i3 + type.getCategory();
        }
        InsnList insnList10 = insnList8;
        int i5 = size;
        PlainInsn plainInsn4 = plainInsn;
        PlainInsn plainInsn5 = new PlainInsn(Rops.GOTO, makeSourcePosistion, (RegisterSpec) null, RegisterSpecList.EMPTY);
        insnList10.set(i5, plainInsn4);
        insnList8.setImmutable();
        boolean isSynchronized = isSynchronized();
        int i6 = isSynchronized ? getSpecialLabel(-4) : 0;
        BasicBlock basicBlock4 = basicBlock;
        BasicBlock basicBlock5 = new BasicBlock(getSpecialLabel(-1), insnList8, IntList.makeImmutable(i6), i6);
        addBlock(basicBlock4, IntList.EMPTY);
        if (isSynchronized) {
            RegisterSpec synchReg = getSynchReg();
            if (isStatic()) {
                ThrowingCstInsn throwingCstInsn2 = throwingCstInsn;
                ThrowingCstInsn throwingCstInsn3 = new ThrowingCstInsn(Rops.CONST_OBJECT, makeSourcePosistion, RegisterSpecList.EMPTY, StdTypeList.EMPTY, this.method.getDefiningClass());
                ThrowingCstInsn throwingCstInsn4 = throwingCstInsn2;
                InsnList insnList11 = insnList5;
                InsnList insnList12 = new InsnList(1);
                InsnList insnList13 = insnList11;
                insnList13.set(0, throwingCstInsn4);
                insnList3 = insnList13;
            } else {
                InsnList insnList14 = insnList2;
                InsnList insnList15 = new InsnList(2);
                InsnList insnList16 = insnList14;
                InsnList insnList17 = insnList16;
                PlainCstInsn plainCstInsn5 = plainCstInsn;
                PlainCstInsn plainCstInsn6 = new PlainCstInsn(Rops.MOVE_PARAM_OBJECT, makeSourcePosistion, synchReg, RegisterSpecList.EMPTY, CstInteger.VALUE_0);
                insnList17.set(0, plainCstInsn5);
                InsnList insnList18 = insnList16;
                PlainInsn plainInsn6 = plainInsn2;
                PlainInsn plainInsn7 = new PlainInsn(Rops.GOTO, makeSourcePosistion, (RegisterSpec) null, RegisterSpecList.EMPTY);
                insnList18.set(1, plainInsn6);
                insnList3 = insnList16;
            }
            int specialLabel = getSpecialLabel(-5);
            insnList3.setImmutable();
            BasicBlock basicBlock6 = basicBlock2;
            BasicBlock basicBlock7 = new BasicBlock(i6, insnList3, IntList.makeImmutable(specialLabel), specialLabel);
            addBlock(basicBlock6, IntList.EMPTY);
            InsnList insnList19 = insnList4;
            InsnList insnList20 = new InsnList(isStatic() ? 2 : 1);
            InsnList insnList21 = insnList19;
            if (isStatic()) {
                InsnList insnList22 = insnList21;
                PlainInsn plainInsn8 = plainInsn3;
                PlainInsn plainInsn9 = new PlainInsn(Rops.opMoveResultPseudo(synchReg), makeSourcePosistion, synchReg, RegisterSpecList.EMPTY);
                insnList22.set(0, plainInsn8);
            }
            ThrowingInsn throwingInsn2 = throwingInsn;
            ThrowingInsn throwingInsn3 = new ThrowingInsn(Rops.MONITOR_ENTER, makeSourcePosistion, RegisterSpecList.make(synchReg), StdTypeList.EMPTY);
            insnList21.set(isStatic() ? 1 : 0, throwingInsn2);
            insnList21.setImmutable();
            BasicBlock basicBlock8 = basicBlock3;
            BasicBlock basicBlock9 = new BasicBlock(specialLabel, insnList21, IntList.makeImmutable(0), 0);
            addBlock(basicBlock8, IntList.EMPTY);
        }
    }

    private void addSynchExceptionHandlerBlock() {
        InsnList insnList;
        PlainInsn plainInsn;
        ThrowingInsn throwingInsn;
        BasicBlock basicBlock;
        InsnList insnList2;
        ThrowingInsn throwingInsn2;
        BasicBlock basicBlock2;
        if (this.synchNeedsExceptionHandler) {
            SourcePosition makeSourcePosistion = this.method.makeSourcePosistion(0);
            RegisterSpec make = RegisterSpec.make(0, Type.THROWABLE);
            InsnList insnList3 = insnList;
            InsnList insnList4 = new InsnList(2);
            InsnList insnList5 = insnList3;
            InsnList insnList6 = insnList5;
            PlainInsn plainInsn2 = plainInsn;
            PlainInsn plainInsn3 = new PlainInsn(Rops.opMoveException(Type.THROWABLE), makeSourcePosistion, make, RegisterSpecList.EMPTY);
            insnList6.set(0, plainInsn2);
            InsnList insnList7 = insnList5;
            ThrowingInsn throwingInsn3 = throwingInsn;
            ThrowingInsn throwingInsn4 = new ThrowingInsn(Rops.MONITOR_EXIT, makeSourcePosistion, RegisterSpecList.make(getSynchReg()), StdTypeList.EMPTY);
            insnList7.set(1, throwingInsn3);
            insnList5.setImmutable();
            int specialLabel = getSpecialLabel(-7);
            BasicBlock basicBlock3 = basicBlock;
            BasicBlock basicBlock4 = new BasicBlock(getSpecialLabel(-6), insnList5, IntList.makeImmutable(specialLabel), specialLabel);
            addBlock(basicBlock3, IntList.EMPTY);
            InsnList insnList8 = insnList2;
            InsnList insnList9 = new InsnList(1);
            InsnList insnList10 = insnList8;
            InsnList insnList11 = insnList10;
            ThrowingInsn throwingInsn5 = throwingInsn2;
            ThrowingInsn throwingInsn6 = new ThrowingInsn(Rops.THROW, makeSourcePosistion, RegisterSpecList.make(make), StdTypeList.EMPTY);
            insnList11.set(0, throwingInsn5);
            insnList10.setImmutable();
            BasicBlock basicBlock5 = basicBlock2;
            BasicBlock basicBlock6 = new BasicBlock(specialLabel, insnList10, IntList.EMPTY, -1);
            addBlock(basicBlock5, IntList.EMPTY);
        }
    }

    public static RopMethod convert(ConcreteMethod concreteMethod, TranslationAdvice translationAdvice) {
        StringBuilder sb;
        Ropper ropper;
        ConcreteMethod concreteMethod2 = concreteMethod;
        try {
            Ropper ropper2 = ropper;
            Ropper ropper3 = new Ropper(concreteMethod2, translationAdvice);
            Ropper ropper4 = ropper2;
            ropper4.doit();
            return ropper4.getRopMethod();
        } catch (SimException e) {
            SimException simException = e;
            SimException simException2 = simException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            simException2.addContext(sb2.append("...while working on method ").append(concreteMethod2.getNat().toHuman()).toString());
            throw simException;
        }
    }

    private void deleteUnreachableBlocks() {
        IntList intList;
        C06512 r9;
        IntList intList2 = intList;
        IntList intList3 = new IntList(this.result.size());
        IntList intList4 = intList2;
        this.resultSubroutines.clear();
        int specialLabel = getSpecialLabel(-1);
        C06512 r5 = r9;
        final IntList intList5 = intList4;
        C06512 r6 = new Visitor(this) {
            final /* synthetic */ Ropper this$0;

            {
                IntList intList = r7;
                this.this$0 = r6;
            }

            public void visitBlock(BasicBlock basicBlock) {
                intList5.add(basicBlock.getLabel());
            }
        };
        forEachNonSubBlockDepthFirst(specialLabel, r5);
        intList4.sort();
        for (int size = -1 + this.result.size(); size >= 0; size--) {
            if (intList4.indexOf(((BasicBlock) this.result.get(size)).getLabel()) < 0) {
                Object remove = this.result.remove(size);
            }
        }
    }

    private void doit() {
        StringBuilder sb;
        int[] makeBitSet = Bits.makeBitSet(this.maxLabel);
        Bits.set(makeBitSet, 0);
        addSetupBlocks();
        setFirstFrame();
        while (true) {
            int findFirst = Bits.findFirst(makeBitSet, 0);
            if (findFirst < 0) {
                break;
            }
            Bits.clear(makeBitSet, findFirst);
            try {
                processBlock(this.blocks.labelToBlock(findFirst), this.startFrames[findFirst], makeBitSet);
            } catch (SimException e) {
                SimException simException = e;
                SimException simException2 = simException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                simException2.addContext(sb2.append("...while working on block ").append(Hex.m51u2(findFirst)).toString());
                throw simException;
            }
        }
        addReturnBlock();
        addSynchExceptionHandlerBlock();
        addExceptionSetupBlocks();
        if (this.hasSubroutines) {
            inlineSubroutines();
        }
    }

    /* access modifiers changed from: private */
    public InsnList filterMoveReturnAddressInsns(InsnList insnList) {
        InsnList insnList2;
        int i;
        InsnList insnList3 = insnList;
        int i2 = 0;
        int size = insnList3.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (insnList3.get(i4).getOpcode() != Rops.MOVE_RETURN_ADDRESS) {
                i3++;
            }
        }
        if (i3 == size) {
            return insnList3;
        }
        InsnList insnList4 = insnList2;
        InsnList insnList5 = new InsnList(i3);
        InsnList insnList6 = insnList4;
        int i5 = 0;
        while (i5 < size) {
            Insn insn = insnList3.get(i5);
            if (insn.getOpcode() != Rops.MOVE_RETURN_ADDRESS) {
                i = i2 + 1;
                insnList6.set(i2, insn);
            } else {
                i = i2;
            }
            i5++;
            i2 = i;
        }
        insnList6.setImmutable();
        return insnList6;
    }

    private void forEachNonSubBlockDepthFirst(int i, Visitor visitor) {
        BitSet bitSet;
        Visitor visitor2 = visitor;
        BasicBlock labelToBlock = labelToBlock(i);
        Visitor visitor3 = visitor2;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(this.maxLabel);
        forEachNonSubBlockDepthFirst0(labelToBlock, visitor3, bitSet2);
    }

    private void forEachNonSubBlockDepthFirst0(BasicBlock basicBlock, Visitor visitor, BitSet bitSet) {
        BasicBlock basicBlock2 = basicBlock;
        Visitor visitor2 = visitor;
        BitSet bitSet2 = bitSet;
        visitor2.visitBlock(basicBlock2);
        bitSet2.set(basicBlock2.getLabel());
        IntList successors = basicBlock2.getSuccessors();
        int size = successors.size();
        for (int i = 0; i < size; i++) {
            int i2 = successors.get(i);
            if (!bitSet2.get(i2) && (!isSubroutineCaller(basicBlock2) || i <= 0)) {
                int labelToResultIndex = labelToResultIndex(i2);
                if (labelToResultIndex >= 0) {
                    forEachNonSubBlockDepthFirst0((BasicBlock) this.result.get(labelToResultIndex), visitor2, bitSet2);
                }
            }
        }
    }

    private int getAvailableLabel() {
        int minimumUnreservedLabel = getMinimumUnreservedLabel();
        Iterator it = this.result.iterator();
        int i = minimumUnreservedLabel;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            int label = ((BasicBlock) it.next()).getLabel();
            i = label >= i2 ? label + 1 : i2;
        }
    }

    private int getMinimumUnreservedLabel() {
        return 7 + this.maxLabel + this.method.getCatches().size();
    }

    private int getNormalRegCount() {
        return this.maxLocals + this.method.getMaxStack();
    }

    private RopMethod getRopMethod() {
        BasicBlockList basicBlockList;
        RopMethod ropMethod;
        int size = this.result.size();
        BasicBlockList basicBlockList2 = basicBlockList;
        BasicBlockList basicBlockList3 = new BasicBlockList(size);
        BasicBlockList basicBlockList4 = basicBlockList2;
        for (int i = 0; i < size; i++) {
            basicBlockList4.set(i, (BasicBlock) this.result.get(i));
        }
        basicBlockList4.setImmutable();
        RopMethod ropMethod2 = ropMethod;
        RopMethod ropMethod3 = new RopMethod(basicBlockList4, getSpecialLabel(-1));
        return ropMethod2;
    }

    private int getSpecialLabel(int i) {
        return this.maxLabel + this.method.getCatches().size() + (i ^ -1);
    }

    private RegisterSpec getSynchReg() {
        int i = 1;
        int normalRegCount = getNormalRegCount();
        if (normalRegCount >= 1) {
            i = normalRegCount;
        }
        return RegisterSpec.make(i, Type.OBJECT);
    }

    private void inlineSubroutines() {
        IntList intList;
        C06501 r17;
        ArrayList arrayList;
        SubroutineInliner subroutineInliner;
        LabelAllocator labelAllocator;
        IntList intList2 = intList;
        IntList intList3 = new IntList(4);
        IntList intList4 = intList2;
        C06501 r13 = r17;
        final IntList intList5 = intList4;
        C06501 r14 = new Visitor(this) {
            final /* synthetic */ Ropper this$0;

            {
                IntList intList = r7;
                this.this$0 = r6;
            }

            public void visitBlock(BasicBlock basicBlock) {
                BasicBlock basicBlock2 = basicBlock;
                if (this.this$0.isSubroutineCaller(basicBlock2)) {
                    intList5.add(basicBlock2.getLabel());
                }
            }
        };
        forEachNonSubBlockDepthFirst(0, r13);
        int availableLabel = getAvailableLabel();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(availableLabel);
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < availableLabel; i++) {
            boolean add = arrayList4.add(null);
        }
        for (int i2 = 0; i2 < this.result.size(); i2++) {
            BasicBlock basicBlock = (BasicBlock) this.result.get(i2);
            if (basicBlock != null) {
                Object obj = arrayList4.set(basicBlock.getLabel(), (IntList) this.resultSubroutines.get(i2));
            }
        }
        int size = intList4.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = intList4.get(i3);
            SubroutineInliner subroutineInliner2 = subroutineInliner;
            LabelAllocator labelAllocator2 = labelAllocator;
            LabelAllocator labelAllocator3 = new LabelAllocator(getAvailableLabel());
            SubroutineInliner subroutineInliner3 = new SubroutineInliner(this, labelAllocator2, arrayList4);
            subroutineInliner2.inlineSubroutineCalledFrom(labelToBlock(i4));
        }
        deleteUnreachableBlocks();
    }

    private boolean isStatic() {
        return (8 & this.method.getAccessFlags()) != 0;
    }

    /* access modifiers changed from: private */
    public boolean isSubroutineCaller(BasicBlock basicBlock) {
        boolean z = true;
        IntList successors = basicBlock.getSuccessors();
        if (successors.size() < 2) {
            return false;
        }
        int i = successors.get(1);
        if (i >= this.subroutines.length || this.subroutines[i] == null) {
            z = false;
        }
        return z;
    }

    private boolean isSynchronized() {
        return (32 & this.method.getAccessFlags()) != 0;
    }

    /* access modifiers changed from: private */
    public BasicBlock labelToBlock(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        int labelToResultIndex = labelToResultIndex(i2);
        if (labelToResultIndex >= 0) {
            return (BasicBlock) this.result.get(labelToResultIndex);
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("no such label ").append(Hex.m51u2(i2)).toString());
        throw illegalArgumentException2;
    }

    private int labelToResultIndex(int i) {
        int i2 = i;
        int size = this.result.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((BasicBlock) this.result.get(i3)).getLabel() == i2) {
                return i3;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void mergeAndWorkAsNecessary(int i, int i2, Subroutine subroutine, Frame frame, int[] iArr) {
        int i3 = i;
        int i4 = i2;
        Subroutine subroutine2 = subroutine;
        Frame frame2 = frame;
        int[] iArr2 = iArr;
        Frame frame3 = this.startFrames[i3];
        if (frame3 != null) {
            Frame mergeWith = subroutine2 != null ? frame3.mergeWithSubroutineCaller(frame2, subroutine2.getStartBlock(), i4) : frame3.mergeWith(frame2);
            if (mergeWith != frame3) {
                this.startFrames[i3] = mergeWith;
                Bits.set(iArr2, i3);
                return;
            }
            return;
        }
        if (subroutine2 != null) {
            this.startFrames[i3] = frame2.makeNewSubroutineStartFrame(i3, i4);
        } else {
            this.startFrames[i3] = frame2;
        }
        Bits.set(iArr2, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0528 A[LOOP:4: B:107:0x051e->B:109:0x0528, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x054d  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x04ca A[EDGE_INSN: B:125:0x04ca->B:95:0x04ca ?: BREAK  
    EDGE_INSN: B:125:0x04ca->B:95:0x04ca ?: BREAK  
    EDGE_INSN: B:125:0x04ca->B:95:0x04ca ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x04ca A[EDGE_INSN: B:125:0x04ca->B:95:0x04ca ?: BREAK  
    EDGE_INSN: B:125:0x04ca->B:95:0x04ca ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x04ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processBlock(net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteBlock r73, net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Frame r74, int[] r75) {
        /*
            r72 = this;
            r2 = r72
            r3 = r73
            r4 = r74
            r5 = r75
            r63 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ByteCatchList r63 = r63.getCatches()
            r6 = r63
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            r64 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeList r64 = r64.toRopCatchList()
            r63.startBlock(r64)
            r63 = r4
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Frame r63 = r63.copy()
            r7 = r63
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Simulator r0 = r0.sim
            r63 = r0
            r64 = r3
            r65 = r7
            r63.simulate(r64, r65)
            r63 = r7
            r63.setImmutable()
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            int r63 = r63.getExtraBlockCount()
            r8 = r63
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            java.util.ArrayList r63 = r63.getInsns()
            r9 = r63
            r63 = r9
            int r63 = r63.size()
            r10 = r63
            r63 = r6
            int r63 = r63.size()
            r11 = r63
            r63 = r3
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r63 = r63.getSuccessors()
            r12 = r63
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            boolean r63 = r63.hasJsr()
            if (r63 == 0) goto L_0x0113
            r63 = 1
            r14 = r63
            r63 = r12
            r64 = 1
            int r63 = r63.get(r64)
            r62 = r63
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r62
            r63 = r63[r64]
            if (r63 != 0) goto L_0x00b6
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r62
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine r65 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine
            r71 = r65
            r65 = r71
            r66 = r71
            r67 = r2
            r68 = r62
            r66.<init>(r67, r68)
            r63[r64] = r65
        L_0x00b6:
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r62
            r63 = r63[r64]
            r64 = r3
            int r64 = r64.getLabel()
            r63.addCallerBlock(r64)
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r62
            r63 = r63[r64]
            r15 = r63
            r63 = r12
            r13 = r63
        L_0x00dd:
            r63 = r13
            int r63 = r63.size()
            r16 = r63
            r63 = r14
            r17 = r63
        L_0x00e9:
            r63 = r17
            r64 = r16
            r0 = r63
            r1 = r64
            if (r0 >= r1) goto L_0x0203
            r63 = r13
            r64 = r17
            int r63 = r63.get(r64)
            r58 = r63
            r63 = r2
            r64 = r58
            r65 = r3
            int r65 = r65.getLabel()     // Catch:{ SimException -> 0x01d9 }
            r66 = r15
            r67 = r7
            r68 = r5
            r63.mergeAndWorkAsNecessary(r64, r65, r66, r67, r68)     // Catch:{ SimException -> 0x01d9 }
            int r17 = r17 + 1
            goto L_0x00e9
        L_0x0113:
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            boolean r63 = r63.hasRet()
            if (r63 == 0) goto L_0x01af
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ReturnAddress r63 = r63.getReturnAddress()
            int r63 = r63.getSubroutineAddress()
            r60 = r63
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r60
            r63 = r63[r64]
            if (r63 != 0) goto L_0x0199
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r60
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine r65 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine
            r71 = r65
            r65 = r71
            r66 = r71
            r67 = r2
            r68 = r60
            r69 = r3
            int r69 = r69.getLabel()
            r66.<init>(r67, r68, r69)
            r63[r64] = r65
        L_0x0162:
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r60
            r63 = r63[r64]
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r63 = r63.getSuccessors()
            r61 = r63
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r60
            r63 = r63[r64]
            r64 = r7
            r65 = r5
            r63.mergeToSuccessors(r64, r65)
            r63 = r61
            int r63 = r63.size()
            r14 = r63
            r63 = r61
            r13 = r63
            r63 = 0
            r15 = r63
            goto L_0x00dd
        L_0x0199:
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$Subroutine[] r0 = r0.subroutines
            r63 = r0
            r64 = r60
            r63 = r63[r64]
            r64 = r3
            int r64 = r64.getLabel()
            r63.addRetBlock(r64)
            goto L_0x0162
        L_0x01af:
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            boolean r63 = r63.wereCatchesUsed()
            if (r63 == 0) goto L_0x01cb
            r63 = r11
            r14 = r63
            r63 = r12
            r13 = r63
            r63 = 0
            r15 = r63
            goto L_0x00dd
        L_0x01cb:
            r63 = r12
            r13 = r63
            r63 = 0
            r14 = r63
            r63 = 0
            r15 = r63
            goto L_0x00dd
        L_0x01d9:
            r63 = move-exception
            r59 = r63
            r63 = r59
            java.lang.StringBuilder r64 = new java.lang.StringBuilder
            r71 = r64
            r64 = r71
            r65 = r71
            r65.<init>()
            java.lang.String r65 = "...while merging to block "
            java.lang.StringBuilder r64 = r64.append(r65)
            r65 = r58
            java.lang.String r65 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r65)
            java.lang.StringBuilder r64 = r64.append(r65)
            java.lang.String r64 = r64.toString()
            r63.addContext(r64)
            r63 = r59
            throw r63
        L_0x0203:
            r63 = r16
            if (r63 != 0) goto L_0x0591
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            boolean r63 = r63.returns()
            if (r63 == 0) goto L_0x0591
            r63 = r2
            r64 = -2
            int r63 = r63.getSpecialLabel(r64)
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r63 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList.makeImmutable(r63)
            r57 = r63
            r63 = 1
            r18 = r63
            r63 = r57
            r19 = r63
        L_0x022b:
            r63 = r18
            if (r63 != 0) goto L_0x0311
            r63 = -1
            r21 = r63
        L_0x0233:
            r63 = r2
            boolean r63 = r63.isSynchronized()
            if (r63 == 0) goto L_0x032f
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            boolean r63 = r63.canThrow()
            if (r63 == 0) goto L_0x032f
            r63 = 1
            r22 = r63
        L_0x024d:
            r63 = r22
            if (r63 != 0) goto L_0x0255
            r63 = r11
            if (r63 == 0) goto L_0x0585
        L_0x0255:
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r63 = new net.zhuoweizhang.boardwalk.com.android.dx.util.IntList
            r71 = r63
            r63 = r71
            r64 = r71
            r65 = r18
            r64.<init>(r65)
            r23 = r63
            r63 = 0
            r24 = r63
            r63 = 0
            r25 = r63
        L_0x026c:
            r63 = r25
            r64 = r11
            r0 = r63
            r1 = r64
            if (r0 >= r1) goto L_0x0365
            r63 = r6
            r64 = r25
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ByteCatchList$Item r63 = r63.get(r64)
            r49 = r63
            r63 = r49
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r63 = r63.getExceptionClass()
            r50 = r63
            r63 = r49
            int r63 = r63.getHandlerPc()
            r51 = r63
            r63 = r50
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r64 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.OBJECT
            r0 = r63
            r1 = r64
            if (r0 != r1) goto L_0x0335
            r63 = 1
            r52 = r63
        L_0x029e:
            r63 = r24
            r64 = r52
            r63 = r63 | r64
            r53 = r63
            r63 = r7
            r64 = r50
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Frame r63 = r63.makeExceptionHandlerStartFrame(r64)
            r54 = r63
            r63 = r2
            r64 = r51
            r65 = r3
            int r65 = r65.getLabel()     // Catch:{ SimException -> 0x033b }
            r66 = 0
            r67 = r54
            r68 = r5
            r63.mergeAndWorkAsNecessary(r64, r65, r66, r67, r68)     // Catch:{ SimException -> 0x033b }
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$CatchInfo[] r0 = r0.catchInfos
            r63 = r0
            r64 = r51
            r63 = r63[r64]
            r56 = r63
            r63 = r56
            if (r63 != 0) goto L_0x02f4
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$CatchInfo r63 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$CatchInfo
            r71 = r63
            r63 = r71
            r64 = r71
            r65 = r2
            r66 = 0
            r64.<init>(r65, r66)
            r56 = r63
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$CatchInfo[] r0 = r0.catchInfos
            r63 = r0
            r64 = r51
            r65 = r56
            r63[r64] = r65
        L_0x02f4:
            r63 = r23
            r64 = r56
            r65 = r50
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r65 = r65.getClassType()
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Ropper$ExceptionHandlerSetup r64 = r64.getSetup(r65)
            int r64 = r64.getLabel()
            r63.add(r64)
            int r25 = r25 + 1
            r63 = r53
            r24 = r63
            goto L_0x026c
        L_0x0311:
            r63 = r2
            r0 = r63
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.RopperMachine r0 = r0.machine
            r63 = r0
            int r63 = r63.getPrimarySuccessorIndex()
            r20 = r63
            r63 = r20
            if (r63 < 0) goto L_0x058b
            r63 = r19
            r64 = r20
            int r63 = r63.get(r64)
            r21 = r63
            goto L_0x0233
        L_0x032f:
            r63 = 0
            r22 = r63
            goto L_0x024d
        L_0x0335:
            r63 = 0
            r52 = r63
            goto L_0x029e
        L_0x033b:
            r63 = move-exception
            r55 = r63
            r63 = r55
            java.lang.StringBuilder r64 = new java.lang.StringBuilder
            r71 = r64
            r64 = r71
            r65 = r71
            r65.<init>()
            java.lang.String r65 = "...while merging exception to block "
            java.lang.StringBuilder r64 = r64.append(r65)
            r65 = r51
            java.lang.String r65 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r65)
            java.lang.StringBuilder r64 = r64.append(r65)
            java.lang.String r64 = r64.toString()
            r63.addContext(r64)
            r63 = r55
            throw r63
        L_0x0365:
            r63 = r22
            if (r63 == 0) goto L_0x03c1
            r63 = r24
            if (r63 != 0) goto L_0x03c1
            r63 = r23
            r64 = r2
            r65 = -6
            int r64 = r64.getSpecialLabel(r65)
            r63.add(r64)
            r63 = r2
            r64 = 1
            r0 = r64
            r1 = r63
            r1.synchNeedsExceptionHandler = r0
            r63 = -1
            r64 = r10
            r65 = r8
            int r64 = r64 - r65
            int r63 = r63 + r64
            r46 = r63
        L_0x0390:
            r63 = r46
            r64 = r10
            r0 = r63
            r1 = r64
            if (r0 >= r1) goto L_0x03c1
            r63 = r9
            r64 = r46
            java.lang.Object r63 = r63.get(r64)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r63 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn) r63
            r47 = r63
            r63 = r47
            boolean r63 = r63.canThrow()
            if (r63 == 0) goto L_0x03be
            r63 = r9
            r64 = r46
            r65 = r47
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r66 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.OBJECT
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r65 = r65.withAddedCatch(r66)
            java.lang.Object r63 = r63.set(r64, r65)
        L_0x03be:
            int r46 = r46 + 1
            goto L_0x0390
        L_0x03c1:
            r63 = r21
            if (r63 < 0) goto L_0x03cc
            r63 = r23
            r64 = r21
            r63.add(r64)
        L_0x03cc:
            r63 = r23
            r63.setImmutable()
            r63 = r23
            r26 = r63
        L_0x03d5:
            r63 = r26
            r64 = r21
            int r63 = r63.indexOf(r64)
            r27 = r63
            r63 = r21
            r28 = r63
            r63 = r26
            r29 = r63
            r63 = r8
            r30 = r63
            r63 = r10
            r31 = r63
        L_0x03ef:
            r63 = r30
            if (r63 <= 0) goto L_0x04ca
            r63 = r31
            r64 = 1
            int r63 = r63 + -1
            r38 = r63
            r63 = r9
            r64 = r38
            java.lang.Object r63 = r63.get(r64)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r63 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn) r63
            r39 = r63
            r63 = r39
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r63 = r63.getOpcode()
            int r63 = r63.getBranchingness()
            r64 = 1
            r0 = r63
            r1 = r64
            if (r0 != r1) goto L_0x04be
            r63 = 1
            r40 = r63
        L_0x041d:
            r63 = r40
            if (r63 == 0) goto L_0x04c4
            r63 = 2
            r41 = r63
        L_0x0425:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.InsnList r63 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.InsnList
            r71 = r63
            r63 = r71
            r64 = r71
            r65 = r41
            r64.<init>(r65)
            r42 = r63
            r63 = r42
            r64 = 0
            r65 = r39
            r63.set(r64, r65)
            r63 = r40
            if (r63 == 0) goto L_0x057f
            r63 = r42
            r64 = 1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r65 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r71 = r65
            r65 = r71
            r66 = r71
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r67 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.GOTO
            r68 = r39
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r68 = r68.getPosition()
            r69 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r70 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r66.<init>(r67, r68, r69, r70)
            r63.set(r64, r65)
            r63 = r28
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r63 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList.makeImmutable(r63)
            r43 = r63
        L_0x0467:
            r63 = r42
            r63.setImmutable()
            r63 = r2
            int r63 = r63.getAvailableLabel()
            r44 = r63
            r63 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlock r64 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlock
            r71 = r64
            r64 = r71
            r65 = r71
            r66 = r44
            r67 = r42
            r68 = r43
            r69 = r28
            r65.<init>(r66, r67, r68, r69)
            r65 = r7
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r65 = r65.getSubroutines()
            r63.addBlock(r64, r65)
            r63 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r63 = r63.mutableCopy()
            r29 = r63
            r63 = r29
            r64 = r27
            r65 = r44
            r63.set(r64, r65)
            r63 = r29
            r63.setImmutable()
            r63 = r30
            r64 = 1
            int r63 = r63 + -1
            r45 = r63
            r63 = r44
            r28 = r63
            r63 = r45
            r30 = r63
            r63 = r38
            r31 = r63
            goto L_0x03ef
        L_0x04be:
            r63 = 0
            r40 = r63
            goto L_0x041d
        L_0x04c4:
            r63 = 1
            r41 = r63
            goto L_0x0425
        L_0x04ca:
            r63 = r31
            if (r63 != 0) goto L_0x053c
            r63 = 0
            r32 = r63
        L_0x04d2:
            r63 = r32
            if (r63 == 0) goto L_0x04e8
            r63 = r32
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r63 = r63.getOpcode()
            int r63 = r63.getBranchingness()
            r64 = 1
            r0 = r63
            r1 = r64
            if (r0 != r1) goto L_0x050b
        L_0x04e8:
            r63 = r32
            if (r63 != 0) goto L_0x054d
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r63 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition.NO_INFO
            r33 = r63
        L_0x04f0:
            r63 = r9
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r64 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r71 = r64
            r64 = r71
            r65 = r71
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r66 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.GOTO
            r67 = r33
            r68 = 0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r69 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.EMPTY
            r65.<init>(r66, r67, r68, r69)
            boolean r63 = r63.add(r64)
            int r31 = r31 + 1
        L_0x050b:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.InsnList r63 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.InsnList
            r71 = r63
            r63 = r71
            r64 = r71
            r65 = r31
            r64.<init>(r65)
            r35 = r63
            r63 = 0
            r36 = r63
        L_0x051e:
            r63 = r36
            r64 = r31
            r0 = r63
            r1 = r64
            if (r0 >= r1) goto L_0x0556
            r63 = r35
            r64 = r36
            r65 = r9
            r66 = r36
            java.lang.Object r65 = r65.get(r66)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r65 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn) r65
            r63.set(r64, r65)
            int r36 = r36 + 1
            goto L_0x051e
        L_0x053c:
            r63 = r9
            r64 = r31
            r65 = 1
            int r64 = r64 + -1
            java.lang.Object r63 = r63.get(r64)
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r63 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn) r63
            r32 = r63
            goto L_0x04d2
        L_0x054d:
            r63 = r32
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r63 = r63.getPosition()
            r33 = r63
            goto L_0x04f0
        L_0x0556:
            r63 = r35
            r63.setImmutable()
            r63 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlock r64 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.BasicBlock
            r71 = r64
            r64 = r71
            r65 = r71
            r66 = r3
            int r66 = r66.getLabel()
            r67 = r35
            r68 = r29
            r69 = r28
            r65.<init>(r66, r67, r68, r69)
            r65 = r7
            net.zhuoweizhang.boardwalk.com.android.dx.util.IntList r65 = r65.getSubroutines()
            boolean r63 = r63.addOrReplaceBlock(r64, r65)
            return
        L_0x057f:
            r63 = r29
            r43 = r63
            goto L_0x0467
        L_0x0585:
            r63 = r19
            r26 = r63
            goto L_0x03d5
        L_0x058b:
            r63 = r20
            r21 = r63
            goto L_0x0233
        L_0x0591:
            r63 = r16
            r18 = r63
            r63 = r13
            r19 = r63
            goto L_0x022b
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Ropper.processBlock(net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ByteBlock, net.zhuoweizhang.boardwalk.com.android.dx.cf.code.Frame, int[]):void");
    }

    private void removeBlockAndSpecialSuccessors(int i) {
        RuntimeException runtimeException;
        StringBuilder sb;
        int i2 = i;
        int minimumUnreservedLabel = getMinimumUnreservedLabel();
        IntList successors = ((BasicBlock) this.result.get(i2)).getSuccessors();
        int size = successors.size();
        Object remove = this.result.remove(i2);
        Object remove2 = this.resultSubroutines.remove(i2);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = successors.get(i3);
            if (i4 >= minimumUnreservedLabel) {
                int labelToResultIndex = labelToResultIndex(i4);
                if (labelToResultIndex < 0) {
                    RuntimeException runtimeException2 = runtimeException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    RuntimeException runtimeException3 = new RuntimeException(sb2.append("Invalid label ").append(Hex.m51u2(i4)).toString());
                    throw runtimeException2;
                }
                removeBlockAndSpecialSuccessors(labelToResultIndex);
            }
        }
    }

    private void setFirstFrame() {
        this.startFrames[0].initializeWithParameters(this.method.getEffectiveDescriptor().getParameterTypes());
        this.startFrames[0].setImmutable();
    }

    /* access modifiers changed from: private */
    public Subroutine subroutineFromRetBlock(int i) {
        int i2 = i;
        for (int length = -1 + this.subroutines.length; length >= 0; length--) {
            if (this.subroutines[length] != null) {
                Subroutine subroutine = this.subroutines[length];
                if (subroutine.retBlocks.get(i2)) {
                    return subroutine;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public int getFirstTempStackReg() {
        int normalRegCount = getNormalRegCount();
        if (isSynchronized()) {
            normalRegCount++;
        }
        return normalRegCount;
    }
}
