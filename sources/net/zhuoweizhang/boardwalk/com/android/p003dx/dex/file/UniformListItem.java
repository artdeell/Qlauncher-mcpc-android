package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.OffsettedItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.UniformListItem */
public final class UniformListItem<T extends OffsettedItem> extends OffsettedItem {
    private static final int HEADER_SIZE = 4;
    private final ItemType itemType;
    private final List<T> items;

    public UniformListItem(ItemType itemType2, List<T> list) {
        NullPointerException nullPointerException;
        ItemType itemType3 = itemType2;
        List<T> list2 = list;
        super(getAlignment(list2), writeSize(list2));
        if (itemType3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("itemType == null");
            throw nullPointerException2;
        }
        this.items = list2;
        this.itemType = itemType3;
    }

    private static int getAlignment(List<? extends OffsettedItem> list) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        try {
            return Math.max(4, ((OffsettedItem) list.get(0)).getAlignment());
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("items.size() == 0");
            throw illegalArgumentException2;
        } catch (NullPointerException e2) {
            NullPointerException nullPointerException2 = e2;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("items == null");
            throw nullPointerException3;
        }
    }

    private int headerSize() {
        return getAlignment();
    }

    private static int writeSize(List<? extends OffsettedItem> list) {
        List<? extends OffsettedItem> list2 = list;
        return (list2.size() * ((OffsettedItem) list2.get(0)).writeSize()) + getAlignment(list2);
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        for (T addContents : this.items) {
            addContents.addContents(dexFile2);
        }
    }

    public final List<T> getItems() {
        return this.items;
    }

    public ItemType itemType() {
        return this.itemType;
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2;
        Section section2 = section;
        int headerSize = i + headerSize();
        boolean z = true;
        int i2 = headerSize;
        int i3 = -1;
        int i4 = -1;
        for (T t : this.items) {
            int writeSize = t.writeSize();
            if (z) {
                i3 = t.getAlignment();
                z = false;
                i4 = writeSize;
            } else if (writeSize != i4) {
                UnsupportedOperationException unsupportedOperationException3 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException4 = new UnsupportedOperationException("item size mismatch");
                throw unsupportedOperationException3;
            } else if (t.getAlignment() != i3) {
                UnsupportedOperationException unsupportedOperationException5 = unsupportedOperationException2;
                UnsupportedOperationException unsupportedOperationException6 = new UnsupportedOperationException("item alignment mismatch");
                throw unsupportedOperationException5;
            }
            i2 = writeSize + t.place(section2, i2);
        }
    }

    public final String toHuman() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append("{");
        boolean z = true;
        for (T t : this.items) {
            if (z) {
                z = false;
            } else {
                StringBuffer append2 = stringBuffer4.append(", ");
            }
            StringBuffer append3 = stringBuffer4.append(t.toHuman());
        }
        StringBuffer append4 = stringBuffer4.append("}");
        return stringBuffer4.toString();
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(getClass().getName());
        StringBuffer append2 = stringBuffer4.append(this.items);
        return stringBuffer4.toString();
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int size = this.items.size();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(0, sb3.append(offsetString()).append(" ").append(typeName()).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append("  size: ").append(Hex.m53u4(size)).toString());
        }
        annotatedOutput2.writeInt(size);
        for (T writeTo : this.items) {
            writeTo.writeTo(dexFile2, annotatedOutput2);
        }
    }
}
