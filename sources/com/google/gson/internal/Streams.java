package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class Streams {

    private static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        static class CurrentWrite implements CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            public char charAt(int i) {
                return this.chars[i];
            }

            public int length() {
                return this.chars.length;
            }

            public CharSequence subSequence(int i, int i2) {
                String str;
                int i3 = i;
                String str2 = str;
                String str3 = new String(this.chars, i3, i2 - i3);
                return str2;
            }
        }

        private AppendableWriter(Appendable appendable2) {
            CurrentWrite currentWrite2;
            Appendable appendable3 = appendable2;
            CurrentWrite currentWrite3 = currentWrite2;
            CurrentWrite currentWrite4 = new CurrentWrite();
            this.currentWrite = currentWrite3;
            this.appendable = appendable3;
        }

        /* synthetic */ AppendableWriter(Appendable appendable2, C04861 r7) {
            C04861 r2 = r7;
            this(appendable2);
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) throws IOException {
            Appendable append = this.appendable.append((char) i);
        }

        public void write(char[] cArr, int i, int i2) throws IOException {
            int i3 = i;
            int i4 = i2;
            this.currentWrite.chars = cArr;
            Appendable append = this.appendable.append(this.currentWrite, i3, i3 + i4);
        }
    }

    public Streams() {
    }

    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        JsonSyntaxException jsonSyntaxException;
        JsonIOException jsonIOException;
        JsonSyntaxException jsonSyntaxException2;
        JsonSyntaxException jsonSyntaxException3;
        JsonReader jsonReader2 = jsonReader;
        boolean z = true;
        try {
            JsonToken peek = jsonReader2.peek();
            z = false;
            return (JsonElement) TypeAdapters.JSON_ELEMENT.read(jsonReader2);
        } catch (EOFException e) {
            EOFException eOFException = e;
            if (z) {
                return JsonNull.INSTANCE;
            }
            JsonSyntaxException jsonSyntaxException4 = jsonSyntaxException3;
            JsonSyntaxException jsonSyntaxException5 = new JsonSyntaxException((Throwable) eOFException);
            throw jsonSyntaxException4;
        } catch (MalformedJsonException e2) {
            MalformedJsonException malformedJsonException = e2;
            JsonSyntaxException jsonSyntaxException6 = jsonSyntaxException2;
            JsonSyntaxException jsonSyntaxException7 = new JsonSyntaxException((Throwable) malformedJsonException);
            throw jsonSyntaxException6;
        } catch (IOException e3) {
            IOException iOException = e3;
            JsonIOException jsonIOException2 = jsonIOException;
            JsonIOException jsonIOException3 = new JsonIOException((Throwable) iOException);
            throw jsonIOException2;
        } catch (NumberFormatException e4) {
            NumberFormatException numberFormatException = e4;
            JsonSyntaxException jsonSyntaxException8 = jsonSyntaxException;
            JsonSyntaxException jsonSyntaxException9 = new JsonSyntaxException((Throwable) numberFormatException);
            throw jsonSyntaxException8;
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        JsonWriter jsonWriter2 = jsonWriter;
        TypeAdapters.JSON_ELEMENT.write(jsonWriter2, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        AppendableWriter appendableWriter;
        Appendable appendable2 = appendable;
        if (appendable2 instanceof Writer) {
            return (Writer) appendable2;
        }
        AppendableWriter appendableWriter2 = appendableWriter;
        AppendableWriter appendableWriter3 = new AppendableWriter(appendable2, null);
        return appendableWriter2;
    }
}
