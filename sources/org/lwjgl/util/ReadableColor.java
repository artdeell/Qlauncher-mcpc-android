package org.lwjgl.util;

import java.nio.ByteBuffer;

public interface ReadableColor {
    public static final ReadableColor BLACK;
    public static final ReadableColor BLUE;
    public static final ReadableColor CYAN;
    public static final ReadableColor DKGREY;
    public static final ReadableColor GREEN;
    public static final ReadableColor GREY;
    public static final ReadableColor LTGREY;
    public static final ReadableColor ORANGE;
    public static final ReadableColor PURPLE;
    public static final ReadableColor RED;
    public static final ReadableColor WHITE;
    public static final ReadableColor YELLOW;

    static {
        Color color;
        Color color2;
        Color color3;
        Color color4;
        Color color5;
        Color color6;
        Color color7;
        Color color8;
        Color color9;
        Color color10;
        Color color11;
        Color color12;
        Color color13 = color;
        Color color14 = new Color(255, 0, 0);
        RED = color13;
        Color color15 = color2;
        Color color16 = new Color(255, 128, 0);
        ORANGE = color15;
        Color color17 = color3;
        Color color18 = new Color(255, 255, 0);
        YELLOW = color17;
        Color color19 = color4;
        Color color20 = new Color(0, 255, 0);
        GREEN = color19;
        Color color21 = color5;
        Color color22 = new Color(0, 255, 255);
        CYAN = color21;
        Color color23 = color6;
        Color color24 = new Color(0, 0, 255);
        BLUE = color23;
        Color color25 = color7;
        Color color26 = new Color(255, 0, 255);
        PURPLE = color25;
        Color color27 = color8;
        Color color28 = new Color(255, 255, 255);
        WHITE = color27;
        Color color29 = color9;
        Color color30 = new Color(0, 0, 0);
        BLACK = color29;
        Color color31 = color10;
        Color color32 = new Color(192, 192, 192);
        LTGREY = color31;
        Color color33 = color11;
        Color color34 = new Color(64, 64, 64);
        DKGREY = color33;
        Color color35 = color12;
        Color color36 = new Color(128, 128, 128);
        GREY = color35;
    }

    int getAlpha();

    byte getAlphaByte();

    int getBlue();

    byte getBlueByte();

    int getGreen();

    byte getGreenByte();

    int getRed();

    byte getRedByte();

    void writeABGR(ByteBuffer byteBuffer);

    void writeARGB(ByteBuffer byteBuffer);

    void writeBGR(ByteBuffer byteBuffer);

    void writeBGRA(ByteBuffer byteBuffer);

    void writeRGB(ByteBuffer byteBuffer);

    void writeRGBA(ByteBuffer byteBuffer);
}
