package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.Annotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation.AnnotationsList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Writers;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.ClassDefItem */
public final class ClassDefItem extends IndexedItem {
    private final int accessFlags;
    private AnnotationsDirectoryItem annotationsDirectory;
    private final ClassDataItem classData;
    private TypeListItem interfaces;
    private final CstString sourceFile;
    private EncodedArrayItem staticValuesItem;
    private final CstType superclass;
    private final CstType thisClass;

    public ClassDefItem(CstType cstType, int i, CstType cstType2, TypeList typeList, CstString cstString) {
        TypeListItem typeListItem;
        TypeListItem typeListItem2;
        ClassDataItem classDataItem;
        AnnotationsDirectoryItem annotationsDirectoryItem;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CstType cstType3 = cstType;
        int i2 = i;
        CstType cstType4 = cstType2;
        TypeList typeList2 = typeList;
        CstString cstString2 = cstString;
        if (cstType3 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("thisClass == null");
            throw nullPointerException3;
        } else if (typeList2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("interfaces == null");
            throw nullPointerException5;
        } else {
            this.thisClass = cstType3;
            this.accessFlags = i2;
            this.superclass = cstType4;
            if (typeList2.size() == 0) {
                typeListItem2 = null;
            } else {
                TypeListItem typeListItem3 = typeListItem;
                TypeListItem typeListItem4 = new TypeListItem(typeList2);
                typeListItem2 = typeListItem3;
            }
            this.interfaces = typeListItem2;
            this.sourceFile = cstString2;
            ClassDataItem classDataItem2 = classDataItem;
            ClassDataItem classDataItem3 = new ClassDataItem(cstType3);
            this.classData = classDataItem2;
            this.staticValuesItem = null;
            AnnotationsDirectoryItem annotationsDirectoryItem2 = annotationsDirectoryItem;
            AnnotationsDirectoryItem annotationsDirectoryItem3 = new AnnotationsDirectoryItem();
            this.annotationsDirectory = annotationsDirectoryItem2;
        }
    }

    public void addContents(DexFile dexFile) {
        EncodedArrayItem encodedArrayItem;
        DexFile dexFile2 = dexFile;
        TypeIdsSection typeIds = dexFile2.getTypeIds();
        MixedItemSection byteData = dexFile2.getByteData();
        MixedItemSection wordData = dexFile2.getWordData();
        MixedItemSection typeLists = dexFile2.getTypeLists();
        StringIdsSection stringIds = dexFile2.getStringIds();
        TypeIdItem intern = typeIds.intern(this.thisClass);
        if (!this.classData.isEmpty()) {
            dexFile2.getClassData().add(this.classData);
            CstArray staticValuesConstant = this.classData.getStaticValuesConstant();
            if (staticValuesConstant != null) {
                MixedItemSection mixedItemSection = byteData;
                EncodedArrayItem encodedArrayItem2 = encodedArrayItem;
                EncodedArrayItem encodedArrayItem3 = new EncodedArrayItem(staticValuesConstant);
                this.staticValuesItem = (EncodedArrayItem) mixedItemSection.intern(encodedArrayItem2);
            }
        }
        if (this.superclass != null) {
            TypeIdItem intern2 = typeIds.intern(this.superclass);
        }
        if (this.interfaces != null) {
            this.interfaces = (TypeListItem) typeLists.intern(this.interfaces);
        }
        if (this.sourceFile != null) {
            StringIdItem intern3 = stringIds.intern(this.sourceFile);
        }
        if (this.annotationsDirectory.isEmpty()) {
            return;
        }
        if (this.annotationsDirectory.isInternable()) {
            this.annotationsDirectory = (AnnotationsDirectoryItem) wordData.intern(this.annotationsDirectory);
            return;
        }
        wordData.add(this.annotationsDirectory);
    }

    public void addDirectMethod(EncodedMethod encodedMethod) {
        EncodedMethod encodedMethod2 = encodedMethod;
        this.classData.addDirectMethod(encodedMethod2);
    }

    public void addFieldAnnotations(CstFieldRef cstFieldRef, Annotations annotations) {
        CstFieldRef cstFieldRef2 = cstFieldRef;
        Annotations annotations2 = annotations;
        this.annotationsDirectory.addFieldAnnotations(cstFieldRef2, annotations2);
    }

    public void addInstanceField(EncodedField encodedField) {
        EncodedField encodedField2 = encodedField;
        this.classData.addInstanceField(encodedField2);
    }

