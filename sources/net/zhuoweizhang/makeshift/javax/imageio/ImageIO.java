package net.zhuoweizhang.makeshift.javax.imageio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import net.zhuoweizhang.makeshift.java.awt.image.BufferedImage;
import net.zhuoweizhang.makeshift.java.awt.image.RenderedImage;

public class ImageIO {
    public ImageIO() {
    }

    private static BufferedImage makeBufferedImage(Bitmap bitmap) {
        BufferedImage bufferedImage;
        BufferedImage bufferedImage2 = bufferedImage;
        BufferedImage bufferedImage3 = new BufferedImage(bitmap);
        return bufferedImage2;
    }

    public static BufferedImage read(File file) throws IOException {
        return makeBufferedImage(BitmapFactory.decodeFile(file.getAbsolutePath()));
    }

    public static BufferedImage read(InputStream inputStream) throws IOException {
        return makeBufferedImage(BitmapFactory.decodeStream(inputStream));
    }

    public static BufferedImage read(URL url) throws IOException {
        InputStream openStream = url.openStream();
        Bitmap decodeStream = BitmapFactory.decodeStream(openStream);
        openStream.close();
        return makeBufferedImage(decodeStream);
    }

    public static void setUseCache(boolean z) {
    }

    public static boolean write(RenderedImage renderedImage, String str, File file) {
        StringBuilder sb;
        RenderedImage renderedImage2 = renderedImage;
        String str2 = str;
        File file2 = file;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("ImageIO.write stub ").append(file2).toString());
        return true;
    }
}
