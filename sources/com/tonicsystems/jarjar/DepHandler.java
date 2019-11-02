package com.tonicsystems.jarjar;

import java.io.IOException;

public interface DepHandler {
    public static final int LEVEL_CLASS = 0;
    public static final int LEVEL_JAR = 1;

    void handle(PathClass pathClass, PathClass pathClass2) throws IOException;

    void handleEnd() throws IOException;

    void handleStart() throws IOException;
}
