package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Primitives {
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
    private static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;

    static {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3 = hashMap;
        HashMap hashMap4 = new HashMap(16);
        HashMap hashMap5 = hashMap3;
        HashMap hashMap6 = hashMap2;
        HashMap hashMap7 = new HashMap(16);
        HashMap hashMap8 = hashMap6;
        add(hashMap5, hashMap8, Boolean.TYPE, Boolean.class);
        add(hashMap5, hashMap8, Byte.TYPE, Byte.class);
        add(hashMap5, hashMap8, Character.TYPE, Character.class);
        add(hashMap5, hashMap8, Double.TYPE, Double.class);
        add(hashMap5, hashMap8, Float.TYPE, Float.class);
        add(hashMap5, hashMap8, Integer.TYPE, Integer.class);
        add(hashMap5, hashMap8, Long.TYPE, Long.class);
        add(hashMap5, hashMap8, Short.TYPE, Short.class);
        add(hashMap5, hashMap8, Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(hashMap5);
        WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(hashMap8);
    }

    private Primitives() {
    }

    private static void add(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        Map<Class<?>, Class<?>> map3 = map2;
        Class<?> cls3 = cls;
        Class<?> cls4 = cls2;
        Object put = map.put(cls3, cls4);
        Object put2 = map3.put(cls4, cls3);
    }

    public static boolean isPrimitive(Type type) {
        return PRIMITIVE_TO_WRAPPER_TYPE.containsKey(type);
    }

    public static boolean isWrapperType(Type type) {
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(C$Gson$Preconditions.checkNotNull(type));
    }

    public static <T> Class<T> unwrap(Class<T> cls) {
        Class<T> cls2 = cls;
        Class cls3 = (Class) WRAPPER_TO_PRIMITIVE_TYPE.get(C$Gson$Preconditions.checkNotNull(cls2));
        return cls3 == null ? cls2 : cls3;
    }

    public static <T> Class<T> wrap(Class<T> cls) {
        Class<T> cls2 = cls;
        Class cls3 = (Class) PRIMITIVE_TO_WRAPPER_TYPE.get(C$Gson$Preconditions.checkNotNull(cls2));
        return cls3 == null ? cls2 : cls3;
    }
}
