package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.dex.Leb128;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.StringDataItem */
public final class StringDataItem extends OffsettedItem {
    private final CstString value;

    public StringDataItem(CstString cstString) {
        CstString cstString2 = cstString;
        super(1, writeSize(cstString2));
        this.value = cstString2;
    }

    private static int writeSize(CstString cstString) {
        CstString cstString2 = cstString;
        return 1 + Leb128.unsignedLeb128Size(cstString2.getUtf16Size()) + cstString2.getUtf8Size();
    }

    public void addContents(DexFile dexFile) {
    }

    /* access modifiers changed from: protected */
    public int compareTo0(OffsettedItem offsettedItem) {
        return this.value.compareTo((Constant) ((StringDataItem) offsettedItem).value);
    }

    public ItemType itemType() {
        return ItemType.TYPE_STRING_DATA_ITEM;
    }

    public String toHuman() {
        return this.value.toQuoted();
    }

    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        ByteArray bytes = this.value.getBytes();
        int utf16Size = this.value.getUtf16Size();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            int unsignedLeb128Size = Leb128.unsignedLeb128Size(utf16Size);
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            annotatedOutput3.annotate(unsignedLeb128Size, sb2.append("utf16_size: ").append(Hex.m53u4(utf16Size)).toString());
            annotatedOutput2.annotate(1 + bytes.size(), this.value.toQuoted());
        }
        int writeUleb128 = annotatedOutput2.writeUleb128(utf16Size);
        annotatedOutput2.write(bytes);
        annotatedOutput2.writeByte(0);
    }
}
