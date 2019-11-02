package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationsList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.AnnotationsDirectoryItem */
public final class AnnotationsDirectoryItem extends OffsettedItem {
    private static final int ALIGNMENT = 4;
    private static final int ELEMENT_SIZE = 8;
    private static final int HEADER_SIZE = 16;
    private AnnotationSetItem classAnnotations = null;
    private ArrayList<FieldAnnotationStruct> fieldAnnotations = null;
    private ArrayList<MethodAnnotationStruct> methodAnnotations = null;
    private ArrayList<ParameterAnnotationStruct> parameterAnnotations = null;

    public AnnotationsDirectoryItem() {
        super(4, -1);
    }

    private static int listSize(ArrayList<?> arrayList) {
        ArrayList<?> arrayList2 = arrayList;
        if (arrayList2 == null) {
            return 0;
        }
        return arrayList2.size();
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        MixedItemSection wordData = dexFile2.getWordData();
        if (this.classAnnotations != null) {
            this.classAnnotations = (AnnotationSetItem) wordData.intern(this.classAnnotations);
        }
        if (this.fieldAnnotations != null) {
            Iterator it = this.fieldAnnotations.iterator();
            while (it.hasNext()) {
                ((FieldAnnotationStruct) it.next()).addContents(dexFile2);
            }
        }
        if (this.methodAnnotations != null) {
            Iterator it2 = this.methodAnnotations.iterator();
            while (it2.hasNext()) {
                ((MethodAnnotationStruct) it2.next()).addContents(dexFile2);
            }
        }
        if (this.parameterAnnotations != null) {
            Iterator it3 = this.parameterAnnotations.iterator();
            while (it3.hasNext()) {
                ((ParameterAnnotationStruct) it3.next()).addContents(dexFile2);
            }
        }
    }

    public void addFieldAnnotations(CstFieldRef cstFieldRef, Annotations annotations) {
        FieldAnnotationStruct fieldAnnotationStruct;
        AnnotationSetItem annotationSetItem;
        ArrayList<FieldAnnotationStruct> arrayList;
        CstFieldRef cstFieldRef2 = cstFieldRef;
        Annotations annotations2 = annotations;
        if (this.fieldAnnotations == null) {
            ArrayList<FieldAnnotationStruct> arrayList2 = arrayList;
            ArrayList<FieldAnnotationStruct> arrayList3 = new ArrayList<>();
            this.fieldAnnotations = arrayList2;
        }
        ArrayList<FieldAnnotationStruct> arrayList4 = this.fieldAnnotations;
        FieldAnnotationStruct fieldAnnotationStruct2 = fieldAnnotationStruct;
        CstFieldRef cstFieldRef3 = cstFieldRef2;
        AnnotationSetItem annotationSetItem2 = annotationSetItem;
        AnnotationSetItem annotationSetItem3 = new AnnotationSetItem(annotations2);
        FieldAnnotationStruct fieldAnnotationStruct3 = new FieldAnnotationStruct(cstFieldRef3, annotationSetItem2);
        boolean add = arrayList4.add(fieldAnnotationStruct2);
    }

    public void addMethodAnnotations(CstMethodRef cstMethodRef, Annotations annotations) {
        MethodAnnotationStruct methodAnnotationStruct;
        AnnotationSetItem annotationSetItem;
        ArrayList<MethodAnnotationStruct> arrayList;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        Annotations annotations2 = annotations;
        if (this.methodAnnotations == null) {
            ArrayList<MethodAnnotationStruct> arrayList2 = arrayList;
            ArrayList<MethodAnnotationStruct> arrayList3 = new ArrayList<>();
            this.methodAnnotations = arrayList2;
        }
        ArrayList<MethodAnnotationStruct> arrayList4 = this.methodAnnotations;
        MethodAnnotationStruct methodAnnotationStruct2 = methodAnnotationStruct;
        CstMethodRef cstMethodRef3 = cstMethodRef2;
        AnnotationSetItem annotationSetItem2 = annotationSetItem;
        AnnotationSetItem annotationSetItem3 = new AnnotationSetItem(annotations2);
        MethodAnnotationStruct methodAnnotationStruct3 = new MethodAnnotationStruct(cstMethodRef3, annotationSetItem2);
        boolean add = arrayList4.add(methodAnnotationStruct2);
    }

