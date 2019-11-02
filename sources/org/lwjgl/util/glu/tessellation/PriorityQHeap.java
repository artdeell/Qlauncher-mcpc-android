package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.PriorityQ.Leq;
import org.lwjgl.util.glu.tessellation.PriorityQ.PQhandleElem;
import org.lwjgl.util.glu.tessellation.PriorityQ.PQnode;

class PriorityQHeap extends PriorityQ {
    static final /* synthetic */ boolean $assertionsDisabled = (!PriorityQHeap.class.desiredAssertionStatus());
    int freeList;
    PQhandleElem[] handles;
    boolean initialized;
    Leq leq;
    int max = 32;
    PQnode[] nodes = new PQnode[33];
    int size = 0;

    PriorityQHeap(Leq leq2) {
        PQhandleElem pQhandleElem;
        PQnode pQnode;
        Leq leq3 = leq2;
        for (int i = 0; i < this.nodes.length; i++) {
            PQnode[] pQnodeArr = this.nodes;
            int i2 = i;
            PQnode pQnode2 = pQnode;
            PQnode pQnode3 = new PQnode();
            pQnodeArr[i2] = pQnode2;
        }
        this.handles = new PQhandleElem[33];
        for (int i3 = 0; i3 < this.handles.length; i3++) {
            PQhandleElem[] pQhandleElemArr = this.handles;
            int i4 = i3;
            PQhandleElem pQhandleElem2 = pQhandleElem;
            PQhandleElem pQhandleElem3 = new PQhandleElem();
            pQhandleElemArr[i4] = pQhandleElem2;
        }
        this.initialized = false;
        this.freeList = 0;
        this.leq = leq3;
        this.nodes[1].handle = 1;
        this.handles[1].key = null;
    }

