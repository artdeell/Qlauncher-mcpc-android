package org.lwjgl.util;

public interface ReadablePoint {
    void getLocation(WritablePoint writablePoint);

    int getX();

    int getY();
}
