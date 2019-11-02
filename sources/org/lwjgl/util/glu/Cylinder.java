package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

public class Cylinder extends Quadric {
    public Cylinder() {
    }

    public void draw(float f, float f2, float f3, int i, int i2) {
        float sin;
        float cos;
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        int i3 = i;
        int i4 = i2;
        float f7 = this.orientation == 100021 ? -1.0f : 1.0f;
        float f8 = 6.2831855f / ((float) i3);
        float f9 = (f5 - f4) / ((float) i4);
        float f10 = f6 / ((float) i4);
        float f11 = (f4 - f5) / f6;
        if (this.drawStyle == 100010) {
            GL11.glBegin(0);
            for (int i5 = 0; i5 < i3; i5++) {
                float cos2 = cos(f8 * ((float) i5));
                float sin2 = sin(f8 * ((float) i5));
                normal3f(cos2 * f7, sin2 * f7, f11 * f7);
                float f12 = 0.0f;
                float f13 = f4;
                for (int i6 = 0; i6 <= i4; i6++) {
                    GL11.glVertex3f(cos2 * f13, sin2 * f13, f12);
                    f12 += f10;
                    f13 += f9;
                }
            }
            GL11.glEnd();
            return;
        }
        if (this.drawStyle != 100011) {
            if (this.drawStyle != 100013) {
                if (this.drawStyle == 100012) {
                    float f14 = 1.0f / ((float) i3);
                    float f15 = 1.0f / ((float) i4);
                    float f16 = 0.0f;
                    float f17 = 0.0f;
                    float f18 = f4;
                    for (int i7 = 0; i7 < i4; i7++) {
                        float f19 = 0.0f;
                        GL11.glBegin(8);
                        for (int i8 = 0; i8 <= i3; i8++) {
                            if (i8 == i3) {
                                sin = sin(0.0f);
                                cos = cos(0.0f);
                            } else {
                                sin = sin(f8 * ((float) i8));
                                cos = cos(f8 * ((float) i8));
                            }
                            if (f7 == 1.0f) {
                                normal3f(sin * f7, cos * f7, f11 * f7);
                                TXTR_COORD(f19, f16);
                                GL11.glVertex3f(sin * f18, cos * f18, f17);
                                normal3f(sin * f7, cos * f7, f11 * f7);
                                TXTR_COORD(f19, f16 + f15);
                                GL11.glVertex3f(sin * (f18 + f9), cos * (f18 + f9), f17 + f10);
                            } else {
                                normal3f(sin * f7, cos * f7, f11 * f7);
                                TXTR_COORD(f19, f16);
                                GL11.glVertex3f(sin * f18, cos * f18, f17);
                                normal3f(sin * f7, cos * f7, f11 * f7);
                                TXTR_COORD(f19, f16 + f15);
                                GL11.glVertex3f(sin * (f18 + f9), cos * (f18 + f9), f17 + f10);
                            }
                            f19 += f14;
                        }
                        GL11.glEnd();
                        f18 += f9;
                        f16 += f15;
                        f17 += f10;
                    }
                    return;
                }
                return;
            }
        }
        if (this.drawStyle == 100011) {
            float f20 = 0.0f;
            float f21 = f4;
            for (int i9 = 0; i9 <= i4; i9++) {
                GL11.glBegin(2);
                for (int i10 = 0; i10 < i3; i10++) {
                    float cos3 = cos(f8 * ((float) i10));
                    float sin3 = sin(f8 * ((float) i10));
                    normal3f(cos3 * f7, sin3 * f7, f11 * f7);
                    GL11.glVertex3f(cos3 * f21, sin3 * f21, f20);
                }
                GL11.glEnd();
                f20 += f10;
                f21 += f9;
            }
        } else if (((double) f4) != 0.0d) {
            GL11.glBegin(2);
            for (int i11 = 0; i11 < i3; i11++) {
                float cos4 = cos(f8 * ((float) i11));
                float sin4 = sin(f8 * ((float) i11));
                normal3f(cos4 * f7, sin4 * f7, f11 * f7);
                GL11.glVertex3f(cos4 * f4, sin4 * f4, 0.0f);
            }
            GL11.glEnd();
            GL11.glBegin(2);
            for (int i12 = 0; i12 < i3; i12++) {
                float cos5 = cos(f8 * ((float) i12));
                float sin5 = sin(f8 * ((float) i12));
                normal3f(cos5 * f7, sin5 * f7, f11 * f7);
                GL11.glVertex3f(cos5 * f5, sin5 * f5, f6);
            }
            GL11.glEnd();
        }
        GL11.glBegin(1);
        for (int i13 = 0; i13 < i3; i13++) {
            float cos6 = cos(f8 * ((float) i13));
            float sin6 = sin(f8 * ((float) i13));
            normal3f(cos6 * f7, sin6 * f7, f11 * f7);
            GL11.glVertex3f(cos6 * f4, sin6 * f4, 0.0f);
            GL11.glVertex3f(cos6 * f5, sin6 * f5, f6);
        }
        GL11.glEnd();
    }
}
