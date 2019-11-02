package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

public class Quadric {
    protected int drawStyle = GLU.GLU_FILL;
    protected int normals = GLU.GLU_SMOOTH;
    protected int orientation = GLU.GLU_OUTSIDE;
    protected boolean textureFlag = false;

    public Quadric() {
    }

    /* access modifiers changed from: protected */
    public void TXTR_COORD(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        if (this.textureFlag) {
            GL11.glTexCoord2f(f3, f4);
        }
    }

    /* access modifiers changed from: protected */
    public float cos(float f) {
        return (float) Math.cos((double) f);
    }

    public int getDrawStyle() {
        return this.drawStyle;
    }

    public int getNormals() {
        return this.normals;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean getTextureFlag() {
        return this.textureFlag;
    }

    /* access modifiers changed from: protected */
    public void normal3f(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        float sqrt = (float) Math.sqrt((double) ((f4 * f4) + (f5 * f5) + (f6 * f6)));
        if (sqrt > 1.0E-5f) {
            f4 /= sqrt;
            f5 /= sqrt;
            f6 /= sqrt;
        }
        GL11.glNormal3f(f4, f5, f6);
    }

    public void setDrawStyle(int i) {
        int i2 = i;
        this.drawStyle = i2;
    }

    public void setNormals(int i) {
        int i2 = i;
        this.normals = i2;
    }

    public void setOrientation(int i) {
        int i2 = i;
        this.orientation = i2;
    }

    public void setTextureFlag(boolean z) {
        boolean z2 = z;
        this.textureFlag = z2;
    }

    /* access modifiers changed from: protected */
    public float sin(float f) {
        return (float) Math.sin((double) f);
    }
}
