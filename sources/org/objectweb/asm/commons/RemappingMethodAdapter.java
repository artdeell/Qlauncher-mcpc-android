package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class RemappingMethodAdapter extends LocalVariablesSorter {
    protected final Remapper remapper;

    protected RemappingMethodAdapter(int i, int i2, String str, MethodVisitor methodVisitor, Remapper remapper2) {
        Remapper remapper3 = remapper2;
        super(i, i2, str, methodVisitor);
        this.remapper = remapper3;
    }

    public RemappingMethodAdapter(int i, String str, MethodVisitor methodVisitor, Remapper remapper2) {
        this(262144, i, str, methodVisitor, remapper2);
    }

    private Object[] remapEntries(int i, Object[] objArr) {
        int i2 = i;
        Object[] objArr2 = objArr;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            } else if (objArr2[i3] instanceof String) {
                Object[] objArr3 = new Object[i2];
                if (i3 > 0) {
                    System.arraycopy(objArr2, 0, objArr3, 0, i3);
                }
                int i4 = i3;
                while (true) {
                    int i5 = i4;
                    Object obj = objArr2[i5];
                    int i6 = i5 + 1;
                    if (obj instanceof String) {
                        obj = this.remapper.mapType((String) obj);
                    }
                    objArr3[i5] = obj;
                    if (i6 >= i2) {
                        break;
                    }
                    i4 = i6;
                }
                objArr2 = objArr3;
            } else {
                i3++;
            }
        }
        return objArr2;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        RemappingAnnotationAdapter remappingAnnotationAdapter;
        boolean z2 = z;
        AnnotationVisitor visitAnnotation = this.f376mv.visitAnnotation(this.remapper.mapDesc(str), z2);
        if (visitAnnotation == null) {
            return visitAnnotation;
        }
        RemappingAnnotationAdapter remappingAnnotationAdapter2 = remappingAnnotationAdapter;
        RemappingAnnotationAdapter remappingAnnotationAdapter3 = new RemappingAnnotationAdapter(visitAnnotation, this.remapper);
        return remappingAnnotationAdapter2;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        RemappingAnnotationAdapter remappingAnnotationAdapter;
        AnnotationVisitor visitAnnotationDefault = this.f376mv.visitAnnotationDefault();
        if (visitAnnotationDefault == null) {
            return visitAnnotationDefault;
        }
        RemappingAnnotationAdapter remappingAnnotationAdapter2 = remappingAnnotationAdapter;
        RemappingAnnotationAdapter remappingAnnotationAdapter3 = new RemappingAnnotationAdapter(visitAnnotationDefault, this.remapper);
        return remappingAnnotationAdapter2;
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        String str4 = str;
        String str5 = str3;
        super.visitFieldInsn(i, this.remapper.mapType(str4), this.remapper.mapFieldName(str4, str2, str5), this.remapper.mapDesc(str5));
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4 = i2;
        int i5 = i3;
        super.visitFrame(i, i4, remapEntries(i4, objArr), i5, remapEntries(i5, objArr2));
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        String str3 = str;
        String str4 = str2;
        Handle handle2 = handle;
        Object[] objArr2 = objArr;
        for (int i = 0; i < objArr2.length; i++) {
            objArr2[i] = this.remapper.mapValue(objArr2[i]);
        }
        super.visitInvokeDynamicInsn(this.remapper.mapInvokeDynamicMethodName(str3, str4), this.remapper.mapMethodDesc(str4), (Handle) this.remapper.mapValue(handle2), objArr2);
    }

    public void visitLdcInsn(Object obj) {
        super.visitLdcInsn(this.remapper.mapValue(obj));
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        Label label3 = label;
        Label label4 = label2;
        int i2 = i;
        super.visitLocalVariable(str, this.remapper.mapDesc(str2), this.remapper.mapSignature(str3, true), label3, label4, i2);
    }

    public void visitMethodInsn(int i, String str, String str2, String str3) {
        String str4 = str;
        String str5 = str3;
        super.visitMethodInsn(i, this.remapper.mapType(str4), this.remapper.mapMethodName(str4, str2, str5), this.remapper.mapMethodDesc(str5));
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        int i2 = i;
        super.visitMultiANewArrayInsn(this.remapper.mapDesc(str), i2);
    }

    public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
        RemappingAnnotationAdapter remappingAnnotationAdapter;
        boolean z2 = z;
        AnnotationVisitor visitParameterAnnotation = this.f376mv.visitParameterAnnotation(i, this.remapper.mapDesc(str), z2);
        if (visitParameterAnnotation == null) {
            return visitParameterAnnotation;
        }
        RemappingAnnotationAdapter remappingAnnotationAdapter2 = remappingAnnotationAdapter;
        RemappingAnnotationAdapter remappingAnnotationAdapter3 = new RemappingAnnotationAdapter(visitParameterAnnotation, this.remapper);
        return remappingAnnotationAdapter2;
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        String str2 = str;
        super.visitTryCatchBlock(label, label2, label3, str2 == null ? null : this.remapper.mapType(str2));
    }

    public void visitTypeInsn(int i, String str) {
        super.visitTypeInsn(i, this.remapper.mapType(str));
    }
}
