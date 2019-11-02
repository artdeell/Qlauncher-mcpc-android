package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Collection;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.command.dexer.Main;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.TypeIdsSection */
public final class TypeIdsSection extends UniformItemSection {
    private final TreeMap<Type, TypeIdItem> typeIds;

    public TypeIdsSection(DexFile dexFile) {
        TreeMap<Type, TypeIdItem> treeMap;
        super("type_ids", dexFile, 4);
        TreeMap<Type, TypeIdItem> treeMap2 = treeMap;
        TreeMap<Type, TypeIdItem> treeMap3 = new TreeMap<>();
        this.typeIds = treeMap2;
    }

    public IndexedItem get(Constant constant) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        NullPointerException nullPointerException;
        Constant constant2 = constant;
        if (constant2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cst == null");
            throw nullPointerException2;
        }
        throwIfNotPrepared();
        IndexedItem indexedItem = (IndexedItem) this.typeIds.get(((CstType) constant2).getClassType());
        if (indexedItem != null) {
            return indexedItem;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("not found: ").append(constant2).toString());
        throw illegalArgumentException2;
    }

    public int indexOf(CstType cstType) {
        NullPointerException nullPointerException;
        CstType cstType2 = cstType;
        if (cstType2 != null) {
            return indexOf(cstType2.getClassType());
        }
        NullPointerException nullPointerException2 = nullPointerException;
        NullPointerException nullPointerException3 = new NullPointerException("type == null");
        throw nullPointerException2;
    }

    public int indexOf(Type type) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        NullPointerException nullPointerException;
        Type type2 = type;
        if (type2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("type == null");
            throw nullPointerException2;
        }
        throwIfNotPrepared();
        TypeIdItem typeIdItem = (TypeIdItem) this.typeIds.get(type2);
        if (typeIdItem != null) {
            return typeIdItem.getIndex();
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("not found: ").append(type2).toString());
        throw illegalArgumentException2;
    }

    public TypeIdItem intern(CstType cstType) {
        TypeIdItem typeIdItem;
        TypeIdItem typeIdItem2;
        NullPointerException nullPointerException;
        CstType cstType2 = cstType;
        synchronized (this) {
            if (cstType2 == null) {
                try {
                    NullPointerException nullPointerException2 = nullPointerException;
                    NullPointerException nullPointerException3 = new NullPointerException("type == null");
                    throw nullPointerException2;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            } else {
                throwIfPrepared();
                Type classType = cstType2.getClassType();
                typeIdItem = (TypeIdItem) this.typeIds.get(classType);
                if (typeIdItem == null) {
                    TypeIdItem typeIdItem3 = typeIdItem2;
                    TypeIdItem typeIdItem4 = new TypeIdItem(cstType2);
                    typeIdItem = typeIdItem3;
                    Object put = this.typeIds.put(classType, typeIdItem);
                }
            }
        }
        return typeIdItem;
    }

    public TypeIdItem intern(Type type) {
        TypeIdItem typeIdItem;
        CstType cstType;
        NullPointerException nullPointerException;
        Type type2 = type;
        if (type2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("type == null");
            throw nullPointerException2;
        }
        throwIfPrepared();
        TypeIdItem typeIdItem2 = (TypeIdItem) this.typeIds.get(type2);
        if (typeIdItem2 == null) {
            TypeIdItem typeIdItem3 = typeIdItem;
            CstType cstType2 = cstType;
            CstType cstType3 = new CstType(type2);
            TypeIdItem typeIdItem4 = new TypeIdItem(cstType2);
            typeIdItem2 = typeIdItem3;
            Object put = this.typeIds.put(type2, typeIdItem2);
        }
        return typeIdItem2;
    }

    public Collection<? extends Item> items() {
        return this.typeIds.values();
    }

    /* access modifiers changed from: protected */
    public void orderItems() {
        int i = 0;
        for (Item item : items()) {
            ((TypeIdItem) item).setIndex(i);
            i++;
        }
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        DexException dexException;
        StringBuilder sb3;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        throwIfNotPrepared();
        int size = this.typeIds.size();
        int fileOffset = size == 0 ? 0 : getFileOffset();
        if (size > 65536) {
            DexException dexException2 = dexException;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            DexException dexException3 = new DexException(sb4.append("Too many type references: ").append(size).append("; max is ").append(65536).append(".\n").append(Main.getTooManyIdsErrorMessage()).toString());
            throw dexException2;
        }
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            annotatedOutput3.annotate(4, sb6.append("type_ids_size:   ").append(Hex.m53u4(size)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            annotatedOutput4.annotate(4, sb8.append("type_ids_off:    ").append(Hex.m53u4(fileOffset)).toString());
        }
        annotatedOutput2.writeInt(size);
        annotatedOutput2.writeInt(fileOffset);
    }
}
