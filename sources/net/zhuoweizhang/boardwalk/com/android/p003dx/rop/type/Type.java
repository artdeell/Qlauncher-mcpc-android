package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type;

import java.util.HashMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type */
public final class Type implements TypeBearer, Comparable<Type> {
    public static final Type ANNOTATION = intern("Ljava/lang/annotation/Annotation;");
    public static final Type BOOLEAN;
    public static final Type BOOLEAN_ARRAY = BOOLEAN.getArrayType();
    public static final Type BOOLEAN_CLASS = intern("Ljava/lang/Boolean;");
    public static final int BT_ADDR = 10;
    public static final int BT_BOOLEAN = 1;
    public static final int BT_BYTE = 2;
    public static final int BT_CHAR = 3;
    public static final int BT_COUNT = 11;
    public static final int BT_DOUBLE = 4;
    public static final int BT_FLOAT = 5;
    public static final int BT_INT = 6;
    public static final int BT_LONG = 7;
    public static final int BT_OBJECT = 9;
    public static final int BT_SHORT = 8;
    public static final int BT_VOID = 0;
    public static final Type BYTE;
    public static final Type BYTE_ARRAY = BYTE.getArrayType();
    public static final Type BYTE_CLASS = intern("Ljava/lang/Byte;");
    public static final Type CHAR;
    public static final Type CHARACTER_CLASS = intern("Ljava/lang/Character;");
    public static final Type CHAR_ARRAY = CHAR.getArrayType();
    public static final Type CLASS = intern("Ljava/lang/Class;");
    public static final Type CLONEABLE = intern("Ljava/lang/Cloneable;");
    public static final Type DOUBLE;
    public static final Type DOUBLE_ARRAY = DOUBLE.getArrayType();
    public static final Type DOUBLE_CLASS = intern("Ljava/lang/Double;");
    public static final Type FLOAT;
    public static final Type FLOAT_ARRAY = FLOAT.getArrayType();
    public static final Type FLOAT_CLASS = intern("Ljava/lang/Float;");
    public static final Type INT;
    public static final Type INTEGER_CLASS = intern("Ljava/lang/Integer;");
    public static final Type INT_ARRAY = INT.getArrayType();
    public static final Type KNOWN_NULL;
    public static final Type LONG;
    public static final Type LONG_ARRAY = LONG.getArrayType();
    public static final Type LONG_CLASS = intern("Ljava/lang/Long;");
    public static final Type OBJECT = intern("Ljava/lang/Object;");
    public static final Type OBJECT_ARRAY = OBJECT.getArrayType();
    public static final Type RETURN_ADDRESS;
    public static final Type SERIALIZABLE = intern("Ljava/io/Serializable;");
    public static final Type SHORT;
    public static final Type SHORT_ARRAY = SHORT.getArrayType();
    public static final Type SHORT_CLASS = intern("Ljava/lang/Short;");
    public static final Type STRING = intern("Ljava/lang/String;");
    public static final Type THROWABLE = intern("Ljava/lang/Throwable;");
    public static final Type VOID;
    public static final Type VOID_CLASS = intern("Ljava/lang/Void;");
    private static final HashMap<String, Type> internTable;
    private Type arrayType;
    private final int basicType;
    private String className;
    private Type componentType;
    private final String descriptor;
    private Type initializedType;
    private final int newAt;

    static {
        HashMap<String, Type> hashMap;
        Type type;
        Type type2;
        Type type3;
        Type type4;
        Type type5;
        Type type6;
        Type type7;
        Type type8;
        Type type9;
        Type type10;
        Type type11;
        HashMap<String, Type> hashMap2 = hashMap;
        HashMap<String, Type> hashMap3 = new HashMap<>(500);
        internTable = hashMap2;
        Type type12 = type;
        Type type13 = new Type("Z", 1);
        BOOLEAN = type12;
        Type type14 = type2;
        Type type15 = new Type("B", 2);
        BYTE = type14;
        Type type16 = type3;
        Type type17 = new Type("C", 3);
        CHAR = type16;
        Type type18 = type4;
        Type type19 = new Type("D", 4);
        DOUBLE = type18;
        Type type20 = type5;
        Type type21 = new Type("F", 5);
        FLOAT = type20;
        Type type22 = type6;
        Type type23 = new Type("I", 6);
        INT = type22;
        Type type24 = type7;
        Type type25 = new Type("J", 7);
        LONG = type24;
        Type type26 = type8;
        Type type27 = new Type("S", 8);
        SHORT = type26;
        Type type28 = type9;
        Type type29 = new Type("V", 0);
        VOID = type28;
        Type type30 = type10;
        Type type31 = new Type("<null>", 9);
        KNOWN_NULL = type30;
        Type type32 = type11;
        Type type33 = new Type("<addr>", 10);
        RETURN_ADDRESS = type32;
        Type putIntern = putIntern(BOOLEAN);
        Type putIntern2 = putIntern(BYTE);
        Type putIntern3 = putIntern(CHAR);
        Type putIntern4 = putIntern(DOUBLE);
        Type putIntern5 = putIntern(FLOAT);
        Type putIntern6 = putIntern(INT);
        Type putIntern7 = putIntern(LONG);
        Type putIntern8 = putIntern(SHORT);
    }

