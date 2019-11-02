package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map.Entry;
import java.util.Set;

public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members;

    public JsonObject() {
        LinkedTreeMap<String, JsonElement> linkedTreeMap;
        LinkedTreeMap<String, JsonElement> linkedTreeMap2 = linkedTreeMap;
        LinkedTreeMap<String, JsonElement> linkedTreeMap3 = new LinkedTreeMap<>();
        this.members = linkedTreeMap2;
    }

    private JsonElement createJsonElement(Object obj) {
        JsonPrimitive jsonPrimitive;
        Object obj2 = obj;
        if (obj2 == null) {
            return JsonNull.INSTANCE;
        }
        JsonPrimitive jsonPrimitive2 = jsonPrimitive;
        JsonPrimitive jsonPrimitive3 = new JsonPrimitive(obj2);
        return jsonPrimitive2;
    }

    public void add(String str, JsonElement jsonElement) {
        String str2 = str;
        JsonElement jsonElement2 = jsonElement;
        if (jsonElement2 == null) {
            jsonElement2 = JsonNull.INSTANCE;
        }
        Object put = this.members.put(str2, jsonElement2);
    }

    public void addProperty(String str, Boolean bool) {
        add(str, createJsonElement(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, createJsonElement(ch));
    }

    public void addProperty(String str, Number number) {
        add(str, createJsonElement(number));
    }

    public void addProperty(String str, String str2) {
        add(str, createJsonElement(str2));
    }

    /* access modifiers changed from: 0000 */
    public JsonObject deepCopy() {
        JsonObject jsonObject;
        JsonObject jsonObject2 = jsonObject;
        JsonObject jsonObject3 = new JsonObject();
        JsonObject jsonObject4 = jsonObject2;
        for (Entry entry : this.members.entrySet()) {
            jsonObject4.add((String) entry.getKey(), ((JsonElement) entry.getValue()).deepCopy());
        }
        return jsonObject4;
    }

    public Set<Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return obj2 == this || ((obj2 instanceof JsonObject) && ((JsonObject) obj2).members.equals(this.members));
    }

    public JsonElement get(String str) {
        return (JsonElement) this.members.get(str);
    }

    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.members.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.members.get(str);
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.members.get(str);
    }

    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public JsonElement remove(String str) {
        return (JsonElement) this.members.remove(str);
    }
}
