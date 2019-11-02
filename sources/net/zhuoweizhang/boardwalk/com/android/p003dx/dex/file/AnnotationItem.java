package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Arrays;
import java.util.Comparator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotation;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationVisibility;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.NameValuePair;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArrayAnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.AnnotationItem */
public final class AnnotationItem extends OffsettedItem {
    private static final int ALIGNMENT = 1;
    private static final TypeIdSorter TYPE_ID_SORTER;
    private static final int VISIBILITY_BUILD = 0;
    private static final int VISIBILITY_RUNTIME = 1;
    private static final int VISIBILITY_SYSTEM = 2;
    private final Annotation annotation;
    private byte[] encodedForm;
    /* access modifiers changed from: private */
    public TypeIdItem type;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.AnnotationItem$TypeIdSorter */
    private static class TypeIdSorter implements Comparator<AnnotationItem> {
        private TypeIdSorter() {
        }

        /* synthetic */ TypeIdSorter(C06631 r4) {
            C06631 r1 = r4;
            this();
        }

        public int compare(AnnotationItem annotationItem, AnnotationItem annotationItem2) {
            AnnotationItem annotationItem3 = annotationItem2;
            int index = annotationItem.type.getIndex();
            int index2 = annotationItem3.type.getIndex();
            if (index < index2) {
                return -1;
            }
            return index > index2 ? 1 : 0;
        }
    }

    static {
        TypeIdSorter typeIdSorter;
        TypeIdSorter typeIdSorter2 = typeIdSorter;
        TypeIdSorter typeIdSorter3 = new TypeIdSorter(null);
        TYPE_ID_SORTER = typeIdSorter2;
    }

    public AnnotationItem(Annotation annotation2) {
        NullPointerException nullPointerException;
        Annotation annotation3 = annotation2;
        super(1, -1);
        if (annotation3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("annotation == null");
            throw nullPointerException2;
        }
        this.annotation = annotation3;
        this.type = null;
        this.encodedForm = null;
    }

    public static void sortByTypeIdIndex(AnnotationItem[] annotationItemArr) {
        Arrays.sort(annotationItemArr, TYPE_ID_SORTER);
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        this.type = dexFile2.getTypeIds().intern(this.annotation.getType());
        ValueEncoder.addContents(dexFile2, this.annotation);
    }

    public void annotateTo(AnnotatedOutput annotatedOutput, String str) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        String str2 = str;
        AnnotatedOutput annotatedOutput3 = annotatedOutput2;
        StringBuilder sb4 = sb;
        StringBuilder sb5 = new StringBuilder();
        annotatedOutput3.annotate(0, sb4.append(str2).append("visibility: ").append(this.annotation.getVisibility().toHuman()).toString());
        AnnotatedOutput annotatedOutput4 = annotatedOutput2;
        StringBuilder sb6 = sb2;
        StringBuilder sb7 = new StringBuilder();
        annotatedOutput4.annotate(0, sb6.append(str2).append("type: ").append(this.annotation.getType().toHuman()).toString());
        for (NameValuePair nameValuePair : this.annotation.getNameValuePairs()) {
            CstString name = nameValuePair.getName();
            Constant value = nameValuePair.getValue();
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb8 = sb3;
            StringBuilder sb9 = new StringBuilder();
            annotatedOutput5.annotate(0, sb8.append(str2).append(name.toHuman()).append(": ").append(ValueEncoder.constantToHuman(value)).toString());
        }
    }

    /* access modifiers changed from: protected */
    public int compareTo0(OffsettedItem offsettedItem) {
        return this.annotation.compareTo(((AnnotationItem) offsettedItem).annotation);
    }

    public int hashCode() {
        return this.annotation.hashCode();
    }

    public ItemType itemType() {
        return ItemType.TYPE_ANNOTATION_ITEM;
    }

    /* access modifiers changed from: protected */
    public void place0(Section section, int i) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        ValueEncoder valueEncoder;
        Section section2 = section;
        int i2 = i;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput();
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput4 = byteArrayAnnotatedOutput2;
        ValueEncoder valueEncoder2 = valueEncoder;
        ValueEncoder valueEncoder3 = new ValueEncoder(section2.getFile(), byteArrayAnnotatedOutput4);
        valueEncoder2.writeAnnotation(this.annotation, false);
        this.encodedForm = byteArrayAnnotatedOutput4.toByteArray();
        setWriteSize(1 + this.encodedForm.length);
    }

    public String toHuman() {
        return this.annotation.toHuman();
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        ValueEncoder valueEncoder;
        RuntimeException runtimeException;
        StringBuilder sb;
        StringBuilder sb2;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean annotates = annotatedOutput2.annotates();
        AnnotationVisibility visibility = this.annotation.getVisibility();
        if (annotates) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(0, sb3.append(offsetString()).append(" annotation").toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(1, sb5.append("  visibility: VISBILITY_").append(visibility).toString());
        }
        switch (visibility) {
            case BUILD:
                annotatedOutput2.writeByte(0);
                break;
            case RUNTIME:
                annotatedOutput2.writeByte(1);
                break;
            case SYSTEM:
                annotatedOutput2.writeByte(2);
                break;
            default:
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
                throw runtimeException2;
        }
        if (annotates) {
            ValueEncoder valueEncoder2 = valueEncoder;
            ValueEncoder valueEncoder3 = new ValueEncoder(dexFile2, annotatedOutput2);
            valueEncoder2.writeAnnotation(this.annotation, true);
            return;
        }
        annotatedOutput2.write(this.encodedForm);
    }
}
