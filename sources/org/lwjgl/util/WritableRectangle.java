package org.lwjgl.util;

public interface WritableRectangle extends WritablePoint, WritableDimension {
    void setBounds(int i, int i2, int i3, int i4);

    void setBounds(ReadablePoint readablePoint, ReadableDimension readableDimension);

    void setBounds(ReadableRectangle readableRectangle);
}
