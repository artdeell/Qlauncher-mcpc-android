package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class DefaultDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private final DateFormat enUsFormat;
    private final DateFormat iso8601Format;
    private final DateFormat localFormat;

    DefaultDateTypeAdapter() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    DefaultDateTypeAdapter(int i) {
        int i2 = i;
        this(DateFormat.getDateInstance(i2, Locale.US), DateFormat.getDateInstance(i2));
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this(DateFormat.getDateTimeInstance(i3, i4, Locale.US), DateFormat.getDateTimeInstance(i3, i4));
    }

    DefaultDateTypeAdapter(String str) {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        String str2 = str;
        SimpleDateFormat simpleDateFormat3 = simpleDateFormat;
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(str2, Locale.US);
        SimpleDateFormat simpleDateFormat5 = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat(str2);
        this((DateFormat) simpleDateFormat3, (DateFormat) simpleDateFormat5);
    }

    DefaultDateTypeAdapter(DateFormat dateFormat, DateFormat dateFormat2) {
        SimpleDateFormat simpleDateFormat;
        DateFormat dateFormat3 = dateFormat2;
        this.enUsFormat = dateFormat;
        this.localFormat = dateFormat3;
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.iso8601Format = simpleDateFormat2;
        this.iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date deserializeToDate(JsonElement jsonElement) {
        JsonSyntaxException jsonSyntaxException;
        Date parse;
        JsonElement jsonElement2 = jsonElement;
        DateFormat dateFormat = this.localFormat;
        synchronized (dateFormat) {
            try {
                parse = this.localFormat.parse(jsonElement2.getAsString());
            } catch (ParseException e) {
                ParseException parseException = e;
                JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException(jsonElement2.getAsString(), parseException);
                throw jsonSyntaxException2;
            } catch (ParseException e2) {
                ParseException parseException2 = e2;
                try {
                    DateFormat dateFormat2 = dateFormat;
                    return this.enUsFormat.parse(jsonElement2.getAsString());
                } catch (ParseException e3) {
                    ParseException parseException3 = e3;
                    DateFormat dateFormat3 = dateFormat;
                    return this.iso8601Format.parse(jsonElement2.getAsString());
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                DateFormat dateFormat4 = dateFormat;
                throw th2;
            }
        }
        return parse;
    }

    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        java.sql.Date date;
        Timestamp timestamp;
        JsonParseException jsonParseException;
        JsonElement jsonElement2 = jsonElement;
        Type type2 = type;
        JsonDeserializationContext jsonDeserializationContext2 = jsonDeserializationContext;
        if (!(jsonElement2 instanceof JsonPrimitive)) {
            JsonParseException jsonParseException2 = jsonParseException;
            JsonParseException jsonParseException3 = new JsonParseException("The date should be a string value");
            throw jsonParseException2;
        }
        Date deserializeToDate = deserializeToDate(jsonElement2);
        if (type2 == Date.class) {
            return deserializeToDate;
        }
        if (type2 == Timestamp.class) {
            Timestamp timestamp2 = timestamp;
            Timestamp timestamp3 = new Timestamp(deserializeToDate.getTime());
            return timestamp2;
        } else if (type2 == java.sql.Date.class) {
            java.sql.Date date2 = date;
            java.sql.Date date3 = new java.sql.Date(deserializeToDate.getTime());
            return date2;
        } else {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append(getClass()).append(" cannot deserialize to ").append(type2).toString());
            throw illegalArgumentException2;
        }
    }

    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonPrimitive jsonPrimitive;
        Date date2 = date;
        Type type2 = type;
        JsonSerializationContext jsonSerializationContext2 = jsonSerializationContext;
        JsonPrimitive jsonPrimitive2 = this.localFormat;
        synchronized (jsonPrimitive2) {
            try {
                JsonPrimitive jsonPrimitive3 = jsonPrimitive;
                JsonPrimitive jsonPrimitive4 = new JsonPrimitive(this.enUsFormat.format(date2));
                th = jsonPrimitive3;
            } finally {
                Throwable th = th;
                JsonPrimitive jsonPrimitive5 = jsonPrimitive2;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(DefaultDateTypeAdapter.class.getSimpleName());
        StringBuilder append2 = sb4.append('(').append(this.localFormat.getClass().getSimpleName()).append(')');
        return sb4.toString();
    }
}
