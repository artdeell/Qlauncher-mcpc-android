package org.lwjgl.util.glu.tessellation;

abstract class PriorityQ {
    public static final int INIT_SIZE = 32;

    public interface Leq {
        boolean leq(Object obj, Object obj2);
    }

    public static class PQhandleElem {
        Object key;
        int node;

        public PQhandleElem() {
        }
    }

    public static class PQnode {
        int handle;

        public PQnode() {
        }
    }

    PriorityQ() {
    }

    public static boolean LEQ(Leq leq, Object obj, Object obj2) {
        Leq leq2 = leq;
        return Geom.VertLeq((GLUvertex) obj, (GLUvertex) obj2);
    }

    static PriorityQ pqNewPriorityQ(Leq leq) {
        PriorityQSort priorityQSort;
        PriorityQSort priorityQSort2 = priorityQSort;
        PriorityQSort priorityQSort3 = new PriorityQSort(leq);
        return priorityQSort2;
    }

    /* access modifiers changed from: 0000 */
    public abstract void pqDelete(int i);

    /* access modifiers changed from: 0000 */
    public abstract void pqDeletePriorityQ();

    /* access modifiers changed from: 0000 */
    public abstract Object pqExtractMin();

    /* access modifiers changed from: 0000 */
    public abstract boolean pqInit();

    /* access modifiers changed from: 0000 */
    public abstract int pqInsert(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract boolean pqIsEmpty();

    /* access modifiers changed from: 0000 */
    public abstract Object pqMinimum();
}
