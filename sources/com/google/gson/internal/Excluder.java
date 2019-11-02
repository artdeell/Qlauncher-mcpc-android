package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT;
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
    private int modifiers = 136;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private boolean serializeInnerClasses = true;
    private double version = IGNORE_VERSIONS;

    static {
        Excluder excluder;
        Excluder excluder2 = excluder;
        Excluder excluder3 = new Excluder();
        DEFAULT = excluder2;
    }

    public Excluder() {
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        Class<?> cls2 = cls;
        return !Enum.class.isAssignableFrom(cls2) && (cls2.isAnonymousClass() || cls2.isLocalClass());
    }

    private boolean isInnerClass(Class<?> cls) {
        Class<?> cls2 = cls;
        return cls2.isMemberClass() && !isStatic(cls2);
    }

    private boolean isStatic(Class<?> cls) {
        return (8 & cls.getModifiers()) != 0;
    }

    private boolean isValidSince(Since since) {
        Since since2 = since;
        return since2 == null || since2.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        Until until2 = until;
        return until2 == null || until2.value() > this.version;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    /* access modifiers changed from: protected */
    public Excluder clone() {
        AssertionError assertionError;
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            CloneNotSupportedException cloneNotSupportedException = e;
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        C04821 r13;
        Gson gson2 = gson;
        TypeToken<T> typeToken2 = typeToken;
        Class rawType = typeToken2.getRawType();
        boolean excludeClass = excludeClass(rawType, true);
        boolean excludeClass2 = excludeClass(rawType, false);
        if (!excludeClass && !excludeClass2) {
            return null;
        }
        C04821 r6 = r13;
        final boolean z = excludeClass2;
        final boolean z2 = excludeClass;
        final Gson gson3 = gson2;
        final TypeToken<T> typeToken3 = typeToken2;
        C04821 r7 = new TypeAdapter<T>(this) {
            private TypeAdapter<T> delegate;
            final /* synthetic */ Excluder this$0;

            {
                boolean z = r10;
                boolean z2 = r11;
                Gson gson = r12;
                TypeToken typeToken = r13;
                this.this$0 = r9;
            }

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter delegateAdapter = gson3.getDelegateAdapter(this.this$0, typeToken3);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }

            public T read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (!z) {
                    return delegate().read(jsonReader2);
                }
                jsonReader2.skipValue();
                return null;
            }

            public void write(JsonWriter jsonWriter, T t) throws IOException {
                JsonWriter jsonWriter2 = jsonWriter;
                T t2 = t;
                if (z2) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                } else {
                    delegate().write(jsonWriter2, t2);
                }
            }
        };
        return r6;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.serializeInnerClasses = false;
        return clone;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        Class<?> cls2 = cls;
        boolean z2 = z;
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) cls2.getAnnotation(Since.class), (Until) cls2.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.serializeInnerClasses && isInnerClass(cls2)) {
            return true;
        }
        if (isAnonymousOrLocal(cls2)) {
            return true;
        }
        for (ExclusionStrategy shouldSkipClass : z2 ? this.serializationStrategies : this.deserializationStrategies) {
            if (shouldSkipClass.shouldSkipClass(cls2)) {
                return true;
            }
        }
        return false;
    }

    public boolean excludeField(Field field, boolean z) {
        FieldAttributes fieldAttributes;
        Field field2 = field;
        boolean z2 = z;
        if ((this.modifiers & field2.getModifiers()) != 0) {
            return true;
        }
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) field2.getAnnotation(Since.class), (Until) field2.getAnnotation(Until.class))) {
            return true;
        }
        if (field2.isSynthetic()) {
            return true;
        }
        if (this.requireExpose) {
            Expose expose = (Expose) field2.getAnnotation(Expose.class);
            if (expose == null || (!z2 ? !expose.deserialize() : !expose.serialize())) {
                return true;
            }
        }
        if (!this.serializeInnerClasses && isInnerClass(field2.getType())) {
            return true;
        }
        if (isAnonymousOrLocal(field2.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z2 ? this.serializationStrategies : this.deserializationStrategies;
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes2 = fieldAttributes;
            FieldAttributes fieldAttributes3 = new FieldAttributes(field2);
            FieldAttributes fieldAttributes4 = fieldAttributes2;
            for (ExclusionStrategy shouldSkipField : list) {
                if (shouldSkipField.shouldSkipField(fieldAttributes4)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.requireExpose = true;
        return clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ExclusionStrategy exclusionStrategy2 = exclusionStrategy;
        boolean z3 = z;
        boolean z4 = z2;
        Excluder clone = clone();
        if (z3) {
            Excluder excluder = clone;
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(this.serializationStrategies);
            excluder.serializationStrategies = arrayList3;
            boolean add = clone.serializationStrategies.add(exclusionStrategy2);
        }
        if (z4) {
            Excluder excluder2 = clone;
            ArrayList arrayList5 = arrayList;
            ArrayList arrayList6 = new ArrayList(this.deserializationStrategies);
            excluder2.deserializationStrategies = arrayList5;
            boolean add2 = clone.deserializationStrategies.add(exclusionStrategy2);
        }
        return clone;
    }

    public Excluder withModifiers(int... iArr) {
        int[] iArr2 = iArr;
        Excluder clone = clone();
        clone.modifiers = 0;
        int length = iArr2.length;
        for (int i = 0; i < length; i++) {
            clone.modifiers = iArr2[i] | clone.modifiers;
        }
        return clone;
    }

    public Excluder withVersion(double d) {
        double d2 = d;
        Excluder clone = clone();
        clone.version = d2;
        return clone;
    }
}
