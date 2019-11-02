package org.lwjgl.opengl;

public class OpenGLException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public OpenGLException() {
    }

    public OpenGLException(int i) {
        this(createErrorMessage(i));
    }

    public OpenGLException(String str) {
        super(str);
    }

    public OpenGLException(String str, Throwable th) {
        super(str, th);
    }

    public OpenGLException(Throwable th) {
        super(th);
    }

    private static String createErrorMessage(int i) {
        StringBuilder sb;
        int i2 = i;
        String translateGLErrorString = Util.translateGLErrorString(i2);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(translateGLErrorString).append(" (").append(i2).append(")").toString();
    }
}