    public void addParameterAnnotations(CstMethodRef cstMethodRef, AnnotationsList annotationsList) {
        ParameterAnnotationStruct parameterAnnotationStruct;
        ArrayList<ParameterAnnotationStruct> arrayList;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        AnnotationsList annotationsList2 = annotationsList;
        if (this.parameterAnnotations == null) {
            ArrayList<ParameterAnnotationStruct> arrayList2 = arrayList;
            ArrayList<ParameterAnnotationStruct> arrayList3 = new ArrayList<>();
            this.parameterAnnotations = arrayList2;
        }
        ArrayList<ParameterAnnotationStruct> arrayList4 = this.parameterAnnotations;
        ParameterAnnotationStruct parameterAnnotationStruct2 = parameterAnnotationStruct;
        ParameterAnnotationStruct parameterAnnotationStruct3 = new ParameterAnnotationStruct(cstMethodRef2, annotationsList2);
        boolean add = arrayList4.add(parameterAnnotationStruct2);
    }

    public int compareTo0(OffsettedItem offsettedItem) {
        UnsupportedOperationException unsupportedOperationException;
        OffsettedItem offsettedItem2 = offsettedItem;
        if (!isInternable()) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("uninternable instance");
            throw unsupportedOperationException2;
        }
        return this.classAnnotations.compareTo((OffsettedItem) ((AnnotationsDirectoryItem) offsettedItem2).classAnnotations);
    }

    /* access modifiers changed from: 0000 */
    public void debugPrint(PrintWriter printWriter) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        PrintWriter printWriter2 = printWriter;
        if (this.classAnnotations != null) {
            PrintWriter printWriter3 = printWriter2;
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            printWriter3.println(sb5.append("  class annotations: ").append(this.classAnnotations).toString());
        }
        if (this.fieldAnnotations != null) {
            printWriter2.println("  field annotations:");
            Iterator it = this.fieldAnnotations.iterator();
            while (it.hasNext()) {
                FieldAnnotationStruct fieldAnnotationStruct = (FieldAnnotationStruct) it.next();
                PrintWriter printWriter4 = printWriter2;
                StringBuilder sb7 = sb3;
                StringBuilder sb8 = new StringBuilder();
                printWriter4.println(sb7.append("    ").append(fieldAnnotationStruct.toHuman()).toString());
            }
        }
        if (this.methodAnnotations != null) {
            printWriter2.println("  method annotations:");
            Iterator it2 = this.methodAnnotations.iterator();
            while (it2.hasNext()) {
                MethodAnnotationStruct methodAnnotationStruct = (MethodAnnotationStruct) it2.next();
                PrintWriter printWriter5 = printWriter2;
                StringBuilder sb9 = sb2;
                StringBuilder sb10 = new StringBuilder();
                printWriter5.println(sb9.append("    ").append(methodAnnotationStruct.toHuman()).toString());
            }
        }
        if (this.parameterAnnotations != null) {
            printWriter2.println("  parameter annotations:");
            Iterator it3 = this.parameterAnnotations.iterator();
            while (it3.hasNext()) {
                ParameterAnnotationStruct parameterAnnotationStruct = (ParameterAnnotationStruct) it3.next();
                PrintWriter printWriter6 = printWriter2;
                StringBuilder sb11 = sb;
                StringBuilder sb12 = new StringBuilder();
                printWriter6.println(sb11.append("    ").append(parameterAnnotationStruct.toHuman()).toString());
            }
        }
    }

    public Annotations getMethodAnnotations(CstMethodRef cstMethodRef) {
        CstMethodRef cstMethodRef2 = cstMethodRef;
        if (this.methodAnnotations == null) {
            return null;
        }
        Iterator it = this.methodAnnotations.iterator();
        while (it.hasNext()) {
            MethodAnnotationStruct methodAnnotationStruct = (MethodAnnotationStruct) it.next();
            if (methodAnnotationStruct.getMethod().equals(cstMethodRef2)) {
                return methodAnnotationStruct.getAnnotations();
            }
        }
        return null;
    }

    public AnnotationsList getParameterAnnotations(CstMethodRef cstMethodRef) {
        CstMethodRef cstMethodRef2 = cstMethodRef;
        if (this.parameterAnnotations == null) {
            return null;
        }
        Iterator it = this.parameterAnnotations.iterator();
        while (it.hasNext()) {
            ParameterAnnotationStruct parameterAnnotationStruct = (ParameterAnnotationStruct) it.next();
            if (parameterAnnotationStruct.getMethod().equals(cstMethodRef2)) {
                return parameterAnnotationStruct.getAnnotationsList();
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.classAnnotations == null) {
            return 0;
        }
        return this.classAnnotations.hashCode();
    }

    public boolean isEmpty() {
        return this.classAnnotations == null && this.fieldAnnotations == null && this.methodAnnotations == null && this.parameterAnnotations == null;
    }

    public boolean isInternable() {
        return this.classAnnotations != null && this.fieldAnnotations == null && this.methodAnnotations == null && this.parameterAnnotations == null;
    }

    public ItemType itemType() {
        return ItemType.TYPE_ANNOTATIONS_DIRECTORY_ITEM;
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
        Section section2 = section;
        int i2 = i;
        setWriteSize(16 + (8 * (listSize(this.fieldAnnotations) + listSize(this.methodAnnotations) + listSize(this.parameterAnnotations))));
    }

    public void setClassAnnotations(Annotations annotations) {
        AnnotationSetItem annotationSetItem;
        UnsupportedOperationException unsupportedOperationException;
        NullPointerException nullPointerException;
        Annotations annotations2 = annotations;
        if (annotations2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("annotations == null");
            throw nullPointerException2;
        } else if (this.classAnnotations != null) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("class annotations already set");
            throw unsupportedOperationException2;
        } else {
            AnnotationSetItem annotationSetItem2 = annotationSetItem;
            AnnotationSetItem annotationSetItem3 = new AnnotationSetItem(annotations2);
            this.classAnnotations = annotationSetItem2;
        }
    }

    public String toHuman() {
        RuntimeException runtimeException;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("unsupported");
        throw runtimeException2;
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean annotates = annotatedOutput2.annotates();
        int absoluteOffsetOr0 = OffsettedItem.getAbsoluteOffsetOr0(this.classAnnotations);
        int listSize = listSize(this.fieldAnnotations);
        int listSize2 = listSize(this.methodAnnotations);
        int listSize3 = listSize(this.parameterAnnotations);
        if (annotates) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            annotatedOutput3.annotate(0, sb6.append(offsetString()).append(" annotations directory").toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            annotatedOutput4.annotate(4, sb8.append("  class_annotations_off: ").append(Hex.m53u4(absoluteOffsetOr0)).toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb10 = sb3;
            StringBuilder sb11 = new StringBuilder();
            annotatedOutput5.annotate(4, sb10.append("  fields_size:           ").append(Hex.m53u4(listSize)).toString());
            AnnotatedOutput annotatedOutput6 = annotatedOutput2;
            StringBuilder sb12 = sb4;
            StringBuilder sb13 = new StringBuilder();
            annotatedOutput6.annotate(4, sb12.append("  methods_size:          ").append(Hex.m53u4(listSize2)).toString());
            AnnotatedOutput annotatedOutput7 = annotatedOutput2;
            StringBuilder sb14 = sb5;
            StringBuilder sb15 = new StringBuilder();
            annotatedOutput7.annotate(4, sb14.append("  parameters_size:       ").append(Hex.m53u4(listSize3)).toString());
        }
        annotatedOutput2.writeInt(absoluteOffsetOr0);
        annotatedOutput2.writeInt(listSize);
        annotatedOutput2.writeInt(listSize2);
        annotatedOutput2.writeInt(listSize3);
        if (listSize != 0) {
            Collections.sort(this.fieldAnnotations);
            if (annotates) {
                annotatedOutput2.annotate(0, "  fields:");
            }
            Iterator it = this.fieldAnnotations.iterator();
            while (it.hasNext()) {
                ((FieldAnnotationStruct) it.next()).writeTo(dexFile2, annotatedOutput2);
            }
        }
        if (listSize2 != 0) {
            Collections.sort(this.methodAnnotations);
            if (annotates) {
                annotatedOutput2.annotate(0, "  methods:");
            }
            Iterator it2 = this.methodAnnotations.iterator();
            while (it2.hasNext()) {
                ((MethodAnnotationStruct) it2.next()).writeTo(dexFile2, annotatedOutput2);
            }
        }
        if (listSize3 != 0) {
            Collections.sort(this.parameterAnnotations);
            if (annotates) {
                annotatedOutput2.annotate(0, "  parameters:");
            }
            Iterator it3 = this.parameterAnnotations.iterator();
            while (it3.hasNext()) {
                ((ParameterAnnotationStruct) it3.next()).writeTo(dexFile2, annotatedOutput2);
            }
        }
    }
}
