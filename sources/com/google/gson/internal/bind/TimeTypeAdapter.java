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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;

    static {
        C04991 r2;
        C04991 r0 = r2;
        C04991 r1 = new TypeAdapterFactory() {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                TimeTypeAdapter timeTypeAdapter;
                Gson gson2 = gson;
                if (typeToken.getRawType() != Time.class) {
                    return null;
                }
                TimeTypeAdapter timeTypeAdapter2 = timeTypeAdapter;
                TimeTypeAdapter timeTypeAdapter3 = new TimeTypeAdapter();
                return timeTypeAdapter2;
            }
        };
        FACTORY = r0;
    }

    public TimeTypeAdapter() {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("hh:mm:ss a");
        this.format = simpleDateFormat2;
    }

    public Time read(JsonReader jsonReader) throws IOException {
        JsonSyntaxException jsonSyntaxException;
        Time time;
        Time time2;
        JsonReader jsonReader2 = jsonReader;
        synchronized (this) {
            try {
                if (jsonReader2.peek() == JsonToken.NULL) {
                    jsonReader2.nextNull();
                    time2 = null;
                } else {
                    Time time3 = time;
                    Time time4 = new Time(this.format.parse(jsonReader2.nextString()).getTime());
                    time2 = time3;
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
        return time2;
    }

    public void write(JsonWriter jsonWriter, Time time) throws IOException {
        JsonWriter jsonWriter2 = jsonWriter;
        Time time2 = time;
        synchronized (this) {
            try {
                JsonWriter value = jsonWriter2.value(time2 == null ? null : this.format.format(time2));
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
