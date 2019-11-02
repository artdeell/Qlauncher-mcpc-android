package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteCatchList.Item;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BytecodeArray.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMemberRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Bits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BasicBlocker */
public final class BasicBlocker implements Visitor {
    private final int[] blockSet;
    private final ByteCatchList[] catchLists;
    private final int[] liveSet;
    private final ConcreteMethod method;
    private int previousOffset;
    private final IntList[] targetLists;
    private final int[] workSet;

    private BasicBlocker(ConcreteMethod concreteMethod) {
        NullPointerException nullPointerException;
        ConcreteMethod concreteMethod2 = concreteMethod;
        if (concreteMethod2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("method == null");
            throw nullPointerException2;
        }
        this.method = concreteMethod2;
        int size = 1 + concreteMethod2.getCode().size();
        this.workSet = Bits.makeBitSet(size);
        this.liveSet = Bits.makeBitSet(size);
        this.blockSet = Bits.makeBitSet(size);
        this.targetLists = new IntList[size];
        this.catchLists = new ByteCatchList[size];
        this.previousOffset = -1;
    }

    private void addWorkIfNecessary(int i, boolean z) {
        int i2 = i;
        boolean z2 = z;
        if (!Bits.get(this.liveSet, i2)) {
            Bits.set(this.workSet, i2);
        }
        if (z2) {
            Bits.set(this.blockSet, i2);
        }
    }

    private void doit() {
        SimException simException;
        BytecodeArray code = this.method.getCode();
        ByteCatchList catches = this.method.getCatches();
        int size = catches.size();
        Bits.set(this.workSet, 0);
        Bits.set(this.blockSet, 0);
        while (!Bits.isEmpty(this.workSet)) {
            try {
                code.processWorkSet(this.workSet, this);
                for (int i = 0; i < size; i++) {
                    Item item = catches.get(i);
                    int startPc = item.getStartPc();
                    int endPc = item.getEndPc();
                    if (Bits.anyInRange(this.liveSet, startPc, endPc)) {
                        Bits.set(this.blockSet, startPc);
                        Bits.set(this.blockSet, endPc);
                        addWorkIfNecessary(item.getHandlerPc(), true);
                    }
                }
            } catch (IllegalArgumentException e) {
                IllegalArgumentException illegalArgumentException = e;
                SimException simException2 = simException;
                SimException simException3 = new SimException("flow of control falls off end of method", illegalArgumentException);
                throw simException2;
            }
        }
    }

    private ByteBlockList getBlockList() {
        int i;
        ByteBlockList byteBlockList;
        int i2;
        ByteCatchList byteCatchList;
        ByteBlock byteBlock;
        ByteBlock[] byteBlockArr = new ByteBlock[this.method.getCode().size()];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            int findFirst = Bits.findFirst(this.blockSet, i3 + 1);
            if (findFirst < 0) {
                break;
            }
            if (Bits.get(this.liveSet, i3)) {
                IntList intList = null;
                int i5 = findFirst - 1;
                while (true) {
                    if (i5 < i3) {
                        i5 = -1;
                        break;
                    }
                    intList = this.targetLists[i5];
                    if (intList != null) {
                        break;
                    }
                    i5--;
                }
                if (intList == null) {
                    intList = IntList.makeImmutable(findFirst);
                    byteCatchList = ByteCatchList.EMPTY;
                } else {
                    byteCatchList = this.catchLists[i5];
                    if (byteCatchList == null) {
                        byteCatchList = ByteCatchList.EMPTY;
                    }
                }
                ByteBlock[] byteBlockArr2 = byteBlockArr;
                int i6 = i;
                ByteBlock byteBlock2 = byteBlock;
                ByteBlock byteBlock3 = new ByteBlock(i3, i3, findFirst, intList, byteCatchList);
                byteBlockArr2[i6] = byteBlock2;
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i3 = findFirst;
            i4 = i2;
        }
        ByteBlockList byteBlockList2 = byteBlockList;
        ByteBlockList byteBlockList3 = new ByteBlockList(i);
        ByteBlockList byteBlockList4 = byteBlockList2;
        for (int i7 = 0; i7 < i; i7++) {
            byteBlockList4.set(i7, byteBlockArr[i7]);
        }
        return byteBlockList4;
    }

