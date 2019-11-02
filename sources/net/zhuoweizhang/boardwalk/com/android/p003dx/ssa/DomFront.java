package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntSet;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.DomFront */
public class DomFront {
    private static boolean DEBUG = false;
    private final DomInfo[] domInfos;
    private final SsaMethod meth;
    private final ArrayList<SsaBasicBlock> nodes;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.DomFront$DomInfo */
    public static class DomInfo {
        public IntSet dominanceFrontiers;
        public int idom = -1;

        public DomInfo() {
        }
    }

    public DomFront(SsaMethod ssaMethod) {
        DomInfo domInfo;
        SsaMethod ssaMethod2 = ssaMethod;
        this.meth = ssaMethod2;
        this.nodes = ssaMethod2.getBlocks();
        int size = this.nodes.size();
        this.domInfos = new DomInfo[size];
        for (int i = 0; i < size; i++) {
            DomInfo[] domInfoArr = this.domInfos;
            int i2 = i;
            DomInfo domInfo2 = domInfo;
            DomInfo domInfo3 = new DomInfo();
            domInfoArr[i2] = domInfo2;
        }
    }

    private void buildDomTree() {
        int size = this.nodes.size();
        for (int i = 0; i < size; i++) {
            DomInfo domInfo = this.domInfos[i];
            if (domInfo.idom != -1) {
                ((SsaBasicBlock) this.nodes.get(domInfo.idom)).addDomChild((SsaBasicBlock) this.nodes.get(i));
            }
        }
    }

    private void calcDomFronts() {
        int size = this.nodes.size();
        for (int i = 0; i < size; i++) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) this.nodes.get(i);
            DomInfo domInfo = this.domInfos[i];
            BitSet predecessors = ssaBasicBlock.getPredecessors();
            if (predecessors.cardinality() > 1) {
                int nextSetBit = predecessors.nextSetBit(0);
                while (true) {
                    int i2 = nextSetBit;
                    if (i2 < 0) {
                        break;
                    }
                    int i3 = i2;
                    while (true) {
                        int i4 = i3;
                        if (i4 != domInfo.idom && i4 != -1) {
                            DomInfo domInfo2 = this.domInfos[i4];
                            if (domInfo2.dominanceFrontiers.has(i)) {
                                break;
                            }
                            domInfo2.dominanceFrontiers.add(i);
                            i3 = domInfo2.idom;
                        } else {
                            break;
                        }
                    }
                    nextSetBit = predecessors.nextSetBit(i2 + 1);
                }
            }
        }
    }

    private void debugPrintDomChildren() {
        StringBuffer stringBuffer;
        StringBuilder sb;
        int size = this.nodes.size();
        for (int i = 0; i < size; i++) {
            SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) this.nodes.get(i);
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            StringBuffer stringBuffer4 = stringBuffer2;
            StringBuffer append = stringBuffer4.append('{');
            Iterator it = ssaBasicBlock.getDomChildren().iterator();
            boolean z = false;
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    break;
                }
                SsaBasicBlock ssaBasicBlock2 = (SsaBasicBlock) it.next();
                if (z2) {
                    StringBuffer append2 = stringBuffer4.append(',');
                }
                StringBuffer append3 = stringBuffer4.append(ssaBasicBlock2);
                z = true;
            }
            StringBuffer append4 = stringBuffer4.append('}');
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("domChildren[").append(ssaBasicBlock).append("]: ").append(stringBuffer4).toString());
        }
    }

    public DomInfo[] run() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        int size = this.nodes.size();
        if (DEBUG) {
            for (int i = 0; i < size; i++) {
                SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) this.nodes.get(i);
                PrintStream printStream = System.out;
                StringBuilder sb4 = sb3;
                StringBuilder sb5 = new StringBuilder();
                printStream.println(sb4.append("pred[").append(i).append("]: ").append(ssaBasicBlock.getPredecessors()).toString());
            }
        }
        Dominators make = Dominators.make(this.meth, this.domInfos, false);
        if (DEBUG) {
            for (int i2 = 0; i2 < size; i2++) {
                DomInfo domInfo = this.domInfos[i2];
                PrintStream printStream2 = System.out;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                printStream2.println(sb6.append("idom[").append(i2).append("]: ").append(domInfo.idom).toString());
            }
        }
        buildDomTree();
        if (DEBUG) {
            debugPrintDomChildren();
        }
        for (int i3 = 0; i3 < size; i3++) {
            this.domInfos[i3].dominanceFrontiers = SetFactory.makeDomFrontSet(size);
        }
        calcDomFronts();
        if (DEBUG) {
            for (int i4 = 0; i4 < size; i4++) {
                PrintStream printStream3 = System.out;
                StringBuilder sb8 = sb;
                StringBuilder sb9 = new StringBuilder();
                printStream3.println(sb8.append("df[").append(i4).append("]: ").append(this.domInfos[i4].dominanceFrontiers).toString());
            }
        }
        return this.domInfos;
    }
}
