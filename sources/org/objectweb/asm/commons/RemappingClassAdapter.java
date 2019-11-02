package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class RemappingClassAdapter extends ClassVisitor {
    protected String className;
    protected final Remapper remapper;

    protected RemappingClassAdapter(int i, ClassVisitor classVisitor, Remapper remapper2) {
        Remapper remapper3 = remapper2;
        super(i, classVisitor);
        this.remapper = remapper3;
    }

    public RemappingClassAdapter(ClassVisitor classVisitor, Remapper remapper2) {
        this(262144, classVisitor, remapper2);
    }

    /* access modifiers changed from: protected */
    public AnnotationVisitor createRemappingAnnotationAdapter(AnnotationVisitor annotationVisitor) {
        RemappingAnnotationAdapter remappingAnnotationAdapter;
        RemappingAnnotationAdapter remappingAnnotationAdapter2 = remappingAnnotationAdapter;
        RemappingAnnotationAdapter remappingAnnotationAdapter3 = new RemappingAnnotationAdapter(annotationVisitor, this.remapper);
        return remappingAnnotationAdapter2;
    }

    /* access modifiers changed from: protected */
    public FieldVisitor createRemappingFieldAdapter(FieldVisitor fieldVisitor) {
        RemappingFieldAdapter remappingFieldAdapter;
        RemappingFieldAdapter remappingFieldAdapter2 = remappingFieldAdapter;
        RemappingFieldAdapter remappingFieldAdapter3 = new RemappingFieldAdapter(fieldVisitor, this.remapper);
        return remappingFieldAdapter2;
    }

    /* access modifiers changed from: protected */
    public MethodVisitor createRemappingMethodAdapter(int i, String str, MethodVisitor methodVisitor) {
        RemappingMethodAdapter remappingMethodAdapter;
        RemappingMethodAdapter remappingMethodAdapter2 = remappingMethodAdapter;
        RemappingMethodAdapter remappingMethodAdapter3 = new RemappingMethodAdapter(i, str, methodVisitor, this.remapper);
        return remappingMethodAdapter2;
    }

    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        int i3 = i;
        int i4 = i2;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        this.className = str4;
        super.visit(i3, i4, this.remapper.mapType(str4), this.remapper.mapSignature(str5, false), this.remapper.mapType(str6), strArr2 == null ? null : this.remapper.mapTypes(strArr2));
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        boolean z2 = z;
        AnnotationVisitor visitAnnotation = super.visitAnnotation(this.remapper.mapDesc(str), z2);
        if (visitAnnotation == null) {
            return null;
        }
        return createRemappingAnnotationAdapter(visitAnnotation);
    }

    public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        String str4 = str2;
        FieldVisitor visitField = super.visitField(i, this.remapper.mapFieldName(this.className, str, str4), this.remapper.mapDesc(str4), this.remapper.mapSignature(str3, true), this.remapper.mapValue(obj));
        if (visitField == null) {
            return null;
        }
        return createRemappingFieldAdapter(visitField);
    }

    public void visitInnerClass(String str, String str2, String str3, int i) {
        String str4 = str2;
        super.visitInnerClass(this.remapper.mapType(str), str4 == null ? null : this.remapper.mapType(str4), str3, i);
    }

    public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        String mapMethodDesc = this.remapper.mapMethodDesc(str5);
        MethodVisitor visitMethod = super.visitMethod(i2, this.remapper.mapMethodName(this.className, str4, str5), mapMethodDesc, this.remapper.mapSignature(str6, false), strArr2 == null ? null : this.remapper.mapTypes(strArr2));
        if (visitMethod == null) {
            return null;
        }
        return createRemappingMethodAdapter(i2, mapMethodDesc, visitMethod);
    }

    public void visitOuterClass(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String mapType = this.remapper.mapType(str4);
        String mapMethodName = str5 == null ? null : this.remapper.mapMethodName(str4, str5, str6);
        String str7 = null;
        if (str6 != null) {
            str7 = this.remapper.mapMethodDesc(str6);
        }
        super.visitOuterClass(mapType, mapMethodName, str7);
    }
}
