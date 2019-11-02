package org.objectweb.asm;

public class ClassWriter extends ClassVisitor {
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;

    /* renamed from: a */
    static final byte[] f286a;

    /* renamed from: A */
    ByteVector f287A;

    /* renamed from: B */
    FieldWriter f288B;

    /* renamed from: C */
    FieldWriter f289C;

    /* renamed from: D */
    MethodWriter f290D;

    /* renamed from: E */
    MethodWriter f291E;

    /* renamed from: G */
    private short f292G;

    /* renamed from: H */
    Item[] f293H;

    /* renamed from: I */
    String f294I;

    /* renamed from: J */
    private final boolean f295J;

    /* renamed from: K */
    private final boolean f296K;

    /* renamed from: L */
    boolean f297L;

    /* renamed from: M */
    ClassReader f298M;

    /* renamed from: b */
    int f299b;

    /* renamed from: c */
    int f300c;

    /* renamed from: d */
    final ByteVector f301d;

    /* renamed from: e */
    Item[] f302e;

    /* renamed from: f */
    int f303f;

    /* renamed from: g */
    final Item f304g;

    /* renamed from: h */
    final Item f305h;

    /* renamed from: i */
    final Item f306i;

    /* renamed from: j */
    final Item f307j;

    /* renamed from: k */
    private int f308k;

    /* renamed from: l */
    private int f309l;

    /* renamed from: m */
    private int f310m;

    /* renamed from: n */
    private int f311n;

    /* renamed from: o */
    private int f312o;

    /* renamed from: p */
    private int[] f313p;

    /* renamed from: q */
    private int f314q;

    /* renamed from: r */
    private ByteVector f315r;

    /* renamed from: s */
    private int f316s;

    /* renamed from: t */
    private int f317t;

    /* renamed from: u */
    private AnnotationWriter f318u;

    /* renamed from: v */
    private AnnotationWriter f319v;

    /* renamed from: w */
    private Attribute f320w;

    /* renamed from: x */
    private int f321x;

    /* renamed from: y */
    private ByteVector f322y;

    /* renamed from: z */
    int f323z;

    static {
        byte[] bArr = new byte[220];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (65471 + "AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i));
        }
        f286a = bArr;
    }

    public ClassWriter(int i) {
        ByteVector byteVector;
        Item item;
        Item item2;
        Item item3;
        Item item4;
        int i2 = i;
        boolean z = true;
        super(262144);
        this.f300c = 1;
        ByteVector byteVector2 = byteVector;
        ByteVector byteVector3 = new ByteVector();
        this.f301d = byteVector2;
        this.f302e = new Item[256];
        this.f303f = (int) (0.75d * ((double) this.f302e.length));
        Item item5 = item;
        Item item6 = new Item();
        this.f304g = item5;
        Item item7 = item2;
        Item item8 = new Item();
        this.f305h = item7;
        Item item9 = item3;
        Item item10 = new Item();
        this.f306i = item9;
        Item item11 = item4;
        Item item12 = new Item();
        this.f307j = item11;
        this.f296K = (i2 & 1) != 0;
        if ((i2 & 2) == 0) {
            z = false;
        }
        this.f295J = z;
    }

    public ClassWriter(ClassReader classReader, int i) {
        ClassReader classReader2 = classReader;
        this(i);
        classReader2.mo11118a(this);
        this.f298M = classReader2;
    }

    /* renamed from: a */
    private Item m75a(Item item) {
        Item item2;
        Item item3 = item;
        Item item4 = this.f302e[item3.f363j % this.f302e.length];
        while (true) {
            item2 = item4;
            if (item2 != null && (item2.f357b != item3.f357b || !item3.mo11187a(item2))) {
                item4 = item2.f364k;
            }
        }
        return item2;
    }

    /* renamed from: a */
    private void m76a(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteVector putShort = this.f301d.mo11111b(i4, i5).putShort(i6);
    }

    /* renamed from: b */
    private Item m77b(String str) {
        Item item;
        String str2 = str;
        this.f305h.mo11184a(8, str2, null, null);
        Item a = m75a(this.f305h);
        if (a == null) {
            ByteVector b = this.f301d.mo11111b(8, newUTF8(str2));
            int i = this.f300c;
            this.f300c = i + 1;
            Item item2 = item;
            Item item3 = new Item(i, this.f305h);
            a = item2;
            m79b(a);
        }
        return a;
    }

    /* renamed from: b */
    private void m78b(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ByteVector putShort = this.f301d.mo11110a(i4, i5).putShort(i6);
    }

    /* renamed from: b */
    private void m79b(Item item) {
        Item item2 = item;
        if (this.f300c + this.f292G > this.f303f) {
            int length = this.f302e.length;
            int i = 1 + (length * 2);
            Item[] itemArr = new Item[i];
            for (int i2 = length - 1; i2 >= 0; i2--) {
                Item item3 = this.f302e[i2];
                while (true) {
                    Item item4 = item3;
                    if (item4 == null) {
                        break;
                    }
                    int length2 = item4.f363j % itemArr.length;
                    Item item5 = item4.f364k;
                    item4.f364k = itemArr[length2];
                    itemArr[length2] = item4;
                    item3 = item5;
                }
            }
            this.f302e = itemArr;
            this.f303f = (int) (0.75d * ((double) i));
        }
        int length3 = item2.f363j % this.f302e.length;
        item2.f364k = this.f302e[length3];
        this.f302e[length3] = item2;
    }

