package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

public class Disk extends Quadric {
    public Disk() {
    }

    public void draw(float f, float f2, int i, int i2) {
        float f3 = f;
        float f4 = f2;
        int i3 = i;
        int i4 = i2;
        if (this.normals != 100002) {
            if (this.orientation == 100020) {
                GL11.glNormal3f(0.0f, 0.0f, 1.0f);
            } else {
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
            }
        }
        float f5 = 6.2831855f / ((float) i3);
        float f6 = (f4 - f3) / ((float) i4);
        switch (this.drawStyle) {
            case GLU.GLU_POINT /*100010*/:
                GL11.glBegin(0);
                for (int i5 = 0; i5 < i3; i5++) {
                    float f7 = f5 * ((float) i5);
                    float sin = sin(f7);
                    float cos = cos(f7);
                    for (int i6 = 0; i6 <= i4; i6++) {
                        float f8 = f6 * f3 * ((float) i6);
                        GL11.glVertex2f(f8 * sin, f8 * cos);
                    }
                }
                GL11.glEnd();
                return;
            case GLU.GLU_LINE /*100011*/:
                for (int i7 = 0; i7 <= i4; i7++) {
                    float f9 = f3 + (f6 * ((float) i7));
                    GL11.glBegin(2);
                    for (int i8 = 0; i8 < i3; i8++) {
                        float f10 = f5 * ((float) i8);
                        GL11.glVertex2f(f9 * sin(f10), f9 * cos(f10));
                    }
                    GL11.glEnd();
                }
                for (int i9 = 0; i9 < i3; i9++) {
                    float f11 = f5 * ((float) i9);
                    float sin2 = sin(f11);
                    float cos2 = cos(f11);
                    GL11.glBegin(3);
                    for (int i10 = 0; i10 <= i4; i10++) {
                        float f12 = f3 + (f6 * ((float) i10));
                        GL11.glVertex2f(f12 * sin2, f12 * cos2);
                    }
                    GL11.glEnd();
                }
                return;
            case GLU.GLU_FILL /*100012*/:
                float f13 = 2.0f * f4;
                float f14 = f3;
                for (int i11 = 0; i11 < i4; i11++) {
                    float f15 = f14 + f6;
                    if (this.orientation == 100020) {
                        GL11.glBegin(8);
                        int i12 = 0;
                        while (i12 <= i3) {
                            float f16 = i12 == i3 ? 0.0f : f5 * ((float) i12);
                            float sin3 = sin(f16);
                            float cos3 = cos(f16);
                            TXTR_COORD(0.5f + ((sin3 * f15) / f13), 0.5f + ((cos3 * f15) / f13));
                            GL11.glVertex2f(f15 * sin3, f15 * cos3);
                            TXTR_COORD(0.5f + ((sin3 * f14) / f13), 0.5f + ((cos3 * f14) / f13));
                            GL11.glVertex2f(f14 * sin3, f14 * cos3);
                            i12++;
                        }
                        GL11.glEnd();
                    } else {
                        GL11.glBegin(8);
                        int i13 = i3;
                        while (i13 >= 0) {
                            float f17 = i13 == i3 ? 0.0f : f5 * ((float) i13);
                            float sin4 = sin(f17);
                            float cos4 = cos(f17);
                            TXTR_COORD(0.5f - ((sin4 * f15) / f13), 0.5f + ((cos4 * f15) / f13));
                            GL11.glVertex2f(f15 * sin4, f15 * cos4);
                            TXTR_COORD(0.5f - ((sin4 * f14) / f13), 0.5f + ((cos4 * f14) / f13));
                            GL11.glVertex2f(f14 * sin4, f14 * cos4);
                            i13--;
                        }
                        GL11.glEnd();
                    }
                    f14 = f15;
                }
                return;
            case GLU.GLU_SILHOUETTE /*100013*/:
                if (((double) f3) != 0.0d) {
                    GL11.glBegin(2);
                    float f18 = 0.0f;
                    while (true) {
                        float f19 = f18;
                        if (((double) f19) < 6.2831854820251465d) {
                            GL11.glVertex2f(f3 * sin(f19), f3 * cos(f19));
                            f18 = f19 + f5;
                        } else {
                            GL11.glEnd();
                        }
                    }
                }
                GL11.glBegin(2);
                float f20 = 0.0f;
                while (true) {
                    float f21 = f20;
                    if (f21 < 6.2831855f) {
                        GL11.glVertex2f(f4 * sin(f21), f4 * cos(f21));
                        f20 = f21 + f5;
                    } else {
                        GL11.glEnd();
                        return;
                    }
                }
            default:
                return;
        }
    }
}
