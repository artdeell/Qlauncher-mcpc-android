package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: com.google.gson.internal.$Gson$Types reason: invalid class name */
public final class C$Gson$Types {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    /* renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = C$Gson$Types.canonicalize(type);
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            return (obj2 instanceof GenericArrayType) && C$Gson$Types.equals(this, (GenericArrayType) obj2);
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append(C$Gson$Types.typeToString(this.componentType)).append("[]").toString();
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
            if (r7.getEnclosingClass() != null) goto L_0x0032;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ParameterizedTypeImpl(java.lang.reflect.Type r16, java.lang.reflect.Type r17, java.lang.reflect.Type... r18) {
            /*
                r15 = this;
                r0 = r15
                r1 = r16
                r2 = r17
                r3 = r18
                r11 = r0
                r11.<init>()
                r11 = r2
                boolean r11 = r11 instanceof java.lang.Class
                if (r11 == 0) goto L_0x0038
                r11 = r2
                java.lang.Class r11 = (java.lang.Class) r11
                r7 = r11
                r11 = r1
                if (r11 != 0) goto L_0x001e
                r11 = r7
                java.lang.Class r11 = r11.getEnclosingClass()
                if (r11 != 0) goto L_0x0082
            L_0x001e:
                r11 = 1
                r8 = r11
            L_0x0020:
                r11 = r8
                com.google.gson.internal.C$Gson$Preconditions.checkArgument(r11)
                r11 = r1
                if (r11 == 0) goto L_0x0032
                r11 = r7
                java.lang.Class r11 = r11.getEnclosingClass()
                r10 = r11
                r11 = 0
                r9 = r11
                r11 = r10
                if (r11 == 0) goto L_0x0034
            L_0x0032:
                r11 = 1
                r9 = r11
            L_0x0034:
                r11 = r9
                com.google.gson.internal.C$Gson$Preconditions.checkArgument(r11)
            L_0x0038:
                r11 = r1
                if (r11 != 0) goto L_0x0085
                r11 = 0
                r4 = r11
            L_0x003d:
                r11 = r0
                r12 = r4
                r11.ownerType = r12
                r11 = r0
                r12 = r2
                java.lang.reflect.Type r12 = com.google.gson.internal.C$Gson$Types.canonicalize(r12)
                r11.rawType = r12
                r11 = r0
                r12 = r3
                java.lang.Object r12 = r12.clone()
                java.lang.reflect.Type[] r12 = (java.lang.reflect.Type[]) r12
                r11.typeArguments = r12
                r11 = 0
                r5 = r11
            L_0x0055:
                r11 = r5
                r12 = r0
                java.lang.reflect.Type[] r12 = r12.typeArguments
                int r12 = r12.length
                if (r11 >= r12) goto L_0x008c
                r11 = r0
                java.lang.reflect.Type[] r11 = r11.typeArguments
                r12 = r5
                r11 = r11[r12]
                java.lang.Object r11 = com.google.gson.internal.C$Gson$Preconditions.checkNotNull(r11)
                r11 = r0
                java.lang.reflect.Type[] r11 = r11.typeArguments
                r12 = r5
                r11 = r11[r12]
                com.google.gson.internal.C$Gson$Types.checkNotPrimitive(r11)
                r11 = r0
                java.lang.reflect.Type[] r11 = r11.typeArguments
                r12 = r5
                r13 = r0
                java.lang.reflect.Type[] r13 = r13.typeArguments
                r14 = r5
                r13 = r13[r14]
                java.lang.reflect.Type r13 = com.google.gson.internal.C$Gson$Types.canonicalize(r13)
                r11[r12] = r13
                int r5 = r5 + 1
                goto L_0x0055
            L_0x0082:
                r11 = 0
                r8 = r11
                goto L_0x0020
            L_0x0085:
                r11 = r1
                java.lang.reflect.Type r11 = com.google.gson.internal.C$Gson$Types.canonicalize(r11)
                r4 = r11
                goto L_0x003d
            L_0x008c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.C$Gson$Types.ParameterizedTypeImpl.<init>(java.lang.reflect.Type, java.lang.reflect.Type, java.lang.reflect.Type[]):void");
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            return (obj2 instanceof ParameterizedType) && C$Gson$Types.equals(this, (ParameterizedType) obj2);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C$Gson$Types.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder(30 * (1 + this.typeArguments.length));
            StringBuilder sb4 = sb2;
            StringBuilder append = sb4.append(C$Gson$Types.typeToString(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb4.toString();
            }
            StringBuilder append2 = sb4.append("<").append(C$Gson$Types.typeToString(this.typeArguments[0]));
            for (int i = 1; i < this.typeArguments.length; i++) {
                StringBuilder append3 = sb4.append(", ").append(C$Gson$Types.typeToString(this.typeArguments[i]));
            }
            return sb4.append(">").toString();
        }
    }

    /* renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    private static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Type[] typeArr3 = typeArr;
            Type[] typeArr4 = typeArr2;
            boolean z = true;
            C$Gson$Preconditions.checkArgument(typeArr4.length <= 1);
            C$Gson$Preconditions.checkArgument(typeArr3.length == 1);
            if (typeArr4.length == 1) {
                Object checkNotNull = C$Gson$Preconditions.checkNotNull(typeArr4[0]);
                C$Gson$Types.checkNotPrimitive(typeArr4[0]);
                if (typeArr3[0] != Object.class) {
                    z = false;
                }
                C$Gson$Preconditions.checkArgument(z);
                this.lowerBound = C$Gson$Types.canonicalize(typeArr4[0]);
                this.upperBound = Object.class;
                return;
            }
            Object checkNotNull2 = C$Gson$Preconditions.checkNotNull(typeArr3[0]);
            C$Gson$Types.checkNotPrimitive(typeArr3[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.canonicalize(typeArr3[0]);
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            return (obj2 instanceof WildcardType) && C$Gson$Types.equals(this, (WildcardType) obj2);
        }

        public Type[] getLowerBounds() {
            if (this.lowerBound == null) {
                return C$Gson$Types.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{this.lowerBound};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            return (this.lowerBound != null ? 31 + this.lowerBound.hashCode() : 1) ^ (31 + this.upperBound.hashCode());
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2;
            if (this.lowerBound != null) {
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                return sb3.append("? super ").append(C$Gson$Types.typeToString(this.lowerBound)).toString();
            } else if (this.upperBound == Object.class) {
                return "?";
            } else {
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                return sb5.append("? extends ").append(C$Gson$Types.typeToString(this.upperBound)).toString();
            }
        }
    }

    private C$Gson$Types() {
    }

    public static GenericArrayType arrayOf(Type type) {
        GenericArrayTypeImpl genericArrayTypeImpl;
        GenericArrayTypeImpl genericArrayTypeImpl2 = genericArrayTypeImpl;
        GenericArrayTypeImpl genericArrayTypeImpl3 = new GenericArrayTypeImpl(type);
        return genericArrayTypeImpl2;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type canonicalize(java.lang.reflect.Type r11) {
        /*
            r0 = r11
            r5 = r0
            boolean r5 = r5 instanceof java.lang.Class
            if (r5 == 0) goto L_0x002b
            r5 = r0
            java.lang.Class r5 = (java.lang.Class) r5
            r3 = r5
            r5 = r3
            boolean r5 = r5.isArray()
            if (r5 == 0) goto L_0x0028
            com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl r5 = new com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl
            r10 = r5
            r5 = r10
            r6 = r10
            r7 = r3
            java.lang.Class r7 = r7.getComponentType()
            java.lang.reflect.Type r7 = canonicalize(r7)
            r6.<init>(r7)
            r4 = r5
        L_0x0023:
            r5 = r4
            java.lang.reflect.Type r5 = (java.lang.reflect.Type) r5
            r0 = r5
        L_0x0027:
            return r0
        L_0x0028:
            r5 = r3
            r4 = r5
            goto L_0x0023
        L_0x002b:
            r5 = r0
            boolean r5 = r5 instanceof java.lang.reflect.ParameterizedType
            if (r5 == 0) goto L_0x004d
            r5 = r0
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            r2 = r5
            com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl r5 = new com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl
            r10 = r5
            r5 = r10
            r6 = r10
            r7 = r2
            java.lang.reflect.Type r7 = r7.getOwnerType()
            r8 = r2
            java.lang.reflect.Type r8 = r8.getRawType()
            r9 = r2
            java.lang.reflect.Type[] r9 = r9.getActualTypeArguments()
            r6.<init>(r7, r8, r9)
            r0 = r5
            goto L_0x0027
        L_0x004d:
            r5 = r0
            boolean r5 = r5 instanceof java.lang.reflect.GenericArrayType
            if (r5 == 0) goto L_0x0063
            com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl r5 = new com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl
            r10 = r5
            r5 = r10
            r6 = r10
            r7 = r0
            java.lang.reflect.GenericArrayType r7 = (java.lang.reflect.GenericArrayType) r7
            java.lang.reflect.Type r7 = r7.getGenericComponentType()
            r6.<init>(r7)
            r0 = r5
            goto L_0x0027
        L_0x0063:
            r5 = r0
            boolean r5 = r5 instanceof java.lang.reflect.WildcardType
            if (r5 == 0) goto L_0x0080
            r5 = r0
            java.lang.reflect.WildcardType r5 = (java.lang.reflect.WildcardType) r5
            r1 = r5
            com.google.gson.internal.$Gson$Types$WildcardTypeImpl r5 = new com.google.gson.internal.$Gson$Types$WildcardTypeImpl
            r10 = r5
            r5 = r10
            r6 = r10
            r7 = r1
            java.lang.reflect.Type[] r7 = r7.getUpperBounds()
            r8 = r1
            java.lang.reflect.Type[] r8 = r8.getLowerBounds()
            r6.<init>(r7, r8)
            r0 = r5
            goto L_0x0027
        L_0x0080:
            r5 = r0
            r0 = r5
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.C$Gson$Types.canonicalize(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    /* access modifiers changed from: private */
    public static void checkNotPrimitive(Type type) {
        Type type2 = type;
        C$Gson$Preconditions.checkArgument(!(type2 instanceof Class) || !((Class) type2).isPrimitive());
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static boolean equal(Object obj, Object obj2) {
        Object obj3 = obj;
        Object obj4 = obj2;
        return obj3 == obj4 || (obj3 != null && obj3.equals(obj4));
    }

    public static boolean equals(Type type, Type type2) {
        boolean z;
        Type type3 = type;
        Type type4 = type2;
        boolean z2 = true;
        if (type3 == type4) {
            z = true;
        } else if (type3 instanceof Class) {
            return type3.equals(type4);
        } else {
            if (type3 instanceof ParameterizedType) {
                z = false;
                if (type4 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    ParameterizedType parameterizedType2 = (ParameterizedType) type4;
                    if (!equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                        z2 = false;
                    }
                    return z2;
                }
            } else if (type3 instanceof GenericArrayType) {
                z = false;
                if (type4 instanceof GenericArrayType) {
                    return equals(((GenericArrayType) type3).getGenericComponentType(), ((GenericArrayType) type4).getGenericComponentType());
                }
            } else if (type3 instanceof WildcardType) {
                z = false;
                if (type4 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type3;
                    WildcardType wildcardType2 = (WildcardType) type4;
                    if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                        z2 = false;
                    }
                    return z2;
                }
            } else {
                z = false;
                if (type3 instanceof TypeVariable) {
                    z = false;
                    if (type4 instanceof TypeVariable) {
                        TypeVariable typeVariable = (TypeVariable) type3;
                        TypeVariable typeVariable2 = (TypeVariable) type4;
                        if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                            z2 = false;
                        }
                        return z2;
                    }
                }
            }
        }
        return z;
    }

    public static Type getArrayComponentType(Type type) {
        Type type2 = type;
        return type2 instanceof GenericArrayType ? ((GenericArrayType) type2).getGenericComponentType() : ((Class) type2).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        Type supertype = getSupertype(type, cls, Collection.class);
        if (supertype instanceof WildcardType) {
            supertype = ((WildcardType) supertype).getUpperBounds()[0];
        }
        return supertype instanceof ParameterizedType ? ((ParameterizedType) supertype).getActualTypeArguments()[0] : Object.class;
    }

    static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        Type type2 = type;
        Class<?> cls3 = cls;
        Class<?> cls4 = cls2;
        if (cls4 == cls3) {
            return type2;
        }
        if (cls4.isInterface()) {
            Class<?>[] interfaces = cls3.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls4) {
                    return cls3.getGenericInterfaces()[i];
                }
                if (cls4.isAssignableFrom(interfaces[i])) {
                    return getGenericSupertype(cls3.getGenericInterfaces()[i], interfaces[i], cls4);
                }
            }
        }
        if (!cls3.isInterface()) {
            while (cls3 != Object.class) {
                Class<?> superclass = cls3.getSuperclass();
                if (superclass == cls4) {
                    return cls3.getGenericSuperclass();
                }
                if (cls4.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls3.getGenericSuperclass(), superclass, cls4);
                }
                cls3 = superclass;
            }
        }
        return cls4;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        Type type2 = type;
        Class<?> cls2 = cls;
        if (type2 == Properties.class) {
            Type[] typeArr = new Type[2];
            Type[] typeArr2 = typeArr;
            typeArr[0] = String.class;
            Type[] typeArr3 = typeArr2;
            Type[] typeArr4 = typeArr3;
            typeArr3[1] = String.class;
            return typeArr4;
        }
        Type supertype = getSupertype(type2, cls2, Map.class);
        if (supertype instanceof ParameterizedType) {
            return ((ParameterizedType) supertype).getActualTypeArguments();
        }
        Type[] typeArr5 = new Type[2];
        Type[] typeArr6 = typeArr5;
        typeArr5[0] = Object.class;
        Type[] typeArr7 = typeArr6;
        Type[] typeArr8 = typeArr7;
        typeArr7[1] = Object.class;
        return typeArr8;
    }

    public static Class<?> getRawType(Type type) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Type type2 = type;
        if (type2 instanceof Class) {
            return (Class) type2;
        }
        if (type2 instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type2).getRawType();
            C$Gson$Preconditions.checkArgument(rawType instanceof Class);
            return (Class) rawType;
        } else if (type2 instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type2).getGenericComponentType()), 0).getClass();
        } else {
            if (type2 instanceof TypeVariable) {
                return Object.class;
            }
            if (type2 instanceof WildcardType) {
                return getRawType(((WildcardType) type2).getUpperBounds()[0]);
            }
            String name = type2 == null ? "null" : type2.getClass().getName();
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Expected a Class, ParameterizedType, or GenericArrayType, but <").append(type2).append("> is of type ").append(name).toString());
            throw illegalArgumentException2;
        }
    }

    static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        Type type2 = type;
        Class<?> cls3 = cls;
        Class<?> cls4 = cls2;
        C$Gson$Preconditions.checkArgument(cls4.isAssignableFrom(cls3));
        return resolve(type2, cls3, getGenericSupertype(type2, cls3, cls4));
    }

    /* access modifiers changed from: private */
    public static int hashCodeOrZero(Object obj) {
        Object obj2 = obj;
        if (obj2 != null) {
            return obj2.hashCode();
        }
        return 0;
    }

    private static int indexOf(Object[] objArr, Object obj) {
        NoSuchElementException noSuchElementException;
        Object[] objArr2 = objArr;
        Object obj2 = obj;
        for (int i = 0; i < objArr2.length; i++) {
            if (obj2.equals(objArr2[i])) {
                return i;
            }
        }
        NoSuchElementException noSuchElementException2 = noSuchElementException;
        NoSuchElementException noSuchElementException3 = new NoSuchElementException();
        throw noSuchElementException2;
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        ParameterizedTypeImpl parameterizedTypeImpl;
        ParameterizedTypeImpl parameterizedTypeImpl2 = parameterizedTypeImpl;
        ParameterizedTypeImpl parameterizedTypeImpl3 = new ParameterizedTypeImpl(type, type2, typeArr);
        return parameterizedTypeImpl2;
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r23v0 */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r23v2 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r23v4 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r23v6 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r23v8 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r23v10 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r23v11 */
    /* JADX WARNING: type inference failed for: r23v12, types: [java.lang.reflect.WildcardType] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r23v13, types: [java.lang.reflect.WildcardType] */
    /* JADX WARNING: type inference failed for: r23v15, types: [java.lang.reflect.WildcardType] */
    /* JADX WARNING: type inference failed for: r23v31 */
    /* JADX WARNING: type inference failed for: r23v32, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r23v33, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARNING: type inference failed for: r23v39, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARNING: type inference failed for: r24v11, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARNING: type inference failed for: r23v58 */
    /* JADX WARNING: type inference failed for: r23v59, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r23v60, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARNING: type inference failed for: r23v67 */
    /* JADX WARNING: type inference failed for: r23v70 */
    /* JADX WARNING: type inference failed for: r23v71, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r23v78, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r19v2 */
    /* JADX WARNING: type inference failed for: r23v79 */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r23v80 */
    /* JADX WARNING: type inference failed for: r2v7, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r23v81 */
    /* JADX WARNING: type inference failed for: r23v84, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r23v85 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r23v86 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 40 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type resolve(java.lang.reflect.Type r27, java.lang.Class<?> r28, java.lang.reflect.Type r29) {
        /*
            r2 = r27
            r3 = r28
            r4 = r29
        L_0x0006:
            r23 = r4
            r0 = r23
            boolean r0 = r0 instanceof java.lang.reflect.TypeVariable
            r23 = r0
            if (r23 == 0) goto L_0x0035
            r23 = r4
            java.lang.reflect.TypeVariable r23 = (java.lang.reflect.TypeVariable) r23
            r22 = r23
            r23 = r2
            r24 = r3
            r25 = r22
            java.lang.reflect.Type r23 = resolveTypeVariable(r23, r24, r25)
            r4 = r23
            r23 = r4
            r24 = r22
            r0 = r23
            r1 = r24
            if (r0 != r1) goto L_0x0006
            r23 = r4
            r5 = r23
        L_0x0030:
            r23 = r5
            r2 = r23
        L_0x0034:
            return r2
        L_0x0035:
            r23 = r4
            r0 = r23
            boolean r0 = r0 instanceof java.lang.Class
            r23 = r0
            if (r23 == 0) goto L_0x007b
            r23 = r4
            java.lang.Class r23 = (java.lang.Class) r23
            boolean r23 = r23.isArray()
            if (r23 == 0) goto L_0x007b
            r23 = r4
            java.lang.Class r23 = (java.lang.Class) r23
            r19 = r23
            r23 = r19
            java.lang.Class r23 = r23.getComponentType()
            r20 = r23
            r23 = r2
            r24 = r3
            r25 = r20
            java.lang.reflect.Type r23 = resolve(r23, r24, r25)
            r21 = r23
            r23 = r20
            r24 = r21
            r0 = r23
            r1 = r24
            if (r0 != r1) goto L_0x0072
        L_0x006d:
            r23 = r19
            r2 = r23
            goto L_0x0034
        L_0x0072:
            r23 = r21
            java.lang.reflect.GenericArrayType r23 = arrayOf(r23)
            r19 = r23
            goto L_0x006d
        L_0x007b:
            r23 = r4
            r0 = r23
            boolean r0 = r0 instanceof java.lang.reflect.GenericArrayType
            r23 = r0
            if (r23 == 0) goto L_0x00b2
            r23 = r4
            java.lang.reflect.GenericArrayType r23 = (java.lang.reflect.GenericArrayType) r23
            r5 = r23
            r23 = r5
            java.lang.reflect.Type r23 = r23.getGenericComponentType()
            r17 = r23
            r23 = r2
            r24 = r3
            r25 = r17
            java.lang.reflect.Type r23 = resolve(r23, r24, r25)
            r18 = r23
            r23 = r17
            r24 = r18
            r0 = r23
            r1 = r24
            if (r0 == r1) goto L_0x0030
            r23 = r18
            java.lang.reflect.GenericArrayType r23 = arrayOf(r23)
            r2 = r23
            goto L_0x0034
        L_0x00b2:
            r23 = r4
            r0 = r23
            boolean r0 = r0 instanceof java.lang.reflect.ParameterizedType
            r23 = r0
            if (r23 == 0) goto L_0x0159
            r23 = r4
            java.lang.reflect.ParameterizedType r23 = (java.lang.reflect.ParameterizedType) r23
            r5 = r23
            r23 = r5
            java.lang.reflect.Type r23 = r23.getOwnerType()
            r10 = r23
            r23 = r2
            r24 = r3
            r25 = r10
            java.lang.reflect.Type r23 = resolve(r23, r24, r25)
            r11 = r23
            r23 = r11
            r24 = r10
            r0 = r23
            r1 = r24
            if (r0 == r1) goto L_0x013e
            r23 = 1
            r12 = r23
        L_0x00e4:
            r23 = r5
            java.lang.reflect.Type[] r23 = r23.getActualTypeArguments()
            r13 = r23
            r23 = 0
            r14 = r23
            r23 = r13
            r0 = r23
            int r0 = r0.length
            r23 = r0
            r15 = r23
        L_0x00f9:
            r23 = r14
            r24 = r15
            r0 = r23
            r1 = r24
            if (r0 >= r1) goto L_0x0143
            r23 = r2
            r24 = r3
            r25 = r13
            r26 = r14
            r25 = r25[r26]
            java.lang.reflect.Type r23 = resolve(r23, r24, r25)
            r16 = r23
            r23 = r16
            r24 = r13
            r25 = r14
            r24 = r24[r25]
            r0 = r23
            r1 = r24
            if (r0 == r1) goto L_0x013b
            r23 = r12
            if (r23 != 0) goto L_0x0133
            r23 = r13
            java.lang.Object r23 = r23.clone()
            java.lang.reflect.Type[] r23 = (java.lang.reflect.Type[]) r23
            r13 = r23
            r23 = 1
            r12 = r23
        L_0x0133:
            r23 = r13
            r24 = r14
            r25 = r16
            r23[r24] = r25
        L_0x013b:
            int r14 = r14 + 1
            goto L_0x00f9
        L_0x013e:
            r23 = 0
            r12 = r23
            goto L_0x00e4
        L_0x0143:
            r23 = r12
            if (r23 == 0) goto L_0x0030
            r23 = r11
            r24 = r5
            java.lang.reflect.Type r24 = r24.getRawType()
            r25 = r13
            java.lang.reflect.ParameterizedType r23 = newParameterizedTypeWithOwner(r23, r24, r25)
            r2 = r23
            goto L_0x0034
        L_0x0159:
            r23 = r4
            r0 = r23
            boolean r0 = r0 instanceof java.lang.reflect.WildcardType
            r23 = r0
            if (r23 == 0) goto L_0x01e7
            r23 = r4
            java.lang.reflect.WildcardType r23 = (java.lang.reflect.WildcardType) r23
            r5 = r23
            r23 = r5
            java.lang.reflect.Type[] r23 = r23.getLowerBounds()
            r6 = r23
            r23 = r5
            java.lang.reflect.Type[] r23 = r23.getUpperBounds()
            r7 = r23
            r23 = r6
            r0 = r23
            int r0 = r0.length
            r23 = r0
            r24 = 1
            r0 = r23
            r1 = r24
            if (r0 != r1) goto L_0x01b0
            r23 = r2
            r24 = r3
            r25 = r6
            r26 = 0
            r25 = r25[r26]
            java.lang.reflect.Type r23 = resolve(r23, r24, r25)
            r9 = r23
            r23 = r9
            r24 = r6
            r25 = 0
            r24 = r24[r25]
            r0 = r23
            r1 = r24
            if (r0 == r1) goto L_0x0030
            r23 = r9
            java.lang.reflect.WildcardType r23 = supertypeOf(r23)
            r2 = r23
            goto L_0x0034
        L_0x01b0:
            r23 = r7
            r0 = r23
            int r0 = r0.length
            r23 = r0
            r24 = 1
            r0 = r23
            r1 = r24
            if (r0 != r1) goto L_0x0030
            r23 = r2
            r24 = r3
            r25 = r7
            r26 = 0
            r25 = r25[r26]
            java.lang.reflect.Type r23 = resolve(r23, r24, r25)
            r8 = r23
            r23 = r8
            r24 = r7
            r25 = 0
            r24 = r24[r25]
            r0 = r23
            r1 = r24
            if (r0 == r1) goto L_0x0030
            r23 = r8
            java.lang.reflect.WildcardType r23 = subtypeOf(r23)
            r2 = r23
            goto L_0x0034
        L_0x01e7:
            r23 = r4
            r2 = r23
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.C$Gson$Types.resolve(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Type type2 = type;
        Class<?> cls2 = cls;
        TypeVariable<?> typeVariable2 = typeVariable;
        Class declaringClassOf = declaringClassOf(typeVariable2);
        if (declaringClassOf != null) {
            Type genericSupertype = getGenericSupertype(type2, cls2, declaringClassOf);
            if (genericSupertype instanceof ParameterizedType) {
                return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable2)];
            }
        }
        return typeVariable2;
    }

    public static WildcardType subtypeOf(Type type) {
        WildcardTypeImpl wildcardTypeImpl;
        WildcardTypeImpl wildcardTypeImpl2 = wildcardTypeImpl;
        Type[] typeArr = new Type[1];
        Type[] typeArr2 = typeArr;
        typeArr[0] = type;
        WildcardTypeImpl wildcardTypeImpl3 = new WildcardTypeImpl(typeArr2, EMPTY_TYPE_ARRAY);
        return wildcardTypeImpl2;
    }

    public static WildcardType supertypeOf(Type type) {
        WildcardTypeImpl wildcardTypeImpl;
        Type type2 = type;
        WildcardTypeImpl wildcardTypeImpl2 = wildcardTypeImpl;
        Type[] typeArr = new Type[1];
        Type[] typeArr2 = typeArr;
        typeArr[0] = Object.class;
        Type[] typeArr3 = new Type[1];
        Type[] typeArr4 = typeArr3;
        typeArr3[0] = type2;
        WildcardTypeImpl wildcardTypeImpl3 = new WildcardTypeImpl(typeArr2, typeArr4);
        return wildcardTypeImpl2;
    }

    public static String typeToString(Type type) {
        Type type2 = type;
        return type2 instanceof Class ? ((Class) type2).getName() : type2.toString();
    }
}
