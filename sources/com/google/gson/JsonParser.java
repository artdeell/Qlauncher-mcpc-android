package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public JsonParser() {
    }

    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        JsonParseException jsonParseException;
        StringBuilder sb;
        JsonParseException jsonParseException2;
        StringBuilder sb2;
        JsonReader jsonReader2 = jsonReader;
        boolean isLenient = jsonReader2.isLenient();
        jsonReader2.setLenient(true);
        try {
            JsonElement parse = Streams.parse(jsonReader2);
            jsonReader2.setLenient(isLenient);
            return parse;
        } catch (StackOverflowError e) {
            StackOverflowError stackOverflowError = e;
            JsonParseException jsonParseException3 = jsonParseException2;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            JsonParseException jsonParseException4 = new JsonParseException(sb3.append("Failed parsing JSON source: ").append(jsonReader2).append(" to Json").toString(), stackOverflowError);
            throw jsonParseException3;
        } catch (OutOfMemoryError e2) {
            OutOfMemoryError outOfMemoryError = e2;
            JsonParseException jsonParseException5 = jsonParseException;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            JsonParseException jsonParseException6 = new JsonParseException(sb5.append("Failed parsing JSON source: ").append(jsonReader2).append(" to Json").toString(), outOfMemoryError);
            throw jsonParseException5;
        } catch (Throwable th) {
            Throwable th2 = th;
            jsonReader2.setLenient(isLenient);
            throw th2;
        }
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        JsonSyntaxException jsonSyntaxException;
        JsonIOException jsonIOException;
        JsonSyntaxException jsonSyntaxException2;
        JsonReader jsonReader;
        JsonSyntaxException jsonSyntaxException3;
        try {
            JsonReader jsonReader2 = jsonReader;
            JsonReader jsonReader3 = new JsonReader(reader);
            JsonReader jsonReader4 = jsonReader2;
            JsonElement parse = parse(jsonReader4);
            if (parse.isJsonNull() || jsonReader4.peek() == JsonToken.END_DOCUMENT) {
                return parse;
            }
            JsonSyntaxException jsonSyntaxException4 = jsonSyntaxException3;
            JsonSyntaxException jsonSyntaxException5 = new JsonSyntaxException("Did not consume the entire document.");
            throw jsonSyntaxException4;
        } catch (MalformedJsonException e) {
            MalformedJsonException malformedJsonException = e;
            JsonSyntaxException jsonSyntaxException6 = jsonSyntaxException2;
            JsonSyntaxException jsonSyntaxException7 = new JsonSyntaxException((Throwable) malformedJsonException);
            throw jsonSyntaxException6;
        } catch (IOException e2) {
            IOException iOException = e2;
            JsonIOException jsonIOException2 = jsonIOException;
            JsonIOException jsonIOException3 = new JsonIOException((Throwable) iOException);
            throw jsonIOException2;
        } catch (NumberFormatException e3) {
            NumberFormatException numberFormatException = e3;
            JsonSyntaxException jsonSyntaxException8 = jsonSyntaxException;
            JsonSyntaxException jsonSyntaxException9 = new JsonSyntaxException((Throwable) numberFormatException);
            throw jsonSyntaxException8;
        }
    }

    public JsonElement parse(String str) throws JsonSyntaxException {
        StringReader stringReader;
        StringReader stringReader2 = stringReader;
        StringReader stringReader3 = new StringReader(str);
        return parse((Reader) stringReader2);
    }
}
