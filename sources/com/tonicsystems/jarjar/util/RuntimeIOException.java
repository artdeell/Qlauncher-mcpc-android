package com.tonicsystems.jarjar.util;

import java.io.IOException;

public class RuntimeIOException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public RuntimeIOException(IOException iOException) {
        super(iOException);
    }
}