    public void addMethodAnnotations(CstMethodRef cstMethodRef, Annotations annotations) {
        CstMethodRef cstMethodRef2 = cstMethodRef;
        Annotations annotations2 = annotations;
        this.annotationsDirectory.addMethodAnnotations(cstMethodRef2, annotations2);
    }

    public void addParameterAnnotations(CstMethodRef cstMethodRef, AnnotationsList annotationsList) {
        CstMethodRef cstMethodRef2 = cstMethodRef;
        AnnotationsList annotationsList2 = annotationsList;
        this.annotationsDirectory.addParameterAnnotations(cstMethodRef2, annotationsList2);
    }

    public void addStaticField(EncodedField encodedField, Constant constant) {
        EncodedField encodedField2 = encodedField;
        Constant constant2 = constant;
        this.classData.addStaticField(encodedField2, constant2);
    }

    public void addVirtualMethod(EncodedMethod encodedMethod) {
        EncodedMethod encodedMethod2 = encodedMethod;
        this.classData.addVirtualMethod(encodedMethod2);
    }

    public void debugPrint(Writer writer, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        Writer writer2 = writer;
        boolean z2 = z;
        PrintWriter printWriterFor = Writers.printWriterFor(writer2);
        PrintWriter printWriter = printWriterFor;
        StringBuilder sb6 = sb;
        StringBuilder sb7 = new StringBuilder();
        printWriter.println(sb6.append(getClass().getName()).append(" {").toString());
        PrintWriter printWriter2 = printWriterFor;
        StringBuilder sb8 = sb2;
        StringBuilder sb9 = new StringBuilder();
        printWriter2.println(sb8.append("  accessFlags: ").append(Hex.m51u2(this.accessFlags)).toString());
        PrintWriter printWriter3 = printWriterFor;
        StringBuilder sb10 = sb3;
        StringBuilder sb11 = new StringBuilder();
        printWriter3.println(sb10.append("  superclass: ").append(this.superclass).toString());
        StringBuilder sb12 = sb4;
        StringBuilder sb13 = new StringBuilder();
        printWriterFor.println(sb12.append("  interfaces: ").append(this.interfaces == null ? "<none>" : this.interfaces).toString());
        StringBuilder sb14 = sb5;
        StringBuilder sb15 = new StringBuilder();
        printWriterFor.println(sb14.append("  sourceFile: ").append(this.sourceFile == null ? "<none>" : this.sourceFile.toQuoted()).toString());
        this.classData.debugPrint(writer2, z2);
        this.annotationsDirectory.debugPrint(printWriterFor);
        printWriterFor.println("}");
    }

    public int getAccessFlags() {
        return this.accessFlags;
    }

    public TypeList getInterfaces() {
        return this.interfaces == null ? StdTypeList.EMPTY : this.interfaces.getList();
    }

    public Annotations getMethodAnnotations(CstMethodRef cstMethodRef) {
        return this.annotationsDirectory.getMethodAnnotations(cstMethodRef);
    }

    public ArrayList<EncodedMethod> getMethods() {
        return this.classData.getMethods();
    }

    public AnnotationsList getParameterAnnotations(CstMethodRef cstMethodRef) {
        return this.annotationsDirectory.getParameterAnnotations(cstMethodRef);
    }

    public CstString getSourceFile() {
        return this.sourceFile;
    }

    public CstType getSuperclass() {
        return this.superclass;
    }

    public CstType getThisClass() {
        return this.thisClass;
    }

    public ItemType itemType() {
        return ItemType.TYPE_CLASS_DEF_ITEM;
    }

    public void setClassAnnotations(Annotations annotations) {
        Annotations annotations2 = annotations;
        this.annotationsDirectory.setClassAnnotations(annotations2);
    }

