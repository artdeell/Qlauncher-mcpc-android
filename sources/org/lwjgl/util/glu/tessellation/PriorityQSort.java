package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.PriorityQ.Leq;

class PriorityQSort extends PriorityQ {
    static final /* synthetic */ boolean $assertionsDisabled = (!PriorityQSort.class.desiredAssertionStatus());
    PriorityQHeap heap;
    boolean initialized = false;
    Object[] keys = new Object[32];
    Leq leq;
    int max = 32;
    int[] order;
    int size = 0;

    private static class Stack {

        /* renamed from: p */
        int f244p;

        /* renamed from: r */
        int f245r;

        private Stack() {
        }

        /* synthetic */ Stack(C08451 r4) {
            C08451 r1 = r4;
            this();
        }
    }

    PriorityQSort(Leq leq2) {
        PriorityQHeap priorityQHeap;
        Leq leq3 = leq2;
        PriorityQHeap priorityQHeap2 = priorityQHeap;
        PriorityQHeap priorityQHeap3 = new PriorityQHeap(leq3);
        this.heap = priorityQHeap2;
        this.leq = leq3;
    }

    /* renamed from: GT */
    private static boolean m55GT(Leq leq2, Object obj, Object obj2) {
        return !PriorityQHeap.LEQ(leq2, obj, obj2);
    }

    /* renamed from: LT */
    private static boolean m56LT(Leq leq2, Object obj, Object obj2) {
        return !PriorityQHeap.LEQ(leq2, obj2, obj);
    }

    private static void Swap(int[] iArr, int i, int i2) {
        int[] iArr2 = iArr;
        int i3 = i;
        int i4 = i2;
        int i5 = iArr2[i3];
        iArr2[i3] = iArr2[i4];
        iArr2[i4] = i5;
    }

