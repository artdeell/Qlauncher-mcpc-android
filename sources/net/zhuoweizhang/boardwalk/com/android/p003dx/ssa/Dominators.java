package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.DomFront.DomInfo;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock.Visitor;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.Dominators */
public final class Dominators {
    private final ArrayList<SsaBasicBlock> blocks;
    private final DomInfo[] domInfos;
    /* access modifiers changed from: private */
    public final DFSInfo[] info = new DFSInfo[(2 + this.blocks.size())];
    private final SsaMethod meth;
    private final boolean postdom;
    /* access modifiers changed from: private */
    public final ArrayList<SsaBasicBlock> vertex;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.Dominators$DFSInfo */
    private static final class DFSInfo {
        public SsaBasicBlock ancestor;
        public ArrayList<SsaBasicBlock> bucket;
        public SsaBasicBlock parent;
        public SsaBasicBlock rep;
        public int semidom;

        public DFSInfo() {
            ArrayList<SsaBasicBlock> arrayList;
            ArrayList<SsaBasicBlock> arrayList2 = arrayList;
            ArrayList<SsaBasicBlock> arrayList3 = new ArrayList<>();
            this.bucket = arrayList2;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.Dominators$DfsWalker */
    private class DfsWalker implements Visitor {
        private int dfsNum;
        final /* synthetic */ Dominators this$0;

        private DfsWalker(Dominators dominators) {
            this.this$0 = dominators;
            this.dfsNum = 0;
        }

        /* synthetic */ DfsWalker(Dominators dominators, C07161 r7) {
            C07161 r2 = r7;
            this(dominators);
        }

        public void visitBlock(SsaBasicBlock ssaBasicBlock, SsaBasicBlock ssaBasicBlock2) {
            DFSInfo dFSInfo;
            SsaBasicBlock ssaBasicBlock3 = ssaBasicBlock;
            SsaBasicBlock ssaBasicBlock4 = ssaBasicBlock2;
            DFSInfo dFSInfo2 = dFSInfo;
            DFSInfo dFSInfo3 = new DFSInfo();
            DFSInfo dFSInfo4 = dFSInfo2;
            int i = 1 + this.dfsNum;
            this.dfsNum = i;
            dFSInfo4.semidom = i;
            dFSInfo4.rep = ssaBasicBlock3;
            dFSInfo4.parent = ssaBasicBlock4;
            boolean add = this.this$0.vertex.add(ssaBasicBlock3);
            this.this$0.info[ssaBasicBlock3.getIndex()] = dFSInfo4;
        }
    }

    private Dominators(SsaMethod ssaMethod, DomInfo[] domInfoArr, boolean z) {
        ArrayList<SsaBasicBlock> arrayList;
        SsaMethod ssaMethod2 = ssaMethod;
        DomInfo[] domInfoArr2 = domInfoArr;
        boolean z2 = z;
        this.meth = ssaMethod2;
        this.domInfos = domInfoArr2;
        this.postdom = z2;
        this.blocks = ssaMethod2.getBlocks();
        ArrayList<SsaBasicBlock> arrayList2 = arrayList;
        ArrayList<SsaBasicBlock> arrayList3 = new ArrayList<>();
        this.vertex = arrayList2;
    }

    private void compress(SsaBasicBlock ssaBasicBlock) {
        ArrayList arrayList;
        HashSet hashSet;
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        if (this.info[this.info[ssaBasicBlock2.getIndex()].ancestor.getIndex()].ancestor != null) {
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            HashSet hashSet2 = hashSet;
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = hashSet2;
            boolean add = arrayList4.add(ssaBasicBlock2);
            while (!arrayList4.isEmpty()) {
                int size = arrayList4.size();
                DFSInfo dFSInfo = this.info[((SsaBasicBlock) arrayList4.get(size - 1)).getIndex()];
                SsaBasicBlock ssaBasicBlock3 = dFSInfo.ancestor;
                DFSInfo dFSInfo2 = this.info[ssaBasicBlock3.getIndex()];
                if (!hashSet4.add(ssaBasicBlock3) || dFSInfo2.ancestor == null) {
                    Object remove = arrayList4.remove(size - 1);
                    if (dFSInfo2.ancestor != null) {
                        SsaBasicBlock ssaBasicBlock4 = dFSInfo2.rep;
                        if (this.info[ssaBasicBlock4.getIndex()].semidom < this.info[dFSInfo.rep.getIndex()].semidom) {
                            dFSInfo.rep = ssaBasicBlock4;
                        }
                        dFSInfo.ancestor = dFSInfo2.ancestor;
                    }
                } else {
                    boolean add2 = arrayList4.add(ssaBasicBlock3);
                }
            }
        }
    }

    private SsaBasicBlock eval(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        DFSInfo dFSInfo = this.info[ssaBasicBlock2.getIndex()];
        if (dFSInfo.ancestor == null) {
            return ssaBasicBlock2;
        }
        compress(ssaBasicBlock2);
        return dFSInfo.rep;
    }

    private BitSet getPreds(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        return this.postdom ? ssaBasicBlock2.getSuccessors() : ssaBasicBlock2.getPredecessors();
    }

    private BitSet getSuccs(SsaBasicBlock ssaBasicBlock) {
        SsaBasicBlock ssaBasicBlock2 = ssaBasicBlock;
        return this.postdom ? ssaBasicBlock2.getPredecessors() : ssaBasicBlock2.getSuccessors();
    }

    public static Dominators make(SsaMethod ssaMethod, DomInfo[] domInfoArr, boolean z) {
        Dominators dominators;
        Dominators dominators2 = dominators;
        Dominators dominators3 = new Dominators(ssaMethod, domInfoArr, z);
        Dominators dominators4 = dominators2;
        dominators4.run();
        return dominators4;
    }

    private void run() {
        SsaBasicBlock entryBlock;
        DfsWalker dfsWalker;
        if (this.postdom) {
            entryBlock = this.meth.getExitBlock();
        } else {
            entryBlock = this.meth.getEntryBlock();
        }
        if (entryBlock != null) {
            boolean add = this.vertex.add(entryBlock);
            this.domInfos[entryBlock.getIndex()].idom = entryBlock.getIndex();
        }
        DfsWalker dfsWalker2 = dfsWalker;
        DfsWalker dfsWalker3 = new DfsWalker(this, null);
        this.meth.forEachBlockDepthFirst(this.postdom, dfsWalker2);
        int size = -1 + this.vertex.size();
        for (int i = size; i >= 2; i--) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) this.vertex.get(i);
            DFSInfo dFSInfo = this.info[ssaBasicBlock.getIndex()];
            BitSet preds = getPreds(ssaBasicBlock);
            int nextSetBit = preds.nextSetBit(0);
            while (true) {
                int i2 = nextSetBit;
                if (i2 < 0) {
                    break;
                }
                SsaBasicBlock ssaBasicBlock2 = (SsaBasicBlock) this.blocks.get(i2);
                if (this.info[ssaBasicBlock2.getIndex()] != null) {
                    int i3 = this.info[eval(ssaBasicBlock2).getIndex()].semidom;
                    if (i3 < dFSInfo.semidom) {
                        dFSInfo.semidom = i3;
                    }
                }
                nextSetBit = preds.nextSetBit(i2 + 1);
            }
            boolean add2 = this.info[((SsaBasicBlock) this.vertex.get(dFSInfo.semidom)).getIndex()].bucket.add(ssaBasicBlock);
            dFSInfo.ancestor = dFSInfo.parent;
            ArrayList<SsaBasicBlock> arrayList = this.info[dFSInfo.parent.getIndex()].bucket;
            while (!arrayList.isEmpty()) {
                SsaBasicBlock ssaBasicBlock3 = (SsaBasicBlock) arrayList.remove(-1 + arrayList.size());
                SsaBasicBlock eval = eval(ssaBasicBlock3);
                if (this.info[eval.getIndex()].semidom < this.info[ssaBasicBlock3.getIndex()].semidom) {
                    this.domInfos[ssaBasicBlock3.getIndex()].idom = eval.getIndex();
                } else {
                    this.domInfos[ssaBasicBlock3.getIndex()].idom = dFSInfo.parent.getIndex();
                }
            }
        }
        for (int i4 = 2; i4 <= size; i4++) {
            SsaBasicBlock ssaBasicBlock4 = (SsaBasicBlock) this.vertex.get(i4);
            if (this.domInfos[ssaBasicBlock4.getIndex()].idom != ((SsaBasicBlock) this.vertex.get(this.info[ssaBasicBlock4.getIndex()].semidom)).getIndex()) {
                this.domInfos[ssaBasicBlock4.getIndex()].idom = this.domInfos[this.domInfos[ssaBasicBlock4.getIndex()].idom].idom;
            }
        }
    }
}
