package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class JsonTreeReader extends JsonReader {
    private static final Object SENTINEL_CLOSED;
    private static final Reader UNREADABLE_READER;
    private final List<Object> stack;

    static {
        C04931 r2;
        Object obj;
        C04931 r0 = r2;
        C04931 r1 = new Reader() {
            public void close() throws IOException {
                AssertionError assertionError;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }

            public int read(char[] cArr, int i, int i2) throws IOException {
                AssertionError assertionError;
                char[] cArr2 = cArr;
                int i3 = i;
                int i4 = i2;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
        };
        UNREADABLE_READER = r0;
        Object obj2 = obj;
        Object obj3 = new Object();
        SENTINEL_CLOSED = obj2;
    }

    public JsonTreeReader(JsonElement jsonElement) {
        ArrayList arrayList;
        JsonElement jsonElement2 = jsonElement;
        super(UNREADABLE_READER);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.stack = arrayList2;
        boolean add = this.stack.add(jsonElement2);
    }

    private void expect(JsonToken jsonToken) throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        JsonToken jsonToken2 = jsonToken;
        if (peek() != jsonToken2) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected ").append(jsonToken2).append(" but was ").append(peek()).toString());
            throw illegalStateException2;
        }
    }

    private Object peekStack() {
        return this.stack.get(-1 + this.stack.size());
    }

    private Object popStack() {
        return this.stack.remove(-1 + this.stack.size());
    }

    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        boolean add = this.stack.add(((JsonArray) peekStack()).iterator());
    }

    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
        boolean add = this.stack.add(((JsonObject) peekStack()).entrySet().iterator());
    }

    public void close() throws IOException {
        this.stack.clear();
        boolean add = this.stack.add(SENTINEL_CLOSED);
    }

    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
        Object popStack = popStack();
        Object popStack2 = popStack();
    }

    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
        Object popStack = popStack();
        Object popStack2 = popStack();
    }

    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    public boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        return ((JsonPrimitive) popStack()).getAsBoolean();
    }

    public double nextDouble() throws IOException {
        NumberFormatException numberFormatException;
        StringBuilder sb;
        IllegalStateException illegalStateException;
        StringBuilder sb2;
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            double asDouble = ((JsonPrimitive) peekStack()).getAsDouble();
            if (isLenient() || (!Double.isNaN(asDouble) && !Double.isInfinite(asDouble))) {
                Object popStack = popStack();
                return asDouble;
            }
            NumberFormatException numberFormatException2 = numberFormatException;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            NumberFormatException numberFormatException3 = new NumberFormatException(sb3.append("JSON forbids NaN and infinities: ").append(asDouble).toString());
            throw numberFormatException2;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb5.append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(peek).toString());
        throw illegalStateException2;
    }

    public int nextInt() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            int asInt = ((JsonPrimitive) peekStack()).getAsInt();
            Object popStack = popStack();
            return asInt;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(peek).toString());
        throw illegalStateException2;
    }

    public long nextLong() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            long asLong = ((JsonPrimitive) peekStack()).getAsLong();
            Object popStack = popStack();
            return asLong;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(peek).toString());
        throw illegalStateException2;
    }

    public String nextName() throws IOException {
        expect(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) peekStack()).next();
        boolean add = this.stack.add(entry.getValue());
        return (String) entry.getKey();
    }

    public void nextNull() throws IOException {
        expect(JsonToken.NULL);
        Object popStack = popStack();
    }

    public String nextString() throws IOException {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        JsonToken peek = peek();
        if (peek == JsonToken.STRING || peek == JsonToken.NUMBER) {
            return ((JsonPrimitive) popStack()).getAsString();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected ").append(JsonToken.STRING).append(" but was ").append(peek).toString());
        throw illegalStateException2;
    }

    public JsonToken peek() throws IOException {
        AssertionError assertionError;
        IllegalStateException illegalStateException;
        AssertionError assertionError2;
        if (this.stack.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Object peekStack = peekStack();
        if (peekStack instanceof Iterator) {
            boolean z = this.stack.get(-2 + this.stack.size()) instanceof JsonObject;
            Iterator it = (Iterator) peekStack;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            boolean add = this.stack.add(it.next());
            return peek();
        } else if (peekStack instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (peekStack instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (peekStack instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) peekStack;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                AssertionError assertionError3 = assertionError2;
                AssertionError assertionError4 = new AssertionError();
                throw assertionError3;
            } else if (peekStack instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (peekStack == SENTINEL_CLOSED) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    IllegalStateException illegalStateException3 = new IllegalStateException("JsonReader is closed");
                    throw illegalStateException2;
                }
                AssertionError assertionError5 = assertionError;
                AssertionError assertionError6 = new AssertionError();
                throw assertionError5;
            }
        }
    }

    public void promoteNameToValue() throws IOException {
        JsonPrimitive jsonPrimitive;
        expect(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) peekStack()).next();
        boolean add = this.stack.add(entry.getValue());
        List<Object> list = this.stack;
        JsonPrimitive jsonPrimitive2 = jsonPrimitive;
        JsonPrimitive jsonPrimitive3 = new JsonPrimitive((String) entry.getKey());
        boolean add2 = list.add(jsonPrimitive2);
    }

    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            String nextName = nextName();
        } else {
            Object popStack = popStack();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
