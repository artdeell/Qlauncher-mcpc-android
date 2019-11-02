package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.ArrayList;
import java.util.HashSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CatchTable.Entry;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.StdCatchBuilder */
public final class StdCatchBuilder implements CatchBuilder {
    private static final int MAX_CATCH_RANGE = 65535;
    private final BlockAddresses addresses;
    private final RopMethod method;
    private final int[] order;

    public StdCatchBuilder(RopMethod ropMethod, int[] iArr, BlockAddresses blockAddresses) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        RopMethod ropMethod2 = ropMethod;
        int[] iArr2 = iArr;
        BlockAddresses blockAddresses2 = blockAddresses;
        if (ropMethod2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("method == null");
            throw nullPointerException4;
        } else if (iArr2 == null) {
            NullPointerException nullPointerException6 = nullPointerException2;
            NullPointerException nullPointerException7 = new NullPointerException("order == null");
            throw nullPointerException6;
        } else if (blockAddresses2 == null) {
            NullPointerException nullPointerException8 = nullPointerException;
            NullPointerException nullPointerException9 = new NullPointerException("addresses == null");
            throw nullPointerException8;
        } else {
            this.method = ropMethod2;
            this.order = iArr2;
            this.addresses = blockAddresses2;
        }
    }

    public static CatchTable build(RopMethod ropMethod, int[] iArr, BlockAddresses blockAddresses) {
        ArrayList arrayList;
        BasicBlock basicBlock;
        CatchTable catchTable;
        CatchHandlerList catchHandlerList;
        RopMethod ropMethod2 = ropMethod;
        int[] iArr2 = iArr;
        BlockAddresses blockAddresses2 = blockAddresses;
        BasicBlock basicBlock2 = null;
        int length = iArr2.length;
        BasicBlockList blocks = ropMethod2.getBlocks();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(length);
        ArrayList arrayList4 = arrayList2;
        CatchHandlerList catchHandlerList2 = CatchHandlerList.EMPTY;
        int i = 0;
        BasicBlock basicBlock3 = null;
        while (true) {
            basicBlock = basicBlock3;
            if (i >= length) {
                break;
            }
            BasicBlock labelToBlock = blocks.labelToBlock(iArr2[i]);
            if (!labelToBlock.canThrow()) {
                labelToBlock = basicBlock;
                catchHandlerList = catchHandlerList2;
            } else {
                CatchHandlerList handlersFor = handlersFor(labelToBlock, blockAddresses2);
                if (catchHandlerList2.size() == 0) {
                    basicBlock2 = labelToBlock;
                    catchHandlerList = handlersFor;
                } else if (!catchHandlerList2.equals(handlersFor) || !rangeIsValid(basicBlock, labelToBlock, blockAddresses2)) {
                    if (catchHandlerList2.size() != 0) {
                        boolean add = arrayList4.add(makeEntry(basicBlock, basicBlock2, catchHandlerList2, blockAddresses2));
                    }
                    basicBlock2 = labelToBlock;
                    catchHandlerList = handlersFor;
                } else {
                    basicBlock2 = labelToBlock;
                    labelToBlock = basicBlock;
                    catchHandlerList = catchHandlerList2;
                }
            }
            i++;
            catchHandlerList2 = catchHandlerList;
            basicBlock3 = labelToBlock;
        }
        if (catchHandlerList2.size() != 0) {
            boolean add2 = arrayList4.add(makeEntry(basicBlock, basicBlock2, catchHandlerList2, blockAddresses2));
        }
        int size = arrayList4.size();
        if (size == 0) {
            return CatchTable.EMPTY;
        }
        CatchTable catchTable2 = catchTable;
        CatchTable catchTable3 = new CatchTable(size);
        CatchTable catchTable4 = catchTable2;
        for (int i2 = 0; i2 < size; i2++) {
            catchTable4.set(i2, (Entry) arrayList4.get(i2));
        }
        catchTable4.setImmutable();
        return catchTable4;
    }

    private static CatchHandlerList handlersFor(BasicBlock basicBlock, BlockAddresses blockAddresses) {
        RuntimeException runtimeException;
        CatchHandlerList catchHandlerList;
        CstType cstType;
        BasicBlock basicBlock2 = basicBlock;
        BlockAddresses blockAddresses2 = blockAddresses;
        IntList successors = basicBlock2.getSuccessors();
        int size = successors.size();
        int primarySuccessor = basicBlock2.getPrimarySuccessor();
        TypeList catches = basicBlock2.getLastInsn().getCatches();
        int size2 = catches.size();
        if (size2 == 0) {
            return CatchHandlerList.EMPTY;
        }
        if ((primarySuccessor != -1 || size == size2) && (primarySuccessor == -1 || (size == size2 + 1 && primarySuccessor == successors.get(size2)))) {
            int i = 0;
            while (true) {
                if (i >= size2) {
                    break;
                } else if (catches.getType(i).equals(Type.OBJECT)) {
                    size2 = i + 1;
                    break;
                } else {
                    i++;
                }
            }
            CatchHandlerList catchHandlerList2 = catchHandlerList;
            CatchHandlerList catchHandlerList3 = new CatchHandlerList(size2);
            CatchHandlerList catchHandlerList4 = catchHandlerList2;
            for (int i2 = 0; i2 < size2; i2++) {
                CatchHandlerList catchHandlerList5 = catchHandlerList4;
                int i3 = i2;
                CstType cstType2 = cstType;
                CstType cstType3 = new CstType(catches.getType(i2));
                catchHandlerList5.set(i3, cstType2, blockAddresses2.getStart(successors.get(i2)).getAddress());
            }
            catchHandlerList4.setImmutable();
            return catchHandlerList4;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("shouldn't happen: weird successors list");
        throw runtimeException2;
    }

    private static Entry makeEntry(BasicBlock basicBlock, BasicBlock basicBlock2, CatchHandlerList catchHandlerList, BlockAddresses blockAddresses) {
        Entry entry;
        BasicBlock basicBlock3 = basicBlock2;
        BlockAddresses blockAddresses2 = blockAddresses;
        Entry entry2 = entry;
        Entry entry3 = new Entry(blockAddresses2.getLast(basicBlock).getAddress(), blockAddresses2.getEnd(basicBlock3).getAddress(), catchHandlerList);
        return entry2;
    }

    private static boolean rangeIsValid(BasicBlock basicBlock, BasicBlock basicBlock2, BlockAddresses blockAddresses) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        BasicBlock basicBlock3 = basicBlock;
        BasicBlock basicBlock4 = basicBlock2;
        BlockAddresses blockAddresses2 = blockAddresses;
        if (basicBlock3 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("start == null");
            throw nullPointerException3;
        } else if (basicBlock4 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("end == null");
            throw nullPointerException5;
        } else {
            return blockAddresses2.getEnd(basicBlock4).getAddress() - blockAddresses2.getLast(basicBlock3).getAddress() <= 65535;
        }
    }

    public CatchTable build() {
        return build(this.method, this.order, this.addresses);
    }

    public HashSet<Type> getCatchTypes() {
        HashSet hashSet;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet(20);
        HashSet hashSet4 = hashSet2;
        BasicBlockList blocks = this.method.getBlocks();
        int size = blocks.size();
        for (int i = 0; i < size; i++) {
            TypeList catches = blocks.get(i).getLastInsn().getCatches();
            int size2 = catches.size();
            for (int i2 = 0; i2 < size2; i2++) {
                boolean add = hashSet4.add(catches.getType(i2));
            }
        }
        return hashSet4;
    }

    public boolean hasAnyCatches() {
        boolean z;
        BasicBlockList blocks = this.method.getBlocks();
        int size = blocks.size();
        int i = 0;
        while (true) {
            z = false;
            if (i >= size) {
                break;
            } else if (blocks.get(i).getLastInsn().getCatches().size() != 0) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return z;
    }
}