    /* access modifiers changed from: 0000 */
    public void FloatDown(int i) {
        AssertionError assertionError;
        int i2 = i;
        PQnode[] pQnodeArr = this.nodes;
        PQhandleElem[] pQhandleElemArr = this.handles;
        int i3 = pQnodeArr[i2].handle;
        while (true) {
            int i4 = i2 << 1;
            if (i4 < this.size && LEQ(this.leq, pQhandleElemArr[pQnodeArr[i4 + 1].handle].key, pQhandleElemArr[pQnodeArr[i4].handle].key)) {
                i4++;
            }
            if ($assertionsDisabled || i4 <= this.max) {
                int i5 = pQnodeArr[i4].handle;
                if (i4 > this.size || LEQ(this.leq, pQhandleElemArr[i3].key, pQhandleElemArr[i5].key)) {
                    pQnodeArr[i2].handle = i3;
                    pQhandleElemArr[i3].node = i2;
                } else {
                    pQnodeArr[i2].handle = i5;
                    pQhandleElemArr[i5].node = i2;
                    i2 = i4;
                }
            } else {
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
        }
        pQnodeArr[i2].handle = i3;
        pQhandleElemArr[i3].node = i2;
    }

    /* access modifiers changed from: 0000 */
    public void FloatUp(int i) {
        int i2 = i;
        PQnode[] pQnodeArr = this.nodes;
        PQhandleElem[] pQhandleElemArr = this.handles;
        int i3 = pQnodeArr[i2].handle;
        while (true) {
            int i4 = i2 >> 1;
            int i5 = pQnodeArr[i4].handle;
            if (i4 == 0 || LEQ(this.leq, pQhandleElemArr[i5].key, pQhandleElemArr[i3].key)) {
                pQnodeArr[i2].handle = i3;
                pQhandleElemArr[i3].node = i2;
            } else {
                pQnodeArr[i2].handle = i5;
                pQhandleElemArr[i5].node = i2;
                i2 = i4;
            }
        }
        pQnodeArr[i2].handle = i3;
        pQhandleElemArr[i3].node = i2;
    }

    /* access modifiers changed from: 0000 */
    public void pqDelete(int i) {
        AssertionError assertionError;
        int i2 = i;
        PQnode[] pQnodeArr = this.nodes;
        PQhandleElem[] pQhandleElemArr = this.handles;
        if ($assertionsDisabled || (i2 >= 1 && i2 <= this.max && pQhandleElemArr[i2].key != null)) {
            int i3 = pQhandleElemArr[i2].node;
            pQnodeArr[i3].handle = pQnodeArr[this.size].handle;
            pQhandleElemArr[pQnodeArr[i3].handle].node = i3;
            int i4 = -1 + this.size;
            this.size = i4;
            if (i3 <= i4) {
                if (i3 <= 1 || LEQ(this.leq, pQhandleElemArr[pQnodeArr[i3 >> 1].handle].key, pQhandleElemArr[pQnodeArr[i3].handle].key)) {
                    FloatDown(i3);
                } else {
                    FloatUp(i3);
                }
            }
            pQhandleElemArr[i2].key = null;
            pQhandleElemArr[i2].node = this.freeList;
            this.freeList = i2;
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    /* access modifiers changed from: 0000 */
    public void pqDeletePriorityQ() {
        this.handles = null;
        this.nodes = null;
    }

    /* access modifiers changed from: 0000 */
    public Object pqExtractMin() {
        PQnode[] pQnodeArr = this.nodes;
        PQhandleElem[] pQhandleElemArr = this.handles;
        int i = pQnodeArr[1].handle;
        Object obj = pQhandleElemArr[i].key;
        if (this.size > 0) {
            pQnodeArr[1].handle = pQnodeArr[this.size].handle;
            pQhandleElemArr[pQnodeArr[1].handle].node = 1;
            pQhandleElemArr[i].key = null;
            pQhandleElemArr[i].node = this.freeList;
            this.freeList = i;
            int i2 = -1 + this.size;
            this.size = i2;
            if (i2 > 0) {
                FloatDown(1);
            }
        }
        return obj;
    }

    /* access modifiers changed from: 0000 */
    public boolean pqInit() {
        for (int i = this.size; i >= 1; i--) {
            FloatDown(i);
        }
        this.initialized = true;
        return true;
    }

    /* access modifiers changed from: 0000 */
    public int pqInsert(Object obj) {
        int i;
        AssertionError assertionError;
        PQhandleElem pQhandleElem;
        PQnode pQnode;
        Object obj2 = obj;
        int i2 = 1 + this.size;
        this.size = i2;
        if (i2 * 2 > this.max) {
            PQnode[] pQnodeArr = this.nodes;
            PQhandleElem[] pQhandleElemArr = this.handles;
            this.max <<= 1;
            PQnode[] pQnodeArr2 = new PQnode[(1 + this.max)];
            System.arraycopy(this.nodes, 0, pQnodeArr2, 0, this.nodes.length);
            for (int length = this.nodes.length; length < pQnodeArr2.length; length++) {
                PQnode[] pQnodeArr3 = pQnodeArr2;
                int i3 = length;
                PQnode pQnode2 = pQnode;
                PQnode pQnode3 = new PQnode();
                pQnodeArr3[i3] = pQnode2;
            }
            this.nodes = pQnodeArr2;
            if (this.nodes == null) {
                this.nodes = pQnodeArr;
                i = Integer.MAX_VALUE;
                return i;
            }
            PQhandleElem[] pQhandleElemArr2 = new PQhandleElem[(1 + this.max)];
            System.arraycopy(this.handles, 0, pQhandleElemArr2, 0, this.handles.length);
            for (int length2 = this.handles.length; length2 < pQhandleElemArr2.length; length2++) {
                PQhandleElem[] pQhandleElemArr3 = pQhandleElemArr2;
                int i4 = length2;
                PQhandleElem pQhandleElem2 = pQhandleElem;
                PQhandleElem pQhandleElem3 = new PQhandleElem();
                pQhandleElemArr3[i4] = pQhandleElem2;
            }
            this.handles = pQhandleElemArr2;
            if (this.handles == null) {
                this.handles = pQhandleElemArr;
                return IDirectInputDevice.DIPROPRANGE_NOMAX;
            }
        }
        if (this.freeList == 0) {
            i = i2;
        } else {
            i = this.freeList;
            this.freeList = this.handles[i].node;
        }
        this.nodes[i2].handle = i;
        this.handles[i].node = i2;
        this.handles[i].key = obj2;
        if (this.initialized) {
            FloatUp(i2);
        }
        if (!$assertionsDisabled && i == Integer.MAX_VALUE) {
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    public boolean pqIsEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: 0000 */
    public Object pqMinimum() {
        return this.handles[this.nodes[1].handle].key;
    }
}
