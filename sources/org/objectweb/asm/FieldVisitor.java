package org.objectweb.asm;

public abstract class FieldVisitor {
    protected final int api;

    /* renamed from: fv */
    protected FieldVisitor f327fv;

    public FieldVisitor(int i) {
        this(i, null);
    }

    public FieldVisitor(int i, FieldVisitor fieldVisitor) {
        FieldVisitor fieldVisitor2 = fieldVisitor;
        this.api = i;
        this.f327fv = fieldVisitor2;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        String str2 = str;
        boolean z2 = z;
        if (this.f327fv != null) {
            return this.f327fv.visitAnnotation(str2, z2);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        Attribute attribute2 = attribute;
        if (this.f327fv != null) {
            this.f327fv.visitAttribute(attribute2);
        }
    }

    public void visitEnd() {
        if (this.f327fv != null) {
            this.f327fv.visitEnd();
        }
    }
}
