package org.lwjgl.util.glu.tessellation;

class Dict {
    Object frame;
    DictNode head;
    DictLeq leq;

    public interface DictLeq {
        boolean leq(Object obj, Object obj2, Object obj3);
    }

    private Dict() {
    }

    static void dictDelete(Dict dict, DictNode dictNode) {
        Dict dict2 = dict;
        DictNode dictNode2 = dictNode;
        dictNode2.next.prev = dictNode2.prev;
        dictNode2.prev.next = dictNode2.next;
    }

    static void dictDeleteDict(Dict dict) {
        Dict dict2 = dict;
        dict2.head = null;
        dict2.frame = null;
        dict2.leq = null;
    }

    static DictNode dictInsert(Dict dict, Object obj) {
        Dict dict2 = dict;
        return dictInsertBefore(dict2, dict2.head, obj);
    }

    static DictNode dictInsertBefore(Dict dict, DictNode dictNode, Object obj) {
        DictNode dictNode2;
        Dict dict2 = dict;
        DictNode dictNode3 = dictNode;
        Object obj2 = obj;
        do {
            dictNode3 = dictNode3.prev;
            if (dictNode3.key == null) {
                break;
            }
        } while (!dict2.leq.leq(dict2.frame, dictNode3.key, obj2));
        DictNode dictNode4 = dictNode2;
        DictNode dictNode5 = new DictNode();
        DictNode dictNode6 = dictNode4;
        dictNode6.key = obj2;
        dictNode6.next = dictNode3.next;
        dictNode3.next.prev = dictNode6;
        dictNode6.prev = dictNode3;
        dictNode3.next = dictNode6;
        return dictNode6;
    }

    static Object dictKey(DictNode dictNode) {
        return dictNode.key;
    }

    static DictNode dictMax(Dict dict) {
        return dict.head.prev;
    }

    static DictNode dictMin(Dict dict) {
        return dict.head.next;
    }

    static Dict dictNewDict(Object obj, DictLeq dictLeq) {
        Dict dict;
        DictNode dictNode;
        Object obj2 = obj;
        DictLeq dictLeq2 = dictLeq;
        Dict dict2 = dict;
        Dict dict3 = new Dict();
        Dict dict4 = dict2;
        Dict dict5 = dict4;
        DictNode dictNode2 = dictNode;
        DictNode dictNode3 = new DictNode();
        dict5.head = dictNode2;
        dict4.head.key = null;
        dict4.head.next = dict4.head;
        dict4.head.prev = dict4.head;
        dict4.frame = obj2;
        dict4.leq = dictLeq2;
        return dict4;
    }

    static DictNode dictPred(DictNode dictNode) {
        return dictNode.prev;
    }

    static DictNode dictSearch(Dict dict, Object obj) {
        Dict dict2 = dict;
        Object obj2 = obj;
        DictNode dictNode = dict2.head;
        do {
            dictNode = dictNode.next;
            if (dictNode.key == null) {
                break;
            }
        } while (!dict2.leq.leq(dict2.frame, obj2, dictNode.key));
        return dictNode;
    }

    static DictNode dictSucc(DictNode dictNode) {
        return dictNode.next;
    }
}
