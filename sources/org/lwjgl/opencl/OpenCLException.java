package org.lwjgl.opencl;

public class OpenCLException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public OpenCLException() {
    }

    public OpenCLException(String str) {
        super(str);
    }

    public OpenCLException(String str, Throwable th) {
        super(str, th);
    }

    public OpenCLException(Throwable th) {
        super(th);
    }
}
