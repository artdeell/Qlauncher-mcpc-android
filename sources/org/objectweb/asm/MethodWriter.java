package org.objectweb.asm;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.opengl.GL11;

class MethodWriter extends MethodVisitor {

    /* renamed from: A */
    private int f377A;

    /* renamed from: B */
    private Handler f378B;

    /* renamed from: C */
    private Handler f379C;

    /* renamed from: D */
    private int f380D;

    /* renamed from: E */
    private ByteVector f381E;

    /* renamed from: F */
    private int f382F;

    /* renamed from: G */
    private ByteVector f383G;

    /* renamed from: H */
    private int f384H;

    /* renamed from: I */
    private ByteVector f385I;

    /* renamed from: J */
    private Attribute f386J;

    /* renamed from: K */
    private boolean f387K;

    /* renamed from: L */
    private int f388L;

    /* renamed from: M */
    private final int f389M;

    /* renamed from: N */
    private Label f390N;

    /* renamed from: O */
    private Label f391O;

    /* renamed from: P */
    private Label f392P;

    /* renamed from: Q */
    private int f393Q;

    /* renamed from: R */
    private int f394R;

    /* renamed from: S */
    private int f395S;

    /* renamed from: T */
    private int f396T;

    /* renamed from: b */
    final ClassWriter f397b;

    /* renamed from: c */
    private int f398c;

    /* renamed from: d */
    private final int f399d;

    /* renamed from: e */
    private final int f400e;

    /* renamed from: f */
    private final String f401f;

    /* renamed from: g */
    String f402g;

    /* renamed from: h */
    int f403h;

    /* renamed from: i */
    int f404i;

    /* renamed from: j */
    int f405j;

    /* renamed from: k */
    int[] f406k;

    /* renamed from: l */
    private ByteVector f407l;

    /* renamed from: m */
    private AnnotationWriter f408m;

    /* renamed from: n */
    private AnnotationWriter f409n;

    /* renamed from: o */
    private AnnotationWriter[] f410o;

    /* renamed from: p */
    private AnnotationWriter[] f411p;

    /* renamed from: q */
    private Attribute f412q;

    /* renamed from: r */
    private ByteVector f413r;

    /* renamed from: s */
    private int f414s;

    /* renamed from: t */
    private int f415t;

    /* renamed from: u */
    private int f416u;

    /* renamed from: v */
    private ByteVector f417v;

    /* renamed from: w */
    private int f418w;

    /* renamed from: x */
    private int[] f419x;

    /* renamed from: y */
    private int f420y;

    /* renamed from: z */
    private int[] f421z;

    MethodWriter(ClassWriter classWriter, int i, String str, String str2, String str3, String[] strArr, boolean z, boolean z2) {
        ByteVector byteVector;
        Label label;
        ClassWriter classWriter2 = classWriter;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        boolean z3 = z;
        boolean z4 = z2;
        super(262144);
        ByteVector byteVector2 = byteVector;
        ByteVector byteVector3 = new ByteVector();
        this.f413r = byteVector2;
        if (classWriter2.f290D == null) {
            classWriter2.f290D = this;
        } else {
            classWriter2.f291E.f376mv = this;
        }
        classWriter2.f291E = this;
        this.f397b = classWriter2;
        this.f398c = i2;
        this.f399d = classWriter2.newUTF8(str4);
        this.f400e = classWriter2.newUTF8(str5);
        this.f401f = str5;
        this.f402g = str6;
        if (strArr2 != null && strArr2.length > 0) {
            this.f405j = strArr2.length;
            this.f406k = new int[this.f405j];
            for (int i3 = 0; i3 < this.f405j; i3++) {
                this.f406k[i3] = classWriter2.newClass(strArr2[i3]);
            }
        }
        int i4 = 0;
        if (!z4) {
            i4 = z3 ? 1 : 2;
        }
        this.f389M = i4;
        if (z3 || z4) {
            if (z4 && "<init>".equals(str4)) {
                this.f398c = 262144 | this.f398c;
            }
            int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(this.f401f) >> 2;
            if ((i2 & 8) != 0) {
                argumentsAndReturnSizes--;
            }
            this.f415t = argumentsAndReturnSizes;
            this.f396T = argumentsAndReturnSizes;
            Label label2 = label;
            Label label3 = new Label();
            this.f390N = label2;
            Label label4 = this.f390N;
            label4.f365a = 8 | label4.f365a;
            visitLabel(this.f390N);
        }
    }

    /* renamed from: a */
    static int m129a(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        int i2 = i;
        return ((255 & bArr2[i2]) << 24) | ((255 & bArr2[i2 + 1]) << 16) | ((255 & bArr2[i2 + 2]) << 8) | (255 & bArr2[i2 + 3]);
    }

    /* renamed from: a */
    static int m130a(int[] iArr, int[] iArr2, int i, int i2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i3 = i;
        int i4 = i2;
        int i5 = i4 - i3;
        for (int i6 = 0; i6 < iArr3.length; i6++) {
            if (i3 < iArr3[i6] && iArr3[i6] <= i4) {
                i5 += iArr4[i6];
            } else if (i4 < iArr3[i6] && iArr3[i6] <= i3) {
                i5 -= iArr4[i6];
            }
        }
        return i5;
    }

    /* renamed from: a */
    private void m131a(int i, int i2) {
        StringBuffer stringBuffer;
        int i3 = i2;
        for (int i4 = i; i4 < i3; i4++) {
            int i5 = this.f421z[i4];
            int i6 = -268435456 & i5;
            if (i6 == 0) {
                int i7 = i5 & GL11.GL_ALL_ATTRIB_BITS;
                switch (i5 & 267386880) {
                    case 24117248:
                        ByteVector putShort = this.f417v.putByte(7).putShort(this.f397b.newClass(this.f397b.f293H[i7].f360g));
                        break;
                    case 25165824:
                        ByteVector putShort2 = this.f417v.putByte(8).putShort(this.f397b.f293H[i7].f358c);
                        break;
                    default:
                        ByteVector putByte = this.f417v.putByte(i7);
                        break;
                }
            } else {
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                StringBuffer stringBuffer4 = stringBuffer2;
                int i8 = i6 >> 28;
                while (true) {
                    int i9 = i8;
                    int i10 = i9 - 1;
                    if (i9 > 0) {
                        StringBuffer append = stringBuffer4.append('[');
                        i8 = i10;
                    } else {
                        if ((i5 & 267386880) != 24117248) {
                            switch (i5 & 15) {
                                case 1:
                                    StringBuffer append2 = stringBuffer4.append('I');
                                    break;
                                case 2:
                                    StringBuffer append3 = stringBuffer4.append('F');
                                    break;
                                case 3:
                                    StringBuffer append4 = stringBuffer4.append('D');
                                    break;
                                case 9:
                                    StringBuffer append5 = stringBuffer4.append('Z');
                                    break;
                                case 10:
                                    StringBuffer append6 = stringBuffer4.append('B');
                                    break;
                                case 11:
                                    StringBuffer append7 = stringBuffer4.append('C');
                                    break;
                                case 12:
                                    StringBuffer append8 = stringBuffer4.append('S');
                                    break;
                                default:
                                    StringBuffer append9 = stringBuffer4.append('J');
                                    break;
                            }
                        } else {
                            StringBuffer append10 = stringBuffer4.append('L');
                            StringBuffer append11 = stringBuffer4.append(this.f397b.f293H[i5 & GL11.GL_ALL_ATTRIB_BITS].f360g);
                            StringBuffer append12 = stringBuffer4.append(';');
                        }
                        ByteVector putShort3 = this.f417v.putByte(7).putShort(this.f397b.newClass(stringBuffer4.toString()));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m132a(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        int i7 = i6 + i5 + 3;
        if (this.f421z == null || this.f421z.length < i7) {
            this.f421z = new int[i7];
        }
        this.f421z[0] = i4;
        this.f421z[1] = i5;
        this.f421z[2] = i6;
        this.f420y = 3;
    }

    /* renamed from: a */
    private void m133a(int i, Label label) {
        Edge edge;
        int i2 = i;
        Label label2 = label;
        Edge edge2 = edge;
        Edge edge3 = new Edge();
        Edge edge4 = edge2;
        edge4.f324a = i2;
        edge4.f325b = label2;
        edge4.f326c = this.f392P.f374j;
        this.f392P.f374j = edge4;
    }

    /* renamed from: a */
    private void m134a(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof String) {
            ByteVector putShort = this.f417v.putByte(7).putShort(this.f397b.newClass((String) obj2));
        } else if (obj2 instanceof Integer) {
            ByteVector putByte = this.f417v.putByte(((Integer) obj2).intValue());
        } else {
            ByteVector putShort2 = this.f417v.putByte(8).putShort(((Label) obj2).f367c);
        }
    }

    /* renamed from: a */
    private void m135a(Label label, Label[] labelArr) {
        Label label2 = label;
        Label[] labelArr2 = labelArr;
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(171, 0, (ClassWriter) null, (Item) null);
                m133a(0, label2);
                Label a = label2.mo11188a();
                a.f365a = 16 | a.f365a;
                for (int i = 0; i < labelArr2.length; i++) {
                    m133a(0, labelArr2[i]);
                    Label a2 = labelArr2[i].mo11188a();
                    a2.f365a = 16 | a2.f365a;
                }
            } else {
                this.f393Q = -1 + this.f393Q;
                m133a(this.f393Q, label2);
                for (int i2 = 0; i2 < labelArr2.length; i2++) {
                    m133a(this.f393Q, labelArr2[i2]);
                }
            }
            m144e();
        }
    }

    /* renamed from: a */
    static void m136a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        bArr2[i3] = (byte) (i4 >>> 8);
        bArr2[i3 + 1] = (byte) i4;
    }

    /* renamed from: a */
    static void m137a(int[] iArr, int[] iArr2, Label label) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        Label label2 = label;
        if ((4 & label2.f365a) == 0) {
            label2.f367c = m130a(iArr3, iArr4, 0, label2.f367c);
            label2.f365a = 4 | label2.f365a;
        }
    }

    /* renamed from: b */
    static short m138b(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        int i2 = i;
        return (short) (((255 & bArr2[i2]) << 8) | (255 & bArr2[i2 + 1]));
    }

    /* renamed from: b */
    private void m139b() {
        ByteVector byteVector;
        if (this.f419x != null) {
            if (this.f417v == null) {
                ByteVector byteVector2 = byteVector;
                ByteVector byteVector3 = new ByteVector();
                this.f417v = byteVector2;
            }
            m142c();
            this.f416u = 1 + this.f416u;
        }
        this.f419x = this.f421z;
        this.f421z = null;
    }

