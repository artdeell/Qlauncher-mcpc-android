package org.lwjgl.util;

import java.io.Serializable;
import java.nio.ByteBuffer;

public final class Color implements ReadableColor, Serializable, WritableColor {
    static final long serialVersionUID = 1;
    private byte alpha;
    private byte blue;
    private byte green;
    private byte red;

    public Color() {
        this(0, 0, 0, 255);
    }

    public Color(byte b, byte b2, byte b3) {
        this(b, b2, b3, -1);
    }

    public Color(byte b, byte b2, byte b3, byte b4) {
        set(b, b2, b3, b4);
    }

    public Color(int i, int i2, int i3) {
        this(i, i2, i3, 255);
    }

    public Color(int i, int i2, int i3, int i4) {
        set(i, i2, i3, i4);
    }

    public Color(ReadableColor readableColor) {
        setColor(readableColor);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return obj2 != null && (obj2 instanceof ReadableColor) && ((ReadableColor) obj2).getRed() == getRed() && ((ReadableColor) obj2).getGreen() == getGreen() && ((ReadableColor) obj2).getBlue() == getBlue() && ((ReadableColor) obj2).getAlpha() == getAlpha();
    }

    public void fromHSB(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        if (f5 == 0.0f) {
            byte b = (byte) ((int) (0.5f + (f6 * 255.0f)));
            this.blue = b;
            this.green = b;
            this.red = b;
            return;
        }
        float floor = 6.0f * (f4 - ((float) Math.floor((double) f4)));
        float floor2 = floor - ((float) Math.floor((double) floor));
        float f7 = f6 * (1.0f - f5);
        float f8 = f6 * (1.0f - (f5 * floor2));
        float f9 = f6 * (1.0f - (f5 * (1.0f - floor2)));
        switch ((int) floor) {
            case 0:
                this.red = (byte) ((int) (0.5f + (f6 * 255.0f)));
                this.green = (byte) ((int) (0.5f + (f9 * 255.0f)));
                this.blue = (byte) ((int) (0.5f + (f7 * 255.0f)));
                return;
            case 1:
                this.red = (byte) ((int) (0.5f + (f8 * 255.0f)));
                this.green = (byte) ((int) (0.5f + (f6 * 255.0f)));
                this.blue = (byte) ((int) (0.5f + (f7 * 255.0f)));
                return;
            case 2:
                this.red = (byte) ((int) (0.5f + (f7 * 255.0f)));
                this.green = (byte) ((int) (0.5f + (f6 * 255.0f)));
                this.blue = (byte) ((int) (0.5f + (f9 * 255.0f)));
                return;
            case 3:
                this.red = (byte) ((int) (0.5f + (f7 * 255.0f)));
                this.green = (byte) ((int) (0.5f + (f8 * 255.0f)));
                this.blue = (byte) ((int) (0.5f + (f6 * 255.0f)));
                return;
            case 4:
                this.red = (byte) ((int) (0.5f + (f9 * 255.0f)));
                this.green = (byte) ((int) (0.5f + (f7 * 255.0f)));
                this.blue = (byte) ((int) (0.5f + (f6 * 255.0f)));
                return;
            case 5:
                this.red = (byte) ((int) (0.5f + (f6 * 255.0f)));
                this.green = (byte) ((int) (0.5f + (f7 * 255.0f)));
                this.blue = (byte) ((int) (0.5f + (f8 * 255.0f)));
                return;
            default:
                return;
        }
    }

    public int getAlpha() {
        return 255 & this.alpha;
    }

    public byte getAlphaByte() {
        return this.alpha;
    }

    public int getBlue() {
        return 255 & this.blue;
    }

    public byte getBlueByte() {
        return this.blue;
    }

    public int getGreen() {
        return 255 & this.green;
    }

    public byte getGreenByte() {
        return this.green;
    }

    public int getRed() {
        return 255 & this.red;
    }

    public byte getRedByte() {
        return this.red;
    }

    public int hashCode() {
        return (this.red << 24) | (this.green << 16) | (this.blue << 8) | this.alpha;
    }

    public void readABGR(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.alpha = byteBuffer2.get();
        this.blue = byteBuffer2.get();
        this.green = byteBuffer2.get();
        this.red = byteBuffer2.get();
    }

