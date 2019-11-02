package org.objectweb.asm;

public abstract class AnnotationVisitor {
    protected final int api;

    /* renamed from: av */
    protected AnnotationVisitor f268av;

    public AnnotationVisitor(int i) {
        this(i, null);
    }

    public AnnotationVisitor(int i, AnnotationVisitor annotationVisitor) {
        AnnotationVisitor annotationVisitor2 = annotationVisitor;
        this.api = i;
        this.f268av = annotationVisitor2;
    }

    public void visit(String str, Object obj) {
        String str2 = str;
        Object obj2 = obj;
        if (this.f268av != null) {
            this.f268av.visit(str2, obj2);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (this.f268av != null) {
            return this.f268av.visitAnnotation(str3, str4);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String str) {
        String str2 = str;
        if (this.f268av != null) {
            return this.f268av.visitArray(str2);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f268av != null) {
            this.f268av.visitEnd();
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (this.f268av != null) {
            this.f268av.visitEnum(str4, str5, str6);
        }
    }
}
