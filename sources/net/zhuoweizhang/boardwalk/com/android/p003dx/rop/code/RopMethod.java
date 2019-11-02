package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RopMethod */
public final class RopMethod {
    private final BasicBlockList blocks;
    private IntList exitPredecessors;
    private final int firstLabel;
    private IntList[] predecessors;

    public RopMethod(BasicBlockList basicBlockList, int i) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        BasicBlockList basicBlockList2 = basicBlockList;
        int i2 = i;
        if (basicBlockList2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("blocks == null");
            throw nullPointerException2;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("firstLabel < 0");
            throw illegalArgumentException2;
        } else {
            this.blocks = basicBlockList2;
            this.firstLabel = i2;
            this.predecessors = null;
            this.exitPredecessors = null;
        }
    }

    private void calcPredecessors() {
        IntList intList;
        IntList intList2;
        int maxLabel = this.blocks.getMaxLabel();
        IntList[] intListArr = new IntList[maxLabel];
        IntList intList3 = intList;
        IntList intList4 = new IntList(10);
        IntList intList5 = intList3;
        int size = this.blocks.size();
        for (int i = 0; i < size; i++) {
            BasicBlock basicBlock = this.blocks.get(i);
            int label = basicBlock.getLabel();
            IntList successors = basicBlock.getSuccessors();
            int size2 = successors.size();
            if (size2 == 0) {
                intList5.add(label);
            } else {
                for (int i2 = 0; i2 < size2; i2++) {
                    int i3 = successors.get(i2);
                    IntList intList6 = intListArr[i3];
                    if (intList6 == null) {
                        IntList intList7 = intList2;
                        IntList intList8 = new IntList(10);
                        intList6 = intList7;
                        intListArr[i3] = intList6;
                    }
                    intList6.add(label);
                }
            }
        }
        for (int i4 = 0; i4 < maxLabel; i4++) {
            IntList intList9 = intListArr[i4];
            if (intList9 != null) {
                intList9.sort();
                intList9.setImmutable();
            }
        }
        intList5.sort();
        intList5.setImmutable();
        if (intListArr[this.firstLabel] == null) {
            intListArr[this.firstLabel] = IntList.EMPTY;
        }
        this.predecessors = intListArr;
        this.exitPredecessors = intList5;
    }

    public BasicBlockList getBlocks() {
        return this.blocks;
    }

    public IntList getExitPredecessors() {
        if (this.exitPredecessors == null) {
            calcPredecessors();
        }
        return this.exitPredecessors;
    }

    public int getFirstLabel() {
        return this.firstLabel;
    }

    public IntList labelToPredecessors(int i) {
        RuntimeException runtimeException;
        StringBuilder sb;
        int i2 = i;
        if (this.exitPredecessors == null) {
            calcPredecessors();
        }
        IntList intList = this.predecessors[i2];
        if (intList != null) {
            return intList;
        }
        RuntimeException runtimeException2 = runtimeException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        RuntimeException runtimeException3 = new RuntimeException(sb2.append("no such block: ").append(Hex.m51u2(i2)).toString());
        throw runtimeException2;
    }

    public RopMethod withRegisterOffset(int i) {
        RopMethod ropMethod;
        RopMethod ropMethod2 = ropMethod;
        RopMethod ropMethod3 = new RopMethod(this.blocks.withRegisterOffset(i), this.firstLabel);
        RopMethod ropMethod4 = ropMethod2;
        if (this.exitPredecessors != null) {
            ropMethod4.exitPredecessors = this.exitPredecessors;
            ropMethod4.predecessors = this.predecessors;
        }
        return ropMethod4;
    }
}
