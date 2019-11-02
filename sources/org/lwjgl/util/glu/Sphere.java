package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

public class Sphere extends Quadric {
    public Sphere() {
    }

    public void draw(float f, int i, int i2) {
        int i3;
        int i4;
        float f2 = f;
        int i5 = i;
        int i6 = i2;
        boolean z = this.normals != 100002;
        boolean z2 = this.orientation == 100021 ? true : true;
        float f3 = 3.1415927f / ((float) i6);
        float f4 = 6.2831855f / ((float) i5);
        if (this.drawStyle == 100012) {
            if (!this.textureFlag) {
                GL11.glBegin(6);
                GL11.glNormal3f(0.0f, 0.0f, 1.0f);
                GL11.glVertex3f(0.0f, 0.0f, z2 * f2);
                int i7 = 0;
                while (i7 <= i5) {
                    float f5 = i7 == i5 ? 0.0f : f4 * ((float) i7);
                    float sin = (-sin(f5)) * sin(f3);
                    float cos = cos(f5) * sin(f3);
                    float cos2 = z2 * cos(f3);
                    if (z) {
                        GL11.glNormal3f(sin * z2, cos * z2, cos2 * z2);
                    }
                    GL11.glVertex3f(sin * f2, cos * f2, cos2 * f2);
                    i7++;
                }
                GL11.glEnd();
            }
            float f6 = 1.0f / ((float) i5);
            float f7 = 1.0f / ((float) i6);
            float f8 = 1.0f;
            if (this.textureFlag) {
                i3 = 0;
                i4 = i6;
            } else {
                i3 = 1;
                i4 = i6 - 1;
            }
            for (int i8 = i3; i8 < i4; i8++) {
                float f9 = f3 * ((float) i8);
                GL11.glBegin(8);
                float f10 = 0.0f;
                int i9 = 0;
                while (i9 <= i5) {
                    float f11 = i9 == i5 ? 0.0f : f4 * ((float) i9);
                    float sin2 = (-sin(f11)) * sin(f9);
                    float cos3 = cos(f11) * sin(f9);
                    float cos4 = z2 * cos(f9);
                    if (z) {
                        GL11.glNormal3f(sin2 * z2, cos3 * z2, cos4 * z2);
                    }
                    TXTR_COORD(f10, f8);
                    GL11.glVertex3f(sin2 * f2, cos3 * f2, cos4 * f2);
                    float sin3 = (-sin(f11)) * sin(f9 + f3);
                    float cos5 = cos(f11) * sin(f9 + f3);
                    float cos6 = z2 * cos(f9 + f3);
                    if (z) {
                        GL11.glNormal3f(sin3 * z2, cos5 * z2, cos6 * z2);
                    }
                    TXTR_COORD(f10, f8 - f7);
                    f10 += f6;
                    GL11.glVertex3f(sin3 * f2, cos5 * f2, cos6 * f2);
                    i9++;
                }
                GL11.glEnd();
                f8 -= f7;
            }
            if (!this.textureFlag) {
                GL11.glBegin(6);
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
                GL11.glVertex3f(0.0f, 0.0f, z2 * (-f2));
                float f12 = 3.1415927f - f3;
                float f13 = 1.0f;
                int i10 = i5;
                while (i10 >= 0) {
                    float f14 = i10 == i5 ? 0.0f : f4 * ((float) i10);
                    float sin4 = (-sin(f14)) * sin(f12);
                    float cos7 = cos(f14) * sin(f12);
                    float cos8 = z2 * cos(f12);
                    if (z) {
                        GL11.glNormal3f(sin4 * z2, cos7 * z2, cos8 * z2);
                    }
                    f13 -= f6;
                    GL11.glVertex3f(sin4 * f2, cos7 * f2, cos8 * f2);
                    i10--;
                }
                GL11.glEnd();
                return;
            }
            return;
        }
        if (this.drawStyle != 100011) {
            if (this.drawStyle != 100013) {
                if (this.drawStyle == 100010) {
                    GL11.glBegin(0);
                    if (z) {
                        GL11.glNormal3f(0.0f, 0.0f, z2);
                    }
                    GL11.glVertex3f(0.0f, 0.0f, f2);
                    if (z) {
                        GL11.glNormal3f(0.0f, 0.0f, -z2);
                    }
                    GL11.glVertex3f(0.0f, 0.0f, -f2);
                    for (int i11 = 1; i11 < i6 - 1; i11++) {
                        float f15 = f3 * ((float) i11);
                        for (int i12 = 0; i12 < i5; i12++) {
                            float f16 = f4 * ((float) i12);
                            float cos9 = cos(f16) * sin(f15);
                            float sin5 = sin(f16) * sin(f15);
                            float cos10 = cos(f15);
                            if (z) {
                                GL11.glNormal3f(cos9 * z2, sin5 * z2, cos10 * z2);
                            }
                            GL11.glVertex3f(cos9 * f2, sin5 * f2, cos10 * f2);
                        }
                    }
                    GL11.glEnd();
                    return;
                }
                return;
            }
        }
        for (int i13 = 1; i13 < i6; i13++) {
            float f17 = f3 * ((float) i13);
            GL11.glBegin(2);
            for (int i14 = 0; i14 < i5; i14++) {
                float f18 = f4 * ((float) i14);
                float cos11 = cos(f18) * sin(f17);
                float sin6 = sin(f18) * sin(f17);
                float cos12 = cos(f17);
                if (z) {
                    GL11.glNormal3f(cos11 * z2, sin6 * z2, cos12 * z2);
                }
                GL11.glVertex3f(cos11 * f2, sin6 * f2, cos12 * f2);
            }
            GL11.glEnd();
        }
        for (int i15 = 0; i15 < i5; i15++) {
            float f19 = f4 * ((float) i15);
            GL11.glBegin(3);
            for (int i16 = 0; i16 <= i6; i16++) {
                float f20 = f3 * ((float) i16);
                float cos13 = cos(f19) * sin(f20);
                float sin7 = sin(f19) * sin(f20);
                float cos14 = cos(f20);
                if (z) {
                    GL11.glNormal3f(cos13 * z2, sin7 * z2, cos14 * z2);
                }
                GL11.glVertex3f(cos13 * f2, sin7 * f2, cos14 * f2);
            }
            GL11.glEnd();
        }
    }
}
