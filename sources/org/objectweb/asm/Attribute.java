package org.objectweb.asm;

public class Attribute {

    /* renamed from: a */
    Attribute f277a;

    /* renamed from: b */
    byte[] f278b;
    public final String type;

    protected Attribute(String str) {
        this.type = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo11102a() {
        int i = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.f277a) {
            i++;
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo11103a(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        ClassWriter classWriter2 = classWriter;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        int i7 = 0;
        Attribute attribute = this;
        while (attribute != null) {
            int newUTF8 = classWriter2.newUTF8(attribute.type);
            int i8 = i7 + 6 + attribute.write(classWriter2, bArr2, i4, i5, i6).f280b;
            attribute = attribute.f277a;
            i7 = i8;
        }
        return i7;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo11104a(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3, ByteVector byteVector) {
        ClassWriter classWriter2 = classWriter;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteVector byteVector2 = byteVector;
        Attribute attribute = this;
        while (true) {
            Attribute attribute2 = attribute;
            if (attribute2 != null) {
                ByteVector write = attribute2.write(classWriter2, bArr2, i4, i5, i6);
                ByteVector putInt = byteVector2.putShort(classWriter2.newUTF8(attribute2.type)).putInt(write.f280b);
                ByteVector putByteArray = byteVector2.putByteArray(write.f279a, 0, write.f280b);
                attribute = attribute2.f277a;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Label[] getLabels() {
        return null;
    }

    public boolean isCodeAttribute() {
        return false;
    }

    public boolean isUnknown() {
        return true;
    }

    /* access modifiers changed from: protected */
    public Attribute read(ClassReader classReader, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        Attribute attribute;
        ClassReader classReader2 = classReader;
        int i4 = i;
        int i5 = i2;
        char[] cArr2 = cArr;
        int i6 = i3;
        Label[] labelArr2 = labelArr;
        Attribute attribute2 = attribute;
        Attribute attribute3 = new Attribute(this.type);
        Attribute attribute4 = attribute2;
        attribute4.f278b = new byte[i5];
        System.arraycopy(classReader2.f282b, i4, attribute4.f278b, 0, i5);
        return attribute4;
    }

    /* access modifiers changed from: protected */
    public ByteVector write(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        ByteVector byteVector;
        ClassWriter classWriter2 = classWriter;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteVector byteVector2 = byteVector;
        ByteVector byteVector3 = new ByteVector();
        ByteVector byteVector4 = byteVector2;
        byteVector4.f279a = this.f278b;
        byteVector4.f280b = this.f278b.length;
        return byteVector4;
    }
}
