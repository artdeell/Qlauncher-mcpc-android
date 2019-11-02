package org.objectweb.asm;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttConstantValue;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttDeprecated;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeInvisibleAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttRuntimeVisibleAnnotations;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttSignature;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.AttSynthetic;

final class FieldWriter extends FieldVisitor {

    /* renamed from: b */
    private final ClassWriter f328b;

    /* renamed from: c */
    private final int f329c;

    /* renamed from: d */
    private final int f330d;

    /* renamed from: e */
    private final int f331e;

    /* renamed from: f */
    private int f332f;

    /* renamed from: g */
    private int f333g;

    /* renamed from: h */
    private AnnotationWriter f334h;

    /* renamed from: i */
    private AnnotationWriter f335i;

    /* renamed from: j */
    private Attribute f336j;

    FieldWriter(ClassWriter classWriter, int i, String str, String str2, String str3, Object obj) {
        ClassWriter classWriter2 = classWriter;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Object obj2 = obj;
        super(262144);
        if (classWriter2.f288B == null) {
            classWriter2.f288B = this;
        } else {
            classWriter2.f289C.f327fv = this;
        }
        classWriter2.f289C = this;
        this.f328b = classWriter2;
        this.f329c = i2;
        this.f330d = classWriter2.newUTF8(str4);
        this.f331e = classWriter2.newUTF8(str5);
        if (str6 != null) {
            this.f332f = classWriter2.newUTF8(str6);
        }
        if (obj2 != null) {
            this.f333g = classWriter2.mo11149a(obj2).f356a;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo11168a() {
        int i;
        int i2 = 8;
        if (this.f333g != 0) {
            int newUTF8 = this.f328b.newUTF8(AttConstantValue.ATTRIBUTE_NAME);
            i2 = 16;
        }
        if ((4096 & this.f329c) != 0 && ((65535 & this.f328b.f299b) < 49 || (262144 & this.f329c) != 0)) {
            int newUTF82 = this.f328b.newUTF8(AttSynthetic.ATTRIBUTE_NAME);
            i2 += 6;
        }
        if ((131072 & this.f329c) != 0) {
            int newUTF83 = this.f328b.newUTF8(AttDeprecated.ATTRIBUTE_NAME);
            i2 += 6;
        }
        if (this.f332f != 0) {
            int newUTF84 = this.f328b.newUTF8(AttSignature.ATTRIBUTE_NAME);
            i2 += 8;
        }
        if (this.f334h != null) {
            int newUTF85 = this.f328b.newUTF8(AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME);
            i2 += 8 + this.f334h.mo11100a();
        }
        if (this.f335i != null) {
            int newUTF86 = this.f328b.newUTF8(AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME);
            i = i2 + 8 + this.f335i.mo11100a();
        } else {
            i = i2;
        }
        if (this.f336j != null) {
            i += this.f336j.mo11103a(this.f328b, null, 0, -1, -1);
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11169a(ByteVector byteVector) {
        ByteVector byteVector2 = byteVector;
        ByteVector putShort = byteVector2.putShort(this.f329c & ((393216 | ((262144 & this.f329c) / 64)) ^ -1)).putShort(this.f330d).putShort(this.f331e);
        int i = this.f333g != 0 ? 1 : 0;
        if ((4096 & this.f329c) != 0 && ((65535 & this.f328b.f299b) < 49 || (262144 & this.f329c) != 0)) {
            i++;
        }
        if ((131072 & this.f329c) != 0) {
            i++;
        }
        if (this.f332f != 0) {
            i++;
        }
        if (this.f334h != null) {
            i++;
        }
        if (this.f335i != null) {
            i++;
        }
        if (this.f336j != null) {
            i += this.f336j.mo11102a();
        }
        ByteVector putShort2 = byteVector2.putShort(i);
        if (this.f333g != 0) {
            ByteVector putShort3 = byteVector2.putShort(this.f328b.newUTF8(AttConstantValue.ATTRIBUTE_NAME));
            ByteVector putShort4 = byteVector2.putInt(2).putShort(this.f333g);
        }
        if ((4096 & this.f329c) != 0 && ((65535 & this.f328b.f299b) < 49 || (262144 & this.f329c) != 0)) {
            ByteVector putInt = byteVector2.putShort(this.f328b.newUTF8(AttSynthetic.ATTRIBUTE_NAME)).putInt(0);
        }
        if ((131072 & this.f329c) != 0) {
            ByteVector putInt2 = byteVector2.putShort(this.f328b.newUTF8(AttDeprecated.ATTRIBUTE_NAME)).putInt(0);
        }
        if (this.f332f != 0) {
            ByteVector putShort5 = byteVector2.putShort(this.f328b.newUTF8(AttSignature.ATTRIBUTE_NAME));
            ByteVector putShort6 = byteVector2.putInt(2).putShort(this.f332f);
        }
        if (this.f334h != null) {
            ByteVector putShort7 = byteVector2.putShort(this.f328b.newUTF8(AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME));
            this.f334h.mo11101a(byteVector2);
        }
        if (this.f335i != null) {
            ByteVector putShort8 = byteVector2.putShort(this.f328b.newUTF8(AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME));
            this.f335i.mo11101a(byteVector2);
        }
        if (this.f336j != null) {
            this.f336j.mo11104a(this.f328b, null, 0, -1, -1, byteVector2);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector;
        AnnotationWriter annotationWriter;
        String str2 = str;
        boolean z2 = z;
        ByteVector byteVector2 = byteVector;
        ByteVector byteVector3 = new ByteVector();
        ByteVector byteVector4 = byteVector2;
        ByteVector putShort = byteVector4.putShort(this.f328b.newUTF8(str2)).putShort(0);
        AnnotationWriter annotationWriter2 = annotationWriter;
        AnnotationWriter annotationWriter3 = new AnnotationWriter(this.f328b, true, byteVector4, byteVector4, 2);
        AnnotationWriter annotationWriter4 = annotationWriter2;
        if (z2) {
            annotationWriter4.f275g = this.f334h;
            this.f334h = annotationWriter4;
            return annotationWriter4;
        }
        annotationWriter4.f275g = this.f335i;
        this.f335i = annotationWriter4;
        return annotationWriter4;
    }

    public void visitAttribute(Attribute attribute) {
        Attribute attribute2 = attribute;
        attribute2.f277a = this.f336j;
        this.f336j = attribute2;
    }

    public void visitEnd() {
    }
}
