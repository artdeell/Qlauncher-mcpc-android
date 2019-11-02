package org.lwjgl.openal;

public class OpenALException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public OpenALException() {
    }

    public OpenALException(int i) {
        StringBuilder sb;
        int i2 = i;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        super(sb2.append("OpenAL error: ").append(AL10.alGetString(i2)).append(" (").append(i2).append(")").toString());
    }

    public OpenALException(String str) {
        super(str);
    }

    public OpenALException(String str, Throwable th) {
        super(str, th);
    }

    public OpenALException(Throwable th) {
        super(th);
    }
}
