package org.objectweb.asm;

public abstract class ClassVisitor {
    protected final int api;

    /* renamed from: cv */
    protected ClassVisitor f285cv;

    public ClassVisitor(int i) {
        this(i, null);
    }

    public ClassVisitor(int i, ClassVisitor classVisitor) {
        ClassVisitor classVisitor2 = classVisitor;
        this.api = i;
        this.f285cv = classVisitor2;
    }

    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        int i3 = i;
        int i4 = i2;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        if (this.f285cv != null) {
            this.f285cv.visit(i3, i4, str4, str5, str6, strArr2);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        String str2 = str;
        boolean z2 = z;
        if (this.f285cv != null) {
            return this.f285cv.visitAnnotation(str2, z2);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        Attribute attribute2 = attribute;
        if (this.f285cv != null) {
            this.f285cv.visitAttribute(attribute2);
        }
    }

    public void visitEnd() {
        if (this.f285cv != null) {
            this.f285cv.visitEnd();
        }
    }

    public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Object obj2 = obj;
        if (this.f285cv != null) {
            return this.f285cv.visitField(i2, str4, str5, str6, obj2);
        }
        return null;
    }

    public void visitInnerClass(String str, String str2, String str3, int i) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        int i2 = i;
        if (this.f285cv != null) {
            this.f285cv.visitInnerClass(str4, str5, str6, i2);
        }
    }

    public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        if (this.f285cv != null) {
            return this.f285cv.visitMethod(i2, str4, str5, str6, strArr2);
        }
        return null;
    }

    public void visitOuterClass(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (this.f285cv != null) {
            this.f285cv.visitOuterClass(str4, str5, str6);
        }
    }

    public void visitSource(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (this.f285cv != null) {
            this.f285cv.visitSource(str3, str4);
        }
    }
}
