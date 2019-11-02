package org.lwjgl.examples.spaceinvaders;

import java.io.IOException;
import org.lwjgl.opengl.GL11;

public class Sprite {
    private int height;
    private Texture texture;
    private int width;

    public Sprite(TextureLoader textureLoader, String str) {
        StringBuilder sb;
        String str2 = str;
        TextureLoader textureLoader2 = textureLoader;
        try {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            this.texture = textureLoader2.getTexture(sb2.append("spaceinvaders/").append(str2).toString());
            this.width = this.texture.getImageWidth();
            this.height = this.texture.getImageHeight();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void draw(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        GL11.glPushMatrix();
        this.texture.bind();
        GL11.glTranslatef((float) i3, (float) i4, 0.0f);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2f(0.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, this.texture.getHeight());
        GL11.glVertex2f(0.0f, (float) this.height);
        GL11.glTexCoord2f(this.texture.getWidth(), this.texture.getHeight());
        GL11.glVertex2f((float) this.width, (float) this.height);
        GL11.glTexCoord2f(this.texture.getWidth(), 0.0f);
        GL11.glVertex2f((float) this.width, 0.0f);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

    public int getHeight() {
        return this.texture.getImageHeight();
    }

    public int getWidth() {
        return this.texture.getImageWidth();
    }
}
