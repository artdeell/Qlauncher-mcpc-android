package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String str) {
        this.value = str;
    }

    private Object writeReplace() throws ObjectStreamException {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2 = bigDecimal;
        BigDecimal bigDecimal3 = new BigDecimal(this.value);
        return bigDecimal2;
    }

    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    public int intValue() {
        BigDecimal bigDecimal;
        try {
            return Integer.parseInt(this.value);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            try {
                return (int) Long.parseLong(this.value);
            } catch (NumberFormatException e2) {
                NumberFormatException numberFormatException2 = e2;
                BigDecimal bigDecimal2 = bigDecimal;
                BigDecimal bigDecimal3 = new BigDecimal(this.value);
                return bigDecimal2.intValue();
            }
        }
    }

    public long longValue() {
        BigDecimal bigDecimal;
        try {
            return Long.parseLong(this.value);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            BigDecimal bigDecimal2 = bigDecimal;
            BigDecimal bigDecimal3 = new BigDecimal(this.value);
            return bigDecimal2.longValue();
        }
    }

    public String toString() {
        return this.value;
    }
}
