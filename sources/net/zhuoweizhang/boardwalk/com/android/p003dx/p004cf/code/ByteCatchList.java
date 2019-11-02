package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ByteCatchList */
public final class ByteCatchList extends FixedSizeList {
    public static final ByteCatchList EMPTY;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ByteCatchList$Item */
    public static class Item {
        private final int endPc;
        private final CstType exceptionClass;
        private final int handlerPc;
        private final int startPc;

        public Item(int i, int i2, int i3, CstType cstType) {
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            IllegalArgumentException illegalArgumentException3;
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            CstType cstType2 = cstType;
            if (i4 < 0) {
                IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("startPc < 0");
                throw illegalArgumentException4;
            } else if (i5 < i4) {
                IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("endPc < startPc");
                throw illegalArgumentException6;
            } else if (i6 < 0) {
                IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("handlerPc < 0");
                throw illegalArgumentException8;
            } else {
                this.startPc = i4;
                this.endPc = i5;
                this.handlerPc = i6;
                this.exceptionClass = cstType2;
            }
        }

        public boolean covers(int i) {
            int i2 = i;
            return i2 >= this.startPc && i2 < this.endPc;
        }

        public int getEndPc() {
            return this.endPc;
        }

        public CstType getExceptionClass() {
            return this.exceptionClass != null ? this.exceptionClass : CstType.OBJECT;
        }

        public int getHandlerPc() {
            return this.handlerPc;
        }

        public int getStartPc() {
            return this.startPc;
        }
    }

    static {
        ByteCatchList byteCatchList;
        ByteCatchList byteCatchList2 = byteCatchList;
        ByteCatchList byteCatchList3 = new ByteCatchList(0);
        EMPTY = byteCatchList2;
    }

    public ByteCatchList(int i) {
        super(i);
    }

    private static boolean typeNotFound(Item item, Item[] itemArr, int i) {
        Item[] itemArr2 = itemArr;
        int i2 = i;
        CstType exceptionClass = item.getExceptionClass();
        for (int i3 = 0; i3 < i2; i3++) {
            CstType exceptionClass2 = itemArr2[i3].getExceptionClass();
            if (exceptionClass2 == exceptionClass || exceptionClass2 == CstType.OBJECT) {
                return false;
            }
        }
        return true;
    }

    public int byteLength() {
        return 2 + (8 * size());
    }

    public Item get(int i) {
        return (Item) get0(i);
    }

    public ByteCatchList listFor(int i) {
        ByteCatchList byteCatchList;
        int i2 = i;
        int size = size();
        Item[] itemArr = new Item[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Item item = get(i4);
            if (item.covers(i2) && typeNotFound(item, itemArr, i3)) {
                itemArr[i3] = item;
                i3++;
            }
        }
        if (i3 == 0) {
            return EMPTY;
        }
        ByteCatchList byteCatchList2 = byteCatchList;
        ByteCatchList byteCatchList3 = new ByteCatchList(i3);
        ByteCatchList byteCatchList4 = byteCatchList2;
        for (int i5 = 0; i5 < i3; i5++) {
            byteCatchList4.set(i5, itemArr[i5]);
        }
        byteCatchList4.setImmutable();
        return byteCatchList4;
    }

    public void set(int i, int i2, int i3, int i4, CstType cstType) {
        Item item;
        int i5 = i;
        Item item2 = item;
        Item item3 = new Item(i2, i3, i4, cstType);
        set0(i5, item2);
    }

    public void set(int i, Item item) {
        NullPointerException nullPointerException;
        int i2 = i;
        Item item2 = item;
        if (item2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("item == null");
            throw nullPointerException2;
        }
        set0(i2, item2);
    }

    public TypeList toRopCatchList() {
        StdTypeList stdTypeList;
        int size = size();
        if (size == 0) {
            return StdTypeList.EMPTY;
        }
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(size);
        StdTypeList stdTypeList4 = stdTypeList2;
        for (int i = 0; i < size; i++) {
            stdTypeList4.set(i, get(i).getExceptionClass().getClassType());
        }
        stdTypeList4.setImmutable();
        return stdTypeList4;
    }

    public IntList toTargetList(int i) {
        IntList intList;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        int i3 = 1;
        if (i2 < -1) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("noException < -1");
            throw illegalArgumentException2;
        }
        boolean z = i2 >= 0;
        int size = size();
        if (size == 0) {
            return z ? IntList.makeImmutable(i2) : IntList.EMPTY;
        }
        if (!z) {
            i3 = 0;
        }
        IntList intList2 = intList;
        IntList intList3 = new IntList(i3 + size);
        IntList intList4 = intList2;
        for (int i4 = 0; i4 < size; i4++) {
            intList4.add(get(i4).getHandlerPc());
        }
        if (z) {
            intList4.add(i2);
        }
        intList4.setImmutable();
        return intList4;
    }
}
