package com.tonicsystems.jarjar;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

abstract class StringReader extends ClassVisitor {
    private String className;
    private int line = -1;

    public StringReader() {
        super(262144);
    }

    static /* synthetic */ int access$102(StringReader stringReader, int i) {
        int i2 = i;
        stringReader.line = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    public void handleObject(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof String) {
            visitString(this.className, (String) obj2, this.line);
        }
    }

    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        int i3 = i;
        int i4 = i2;
        String str4 = str2;
        String str5 = str3;
        String[] strArr2 = strArr;
        this.className = str;
        this.line = -1;
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        C05492 r7;
        String str2 = str;
        boolean z2 = z;
        C05492 r3 = r7;
        C05492 r4 = new AnnotationVisitor(this, 262144) {
            final /* synthetic */ StringReader this$0;

            {
                int i = r7;
                this.this$0 = r6;
            }

            public void visit(String str, Object obj) {
                String str2 = str;
                Object obj2 = obj;
                this.this$0.handleObject(obj2);
            }

            public AnnotationVisitor visitAnnotation(String str, String str2) {
                String str3 = str;
                String str4 = str2;
                return this;
            }

            public void visitEnum(String str, String str2, String str3) {
                String str4 = str;
                String str5 = str2;
                String str6 = str3;
                this.this$0.handleObject(str6);
            }
        };
        return r3;
    }

    public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        C05481 r10;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        handleObject(obj);
        C05481 r6 = r10;
        C05481 r7 = new FieldVisitor(this, 262144) {
            final /* synthetic */ StringReader this$0;

            {
                int i = r7;
                this.this$0 = r6;
            }

            public AnnotationVisitor visitAnnotation(String str, boolean z) {
                return this.this$0.visitAnnotation(str, z);
            }
        };
        return r6;
    }

    public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        C05503 r10;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        C05503 r6 = r10;
        C05503 r7 = new MethodVisitor(this, 262144) {
            final /* synthetic */ StringReader this$0;

            {
                int i = r7;
                this.this$0 = r6;
            }

            public AnnotationVisitor visitAnnotation(String str, boolean z) {
                return this.this$0.visitAnnotation(str, z);
            }

            public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
                String str3 = str;
                String str4 = str2;
                Handle handle2 = handle;
                Object[] objArr2 = objArr;
                int length = objArr2.length;
                for (int i = 0; i < length; i++) {
                    this.this$0.handleObject(objArr2[i]);
                }
            }

            public void visitLdcInsn(Object obj) {
                Object obj2 = obj;
                this.this$0.handleObject(obj2);
            }

            public void visitLineNumber(int i, Label label) {
                int i2 = i;
                Label label2 = label;
                int access$102 = StringReader.access$102(this.this$0, i2);
            }

            public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
                int i2 = i;
                return this.this$0.visitAnnotation(str, z);
            }
        };
        return r6;
    }

    public abstract void visitString(String str, String str2, int i);
}
