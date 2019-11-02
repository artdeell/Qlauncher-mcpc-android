package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat enUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat iso8601Format = buildIso8601Format();
    private final DateFormat localFormat = DateFormat.getDateTimeInstance(2, 2);

    static {
        C04921 r2;
        C04921 r0 = r2;
        C04921 r1 = new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                DateTypeAdapter dateTypeAdapter;
                Gson gson2 = gson;
                if (typeToken.getRawType() != Date.class) {
                    return null;
                }
                DateTypeAdapter dateTypeAdapter2 = dateTypeAdapter;
                DateTypeAdapter dateTypeAdapter3 = new DateTypeAdapter();
                return dateTypeAdapter2;
            }
        };
        FACTORY = r0;
    }

    public DateTypeAdapter() {
    }

    private static DateFormat buildIso8601Format() {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        SimpleDateFormat simpleDateFormat4 = simpleDateFormat2;
        simpleDateFormat4.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat4;
    }

    /* JADX INFO: finally extract failed */
    private Date deserializeToDate(String str) {
        JsonSyntaxException jsonSyntaxException;
        Date parse;
        String str2 = str;
        synchronized (this) {
            try {
                parse = this.localFormat.parse(str2);
            } catch (ParseException e) {
                ParseException parseException = e;
                try {
                    parse = this.enUsFormat.parse(str2);
                } catch (ParseException e2) {
                    ParseException parseException2 = e2;
                    try {
                        parse = this.iso8601Format.parse(str2);
                    } catch (ParseException e3) {
                        ParseException parseException3 = e3;
                        JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                        JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException(str2, parseException3);
                        throw jsonSyntaxException2;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        throw th2;
                    }
                }
            }
        }
        return parse;
    }

    public Date read(JsonReader jsonReader) throws IOException {
        JsonReader jsonReader2 = jsonReader;
        if (jsonReader2.peek() != JsonToken.NULL) {
            return deserializeToDate(jsonReader2.nextString());
        }
        jsonReader2.nextNull();
        return null;
    }

    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        JsonWriter jsonWriter2 = jsonWriter;
        Date date2 = date;
        synchronized (this) {
            if (date2 == null) {
                try {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            } else {
                JsonWriter value = jsonWriter2.value(this.enUsFormat.format(date2));
            }
        }
    }
}
