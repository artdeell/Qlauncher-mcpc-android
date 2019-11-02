package org.objectweb.asm;

import java.io.IOException;
import java.io.InputStream;

public class ClassReader {
    public static final int EXPAND_FRAMES = 8;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;

    /* renamed from: a */
    private final int[] f281a;

    /* renamed from: b */
    public final byte[] f282b;

    /* renamed from: c */
    private final String[] f283c;

    /* renamed from: d */
    private final int f284d;
    public final int header;

    public ClassReader(InputStream inputStream) throws IOException {
        this(m73a(inputStream, false));
    }

    public ClassReader(String str) throws IOException {
        StringBuffer stringBuffer;
        String str2 = str;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        this(m73a(ClassLoader.getSystemResourceAsStream(stringBuffer2.append(str2.replace('.', ClassPathElement.SEPARATOR_CHAR)).append(".class").toString()), true));
    }

    public ClassReader(byte[] bArr) {
        byte[] bArr2 = bArr;
        this(bArr2, 0, bArr2.length);
    }

    public ClassReader(byte[] bArr, int i, int i2) {
        int i3;
        IllegalArgumentException illegalArgumentException;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        this.f282b = bArr2;
        if (readShort(6) > 51) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
        this.f281a = new int[readUnsignedShort(i4 + 8)];
        int length = this.f281a.length;
        this.f283c = new String[length];
        int i6 = 0;
        int i7 = 1;
        int i8 = i4 + 10;
        while (true) {
            int i9 = i8;
            if (i7 < length) {
                this.f281a[i7] = i9 + 1;
                switch (bArr2[i9]) {
                    case 1:
                        i3 = 3 + readUnsignedShort(i9 + 1);
                        if (i3 <= i6) {
                            break;
                        } else {
                            i6 = i3;
                            break;
                        }
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 18:
                        i3 = 5;
                        break;
                    case 5:
                    case 6:
                        i3 = 9;
                        i7++;
                        break;
                    case 15:
                        i3 = 4;
                        break;
                    default:
                        i3 = 3;
                        break;
                }
                i7++;
                i8 = i3 + i9;
            } else {
                this.f284d = i6;
                this.header = i9;
                return;
            }
        }
    }

