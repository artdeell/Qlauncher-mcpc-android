package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type;

import java.util.HashMap;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Prototype */
public final class Prototype implements Comparable<Prototype> {
    private static final HashMap<String, Prototype> internTable;
    private final String descriptor;
    private StdTypeList parameterFrameTypes;
    private final StdTypeList parameterTypes;
    private final Type returnType;

    static {
        HashMap<String, Prototype> hashMap;
        HashMap<String, Prototype> hashMap2 = hashMap;
        HashMap<String, Prototype> hashMap3 = new HashMap<>(500);
        internTable = hashMap2;
    }

    private Prototype(String str, Type type, StdTypeList stdTypeList) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        String str2 = str;
        Type type2 = type;
        StdTypeList stdTypeList2 = stdTypeList;
        if (str2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("descriptor == null");
            throw nullPointerException4;
        } else if (type2 == null) {
            NullPointerException nullPointerException6 = nullPointerException2;
            NullPointerException nullPointerException7 = new NullPointerException("returnType == null");
            throw nullPointerException6;
        } else if (stdTypeList2 == null) {
            NullPointerException nullPointerException8 = nullPointerException;
            NullPointerException nullPointerException9 = new NullPointerException("parameterTypes == null");
            throw nullPointerException8;
        } else {
            this.descriptor = str2;
            this.returnType = type2;
            this.parameterTypes = stdTypeList2;
            this.parameterFrameTypes = null;
        }
    }

    public static Prototype intern(String str) {
        StdTypeList stdTypeList;
        Prototype prototype;
        int i;
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        String str2 = str;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("descriptor == null");
            throw nullPointerException2;
        }
        Prototype prototype2 = internTable;
        synchronized (prototype2) {
            try {
                th = (Prototype) internTable.get(str2);
            } finally {
                Throwable th = th;
                Prototype prototype3 = prototype2;
                Throwable th2 = th;
            }
        }
        if (th != null) {
            return th;
        }
        Type[] makeParameterArray = makeParameterArray(str2);
        int i2 = 1;
        int i3 = 0;
        while (true) {
            char charAt = str2.charAt(i2);
            if (charAt == ')') {
                Type internReturnType = Type.internReturnType(str2.substring(i2 + 1));
                StdTypeList stdTypeList2 = stdTypeList;
                StdTypeList stdTypeList3 = new StdTypeList(i3);
                StdTypeList stdTypeList4 = stdTypeList2;
                for (int i4 = 0; i4 < i3; i4++) {
                    stdTypeList4.set(i4, makeParameterArray[i4]);
                }
                Prototype prototype4 = prototype;
                Prototype prototype5 = new Prototype(str2, internReturnType, stdTypeList4);
                return putIntern(prototype4);
            }
            int i5 = i2;
            while (charAt == '[') {
                i5++;
                charAt = str2.charAt(i5);
            }
            if (charAt == 'L') {
                int indexOf = str2.indexOf(59, i5);
                if (indexOf == -1) {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bad descriptor");
                    throw illegalArgumentException2;
                }
                i = indexOf;
            } else {
                i = i5;
            }
            int i6 = i + 1;
            makeParameterArray[i3] = Type.intern(str2.substring(i2, i6));
            i3++;
            i2 = i6;
        }
    }

    public static Prototype intern(String str, Type type, boolean z, boolean z2) {
        Type type2 = type;
        boolean z3 = z;
        boolean z4 = z2;
        Prototype intern = intern(str);
        if (z3) {
            return intern;
        }
        if (z4) {
            type2 = type2.asUninitialized(IDirectInputDevice.DIPROPRANGE_NOMAX);
        }
        return intern.withFirstParameter(type2);
    }

    public static Prototype internInts(Type type, int i) {
        StringBuffer stringBuffer;
        Type type2 = type;
        int i2 = i;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append('(');
        for (int i3 = 0; i3 < i2; i3++) {
            StringBuffer append2 = stringBuffer4.append('I');
        }
        StringBuffer append3 = stringBuffer4.append(')');
        StringBuffer append4 = stringBuffer4.append(type2.getDescriptor());
        return intern(stringBuffer4.toString());
    }

    private static Type[] makeParameterArray(String str) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        String str2 = str;
        int length = str2.length();
        if (str2.charAt(0) != '(') {
            IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("bad descriptor");
            throw illegalArgumentException4;
        }
        int i = 1;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = 0;
                break;
            }
            char charAt = str2.charAt(i);
            if (charAt == ')') {
                break;
            }
            if (charAt >= 'A' && charAt <= 'Z') {
                i2++;
            }
            i++;
        }
        if (i == 0 || i == length - 1) {
            IllegalArgumentException illegalArgumentException6 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("bad descriptor");
            throw illegalArgumentException6;
        } else if (str2.indexOf(41, i + 1) == -1) {
            return new Type[i2];
        } else {
            IllegalArgumentException illegalArgumentException8 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("bad descriptor");
            throw illegalArgumentException8;
        }
    }

    private static Prototype putIntern(Prototype prototype) {
        Prototype prototype2 = prototype;
        Prototype prototype3 = internTable;
        synchronized (prototype3) {
            try {
                String descriptor2 = prototype2.getDescriptor();
                th = (Prototype) internTable.get(descriptor2);
                if (th != null) {
                    return th;
                }
                Object put = internTable.put(descriptor2, prototype2);
                return prototype2;
            } finally {
                Throwable th = th;
                Prototype prototype4 = prototype3;
                Throwable th2 = th;
            }
        }
    }

    public int compareTo(Prototype prototype) {
        Prototype prototype2 = prototype;
        if (this != prototype2) {
            int compareTo = this.returnType.compareTo(prototype2.returnType);
            if (compareTo != 0) {
                return compareTo;
            }
            int size = this.parameterTypes.size();
            int size2 = prototype2.parameterTypes.size();
            int min = Math.min(size, size2);
            for (int i = 0; i < min; i++) {
                int compareTo2 = this.parameterTypes.get(i).compareTo(prototype2.parameterTypes.get(i));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
            }
            if (size < size2) {
                return -1;
            }
            if (size > size2) {
                return 1;
            }
        }
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this == obj2) {
            return true;
        }
        if (!(obj2 instanceof Prototype)) {
            return false;
        }
        return this.descriptor.equals(((Prototype) obj2).descriptor);
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public StdTypeList getParameterFrameTypes() {
        StdTypeList stdTypeList;
        if (this.parameterFrameTypes == null) {
            int size = this.parameterTypes.size();
            StdTypeList stdTypeList2 = stdTypeList;
            StdTypeList stdTypeList3 = new StdTypeList(size);
            StdTypeList stdTypeList4 = stdTypeList2;
            boolean z = false;
            for (int i = 0; i < size; i++) {
                Type type = this.parameterTypes.get(i);
                if (type.isIntlike()) {
                    z = true;
                    type = Type.INT;
                }
                stdTypeList4.set(i, type);
            }
            this.parameterFrameTypes = z ? stdTypeList4 : this.parameterTypes;
        }
        return this.parameterFrameTypes;
    }

    public StdTypeList getParameterTypes() {
        return this.parameterTypes;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public int hashCode() {
        return this.descriptor.hashCode();
    }

    public String toString() {
        return this.descriptor;
    }

    public Prototype withFirstParameter(Type type) {
        StringBuilder sb;
        Prototype prototype;
        Type type2 = type;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String sb4 = sb2.append("(").append(type2.getDescriptor()).append(this.descriptor.substring(1)).toString();
        StdTypeList withFirst = this.parameterTypes.withFirst(type2);
        withFirst.setImmutable();
        Prototype prototype2 = prototype;
        Prototype prototype3 = new Prototype(sb4, this.returnType, withFirst);
        return putIntern(prototype2);
    }
}
