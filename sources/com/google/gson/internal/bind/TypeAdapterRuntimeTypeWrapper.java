package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type2) {
        TypeAdapter<T> typeAdapter2 = typeAdapter;
        Type type3 = type2;
        this.context = gson;
        this.delegate = typeAdapter2;
        this.type = type3;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type type2, Object obj) {
        Type type3 = type2;
        Object obj2 = obj;
        if (obj2 != null && (type3 == Object.class || (type3 instanceof TypeVariable) || (type3 instanceof Class))) {
            type3 = obj2.getClass();
        }
        return type3;
    }

    public T read(JsonReader jsonReader) throws IOException {
        return this.delegate.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonWriter jsonWriter2 = jsonWriter;
        T t2 = t;
        TypeAdapter<T> typeAdapter = this.delegate;
        Type runtimeTypeIfMoreSpecific = getRuntimeTypeIfMoreSpecific(this.type, t2);
        if (runtimeTypeIfMoreSpecific != this.type) {
            TypeAdapter<T> adapter = this.context.getAdapter(TypeToken.get(runtimeTypeIfMoreSpecific));
            typeAdapter = !(adapter instanceof Adapter) ? adapter : !(this.delegate instanceof Adapter) ? this.delegate : adapter;
        }
        typeAdapter.write(jsonWriter2, t2);
    }
}
