package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Collection;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstBaseMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.MethodIdsSection */
public final class MethodIdsSection extends MemberIdsSection {
    private final TreeMap<CstBaseMethodRef, MethodIdItem> methodIds;

    public MethodIdsSection(DexFile dexFile) {
        TreeMap<CstBaseMethodRef, MethodIdItem> treeMap;
        super("method_ids", dexFile);
        TreeMap<CstBaseMethodRef, MethodIdItem> treeMap2 = treeMap;
        TreeMap<CstBaseMethodRef, MethodIdItem> treeMap3 = new TreeMap<>();
        this.methodIds = treeMap2;
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
        IndexedItem indexedItem = (IndexedItem) this.methodIds.get((CstBaseMethodRef) constant2);
        if (indexedItem != null) {
            return indexedItem;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("not found");
        throw illegalArgumentException2;
    }

    public int indexOf(CstBaseMethodRef cstBaseMethodRef) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        CstBaseMethodRef cstBaseMethodRef2 = cstBaseMethodRef;
        if (cstBaseMethodRef2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("ref == null");
            throw nullPointerException2;
        }
        throwIfNotPrepared();
        MethodIdItem methodIdItem = (MethodIdItem) this.methodIds.get(cstBaseMethodRef2);
        if (methodIdItem != null) {
            return methodIdItem.getIndex();
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("not found");
        throw illegalArgumentException2;
    }

    public MethodIdItem intern(CstBaseMethodRef cstBaseMethodRef) {
        MethodIdItem methodIdItem;
        MethodIdItem methodIdItem2;
        NullPointerException nullPointerException;
        CstBaseMethodRef cstBaseMethodRef2 = cstBaseMethodRef;
        synchronized (this) {
            if (cstBaseMethodRef2 == null) {
                try {
                    NullPointerException nullPointerException2 = nullPointerException;
                    NullPointerException nullPointerException3 = new NullPointerException("method == null");
                    throw nullPointerException2;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            } else {
                throwIfPrepared();
                methodIdItem = (MethodIdItem) this.methodIds.get(cstBaseMethodRef2);
                if (methodIdItem == null) {
                    MethodIdItem methodIdItem3 = methodIdItem2;
                    MethodIdItem methodIdItem4 = new MethodIdItem(cstBaseMethodRef2);
                    methodIdItem = methodIdItem3;
                    Object put = this.methodIds.put(cstBaseMethodRef2, methodIdItem);
                }
            }
        }
        return methodIdItem;
    }

    public Collection<? extends Item> items() {
        return this.methodIds.values();
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        throwIfNotPrepared();
        int size = this.methodIds.size();
        int fileOffset = size == 0 ? 0 : getFileOffset();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(4, sb3.append("method_ids_size: ").append(Hex.m53u4(size)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append("method_ids_off:  ").append(Hex.m53u4(fileOffset)).toString());
        }
        annotatedOutput2.writeInt(size);
        annotatedOutput2.writeInt(fileOffset);
    }
}
