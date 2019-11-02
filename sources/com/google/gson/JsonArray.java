package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final List<JsonElement> elements;

    public JsonArray() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.elements = arrayList2;
    }

    public void add(JsonElement jsonElement) {
        JsonElement jsonElement2 = jsonElement;
        if (jsonElement2 == null) {
            jsonElement2 = JsonNull.INSTANCE;
        }
        boolean add = this.elements.add(jsonElement2);
    }

    public void addAll(JsonArray jsonArray) {
        boolean addAll = this.elements.addAll(jsonArray.elements);
    }

    /* access modifiers changed from: 0000 */
    public JsonArray deepCopy() {
        JsonArray jsonArray;
        JsonArray jsonArray2 = jsonArray;
        JsonArray jsonArray3 = new JsonArray();
        JsonArray jsonArray4 = jsonArray2;
        for (JsonElement deepCopy : this.elements) {
            jsonArray4.add(deepCopy.deepCopy());
        }
        return jsonArray4;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return obj2 == this || ((obj2 instanceof JsonArray) && ((JsonArray) obj2).elements.equals(this.elements));
    }

    public JsonElement get(int i) {
        return (JsonElement) this.elements.get(i);
    }

    public BigDecimal getAsBigDecimal() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsBigDecimal();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public BigInteger getAsBigInteger() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsBigInteger();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public boolean getAsBoolean() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsBoolean();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public byte getAsByte() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsByte();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public char getAsCharacter() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsCharacter();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public double getAsDouble() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsDouble();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public float getAsFloat() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsFloat();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public int getAsInt() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsInt();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public long getAsLong() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsLong();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public Number getAsNumber() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsNumber();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public short getAsShort() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsShort();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public String getAsString() {
        IllegalStateException illegalStateException;
        if (this.elements.size() == 1) {
            return ((JsonElement) this.elements.get(0)).getAsString();
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException();
        throw illegalStateException2;
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public int size() {
        return this.elements.size();
    }
}
