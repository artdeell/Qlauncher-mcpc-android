package com.tonicsystems.jarjar;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class EmptyClassVisitor extends ClassVisitor {
    public EmptyClassVisitor() {
        super(262144);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        C05462 r7;
        String str2 = str;
        boolean z2 = z;
        C05462 r3 = r7;
        C05462 r4 = new AnnotationVisitor(this, 262144) {
            final /* synthetic */ EmptyClassVisitor this$0;

            {
                int i = r7;
                this.this$0 = r6;
            }
        };
        return r3;
    }

    public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        C05473 r10;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Object obj2 = obj;
        C05473 r6 = r10;
        C05473 r7 = new FieldVisitor(this, 262144) {
            final /* synthetic */ EmptyClassVisitor this$0;

            {
                int i = r7;
                this.this$0 = r6;
            }
        };
        return r6;
    }

    public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        C05451 r10;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        C05451 r6 = r10;
        C05451 r7 = new MethodVisitor(this, 262144) {
            final /* synthetic */ EmptyClassVisitor this$0;

            {
                int i = r7;
                this.this$0 = r6;
            }
        };
        return r6;
    }
}
