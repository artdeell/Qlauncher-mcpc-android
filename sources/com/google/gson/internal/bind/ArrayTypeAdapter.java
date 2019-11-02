package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY;
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    static {
        C04911 r2;
        C04911 r0 = r2;
        C04911 r1 = new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                ArrayTypeAdapter arrayTypeAdapter;
                Gson gson2 = gson;
                Type type = typeToken.getType();
                if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                    return null;
                }
                Type arrayComponentType = C$Gson$Types.getArrayComponentType(type);
                ArrayTypeAdapter arrayTypeAdapter2 = arrayTypeAdapter;
                ArrayTypeAdapter arrayTypeAdapter3 = new ArrayTypeAdapter(gson2, gson2.getAdapter(TypeToken.get(arrayComponentType)), C$Gson$Types.getRawType(arrayComponentType));
                return arrayTypeAdapter2;
            }
        };
        FACTORY = r0;
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper;
        Class<E> cls2 = cls;
        TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper2 = typeAdapterRuntimeTypeWrapper;
        TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper3 = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls2);
        this.componentTypeAdapter = typeAdapterRuntimeTypeWrapper2;
        this.componentType = cls2;
    }

    public Object read(JsonReader jsonReader) throws IOException {
        ArrayList arrayList;
        Object newInstance;
        JsonReader jsonReader2 = jsonReader;
        if (jsonReader2.peek() == JsonToken.NULL) {
            jsonReader2.nextNull();
            newInstance = null;
        } else {
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            jsonReader2.beginArray();
            while (jsonReader2.hasNext()) {
                boolean add = arrayList4.add(this.componentTypeAdapter.read(jsonReader2));
            }
            jsonReader2.endArray();
            newInstance = Array.newInstance(this.componentType, arrayList4.size());
            for (int i = 0; i < arrayList4.size(); i++) {
                Array.set(newInstance, i, arrayList4.get(i));
            }
        }
        return newInstance;
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        JsonWriter jsonWriter2 = jsonWriter;
        Object obj2 = obj;
        if (obj2 == null) {
            JsonWriter nullValue = jsonWriter2.nullValue();
            return;
        }
        JsonWriter beginArray = jsonWriter2.beginArray();
        int length = Array.getLength(obj2);
        for (int i = 0; i < length; i++) {
            this.componentTypeAdapter.write(jsonWriter2, Array.get(obj2, i));
        }
        JsonWriter endArray = jsonWriter2.endArray();
    }
}
