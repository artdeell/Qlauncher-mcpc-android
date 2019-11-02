package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.TypeListItem */
public final class TypeListItem extends OffsettedItem {
    private static final int ALIGNMENT = 4;
    private static final int ELEMENT_SIZE = 2;
    private static final int HEADER_SIZE = 4;
    private final TypeList list;

    public TypeListItem(TypeList typeList) {
        TypeList typeList2 = typeList;
        super(4, 4 + (2 * typeList2.size()));
        this.list = typeList2;
    }

    public void addContents(DexFile dexFile) {
        TypeIdsSection typeIds = dexFile.getTypeIds();
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            TypeIdItem intern = typeIds.intern(this.list.getType(i));
        }
    }

    /* access modifiers changed from: protected */
    public int compareTo0(OffsettedItem offsettedItem) {
        return StdTypeList.compareContents(this.list, ((TypeListItem) offsettedItem).list);
    }

    public TypeList getList() {
        return this.list;
    }

    public int hashCode() {
        return StdTypeList.hashContents(this.list);
    }

    public ItemType itemType() {
        return ItemType.TYPE_TYPE_LIST;
    }

    public String toHuman() {
        RuntimeException runtimeException;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("unsupported");
        throw runtimeException2;
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        TypeIdsSection typeIds = dexFile.getTypeIds();
        int size = this.list.size();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb4 = sb;
            StringBuilder sb5 = new StringBuilder();
            annotatedOutput3.annotate(0, sb4.append(offsetString()).append(" type_list").toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            annotatedOutput4.annotate(4, sb6.append("  size: ").append(Hex.m53u4(size)).toString());
            for (int i = 0; i < size; i++) {
                Type type = this.list.getType(i);
                int indexOf = typeIds.indexOf(type);
                AnnotatedOutput annotatedOutput5 = annotatedOutput2;
                StringBuilder sb8 = sb3;
                StringBuilder sb9 = new StringBuilder();
                annotatedOutput5.annotate(2, sb8.append("  ").append(Hex.m51u2(indexOf)).append(" // ").append(type.toHuman()).toString());
            }
        }
        annotatedOutput2.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            annotatedOutput2.writeShort(typeIds.indexOf(this.list.getType(i2)));
        }
    }
}
