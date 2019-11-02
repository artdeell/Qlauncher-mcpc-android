package org.objectweb.asm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final Type BOOLEAN_TYPE;
    public static final int BYTE = 3;
    public static final Type BYTE_TYPE;
    public static final int CHAR = 2;
    public static final Type CHAR_TYPE;
    public static final int DOUBLE = 8;
    public static final Type DOUBLE_TYPE;
    public static final int FLOAT = 6;
    public static final Type FLOAT_TYPE;
    public static final int INT = 5;
    public static final Type INT_TYPE;
    public static final int LONG = 7;
    public static final Type LONG_TYPE;
    public static final int METHOD = 11;
    public static final int OBJECT = 10;
    public static final int SHORT = 4;
    public static final Type SHORT_TYPE;
    public static final int VOID = 0;
    public static final Type VOID_TYPE;

    /* renamed from: a */
    private final int f422a;

    /* renamed from: b */
    private final char[] f423b;

    /* renamed from: c */
    private final int f424c;

    /* renamed from: d */
    private final int f425d;

    static {
        Type type;
        Type type2;
        Type type3;
        Type type4;
        Type type5;
        Type type6;
        Type type7;
        Type type8;
        Type type9;
        Type type10 = type;
        Type type11 = new Type(0, null, 1443168256, 1);
        VOID_TYPE = type10;
        Type type12 = type2;
        Type type13 = new Type(1, null, 1509950721, 1);
        BOOLEAN_TYPE = type12;
        Type type14 = type3;
        Type type15 = new Type(2, null, 1124075009, 1);
        CHAR_TYPE = type14;
        Type type16 = type4;
        Type type17 = new Type(3, null, 1107297537, 1);
        BYTE_TYPE = type16;
        Type type18 = type5;
        Type type19 = new Type(4, null, 1392510721, 1);
        SHORT_TYPE = type18;
        Type type20 = type6;
        Type type21 = new Type(5, null, 1224736769, 1);
        INT_TYPE = type20;
        Type type22 = type7;
        Type type23 = new Type(6, null, 1174536705, 1);
        FLOAT_TYPE = type22;
        Type type24 = type8;
        Type type25 = new Type(7, null, 1241579778, 1);
        LONG_TYPE = type24;
        Type type26 = type9;
        Type type27 = new Type(8, null, 1141048066, 1);
        DOUBLE_TYPE = type26;
    }

    private Type(int i, char[] cArr, int i2, int i3) {
        char[] cArr2 = cArr;
        int i4 = i2;
        int i5 = i3;
        this.f422a = i;
        this.f423b = cArr2;
        this.f424c = i4;
        this.f425d = i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r0[r1 + r2] != '[') goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (r0[r1 + r2] != 'L') goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        if (r0[r1 + r2] == ';') goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        r3 = r10;
        r4 = new org.objectweb.asm.Type(9, r0, r1, r2 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        if (r0[r1 + r2] == ';') goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r3 = r10;
        r4 = new org.objectweb.asm.Type(10, r0, r1 + 1, r2 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return r3;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.objectweb.asm.Type m147a(char[] r11, int r12) {
        /*
            r0 = r11
            r1 = r12
            r3 = 1
            r2 = r3
            r3 = r0
            r4 = r1
            char r3 = r3[r4]
            switch(r3) {
                case 66: goto L_0x0027;
                case 67: goto L_0x0023;
                case 68: goto L_0x003b;
                case 69: goto L_0x000b;
                case 70: goto L_0x0033;
                case 71: goto L_0x000b;
                case 72: goto L_0x000b;
                case 73: goto L_0x002f;
                case 74: goto L_0x0037;
                case 75: goto L_0x000b;
                case 76: goto L_0x0077;
                case 77: goto L_0x000b;
                case 78: goto L_0x000b;
                case 79: goto L_0x000b;
                case 80: goto L_0x000b;
                case 81: goto L_0x000b;
                case 82: goto L_0x000b;
                case 83: goto L_0x002b;
                case 84: goto L_0x000b;
                case 85: goto L_0x000b;
                case 86: goto L_0x001b;
                case 87: goto L_0x000b;
                case 88: goto L_0x000b;
                case 89: goto L_0x000b;
                case 90: goto L_0x001f;
                case 91: goto L_0x003f;
                default: goto L_0x000b;
            }
        L_0x000b:
            org.objectweb.asm.Type r3 = new org.objectweb.asm.Type
            r10 = r3
            r3 = r10
            r4 = r10
            r5 = 11
            r6 = r0
            r7 = 0
            r8 = r0
            int r8 = r8.length
            r4.<init>(r5, r6, r7, r8)
            r0 = r3
        L_0x001a:
            return r0
        L_0x001b:
            org.objectweb.asm.Type r3 = VOID_TYPE
            r0 = r3
            goto L_0x001a
        L_0x001f:
            org.objectweb.asm.Type r3 = BOOLEAN_TYPE
            r0 = r3
            goto L_0x001a
        L_0x0023:
            org.objectweb.asm.Type r3 = CHAR_TYPE
            r0 = r3
            goto L_0x001a
        L_0x0027:
            org.objectweb.asm.Type r3 = BYTE_TYPE
            r0 = r3
            goto L_0x001a
        L_0x002b:
            org.objectweb.asm.Type r3 = SHORT_TYPE
            r0 = r3
            goto L_0x001a
        L_0x002f:
            org.objectweb.asm.Type r3 = INT_TYPE
            r0 = r3
            goto L_0x001a
        L_0x0033:
            org.objectweb.asm.Type r3 = FLOAT_TYPE
            r0 = r3
            goto L_0x001a
        L_0x0037:
            org.objectweb.asm.Type r3 = LONG_TYPE
            r0 = r3
            goto L_0x001a
        L_0x003b:
            org.objectweb.asm.Type r3 = DOUBLE_TYPE
            r0 = r3
            goto L_0x001a
        L_0x003f:
            r3 = r0
            r4 = r1
            r5 = r2
            int r4 = r4 + r5
            char r3 = r3[r4]
            r4 = 91
            if (r3 != r4) goto L_0x004c
            int r2 = r2 + 1
            goto L_0x003f
        L_0x004c:
            r3 = r0
            r4 = r1
            r5 = r2
            int r4 = r4 + r5
            char r3 = r3[r4]
            r4 = 76
            if (r3 != r4) goto L_0x0065
            int r2 = r2 + 1
        L_0x0058:
            r3 = r0
            r4 = r1
            r5 = r2
            int r4 = r4 + r5
            char r3 = r3[r4]
            r4 = 59
            if (r3 == r4) goto L_0x0065
            int r2 = r2 + 1
            goto L_0x0058
        L_0x0065:
            org.objectweb.asm.Type r3 = new org.objectweb.asm.Type
            r10 = r3
            r3 = r10
            r4 = r10
            r5 = 9
            r6 = r0
            r7 = r1
            r8 = r2
            r9 = 1
            int r8 = r8 + 1
            r4.<init>(r5, r6, r7, r8)
            r0 = r3
            goto L_0x001a
        L_0x0077:
            r3 = r0
            r4 = r1
            r5 = r2
            int r4 = r4 + r5
            char r3 = r3[r4]
            r4 = 59
            if (r3 == r4) goto L_0x0084
            int r2 = r2 + 1
            goto L_0x0077
        L_0x0084:
            org.objectweb.asm.Type r3 = new org.objectweb.asm.Type
            r10 = r3
            r3 = r10
            r4 = r10
            r5 = 10
            r6 = r0
            r7 = r1
            r8 = 1
            int r7 = r7 + 1
            r8 = r2
            r9 = 1
            int r8 = r8 + -1
            r4.<init>(r5, r6, r7, r8)
            r0 = r3
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.Type.m147a(char[], int):org.objectweb.asm.Type");
    }

    /* renamed from: a */
    private void m148a(StringBuffer stringBuffer) {
        StringBuffer stringBuffer2 = stringBuffer;
        if (this.f423b == null) {
            StringBuffer append = stringBuffer2.append((char) ((-16777216 & this.f424c) >>> 24));
        } else if (this.f422a == 10) {
            StringBuffer append2 = stringBuffer2.append('L');
            StringBuffer append3 = stringBuffer2.append(this.f423b, this.f424c, this.f425d);
            StringBuffer append4 = stringBuffer2.append(';');
        } else {
            StringBuffer append5 = stringBuffer2.append(this.f423b, this.f424c, this.f425d);
        }
    }

    /* renamed from: a */
    private static void m149a(StringBuffer stringBuffer, Class cls) {
        StringBuffer stringBuffer2 = stringBuffer;
        Class cls2 = cls;
        while (!cls2.isPrimitive()) {
            if (cls2.isArray()) {
                StringBuffer append = stringBuffer2.append('[');
                cls2 = cls2.getComponentType();
            } else {
                StringBuffer append2 = stringBuffer2.append('L');
                String name = cls2.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    char charAt = name.charAt(i);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    StringBuffer append3 = stringBuffer2.append(charAt);
                }
                StringBuffer append4 = stringBuffer2.append(';');
                return;
            }
        }
        char c = cls2 == Integer.TYPE ? 'I' : cls2 == Void.TYPE ? 'V' : cls2 == Boolean.TYPE ? 'Z' : cls2 == Byte.TYPE ? 'B' : cls2 == Character.TYPE ? 'C' : cls2 == Short.TYPE ? 'S' : cls2 == Double.TYPE ? 'D' : cls2 == Float.TYPE ? 'F' : 'J';
        StringBuffer append5 = stringBuffer2.append(c);
    }

    public static Type[] getArgumentTypes(String str) {
        int i;
        int i2 = 1;
        char[] charArray = str.toCharArray();
        int i3 = 0;
        int i4 = 1;
        while (true) {
            int i5 = i4;
            int i6 = i5 + 1;
            char c = charArray[i5];
            if (c == ')') {
                break;
            } else if (c == 'L') {
                int i7 = i6;
                while (true) {
                    int i8 = i7;
                    i = i8 + 1;
                    if (charArray[i8] == ';') {
                        break;
                    }
                    i7 = i;
                }
                i3++;
                i4 = i;
            } else if (c != '[') {
                i3++;
                i4 = i6;
            } else {
                i4 = i6;
            }
        }
        Type[] typeArr = new Type[i3];
        int i9 = 0;
        while (charArray[i2] != ')') {
            typeArr[i9] = m147a(charArray, i2);
            i2 += (typeArr[i9].f422a == 10 ? 2 : 0) + typeArr[i9].f425d;
            i9++;
        }
        return typeArr;
    }

    public static Type[] getArgumentTypes(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        Type[] typeArr = new Type[parameterTypes.length];
        for (int length = -1 + parameterTypes.length; length >= 0; length--) {
            typeArr[length] = getType(parameterTypes[length]);
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i;
        char charAt;
        int i2;
        String str2 = str;
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            i = i4 + 1;
            char charAt2 = str2.charAt(i4);
            if (charAt2 == ')') {
                break;
            } else if (charAt2 == 'L') {
                int i6 = i;
                while (true) {
                    int i7 = i6;
                    i2 = i7 + 1;
                    if (str2.charAt(i7) == ';') {
                        break;
                    }
                    i6 = i2;
                }
                i5++;
                i4 = i2;
            } else if (charAt2 == '[') {
                while (true) {
                    charAt = str2.charAt(i);
                    if (charAt != '[') {
                        break;
                    }
                    i++;
                }
                if (charAt == 'D' || charAt == 'J') {
                    i5--;
                    i4 = i;
                } else {
                    i4 = i;
                }
            } else if (charAt2 == 'D' || charAt2 == 'J') {
                i5 += 2;
                i4 = i;
            } else {
                i5++;
                i4 = i;
            }
        }
        char charAt3 = str2.charAt(i);
        int i8 = i5 << 2;
        if (charAt3 == 'V') {
            i3 = 0;
        } else if (charAt3 == 'D' || charAt3 == 'J') {
            i3 = 2;
        }
        return i8 | i3;
    }

    public static String getConstructorDescriptor(Constructor constructor) {
        StringBuffer stringBuffer;
        Class[] parameterTypes = constructor.getParameterTypes();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append('(');
        for (int i = 0; i < parameterTypes.length; i++) {
            m149a(stringBuffer4, parameterTypes[i]);
        }
        return stringBuffer4.append(")V").toString();
    }

    public static String getDescriptor(Class cls) {
        StringBuffer stringBuffer;
        Class cls2 = cls;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        m149a(stringBuffer4, cls2);
        return stringBuffer4.toString();
    }

    public static String getInternalName(Class cls) {
        return cls.getName().replace('.', ClassPathElement.SEPARATOR_CHAR);
    }

    public static String getMethodDescriptor(Method method) {
        StringBuffer stringBuffer;
        Method method2 = method;
        Class[] parameterTypes = method2.getParameterTypes();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append('(');
        for (int i = 0; i < parameterTypes.length; i++) {
            m149a(stringBuffer4, parameterTypes[i]);
        }
        StringBuffer append2 = stringBuffer4.append(')');
        m149a(stringBuffer4, method2.getReturnType());
        return stringBuffer4.toString();
    }

    public static String getMethodDescriptor(Type type, Type... typeArr) {
        StringBuffer stringBuffer;
        Type type2 = type;
        Type[] typeArr2 = typeArr;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append('(');
        for (int i = 0; i < typeArr2.length; i++) {
            typeArr2[i].m148a(stringBuffer4);
        }
        StringBuffer append2 = stringBuffer4.append(')');
        type2.m148a(stringBuffer4);
        return stringBuffer4.toString();
    }

    public static Type getMethodType(String str) {
        return m147a(str.toCharArray(), 0);
    }

    public static Type getMethodType(Type type, Type... typeArr) {
        return getType(getMethodDescriptor(type, typeArr));
    }

    public static Type getObjectType(String str) {
        Type type;
        char[] charArray = str.toCharArray();
        Type type2 = type;
        Type type3 = new Type(charArray[0] == '[' ? 9 : 10, charArray, 0, charArray.length);
        return type2;
    }

    public static Type getReturnType(String str) {
        String str2 = str;
        return m147a(str2.toCharArray(), 1 + str2.indexOf(41));
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    public static Type getType(Class cls) {
        Class cls2 = cls;
        return cls2.isPrimitive() ? cls2 == Integer.TYPE ? INT_TYPE : cls2 == Void.TYPE ? VOID_TYPE : cls2 == Boolean.TYPE ? BOOLEAN_TYPE : cls2 == Byte.TYPE ? BYTE_TYPE : cls2 == Character.TYPE ? CHAR_TYPE : cls2 == Short.TYPE ? SHORT_TYPE : cls2 == Double.TYPE ? DOUBLE_TYPE : cls2 == Float.TYPE ? FLOAT_TYPE : LONG_TYPE : getType(getDescriptor(cls2));
    }

    public static Type getType(String str) {
        return m147a(str.toCharArray(), 0);
    }

    public static Type getType(Constructor constructor) {
        return getType(getConstructorDescriptor(constructor));
    }

    public static Type getType(Method method) {
        return getType(getMethodDescriptor(method));
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (!(obj2 instanceof Type)) {
                return false;
            }
            Type type = (Type) obj2;
            if (this.f422a != type.f422a) {
                return false;
            }
            if (this.f422a >= 9) {
                if (this.f425d != type.f425d) {
                    return false;
                }
                int i = this.f424c;
                int i2 = type.f424c;
                int i3 = i + this.f425d;
                while (i < i3) {
                    if (this.f423b[i] != type.f423b[i2]) {
                        return false;
                    }
                    i++;
                    i2++;
                }
            }
        }
        return true;
    }

    public Type[] getArgumentTypes() {
        return getArgumentTypes(getDescriptor());
    }

    public int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(getDescriptor());
    }

    public String getClassName() {
        String str;
        StringBuffer stringBuffer;
        switch (this.f422a) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer(getElementType().getClassName());
                StringBuffer stringBuffer4 = stringBuffer2;
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    StringBuffer append = stringBuffer4.append("[]");
                }
                return stringBuffer4.toString();
            case 10:
                String str2 = str;
                String str3 = new String(this.f423b, this.f424c, this.f425d);
                return str2.replace(ClassPathElement.SEPARATOR_CHAR, '.');
            default:
                return null;
        }
    }

    public String getDescriptor() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        m148a(stringBuffer4);
        return stringBuffer4.toString();
    }

    public int getDimensions() {
        int i = 1;
        while (this.f423b[i + this.f424c] == '[') {
            i++;
        }
        return i;
    }

    public Type getElementType() {
        return m147a(this.f423b, this.f424c + getDimensions());
    }

    public String getInternalName() {
        String str;
        String str2 = str;
        String str3 = new String(this.f423b, this.f424c, this.f425d);
        return str2;
    }

    public int getOpcode(int i) {
        int i2 = i;
        int i3 = 4;
        if (i2 == 46 || i2 == 79) {
            if (this.f423b == null) {
                i3 = (65280 & this.f424c) >> 8;
            }
            return i3 + i2;
        }
        if (this.f423b == null) {
            i3 = (16711680 & this.f424c) >> 16;
        }
        return i3 + i2;
    }

    public Type getReturnType() {
        return getReturnType(getDescriptor());
    }

    public int getSize() {
        if (this.f423b == null) {
            return 255 & this.f424c;
        }
        return 1;
    }

    public int getSort() {
        return this.f422a;
    }

    public int hashCode() {
        int i = 13 * this.f422a;
        if (this.f422a >= 9) {
            int i2 = this.f424c;
            int i3 = i2 + this.f425d;
            while (i2 < i3) {
                i2++;
                i = 17 * (i + this.f423b[i2]);
            }
        }
        return i;
    }

    public String toString() {
        return getDescriptor();
    }
}
