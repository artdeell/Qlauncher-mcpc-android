package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

class PixelStoreState extends Util {
    public int packAlignment;
    public int packRowLength;
    public int packSkipPixels;
    public int packSkipRows;
    public int unpackAlignment;
    public int unpackRowLength;
    public int unpackSkipPixels;
    public int unpackSkipRows;

    PixelStoreState() {
        load();
    }

    public void load() {
        this.unpackRowLength = glGetIntegerv(GL11.GL_UNPACK_ROW_LENGTH);
        this.unpackAlignment = glGetIntegerv(GL11.GL_UNPACK_ALIGNMENT);
        this.unpackSkipRows = glGetIntegerv(GL11.GL_UNPACK_SKIP_ROWS);
        this.unpackSkipPixels = glGetIntegerv(GL11.GL_UNPACK_SKIP_PIXELS);
        this.packRowLength = glGetIntegerv(GL11.GL_PACK_ROW_LENGTH);
        this.packAlignment = glGetIntegerv(GL11.GL_PACK_ALIGNMENT);
        this.packSkipRows = glGetIntegerv(GL11.GL_PACK_SKIP_ROWS);
        this.packSkipPixels = glGetIntegerv(GL11.GL_PACK_SKIP_PIXELS);
    }

    public void save() {
        GL11.glPixelStorei(GL11.GL_UNPACK_ROW_LENGTH, this.unpackRowLength);
        GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, this.unpackAlignment);
        GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_ROWS, this.unpackSkipRows);
        GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_PIXELS, this.unpackSkipPixels);
        GL11.glPixelStorei(GL11.GL_PACK_ROW_LENGTH, this.packRowLength);
        GL11.glPixelStorei(GL11.GL_PACK_ALIGNMENT, this.packAlignment);
        GL11.glPixelStorei(GL11.GL_PACK_SKIP_ROWS, this.packSkipRows);
        GL11.glPixelStorei(GL11.GL_PACK_SKIP_PIXELS, this.packSkipPixels);
    }
}
