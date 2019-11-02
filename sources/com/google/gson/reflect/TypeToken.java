package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    protected TypeToken() {
        this.type = getSuperclassTypeParameter(getClass());
        this.rawType = C$Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    TypeToken(Type type2) {
        this.type = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(type2));
        this.rawType = C$Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type type2, Class<?>... clsArr) {
        StringBuilder sb;
        AssertionError assertionError;
        Type type3 = type2;
        Class<?>[] clsArr2 = clsArr;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder("Unexpected type. Expected one of: ");
        StringBuilder sb4 = sb2;
        int length = clsArr2.length;
        for (int i = 0; i < length; i++) {
            StringBuilder append = sb4.append(clsArr2[i].getName()).append(", ");
        }
        StringBuilder append2 = sb4.append("but got: ").append(type3.getClass().getName()).append(", for type token: ").append(type3.toString()).append('.');
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError(sb4.toString());
        return assertionError2;
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        TypeToken typeToken;
        TypeToken typeToken2 = typeToken;
        TypeToken typeToken3 = new TypeToken(cls);
        return typeToken2;
    }

    public static TypeToken<?> get(Type type2) {
        TypeToken typeToken;
        TypeToken typeToken2 = typeToken;
        TypeToken typeToken3 = new TypeToken(type2);
        return typeToken2;
    }

    static Type getSuperclassTypeParameter(Class<?> cls) {
        RuntimeException runtimeException;
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C$Gson$Types.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("Missing type parameter.");
        throw runtimeException2;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r5v11, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r5v17, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r5v18, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v22, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 14 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isAssignableFrom(java.lang.reflect.Type r10, java.lang.reflect.GenericArrayType r11) {
        /*
            r0 = r10
            r1 = r11
            r5 = r1
            java.lang.reflect.Type r5 = r5.getGenericComponentType()
            r2 = r5
            r5 = r2
            boolean r5 = r5 instanceof java.lang.reflect.ParameterizedType
            if (r5 == 0) goto L_0x0048
            r5 = r0
            r3 = r5
            r5 = r0
            boolean r5 = r5 instanceof java.lang.reflect.GenericArrayType
            if (r5 == 0) goto L_0x002e
            r5 = r0
            java.lang.reflect.GenericArrayType r5 = (java.lang.reflect.GenericArrayType) r5
            java.lang.reflect.Type r5 = r5.getGenericComponentType()
            r3 = r5
        L_0x001c:
            r5 = r3
            r6 = r2
            java.lang.reflect.ParameterizedType r6 = (java.lang.reflect.ParameterizedType) r6
            java.util.HashMap r7 = new java.util.HashMap
            r9 = r7
            r7 = r9
            r8 = r9
            r8.<init>()
            boolean r5 = isAssignableFrom(r5, r6, r7)
            r0 = r5
        L_0x002d:
            return r0
        L_0x002e:
            r5 = r0
            boolean r5 = r5 instanceof java.lang.Class
            if (r5 == 0) goto L_0x001c
            r5 = r0
            java.lang.Class r5 = (java.lang.Class) r5
            r4 = r5
        L_0x0037:
            r5 = r4
            boolean r5 = r5.isArray()
            if (r5 == 0) goto L_0x0045
            r5 = r4
            java.lang.Class r5 = r5.getComponentType()
            r4 = r5
            goto L_0x0037
        L_0x0045:
            r5 = r4
            r3 = r5
            goto L_0x001c
        L_0x0048:
            r5 = 1
            r0 = r5
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.reflect.TypeToken.isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.GenericArrayType):boolean");
    }

    private static boolean isAssignableFrom(Type type2, ParameterizedType parameterizedType, Map<String, Type> map) {
        HashMap hashMap;
        HashMap hashMap2;
        Type type3 = type2;
        ParameterizedType parameterizedType2 = parameterizedType;
        Map<String, Type> map2 = map;
        if (type3 == null) {
            return false;
        }
        if (parameterizedType2.equals(type3)) {
            return true;
        }
        Class rawType2 = C$Gson$Types.getRawType(type3);
        ParameterizedType parameterizedType3 = null;
        if (type3 instanceof ParameterizedType) {
            parameterizedType3 = (ParameterizedType) type3;
        }
        if (parameterizedType3 != null) {
            Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
            TypeVariable[] typeParameters = rawType2.getTypeParameters();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type4 = actualTypeArguments[i];
                TypeVariable typeVariable = typeParameters[i];
                while (type4 instanceof TypeVariable) {
                    type4 = (Type) map2.get(((TypeVariable) type4).getName());
                }
                Object put = map2.put(typeVariable.getName(), type4);
            }
            if (typeEquals(parameterizedType3, parameterizedType2, map2)) {
                return true;
            }
        }
        Type[] genericInterfaces = rawType2.getGenericInterfaces();
        int length = genericInterfaces.length;
        for (int i2 = 0; i2 < length; i2++) {
            Type type5 = genericInterfaces[i2];
            ParameterizedType parameterizedType4 = parameterizedType2;
            HashMap hashMap3 = hashMap2;
            HashMap hashMap4 = new HashMap(map2);
            if (isAssignableFrom(type5, parameterizedType4, hashMap3)) {
                return true;
            }
        }
        Type genericSuperclass = rawType2.getGenericSuperclass();
        ParameterizedType parameterizedType5 = parameterizedType2;
        HashMap hashMap5 = hashMap;
        HashMap hashMap6 = new HashMap(map2);
        return isAssignableFrom(genericSuperclass, parameterizedType5, hashMap5);
    }

    private static boolean matches(Type type2, Type type3, Map<String, Type> map) {
        Type type4 = type2;
        Type type5 = type3;
        return type5.equals(type4) || ((type4 instanceof TypeVariable) && type5.equals(map.get(((TypeVariable) type4).getName())));
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        ParameterizedType parameterizedType3 = parameterizedType;
        ParameterizedType parameterizedType4 = parameterizedType2;
        Map<String, Type> map2 = map;
        if (parameterizedType3.getRawType().equals(parameterizedType4.getRawType())) {
            Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType4.getActualTypeArguments();
            int i = 0;
            while (i < actualTypeArguments.length) {
                if (matches(actualTypeArguments[i], actualTypeArguments2[i], map2)) {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        return (obj2 instanceof TypeToken) && C$Gson$Types.equals(this.type, ((TypeToken) obj2).type);
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type2) {
        HashMap hashMap;
        Type type3 = type2;
        if (type3 == null) {
            return false;
        }
        if (this.type.equals(type3)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type3));
        }
        if (this.type instanceof ParameterizedType) {
            Type type4 = type3;
            ParameterizedType parameterizedType = (ParameterizedType) this.type;
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            return isAssignableFrom(type4, parameterizedType, hashMap2);
        } else if (this.type instanceof GenericArrayType) {
            return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type3)) && isAssignableFrom(type3, (GenericArrayType) this.type);
        } else {
            Type type5 = this.type;
            Class[] clsArr = new Class[3];
            Class[] clsArr2 = clsArr;
            clsArr[0] = Class.class;
            Class[] clsArr3 = clsArr2;
            Class[] clsArr4 = clsArr3;
            clsArr3[1] = ParameterizedType.class;
            Class[] clsArr5 = clsArr4;
            Class[] clsArr6 = clsArr5;
            clsArr5[2] = GenericArrayType.class;
            throw buildUnexpectedTypeError(type5, clsArr6);
        }
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }
}
