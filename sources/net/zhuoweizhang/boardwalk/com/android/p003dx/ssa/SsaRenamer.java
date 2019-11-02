package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaRenamer */
public class SsaRenamer implements Runnable {
    private static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public int nextSsaReg;
    private final int ropRegCount;
    /* access modifiers changed from: private */
    public final SsaMethod ssaMeth;
    private final ArrayList<LocalItem> ssaRegToLocalItems;
    private IntList ssaRegToRopReg;
    /* access modifiers changed from: private */
    public final RegisterSpec[][] startsForBlocks;
    /* access modifiers changed from: private */
    public int threshold;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaRenamer$BlockRenamer */
    private class BlockRenamer implements Visitor {
        /* access modifiers changed from: private */
        public final SsaBasicBlock block;
        /* access modifiers changed from: private */
        public final RegisterSpec[] currentMapping;
        private final HashMap<SsaInsn, SsaInsn> insnsToReplace;
        private final RenamingMapper mapper;
        private final HashSet<SsaInsn> movesToKeep;
        final /* synthetic */ SsaRenamer this$0;

        /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaRenamer$BlockRenamer$RenamingMapper */
        private class RenamingMapper extends RegisterMapper {
            final /* synthetic */ BlockRenamer this$1;

            public RenamingMapper(BlockRenamer blockRenamer) {
                this.this$1 = blockRenamer;
            }

            public int getNewRegisterCount() {
                return this.this$1.this$0.nextSsaReg;
            }

            public RegisterSpec map(RegisterSpec registerSpec) {
                RegisterSpec registerSpec2 = registerSpec;
                if (registerSpec2 == null) {
                    return null;
                }
                return registerSpec2.withReg(this.this$1.currentMapping[registerSpec2.getReg()].getReg());
            }
        }

        BlockRenamer(SsaRenamer ssaRenamer, SsaBasicBlock ssaBasicBlock) {
            HashSet<SsaInsn> hashSet;
            HashMap<SsaInsn, SsaInsn> hashMap;
            RenamingMapper renamingMapper;
            SsaRenamer ssaRenamer2 = ssaRenamer;
            SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
            this.this$0 = ssaRenamer2;
            this.block = ssaBasicBlock2;
            this.currentMapping = ssaRenamer2.startsForBlocks[ssaBasicBlock2.getIndex()];
            HashSet<SsaInsn> hashSet2 = hashSet;
            HashSet<SsaInsn> hashSet3 = new HashSet<>();
            this.movesToKeep = hashSet2;
            HashMap<SsaInsn, SsaInsn> hashMap2 = hashMap;
            HashMap<SsaInsn, SsaInsn> hashMap3 = new HashMap<>();
            this.insnsToReplace = hashMap2;
            RenamingMapper renamingMapper2 = renamingMapper;
            RenamingMapper renamingMapper3 = new RenamingMapper(this);
            this.mapper = renamingMapper2;
            ssaRenamer2.startsForBlocks[ssaBasicBlock2.getIndex()] = null;
        }

        private void addMapping(int i, RegisterSpec registerSpec) {
            int i2 = i;
            RegisterSpec registerSpec2 = registerSpec;
            int reg = registerSpec2.getReg();
            LocalItem localItem = registerSpec2.getLocalItem();
            this.currentMapping[i2] = registerSpec2;
            for (int length = -1 + this.currentMapping.length; length >= 0; length--) {
                if (reg == this.currentMapping[length].getReg()) {
                    this.currentMapping[length] = registerSpec2;
                }
            }
            if (localItem != null) {
                this.this$0.setNameForSsaReg(registerSpec2);
                for (int length2 = -1 + this.currentMapping.length; length2 >= 0; length2--) {
                    RegisterSpec registerSpec3 = this.currentMapping[length2];
                    if (reg != registerSpec3.getReg() && localItem.equals(registerSpec3.getLocalItem())) {
                        this.currentMapping[length2] = registerSpec3.withLocalItem(null);
                    }
                }
            }
        }

