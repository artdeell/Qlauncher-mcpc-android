package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.MethodAnnotationStruct */
public final class MethodAnnotationStruct implements ToHuman, Comparable<MethodAnnotationStruct> {
    private AnnotationSetItem annotations;
    private final CstMethodRef method;

    public MethodAnnotationStruct(CstMethodRef cstMethodRef, AnnotationSetItem annotationSetItem) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        AnnotationSetItem annotationSetItem2 = annotationSetItem;
        if (cstMethodRef2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("method == null");
            throw nullPointerException3;
        } else if (annotationSetItem2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("annotations == null");
            throw nullPointerException5;
        } else {
            this.method = cstMethodRef2;
            this.annotations = annotationSetItem2;
        }
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        MethodIdsSection methodIds = dexFile2.getMethodIds();
        MixedItemSection wordData = dexFile2.getWordData();
        MethodIdItem intern = methodIds.intern(this.method);
        this.annotations = (AnnotationSetItem) wordData.intern(this.annotations);
    }

    public int compareTo(MethodAnnotationStruct methodAnnotationStruct) {
        return this.method.compareTo((Constant) methodAnnotationStruct.method);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof MethodAnnotationStruct)) {
            return false;
        }
        return this.method.equals(((MethodAnnotationStruct) obj2).method);
    }

    public Annotations getAnnotations() {
        return this.annotations.getAnnotations();
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
        return sb2.append(this.method.toHuman()).append(": ").append(this.annotations).toString();
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int indexOf = dexFile.getMethodIds().indexOf(this.method);
        int absoluteOffset = this.annotations.getAbsoluteOffset();
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
