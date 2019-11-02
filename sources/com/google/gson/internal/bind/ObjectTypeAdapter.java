package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY;
    private final Gson gson;

    static {
        C04951 r2;
        C04951 r0 = r2;
        C04951 r1 = new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                ObjectTypeAdapter objectTypeAdapter;
                Gson gson2 = gson;
                if (typeToken.getRawType() != Object.class) {
                    return null;
                }
                ObjectTypeAdapter objectTypeAdapter2 = objectTypeAdapter;
                ObjectTypeAdapter objectTypeAdapter3 = new ObjectTypeAdapter(gson2, null);
                return objectTypeAdapter2;
            }
        };
        FACTORY = r0;
    }

    private ObjectTypeAdapter(Gson gson2) {
        this.gson = gson2;
    }

    /* synthetic */ ObjectTypeAdapter(Gson gson2, C04951 r7) {
        C04951 r2 = r7;
        this(gson2);
    }

    public Object read(JsonReader jsonReader) throws IOException {
        LinkedTreeMap linkedTreeMap;
        ArrayList arrayList;
        IllegalStateException illegalStateException;
        JsonReader jsonReader2 = jsonReader;
        switch (jsonReader2.peek()) {
            case BEGIN_ARRAY:
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = arrayList2;
                jsonReader2.beginArray();
                while (jsonReader2.hasNext()) {
                    boolean add = arrayList4.add(read(jsonReader2));
                }
                jsonReader2.endArray();
                return arrayList4;
            case BEGIN_OBJECT:
                LinkedTreeMap linkedTreeMap2 = linkedTreeMap;
                LinkedTreeMap linkedTreeMap3 = new LinkedTreeMap();
                LinkedTreeMap linkedTreeMap4 = linkedTreeMap2;
                jsonReader2.beginObject();
                while (jsonReader2.hasNext()) {
                    Object put = linkedTreeMap4.put(jsonReader2.nextName(), read(jsonReader2));
                }
                jsonReader2.endObject();
                return linkedTreeMap4;
            case STRING:
                return jsonReader2.nextString();
            case NUMBER:
                return Double.valueOf(jsonReader2.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(jsonReader2.nextBoolean());
            case NULL:
                jsonReader2.nextNull();
                return null;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException();
                throw illegalStateException2;
        }
    }

    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        JsonWriter jsonWriter2 = jsonWriter;
        Object obj2 = obj;
        if (obj2 == null) {
            JsonWriter nullValue = jsonWriter2.nullValue();
            return;
        }
        TypeAdapter adapter = this.gson.getAdapter(obj2.getClass());
        if (adapter instanceof ObjectTypeAdapter) {
            JsonWriter beginObject = jsonWriter2.beginObject();
            JsonWriter endObject = jsonWriter2.endObject();
            return;
        }
        adapter.write(jsonWriter2, obj2);
    }
}
