package com.google.gson;

public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE;

    static {
        JsonNull jsonNull;
        JsonNull jsonNull2 = jsonNull;
        JsonNull jsonNull3 = new JsonNull();
        INSTANCE = jsonNull2;
    }

    @Deprecated
    public JsonNull() {
    }

    /* access modifiers changed from: 0000 */
    public JsonNull deepCopy() {
        return INSTANCE;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return this == obj2 || (obj2 instanceof JsonNull);
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }
}