    /* renamed from: a */
    private int m66a(int i, char[] cArr, String str, AnnotationVisitor annotationVisitor) {
        Character ch;
        Short sh;
        Byte b;
        int i2 = i;
        char[] cArr2 = cArr;
        String str2 = str;
        AnnotationVisitor annotationVisitor2 = annotationVisitor;
        int i3 = 0;
        if (annotationVisitor2 == null) {
            switch (255 & this.f282b[i2]) {
                case 64:
                    return m67a(i2 + 3, cArr2, true, (AnnotationVisitor) null);
                case 91:
                    return m67a(i2 + 1, cArr2, false, (AnnotationVisitor) null);
                case 101:
                    return i2 + 5;
                default:
                    return i2 + 3;
            }
        } else {
            int i4 = i2 + 1;
            switch (255 & this.f282b[i2]) {
                case 64:
                    return m67a(i4 + 2, cArr2, true, annotationVisitor2.visitAnnotation(str2, readUTF8(i4, cArr2)));
                case 66:
                    AnnotationVisitor annotationVisitor3 = annotationVisitor2;
                    String str3 = str2;
                    Byte b2 = b;
                    Byte b3 = new Byte((byte) readInt(this.f281a[readUnsignedShort(i4)]));
                    annotationVisitor3.visit(str3, b2);
                    return i4 + 2;
                case 67:
                    AnnotationVisitor annotationVisitor4 = annotationVisitor2;
                    String str4 = str2;
                    Character ch2 = ch;
                    Character ch3 = new Character((char) readInt(this.f281a[readUnsignedShort(i4)]));
                    annotationVisitor4.visit(str4, ch2);
                    return i4 + 2;
                case 68:
                case 70:
                case 73:
                case 74:
                    annotationVisitor2.visit(str2, readConst(readUnsignedShort(i4), cArr2));
                    return i4 + 2;
                case 83:
                    AnnotationVisitor annotationVisitor5 = annotationVisitor2;
                    String str5 = str2;
                    Short sh2 = sh;
                    Short sh3 = new Short((short) readInt(this.f281a[readUnsignedShort(i4)]));
                    annotationVisitor5.visit(str5, sh2);
                    return i4 + 2;
                case 90:
                    annotationVisitor2.visit(str2, readInt(this.f281a[readUnsignedShort(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                    return i4 + 2;
                case 91:
                    int readUnsignedShort = readUnsignedShort(i4);
                    int i5 = i4 + 2;
                    if (readUnsignedShort == 0) {
                        return m67a(i5 - 2, cArr2, false, annotationVisitor2.visitArray(str2));
                    }
                    int i6 = i5 + 1;
                    switch (255 & this.f282b[i5]) {
                        case 66:
                            byte[] bArr = new byte[readUnsignedShort];
                            while (i3 < readUnsignedShort) {
                                bArr[i3] = (byte) readInt(this.f281a[readUnsignedShort(i6)]);
                                i6 += 3;
                                i3++;
                            }
                            annotationVisitor2.visit(str2, bArr);
                            return i6 - 1;
                        case 67:
                            char[] cArr3 = new char[readUnsignedShort];
                            while (i3 < readUnsignedShort) {
                                cArr3[i3] = (char) readInt(this.f281a[readUnsignedShort(i6)]);
                                i6 += 3;
                                i3++;
                            }
                            annotationVisitor2.visit(str2, cArr3);
                            return i6 - 1;
                        case 68:
                            double[] dArr = new double[readUnsignedShort];
                            while (i3 < readUnsignedShort) {
                                dArr[i3] = Double.longBitsToDouble(readLong(this.f281a[readUnsignedShort(i6)]));
                                i6 += 3;
                                i3++;
                            }
                            annotationVisitor2.visit(str2, dArr);
                            return i6 - 1;
                        case 70:
                            float[] fArr = new float[readUnsignedShort];
                            while (i3 < readUnsignedShort) {
                                fArr[i3] = Float.intBitsToFloat(readInt(this.f281a[readUnsignedShort(i6)]));
                                i6 += 3;
                                i3++;
                            }
                            annotationVisitor2.visit(str2, fArr);
                            return i6 - 1;
                        case 73:
                            int[] iArr = new int[readUnsignedShort];
                            while (i3 < readUnsignedShort) {
                                iArr[i3] = readInt(this.f281a[readUnsignedShort(i6)]);
                                i6 += 3;
                                i3++;
                            }
                            annotationVisitor2.visit(str2, iArr);
                            return i6 - 1;
                        case 74:
                            long[] jArr = new long[readUnsignedShort];
                            while (i3 < readUnsignedShort) {
                                jArr[i3] = readLong(this.f281a[readUnsignedShort(i6)]);
                                i6 += 3;
                                i3++;
                            }
                            annotationVisitor2.visit(str2, jArr);
                            return i6 - 1;
                        case 83:
                            short[] sArr = new short[readUnsignedShort];
                            while (i3 < readUnsignedShort) {
                                sArr[i3] = (short) readInt(this.f281a[readUnsignedShort(i6)]);
                                i6 += 3;
                                i3++;
                            }
                            annotationVisitor2.visit(str2, sArr);
                            return i6 - 1;
                        case 90:
                            boolean[] zArr = new boolean[readUnsignedShort];
                            int i7 = i6;
                            for (int i8 = 0; i8 < readUnsignedShort; i8++) {
                                zArr[i8] = readInt(this.f281a[readUnsignedShort(i7)]) != 0;
                                i7 += 3;
                            }
                            annotationVisitor2.visit(str2, zArr);
                            return i7 - 1;
                        default:
                            return m67a(i6 - 3, cArr2, false, annotationVisitor2.visitArray(str2));
                    }
                case 99:
                    annotationVisitor2.visit(str2, Type.getType(readUTF8(i4, cArr2)));
                    return i4 + 2;
                case 101:
                    annotationVisitor2.visitEnum(str2, readUTF8(i4, cArr2), readUTF8(i4 + 2, cArr2));
                    return i4 + 4;
                case 115:
                    annotationVisitor2.visit(str2, readUTF8(i4, cArr2));
                    return i4 + 2;
                default:
                    return i4;
            }
        }
    }

    /* renamed from: a */
    private int m67a(int i, char[] cArr, boolean z, AnnotationVisitor annotationVisitor) {
        int i2;
        int i3 = i;
        char[] cArr2 = cArr;
        boolean z2 = z;
        AnnotationVisitor annotationVisitor2 = annotationVisitor;
        int readUnsignedShort = readUnsignedShort(i3);
        int i4 = i3 + 2;
        if (z2) {
            i2 = i4;
            int i5 = readUnsignedShort;
            while (i5 > 0) {
                i5--;
                i2 = m66a(i2 + 2, cArr2, readUTF8(i2, cArr2), annotationVisitor2);
            }
        } else {
            int i6 = i4;
            int i7 = readUnsignedShort;
            while (i7 > 0) {
                i7--;
                i6 = m66a(i2, cArr2, (String) null, annotationVisitor2);
            }
        }
        if (annotationVisitor2 != null) {
            annotationVisitor2.visitEnd();
        }
        return i2;
    }

    /* renamed from: a */
    private int m68a(Object[] objArr, int i, int i2, char[] cArr, Label[] labelArr) {
        Object[] objArr2 = objArr;
        int i3 = i;
        int i4 = i2;
        char[] cArr2 = cArr;
        Label[] labelArr2 = labelArr;
        int i5 = i4 + 1;
        switch (255 & this.f282b[i4]) {
            case 0:
                objArr2[i3] = Opcodes.TOP;
                return i5;
            case 1:
                objArr2[i3] = Opcodes.INTEGER;
                return i5;
            case 2:
                objArr2[i3] = Opcodes.FLOAT;
                return i5;
            case 3:
                objArr2[i3] = Opcodes.DOUBLE;
                return i5;
            case 4:
                objArr2[i3] = Opcodes.LONG;
                return i5;
            case 5:
                objArr2[i3] = Opcodes.NULL;
                return i5;
            case 6:
                objArr2[i3] = Opcodes.UNINITIALIZED_THIS;
                return i5;
            case 7:
                objArr2[i3] = readClass(i5, cArr2);
                return i5 + 2;
            default:
                objArr2[i3] = readLabel(readUnsignedShort(i5), labelArr2);
                return i5 + 2;
        }
    }

    /* renamed from: a */
    private String m69a(int i, int i2, char[] cArr) {
        String str;
        int i3;
        int i4 = i;
        char[] cArr2 = cArr;
        int i5 = i4 + i2;
        byte[] bArr = this.f282b;
        int i6 = 0;
        boolean z = false;
        int i7 = 0;
        while (i4 < i5) {
            int i8 = i4 + 1;
            byte b = bArr[i4];
            switch (z) {
                case false:
                    byte b2 = b & 255;
                    if (b2 >= 128) {
                        if (b2 < 224 && b2 > 191) {
                            i6 = (char) (b2 & 31);
                            z = true;
                            i3 = i7;
                            break;
                        } else {
                            i6 = (char) (b2 & 15);
                            z = true;
                            i3 = i7;
                            break;
                        }
                    } else {
                        i3 = i7 + 1;
                        cArr2[i7] = (char) b2;
                        break;
                    }
                case true:
                    int i9 = i7 + 1;
                    cArr2[i7] = (char) ((i6 << 6) | (b & 63));
                    i3 = i9;
                    z = false;
                    break;
                case true:
                    i6 = (char) ((i6 << 6) | (b & 63));
                    z = true;
                    i3 = i7;
                    break;
                default:
                    i3 = i7;
                    break;
            }
            i7 = i3;
            i4 = i8;
        }
        String str2 = str;
        String str3 = new String(cArr2, 0, i7);
        return str2;
    }

    /* renamed from: a */
    private Attribute m70a(Attribute[] attributeArr, String str, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        Attribute attribute;
        Attribute[] attributeArr2 = attributeArr;
        String str2 = str;
        int i4 = i;
        int i5 = i2;
        char[] cArr2 = cArr;
        int i6 = i3;
        Label[] labelArr2 = labelArr;
        for (int i7 = 0; i7 < attributeArr2.length; i7++) {
            if (attributeArr2[i7].type.equals(str2)) {
                return attributeArr2[i7].read(this, i4, i5, cArr2, i6, labelArr2);
            }
        }
        Attribute attribute2 = attribute;
        Attribute attribute3 = new Attribute(str2);
        return attribute2.read(this, i4, i5, null, -1, null);
    }

    /* renamed from: a */
    private void m71a(int i, String str, char[] cArr, boolean z, MethodVisitor methodVisitor) {
        int i2 = i;
        String str2 = str;
        char[] cArr2 = cArr;
        boolean z2 = z;
        MethodVisitor methodVisitor2 = methodVisitor;
        int i3 = i2 + 1;
        byte b = 255 & this.f282b[i2];
        int length = Type.getArgumentTypes(str2).length - b;
        int i4 = 0;
        while (i4 < length) {
            AnnotationVisitor visitParameterAnnotation = methodVisitor2.visitParameterAnnotation(i4, "Ljava/lang/Synthetic;", false);
            if (visitParameterAnnotation != null) {
                visitParameterAnnotation.visitEnd();
            }
            i4++;
        }
        for (int i5 = i4; i5 < b + length; i5++) {
            i3 += 2;
            for (int readUnsignedShort = readUnsignedShort(i3); readUnsignedShort > 0; readUnsignedShort--) {
                i3 = m67a(i3 + 2, cArr2, true, methodVisitor2.visitParameterAnnotation(i5, readUTF8(i3, cArr2), z2));
            }
        }
    }

    /* renamed from: a */
    private void m72a(ClassWriter classWriter, Item[] itemArr, char[] cArr) {
        ByteVector byteVector;
        Item item;
        ClassWriter classWriter2 = classWriter;
        Item[] itemArr2 = itemArr;
        char[] cArr2 = cArr;
        int i = this.header;
        int readUnsignedShort = i + 8 + (readUnsignedShort(i + 6) << 1);
        int i2 = readUnsignedShort + 2;
        for (int readUnsignedShort2 = readUnsignedShort(readUnsignedShort); readUnsignedShort2 > 0; readUnsignedShort2--) {
            i2 += 8;
            for (int readUnsignedShort3 = readUnsignedShort(i2 + 6); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i2 += 6 + readInt(i2 + 2);
            }
        }
        int i3 = i2 + 2;
        for (int readUnsignedShort4 = readUnsignedShort(i2); readUnsignedShort4 > 0; readUnsignedShort4--) {
            i3 += 8;
            for (int readUnsignedShort5 = readUnsignedShort(i3 + 6); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i3 += 6 + readInt(i3 + 2);
            }
        }
        int readUnsignedShort6 = readUnsignedShort(i3);
        int i4 = i3 + 2;
        while (true) {
            int i5 = i4;
            if (readUnsignedShort6 > 0) {
                String readUTF8 = readUTF8(i5, cArr2);
                int readInt = readInt(i5 + 2);
                if ("BootstrapMethods".equals(readUTF8)) {
                    int readUnsignedShort7 = readUnsignedShort(i5 + 6);
                    int i6 = i5 + 8;
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 < readUnsignedShort7) {
                            int hashCode = readConst(readUnsignedShort(i6), cArr2).hashCode();
                            int i9 = i6 + 4;
                            for (int readUnsignedShort8 = readUnsignedShort(i6 + 2); readUnsignedShort8 > 0; readUnsignedShort8--) {
                                hashCode ^= readConst(readUnsignedShort(i9), cArr2).hashCode();
                                i9 += 2;
                            }
                            Item item2 = item;
                            Item item3 = new Item(i8);
                            Item item4 = item2;
                            item4.mo11183a(-8 + (i6 - i5), hashCode & IDirectInputDevice.DIPROPRANGE_NOMAX);
                            int length = item4.f363j % itemArr2.length;
                            item4.f364k = itemArr2[length];
                            itemArr2[length] = item4;
                            i6 = i9;
                            i7 = i8 + 1;
                        } else {
                            classWriter2.f323z = readUnsignedShort7;
                            ByteVector byteVector2 = byteVector;
                            ByteVector byteVector3 = new ByteVector(readInt + 62);
                            ByteVector byteVector4 = byteVector2;
                            ByteVector putByteArray = byteVector4.putByteArray(this.f282b, i5 + 8, readInt - 2);
                            classWriter2.f287A = byteVector4;
                            return;
                        }
                    }
                } else {
                    readUnsignedShort6--;
                    i4 = i5 + readInt + 6;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static byte[] m73a(InputStream inputStream, boolean z) throws IOException {
        byte[] bArr;
        int i;
        IOException iOException;
        InputStream inputStream2 = inputStream;
        boolean z2 = z;
        if (inputStream2 == null) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException("Class not found");
            throw iOException2;
        }
        try {
            byte[] bArr2 = new byte[inputStream2.available()];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int read = inputStream2.read(bArr2, i3, bArr2.length - i3);
                if (read == -1) {
                    if (i3 < bArr2.length) {
                        bArr = new byte[i3];
                        System.arraycopy(bArr2, 0, bArr, 0, i3);
                    } else {
                        bArr = bArr2;
                    }
                    if (z2) {
                        inputStream2.close();
                    }
                    return bArr;
                }
                int i4 = i3 + read;
                if (i4 == bArr2.length) {
                    int read2 = inputStream2.read();
                    if (read2 < 0) {
                        if (z2) {
                            inputStream2.close();
                        }
                        return bArr2;
                    }
                    byte[] bArr3 = new byte[(1000 + bArr2.length)];
                    System.arraycopy(bArr2, 0, bArr3, 0, i4);
                    i = i4 + 1;
                    bArr3[i4] = (byte) read2;
                    bArr2 = bArr3;
                } else {
                    i = i4;
                }
                i2 = i;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (z2) {
                inputStream2.close();
            }
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11118a(ClassWriter classWriter) {
        Item item;
        int i;
        ClassWriter classWriter2 = classWriter;
        char[] cArr = new char[this.f284d];
        int length = this.f281a.length;
        Item[] itemArr = new Item[length];
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 < length) {
                int i4 = this.f281a[i3];
                byte b = this.f282b[i4 - 1];
                Item item2 = item;
                Item item3 = new Item(i3);
                Item item4 = item2;
                switch (b) {
                    case 1:
                        String str = this.f283c[i3];
                        if (str == null) {
                            int i5 = this.f281a[i3];
                            String[] strArr = this.f283c;
                            str = m69a(i5 + 2, readUnsignedShort(i5), cArr);
                            strArr[i3] = str;
                        }
                        item4.mo11184a(b, str, null, null);
                        i = i3;
                        break;
                    case 3:
                        item4.mo11182a(readInt(i4));
                        i = i3;
                        break;
                    case 4:
                        item4.mo11181a(Float.intBitsToFloat(readInt(i4)));
                        i = i3;
                        break;
                    case 5:
                        item4.mo11185a(readLong(i4));
                        i = i3 + 1;
                        break;
                    case 6:
                        item4.mo11180a(Double.longBitsToDouble(readLong(i4)));
                        i = i3 + 1;
                        break;
                    case 9:
                    case 10:
                    case 11:
                        int i6 = this.f281a[readUnsignedShort(i4 + 2)];
                        item4.mo11184a(b, readClass(i4, cArr), readUTF8(i6, cArr), readUTF8(i6 + 2, cArr));
                        i = i3;
                        break;
                    case 12:
                        item4.mo11184a(b, readUTF8(i4, cArr), readUTF8(i4 + 2, cArr), null);
                        i = i3;
                        break;
                    case 15:
                        int i7 = this.f281a[readUnsignedShort(i4 + 1)];
                        int i8 = this.f281a[readUnsignedShort(i7 + 2)];
                        item4.mo11184a(20 + readByte(i4), readClass(i7, cArr), readUTF8(i8, cArr), readUTF8(i8 + 2, cArr));
                        i = i3;
                        break;
                    case 18:
                        if (classWriter2.f287A == null) {
                            m72a(classWriter2, itemArr, cArr);
                        }
                        int i9 = this.f281a[readUnsignedShort(i4 + 2)];
                        item4.mo11186a(readUTF8(i9, cArr), readUTF8(i9 + 2, cArr), readUnsignedShort(i4));
                        i = i3;
                        break;
                    default:
                        item4.mo11184a(b, readUTF8(i4, cArr), null, null);
                        i = i3;
                        break;
                }
                int i10 = i;
                int length2 = item4.f363j % itemArr.length;
                item4.f364k = itemArr[length2];
                itemArr[length2] = item4;
                i2 = i10 + 1;
            } else {
                int i11 = -1 + this.f281a[1];
                ByteVector putByteArray = classWriter2.f301d.putByteArray(this.f282b, i11, this.header - i11);
                classWriter2.f302e = itemArr;
                classWriter2.f303f = (int) (0.75d * ((double) length));
                classWriter2.f300c = length;
                return;
            }
        }
    }

    public void accept(ClassVisitor classVisitor, int i) {
        accept(classVisitor, new Attribute[0], i);
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: org.objectweb.asm.ClassReader.accept(org.objectweb.asm.ClassVisitor, org.objectweb.asm.Attribute[], int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
        	at jadx.core.ProcessClass.process(ProcessClass.java:27)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
        Caused by: java.lang.NullPointerException
        	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:391)
        	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:363)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:129)
        	... 9 more
        */
    public void accept(org.objectweb.asm.ClassVisitor r1, org.objectweb.asm.Attribute[] r2, int r3) {
        /*
            r0 = this;
            r3 = r373
            r4 = r374
            r5 = r375
            r6 = r376
            r365 = r3
            r0 = r365
            byte[] r0 = r0.f282b
            r365 = r0
            r7 = r365
            r365 = r3
            r0 = r365
            int r0 = r0.f284d
            r365 = r0
            r0 = r365
            char[] r0 = new char[r0]
            r365 = r0
            r8 = r365
            r0 = 0
            r365 = r0
            r9 = r365
            r0 = 0
            r365 = r0
            r10 = r365
            r0 = 0
            r365 = r0
            r11 = r365
            r365 = r3
            r0 = r365
            int r0 = r0.header
            r365 = r0
            r12 = r365
            r365 = r3
            r366 = r12
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r13 = r365
            r365 = r3
            r366 = r12
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readClass(r366, r367)
            r365 = r0
            r14 = r365
            r365 = r3
            r0 = r365
            int[] r0 = r0.f281a
            r365 = r0
            r366 = r3
            r367 = r12
            r0 = 4
            r368 = r0
            r0 = r367
            int r0 = r0 + 4
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r15 = r365
            r365 = r15
            r0 = r365
            if (r0 != 0) goto L_0x0137
            r0 = 0
            r365 = r0
            r16 = r365
        L_0x00ab:
            r365 = r3
            r366 = r12
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r0 = r365
            java.lang.String[] r0 = new java.lang.String[r0]
            r365 = r0
            r17 = r365
            r0 = 0
            r365 = r0
            r18 = r365
            r365 = r12
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r19 = r365
            r0 = 0
            r365 = r0
            r20 = r365
            r365 = r19
            r21 = r365
        L_0x00ee:
            r365 = r20
            r366 = r17
            r0 = r366
            int r0 = r0.length
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x014b
            r365 = r17
            r366 = r20
            r367 = r3
            r368 = r21
            r369 = r8
            java.lang.String r0 = r367.readClass(r368, r369)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r21
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r364 = r365
            int r20 = r20 + 1
            r365 = r364
            r21 = r365
            goto L_0x00ee
        L_0x0137:
            r365 = r3
            r366 = r15
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r16 = r365
            goto L_0x00ab
        L_0x014b:
            r365 = r6
            r0 = 1
            r366 = r0
            r0 = r365
            r0 = r0 & 1
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x021c
            r0 = 1
            r365 = r0
            r22 = r365
        L_0x0163:
            r365 = r6
            r0 = 2
            r366 = r0
            r0 = r365
            r0 = r0 & 2
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0224
            r0 = 1
            r365 = r0
            r23 = r365
        L_0x017b:
            r365 = r6
            r0 = 8
            r366 = r0
            r0 = r365
            r0 = r0 & 8
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x022c
            r0 = 1
            r365 = r0
            r24 = r365
        L_0x0194:
            r365 = r3
            r366 = r21
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r25 = r365
            r365 = r21
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r26 = r365
            r365 = r25
            r27 = r365
        L_0x01b8:
            r365 = r27
            r0 = r365
            if (r0 <= 0) goto L_0x0237
            r365 = r3
            r366 = r26
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r363 = r365
            int r26 = r26 + 8
        L_0x01dc:
            r365 = r363
            r0 = r365
            if (r0 <= 0) goto L_0x0234
            r365 = r26
            r0 = 6
            r366 = r0
            r367 = r3
            r368 = r26
            r0 = 2
            r369 = r0
            r0 = r368
            int r0 = r0 + 2
            r368 = r0
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r26 = r365
            r0 = r363
            int r0 = r0 + -1
            r363 = r0
            goto L_0x01dc
        L_0x021c:
            r0 = 0
            r365 = r0
            r22 = r365
            goto L_0x0163
        L_0x0224:
            r0 = 0
            r365 = r0
            r23 = r365
            goto L_0x017b
        L_0x022c:
            r0 = 0
            r365 = r0
            r24 = r365
            goto L_0x0194
        L_0x0234:
            int r27 = r27 + -1
            goto L_0x01b8
        L_0x0237:
            r365 = r3
            r366 = r26
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r28 = r365
            r365 = r26
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r29 = r365
            r365 = r28
            r30 = r365
        L_0x025b:
            r365 = r30
            r0 = r365
            if (r0 <= 0) goto L_0x02c2
            r365 = r3
            r366 = r29
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r362 = r365
            int r29 = r29 + 8
        L_0x027f:
            r365 = r362
            r0 = r365
            if (r0 <= 0) goto L_0x02bf
            r365 = r29
            r0 = 6
            r366 = r0
            r367 = r3
            r368 = r29
            r0 = 2
            r369 = r0
            r0 = r368
            int r0 = r0 + 2
            r368 = r0
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r29 = r365
            r0 = r362
            int r0 = r0 + -1
            r362 = r0
            goto L_0x027f
        L_0x02bf:
            int r30 = r30 + -1
            goto L_0x025b
        L_0x02c2:
            r0 = 0
            r365 = r0
            r31 = r365
            r0 = 0
            r365 = r0
            r32 = r365
            r0 = 0
            r365 = r0
            r33 = r365
            r0 = 0
            r365 = r0
            r34 = r365
            r0 = 0
            r365 = r0
            r35 = r365
            r0 = 0
            r365 = r0
            r36 = r365
            r0 = 0
            r365 = r0
            r37 = r365
            r365 = r3
            r366 = r29
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r38 = r365
            r365 = r29
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r39 = r365
            r365 = r38
            r40 = r365
            r365 = r39
            r41 = r365
        L_0x0315:
            r365 = r40
            r0 = r365
            if (r0 <= 0) goto L_0x0979
            r365 = r3
            r366 = r41
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r335 = r365
            java.lang.String r0 = "SourceFile"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x041d
            r365 = r3
            r366 = r41
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r361 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r361
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r37
            r337 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
        L_0x039c:
            r365 = r41
            r0 = 6
            r366 = r0
            r367 = r3
            r368 = r41
            r0 = 2
            r369 = r0
            r0 = r368
            int r0 = r0 + 2
            r368 = r0
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r347 = r365
            r365 = r40
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + -1
            r365 = r0
            r348 = r365
            r365 = r337
            r37 = r365
            r365 = r348
            r40 = r365
            r365 = r343
            r18 = r365
            r365 = r347
            r41 = r365
            r365 = r344
            r11 = r365
            r365 = r345
            r10 = r365
            r365 = r346
            r9 = r365
            r365 = r339
            r35 = r365
            r365 = r340
            r34 = r365
            r365 = r341
            r33 = r365
            r365 = r342
            r32 = r365
            r365 = r338
            r36 = r365
            goto L_0x0315
        L_0x041d:
            java.lang.String r0 = "InnerClasses"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x047f
            r365 = r41
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r360 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r360
            r343 = r365
            r365 = r37
            r337 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            goto L_0x039c
        L_0x047f:
            java.lang.String r0 = "EnclosingMethod"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0569
            r365 = r3
            r366 = r41
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readClass(r366, r367)
            r365 = r0
            r356 = r365
            r365 = r3
            r366 = r41
            r0 = 8
            r367 = r0
            r0 = r366
            int r0 = r0 + 8
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r357 = r365
            r365 = r357
            r0 = r365
            if (r0 == 0) goto L_0x37c7
            r365 = r3
            r366 = r3
            r0 = r366
            int[] r0 = r0.f281a
            r366 = r0
            r367 = r357
            r0 = r366
            r1 = r367
            r0 = r0[r1]
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r359 = r365
            r365 = r3
            r0 = 2
            r366 = r0
            r367 = r3
            r0 = r367
            int[] r0 = r0.f281a
            r367 = r0
            r368 = r357
            r0 = r367
            r1 = r368
            r0 = r0[r1]
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r358 = r365
            r365 = r356
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            r365 = r359
            r339 = r365
            r365 = r358
            r338 = r365
            r365 = r37
            r337 = r365
            goto L_0x039c
        L_0x0569:
            java.lang.String r0 = "Signature"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x05d7
            r365 = r3
            r366 = r41
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r31 = r365
            r365 = r37
            r337 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            goto L_0x039c
        L_0x05d7:
            java.lang.String r0 = "RuntimeVisibleAnnotations"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0639
            r365 = r41
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r355 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r355
            r346 = r365
            r365 = r37
            r337 = r365
            goto L_0x039c
        L_0x0639:
            java.lang.String r0 = "Deprecated"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x069c
            r365 = r13
            r0 = 131072(0x20000, float:1.83671E-40)
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0 | r1
            r365 = r0
            r13 = r365
            r365 = r37
            r337 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            goto L_0x039c
        L_0x069c:
            java.lang.String r0 = "Synthetic"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0700
            r365 = r13
            r0 = 266240(0x41000, float:3.73082E-40)
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0 | r1
            r365 = r0
            r13 = r365
            r365 = r37
            r337 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            goto L_0x039c
        L_0x0700:
            java.lang.String r0 = "SourceDebugExtension"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0794
            r365 = r3
            r366 = r41
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r353 = r365
            r365 = r3
            r366 = r41
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            r367 = r353
            r368 = r353
            r0 = r368
            char[] r0 = new char[r0]
            r368 = r0
            java.lang.String r0 = r365.m69a(r366, r367, r368)
            r365 = r0
            r354 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r354
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r37
            r337 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            goto L_0x039c
        L_0x0794:
            java.lang.String r0 = "RuntimeInvisibleAnnotations"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x07f6
            r365 = r41
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r352 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r11
            r344 = r365
            r365 = r352
            r345 = r365
            r365 = r9
            r346 = r365
            r365 = r37
            r337 = r365
            goto L_0x039c
        L_0x07f6:
            java.lang.String r0 = "BootstrapMethods"
            r365 = r0
            r366 = r335
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x08e4
            r365 = r3
            r366 = r41
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r349 = r365
            r365 = r349
            r0 = r365
            int[] r0 = new int[r0]
            r365 = r0
            r337 = r365
            r365 = r41
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r350 = r365
            r0 = 0
            r365 = r0
            r351 = r365
        L_0x084a:
            r365 = r351
            r366 = r349
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x08ac
            r365 = r337
            r366 = r351
            r367 = r350
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r350
            r0 = 2
            r366 = r0
            r367 = r3
            r368 = r350
            r0 = 2
            r369 = r0
            r0 = r368
            int r0 = r0 + 2
            r368 = r0
            int r0 = r367.readUnsignedShort(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r0 = 1
            r367 = r0
            r0 = r366
            int r0 = r0 << 1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r350 = r365
            r0 = r351
            int r0 = r0 + 1
            r351 = r0
            goto L_0x084a
        L_0x08ac:
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            goto L_0x039c
        L_0x08e4:
            r365 = r3
            r366 = r5
            r367 = r335
            r368 = r41
            r0 = 6
            r369 = r0
            r0 = r368
            int r0 = r0 + 6
            r368 = r0
            r369 = r3
            r370 = r41
            r0 = 2
            r371 = r0
            r0 = r370
            int r0 = r0 + 2
            r370 = r0
            int r0 = r369.readInt(r370)
            r369 = r0
            r370 = r8
            r0 = -1
            r371 = r0
            r0 = 0
            r372 = r0
            org.objectweb.asm.Attribute r0 = r365.m70a(r366, r367, r368, r369, r370, r371, r372)
            r365 = r0
            r336 = r365
            r365 = r336
            r0 = r365
            if (r0 == 0) goto L_0x3789
            r365 = r336
            r366 = r11
            r0 = r366
            r1 = r365
            r1.f277a = r0
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r336
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            r365 = r37
            r337 = r365
            goto L_0x039c
        L_0x0979:
            r365 = r4
            r366 = r3
            r0 = 4
            r367 = r0
            int r0 = r366.readInt(r367)
            r366 = r0
            r367 = r13
            r368 = r14
            r369 = r31
            r370 = r16
            r371 = r17
            r365.visit(r366, r367, r368, r369, r370, r371)
            r365 = r23
            r0 = r365
            if (r0 != 0) goto L_0x09bd
            r365 = r32
            r0 = r365
            if (r0 != 0) goto L_0x09b1
            r365 = r33
            r0 = r365
            if (r0 == 0) goto L_0x09bd
        L_0x09b1:
            r365 = r4
            r366 = r32
            r367 = r33
            r365.visitSource(r366, r367)
        L_0x09bd:
            r365 = r34
            r0 = r365
            if (r0 == 0) goto L_0x09d3
            r365 = r4
            r366 = r34
            r367 = r35
            r368 = r36
            r365.visitOuterClass(r366, r367, r368)
        L_0x09d3:
            r0 = 1
            r365 = r0
            r42 = r365
        L_0x09d9:
            r365 = r42
            r0 = r365
            if (r0 < 0) goto L_0x0a9d
            r365 = r42
            r0 = r365
            if (r0 != 0) goto L_0x0a89
            r365 = r10
            r327 = r365
        L_0x09ed:
            r365 = r327
            r0 = r365
            if (r0 == 0) goto L_0x0a99
            r365 = r3
            r366 = r327
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r328 = r365
            r365 = r327
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r329 = r365
            r365 = r328
            r330 = r365
        L_0x0a1b:
            r365 = r330
            r0 = r365
            if (r0 <= 0) goto L_0x0a99
            r365 = r329
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r331 = r365
            r365 = r3
            r366 = r329
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r332 = r365
            r365 = r42
            r0 = r365
            if (r0 == 0) goto L_0x0a91
            r0 = 1
            r365 = r0
            r333 = r365
        L_0x0a54:
            r365 = r3
            r366 = r331
            r367 = r8
            r0 = 1
            r368 = r0
            r369 = r4
            r370 = r332
            r371 = r333
            org.objectweb.asm.AnnotationVisitor r0 = r369.visitAnnotation(r370, r371)
            r369 = r0
            int r0 = r365.m67a(r366, r367, r368, r369)
            r365 = r0
            r334 = r365
            r0 = r330
            int r0 = r0 + -1
            r330 = r0
            r365 = r334
            r329 = r365
            goto L_0x0a1b
        L_0x0a89:
            r365 = r9
            r327 = r365
            goto L_0x09ed
        L_0x0a91:
            r0 = 0
            r365 = r0
            r333 = r365
            goto L_0x0a54
        L_0x0a99:
            int r42 = r42 + -1
            goto L_0x09d9
        L_0x0a9d:
            r365 = r11
            r0 = r365
            if (r0 == 0) goto L_0x0acd
            r365 = r11
            r0 = r365
            org.objectweb.asm.Attribute r0 = r0.f277a
            r365 = r0
            r326 = r365
            r365 = r11
            r0 = 0
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f277a = r0
            r365 = r4
            r366 = r11
            r365.visitAttribute(r366)
            r365 = r326
            r11 = r365
            goto L_0x0a9d
        L_0x0acd:
            r365 = r18
            r0 = r365
            if (r0 == 0) goto L_0x0c03
            r365 = r3
            r366 = r18
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r318 = r365
            r365 = r18
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r319 = r365
            r365 = r318
            r320 = r365
            r365 = r319
            r321 = r365
        L_0x0b01:
            r365 = r320
            r0 = r365
            if (r0 <= 0) goto L_0x0c03
            r365 = r3
            r366 = r321
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x0bae
            r0 = 0
            r365 = r0
            r322 = r365
        L_0x0b20:
            r365 = r3
            r366 = r321
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x0bc3
            r0 = 0
            r365 = r0
            r323 = r365
        L_0x0b43:
            r365 = r3
            r366 = r321
            r0 = 4
            r367 = r0
            r0 = r366
            int r0 = r0 + 4
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x0be3
            r0 = 0
            r365 = r0
            r324 = r365
        L_0x0b66:
            r365 = r4
            r366 = r322
            r367 = r323
            r368 = r324
            r369 = r3
            r370 = r321
            r0 = 6
            r371 = r0
            r0 = r370
            int r0 = r0 + 6
            r370 = r0
            int r0 = r369.readUnsignedShort(r370)
            r369 = r0
            r365.visitInnerClass(r366, r367, r368, r369)
            r365 = r321
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r325 = r365
            r0 = r320
            int r0 = r0 + -1
            r320 = r0
            r365 = r325
            r321 = r365
            goto L_0x0b01
        L_0x0bae:
            r365 = r3
            r366 = r321
            r367 = r8
            java.lang.String r0 = r365.readClass(r366, r367)
            r365 = r0
            r322 = r365
            goto L_0x0b20
        L_0x0bc3:
            r365 = r3
            r366 = r321
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readClass(r366, r367)
            r365 = r0
            r323 = r365
            goto L_0x0b43
        L_0x0be3:
            r365 = r3
            r366 = r321
            r0 = 4
            r367 = r0
            r0 = r366
            int r0 = r0 + 4
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r324 = r365
            goto L_0x0b66
        L_0x0c03:
            r365 = r3
            r366 = r21
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r43 = r365
            r365 = r21
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r44 = r365
            r365 = r43
            r45 = r365
        L_0x0c27:
            r365 = r45
            r0 = r365
            if (r0 <= 0) goto L_0x10c5
            r365 = r3
            r366 = r44
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r284 = r365
            r365 = r3
            r366 = r44
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r285 = r365
            r365 = r3
            r366 = r44
            r0 = 4
            r367 = r0
            r0 = r366
            int r0 = r0 + 4
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r286 = r365
            r0 = 0
            r365 = r0
            r287 = r365
            r0 = 0
            r365 = r0
            r288 = r365
            r0 = 0
            r365 = r0
            r289 = r365
            r0 = 0
            r365 = r0
            r290 = r365
            r0 = 0
            r365 = r0
            r291 = r365
            r365 = r3
            r366 = r44
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r292 = r365
            r365 = r44
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r293 = r365
            r365 = r292
            r294 = r365
            r365 = r293
            r44 = r365
        L_0x0cd5:
            r365 = r294
            r0 = r365
            if (r0 <= 0) goto L_0x0f74
            r365 = r3
            r366 = r44
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r307 = r365
            java.lang.String r0 = "ConstantValue"
            r365 = r0
            r366 = r307
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0da3
            r365 = r3
            r366 = r44
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r309 = r365
            r365 = r284
            r310 = r365
            r365 = r291
            r311 = r365
            r365 = r290
            r312 = r365
            r365 = r289
            r313 = r365
        L_0x0d35:
            r365 = r44
            r0 = 6
            r366 = r0
            r367 = r3
            r368 = r44
            r0 = 2
            r369 = r0
            r0 = r368
            int r0 = r0 + 2
            r368 = r0
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r314 = r365
            r365 = r294
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + -1
            r365 = r0
            r315 = r365
            r365 = r309
            r287 = r365
            r365 = r315
            r294 = r365
            r365 = r310
            r284 = r365
            r365 = r314
            r44 = r365
            r365 = r311
            r291 = r365
            r365 = r312
            r290 = r365
            r365 = r313
            r289 = r365
            goto L_0x0cd5
        L_0x0da3:
            java.lang.String r0 = "Signature"
            r365 = r0
            r366 = r307
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0df4
            r365 = r3
            r366 = r44
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r288 = r365
            r365 = r287
            r309 = r365
            r365 = r284
            r310 = r365
            r365 = r291
            r311 = r365
            r365 = r290
            r312 = r365
            r365 = r289
            r313 = r365
            goto L_0x0d35
        L_0x0df4:
            java.lang.String r0 = "Deprecated"
            r365 = r0
            r366 = r307
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0e34
            r0 = 131072(0x20000, float:1.83671E-40)
            r365 = r0
            r366 = r284
            r0 = r365
            r1 = r366
            r0 = r0 | r1
            r365 = r0
            r310 = r365
            r365 = r291
            r311 = r365
            r365 = r290
            r312 = r365
            r365 = r289
            r313 = r365
            r365 = r287
            r309 = r365
            goto L_0x0d35
        L_0x0e34:
            java.lang.String r0 = "Synthetic"
            r365 = r0
            r366 = r307
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0e75
            r0 = 266240(0x41000, float:3.73082E-40)
            r365 = r0
            r366 = r284
            r0 = r365
            r1 = r366
            r0 = r0 | r1
            r365 = r0
            r310 = r365
            r365 = r291
            r311 = r365
            r365 = r290
            r312 = r365
            r365 = r289
            r313 = r365
            r365 = r287
            r309 = r365
            goto L_0x0d35
        L_0x0e75:
            java.lang.String r0 = "RuntimeVisibleAnnotations"
            r365 = r0
            r366 = r307
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0eb9
            r365 = r44
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r317 = r365
            r365 = r284
            r310 = r365
            r365 = r291
            r311 = r365
            r365 = r290
            r312 = r365
            r365 = r317
            r313 = r365
            r365 = r287
            r309 = r365
            goto L_0x0d35
        L_0x0eb9:
            java.lang.String r0 = "RuntimeInvisibleAnnotations"
            r365 = r0
            r366 = r307
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x0efd
            r365 = r44
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r316 = r365
            r365 = r284
            r310 = r365
            r365 = r291
            r311 = r365
            r365 = r316
            r312 = r365
            r365 = r289
            r313 = r365
            r365 = r287
            r309 = r365
            goto L_0x0d35
        L_0x0efd:
            r365 = r3
            r366 = r5
            r367 = r307
            r368 = r44
            r0 = 6
            r369 = r0
            r0 = r368
            int r0 = r0 + 6
            r368 = r0
            r369 = r3
            r370 = r44
            r0 = 2
            r371 = r0
            r0 = r370
            int r0 = r0 + 2
            r370 = r0
            int r0 = r369.readInt(r370)
            r369 = r0
            r370 = r8
            r0 = -1
            r371 = r0
            r0 = 0
            r372 = r0
            org.objectweb.asm.Attribute r0 = r365.m70a(r366, r367, r368, r369, r370, r371, r372)
            r365 = r0
            r308 = r365
            r365 = r308
            r0 = r365
            if (r0 == 0) goto L_0x3769
            r365 = r308
            r366 = r291
            r0 = r366
            r1 = r365
            r1.f277a = r0
            r365 = r284
            r310 = r365
            r365 = r308
            r311 = r365
            r365 = r290
            r312 = r365
            r365 = r289
            r313 = r365
            r365 = r287
            r309 = r365
            goto L_0x0d35
        L_0x0f74:
            r365 = r287
            r0 = r365
            if (r0 != 0) goto L_0x105c
            r0 = 0
            r365 = r0
            r295 = r365
        L_0x0f82:
            r365 = r4
            r366 = r284
            r367 = r285
            r368 = r286
            r369 = r288
            r370 = r295
            org.objectweb.asm.FieldVisitor r0 = r365.visitField(r366, r367, r368, r369, r370)
            r365 = r0
            r296 = r365
            r365 = r296
            r0 = r365
            if (r0 == 0) goto L_0x10c1
            r0 = 1
            r365 = r0
            r297 = r365
        L_0x0fac:
            r365 = r297
            r0 = r365
            if (r0 < 0) goto L_0x108a
            r365 = r297
            r0 = r365
            if (r0 != 0) goto L_0x1071
            r365 = r290
            r299 = r365
        L_0x0fc0:
            r365 = r299
            r0 = r365
            if (r0 == 0) goto L_0x1081
            r365 = r3
            r366 = r299
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r300 = r365
            r365 = r299
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r301 = r365
            r365 = r300
            r302 = r365
        L_0x0fee:
            r365 = r302
            r0 = r365
            if (r0 <= 0) goto L_0x1081
            r365 = r301
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r303 = r365
            r365 = r3
            r366 = r301
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r304 = r365
            r365 = r297
            r0 = r365
            if (r0 == 0) goto L_0x1079
            r0 = 1
            r365 = r0
            r305 = r365
        L_0x1027:
            r365 = r3
            r366 = r303
            r367 = r8
            r0 = 1
            r368 = r0
            r369 = r296
            r370 = r304
            r371 = r305
            org.objectweb.asm.AnnotationVisitor r0 = r369.visitAnnotation(r370, r371)
            r369 = r0
            int r0 = r365.m67a(r366, r367, r368, r369)
            r365 = r0
            r306 = r365
            r0 = r302
            int r0 = r0 + -1
            r302 = r0
            r365 = r306
            r301 = r365
            goto L_0x0fee
        L_0x105c:
            r365 = r3
            r366 = r287
            r367 = r8
            java.lang.Object r0 = r365.readConst(r366, r367)
            r365 = r0
            r295 = r365
            goto L_0x0f82
        L_0x1071:
            r365 = r289
            r299 = r365
            goto L_0x0fc0
        L_0x1079:
            r0 = 0
            r365 = r0
            r305 = r365
            goto L_0x1027
        L_0x1081:
            r0 = r297
            int r0 = r0 + -1
            r297 = r0
            goto L_0x0fac
        L_0x108a:
            r365 = r291
            r0 = r365
            if (r0 == 0) goto L_0x10bb
            r365 = r291
            r0 = r365
            org.objectweb.asm.Attribute r0 = r0.f277a
            r365 = r0
            r298 = r365
            r365 = r291
            r0 = 0
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f277a = r0
            r365 = r296
            r366 = r291
            r365.visitAttribute(r366)
            r365 = r298
            r291 = r365
            goto L_0x108a
        L_0x10bb:
            r365 = r296
            r365.visitEnd()
        L_0x10c1:
            int r45 = r45 + -1
            goto L_0x0c27
        L_0x10c5:
            r365 = r3
            r366 = r44
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r46 = r365
            r365 = r44
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r47 = r365
            r365 = r46
            r48 = r365
        L_0x10e9:
            r365 = r48
            r0 = r365
            if (r0 <= 0) goto L_0x3669
            r365 = r47
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r49 = r365
            r365 = r3
            r366 = r47
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r50 = r365
            r365 = r3
            r366 = r47
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r51 = r365
            r365 = r3
            r366 = r47
            r0 = 4
            r367 = r0
            r0 = r366
            int r0 = r0 + 4
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r52 = r365
            r0 = 0
            r365 = r0
            r53 = r365
            r0 = 0
            r365 = r0
            r54 = r365
            r0 = 0
            r365 = r0
            r55 = r365
            r0 = 0
            r365 = r0
            r56 = r365
            r0 = 0
            r365 = r0
            r57 = r365
            r0 = 0
            r365 = r0
            r58 = r365
            r0 = 0
            r365 = r0
            r59 = r365
            r0 = 0
            r365 = r0
            r60 = r365
            r0 = 0
            r365 = r0
            r61 = r365
            r365 = r3
            r366 = r47
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r62 = r365
            r365 = r47
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r63 = r365
            r365 = r62
            r64 = r365
            r365 = r63
            r47 = r365
        L_0x11b4:
            r365 = r64
            r0 = r365
            if (r0 <= 0) goto L_0x15e2
            r365 = r3
            r366 = r47
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r267 = r365
            r365 = r3
            r366 = r47
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r268 = r365
            r365 = r47
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r269 = r365
            java.lang.String r0 = "Code"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x1291
            r365 = r22
            r0 = r365
            if (r0 != 0) goto L_0x3731
            r365 = r58
            r271 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r269
            r275 = r365
            r365 = r50
            r276 = r365
            r365 = r59
            r277 = r365
            r365 = r55
            r278 = r365
            r365 = r54
            r279 = r365
        L_0x124a:
            r365 = r268
            r366 = r269
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r280 = r365
            int r64 = r64 + -1
            r365 = r275
            r60 = r365
            r365 = r276
            r50 = r365
            r365 = r280
            r47 = r365
            r365 = r277
            r59 = r365
            r365 = r278
            r55 = r365
            r365 = r279
            r54 = r365
            r365 = r271
            r58 = r365
            r365 = r274
            r61 = r365
            r365 = r272
            r57 = r365
            r365 = r273
            r56 = r365
            goto L_0x11b4
        L_0x1291:
            java.lang.String r0 = "Exceptions"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x12dc
            r365 = r58
            r271 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r269
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r50
            r276 = r365
            r365 = r59
            r277 = r365
            r365 = r55
            r278 = r365
            r365 = r54
            r279 = r365
            goto L_0x124a
        L_0x12dc:
            java.lang.String r0 = "Signature"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x1339
            r365 = r3
            r366 = r269
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r53 = r365
            r365 = r58
            r271 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r50
            r276 = r365
            r365 = r59
            r277 = r365
            r365 = r55
            r278 = r365
            r365 = r54
            r279 = r365
            goto L_0x124a
        L_0x1339:
            java.lang.String r0 = "Deprecated"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x1397
            r0 = 131072(0x20000, float:1.83671E-40)
            r365 = r0
            r366 = r50
            r0 = r365
            r1 = r366
            r0 = r0 | r1
            r365 = r0
            r283 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r283
            r276 = r365
            r365 = r55
            r278 = r365
            r365 = r54
            r279 = r365
            r365 = r58
            r271 = r365
            r365 = r59
            r277 = r365
            goto L_0x124a
        L_0x1397:
            java.lang.String r0 = "RuntimeVisibleAnnotations"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x13e2
            r365 = r58
            r271 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r50
            r276 = r365
            r365 = r59
            r277 = r365
            r365 = r55
            r278 = r365
            r365 = r269
            r279 = r365
            goto L_0x124a
        L_0x13e2:
            java.lang.String r0 = "AnnotationDefault"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x142d
            r365 = r58
            r271 = r365
            r365 = r57
            r272 = r365
            r365 = r269
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r54
            r279 = r365
            r365 = r59
            r277 = r365
            r365 = r55
            r278 = r365
            r365 = r50
            r276 = r365
            goto L_0x124a
        L_0x142d:
            java.lang.String r0 = "Synthetic"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x148c
            r0 = 266240(0x41000, float:3.73082E-40)
            r365 = r0
            r366 = r50
            r0 = r365
            r1 = r366
            r0 = r0 | r1
            r365 = r0
            r282 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r282
            r276 = r365
            r365 = r55
            r278 = r365
            r365 = r54
            r279 = r365
            r365 = r58
            r271 = r365
            r365 = r59
            r277 = r365
            goto L_0x124a
        L_0x148c:
            java.lang.String r0 = "RuntimeInvisibleAnnotations"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x14d7
            r365 = r58
            r271 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r50
            r276 = r365
            r365 = r59
            r277 = r365
            r365 = r269
            r278 = r365
            r365 = r54
            r279 = r365
            goto L_0x124a
        L_0x14d7:
            java.lang.String r0 = "RuntimeVisibleParameterAnnotations"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x1522
            r365 = r58
            r271 = r365
            r365 = r269
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r55
            r278 = r365
            r365 = r59
            r277 = r365
            r365 = r50
            r276 = r365
            r365 = r54
            r279 = r365
            goto L_0x124a
        L_0x1522:
            java.lang.String r0 = "RuntimeInvisibleParameterAnnotations"
            r365 = r0
            r366 = r267
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x156d
            r365 = r269
            r271 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r59
            r277 = r365
            r365 = r50
            r276 = r365
            r365 = r55
            r278 = r365
            r365 = r54
            r279 = r365
            goto L_0x124a
        L_0x156d:
            r365 = r3
            r366 = r5
            r367 = r267
            r368 = r269
            r369 = r268
            r370 = r8
            r0 = -1
            r371 = r0
            r0 = 0
            r372 = r0
            org.objectweb.asm.Attribute r0 = r365.m70a(r366, r367, r368, r369, r370, r371, r372)
            r365 = r0
            r270 = r365
            r365 = r270
            r0 = r365
            if (r0 == 0) goto L_0x3731
            r365 = r270
            r366 = r59
            r0 = r366
            r1 = r365
            r1.f277a = r0
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r50
            r276 = r365
            r365 = r55
            r278 = r365
            r365 = r54
            r279 = r365
            r365 = r58
            r281 = r365
            r365 = r270
            r277 = r365
            r365 = r281
            r271 = r365
            goto L_0x124a
        L_0x15e2:
            r365 = r61
            r0 = r365
            if (r0 != 0) goto L_0x16a8
            r365 = r61
            r66 = r365
            r0 = 0
            r365 = r0
            r68 = r365
            r365 = r4
            r366 = r50
            r367 = r51
            r368 = r52
            r369 = r53
            r370 = r68
            org.objectweb.asm.MethodVisitor r0 = r365.visitMethod(r366, r367, r368, r369, r370)
            r365 = r0
            r69 = r365
            r365 = r69
            r0 = r365
            if (r0 == 0) goto L_0x190d
            r365 = r69
            r0 = r365
            boolean r0 = r0 instanceof org.objectweb.asm.MethodWriter
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x17b1
            r365 = r69
            r0 = r365
            org.objectweb.asm.MethodWriter r0 = (org.objectweb.asm.MethodWriter) r0
            r365 = r0
            r259 = r365
            r365 = r259
            r0 = r365
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r365 = r0
            r0 = r365
            org.objectweb.asm.ClassReader r0 = r0.f298M
            r365 = r0
            r366 = r3
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x17b1
            r365 = r53
            r366 = r259
            r0 = r366
            java.lang.String r0 = r0.f402g
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x17b1
            r365 = r68
            r0 = r365
            if (r0 != 0) goto L_0x1712
            r365 = r259
            r0 = r365
            int r0 = r0.f405j
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x1709
            r0 = 1
            r365 = r0
            r263 = r365
        L_0x167a:
            r365 = r263
            r0 = r365
            if (r0 == 0) goto L_0x17b1
            r365 = r259
            r366 = r49
            r0 = r366
            r1 = r365
            r1.f403h = r0
            r365 = r259
            r366 = r47
            r367 = r49
            r0 = r366
            r1 = r367
            int r0 = r0 - r1
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f404i = r0
            int r48 = r48 + -1
            goto L_0x10e9
        L_0x16a8:
            r365 = r3
            r366 = r61
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r0 = r365
            java.lang.String[] r0 = new java.lang.String[r0]
            r365 = r0
            r65 = r365
            r365 = r61
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r66 = r365
            r0 = 0
            r365 = r0
            r67 = r365
        L_0x16d4:
            r365 = r67
            r366 = r65
            r0 = r366
            int r0 = r0.length
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x372a
            r365 = r65
            r366 = r67
            r367 = r3
            r368 = r66
            r369 = r8
            java.lang.String r0 = r367.readClass(r368, r369)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            int r66 = r66 + 2
            int r67 = r67 + 1
            goto L_0x16d4
        L_0x1709:
            r0 = 0
            r365 = r0
            r263 = r365
            goto L_0x167a
        L_0x1712:
            r365 = r68
            r0 = r365
            int r0 = r0.length
            r365 = r0
            r260 = r365
            r365 = r259
            r0 = r365
            int r0 = r0.f405j
            r365 = r0
            r261 = r365
            r0 = 0
            r365 = r0
            r262 = r365
            r365 = r260
            r366 = r261
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x3722
            r0 = 1
            r365 = r0
            r262 = r365
            r0 = -1
            r365 = r0
            r366 = r68
            r0 = r366
            int r0 = r0.length
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r264 = r365
            r365 = r66
            r265 = r365
            r365 = r264
            r266 = r365
        L_0x1769:
            r365 = r266
            r0 = r365
            if (r0 < 0) goto L_0x3722
            r0 = r265
            int r0 = r0 + -2
            r265 = r0
            r365 = r259
            r0 = r365
            int[] r0 = r0.f406k
            r365 = r0
            r366 = r266
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r366 = r3
            r367 = r265
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 == r1) goto L_0x17a9
            r0 = 0
            r365 = r0
            r263 = r365
            goto L_0x167a
        L_0x17a9:
            r0 = r266
            int r0 = r0 + -1
            r266 = r0
            goto L_0x1769
        L_0x17b1:
            r365 = r56
            r0 = r365
            if (r0 == 0) goto L_0x17e9
            r365 = r69
            org.objectweb.asm.AnnotationVisitor r0 = r365.visitAnnotationDefault()
            r365 = r0
            r257 = r365
            r365 = r3
            r366 = r56
            r367 = r8
            r0 = 0
            r368 = r0
            r369 = r257
            int r0 = r365.m66a(r366, r367, r368, r369)
            r365 = r0
            r365 = r257
            r0 = r365
            if (r0 == 0) goto L_0x17e9
            r365 = r257
            r365.visitEnd()
        L_0x17e9:
            r0 = 1
            r365 = r0
            r247 = r365
        L_0x17ef:
            r365 = r247
            r0 = r365
            if (r0 < 0) goto L_0x18a4
            r365 = r247
            r0 = r365
            if (r0 != 0) goto L_0x1892
            r365 = r55
            r249 = r365
        L_0x1802:
            r365 = r249
            r0 = r365
            if (r0 == 0) goto L_0x18a0
            r365 = r3
            r366 = r249
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r250 = r365
            r365 = r249
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r251 = r365
            r365 = r250
            r252 = r365
        L_0x182d:
            r365 = r252
            r0 = r365
            if (r0 <= 0) goto L_0x18a0
            r365 = r251
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r253 = r365
            r365 = r3
            r366 = r251
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r254 = r365
            r365 = r247
            r0 = r365
            if (r0 == 0) goto L_0x1899
            r0 = 1
            r365 = r0
            r255 = r365
        L_0x1863:
            r365 = r3
            r366 = r253
            r367 = r8
            r0 = 1
            r368 = r0
            r369 = r69
            r370 = r254
            r371 = r255
            org.objectweb.asm.AnnotationVisitor r0 = r369.visitAnnotation(r370, r371)
            r369 = r0
            int r0 = r365.m67a(r366, r367, r368, r369)
            r365 = r0
            r256 = r365
            int r252 = r252 + -1
            r365 = r256
            r251 = r365
            goto L_0x182d
        L_0x1892:
            r365 = r54
            r249 = r365
            goto L_0x1802
        L_0x1899:
            r0 = 0
            r365 = r0
            r255 = r365
            goto L_0x1863
        L_0x18a0:
            int r247 = r247 + -1
            goto L_0x17ef
        L_0x18a4:
            r365 = r57
            r0 = r365
            if (r0 == 0) goto L_0x18c1
            r365 = r3
            r366 = r57
            r367 = r52
            r368 = r8
            r0 = 1
            r369 = r0
            r370 = r69
            r365.m71a(r366, r367, r368, r369, r370)
        L_0x18c1:
            r365 = r58
            r0 = r365
            if (r0 == 0) goto L_0x18de
            r365 = r3
            r366 = r58
            r367 = r52
            r368 = r8
            r0 = 0
            r369 = r0
            r370 = r69
            r365.m71a(r366, r367, r368, r369, r370)
        L_0x18de:
            r365 = r59
            r0 = r365
            if (r0 == 0) goto L_0x190d
            r365 = r59
            r0 = r365
            org.objectweb.asm.Attribute r0 = r0.f277a
            r365 = r0
            r248 = r365
            r365 = r59
            r0 = 0
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f277a = r0
            r365 = r69
            r366 = r59
            r365.visitAttribute(r366)
            r365 = r248
            r59 = r365
            goto L_0x18de
        L_0x190d:
            r365 = r69
            r0 = r365
            if (r0 == 0) goto L_0x365a
            r365 = r60
            r0 = r365
            if (r0 == 0) goto L_0x365a
            r365 = r3
            r366 = r60
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r70 = r365
            r365 = r3
            r366 = r60
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r71 = r365
            r365 = r3
            r366 = r60
            r0 = 4
            r367 = r0
            r0 = r366
            int r0 = r0 + 4
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r72 = r365
            r365 = r60
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r73 = r365
            r365 = r73
            r366 = r72
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r74 = r365
            r365 = r69
            r365.visitCode()
            r365 = r72
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r0 = r365
            org.objectweb.asm.Label[] r0 = new org.objectweb.asm.Label[r0]
            r365 = r0
            r75 = r365
            r365 = r3
            r366 = r72
            r0 = 1
            r367 = r0
            r0 = r366
            int r0 = r0 + 1
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r365 = r73
            r77 = r365
            r365 = r77
            r366 = r74
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x1cf9
            r365 = r77
            r366 = r73
            r0 = r365
            r1 = r366
            int r0 = r0 - r1
            r365 = r0
            r230 = r365
            r0 = 255(0xff, float:3.57E-43)
            r365 = r0
            r366 = r7
            r367 = r77
            r0 = r366
            r1 = r367
            byte r0 = r0[r1]
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0 & r1
            r365 = r0
            r231 = r365
            byte[] r0 = org.objectweb.asm.ClassWriter.f286a
            r365 = r0
            r366 = r231
            r0 = r365
            r1 = r366
            byte r0 = r0[r1]
            r365 = r0
            r0 = r365
            switch(r0) {
                case 0: goto L_0x1a24;
                case 1: goto L_0x1cc5;
                case 2: goto L_0x1cd7;
                case 3: goto L_0x1cc5;
                case 4: goto L_0x1a24;
                case 5: goto L_0x1cd7;
                case 6: goto L_0x1cd7;
                case 7: goto L_0x1ce9;
                case 8: goto L_0x1ce9;
                case 9: goto L_0x1a35;
                case 10: goto L_0x1a76;
                case 11: goto L_0x1cc5;
                case 12: goto L_0x1cd7;
                case 13: goto L_0x1cd7;
                case 14: goto L_0x1b0e;
                case 15: goto L_0x1bfa;
                case 16: goto L_0x1a0c;
                case 17: goto L_0x1ab8;
                default: goto L_0x1a0c;
            }
            r365 = r77
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r232 = r365
            r365 = r232
            r77 = r365
            goto L_0x19bc
            r365 = r77
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r232 = r365
            goto L_0x1a1c
            r365 = r3
            r366 = r230
            r367 = r3
            r368 = r77
            r0 = 1
            r369 = r0
            r0 = r368
            int r0 = r0 + 1
            r368 = r0
            short r0 = r367.readShort(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r365 = r77
            r0 = 3
            r366 = r0
            r0 = r365
            int r0 = r0 + 3
            r365 = r0
            r232 = r365
            goto L_0x1a1c
            r365 = r3
            r366 = r230
            r367 = r3
            r368 = r77
            r0 = 1
            r369 = r0
            r0 = r368
            int r0 = r0 + 1
            r368 = r0
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r365 = r77
            r0 = 5
            r366 = r0
            r0 = r365
            int r0 = r0 + 5
            r365 = r0
            r232 = r365
            goto L_0x1a1c
            r0 = 255(0xff, float:3.57E-43)
            r365 = r0
            r366 = r7
            r367 = r77
            r0 = 1
            r368 = r0
            r0 = r367
            int r0 = r0 + 1
            r367 = r0
            r0 = r366
            r1 = r367
            byte r0 = r0[r1]
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0 & r1
            r365 = r0
            r0 = 132(0x84, float:1.85E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x1afa
            r365 = r77
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r232 = r365
            goto L_0x1a1c
            r365 = r77
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r232 = r365
            goto L_0x1a1c
            r365 = r77
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r366 = r230
            r0 = 3
            r367 = r0
            r0 = r366
            r0 = r0 & 3
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 - r1
            r365 = r0
            r239 = r365
            r365 = r3
            r366 = r230
            r367 = r3
            r368 = r239
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r0 = 1
            r365 = r0
            r366 = r3
            r367 = r239
            r0 = 8
            r368 = r0
            r0 = r367
            int r0 = r0 + 8
            r367 = r0
            int r0 = r366.readInt(r367)
            r366 = r0
            r367 = r3
            r368 = r239
            r0 = 4
            r369 = r0
            r0 = r368
            int r0 = r0 + 4
            r368 = r0
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 - r1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r241 = r365
            r365 = r239
            r0 = 12
            r366 = r0
            r0 = r365
            int r0 = r0 + 12
            r365 = r0
            r232 = r365
            r365 = r241
            r242 = r365
            r365 = r242
            r0 = r365
            if (r0 <= 0) goto L_0x1a1c
            r365 = r3
            r366 = r230
            r367 = r3
            r368 = r232
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r365 = r232
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r244 = r365
            int r242 = r242 + -1
            r365 = r244
            r232 = r365
            goto L_0x1bb4
            r365 = r77
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r366 = r230
            r0 = 3
            r367 = r0
            r0 = r366
            r0 = r0 & 3
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 - r1
            r365 = r0
            r233 = r365
            r365 = r3
            r366 = r230
            r367 = r3
            r368 = r233
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r365 = r3
            r366 = r233
            r0 = 4
            r367 = r0
            r0 = r366
            int r0 = r0 + 4
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r235 = r365
            r365 = r233
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r232 = r365
            r365 = r235
            r236 = r365
            r365 = r236
            r0 = r365
            if (r0 <= 0) goto L_0x1a1c
            r365 = r3
            r366 = r230
            r367 = r3
            r368 = r232
            r0 = 4
            r369 = r0
            r0 = r368
            int r0 = r0 + 4
            r368 = r0
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r365 = r232
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r238 = r365
            int r236 = r236 + -1
            r365 = r238
            r232 = r365
            goto L_0x1c73
            r365 = r77
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r232 = r365
            goto L_0x1a1c
            r365 = r77
            r0 = 3
            r366 = r0
            r0 = r365
            int r0 = r0 + 3
            r365 = r0
            r232 = r365
            goto L_0x1a1c
            r365 = r77
            r0 = 5
            r366 = r0
            r0 = r365
            int r0 = r0 + 5
            r365 = r0
            r232 = r365
            goto L_0x1a1c
        L_0x1cf9:
            r365 = r3
            r366 = r77
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r78 = r365
            r365 = r77
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r79 = r365
            r365 = r78
            r0 = r365
            if (r0 <= 0) goto L_0x1df6
            r365 = r3
            r366 = r3
            r367 = r79
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r226 = r365
            r365 = r3
            r366 = r3
            r367 = r79
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 + 2
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r227 = r365
            r365 = r3
            r366 = r3
            r367 = r79
            r0 = 4
            r368 = r0
            r0 = r367
            int r0 = r0 + 4
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r228 = r365
            r365 = r3
            r366 = r79
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r229 = r365
            r365 = r229
            r0 = r365
            if (r0 != 0) goto L_0x1dc3
            r365 = r69
            r366 = r226
            r367 = r227
            r368 = r228
            r0 = 0
            r369 = r0
            r365.visitTryCatchBlock(r366, r367, r368, r369)
            int r79 = r79 + 8
            int r78 = r78 + -1
            goto L_0x1d18
            r365 = r69
            r366 = r226
            r367 = r227
            r368 = r228
            r369 = r3
            r370 = r3
            r0 = r370
            int[] r0 = r0.f281a
            r370 = r0
            r371 = r229
            r0 = r370
            r1 = r371
            r0 = r0[r1]
            r370 = r0
            r371 = r8
            java.lang.String r0 = r369.readUTF8(r370, r371)
            r369 = r0
            r365.visitTryCatchBlock(r366, r367, r368, r369)
            goto L_0x1dbd
            r0 = 0
            r365 = r0
            r80 = r365
            r0 = 0
            r365 = r0
            r81 = r365
            r0 = 0
            r365 = r0
            r82 = r365
            r0 = 0
            r365 = r0
            r83 = r365
            r0 = 0
            r365 = r0
            r84 = r365
            r0 = 1
            r365 = r0
            r85 = r365
            r0 = 0
            r365 = r0
            r86 = r365
            r365 = r3
            r366 = r79
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r87 = r365
            r365 = r79
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r88 = r365
            r365 = r87
            r89 = r365
            r365 = r88
            r90 = r365
            r365 = r89
            r0 = r365
            if (r0 <= 0) goto L_0x22b7
            r365 = r3
            r366 = r90
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r199 = r365
            java.lang.String r0 = "LocalVariableTable"
            r365 = r0
            r366 = r199
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x1f80
            r365 = r23
            r0 = r365
            if (r0 != 0) goto L_0x36b6
            r365 = r90
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r219 = r365
            r365 = r3
            r366 = r90
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r220 = r365
            r365 = r90
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r221 = r365
            r365 = r220
            r0 = r365
            if (r0 <= 0) goto L_0x36d6
            r365 = r3
            r366 = r221
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r222 = r365
            r365 = r75
            r366 = r222
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x1f11
            r365 = r3
            r366 = r222
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r225 = r365
            r365 = r225
            r0 = 1
            r366 = r0
            r367 = r225
            r0 = r367
            int r0 = r0.f365a
            r367 = r0
            r0 = r366
            r1 = r367
            r0 = r0 | r1
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f365a = r0
            r365 = r222
            r366 = r3
            r367 = r221
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 + 2
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r223 = r365
            r365 = r75
            r366 = r223
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x1f7a
            r365 = r3
            r366 = r223
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r224 = r365
            r365 = r224
            r0 = 1
            r366 = r0
            r367 = r224
            r0 = r367
            int r0 = r0.f365a
            r367 = r0
            r0 = r366
            r1 = r367
            r0 = r0 | r1
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f365a = r0
            int r221 = r221 + 10
            int r220 = r220 + -1
            goto L_0x1eb7
            java.lang.String r0 = "LocalVariableTypeTable"
            r365 = r0
            r366 = r199
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x202c
            r365 = r90
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r218 = r365
            r365 = r84
            r205 = r365
            r365 = r83
            r203 = r365
            r365 = r82
            r206 = r365
            r365 = r218
            r204 = r365
            r365 = r85
            r202 = r365
            r365 = r80
            r207 = r365
            r365 = r90
            r0 = 6
            r366 = r0
            r367 = r3
            r368 = r90
            r0 = 2
            r369 = r0
            r0 = r368
            int r0 = r0 + 2
            r368 = r0
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r208 = r365
            r365 = r89
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + -1
            r365 = r0
            r209 = r365
            r365 = r202
            r85 = r365
            r365 = r204
            r81 = r365
            r365 = r207
            r80 = r365
            r365 = r209
            r89 = r365
            r365 = r208
            r90 = r365
            r365 = r203
            r83 = r365
            r365 = r206
            r82 = r365
            r365 = r205
            r84 = r365
            goto L_0x1e49
            java.lang.String r0 = "LineNumberTable"
            r365 = r0
            r366 = r199
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x20fe
            r365 = r23
            r0 = r365
            if (r0 != 0) goto L_0x36b6
            r365 = r3
            r366 = r90
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r214 = r365
            r365 = r90
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r215 = r365
            r365 = r214
            r0 = r365
            if (r0 <= 0) goto L_0x36b6
            r365 = r3
            r366 = r215
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r216 = r365
            r365 = r75
            r366 = r216
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x20cb
            r365 = r3
            r366 = r216
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r217 = r365
            r365 = r217
            r0 = 1
            r366 = r0
            r367 = r217
            r0 = r367
            int r0 = r0.f365a
            r367 = r0
            r0 = r366
            r1 = r367
            r0 = r0 | r1
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f365a = r0
            r365 = r75
            r366 = r216
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r366 = r3
            r367 = r215
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 + 2
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f366b = r0
            int r215 = r215 + 4
            int r214 = r214 + -1
            goto L_0x2071
            java.lang.String r0 = "StackMapTable"
            r365 = r0
            r366 = r199
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x2188
            r365 = r6
            r0 = 4
            r366 = r0
            r0 = r365
            r0 = r0 & 4
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x36b6
            r365 = r90
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r211 = r365
            r365 = r3
            r366 = r90
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r212 = r365
            r365 = r3
            r366 = r90
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r213 = r365
            r365 = r211
            r206 = r365
            r365 = r81
            r204 = r365
            r365 = r80
            r207 = r365
            r365 = r212
            r203 = r365
            r365 = r213
            r205 = r365
            r365 = r85
            r202 = r365
            goto L_0x1fc1
            java.lang.String r0 = "StackMap"
            r365 = r0
            r366 = r199
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x2204
            r365 = r6
            r0 = 4
            r366 = r0
            r0 = r365
            r0 = r0 & 4
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x36b6
            r365 = r90
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r206 = r365
            r365 = r3
            r366 = r90
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r203 = r365
            r365 = r3
            r366 = r90
            r0 = 6
            r367 = r0
            r0 = r366
            int r0 = r0 + 6
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r205 = r365
            r365 = r81
            r204 = r365
            r365 = r80
            r207 = r365
            r0 = 0
            r365 = r0
            r202 = r365
            goto L_0x1fc1
            r0 = 0
            r365 = r0
            r200 = r365
            r365 = r86
            r201 = r365
            r365 = r200
            r366 = r5
            r0 = r366
            int r0 = r0.length
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x36fd
            r365 = r5
            r366 = r200
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r0 = r365
            java.lang.String r0 = r0.type
            r365 = r0
            r366 = r199
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x36f6
            r365 = r5
            r366 = r200
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r366 = r3
            r367 = r90
            r0 = 6
            r368 = r0
            r0 = r367
            int r0 = r0 + 6
            r367 = r0
            r368 = r3
            r369 = r90
            r0 = 2
            r370 = r0
            r0 = r369
            int r0 = r0 + 2
            r369 = r0
            int r0 = r368.readInt(r369)
            r368 = r0
            r369 = r8
            r370 = r73
            r0 = 8
            r371 = r0
            r0 = r370
            int r0 = r0 + -8
            r370 = r0
            r371 = r75
            org.objectweb.asm.Attribute r0 = r365.read(r366, r367, r368, r369, r370, r371)
            r365 = r0
            r210 = r365
            r365 = r210
            r0 = r365
            if (r0 == 0) goto L_0x36f6
            r365 = r210
            r366 = r201
            r0 = r366
            r1 = r365
            r1.f277a = r0
            int r200 = r200 + 1
            r365 = r210
            r201 = r365
            goto L_0x220f
            r365 = r82
            r0 = r365
            if (r0 == 0) goto L_0x369c
            r365 = r71
            r0 = r365
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r365 = r0
            r183 = r365
            r365 = r70
            r0 = r365
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r365 = r0
            r93 = r365
            r365 = r24
            r0 = r365
            if (r0 == 0) goto L_0x3694
            r365 = r50
            r0 = 8
            r366 = r0
            r0 = r365
            r0 = r0 & 8
            r365 = r0
            r0 = r365
            if (r0 != 0) goto L_0x368c
            java.lang.String r0 = "<init>"
            r365 = r0
            r366 = r51
            boolean r0 = r365.equals(r366)
            r365 = r0
            r0 = r365
            if (r0 == 0) goto L_0x2400
            r0 = 1
            r365 = r0
            r184 = r365
            r365 = r183
            r0 = 0
            r366 = r0
            java.lang.Integer r0 = org.objectweb.asm.Opcodes.UNINITIALIZED_THIS
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r0 = 1
            r365 = r0
            r188 = r365
            r365 = r188
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r189 = r365
            r365 = r52
            r366 = r188
            char r0 = r365.charAt(r366)
            r365 = r0
            r0 = r365
            switch(r0) {
                case 66: goto L_0x243c;
                case 67: goto L_0x243c;
                case 68: goto L_0x24c9;
                case 70: goto L_0x246b;
                case 73: goto L_0x243c;
                case 74: goto L_0x249a;
                case 76: goto L_0x25a5;
                case 83: goto L_0x243c;
                case 90: goto L_0x243c;
                case 91: goto L_0x24f8;
                default: goto L_0x2345;
            }
            r0 = -1
            r365 = r0
            r92 = r365
            r365 = r82
            r185 = r365
            r365 = r185
            r0 = -2
            r366 = r0
            r367 = r82
            r368 = r83
            r0 = r367
            r1 = r368
            int r0 = r0 + r1
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x2613
            r365 = r7
            r366 = r185
            r0 = r365
            r1 = r366
            byte r0 = r0[r1]
            r365 = r0
            r0 = 8
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x23fc
            r365 = r3
            r366 = r185
            r0 = 1
            r367 = r0
            r0 = r366
            int r0 = r0 + 1
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r186 = r365
            r365 = r186
            r0 = r365
            if (r0 < 0) goto L_0x23fc
            r365 = r186
            r366 = r72
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x23fc
            r0 = 255(0xff, float:3.57E-43)
            r365 = r0
            r366 = r7
            r367 = r73
            r368 = r186
            r0 = r367
            r1 = r368
            int r0 = r0 + r1
            r367 = r0
            r0 = r366
            r1 = r367
            byte r0 = r0[r1]
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0 & r1
            r365 = r0
            r0 = 187(0xbb, float:2.62E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x23fc
            r365 = r3
            r366 = r186
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            int r185 = r185 + 1
            goto L_0x2350
            r0 = 1
            r365 = r0
            r184 = r365
            r365 = r183
            r0 = 0
            r366 = r0
            r367 = r3
            r0 = 2
            r368 = r0
            r369 = r3
            r0 = r369
            int r0 = r0.header
            r369 = r0
            r0 = r368
            r1 = r369
            int r0 = r0 + r1
            r368 = r0
            r369 = r8
            java.lang.String r0 = r367.readClass(r368, r369)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            goto L_0x231d
            r365 = r184
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r198 = r365
            r365 = r183
            r366 = r184
            java.lang.Integer r0 = org.objectweb.asm.Opcodes.INTEGER
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r198
            r184 = r365
            r365 = r189
            r188 = r365
            goto L_0x2323
            r365 = r184
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r197 = r365
            r365 = r183
            r366 = r184
            java.lang.Integer r0 = org.objectweb.asm.Opcodes.FLOAT
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r197
            r184 = r365
            r365 = r189
            r188 = r365
            goto L_0x2323
            r365 = r184
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r196 = r365
            r365 = r183
            r366 = r184
            java.lang.Integer r0 = org.objectweb.asm.Opcodes.LONG
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r196
            r184 = r365
            r365 = r189
            r188 = r365
            goto L_0x2323
            r365 = r184
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r195 = r365
            r365 = r183
            r366 = r184
            java.lang.Integer r0 = org.objectweb.asm.Opcodes.DOUBLE
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r195
            r184 = r365
            r365 = r189
            r188 = r365
            goto L_0x2323
            r365 = r52
            r366 = r189
            char r0 = r365.charAt(r366)
            r365 = r0
            r0 = 91
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x2511
            int r189 = r189 + 1
            goto L_0x24f6
            r365 = r52
            r366 = r189
            char r0 = r365.charAt(r366)
            r365 = r0
            r0 = 76
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x2559
            r365 = r189
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r194 = r365
            r365 = r52
            r366 = r194
            char r0 = r365.charAt(r366)
            r365 = r0
            r0 = 59
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 == r1) goto L_0x2554
            int r194 = r194 + 1
            goto L_0x2539
            r365 = r194
            r189 = r365
            r365 = r184
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r192 = r365
            r365 = r189
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r193 = r365
            r365 = r183
            r366 = r184
            r367 = r52
            r368 = r188
            r369 = r193
            java.lang.String r0 = r367.substring(r368, r369)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r192
            r184 = r365
            r365 = r193
            r188 = r365
            goto L_0x2323
            r365 = r52
            r366 = r189
            char r0 = r365.charAt(r366)
            r365 = r0
            r0 = 59
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 == r1) goto L_0x25be
            int r189 = r189 + 1
            goto L_0x25a3
            r365 = r184
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r190 = r365
            r365 = r188
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r191 = r365
            r365 = r189
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r188 = r365
            r365 = r183
            r366 = r184
            r367 = r52
            r368 = r191
            r369 = r189
            java.lang.String r0 = r367.substring(r368, r369)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r190
            r184 = r365
            goto L_0x2323
            r365 = r184
            r94 = r365
            r365 = r183
            r91 = r365
            r365 = r91
            r95 = r365
            r0 = 0
            r365 = r0
            r96 = r365
            r0 = 0
            r365 = r0
            r97 = r365
            r365 = r94
            r98 = r365
            r365 = r82
            r99 = r365
            r0 = 0
            r365 = r0
            r100 = r365
            r365 = r84
            r101 = r365
            r365 = r92
            r102 = r365
            r365 = r73
            r103 = r365
            r365 = r103
            r366 = r74
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x3390
            r365 = r103
            r366 = r73
            r0 = r365
            r1 = r366
            int r0 = r0 - r1
            r365 = r0
            r120 = r365
            r365 = r75
            r366 = r120
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r121 = r365
            r365 = r121
            r0 = r365
            if (r0 == 0) goto L_0x26b2
            r365 = r69
            r366 = r121
            r365.visitLabel(r366)
            r365 = r23
            r0 = r365
            if (r0 != 0) goto L_0x26b2
            r365 = r121
            r0 = r365
            int r0 = r0.f366b
            r365 = r0
            r0 = r365
            if (r0 <= 0) goto L_0x26b2
            r365 = r69
            r366 = r121
            r0 = r366
            int r0 = r0.f366b
            r366 = r0
            r367 = r121
            r365.visitLineNumber(r366, r367)
            r365 = r101
            r122 = r365
            r365 = r95
            r0 = r365
            if (r0 == 0) goto L_0x2a9c
            r365 = r102
            r366 = r120
            r0 = r365
            r1 = r366
            if (r0 == r1) goto L_0x26d7
            r365 = r102
            r0 = -1
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x2a9c
            r365 = r85
            r0 = r365
            if (r0 == 0) goto L_0x26e5
            r365 = r24
            r0 = r365
            if (r0 == 0) goto L_0x27bc
            r365 = r69
            r0 = -1
            r366 = r0
            r367 = r98
            r368 = r95
            r369 = r96
            r370 = r93
            r365.visitFrame(r366, r367, r368, r369, r370)
            r365 = r122
            r0 = r365
            if (r0 <= 0) goto L_0x2a94
            r365 = r85
            r0 = r365
            if (r0 == 0) goto L_0x27e0
            r365 = r99
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r157 = r365
            r0 = 255(0xff, float:3.57E-43)
            r365 = r0
            r366 = r7
            r367 = r99
            r0 = r366
            r1 = r367
            byte r0 = r0[r1]
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0 & r1
            r365 = r0
            r155 = r365
            r365 = r102
            r156 = r365
            r0 = 0
            r365 = r0
            r158 = r365
            r365 = r155
            r0 = 64
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x27f4
            r0 = 3
            r365 = r0
            r169 = r365
            r0 = 0
            r365 = r0
            r167 = r365
            r365 = r155
            r168 = r365
            r365 = r156
            r366 = r168
            r0 = 1
            r367 = r0
            r0 = r366
            int r0 = r0 + 1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r170 = r365
            r365 = r3
            r366 = r170
            r367 = r75
            org.objectweb.asm.Label r0 = r365.readLabel(r366, r367)
            r365 = r0
            r365 = r122
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + -1
            r365 = r0
            r172 = r365
            r365 = r167
            r96 = r365
            r365 = r158
            r97 = r365
            r365 = r169
            r100 = r365
            r365 = r172
            r122 = r365
            r365 = r170
            r102 = r365
            r365 = r157
            r99 = r365
            goto L_0x26b7
            r365 = r102
            r0 = -1
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 == r1) goto L_0x26fb
            r365 = r69
            r366 = r100
            r367 = r97
            r368 = r95
            r369 = r96
            r370 = r93
            r365.visitFrame(r366, r367, r368, r369, r370)
            goto L_0x26fb
            r0 = 255(0xff, float:3.57E-43)
            r365 = r0
            r155 = r365
            r0 = -1
            r365 = r0
            r156 = r365
            r365 = r99
            r157 = r365
            goto L_0x273c
            r365 = r155
            r0 = 128(0x80, float:1.794E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x2843
            r365 = r155
            r0 = 64
            r366 = r0
            r0 = r365
            int r0 = r0 + -64
            r365 = r0
            r168 = r365
            r365 = r3
            r366 = r93
            r0 = 0
            r367 = r0
            r368 = r157
            r369 = r8
            r370 = r75
            int r0 = r365.m68a(r366, r367, r368, r369, r370)
            r365 = r0
            r157 = r365
            r0 = 4
            r365 = r0
            r169 = r365
            r0 = 1
            r365 = r0
            r167 = r365
            r0 = 0
            r365 = r0
            r158 = r365
            goto L_0x2761
            r365 = r3
            r366 = r157
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r159 = r365
            int r157 = r157 + 2
            r365 = r155
            r0 = 247(0xf7, float:3.46E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x2897
            r365 = r3
            r366 = r93
            r0 = 0
            r367 = r0
            r368 = r157
            r369 = r8
            r370 = r75
            int r0 = r365.m68a(r366, r367, r368, r369, r370)
            r365 = r0
            r157 = r365
            r0 = 4
            r365 = r0
            r169 = r365
            r0 = 1
            r365 = r0
            r167 = r365
            r365 = r159
            r168 = r365
            r0 = 0
            r365 = r0
            r158 = r365
            goto L_0x2761
            r365 = r155
            r0 = 248(0xf8, float:3.48E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 < r1) goto L_0x28ec
            r365 = r155
            r0 = 251(0xfb, float:3.52E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x28ec
            r0 = 251(0xfb, float:3.52E-43)
            r365 = r0
            r366 = r155
            r0 = r366
            int r0 = 251 - r0
            r365 = r0
            r182 = r365
            r365 = r98
            r366 = r182
            r0 = r365
            r1 = r366
            int r0 = r0 - r1
            r365 = r0
            r98 = r365
            r0 = 2
            r365 = r0
            r169 = r365
            r365 = r182
            r158 = r365
            r365 = r159
            r168 = r365
            r0 = 0
            r365 = r0
            r167 = r365
            goto L_0x2761
            r365 = r155
            r0 = 251(0xfb, float:3.52E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x2913
            r0 = 3
            r365 = r0
            r169 = r365
            r365 = r159
            r168 = r365
            r0 = 0
            r365 = r0
            r167 = r365
            r0 = 0
            r365 = r0
            r158 = r365
            goto L_0x2761
            r365 = r155
            r0 = 255(0xff, float:3.57E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x29cc
            r365 = r24
            r0 = r365
            if (r0 == 0) goto L_0x2987
            r365 = r98
            r175 = r365
            r365 = r155
            r0 = 251(0xfb, float:3.52E-43)
            r366 = r0
            r0 = r365
            int r0 = r0 + -251
            r365 = r0
            r176 = r365
            r365 = r157
            r177 = r365
            r365 = r175
            r178 = r365
            r365 = r176
            r179 = r365
            r365 = r179
            r0 = r365
            if (r0 <= 0) goto L_0x298e
            r365 = r178
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r181 = r365
            r365 = r3
            r366 = r95
            r367 = r178
            r368 = r177
            r369 = r8
            r370 = r75
            int r0 = r365.m68a(r366, r367, r368, r369, r370)
            r365 = r0
            r177 = r365
            int r179 = r179 + -1
            r365 = r181
            r178 = r365
            goto L_0x294d
            r0 = 0
            r365 = r0
            r175 = r365
            goto L_0x292d
            r365 = r155
            r0 = 251(0xfb, float:3.52E-43)
            r366 = r0
            r0 = r365
            int r0 = r0 + -251
            r365 = r0
            r180 = r365
            r365 = r98
            r366 = r180
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r98 = r365
            r0 = 1
            r365 = r0
            r169 = r365
            r365 = r177
            r157 = r365
            r365 = r180
            r158 = r365
            r365 = r159
            r168 = r365
            r0 = 0
            r365 = r0
            r167 = r365
            goto L_0x2761
            r365 = r3
            r366 = r157
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r160 = r365
            r365 = r157
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r161 = r365
            r0 = 0
            r365 = r0
            r162 = r365
            r365 = r160
            r163 = r365
            r365 = r163
            r0 = r365
            if (r0 <= 0) goto L_0x2a30
            r365 = r162
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r174 = r365
            r365 = r3
            r366 = r95
            r367 = r162
            r368 = r161
            r369 = r8
            r370 = r75
            int r0 = r365.m68a(r366, r367, r368, r369, r370)
            r365 = r0
            r161 = r365
            int r163 = r163 + -1
            r365 = r174
            r162 = r365
            goto L_0x29f6
            r365 = r3
            r366 = r161
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r164 = r365
            r365 = r161
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r157 = r365
            r0 = 0
            r365 = r0
            r165 = r365
            r365 = r164
            r166 = r365
            r365 = r166
            r0 = r365
            if (r0 <= 0) goto L_0x3670
            r365 = r165
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r173 = r365
            r365 = r3
            r366 = r93
            r367 = r165
            r368 = r157
            r369 = r8
            r370 = r75
            int r0 = r365.m68a(r366, r367, r368, r369, r370)
            r365 = r0
            r157 = r365
            int r166 = r166 + -1
            r365 = r173
            r165 = r365
            goto L_0x2a5a
            r0 = 0
            r365 = r0
            r95 = r365
            goto L_0x26b7
            r0 = 255(0xff, float:3.57E-43)
            r365 = r0
            r366 = r7
            r367 = r103
            r0 = r366
            r1 = r367
            byte r0 = r0[r1]
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0 & r1
            r365 = r0
            r123 = r365
            byte[] r0 = org.objectweb.asm.ClassWriter.f286a
            r365 = r0
            r366 = r123
            r0 = r365
            r1 = r366
            byte r0 = r0[r1]
            r365 = r0
            r0 = r365
            switch(r0) {
                case 0: goto L_0x2b36;
                case 1: goto L_0x2fb2;
                case 2: goto L_0x2fe7;
                case 3: goto L_0x2f70;
                case 4: goto L_0x2b50;
                case 5: goto L_0x3303;
                case 6: goto L_0x30a3;
                case 7: goto L_0x30a3;
                case 8: goto L_0x31a3;
                case 9: goto L_0x2bf1;
                case 10: goto L_0x2c3b;
                case 11: goto L_0x301a;
                case 12: goto L_0x3066;
                case 13: goto L_0x3339;
                case 14: goto L_0x2d43;
                case 15: goto L_0x2e5b;
                case 16: goto L_0x2ad0;
                case 17: goto L_0x2c91;
                default: goto L_0x2ad0;
            }
            r365 = r69
            r366 = r3
            r367 = r103
            r0 = 1
            r368 = r0
            r0 = r367
            int r0 = r0 + 1
            r367 = r0
            r368 = r8
            java.lang.String r0 = r366.readClass(r367, r368)
            r366 = r0
            r0 = 255(0xff, float:3.57E-43)
            r367 = r0
            r368 = r7
            r369 = r103
            r0 = 3
            r370 = r0
            r0 = r369
            int r0 = r0 + 3
            r369 = r0
            r0 = r368
            r1 = r369
            byte r0 = r0[r1]
            r368 = r0
            r0 = r367
            r1 = r368
            r0 = r0 & r1
            r367 = r0
            r365.visitMultiANewArrayInsn(r366, r367)
            r365 = r103
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r124 = r365
            r365 = r122
            r101 = r365
            r365 = r124
            r103 = r365
            goto L_0x264d
            r365 = r69
            r366 = r123
            r365.visitInsn(r366)
            r365 = r103
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r123
            r0 = 54
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 <= r1) goto L_0x2bae
            r365 = r123
            r0 = 59
            r366 = r0
            r0 = r365
            int r0 = r0 + -59
            r365 = r0
            r154 = r365
            r365 = r69
            r0 = 54
            r366 = r0
            r367 = r154
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 >> 2
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r154
            r0 = 3
            r368 = r0
            r0 = r367
            r0 = r0 & 3
            r367 = r0
            r365.visitVarInsn(r366, r367)
            r365 = r103
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + 1
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r123
            r0 = 26
            r366 = r0
            r0 = r365
            int r0 = r0 + -26
            r365 = r0
            r153 = r365
            r365 = r69
            r0 = 21
            r366 = r0
            r367 = r153
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 >> 2
            r367 = r0
            r0 = r366
            r1 = r367
            int r0 = r0 + r1
            r366 = r0
            r367 = r153
            r0 = 3
            r368 = r0
            r0 = r367
            r0 = r0 & 3
            r367 = r0
            r365.visitVarInsn(r366, r367)
            goto L_0x2b9c
            r365 = r69
            r366 = r123
            r367 = r75
            r368 = r120
            r369 = r3
            r370 = r103
            r0 = 1
            r371 = r0
            r0 = r370
            int r0 = r0 + 1
            r370 = r0
            short r0 = r369.readShort(r370)
            r369 = r0
            r0 = r368
            r1 = r369
            int r0 = r0 + r1
            r368 = r0
            r0 = r367
            r1 = r368
            r0 = r0[r1]
            r367 = r0
            r365.visitJumpInsn(r366, r367)
            r365 = r103
            r0 = 3
            r366 = r0
            r0 = r365
            int r0 = r0 + 3
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r366 = r123
            r0 = 33
            r367 = r0
            r0 = r366
            int r0 = r0 + -33
            r366 = r0
            r367 = r75
            r368 = r120
            r369 = r3
            r370 = r103
            r0 = 1
            r371 = r0
            r0 = r370
            int r0 = r0 + 1
            r370 = r0
            int r0 = r369.readInt(r370)
            r369 = r0
            r0 = r368
            r1 = r369
            int r0 = r0 + r1
            r368 = r0
            r0 = r367
            r1 = r368
            r0 = r0[r1]
            r367 = r0
            r365.visitJumpInsn(r366, r367)
            r365 = r103
            r0 = 5
            r366 = r0
            r0 = r365
            int r0 = r0 + 5
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r0 = 255(0xff, float:3.57E-43)
            r365 = r0
            r366 = r7
            r367 = r103
            r0 = 1
            r368 = r0
            r0 = r367
            int r0 = r0 + 1
            r367 = r0
            r0 = r366
            r1 = r367
            byte r0 = r0[r1]
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0 & r1
            r365 = r0
            r152 = r365
            r365 = r152
            r0 = 132(0x84, float:1.85E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x2d0e
            r365 = r69
            r366 = r3
            r367 = r103
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 + 2
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r367 = r3
            r368 = r103
            r0 = 4
            r369 = r0
            r0 = r368
            int r0 = r0 + 4
            r368 = r0
            short r0 = r367.readShort(r368)
            r367 = r0
            r365.visitIincInsn(r366, r367)
            r365 = r103
            r0 = 6
            r366 = r0
            r0 = r365
            int r0 = r0 + 6
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r366 = r152
            r367 = r3
            r368 = r103
            r0 = 2
            r369 = r0
            r0 = r368
            int r0 = r0 + 2
            r368 = r0
            int r0 = r367.readUnsignedShort(r368)
            r367 = r0
            r365.visitVarInsn(r366, r367)
            r365 = r103
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r103
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r366 = r120
            r0 = 3
            r367 = r0
            r0 = r366
            r0 = r0 & 3
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 - r1
            r365 = r0
            r146 = r365
            r365 = r120
            r366 = r3
            r367 = r146
            int r0 = r366.readInt(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r147 = r365
            r365 = r3
            r366 = r146
            r0 = 4
            r367 = r0
            r0 = r366
            int r0 = r0 + 4
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r148 = r365
            r365 = r3
            r366 = r146
            r0 = 8
            r367 = r0
            r0 = r366
            int r0 = r0 + 8
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r149 = r365
            r365 = r146
            r0 = 12
            r366 = r0
            r0 = r365
            int r0 = r0 + 12
            r365 = r0
            r124 = r365
            r0 = 1
            r365 = r0
            r366 = r149
            r367 = r148
            r0 = r366
            r1 = r367
            int r0 = r0 - r1
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r0 = r365
            org.objectweb.asm.Label[] r0 = new org.objectweb.asm.Label[r0]
            r365 = r0
            r150 = r365
            r0 = 0
            r365 = r0
            r151 = r365
            r365 = r151
            r366 = r150
            r0 = r366
            int r0 = r0.length
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x2e39
            r365 = r150
            r366 = r151
            r367 = r75
            r368 = r120
            r369 = r3
            r370 = r124
            int r0 = r369.readInt(r370)
            r369 = r0
            r0 = r368
            r1 = r369
            int r0 = r0 + r1
            r368 = r0
            r0 = r367
            r1 = r368
            r0 = r0[r1]
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            int r124 = r124 + 4
            int r151 = r151 + 1
            goto L_0x2df0
            r365 = r69
            r366 = r148
            r367 = r149
            r368 = r75
            r369 = r147
            r0 = r368
            r1 = r369
            r0 = r0[r1]
            r368 = r0
            r369 = r150
            r365.visitTableSwitchInsn(r366, r367, r368, r369)
            goto L_0x2b28
            r365 = r103
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r366 = r120
            r0 = 3
            r367 = r0
            r0 = r366
            r0 = r0 & 3
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 - r1
            r365 = r0
            r140 = r365
            r365 = r120
            r366 = r3
            r367 = r140
            int r0 = r366.readInt(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 + r1
            r365 = r0
            r141 = r365
            r365 = r3
            r366 = r140
            r0 = 4
            r367 = r0
            r0 = r366
            int r0 = r0 + 4
            r366 = r0
            int r0 = r365.readInt(r366)
            r365 = r0
            r142 = r365
            r365 = r140
            r0 = 8
            r366 = r0
            r0 = r365
            int r0 = r0 + 8
            r365 = r0
            r124 = r365
            r365 = r142
            r0 = r365
            int[] r0 = new int[r0]
            r365 = r0
            r143 = r365
            r365 = r142
            r0 = r365
            org.objectweb.asm.Label[] r0 = new org.objectweb.asm.Label[r0]
            r365 = r0
            r144 = r365
            r0 = 0
            r365 = r0
            r145 = r365
            r365 = r145
            r366 = r143
            r0 = r366
            int r0 = r0.length
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x2f51
            r365 = r143
            r366 = r145
            r367 = r3
            r368 = r124
            int r0 = r367.readInt(r368)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r144
            r366 = r145
            r367 = r75
            r368 = r120
            r369 = r3
            r370 = r124
            r0 = 4
            r371 = r0
            r0 = r370
            int r0 = r0 + 4
            r370 = r0
            int r0 = r369.readInt(r370)
            r369 = r0
            r0 = r368
            r1 = r369
            int r0 = r0 + r1
            r368 = r0
            r0 = r367
            r1 = r368
            r0 = r0[r1]
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            int r124 = r124 + 8
            int r145 = r145 + 1
            goto L_0x2ee2
            r365 = r69
            r366 = r75
            r367 = r141
            r0 = r366
            r1 = r367
            r0 = r0[r1]
            r366 = r0
            r367 = r143
            r368 = r144
            r365.visitLookupSwitchInsn(r366, r367, r368)
            goto L_0x2b28
            r365 = r69
            r366 = r123
            r0 = 255(0xff, float:3.57E-43)
            r367 = r0
            r368 = r7
            r369 = r103
            r0 = 1
            r370 = r0
            r0 = r369
            int r0 = r0 + 1
            r369 = r0
            r0 = r368
            r1 = r369
            byte r0 = r0[r1]
            r368 = r0
            r0 = r367
            r1 = r368
            r0 = r0 & r1
            r367 = r0
            r365.visitVarInsn(r366, r367)
            r365 = r103
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r366 = r123
            r367 = r7
            r368 = r103
            r0 = 1
            r369 = r0
            r0 = r368
            int r0 = r0 + 1
            r368 = r0
            r0 = r367
            r1 = r368
            byte r0 = r0[r1]
            r367 = r0
            r365.visitIntInsn(r366, r367)
            r365 = r103
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r366 = r123
            r367 = r3
            r368 = r103
            r0 = 1
            r369 = r0
            r0 = r368
            int r0 = r0 + 1
            r368 = r0
            short r0 = r367.readShort(r368)
            r367 = r0
            r365.visitIntInsn(r366, r367)
            r365 = r103
            r0 = 3
            r366 = r0
            r0 = r365
            int r0 = r0 + 3
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r366 = r3
            r0 = 255(0xff, float:3.57E-43)
            r367 = r0
            r368 = r7
            r369 = r103
            r0 = 1
            r370 = r0
            r0 = r369
            int r0 = r0 + 1
            r369 = r0
            r0 = r368
            r1 = r369
            byte r0 = r0[r1]
            r368 = r0
            r0 = r367
            r1 = r368
            r0 = r0 & r1
            r367 = r0
            r368 = r8
            java.lang.Object r0 = r366.readConst(r367, r368)
            r366 = r0
            r365.visitLdcInsn(r366)
            r365 = r103
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r366 = r3
            r367 = r3
            r368 = r103
            r0 = 1
            r369 = r0
            r0 = r368
            int r0 = r0 + 1
            r368 = r0
            int r0 = r367.readUnsignedShort(r368)
            r367 = r0
            r368 = r8
            java.lang.Object r0 = r366.readConst(r367, r368)
            r366 = r0
            r365.visitLdcInsn(r366)
            r365 = r103
            r0 = 3
            r366 = r0
            r0 = r365
            int r0 = r0 + 3
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r3
            r0 = r365
            int[] r0 = r0.f281a
            r365 = r0
            r366 = r3
            r367 = r103
            r0 = 1
            r368 = r0
            r0 = r367
            int r0 = r0 + 1
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r135 = r365
            r365 = r3
            r366 = r135
            r367 = r8
            java.lang.String r0 = r365.readClass(r366, r367)
            r365 = r0
            r136 = r365
            r365 = r3
            r0 = r365
            int[] r0 = r0.f281a
            r365 = r0
            r366 = r3
            r367 = r135
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 + 2
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r137 = r365
            r365 = r3
            r366 = r137
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r138 = r365
            r365 = r3
            r366 = r137
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r139 = r365
            r365 = r123
            r0 = 182(0xb6, float:2.55E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x317c
            r365 = r69
            r366 = r123
            r367 = r136
            r368 = r138
            r369 = r139
            r365.visitFieldInsn(r366, r367, r368, r369)
            r365 = r123
            r0 = 185(0xb9, float:2.59E-43)
            r366 = r0
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x318f
            r365 = r103
            r0 = 5
            r366 = r0
            r0 = r365
            int r0 = r0 + 5
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r366 = r123
            r367 = r136
            r368 = r138
            r369 = r139
            r365.visitMethodInsn(r366, r367, r368, r369)
            goto L_0x315c
            r365 = r103
            r0 = 3
            r366 = r0
            r0 = r365
            int r0 = r0 + 3
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r3
            r0 = r365
            int[] r0 = r0.f281a
            r365 = r0
            r366 = r3
            r367 = r103
            r0 = 1
            r368 = r0
            r0 = r367
            int r0 = r0 + 1
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r125 = r365
            r365 = r37
            r366 = r3
            r367 = r125
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r126 = r365
            r365 = r3
            r0 = r365
            int[] r0 = r0.f281a
            r365 = r0
            r366 = r3
            r367 = r125
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 + 2
            r367 = r0
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r127 = r365
            r365 = r3
            r366 = r127
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r128 = r365
            r365 = r3
            r366 = r127
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r129 = r365
            r365 = r3
            r366 = r3
            r367 = r126
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r367 = r8
            java.lang.Object r0 = r365.readConst(r366, r367)
            r365 = r0
            r0 = r365
            org.objectweb.asm.Handle r0 = (org.objectweb.asm.Handle) r0
            r365 = r0
            r130 = r365
            r365 = r3
            r366 = r126
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r131 = r365
            r365 = r131
            r0 = r365
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r365 = r0
            r132 = r365
            r365 = r126
            r0 = 4
            r366 = r0
            r0 = r365
            int r0 = r0 + 4
            r365 = r0
            r133 = r365
            r0 = 0
            r365 = r0
            r134 = r365
            r365 = r134
            r366 = r131
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x32dd
            r365 = r132
            r366 = r134
            r367 = r3
            r368 = r3
            r369 = r133
            int r0 = r368.readUnsignedShort(r369)
            r368 = r0
            r369 = r8
            java.lang.Object r0 = r367.readConst(r368, r369)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            int r133 = r133 + 2
            int r134 = r134 + 1
            goto L_0x32a4
            r365 = r69
            r366 = r128
            r367 = r129
            r368 = r130
            r369 = r132
            r365.visitInvokeDynamicInsn(r366, r367, r368, r369)
            r365 = r103
            r0 = 5
            r366 = r0
            r0 = r365
            int r0 = r0 + 5
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r366 = r123
            r367 = r3
            r368 = r103
            r0 = 1
            r369 = r0
            r0 = r368
            int r0 = r0 + 1
            r368 = r0
            r369 = r8
            java.lang.String r0 = r367.readClass(r368, r369)
            r367 = r0
            r365.visitTypeInsn(r366, r367)
            r365 = r103
            r0 = 3
            r366 = r0
            r0 = r365
            int r0 = r0 + 3
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r69
            r0 = 255(0xff, float:3.57E-43)
            r366 = r0
            r367 = r7
            r368 = r103
            r0 = 1
            r369 = r0
            r0 = r368
            int r0 = r0 + 1
            r368 = r0
            r0 = r367
            r1 = r368
            byte r0 = r0[r1]
            r367 = r0
            r0 = r366
            r1 = r367
            r0 = r0 & r1
            r366 = r0
            r367 = r7
            r368 = r103
            r0 = 2
            r369 = r0
            r0 = r368
            int r0 = r0 + 2
            r368 = r0
            r0 = r367
            r1 = r368
            byte r0 = r0[r1]
            r367 = r0
            r365.visitIincInsn(r366, r367)
            r365 = r103
            r0 = 3
            r366 = r0
            r0 = r365
            int r0 = r0 + 3
            r365 = r0
            r124 = r365
            goto L_0x2b28
            r365 = r75
            r366 = r74
            r367 = r73
            r0 = r366
            r1 = r367
            int r0 = r0 - r1
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r104 = r365
            r365 = r104
            r0 = r365
            if (r0 == 0) goto L_0x33bc
            r365 = r69
            r366 = r104
            r365.visitLabel(r366)
            r365 = r23
            r0 = r365
            if (r0 != 0) goto L_0x361f
            r365 = r80
            r0 = r365
            if (r0 == 0) goto L_0x361f
            r0 = 0
            r365 = r0
            r106 = r365
            r365 = r81
            r0 = r365
            if (r0 == 0) goto L_0x34a7
            r0 = 3
            r365 = r0
            r366 = r3
            r367 = r81
            int r0 = r366.readUnsignedShort(r367)
            r366 = r0
            r0 = r365
            r1 = r366
            int r0 = r0 * r1
            r365 = r0
            r116 = r365
            r365 = r81
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r117 = r365
            r365 = r116
            r0 = r365
            int[] r0 = new int[r0]
            r365 = r0
            r106 = r365
            r365 = r116
            r0 = r365
            if (r0 <= 0) goto L_0x34a7
            r365 = r116
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + -1
            r365 = r0
            r118 = r365
            r365 = r106
            r366 = r118
            r367 = r117
            r0 = 6
            r368 = r0
            r0 = r367
            int r0 = r0 + 6
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r118
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + -1
            r365 = r0
            r119 = r365
            r365 = r106
            r366 = r119
            r367 = r3
            r368 = r117
            r0 = 8
            r369 = r0
            r0 = r368
            int r0 = r0 + 8
            r368 = r0
            int r0 = r367.readUnsignedShort(r368)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            r365 = r119
            r0 = 1
            r366 = r0
            r0 = r365
            int r0 = r0 + -1
            r365 = r0
            r116 = r365
            r365 = r106
            r366 = r116
            r367 = r3
            r368 = r117
            int r0 = r367.readUnsignedShort(r368)
            r367 = r0
            r0 = r367
            r1 = r365
            r2 = r366
            r1[r2] = r0
            int r117 = r117 + 10
            goto L_0x340e
            r365 = r3
            r366 = r80
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r107 = r365
            r365 = r80
            r0 = 2
            r366 = r0
            r0 = r365
            int r0 = r0 + 2
            r365 = r0
            r108 = r365
            r365 = r107
            r109 = r365
            r365 = r109
            r0 = r365
            if (r0 <= 0) goto L_0x361f
            r365 = r3
            r366 = r108
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r110 = r365
            r365 = r3
            r366 = r108
            r0 = 2
            r367 = r0
            r0 = r366
            int r0 = r0 + 2
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r111 = r365
            r365 = r3
            r366 = r108
            r0 = 8
            r367 = r0
            r0 = r366
            int r0 = r0 + 8
            r366 = r0
            int r0 = r365.readUnsignedShort(r366)
            r365 = r0
            r112 = r365
            r0 = 0
            r365 = r0
            r113 = r365
            r365 = r106
            r0 = r365
            if (r0 == 0) goto L_0x35aa
            r0 = 0
            r365 = r0
            r114 = r365
            r365 = r106
            r0 = r365
            int r0 = r0.length
            r365 = r0
            r115 = r365
            r0 = 0
            r365 = r0
            r113 = r365
            r365 = r114
            r366 = r115
            r0 = r365
            r1 = r366
            if (r0 >= r1) goto L_0x35aa
            r365 = r106
            r366 = r114
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r366 = r110
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x361b
            r365 = r106
            r366 = r114
            r0 = 1
            r367 = r0
            r0 = r366
            int r0 = r0 + 1
            r366 = r0
            r0 = r365
            r1 = r366
            r0 = r0[r1]
            r365 = r0
            r366 = r112
            r0 = r365
            r1 = r366
            if (r0 != r1) goto L_0x361b
            r365 = r3
            r366 = r106
            r367 = r114
            r0 = 2
            r368 = r0
            r0 = r367
            int r0 = r0 + 2
            r367 = r0
            r0 = r366
            r1 = r367
            r0 = r0[r1]
            r366 = r0
            r367 = r8
            java.lang.String r0 = r365.readUTF8(r366, r367)
            r365 = r0
            r113 = r365
            r365 = r69
            r366 = r3
            r367 = r108
            r0 = 4
            r368 = r0
            r0 = r367
            int r0 = r0 + 4
            r367 = r0
            r368 = r8
            java.lang.String r0 = r366.readUTF8(r367, r368)
            r366 = r0
            r367 = r3
            r368 = r108
            r0 = 6
            r369 = r0
            r0 = r368
            int r0 = r0 + 6
            r368 = r0
            r369 = r8
            java.lang.String r0 = r367.readUTF8(r368, r369)
            r367 = r0
            r368 = r113
            r369 = r75
            r370 = r110
            r0 = r369
            r1 = r370
            r0 = r0[r1]
            r369 = r0
            r370 = r75
            r371 = r110
            r372 = r111
            r0 = r371
            r1 = r372
            int r0 = r0 + r1
            r371 = r0
            r0 = r370
            r1 = r371
            r0 = r0[r1]
            r370 = r0
            r371 = r112
            r365.visitLocalVariable(r366, r367, r368, r369, r370, r371)
            int r108 = r108 + 10
            int r109 = r109 + -1
            goto L_0x34cb
            int r114 = r114 + 3
            goto L_0x3529
            r365 = r86
            r0 = r365
            if (r0 == 0) goto L_0x364e
            r365 = r86
            r0 = r365
            org.objectweb.asm.Attribute r0 = r0.f277a
            r365 = r0
            r105 = r365
            r365 = r86
            r0 = 0
            r366 = r0
            r0 = r366
            r1 = r365
            r1.f277a = r0
            r365 = r69
            r366 = r86
            r365.visitAttribute(r366)
            r365 = r105
            r86 = r365
            goto L_0x361f
            r365 = r69
            r366 = r70
            r367 = r71
            r365.visitMaxs(r366, r367)
        L_0x365a:
            r365 = r69
            r0 = r365
            if (r0 == 0) goto L_0x16a4
            r365 = r69
            r365.visitEnd()
            goto L_0x16a4
        L_0x3669:
            r365 = r4
            r365.visitEnd()
            return
            r365 = r164
            r167 = r365
            r365 = r160
            r158 = r365
            r365 = r160
            r98 = r365
            r365 = r159
            r168 = r365
            r0 = 0
            r365 = r0
            r169 = r365
            goto L_0x2761
            r0 = 0
            r365 = r0
            r184 = r365
            goto L_0x231d
            r0 = 0
            r365 = r0
            r184 = r365
            goto L_0x2345
            r0 = 0
            r365 = r0
            r91 = r365
            r0 = 0
            r365 = r0
            r92 = r365
            r0 = 0
            r365 = r0
            r93 = r365
            r0 = 0
            r365 = r0
            r94 = r365
            goto L_0x261d
            r365 = r85
            r202 = r365
            r365 = r84
            r205 = r365
            r365 = r83
            r203 = r365
            r365 = r82
            r206 = r365
            r365 = r81
            r204 = r365
            r365 = r80
            r207 = r365
            goto L_0x1fc1
            r365 = r84
            r205 = r365
            r365 = r83
            r203 = r365
            r365 = r82
            r206 = r365
            r365 = r81
            r204 = r365
            r365 = r219
            r207 = r365
            r365 = r85
            r202 = r365
            goto L_0x1fc1
            r365 = r201
            r210 = r365
            goto L_0x22ae
            r365 = r85
            r202 = r365
            r365 = r83
            r203 = r365
            r365 = r201
            r86 = r365
            r365 = r81
            r204 = r365
            r365 = r84
            r205 = r365
            r365 = r82
            r206 = r365
            r365 = r80
            r207 = r365
            goto L_0x1fc1
        L_0x3722:
            r365 = r262
            r263 = r365
            goto L_0x167a
        L_0x372a:
            r365 = r65
            r68 = r365
            goto L_0x15f4
        L_0x3731:
            r365 = r58
            r271 = r365
            r365 = r57
            r272 = r365
            r365 = r56
            r273 = r365
            r365 = r61
            r274 = r365
            r365 = r60
            r275 = r365
            r365 = r50
            r276 = r365
            r365 = r59
            r277 = r365
            r365 = r55
            r278 = r365
            r365 = r54
            r279 = r365
            goto L_0x124a
        L_0x3769:
            r365 = r287
            r309 = r365
            r365 = r284
            r310 = r365
            r365 = r291
            r311 = r365
            r365 = r290
            r312 = r365
            r365 = r289
            r313 = r365
            goto L_0x0d35
        L_0x3789:
            r365 = r37
            r337 = r365
            r365 = r36
            r338 = r365
            r365 = r35
            r339 = r365
            r365 = r34
            r340 = r365
            r365 = r33
            r341 = r365
            r365 = r32
            r342 = r365
            r365 = r18
            r343 = r365
            r365 = r11
            r344 = r365
            r365 = r10
            r345 = r365
            r365 = r9
            r346 = r365
            goto L_0x039c
        L_0x37c7:
            r365 = r36
            r358 = r365
            r365 = r35
            r359 = r365
            goto L_0x052b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassReader.accept(org.objectweb.asm.ClassVisitor, org.objectweb.asm.Attribute[], int):void");
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(2 + this.header, new char[this.f284d]);
    }

    public String[] getInterfaces() {
        int i = 6 + this.header;
        int readUnsignedShort = readUnsignedShort(i);
        String[] strArr = new String[readUnsignedShort];
        if (readUnsignedShort > 0) {
            char[] cArr = new char[this.f284d];
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                i += 2;
                strArr[i2] = readClass(i, cArr);
            }
        }
        return strArr;
    }

    public int getItem(int i) {
        return this.f281a[i];
    }

    public int getItemCount() {
        return this.f281a.length;
    }

    public int getMaxStringLength() {
        return this.f284d;
    }

    public String getSuperName() {
        int i = this.f281a[readUnsignedShort(4 + this.header)];
        if (i == 0) {
            return null;
        }
        return readUTF8(i, new char[this.f284d]);
    }

    public int readByte(int i) {
        return 255 & this.f282b[i];
    }

    public String readClass(int i, char[] cArr) {
        return readUTF8(this.f281a[readUnsignedShort(i)], cArr);
    }

    public Object readConst(int i, char[] cArr) {
        Double d;
        Long l;
        Float f;
        Integer num;
        Handle handle;
        char[] cArr2 = cArr;
        int i2 = this.f281a[i];
        switch (this.f282b[i2 - 1]) {
            case 3:
                Integer num2 = num;
                Integer num3 = new Integer(readInt(i2));
                return num2;
            case 4:
                Float f2 = f;
                Float f3 = new Float(Float.intBitsToFloat(readInt(i2)));
                return f2;
            case 5:
                Long l2 = l;
                Long l3 = new Long(readLong(i2));
                return l2;
            case 6:
                Double d2 = d;
                Double d3 = new Double(Double.longBitsToDouble(readLong(i2)));
                return d2;
            case 7:
                return Type.getObjectType(readUTF8(i2, cArr2));
            case 8:
                return readUTF8(i2, cArr2);
            case 16:
                return Type.getMethodType(readUTF8(i2, cArr2));
            default:
                int readByte = readByte(i2);
                int[] iArr = this.f281a;
                int i3 = iArr[readUnsignedShort(i2 + 1)];
                String readClass = readClass(i3, cArr2);
                int i4 = iArr[readUnsignedShort(i3 + 2)];
                Handle handle2 = handle;
                Handle handle3 = new Handle(readByte, readClass, readUTF8(i4, cArr2), readUTF8(i4 + 2, cArr2));
                return handle2;
        }
    }

    public int readInt(int i) {
        int i2 = i;
        byte[] bArr = this.f282b;
        return ((255 & bArr[i2]) << 24) | ((255 & bArr[i2 + 1]) << 16) | ((255 & bArr[i2 + 2]) << 8) | (255 & bArr[i2 + 3]);
    }

    /* access modifiers changed from: protected */
    public Label readLabel(int i, Label[] labelArr) {
        Label label;
        int i2 = i;
        Label[] labelArr2 = labelArr;
        if (labelArr2[i2] == null) {
            Label[] labelArr3 = labelArr2;
            int i3 = i2;
            Label label2 = label;
            Label label3 = new Label();
            labelArr3[i3] = label2;
        }
        return labelArr2[i2];
    }

    public long readLong(int i) {
        int i2 = i;
        return (4294967295L & ((long) readInt(i2 + 4))) | (((long) readInt(i2)) << 32);
    }

    public short readShort(int i) {
        int i2 = i;
        byte[] bArr = this.f282b;
        return (short) (((255 & bArr[i2]) << 8) | (255 & bArr[i2 + 1]));
    }

    public String readUTF8(int i, char[] cArr) {
        char[] cArr2 = cArr;
        int readUnsignedShort = readUnsignedShort(i);
        String str = this.f283c[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i2 = this.f281a[readUnsignedShort];
        String[] strArr = this.f283c;
        String a = m69a(i2 + 2, readUnsignedShort(i2), cArr2);
        strArr[readUnsignedShort] = a;
        return a;
    }

    public int readUnsignedShort(int i) {
        int i2 = i;
        byte[] bArr = this.f282b;
        return ((255 & bArr[i2]) << 8) | (255 & bArr[i2 + 1]);
    }
}
