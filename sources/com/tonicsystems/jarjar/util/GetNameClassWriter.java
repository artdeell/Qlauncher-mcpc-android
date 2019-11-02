package com.tonicsystems.jarjar.util;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class GetNameClassWriter extends ClassVisitor {
    private String className;

    public GetNameClassWriter(int i) {
        ClassWriter classWriter;
        ClassWriter classWriter2 = classWriter;
        ClassWriter classWriter3 = new ClassWriter(i);
        super(262144, classWriter2);
    }

    public String getClassName() {
        return this.className;
    }

    public byte[] toByteArray() {
        return ((ClassWriter) this.f285cv).toByteArray();
    }

    public void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        int i3 = i;
        int i4 = i2;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        this.className = str4;
        super.visit(i3, i4, str4, str5, str6, strArr2);
    }
}
