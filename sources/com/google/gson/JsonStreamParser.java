package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader;
        Object obj;
        JsonReader jsonReader2 = jsonReader;
        JsonReader jsonReader3 = new JsonReader(reader);
        this.parser = jsonReader2;
        this.parser.setLenient(true);
        Object obj2 = obj;
        Object obj3 = new Object();
        this.lock = obj2;
    }

    public JsonStreamParser(String str) {
        StringReader stringReader;
        StringReader stringReader2 = stringReader;
        StringReader stringReader3 = new StringReader(str);
        this((Reader) stringReader2);
    }

    public boolean hasNext() {
        JsonIOException jsonIOException;
        JsonSyntaxException jsonSyntaxException;
        boolean z;
        Object obj = this.lock;
        synchronized (obj) {
            try {
                z = this.parser.peek() != JsonToken.END_DOCUMENT;
            } catch (MalformedJsonException e) {
                MalformedJsonException malformedJsonException = e;
                JsonSyntaxException jsonSyntaxException2 = jsonSyntaxException;
                JsonSyntaxException jsonSyntaxException3 = new JsonSyntaxException((Throwable) malformedJsonException);
                throw jsonSyntaxException2;
            } catch (IOException e2) {
                IOException iOException = e2;
                JsonIOException jsonIOException2 = jsonIOException;
                JsonIOException jsonIOException3 = new JsonIOException((Throwable) iOException);
                throw jsonIOException2;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r5v3, types: [com.google.gson.JsonParseException] */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r5v4, types: [com.google.gson.JsonParseException] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r5v7, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.JsonElement next() throws com.google.gson.JsonParseException {
        /*
            r10 = this;
            r0 = r10
            r5 = r0
            boolean r5 = r5.hasNext()
            if (r5 != 0) goto L_0x0011
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            r9 = r5
            r5 = r9
            r6 = r9
            r6.<init>()
            throw r5
        L_0x0011:
            r5 = r0
            com.google.gson.stream.JsonReader r5 = r5.parser     // Catch:{ StackOverflowError -> 0x001c, OutOfMemoryError -> 0x002a, JsonParseException -> 0x0038 }
            com.google.gson.JsonElement r5 = com.google.gson.internal.Streams.parse(r5)     // Catch:{ StackOverflowError -> 0x001c, OutOfMemoryError -> 0x002a, JsonParseException -> 0x0038 }
            r4 = r5
            r5 = r4
            r0 = r5
            return r0
        L_0x001c:
            r5 = move-exception
            r3 = r5
            com.google.gson.JsonParseException r5 = new com.google.gson.JsonParseException
            r9 = r5
            r5 = r9
            r6 = r9
            java.lang.String r7 = "Failed parsing JSON source to Json"
            r8 = r3
            r6.<init>(r7, r8)
            throw r5
        L_0x002a:
            r5 = move-exception
            r2 = r5
            com.google.gson.JsonParseException r5 = new com.google.gson.JsonParseException
            r9 = r5
            r5 = r9
            r6 = r9
            java.lang.String r7 = "Failed parsing JSON source to Json"
            r8 = r2
            r6.<init>(r7, r8)
            throw r5
        L_0x0038:
            r5 = move-exception
            r1 = r5
            r5 = r1
            java.lang.Throwable r5 = r5.getCause()
            boolean r5 = r5 instanceof java.io.EOFException
            if (r5 == 0) goto L_0x004c
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            r9 = r5
            r5 = r9
            r6 = r9
            r6.<init>()
            r1 = r5
        L_0x004c:
            r5 = r1
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.JsonStreamParser.next():com.google.gson.JsonElement");
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }
}
