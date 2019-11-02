package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.TypeIdItem */
public final class TypeIdItem extends IdItem {
    public TypeIdItem(CstType cstType) {
        super(cstType);
    }

    public void addContents(DexFile dexFile) {
        StringIdItem intern = dexFile.getStringIds().intern(getDefiningClass().getDescriptor());
    }

    public ItemType itemType() {
        return ItemType.TYPE_TYPE_ID_ITEM;
    }

    public int writeSize() {
        return 4;
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        CstString descriptor = getDefiningClass().getDescriptor();
        int indexOf = dexFile2.getStringIds().indexOf(descriptor);
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(0, sb3.append(indexString()).append(' ').append(descriptor.toHuman()).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append("  descriptor_idx: ").append(Hex.m53u4(indexOf)).toString());
        }
        annotatedOutput2.writeInt(indexOf);
    }
}
