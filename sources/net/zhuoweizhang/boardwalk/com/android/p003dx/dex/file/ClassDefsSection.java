package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.ClassDefsSection */
public final class ClassDefsSection extends UniformItemSection {
    private final TreeMap<Type, ClassDefItem> classDefs;
    private ArrayList<ClassDefItem> orderedDefs = null;

    public ClassDefsSection(DexFile dexFile) {
        TreeMap<Type, ClassDefItem> treeMap;
        super("class_defs", dexFile, 4);
        TreeMap<Type, ClassDefItem> treeMap2 = treeMap;
        TreeMap<Type, ClassDefItem> treeMap3 = new TreeMap<>();
        this.classDefs = treeMap2;
    }

    private int orderItems0(Type type, int i, int i2) {
        RuntimeException runtimeException;
        StringBuilder sb;
        Type type2 = type;
        int i3 = i;
        int i4 = i2;
        ClassDefItem classDefItem = (ClassDefItem) this.classDefs.get(type2);
        if (classDefItem == null || classDefItem.hasIndex()) {
            return i3;
        }
        if (i4 < 0) {
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            RuntimeException runtimeException3 = new RuntimeException(sb2.append("class circularity with ").append(type2).toString());
            throw runtimeException2;
        }
        int i5 = i4 - 1;
        CstType superclass = classDefItem.getSuperclass();
        if (superclass != null) {
            i3 = orderItems0(superclass.getClassType(), i3, i5);
        }
        TypeList interfaces = classDefItem.getInterfaces();
        int size = interfaces.size();
        for (int i6 = 0; i6 < size; i6++) {
            i3 = orderItems0(interfaces.getType(i6), i3, i5);
        }
        classDefItem.setIndex(i3);
        boolean add = this.orderedDefs.add(classDefItem);
        return i3 + 1;
    }

    public void add(ClassDefItem classDefItem) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        ClassDefItem classDefItem2 = classDefItem;
        try {
            Type classType = classDefItem2.getThisClass().getClassType();
            throwIfPrepared();
            if (this.classDefs.get(classType) != null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("already added: ").append(classType).toString());
                throw illegalArgumentException2;
            }
            Object put = this.classDefs.put(classType, classDefItem2);
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("clazz == null");
            throw nullPointerException3;
        }
    }

    public IndexedItem get(Constant constant) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        Constant constant2 = constant;
        if (constant2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cst == null");
            throw nullPointerException2;
        }
        throwIfNotPrepared();
        IndexedItem indexedItem = (IndexedItem) this.classDefs.get(((CstType) constant2).getClassType());
        if (indexedItem != null) {
            return indexedItem;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("not found");
        throw illegalArgumentException2;
    }

    public Collection<? extends Item> items() {
        return this.orderedDefs != null ? this.orderedDefs : this.classDefs.values();
    }

    /* access modifiers changed from: protected */
    public void orderItems() {
        ArrayList<ClassDefItem> arrayList;
        int size = this.classDefs.size();
        ArrayList<ClassDefItem> arrayList2 = arrayList;
        ArrayList<ClassDefItem> arrayList3 = new ArrayList<>(size);
        this.orderedDefs = arrayList2;
        Iterator it = this.classDefs.keySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = orderItems0((Type) it.next(), i2, size - i2);
            } else {
                return;
            }
        }
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        throwIfNotPrepared();
        int size = this.classDefs.size();
        int fileOffset = size == 0 ? 0 : getFileOffset();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(4, sb3.append("class_defs_size: ").append(Hex.m53u4(size)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append("class_defs_off:  ").append(Hex.m53u4(fileOffset)).toString());
        }
        annotatedOutput2.writeInt(size);
        annotatedOutput2.writeInt(fileOffset);
    }
}
