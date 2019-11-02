package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.DeadCodeRemover */
public class DeadCodeRemover {
    private final int regCount;
    private final SsaMethod ssaMeth;
    private final ArrayList<SsaInsn>[] useList = this.ssaMeth.getUseListCopy();
    private final BitSet worklist;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.DeadCodeRemover$NoSideEffectVisitor */
    private static class NoSideEffectVisitor implements Visitor {
        BitSet noSideEffectRegs;

        public NoSideEffectVisitor(BitSet bitSet) {
            this.noSideEffectRegs = bitSet;
        }

        public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
            NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
            if (!DeadCodeRemover.hasSideEffect(normalSsaInsn2)) {
                this.noSideEffectRegs.set(normalSsaInsn2.getResult().getReg());
            }
        }

        public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
            NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
            RegisterSpec result = normalSsaInsn2.getResult();
            if (!DeadCodeRemover.hasSideEffect(normalSsaInsn2) && result != null) {
                this.noSideEffectRegs.set(result.getReg());
            }
        }

        public void visitPhiInsn(PhiInsn phiInsn) {
            PhiInsn phiInsn2 = phiInsn;
            if (!DeadCodeRemover.hasSideEffect(phiInsn2)) {
                this.noSideEffectRegs.set(phiInsn2.getResult().getReg());
            }
        }
    }

    private DeadCodeRemover(SsaMethod ssaMethod) {
        BitSet bitSet;
        SsaMethod ssaMethod2 = ssaMethod;
        this.ssaMeth = ssaMethod2;
        this.regCount = ssaMethod2.getRegCount();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(this.regCount);
        this.worklist = bitSet2;
    }

    /* access modifiers changed from: private */
    public static boolean hasSideEffect(SsaInsn ssaInsn) {
        SsaInsn ssaInsn2 = ssaInsn;
        if (ssaInsn2 == null) {
            return true;
        }
        return ssaInsn2.hasSideEffect();
    }

    private boolean isCircularNoSideEffect(int i, BitSet bitSet) {
        BitSet bitSet2;
        int i2 = i;
        BitSet bitSet3 = bitSet;
        if (bitSet3 != null && bitSet3.get(i2)) {
            return true;
        }
        Iterator it = this.useList[i2].iterator();
        while (it.hasNext()) {
            if (hasSideEffect((SsaInsn) it.next())) {
                return false;
            }
        }
        if (bitSet3 == null) {
            BitSet bitSet4 = bitSet2;
            BitSet bitSet5 = new BitSet(this.regCount);
            bitSet3 = bitSet4;
        }
        bitSet3.set(i2);
        Iterator it2 = this.useList[i2].iterator();
        while (it2.hasNext()) {
            RegisterSpec result = ((SsaInsn) it2.next()).getResult();
            if (result != null) {
                if (!isCircularNoSideEffect(result.getReg(), bitSet3)) {
                }
            }
            return false;
        }
        return true;
    }

    public static void process(SsaMethod ssaMethod) {
        DeadCodeRemover deadCodeRemover;
        DeadCodeRemover deadCodeRemover2 = deadCodeRemover;
        DeadCodeRemover deadCodeRemover3 = new DeadCodeRemover(ssaMethod);
        deadCodeRemover2.run();
    }

    private void pruneDeadInstructions() {
        HashSet hashSet;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        this.ssaMeth.computeReachability();
        Iterator it = this.ssaMeth.getBlocks().iterator();
        while (it.hasNext()) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) it.next();
            if (!ssaBasicBlock.isReachable()) {
                for (int i = 0; i < ssaBasicBlock.getInsns().size(); i++) {
                    SsaInsn ssaInsn = (SsaInsn) ssaBasicBlock.getInsns().get(i);
                    RegisterSpecList sources = ssaInsn.getSources();
                    int size = sources.size();
                    if (size != 0) {
                        boolean add = hashSet4.add(ssaInsn);
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        boolean remove = this.useList[sources.get(i2).getReg()].remove(ssaInsn);
                    }
                    RegisterSpec result = ssaInsn.getResult();
                    if (result != null) {
                        Iterator it2 = this.useList[result.getReg()].iterator();
                        while (it2.hasNext()) {
                            SsaInsn ssaInsn2 = (SsaInsn) it2.next();
                            if (ssaInsn2 instanceof PhiInsn) {
                                ((PhiInsn) ssaInsn2).removePhiRegister(result);
                            }
                        }
                    }
                }
            }
        }
        this.ssaMeth.deleteInsns(hashSet4);
    }

    private void run() {
        HashSet hashSet;
        NoSideEffectVisitor noSideEffectVisitor;
        pruneDeadInstructions();
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        SsaMethod ssaMethod = this.ssaMeth;
        NoSideEffectVisitor noSideEffectVisitor2 = noSideEffectVisitor;
        NoSideEffectVisitor noSideEffectVisitor3 = new NoSideEffectVisitor(this.worklist);
        ssaMethod.forEachInsn(noSideEffectVisitor2);
        while (true) {
            int nextSetBit = this.worklist.nextSetBit(0);
            if (nextSetBit >= 0) {
                this.worklist.clear(nextSetBit);
                if (this.useList[nextSetBit].size() == 0 || isCircularNoSideEffect(nextSetBit, null)) {
                    SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(nextSetBit);
                    if (!hashSet4.contains(definitionForRegister)) {
                        RegisterSpecList sources = definitionForRegister.getSources();
                        int size = sources.size();
                        for (int i = 0; i < size; i++) {
                            RegisterSpec registerSpec = sources.get(i);
                            boolean remove = this.useList[registerSpec.getReg()].remove(definitionForRegister);
                            if (!hasSideEffect(this.ssaMeth.getDefinitionForRegister(registerSpec.getReg()))) {
                                this.worklist.set(registerSpec.getReg());
                            }
                        }
                        boolean add = hashSet4.add(definitionForRegister);
                    }
                }
            } else {
                this.ssaMeth.deleteInsns(hashSet4);
                return;
            }
        }
    }
}
