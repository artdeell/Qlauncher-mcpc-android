package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls) {
        C04753 r9;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            C04753 r5 = r9;
            final Constructor constructor = declaredConstructor;
            C04753 r6 = new ObjectConstructor<T>(this) {
                final /* synthetic */ ConstructorConstructor this$0;

                {
                    Constructor constructor = r7;
                    this.this$0 = r6;
                }

                public T construct() {
                    AssertionError assertionError;
                    RuntimeException runtimeException;
                    StringBuilder sb;
                    RuntimeException runtimeException2;
                    StringBuilder sb2;
                    try {
                        return constructor.newInstance(null);
                    } catch (InstantiationException e) {
                        InstantiationException instantiationException = e;
                        RuntimeException runtimeException3 = runtimeException2;
                        StringBuilder sb3 = sb2;
                        StringBuilder sb4 = new StringBuilder();
                        RuntimeException runtimeException4 = new RuntimeException(sb3.append("Failed to invoke ").append(constructor).append(" with no args").toString(), instantiationException);
                        throw runtimeException3;
                    } catch (InvocationTargetException e2) {
                        InvocationTargetException invocationTargetException = e2;
                        RuntimeException runtimeException5 = runtimeException;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        RuntimeException runtimeException6 = new RuntimeException(sb5.append("Failed to invoke ").append(constructor).append(" with no args").toString(), invocationTargetException.getTargetException());
                        throw runtimeException5;
                    } catch (IllegalAccessException e3) {
                        IllegalAccessException illegalAccessException = e3;
                        AssertionError assertionError2 = assertionError;
                        AssertionError assertionError3 = new AssertionError(illegalAccessException);
                        throw assertionError2;
                    }
                }
            };
            return r5;
        } catch (NoSuchMethodException e) {
            NoSuchMethodException noSuchMethodException = e;
            return null;
        }
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        C047211 r7;
        C047110 r72;
        C04819 r73;
        C04808 r74;
        C04797 r75;
        C04786 r76;
        C04775 r77;
        C04764 r78;
        Type type2 = type;
        Class<? super T> cls2 = cls;
        if (Collection.class.isAssignableFrom(cls2)) {
            if (SortedSet.class.isAssignableFrom(cls2)) {
                C04764 r3 = r78;
                C04764 r4 = new ObjectConstructor<T>(this) {
                    final /* synthetic */ ConstructorConstructor this$0;

                    {
                        this.this$0 = r5;
                    }

                    public T construct() {
                        TreeSet treeSet;
                        TreeSet treeSet2 = treeSet;
                        TreeSet treeSet3 = new TreeSet();
                        return treeSet2;
                    }
                };
                return r3;
            } else if (EnumSet.class.isAssignableFrom(cls2)) {
                C04775 r32 = r77;
                final Type type3 = type2;
                C04775 r42 = new ObjectConstructor<T>(this) {
                    final /* synthetic */ ConstructorConstructor this$0;

                    {
                        Type type = r7;
                        this.this$0 = r6;
                    }

                    public T construct() {
                        JsonIOException jsonIOException;
                        StringBuilder sb;
                        JsonIOException jsonIOException2;
                        StringBuilder sb2;
                        if (type3 instanceof ParameterizedType) {
                            Type type = ((ParameterizedType) type3).getActualTypeArguments()[0];
                            if (type instanceof Class) {
                                return EnumSet.noneOf((Class) type);
                            }
                            JsonIOException jsonIOException3 = jsonIOException2;
                            StringBuilder sb3 = sb2;
                            StringBuilder sb4 = new StringBuilder();
                            JsonIOException jsonIOException4 = new JsonIOException(sb3.append("Invalid EnumSet type: ").append(type3.toString()).toString());
                            throw jsonIOException3;
                        }
                        JsonIOException jsonIOException5 = jsonIOException;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        JsonIOException jsonIOException6 = new JsonIOException(sb5.append("Invalid EnumSet type: ").append(type3.toString()).toString());
                        throw jsonIOException5;
                    }
                };
                return r32;
            } else if (Set.class.isAssignableFrom(cls2)) {
                C04786 r33 = r76;
                C04786 r43 = new ObjectConstructor<T>(this) {
                    final /* synthetic */ ConstructorConstructor this$0;

                    {
                        this.this$0 = r5;
                    }

                    public T construct() {
                        LinkedHashSet linkedHashSet;
                        LinkedHashSet linkedHashSet2 = linkedHashSet;
                        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                        return linkedHashSet2;
                    }
                };
                return r33;
            } else if (Queue.class.isAssignableFrom(cls2)) {
                C04797 r34 = r75;
                C04797 r44 = new ObjectConstructor<T>(this) {
                    final /* synthetic */ ConstructorConstructor this$0;

                    {
                        this.this$0 = r5;
                    }

                    public T construct() {
                        LinkedList linkedList;
                        LinkedList linkedList2 = linkedList;
                        LinkedList linkedList3 = new LinkedList();
                        return linkedList2;
                    }
                };
                return r34;
            } else {
                C04808 r35 = r74;
                C04808 r45 = new ObjectConstructor<T>(this) {
                    final /* synthetic */ ConstructorConstructor this$0;

                    {
                        this.this$0 = r5;
                    }

                    public T construct() {
                        ArrayList arrayList;
                        ArrayList arrayList2 = arrayList;
                        ArrayList arrayList3 = new ArrayList();
                        return arrayList2;
                    }
                };
                return r35;
            }
        } else if (!Map.class.isAssignableFrom(cls2)) {
            return null;
        } else {
            if (SortedMap.class.isAssignableFrom(cls2)) {
                C04819 r36 = r73;
                C04819 r46 = new ObjectConstructor<T>(this) {
                    final /* synthetic */ ConstructorConstructor this$0;

                    {
                        this.this$0 = r5;
                    }

                    public T construct() {
                        TreeMap treeMap;
                        TreeMap treeMap2 = treeMap;
                        TreeMap treeMap3 = new TreeMap();
                        return treeMap2;
                    }
                };
                return r36;
            } else if (!(type2 instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type2).getActualTypeArguments()[0]).getRawType())) {
                C047211 r37 = r7;
                C047211 r47 = new ObjectConstructor<T>(this) {
                    final /* synthetic */ ConstructorConstructor this$0;

                    {
                        this.this$0 = r5;
                    }

                    public T construct() {
                        LinkedTreeMap linkedTreeMap;
                        LinkedTreeMap linkedTreeMap2 = linkedTreeMap;
                        LinkedTreeMap linkedTreeMap3 = new LinkedTreeMap();
                        return linkedTreeMap2;
                    }
                };
                return r37;
            } else {
                C047110 r38 = r72;
                C047110 r48 = new ObjectConstructor<T>(this) {
                    final /* synthetic */ ConstructorConstructor this$0;

                    {
                        this.this$0 = r5;
                    }

                    public T construct() {
                        LinkedHashMap linkedHashMap;
                        LinkedHashMap linkedHashMap2 = linkedHashMap;
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        return linkedHashMap2;
                    }
                };
                return r38;
            }
        }
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Type type, Class<? super T> cls) {
        C047312 r8;
        C047312 r3 = r8;
        final Class<? super T> cls2 = cls;
        final Type type2 = type;
        C047312 r4 = new ObjectConstructor<T>(this) {
            final /* synthetic */ ConstructorConstructor this$0;
            private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

            {
                Class cls = r8;
                Type type = r9;
                this.this$0 = r7;
            }

            public T construct() {
                RuntimeException runtimeException;
                StringBuilder sb;
                try {
                    return this.unsafeAllocator.newInstance(cls2);
                } catch (Exception e) {
                    Exception exc = e;
                    RuntimeException runtimeException2 = runtimeException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    RuntimeException runtimeException3 = new RuntimeException(sb2.append("Unable to invoke no-args constructor for ").append(type2).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exc);
                    throw runtimeException2;
                }
            }
        };
        return r3;
    }

    /* JADX WARNING: type inference failed for: r8v15, types: [com.google.gson.internal.ObjectConstructor] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: type inference failed for: r0v4, types: [com.google.gson.internal.ObjectConstructor<T>] */
    /* JADX WARNING: type inference failed for: r13v1 */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.google.gson.internal.ObjectConstructor<T> get(com.google.gson.reflect.TypeToken<T> r15) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r8 = r1
            java.lang.reflect.Type r8 = r8.getType()
            r2 = r8
            r8 = r1
            java.lang.Class r8 = r8.getRawType()
            r3 = r8
            r8 = r0
            java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> r8 = r8.instanceCreators
            r9 = r2
            java.lang.Object r8 = r8.get(r9)
            com.google.gson.InstanceCreator r8 = (com.google.gson.InstanceCreator) r8
            r4 = r8
            r8 = r4
            if (r8 == 0) goto L_0x002b
            com.google.gson.internal.ConstructorConstructor$1 r8 = new com.google.gson.internal.ConstructorConstructor$1
            r13 = r8
            r8 = r13
            r9 = r13
            r10 = r0
            r11 = r4
            r12 = r2
            r9.<init>(r10, r11, r12)
            r5 = r8
        L_0x0028:
            r8 = r5
            r0 = r8
        L_0x002a:
            return r0
        L_0x002b:
            r8 = r0
            java.util.Map<java.lang.reflect.Type, com.google.gson.InstanceCreator<?>> r8 = r8.instanceCreators
            r9 = r3
            java.lang.Object r8 = r8.get(r9)
            com.google.gson.InstanceCreator r8 = (com.google.gson.InstanceCreator) r8
            r6 = r8
            r8 = r6
            if (r8 == 0) goto L_0x0046
            com.google.gson.internal.ConstructorConstructor$2 r8 = new com.google.gson.internal.ConstructorConstructor$2
            r13 = r8
            r8 = r13
            r9 = r13
            r10 = r0
            r11 = r6
            r12 = r2
            r9.<init>(r10, r11, r12)
            r0 = r8
            goto L_0x002a
        L_0x0046:
            r8 = r0
            r9 = r3
            com.google.gson.internal.ObjectConstructor r8 = r8.newDefaultConstructor(r9)
            r5 = r8
            r8 = r5
            if (r8 != 0) goto L_0x0028
            r8 = r0
            r9 = r2
            r10 = r3
            com.google.gson.internal.ObjectConstructor r8 = r8.newDefaultImplementationConstructor(r9, r10)
            r7 = r8
            r8 = r7
            if (r8 == 0) goto L_0x005e
            r8 = r7
            r0 = r8
            goto L_0x002a
        L_0x005e:
            r8 = r0
            r9 = r2
            r10 = r3
            com.google.gson.internal.ObjectConstructor r8 = r8.newUnsafeAllocator(r9, r10)
            r0 = r8
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ConstructorConstructor.get(com.google.gson.reflect.TypeToken):com.google.gson.internal.ObjectConstructor");
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
