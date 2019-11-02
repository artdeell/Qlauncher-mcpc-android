package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CatchTable */
public final class CatchTable extends FixedSizeList implements Comparable<CatchTable> {
    public static final CatchTable EMPTY;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CatchTable$Entry */
    public static class Entry implements Comparable<Entry> {
        private final int end;
        private final CatchHandlerList handlers;
        private final int start;

        public Entry(int i, int i2, CatchHandlerList catchHandlerList) {
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            IllegalArgumentException illegalArgumentException3;
            int i3 = i;
            int i4 = i2;
            CatchHandlerList catchHandlerList2 = catchHandlerList;
            if (i3 < 0) {
                IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("start < 0");
                throw illegalArgumentException4;
            } else if (i4 <= i3) {
                IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("end <= start");
                throw illegalArgumentException6;
            } else if (catchHandlerList2.isMutable()) {
                IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("handlers.isMutable()");
                throw illegalArgumentException8;
            } else {
                this.start = i3;
                this.end = i4;
                this.handlers = catchHandlerList2;
            }
        }

        public int compareTo(Entry entry) {
            Entry entry2 = entry;
            if (this.start >= entry2.start) {
                if (this.start > entry2.start) {
                    return 1;
                }
                if (this.end >= entry2.end) {
                    if (this.end > entry2.end) {
                        return 1;
                    }
                    return this.handlers.compareTo(entry2.handlers);
                }
            }
            return -1;
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            boolean z = false;
            if (obj2 instanceof Entry) {
                z = false;
                if (compareTo((Entry) obj2) == 0) {
                    z = true;
                }
            }
            return z;
        }

        public int getEnd() {
            return this.end;
        }

        public CatchHandlerList getHandlers() {
            return this.handlers;
        }

        public int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (31 * ((31 * this.start) + this.end)) + this.handlers.hashCode();
        }
    }

    static {
        CatchTable catchTable;
        CatchTable catchTable2 = catchTable;
        CatchTable catchTable3 = new CatchTable(0);
        EMPTY = catchTable2;
    }

    public CatchTable(int i) {
        super(i);
    }

    public int compareTo(CatchTable catchTable) {
        CatchTable catchTable2 = catchTable;
        if (this != catchTable2) {
            int size = size();
            int size2 = catchTable2.size();
            int min = Math.min(size, size2);
            for (int i = 0; i < min; i++) {
                int compareTo = get(i).compareTo(catchTable2.get(i));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            if (size < size2) {
                return -1;
            }
            if (size > size2) {
                return 1;
            }
        }
        return 0;
    }

    public Entry get(int i) {
        return (Entry) get0(i);
    }

    public void set(int i, Entry entry) {
        set0(i, entry);
    }
}
