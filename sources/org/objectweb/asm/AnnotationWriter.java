package org.objectweb.asm;

final class AnnotationWriter extends AnnotationVisitor {

    /* renamed from: a */
    private final ClassWriter f269a;

    /* renamed from: b */
    private int f270b;

    /* renamed from: c */
    private final boolean f271c;

    /* renamed from: d */
    private final ByteVector f272d;

    /* renamed from: e */
    private final ByteVector f273e;

    /* renamed from: f */
    private final int f274f;

    /* renamed from: g */
    AnnotationWriter f275g;

    /* renamed from: h */
    AnnotationWriter f276h;

    AnnotationWriter(ClassWriter classWriter, boolean z, ByteVector byteVector, ByteVector byteVector2, int i) {
        ClassWriter classWriter2 = classWriter;
        boolean z2 = z;
        ByteVector byteVector3 = byteVector;
        ByteVector byteVector4 = byteVector2;
        int i2 = i;
        super(262144);
        this.f269a = classWriter2;
        this.f271c = z2;
        this.f272d = byteVector3;
        this.f273e = byteVector4;
        this.f274f = i2;
    }

    /* renamed from: a */
    static void m57a(AnnotationWriter[] annotationWriterArr, int i, ByteVector byteVector) {
        AnnotationWriter[] annotationWriterArr2 = annotationWriterArr;
        int i2 = i;
        ByteVector byteVector2 = byteVector;
        int length = 1 + (2 * (annotationWriterArr2.length - i2));
        for (int i3 = i2; i3 < annotationWriterArr2.length; i3++) {
            length += annotationWriterArr2[i3] == null ? 0 : annotationWriterArr2[i3].mo11100a();
        }
        ByteVector putByte = byteVector2.putInt(length).putByte(annotationWriterArr2.length - i2);
        while (i2 < annotationWriterArr2.length) {
            AnnotationWriter annotationWriter = annotationWriterArr2[i2];
            AnnotationWriter annotationWriter2 = null;
            int i4 = 0;
            while (annotationWriter != null) {
                i4++;
                annotationWriter.visitEnd();
                annotationWriter.f276h = annotationWriter2;
                AnnotationWriter annotationWriter3 = annotationWriter;
                annotationWriter = annotationWriter.f275g;
                annotationWriter2 = annotationWriter3;
            }
            ByteVector putShort = byteVector2.putShort(i4);
            while (annotationWriter2 != null) {
                ByteVector putByteArray = byteVector2.putByteArray(annotationWriter2.f272d.f279a, 0, annotationWriter2.f272d.f280b);
                annotationWriter2 = annotationWriter2.f276h;
            }
            i2++;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo11100a() {
        int i = 0;
        for (AnnotationWriter annotationWriter = this; annotationWriter != null; annotationWriter = annotationWriter.f275g) {
            i += annotationWriter.f272d.f280b;
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11101a(ByteVector byteVector) {
        ByteVector byteVector2 = byteVector;
        AnnotationWriter annotationWriter = null;
        int i = 2;
        int i2 = 0;
        AnnotationWriter annotationWriter2 = this;
        while (true) {
            AnnotationWriter annotationWriter3 = annotationWriter2;
            if (annotationWriter3 == null) {
                break;
            }
            i2++;
            i += annotationWriter3.f272d.f280b;
            annotationWriter3.visitEnd();
            annotationWriter3.f276h = annotationWriter;
            annotationWriter = annotationWriter3;
            annotationWriter2 = annotationWriter3.f275g;
        }
        ByteVector putInt = byteVector2.putInt(i);
        ByteVector putShort = byteVector2.putShort(i2);
        while (annotationWriter != null) {
            ByteVector putByteArray = byteVector2.putByteArray(annotationWriter.f272d.f279a, 0, annotationWriter.f272d.f280b);
            annotationWriter = annotationWriter.f276h;
        }
    }

    public void visit(String str, Object obj) {
        String str2 = str;
        Object obj2 = obj;
        int i = 1;
        int i2 = 0;
        this.f270b = 1 + this.f270b;
        if (this.f271c) {
            ByteVector putShort = this.f272d.putShort(this.f269a.newUTF8(str2));
        }
        if (obj2 instanceof String) {
            ByteVector b = this.f272d.mo11111b(115, this.f269a.newUTF8((String) obj2));
        } else if (obj2 instanceof Byte) {
            ByteVector b2 = this.f272d.mo11111b(66, this.f269a.mo11146a((int) ((Byte) obj2).byteValue()).f356a);
        } else if (obj2 instanceof Boolean) {
            if (!((Boolean) obj2).booleanValue()) {
                i = 0;
            }
            ByteVector b3 = this.f272d.mo11111b(90, this.f269a.mo11146a(i).f356a);
        } else if (obj2 instanceof Character) {
            ByteVector b4 = this.f272d.mo11111b(67, this.f269a.mo11146a((int) ((Character) obj2).charValue()).f356a);
        } else if (obj2 instanceof Short) {
            ByteVector b5 = this.f272d.mo11111b(83, this.f269a.mo11146a((int) ((Short) obj2).shortValue()).f356a);
        } else if (obj2 instanceof Type) {
            ByteVector b6 = this.f272d.mo11111b(99, this.f269a.newUTF8(((Type) obj2).getDescriptor()));
        } else if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            ByteVector b7 = this.f272d.mo11111b(91, bArr.length);
            while (i2 < bArr.length) {
                ByteVector b8 = this.f272d.mo11111b(66, this.f269a.mo11146a((int) bArr[i2]).f356a);
                i2++;
            }
        } else if (obj2 instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj2;
            ByteVector b9 = this.f272d.mo11111b(91, zArr.length);
            for (int i3 = 0; i3 < zArr.length; i3++) {
                ByteVector b10 = this.f272d.mo11111b(90, this.f269a.mo11146a(zArr[i3] ? 1 : 0).f356a);
            }
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            ByteVector b11 = this.f272d.mo11111b(91, sArr.length);
            while (i2 < sArr.length) {
                ByteVector b12 = this.f272d.mo11111b(83, this.f269a.mo11146a((int) sArr[i2]).f356a);
                i2++;
            }
        } else if (obj2 instanceof char[]) {
            char[] cArr = (char[]) obj2;
            ByteVector b13 = this.f272d.mo11111b(91, cArr.length);
            while (i2 < cArr.length) {
                ByteVector b14 = this.f272d.mo11111b(67, this.f269a.mo11146a((int) cArr[i2]).f356a);
                i2++;
            }
        } else if (obj2 instanceof int[]) {
            int[] iArr = (int[]) obj2;
            ByteVector b15 = this.f272d.mo11111b(91, iArr.length);
            while (i2 < iArr.length) {
                ByteVector b16 = this.f272d.mo11111b(73, this.f269a.mo11146a(iArr[i2]).f356a);
                i2++;
            }
        } else if (obj2 instanceof long[]) {
            long[] jArr = (long[]) obj2;
            ByteVector b17 = this.f272d.mo11111b(91, jArr.length);
            while (i2 < jArr.length) {
                ByteVector b18 = this.f272d.mo11111b(74, this.f269a.mo11148a(jArr[i2]).f356a);
                i2++;
            }
        } else if (obj2 instanceof float[]) {
            float[] fArr = (float[]) obj2;
            ByteVector b19 = this.f272d.mo11111b(91, fArr.length);
            while (i2 < fArr.length) {
                ByteVector b20 = this.f272d.mo11111b(70, this.f269a.mo11145a(fArr[i2]).f356a);
                i2++;
            }
        } else if (obj2 instanceof double[]) {
            double[] dArr = (double[]) obj2;
            ByteVector b21 = this.f272d.mo11111b(91, dArr.length);
            while (i2 < dArr.length) {
                ByteVector b22 = this.f272d.mo11111b(68, this.f269a.mo11144a(dArr[i2]).f356a);
                i2++;
            }
        } else {
            Item a = this.f269a.mo11149a(obj2);
            ByteVector b23 = this.f272d.mo11111b(".s.IFJDCS".charAt(a.f357b), a.f356a);
        }
    }

    public AnnotationVisitor visitAnnotation(String str, String str2) {
        AnnotationWriter annotationWriter;
        String str3 = str;
        String str4 = str2;
        this.f270b = 1 + this.f270b;
        if (this.f271c) {
            ByteVector putShort = this.f272d.putShort(this.f269a.newUTF8(str3));
        }
        ByteVector putShort2 = this.f272d.mo11111b(64, this.f269a.newUTF8(str4)).putShort(0);
        AnnotationWriter annotationWriter2 = annotationWriter;
        AnnotationWriter annotationWriter3 = new AnnotationWriter(this.f269a, true, this.f272d, this.f272d, -2 + this.f272d.f280b);
        return annotationWriter2;
    }

    public AnnotationVisitor visitArray(String str) {
        AnnotationWriter annotationWriter;
        String str2 = str;
        this.f270b = 1 + this.f270b;
        if (this.f271c) {
            ByteVector putShort = this.f272d.putShort(this.f269a.newUTF8(str2));
        }
        ByteVector b = this.f272d.mo11111b(91, 0);
        AnnotationWriter annotationWriter2 = annotationWriter;
        AnnotationWriter annotationWriter3 = new AnnotationWriter(this.f269a, false, this.f272d, this.f272d, -2 + this.f272d.f280b);
        return annotationWriter2;
    }

    public void visitEnd() {
        if (this.f273e != null) {
            byte[] bArr = this.f273e.f279a;
            bArr[this.f274f] = (byte) (this.f270b >>> 8);
            bArr[1 + this.f274f] = (byte) this.f270b;
        }
    }

    public void visitEnum(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        this.f270b = 1 + this.f270b;
        if (this.f271c) {
            ByteVector putShort = this.f272d.putShort(this.f269a.newUTF8(str4));
        }
        ByteVector putShort2 = this.f272d.mo11111b(101, this.f269a.newUTF8(str5)).putShort(this.f269a.newUTF8(str6));
    }
}
