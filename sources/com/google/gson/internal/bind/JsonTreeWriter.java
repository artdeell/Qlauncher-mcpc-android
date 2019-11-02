package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter {
    private static final JsonPrimitive SENTINEL_CLOSED;
    private static final Writer UNWRITABLE_WRITER;
    private String pendingName;
    private JsonElement product = JsonNull.INSTANCE;
    private final List<JsonElement> stack;

    static {
        C04941 r3;
        JsonPrimitive jsonPrimitive;
        C04941 r0 = r3;
        C04941 r1 = new Writer() {
            public void close() throws IOException {
                AssertionError assertionError;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }

            public void flush() throws IOException {
                AssertionError assertionError;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }

            public void write(char[] cArr, int i, int i2) {
                AssertionError assertionError;
                char[] cArr2 = cArr;
                int i3 = i;
                int i4 = i2;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
        };
        UNWRITABLE_WRITER = r0;
        JsonPrimitive jsonPrimitive2 = jsonPrimitive;
        JsonPrimitive jsonPrimitive3 = new JsonPrimitive("closed");
        SENTINEL_CLOSED = jsonPrimitive2;
    }

    public JsonTreeWriter() {
        ArrayList arrayList;
        super(UNWRITABLE_WRITER);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.stack = arrayList2;
    }

    private JsonElement peek() {
        return (JsonElement) this.stack.get(-1 + this.stack.size());
    }

    private void put(JsonElement jsonElement) {
        IllegalStateException illegalStateException;
        JsonElement jsonElement2 = jsonElement;
        if (this.pendingName != null) {
            if (!jsonElement2.isJsonNull() || getSerializeNulls()) {
                ((JsonObject) peek()).add(this.pendingName, jsonElement2);
            }
            this.pendingName = null;
        } else if (this.stack.isEmpty()) {
            this.product = jsonElement2;
        } else {
            JsonElement peek = peek();
            if (peek instanceof JsonArray) {
                ((JsonArray) peek).add(jsonElement2);
                return;
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException();
            throw illegalStateException2;
        }
    }

    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray;
        JsonArray jsonArray2 = jsonArray;
        JsonArray jsonArray3 = new JsonArray();
        JsonArray jsonArray4 = jsonArray2;
        put(jsonArray4);
        boolean add = this.stack.add(jsonArray4);
        return this;
    }

    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject;
        JsonObject jsonObject2 = jsonObject;
        JsonObject jsonObject3 = new JsonObject();
        JsonObject jsonObject4 = jsonObject2;
        put(jsonObject4);
        boolean add = this.stack.add(jsonObject4);
        return this;
    }

    public void close() throws IOException {
        IOException iOException;
        if (!this.stack.isEmpty()) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException("Incomplete document");
            throw iOException2;
        }
        boolean add = this.stack.add(SENTINEL_CLOSED);
    }

    public JsonWriter endArray() throws IOException {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        if (this.stack.isEmpty() || this.pendingName != null) {
            IllegalStateException illegalStateException3 = illegalStateException;
            IllegalStateException illegalStateException4 = new IllegalStateException();
            throw illegalStateException3;
        } else if (peek() instanceof JsonArray) {
            Object remove = this.stack.remove(-1 + this.stack.size());
            return this;
        } else {
            IllegalStateException illegalStateException5 = illegalStateException2;
            IllegalStateException illegalStateException6 = new IllegalStateException();
            throw illegalStateException5;
        }
    }

    public JsonWriter endObject() throws IOException {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        if (this.stack.isEmpty() || this.pendingName != null) {
            IllegalStateException illegalStateException3 = illegalStateException;
            IllegalStateException illegalStateException4 = new IllegalStateException();
            throw illegalStateException3;
        } else if (peek() instanceof JsonObject) {
            Object remove = this.stack.remove(-1 + this.stack.size());
            return this;
        } else {
            IllegalStateException illegalStateException5 = illegalStateException2;
            IllegalStateException illegalStateException6 = new IllegalStateException();
            throw illegalStateException5;
        }
    }

    public void flush() throws IOException {
    }

    public JsonElement get() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        if (this.stack.isEmpty()) {
            return this.product;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected one JSON element but was ").append(this.stack).toString());
        throw illegalStateException2;
    }

    public JsonWriter name(String str) throws IOException {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2;
        String str2 = str;
        if (this.stack.isEmpty() || this.pendingName != null) {
            IllegalStateException illegalStateException3 = illegalStateException;
            IllegalStateException illegalStateException4 = new IllegalStateException();
            throw illegalStateException3;
        } else if (peek() instanceof JsonObject) {
            this.pendingName = str2;
            return this;
        } else {
            IllegalStateException illegalStateException5 = illegalStateException2;
            IllegalStateException illegalStateException6 = new IllegalStateException();
            throw illegalStateException5;
        }
    }

    public JsonWriter nullValue() throws IOException {
        put(JsonNull.INSTANCE);
        return this;
    }

    public JsonWriter value(double d) throws IOException {
        JsonPrimitive jsonPrimitive;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        double d2 = d;
        if (isLenient() || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
            JsonPrimitive jsonPrimitive2 = jsonPrimitive;
            JsonPrimitive jsonPrimitive3 = new JsonPrimitive((Number) Double.valueOf(d2));
            put(jsonPrimitive2);
            return this;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("JSON forbids NaN and infinities: ").append(d2).toString());
        throw illegalArgumentException2;
    }

    public JsonWriter value(long j) throws IOException {
        JsonPrimitive jsonPrimitive;
        JsonPrimitive jsonPrimitive2 = jsonPrimitive;
        JsonPrimitive jsonPrimitive3 = new JsonPrimitive((Number) Long.valueOf(j));
        put(jsonPrimitive2);
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        JsonPrimitive jsonPrimitive;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Number number2 = number;
        if (number2 == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number2.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("JSON forbids NaN and infinities: ").append(number2).toString());
                throw illegalArgumentException2;
            }
        }
        JsonPrimitive jsonPrimitive2 = jsonPrimitive;
        JsonPrimitive jsonPrimitive3 = new JsonPrimitive(number2);
        put(jsonPrimitive2);
        return this;
    }

    public JsonWriter value(String str) throws IOException {
        JsonPrimitive jsonPrimitive;
        String str2 = str;
        if (str2 == null) {
            return nullValue();
        }
        JsonPrimitive jsonPrimitive2 = jsonPrimitive;
        JsonPrimitive jsonPrimitive3 = new JsonPrimitive(str2);
        put(jsonPrimitive2);
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        JsonPrimitive jsonPrimitive;
        JsonPrimitive jsonPrimitive2 = jsonPrimitive;
        JsonPrimitive jsonPrimitive3 = new JsonPrimitive(Boolean.valueOf(z));
        put(jsonPrimitive2);
        return this;
    }
}