    public int writeSize() {
        return 32;
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        int indexOf;
        int absoluteOffset;
        int indexOf2;
        int absoluteOffset2;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String human;
        StringBuilder sb5;
        StringBuilder sb6;
        String human2;
        StringBuilder sb7;
        StringBuilder sb8;
        StringBuilder sb9;
        StringBuilder sb10;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean annotates = annotatedOutput2.annotates();
        TypeIdsSection typeIds = dexFile2.getTypeIds();
        int indexOf3 = typeIds.indexOf(this.thisClass);
        if (this.superclass == null) {
            indexOf = -1;
        } else {
            indexOf = typeIds.indexOf(this.superclass);
        }
        int absoluteOffsetOr0 = OffsettedItem.getAbsoluteOffsetOr0(this.interfaces);
        if (this.annotationsDirectory.isEmpty()) {
            absoluteOffset = 0;
        } else {
            absoluteOffset = this.annotationsDirectory.getAbsoluteOffset();
        }
        if (this.sourceFile == null) {
            indexOf2 = -1;
        } else {
            indexOf2 = dexFile2.getStringIds().indexOf(this.sourceFile);
        }
        if (this.classData.isEmpty()) {
            absoluteOffset2 = 0;
        } else {
            absoluteOffset2 = this.classData.getAbsoluteOffset();
        }
        int absoluteOffsetOr02 = OffsettedItem.getAbsoluteOffsetOr0(this.staticValuesItem);
        if (annotates) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb11 = sb;
            StringBuilder sb12 = new StringBuilder();
            annotatedOutput3.annotate(0, sb11.append(indexString()).append(' ').append(this.thisClass.toHuman()).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb13 = sb2;
            StringBuilder sb14 = new StringBuilder();
            annotatedOutput4.annotate(4, sb13.append("  class_idx:           ").append(Hex.m53u4(indexOf3)).toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb15 = sb3;
            StringBuilder sb16 = new StringBuilder();
            annotatedOutput5.annotate(4, sb15.append("  access_flags:        ").append(AccessFlags.classString(this.accessFlags)).toString());
            StringBuilder sb17 = sb4;
            StringBuilder sb18 = new StringBuilder();
            StringBuilder append = sb17.append("  superclass_idx:      ").append(Hex.m53u4(indexOf)).append(" // ");
            if (this.superclass == null) {
                human = "<none>";
            } else {
                human = this.superclass.toHuman();
            }
            annotatedOutput2.annotate(4, append.append(human).toString());
            AnnotatedOutput annotatedOutput6 = annotatedOutput2;
            StringBuilder sb19 = sb5;
            StringBuilder sb20 = new StringBuilder();
            annotatedOutput6.annotate(4, sb19.append("  interfaces_off:      ").append(Hex.m53u4(absoluteOffsetOr0)).toString());
            if (absoluteOffsetOr0 != 0) {
                TypeList list = this.interfaces.getList();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    AnnotatedOutput annotatedOutput7 = annotatedOutput2;
                    StringBuilder sb21 = sb10;
                    StringBuilder sb22 = new StringBuilder();
                    annotatedOutput7.annotate(0, sb21.append("    ").append(list.getType(i).toHuman()).toString());
                }
            }
            StringBuilder sb23 = sb6;
            StringBuilder sb24 = new StringBuilder();
            StringBuilder append2 = sb23.append("  source_file_idx:     ").append(Hex.m53u4(indexOf2)).append(" // ");
            if (this.sourceFile == null) {
                human2 = "<none>";
            } else {
                human2 = this.sourceFile.toHuman();
            }
            annotatedOutput2.annotate(4, append2.append(human2).toString());
            AnnotatedOutput annotatedOutput8 = annotatedOutput2;
            StringBuilder sb25 = sb7;
            StringBuilder sb26 = new StringBuilder();
            annotatedOutput8.annotate(4, sb25.append("  annotations_off:     ").append(Hex.m53u4(absoluteOffset)).toString());
            AnnotatedOutput annotatedOutput9 = annotatedOutput2;
            StringBuilder sb27 = sb8;
            StringBuilder sb28 = new StringBuilder();
            annotatedOutput9.annotate(4, sb27.append("  class_data_off:      ").append(Hex.m53u4(absoluteOffset2)).toString());
            AnnotatedOutput annotatedOutput10 = annotatedOutput2;
            StringBuilder sb29 = sb9;
            StringBuilder sb30 = new StringBuilder();
            annotatedOutput10.annotate(4, sb29.append("  static_values_off:   ").append(Hex.m53u4(absoluteOffsetOr02)).toString());
        }
        annotatedOutput2.writeInt(indexOf3);
        annotatedOutput2.writeInt(this.accessFlags);
        annotatedOutput2.writeInt(indexOf);
        annotatedOutput2.writeInt(absoluteOffsetOr0);
        annotatedOutput2.writeInt(indexOf2);
        annotatedOutput2.writeInt(absoluteOffset);
        annotatedOutput2.writeInt(absoluteOffset2);
        annotatedOutput2.writeInt(absoluteOffsetOr02);
    }
}
