package net.zhuoweizhang.makeshift.java.awt.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import net.zhuoweizhang.makeshift.java.awt.Graphics;
import net.zhuoweizhang.makeshift.java.awt.Graphics2D;
import net.zhuoweizhang.makeshift.java.awt.Image;

public class BufferedImage extends Image implements RenderedImage {
    public static final int TYPE_INT_ARGB = 2;
    private Bitmap bitmap;

    public BufferedImage(int i, int i2, int i3) {
        int i4 = i3;
        this.bitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
    }

    public BufferedImage(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public Graphics2D createGraphics() {
        Graphics2D graphics2D;
        Graphics2D graphics2D2 = graphics2D;
        Graphics2D graphics2D3 = new Graphics2D(this);
        return graphics2D2;
    }

    public Bitmap getAndroidBitmap() {
        return this.bitmap;
    }

    public Graphics getGraphics() {
        Graphics2D graphics2D;
        Graphics2D graphics2D2 = graphics2D;
        Graphics2D graphics2D3 = new Graphics2D(this);
        return graphics2D2;
    }

    public int getHeight() {
        return this.bitmap.getHeight();
    }

    public int[] getRGB(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int[] iArr2 = iArr;
        int i11 = i5;
        int i12 = i6;
        if (iArr2 == null) {
            iArr2 = new int[(i11 + (i12 * i10))];
        }
        this.bitmap.getPixels(iArr2, i11, i12, i7, i8, i9, i10);
        return iArr2;
    }

    public WritableRaster getRaster() {
        WritableRaster writableRaster;
        WritableRaster writableRaster2 = writableRaster;
        WritableRaster writableRaster3 = new WritableRaster(this);
        return writableRaster2;
    }

    public int getType() {
        return 2;
    }

    public int getWidth() {
        return this.bitmap.getWidth();
    }

    public void setRGB(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int[] iArr2 = iArr;
        int i11 = i5;
        int i12 = i6;
        System.out.println("Setting RGB stub");
    }
}
