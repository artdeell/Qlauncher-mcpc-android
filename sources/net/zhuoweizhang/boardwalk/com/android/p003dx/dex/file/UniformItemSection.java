package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Collection;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.UniformItemSection */
public abstract class UniformItemSection extends Section {
    public UniformItemSection(String str, DexFile dexFile, int i) {
        super(str, dexFile, i);
    }

    public abstract IndexedItem get(Constant constant);

    public final int getAbsoluteItemOffset(Item item) {
        IndexedItem indexedItem = (IndexedItem) item;
        return getAbsoluteOffset(indexedItem.getIndex() * indexedItem.writeSize());
    }

    /* access modifiers changed from: protected */
    public abstract void orderItems();

    /* access modifiers changed from: protected */
    public final void prepare0() {
        DexFile file = getFile();
        orderItems();
        for (Item addContents : items()) {
            addContents.addContents(file);
        }
    }

    public final int writeSize() {
        Collection items = items();
        int size = items.size();
        if (size == 0) {
            return 0;
        }
        return size * ((Item) items.iterator().next()).writeSize();
    }

    /* access modifiers changed from: protected */
    public final void writeTo0(AnnotatedOutput annotatedOutput) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DexFile file = getFile();
        int alignment = getAlignment();
        for (Item writeTo : items()) {
            writeTo.writeTo(file, annotatedOutput2);
            annotatedOutput2.alignTo(alignment);
        }
    }
}
