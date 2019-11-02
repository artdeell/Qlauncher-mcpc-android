package com.google.gson.stream;

import java.io.IOException;

public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(String str) {
        super(str);
    }

    public MalformedJsonException(String str, Throwable th) {
        Throwable th2 = th;
        super(str);
        Throwable initCause = initCause(th2);
    }

    public MalformedJsonException(Throwable th) {
        Throwable initCause = initCause(th);
    }
}
