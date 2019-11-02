package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.OffsettedItem */
public abstract class OffsettedItem extends Item implements Comparable<OffsettedItem> {
    private Section addedTo;
    private final int alignment;
    private int offset;
    private int writeSize;

    public OffsettedItem(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        Section.validateAlignment(i3);
        if (i4 < -1) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("writeSize < -1");
            throw illegalArgumentException2;
        }
        this.alignment = i3;
        this.writeSize = i4;
        this.addedTo = null;
        this.offset = -1;
    }

    public static int getAbsoluteOffsetOr0(OffsettedItem offsettedItem) {
        OffsettedItem offsettedItem2 = offsettedItem;
        if (offsettedItem2 == null) {
            return 0;
        }
        return offsettedItem2.getAbsoluteOffset();
    }

    public final int compareTo(OffsettedItem offsettedItem) {
        OffsettedItem offsettedItem2 = offsettedItem;
        if (this == offsettedItem2) {
            return 0;
        }
        ItemType itemType = itemType();
        ItemType itemType2 = offsettedItem2.itemType();
        return itemType != itemType2 ? itemType.compareTo(itemType2) : compareTo0(offsettedItem2);
    }

    /* access modifiers changed from: protected */
    public int compareTo0(OffsettedItem offsettedItem) {
        UnsupportedOperationException unsupportedOperationException;
        OffsettedItem offsettedItem2 = offsettedItem;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("unsupported");
        throw unsupportedOperationException2;
    }

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            OffsettedItem offsettedItem = (OffsettedItem) obj2;
            if (itemType() != offsettedItem.itemType()) {
                return false;
            }
            if (compareTo0(offsettedItem) != 0) {
                return false;
            }
        }
        return true;
    }

    public final int getAbsoluteOffset() {
        RuntimeException runtimeException;
        if (this.offset >= 0) {
            return this.addedTo.getAbsoluteOffset(this.offset);
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("offset not yet known");
        throw runtimeException2;
    }

    public final int getAlignment() {
        return this.alignment;
    }

    public final int getRelativeOffset() {
        RuntimeException runtimeException;
        if (this.offset >= 0) {
            return this.offset;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("offset not yet known");
        throw runtimeException2;
    }

    public final String offsetString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append('[').append(Integer.toHexString(getAbsoluteOffset())).append(']').toString();
    }

    public final int place(Section section, int i) {
        RuntimeException runtimeException;
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        Section section2 = section;
        int i2 = i;
        if (section2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("addedTo == null");
            throw nullPointerException2;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("offset < 0");
            throw illegalArgumentException2;
        } else if (this.addedTo != null) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("already written");
            throw runtimeException2;
        } else {
            int i3 = -1 + this.alignment;
            int i4 = (i2 + i3) & (i3 ^ -1);
            this.addedTo = section2;
            this.offset = i4;
            place0(section2, i4);
            return i4;
        }
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
    }

    public final void setWriteSize(int i) {
        UnsupportedOperationException unsupportedOperationException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("writeSize < 0");
            throw illegalArgumentException2;
        } else if (this.writeSize >= 0) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("writeSize already set");
            throw unsupportedOperationException2;
        } else {
            this.writeSize = i2;
        }
    }

    public abstract String toHuman();

    public final int writeSize() {
        UnsupportedOperationException unsupportedOperationException;
        if (this.writeSize >= 0) {
            return this.writeSize;
        }
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("writeSize is unknown");
        throw unsupportedOperationException2;
    }

    public final void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        UnsupportedOperationException unsupportedOperationException;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        annotatedOutput2.alignTo(this.alignment);
        try {
            if (this.writeSize < 0) {
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("writeSize is unknown");
                throw unsupportedOperationException2;
            }
            annotatedOutput2.assertCursor(getAbsoluteOffset());
            writeTo0(dexFile2, annotatedOutput2);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            throw ExceptionWithContext.withContext(runtimeException, sb2.append("...while writing ").append(this).toString());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput);
}
