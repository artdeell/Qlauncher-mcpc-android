package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Collection;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.StringIdsSection */
public final class StringIdsSection extends UniformItemSection {
    private final TreeMap<CstString, StringIdItem> strings;

    public StringIdsSection(DexFile dexFile) {
        TreeMap<CstString, StringIdItem> treeMap;
        super("string_ids", dexFile, 4);
        TreeMap<CstString, StringIdItem> treeMap2 = treeMap;
        TreeMap<CstString, StringIdItem> treeMap3 = new TreeMap<>();
        this.strings = treeMap2;
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
        IndexedItem indexedItem = (IndexedItem) this.strings.get((CstString) constant2);
        if (indexedItem != null) {
            return indexedItem;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("not found");
        throw illegalArgumentException2;
    }

    public int indexOf(CstString cstString) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        CstString cstString2 = cstString;
        if (cstString2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("string == null");
            throw nullPointerException2;
        }
        throwIfNotPrepared();
        StringIdItem stringIdItem = (StringIdItem) this.strings.get(cstString2);
        if (stringIdItem != null) {
            return stringIdItem.getIndex();
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("not found");
        throw illegalArgumentException2;
    }

    public StringIdItem intern(String str) {
        StringIdItem stringIdItem;
        CstString cstString;
        StringIdItem stringIdItem2 = stringIdItem;
        CstString cstString2 = cstString;
        CstString cstString3 = new CstString(str);
        StringIdItem stringIdItem3 = new StringIdItem(cstString2);
        return intern(stringIdItem2);
    }

    public StringIdItem intern(StringIdItem stringIdItem) {
        NullPointerException nullPointerException;
        StringIdItem stringIdItem2 = stringIdItem;
        if (stringIdItem2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("string == null");
            throw nullPointerException2;
        }
        throwIfPrepared();
        CstString value = stringIdItem2.getValue();
        StringIdItem stringIdItem3 = (StringIdItem) this.strings.get(value);
        if (stringIdItem3 != null) {
            return stringIdItem3;
        }
        Object put = this.strings.put(value, stringIdItem2);
        return stringIdItem2;
    }

    public StringIdItem intern(CstString cstString) {
        StringIdItem stringIdItem;
        StringIdItem stringIdItem2 = stringIdItem;
        StringIdItem stringIdItem3 = new StringIdItem(cstString);
        return intern(stringIdItem2);
    }

    public void intern(CstNat cstNat) {
        CstNat cstNat2 = cstNat;
        StringIdItem intern = intern(cstNat2.getName());
        StringIdItem intern2 = intern(cstNat2.getDescriptor());
    }

    public Collection<? extends Item> items() {
        return this.strings.values();
    }

    /* access modifiers changed from: protected */
    public void orderItems() {
        int i = 0;
        for (StringIdItem index : this.strings.values()) {
            index.setIndex(i);
            i++;
        }
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        throwIfNotPrepared();
        int size = this.strings.size();
        int fileOffset = size == 0 ? 0 : getFileOffset();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(4, sb3.append("string_ids_size: ").append(Hex.m53u4(size)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append("string_ids_off:  ").append(Hex.m53u4(fileOffset)).toString());
        }
        annotatedOutput2.writeInt(size);
        annotatedOutput2.writeInt(fileOffset);
    }
}