    public void readARGB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.alpha = byteBuffer2.get();
        this.red = byteBuffer2.get();
        this.green = byteBuffer2.get();
        this.blue = byteBuffer2.get();
    }

    public void readBGR(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.blue = byteBuffer2.get();
        this.green = byteBuffer2.get();
        this.red = byteBuffer2.get();
    }

    public void readBGRA(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.blue = byteBuffer2.get();
        this.green = byteBuffer2.get();
        this.red = byteBuffer2.get();
        this.alpha = byteBuffer2.get();
    }

    public void readRGB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.red = byteBuffer2.get();
        this.green = byteBuffer2.get();
        this.blue = byteBuffer2.get();
    }

    public void readRGBA(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        this.red = byteBuffer2.get();
        this.green = byteBuffer2.get();
        this.blue = byteBuffer2.get();
        this.alpha = byteBuffer2.get();
    }

    public void set(byte b, byte b2, byte b3) {
        set(b, b2, b3, -1);
    }

    public void set(byte b, byte b2, byte b3, byte b4) {
        byte b5 = b2;
        byte b6 = b3;
        byte b7 = b4;
        this.red = b;
        this.green = b5;
        this.blue = b6;
        this.alpha = b7;
    }

    public void set(int i, int i2, int i3) {
        set(i, i2, i3, 255);
    }

    public void set(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        this.red = (byte) i;
        this.green = (byte) i5;
        this.blue = (byte) i6;
        this.alpha = (byte) i7;
    }

    public void setAlpha(byte b) {
        byte b2 = b;
        this.alpha = b2;
    }

    public void setAlpha(int i) {
        byte b = (byte) i;
        this.alpha = b;
    }

    public void setBlue(byte b) {
        byte b2 = b;
        this.blue = b2;
    }

    public void setBlue(int i) {
        byte b = (byte) i;
        this.blue = b;
    }

    public void setColor(ReadableColor readableColor) {
        ReadableColor readableColor2 = readableColor;
        this.red = readableColor2.getRedByte();
        this.green = readableColor2.getGreenByte();
        this.blue = readableColor2.getBlueByte();
        this.alpha = readableColor2.getAlphaByte();
    }

    public void setGreen(byte b) {
        byte b2 = b;
        this.green = b2;
    }

    public void setGreen(int i) {
        byte b = (byte) i;
        this.green = b;
    }

    public void setRed(byte b) {
        byte b2 = b;
        this.red = b2;
    }

    public void setRed(int i) {
        byte b = (byte) i;
        this.red = b;
    }

    public float[] toHSB(float[] fArr) {
        float f;
        float[] fArr2 = fArr;
        int red2 = getRed();
        int green2 = getGreen();
        int blue2 = getBlue();
        if (fArr2 == null) {
            fArr2 = new float[3];
        }
        int i = red2 <= green2 ? green2 : red2;
        if (blue2 > i) {
            i = blue2;
        }
        int i2 = red2 >= green2 ? green2 : red2;
        if (blue2 < i2) {
            i2 = blue2;
        }
        float f2 = ((float) i) / 255.0f;
        float f3 = i != 0 ? ((float) (i - i2)) / ((float) i) : 0.0f;
        if (f3 == 0.0f) {
            f = 0.0f;
        } else {
            float f4 = ((float) (i - red2)) / ((float) (i - i2));
            float f5 = ((float) (i - green2)) / ((float) (i - i2));
            float f6 = ((float) (i - blue2)) / ((float) (i - i2));
            float f7 = red2 == i ? f6 - f5 : green2 == i ? (2.0f + f4) - f6 : (4.0f + f5) - f4;
            f = f7 / 6.0f;
            if (f < 0.0f) {
                f += 1.0f;
            }
        }
        fArr2[0] = f;
        fArr2[1] = f3;
        fArr2[2] = f2;
        return fArr2;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("Color [").append(getRed()).append(", ").append(getGreen()).append(", ").append(getBlue()).append(", ").append(getAlpha()).append("]").toString();
    }

    public void writeABGR(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer put = byteBuffer2.put(this.alpha);
        ByteBuffer put2 = byteBuffer2.put(this.blue);
        ByteBuffer put3 = byteBuffer2.put(this.green);
        ByteBuffer put4 = byteBuffer2.put(this.red);
    }

    public void writeARGB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer put = byteBuffer2.put(this.alpha);
        ByteBuffer put2 = byteBuffer2.put(this.red);
        ByteBuffer put3 = byteBuffer2.put(this.green);
        ByteBuffer put4 = byteBuffer2.put(this.blue);
    }

    public void writeBGR(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer put = byteBuffer2.put(this.blue);
        ByteBuffer put2 = byteBuffer2.put(this.green);
        ByteBuffer put3 = byteBuffer2.put(this.red);
    }

    public void writeBGRA(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer put = byteBuffer2.put(this.blue);
        ByteBuffer put2 = byteBuffer2.put(this.green);
        ByteBuffer put3 = byteBuffer2.put(this.red);
        ByteBuffer put4 = byteBuffer2.put(this.alpha);
    }

    public void writeRGB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer put = byteBuffer2.put(this.red);
        ByteBuffer put2 = byteBuffer2.put(this.green);
        ByteBuffer put3 = byteBuffer2.put(this.blue);
    }

    public void writeRGBA(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer put = byteBuffer2.put(this.red);
        ByteBuffer put2 = byteBuffer2.put(this.green);
        ByteBuffer put3 = byteBuffer2.put(this.blue);
        ByteBuffer put4 = byteBuffer2.put(this.alpha);
    }
}
