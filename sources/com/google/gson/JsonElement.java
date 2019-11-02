package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class JsonElement {
    public JsonElement() {
    }

    /* access modifiers changed from: 0000 */
    public abstract JsonElement deepCopy();

    public BigDecimal getAsBigDecimal() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public BigInteger getAsBigInteger() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public boolean getAsBoolean() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    /* access modifiers changed from: 0000 */
    public Boolean getAsBooleanWrapper() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public byte getAsByte() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public char getAsCharacter() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public double getAsDouble() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public float getAsFloat() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public int getAsInt() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public JsonArray getAsJsonArray() {
        IllegalStateException illegalStateException;
        if (isJsonArray()) {
            return (JsonArray) this;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("This is not a JSON Array.");
        throw illegalStateException2;
    }

    public JsonNull getAsJsonNull() {
        IllegalStateException illegalStateException;
        if (isJsonNull()) {
            return (JsonNull) this;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("This is not a JSON Null.");
        throw illegalStateException2;
    }

    public JsonObject getAsJsonObject() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        if (isJsonObject()) {
            return (JsonObject) this;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Not a JSON Object: ").append(this).toString());
        throw illegalStateException2;
    }

    public JsonPrimitive getAsJsonPrimitive() {
        IllegalStateException illegalStateException;
        if (isJsonPrimitive()) {
            return (JsonPrimitive) this;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("This is not a JSON Primitive.");
        throw illegalStateException2;
    }

    public long getAsLong() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public Number getAsNumber() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public short getAsShort() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public String getAsString() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(getClass().getSimpleName());
        throw unsupportedOperationException2;
    }

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }

    public String toString() {
        AssertionError assertionError;
        StringWriter stringWriter;
        JsonWriter jsonWriter;
        try {
            StringWriter stringWriter2 = stringWriter;
            StringWriter stringWriter3 = new StringWriter();
            StringWriter stringWriter4 = stringWriter2;
            JsonWriter jsonWriter2 = jsonWriter;
            JsonWriter jsonWriter3 = new JsonWriter(stringWriter4);
            JsonWriter jsonWriter4 = jsonWriter2;
            jsonWriter4.setLenient(true);
            Streams.write(this, jsonWriter4);
            return stringWriter4.toString();
        } catch (IOException e) {
            IOException iOException = e;
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError(iOException);
            throw assertionError2;
        }
    }
}
