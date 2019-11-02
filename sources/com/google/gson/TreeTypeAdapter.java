package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    private final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    private static class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        private SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            Object obj2 = obj;
            TypeToken<?> typeToken2 = typeToken;
            boolean z2 = z;
            Class<?> cls2 = cls;
            this.serializer = obj2 instanceof JsonSerializer ? (JsonSerializer) obj2 : null;
            this.deserializer = obj2 instanceof JsonDeserializer ? (JsonDeserializer) obj2 : null;
            C$Gson$Preconditions.checkArgument((this.serializer == null && this.deserializer == null) ? false : true);
            this.exactType = typeToken2;
            this.matchRawType = z2;
            this.hierarchyType = cls2;
        }

        /* synthetic */ SingleTypeFactory(Object obj, TypeToken typeToken, boolean z, Class cls, C04681 r16) {
            C04681 r5 = r16;
            this(obj, typeToken, z, cls);
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            TreeTypeAdapter treeTypeAdapter;
            Gson gson2 = gson;
            TypeToken<T> typeToken2 = typeToken;
            boolean isAssignableFrom = this.exactType != null ? this.exactType.equals(typeToken2) || (this.matchRawType && this.exactType.getType() == typeToken2.getRawType()) : this.hierarchyType.isAssignableFrom(typeToken2.getRawType());
            if (!isAssignableFrom) {
                return null;
            }
            TreeTypeAdapter treeTypeAdapter2 = treeTypeAdapter;
            TreeTypeAdapter treeTypeAdapter3 = new TreeTypeAdapter(this.serializer, this.deserializer, gson2, typeToken2, this, null);
            return treeTypeAdapter2;
        }
    }

    private TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson2, TypeToken<T> typeToken2, TypeAdapterFactory typeAdapterFactory) {
        JsonDeserializer<T> jsonDeserializer2 = jsonDeserializer;
        Gson gson3 = gson2;
        TypeToken<T> typeToken3 = typeToken2;
        TypeAdapterFactory typeAdapterFactory2 = typeAdapterFactory;
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer2;
        this.gson = gson3;
        this.typeToken = typeToken3;
        this.skipPast = typeAdapterFactory2;
    }

    /* synthetic */ TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson2, TypeToken typeToken2, TypeAdapterFactory typeAdapterFactory, C04681 r19) {
        C04681 r6 = r19;
        this(jsonSerializer, jsonDeserializer, gson2, typeToken2, typeAdapterFactory);
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken2, Object obj) {
        SingleTypeFactory singleTypeFactory;
        SingleTypeFactory singleTypeFactory2 = singleTypeFactory;
        SingleTypeFactory singleTypeFactory3 = new SingleTypeFactory(obj, typeToken2, false, null, null);
        return singleTypeFactory2;
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken2, Object obj) {
        SingleTypeFactory singleTypeFactory;
        TypeToken<?> typeToken3 = typeToken2;
        SingleTypeFactory singleTypeFactory2 = singleTypeFactory;
        SingleTypeFactory singleTypeFactory3 = new SingleTypeFactory(obj, typeToken3, typeToken3.getType() == typeToken3.getRawType(), null, null);
        return singleTypeFactory2;
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> cls, Object obj) {
        SingleTypeFactory singleTypeFactory;
        SingleTypeFactory singleTypeFactory2 = singleTypeFactory;
        SingleTypeFactory singleTypeFactory3 = new SingleTypeFactory(obj, null, false, cls, null);
        return singleTypeFactory2;
    }

    public T read(JsonReader jsonReader) throws IOException {
        JsonReader jsonReader2 = jsonReader;
        if (this.deserializer == null) {
            return delegate().read(jsonReader2);
        }
        JsonElement parse = Streams.parse(jsonReader2);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(parse, this.typeToken.getType(), this.gson.deserializationContext);
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonWriter jsonWriter2 = jsonWriter;
        T t2 = t;
        if (this.serializer == null) {
            delegate().write(jsonWriter2, t2);
        } else if (t2 == null) {
            JsonWriter nullValue = jsonWriter2.nullValue();
        } else {
            Streams.write(this.serializer.serialize(t2, this.typeToken.getType(), this.gson.serializationContext), jsonWriter2);
        }
    }
}
