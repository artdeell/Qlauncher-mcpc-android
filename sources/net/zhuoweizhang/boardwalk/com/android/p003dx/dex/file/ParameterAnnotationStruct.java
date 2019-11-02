package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationsList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.ParameterAnnotationStruct */
public final class ParameterAnnotationStruct implements ToHuman, Comparable<ParameterAnnotationStruct> {
    private final UniformListItem<AnnotationSetRefItem> annotationsItem;
    private final AnnotationsList annotationsList;
    private final CstMethodRef method;

    public ParameterAnnotationStruct(CstMethodRef cstMethodRef, AnnotationsList annotationsList2) {
        ArrayList arrayList;
        UniformListItem<AnnotationSetRefItem> uniformListItem;
        AnnotationSetRefItem annotationSetRefItem;
        AnnotationSetItem annotationSetItem;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        AnnotationsList annotationsList3 = annotationsList2;
        if (cstMethodRef2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("method == null");
            throw nullPointerException3;
        } else if (annotationsList3 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("annotationsList == null");
            throw nullPointerException5;
        } else {
            this.method = cstMethodRef2;
            this.annotationsList = annotationsList3;
            int size = annotationsList3.size();
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(size);
            ArrayList arrayList4 = arrayList2;
            for (int i = 0; i < size; i++) {
                ArrayList arrayList5 = arrayList4;
                AnnotationSetRefItem annotationSetRefItem2 = annotationSetRefItem;
                AnnotationSetItem annotationSetItem2 = annotationSetItem;
                AnnotationSetItem annotationSetItem3 = new AnnotationSetItem(annotationsList3.get(i));
                AnnotationSetRefItem annotationSetRefItem3 = new AnnotationSetRefItem(annotationSetItem2);
                boolean add = arrayList5.add(annotationSetRefItem2);
            }
            UniformListItem<AnnotationSetRefItem> uniformListItem2 = uniformListItem;
            UniformListItem<AnnotationSetRefItem> uniformListItem3 = new UniformListItem<>(ItemType.TYPE_ANNOTATION_SET_REF_LIST, arrayList4);
            this.annotationsItem = uniformListItem2;
        }
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        MethodIdsSection methodIds = dexFile2.getMethodIds();
        MixedItemSection wordData = dexFile2.getWordData();
        MethodIdItem intern = methodIds.intern(this.method);
        wordData.add(this.annotationsItem);
    }

    public int compareTo(ParameterAnnotationStruct parameterAnnotationStruct) {
        return this.method.compareTo((Constant) parameterAnnotationStruct.method);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof ParameterAnnotationStruct)) {
            return false;
        }
        return this.method.equals(((ParameterAnnotationStruct) obj2).method);
    }

    public AnnotationsList getAnnotationsList() {
        return this.annotationsList;
    }

    public CstMethodRef getMethod() {
        return this.method;
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public String toHuman() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(this.method.toHuman());
        StringBuilder append2 = sb4.append(": ");
        boolean z = true;
        for (AnnotationSetRefItem annotationSetRefItem : this.annotationsItem.getItems()) {
            if (z) {
                z = false;
            } else {
                StringBuilder append3 = sb4.append(", ");
            }
            StringBuilder append4 = sb4.append(annotationSetRefItem.toHuman());
        }
        return sb4.toString();
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int indexOf = dexFile.getMethodIds().indexOf(this.method);
        int absoluteOffset = this.annotationsItem.getAbsoluteOffset();
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb4 = sb;
            StringBuilder sb5 = new StringBuilder();
            annotatedOutput3.annotate(0, sb4.append("    ").append(this.method.toHuman()).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            annotatedOutput4.annotate(4, sb6.append("      method_idx:      ").append(Hex.m53u4(indexOf)).toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb8 = sb3;
            StringBuilder sb9 = new StringBuilder();
            annotatedOutput5.annotate(4, sb8.append("      annotations_off: ").append(Hex.m53u4(absoluteOffset)).toString());
        }
        annotatedOutput2.writeInt(indexOf);
        annotatedOutput2.writeInt(absoluteOffset);
    }
}
