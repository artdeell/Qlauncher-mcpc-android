package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Collection;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.ProtoIdsSection */
public final class ProtoIdsSection extends UniformItemSection {
    private final TreeMap<Prototype, ProtoIdItem> protoIds;

    public ProtoIdsSection(DexFile dexFile) {
        TreeMap<Prototype, ProtoIdItem> treeMap;
        super("proto_ids", dexFile, 4);
        TreeMap<Prototype, ProtoIdItem> treeMap2 = treeMap;
        TreeMap<Prototype, ProtoIdItem> treeMap3 = new TreeMap<>();
        this.protoIds = treeMap2;
    }

    public IndexedItem get(Constant constant) {
        UnsupportedOperationException unsupportedOperationException;
        Constant constant2 = constant;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("unsupported");
        throw unsupportedOperationException2;
    }

    public int indexOf(Prototype prototype) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        Prototype prototype2 = prototype;
        if (prototype2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("prototype == null");
            throw nullPointerException2;
        }
        throwIfNotPrepared();
        ProtoIdItem protoIdItem = (ProtoIdItem) this.protoIds.get(prototype2);
        if (protoIdItem != null) {
            return protoIdItem.getIndex();
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("not found");
        throw illegalArgumentException2;
    }

    public ProtoIdItem intern(Prototype prototype) {
        ProtoIdItem protoIdItem;
        NullPointerException nullPointerException;
        Prototype prototype2 = prototype;
        if (prototype2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("prototype == null");
            throw nullPointerException2;
        }
        throwIfPrepared();
        ProtoIdItem protoIdItem2 = (ProtoIdItem) this.protoIds.get(prototype2);
        if (protoIdItem2 == null) {
            ProtoIdItem protoIdItem3 = protoIdItem;
            ProtoIdItem protoIdItem4 = new ProtoIdItem(prototype2);
            protoIdItem2 = protoIdItem3;
            Object put = this.protoIds.put(prototype2, protoIdItem2);
        }
        return protoIdItem2;
    }

    public Collection<? extends Item> items() {
        return this.protoIds.values();
    }

    /* access modifiers changed from: protected */
    public void orderItems() {
        int i = 0;
        for (Item item : items()) {
            ((ProtoIdItem) item).setIndex(i);
            i++;
        }
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        UnsupportedOperationException unsupportedOperationException;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        throwIfNotPrepared();
        int size = this.protoIds.size();
        int fileOffset = size == 0 ? 0 : getFileOffset();
        if (size > 65536) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("too many proto ids");
            throw unsupportedOperationException2;
        }
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(4, sb3.append("proto_ids_size:  ").append(Hex.m53u4(size)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append("proto_ids_off:   ").append(Hex.m53u4(fileOffset)).toString());
        }
        annotatedOutput2.writeInt(size);
        annotatedOutput2.writeInt(fileOffset);
    }
}
