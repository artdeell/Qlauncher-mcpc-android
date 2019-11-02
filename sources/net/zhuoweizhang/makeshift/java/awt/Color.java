package net.zhuoweizhang.makeshift.java.awt;

import java.io.Serializable;

public class Color implements Serializable {
    public static final Color BLACK = black;
    public static final Color BLUE = blue;
    public static final Color CYAN = cyan;
    public static final Color DARK_GRAY = darkGray;
    public static final Color GRAY = gray;
    public static final Color GREEN = green;
    public static final Color LIGHT_GRAY = lightGray;
    public static final Color MAGENTA = magenta;
    private static final int MIN_SCALABLE = 3;
    public static final Color ORANGE = orange;
    public static final Color PINK = pink;
    public static final Color RED = red;
    private static final double SCALE_FACTOR = 0.7d;
    public static final Color WHITE = white;
    public static final Color YELLOW = yellow;
    public static final Color black;
    public static final Color blue;
    public static final Color cyan;
    public static final Color darkGray;
    public static final Color gray;
    public static final Color green;
    public static final Color lightGray;
    public static final Color magenta;
    public static final Color orange;
    public static final Color pink;
    public static final Color red;
    private static final long serialVersionUID = 118526816881161077L;
    public static final Color white;
    public static final Color yellow;
    private float falpha;
    private float[] frgbvalue;
    private float[] fvalue;
    int value;

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
        Color color13;
        Color color14 = color;
        Color color15 = new Color(255, 255, 255);
        white = color14;
        Color color16 = color2;
        Color color17 = new Color(192, 192, 192);
        lightGray = color16;
        Color color18 = color3;
        Color color19 = new Color(128, 128, 128);
        gray = color18;
        Color color20 = color4;
        Color color21 = new Color(64, 64, 64);
        darkGray = color20;
        Color color22 = color5;
        Color color23 = new Color(0, 0, 0);
        black = color22;
        Color color24 = color6;
        Color color25 = new Color(255, 0, 0);
        red = color24;
        Color color26 = color7;
        Color color27 = new Color(255, 175, 175);
        pink = color26;
        Color color28 = color8;
        Color color29 = new Color(255, 200, 0);
        orange = color28;
        Color color30 = color9;
        Color color31 = new Color(255, 255, 0);
        yellow = color30;
        Color color32 = color10;
        Color color33 = new Color(0, 255, 0);
        green = color32;
        Color color34 = color11;
        Color color35 = new Color(255, 0, 255);
        magenta = color34;
        Color color36 = color12;
        Color color37 = new Color(0, 255, 255);
        cyan = color36;
        Color color38 = color13;
        Color color39 = new Color(0, 0, 255);
        blue = color38;
    }

    public Color(float f, float f2, float f3) {
        this(f, f2, f3, 1.0f);
    }

    public Color(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        this((int) (0.5d + ((double) (f5 * 255.0f))), (int) (0.5d + ((double) (f6 * 255.0f))), (int) (0.5d + ((double) (f7 * 255.0f))), (int) (0.5d + ((double) (f8 * 255.0f))));
        this.falpha = f8;
        this.fvalue = new float[3];
        this.fvalue[0] = f5;
        this.fvalue[1] = f6;
        this.fvalue[2] = f7;
        this.frgbvalue = this.fvalue;
    }

    public Color(int i) {
        this.value = -16777216 | i;
    }

    public Color(int i, int i2, int i3) {
        IllegalArgumentException illegalArgumentException;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if ((i4 & 255) == i4 && (i5 & 255) == i5 && (i6 & 255) == i6) {
            this.value = -16777216 | i6 | (i5 << 8) | (i4 << 16);
            return;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Color parameter outside of expected range");
        throw illegalArgumentException2;
    }

    public Color(int i, int i2, int i3, int i4) {
        IllegalArgumentException illegalArgumentException;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if ((i5 & 255) == i5 && (i6 & 255) == i6 && (i7 & 255) == i7 && (i8 & 255) == i8) {
            this.value = i7 | (i6 << 8) | (i5 << 16) | (i8 << 24);
            return;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Color parameter outside of expected range");
        throw illegalArgumentException2;
    }

    public Color(int i, boolean z) {
        int i2 = i;
        if (!z) {
            this.value = -16777216 | i2;
            return;
        }
        this.value = i2;
    }

    public static int HSBtoRGB(float f, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7 = f;
        float f8 = f2;
        float f9 = f3;
        if (f8 != 0.0f) {
            float floor = 6.0f * (f7 - ((float) Math.floor((double) f7)));
            int floor2 = (int) Math.floor((double) floor);
            float f10 = floor - ((float) floor2);
            float f11 = f9 * (1.0f - f8);
            float f12 = f9 * (1.0f - (f8 * f10));
            float f13 = f9 * (1.0f - (f8 * (1.0f - f10)));
            switch (floor2) {
                case 0:
                    f4 = f9;
                    f5 = f13;
                    f6 = f11;
                    break;
                case 1:
                    f4 = f12;
                    f5 = f9;
                    f6 = f11;
                    break;
                case 2:
                    f4 = f11;
                    f5 = f9;
                    f6 = f13;
                    break;
                case 3:
                    f4 = f11;
                    f5 = f12;
                    f6 = f9;
                    break;
                case 4:
                    f4 = f13;
                    f5 = f11;
                    f6 = f9;
                    break;
                case 5:
                    f4 = f9;
                    f5 = f11;
                    f6 = f12;
                    break;
                default:
                    f6 = 0.0f;
                    f5 = 0.0f;
                    f4 = 0.0f;
                    break;
            }
        } else {
            f6 = f9;
            f5 = f9;
            f4 = f9;
        }
        return -16777216 | ((int) (0.5d + (255.0d * ((double) f6)))) | (((int) (0.5d + (255.0d * ((double) f4)))) << 16) | (((int) (0.5d + (255.0d * ((double) f5)))) << 8);
    }

    public static float[] RGBtoHSB(int i, int i2, int i3, float[] fArr) {
        float f;
        float f2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        float[] fArr2 = fArr;
        if (fArr2 == null) {
            fArr2 = new float[3];
        }
        int max = Math.max(i6, Math.max(i4, i5));
        int min = Math.min(i6, Math.min(i4, i5));
        float f3 = ((float) max) / 255.0f;
        if (max == min) {
            f = 0.0f;
            f2 = 0.0f;
        } else {
            f = ((float) (max - min)) / ((float) max);
            float f4 = ((float) (max - i4)) / ((float) (max - min));
            float f5 = ((float) (max - i5)) / ((float) (max - min));
            float f6 = ((float) (max - i6)) / ((float) (max - min));
            float f7 = i4 == max ? f6 - f5 : i5 == max ? (2.0f + f4) - f6 : (4.0f + f5) - f4;
            f2 = f7 / 6.0f;
            if (f2 < 0.0f) {
                f2 += 1.0f;
            }
        }
        fArr2[0] = f2;
        fArr2[1] = f;
        fArr2[2] = f3;
        return fArr2;
    }

    public static Color decode(String str) throws NumberFormatException {
        Color color;
        Color color2 = color;
        Color color3 = new Color(Integer.decode(str).intValue());
        return color2;
    }

    public static Color getColor(String str) {
        Color color;
        Integer integer = Integer.getInteger(str);
        if (integer == null) {
            return null;
        }
        Color color2 = color;
        Color color3 = new Color(integer.intValue());
        return color2;
    }

    public static Color getColor(String str, int i) {
        Color color;
        Color color2;
        int i2 = i;
        Integer integer = Integer.getInteger(str);
        if (integer == null) {
            Color color3 = color2;
            Color color4 = new Color(i2);
            return color3;
        }
        Color color5 = color;
        Color color6 = new Color(integer.intValue());
        return color5;
    }

    public static Color getColor(String str, Color color) {
        Color color2;
        Color color3 = color;
        Integer integer = Integer.getInteger(str);
        if (integer == null) {
            return color3;
        }
        Color color4 = color2;
        Color color5 = new Color(integer.intValue());
        return color4;
    }

    public static Color getHSBColor(float f, float f2, float f3) {
        Color color;
        Color color2 = color;
        Color color3 = new Color(HSBtoRGB(f, f2, f3));
        return color2;
    }

    public Color brighter() {
        int i;
        int i2;
        int i3;
        Color color;
        Color color2;
        int red2 = getRed();
        int blue2 = getBlue();
        int green2 = getGreen();
        if (red2 == 0 && blue2 == 0 && green2 == 0) {
            Color color3 = color2;
            Color color4 = new Color(3, 3, 3);
            return color3;
        }
        if (red2 >= 3 || red2 == 0) {
            i = (int) (((double) red2) / SCALE_FACTOR);
            if (i > 255) {
                i = 255;
            }
        } else {
            i = 3;
        }
        if (blue2 >= 3 || blue2 == 0) {
            i2 = (int) (((double) blue2) / SCALE_FACTOR);
            if (i2 > 255) {
                i2 = 255;
            }
        } else {
            i2 = 3;
        }
        if (green2 >= 3 || green2 == 0) {
            i3 = (int) (((double) green2) / SCALE_FACTOR);
            if (i3 > 255) {
                i3 = 255;
            }
        } else {
            i3 = 3;
        }
        Color color5 = color;
        Color color6 = new Color(i, i3, i2);
        return color5;
    }

    public Color darker() {
        Color color;
        Color color2 = color;
        Color color3 = new Color((int) (SCALE_FACTOR * ((double) getRed())), (int) (SCALE_FACTOR * ((double) getGreen())), (int) (SCALE_FACTOR * ((double) getBlue())));
        return color2;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        boolean z = false;
        if (obj2 instanceof Color) {
            z = false;
            if (((Color) obj2).value == this.value) {
                z = true;
            }
        }
        return z;
    }

    public int getAlpha() {
        return 255 & (this.value >> 24);
    }

    public int getBlue() {
        return 255 & this.value;
    }

    public float[] getColorComponents(float[] fArr) {
        float[] fArr2 = fArr;
        if (this.fvalue == null) {
            return getRGBColorComponents(fArr2);
        }
        if (fArr2 == null) {
            fArr2 = new float[this.fvalue.length];
        }
        for (int i = 0; i < this.fvalue.length; i++) {
            fArr2[i] = this.fvalue[i];
        }
        return fArr2;
    }

    public float[] getComponents(float[] fArr) {
        float[] fArr2 = fArr;
        if (this.fvalue == null) {
            return getRGBComponents(fArr2);
        }
        int length = this.fvalue.length;
        if (fArr2 == null) {
            fArr2 = new float[(length + 1)];
        }
        float[] colorComponents = getColorComponents(fArr2);
        fArr2[length] = this.falpha;
        return fArr2;
    }

    public int getGreen() {
        return 255 & (this.value >> 8);
    }

    public int getRGB() {
        return this.value;
    }

    public float[] getRGBColorComponents(float[] fArr) {
        float[] fArr2 = fArr;
        if (fArr2 == null) {
            fArr2 = new float[3];
        }
        if (this.frgbvalue != null) {
            fArr2[2] = this.frgbvalue[2];
            fArr2[1] = this.frgbvalue[1];
            fArr2[0] = this.frgbvalue[0];
            return fArr2;
        }
        fArr2[2] = ((float) getBlue()) / 255.0f;
        fArr2[1] = ((float) getGreen()) / 255.0f;
        fArr2[0] = ((float) getRed()) / 255.0f;
        return fArr2;
    }

    public float[] getRGBComponents(float[] fArr) {
        float[] fArr2 = fArr;
        if (fArr2 == null) {
            fArr2 = new float[4];
        }
        if (this.frgbvalue != null) {
            fArr2[3] = this.falpha;
        } else {
            fArr2[3] = ((float) getAlpha()) / 255.0f;
        }
        float[] rGBColorComponents = getRGBColorComponents(fArr2);
        return fArr2;
    }

    public int getRed() {
        return 255 & (this.value >> 16);
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(getClass().getName()).append("[r=").append(getRed()).append(",g=").append(getGreen()).append(",b=").append(getBlue()).append("]").toString();
    }
}
