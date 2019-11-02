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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;

    static {
        C04981 r2;
        C04981 r0 = r2;
        C04981 r1 = new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                SqlDateTypeAdapter sqlDateTypeAdapter;
                Gson gson2 = gson;
                if (typeToken.getRawType() != Date.class) {
                    return null;
                }
                SqlDateTypeAdapter sqlDateTypeAdapter2 = sqlDateTypeAdapter;
                SqlDateTypeAdapter sqlDateTypeAdapter3 = new SqlDateTypeAdapter();
                return sqlDateTypeAdapter2;
            }
        };
        FACTORY = r0;
    }

    public SqlDateTypeAdapter() {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MMM d, yyyy");
        this.format = simpleDateFormat2;
    }

    public Date read(JsonReader jsonReader) throws IOException {
        JsonSyntaxException jsonSyntaxException;
        Date date;
        Date date2;
        JsonReader jsonReader2 = jsonReader;
        synchronized (this) {
            try {
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    date2 = null;
                } else {
                    Date date3 = date;
                    Date date4 = new Date(this.format.parse(jsonReader2.nextString()).getTime());
                    date2 = date3;
                }
            } catch (ParseException e) {
                ParseException parseException = e;
                JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) parseException);
                throw jsonSyntaxException2;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
        return date2;
    }

    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        JsonWriter jsonWriter2 = jsonWriter;
        Date date2 = date;
        synchronized (this) {
            try {
                JsonWriter value = jsonWriter2.value(date2 == null ? null : this.format.format(date2));
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
