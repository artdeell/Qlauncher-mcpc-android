package org.objectweb.asm;

public abstract class MethodVisitor {
    protected final int api;

    /* renamed from: mv */
    protected MethodVisitor f376mv;

    public MethodVisitor(int i) {
        this(i, null);
    }

    public MethodVisitor(int i, MethodVisitor methodVisitor) {
        MethodVisitor methodVisitor2 = methodVisitor;
        this.api = i;
        this.f376mv = methodVisitor2;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        String str2 = str;
        boolean z2 = z;
        if (this.f376mv != null) {
            return this.f376mv.visitAnnotation(str2, z2);
        }
        return null;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        if (this.f376mv != null) {
            return this.f376mv.visitAnnotationDefault();
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        Attribute attribute2 = attribute;
        if (this.f376mv != null) {
            this.f376mv.visitAttribute(attribute2);
        }
    }

    public void visitCode() {
        if (this.f376mv != null) {
            this.f376mv.visitCode();
        }
    }

    public void visitEnd() {
        if (this.f376mv != null) {
            this.f376mv.visitEnd();
        }
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (this.f376mv != null) {
            this.f376mv.visitFieldInsn(i2, str4, str5, str6);
        }
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4 = i;
        int i5 = i2;
        Object[] objArr3 = objArr;
        int i6 = i3;
        Object[] objArr4 = objArr2;
        if (this.f376mv != null) {
            this.f376mv.visitFrame(i4, i5, objArr3, i6, objArr4);
        }
    }

    public void visitIincInsn(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f376mv != null) {
            this.f376mv.visitIincInsn(i3, i4);
        }
    }

    public void visitInsn(int i) {
        int i2 = i;
        if (this.f376mv != null) {
            this.f376mv.visitInsn(i2);
        }
    }

    public void visitIntInsn(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f376mv != null) {
            this.f376mv.visitIntInsn(i3, i4);
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        String str3 = str;
        String str4 = str2;
        Handle handle2 = handle;
        Object[] objArr2 = objArr;
        if (this.f376mv != null) {
            this.f376mv.visitInvokeDynamicInsn(str3, str4, handle2, objArr2);
        }
    }

    public void visitJumpInsn(int i, Label label) {
        int i2 = i;
        Label label2 = label;
        if (this.f376mv != null) {
            this.f376mv.visitJumpInsn(i2, label2);
        }
    }

    public void visitLabel(Label label) {
        Label label2 = label;
        if (this.f376mv != null) {
            this.f376mv.visitLabel(label2);
        }
    }

    public void visitLdcInsn(Object obj) {
        Object obj2 = obj;
        if (this.f376mv != null) {
            this.f376mv.visitLdcInsn(obj2);
        }
    }

    public void visitLineNumber(int i, Label label) {
        int i2 = i;
        Label label2 = label;
        if (this.f376mv != null) {
            this.f376mv.visitLineNumber(i2, label2);
        }
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Label label3 = label;
        Label label4 = label2;
        int i2 = i;
        if (this.f376mv != null) {
            this.f376mv.visitLocalVariable(str4, str5, str6, label3, label4, i2);
        }
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        Label label2 = label;
        int[] iArr2 = iArr;
        Label[] labelArr2 = labelArr;
        if (this.f376mv != null) {
            this.f376mv.visitLookupSwitchInsn(label2, iArr2, labelArr2);
        }
    }

    public void visitMaxs(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f376mv != null) {
            this.f376mv.visitMaxs(i3, i4);
        }
    }

    public void visitMethodInsn(int i, String str, String str2, String str3) {
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (this.f376mv != null) {
            this.f376mv.visitMethodInsn(i2, str4, str5, str6);
        }
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        String str2 = str;
        int i2 = i;
        if (this.f376mv != null) {
            this.f376mv.visitMultiANewArrayInsn(str2, i2);
        }
    }

    public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
        int i2 = i;
        String str2 = str;
        boolean z2 = z;
        if (this.f376mv != null) {
            return this.f376mv.visitParameterAnnotation(i2, str2, z2);
        }
        return null;
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        int i3 = i;
        int i4 = i2;
        Label label2 = label;
        Label[] labelArr2 = labelArr;
        if (this.f376mv != null) {
            this.f376mv.visitTableSwitchInsn(i3, i4, label2, labelArr2);
        }
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        Label label4 = label;
        Label label5 = label2;
        Label label6 = label3;
        String str2 = str;
        if (this.f376mv != null) {
            this.f376mv.visitTryCatchBlock(label4, label5, label6, str2);
        }
    }

    public void visitTypeInsn(int i, String str) {
        int i2 = i;
        String str2 = str;
        if (this.f376mv != null) {
            this.f376mv.visitTypeInsn(i2, str2);
        }
    }

    public void visitVarInsn(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f376mv != null) {
            this.f376mv.visitVarInsn(i3, i4);
        }
    }
}
