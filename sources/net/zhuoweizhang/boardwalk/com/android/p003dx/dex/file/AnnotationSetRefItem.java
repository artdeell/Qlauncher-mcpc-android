package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.AnnotationSetRefItem */
public final class AnnotationSetRefItem extends OffsettedItem {
    private static final int ALIGNMENT = 4;
    private static final int WRITE_SIZE = 4;
    private AnnotationSetItem annotations;

    public AnnotationSetRefItem(AnnotationSetItem annotationSetItem) {
        NullPointerException nullPointerException;
        AnnotationSetItem annotationSetItem2 = annotationSetItem;
        super(4, 4);
        if (annotationSetItem2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("annotations == null");
            throw nullPointerException2;
        }
        this.annotations = annotationSetItem2;
    }

    public void addContents(DexFile dexFile) {
        this.annotations = (AnnotationSetItem) dexFile.getWordData().intern(this.annotations);
    }

    public ItemType itemType() {
        return ItemType.TYPE_ANNOTATION_SET_REF_ITEM;
    }

    public String toHuman() {
        return this.annotations.toHuman();
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int absoluteOffset = this.annotations.getAbsoluteOffset();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            annotatedOutput3.annotate(4, sb2.append("  annotations_off: ").append(Hex.m53u4(absoluteOffset)).toString());
        }
        annotatedOutput2.writeInt(absoluteOffset);
    }
}
