package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!LinkedTreeMap.class.desiredAssertionStatus());
    private static final Comparator<Comparable> NATURAL_ORDER;
    Comparator<? super K> comparator;
    private EntrySet entrySet;
    final Node<K, V> header;
    private KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    class EntrySet extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ LinkedTreeMap this$0;

        EntrySet(LinkedTreeMap linkedTreeMap) {
            this.this$0 = linkedTreeMap;
        }

        public void clear() {
            this.this$0.clear();
        }

        public boolean contains(Object obj) {
            Object obj2 = obj;
            return (obj2 instanceof Entry) && this.this$0.findByEntry((Entry) obj2) != null;
        }

        public Iterator<Entry<K, V>> iterator() {
            C04841 r4;
            C04841 r1 = r4;
            C04841 r2 = new LinkedTreeMapIterator<Entry<K, V>>(this) {
                final /* synthetic */ EntrySet this$1;

                {
                    EntrySet entrySet = r6;
                    this.this$1 = entrySet;
                    LinkedTreeMap linkedTreeMap = entrySet.this$0;
                }

                public Entry<K, V> next() {
                    return nextNode();
                }
            };
            return r1;
        }

        public boolean remove(Object obj) {
            Object obj2 = obj;
            if (obj2 instanceof Entry) {
                Node findByEntry = this.this$0.findByEntry((Entry) obj2);
                if (findByEntry != null) {
                    this.this$0.removeInternal(findByEntry, true);
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return this.this$0.size;
        }
    }

    class KeySet extends AbstractSet<K> {
        final /* synthetic */ LinkedTreeMap this$0;

        KeySet(LinkedTreeMap linkedTreeMap) {
            this.this$0 = linkedTreeMap;
        }

        public void clear() {
            this.this$0.clear();
        }

        public boolean contains(Object obj) {
            return this.this$0.containsKey(obj);
        }

        public Iterator<K> iterator() {
            C04851 r4;
            C04851 r1 = r4;
            C04851 r2 = new LinkedTreeMapIterator<K>(this) {
                final /* synthetic */ KeySet this$1;

                {
                    KeySet keySet = r6;
                    this.this$1 = keySet;
                    LinkedTreeMap linkedTreeMap = keySet.this$0;
                }

                public K next() {
                    return nextNode().key;
                }
            };
            return r1;
        }

        public boolean remove(Object obj) {
            return this.this$0.removeInternalByKey(obj) != null;
        }

        public int size() {
            return this.this$0.size;
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned;
        Node<K, V> next;
        final /* synthetic */ LinkedTreeMap this$0;

        private LinkedTreeMapIterator(LinkedTreeMap linkedTreeMap) {
            this.this$0 = linkedTreeMap;
            this.next = this.this$0.header.next;
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
        }

        /* synthetic */ LinkedTreeMapIterator(LinkedTreeMap linkedTreeMap, C04831 r7) {
            C04831 r2 = r7;
            this(linkedTreeMap);
        }

        public final boolean hasNext() {
            return this.next != this.this$0.header;
        }

        /* access modifiers changed from: 0000 */
        public final Node<K, V> nextNode() {
            ConcurrentModificationException concurrentModificationException;
            NoSuchElementException noSuchElementException;
            Node<K, V> node = this.next;
            if (node == this.this$0.header) {
                NoSuchElementException noSuchElementException2 = noSuchElementException;
                NoSuchElementException noSuchElementException3 = new NoSuchElementException();
                throw noSuchElementException2;
            } else if (this.this$0.modCount != this.expectedModCount) {
                ConcurrentModificationException concurrentModificationException2 = concurrentModificationException;
                ConcurrentModificationException concurrentModificationException3 = new ConcurrentModificationException();
                throw concurrentModificationException2;
            } else {
                this.next = node.next;
                this.lastReturned = node;
                return node;
            }
        }

        public final void remove() {
            IllegalStateException illegalStateException;
            if (this.lastReturned == null) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException();
                throw illegalStateException2;
            }
            this.this$0.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = this.this$0.modCount;
        }
    }

    static final class Node<K, V> implements Entry<K, V> {
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        Node() {
            this.key = null;
            this.prev = this;
            this.next = this;
        }

        Node(Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            K k2 = k;
            Node<K, V> node4 = node2;
            Node<K, V> node5 = node3;
            this.parent = node;
            this.key = k2;
            this.height = 1;
            this.next = node4;
            this.prev = node5;
            node5.next = this;
            node4.prev = this;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
            if (r0.key.equals(r4.getKey()) != false) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
            if (r0.value.equals(r4.getValue()) != false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
            if (r4.getKey() == null) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
            if (r4.getValue() == null) goto L_0x002f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r12) {
            /*
                r11 = this;
                r0 = r11
                r1 = r12
                r9 = r1
                boolean r9 = r9 instanceof java.util.Map.Entry
                r2 = r9
                r9 = 0
                r3 = r9
                r9 = r2
                if (r9 == 0) goto L_0x0031
                r9 = r1
                java.util.Map$Entry r9 = (java.util.Map.Entry) r9
                r4 = r9
                r9 = r0
                K r9 = r9.key
                if (r9 != 0) goto L_0x0034
                r9 = r4
                java.lang.Object r9 = r9.getKey()
                r8 = r9
                r9 = 0
                r3 = r9
                r9 = r8
                if (r9 != 0) goto L_0x0031
            L_0x001f:
                r9 = r0
                V r9 = r9.value
                if (r9 != 0) goto L_0x0047
                r9 = r4
                java.lang.Object r9 = r9.getValue()
                r7 = r9
                r9 = 0
                r3 = r9
                r9 = r7
                if (r9 != 0) goto L_0x0031
            L_0x002f:
                r9 = 1
                r3 = r9
            L_0x0031:
                r9 = r3
                r0 = r9
                return r0
            L_0x0034:
                r9 = r0
                K r9 = r9.key
                r10 = r4
                java.lang.Object r10 = r10.getKey()
                boolean r9 = r9.equals(r10)
                r5 = r9
                r9 = 0
                r3 = r9
                r9 = r5
                if (r9 == 0) goto L_0x0031
                goto L_0x001f
            L_0x0047:
                r9 = r0
                V r9 = r9.value
                r10 = r4
                java.lang.Object r10 = r10.getValue()
                boolean r9 = r9.equals(r10)
                r6 = r9
                r9 = 0
                r3 = r9
                r9 = r6
                if (r9 == 0) goto L_0x0031
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public Node<K, V> first() {
            Node node = this;
            Node<K, V> node2 = node.left;
            while (true) {
                Node node3 = node2;
                if (node3 == null) {
                    return node;
                }
                node = node3;
                node2 = node.left;
            }
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            int i = 0;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public Node<K, V> last() {
            Node node = this;
            Node<K, V> node2 = node.right;
            while (true) {
                Node node3 = node2;
                if (node3 == null) {
                    return node;
                }
                node = node3;
                node2 = node.right;
            }
        }

        public V setValue(V v) {
            V v2 = v;
            V v3 = this.value;
            this.value = v2;
            return v3;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append(this.key).append("=").append(this.value).toString();
        }
    }

    static {
        C04831 r3;
        C04831 r1 = r3;
        C04831 r2 = new Comparator<Comparable>() {
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        };
        NATURAL_ORDER = r1;
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Comparator<? super K>, code=java.util.Comparator, for r7v0, types: [java.util.Comparator<? super K>, java.util.Comparator] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LinkedTreeMap(java.util.Comparator r7) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r0
            r2.<init>()
            r2 = r0
            r3 = 0
            r2.size = r3
            r2 = r0
            r3 = 0
            r2.modCount = r3
            r2 = r0
            com.google.gson.internal.LinkedTreeMap$Node r3 = new com.google.gson.internal.LinkedTreeMap$Node
            r5 = r3
            r3 = r5
            r4 = r5
            r4.<init>()
            r2.header = r3
            r2 = r1
            if (r2 == 0) goto L_0x0021
        L_0x001c:
            r2 = r0
            r3 = r1
            r2.comparator = r3
            return
        L_0x0021:
            java.util.Comparator<java.lang.Comparable> r2 = NATURAL_ORDER
            r1 = r2
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.<init>(java.util.Comparator):void");
    }

    private boolean equal(Object obj, Object obj2) {
        Object obj3 = obj;
        Object obj4 = obj2;
        return obj3 == obj4 || (obj3 != null && obj3.equals(obj4));
    }

    private void rebalance(Node<K, V> node, boolean z) {
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        boolean z2 = z;
        Node<K, V> node2 = node;
        while (true) {
            Node<K, V> node3 = node2;
            if (node3 != null) {
                Node<K, V> node4 = node3.left;
                Node<K, V> node5 = node3.right;
                int i = node4 != null ? node4.height : 0;
                int i2 = node5 != null ? node5.height : 0;
                int i3 = i - i2;
                if (i3 == -2) {
                    Node<K, V> node6 = node5.left;
                    Node<K, V> node7 = node5.right;
                    int i4 = (node6 != null ? node6.height : 0) - (node7 != null ? node7.height : 0);
                    if (i4 == -1 || (i4 == 0 && !z2)) {
                        rotateLeft(node3);
                    } else if ($assertionsDisabled || i4 == 1) {
                        rotateRight(node5);
                        rotateLeft(node3);
                    } else {
                        AssertionError assertionError4 = assertionError3;
                        AssertionError assertionError5 = new AssertionError();
                        throw assertionError4;
                    }
                    if (z2) {
                        return;
                    }
                } else if (i3 == 2) {
                    Node<K, V> node8 = node4.left;
                    Node<K, V> node9 = node4.right;
                    int i5 = (node8 != null ? node8.height : 0) - (node9 != null ? node9.height : 0);
                    if (i5 == 1 || (i5 == 0 && !z2)) {
                        rotateRight(node3);
                    } else if ($assertionsDisabled || i5 == -1) {
                        rotateLeft(node4);
                        rotateRight(node3);
                    } else {
                        AssertionError assertionError6 = assertionError2;
                        AssertionError assertionError7 = new AssertionError();
                        throw assertionError6;
                    }
                    if (z2) {
                        return;
                    }
                } else if (i3 == 0) {
                    node3.height = i + 1;
                    if (z2) {
                        return;
                    }
                } else if ($assertionsDisabled || i3 == -1 || i3 == 1) {
                    node3.height = 1 + Math.max(i, i2);
                    if (!z2) {
                        return;
                    }
                } else {
                    AssertionError assertionError8 = assertionError;
                    AssertionError assertionError9 = new AssertionError();
                    throw assertionError8;
                }
                node2 = node3.parent;
            } else {
                return;
            }
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        AssertionError assertionError;
        Node<K, V> node3 = node;
        Node<K, V> node4 = node2;
        Node<K, V> node5 = node3.parent;
        node3.parent = null;
        if (node4 != null) {
            node4.parent = node5;
        }
        if (node5 == null) {
            this.root = node4;
        } else if (node5.left == node3) {
            node5.left = node4;
        } else if ($assertionsDisabled || node5.right == node3) {
            node5.right = node4;
        } else {
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Node<K, V> node2 = node;
        Node<K, V> node3 = node2.left;
        Node<K, V> node4 = node2.right;
        Node<K, V> node5 = node4.left;
        Node<K, V> node6 = node4.right;
        node2.right = node5;
        if (node5 != null) {
            node5.parent = node2;
        }
        replaceInParent(node2, node4);
        node4.left = node2;
        node2.parent = node4;
        node2.height = 1 + Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0);
        int i = node2.height;
        int i2 = 0;
        if (node6 != null) {
            i2 = node6.height;
        }
        node4.height = 1 + Math.max(i, i2);
    }

    private void rotateRight(Node<K, V> node) {
        Node<K, V> node2 = node;
        Node<K, V> node3 = node2.left;
        Node<K, V> node4 = node2.right;
        Node<K, V> node5 = node3.left;
        Node<K, V> node6 = node3.right;
        node2.left = node6;
        if (node6 != null) {
            node6.parent = node2;
        }
        replaceInParent(node2, node3);
        node3.right = node2;
        node2.parent = node3;
        node2.height = 1 + Math.max(node4 != null ? node4.height : 0, node6 != null ? node6.height : 0);
        int i = node2.height;
        int i2 = 0;
        if (node5 != null) {
            i2 = node5.height;
        }
        node3.height = 1 + Math.max(i, i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(this);
        return linkedHashMap2;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount = 1 + this.modCount;
        Node<K, V> node = this.header;
        node.prev = node;
        node.next = node;
    }

    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        EntrySet entrySet2;
        EntrySet entrySet3 = this.entrySet;
        if (entrySet3 != null) {
            return entrySet3;
        }
        EntrySet entrySet4 = entrySet2;
        EntrySet entrySet5 = new EntrySet(this);
        EntrySet entrySet6 = entrySet4;
        this.entrySet = entrySet6;
        return entrySet6;
    }

    /* access modifiers changed from: 0000 */
    public Node<K, V> find(K k, boolean z) {
        Node<K, V> node;
        Node node2;
        Node node3;
        Node node4;
        ClassCastException classCastException;
        StringBuilder sb;
        K k2 = k;
        boolean z2 = z;
        Comparator<? super K> comparator2 = this.comparator;
        Node<K, V> node5 = this.root;
        int i = 0;
        if (node5 != null) {
            Comparable comparable = comparator2 == NATURAL_ORDER ? (Comparable) k2 : null;
            while (true) {
                i = comparable != null ? comparable.compareTo(node5.key) : comparator2.compare(k2, node5.key);
                if (i == 0) {
                    node = node5;
                    break;
                }
                Node<K, V> node6 = i < 0 ? node5.left : node5.right;
                if (node6 == null) {
                    break;
                }
                node5 = node6;
            }
            return node;
        }
        node = null;
        if (z2) {
            Node<K, V> node7 = this.header;
            if (node5 != null) {
                Node node8 = node2;
                Node node9 = new Node(node5, k2, node7, node7.prev);
                node3 = node8;
                if (i < 0) {
                    node5.left = node3;
                } else {
                    node5.right = node3;
                }
                rebalance(node5, true);
            } else if (comparator2 != NATURAL_ORDER || (k2 instanceof Comparable)) {
                Node node10 = node4;
                Node node11 = new Node(node5, k2, node7, node7.prev);
                node3 = node10;
                this.root = node3;
            } else {
                ClassCastException classCastException2 = classCastException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                ClassCastException classCastException3 = new ClassCastException(sb2.append(k2.getClass().getName()).append(" is not Comparable").toString());
                throw classCastException2;
            }
            this.size = 1 + this.size;
            this.modCount = 1 + this.modCount;
            return node3;
        }
        return node;
    }

    /* access modifiers changed from: 0000 */
    public Node<K, V> findByEntry(Entry<?, ?> entry) {
        Entry<?, ?> entry2 = entry;
        Node findByObject = findByObject(entry2.getKey());
        if (findByObject != null && equal(findByObject.value, entry2.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public Node<K, V> findByObject(Object obj) {
        Object obj2 = obj;
        Node<K, V> node = null;
        if (obj2 != null) {
            try {
                node = find(obj2, false);
            } catch (ClassCastException e) {
                ClassCastException classCastException = e;
                return null;
            }
        }
        return node;
    }

    public V get(Object obj) {
        Node findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    public Set<K> keySet() {
        KeySet keySet2;
        KeySet keySet3 = this.keySet;
        if (keySet3 != null) {
            return keySet3;
        }
        KeySet keySet4 = keySet2;
        KeySet keySet5 = new KeySet(this);
        KeySet keySet6 = keySet4;
        this.keySet = keySet6;
        return keySet6;
    }

    public V put(K k, V v) {
        NullPointerException nullPointerException;
        K k2 = k;
        V v2 = v;
        if (k2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("key == null");
            throw nullPointerException2;
        }
        Node find = find(k2, true);
        V v3 = find.value;
        find.value = v2;
        return v3;
    }

    public V remove(Object obj) {
        Node removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void removeInternal(Node<K, V> node, boolean z) {
        Node<K, V> node2 = node;
        if (z) {
            node2.prev.next = node2.next;
            node2.next.prev = node2.prev;
        }
        Node<K, V> node3 = node2.left;
        Node<K, V> node4 = node2.right;
        Node<K, V> node5 = node2.parent;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                replaceInParent(node2, node3);
                node2.left = null;
            } else if (node4 != null) {
                replaceInParent(node2, node4);
                node2.right = null;
            } else {
                replaceInParent(node2, null);
            }
            rebalance(node5, false);
            this.size = -1 + this.size;
            this.modCount = 1 + this.modCount;
            return;
        }
        Node first = node3.height > node4.height ? node3.last() : node4.first();
        removeInternal(first, false);
        Node<K, V> node6 = node2.left;
        int i = 0;
        if (node6 != null) {
            i = node6.height;
            first.left = node6;
            node6.parent = first;
            node2.left = null;
        }
        Node<K, V> node7 = node2.right;
        int i2 = 0;
        if (node7 != null) {
            i2 = node7.height;
            first.right = node7;
            node7.parent = first;
            node2.right = null;
        }
        first.height = 1 + Math.max(i, i2);
        replaceInParent(node2, first);
    }

    /* access modifiers changed from: 0000 */
    public Node<K, V> removeInternalByKey(Object obj) {
        Node findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public int size() {
        return this.size;
    }
}