        private void updateSuccessorPhis() {
            C07261 r7;
            C07261 r4 = r7;
            C07261 r5 = new PhiInsn.Visitor(this) {
                final /* synthetic */ BlockRenamer this$1;

                {
                    this.this$1 = r5;
                }

                public void visitPhiInsn(PhiInsn phiInsn) {
                    PhiInsn phiInsn2 = phiInsn;
                    int ropResultReg = phiInsn2.getRopResultReg();
                    if (!this.this$1.this$0.isBelowThresholdRegister(ropResultReg)) {
                        RegisterSpec registerSpec = this.this$1.currentMapping[ropResultReg];
                        if (!this.this$1.this$0.isVersionZeroRegister(registerSpec.getReg())) {
                            phiInsn2.addPhiOperand(registerSpec, this.this$1.block);
                        }
                    }
                }
            };
            C07261 r1 = r4;
            BitSet successors = this.block.getSuccessors();
            int nextSetBit = successors.nextSetBit(0);
            while (true) {
                int i = nextSetBit;
                if (i >= 0) {
                    ((SsaBasicBlock) this.this$0.ssaMeth.getBlocks().get(i)).forEachPhiInsn(r1);
                    nextSetBit = successors.nextSetBit(i + 1);
                } else {
                    return;
                }
            }
        }