    private Type(String str, int i) {
        this(str, i, -1);
    }

    private Type(String str, int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        NullPointerException nullPointerException;
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("descriptor == null");
            throw nullPointerException2;
        } else if (i3 < 0 || i3 >= 11) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("bad basicType");
            throw illegalArgumentException3;
        } else if (i4 < -1) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("newAt < -1");
            throw illegalArgumentException5;
        } else {
            this.descriptor = str2;
            this.basicType = i3;
            this.newAt = i4;
            this.arrayType = null;
            this.componentType = null;
            this.initializedType = null;
        }
    }

    public static Type intern(String str) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb;
        Type type;
        IllegalArgumentException illegalArgumentException3;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException4;
        StringBuilder sb3;
        String str2 = str;
        Type type2 = internTable;
        synchronized (type2) {
            try {
                th = (Type) internTable.get(str2);
            } finally {
                Throwable th = th;
                Type type3 = type2;
                Throwable th2 = th;
            }
        }
        if (th != null) {
            return th;
        }
        try {
            char charAt = str2.charAt(0);
            if (charAt == '[') {
                return intern(str2.substring(1)).getArrayType();
            }
            int length = str2.length();
            if (charAt == 'L' && str2.charAt(length - 1) == ';') {
                int i = length - 1;
                for (int i2 = 1; i2 < i; i2++) {
                    switch (str2.charAt(i2)) {
                        case '(':
                        case ')':
                        case '.':
                        case ';':
                        case '[':
                            IllegalArgumentException illegalArgumentException5 = illegalArgumentException3;
                            StringBuilder sb4 = sb2;
                            StringBuilder sb5 = new StringBuilder();
                            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb4.append("bad descriptor: ").append(str2).toString());
                            throw illegalArgumentException5;
                        case '/':
                            if (i2 != 1 && i2 != length - 1 && str2.charAt(i2 - 1) != '/') {
                                break;
                            } else {
                                IllegalArgumentException illegalArgumentException7 = illegalArgumentException4;
                                StringBuilder sb6 = sb3;
                                StringBuilder sb7 = new StringBuilder();
                                IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException(sb6.append("bad descriptor: ").append(str2).toString());
                                throw illegalArgumentException7;
                            }
                    }
                }
                Type type4 = type;
                Type type5 = new Type(str2, 9);
                return putIntern(type4);
            }
            IllegalArgumentException illegalArgumentException9 = illegalArgumentException2;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException(sb8.append("bad descriptor: ").append(str2).toString());
            throw illegalArgumentException9;
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException11 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException("descriptor is empty");
            throw illegalArgumentException11;
        } catch (NullPointerException e2) {
            NullPointerException nullPointerException2 = e2;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("descriptor == null");
            throw nullPointerException3;
        }
    }

    public static Type internClassName(String str) {
        StringBuilder sb;
        NullPointerException nullPointerException;
        String str2 = str;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("name == null");
            throw nullPointerException2;
        } else if (str2.startsWith("[")) {
            return intern(str2);
        } else {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return intern(sb2.append('L').append(str2).append(';').toString());
        }
    }

    public static Type internReturnType(String str) {
        NullPointerException nullPointerException;
        String str2 = str;
        try {
            return str2.equals("V") ? VOID : intern(str2);
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("descriptor == null");
            throw nullPointerException3;
        }
    }

    private static Type putIntern(Type type) {
        Type type2 = type;
        Type type3 = internTable;
        synchronized (type3) {
            try {
                String descriptor2 = type2.getDescriptor();
                th = (Type) internTable.get(descriptor2);
                if (th != null) {
                    return th;
                }
                Object put = internTable.put(descriptor2, type2);
                return type2;
            } finally {
                Throwable th = th;
                Type type4 = type3;
                Throwable th2 = th;
            }
        }
    }

    public Type asUninitialized(int i) {
        Type type;
        StringBuilder sb;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb2;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb3;
        IllegalArgumentException illegalArgumentException3;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("newAt < 0");
            throw illegalArgumentException4;
        } else if (!isReference()) {
            IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException(sb4.append("not a reference type: ").append(this.descriptor).toString());
            throw illegalArgumentException6;
        } else if (isUninitialized()) {
            IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException(sb6.append("already uninitialized: ").append(this.descriptor).toString());
            throw illegalArgumentException8;
        } else {
            Type type2 = type;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            Type type3 = new Type(sb8.append('N').append(Hex.m51u2(i2)).append(this.descriptor).toString(), 9, i2);
            Type type4 = type2;
            type4.initializedType = this;
            return putIntern(type4);
        }
    }

    public int compareTo(Type type) {
        return this.descriptor.compareTo(type.descriptor);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this == obj2) {
            return true;
        }
        if (!(obj2 instanceof Type)) {
            return false;
        }
        return this.descriptor.equals(((Type) obj2).descriptor);
    }

    public Type getArrayType() {
        Type type;
        StringBuilder sb;
        if (this.arrayType == null) {
            Type type2 = type;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            Type type3 = new Type(sb2.append('[').append(this.descriptor).toString(), 9);
            this.arrayType = putIntern(type2);
        }
        return this.arrayType;
    }

    public int getBasicFrameType() {
        switch (this.basicType) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return 6;
            default:
                return this.basicType;
        }
    }

    public int getBasicType() {
        return this.basicType;
    }

    public int getCategory() {
        switch (this.basicType) {
            case 4:
            case 7:
                return 2;
            default:
                return 1;
        }
    }

    public String getClassName() {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        if (this.className == null) {
            if (!isReference()) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("not an object type: ").append(this.descriptor).toString());
                throw illegalArgumentException2;
            } else if (this.descriptor.charAt(0) == '[') {
                this.className = this.descriptor;
            } else {
                this.className = this.descriptor.substring(1, -1 + this.descriptor.length());
            }
        }
        return this.className;
    }

    public Type getComponentType() {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        if (this.componentType == null) {
            if (this.descriptor.charAt(0) != '[') {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("not an array type: ").append(this.descriptor).toString());
                throw illegalArgumentException2;
            }
            this.componentType = intern(this.descriptor.substring(1));
        }
        return this.componentType;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public Type getFrameType() {
        switch (this.basicType) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return INT;
            default:
                return this;
        }
    }

    public Type getInitializedType() {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        if (this.initializedType != null) {
            return this.initializedType;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("initialized type: ").append(this.descriptor).toString());
        throw illegalArgumentException2;
    }

    public int getNewAt() {
        return this.newAt;
    }

    public Type getType() {
        return this;
    }

    public int hashCode() {
        return this.descriptor.hashCode();
    }

    public boolean isArray() {
        boolean z = false;
        if (this.descriptor.charAt(0) == '[') {
            z = true;
        }
        return z;
    }

    public boolean isArrayOrKnownNull() {
        return isArray() || equals(KNOWN_NULL);
    }

    public boolean isCategory1() {
        switch (this.basicType) {
            case 4:
            case 7:
                return false;
            default:
                return true;
        }
    }

    public boolean isCategory2() {
        switch (this.basicType) {
            case 4:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public boolean isConstant() {
        return false;
    }

    public boolean isIntlike() {
        switch (this.basicType) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public boolean isPrimitive() {
        switch (this.basicType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public boolean isReference() {
        return this.basicType == 9;
    }

    public boolean isUninitialized() {
        return this.newAt >= 0;
    }

    public String toHuman() {
        StringBuilder sb;
        switch (this.basicType) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "byte";
            case 3:
                return "char";
            case 4:
                return "double";
            case 5:
                return "float";
            case 6:
                return "int";
            case 7:
                return "long";
            case 8:
                return "short";
            case 9:
                if (!isArray()) {
                    return getClassName().replace("/", ".");
                }
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return sb2.append(getComponentType().toHuman()).append("[]").toString();
            default:
                return this.descriptor;
        }
    }

    public String toString() {
        return this.descriptor;
    }
}
