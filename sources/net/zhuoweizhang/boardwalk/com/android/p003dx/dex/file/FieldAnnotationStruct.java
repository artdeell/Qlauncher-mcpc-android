package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.FieldAnnotationStruct */
public final class FieldAnnotationStruct implements ToHuman, Comparable<FieldAnnotationStruct> {
    private AnnotationSetItem annotations;
    private final CstFieldRef field;

    public FieldAnnotationStruct(CstFieldRef cstFieldRef, AnnotationSetItem annotationSetItem) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CstFieldRef cstFieldRef2 = cstFieldRef;
        AnnotationSetItem annotationSetItem2 = annotationSetItem;
        if (cstFieldRef2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("field == null");
            throw nullPointerException3;
        } else if (annotationSetItem2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("annotations == null");
            throw nullPointerException5;
        } else {
            this.field = cstFieldRef2;
            this.annotations = annotationSetItem2;
        }
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        FieldIdsSection fieldIds = dexFile2.getFieldIds();
        MixedItemSection wordData = dexFile2.getWordData();
        FieldIdItem intern = fieldIds.intern(this.field);
        this.annotations = (AnnotationSetItem) wordData.intern(this.annotations);
    }

    public int compareTo(FieldAnnotationStruct fieldAnnotationStruct) {
        return this.field.compareTo((Constant) fieldAnnotationStruct.field);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof FieldAnnotationStruct)) {
            return false;
        }
        return this.field.equals(((FieldAnnotationStruct) obj2).field);
    }

    public Annotations getAnnotations() {
        return this.annotations.getAnnotations();
    }

    public CstFieldRef getField() {
        return this.field;
    }

    public int hashCode() {
        return this.field.hashCode();
    }

    public String toHuman() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(this.field.toHuman()).append(": ").append(this.annotations).toString();
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int indexOf = dexFile.getFieldIds().indexOf(this.field);
        int absoluteOffset = this.annotations.getAbsoluteOffset();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb4 = sb;
            StringBuilder sb5 = new StringBuilder();
            annotatedOutput3.annotate(0, sb4.append("    ").append(this.field.toHuman()).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            annotatedOutput4.annotate(4, sb6.append("      field_idx:       ").append(Hex.m53u4(indexOf)).toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb8 = sb3;
            StringBuilder sb9 = new StringBuilder();
            annotatedOutput5.annotate(4, sb8.append("      annotations_off: ").append(Hex.m53u4(absoluteOffset)).toString());
        }
        annotatedOutput2.writeInt(indexOf);
        annotatedOutput2.writeInt(absoluteOffset);
    }
}
