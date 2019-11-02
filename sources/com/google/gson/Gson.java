package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Gson {
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls;
    private final ConstructorConstructor constructorConstructor;
    final JsonDeserializationContext deserializationContext;
    private final List<TypeAdapterFactory> factories;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final boolean prettyPrinting;
    final JsonSerializationContext serializationContext;
    private final boolean serializeNulls;
    private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache;

    static class FutureTypeAdapter<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;

        FutureTypeAdapter() {
        }

        public T read(JsonReader jsonReader) throws IOException {
            IllegalStateException illegalStateException;
            JsonReader jsonReader2 = jsonReader;
            if (this.delegate != null) {
                return this.delegate.read(jsonReader2);
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException();
            throw illegalStateException2;
        }

        public void setDelegate(TypeAdapter<T> typeAdapter) {
            AssertionError assertionError;
            TypeAdapter<T> typeAdapter2 = typeAdapter;
            if (this.delegate != null) {
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
            this.delegate = typeAdapter2;
        }

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            IllegalStateException illegalStateException;
            JsonWriter jsonWriter2 = jsonWriter;
            T t2 = t;
            if (this.delegate == null) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException();
                throw illegalStateException2;
            }
            this.delegate.write(jsonWriter2, t2);
        }
    }

    public Gson() {
        this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> threadLocal;
        HashMap hashMap;
        C04611 r20;
        C04622 r202;
        ConstructorConstructor constructorConstructor2;
        ArrayList arrayList;
        CollectionTypeAdapterFactory collectionTypeAdapterFactory;
        MapTypeAdapterFactory mapTypeAdapterFactory;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory;
        Excluder excluder2 = excluder;
        FieldNamingStrategy fieldNamingStrategy2 = fieldNamingStrategy;
        Map<Type, InstanceCreator<?>> map2 = map;
        boolean z7 = z;
        boolean z8 = z2;
        boolean z9 = z3;
        boolean z10 = z4;
        boolean z11 = z5;
        boolean z12 = z6;
        LongSerializationPolicy longSerializationPolicy2 = longSerializationPolicy;
        List<TypeAdapterFactory> list2 = list;
        ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> threadLocal2 = threadLocal;
        ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> threadLocal3 = new ThreadLocal<>();
        this.calls = threadLocal2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.typeTokenCache = Collections.synchronizedMap(hashMap2);
        C04611 r15 = r20;
        C04611 r16 = new JsonDeserializationContext(this) {
            final /* synthetic */ Gson this$0;

            {
                this.this$0 = r5;
            }

            public <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
                return this.this$0.fromJson(jsonElement, type);
            }
        };
        this.deserializationContext = r15;
        C04622 r152 = r202;
        C04622 r162 = new JsonSerializationContext(this) {
            final /* synthetic */ Gson this$0;

            {
                this.this$0 = r5;
            }

            public JsonElement serialize(Object obj) {
                return this.this$0.toJsonTree(obj);
            }

            public JsonElement serialize(Object obj, Type type) {
                return this.this$0.toJsonTree(obj, type);
            }
        };
        this.serializationContext = r152;
        ConstructorConstructor constructorConstructor3 = constructorConstructor2;
        ConstructorConstructor constructorConstructor4 = new ConstructorConstructor(map2);
        this.constructorConstructor = constructorConstructor3;
        this.serializeNulls = z7;
        this.generateNonExecutableJson = z9;
        this.htmlSafe = z10;
        this.prettyPrinting = z11;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        boolean add2 = arrayList4.add(ObjectTypeAdapter.FACTORY);
        boolean add3 = arrayList4.add(excluder2);
        boolean addAll = arrayList4.addAll(list2);
        boolean add4 = arrayList4.add(TypeAdapters.STRING_FACTORY);
        boolean add5 = arrayList4.add(TypeAdapters.INTEGER_FACTORY);
        boolean add6 = arrayList4.add(TypeAdapters.BOOLEAN_FACTORY);
        boolean add7 = arrayList4.add(TypeAdapters.BYTE_FACTORY);
        boolean add8 = arrayList4.add(TypeAdapters.SHORT_FACTORY);
        boolean add9 = arrayList4.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter(longSerializationPolicy2)));
        boolean add10 = arrayList4.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(z12)));
        boolean add11 = arrayList4.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(z12)));
        boolean add12 = arrayList4.add(TypeAdapters.NUMBER_FACTORY);
        boolean add13 = arrayList4.add(TypeAdapters.CHARACTER_FACTORY);
        boolean add14 = arrayList4.add(TypeAdapters.STRING_BUILDER_FACTORY);
        boolean add15 = arrayList4.add(TypeAdapters.STRING_BUFFER_FACTORY);
        boolean add16 = arrayList4.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        boolean add17 = arrayList4.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        boolean add18 = arrayList4.add(TypeAdapters.URL_FACTORY);
        boolean add19 = arrayList4.add(TypeAdapters.URI_FACTORY);
        boolean add20 = arrayList4.add(TypeAdapters.UUID_FACTORY);
        boolean add21 = arrayList4.add(TypeAdapters.LOCALE_FACTORY);
        boolean add22 = arrayList4.add(TypeAdapters.INET_ADDRESS_FACTORY);
        boolean add23 = arrayList4.add(TypeAdapters.BIT_SET_FACTORY);
        boolean add24 = arrayList4.add(DateTypeAdapter.FACTORY);
        boolean add25 = arrayList4.add(TypeAdapters.CALENDAR_FACTORY);
        boolean add26 = arrayList4.add(TimeTypeAdapter.FACTORY);
        boolean add27 = arrayList4.add(SqlDateTypeAdapter.FACTORY);
        boolean add28 = arrayList4.add(TypeAdapters.TIMESTAMP_FACTORY);
        boolean add29 = arrayList4.add(ArrayTypeAdapter.FACTORY);
        boolean add30 = arrayList4.add(TypeAdapters.ENUM_FACTORY);
        boolean add31 = arrayList4.add(TypeAdapters.CLASS_FACTORY);
        ArrayList arrayList5 = arrayList4;
        CollectionTypeAdapterFactory collectionTypeAdapterFactory2 = collectionTypeAdapterFactory;
        CollectionTypeAdapterFactory collectionTypeAdapterFactory3 = new CollectionTypeAdapterFactory(this.constructorConstructor);
        boolean add32 = arrayList5.add(collectionTypeAdapterFactory2);
        ArrayList arrayList6 = arrayList4;
        MapTypeAdapterFactory mapTypeAdapterFactory2 = mapTypeAdapterFactory;
        MapTypeAdapterFactory mapTypeAdapterFactory3 = new MapTypeAdapterFactory(this.constructorConstructor, z8);
        boolean add33 = arrayList6.add(mapTypeAdapterFactory2);
        ArrayList arrayList7 = arrayList4;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory2 = reflectiveTypeAdapterFactory;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory3 = new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy2, excluder2);
        boolean add34 = arrayList7.add(reflectiveTypeAdapterFactory2);
        this.factories = Collections.unmodifiableList(arrayList4);
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonReader) {
        JsonIOException jsonIOException;
        JsonSyntaxException jsonSyntaxException;
        JsonIOException jsonIOException2;
        JsonReader jsonReader2 = jsonReader;
        if (obj != null) {
            try {
                if (jsonReader2.peek() != JsonToken.END_DOCUMENT) {
                    JsonIOException jsonIOException3 = jsonIOException2;
                    JsonIOException jsonIOException4 = new JsonIOException("JSON document was not fully consumed.");
                    throw jsonIOException3;
                }
            } catch (MalformedJsonException e) {
                MalformedJsonException malformedJsonException = e;
                JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) malformedJsonException);
                throw jsonSyntaxException2;
            } catch (IOException e2) {
                IOException iOException = e2;
                JsonIOException jsonIOException5 = jsonIOException;
                JsonIOException jsonIOException6 = new JsonIOException((Throwable) iOException);
                throw jsonIOException5;
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkValidFloatingPoint(double d) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        double d2 = d;
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append(d2).append(" is not a valid double value as per JSON specification. To override this").append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
            throw illegalArgumentException2;
        }
    }

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        C04633 r5;
        if (z) {
            return TypeAdapters.DOUBLE;
        }
        C04633 r2 = r5;
        C04633 r3 = new TypeAdapter<Number>(this) {
            final /* synthetic */ Gson this$0;

            {
                this.this$0 = r5;
            }

            public Double read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader2.nextDouble());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter jsonWriter2 = jsonWriter;
                Number number2 = number;
                if (number2 == null) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                    return;
                }
                this.this$0.checkValidFloatingPoint(number2.doubleValue());
                JsonWriter value = jsonWriter2.value(number2);
            }
        };
        return r2;
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        C04644 r5;
        if (z) {
            return TypeAdapters.FLOAT;
        }
        C04644 r2 = r5;
        C04644 r3 = new TypeAdapter<Number>(this) {
            final /* synthetic */ Gson this$0;

            {
                this.this$0 = r5;
            }

            public Float read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader2.nextDouble());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter jsonWriter2 = jsonWriter;
                Number number2 = number;
                if (number2 == null) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                    return;
                }
                this.this$0.checkValidFloatingPoint((double) number2.floatValue());
                JsonWriter value = jsonWriter2.value(number2);
            }
        };
        return r2;
    }

    private TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        C04655 r5;
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        C04655 r2 = r5;
        C04655 r3 = new TypeAdapter<Number>(this) {
            final /* synthetic */ Gson this$0;

            {
                this.this$0 = r5;
            }

            public Number read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return Long.valueOf(jsonReader2.nextLong());
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                JsonWriter jsonWriter2 = jsonWriter;
                Number number2 = number;
                if (number2 == null) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                } else {
                    JsonWriter value = jsonWriter2.value(number2.toString());
                }
            }
        };
        return r2;
    }

    private JsonWriter newJsonWriter(Writer writer) throws IOException {
        JsonWriter jsonWriter;
        Writer writer2 = writer;
        if (this.generateNonExecutableJson) {
            writer2.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter2 = jsonWriter;
        JsonWriter jsonWriter3 = new JsonWriter(writer2);
        JsonWriter jsonWriter4 = jsonWriter2;
        if (this.prettyPrinting) {
            jsonWriter4.setIndent("  ");
        }
        jsonWriter4.setSerializeNulls(this.serializeNulls);
        return jsonWriter4;
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        Class<T> cls2 = cls;
        return Primitives.wrap(cls2).cast(fromJson(jsonElement, (Type) cls2));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        JsonTreeReader jsonTreeReader;
        JsonElement jsonElement2 = jsonElement;
        Type type2 = type;
        if (jsonElement2 == null) {
            return null;
        }
        JsonTreeReader jsonTreeReader2 = jsonTreeReader;
        JsonTreeReader jsonTreeReader3 = new JsonTreeReader(jsonElement2);
        return fromJson((JsonReader) jsonTreeReader2, type2);
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        JsonSyntaxException jsonSyntaxException;
        JsonSyntaxException jsonSyntaxException2;
        JsonSyntaxException jsonSyntaxException3;
        JsonReader jsonReader2 = jsonReader;
        Type type2 = type;
        boolean z = true;
        boolean isLenient = jsonReader2.isLenient();
        jsonReader2.setLenient(true);
        try {
            JsonToken peek = jsonReader2.peek();
            z = false;
            Object read = getAdapter(TypeToken.get(type2)).read(jsonReader2);
            jsonReader2.setLenient(isLenient);
            return read;
        } catch (EOFException e) {
            EOFException eOFException = e;
            if (z) {
                jsonReader2.setLenient(isLenient);
                return null;
            }
            JsonSyntaxException jsonSyntaxException4 = jsonSyntaxException3;
            JsonSyntaxException jsonSyntaxException5 = new JsonSyntaxException((Throwable) eOFException);
            throw jsonSyntaxException4;
        } catch (IllegalStateException e2) {
            IllegalStateException illegalStateException = e2;
            JsonSyntaxException jsonSyntaxException6 = jsonSyntaxException2;
            JsonSyntaxException jsonSyntaxException7 = new JsonSyntaxException((Throwable) illegalStateException);
            throw jsonSyntaxException6;
        } catch (IOException e3) {
            IOException iOException = e3;
            JsonSyntaxException jsonSyntaxException8 = jsonSyntaxException;
            JsonSyntaxException jsonSyntaxException9 = new JsonSyntaxException((Throwable) iOException);
            throw jsonSyntaxException8;
        } catch (Throwable th) {
            Throwable th2 = th;
            jsonReader2.setLenient(isLenient);
            throw th2;
        }
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReader;
        Class<T> cls2 = cls;
        JsonReader jsonReader2 = jsonReader;
        JsonReader jsonReader3 = new JsonReader(reader);
        JsonReader jsonReader4 = jsonReader2;
        Object fromJson = fromJson(jsonReader4, (Type) cls2);
        assertFullConsumption(fromJson, jsonReader4);
        return Primitives.wrap(cls2).cast(fromJson);
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        JsonReader jsonReader;
        Type type2 = type;
        JsonReader jsonReader2 = jsonReader;
        JsonReader jsonReader3 = new JsonReader(reader);
        JsonReader jsonReader4 = jsonReader2;
        Object fromJson = fromJson(jsonReader4, type2);
        assertFullConsumption(fromJson, jsonReader4);
        return fromJson;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        Class<T> cls2 = cls;
        return Primitives.wrap(cls2).cast(fromJson(str, (Type) cls2));
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        StringReader stringReader;
        String str2 = str;
        Type type2 = type;
        if (str2 == null) {
            return null;
        }
        StringReader stringReader2 = stringReader;
        StringReader stringReader3 = new StringReader(str2);
        return fromJson((Reader) stringReader2, type2);
    }

    /* JADX WARNING: type inference failed for: r12v8, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r12v11, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r12v16, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r12v24, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r12v42, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r16v3 */
    /* JADX WARNING: type inference failed for: r12v50 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r13v11, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.google.gson.TypeAdapter<T> getAdapter(com.google.gson.reflect.TypeToken<T> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r12 = r0
            java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>> r12 = r12.typeTokenCache
            r13 = r1
            java.lang.Object r12 = r12.get(r13)
            com.google.gson.TypeAdapter r12 = (com.google.gson.TypeAdapter) r12
            r2 = r12
            r12 = r2
            if (r12 == 0) goto L_0x0015
            r12 = r2
            r0 = r12
        L_0x0014:
            return r0
        L_0x0015:
            r12 = r0
            java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.Gson$FutureTypeAdapter<?>>> r12 = r12.calls
            java.lang.Object r12 = r12.get()
            java.util.Map r12 = (java.util.Map) r12
            r3 = r12
            r12 = 0
            r4 = r12
            r12 = r3
            if (r12 != 0) goto L_0x0039
            java.util.HashMap r12 = new java.util.HashMap
            r16 = r12
            r12 = r16
            r13 = r16
            r13.<init>()
            r3 = r12
            r12 = r0
            java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.Gson$FutureTypeAdapter<?>>> r12 = r12.calls
            r13 = r3
            r12.set(r13)
            r12 = 1
            r4 = r12
        L_0x0039:
            r12 = r3
            r13 = r1
            java.lang.Object r12 = r12.get(r13)
            com.google.gson.Gson$FutureTypeAdapter r12 = (com.google.gson.Gson.FutureTypeAdapter) r12
            r5 = r12
            r12 = r5
            if (r12 == 0) goto L_0x0048
            r12 = r5
            r0 = r12
            goto L_0x0014
        L_0x0048:
            com.google.gson.Gson$FutureTypeAdapter r12 = new com.google.gson.Gson$FutureTypeAdapter     // Catch:{ all -> 0x00c2 }
            r16 = r12
            r12 = r16
            r13 = r16
            r13.<init>()     // Catch:{ all -> 0x00c2 }
            r6 = r12
            r12 = r3
            r13 = r1
            r14 = r6
            java.lang.Object r12 = r12.put(r13, r14)     // Catch:{ all -> 0x00c2 }
            r12 = r0
            java.util.List<com.google.gson.TypeAdapterFactory> r12 = r12.factories     // Catch:{ all -> 0x00c2 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x00c2 }
            r10 = r12
        L_0x0063:
            r12 = r10
            boolean r12 = r12.hasNext()     // Catch:{ all -> 0x00c2 }
            if (r12 == 0) goto L_0x009c
            r12 = r10
            java.lang.Object r12 = r12.next()     // Catch:{ all -> 0x00c2 }
            com.google.gson.TypeAdapterFactory r12 = (com.google.gson.TypeAdapterFactory) r12     // Catch:{ all -> 0x00c2 }
            r13 = r0
            r14 = r1
            com.google.gson.TypeAdapter r12 = r12.create(r13, r14)     // Catch:{ all -> 0x00c2 }
            r11 = r12
            r12 = r11
            if (r12 == 0) goto L_0x0063
            r12 = r6
            r13 = r11
            r12.setDelegate(r13)     // Catch:{ all -> 0x00c2 }
            r12 = r0
            java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.TypeAdapter<?>> r12 = r12.typeTokenCache     // Catch:{ all -> 0x00c2 }
            r13 = r1
            r14 = r11
            java.lang.Object r12 = r12.put(r13, r14)     // Catch:{ all -> 0x00c2 }
            r12 = r3
            r13 = r1
            java.lang.Object r12 = r12.remove(r13)
            r12 = r4
            if (r12 == 0) goto L_0x0098
            r12 = r0
            java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.Gson$FutureTypeAdapter<?>>> r12 = r12.calls
            r12.remove()
        L_0x0098:
            r12 = r11
            r0 = r12
            goto L_0x0014
        L_0x009c:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c2 }
            r16 = r12
            r12 = r16
            r13 = r16
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            r16 = r14
            r14 = r16
            r15 = r16
            r15.<init>()     // Catch:{ all -> 0x00c2 }
            java.lang.String r15 = "GSON cannot handle "
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x00c2 }
            r15 = r1
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x00c2 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x00c2 }
            r13.<init>(r14)     // Catch:{ all -> 0x00c2 }
            throw r12     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r12 = move-exception
            r7 = r12
            r12 = r3
            r13 = r1
            java.lang.Object r12 = r12.remove(r13)
            r12 = r4
            if (r12 == 0) goto L_0x00d3
            r12 = r0
            java.lang.ThreadLocal<java.util.Map<com.google.gson.reflect.TypeToken<?>, com.google.gson.Gson$FutureTypeAdapter<?>>> r12 = r12.calls
            r12.remove()
        L_0x00d3:
            r12 = r7
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.getAdapter(com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> cls) {
        return getAdapter(TypeToken.get(cls));
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        TypeAdapterFactory typeAdapterFactory2 = typeAdapterFactory;
        TypeToken<T> typeToken2 = typeToken;
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory3 : this.factories) {
            if (z) {
                TypeAdapter create = typeAdapterFactory3.create(this, typeToken2);
                if (create != null) {
                    return create;
                }
            } else if (typeAdapterFactory3 == typeAdapterFactory2) {
                z = true;
            }
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("GSON cannot serialize ").append(typeToken2).toString());
        throw illegalArgumentException2;
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter;
        JsonElement jsonElement2 = jsonElement;
        StringWriter stringWriter2 = stringWriter;
        StringWriter stringWriter3 = new StringWriter();
        StringWriter stringWriter4 = stringWriter2;
        toJson(jsonElement2, (Appendable) stringWriter4);
        return stringWriter4.toString();
    }

    public String toJson(Object obj) {
        Object obj2 = obj;
        return obj2 == null ? toJson((JsonElement) JsonNull.INSTANCE) : toJson(obj2, (Type) obj2.getClass());
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter;
        Object obj2 = obj;
        Type type2 = type;
        StringWriter stringWriter2 = stringWriter;
        StringWriter stringWriter3 = new StringWriter();
        StringWriter stringWriter4 = stringWriter2;
        toJson(obj2, type2, (Appendable) stringWriter4);
        return stringWriter4.toString();
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        JsonIOException jsonIOException;
        JsonElement jsonElement2 = jsonElement;
        JsonWriter jsonWriter2 = jsonWriter;
        boolean isLenient = jsonWriter2.isLenient();
        jsonWriter2.setLenient(true);
        boolean isHtmlSafe = jsonWriter2.isHtmlSafe();
        jsonWriter2.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls2 = jsonWriter2.getSerializeNulls();
        jsonWriter2.setSerializeNulls(this.serializeNulls);
        try {
            Streams.write(jsonElement2, jsonWriter2);
            jsonWriter2.setLenient(isLenient);
            jsonWriter2.setHtmlSafe(isHtmlSafe);
            jsonWriter2.setSerializeNulls(serializeNulls2);
        } catch (IOException e) {
            IOException iOException = e;
            JsonIOException jsonIOException2 = jsonIOException;
            JsonIOException jsonIOException3 = new JsonIOException((Throwable) iOException);
            throw jsonIOException2;
        } catch (Throwable th) {
            Throwable th2 = th;
            jsonWriter2.setLenient(isLenient);
            jsonWriter2.setHtmlSafe(isHtmlSafe);
            jsonWriter2.setSerializeNulls(serializeNulls2);
            throw th2;
        }
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        RuntimeException runtimeException;
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(iOException);
            throw runtimeException2;
        }
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        Object obj2 = obj;
        Appendable appendable2 = appendable;
        if (obj2 != null) {
            toJson(obj2, (Type) obj2.getClass(), appendable2);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable2);
        }
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        JsonIOException jsonIOException;
        Object obj2 = obj;
        JsonWriter jsonWriter2 = jsonWriter;
        TypeAdapter adapter = getAdapter(TypeToken.get(type));
        boolean isLenient = jsonWriter2.isLenient();
        jsonWriter2.setLenient(true);
        boolean isHtmlSafe = jsonWriter2.isHtmlSafe();
        jsonWriter2.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls2 = jsonWriter2.getSerializeNulls();
        jsonWriter2.setSerializeNulls(this.serializeNulls);
        try {
            adapter.write(jsonWriter2, obj2);
            jsonWriter2.setLenient(isLenient);
            jsonWriter2.setHtmlSafe(isHtmlSafe);
            jsonWriter2.setSerializeNulls(serializeNulls2);
        } catch (IOException e) {
            IOException iOException = e;
            JsonIOException jsonIOException2 = jsonIOException;
            JsonIOException jsonIOException3 = new JsonIOException((Throwable) iOException);
            throw jsonIOException2;
        } catch (Throwable th) {
            Throwable th2 = th;
            jsonWriter2.setLenient(isLenient);
            jsonWriter2.setHtmlSafe(isHtmlSafe);
            jsonWriter2.setSerializeNulls(serializeNulls2);
            throw th2;
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        JsonIOException jsonIOException;
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e) {
            IOException iOException = e;
            JsonIOException jsonIOException2 = jsonIOException;
            JsonIOException jsonIOException3 = new JsonIOException((Throwable) iOException);
            throw jsonIOException2;
        }
    }

    public JsonElement toJsonTree(Object obj) {
        Object obj2 = obj;
        return obj2 == null ? JsonNull.INSTANCE : toJsonTree(obj2, obj2.getClass());
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        JsonTreeWriter jsonTreeWriter;
        Object obj2 = obj;
        Type type2 = type;
        JsonTreeWriter jsonTreeWriter2 = jsonTreeWriter;
        JsonTreeWriter jsonTreeWriter3 = new JsonTreeWriter();
        JsonTreeWriter jsonTreeWriter4 = jsonTreeWriter2;
        toJson(obj2, type2, (JsonWriter) jsonTreeWriter4);
        return jsonTreeWriter4.get();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder("{serializeNulls:");
        return sb2.append(this.serializeNulls).append("factories:").append(this.factories).append(",instanceCreators:").append(this.constructorConstructor).append("}").toString();
    }
}
