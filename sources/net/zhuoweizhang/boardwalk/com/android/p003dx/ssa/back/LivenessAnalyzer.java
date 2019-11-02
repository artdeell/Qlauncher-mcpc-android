package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back;

import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.PhiInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaMethod;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.LivenessAnalyzer */
public class LivenessAnalyzer {
    private SsaBasicBlock blockN;
    private final InterferenceGraph interference;
    private final BitSet liveOutBlocks;
    private NextFunction nextFunction;
    private final int regV;
    private final SsaMethod ssaMeth;
    private int statementIndex;
    private final BitSet visitedBlocks;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.LivenessAnalyzer$NextFunction */
    private enum NextFunction {
    }

    private LivenessAnalyzer(SsaMethod ssaMethod, int i, InterferenceGraph interferenceGraph) {
        BitSet bitSet;
        BitSet bitSet2;
        SsaMethod ssaMethod2 = ssaMethod;
        int i2 = i;
        InterferenceGraph interferenceGraph2 = interferenceGraph;
        int size = ssaMethod2.getBlocks().size();
        this.ssaMeth = ssaMethod2;
        this.regV = i2;
        BitSet bitSet3 = bitSet;
        BitSet bitSet4 = new BitSet(size);
        this.visitedBlocks = bitSet3;
        BitSet bitSet5 = bitSet2;
        BitSet bitSet6 = new BitSet(size);
        this.liveOutBlocks = bitSet5;
        this.interference = interferenceGraph2;
    }

    private static void coInterferePhis(SsaMethod ssaMethod, InterferenceGraph interferenceGraph) {
        InterferenceGraph interferenceGraph2 = interferenceGraph;
        Iterator it = ssaMethod.getBlocks().iterator();
        while (it.hasNext()) {
            List phiInsns = ((SsaBasicBlock) it.next()).getPhiInsns();
            int size = phiInsns.size();
            for (int i = 0; i < size; i++) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (i != i2) {
                        interferenceGraph2.add(((SsaInsn) phiInsns.get(i)).getResult().getReg(), ((SsaInsn) phiInsns.get(i2)).getResult().getReg());
                    }
                }
            }
        }
    }

    public static InterferenceGraph constructInterferenceGraph(SsaMethod ssaMethod) {
        InterferenceGraph interferenceGraph;
        LivenessAnalyzer livenessAnalyzer;
        SsaMethod ssaMethod2 = ssaMethod;
        int regCount = ssaMethod2.getRegCount();
        InterferenceGraph interferenceGraph2 = interferenceGraph;
        InterferenceGraph interferenceGraph3 = new InterferenceGraph(regCount);
        InterferenceGraph interferenceGraph4 = interferenceGraph2;
        for (int i = 0; i < regCount; i++) {
            LivenessAnalyzer livenessAnalyzer2 = livenessAnalyzer;
            LivenessAnalyzer livenessAnalyzer3 = new LivenessAnalyzer(ssaMethod2, i, interferenceGraph4);
            livenessAnalyzer2.run();
        }
        coInterferePhis(ssaMethod2, interferenceGraph4);
        return interferenceGraph4;
    }

    private void handleTailRecursion() {
        while (this.nextFunction != NextFunction.DONE) {
            switch (this.nextFunction) {
                case LIVE_IN_AT_STATEMENT:
                    this.nextFunction = NextFunction.DONE;
                    liveInAtStatement();
                    break;
                case LIVE_OUT_AT_STATEMENT:
                    this.nextFunction = NextFunction.DONE;
                    liveOutAtStatement();
                    break;
                case LIVE_OUT_AT_BLOCK:
                    this.nextFunction = NextFunction.DONE;
                    liveOutAtBlock();
                    break;
            }
        }
    }

    private void liveInAtStatement() {
        if (this.statementIndex == 0) {
            this.blockN.addLiveIn(this.regV);
            this.liveOutBlocks.or(this.blockN.getPredecessors());
            return;
        }
        this.statementIndex = -1 + this.statementIndex;
        this.nextFunction = NextFunction.LIVE_OUT_AT_STATEMENT;
    }

    private void liveOutAtBlock() {
        if (!this.visitedBlocks.get(this.blockN.getIndex())) {
            this.visitedBlocks.set(this.blockN.getIndex());
            this.blockN.addLiveOut(this.regV);
            this.statementIndex = -1 + this.blockN.getInsns().size();
            this.nextFunction = NextFunction.LIVE_OUT_AT_STATEMENT;
        }
    }

    private void liveOutAtStatement() {
        SsaInsn ssaInsn = (SsaInsn) this.blockN.getInsns().get(this.statementIndex);
        RegisterSpec result = ssaInsn.getResult();
        if (!ssaInsn.isResultReg(this.regV)) {
            if (result != null) {
                this.interference.add(this.regV, result.getReg());
            }
            this.nextFunction = NextFunction.LIVE_IN_AT_STATEMENT;
        }
    }

    public void run() {
        RuntimeException runtimeException;
        for (SsaInsn ssaInsn : this.ssaMeth.getUseListForRegister(this.regV)) {
            this.nextFunction = NextFunction.DONE;
            if (ssaInsn instanceof PhiInsn) {
                for (SsaBasicBlock ssaBasicBlock : ((PhiInsn) ssaInsn).predBlocksForReg(this.regV, this.ssaMeth)) {
                    this.blockN = ssaBasicBlock;
                    this.nextFunction = NextFunction.LIVE_OUT_AT_BLOCK;
                    handleTailRecursion();
                }
            } else {
                this.blockN = ssaInsn.getBlock();
                this.statementIndex = this.blockN.getInsns().indexOf(ssaInsn);
                if (this.statementIndex < 0) {
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException("insn not found in it's own block");
                    throw runtimeException2;
                }
                this.nextFunction = NextFunction.LIVE_IN_AT_STATEMENT;
                handleTailRecursion();
            }
        }
        while (true) {
            int nextSetBit = this.liveOutBlocks.nextSetBit(0);
            if (nextSetBit >= 0) {
                this.blockN = (SsaBasicBlock) this.ssaMeth.getBlocks().get(nextSetBit);
                this.liveOutBlocks.clear(nextSetBit);
                this.nextFunction = NextFunction.LIVE_OUT_AT_BLOCK;
                handleTailRecursion();
            } else {
                return;
            }
        }
    }
}