    /* access modifiers changed from: 0000 */
    public void pqDelete(int i) {
        AssertionError assertionError;
        int i2 = i;
        if (i2 >= 0) {
            this.heap.pqDelete(i2);
            return;
        }
        int i3 = -(i2 + 1);
        if ($assertionsDisabled || (i3 < this.max && this.keys[i3] != null)) {
            this.keys[i3] = null;
            while (this.size > 0 && this.keys[this.order[-1 + this.size]] == null) {
                this.size = -1 + this.size;
            }
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    /* access modifiers changed from: 0000 */
    public void pqDeletePriorityQ() {
        if (this.heap != null) {
            this.heap.pqDeletePriorityQ();
        }
        this.order = null;
        this.keys = null;
    }

    /* access modifiers changed from: 0000 */
    public Object pqExtractMin() {
        Object obj;
        if (this.size == 0) {
            obj = this.heap.pqExtractMin();
        } else {
            obj = this.keys[this.order[-1 + this.size]];
            if (!this.heap.pqIsEmpty()) {
                if (LEQ(this.leq, this.heap.pqMinimum(), obj)) {
                    return this.heap.pqExtractMin();
                }
            }
            do {
                this.size = -1 + this.size;
                if (this.size > 0) {
                }
            } while (this.keys[this.order[-1 + this.size]] == null);
            return obj;
        }
        return obj;
    }

    /* access modifiers changed from: 0000 */
    public boolean pqInit() {
        Stack stack;
        Stack[] stackArr = new Stack[50];
        for (int i = 0; i < stackArr.length; i++) {
            Stack[] stackArr2 = stackArr;
            int i2 = i;
            Stack stack2 = stack;
            Stack stack3 = new Stack(null);
            stackArr2[i2] = stack2;
        }
        int i3 = 2016473283;
        this.order = new int[(1 + this.size)];
        int i4 = -1 + this.size;
        int i5 = 0;
        for (int i6 = 0; i6 <= i4; i6++) {
            this.order[i6] = i5;
            i5++;
        }
        stackArr[0].f244p = 0;
        stackArr[0].f245r = i4;
        int i7 = 0 + 1;
        while (true) {
            i7--;
            if (i7 >= 0) {
                int i8 = stackArr[i7].f244p;
                int i9 = stackArr[i7].f245r;
                while (i9 > i8 + 10) {
                    i3 = Math.abs(1 + (1539415821 * i3));
                    int i10 = i8 + (i3 % (1 + (i9 - i8)));
                    int i11 = this.order[i10];
                    this.order[i10] = this.order[i8];
                    this.order[i8] = i11;
                    int i12 = i8 - 1;
                    int i13 = i9 + 1;
                    while (true) {
                        i12++;
                        if (!m55GT(this.leq, this.keys[this.order[i12]], this.keys[i11])) {
                            do {
                                i13--;
                            } while (m56LT(this.leq, this.keys[this.order[i13]], this.keys[i11]));
                            Swap(this.order, i12, i13);
                            if (i12 >= i13) {
                                break;
                            }
                        }
                    }
                    Swap(this.order, i12, i13);
                    if (i12 - i8 < i9 - i13) {
                        stackArr[i7].f244p = i13 + 1;
                        stackArr[i7].f245r = i9;
                        i7++;
                        i9 = i12 - 1;
                    } else {
                        stackArr[i7].f244p = i8;
                        stackArr[i7].f245r = i12 - 1;
                        i7++;
                        i8 = i13 + 1;
                    }
                }
                for (int i14 = i8 + 1; i14 <= i9; i14++) {
                    int i15 = this.order[i14];
                    int i16 = i14;
                    while (i16 > i8) {
                        if (!m56LT(this.leq, this.keys[this.order[i16 - 1]], this.keys[i15])) {
                            break;
                        }
                        this.order[i16] = this.order[i16 - 1];
                        i16--;
                    }
                    this.order[i16] = i15;
                }
            } else {
                this.max = this.size;
                this.initialized = true;
                boolean pqInit = this.heap.pqInit();
                return true;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int pqInsert(Object obj) {
        AssertionError assertionError;
        Object obj2 = obj;
        if (this.initialized) {
            return this.heap.pqInsert(obj2);
        }
        int i = this.size;
        int i2 = 1 + this.size;
        this.size = i2;
        if (i2 >= this.max) {
            Object[] objArr = this.keys;
            this.max <<= 1;
            Object[] objArr2 = new Object[this.max];
            System.arraycopy(this.keys, 0, objArr2, 0, this.keys.length);
            this.keys = objArr2;
            if (this.keys == null) {
                this.keys = objArr;
                return IDirectInputDevice.DIPROPRANGE_NOMAX;
            }
        }
        if ($assertionsDisabled || i != Integer.MAX_VALUE) {
            this.keys[i] = obj2;
            return -(i + 1);
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    /* access modifiers changed from: 0000 */
    public boolean pqIsEmpty() {
        return this.size == 0 && this.heap.pqIsEmpty();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003b, code lost:
        if (org.lwjgl.util.glu.tessellation.PriorityQHeap.LEQ(r0.leq, r2, r1) == false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object pqMinimum() {
        /*
            r7 = this;
            r0 = r7
            r3 = r0
            int r3 = r3.size
            if (r3 != 0) goto L_0x0011
            r3 = r0
            org.lwjgl.util.glu.tessellation.PriorityQHeap r3 = r3.heap
            java.lang.Object r3 = r3.pqMinimum()
            r2 = r3
        L_0x000e:
            r3 = r2
            r0 = r3
        L_0x0010:
            return r0
        L_0x0011:
            r3 = r0
            java.lang.Object[] r3 = r3.keys
            r4 = r0
            int[] r4 = r4.order
            r5 = -1
            r6 = r0
            int r6 = r6.size
            int r5 = r5 + r6
            r4 = r4[r5]
            r3 = r3[r4]
            r1 = r3
            r3 = r0
            org.lwjgl.util.glu.tessellation.PriorityQHeap r3 = r3.heap
            boolean r3 = r3.pqIsEmpty()
            if (r3 != 0) goto L_0x003d
            r3 = r0
            org.lwjgl.util.glu.tessellation.PriorityQHeap r3 = r3.heap
            java.lang.Object r3 = r3.pqMinimum()
            r2 = r3
            r3 = r0
            org.lwjgl.util.glu.tessellation.PriorityQ$Leq r3 = r3.leq
            r4 = r2
            r5 = r1
            boolean r3 = org.lwjgl.util.glu.tessellation.PriorityQHeap.LEQ(r3, r4, r5)
            if (r3 != 0) goto L_0x000e
        L_0x003d:
            r3 = r1
            r0 = r3
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.glu.tessellation.PriorityQSort.pqMinimum():java.lang.Object");
    }
}
