package com.google.gson.internal;

/* renamed from: com.google.gson.internal.$Gson$Preconditions reason: invalid class name */
public final class C$Gson$Preconditions {
    public C$Gson$Preconditions() {
    }

    public static void checkArgument(boolean z) {
        IllegalArgumentException illegalArgumentException;
        if (!z) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }
    }

    public static <T> T checkNotNull(T t) {
        NullPointerException nullPointerException;
        T t2 = t;
        if (t2 != null) {
            return t2;
        }
        NullPointerException nullPointerException2 = nullPointerException;
        NullPointerException nullPointerException3 = new NullPointerException();
        throw nullPointerException2;
    }
}
