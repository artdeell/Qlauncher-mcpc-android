package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

public final class TypeAdapters {
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY = newFactory(BitSet.class, BIT_SET);
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY = newFactory(Class.class, CLASS);
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY = newEnumTypeHierarchyFactory();
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, JSON_ELEMENT);
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY = newFactory(Locale.class, LOCALE);
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY = newFactory(Number.class, NUMBER);
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, STRING_BUFFER);
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, STRING_BUILDER);
    public static final TypeAdapterFactory STRING_FACTORY = newFactory(String.class, STRING);
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY = newFactory(URI.class, URI);
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY = newFactory(URL.class, URL);
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY = newFactory(UUID.class, UUID);

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$32 */
    static /* synthetic */ class C052632 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[JsonToken.values().length];

        static {
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
                NoSuchFieldError noSuchFieldError = e;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
                NoSuchFieldError noSuchFieldError2 = e2;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
                NoSuchFieldError noSuchFieldError3 = e3;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
                NoSuchFieldError noSuchFieldError4 = e4;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
                NoSuchFieldError noSuchFieldError5 = e5;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
                NoSuchFieldError noSuchFieldError6 = e6;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
                NoSuchFieldError noSuchFieldError7 = e7;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
                NoSuchFieldError noSuchFieldError8 = e8;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
                NoSuchFieldError noSuchFieldError9 = e9;
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
                NoSuchFieldError noSuchFieldError10 = e10;
            }
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<T, String> constantToName;
        private final Map<String, T> nameToConstant;

        public EnumTypeAdapter(Class<T> cls) {
            HashMap hashMap;
            HashMap hashMap2;
            AssertionError assertionError;
            Class<T> cls2 = cls;
            HashMap hashMap3 = hashMap;
            HashMap hashMap4 = new HashMap();
            this.nameToConstant = hashMap3;
            HashMap hashMap5 = hashMap2;
            HashMap hashMap6 = new HashMap();
            this.constantToName = hashMap5;
            try {
                Enum[] enumArr = (Enum[]) cls2.getEnumConstants();
                int length = enumArr.length;
                for (int i = 0; i < length; i++) {
                    Enum enumR = enumArr[i];
                    String name = enumR.name();
                    SerializedName serializedName = (SerializedName) cls2.getField(name).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        name = serializedName.value();
                    }
                    Object put = this.nameToConstant.put(name, enumR);
                    Object put2 = this.constantToName.put(enumR, name);
                }
            } catch (NoSuchFieldException e) {
                NoSuchFieldException noSuchFieldException = e;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
        }

        public T read(JsonReader jsonReader) throws IOException {
            JsonReader jsonReader2 = jsonReader;
            if (jsonReader2.peek() != JsonToken.NULL) {
                return (Enum) this.nameToConstant.get(jsonReader2.nextString());
            }
            jsonReader2.nextNull();
            return null;
        }

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            T t2 = t;
            JsonWriter value = jsonWriter.value(t2 == null ? null : (String) this.constantToName.get(t2));
        }
    }

    static {
        C05001 r3;
        C05112 r32;
        C05233 r33;
        C05274 r34;
        C05285 r35;
        C05296 r36;
        C05307 r37;
        C05318 r38;
        C05329 r39;
        C050110 r310;
        C050211 r311;
        C050312 r312;
        C050413 r313;
        C050514 r314;
        C050615 r315;
        C050716 r316;
        C050817 r317;
        C050918 r318;
        C051019 r319;
        C051220 r320;
        C051321 r321;
        C051422 r322;
        C051623 r323;
        C051724 r324;
        C051825 r325;
        C05001 r0 = r3;
        C05001 r1 = new TypeAdapter<Class>() {
            public Class read(JsonReader jsonReader) throws IOException {
                UnsupportedOperationException unsupportedOperationException;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
                throw unsupportedOperationException2;
            }

            public void write(JsonWriter jsonWriter, Class cls) throws IOException {
                UnsupportedOperationException unsupportedOperationException;
                StringBuilder sb;
                JsonWriter jsonWriter2 = jsonWriter;
                Class cls2 = cls;
                if (cls2 == null) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                    return;
                }
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(sb2.append("Attempted to serialize java.lang.Class: ").append(cls2.getName()).append(". Forgot to register a type adapter?").toString());
                throw unsupportedOperationException2;
            }
        };
        CLASS = r0;
        C05112 r02 = r32;
        C05112 r12 = new TypeAdapter<BitSet>() {
            public BitSet read(JsonReader jsonReader) throws IOException {
                BitSet bitSet;
                JsonSyntaxException jsonSyntaxException;
                StringBuilder sb;
                JsonSyntaxException jsonSyntaxException2;
                StringBuilder sb2;
                boolean z;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                BitSet bitSet2 = bitSet;
                BitSet bitSet3 = new BitSet();
                BitSet bitSet4 = bitSet2;
                jsonReader2.beginArray();
                int i = 0;
                JsonToken peek = jsonReader2.peek();
                while (true) {
                    JsonToken jsonToken = peek;
                    if (jsonToken != JsonToken.END_ARRAY) {
                        switch (C052632.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()]) {
                            case 1:
                                if (jsonReader2.nextInt() == 0) {
                                    z = false;
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                            case 2:
                                z = jsonReader2.nextBoolean();
                                break;
                            case 3:
                                String nextString = jsonReader2.nextString();
                                try {
                                    if (Integer.parseInt(nextString) == 0) {
                                        z = false;
                                        break;
                                    } else {
                                        z = true;
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    NumberFormatException numberFormatException = e;
                                    JsonSyntaxException jsonSyntaxException3 = jsonSyntaxException2;
                                    StringBuilder sb3 = sb2;
                                    StringBuilder sb4 = new StringBuilder();
                                    JsonSyntaxException jsonSyntaxException4 = new JsonSyntaxException(sb3.append("Error: Expecting: bitset number value (1, 0), Found: ").append(nextString).toString());
                                    throw jsonSyntaxException3;
                                }
                            default:
                                JsonSyntaxException jsonSyntaxException5 = jsonSyntaxException;
                                StringBuilder sb5 = sb;
                                StringBuilder sb6 = new StringBuilder();
                                JsonSyntaxException jsonSyntaxException6 = new JsonSyntaxException(sb5.append("Invalid bitset value type: ").append(jsonToken).toString());
                                throw jsonSyntaxException5;
                        }
                        if (z) {
                            bitSet4.set(i);
                        }
                        i++;
                        peek = jsonReader2.peek();
                    } else {
                        jsonReader2.endArray();
                        return bitSet4;
                    }
                }
            }

            public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                JsonWriter jsonWriter2 = jsonWriter;
                BitSet bitSet2 = bitSet;
                if (bitSet2 == null) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                    return;
                }
                JsonWriter beginArray = jsonWriter2.beginArray();
                for (int i = 0; i < bitSet2.length(); i++) {
                    JsonWriter value = jsonWriter2.value((long) (bitSet2.get(i) ? 1 : 0));
                }
                JsonWriter endArray = jsonWriter2.endArray();
            }
        };
        BIT_SET = r02;
        C05233 r03 = r33;
        C05233 r13 = new TypeAdapter<Boolean>() {
            public Boolean read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return jsonReader2.peek() == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader2.nextString())) : Boolean.valueOf(jsonReader2.nextBoolean());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                JsonWriter jsonWriter2 = jsonWriter;
                Boolean bool2 = bool;
                if (bool2 == null) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                } else {
                    JsonWriter value = jsonWriter2.value(bool2.booleanValue());
                }
            }
        };
        BOOLEAN = r03;
        C05274 r04 = r34;
        C05274 r14 = new TypeAdapter<Boolean>() {
            public Boolean read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader2.nextString());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                Boolean bool2 = bool;
                JsonWriter value = jsonWriter.value(bool2 == null ? "null" : bool2.toString());
            }
        };
        BOOLEAN_AS_STRING = r04;
        C05285 r05 = r35;
        C05285 r15 = new TypeAdapter<Number>() {
            public Number read(JsonReader jsonReader) throws IOException {
                JsonSyntaxException jsonSyntaxException;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) jsonReader2.nextInt());
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                    JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) numberFormatException);
                    throw jsonSyntaxException2;
                }
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter value = jsonWriter.value(number);
            }
        };
        BYTE = r05;
        C05296 r06 = r36;
        C05296 r16 = new TypeAdapter<Number>() {
            public Number read(JsonReader jsonReader) throws IOException {
                JsonSyntaxException jsonSyntaxException;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                try {
                    return Short.valueOf((short) jsonReader2.nextInt());
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                    JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) numberFormatException);
                    throw jsonSyntaxException2;
                }
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter value = jsonWriter.value(number);
            }
        };
        SHORT = r06;
        C05307 r07 = r37;
        C05307 r17 = new TypeAdapter<Number>() {
            public Number read(JsonReader jsonReader) throws IOException {
                JsonSyntaxException jsonSyntaxException;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader2.nextInt());
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                    JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) numberFormatException);
                    throw jsonSyntaxException2;
                }
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter value = jsonWriter.value(number);
            }
        };
        INTEGER = r07;
        C05318 r08 = r38;
        C05318 r18 = new TypeAdapter<Number>() {
            public Number read(JsonReader jsonReader) throws IOException {
                JsonSyntaxException jsonSyntaxException;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader2.nextLong());
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                    JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) numberFormatException);
                    throw jsonSyntaxException2;
                }
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter value = jsonWriter.value(number);
            }
        };
        LONG = r08;
        C05329 r09 = r39;
        C05329 r19 = new TypeAdapter<Number>() {
            public Number read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader2.nextDouble());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter value = jsonWriter.value(number);
            }
        };
        FLOAT = r09;
        C050110 r010 = r310;
        C050110 r110 = new TypeAdapter<Number>() {
            public Number read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader2.nextDouble());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter value = jsonWriter.value(number);
            }
        };
        DOUBLE = r010;
        C050211 r011 = r311;
        C050211 r111 = new TypeAdapter<Number>() {
            public Number read(JsonReader jsonReader) throws IOException {
                LazilyParsedNumber lazilyParsedNumber;
                JsonSyntaxException jsonSyntaxException;
                StringBuilder sb;
                JsonReader jsonReader2 = jsonReader;
                JsonToken peek = jsonReader2.peek();
                switch (C052632.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()]) {
                    case 1:
                        LazilyParsedNumber lazilyParsedNumber2 = lazilyParsedNumber;
                        LazilyParsedNumber lazilyParsedNumber3 = new LazilyParsedNumber(jsonReader2.nextString());
                        return lazilyParsedNumber2;
                    case 4:
                        jsonReader2.nextNull();
                        return null;
                    default:
                        JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException(sb2.append("Expecting number, got: ").append(peek).toString());
                        throw jsonSyntaxException2;
                }
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter value = jsonWriter.value(number);
            }
        };
        NUMBER = r011;
        C050312 r012 = r312;
        C050312 r112 = new TypeAdapter<Character>() {
            public Character read(JsonReader jsonReader) throws IOException {
                JsonSyntaxException jsonSyntaxException;
                StringBuilder sb;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                String nextString = jsonReader2.nextString();
                if (nextString.length() == 1) {
                    return Character.valueOf(nextString.charAt(0));
                }
                JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException(sb2.append("Expecting character, got: ").append(nextString).toString());
                throw jsonSyntaxException2;
            }

            public void write(JsonWriter jsonWriter, Character ch) throws IOException {
                Character ch2 = ch;
                JsonWriter value = jsonWriter.value(ch2 == null ? null : String.valueOf(ch2));
            }
        };
        CHARACTER = r012;
        C050413 r013 = r313;
        C050413 r113 = new TypeAdapter<String>() {
            public String read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                JsonToken peek = jsonReader2.peek();
                if (peek != JsonToken.NULL) {
                    return peek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader2.nextBoolean()) : jsonReader2.nextString();
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, String str) throws IOException {
                JsonWriter value = jsonWriter.value(str);
            }
        };
        STRING = r013;
        C050514 r014 = r314;
        C050514 r114 = new TypeAdapter<BigDecimal>() {
            public BigDecimal read(JsonReader jsonReader) throws IOException {
                JsonSyntaxException jsonSyntaxException;
                BigDecimal bigDecimal;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                try {
                    BigDecimal bigDecimal2 = bigDecimal;
                    BigDecimal bigDecimal3 = new BigDecimal(jsonReader2.nextString());
                    return bigDecimal2;
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                    JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) numberFormatException);
                    throw jsonSyntaxException2;
                }
            }

            public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
                JsonWriter value = jsonWriter.value((Number) bigDecimal);
            }
        };
        BIG_DECIMAL = r014;
        C050615 r015 = r315;
        C050615 r115 = new TypeAdapter<BigInteger>() {
            public BigInteger read(JsonReader jsonReader) throws IOException {
                JsonSyntaxException jsonSyntaxException;
                BigInteger bigInteger;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                try {
                    BigInteger bigInteger2 = bigInteger;
                    BigInteger bigInteger3 = new BigInteger(jsonReader2.nextString());
                    return bigInteger2;
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                    JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) numberFormatException);
                    throw jsonSyntaxException2;
                }
            }

            public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
                JsonWriter value = jsonWriter.value((Number) bigInteger);
            }
        };
        BIG_INTEGER = r015;
        C050716 r016 = r316;
        C050716 r116 = new TypeAdapter<StringBuilder>() {
            public StringBuilder read(JsonReader jsonReader) throws IOException {
                StringBuilder sb;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder(jsonReader2.nextString());
                return sb2;
            }

            public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
                StringBuilder sb2 = sb;
                JsonWriter value = jsonWriter.value(sb2 == null ? null : sb2.toString());
            }
        };
        STRING_BUILDER = r016;
        C050817 r017 = r317;
        C050817 r117 = new TypeAdapter<StringBuffer>() {
            public StringBuffer read(JsonReader jsonReader) throws IOException {
                StringBuffer stringBuffer;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer(jsonReader2.nextString());
                return stringBuffer2;
            }

            public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
                StringBuffer stringBuffer2 = stringBuffer;
                JsonWriter value = jsonWriter.value(stringBuffer2 == null ? null : stringBuffer2.toString());
            }
        };
        STRING_BUFFER = r017;
        C050918 r018 = r318;
        C050918 r118 = new TypeAdapter<URL>() {
            public URL read(JsonReader jsonReader) throws IOException {
                URL url;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                } else {
                    String nextString = jsonReader2.nextString();
                    if (!"null".equals(nextString)) {
                        URL url2 = url;
                        URL url3 = new URL(nextString);
                        return url2;
                    }
                }
                return null;
            }

            public void write(JsonWriter jsonWriter, URL url) throws IOException {
                URL url2 = url;
                JsonWriter value = jsonWriter.value(url2 == null ? null : url2.toExternalForm());
            }
        };
        URL = r018;
        C051019 r019 = r319;
        C051019 r119 = new TypeAdapter<URI>() {
            public URI read(JsonReader jsonReader) throws IOException {
                JsonIOException jsonIOException;
                URI uri;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                } else {
                    try {
                        String nextString = jsonReader2.nextString();
                        if (!"null".equals(nextString)) {
                            URI uri2 = uri;
                            URI uri3 = new URI(nextString);
                            return uri2;
                        }
                    } catch (URISyntaxException e) {
                        URISyntaxException uRISyntaxException = e;
                        JsonIOException jsonIOException2 = jsonIOException;
                        JsonIOException jsonIOException3 = new JsonIOException((Throwable) uRISyntaxException);
                        throw jsonIOException2;
                    }
                }
                return null;
            }

            public void write(JsonWriter jsonWriter, URI uri) throws IOException {
                URI uri2 = uri;
                JsonWriter value = jsonWriter.value(uri2 == null ? null : uri2.toASCIIString());
            }
        };
        URI = r019;
        C051220 r020 = r320;
        C051220 r120 = new TypeAdapter<InetAddress>() {
            public InetAddress read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return InetAddress.getByName(jsonReader2.nextString());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
                InetAddress inetAddress2 = inetAddress;
                JsonWriter value = jsonWriter.value(inetAddress2 == null ? null : inetAddress2.getHostAddress());
            }
        };
        INET_ADDRESS = r020;
        C051321 r021 = r321;
        C051321 r121 = new TypeAdapter<UUID>() {
            public UUID read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return UUID.fromString(jsonReader2.nextString());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
                UUID uuid2 = uuid;
                JsonWriter value = jsonWriter.value(uuid2 == null ? null : uuid2.toString());
            }
        };
        UUID = r021;
        C051422 r022 = r322;
        C051422 r122 = new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                C05151 r8;
                Gson gson2 = gson;
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                C05151 r3 = r8;
                final TypeAdapter adapter = gson2.getAdapter(Date.class);
                C05151 r4 = new TypeAdapter<Timestamp>(this) {
                    final /* synthetic */ C051422 this$0;

                    {
                        TypeAdapter typeAdapter = r7;
                        this.this$0 = r6;
                    }

                    public Timestamp read(JsonReader jsonReader) throws IOException {
                        Timestamp timestamp;
                        JsonReader jsonReader2 = jsonReader;
                        Date date = (Date) adapter.read(jsonReader2);
                        if (date == null) {
                            return null;
                        }
                        Timestamp timestamp2 = timestamp;
                        Timestamp timestamp3 = new Timestamp(date.getTime());
                        return timestamp2;
                    }

                    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                        JsonWriter jsonWriter2 = jsonWriter;
                        Timestamp timestamp2 = timestamp;
                        adapter.write(jsonWriter2, timestamp2);
                    }
                };
                return r3;
            }
        };
        TIMESTAMP_FACTORY = r022;
        C051623 r023 = r323;
        C051623 r123 = new TypeAdapter<Calendar>() {
            private static final String DAY_OF_MONTH = "dayOfMonth";
            private static final String HOUR_OF_DAY = "hourOfDay";
            private static final String MINUTE = "minute";
            private static final String MONTH = "month";
            private static final String SECOND = "second";
            private static final String YEAR = "year";

            public Calendar read(JsonReader jsonReader) throws IOException {
                GregorianCalendar gregorianCalendar;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                jsonReader2.beginObject();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (jsonReader2.peek() != JsonToken.END_OBJECT) {
                    String nextName = jsonReader2.nextName();
                    int nextInt = jsonReader2.nextInt();
                    if (YEAR.equals(nextName)) {
                        i = nextInt;
                    } else if (MONTH.equals(nextName)) {
                        i2 = nextInt;
                    } else if (DAY_OF_MONTH.equals(nextName)) {
                        i3 = nextInt;
                    } else if (HOUR_OF_DAY.equals(nextName)) {
                        i4 = nextInt;
                    } else if (MINUTE.equals(nextName)) {
                        i5 = nextInt;
                    } else if (SECOND.equals(nextName)) {
                        i6 = nextInt;
                    }
                }
                jsonReader2.endObject();
                GregorianCalendar gregorianCalendar2 = gregorianCalendar;
                GregorianCalendar gregorianCalendar3 = new GregorianCalendar(i, i2, i3, i4, i5, i6);
                return gregorianCalendar2;
            }

            public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
                JsonWriter jsonWriter2 = jsonWriter;
                Calendar calendar2 = calendar;
                if (calendar2 == null) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                    return;
                }
                JsonWriter beginObject = jsonWriter2.beginObject();
                JsonWriter name = jsonWriter2.name(YEAR);
                JsonWriter value = jsonWriter2.value((long) calendar2.get(1));
                JsonWriter name2 = jsonWriter2.name(MONTH);
                JsonWriter value2 = jsonWriter2.value((long) calendar2.get(2));
                JsonWriter name3 = jsonWriter2.name(DAY_OF_MONTH);
                JsonWriter value3 = jsonWriter2.value((long) calendar2.get(5));
                JsonWriter name4 = jsonWriter2.name(HOUR_OF_DAY);
                JsonWriter value4 = jsonWriter2.value((long) calendar2.get(11));
                JsonWriter name5 = jsonWriter2.name(MINUTE);
                JsonWriter value5 = jsonWriter2.value((long) calendar2.get(12));
                JsonWriter name6 = jsonWriter2.name(SECOND);
                JsonWriter value6 = jsonWriter2.value((long) calendar2.get(13));
                JsonWriter endObject = jsonWriter2.endObject();
            }
        };
        CALENDAR = r023;
        C051724 r024 = r324;
        C051724 r124 = new TypeAdapter<Locale>() {
            public Locale read(JsonReader jsonReader) throws IOException {
                StringTokenizer stringTokenizer;
                Locale locale;
                Locale locale2;
                Locale locale3;
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    return null;
                }
                StringTokenizer stringTokenizer2 = stringTokenizer;
                StringTokenizer stringTokenizer3 = new StringTokenizer(jsonReader2.nextString(), "_");
                StringTokenizer stringTokenizer4 = stringTokenizer2;
                String str = null;
                if (stringTokenizer4.hasMoreElements()) {
                    str = stringTokenizer4.nextToken();
                }
                String str2 = null;
                if (stringTokenizer4.hasMoreElements()) {
                    str2 = stringTokenizer4.nextToken();
                }
                String str3 = null;
                if (stringTokenizer4.hasMoreElements()) {
                    str3 = stringTokenizer4.nextToken();
                }
                if (str2 == null && str3 == null) {
                    Locale locale4 = locale3;
                    Locale locale5 = new Locale(str);
                    return locale4;
                } else if (str3 == null) {
                    Locale locale6 = locale2;
                    Locale locale7 = new Locale(str, str2);
                    return locale6;
                } else {
                    Locale locale8 = locale;
                    Locale locale9 = new Locale(str, str2, str3);
                    return locale8;
                }
            }

            public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
                Locale locale2 = locale;
                JsonWriter value = jsonWriter.value(locale2 == null ? null : locale2.toString());
            }
        };
        LOCALE = r024;
        C051825 r025 = r325;
        C051825 r125 = new TypeAdapter<JsonElement>() {
            public JsonElement read(JsonReader jsonReader) throws IOException {
                JsonObject jsonObject;
                JsonArray jsonArray;
                JsonPrimitive jsonPrimitive;
                JsonPrimitive jsonPrimitive2;
                LazilyParsedNumber lazilyParsedNumber;
                JsonPrimitive jsonPrimitive3;
                IllegalArgumentException illegalArgumentException;
                JsonReader jsonReader2 = jsonReader;
                switch (C052632.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader2.peek().ordinal()]) {
                    case 1:
                        JsonPrimitive jsonPrimitive4 = jsonPrimitive2;
                        LazilyParsedNumber lazilyParsedNumber2 = lazilyParsedNumber;
                        LazilyParsedNumber lazilyParsedNumber3 = new LazilyParsedNumber(jsonReader2.nextString());
                        JsonPrimitive jsonPrimitive5 = new JsonPrimitive((Number) lazilyParsedNumber2);
                        return jsonPrimitive4;
                    case 2:
                        JsonPrimitive jsonPrimitive6 = jsonPrimitive;
                        JsonPrimitive jsonPrimitive7 = new JsonPrimitive(Boolean.valueOf(jsonReader2.nextBoolean()));
                        return jsonPrimitive6;
                    case 3:
                        JsonPrimitive jsonPrimitive8 = jsonPrimitive3;
                        JsonPrimitive jsonPrimitive9 = new JsonPrimitive(jsonReader2.nextString());
                        return jsonPrimitive8;
                    case 4:
                        jsonReader2.nextNull();
                        return JsonNull.INSTANCE;
                    case 5:
                        JsonArray jsonArray2 = jsonArray;
                        JsonArray jsonArray3 = new JsonArray();
                        JsonArray jsonArray4 = jsonArray2;
                        jsonReader2.beginArray();
                        while (jsonReader2.hasNext()) {
                            jsonArray4.add(read(jsonReader2));
                        }
                        jsonReader2.endArray();
                        return jsonArray4;
                    case 6:
                        JsonObject jsonObject2 = jsonObject;
                        JsonObject jsonObject3 = new JsonObject();
                        JsonObject jsonObject4 = jsonObject2;
                        jsonReader2.beginObject();
                        while (jsonReader2.hasNext()) {
                            jsonObject4.add(jsonReader2.nextName(), read(jsonReader2));
                        }
                        jsonReader2.endObject();
                        return jsonObject4;
                    default:
                        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
                        throw illegalArgumentException2;
                }
            }

            public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
                IllegalArgumentException illegalArgumentException;
                StringBuilder sb;
                JsonWriter jsonWriter2 = jsonWriter;
                JsonElement jsonElement2 = jsonElement;
                if (jsonElement2 == null || jsonElement2.isJsonNull()) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                } else if (jsonElement2.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement2.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        JsonWriter value = jsonWriter2.value(asJsonPrimitive.getAsNumber());
                    } else if (asJsonPrimitive.isBoolean()) {
                        JsonWriter value2 = jsonWriter2.value(asJsonPrimitive.getAsBoolean());
                    } else {
                        JsonWriter value3 = jsonWriter2.value(asJsonPrimitive.getAsString());
                    }
                } else if (jsonElement2.isJsonArray()) {
                    JsonWriter beginArray = jsonWriter2.beginArray();
                    Iterator it = jsonElement2.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        write(jsonWriter2, (JsonElement) it.next());
                    }
                    JsonWriter endArray = jsonWriter2.endArray();
                } else if (jsonElement2.isJsonObject()) {
                    JsonWriter beginObject = jsonWriter2.beginObject();
                    for (Entry entry : jsonElement2.getAsJsonObject().entrySet()) {
                        JsonWriter name = jsonWriter2.name((String) entry.getKey());
                        write(jsonWriter2, (JsonElement) entry.getValue());
                    }
                    JsonWriter endObject = jsonWriter2.endObject();
                } else {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Couldn't write ").append(jsonElement2.getClass()).toString());
                    throw illegalArgumentException2;
                }
            }
        };
        JSON_ELEMENT = r025;
    }

    private TypeAdapters() {
    }

    public static TypeAdapterFactory newEnumTypeHierarchyFactory() {
        C051926 r2;
        C051926 r0 = r2;
        C051926 r1 = new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                EnumTypeAdapter enumTypeAdapter;
                Gson gson2 = gson;
                Class rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                EnumTypeAdapter enumTypeAdapter2 = enumTypeAdapter;
                EnumTypeAdapter enumTypeAdapter3 = new EnumTypeAdapter(rawType);
                return enumTypeAdapter2;
            }
        };
        return r0;
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        C052027 r6;
        C052027 r2 = r6;
        final TypeToken<TT> typeToken2 = typeToken;
        final TypeAdapter<TT> typeAdapter2 = typeAdapter;
        C052027 r3 = new TypeAdapterFactory() {
            {
                TypeAdapter typeAdapter = r7;
            }

            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Gson gson2 = gson;
                if (typeToken.equals(typeToken2)) {
                    return typeAdapter2;
                }
                return null;
            }
        };
        return r2;
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        C052128 r6;
        C052128 r2 = r6;
        final Class<TT> cls2 = cls;
        final TypeAdapter<TT> typeAdapter2 = typeAdapter;
        C052128 r3 = new TypeAdapterFactory() {
            {
                TypeAdapter typeAdapter = r7;
            }

            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Gson gson2 = gson;
                if (typeToken.getRawType() == cls2) {
                    return typeAdapter2;
                }
                return null;
            }

            public String toString() {
                StringBuilder sb;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return sb2.append("Factory[type=").append(cls2.getName()).append(",adapter=").append(typeAdapter2).append("]").toString();
            }
        };
        return r2;
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        C052229 r8;
        C052229 r3 = r8;
        final Class<TT> cls3 = cls;
        final Class<TT> cls4 = cls2;
        final TypeAdapter<? super TT> typeAdapter2 = typeAdapter;
        C052229 r4 = new TypeAdapterFactory() {
            {
                Class cls = r8;
                TypeAdapter typeAdapter = r9;
            }

            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Gson gson2 = gson;
                Class rawType = typeToken.getRawType();
                if (rawType == cls3 || rawType == cls4) {
                    return typeAdapter2;
                }
                return null;
            }

            public String toString() {
                StringBuilder sb;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return sb2.append("Factory[type=").append(cls4.getName()).append("+").append(cls3.getName()).append(",adapter=").append(typeAdapter2).append("]").toString();
            }
        };
        return r3;
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        C052430 r8;
        C052430 r3 = r8;
        final Class<TT> cls3 = cls;
        final Class<? extends TT> cls4 = cls2;
        final TypeAdapter<? super TT> typeAdapter2 = typeAdapter;
        C052430 r4 = new TypeAdapterFactory() {
            {
                Class cls = r8;
                TypeAdapter typeAdapter = r9;
            }

            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Gson gson2 = gson;
                Class rawType = typeToken.getRawType();
                if (rawType == cls3 || rawType == cls4) {
                    return typeAdapter2;
                }
                return null;
            }

            public String toString() {
                StringBuilder sb;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return sb2.append("Factory[type=").append(cls3.getName()).append("+").append(cls4.getName()).append(",adapter=").append(typeAdapter2).append("]").toString();
            }
        };
        return r3;
    }

    public static <TT> TypeAdapterFactory newTypeHierarchyFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        C052531 r6;
        C052531 r2 = r6;
        final Class<TT> cls2 = cls;
        final TypeAdapter<TT> typeAdapter2 = typeAdapter;
        C052531 r3 = new TypeAdapterFactory() {
            {
                TypeAdapter typeAdapter = r7;
            }

            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Gson gson2 = gson;
                if (cls2.isAssignableFrom(typeToken.getRawType())) {
                    return typeAdapter2;
                }
                return null;
            }

            public String toString() {
                StringBuilder sb;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return sb2.append("Factory[typeHierarchy=").append(cls2.getName()).append(",adapter=").append(typeAdapter2).append("]").toString();
            }
        };
        return r2;
    }
}