    /* renamed from: b */
    private void m140b(Frame frame) {
        int i;
        Frame frame2 = frame;
        int[] iArr = frame2.f339c;
        int[] iArr2 = frame2.f340d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < iArr.length) {
            int i5 = iArr[i2];
            if (i5 == 16777216) {
                i4++;
            } else {
                i3 += i4 + 1;
                i4 = 0;
            }
            if (i5 == 16777220 || i5 == 16777219) {
                i2++;
            }
            i2++;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < iArr2.length) {
            int i8 = iArr2[i6];
            i7++;
            if (i8 == 16777220 || i8 == 16777219) {
                i6++;
            }
            i6++;
        }
        m132a(frame2.f338b.f367c, i3, i7);
        int i9 = 0;
        while (true) {
            i = 0;
            if (i3 <= 0) {
                break;
            }
            int i10 = iArr[i9];
            int[] iArr3 = this.f421z;
            int i11 = this.f420y;
            this.f420y = i11 + 1;
            iArr3[i11] = i10;
            if (i10 == 16777220 || i10 == 16777219) {
                i9++;
            }
            i9++;
            i3--;
        }
        while (i < iArr2.length) {
            int i12 = iArr2[i];
            int[] iArr4 = this.f421z;
            int i13 = this.f420y;
            this.f420y = i13 + 1;
            iArr4[i13] = i12;
            if (i12 == 16777220 || i12 == 16777219) {
                i++;
            }
            i++;
        }
        m139b();
    }

    /* renamed from: c */
    static int m141c(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        int i2 = i;
        return ((255 & bArr2[i2]) << 8) | (255 & bArr2[i2 + 1]);
    }

    /* renamed from: c */
    private void m142c() {
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2 = true;
        int i4 = 0;
        int i5 = this.f421z[1];
        int i6 = this.f421z[2];
        if ((65535 & this.f397b.f299b) < 50) {
            ByteVector putShort = this.f417v.putShort(this.f421z[0]).putShort(i5);
            m131a(3, i5 + 3);
            ByteVector putShort2 = this.f417v.putShort(i6);
            m131a(i5 + 3, i6 + i5 + 3);
            return;
        }
        int i7 = this.f419x[1];
        if (this.f416u == 0) {
            i = this.f421z[0];
        } else {
            i = -1 + (this.f421z[0] - this.f419x[0]);
        }
        if (i6 == 0) {
            i3 = i5 - i7;
            switch (i3) {
                case -3:
                case -2:
                case -1:
                    z = true;
                    i7 = i5;
                    break;
                case 0:
                    if (i >= 64) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case 1:
                case 2:
                case 3:
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            i2 = i7;
        } else if (i5 == i7 && i6 == 1) {
            if (i >= 63) {
                z2 = true;
            }
            i2 = i7;
            i3 = 0;
        } else {
            z = true;
            i2 = i7;
            i3 = 0;
        }
        if (!z) {
            int i8 = 3;
            while (true) {
                if (i4 < i2) {
                    if (this.f421z[i8] != this.f419x[i8]) {
                        z = true;
                    } else {
                        i8++;
                        i4++;
                    }
                }
            }
        }
        switch (z) {
            case false:
                ByteVector putByte = this.f417v.putByte(i);
                return;
            case true:
                ByteVector putByte2 = this.f417v.putByte(i + 64);
                m131a(i5 + 3, i5 + 4);
                return;
            case true:
                ByteVector putShort3 = this.f417v.putByte(247).putShort(i);
                m131a(i5 + 3, i5 + 4);
                return;
            case true:
                ByteVector putShort4 = this.f417v.putByte(i3 + 251).putShort(i);
                return;
            case true:
                ByteVector putShort5 = this.f417v.putByte(251).putShort(i);
                return;
            case true:
                ByteVector putShort6 = this.f417v.putByte(i3 + 251).putShort(i);
                m131a(i2 + 3, i5 + 3);
                return;
            default:
                ByteVector putShort7 = this.f417v.putByte(255).putShort(i).putShort(i5);
                m131a(3, i5 + 3);
                ByteVector putShort8 = this.f417v.putShort(i6);
                m131a(i5 + 3, i6 + i5 + 3);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r29v1 */
    /* JADX WARNING: type inference failed for: r100v112, types: [int] */
    /* JADX WARNING: type inference failed for: r99v204 */
    /* JADX WARNING: type inference failed for: r0v107 */
    /* JADX WARNING: type inference failed for: r99v205 */
    /* JADX WARNING: type inference failed for: r0v108 */
    /* JADX WARNING: type inference failed for: r99v206 */
    /* JADX WARNING: type inference failed for: r0v109 */
    /* JADX WARNING: type inference failed for: r99v207 */
    /* JADX WARNING: type inference failed for: r101v50, types: [int] */
    /* JADX WARNING: type inference failed for: r99v229, types: [int] */
    /* JADX WARNING: type inference failed for: r82v0 */
    /* JADX WARNING: type inference failed for: r82v1 */
    /* JADX WARNING: type inference failed for: r99v232 */
    /* JADX WARNING: type inference failed for: r29v2 */
    /* JADX WARNING: type inference failed for: r99v235, types: [int] */
    /* JADX WARNING: type inference failed for: r82v2 */
    /* JADX WARNING: type inference failed for: r86v1 */
    /* JADX WARNING: type inference failed for: r99v296 */
    /* JADX WARNING: type inference failed for: r0v120 */
    /* JADX WARNING: type inference failed for: r99v299 */
    /* JADX WARNING: type inference failed for: r0v121 */
    /* JADX WARNING: type inference failed for: r99v304, types: [int] */
    /* JADX WARNING: type inference failed for: r97v0 */
    /* JADX WARNING: type inference failed for: r97v1 */
    /* JADX WARNING: type inference failed for: r99v307 */
    /* JADX WARNING: type inference failed for: r86v2 */
    /* JADX WARNING: type inference failed for: r99v310, types: [int] */
    /* JADX WARNING: type inference failed for: r97v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 21 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m143d() {
        /*
            r108 = this;
            r2 = r108
            r99 = r2
            r0 = r99
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r99 = r0
            r0 = r99
            byte[] r0 = r0.f279a
            r99 = r0
            r3 = r99
            r99 = 0
            r0 = r99
            int[] r0 = new int[r0]
            r99 = r0
            r4 = r99
            r99 = 0
            r0 = r99
            int[] r0 = new int[r0]
            r99 = r0
            r5 = r99
            r99 = r2
            r0 = r99
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r99 = r0
            r0 = r99
            int r0 = r0.f280b
            r99 = r0
            r0 = r99
            boolean[] r0 = new boolean[r0]
            r99 = r0
            r6 = r99
            r99 = 3
            r7 = r99
        L_0x0040:
            r99 = r7
            r100 = 3
            r0 = r99
            r1 = r100
            if (r0 != r1) goto L_0x004e
            r99 = 2
            r7 = r99
        L_0x004e:
            r99 = r7
            r8 = r99
            r99 = 0
            r9 = r99
        L_0x0056:
            r99 = r9
            r100 = r3
            r0 = r100
            int r0 = r0.length
            r100 = r0
            r0 = r99
            r1 = r100
            if (r0 >= r1) goto L_0x02de
            r99 = 255(0xff, float:3.57E-43)
            r100 = r3
            r101 = r9
            byte r100 = r100[r101]
            r99 = r99 & r100
            r86 = r99
            r99 = 0
            r87 = r99
            byte[] r99 = org.objectweb.asm.ClassWriter.f286a
            r100 = r86
            byte r99 = r99[r100]
            switch(r99) {
                case 0: goto L_0x00fa;
                case 1: goto L_0x02c6;
                case 2: goto L_0x02ce;
                case 3: goto L_0x02c6;
                case 4: goto L_0x00fa;
                case 5: goto L_0x02ce;
                case 6: goto L_0x02ce;
                case 7: goto L_0x02d6;
                case 8: goto L_0x02d6;
                case 9: goto L_0x0101;
                case 10: goto L_0x01aa;
                case 11: goto L_0x02c6;
                case 12: goto L_0x02ce;
                case 13: goto L_0x02ce;
                case 14: goto L_0x01b2;
                case 15: goto L_0x0232;
                case 16: goto L_0x007e;
                case 17: goto L_0x02a0;
                default: goto L_0x007e;
            }
        L_0x007e:
            int r9 = r9 + 4
        L_0x0080:
            r99 = r87
            if (r99 == 0) goto L_0x0056
            r99 = 1
            r100 = r4
            r0 = r100
            int r0 = r0.length
            r100 = r0
            int r99 = r99 + r100
            r0 = r99
            int[] r0 = new int[r0]
            r99 = r0
            r88 = r99
            r99 = 1
            r100 = r5
            r0 = r100
            int r0 = r0.length
            r100 = r0
            int r99 = r99 + r100
            r0 = r99
            int[] r0 = new int[r0]
            r99 = r0
            r89 = r99
            r99 = r4
            r100 = 0
            r101 = r88
            r102 = 0
            r103 = r4
            r0 = r103
            int r0 = r0.length
            r103 = r0
            java.lang.System.arraycopy(r99, r100, r101, r102, r103)
            r99 = r5
            r100 = 0
            r101 = r89
            r102 = 0
            r103 = r5
            r0 = r103
            int r0 = r0.length
            r103 = r0
            java.lang.System.arraycopy(r99, r100, r101, r102, r103)
            r99 = r88
            r100 = r4
            r0 = r100
            int r0 = r0.length
            r100 = r0
            r101 = r9
            r99[r100] = r101
            r99 = r89
            r100 = r5
            r0 = r100
            int r0 = r0.length
            r100 = r0
            r101 = r87
            r99[r100] = r101
            r99 = r87
            if (r99 <= 0) goto L_0x090c
            r99 = 3
            r8 = r99
            r99 = r89
            r5 = r99
            r99 = r88
            r4 = r99
            goto L_0x0056
        L_0x00fa:
            int r9 = r9 + 1
            r99 = 0
            r87 = r99
            goto L_0x0080
        L_0x0101:
            r99 = r86
            r100 = 201(0xc9, float:2.82E-43)
            r0 = r99
            r1 = r100
            if (r0 <= r1) goto L_0x0192
            r99 = r86
            r100 = 218(0xda, float:3.05E-43)
            r0 = r99
            r1 = r100
            if (r0 >= r1) goto L_0x0189
            r99 = r86
            r100 = 49
            int r99 = r99 + -49
            r97 = r99
        L_0x011d:
            r99 = r9
            r100 = r3
            r101 = r9
            r102 = 1
            int r101 = r101 + 1
            int r100 = m141c(r100, r101)
            int r99 = r99 + r100
            r98 = r99
            r99 = r97
            r86 = r99
            r99 = r98
            r94 = r99
        L_0x0137:
            r99 = r4
            r100 = r5
            r101 = r9
            r102 = r94
            int r99 = m130a(r99, r100, r101, r102)
            r95 = r99
            r99 = r95
            r100 = -32768(0xffffffffffff8000, float:NaN)
            r0 = r99
            r1 = r100
            if (r0 < r1) goto L_0x0159
            r99 = r95
            r100 = 32767(0x7fff, float:4.5916E-41)
            r0 = r99
            r1 = r100
            if (r0 <= r1) goto L_0x0916
        L_0x0159:
            r99 = r6
            r100 = r9
            boolean r99 = r99[r100]
            if (r99 != 0) goto L_0x0916
            r99 = r86
            r100 = 167(0xa7, float:2.34E-43)
            r0 = r99
            r1 = r100
            if (r0 == r1) goto L_0x0175
            r99 = r86
            r100 = 168(0xa8, float:2.35E-43)
            r0 = r99
            r1 = r100
            if (r0 != r1) goto L_0x01a5
        L_0x0175:
            r99 = 2
            r96 = r99
        L_0x0179:
            r99 = r6
            r100 = r9
            r101 = 1
            r99[r100] = r101
        L_0x0181:
            int r9 = r9 + 3
            r99 = r96
            r87 = r99
            goto L_0x0080
        L_0x0189:
            r99 = r86
            r100 = 20
            int r99 = r99 + -20
            r97 = r99
            goto L_0x011d
        L_0x0192:
            r99 = r9
            r100 = r3
            r101 = r9
            r102 = 1
            int r101 = r101 + 1
            short r100 = m138b(r100, r101)
            int r99 = r99 + r100
            r94 = r99
            goto L_0x0137
        L_0x01a5:
            r99 = 5
            r96 = r99
            goto L_0x0179
        L_0x01aa:
            int r9 = r9 + 5
            r99 = 0
            r87 = r99
            goto L_0x0080
        L_0x01b2:
            r99 = r8
            r100 = 1
            r0 = r99
            r1 = r100
            if (r0 != r1) goto L_0x0211
            r99 = 3
            r100 = r4
            r101 = r5
            r102 = 0
            r103 = r9
            int r100 = m130a(r100, r101, r102, r103)
            r99 = r99 & r100
            r0 = r99
            int r0 = -r0
            r99 = r0
            r87 = r99
        L_0x01d3:
            r99 = r9
            r100 = 4
            int r99 = r99 + 4
            r100 = r9
            r101 = 3
            r100 = r100 & 3
            int r99 = r99 - r100
            r93 = r99
            r99 = r93
            r100 = 12
            r101 = 4
            r102 = 1
            r103 = r3
            r104 = r93
            r105 = 8
            int r104 = r104 + 8
            int r103 = m129a(r103, r104)
            r104 = r3
            r105 = r93
            r106 = 4
            int r105 = r105 + 4
            int r104 = m129a(r104, r105)
            int r103 = r103 - r104
            int r102 = r102 + r103
            int r101 = r101 * r102
            int r100 = r100 + r101
            int r99 = r99 + r100
            r9 = r99
            goto L_0x0080
        L_0x0211:
            r99 = r6
            r100 = r9
            boolean r99 = r99[r100]
            r92 = r99
            r99 = 0
            r87 = r99
            r99 = r92
            if (r99 != 0) goto L_0x01d3
            r99 = r9
            r100 = 3
            r99 = r99 & 3
            r87 = r99
            r99 = r6
            r100 = r9
            r101 = 1
            r99[r100] = r101
            goto L_0x01d3
        L_0x0232:
            r99 = r8
            r100 = 1
            r0 = r99
            r1 = r100
            if (r0 != r1) goto L_0x027f
            r99 = 3
            r100 = r4
            r101 = r5
            r102 = 0
            r103 = r9
            int r100 = m130a(r100, r101, r102, r103)
            r99 = r99 & r100
            r0 = r99
            int r0 = -r0
            r99 = r0
            r87 = r99
        L_0x0253:
            r99 = r9
            r100 = 4
            int r99 = r99 + 4
            r100 = r9
            r101 = 3
            r100 = r100 & 3
            int r99 = r99 - r100
            r91 = r99
            r99 = r91
            r100 = 8
            r101 = 8
            r102 = r3
            r103 = r91
            r104 = 4
            int r103 = r103 + 4
            int r102 = m129a(r102, r103)
            int r101 = r101 * r102
            int r100 = r100 + r101
            int r99 = r99 + r100
            r9 = r99
            goto L_0x0080
        L_0x027f:
            r99 = r6
            r100 = r9
            boolean r99 = r99[r100]
            r90 = r99
            r99 = 0
            r87 = r99
            r99 = r90
            if (r99 != 0) goto L_0x0253
            r99 = r9
            r100 = 3
            r99 = r99 & 3
            r87 = r99
            r99 = r6
            r100 = r9
            r101 = 1
            r99[r100] = r101
            goto L_0x0253
        L_0x02a0:
            r99 = 255(0xff, float:3.57E-43)
            r100 = r3
            r101 = r9
            r102 = 1
            int r101 = r101 + 1
            byte r100 = r100[r101]
            r99 = r99 & r100
            r100 = 132(0x84, float:1.85E-43)
            r0 = r99
            r1 = r100
            if (r0 != r1) goto L_0x02be
            int r9 = r9 + 6
            r99 = 0
            r87 = r99
            goto L_0x0080
        L_0x02be:
            int r9 = r9 + 4
            r99 = 0
            r87 = r99
            goto L_0x0080
        L_0x02c6:
            int r9 = r9 + 2
            r99 = 0
            r87 = r99
            goto L_0x0080
        L_0x02ce:
            int r9 = r9 + 3
            r99 = 0
            r87 = r99
            goto L_0x0080
        L_0x02d6:
            int r9 = r9 + 5
            r99 = 0
            r87 = r99
            goto L_0x0080
        L_0x02de:
            r99 = r8
            r100 = 3
            r0 = r99
            r1 = r100
            if (r0 >= r1) goto L_0x02ea
            int r8 = r8 + -1
        L_0x02ea:
            r99 = r8
            if (r99 != 0) goto L_0x0906
            org.objectweb.asm.ByteVector r99 = new org.objectweb.asm.ByteVector
            r107 = r99
            r99 = r107
            r100 = r107
            r101 = r2
            r0 = r101
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r101 = r0
            r0 = r101
            int r0 = r0.f280b
            r101 = r0
            r100.<init>(r101)
            r10 = r99
            r99 = 0
            r11 = r99
        L_0x030d:
            r99 = r11
            r100 = r2
            r0 = r100
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r100 = r0
            r0 = r100
            int r0 = r0.f280b
            r100 = r0
            r0 = r99
            r1 = r100
            if (r0 >= r1) goto L_0x0687
            r99 = 255(0xff, float:3.57E-43)
            r100 = r3
            r101 = r11
            byte r100 = r100[r101]
            r99 = r99 & r100
            r29 = r99
            byte[] r99 = org.objectweb.asm.ClassWriter.f286a
            r100 = r29
            byte r99 = r99[r100]
            switch(r99) {
                case 0: goto L_0x0347;
                case 1: goto L_0x0657;
                case 2: goto L_0x0667;
                case 3: goto L_0x0657;
                case 4: goto L_0x0347;
                case 5: goto L_0x0667;
                case 6: goto L_0x0667;
                case 7: goto L_0x0677;
                case 8: goto L_0x0677;
                case 9: goto L_0x0352;
                case 10: goto L_0x0449;
                case 11: goto L_0x0657;
                case 12: goto L_0x0667;
                case 13: goto L_0x0667;
                case 14: goto L_0x0479;
                case 15: goto L_0x0558;
                case 16: goto L_0x0338;
                case 17: goto L_0x0621;
                default: goto L_0x0338;
            }
        L_0x0338:
            r99 = r10
            r100 = r3
            r101 = r11
            r102 = 4
            org.objectweb.asm.ByteVector r99 = r99.putByteArray(r100, r101, r102)
            int r11 = r11 + 4
            goto L_0x030d
        L_0x0347:
            r99 = r10
            r100 = r29
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            int r11 = r11 + 1
            goto L_0x030d
        L_0x0352:
            r99 = r29
            r100 = 201(0xc9, float:2.82E-43)
            r0 = r99
            r1 = r100
            if (r0 <= r1) goto L_0x03c9
            r99 = r29
            r100 = 218(0xda, float:3.05E-43)
            r0 = r99
            r1 = r100
            if (r0 >= r1) goto L_0x03c0
            r99 = r29
            r100 = 49
            int r99 = r99 + -49
            r82 = r99
        L_0x036e:
            r99 = r11
            r100 = r3
            r101 = r11
            r102 = 1
            int r101 = r101 + 1
            int r100 = m141c(r100, r101)
            int r99 = r99 + r100
            r83 = r99
            r99 = r82
            r29 = r99
            r99 = r83
            r70 = r99
        L_0x0388:
            r99 = r4
            r100 = r5
            r101 = r11
            r102 = r70
            int r99 = m130a(r99, r100, r101, r102)
            r71 = r99
            r99 = r6
            r100 = r11
            boolean r99 = r99[r100]
            if (r99 == 0) goto L_0x0437
            r99 = r29
            r100 = 167(0xa7, float:2.34E-43)
            r0 = r99
            r1 = r100
            if (r0 != r1) goto L_0x03dc
            r99 = r10
            r100 = 200(0xc8, float:2.8E-43)
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            r99 = r71
            r78 = r99
        L_0x03b4:
            r99 = r10
            r100 = r78
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
        L_0x03bc:
            int r11 = r11 + 3
            goto L_0x030d
        L_0x03c0:
            r99 = r29
            r100 = 20
            int r99 = r99 + -20
            r82 = r99
            goto L_0x036e
        L_0x03c9:
            r99 = r11
            r100 = r3
            r101 = r11
            r102 = 1
            int r101 = r101 + 1
            short r100 = m138b(r100, r101)
            int r99 = r99 + r100
            r70 = r99
            goto L_0x0388
        L_0x03dc:
            r99 = r29
            r100 = 168(0xa8, float:2.35E-43)
            r0 = r99
            r1 = r100
            if (r0 != r1) goto L_0x03f3
            r99 = r10
            r100 = 201(0xc9, float:2.82E-43)
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            r99 = r71
            r78 = r99
            goto L_0x03b4
        L_0x03f3:
            r99 = r29
            r100 = 166(0xa6, float:2.33E-43)
            r0 = r99
            r1 = r100
            if (r0 > r1) goto L_0x042e
            r99 = -1
            r100 = 1
            r101 = r29
            r102 = 1
            int r101 = r101 + 1
            r100 = r100 ^ r101
            int r99 = r99 + r100
            r74 = r99
        L_0x040d:
            r99 = r10
            r100 = r74
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            r99 = r10
            r100 = 8
            org.objectweb.asm.ByteVector r99 = r99.putShort(r100)
            r99 = r10
            r100 = 200(0xc8, float:2.8E-43)
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            r99 = r71
            r100 = 3
            int r99 = r99 + -3
            r78 = r99
            goto L_0x03b4
        L_0x042e:
            r99 = r29
            r100 = 1
            r99 = r99 ^ 1
            r74 = r99
            goto L_0x040d
        L_0x0437:
            r99 = r10
            r100 = r29
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            r99 = r10
            r100 = r71
            org.objectweb.asm.ByteVector r99 = r99.putShort(r100)
            goto L_0x03bc
        L_0x0449:
            r99 = r4
            r100 = r5
            r101 = r11
            r102 = r11
            r103 = r3
            r104 = r11
            r105 = 1
            int r104 = r104 + 1
            int r103 = m129a(r103, r104)
            int r102 = r102 + r103
            int r99 = m130a(r99, r100, r101, r102)
            r67 = r99
            r99 = r10
            r100 = r29
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            r99 = r10
            r100 = r67
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            int r11 = r11 + 5
            goto L_0x030d
        L_0x0479:
            r99 = r11
            r100 = 4
            int r99 = r99 + 4
            r100 = r11
            r101 = 3
            r100 = r100 & 3
            int r99 = r99 - r100
            r51 = r99
            r99 = r10
            r100 = 170(0xaa, float:2.38E-43)
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            r99 = r10
            r100 = 0
            r101 = 0
            r102 = 4
            r103 = r10
            r0 = r103
            int r0 = r0.f280b
            r103 = r0
            r104 = 4
            int r103 = r103 % 4
            int r102 = 4 - r103
            r103 = 4
            int r102 = r102 % 4
            org.objectweb.asm.ByteVector r99 = r99.putByteArray(r100, r101, r102)
            r99 = r11
            r100 = r3
            r101 = r51
            int r100 = m129a(r100, r101)
            int r99 = r99 + r100
            r54 = r99
            r99 = r51
            r100 = 4
            int r99 = r99 + 4
            r55 = r99
            r99 = r10
            r100 = r4
            r101 = r5
            r102 = r11
            r103 = r54
            int r100 = m130a(r100, r101, r102, r103)
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            r99 = r3
            r100 = r55
            int r99 = m129a(r99, r100)
            r57 = r99
            r99 = r55
            r100 = 4
            int r99 = r99 + 4
            r58 = r99
            r99 = r10
            r100 = r57
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            r99 = 1
            r100 = r3
            r101 = r58
            int r100 = m129a(r100, r101)
            r101 = r57
            int r100 = r100 - r101
            int r99 = r99 + r100
            r60 = r99
            r99 = r58
            r100 = 4
            int r99 = r99 + 4
            r61 = r99
            r99 = r10
            r100 = r3
            r101 = r61
            r102 = 4
            int r101 = r101 + -4
            int r100 = m129a(r100, r101)
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            r99 = r61
            r44 = r99
            r99 = r60
            r63 = r99
        L_0x0525:
            r99 = r63
            if (r99 <= 0) goto L_0x0900
            r99 = r11
            r100 = r3
            r101 = r44
            int r100 = m129a(r100, r101)
            int r99 = r99 + r100
            r64 = r99
            r99 = r44
            r100 = 4
            int r99 = r99 + 4
            r65 = r99
            r99 = r10
            r100 = r4
            r101 = r5
            r102 = r11
            r103 = r64
            int r100 = m130a(r100, r101, r102, r103)
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            int r63 = r63 + -1
            r99 = r65
            r44 = r99
            goto L_0x0525
        L_0x0558:
            r99 = r11
            r100 = 4
            int r99 = r99 + 4
            r100 = r11
            r101 = 3
            r100 = r100 & 3
            int r99 = r99 - r100
            r35 = r99
            r99 = r10
            r100 = 171(0xab, float:2.4E-43)
            org.objectweb.asm.ByteVector r99 = r99.putByte(r100)
            r99 = r10
            r100 = 0
            r101 = 0
            r102 = 4
            r103 = r10
            r0 = r103
            int r0 = r0.f280b
            r103 = r0
            r104 = 4
            int r103 = r103 % 4
            int r102 = 4 - r103
            r103 = 4
            int r102 = r102 % 4
            org.objectweb.asm.ByteVector r99 = r99.putByteArray(r100, r101, r102)
            r99 = r11
            r100 = r3
            r101 = r35
            int r100 = m129a(r100, r101)
            int r99 = r99 + r100
            r38 = r99
            r99 = r35
            r100 = 4
            int r99 = r99 + 4
            r39 = r99
            r99 = r10
            r100 = r4
            r101 = r5
            r102 = r11
            r103 = r38
            int r100 = m130a(r100, r101, r102, r103)
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            r99 = r3
            r100 = r39
            int r99 = m129a(r99, r100)
            r41 = r99
            r99 = r39
            r100 = 4
            int r99 = r99 + 4
            r42 = r99
            r99 = r10
            r100 = r41
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            r99 = r42
            r44 = r99
            r99 = r41
            r45 = r99
        L_0x05d8:
            r99 = r45
            if (r99 <= 0) goto L_0x0900
            r99 = r10
            r100 = r3
            r101 = r44
            int r100 = m129a(r100, r101)
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            r99 = r44
            r100 = 4
            int r99 = r99 + 4
            r47 = r99
            r99 = r11
            r100 = r3
            r101 = r47
            int r100 = m129a(r100, r101)
            int r99 = r99 + r100
            r48 = r99
            r99 = r47
            r100 = 4
            int r99 = r99 + 4
            r49 = r99
            r99 = r10
            r100 = r4
            r101 = r5
            r102 = r11
            r103 = r48
            int r100 = m130a(r100, r101, r102, r103)
            org.objectweb.asm.ByteVector r99 = r99.putInt(r100)
            int r45 = r45 + -1
            r99 = r49
            r44 = r99
            goto L_0x05d8
        L_0x0621:
            r99 = 255(0xff, float:3.57E-43)
            r100 = r3
            r101 = r11
            r102 = 1
            int r101 = r101 + 1
            byte r100 = r100[r101]
            r99 = r99 & r100
            r100 = 132(0x84, float:1.85E-43)
            r0 = r99
            r1 = r100
            if (r0 != r1) goto L_0x0647
            r99 = r10
            r100 = r3
            r101 = r11
            r102 = 6
            org.objectweb.asm.ByteVector r99 = r99.putByteArray(r100, r101, r102)
            int r11 = r11 + 6
            goto L_0x030d
        L_0x0647:
            r99 = r10
            r100 = r3
            r101 = r11
            r102 = 4
            org.objectweb.asm.ByteVector r99 = r99.putByteArray(r100, r101, r102)
            int r11 = r11 + 4
            goto L_0x030d
        L_0x0657:
            r99 = r10
            r100 = r3
            r101 = r11
            r102 = 2
            org.objectweb.asm.ByteVector r99 = r99.putByteArray(r100, r101, r102)
            int r11 = r11 + 2
            goto L_0x030d
        L_0x0667:
            r99 = r10
            r100 = r3
            r101 = r11
            r102 = 3
            org.objectweb.asm.ByteVector r99 = r99.putByteArray(r100, r101, r102)
            int r11 = r11 + 3
            goto L_0x030d
        L_0x0677:
            r99 = r10
            r100 = r3
            r101 = r11
            r102 = 5
            org.objectweb.asm.ByteVector r99 = r99.putByteArray(r100, r101, r102)
            int r11 = r11 + 5
            goto L_0x030d
        L_0x0687:
            r99 = r2
            r0 = r99
            int r0 = r0.f416u
            r99 = r0
            if (r99 <= 0) goto L_0x077b
            r99 = r2
            r0 = r99
            int r0 = r0.f389M
            r99 = r0
            if (r99 != 0) goto L_0x076b
            r99 = r2
            r100 = 0
            r0 = r100
            r1 = r99
            r1.f416u = r0
            r99 = r2
            r100 = 0
            r0 = r100
            r1 = r99
            r1.f417v = r0
            r99 = r2
            r100 = 0
            r0 = r100
            r1 = r99
            r1.f419x = r0
            r99 = r2
            r100 = 0
            r0 = r100
            r1 = r99
            r1.f421z = r0
            org.objectweb.asm.Frame r99 = new org.objectweb.asm.Frame
            r107 = r99
            r99 = r107
            r100 = r107
            r100.<init>()
            r25 = r99
            r99 = r25
            r100 = r2
            r0 = r100
            org.objectweb.asm.Label r0 = r0.f390N
            r100 = r0
            r0 = r100
            r1 = r99
            r1.f338b = r0
            r99 = r2
            r0 = r99
            java.lang.String r0 = r0.f401f
            r99 = r0
            org.objectweb.asm.Type[] r99 = org.objectweb.asm.Type.getArgumentTypes(r99)
            r26 = r99
            r99 = r25
            r100 = r2
            r0 = r100
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r100 = r0
            r101 = r2
            r0 = r101
            int r0 = r0.f398c
            r101 = r0
            r102 = r26
            r103 = r2
            r0 = r103
            int r0 = r0.f415t
            r103 = r0
            r99.mo11171a(r100, r101, r102, r103)
            r99 = r2
            r100 = r25
            r99.m140b(r100)
            r99 = r2
            r0 = r99
            org.objectweb.asm.Label r0 = r0.f390N
            r99 = r0
            r27 = r99
        L_0x071e:
            r99 = r27
            if (r99 == 0) goto L_0x077b
            r99 = -3
            r100 = r27
            r0 = r100
            int r0 = r0.f367c
            r100 = r0
            int r99 = r99 + r100
            r28 = r99
            r99 = 32
            r100 = r27
            r0 = r100
            int r0 = r0.f365a
            r100 = r0
            r99 = r99 & r100
            if (r99 != 0) goto L_0x074a
            r99 = r28
            if (r99 < 0) goto L_0x0760
            r99 = r6
            r100 = r28
            boolean r99 = r99[r100]
            if (r99 == 0) goto L_0x0760
        L_0x074a:
            r99 = r4
            r100 = r5
            r101 = r27
            m137a(r99, r100, r101)
            r99 = r2
            r100 = r27
            r0 = r100
            org.objectweb.asm.Frame r0 = r0.f372h
            r100 = r0
            r99.m140b(r100)
        L_0x0760:
            r99 = r27
            r0 = r99
            org.objectweb.asm.Label r0 = r0.f373i
            r99 = r0
            r27 = r99
            goto L_0x071e
        L_0x076b:
            r99 = r2
            r0 = r99
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r99 = r0
            r100 = 1
            r0 = r100
            r1 = r99
            r1.f297L = r0
        L_0x077b:
            r99 = r2
            r0 = r99
            org.objectweb.asm.Handler r0 = r0.f378B
            r99 = r0
            r12 = r99
        L_0x0785:
            r99 = r12
            if (r99 == 0) goto L_0x07c1
            r99 = r4
            r100 = r5
            r101 = r12
            r0 = r101
            org.objectweb.asm.Label r0 = r0.f350a
            r101 = r0
            m137a(r99, r100, r101)
            r99 = r4
            r100 = r5
            r101 = r12
            r0 = r101
            org.objectweb.asm.Label r0 = r0.f351b
            r101 = r0
            m137a(r99, r100, r101)
            r99 = r4
            r100 = r5
            r101 = r12
            r0 = r101
            org.objectweb.asm.Label r0 = r0.f352c
            r101 = r0
            m137a(r99, r100, r101)
            r99 = r12
            r0 = r99
            org.objectweb.asm.Handler r0 = r0.f355f
            r99 = r0
            r12 = r99
            goto L_0x0785
        L_0x07c1:
            r99 = 0
            r13 = r99
        L_0x07c5:
            r99 = r13
            r100 = 2
            r0 = r99
            r1 = r100
            if (r0 >= r1) goto L_0x085f
            r99 = r13
            if (r99 != 0) goto L_0x0850
            r99 = r2
            r0 = r99
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r99 = r0
            r19 = r99
        L_0x07dd:
            r99 = r19
            if (r99 == 0) goto L_0x085b
            r99 = r19
            r0 = r99
            byte[] r0 = r0.f279a
            r99 = r0
            r20 = r99
            r99 = 0
            r21 = r99
        L_0x07ef:
            r99 = r21
            r100 = r19
            r0 = r100
            int r0 = r0.f280b
            r100 = r0
            r0 = r99
            r1 = r100
            if (r0 >= r1) goto L_0x085b
            r99 = r20
            r100 = r21
            int r99 = m141c(r99, r100)
            r22 = r99
            r99 = r4
            r100 = r5
            r101 = 0
            r102 = r22
            int r99 = m130a(r99, r100, r101, r102)
            r23 = r99
            r99 = r20
            r100 = r21
            r101 = r23
            m136a(r99, r100, r101)
            r99 = r4
            r100 = r5
            r101 = 0
            r102 = r22
            r103 = r20
            r104 = r21
            r105 = 2
            int r104 = r104 + 2
            int r103 = m141c(r103, r104)
            int r102 = r102 + r103
            int r99 = m130a(r99, r100, r101, r102)
            r100 = r23
            int r99 = r99 - r100
            r24 = r99
            r99 = r20
            r100 = r21
            r101 = 2
            int r100 = r100 + 2
            r101 = r24
            m136a(r99, r100, r101)
            int r21 = r21 + 10
            goto L_0x07ef
        L_0x0850:
            r99 = r2
            r0 = r99
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r99 = r0
            r19 = r99
            goto L_0x07dd
        L_0x085b:
            int r13 = r13 + 1
            goto L_0x07c5
        L_0x085f:
            r99 = r2
            r0 = r99
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r99 = r0
            if (r99 == 0) goto L_0x08af
            r99 = r2
            r0 = r99
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r99 = r0
            r0 = r99
            byte[] r0 = r0.f279a
            r99 = r0
            r17 = r99
            r99 = 0
            r18 = r99
        L_0x087d:
            r99 = r18
            r100 = r2
            r0 = r100
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r100 = r0
            r0 = r100
            int r0 = r0.f280b
            r100 = r0
            r0 = r99
            r1 = r100
            if (r0 >= r1) goto L_0x08af
            r99 = r17
            r100 = r18
            r101 = r4
            r102 = r5
            r103 = 0
            r104 = r17
            r105 = r18
            int r104 = m141c(r104, r105)
            int r101 = m130a(r101, r102, r103, r104)
            m136a(r99, r100, r101)
            int r18 = r18 + 4
            goto L_0x087d
        L_0x08af:
            r99 = r2
            r0 = r99
            org.objectweb.asm.Attribute r0 = r0.f386J
            r99 = r0
            r14 = r99
        L_0x08b9:
            r99 = r14
            if (r99 == 0) goto L_0x08f5
            r99 = r14
            org.objectweb.asm.Label[] r99 = r99.getLabels()
            r15 = r99
            r99 = r15
            if (r99 == 0) goto L_0x08ea
            r99 = -1
            r100 = r15
            r0 = r100
            int r0 = r0.length
            r100 = r0
            int r99 = r99 + r100
            r16 = r99
        L_0x08d6:
            r99 = r16
            if (r99 < 0) goto L_0x08ea
            r99 = r4
            r100 = r5
            r101 = r15
            r102 = r16
            r101 = r101[r102]
            m137a(r99, r100, r101)
            int r16 = r16 + -1
            goto L_0x08d6
        L_0x08ea:
            r99 = r14
            r0 = r99
            org.objectweb.asm.Attribute r0 = r0.f277a
            r99 = r0
            r14 = r99
            goto L_0x08b9
        L_0x08f5:
            r99 = r2
            r100 = r10
            r0 = r100
            r1 = r99
            r1.f413r = r0
            return
        L_0x0900:
            r99 = r44
            r11 = r99
            goto L_0x030d
        L_0x0906:
            r99 = r8
            r7 = r99
            goto L_0x0040
        L_0x090c:
            r99 = r89
            r5 = r99
            r99 = r88
            r4 = r99
            goto L_0x0056
        L_0x0916:
            r99 = 0
            r96 = r99
            goto L_0x0181
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.m143d():void");
    }

    /* renamed from: e */
    private void m144e() {
        Label label;
        Frame frame;
        if (this.f389M == 0) {
            Label label2 = label;
            Label label3 = new Label();
            Label label4 = label2;
            Label label5 = label4;
            Frame frame2 = frame;
            Frame frame3 = new Frame();
            label5.f372h = frame2;
            label4.f372h.f338b = label4;
            boolean a = label4.mo11193a(this, this.f413r.f280b, this.f413r.f279a);
            this.f391O.f373i = label4;
            this.f391O = label4;
        } else {
            this.f392P.f371g = this.f394R;
        }
        this.f392P = null;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0238, code lost:
        if ((262144 & r2.f398c) != 0) goto L_0x023a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo11217a() {
        /*
            r33 = this;
            r2 = r33
            r25 = r2
            r0 = r25
            int r0 = r0.f403h
            r25 = r0
            if (r25 == 0) goto L_0x001f
            r25 = 6
            r26 = r2
            r0 = r26
            int r0 = r0.f404i
            r26 = r0
            int r25 = r25 + r26
            r5 = r25
        L_0x001a:
            r25 = r5
            r2 = r25
        L_0x001e:
            return r2
        L_0x001f:
            r25 = r2
            r0 = r25
            boolean r0 = r0.f387K
            r25 = r0
            if (r25 == 0) goto L_0x002e
            r25 = r2
            r25.m143d()
        L_0x002e:
            r25 = 8
            r3 = r25
            r25 = r2
            r0 = r25
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r25 = r0
            r0 = r25
            int r0 = r0.f280b
            r25 = r0
            if (r25 <= 0) goto L_0x01d5
            r25 = r2
            r0 = r25
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r25 = r0
            r0 = r25
            int r0 = r0.f280b
            r25 = r0
            r26 = 65536(0x10000, float:9.18355E-41)
            r0 = r25
            r1 = r26
            if (r0 <= r1) goto L_0x0066
            java.lang.RuntimeException r25 = new java.lang.RuntimeException
            r32 = r25
            r25 = r32
            r26 = r32
            java.lang.String r27 = "Method code too large!"
            r26.<init>(r27)
            throw r25
        L_0x0066:
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "Code"
            int r25 = r25.newUTF8(r26)
            r25 = r3
            r26 = 18
            r27 = r2
            r0 = r27
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r27 = r0
            r0 = r27
            int r0 = r0.f280b
            r27 = r0
            int r26 = r26 + r27
            r27 = 8
            r28 = r2
            r0 = r28
            int r0 = r0.f377A
            r28 = r0
            int r27 = r27 * r28
            int r26 = r26 + r27
            int r25 = r25 + r26
            r21 = r25
            r25 = r2
            r0 = r25
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r25 = r0
            if (r25 == 0) goto L_0x00ca
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "LocalVariableTable"
            int r25 = r25.newUTF8(r26)
            r25 = r21
            r26 = 8
            r27 = r2
            r0 = r27
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r27 = r0
            r0 = r27
            int r0 = r0.f280b
            r27 = r0
            int r26 = r26 + r27
            int r25 = r25 + r26
            r21 = r25
        L_0x00ca:
            r25 = r2
            r0 = r25
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r25 = r0
            if (r25 == 0) goto L_0x00fa
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "LocalVariableTypeTable"
            int r25 = r25.newUTF8(r26)
            r25 = r21
            r26 = 8
            r27 = r2
            r0 = r27
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r27 = r0
            r0 = r27
            int r0 = r0.f280b
            r27 = r0
            int r26 = r26 + r27
            int r25 = r25 + r26
            r21 = r25
        L_0x00fa:
            r25 = r2
            r0 = r25
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r25 = r0
            if (r25 == 0) goto L_0x012a
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "LineNumberTable"
            int r25 = r25.newUTF8(r26)
            r25 = r21
            r26 = 8
            r27 = r2
            r0 = r27
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r27 = r0
            r0 = r27
            int r0 = r0.f280b
            r27 = r0
            int r26 = r26 + r27
            int r25 = r25 + r26
            r21 = r25
        L_0x012a:
            r25 = r2
            r0 = r25
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r25 = r0
            if (r25 == 0) goto L_0x0484
            r25 = 65535(0xffff, float:9.1834E-41)
            r26 = r2
            r0 = r26
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r26 = r0
            r0 = r26
            int r0 = r0.f299b
            r26 = r0
            r25 = r25 & r26
            r26 = 50
            r0 = r25
            r1 = r26
            if (r0 < r1) goto L_0x039f
            r25 = 1
            r22 = r25
        L_0x0153:
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            r23 = r25
            r25 = r22
            if (r25 == 0) goto L_0x03a5
            java.lang.String r25 = "StackMapTable"
            r24 = r25
        L_0x0165:
            r25 = r23
            r26 = r24
            int r25 = r25.newUTF8(r26)
            r25 = r21
            r26 = 8
            r27 = r2
            r0 = r27
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r27 = r0
            r0 = r27
            int r0 = r0.f280b
            r27 = r0
            int r26 = r26 + r27
            int r25 = r25 + r26
            r3 = r25
        L_0x0185:
            r25 = r2
            r0 = r25
            org.objectweb.asm.Attribute r0 = r0.f386J
            r25 = r0
            if (r25 == 0) goto L_0x01d5
            r25 = r3
            r26 = r2
            r0 = r26
            org.objectweb.asm.Attribute r0 = r0.f386J
            r26 = r0
            r27 = r2
            r0 = r27
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r27 = r0
            r28 = r2
            r0 = r28
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r28 = r0
            r0 = r28
            byte[] r0 = r0.f279a
            r28 = r0
            r29 = r2
            r0 = r29
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r29 = r0
            r0 = r29
            int r0 = r0.f280b
            r29 = r0
            r30 = r2
            r0 = r30
            int r0 = r0.f414s
            r30 = r0
            r31 = r2
            r0 = r31
            int r0 = r0.f415t
            r31 = r0
            int r26 = r26.mo11103a(r27, r28, r29, r30, r31)
            int r25 = r25 + r26
            r3 = r25
        L_0x01d5:
            r25 = r2
            r0 = r25
            int r0 = r0.f405j
            r25 = r0
            if (r25 <= 0) goto L_0x0203
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "Exceptions"
            int r25 = r25.newUTF8(r26)
            r25 = r3
            r26 = 8
            r27 = 2
            r28 = r2
            r0 = r28
            int r0 = r0.f405j
            r28 = r0
            int r27 = r27 * r28
            int r26 = r26 + r27
            int r25 = r25 + r26
            r3 = r25
        L_0x0203:
            r25 = 4096(0x1000, float:5.74E-42)
            r26 = r2
            r0 = r26
            int r0 = r0.f398c
            r26 = r0
            r25 = r25 & r26
            if (r25 == 0) goto L_0x024a
            r25 = 65535(0xffff, float:9.1834E-41)
            r26 = r2
            r0 = r26
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r26 = r0
            r0 = r26
            int r0 = r0.f299b
            r26 = r0
            r25 = r25 & r26
            r26 = 49
            r0 = r25
            r1 = r26
            if (r0 < r1) goto L_0x023a
            r25 = 262144(0x40000, float:3.67342E-40)
            r26 = r2
            r0 = r26
            int r0 = r0.f398c
            r26 = r0
            r25 = r25 & r26
            if (r25 == 0) goto L_0x024a
        L_0x023a:
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "Synthetic"
            int r25 = r25.newUTF8(r26)
            int r3 = r3 + 6
        L_0x024a:
            r25 = 131072(0x20000, float:1.83671E-40)
            r26 = r2
            r0 = r26
            int r0 = r0.f398c
            r26 = r0
            r25 = r25 & r26
            if (r25 == 0) goto L_0x0268
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "Deprecated"
            int r25 = r25.newUTF8(r26)
            int r3 = r3 + 6
        L_0x0268:
            r25 = r2
            r0 = r25
            java.lang.String r0 = r0.f402g
            r25 = r0
            if (r25 == 0) goto L_0x0296
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "Signature"
            int r25 = r25.newUTF8(r26)
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            r26 = r2
            r0 = r26
            java.lang.String r0 = r0.f402g
            r26 = r0
            int r25 = r25.newUTF8(r26)
            int r3 = r3 + 8
        L_0x0296:
            r25 = r2
            r0 = r25
            org.objectweb.asm.ByteVector r0 = r0.f407l
            r25 = r0
            if (r25 == 0) goto L_0x02c6
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "AnnotationDefault"
            int r25 = r25.newUTF8(r26)
            r25 = r3
            r26 = 6
            r27 = r2
            r0 = r27
            org.objectweb.asm.ByteVector r0 = r0.f407l
            r27 = r0
            r0 = r27
            int r0 = r0.f280b
            r27 = r0
            int r26 = r26 + r27
            int r25 = r25 + r26
            r3 = r25
        L_0x02c6:
            r25 = r2
            r0 = r25
            org.objectweb.asm.AnnotationWriter r0 = r0.f408m
            r25 = r0
            if (r25 == 0) goto L_0x02f4
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "RuntimeVisibleAnnotations"
            int r25 = r25.newUTF8(r26)
            r25 = r3
            r26 = 8
            r27 = r2
            r0 = r27
            org.objectweb.asm.AnnotationWriter r0 = r0.f408m
            r27 = r0
            int r27 = r27.mo11100a()
            int r26 = r26 + r27
            int r25 = r25 + r26
            r3 = r25
        L_0x02f4:
            r25 = r2
            r0 = r25
            org.objectweb.asm.AnnotationWriter r0 = r0.f409n
            r25 = r0
            if (r25 == 0) goto L_0x0322
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "RuntimeInvisibleAnnotations"
            int r25 = r25.newUTF8(r26)
            r25 = r3
            r26 = 8
            r27 = r2
            r0 = r27
            org.objectweb.asm.AnnotationWriter r0 = r0.f409n
            r27 = r0
            int r27 = r27.mo11100a()
            int r26 = r26 + r27
            int r25 = r25 + r26
            r3 = r25
        L_0x0322:
            r25 = r2
            r0 = r25
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f410o
            r25 = r0
            if (r25 == 0) goto L_0x03be
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "RuntimeVisibleParameterAnnotations"
            int r25 = r25.newUTF8(r26)
            r25 = r3
            r26 = 7
            r27 = 2
            r28 = r2
            r0 = r28
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f410o
            r28 = r0
            r0 = r28
            int r0 = r0.length
            r28 = r0
            r29 = r2
            r0 = r29
            int r0 = r0.f395S
            r29 = r0
            int r28 = r28 - r29
            int r27 = r27 * r28
            int r26 = r26 + r27
            int r25 = r25 + r26
            r4 = r25
            r25 = -1
            r26 = r2
            r0 = r26
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f410o
            r26 = r0
            r0 = r26
            int r0 = r0.length
            r26 = r0
            int r25 = r25 + r26
            r10 = r25
        L_0x0372:
            r25 = r10
            r26 = r2
            r0 = r26
            int r0 = r0.f395S
            r26 = r0
            r0 = r25
            r1 = r26
            if (r0 < r1) goto L_0x03c2
            r25 = r2
            r0 = r25
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f410o
            r25 = r0
            r26 = r10
            r25 = r25[r26]
            if (r25 != 0) goto L_0x03ab
            r25 = 0
            r11 = r25
        L_0x0394:
            r25 = r4
            r26 = r11
            int r25 = r25 + r26
            r4 = r25
            int r10 = r10 + -1
            goto L_0x0372
        L_0x039f:
            r25 = 0
            r22 = r25
            goto L_0x0153
        L_0x03a5:
            java.lang.String r25 = "StackMap"
            r24 = r25
            goto L_0x0165
        L_0x03ab:
            r25 = r2
            r0 = r25
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f410o
            r25 = r0
            r26 = r10
            r25 = r25[r26]
            int r25 = r25.mo11100a()
            r11 = r25
            goto L_0x0394
        L_0x03be:
            r25 = r3
            r4 = r25
        L_0x03c2:
            r25 = r2
            r0 = r25
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f411p
            r25 = r0
            if (r25 == 0) goto L_0x0452
            r25 = r2
            r0 = r25
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r25 = r0
            java.lang.String r26 = "RuntimeInvisibleParameterAnnotations"
            int r25 = r25.newUTF8(r26)
            r25 = r4
            r26 = 7
            r27 = 2
            r28 = r2
            r0 = r28
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f411p
            r28 = r0
            r0 = r28
            int r0 = r0.length
            r28 = r0
            r29 = r2
            r0 = r29
            int r0 = r0.f395S
            r29 = r0
            int r28 = r28 - r29
            int r27 = r27 * r28
            int r26 = r26 + r27
            int r25 = r25 + r26
            r4 = r25
            r25 = -1
            r26 = r2
            r0 = r26
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f411p
            r26 = r0
            r0 = r26
            int r0 = r0.length
            r26 = r0
            int r25 = r25 + r26
            r7 = r25
        L_0x0412:
            r25 = r7
            r26 = r2
            r0 = r26
            int r0 = r0.f395S
            r26 = r0
            r0 = r25
            r1 = r26
            if (r0 < r1) goto L_0x0452
            r25 = r2
            r0 = r25
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f411p
            r25 = r0
            r26 = r7
            r25 = r25[r26]
            if (r25 != 0) goto L_0x043f
            r25 = 0
            r8 = r25
        L_0x0434:
            r25 = r4
            r26 = r8
            int r25 = r25 + r26
            r4 = r25
            int r7 = r7 + -1
            goto L_0x0412
        L_0x043f:
            r25 = r2
            r0 = r25
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f411p
            r25 = r0
            r26 = r7
            r25 = r25[r26]
            int r25 = r25.mo11100a()
            r8 = r25
            goto L_0x0434
        L_0x0452:
            r25 = r4
            r5 = r25
            r25 = r2
            r0 = r25
            org.objectweb.asm.Attribute r0 = r0.f412q
            r25 = r0
            if (r25 == 0) goto L_0x001a
            r25 = r5
            r26 = r2
            r0 = r26
            org.objectweb.asm.Attribute r0 = r0.f412q
            r26 = r0
            r27 = r2
            r0 = r27
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r27 = r0
            r28 = 0
            r29 = 0
            r30 = -1
            r31 = -1
            int r26 = r26.mo11103a(r27, r28, r29, r30, r31)
            int r25 = r25 + r26
            r2 = r25
            goto L_0x001e
        L_0x0484:
            r25 = r21
            r3 = r25
            goto L_0x0185
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.mo11217a():int");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0649, code lost:
        if ((262144 & r2.f398c) != 0) goto L_0x064b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00d6, code lost:
        if ((262144 & r2.f398c) != 0) goto L_0x00d8;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo11218a(org.objectweb.asm.ByteVector r54) {
        /*
            r53 = this;
            r2 = r53
            r3 = r54
            r46 = 1
            r4 = r46
            r46 = 393216(0x60000, float:5.51013E-40)
            r47 = 262144(0x40000, float:3.67342E-40)
            r48 = r2
            r0 = r48
            int r0 = r0.f398c
            r48 = r0
            r47 = r47 & r48
            r48 = 64
            int r47 = r47 / 64
            r46 = r46 | r47
            r5 = r46
            r46 = r3
            r47 = r2
            r0 = r47
            int r0 = r0.f398c
            r47 = r0
            r48 = r5
            r49 = -1
            r48 = r48 ^ -1
            r47 = r47 & r48
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = r2
            r0 = r47
            int r0 = r0.f399d
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = r2
            r0 = r47
            int r0 = r0.f400e
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r2
            r0 = r46
            int r0 = r0.f403h
            r46 = r0
            if (r46 == 0) goto L_0x0081
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            r0 = r47
            org.objectweb.asm.ClassReader r0 = r0.f298M
            r47 = r0
            r0 = r47
            byte[] r0 = r0.f282b
            r47 = r0
            r48 = r2
            r0 = r48
            int r0 = r0.f403h
            r48 = r0
            r49 = r2
            r0 = r49
            int r0 = r0.f404i
            r49 = r0
            org.objectweb.asm.ByteVector r46 = r46.putByteArray(r47, r48, r49)
        L_0x0080:
            return
        L_0x0081:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r46 = r0
            r0 = r46
            int r0 = r0.f280b
            r46 = r0
            if (r46 <= 0) goto L_0x0810
            r46 = r4
            r7 = r46
        L_0x0095:
            r46 = r2
            r0 = r46
            int r0 = r0.f405j
            r46 = r0
            if (r46 <= 0) goto L_0x00a1
            int r7 = r7 + 1
        L_0x00a1:
            r46 = 4096(0x1000, float:5.74E-42)
            r47 = r2
            r0 = r47
            int r0 = r0.f398c
            r47 = r0
            r46 = r46 & r47
            if (r46 == 0) goto L_0x00da
            r46 = 65535(0xffff, float:9.1834E-41)
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            r0 = r47
            int r0 = r0.f299b
            r47 = r0
            r46 = r46 & r47
            r47 = 49
            r0 = r46
            r1 = r47
            if (r0 < r1) goto L_0x00d8
            r46 = 262144(0x40000, float:3.67342E-40)
            r47 = r2
            r0 = r47
            int r0 = r0.f398c
            r47 = r0
            r46 = r46 & r47
            if (r46 == 0) goto L_0x00da
        L_0x00d8:
            int r7 = r7 + 1
        L_0x00da:
            r46 = 131072(0x20000, float:1.83671E-40)
            r47 = r2
            r0 = r47
            int r0 = r0.f398c
            r47 = r0
            r46 = r46 & r47
            if (r46 == 0) goto L_0x00ea
            int r7 = r7 + 1
        L_0x00ea:
            r46 = r2
            r0 = r46
            java.lang.String r0 = r0.f402g
            r46 = r0
            if (r46 == 0) goto L_0x00f6
            int r7 = r7 + 1
        L_0x00f6:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f407l
            r46 = r0
            if (r46 == 0) goto L_0x0102
            int r7 = r7 + 1
        L_0x0102:
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter r0 = r0.f408m
            r46 = r0
            if (r46 == 0) goto L_0x010e
            int r7 = r7 + 1
        L_0x010e:
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter r0 = r0.f409n
            r46 = r0
            if (r46 == 0) goto L_0x011a
            int r7 = r7 + 1
        L_0x011a:
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f410o
            r46 = r0
            if (r46 == 0) goto L_0x0126
            int r7 = r7 + 1
        L_0x0126:
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f411p
            r46 = r0
            if (r46 == 0) goto L_0x0132
            int r7 = r7 + 1
        L_0x0132:
            r46 = r2
            r0 = r46
            org.objectweb.asm.Attribute r0 = r0.f412q
            r46 = r0
            if (r46 == 0) goto L_0x014e
            r46 = r7
            r47 = r2
            r0 = r47
            org.objectweb.asm.Attribute r0 = r0.f412q
            r47 = r0
            int r47 = r47.mo11102a()
            int r46 = r46 + r47
            r7 = r46
        L_0x014e:
            r46 = r3
            r47 = r7
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r46 = r0
            r0 = r46
            int r0 = r0.f280b
            r46 = r0
            if (r46 <= 0) goto L_0x059f
            r46 = 12
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r47 = r0
            r0 = r47
            int r0 = r0.f280b
            r47 = r0
            int r46 = r46 + r47
            r47 = 8
            r48 = r2
            r0 = r48
            int r0 = r0.f377A
            r48 = r0
            int r47 = r47 * r48
            int r46 = r46 + r47
            r23 = r46
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r46 = r0
            if (r46 == 0) goto L_0x01aa
            r46 = r23
            r47 = 8
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r48 = r0
            r0 = r48
            int r0 = r0.f280b
            r48 = r0
            int r47 = r47 + r48
            int r46 = r46 + r47
            r23 = r46
        L_0x01aa:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r46 = r0
            if (r46 == 0) goto L_0x01cc
            r46 = r23
            r47 = 8
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r48 = r0
            r0 = r48
            int r0 = r0.f280b
            r48 = r0
            int r47 = r47 + r48
            int r46 = r46 + r47
            r23 = r46
        L_0x01cc:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r46 = r0
            if (r46 == 0) goto L_0x01ee
            r46 = r23
            r47 = 8
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r48 = r0
            r0 = r48
            int r0 = r0.f280b
            r48 = r0
            int r47 = r47 + r48
            int r46 = r46 + r47
            r23 = r46
        L_0x01ee:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r46 = r0
            if (r46 == 0) goto L_0x080a
            r46 = r23
            r47 = 8
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r48 = r0
            r0 = r48
            int r0 = r0.f280b
            r48 = r0
            int r47 = r47 + r48
            int r46 = r46 + r47
            r24 = r46
        L_0x0210:
            r46 = r2
            r0 = r46
            org.objectweb.asm.Attribute r0 = r0.f386J
            r46 = r0
            if (r46 == 0) goto L_0x0260
            r46 = r24
            r47 = r2
            r0 = r47
            org.objectweb.asm.Attribute r0 = r0.f386J
            r47 = r0
            r48 = r2
            r0 = r48
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r48 = r0
            r49 = r2
            r0 = r49
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r49 = r0
            r0 = r49
            byte[] r0 = r0.f279a
            r49 = r0
            r50 = r2
            r0 = r50
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r50 = r0
            r0 = r50
            int r0 = r0.f280b
            r50 = r0
            r51 = r2
            r0 = r51
            int r0 = r0.f414s
            r51 = r0
            r52 = r2
            r0 = r52
            int r0 = r0.f415t
            r52 = r0
            int r47 = r47.mo11103a(r48, r49, r50, r51, r52)
            int r46 = r46 + r47
            r24 = r46
        L_0x0260:
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "Code"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = r24
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            int r0 = r0.f414s
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = r2
            r0 = r47
            int r0 = r0.f415t
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r47 = r0
            r0 = r47
            int r0 = r0.f280b
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r47 = r0
            r0 = r47
            byte[] r0 = r0.f279a
            r47 = r0
            r48 = 0
            r49 = r2
            r0 = r49
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r49 = r0
            r0 = r49
            int r0 = r0.f280b
            r49 = r0
            org.objectweb.asm.ByteVector r46 = r46.putByteArray(r47, r48, r49)
            r46 = r3
            r47 = r2
            r0 = r47
            int r0 = r0.f377A
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r2
            r0 = r46
            int r0 = r0.f377A
            r46 = r0
            if (r46 <= 0) goto L_0x033f
            r46 = r2
            r0 = r46
            org.objectweb.asm.Handler r0 = r0.f378B
            r46 = r0
            r45 = r46
        L_0x02ec:
            r46 = r45
            if (r46 == 0) goto L_0x033f
            r46 = r3
            r47 = r45
            r0 = r47
            org.objectweb.asm.Label r0 = r0.f350a
            r47 = r0
            r0 = r47
            int r0 = r0.f367c
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = r45
            r0 = r47
            org.objectweb.asm.Label r0 = r0.f351b
            r47 = r0
            r0 = r47
            int r0 = r0.f367c
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = r45
            r0 = r47
            org.objectweb.asm.Label r0 = r0.f352c
            r47 = r0
            r0 = r47
            int r0 = r0.f367c
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = r45
            r0 = r47
            int r0 = r0.f354e
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r45
            r0 = r46
            org.objectweb.asm.Handler r0 = r0.f355f
            r46 = r0
            r45 = r46
            goto L_0x02ec
        L_0x033f:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r46 = r0
            if (r46 == 0) goto L_0x0804
            r46 = r4
            r29 = r46
        L_0x034d:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r46 = r0
            if (r46 == 0) goto L_0x0359
            int r29 = r29 + 1
        L_0x0359:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r46 = r0
            if (r46 == 0) goto L_0x0365
            int r29 = r29 + 1
        L_0x0365:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r46 = r0
            if (r46 == 0) goto L_0x0371
            int r29 = r29 + 1
        L_0x0371:
            r46 = r2
            r0 = r46
            org.objectweb.asm.Attribute r0 = r0.f386J
            r46 = r0
            if (r46 == 0) goto L_0x038d
            r46 = r29
            r47 = r2
            r0 = r47
            org.objectweb.asm.Attribute r0 = r0.f386J
            r47 = r0
            int r47 = r47.mo11102a()
            int r46 = r46 + r47
            r29 = r46
        L_0x038d:
            r46 = r3
            r47 = r29
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r46 = r0
            if (r46 == 0) goto L_0x03fb
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "LocalVariableTable"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = 2
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r48 = r0
            r0 = r48
            int r0 = r0.f280b
            r48 = r0
            int r47 = r47 + r48
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r47 = r2
            r0 = r47
            int r0 = r0.f380D
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r47 = r0
            r0 = r47
            byte[] r0 = r0.f279a
            r47 = r0
            r48 = 0
            r49 = r2
            r0 = r49
            org.objectweb.asm.ByteVector r0 = r0.f381E
            r49 = r0
            r0 = r49
            int r0 = r0.f280b
            r49 = r0
            org.objectweb.asm.ByteVector r46 = r46.putByteArray(r47, r48, r49)
        L_0x03fb:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r46 = r0
            if (r46 == 0) goto L_0x0461
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "LocalVariableTypeTable"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = 2
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r48 = r0
            r0 = r48
            int r0 = r0.f280b
            r48 = r0
            int r47 = r47 + r48
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r47 = r2
            r0 = r47
            int r0 = r0.f382F
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r47 = r0
            r0 = r47
            byte[] r0 = r0.f279a
            r47 = r0
            r48 = 0
            r49 = r2
            r0 = r49
            org.objectweb.asm.ByteVector r0 = r0.f383G
            r49 = r0
            r0 = r49
            int r0 = r0.f280b
            r49 = r0
            org.objectweb.asm.ByteVector r46 = r46.putByteArray(r47, r48, r49)
        L_0x0461:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r46 = r0
            if (r46 == 0) goto L_0x04c7
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "LineNumberTable"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = 2
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r48 = r0
            r0 = r48
            int r0 = r0.f280b
            r48 = r0
            int r47 = r47 + r48
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r47 = r2
            r0 = r47
            int r0 = r0.f384H
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r47 = r0
            r0 = r47
            byte[] r0 = r0.f279a
            r47 = r0
            r48 = 0
            r49 = r2
            r0 = r49
            org.objectweb.asm.ByteVector r0 = r0.f385I
            r49 = r0
            r0 = r49
            int r0 = r0.f280b
            r49 = r0
            org.objectweb.asm.ByteVector r46 = r46.putByteArray(r47, r48, r49)
        L_0x04c7:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r46 = r0
            if (r46 == 0) goto L_0x0554
            r46 = 65535(0xffff, float:9.1834E-41)
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            r0 = r47
            int r0 = r0.f299b
            r47 = r0
            r46 = r46 & r47
            r47 = 50
            r0 = r46
            r1 = r47
            if (r0 < r1) goto L_0x0608
        L_0x04ec:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r46 = r0
            r31 = r46
            r46 = r4
            if (r46 == 0) goto L_0x060e
            java.lang.String r46 = "StackMapTable"
            r32 = r46
        L_0x04fe:
            r46 = r3
            r47 = r31
            r48 = r32
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = 2
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r48 = r0
            r0 = r48
            int r0 = r0.f280b
            r48 = r0
            int r47 = r47 + r48
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r47 = r2
            r0 = r47
            int r0 = r0.f416u
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r47 = r0
            r0 = r47
            byte[] r0 = r0.f279a
            r47 = r0
            r48 = 0
            r49 = r2
            r0 = r49
            org.objectweb.asm.ByteVector r0 = r0.f417v
            r49 = r0
            r0 = r49
            int r0 = r0.f280b
            r49 = r0
            org.objectweb.asm.ByteVector r46 = r46.putByteArray(r47, r48, r49)
        L_0x0554:
            r46 = r2
            r0 = r46
            org.objectweb.asm.Attribute r0 = r0.f386J
            r46 = r0
            if (r46 == 0) goto L_0x059f
            r46 = r2
            r0 = r46
            org.objectweb.asm.Attribute r0 = r0.f386J
            r46 = r0
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            r48 = r2
            r0 = r48
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r48 = r0
            r0 = r48
            byte[] r0 = r0.f279a
            r48 = r0
            r49 = r2
            r0 = r49
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r49 = r0
            r0 = r49
            int r0 = r0.f280b
            r49 = r0
            r50 = r2
            r0 = r50
            int r0 = r0.f415t
            r50 = r0
            r51 = r2
            r0 = r51
            int r0 = r0.f414s
            r51 = r0
            r52 = r3
            r46.mo11104a(r47, r48, r49, r50, r51, r52)
        L_0x059f:
            r46 = r2
            r0 = r46
            int r0 = r0.f405j
            r46 = r0
            if (r46 <= 0) goto L_0x0614
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "Exceptions"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = 2
            r48 = 2
            r49 = r2
            r0 = r49
            int r0 = r0.f405j
            r49 = r0
            int r48 = r48 * r49
            int r47 = r47 + r48
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            int r0 = r0.f405j
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = 0
            r21 = r46
        L_0x05e3:
            r46 = r21
            r47 = r2
            r0 = r47
            int r0 = r0.f405j
            r47 = r0
            r0 = r46
            r1 = r47
            if (r0 >= r1) goto L_0x0614
            r46 = r3
            r47 = r2
            r0 = r47
            int[] r0 = r0.f406k
            r47 = r0
            r48 = r21
            r47 = r47[r48]
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            int r21 = r21 + 1
            goto L_0x05e3
        L_0x0608:
            r46 = 0
            r4 = r46
            goto L_0x04ec
        L_0x060e:
            java.lang.String r46 = "StackMap"
            r32 = r46
            goto L_0x04fe
        L_0x0614:
            r46 = 4096(0x1000, float:5.74E-42)
            r47 = r2
            r0 = r47
            int r0 = r0.f398c
            r47 = r0
            r46 = r46 & r47
            if (r46 == 0) goto L_0x0665
            r46 = 65535(0xffff, float:9.1834E-41)
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            r0 = r47
            int r0 = r0.f299b
            r47 = r0
            r46 = r46 & r47
            r47 = 49
            r0 = r46
            r1 = r47
            if (r0 < r1) goto L_0x064b
            r46 = 262144(0x40000, float:3.67342E-40)
            r47 = r2
            r0 = r47
            int r0 = r0.f398c
            r47 = r0
            r46 = r46 & r47
            if (r46 == 0) goto L_0x0665
        L_0x064b:
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "Synthetic"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = 0
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
        L_0x0665:
            r46 = 131072(0x20000, float:1.83671E-40)
            r47 = r2
            r0 = r47
            int r0 = r0.f398c
            r47 = r0
            r46 = r46 & r47
            if (r46 == 0) goto L_0x068d
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "Deprecated"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = 0
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
        L_0x068d:
            r46 = r2
            r0 = r46
            java.lang.String r0 = r0.f402g
            r46 = r0
            if (r46 == 0) goto L_0x06c9
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "Signature"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r47 = 2
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            r48 = r2
            r0 = r48
            java.lang.String r0 = r0.f402g
            r48 = r0
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
        L_0x06c9:
            r46 = r2
            r0 = r46
            org.objectweb.asm.ByteVector r0 = r0.f407l
            r46 = r0
            if (r46 == 0) goto L_0x071f
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "AnnotationDefault"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f407l
            r47 = r0
            r0 = r47
            int r0 = r0.f280b
            r47 = r0
            org.objectweb.asm.ByteVector r46 = r46.putInt(r47)
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ByteVector r0 = r0.f407l
            r47 = r0
            r0 = r47
            byte[] r0 = r0.f279a
            r47 = r0
            r48 = 0
            r49 = r2
            r0 = r49
            org.objectweb.asm.ByteVector r0 = r0.f407l
            r49 = r0
            r0 = r49
            int r0 = r0.f280b
            r49 = r0
            org.objectweb.asm.ByteVector r46 = r46.putByteArray(r47, r48, r49)
        L_0x071f:
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter r0 = r0.f408m
            r46 = r0
            if (r46 == 0) goto L_0x074a
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "RuntimeVisibleAnnotations"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter r0 = r0.f408m
            r46 = r0
            r47 = r3
            r46.mo11101a(r47)
        L_0x074a:
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter r0 = r0.f409n
            r46 = r0
            if (r46 == 0) goto L_0x0775
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "RuntimeInvisibleAnnotations"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter r0 = r0.f409n
            r46 = r0
            r47 = r3
            r46.mo11101a(r47)
        L_0x0775:
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f410o
            r46 = r0
            if (r46 == 0) goto L_0x07a8
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "RuntimeVisibleParameterAnnotations"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f410o
            r46 = r0
            r47 = r2
            r0 = r47
            int r0 = r0.f395S
            r47 = r0
            r48 = r3
            org.objectweb.asm.AnnotationWriter.m57a(r46, r47, r48)
        L_0x07a8:
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f411p
            r46 = r0
            if (r46 == 0) goto L_0x07db
            r46 = r3
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            java.lang.String r48 = "RuntimeInvisibleParameterAnnotations"
            int r47 = r47.newUTF8(r48)
            org.objectweb.asm.ByteVector r46 = r46.putShort(r47)
            r46 = r2
            r0 = r46
            org.objectweb.asm.AnnotationWriter[] r0 = r0.f411p
            r46 = r0
            r47 = r2
            r0 = r47
            int r0 = r0.f395S
            r47 = r0
            r48 = r3
            org.objectweb.asm.AnnotationWriter.m57a(r46, r47, r48)
        L_0x07db:
            r46 = r2
            r0 = r46
            org.objectweb.asm.Attribute r0 = r0.f412q
            r46 = r0
            if (r46 == 0) goto L_0x0080
            r46 = r2
            r0 = r46
            org.objectweb.asm.Attribute r0 = r0.f412q
            r46 = r0
            r47 = r2
            r0 = r47
            org.objectweb.asm.ClassWriter r0 = r0.f397b
            r47 = r0
            r48 = 0
            r49 = 0
            r50 = -1
            r51 = -1
            r52 = r3
            r46.mo11104a(r47, r48, r49, r50, r51, r52)
            goto L_0x0080
        L_0x0804:
            r46 = 0
            r29 = r46
            goto L_0x034d
        L_0x080a:
            r46 = r23
            r24 = r46
            goto L_0x0210
        L_0x0810:
            r46 = 0
            r7 = r46
            goto L_0x0095
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.mo11218a(org.objectweb.asm.ByteVector):void");
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector;
        AnnotationWriter annotationWriter;
        String str2 = str;
        boolean z2 = z;
        ByteVector byteVector2 = byteVector;
        ByteVector byteVector3 = new ByteVector();
        ByteVector byteVector4 = byteVector2;
        ByteVector putShort = byteVector4.putShort(this.f397b.newUTF8(str2)).putShort(0);
        AnnotationWriter annotationWriter2 = annotationWriter;
        AnnotationWriter annotationWriter3 = new AnnotationWriter(this.f397b, true, byteVector4, byteVector4, 2);
        AnnotationWriter annotationWriter4 = annotationWriter2;
        if (z2) {
            annotationWriter4.f275g = this.f408m;
            this.f408m = annotationWriter4;
            return annotationWriter4;
        }
        annotationWriter4.f275g = this.f409n;
        this.f409n = annotationWriter4;
        return annotationWriter4;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        ByteVector byteVector;
        AnnotationWriter annotationWriter;
        ByteVector byteVector2 = byteVector;
        ByteVector byteVector3 = new ByteVector();
        this.f407l = byteVector2;
        AnnotationWriter annotationWriter2 = annotationWriter;
        AnnotationWriter annotationWriter3 = new AnnotationWriter(this.f397b, false, this.f407l, null, 0);
        return annotationWriter2;
    }

    public void visitAttribute(Attribute attribute) {
        Attribute attribute2 = attribute;
        if (attribute2.isCodeAttribute()) {
            attribute2.f277a = this.f386J;
            this.f386J = attribute2;
            return;
        }
        attribute2.f277a = this.f412q;
        this.f412q = attribute2;
    }

    public void visitCode() {
    }

    public void visitEnd() {
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        int i2;
        int i3 = i;
        String str4 = str3;
        int i4 = 1;
        int i5 = -2;
        Item a = this.f397b.mo11152a(str, str2, str4);
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(i3, 0, this.f397b, a);
            } else {
                char charAt = str4.charAt(0);
                switch (i3) {
                    case 178:
                        int i6 = this.f393Q;
                        if (charAt == 'D' || charAt == 'J') {
                            i4 = 2;
                        }
                        i2 = i4 + i6;
                        break;
                    case 179:
                        i2 = ((charAt == 'D' || charAt == 'J') ? -2 : -1) + this.f393Q;
                        break;
                    case 180:
                        int i7 = this.f393Q;
                        if (!(charAt == 'D' || charAt == 'J')) {
                            i4 = 0;
                        }
                        i2 = i4 + i7;
                        break;
                    default:
                        int i8 = this.f393Q;
                        if (charAt == 'D' || charAt == 'J') {
                            i5 = -3;
                        }
                        i2 = i8 + i5;
                        break;
                }
                if (i2 > this.f394R) {
                    this.f394R = i2;
                }
                this.f393Q = i2;
            }
        }
        ByteVector b = this.f413r.mo11111b(i3, a.f356a);
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        IllegalStateException illegalStateException;
        ByteVector byteVector;
        int i5;
        int i6 = i;
        int i7 = i2;
        Object[] objArr3 = objArr;
        int i8 = i3;
        Object[] objArr4 = objArr2;
        if (this.f389M != 0) {
            if (i6 == -1) {
                this.f396T = i7;
                m132a(this.f413r.f280b, i7, i8);
                int i9 = 0;
                while (true) {
                    if (i9 >= i7) {
                        break;
                    }
                    if (objArr3[i9] instanceof String) {
                        int[] iArr = this.f421z;
                        int i10 = this.f420y;
                        this.f420y = i10 + 1;
                        iArr[i10] = 24117248 | this.f397b.mo11155c((String) objArr3[i9]);
                    } else if (objArr3[i9] instanceof Integer) {
                        int[] iArr2 = this.f421z;
                        int i11 = this.f420y;
                        this.f420y = i11 + 1;
                        iArr2[i11] = ((Integer) objArr3[i9]).intValue();
                    } else {
                        int[] iArr3 = this.f421z;
                        int i12 = this.f420y;
                        this.f420y = i12 + 1;
                        iArr3[i12] = 25165824 | this.f397b.mo11143a(LibrariesRepository.MOJANG_MAVEN_REPO, ((Label) objArr3[i9]).f367c);
                    }
                    i9++;
                }
                for (i5 = 0; i5 < i8; i5++) {
                    if (objArr4[i5] instanceof String) {
                        int[] iArr4 = this.f421z;
                        int i13 = this.f420y;
                        this.f420y = i13 + 1;
                        iArr4[i13] = 24117248 | this.f397b.mo11155c((String) objArr4[i5]);
                    } else if (objArr4[i5] instanceof Integer) {
                        int[] iArr5 = this.f421z;
                        int i14 = this.f420y;
                        this.f420y = i14 + 1;
                        iArr5[i14] = ((Integer) objArr4[i5]).intValue();
                    } else {
                        int[] iArr6 = this.f421z;
                        int i15 = this.f420y;
                        this.f420y = i15 + 1;
                        iArr6[i15] = 25165824 | this.f397b.mo11143a(LibrariesRepository.MOJANG_MAVEN_REPO, ((Label) objArr4[i5]).f367c);
                    }
                }
                m139b();
            } else {
                if (this.f417v == null) {
                    ByteVector byteVector2 = byteVector;
                    ByteVector byteVector3 = new ByteVector();
                    this.f417v = byteVector2;
                    i4 = this.f413r.f280b;
                } else {
                    i4 = -1 + (this.f413r.f280b - this.f418w);
                    if (i4 < 0) {
                        if (i6 != 3) {
                            IllegalStateException illegalStateException2 = illegalStateException;
                            IllegalStateException illegalStateException3 = new IllegalStateException();
                            throw illegalStateException2;
                        }
                        return;
                    }
                }
                switch (i6) {
                    case 0:
                        this.f396T = i7;
                        ByteVector putShort = this.f417v.putByte(255).putShort(i4).putShort(i7);
                        for (int i16 = 0; i16 < i7; i16++) {
                            m134a(objArr3[i16]);
                        }
                        ByteVector putShort2 = this.f417v.putShort(i8);
                        for (int i17 = 0; i17 < i8; i17++) {
                            m134a(objArr4[i17]);
                        }
                        break;
                    case 1:
                        this.f396T = i7 + this.f396T;
                        ByteVector putShort3 = this.f417v.putByte(i7 + 251).putShort(i4);
                        for (int i18 = 0; i18 < i7; i18++) {
                            m134a(objArr3[i18]);
                        }
                        break;
                    case 2:
                        this.f396T -= i7;
                        ByteVector putShort4 = this.f417v.putByte(251 - i7).putShort(i4);
                        break;
                    case 3:
                        if (i4 >= 64) {
                            ByteVector putShort5 = this.f417v.putByte(251).putShort(i4);
                            break;
                        } else {
                            ByteVector putByte = this.f417v.putByte(i4);
                            break;
                        }
                    case 4:
                        if (i4 < 64) {
                            ByteVector putByte2 = this.f417v.putByte(i4 + 64);
                        } else {
                            ByteVector putShort6 = this.f417v.putByte(247).putShort(i4);
                        }
                        m134a(objArr4[0]);
                        break;
                }
                this.f418w = this.f413r.f280b;
                this.f416u = 1 + this.f416u;
            }
            this.f414s = Math.max(this.f414s, i8);
            this.f415t = Math.max(this.f415t, this.f396T);
        }
    }

    public void visitIincInsn(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f392P != null && this.f389M == 0) {
            this.f392P.f372h.mo11170a(132, i3, (ClassWriter) null, (Item) null);
        }
        if (this.f389M != 2) {
            int i5 = i3 + 1;
            if (i5 > this.f415t) {
                this.f415t = i5;
            }
        }
        if (i3 > 255 || i4 > 127 || i4 < -128) {
            ByteVector putShort = this.f413r.putByte(196).mo11111b(132, i3).putShort(i4);
        } else {
            ByteVector a = this.f413r.putByte(132).mo11110a(i3, i4);
        }
    }

    public void visitInsn(int i) {
        int i2 = i;
        ByteVector putByte = this.f413r.putByte(i2);
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(i2, 0, (ClassWriter) null, (Item) null);
            } else {
                int i3 = this.f393Q + Frame.f337a[i2];
                if (i3 > this.f394R) {
                    this.f394R = i3;
                }
                this.f393Q = i3;
            }
            if ((i2 >= 172 && i2 <= 177) || i2 == 191) {
                m144e();
            }
        }
    }

    public void visitIntInsn(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(i3, i4, (ClassWriter) null, (Item) null);
            } else if (i3 != 188) {
                int i5 = 1 + this.f393Q;
                if (i5 > this.f394R) {
                    this.f394R = i5;
                }
                this.f393Q = i5;
            }
        }
        if (i3 == 17) {
            ByteVector b = this.f413r.mo11111b(i3, i4);
        } else {
            ByteVector a = this.f413r.mo11110a(i3, i4);
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        String str3 = str2;
        Item a = this.f397b.mo11154a(str, str3, handle, objArr);
        int i = a.f358c;
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(186, 0, this.f397b, a);
            } else {
                if (i == 0) {
                    i = Type.getArgumentsAndReturnSizes(str3);
                    a.f358c = i;
                }
                int i2 = 1 + (this.f393Q - (i >> 2)) + (i & 3);
                if (i2 > this.f394R) {
                    this.f394R = i2;
                }
                this.f393Q = i2;
            }
        }
        ByteVector b = this.f413r.mo11111b(186, a.f356a);
        ByteVector putShort = this.f413r.putShort(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void visitJumpInsn(int r24, org.objectweb.asm.Label r25) {
        /*
            r23 = this;
            r2 = r23
            r3 = r24
            r4 = r25
            r17 = r2
            r0 = r17
            org.objectweb.asm.Label r0 = r0.f392P
            r17 = r0
            r5 = r17
            r17 = 0
            r6 = r17
            r17 = r5
            if (r17 == 0) goto L_0x007b
            r17 = r2
            r0 = r17
            int r0 = r0.f389M
            r17 = r0
            if (r17 != 0) goto L_0x0109
            r17 = r2
            r0 = r17
            org.objectweb.asm.Label r0 = r0.f392P
            r17 = r0
            r0 = r17
            org.objectweb.asm.Frame r0 = r0.f372h
            r17 = r0
            r18 = r3
            r19 = 0
            r20 = 0
            r21 = 0
            r17.mo11170a(r18, r19, r20, r21)
            r17 = r4
            org.objectweb.asm.Label r17 = r17.mo11188a()
            r16 = r17
            r17 = r16
            r18 = 16
            r19 = r16
            r0 = r19
            int r0 = r0.f365a
            r19 = r0
            r18 = r18 | r19
            r0 = r18
            r1 = r17
            r1.f365a = r0
            r17 = r2
            r18 = 0
            r19 = r4
            r17.m133a(r18, r19)
            r17 = 0
            r6 = r17
            r17 = r3
            r18 = 167(0xa7, float:2.34E-43)
            r0 = r17
            r1 = r18
            if (r0 == r1) goto L_0x007b
            org.objectweb.asm.Label r17 = new org.objectweb.asm.Label
            r22 = r17
            r17 = r22
            r18 = r22
            r18.<init>()
            r6 = r17
        L_0x007b:
            r17 = 2
            r18 = r4
            r0 = r18
            int r0 = r0.f365a
            r18 = r0
            r17 = r17 & r18
            if (r17 == 0) goto L_0x023b
            r17 = r4
            r0 = r17
            int r0 = r0.f367c
            r17 = r0
            r18 = r2
            r0 = r18
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r18 = r0
            r0 = r18
            int r0 = r0.f280b
            r18 = r0
            int r17 = r17 - r18
            r18 = -32768(0xffffffffffff8000, float:NaN)
            r0 = r17
            r1 = r18
            if (r0 >= r1) goto L_0x023b
            r17 = r3
            r18 = 167(0xa7, float:2.34E-43)
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x01b6
            r17 = r2
            r0 = r17
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r17 = r0
            r18 = 200(0xc8, float:2.8E-43)
            org.objectweb.asm.ByteVector r17 = r17.putByte(r18)
        L_0x00c1:
            r17 = r4
            r18 = r2
            r19 = r2
            r0 = r19
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r19 = r0
            r20 = -1
            r21 = r2
            r0 = r21
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r21 = r0
            r0 = r21
            int r0 = r0.f280b
            r21 = r0
            int r20 = r20 + r21
            r21 = 1
            r17.mo11190a(r18, r19, r20, r21)
        L_0x00e4:
            r17 = r2
            r0 = r17
            org.objectweb.asm.Label r0 = r0.f392P
            r17 = r0
            if (r17 == 0) goto L_0x0108
            r17 = r6
            if (r17 == 0) goto L_0x00f9
            r17 = r2
            r18 = r6
            r17.visitLabel(r18)
        L_0x00f9:
            r17 = r3
            r18 = 167(0xa7, float:2.34E-43)
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x0108
            r17 = r2
            r17.m144e()
        L_0x0108:
            return
        L_0x0109:
            r17 = r3
            r18 = 168(0xa8, float:2.35E-43)
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x0189
            r17 = 512(0x200, float:7.175E-43)
            r18 = r4
            r0 = r18
            int r0 = r0.f365a
            r18 = r0
            r17 = r17 & r18
            if (r17 != 0) goto L_0x0149
            r17 = r4
            r18 = 512(0x200, float:7.175E-43)
            r19 = r4
            r0 = r19
            int r0 = r0.f365a
            r19 = r0
            r18 = r18 | r19
            r0 = r18
            r1 = r17
            r1.f365a = r0
            r17 = r2
            r18 = 1
            r19 = r2
            r0 = r19
            int r0 = r0.f388L
            r19 = r0
            int r18 = r18 + r19
            r0 = r18
            r1 = r17
            r1.f388L = r0
        L_0x0149:
            r17 = r2
            r0 = r17
            org.objectweb.asm.Label r0 = r0.f392P
            r17 = r0
            r15 = r17
            r17 = r15
            r18 = 128(0x80, float:1.794E-43)
            r19 = r15
            r0 = r19
            int r0 = r0.f365a
            r19 = r0
            r18 = r18 | r19
            r0 = r18
            r1 = r17
            r1.f365a = r0
            r17 = r2
            r18 = 1
            r19 = r2
            r0 = r19
            int r0 = r0.f393Q
            r19 = r0
            int r18 = r18 + r19
            r19 = r4
            r17.m133a(r18, r19)
            org.objectweb.asm.Label r17 = new org.objectweb.asm.Label
            r22 = r17
            r17 = r22
            r18 = r22
            r18.<init>()
            r6 = r17
            goto L_0x007b
        L_0x0189:
            r17 = r2
            r18 = r2
            r0 = r18
            int r0 = r0.f393Q
            r18 = r0
            int[] r19 = org.objectweb.asm.Frame.f337a
            r20 = r3
            r19 = r19[r20]
            int r18 = r18 + r19
            r0 = r18
            r1 = r17
            r1.f393Q = r0
            r17 = r2
            r18 = r2
            r0 = r18
            int r0 = r0.f393Q
            r18 = r0
            r19 = r4
            r17.m133a(r18, r19)
            r17 = 0
            r6 = r17
            goto L_0x007b
        L_0x01b6:
            r17 = r3
            r18 = 168(0xa8, float:2.35E-43)
            r0 = r17
            r1 = r18
            if (r0 != r1) goto L_0x01d0
            r17 = r2
            r0 = r17
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r17 = r0
            r18 = 201(0xc9, float:2.82E-43)
            org.objectweb.asm.ByteVector r17 = r17.putByte(r18)
            goto L_0x00c1
        L_0x01d0:
            r17 = r6
            if (r17 == 0) goto L_0x01e8
            r17 = r6
            r18 = 16
            r19 = r6
            r0 = r19
            int r0 = r0.f365a
            r19 = r0
            r18 = r18 | r19
            r0 = r18
            r1 = r17
            r1.f365a = r0
        L_0x01e8:
            r17 = r2
            r0 = r17
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r17 = r0
            r8 = r17
            r17 = r3
            r18 = 166(0xa6, float:2.33E-43)
            r0 = r17
            r1 = r18
            if (r0 > r1) goto L_0x0232
            r17 = -1
            r18 = 1
            r19 = r3
            r20 = 1
            int r19 = r19 + 1
            r18 = r18 ^ r19
            int r17 = r17 + r18
            r9 = r17
        L_0x020c:
            r17 = r8
            r18 = r9
            org.objectweb.asm.ByteVector r17 = r17.putByte(r18)
            r17 = r2
            r0 = r17
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r17 = r0
            r18 = 8
            org.objectweb.asm.ByteVector r17 = r17.putShort(r18)
            r17 = r2
            r0 = r17
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r17 = r0
            r18 = 200(0xc8, float:2.8E-43)
            org.objectweb.asm.ByteVector r17 = r17.putByte(r18)
            goto L_0x00c1
        L_0x0232:
            r17 = r3
            r18 = 1
            r17 = r17 ^ 1
            r9 = r17
            goto L_0x020c
        L_0x023b:
            r17 = r2
            r0 = r17
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r17 = r0
            r18 = r3
            org.objectweb.asm.ByteVector r17 = r17.putByte(r18)
            r17 = r4
            r18 = r2
            r19 = r2
            r0 = r19
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r19 = r0
            r20 = -1
            r21 = r2
            r0 = r21
            org.objectweb.asm.ByteVector r0 = r0.f413r
            r21 = r0
            r0 = r21
            int r0 = r0.f280b
            r21 = r0
            int r20 = r20 + r21
            r21 = 0
            r17.mo11190a(r18, r19, r20, r21)
            goto L_0x00e4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.visitJumpInsn(int, org.objectweb.asm.Label):void");
    }

    public void visitLabel(Label label) {
        Frame frame;
        Label label2 = label;
        this.f387K |= label2.mo11193a(this, this.f413r.f280b, this.f413r.f279a);
        if ((1 & label2.f365a) == 0) {
            if (this.f389M == 0) {
                if (this.f392P != null) {
                    if (label2.f367c == this.f392P.f367c) {
                        this.f392P.f365a |= 16 & label2.f365a;
                        label2.f372h = this.f392P.f372h;
                        return;
                    }
                    m133a(0, label2);
                }
                this.f392P = label2;
                if (label2.f372h == null) {
                    Label label3 = label2;
                    Frame frame2 = frame;
                    Frame frame3 = new Frame();
                    label3.f372h = frame2;
                    label2.f372h.f338b = label2;
                }
                if (this.f391O != null) {
                    if (label2.f367c == this.f391O.f367c) {
                        this.f391O.f365a |= 16 & label2.f365a;
                        label2.f372h = this.f391O.f372h;
                        this.f392P = this.f391O;
                        return;
                    }
                    this.f391O.f373i = label2;
                }
                this.f391O = label2;
            } else if (this.f389M == 1) {
                if (this.f392P != null) {
                    this.f392P.f371g = this.f394R;
                    m133a(this.f393Q, label2);
                }
                this.f392P = label2;
                this.f393Q = 0;
                this.f394R = 0;
                if (this.f391O != null) {
                    this.f391O.f373i = label2;
                }
                this.f391O = label2;
            }
        }
    }

    public void visitLdcInsn(Object obj) {
        Item a = this.f397b.mo11149a(obj);
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(18, 0, this.f397b, a);
            } else {
                int i = (a.f357b == 5 || a.f357b == 6) ? 2 + this.f393Q : 1 + this.f393Q;
                if (i > this.f394R) {
                    this.f394R = i;
                }
                this.f393Q = i;
            }
        }
        int i2 = a.f356a;
        if (a.f357b == 5 || a.f357b == 6) {
            ByteVector b = this.f413r.mo11111b(20, i2);
        } else if (i2 >= 256) {
            ByteVector b2 = this.f413r.mo11111b(19, i2);
        } else {
            ByteVector a2 = this.f413r.mo11110a(18, i2);
        }
    }

    public void visitLineNumber(int i, Label label) {
        ByteVector byteVector;
        int i2 = i;
        Label label2 = label;
        if (this.f385I == null) {
            ByteVector byteVector2 = byteVector;
            ByteVector byteVector3 = new ByteVector();
            this.f385I = byteVector2;
        }
        this.f384H = 1 + this.f384H;
        ByteVector putShort = this.f385I.putShort(label2.f367c);
        ByteVector putShort2 = this.f385I.putShort(i2);
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        ByteVector byteVector;
        ByteVector byteVector2;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Label label3 = label;
        Label label4 = label2;
        int i2 = i;
        int i3 = 2;
        if (str6 != null) {
            if (this.f383G == null) {
                ByteVector byteVector3 = byteVector2;
                ByteVector byteVector4 = new ByteVector();
                this.f383G = byteVector3;
            }
            this.f382F = 1 + this.f382F;
            ByteVector putShort = this.f383G.putShort(label3.f367c).putShort(label4.f367c - label3.f367c).putShort(this.f397b.newUTF8(str4)).putShort(this.f397b.newUTF8(str6)).putShort(i2);
        }
        if (this.f381E == null) {
            ByteVector byteVector5 = byteVector;
            ByteVector byteVector6 = new ByteVector();
            this.f381E = byteVector5;
        }
        this.f380D = 1 + this.f380D;
        ByteVector putShort2 = this.f381E.putShort(label3.f367c).putShort(label4.f367c - label3.f367c).putShort(this.f397b.newUTF8(str4)).putShort(this.f397b.newUTF8(str5)).putShort(i2);
        if (this.f389M != 2) {
            char charAt = str5.charAt(0);
            if (!(charAt == 'J' || charAt == 'D')) {
                i3 = 1;
            }
            int i4 = i3 + i2;
            if (i4 > this.f415t) {
                this.f415t = i4;
            }
        }
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        Label label2 = label;
        int[] iArr2 = iArr;
        Label[] labelArr2 = labelArr;
        int i = this.f413r.f280b;
        ByteVector putByte = this.f413r.putByte(171);
        ByteVector putByteArray = this.f413r.putByteArray(null, 0, (4 - (this.f413r.f280b % 4)) % 4);
        label2.mo11190a(this, this.f413r, i, true);
        ByteVector putInt = this.f413r.putInt(labelArr2.length);
        for (int i2 = 0; i2 < labelArr2.length; i2++) {
            ByteVector putInt2 = this.f413r.putInt(iArr2[i2]);
            labelArr2[i2].mo11190a(this, this.f413r, i, true);
        }
        m135a(label2, labelArr2);
    }

    public void visitMaxs(int i, int i2) {
        Label label;
        Edge edge;
        int i3;
        Edge edge2;
        int i4 = i;
        int i5 = i2;
        if (this.f389M == 0) {
            Handler handler = this.f378B;
            while (true) {
                Handler handler2 = handler;
                if (handler2 == null) {
                    break;
                }
                Label a = handler2.f350a.mo11188a();
                Label a2 = handler2.f352c.mo11188a();
                Label a3 = handler2.f351b.mo11188a();
                int c = 24117248 | this.f397b.mo11155c(handler2.f353d == null ? "java/lang/Throwable" : handler2.f353d);
                a2.f365a = 16 | a2.f365a;
                Label label2 = a;
                while (true) {
                    Label label3 = label2;
                    if (label3 == a3) {
                        break;
                    }
                    Edge edge3 = edge2;
                    Edge edge4 = new Edge();
                    Edge edge5 = edge3;
                    edge5.f324a = c;
                    edge5.f325b = a2;
                    edge5.f326c = label3.f374j;
                    label3.f374j = edge5;
                    label2 = label3.f373i;
                }
                handler = handler2.f355f;
            }
            Frame frame = this.f390N.f372h;
            frame.mo11171a(this.f397b, this.f398c, Type.getArgumentTypes(this.f401f), this.f415t);
            m140b(frame);
            Label label4 = this.f390N;
            int i6 = 0;
            while (true) {
                i3 = i6;
                if (label4 == null) {
                    break;
                }
                Label label5 = label4.f375k;
                label4.f375k = null;
                Frame frame2 = label4.f372h;
                if ((16 & label4.f365a) != 0) {
                    label4.f365a = 32 | label4.f365a;
                }
                label4.f365a = 64 | label4.f365a;
                int length = frame2.f340d.length + label4.f371g;
                if (length <= i3) {
                    length = i3;
                }
                Edge edge6 = label4.f374j;
                while (edge6 != null) {
                    Label a4 = edge6.f325b.mo11188a();
                    if (!frame2.mo11172a(this.f397b, a4.f372h, edge6.f324a) || a4.f375k != null) {
                        a4 = label5;
                    } else {
                        a4.f375k = label5;
                    }
                    edge6 = edge6.f326c;
                    label5 = a4;
                }
                label4 = label5;
                i6 = length;
            }
            int i7 = i3;
            for (Label label6 = this.f390N; label6 != null; label6 = label6.f373i) {
                Frame frame3 = label6.f372h;
                if ((32 & label6.f365a) != 0) {
                    m140b(frame3);
                }
                if ((64 & label6.f365a) == 0) {
                    Label label7 = label6.f373i;
                    int i8 = label6.f367c;
                    int i9 = (label7 == null ? this.f413r.f280b : label7.f367c) - 1;
                    if (i9 >= i8) {
                        i7 = Math.max(i7, 1);
                        for (int i10 = i8; i10 < i9; i10++) {
                            this.f413r.f279a[i10] = 0;
                        }
                        this.f413r.f279a[i9] = -65;
                        m132a(i8, 0, 1);
                        int[] iArr = this.f421z;
                        int i11 = this.f420y;
                        this.f420y = i11 + 1;
                        iArr[i11] = 24117248 | this.f397b.mo11155c("java/lang/Throwable");
                        m139b();
                        this.f378B = Handler.m112a(this.f378B, label6, label7);
                    }
                }
            }
            this.f377A = 0;
            for (Handler handler3 = this.f378B; handler3 != null; handler3 = handler3.f355f) {
                this.f377A = 1 + this.f377A;
            }
            this.f414s = i7;
            return;
        }
        if (this.f389M == 1) {
            Handler handler4 = this.f378B;
            while (true) {
                Handler handler5 = handler4;
                if (handler5 == null) {
                    break;
                }
                Label label8 = handler5.f352c;
                Label label9 = handler5.f351b;
                for (Label label10 = handler5.f350a; label10 != label9; label10 = label10.f373i) {
                    Edge edge7 = edge;
                    Edge edge8 = new Edge();
                    Edge edge9 = edge7;
                    edge9.f324a = IDirectInputDevice.DIPROPRANGE_NOMAX;
                    edge9.f325b = label8;
                    if ((128 & label10.f365a) == 0) {
                        edge9.f326c = label10.f374j;
                        label10.f374j = edge9;
                    } else {
                        edge9.f326c = label10.f374j.f326c.f326c;
                        label10.f374j.f326c.f326c = edge9;
                    }
                }
                handler4 = handler5.f355f;
            }
            if (this.f388L > 0) {
                this.f390N.mo11194b(null, 1, this.f388L);
                int i12 = 0;
                for (Label label11 = this.f390N; label11 != null; label11 = label11.f373i) {
                    if ((128 & label11.f365a) != 0) {
                        Label label12 = label11.f374j.f326c.f325b;
                        if ((1024 & label12.f365a) == 0) {
                            i12++;
                            label12.mo11194b(null, ((((long) i12) / 32) << 32) | (1 << (i12 % 32)), this.f388L);
                        }
                    }
                }
                Label label13 = this.f390N;
                while (true) {
                    Label label14 = label13;
                    if (label14 == null) {
                        break;
                    }
                    if ((128 & label14.f365a) != 0) {
                        Label label15 = this.f390N;
                        while (true) {
                            Label label16 = label15;
                            if (label16 == null) {
                                break;
                            }
                            label16.f365a = -2049 & label16.f365a;
                            label15 = label16.f373i;
                        }
                        label14.f374j.f326c.f325b.mo11194b(label14, 0, this.f388L);
                    }
                    label13 = label14.f373i;
                }
            }
            Label label17 = this.f390N;
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (label17 != null) {
                    Label label18 = label17.f375k;
                    int i15 = label17.f370f;
                    int i16 = i15 + label17.f371g;
                    if (i16 <= i14) {
                        i16 = i14;
                    }
                    Edge edge10 = label17.f374j;
                    Edge edge11 = (128 & label17.f365a) != 0 ? edge10.f326c : edge10;
                    while (edge11 != null) {
                        Label label19 = edge11.f325b;
                        if ((8 & label19.f365a) == 0) {
                            label19.f370f = edge11.f324a == Integer.MAX_VALUE ? 1 : i15 + edge11.f324a;
                            label19.f365a = 8 | label19.f365a;
                            label19.f375k = label18;
                            label = label19;
                        } else {
                            label = label18;
                        }
                        Label label20 = label;
                        edge11 = edge11.f326c;
                        label18 = label20;
                    }
                    label17 = label18;
                    i13 = i16;
                } else {
                    this.f414s = Math.max(i4, i14);
                    return;
                }
            }
        } else {
            this.f414s = i4;
            this.f415t = i5;
        }
    }

    public void visitMethodInsn(int i, String str, String str2, String str3) {
        int i2;
        int i3;
        int i4 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        boolean z = i4 == 185;
        Item a = this.f397b.mo11153a(str4, str5, str6, z);
        int i5 = a.f358c;
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(i4, 0, this.f397b, a);
            } else {
                if (i5 == 0) {
                    i3 = Type.getArgumentsAndReturnSizes(str6);
                    a.f358c = i3;
                } else {
                    i3 = i5;
                }
                int i6 = i4 == 184 ? 1 + (this.f393Q - (i3 >> 2)) + (i3 & 3) : (this.f393Q - (i3 >> 2)) + (i3 & 3);
                if (i6 > this.f394R) {
                    this.f394R = i6;
                }
                this.f393Q = i6;
                i5 = i3;
            }
        }
        if (z) {
            if (i5 == 0) {
                i2 = Type.getArgumentsAndReturnSizes(str6);
                a.f358c = i2;
            } else {
                i2 = i5;
            }
            ByteVector a2 = this.f413r.mo11111b(185, a.f356a).mo11110a(i2 >> 2, 0);
            return;
        }
        ByteVector b = this.f413r.mo11111b(i4, a.f356a);
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        int i2 = i;
        Item a = this.f397b.mo11150a(str);
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(197, i2, this.f397b, a);
            } else {
                this.f393Q += 1 - i2;
            }
        }
        ByteVector putByte = this.f413r.mo11111b(197, a.f356a).putByte(i2);
    }

    public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
        ByteVector byteVector;
        AnnotationWriter annotationWriter;
        AnnotationWriter annotationWriter2;
        int i2 = i;
        String str2 = str;
        boolean z2 = z;
        ByteVector byteVector2 = byteVector;
        ByteVector byteVector3 = new ByteVector();
        ByteVector byteVector4 = byteVector2;
        if ("Ljava/lang/Synthetic;".equals(str2)) {
            this.f395S = Math.max(this.f395S, i2 + 1);
            AnnotationWriter annotationWriter3 = annotationWriter2;
            AnnotationWriter annotationWriter4 = new AnnotationWriter(this.f397b, false, byteVector4, null, 0);
            return annotationWriter3;
        }
        ByteVector putShort = byteVector4.putShort(this.f397b.newUTF8(str2)).putShort(0);
        AnnotationWriter annotationWriter5 = annotationWriter;
        AnnotationWriter annotationWriter6 = new AnnotationWriter(this.f397b, true, byteVector4, byteVector4, 2);
        AnnotationWriter annotationWriter7 = annotationWriter5;
        if (z2) {
            if (this.f410o == null) {
                this.f410o = new AnnotationWriter[Type.getArgumentTypes(this.f401f).length];
            }
            annotationWriter7.f275g = this.f410o[i2];
            this.f410o[i2] = annotationWriter7;
            return annotationWriter7;
        }
        if (this.f411p == null) {
            this.f411p = new AnnotationWriter[Type.getArgumentTypes(this.f401f).length];
        }
        annotationWriter7.f275g = this.f411p[i2];
        this.f411p[i2] = annotationWriter7;
        return annotationWriter7;
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        int i3 = i;
        int i4 = i2;
        Label label2 = label;
        Label[] labelArr2 = labelArr;
        int i5 = this.f413r.f280b;
        ByteVector putByte = this.f413r.putByte(170);
        ByteVector putByteArray = this.f413r.putByteArray(null, 0, (4 - (this.f413r.f280b % 4)) % 4);
        label2.mo11190a(this, this.f413r, i5, true);
        ByteVector putInt = this.f413r.putInt(i3).putInt(i4);
        for (int i6 = 0; i6 < labelArr2.length; i6++) {
            labelArr2[i6].mo11190a(this, this.f413r, i5, true);
        }
        m135a(label2, labelArr2);
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        Handler handler;
        Label label4 = label;
        Label label5 = label2;
        Label label6 = label3;
        String str2 = str;
        this.f377A = 1 + this.f377A;
        Handler handler2 = handler;
        Handler handler3 = new Handler();
        Handler handler4 = handler2;
        handler4.f350a = label4;
        handler4.f351b = label5;
        handler4.f352c = label6;
        handler4.f353d = str2;
        handler4.f354e = str2 != null ? this.f397b.newClass(str2) : 0;
        if (this.f379C == null) {
            this.f378B = handler4;
        } else {
            this.f379C.f355f = handler4;
        }
        this.f379C = handler4;
    }

    public void visitTypeInsn(int i, String str) {
        int i2 = i;
        Item a = this.f397b.mo11150a(str);
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(i2, this.f413r.f280b, this.f397b, a);
            } else if (i2 == 187) {
                int i3 = 1 + this.f393Q;
                if (i3 > this.f394R) {
                    this.f394R = i3;
                }
                this.f393Q = i3;
            }
        }
        ByteVector b = this.f413r.mo11111b(i2, a.f356a);
    }

    public void visitVarInsn(int i, int i2) {
        Label label;
        int i3 = i;
        int i4 = i2;
        if (this.f392P != null) {
            if (this.f389M == 0) {
                this.f392P.f372h.mo11170a(i3, i4, (ClassWriter) null, (Item) null);
            } else if (i3 == 169) {
                Label label2 = this.f392P;
                label2.f365a = 256 | label2.f365a;
                this.f392P.f370f = this.f393Q;
                m144e();
            } else {
                int i5 = this.f393Q + Frame.f337a[i3];
                if (i5 > this.f394R) {
                    this.f394R = i5;
                }
                this.f393Q = i5;
            }
        }
        if (this.f389M != 2) {
            int i6 = (i3 == 22 || i3 == 24 || i3 == 55 || i3 == 57) ? i4 + 2 : i4 + 1;
            if (i6 > this.f415t) {
                this.f415t = i6;
            }
        }
        if (i4 < 4 && i3 != 169) {
            ByteVector putByte = this.f413r.putByte(i3 < 54 ? i4 + 26 + ((i3 - 21) << 2) : i4 + 59 + ((i3 - 54) << 2));
        } else if (i4 >= 256) {
            ByteVector b = this.f413r.putByte(196).mo11111b(i3, i4);
        } else {
            ByteVector a = this.f413r.mo11110a(i3, i4);
        }
        if (i3 >= 54 && this.f389M == 0 && this.f377A > 0) {
            Label label3 = label;
            Label label4 = new Label();
            visitLabel(label3);
        }
    }
}
