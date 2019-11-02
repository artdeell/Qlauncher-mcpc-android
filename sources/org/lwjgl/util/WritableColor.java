package org.lwjgl.util;

import java.nio.ByteBuffer;

public interface WritableColor {
    void readABGR(ByteBuffer byteBuffer);

    void readARGB(ByteBuffer byteBuffer);

    void readBGR(ByteBuffer byteBuffer);

    void readBGRA(ByteBuffer byteBuffer);

    void readRGB(ByteBuffer byteBuffer);

    void readRGBA(ByteBuffer byteBuffer);

    void set(byte b, byte b2, byte b3);

    void set(byte b, byte b2, byte b3, byte b4);

    void set(int i, int i2, int i3);

    void set(int i, int i2, int i3, int i4);

    void setAlpha(byte b);

    void setAlpha(int i);

    void setBlue(byte b);

    void setBlue(int i);

    void setColor(ReadableColor readableColor);

    void setGreen(byte b);

    void setGreen(int i);

    void setRed(byte b);

    void setRed(int i);
}
