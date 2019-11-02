package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class GsonBuilder {
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private Excluder excluder = Excluder.DEFAULT;
    private final List<TypeAdapterFactory> factories;
    private FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
    private boolean generateNonExecutableJson;
    private final List<TypeAdapterFactory> hierarchyFactories;
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
    private boolean prettyPrinting;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;

    public GsonBuilder() {
        HashMap hashMap;
        ArrayList arrayList;
        ArrayList arrayList2;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.instanceCreators = hashMap2;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList();
        this.factories = arrayList3;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = new ArrayList();
        this.hierarchyFactories = arrayList5;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.escapeHtmlChars = true;
    }

    private void addTypeAdaptersForDate(String str, int i, int i2, List<TypeAdapterFactory> list) {
        DefaultDateTypeAdapter defaultDateTypeAdapter;
        DefaultDateTypeAdapter defaultDateTypeAdapter2;
        DefaultDateTypeAdapter defaultDateTypeAdapter3;
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        List<TypeAdapterFactory> list2 = list;
        if (str2 != null && !LibrariesRepository.MOJANG_MAVEN_REPO.equals(str2.trim())) {
            DefaultDateTypeAdapter defaultDateTypeAdapter4 = defaultDateTypeAdapter3;
            DefaultDateTypeAdapter defaultDateTypeAdapter5 = new DefaultDateTypeAdapter(str2);
            defaultDateTypeAdapter2 = defaultDateTypeAdapter4;
        } else if (i3 != 2 && i4 != 2) {
            DefaultDateTypeAdapter defaultDateTypeAdapter6 = defaultDateTypeAdapter;
            DefaultDateTypeAdapter defaultDateTypeAdapter7 = new DefaultDateTypeAdapter(i3, i4);
            defaultDateTypeAdapter2 = defaultDateTypeAdapter6;
        } else {
            return;
        }
        boolean add = list2.add(TreeTypeAdapter.newFactory(TypeToken.get(Date.class), defaultDateTypeAdapter2));
        boolean add2 = list2.add(TreeTypeAdapter.newFactory(TypeToken.get(Timestamp.class), defaultDateTypeAdapter2));
        boolean add3 = list2.add(TreeTypeAdapter.newFactory(TypeToken.get(java.sql.Date.class), defaultDateTypeAdapter2));
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public Gson create() {
        ArrayList arrayList;
        Gson gson;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean addAll = arrayList4.addAll(this.factories);
        Collections.reverse(arrayList4);
        boolean addAll2 = arrayList4.addAll(this.hierarchyFactories);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList4);
        Gson gson2 = gson;
        Gson gson3 = new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, arrayList4);
        return gson2;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        this.excluder = this.excluder.withModifiers(iArr);
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        Type type2 = type;
        Object obj2 = obj;
        C$Gson$Preconditions.checkArgument((obj2 instanceof JsonSerializer) || (obj2 instanceof JsonDeserializer) || (obj2 instanceof InstanceCreator) || (obj2 instanceof TypeAdapter));
        if (obj2 instanceof InstanceCreator) {
            Object put = this.instanceCreators.put(type2, (InstanceCreator) obj2);
        }
        if ((obj2 instanceof JsonSerializer) || (obj2 instanceof JsonDeserializer)) {
            boolean add = this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type2), obj2));
        }
        if (obj2 instanceof TypeAdapter) {
            boolean add2 = this.factories.add(TypeAdapters.newFactory(TypeToken.get(type2), (TypeAdapter) obj2));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        boolean add = this.factories.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        Class<?> cls2 = cls;
        Object obj2 = obj;
        C$Gson$Preconditions.checkArgument((obj2 instanceof JsonSerializer) || (obj2 instanceof JsonDeserializer) || (obj2 instanceof TypeAdapter));
        if ((obj2 instanceof JsonDeserializer) || (obj2 instanceof JsonSerializer)) {
            this.hierarchyFactories.add(0, TreeTypeAdapter.newTypeHierarchyFactory(cls2, obj2));
        }
        if (obj2 instanceof TypeAdapter) {
            boolean add = this.factories.add(TypeAdapters.newTypeHierarchyFactory(cls2, (TypeAdapter) obj2));
        }
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setDateFormat(int i) {
        this.dateStyle = i;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int i, int i2) {
        int i3 = i2;
        this.dateStyle = i;
        this.timeStyle = i3;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        this.datePattern = str;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        ExclusionStrategy[] exclusionStrategyArr2 = exclusionStrategyArr;
        int length = exclusionStrategyArr2.length;
        for (int i = 0; i < length; i++) {
            this.excluder = this.excluder.withExclusionStrategy(exclusionStrategyArr2[i], true, true);
        }
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy2) {
        this.fieldNamingPolicy = fieldNamingPolicy2;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy2) {
        this.longSerializationPolicy = longSerializationPolicy2;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setVersion(double d) {
        this.excluder = this.excluder.withVersion(d);
        return this;
    }
}
