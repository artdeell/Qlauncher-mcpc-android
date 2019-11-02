package org.lwjgl.util;

public interface ReadableDimension {
    int getHeight();

    void getSize(WritableDimension writableDimension);

    int getWidth();
}
