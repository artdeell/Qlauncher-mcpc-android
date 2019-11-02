package com.tonicsystems.jarjar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractDepHandler implements DepHandler {
    protected final int level;
    private final Set<List<Object>> seenIt;

    protected AbstractDepHandler(int i) {
        HashSet hashSet;
        int i2 = i;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.seenIt = hashSet2;
        this.level = i2;
    }

    private static List<Object> createPair(Object obj, Object obj2) {
        ArrayList arrayList;
        Object obj3 = obj;
        Object obj4 = obj2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(2);
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add(obj3);
        boolean add2 = arrayList4.add(obj4);
        return arrayList4;
    }

    public void handle(PathClass pathClass, PathClass pathClass2) throws IOException {
        PathClass pathClass3 = pathClass;
        PathClass pathClass4 = pathClass2;
        List createPair = this.level == 1 ? createPair(pathClass3.getClassPath(), pathClass4.getClassPath()) : createPair(pathClass3.getClassName(), pathClass4.getClassName());
        if (!this.seenIt.contains(createPair)) {
            boolean add = this.seenIt.add(createPair);
            handle(createPair.get(0).toString(), createPair.get(1).toString());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void handle(String str, String str2) throws IOException;

    public void handleEnd() throws IOException {
    }

    public void handleStart() throws IOException {
    }
}
