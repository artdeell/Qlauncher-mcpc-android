package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    /* access modifiers changed from: private */
    public final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final ObjectConstructor<? extends Map<K, V>> constructor;
        private final TypeAdapter<K> keyTypeAdapter;
        final /* synthetic */ MapTypeAdapterFactory this$0;
        private final TypeAdapter<V> valueTypeAdapter;

        public Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper2;
            Gson gson2 = gson;
            Type type3 = type;
            TypeAdapter<K> typeAdapter3 = typeAdapter;
            Type type4 = type2;
            TypeAdapter<V> typeAdapter4 = typeAdapter2;
            ObjectConstructor<? extends Map<K, V>> objectConstructor2 = objectConstructor;
            this.this$0 = mapTypeAdapterFactory;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper3 = typeAdapterRuntimeTypeWrapper;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper4 = new TypeAdapterRuntimeTypeWrapper(gson2, typeAdapter3, type3);
            this.keyTypeAdapter = typeAdapterRuntimeTypeWrapper3;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper5 = typeAdapterRuntimeTypeWrapper2;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper6 = new TypeAdapterRuntimeTypeWrapper(gson2, typeAdapter4, type4);
            this.valueTypeAdapter = typeAdapterRuntimeTypeWrapper5;
            this.constructor = objectConstructor2;
        }

        private String keyToString(JsonElement jsonElement) {
            AssertionError assertionError;
            AssertionError assertionError2;
            JsonElement jsonElement2 = jsonElement;
            if (jsonElement2.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement2.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    return String.valueOf(asJsonPrimitive.getAsNumber());
                }
                if (asJsonPrimitive.isBoolean()) {
                    return Boolean.toString(asJsonPrimitive.getAsBoolean());
                }
                if (asJsonPrimitive.isString()) {
                    return asJsonPrimitive.getAsString();
                }
                AssertionError assertionError3 = assertionError2;
                AssertionError assertionError4 = new AssertionError();
                throw assertionError3;
            } else if (jsonElement2.isJsonNull()) {
                return "null";
            } else {
                AssertionError assertionError5 = assertionError;
                AssertionError assertionError6 = new AssertionError();
                throw assertionError5;
            }
        }

        public Map<K, V> read(JsonReader jsonReader) throws IOException {
            JsonSyntaxException jsonSyntaxException;
            StringBuilder sb;
            JsonSyntaxException jsonSyntaxException2;
            StringBuilder sb2;
            JsonReader jsonReader2 = jsonReader;
            JsonToken peek = jsonReader2.peek();
            if (peek == JsonToken.NULL) {
                jsonReader2.nextNull();
                return null;
            }
            Map map = (Map) this.constructor.construct();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader2.beginArray();
                while (jsonReader2.hasNext()) {
                    jsonReader2.beginArray();
                    Object read = this.keyTypeAdapter.read(jsonReader2);
                    if (map.put(read, this.valueTypeAdapter.read(jsonReader2)) != null) {
                        JsonSyntaxException jsonSyntaxException3 = jsonSyntaxException2;
                        StringBuilder sb3 = sb2;
                        StringBuilder sb4 = new StringBuilder();
                        JsonSyntaxException jsonSyntaxException4 = new JsonSyntaxException(sb3.append("duplicate key: ").append(read).toString());
                        throw jsonSyntaxException3;
                    }
                    jsonReader2.endArray();
                }
                jsonReader2.endArray();
                return map;
            }
            jsonReader2.beginObject();
            while (jsonReader2.hasNext()) {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader2);
                Object read2 = this.keyTypeAdapter.read(jsonReader2);
                if (map.put(read2, this.valueTypeAdapter.read(jsonReader2)) != null) {
                    JsonSyntaxException jsonSyntaxException5 = jsonSyntaxException;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    JsonSyntaxException jsonSyntaxException6 = new JsonSyntaxException(sb5.append("duplicate key: ").append(read2).toString());
                    throw jsonSyntaxException5;
                }
            }
            jsonReader2.endObject();
            return map;
        }

        public void write(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            ArrayList arrayList;
            ArrayList arrayList2;
            JsonWriter jsonWriter2 = jsonWriter;
            Map<K, V> map2 = map;
            if (map2 == null) {
                JsonWriter nullValue = jsonWriter2.nullValue();
                return;
            }
            if (!this.this$0.complexMapKeySerialization) {
                JsonWriter beginObject = jsonWriter2.beginObject();
                for (Entry entry : map2.entrySet()) {
                    JsonWriter name = jsonWriter2.name(String.valueOf(entry.getKey()));
                    this.valueTypeAdapter.write(jsonWriter2, entry.getValue());
                }
                JsonWriter endObject = jsonWriter2.endObject();
                return;
            }
            boolean z = false;
            ArrayList arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList(map2.size());
            ArrayList arrayList5 = arrayList3;
            ArrayList arrayList6 = arrayList2;
            ArrayList arrayList7 = new ArrayList(map2.size());
            ArrayList arrayList8 = arrayList6;
            for (Entry entry2 : map2.entrySet()) {
                JsonElement jsonTree = this.keyTypeAdapter.toJsonTree(entry2.getKey());
                boolean add = arrayList5.add(jsonTree);
                boolean add2 = arrayList8.add(entry2.getValue());
                z |= jsonTree.isJsonArray() || jsonTree.isJsonObject();
            }
            if (z) {
                JsonWriter beginArray = jsonWriter2.beginArray();
                for (int i = 0; i < arrayList5.size(); i++) {
                    JsonWriter beginArray2 = jsonWriter2.beginArray();
                    Streams.write((JsonElement) arrayList5.get(i), jsonWriter2);
                    this.valueTypeAdapter.write(jsonWriter2, arrayList8.get(i));
                    JsonWriter endArray = jsonWriter2.endArray();
                }
                JsonWriter endArray2 = jsonWriter2.endArray();
                return;
            }
            JsonWriter beginObject2 = jsonWriter2.beginObject();
            for (int i2 = 0; i2 < arrayList5.size(); i2++) {
                JsonWriter name2 = jsonWriter2.name(keyToString((JsonElement) arrayList5.get(i2)));
                this.valueTypeAdapter.write(jsonWriter2, arrayList8.get(i2));
            }
            JsonWriter endObject2 = jsonWriter2.endObject();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor2, boolean z) {
        boolean z2 = z;
        this.constructorConstructor = constructorConstructor2;
        this.complexMapKeySerialization = z2;
    }

    private TypeAdapter<?> getKeyAdapter(Gson gson, Type type) {
        Type type2 = type;
        return (type2 == Boolean.TYPE || type2 == Boolean.class) ? TypeAdapters.BOOLEAN_AS_STRING : gson.getAdapter(TypeToken.get(type2));
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Adapter adapter;
        Gson gson2 = gson;
        TypeToken<T> typeToken2 = typeToken;
        Type type = typeToken2.getType();
        if (!Map.class.isAssignableFrom(typeToken2.getRawType())) {
            return null;
        }
        Type[] mapKeyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, C$Gson$Types.getRawType(type));
        Adapter adapter2 = adapter;
        Adapter adapter3 = new Adapter(this, gson2, mapKeyAndValueTypes[0], getKeyAdapter(gson2, mapKeyAndValueTypes[0]), mapKeyAndValueTypes[1], gson2.getAdapter(TypeToken.get(mapKeyAndValueTypes[1])), this.constructorConstructor.get(typeToken2));
        return adapter2;
    }
}