        public void process() {
            boolean z;
            this.block.forEachInsn(this);
            updateSuccessorPhis();
            ArrayList insns = this.block.getInsns();
            for (int size = -1 + insns.size(); size >= 0; size--) {
                SsaInsn ssaInsn = (SsaInsn) insns.get(size);
                SsaInsn ssaInsn2 = (SsaInsn) this.insnsToReplace.get(ssaInsn);
                if (ssaInsn2 != null) {
                    Object obj = insns.set(size, ssaInsn2);
                } else if (ssaInsn.isNormalMoveInsn() && !this.movesToKeep.contains(ssaInsn)) {
                    Object remove = insns.remove(size);
                }
            }
            Iterator it = this.block.getDomChildren().iterator();
            boolean z2 = true;
            while (true) {
                boolean z3 = z2;
                if (it.hasNext()) {
                    SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) it.next();
                    if (ssaBasicBlock != this.block) {
                        this.this$0.startsForBlocks[ssaBasicBlock.getIndex()] = z3 ? this.currentMapping : SsaRenamer.dupArray(this.currentMapping);
                        z = false;
                    } else {
                        z = z3;
                    }
                    z2 = z;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void processResultReg(SsaInsn ssaInsn) {
            SsaInsn ssaInsn2 = ssaInsn;
            RegisterSpec result = ssaInsn2.getResult();
            if (result != null) {
                int reg = result.getReg();
                if (!this.this$0.isBelowThresholdRegister(reg)) {
                    ssaInsn2.changeResultReg(this.this$0.nextSsaReg);
                    addMapping(reg, ssaInsn2.getResult());
                    int access$108 = SsaRenamer.access$108(this.this$0);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c5, code lost:
            if (net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaRenamer.access$700(r1.this$0) == 0) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x008f, code lost:
            if (r8.equals(r9) != false) goto L_0x0091;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void visitMoveInsn(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.NormalSsaInsn r25) {
            /*
                r24 = this;
                r1 = r24
                r2 = r25
                r17 = r2
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r17 = r17.getResult()
                r3 = r17
                r17 = r3
                int r17 = r17.getReg()
                r4 = r17
                r17 = r2
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r17 = r17.getSources()
                r18 = 0
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r17 = r17.get(r18)
                int r17 = r17.getReg()
                r5 = r17
                r17 = r2
                r18 = r1
                r0 = r18
                net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaRenamer$BlockRenamer$RenamingMapper r0 = r0.mapper
                r18 = r0
                r17.mapSourceRegisters(r18)
                r17 = r2
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r17 = r17.getSources()
                r18 = 0
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r17 = r17.get(r18)
                int r17 = r17.getReg()
                r6 = r17
                r17 = r1
                r0 = r17
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec[] r0 = r0.currentMapping
                r17 = r0
                r18 = r5
                r17 = r17[r18]
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r17 = r17.getLocalItem()
                r7 = r17
                r17 = r3
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r17 = r17.getLocalItem()
                r8 = r17
                r17 = r8
                if (r17 != 0) goto L_0x0067
                r17 = r7
                r8 = r17
            L_0x0067:
                r17 = r1
                r0 = r17
                net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaRenamer r0 = r0.this$0
                r17 = r0
                r18 = r6
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r17 = r17.getLocalForNewReg(r18)
                r9 = r17
                r17 = r9
                if (r17 == 0) goto L_0x0091
                r17 = r8
                if (r17 == 0) goto L_0x0091
                r17 = r8
                r18 = r9
                boolean r17 = r17.equals(r18)
                r16 = r17
                r17 = 0
                r10 = r17
                r17 = r16
                if (r17 == 0) goto L_0x0095
            L_0x0091:
                r17 = 1
                r10 = r17
            L_0x0095:
                r17 = r6
                r18 = r3
                net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r18 = r18.getType()
                r19 = r8
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r17 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.makeLocalOptional(r17, r18, r19)
                r11 = r17
                boolean r17 = net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer.getPreserveLocals()
                if (r17 == 0) goto L_0x00c7
                r17 = r10
                if (r17 == 0) goto L_0x00d1
                r17 = r8
                r18 = r7
                boolean r17 = net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaRenamer.equalsHandlesNulls(r17, r18)
                if (r17 == 0) goto L_0x00d1
                r17 = r1
                r0 = r17
                net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaRenamer r0 = r0.this$0
                r17 = r0
                int r17 = r17.threshold
                if (r17 != 0) goto L_0x00d1
            L_0x00c7:
                r17 = r1
                r18 = r4
                r19 = r11
                r17.addMapping(r18, r19)
            L_0x00d0:
                return
            L_0x00d1:
                r17 = r10
                if (r17 == 0) goto L_0x013e
                r17 = r7
                if (r17 != 0) goto L_0x013e
                r17 = r1
                r0 = r17
                net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaRenamer r0 = r0.this$0
                r17 = r0
                int r17 = r17.threshold
                if (r17 != 0) goto L_0x013e
                r17 = r11
                int r17 = r17.getReg()
                r18 = r11
                net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r18 = r18.getType()
                r19 = r8
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r17 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.make(r17, r18, r19)
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList r17 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList.make(r17)
                r13 = r17
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r17 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
                r23 = r17
                r17 = r23
                r18 = r23
                r19 = r11
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r19 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.opMarkLocal(r19)
                net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r20 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition.NO_INFO
                r21 = 0
                r22 = r13
                r18.<init>(r19, r20, r21, r22)
                r18 = r1
                r0 = r18
                net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r0 = r0.block
                r18 = r0
                net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn r17 = net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.makeFromRop(r17, r18)
                r14 = r17
                r17 = r1
                r0 = r17
                java.util.HashMap<net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn, net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn> r0 = r0.insnsToReplace
                r17 = r0
                r18 = r2
                r19 = r14
                java.lang.Object r17 = r17.put(r18, r19)
                r17 = r1
                r18 = r4
                r19 = r11
                r17.addMapping(r18, r19)
                goto L_0x00d0
            L_0x013e:
                r17 = r1
                r18 = r2
                r17.processResultReg(r18)
                r17 = r1
                r0 = r17
                java.util.HashSet<net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaInsn> r0 = r0.movesToKeep
                r17 = r0
                r18 = r2
                boolean r17 = r17.add(r18)
                goto L_0x00d0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaRenamer.BlockRenamer.visitMoveInsn(net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn):void");
        }

        public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
            NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
            normalSsaInsn2.mapSourceRegisters(this.mapper);
            processResultReg(normalSsaInsn2);
        }

        public void visitPhiInsn(PhiInsn phiInsn) {
            processResultReg(phiInsn);
        }
    }

    public SsaRenamer(SsaMethod ssaMethod) {
        ArrayList<LocalItem> arrayList;
        SsaMethod ssaMethod2 = ssaMethod;
        this.ropRegCount = ssaMethod2.getRegCount();
        this.ssaMeth = ssaMethod2;
        this.nextSsaReg = this.ropRegCount;
        this.threshold = 0;
        this.startsForBlocks = new RegisterSpec[ssaMethod2.getBlocks().size()][];
        ArrayList<LocalItem> arrayList2 = arrayList;
        ArrayList<LocalItem> arrayList3 = new ArrayList<>();
        this.ssaRegToLocalItems = arrayList2;
        RegisterSpec[] registerSpecArr = new RegisterSpec[this.ropRegCount];
        for (int i = 0; i < this.ropRegCount; i++) {
            registerSpecArr[i] = RegisterSpec.make(i, Type.VOID);
        }
        this.startsForBlocks[ssaMethod2.getEntryBlockIndex()] = registerSpecArr;
    }

    public SsaRenamer(SsaMethod ssaMethod, int i) {
        int i2 = i;
        this(ssaMethod);
        this.threshold = i2;
    }

    static /* synthetic */ int access$108(SsaRenamer ssaRenamer) {
        SsaRenamer ssaRenamer2 = ssaRenamer;
        int i = ssaRenamer2.nextSsaReg;
        ssaRenamer2.nextSsaReg = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public static RegisterSpec[] dupArray(RegisterSpec[] registerSpecArr) {
        RegisterSpec[] registerSpecArr2 = registerSpecArr;
        RegisterSpec[] registerSpecArr3 = new RegisterSpec[registerSpecArr2.length];
        System.arraycopy(registerSpecArr2, 0, registerSpecArr3, 0, registerSpecArr2.length);
        return registerSpecArr3;
    }

    /* access modifiers changed from: private */
    public static boolean equalsHandlesNulls(Object obj, Object obj2) {
        Object obj3 = obj;
        Object obj4 = obj2;
        return obj3 == obj4 || (obj3 != null && obj3.equals(obj4));
    }

    /* access modifiers changed from: private */
    public LocalItem getLocalForNewReg(int i) {
        int i2 = i;
        if (i2 < this.ssaRegToLocalItems.size()) {
            return (LocalItem) this.ssaRegToLocalItems.get(i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean isBelowThresholdRegister(int i) {
        return i < this.threshold;
    }

    /* access modifiers changed from: private */
    public boolean isVersionZeroRegister(int i) {
        return i < this.ropRegCount;
    }

    /* access modifiers changed from: private */
    public void setNameForSsaReg(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        int reg = registerSpec2.getReg();
        LocalItem localItem = registerSpec2.getLocalItem();
        this.ssaRegToLocalItems.ensureCapacity(reg + 1);
        while (this.ssaRegToLocalItems.size() <= reg) {
            boolean add = this.ssaRegToLocalItems.add(null);
        }
        Object obj = this.ssaRegToLocalItems.set(reg, localItem);
    }

    public void run() {
        C07251 r5;
        SsaMethod ssaMethod = this.ssaMeth;
        C07251 r2 = r5;
        C07251 r3 = new SsaBasicBlock.Visitor(this) {
            final /* synthetic */ SsaRenamer this$0;

            {
                this.this$0 = r5;
            }

            public void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
                BlockRenamer blockRenamer;
                SsaBasicBlock ssaBasicBlock3 = ssaBasicBlock;
                SsaBasicBlock ssaBasicBlock4 = ssaBasicBlock2;
                BlockRenamer blockRenamer2 = blockRenamer;
                BlockRenamer blockRenamer3 = new BlockRenamer(this.this$0, ssaBasicBlock3);
                blockRenamer2.process();
            }
        };
        ssaMethod.forEachBlockDepthFirstDom(r2);
        this.ssaMeth.setNewRegCount(this.nextSsaReg);
        this.ssaMeth.onInsnsChanged();
    }
}
