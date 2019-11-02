package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final ObjectConstructor<? extends Collection<E>> constructor;
        private final TypeAdapter<E> elementTypeAdapter;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper;
            ObjectConstructor<? extends Collection<E>> objectConstructor2 = objectConstructor;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper2 = typeAdapterRuntimeTypeWrapper;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper3 = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.elementTypeAdapter = typeAdapterRuntimeTypeWrapper2;
            this.constructor = objectConstructor2;
        }

        public Collection<E> read(JsonReader jsonReader) throws IOException {
            JsonReader jsonReader2 = jsonReader;
            if (jsonReader2.peek() == JsonToken.NULL) {
                jsonReader2.nextNull();
                return null;
            }
            Collection collection = (Collection) this.constructor.construct();
            jsonReader2.beginArray();
            while (jsonReader2.hasNext()) {
                boolean add = collection.add(this.elementTypeAdapter.read(jsonReader2));
            }
            jsonReader2.endArray();
            return collection;
        }

        public void write(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            JsonWriter jsonWriter2 = jsonWriter;
            Collection<E> collection2 = collection;
            if (collection2 == null) {
                JsonWriter nullValue = jsonWriter2.nullValue();
                return;
            }
            JsonWriter beginArray = jsonWriter2.beginArray();
            for (E write : collection2) {
                this.elementTypeAdapter.write(jsonWriter2, write);
            }
            JsonWriter endArray = jsonWriter2.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Adapter adapter;
        Gson gson2 = gson;
        TypeToken<T> typeToken2 = typeToken;
        Type type = typeToken2.getType();
        Class rawType = typeToken2.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = C$Gson$Types.getCollectionElementType(type, rawType);
        Adapter adapter2 = adapter;
        Adapter adapter3 = new Adapter(gson2, collectionElementType, gson2.getAdapter(TypeToken.get(collectionElementType)), this.constructorConstructor.get(typeToken2));
        return adapter2;
    }
}
