package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Collection;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.FieldIdsSection */
public final class FieldIdsSection extends MemberIdsSection {
    private final TreeMap<CstFieldRef, FieldIdItem> fieldIds;

    public FieldIdsSection(DexFile dexFile) {
        TreeMap<CstFieldRef, FieldIdItem> treeMap;
        super("field_ids", dexFile);
        TreeMap<CstFieldRef, FieldIdItem> treeMap2 = treeMap;
        TreeMap<CstFieldRef, FieldIdItem> treeMap3 = new TreeMap<>();
        this.fieldIds = treeMap2;
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
        IndexedItem indexedItem = (IndexedItem) this.fieldIds.get((CstFieldRef) constant2);
        if (indexedItem != null) {
            return indexedItem;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("not found");
        throw illegalArgumentException2;
    }

    public int indexOf(CstFieldRef cstFieldRef) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        CstFieldRef cstFieldRef2 = cstFieldRef;
        if (cstFieldRef2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("ref == null");
            throw nullPointerException2;
        }
        throwIfNotPrepared();
        FieldIdItem fieldIdItem = (FieldIdItem) this.fieldIds.get(cstFieldRef2);
        if (fieldIdItem != null) {
            return fieldIdItem.getIndex();
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("not found");
        throw illegalArgumentException2;
    }

    public FieldIdItem intern(CstFieldRef cstFieldRef) {
        FieldIdItem fieldIdItem;
        FieldIdItem fieldIdItem2;
        NullPointerException nullPointerException;
        CstFieldRef cstFieldRef2 = cstFieldRef;
        synchronized (this) {
            if (cstFieldRef2 == null) {
                try {
                    NullPointerException nullPointerException2 = nullPointerException;
                    NullPointerException nullPointerException3 = new NullPointerException("field == null");
                    throw nullPointerException2;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            } else {
                throwIfPrepared();
                fieldIdItem = (FieldIdItem) this.fieldIds.get(cstFieldRef2);
                if (fieldIdItem == null) {
                    FieldIdItem fieldIdItem3 = fieldIdItem2;
                    FieldIdItem fieldIdItem4 = new FieldIdItem(cstFieldRef2);
                    fieldIdItem = fieldIdItem3;
                    Object put = this.fieldIds.put(cstFieldRef2, fieldIdItem);
                }
            }
        }
        return fieldIdItem;
    }

    public Collection<? extends Item> items() {
        return this.fieldIds.values();
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        throwIfNotPrepared();
        int size = this.fieldIds.size();
        int fileOffset = size == 0 ? 0 : getFileOffset();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(4, sb3.append("field_ids_size:  ").append(Hex.m53u4(size)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append("field_ids_off:   ").append(Hex.m53u4(fileOffset)).toString());
        }
        annotatedOutput2.writeInt(size);
        annotatedOutput2.writeInt(fileOffset);
    }
}
