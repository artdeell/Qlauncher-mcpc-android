package net.zhuoweizhang.makeshift.java.awt;

import android.graphics.Canvas;
import net.zhuoweizhang.makeshift.java.awt.image.BufferedImage;
import net.zhuoweizhang.makeshift.java.awt.image.ImageObserver;

public class Graphics {
    private Canvas androidCanvas;
    private BufferedImage bufImage;

    public Graphics(BufferedImage bufferedImage) {
        Canvas canvas;
        BufferedImage bufferedImage2 = bufferedImage;
        this.bufImage = bufferedImage2;
        Canvas canvas2 = canvas;
        Canvas canvas3 = new Canvas(bufferedImage2.getAndroidBitmap());
        this.androidCanvas = canvas2;
    }

    public void dispose() {
    }

    public boolean drawImage(Image image, int i, int i2, ImageObserver imageObserver) {
        Image image2 = image;
        int i3 = i;
        int i4 = i2;
        ImageObserver imageObserver2 = imageObserver;
        if (!(image2 instanceof BufferedImage)) {
            return true;
        }
        this.androidCanvas.drawBitmap(((BufferedImage) image2).getAndroidBitmap(), (float) i3, (float) i4, null);
        return true;
    }

    public void drawString(String str, int i, int i2) {
    }

    public void fillRect(int i, int i2, int i3, int i4) {
    }

    public void setColor(Color color) {
    }
}
