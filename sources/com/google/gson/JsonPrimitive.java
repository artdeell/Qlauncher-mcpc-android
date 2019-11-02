package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
    private static final Class<?>[] PRIMITIVE_TYPES = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object value;

    public JsonPrimitive(Boolean bool) {
        setValue(bool);
    }

    public JsonPrimitive(Character ch) {
        setValue(ch);
    }

    public JsonPrimitive(Number number) {
        setValue(number);
    }

    JsonPrimitive(Object obj) {
        setValue(obj);
    }

    public JsonPrimitive(String str) {
        setValue(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if ((r3 instanceof java.lang.Byte) != false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isIntegral(com.google.gson.JsonPrimitive r6) {
        /*
            r0 = r6
            r5 = r0
            java.lang.Object r5 = r5.value
            boolean r5 = r5 instanceof java.lang.Number
            r1 = r5
            r5 = 0
            r2 = r5
            r5 = r1
            if (r5 == 0) goto L_0x0031
            r5 = r0
            java.lang.Object r5 = r5.value
            java.lang.Number r5 = (java.lang.Number) r5
            r3 = r5
            r5 = r3
            boolean r5 = r5 instanceof java.math.BigInteger
            if (r5 != 0) goto L_0x002f
            r5 = r3
            boolean r5 = r5 instanceof java.lang.Long
            if (r5 != 0) goto L_0x002f
            r5 = r3
            boolean r5 = r5 instanceof java.lang.Integer
            if (r5 != 0) goto L_0x002f
            r5 = r3
            boolean r5 = r5 instanceof java.lang.Short
            if (r5 != 0) goto L_0x002f
            r5 = r3
            boolean r5 = r5 instanceof java.lang.Byte
            r4 = r5
            r5 = 0
            r2 = r5
            r5 = r4
            if (r5 == 0) goto L_0x0031
        L_0x002f:
            r5 = 1
            r2 = r5
        L_0x0031:
            r5 = r2
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.JsonPrimitive.isIntegral(com.google.gson.JsonPrimitive):boolean");
    }

    private static boolean isPrimitiveOrString(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof String)) {
            Class cls = obj2.getClass();
            Class<?>[] clsArr = PRIMITIVE_TYPES;
            int length = clsArr.length;
            int i = 0;
            while (i < length) {
                if (!clsArr[i].isAssignableFrom(cls)) {
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public JsonPrimitive deepCopy() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008f, code lost:
        if (java.lang.Double.isNaN(r5) != false) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r10 = r0
            r11 = r1
            if (r10 != r11) goto L_0x0009
        L_0x0006:
            r10 = 1
            r0 = r10
        L_0x0008:
            return r0
        L_0x0009:
            r10 = r1
            if (r10 == 0) goto L_0x0018
            r10 = r0
            java.lang.Class r10 = r10.getClass()
            r11 = r1
            java.lang.Class r11 = r11.getClass()
            if (r10 == r11) goto L_0x001b
        L_0x0018:
            r10 = 0
            r0 = r10
            goto L_0x0008
        L_0x001b:
            r10 = r1
            com.google.gson.JsonPrimitive r10 = (com.google.gson.JsonPrimitive) r10
            r2 = r10
            r10 = r0
            java.lang.Object r10 = r10.value
            if (r10 != 0) goto L_0x002c
            r10 = r2
            java.lang.Object r10 = r10.value
            if (r10 == 0) goto L_0x0006
            r10 = 0
            r0 = r10
            goto L_0x0008
        L_0x002c:
            r10 = r0
            boolean r10 = isIntegral(r10)
            if (r10 == 0) goto L_0x0053
            r10 = r2
            boolean r10 = isIntegral(r10)
            if (r10 == 0) goto L_0x0053
            r10 = r0
            java.lang.Number r10 = r10.getAsNumber()
            long r10 = r10.longValue()
            r12 = r2
            java.lang.Number r12 = r12.getAsNumber()
            long r12 = r12.longValue()
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L_0x0006
            r10 = 0
            r0 = r10
            goto L_0x0008
        L_0x0053:
            r10 = r0
            java.lang.Object r10 = r10.value
            boolean r10 = r10 instanceof java.lang.Number
            if (r10 == 0) goto L_0x0097
            r10 = r2
            java.lang.Object r10 = r10.value
            boolean r10 = r10 instanceof java.lang.Number
            if (r10 == 0) goto L_0x0097
            r10 = r0
            java.lang.Number r10 = r10.getAsNumber()
            double r10 = r10.doubleValue()
            r3 = r10
            r10 = r2
            java.lang.Number r10 = r10.getAsNumber()
            double r10 = r10.doubleValue()
            r5 = r10
            r10 = r3
            r12 = r5
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L_0x0091
            r10 = r3
            boolean r10 = java.lang.Double.isNaN(r10)
            r8 = r10
            r10 = 0
            r7 = r10
            r10 = r8
            if (r10 == 0) goto L_0x0093
            r10 = r5
            boolean r10 = java.lang.Double.isNaN(r10)
            r9 = r10
            r10 = 0
            r7 = r10
            r10 = r9
            if (r10 == 0) goto L_0x0093
        L_0x0091:
            r10 = 1
            r7 = r10
        L_0x0093:
            r10 = r7
            r0 = r10
            goto L_0x0008
        L_0x0097:
            r10 = r0
            java.lang.Object r10 = r10.value
            r11 = r2
            java.lang.Object r11 = r11.value
            boolean r10 = r10.equals(r11)
            r0 = r10
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.JsonPrimitive.equals(java.lang.Object):boolean");
    }

    public BigDecimal getAsBigDecimal() {
        BigDecimal bigDecimal;
        if (this.value instanceof BigDecimal) {
            return (BigDecimal) this.value;
        }
        BigDecimal bigDecimal2 = bigDecimal;
        BigDecimal bigDecimal3 = new BigDecimal(this.value.toString());
        return bigDecimal2;
    }

    public BigInteger getAsBigInteger() {
        BigInteger bigInteger;
        if (this.value instanceof BigInteger) {
            return (BigInteger) this.value;
        }
        BigInteger bigInteger2 = bigInteger;
        BigInteger bigInteger3 = new BigInteger(this.value.toString());
        return bigInteger2;
    }

    public boolean getAsBoolean() {
        return isBoolean() ? getAsBooleanWrapper().booleanValue() : Boolean.parseBoolean(getAsString());
    }

    /* access modifiers changed from: 0000 */
    public Boolean getAsBooleanWrapper() {
        return (Boolean) this.value;
    }

    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    public Number getAsNumber() {
        LazilyParsedNumber lazilyParsedNumber;
        if (!(this.value instanceof String)) {
            return (Number) this.value;
        }
        LazilyParsedNumber lazilyParsedNumber2 = lazilyParsedNumber;
        LazilyParsedNumber lazilyParsedNumber3 = new LazilyParsedNumber((String) this.value);
        return lazilyParsedNumber2;
    }

    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    public String getAsString() {
        return isNumber() ? getAsNumber().toString() : isBoolean() ? getAsBooleanWrapper().toString() : (String) this.value;
    }

    public int hashCode() {
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            long longValue = getAsNumber().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.value instanceof Number)) {
            return this.value.hashCode();
        } else {
            long doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    /* access modifiers changed from: 0000 */
    public void setValue(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof Character) {
            this.value = String.valueOf(((Character) obj2).charValue());
            return;
        }
        C$Gson$Preconditions.checkArgument((obj2 instanceof Number) || isPrimitiveOrString(obj2));
        this.value = obj2;
    }
}
