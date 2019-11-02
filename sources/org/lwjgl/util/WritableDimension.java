package org.lwjgl.util;

public interface WritableDimension {
    void setHeight(int i);

    void setSize(int i, int i2);

    void setSize(ReadableDimension readableDimension);

    void setWidth(int i);
}