    public static ByteBlockList identifyBlocks(ConcreteMethod concreteMethod) {
        BasicBlocker basicBlocker;
        BasicBlocker basicBlocker2 = basicBlocker;
        BasicBlocker basicBlocker3 = new BasicBlocker(concreteMethod);
        BasicBlocker basicBlocker4 = basicBlocker2;
        basicBlocker4.doit();
        return basicBlocker4.getBlockList();
    }

    private void visitCommon(int i, int i2, boolean z) {
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        Bits.set(this.liveSet, i3);
        if (z2) {
            addWorkIfNecessary(i3 + i4, false);
        } else {
            Bits.set(this.blockSet, i3 + i4);
        }
    }

    private void visitThrowing(int i, int i2, boolean z) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i3 + i2;
        if (z2) {
            addWorkIfNecessary(i4, true);
        }
        ByteCatchList listFor = this.method.getCatches().listFor(i3);
        this.catchLists[i3] = listFor;
        IntList[] intListArr = this.targetLists;
        if (!z2) {
            i4 = -1;
        }
        intListArr[i3] = listFor.toTargetList(i4);
    }

    public int getPreviousOffset() {
        return this.previousOffset;
    }

    public void setPreviousOffset(int i) {
        int i2 = i;
        this.previousOffset = i2;
    }

    public void visitBranch(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        switch (i) {
            case 167:
                visitCommon(i5, i6, false);
                this.targetLists[i5] = IntList.makeImmutable(i7);
                break;
            case 168:
                addWorkIfNecessary(i5, true);
                break;
        }
        int i8 = i5 + i6;
        visitCommon(i5, i6, true);
        addWorkIfNecessary(i8, true);
        this.targetLists[i5] = IntList.makeImmutable(i8, i7);
        addWorkIfNecessary(i7, true);
    }

    public void visitConstant(int i, int i2, int i3, Constant constant, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        Constant constant2 = constant;
        int i8 = i4;
        visitCommon(i6, i7, true);
        if ((constant2 instanceof CstMemberRef) || (constant2 instanceof CstType) || (constant2 instanceof CstString)) {
            visitThrowing(i6, i7, true);
        }
    }

    public void visitInvalid(int i, int i2, int i3) {
        int i4 = i;
        visitCommon(i2, i3, true);
    }

    public void visitLocal(int i, int i2, int i3, int i4, Type type, int i5) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        Type type2 = type;
        int i9 = i5;
        if (i == 169) {
            visitCommon(i6, i7, false);
            this.targetLists[i6] = IntList.EMPTY;
            return;
        }
        visitCommon(i6, i7, true);
    }

    public void visitNewarray(int i, int i2, CstType cstType, ArrayList<Constant> arrayList) {
        int i3 = i;
        int i4 = i2;
        CstType cstType2 = cstType;
        ArrayList<Constant> arrayList2 = arrayList;
        visitCommon(i3, i4, true);
        visitThrowing(i3, i4, true);
    }

    public void visitNoArgs(int i, int i2, int i3, Type type) {
        int i4 = i2;
        int i5 = i3;
        Type type2 = type;
        switch (i) {
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 190:
            case 194:
            case 195:
                visitCommon(i4, i5, true);
                visitThrowing(i4, i5, true);
                return;
            case 108:
            case 112:
                visitCommon(i4, i5, true);
                if (type2 == Type.INT || type2 == Type.LONG) {
                    visitThrowing(i4, i5, true);
                    return;
                }
                return;
            case 172:
            case 177:
                visitCommon(i4, i5, false);
                this.targetLists[i4] = IntList.EMPTY;
                return;
            case 191:
                visitCommon(i4, i5, false);
                visitThrowing(i4, i5, false);
                return;
            default:
                visitCommon(i4, i5, true);
                return;
        }
    }

    public void visitSwitch(int i, int i2, int i3, SwitchList switchList, int i4) {
        int i5 = i;
        int i6 = i2;
        SwitchList switchList2 = switchList;
        int i7 = i4;
        visitCommon(i6, i3, false);
        addWorkIfNecessary(switchList2.getDefaultTarget(), true);
        int size = switchList2.size();
        for (int i8 = 0; i8 < size; i8++) {
            addWorkIfNecessary(switchList2.getTarget(i8), true);
        }
        this.targetLists[i6] = switchList2.getTargets();
    }
}
