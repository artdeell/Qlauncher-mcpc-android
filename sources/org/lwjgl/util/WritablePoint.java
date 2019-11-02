package org.lwjgl.util;

public interface WritablePoint {
    void setLocation(int i, int i2);

    void setLocation(ReadablePoint readablePoint);

    void setX(int i);

    void setY(int i);
}
