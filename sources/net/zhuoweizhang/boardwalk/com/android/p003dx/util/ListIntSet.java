package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.util.NoSuchElementException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.ListIntSet */
public class ListIntSet implements IntSet {
    final IntList ints;

    public ListIntSet() {
        IntList intList;
        IntList intList2 = intList;
        IntList intList3 = new IntList();
        this.ints = intList2;
        this.ints.sort();
    }

    public void add(int i) {
        int i2 = i;
        int binarysearch = this.ints.binarysearch(i2);
        if (binarysearch < 0) {
            this.ints.insert(-(binarysearch + 1), i2);
        }
    }

    public int elements() {
        return this.ints.size();
    }

    public boolean has(int i) {
        return this.ints.indexOf(i) >= 0;
    }

    public IntIterator iterator() {
        C07321 r4;
        C07321 r1 = r4;
        C07321 r2 = new IntIterator(this) {
            private int idx = 0;
            final /* synthetic */ ListIntSet this$0;

            {
                this.this$0 = r5;
            }

            public boolean hasNext() {
                return this.idx < this.this$0.ints.size();
            }

            public int next() {
                NoSuchElementException noSuchElementException;
                if (!hasNext()) {
                    NoSuchElementException noSuchElementException2 = noSuchElementException;
                    NoSuchElementException noSuchElementException3 = new NoSuchElementException();
                    throw noSuchElementException2;
                }
                IntList intList = this.this$0.ints;
                int i = this.idx;
                this.idx = i + 1;
                return intList.get(i);
            }
        };
        return r1;
    }

    public void merge(IntSet intSet) {
        IntSet intSet2 = intSet;
        int i = 0;
        if (intSet2 instanceof ListIntSet) {
            ListIntSet listIntSet = (ListIntSet) intSet2;
            int size = this.ints.size();
            int size2 = listIntSet.ints.size();
            int i2 = 0;
            while (i < size2 && i2 < size) {
                while (i < size2 && listIntSet.ints.get(i) < this.ints.get(i2)) {
                    int i3 = i + 1;
                    add(listIntSet.ints.get(i));
                    i = i3;
                }
                if (i == size2) {
                    break;
                }
                while (i2 < size && listIntSet.ints.get(i) >= this.ints.get(i2)) {
                    i2++;
                }
            }
            while (i < size2) {
                int i4 = i + 1;
                add(listIntSet.ints.get(i));
                i = i4;
            }
            this.ints.sort();
        } else if (intSet2 instanceof BitIntSet) {
            BitIntSet bitIntSet = (BitIntSet) intSet2;
            while (i >= 0) {
                this.ints.add(i);
                i = Bits.findFirst(bitIntSet.bits, i + 1);
            }
            this.ints.sort();
        } else {
            IntIterator it = intSet2.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }

    public void remove(int i) {
        int indexOf = this.ints.indexOf(i);
        if (indexOf >= 0) {
            this.ints.removeIndex(indexOf);
        }
    }

    public String toString() {
        return this.ints.toString();
    }
}
