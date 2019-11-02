package org.lwjgl.examples.spaceinvaders;

import org.lwjgl.opengl.GL11;

public class Texture {
    private int height;
    private float heightRatio;
    private int target;
    private int texHeight;
    private int texWidth;
    private int textureID;
    private int width;
    private float widthRatio;

    public Texture(int i, int i2) {
        int i3 = i2;
        this.target = i;
        this.textureID = i3;
    }

    private void setHeight() {
        if (this.texHeight != 0) {
            this.heightRatio = ((float) this.height) / ((float) this.texHeight);
        }
    }

    private void setWidth() {
        if (this.texWidth != 0) {
            this.widthRatio = ((float) this.width) / ((float) this.texWidth);
        }
    }

    public void bind() {
        GL11.glBindTexture(this.target, this.textureID);
    }

    public float getHeight() {
        return this.heightRatio;
    }

    public int getImageHeight() {
        return this.height;
    }

    public int getImageWidth() {
        return this.width;
    }

    public float getWidth() {
        return this.widthRatio;
    }

    public void setHeight(int i) {
        this.height = i;
        setHeight();
    }

    public void setTextureHeight(int i) {
        this.texHeight = i;
        setHeight();
    }

    public void setTextureWidth(int i) {
        this.texWidth = i;
        setWidth();
    }

    public void setWidth(int i) {
        this.width = i;
        setWidth();
    }
}
