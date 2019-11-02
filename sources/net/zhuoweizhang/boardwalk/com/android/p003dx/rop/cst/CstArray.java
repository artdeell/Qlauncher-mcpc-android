package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstArray */
public final class CstArray extends Constant {
    private final List list;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstArray$List */
    public static final class List extends FixedSizeList implements Comparable<List> {
        public List(int i) {
            super(i);
        }

        public int compareTo(List list) {
            List list2 = list;
            int size = size();
            int size2 = list2.size();
            int i = size < size2 ? size : size2;
            for (int i2 = 0; i2 < i; i2++) {
                int compareTo = ((Constant) get0(i2)).compareTo((Constant) list2.get0(i2));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            if (size < size2) {
                return -1;
            }
            return size > size2 ? 1 : 0;
        }

        public Constant get(int i) {
            return (Constant) get0(i);
        }

        public void set(int i, Constant constant) {
            set0(i, constant);
        }
    }

    public CstArray(List list2) {
        NullPointerException nullPointerException;
        List list3 = list2;
        if (list3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("list == null");
            throw nullPointerException2;
        }
        list3.throwIfMutable();
        this.list = list3;
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        return this.list.compareTo(((CstArray) constant).list);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof CstArray)) {
            return false;
        }
        return this.list.equals(((CstArray) obj2).list);
    }

    public List getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public boolean isCategory2() {
        return false;
    }

    public String toHuman() {
        return this.list.toHuman("{", ", ", "}");
    }

    public String toString() {
        return this.list.toString("array{", ", ", "}");
    }

    public String typeName() {
        return "array";
    }
}
