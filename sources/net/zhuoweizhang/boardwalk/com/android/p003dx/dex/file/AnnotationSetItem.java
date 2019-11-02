package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.AnnotationSetItem */
public final class AnnotationSetItem extends OffsettedItem {
    private static final int ALIGNMENT = 4;
    private static final int ENTRY_WRITE_SIZE = 4;
    private final Annotations annotations;
    private final AnnotationItem[] items;

    public AnnotationSetItem(Annotations annotations2) {
        AnnotationItem annotationItem;
        Annotations annotations3 = annotations2;
        super(4, writeSize(annotations3));
        this.annotations = annotations3;
        this.items = new AnnotationItem[annotations3.size()];
        int i = 0;
        for (Annotation annotation : annotations3.getAnnotations()) {
            AnnotationItem[] annotationItemArr = this.items;
            int i2 = i;
            AnnotationItem annotationItem2 = annotationItem;
            AnnotationItem annotationItem3 = new AnnotationItem(annotation);
            annotationItemArr[i2] = annotationItem2;
            i++;
        }
    }

    private static int writeSize(Annotations annotations2) {
        NullPointerException nullPointerException;
        try {
            return 4 + (annotations2.size() * 4);
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("list == null");
            throw nullPointerException3;
        }
    }

    public void addContents(DexFile dexFile) {
        MixedItemSection byteData = dexFile.getByteData();
        int length = this.items.length;
        for (int i = 0; i < length; i++) {
            this.items[i] = (AnnotationItem) byteData.intern(this.items[i]);
        }
    }

    /* access modifiers changed from: protected */
    public int compareTo0(OffsettedItem offsettedItem) {
        return this.annotations.compareTo(((AnnotationSetItem) offsettedItem).annotations);
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public int hashCode() {
        return this.annotations.hashCode();
    }

    public ItemType itemType() {
        return ItemType.TYPE_ANNOTATION_SET_ITEM;
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
        Section section2 = section;
        int i2 = i;
        AnnotationItem.sortByTypeIdIndex(this.items);
    }

    public String toHuman() {
        return this.annotations.toString();
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean annotates = annotatedOutput2.annotates();
        int length = this.items.length;
        if (annotates) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb4 = sb2;
            StringBuilder sb5 = new StringBuilder();
            annotatedOutput3.annotate(0, sb4.append(offsetString()).append(" annotation set").toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb6 = sb3;
            StringBuilder sb7 = new StringBuilder();
            annotatedOutput4.annotate(4, sb6.append("  size: ").append(Hex.m53u4(length)).toString());
        }
        annotatedOutput2.writeInt(length);
        for (int i = 0; i < length; i++) {
            int absoluteOffset = this.items[i].getAbsoluteOffset();
            if (annotates) {
                AnnotatedOutput annotatedOutput5 = annotatedOutput2;
                StringBuilder sb8 = sb;
                StringBuilder sb9 = new StringBuilder();
                annotatedOutput5.annotate(4, sb8.append("  entries[").append(Integer.toHexString(i)).append("]: ").append(Hex.m53u4(absoluteOffset)).toString());
                this.items[i].annotateTo(annotatedOutput2, "    ");
            }
            annotatedOutput2.writeInt(absoluteOffset);
        }
    }
}
