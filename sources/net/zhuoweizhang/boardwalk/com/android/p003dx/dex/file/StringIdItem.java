package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.StringIdItem */
public final class StringIdItem extends IndexedItem implements Comparable {
    private StringDataItem data;
    private final CstString value;

    public StringIdItem(CstString cstString) {
        NullPointerException nullPointerException;
        CstString cstString2 = cstString;
        if (cstString2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("value == null");
            throw nullPointerException2;
        }
        this.value = cstString2;
        this.data = null;
    }

    public void addContents(DexFile dexFile) {
        StringDataItem stringDataItem;
        DexFile dexFile2 = dexFile;
        if (this.data == null) {
            MixedItemSection stringData = dexFile2.getStringData();
            StringDataItem stringDataItem2 = stringDataItem;
            StringDataItem stringDataItem3 = new StringDataItem(this.value);
            this.data = stringDataItem2;
            stringData.add(this.data);
        }
    }

    public int compareTo(Object obj) {
        return this.value.compareTo((Constant) ((StringIdItem) obj).value);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof StringIdItem)) {
            return false;
        }
        return this.value.equals(((StringIdItem) obj2).value);
    }

    public StringDataItem getData() {
        return this.data;
    }

    public CstString getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public ItemType itemType() {
        return ItemType.TYPE_STRING_ID_ITEM;
    }

    public int writeSize() {
        return 4;
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int absoluteOffset = this.data.getAbsoluteOffset();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(0, sb3.append(indexString()).append(' ').append(this.value.toQuoted(100)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append("  string_data_off: ").append(Hex.m53u4(absoluteOffset)).toString());
        }
        annotatedOutput2.writeInt(absoluteOffset);
    }
}
