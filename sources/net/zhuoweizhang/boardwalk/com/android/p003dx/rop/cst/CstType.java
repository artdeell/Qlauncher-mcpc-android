package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.util.HashMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType */
public final class CstType extends TypedConstant {
    public static final CstType BOOLEAN = intern(Type.BOOLEAN_CLASS);
    public static final CstType BOOLEAN_ARRAY = intern(Type.BOOLEAN_ARRAY);
    public static final CstType BYTE = intern(Type.BYTE_CLASS);
    public static final CstType BYTE_ARRAY = intern(Type.BYTE_ARRAY);
    public static final CstType CHARACTER = intern(Type.CHARACTER_CLASS);
    public static final CstType CHAR_ARRAY = intern(Type.CHAR_ARRAY);
    public static final CstType DOUBLE = intern(Type.DOUBLE_CLASS);
    public static final CstType DOUBLE_ARRAY = intern(Type.DOUBLE_ARRAY);
    public static final CstType FLOAT = intern(Type.FLOAT_CLASS);
    public static final CstType FLOAT_ARRAY = intern(Type.FLOAT_ARRAY);
    public static final CstType INTEGER = intern(Type.INTEGER_CLASS);
    public static final CstType INT_ARRAY = intern(Type.INT_ARRAY);
    public static final CstType LONG = intern(Type.LONG_CLASS);
    public static final CstType LONG_ARRAY = intern(Type.LONG_ARRAY);
    public static final CstType OBJECT = intern(Type.OBJECT);
    public static final CstType SHORT = intern(Type.SHORT_CLASS);
    public static final CstType SHORT_ARRAY = intern(Type.SHORT_ARRAY);
    public static final CstType VOID = intern(Type.VOID_CLASS);
    private static final HashMap<Type, CstType> interns;
    private CstString descriptor;
    private final Type type;

    static {
        HashMap<Type, CstType> hashMap;
        HashMap<Type, CstType> hashMap2 = hashMap;
        HashMap<Type, CstType> hashMap3 = new HashMap<>(100);
        interns = hashMap2;
    }

    public CstType(Type type2) {
        UnsupportedOperationException unsupportedOperationException;
        NullPointerException nullPointerException;
        Type type3 = type2;
        if (type3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("type == null");
            throw nullPointerException2;
        } else if (type3 == Type.KNOWN_NULL) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("KNOWN_NULL is not representable");
            throw unsupportedOperationException2;
        } else {
            this.type = type3;
            this.descriptor = null;
        }
    }

    public static CstType forBoxedPrimitiveType(Type type2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Type type3 = type2;
        switch (type3.getBasicType()) {
            case 0:
                return VOID;
            case 1:
                return BOOLEAN;
            case 2:
                return BYTE;
            case 3:
                return CHARACTER;
            case 4:
                return DOUBLE;
            case 5:
                return FLOAT;
            case 6:
                return INTEGER;
            case 7:
                return LONG;
            case 8:
                return SHORT;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("not primitive: ").append(type3).toString());
                throw illegalArgumentException2;
        }
    }

    /* JADX INFO: finally extract failed */
    public static CstType intern(Type type2) {
        CstType cstType;
        CstType cstType2;
        Type type3 = type2;
        HashMap<Type, CstType> hashMap = interns;
        synchronized (hashMap) {
            try {
                cstType = (CstType) interns.get(type3);
                if (cstType == null) {
                    CstType cstType3 = cstType2;
                    CstType cstType4 = new CstType(type3);
                    cstType = cstType3;
                    Object put = interns.put(type3, cstType);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                HashMap<Type, CstType> hashMap2 = hashMap;
                throw th2;
            }
        }
        return cstType;
    }

    /* access modifiers changed from: protected */
    public int compareTo0(Constant constant) {
        return this.type.getDescriptor().compareTo(((CstType) constant).type.getDescriptor());
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return (obj2 instanceof CstType) && this.type == ((CstType) obj2).type;
    }

    public Type getClassType() {
        return this.type;
    }

    public CstString getDescriptor() {
        CstString cstString;
        if (this.descriptor == null) {
            CstString cstString2 = cstString;
            CstString cstString3 = new CstString(this.type.getDescriptor());
            this.descriptor = cstString2;
        }
        return this.descriptor;
    }

    public String getPackageName() {
        String string = getDescriptor().getString();
        int lastIndexOf = string.lastIndexOf(47);
        return lastIndexOf == -1 ? "default" : string.substring(string.lastIndexOf(91) + 2, lastIndexOf).replace(ClassPathElement.SEPARATOR_CHAR, '.');
    }

    public Type getType() {
        return Type.CLASS;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public boolean isCategory2() {
        return false;
    }

    public String toHuman() {
        return this.type.toHuman();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("type{").append(toHuman()).append('}').toString();
    }

    public String typeName() {
        return MimeTypeParser.TAG_TYPE;
    }
}
