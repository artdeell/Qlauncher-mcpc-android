package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        private Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            Map<String, BoundField> map2 = map;
            this.constructor = objectConstructor;
            this.boundFields = map2;
        }

        /* synthetic */ Adapter(ObjectConstructor objectConstructor, Map map, C04971 r10) {
            C04971 r3 = r10;
            this(objectConstructor, map);
        }

        public T read(JsonReader jsonReader) throws IOException {
            AssertionError assertionError;
            JsonSyntaxException jsonSyntaxException;
            JsonReader jsonReader2 = jsonReader;
            if (jsonReader2.peek() == JsonToken.NULL) {
                jsonReader2.nextNull();
                return null;
            }
            Object construct = this.constructor.construct();
            try {
                jsonReader2.beginObject();
                while (jsonReader2.hasNext()) {
                    BoundField boundField = (BoundField) this.boundFields.get(jsonReader2.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader2.skipValue();
                    } else {
                        boundField.read(jsonReader2, construct);
                    }
                }
                jsonReader2.endObject();
                return construct;
            } catch (IllegalStateException e) {
                IllegalStateException illegalStateException = e;
                JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) illegalStateException);
                throw jsonSyntaxException2;
            } catch (IllegalAccessException e2) {
                IllegalAccessException illegalAccessException = e2;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError(illegalAccessException);
                throw assertionError2;
            }
        }

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            AssertionError assertionError;
            JsonWriter jsonWriter2 = jsonWriter;
            T t2 = t;
            if (t2 == null) {
                JsonWriter nullValue = jsonWriter2.nullValue();
                return;
            }
            JsonWriter beginObject = jsonWriter2.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.serialized) {
                        JsonWriter name = jsonWriter2.name(boundField.name);
                        boundField.write(jsonWriter2, t2);
                    }
                }
                JsonWriter endObject = jsonWriter2.endObject();
            } catch (IllegalAccessException e) {
                IllegalAccessException illegalAccessException = e;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
        }
    }

    static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        protected BoundField(String str, boolean z, boolean z2) {
            boolean z3 = z;
            boolean z4 = z2;
            this.name = str;
            this.serialized = z3;
            this.deserialized = z4;
        }

        /* access modifiers changed from: 0000 */
        public abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: 0000 */
        public abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor2, FieldNamingStrategy fieldNamingStrategy, Excluder excluder2) {
        FieldNamingStrategy fieldNamingStrategy2 = fieldNamingStrategy;
        Excluder excluder3 = excluder2;
        this.constructorConstructor = constructorConstructor2;
        this.fieldNamingPolicy = fieldNamingStrategy2;
        this.excluder = excluder3;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        C04971 r17;
        TypeToken<?> typeToken2 = typeToken;
        C04971 r7 = r17;
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        final Gson gson2 = gson;
        final TypeToken<?> typeToken3 = typeToken2;
        final Field field2 = field;
        final boolean isPrimitive = Primitives.isPrimitive(typeToken2.getRawType());
        C04971 r8 = new BoundField(this, str2, z3, z4) {
            final /* synthetic */ ReflectiveTypeAdapterFactory this$0;
            final TypeAdapter<?> typeAdapter = gson2.getAdapter(typeToken3);

            {
                String str = r15;
                boolean z = r16;
                boolean z2 = r17;
                Gson gson = r18;
                TypeToken typeToken = r19;
                Field field = r20;
                boolean z3 = r21;
                this.this$0 = r14;
            }

            /* access modifiers changed from: 0000 */
            public void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object obj2 = obj;
                Object read = this.typeAdapter.read(jsonReader);
                if (read != null || !isPrimitive) {
                    field2.set(obj2, read);
                }
            }

            /* access modifiers changed from: 0000 */
            public void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper;
                JsonWriter jsonWriter2 = jsonWriter;
                Object obj2 = field2.get(obj);
                TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper2 = typeAdapterRuntimeTypeWrapper;
                TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper3 = new TypeAdapterRuntimeTypeWrapper(gson2, this.typeAdapter, typeToken3.getType());
                typeAdapterRuntimeTypeWrapper2.write(jsonWriter2, obj2);
            }
        };
        return r7;
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        LinkedHashMap linkedHashMap;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Gson gson2 = gson;
        TypeToken<?> typeToken2 = typeToken;
        Class<?> cls2 = cls;
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = linkedHashMap2;
        if (!cls2.isInterface()) {
            Type type = typeToken2.getType();
            while (cls2 != Object.class) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                for (int i = 0; i < length; i++) {
                    Field field = declaredFields[i];
                    boolean excludeField = excludeField(field, true);
                    boolean excludeField2 = excludeField(field, false);
                    if (excludeField || excludeField2) {
                        field.setAccessible(true);
                        BoundField createBoundField = createBoundField(gson2, field, getFieldName(field), TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls2, field.getGenericType())), excludeField, excludeField2);
                        BoundField boundField = (BoundField) linkedHashMap4.put(createBoundField.name, createBoundField);
                        if (boundField != null) {
                            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                            StringBuilder sb2 = sb;
                            StringBuilder sb3 = new StringBuilder();
                            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append(type).append(" declares multiple JSON fields named ").append(boundField.name).toString());
                            throw illegalArgumentException2;
                        }
                    }
                }
                typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
                cls2 = typeToken2.getRawType();
            }
        }
        return linkedHashMap4;
    }

    private String getFieldName(Field field) {
        Field field2 = field;
        SerializedName serializedName = (SerializedName) field2.getAnnotation(SerializedName.class);
        return serializedName == null ? this.fieldNamingPolicy.translateName(field2) : serializedName.value();
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Adapter adapter;
        Gson gson2 = gson;
        TypeToken<T> typeToken2 = typeToken;
        Class rawType = typeToken2.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        Adapter adapter2 = adapter;
        Adapter adapter3 = new Adapter(this.constructorConstructor.get(typeToken2), getBoundFields(gson2, typeToken2, rawType), null);
        return adapter2;
    }

    public boolean excludeField(Field field, boolean z) {
        Field field2 = field;
        boolean z2 = z;
        return !this.excluder.excludeClass(field2.getType(), z2) && !this.excluder.excludeField(field2, z2);
    }
}
