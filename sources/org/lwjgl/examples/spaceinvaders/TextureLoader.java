package org.lwjgl.examples.spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class TextureLoader {
    private ColorModel glAlphaColorModel;
    private ColorModel glColorModel;
    private HashMap<String, Texture> table;
    private IntBuffer textureIDBuffer = BufferUtils.createIntBuffer(1);

    public TextureLoader() {
        HashMap<String, Texture> hashMap;
        ColorModel colorModel;
        ColorModel colorModel2;
        HashMap<String, Texture> hashMap2 = hashMap;
        HashMap<String, Texture> hashMap3 = new HashMap<>();
        this.table = hashMap2;
        ColorModel colorModel3 = colorModel;
        ColorModel componentColorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 8}, true, false, 3, 0);
        this.glAlphaColorModel = colorModel3;
        ColorModel colorModel4 = colorModel2;
        ColorModel componentColorModel2 = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 0}, false, false, 1, 0);
        this.glColorModel = colorModel4;
    }

    private ByteBuffer convertImageData(BufferedImage bufferedImage, Texture texture) {
        BufferedImage bufferedImage2;
        Hashtable hashtable;
        BufferedImage bufferedImage3;
        Color color;
        BufferedImage bufferedImage4;
        Hashtable hashtable2;
        BufferedImage bufferedImage5 = bufferedImage;
        Texture texture2 = texture;
        int i = 2;
        int i2 = 2;
        while (i < bufferedImage5.getWidth()) {
            i *= 2;
        }
        while (i2 < bufferedImage5.getHeight()) {
            i2 *= 2;
        }
        texture2.setTextureHeight(i2);
        texture2.setTextureWidth(i);
        if (bufferedImage5.getColorModel().hasAlpha()) {
            WritableRaster createInterleavedRaster = Raster.createInterleavedRaster(0, i, i2, 4, null);
            BufferedImage bufferedImage6 = bufferedImage4;
            ColorModel colorModel = this.glAlphaColorModel;
            WritableRaster writableRaster = createInterleavedRaster;
            Hashtable hashtable3 = hashtable2;
            Hashtable hashtable4 = new Hashtable();
            BufferedImage bufferedImage7 = new BufferedImage(colorModel, writableRaster, false, hashtable3);
            bufferedImage3 = bufferedImage6;
        } else {
            WritableRaster createInterleavedRaster2 = Raster.createInterleavedRaster(0, i, i2, 3, null);
            BufferedImage bufferedImage8 = bufferedImage2;
            ColorModel colorModel2 = this.glColorModel;
            WritableRaster writableRaster2 = createInterleavedRaster2;
            Hashtable hashtable5 = hashtable;
            Hashtable hashtable6 = new Hashtable();
            BufferedImage bufferedImage9 = new BufferedImage(colorModel2, writableRaster2, false, hashtable5);
            bufferedImage3 = bufferedImage8;
        }
        Graphics graphics = bufferedImage3.getGraphics();
        Graphics graphics2 = graphics;
        Color color2 = color;
        Color color3 = new Color(0.0f, 0.0f, 0.0f, 0.0f);
        graphics2.setColor(color2);
        graphics.fillRect(0, 0, i, i2);
        boolean drawImage = graphics.drawImage(bufferedImage5, 0, 0, null);
        byte[] data = bufferedImage3.getRaster().getDataBuffer().getData();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(data.length);
        ByteBuffer order = allocateDirect.order(ByteOrder.nativeOrder());
        ByteBuffer put = allocateDirect.put(data, 0, data.length);
        Buffer flip = allocateDirect.flip();
        return allocateDirect;
    }

    private int createTextureID() {
        GL11.glGenTextures(this.textureIDBuffer);
        return this.textureIDBuffer.get(0);
    }

    private static int get2Fold(int i) {
        int i2 = 2;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return i3;
            }
            i2 = i3 * 2;
        }
    }

    private BufferedImage loadImage(String str) throws IOException {
        ImageIcon imageIcon;
        BufferedImage bufferedImage;
        IOException iOException;
        StringBuilder sb;
        String str2 = str;
        URL resource = TextureLoader.class.getClassLoader().getResource(str2);
        if (resource == null) {
            IOException iOException2 = iOException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IOException iOException3 = new IOException(sb2.append("Cannot find: ").append(str2).toString());
            throw iOException2;
        }
        ImageIcon imageIcon2 = imageIcon;
        ImageIcon imageIcon3 = new ImageIcon(resource);
        Image image = imageIcon2.getImage();
        BufferedImage bufferedImage2 = bufferedImage;
        BufferedImage bufferedImage3 = new BufferedImage(image.getWidth(null), image.getHeight(null), 1);
        BufferedImage bufferedImage4 = bufferedImage2;
        Graphics graphics = bufferedImage4.getGraphics();
        boolean drawImage = graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        return bufferedImage4;
    }

    public Texture getTexture(String str) throws IOException {
        String str2 = str;
        Texture texture = (Texture) this.table.get(str2);
        if (texture != null) {
            return texture;
        }
        Texture texture2 = getTexture(str2, 3553, GL11.GL_RGBA, GL11.GL_LINEAR, GL11.GL_LINEAR);
        Object put = this.table.put(str2, texture2);
        return texture2;
    }

    public Texture getTexture(String str, int i, int i2, int i3, int i4) throws IOException {
        Texture texture;
        String str2 = str;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int createTextureID = createTextureID();
        Texture texture2 = texture;
        Texture texture3 = new Texture(i5, createTextureID);
        Texture texture4 = texture2;
        GL11.glBindTexture(i5, createTextureID);
        BufferedImage loadImage = loadImage(str2);
        texture4.setWidth(loadImage.getWidth());
        texture4.setHeight(loadImage.getHeight());
        int i9 = loadImage.getColorModel().hasAlpha() ? 6408 : 6407;
        ByteBuffer convertImageData = convertImageData(loadImage, texture4);
        if (i5 == 3553) {
            GL11.glTexParameteri(i5, GL11.GL_TEXTURE_MIN_FILTER, i7);
            GL11.glTexParameteri(i5, GL11.GL_TEXTURE_MAG_FILTER, i8);
        }
        GL11.glTexImage2D(i5, 0, i6, get2Fold(loadImage.getWidth()), get2Fold(loadImage.getHeight()), 0, i9, (int) GL11.GL_UNSIGNED_BYTE, convertImageData);
        return texture4;
    }
}
