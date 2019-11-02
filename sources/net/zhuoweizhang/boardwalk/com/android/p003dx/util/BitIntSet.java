package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.util.NoSuchElementException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.BitIntSet */
public class BitIntSet implements IntSet {
    int[] bits;

    public BitIntSet(int i) {
        this.bits = Bits.makeBitSet(i);
    }

    private void ensureCapacity(int i) {
        int i2 = i;
        if (i2 >= Bits.getMax(this.bits)) {
            int[] makeBitSet = Bits.makeBitSet(Math.max(i2 + 1, 2 * Bits.getMax(this.bits)));
            System.arraycopy(this.bits, 0, makeBitSet, 0, this.bits.length);
            this.bits = makeBitSet;
        }
    }

    public void add(int i) {
        int i2 = i;
        ensureCapacity(i2);
        Bits.set(this.bits, i2, true);
    }

    public int elements() {
        return Bits.bitCount(this.bits);
    }

    public boolean has(int i) {
        int i2 = i;
        return i2 < Bits.getMax(this.bits) && Bits.get(this.bits, i2);
    }

    public IntIterator iterator() {
        C07311 r4;
        C07311 r1 = r4;
        C07311 r2 = new IntIterator(this) {
            private int idx = Bits.findFirst(this.this$0.bits, 0);
            final /* synthetic */ BitIntSet this$0;

            {
                this.this$0 = r6;
            }

            public boolean hasNext() {
                return this.idx >= 0;
            }

            public int next() {
                NoSuchElementException noSuchElementException;
                if (!hasNext()) {
                    NoSuchElementException noSuchElementException2 = noSuchElementException;
                    NoSuchElementException noSuchElementException3 = new NoSuchElementException();
                    throw noSuchElementException2;
                }
                int i = this.idx;
                this.idx = Bits.findFirst(this.this$0.bits, 1 + this.idx);
                return i;
            }
        };
        return r1;
    }

    public void merge(IntSet intSet) {
        IntSet intSet2 = intSet;
        if (intSet2 instanceof BitIntSet) {
            BitIntSet bitIntSet = (BitIntSet) intSet2;
            ensureCapacity(1 + Bits.getMax(bitIntSet.bits));
            Bits.m45or(this.bits, bitIntSet.bits);
        } else if (intSet2 instanceof ListIntSet) {
            ListIntSet listIntSet = (ListIntSet) intSet2;
            int size = listIntSet.ints.size();
            if (size > 0) {
                ensureCapacity(listIntSet.ints.get(size - 1));
            }
            for (int i = 0; i < listIntSet.ints.size(); i++) {
                Bits.set(this.bits, listIntSet.ints.get(i), true);
            }
        } else {
            IntIterator it = intSet2.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }

    public void remove(int i) {
        int i2 = i;
        if (i2 < Bits.getMax(this.bits)) {
            Bits.set(this.bits, i2, false);
        }
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append('{');
        boolean z = true;
        int findFirst = Bits.findFirst(this.bits, 0);
        while (findFirst >= 0) {
            if (!z) {
                StringBuilder append2 = sb4.append(", ");
            }
            StringBuilder append3 = sb4.append(findFirst);
            findFirst = Bits.findFirst(this.bits, findFirst + 1);
            z = false;
        }
        StringBuilder append4 = sb4.append('}');
        return sb4.toString();
    }
}
