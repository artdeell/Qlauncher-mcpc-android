package com.google.gson;

import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T> {
    public TypeAdapter() {
    }

    public final T fromJson(Reader reader) throws IOException {
        JsonReader jsonReader;
        JsonReader jsonReader2 = jsonReader;
        JsonReader jsonReader3 = new JsonReader(reader);
        return read(jsonReader2);
    }

    public final T fromJson(String str) throws IOException {
        StringReader stringReader;
        StringReader stringReader2 = stringReader;
        StringReader stringReader3 = new StringReader(str);
        return fromJson((Reader) stringReader2);
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        JsonIOException jsonIOException;
        JsonTreeReader jsonTreeReader;
        try {
            JsonTreeReader jsonTreeReader2 = jsonTreeReader;
            JsonTreeReader jsonTreeReader3 = new JsonTreeReader(jsonElement);
            return read(jsonTreeReader2);
        } catch (IOException e) {
            IOException iOException = e;
            JsonIOException jsonIOException2 = jsonIOException;
            JsonIOException jsonIOException3 = new JsonIOException((Throwable) iOException);
            throw jsonIOException2;
        }
    }

    public final TypeAdapter<T> nullSafe() {
        C04691 r4;
        C04691 r1 = r4;
        C04691 r2 = new TypeAdapter<T>(this) {
            final /* synthetic */ TypeAdapter this$0;

            {
                this.this$0 = r5;
            }

            public T read(JsonReader jsonReader) throws IOException {
                JsonReader jsonReader2 = jsonReader;
                if (jsonReader2.peek() != JsonToken.NULL) {
                    return this.this$0.read(jsonReader2);
                }
                jsonReader2.nextNull();
                return null;
            }

            public void write(JsonWriter jsonWriter, T t) throws IOException {
                JsonWriter jsonWriter2 = jsonWriter;
                T t2 = t;
                if (t2 == null) {
                    JsonWriter nullValue = jsonWriter2.nullValue();
                } else {
                    this.this$0.write(jsonWriter2, t2);
                }
            }
        };
        return r1;
    }

    public abstract T read(JsonReader jsonReader) throws IOException;

    public final String toJson(T t) throws IOException {
        StringWriter stringWriter;
        T t2 = t;
        StringWriter stringWriter2 = stringWriter;
        StringWriter stringWriter3 = new StringWriter();
        StringWriter stringWriter4 = stringWriter2;
        toJson(stringWriter4, t2);
        return stringWriter4.toString();
    }

    public final void toJson(Writer writer, T t) throws IOException {
        JsonWriter jsonWriter;
        T t2 = t;
        JsonWriter jsonWriter2 = jsonWriter;
        JsonWriter jsonWriter3 = new JsonWriter(writer);
        write(jsonWriter2, t2);
    }

    public final JsonElement toJsonTree(T t) {
        JsonIOException jsonIOException;
        JsonTreeWriter jsonTreeWriter;
        T t2 = t;
        try {
            JsonTreeWriter jsonTreeWriter2 = jsonTreeWriter;
            JsonTreeWriter jsonTreeWriter3 = new JsonTreeWriter();
            JsonTreeWriter jsonTreeWriter4 = jsonTreeWriter2;
            write(jsonTreeWriter4, t2);
            return jsonTreeWriter4.get();
        } catch (IOException e) {
            IOException iOException = e;
            JsonIOException jsonIOException2 = jsonIOException;
            JsonIOException jsonIOException3 = new JsonIOException((Throwable) iOException);
            throw jsonIOException2;
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t) throws IOException;
}