    /* renamed from: c */
    private Item m80c(Item item) {
        Item item2;
        Item item3 = item;
        this.f292G = (short) (1 + this.f292G);
        Item item4 = item2;
        Item item5 = new Item(this.f292G, this.f304g);
        Item item6 = item4;
        m79b(item6);
        if (this.f293H == null) {
            this.f293H = new Item[16];
        }
        if (this.f292G == this.f293H.length) {
            Item[] itemArr = new Item[(2 * this.f293H.length)];
            System.arraycopy(this.f293H, 0, itemArr, 0, this.f293H.length);
            this.f293H = itemArr;
        }
        this.f293H[this.f292G] = item6;
        return item6;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo11142a(int i, int i2) {
        Item item;
        int i3 = i;
        int i4 = i2;
        this.f305h.f357b = 32;
        this.f305h.f359d = ((long) i3) | (((long) i4) << 32);
        this.f305h.f363j = Integer.MAX_VALUE & (i4 + i3 + 32);
        Item a = m75a(this.f305h);
        if (a == null) {
            String str = this.f293H[i3].f360g;
            String str2 = this.f293H[i4].f360g;
            this.f305h.f358c = mo11155c(getCommonSuperClass(str, str2));
            Item item2 = item;
            Item item3 = new Item(0, this.f305h);
            a = item2;
            m79b(a);
        }
        return a.f358c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo11143a(String str, int i) {
        String str2 = str;
        int i2 = i;
        this.f304g.f357b = 31;
        this.f304g.f358c = i2;
        this.f304g.f360g = str2;
        this.f304g.f363j = Integer.MAX_VALUE & (i2 + 31 + str2.hashCode());
        Item a = m75a(this.f304g);
        if (a == null) {
            a = m80c(this.f304g);
        }
        return a.f356a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11144a(double d) {
        Item item;
        this.f304g.mo11180a(d);
        Item a = m75a(this.f304g);
        if (a == null) {
            ByteVector putLong = this.f301d.putByte(6).putLong(this.f304g.f359d);
            Item item2 = item;
            Item item3 = new Item(this.f300c, this.f304g);
            a = item2;
            this.f300c = 2 + this.f300c;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11145a(float f) {
        Item item;
        this.f304g.mo11181a(f);
        Item a = m75a(this.f304g);
        if (a == null) {
            ByteVector putInt = this.f301d.putByte(4).putInt(this.f304g.f358c);
            int i = this.f300c;
            this.f300c = i + 1;
            Item item2 = item;
            Item item3 = new Item(i, this.f304g);
            a = item2;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11146a(int i) {
        Item item;
        int i2 = i;
        this.f304g.mo11182a(i2);
        Item a = m75a(this.f304g);
        if (a == null) {
            ByteVector putInt = this.f301d.putByte(3).putInt(i2);
            int i3 = this.f300c;
            this.f300c = i3 + 1;
            Item item2 = item;
            Item item3 = new Item(i3, this.f304g);
            a = item2;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11147a(int i, String str, String str2, String str3) {
        Item item;
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        this.f307j.mo11184a(i2 + 20, str4, str5, str6);
        Item a = m75a(this.f307j);
        if (a == null) {
            if (i2 <= 4) {
                m78b(15, i2, newField(str4, str5, str6));
            } else {
                m78b(15, i2, newMethod(str4, str5, str6, i2 == 9));
            }
            int i3 = this.f300c;
            this.f300c = i3 + 1;
            Item item2 = item;
            Item item3 = new Item(i3, this.f307j);
            a = item2;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11148a(long j) {
        Item item;
        long j2 = j;
        this.f304g.mo11185a(j2);
        Item a = m75a(this.f304g);
        if (a == null) {
            ByteVector putLong = this.f301d.putByte(5).putLong(j2);
            Item item2 = item;
            Item item3 = new Item(this.f300c, this.f304g);
            a = item2;
            this.f300c = 2 + this.f300c;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11149a(Object obj) {
        IllegalArgumentException illegalArgumentException;
        StringBuffer stringBuffer;
        Object obj2 = obj;
        if (obj2 instanceof Integer) {
            return mo11146a(((Integer) obj2).intValue());
        }
        if (obj2 instanceof Byte) {
            return mo11146a(((Byte) obj2).intValue());
        }
        if (obj2 instanceof Character) {
            return mo11146a((int) ((Character) obj2).charValue());
        }
        if (obj2 instanceof Short) {
            return mo11146a(((Short) obj2).intValue());
        }
        if (obj2 instanceof Boolean) {
            return mo11146a(((Boolean) obj2).booleanValue() ? 1 : 0);
        } else if (obj2 instanceof Float) {
            return mo11145a(((Float) obj2).floatValue());
        } else {
            if (obj2 instanceof Long) {
                return mo11148a(((Long) obj2).longValue());
            }
            if (obj2 instanceof Double) {
                return mo11144a(((Double) obj2).doubleValue());
            }
            if (obj2 instanceof String) {
                return m77b((String) obj2);
            }
            if (obj2 instanceof Type) {
                Type type = (Type) obj2;
                int sort = type.getSort();
                return sort == 9 ? mo11150a(type.getDescriptor()) : sort == 10 ? mo11150a(type.getInternalName()) : mo11155c(type.getDescriptor());
            } else if (obj2 instanceof Handle) {
                Handle handle = (Handle) obj2;
                return mo11147a(handle.f346a, handle.f347b, handle.f348c, handle.f349d);
            } else {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuffer2.append("value ").append(obj2).toString());
                throw illegalArgumentException2;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11150a(String str) {
        Item item;
        String str2 = str;
        this.f305h.mo11184a(7, str2, null, null);
        Item a = m75a(this.f305h);
        if (a == null) {
            ByteVector b = this.f301d.mo11111b(7, newUTF8(str2));
            int i = this.f300c;
            this.f300c = i + 1;
            Item item2 = item;
            Item item3 = new Item(i, this.f305h);
            a = item2;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11151a(String str, String str2) {
        Item item;
        String str3 = str;
        String str4 = str2;
        this.f305h.mo11184a(12, str3, str4, null);
        Item a = m75a(this.f305h);
        if (a == null) {
            m76a(12, newUTF8(str3), newUTF8(str4));
            int i = this.f300c;
            this.f300c = i + 1;
            Item item2 = item;
            Item item3 = new Item(i, this.f305h);
            a = item2;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11152a(String str, String str2, String str3) {
        Item item;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        this.f306i.mo11184a(9, str4, str5, str6);
        Item a = m75a(this.f306i);
        if (a == null) {
            m76a(9, newClass(str4), newNameType(str5, str6));
            int i = this.f300c;
            this.f300c = i + 1;
            Item item2 = item;
            Item item3 = new Item(i, this.f306i);
            a = item2;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11153a(String str, String str2, String str3, boolean z) {
        Item item;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        int i = z ? 11 : 10;
        this.f306i.mo11184a(i, str4, str5, str6);
        Item a = m75a(this.f306i);
        if (a != null) {
            return a;
        }
        m76a(i, newClass(str4), newNameType(str5, str6));
        int i2 = this.f300c;
        this.f300c = i2 + 1;
        Item item2 = item;
        Item item3 = new Item(i2, this.f306i);
        Item item4 = item2;
        m79b(item4);
        return item4;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Item mo11154a(String str, String str2, Handle handle, Object... objArr) {
        Item item;
        int i;
        Item item2;
        Item item3;
        ByteVector byteVector;
        String str3 = str;
        String str4 = str2;
        Handle handle2 = handle;
        Object[] objArr2 = objArr;
        ByteVector byteVector2 = this.f287A;
        if (byteVector2 == null) {
            ByteVector byteVector3 = byteVector;
            ByteVector byteVector4 = new ByteVector();
            byteVector2 = byteVector3;
            this.f287A = byteVector2;
        }
        int i2 = byteVector2.f280b;
        int hashCode = handle2.hashCode();
        ByteVector putShort = byteVector2.putShort(newHandle(handle2.f346a, handle2.f347b, handle2.f348c, handle2.f349d));
        int length = objArr2.length;
        ByteVector putShort2 = byteVector2.putShort(length);
        int i3 = hashCode;
        for (int i4 = 0; i4 < length; i4++) {
            Object obj = objArr2[i4];
            i3 ^= obj.hashCode();
            ByteVector putShort3 = byteVector2.putShort(newConst(obj));
        }
        byte[] bArr = byteVector2.f279a;
        int i5 = (length + 2) << 1;
        int i6 = i3 & IDirectInputDevice.DIPROPRANGE_NOMAX;
        Item item4 = this.f302e[i6 % this.f302e.length];
        loop1:
        while (true) {
            item = item4;
            if (item != null) {
                if (item.f357b == 33 && item.f363j == i6) {
                    int i7 = item.f358c;
                    int i8 = 0;
                    while (i8 < i5) {
                        if (bArr[i2 + i8] != bArr[i7 + i8]) {
                            item4 = item.f364k;
                        } else {
                            i8++;
                        }
                    }
                    break loop1;
                }
                item4 = item.f364k;
            } else {
                break;
            }
        }
        if (item != null) {
            int i9 = item.f356a;
            byteVector2.f280b = i2;
            i = i9;
        } else {
            i = this.f323z;
            this.f323z = i + 1;
            Item item5 = item2;
            Item item6 = new Item(i);
            Item item7 = item5;
            item7.mo11183a(i2, i6);
            m79b(item7);
        }
        this.f306i.mo11186a(str3, str4, i);
        Item a = m75a(this.f306i);
        if (a != null) {
            return a;
        }
        m76a(18, i, newNameType(str3, str4));
        int i10 = this.f300c;
        this.f300c = i10 + 1;
        Item item8 = item3;
        Item item9 = new Item(i10, this.f306i);
        Item item10 = item8;
        m79b(item10);
        return item10;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo11155c(String str) {
        this.f304g.mo11184a(30, str, null, null);
        Item a = m75a(this.f304g);
        if (a == null) {
            a = m80c(this.f304g);
        }
        return a.f356a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Item m95c(String str) {
        Item item;
        String str2 = str;
        this.f305h.mo11184a(16, str2, null, null);
        Item a = m75a(this.f305h);
        if (a == null) {
            ByteVector b = this.f301d.mo11111b(16, newUTF8(str2));
            int i = this.f300c;
            this.f300c = i + 1;
            Item item2 = item;
            Item item3 = new Item(i, this.f305h);
            a = item2;
            m79b(a);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public String getCommonSuperClass(String str, String str2) {
        RuntimeException runtimeException;
        String str3 = str;
        String str4 = str2;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class cls = Class.forName(str3.replace(ClassPathElement.SEPARATOR_CHAR, '.'), false, classLoader);
            Class cls2 = Class.forName(str4.replace(ClassPathElement.SEPARATOR_CHAR, '.'), false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                return str3;
            }
            if (cls2.isAssignableFrom(cls)) {
                return str4;
            }
            if (cls.isInterface() || cls2.isInterface()) {
                return "java/lang/Object";
            }
            do {
                cls = cls.getSuperclass();
            } while (!cls.isAssignableFrom(cls2));
            return cls.getName().replace('.', ClassPathElement.SEPARATOR_CHAR);
        } catch (Exception e) {
            Exception exc = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc.toString());
            throw runtimeException2;
        }
    }

    public int newClass(String str) {
        return mo11150a(str).f356a;
    }

    public int newConst(Object obj) {
        return mo11149a(obj).f356a;
    }

    public int newField(String str, String str2, String str3) {
        return mo11152a(str, str2, str3).f356a;
    }

    public int newHandle(int i, String str, String str2, String str3) {
        return mo11147a(i, str, str2, str3).f356a;
    }

    public int newInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return mo11154a(str, str2, handle, objArr).f356a;
    }

    public int newMethod(String str, String str2, String str3, boolean z) {
        return mo11153a(str, str2, str3, z).f356a;
    }

    public int newMethodType(String str) {
        return mo11155c(str).f356a;
    }

    public int newNameType(String str, String str2) {
        return mo11151a(str, str2).f356a;
    }

    public int newUTF8(String str) {
        Item item;
        String str2 = str;
        this.f304g.mo11184a(1, str2, null, null);
        Item a = m75a(this.f304g);
        if (a == null) {
            ByteVector putUTF8 = this.f301d.putByte(1).putUTF8(str2);
            int i = this.f300c;
            this.f300c = i + 1;
            Item item2 = item;
            Item item3 = new Item(i, this.f304g);
            a = item2;
            m79b(a);
        }
        return a.f356a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0185, code lost:
        if ((262144 & r2.f308k) != 0) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0515, code lost:
        if ((262144 & r2.f308k) != 0) goto L_0x0517;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] toByteArray() {
        /*
            r63 = this;
            r2 = r63
            r55 = r2
            r0 = r55
            int r0 = r0.f300c
            r55 = r0
            r56 = 32767(0x7fff, float:4.5916E-41)
            r0 = r55
            r1 = r56
            if (r0 <= r1) goto L_0x0020
            java.lang.RuntimeException r55 = new java.lang.RuntimeException
            r62 = r55
            r55 = r62
            r56 = r62
            java.lang.String r57 = "Class file too large!"
            r56.<init>(r57)
            throw r55
        L_0x0020:
            r55 = 24
            r56 = 2
            r57 = r2
            r0 = r57
            int r0 = r0.f312o
            r57 = r0
            int r56 = r56 * r57
            int r55 = r55 + r56
            r3 = r55
            r55 = r2
            r0 = r55
            org.objectweb.asm.FieldWriter r0 = r0.f288B
            r55 = r0
            r4 = r55
            r55 = 0
            r5 = r55
        L_0x0040:
            r55 = r4
            if (r55 == 0) goto L_0x0069
            r55 = r5
            r56 = 1
            int r55 = r55 + 1
            r54 = r55
            r55 = r3
            r56 = r4
            int r56 = r56.mo11168a()
            int r55 = r55 + r56
            r3 = r55
            r55 = r4
            r0 = r55
            org.objectweb.asm.FieldVisitor r0 = r0.f327fv
            r55 = r0
            org.objectweb.asm.FieldWriter r55 = (org.objectweb.asm.FieldWriter) r55
            r4 = r55
            r55 = r54
            r5 = r55
            goto L_0x0040
        L_0x0069:
            r55 = r2
            r0 = r55
            org.objectweb.asm.MethodWriter r0 = r0.f290D
            r55 = r0
            r6 = r55
            r55 = 0
            r7 = r55
        L_0x0077:
            r55 = r6
            if (r55 == 0) goto L_0x00a0
            r55 = r7
            r56 = 1
            int r55 = r55 + 1
            r53 = r55
            r55 = r3
            r56 = r6
            int r56 = r56.mo11217a()
            int r55 = r55 + r56
            r3 = r55
            r55 = r6
            r0 = r55
            org.objectweb.asm.MethodVisitor r0 = r0.f376mv
            r55 = r0
            org.objectweb.asm.MethodWriter r55 = (org.objectweb.asm.MethodWriter) r55
            r6 = r55
            r55 = r53
            r7 = r55
            goto L_0x0077
        L_0x00a0:
            r55 = r2
            r0 = r55
            org.objectweb.asm.ByteVector r0 = r0.f287A
            r55 = r0
            if (r55 == 0) goto L_0x0643
            r55 = 1
            r8 = r55
            r55 = r3
            r56 = 8
            r57 = r2
            r0 = r57
            org.objectweb.asm.ByteVector r0 = r0.f287A
            r57 = r0
            r0 = r57
            int r0 = r0.f280b
            r57 = r0
            int r56 = r56 + r57
            int r55 = r55 + r56
            r3 = r55
            r55 = r2
            java.lang.String r56 = "BootstrapMethods"
            int r55 = r55.newUTF8(r56)
        L_0x00ce:
            r55 = r2
            r0 = r55
            int r0 = r0.f310m
            r55 = r0
            if (r55 == 0) goto L_0x00e4
            int r8 = r8 + 1
            int r3 = r3 + 8
            r55 = r2
            java.lang.String r56 = "Signature"
            int r55 = r55.newUTF8(r56)
        L_0x00e4:
            r55 = r2
            r0 = r55
            int r0 = r0.f314q
            r55 = r0
            if (r55 == 0) goto L_0x00fa
            int r8 = r8 + 1
            int r3 = r3 + 8
            r55 = r2
            java.lang.String r56 = "SourceFile"
            int r55 = r55.newUTF8(r56)
        L_0x00fa:
            r55 = r2
            r0 = r55
            org.objectweb.asm.ByteVector r0 = r0.f315r
            r55 = r0
            if (r55 == 0) goto L_0x0126
            int r8 = r8 + 1
            r55 = r3
            r56 = 4
            r57 = r2
            r0 = r57
            org.objectweb.asm.ByteVector r0 = r0.f315r
            r57 = r0
            r0 = r57
            int r0 = r0.f280b
            r57 = r0
            int r56 = r56 + r57
            int r55 = r55 + r56
            r3 = r55
            r55 = r2
            java.lang.String r56 = "SourceDebugExtension"
            int r55 = r55.newUTF8(r56)
        L_0x0126:
            r55 = r2
            r0 = r55
            int r0 = r0.f316s
            r55 = r0
            if (r55 == 0) goto L_0x013c
            int r8 = r8 + 1
            int r3 = r3 + 10
            r55 = r2
            java.lang.String r56 = "EnclosingMethod"
            int r55 = r55.newUTF8(r56)
        L_0x013c:
            r55 = 131072(0x20000, float:1.83671E-40)
            r56 = r2
            r0 = r56
            int r0 = r0.f308k
            r56 = r0
            r55 = r55 & r56
            if (r55 == 0) goto L_0x0156
            int r8 = r8 + 1
            int r3 = r3 + 6
            r55 = r2
            java.lang.String r56 = "Deprecated"
            int r55 = r55.newUTF8(r56)
        L_0x0156:
            r55 = 4096(0x1000, float:5.74E-42)
            r56 = r2
            r0 = r56
            int r0 = r0.f308k
            r56 = r0
            r55 = r55 & r56
            if (r55 == 0) goto L_0x0193
            r55 = 65535(0xffff, float:9.1834E-41)
            r56 = r2
            r0 = r56
            int r0 = r0.f299b
            r56 = r0
            r55 = r55 & r56
            r56 = 49
            r0 = r55
            r1 = r56
            if (r0 < r1) goto L_0x0187
            r55 = 262144(0x40000, float:3.67342E-40)
            r56 = r2
            r0 = r56
            int r0 = r0.f308k
            r56 = r0
            r55 = r55 & r56
            if (r55 == 0) goto L_0x0193
        L_0x0187:
            int r8 = r8 + 1
            int r3 = r3 + 6
            r55 = r2
            java.lang.String r56 = "Synthetic"
            int r55 = r55.newUTF8(r56)
        L_0x0193:
            r55 = r2
            r0 = r55
            org.objectweb.asm.ByteVector r0 = r0.f322y
            r55 = r0
            if (r55 == 0) goto L_0x01bf
            int r8 = r8 + 1
            r55 = r3
            r56 = 8
            r57 = r2
            r0 = r57
            org.objectweb.asm.ByteVector r0 = r0.f322y
            r57 = r0
            r0 = r57
            int r0 = r0.f280b
            r57 = r0
            int r56 = r56 + r57
            int r55 = r55 + r56
            r3 = r55
            r55 = r2
            java.lang.String r56 = "InnerClasses"
            int r55 = r55.newUTF8(r56)
        L_0x01bf:
            r55 = r2
            r0 = r55
            org.objectweb.asm.AnnotationWriter r0 = r0.f318u
            r55 = r0
            if (r55 == 0) goto L_0x01e9
            int r8 = r8 + 1
            r55 = r3
            r56 = 8
            r57 = r2
            r0 = r57
            org.objectweb.asm.AnnotationWriter r0 = r0.f318u
            r57 = r0
            int r57 = r57.mo11100a()
            int r56 = r56 + r57
            int r55 = r55 + r56
            r3 = r55
            r55 = r2
            java.lang.String r56 = "RuntimeVisibleAnnotations"
            int r55 = r55.newUTF8(r56)
        L_0x01e9:
            r55 = r2
            r0 = r55
            org.objectweb.asm.AnnotationWriter r0 = r0.f319v
            r55 = r0
            if (r55 == 0) goto L_0x0213
            int r8 = r8 + 1
            r55 = r3
            r56 = 8
            r57 = r2
            r0 = r57
            org.objectweb.asm.AnnotationWriter r0 = r0.f319v
            r57 = r0
            int r57 = r57.mo11100a()
            int r56 = r56 + r57
            int r55 = r55 + r56
            r3 = r55
            r55 = r2
            java.lang.String r56 = "RuntimeInvisibleAnnotations"
            int r55 = r55.newUTF8(r56)
        L_0x0213:
            r55 = r3
            r9 = r55
            r55 = r2
            r0 = r55
            org.objectweb.asm.Attribute r0 = r0.f320w
            r55 = r0
            if (r55 == 0) goto L_0x063d
            r55 = r8
            r56 = r2
            r0 = r56
            org.objectweb.asm.Attribute r0 = r0.f320w
            r56 = r0
            int r56 = r56.mo11102a()
            int r55 = r55 + r56
            r42 = r55
            r55 = r9
            r56 = r2
            r0 = r56
            org.objectweb.asm.Attribute r0 = r0.f320w
            r56 = r0
            r57 = r2
            r58 = 0
            r59 = 0
            r60 = -1
            r61 = -1
            int r56 = r56.mo11103a(r57, r58, r59, r60, r61)
            int r55 = r55 + r56
            r9 = r55
            r55 = r42
            r10 = r55
        L_0x0253:
            org.objectweb.asm.ByteVector r55 = new org.objectweb.asm.ByteVector
            r62 = r55
            r55 = r62
            r56 = r62
            r57 = r9
            r58 = r2
            r0 = r58
            org.objectweb.asm.ByteVector r0 = r0.f301d
            r58 = r0
            r0 = r58
            int r0 = r0.f280b
            r58 = r0
            int r57 = r57 + r58
            r56.<init>(r57)
            r11 = r55
            r55 = r11
            r56 = -889275714(0xffffffffcafebabe, float:-8346975.0)
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
            r56 = r2
            r0 = r56
            int r0 = r0.f299b
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
            r55 = r11
            r56 = r2
            r0 = r56
            int r0 = r0.f300c
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = r2
            r0 = r56
            org.objectweb.asm.ByteVector r0 = r0.f301d
            r56 = r0
            r0 = r56
            byte[] r0 = r0.f279a
            r56 = r0
            r57 = 0
            r58 = r2
            r0 = r58
            org.objectweb.asm.ByteVector r0 = r0.f301d
            r58 = r0
            r0 = r58
            int r0 = r0.f280b
            r58 = r0
            org.objectweb.asm.ByteVector r55 = r55.putByteArray(r56, r57, r58)
            r55 = 393216(0x60000, float:5.51013E-40)
            r56 = 262144(0x40000, float:3.67342E-40)
            r57 = r2
            r0 = r57
            int r0 = r0.f308k
            r57 = r0
            r56 = r56 & r57
            r57 = 64
            int r56 = r56 / 64
            r55 = r55 | r56
            r14 = r55
            r55 = r11
            r56 = r2
            r0 = r56
            int r0 = r0.f308k
            r56 = r0
            r57 = r14
            r58 = -1
            r57 = r57 ^ -1
            r56 = r56 & r57
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = r2
            r0 = r56
            int r0 = r0.f309l
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = r2
            r0 = r56
            int r0 = r0.f311n
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r11
            r56 = r2
            r0 = r56
            int r0 = r0.f312o
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = 0
            r17 = r55
        L_0x030d:
            r55 = r17
            r56 = r2
            r0 = r56
            int r0 = r0.f312o
            r56 = r0
            r0 = r55
            r1 = r56
            if (r0 >= r1) goto L_0x0332
            r55 = r11
            r56 = r2
            r0 = r56
            int[] r0 = r0.f313p
            r56 = r0
            r57 = r17
            r56 = r56[r57]
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            int r17 = r17 + 1
            goto L_0x030d
        L_0x0332:
            r55 = r11
            r56 = r5
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r2
            r0 = r55
            org.objectweb.asm.FieldWriter r0 = r0.f288B
            r55 = r0
            r19 = r55
        L_0x0344:
            r55 = r19
            if (r55 == 0) goto L_0x035c
            r55 = r19
            r56 = r11
            r55.mo11169a(r56)
            r55 = r19
            r0 = r55
            org.objectweb.asm.FieldVisitor r0 = r0.f327fv
            r55 = r0
            org.objectweb.asm.FieldWriter r55 = (org.objectweb.asm.FieldWriter) r55
            r19 = r55
            goto L_0x0344
        L_0x035c:
            r55 = r11
            r56 = r7
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r2
            r0 = r55
            org.objectweb.asm.MethodWriter r0 = r0.f290D
            r55 = r0
            r21 = r55
        L_0x036e:
            r55 = r21
            if (r55 == 0) goto L_0x0386
            r55 = r21
            r56 = r11
            r55.mo11218a(r56)
            r55 = r21
            r0 = r55
            org.objectweb.asm.MethodVisitor r0 = r0.f376mv
            r55 = r0
            org.objectweb.asm.MethodWriter r55 = (org.objectweb.asm.MethodWriter) r55
            r21 = r55
            goto L_0x036e
        L_0x0386:
            r55 = r11
            r56 = r10
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r2
            r0 = r55
            org.objectweb.asm.ByteVector r0 = r0.f287A
            r55 = r0
            if (r55 == 0) goto L_0x03ee
            r55 = r11
            r56 = r2
            java.lang.String r57 = "BootstrapMethods"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r11
            r56 = 2
            r57 = r2
            r0 = r57
            org.objectweb.asm.ByteVector r0 = r0.f287A
            r57 = r0
            r0 = r57
            int r0 = r0.f280b
            r57 = r0
            int r56 = r56 + r57
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
            r56 = r2
            r0 = r56
            int r0 = r0.f323z
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r11
            r56 = r2
            r0 = r56
            org.objectweb.asm.ByteVector r0 = r0.f287A
            r56 = r0
            r0 = r56
            byte[] r0 = r0.f279a
            r56 = r0
            r57 = 0
            r58 = r2
            r0 = r58
            org.objectweb.asm.ByteVector r0 = r0.f287A
            r58 = r0
            r0 = r58
            int r0 = r0.f280b
            r58 = r0
            org.objectweb.asm.ByteVector r55 = r55.putByteArray(r56, r57, r58)
        L_0x03ee:
            r55 = r2
            r0 = r55
            int r0 = r0.f310m
            r55 = r0
            if (r55 == 0) goto L_0x0418
            r55 = r11
            r56 = r2
            java.lang.String r57 = "Signature"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = 2
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
            r56 = r2
            r0 = r56
            int r0 = r0.f310m
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
        L_0x0418:
            r55 = r2
            r0 = r55
            int r0 = r0.f314q
            r55 = r0
            if (r55 == 0) goto L_0x0442
            r55 = r11
            r56 = r2
            java.lang.String r57 = "SourceFile"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = 2
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
            r56 = r2
            r0 = r56
            int r0 = r0.f314q
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
        L_0x0442:
            r55 = r2
            r0 = r55
            org.objectweb.asm.ByteVector r0 = r0.f315r
            r55 = r0
            if (r55 == 0) goto L_0x048c
            r55 = -2
            r56 = r2
            r0 = r56
            org.objectweb.asm.ByteVector r0 = r0.f315r
            r56 = r0
            r0 = r56
            int r0 = r0.f280b
            r56 = r0
            int r55 = r55 + r56
            r33 = r55
            r55 = r11
            r56 = r2
            java.lang.String r57 = "SourceDebugExtension"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = r33
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
            r55 = r11
            r56 = r2
            r0 = r56
            org.objectweb.asm.ByteVector r0 = r0.f315r
            r56 = r0
            r0 = r56
            byte[] r0 = r0.f279a
            r56 = r0
            r57 = 2
            r58 = r33
            org.objectweb.asm.ByteVector r55 = r55.putByteArray(r56, r57, r58)
        L_0x048c:
            r55 = r2
            r0 = r55
            int r0 = r0.f316s
            r55 = r0
            if (r55 == 0) goto L_0x04c4
            r55 = r11
            r56 = r2
            java.lang.String r57 = "EnclosingMethod"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = 4
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
            r55 = r11
            r56 = r2
            r0 = r56
            int r0 = r0.f316s
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = r2
            r0 = r56
            int r0 = r0.f317t
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
        L_0x04c4:
            r55 = 131072(0x20000, float:1.83671E-40)
            r56 = r2
            r0 = r56
            int r0 = r0.f308k
            r56 = r0
            r55 = r55 & r56
            if (r55 == 0) goto L_0x04e6
            r55 = r11
            r56 = r2
            java.lang.String r57 = "Deprecated"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = 0
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
        L_0x04e6:
            r55 = 4096(0x1000, float:5.74E-42)
            r56 = r2
            r0 = r56
            int r0 = r0.f308k
            r56 = r0
            r55 = r55 & r56
            if (r55 == 0) goto L_0x052b
            r55 = 65535(0xffff, float:9.1834E-41)
            r56 = r2
            r0 = r56
            int r0 = r0.f299b
            r56 = r0
            r55 = r55 & r56
            r56 = 49
            r0 = r55
            r1 = r56
            if (r0 < r1) goto L_0x0517
            r55 = 262144(0x40000, float:3.67342E-40)
            r56 = r2
            r0 = r56
            int r0 = r0.f308k
            r56 = r0
            r55 = r55 & r56
            if (r55 == 0) goto L_0x052b
        L_0x0517:
            r55 = r11
            r56 = r2
            java.lang.String r57 = "Synthetic"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r56 = 0
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
        L_0x052b:
            r55 = r2
            r0 = r55
            org.objectweb.asm.ByteVector r0 = r0.f322y
            r55 = r0
            if (r55 == 0) goto L_0x058b
            r55 = r11
            r56 = r2
            java.lang.String r57 = "InnerClasses"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r11
            r56 = 2
            r57 = r2
            r0 = r57
            org.objectweb.asm.ByteVector r0 = r0.f322y
            r57 = r0
            r0 = r57
            int r0 = r0.f280b
            r57 = r0
            int r56 = r56 + r57
            org.objectweb.asm.ByteVector r55 = r55.putInt(r56)
            r56 = r2
            r0 = r56
            int r0 = r0.f321x
            r56 = r0
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r11
            r56 = r2
            r0 = r56
            org.objectweb.asm.ByteVector r0 = r0.f322y
            r56 = r0
            r0 = r56
            byte[] r0 = r0.f279a
            r56 = r0
            r57 = 0
            r58 = r2
            r0 = r58
            org.objectweb.asm.ByteVector r0 = r0.f322y
            r58 = r0
            r0 = r58
            int r0 = r0.f280b
            r58 = r0
            org.objectweb.asm.ByteVector r55 = r55.putByteArray(r56, r57, r58)
        L_0x058b:
            r55 = r2
            r0 = r55
            org.objectweb.asm.AnnotationWriter r0 = r0.f318u
            r55 = r0
            if (r55 == 0) goto L_0x05b0
            r55 = r11
            r56 = r2
            java.lang.String r57 = "RuntimeVisibleAnnotations"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r2
            r0 = r55
            org.objectweb.asm.AnnotationWriter r0 = r0.f318u
            r55 = r0
            r56 = r11
            r55.mo11101a(r56)
        L_0x05b0:
            r55 = r2
            r0 = r55
            org.objectweb.asm.AnnotationWriter r0 = r0.f319v
            r55 = r0
            if (r55 == 0) goto L_0x05d5
            r55 = r11
            r56 = r2
            java.lang.String r57 = "RuntimeInvisibleAnnotations"
            int r56 = r56.newUTF8(r57)
            org.objectweb.asm.ByteVector r55 = r55.putShort(r56)
            r55 = r2
            r0 = r55
            org.objectweb.asm.AnnotationWriter r0 = r0.f319v
            r55 = r0
            r56 = r11
            r55.mo11101a(r56)
        L_0x05d5:
            r55 = r2
            r0 = r55
            org.objectweb.asm.Attribute r0 = r0.f320w
            r55 = r0
            if (r55 == 0) goto L_0x05f6
            r55 = r2
            r0 = r55
            org.objectweb.asm.Attribute r0 = r0.f320w
            r55 = r0
            r56 = r2
            r57 = 0
            r58 = 0
            r59 = -1
            r60 = -1
            r61 = r11
            r55.mo11104a(r56, r57, r58, r59, r60, r61)
        L_0x05f6:
            r55 = r2
            r0 = r55
            boolean r0 = r0.f297L
            r55 = r0
            if (r55 == 0) goto L_0x0632
            org.objectweb.asm.ClassWriter r55 = new org.objectweb.asm.ClassWriter
            r62 = r55
            r55 = r62
            r56 = r62
            r57 = 2
            r56.<init>(r57)
            r23 = r55
            org.objectweb.asm.ClassReader r55 = new org.objectweb.asm.ClassReader
            r62 = r55
            r55 = r62
            r56 = r62
            r57 = r11
            r0 = r57
            byte[] r0 = r0.f279a
            r57 = r0
            r56.<init>(r57)
            r56 = r23
            r57 = 4
            r55.accept(r56, r57)
            r55 = r23
            byte[] r55 = r55.toByteArray()
            r2 = r55
        L_0x0631:
            return r2
        L_0x0632:
            r55 = r11
            r0 = r55
            byte[] r0 = r0.f279a
            r55 = r0
            r2 = r55
            goto L_0x0631
        L_0x063d:
            r55 = r8
            r10 = r55
            goto L_0x0253
        L_0x0643:
            r55 = 0
            r8 = r55
            goto L_0x00ce
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.ClassWriter.toByteArray():byte[]");
    }

    public final void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        int i3 = i2;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String[] strArr2 = strArr;
        this.f299b = i;
        this.f308k = i3;
        this.f309l = newClass(str4);
        this.f294I = str4;
        if (str5 != null) {
            this.f310m = newUTF8(str5);
        }
        this.f311n = str6 == null ? 0 : newClass(str6);
        if (strArr2 != null && strArr2.length > 0) {
            this.f312o = strArr2.length;
            this.f313p = new int[this.f312o];
            for (int i4 = 0; i4 < this.f312o; i4++) {
                this.f313p[i4] = newClass(strArr2[i4]);
            }
        }
    }

    public final AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector;
        AnnotationWriter annotationWriter;
        String str2 = str;
        boolean z2 = z;
        ByteVector byteVector2 = byteVector;
        ByteVector byteVector3 = new ByteVector();
        ByteVector byteVector4 = byteVector2;
        ByteVector putShort = byteVector4.putShort(newUTF8(str2)).putShort(0);
        AnnotationWriter annotationWriter2 = annotationWriter;
        AnnotationWriter annotationWriter3 = new AnnotationWriter(this, true, byteVector4, byteVector4, 2);
        AnnotationWriter annotationWriter4 = annotationWriter2;
        if (z2) {
            annotationWriter4.f275g = this.f318u;
            this.f318u = annotationWriter4;
            return annotationWriter4;
        }
        annotationWriter4.f275g = this.f319v;
        this.f319v = annotationWriter4;
        return annotationWriter4;
    }

    public final void visitAttribute(Attribute attribute) {
        Attribute attribute2 = attribute;
        attribute2.f277a = this.f320w;
        this.f320w = attribute2;
    }

    public final void visitEnd() {
    }

    public final FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        FieldWriter fieldWriter;
        FieldWriter fieldWriter2 = fieldWriter;
        FieldWriter fieldWriter3 = new FieldWriter(this, i, str, str2, str3, obj);
        return fieldWriter2;
    }

    public final void visitInnerClass(String str, String str2, String str3, int i) {
        ByteVector byteVector;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        int i2 = i;
        if (this.f322y == null) {
            ByteVector byteVector2 = byteVector;
            ByteVector byteVector3 = new ByteVector();
            this.f322y = byteVector2;
        }
        this.f321x = 1 + this.f321x;
        ByteVector putShort = this.f322y.putShort(str4 == null ? 0 : newClass(str4));
        ByteVector putShort2 = this.f322y.putShort(str5 == null ? 0 : newClass(str5));
        ByteVector byteVector4 = this.f322y;
        int i3 = 0;
        if (str6 != null) {
            i3 = newUTF8(str6);
        }
        ByteVector putShort3 = byteVector4.putShort(i3);
        ByteVector putShort4 = this.f322y.putShort(i2);
    }

    public final MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        MethodWriter methodWriter;
        MethodWriter methodWriter2 = methodWriter;
        MethodWriter methodWriter3 = new MethodWriter(this, i, str, str2, str3, strArr, this.f296K, this.f295J);
        return methodWriter2;
    }

    public final void visitOuterClass(String str, String str2, String str3) {
        String str4 = str2;
        String str5 = str3;
        this.f316s = newClass(str);
        if (str4 != null && str5 != null) {
            this.f317t = newNameType(str4, str5);
        }
    }

    public final void visitSource(String str, String str2) {
        ByteVector byteVector;
        String str3 = str;
        String str4 = str2;
        if (str3 != null) {
            this.f314q = newUTF8(str3);
        }
        if (str4 != null) {
            ByteVector byteVector2 = byteVector;
            ByteVector byteVector3 = new ByteVector();
            this.f315r = byteVector2.putUTF8(str4);
        }
    }
}
