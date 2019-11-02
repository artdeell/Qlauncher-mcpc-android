package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LineNumberList */
public final class LineNumberList extends FixedSizeList {
    public static final LineNumberList EMPTY;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LineNumberList$Item */
    public static class Item {
        private final int lineNumber;
        private final int startPc;

        public Item(int i, int i2) {
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            int i3 = i;
            int i4 = i2;
            if (i3 < 0) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("startPc < 0");
                throw illegalArgumentException3;
            } else if (i4 < 0) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("lineNumber < 0");
                throw illegalArgumentException5;
            } else {
                this.startPc = i3;
                this.lineNumber = i4;
            }
        }

        public int getLineNumber() {
            return this.lineNumber;
        }

        public int getStartPc() {
            return this.startPc;
        }
    }

    static {
        LineNumberList lineNumberList;
        LineNumberList lineNumberList2 = lineNumberList;
        LineNumberList lineNumberList3 = new LineNumberList(0);
        EMPTY = lineNumberList2;
    }

    public LineNumberList(int i) {
        super(i);
    }

    public static LineNumberList concat(LineNumberList lineNumberList, LineNumberList lineNumberList2) {
        LineNumberList lineNumberList3;
        int i;
        LineNumberList lineNumberList4 = lineNumberList;
        LineNumberList lineNumberList5 = lineNumberList2;
        if (lineNumberList4 == EMPTY) {
            return lineNumberList5;
        }
        int size = lineNumberList4.size();
        int size2 = lineNumberList5.size();
        LineNumberList lineNumberList6 = lineNumberList3;
        LineNumberList lineNumberList7 = new LineNumberList(size + size2);
        LineNumberList lineNumberList8 = lineNumberList6;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            lineNumberList8.set(i2, lineNumberList4.get(i2));
            i2++;
        }
        for (i = 0; i < size2; i++) {
            lineNumberList8.set(size + i, lineNumberList5.get(i));
        }
        return lineNumberList8;
    }

    public Item get(int i) {
        return (Item) get0(i);
    }

    public int pcToLine(int i) {
        int i2 = i;
        int size = size();
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        while (i3 < size) {
            Item item = get(i3);
            int startPc = item.getStartPc();
            if (startPc > i2 || startPc <= i4) {
                startPc = i4;
            } else {
                i5 = item.getLineNumber();
                if (startPc == i2) {
                    break;
                }
            }
            i3++;
            i4 = startPc;
        }
        return i5;
    }

    public void set(int i, int i2, int i3) {
        Item item;
        int i4 = i;
        Item item2 = item;
        Item item3 = new Item(i2, i3);
        set0(i4, item2);
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
}
