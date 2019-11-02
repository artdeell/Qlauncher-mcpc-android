package net.zhuoweizhang.makeshift.java.awt.image;

public class WritableRaster {
    private BufferedImage image;

    public WritableRaster(BufferedImage bufferedImage) {
        this.image = bufferedImage;
    }

    public DataBuffer getDataBuffer() {
        DataBufferInt dataBufferInt;
        int[] iArr = new int[(this.image.getWidth() * this.image.getHeight())];
        int[] rgb = this.image.getRGB(0, 0, this.image.getWidth(), this.image.getHeight(), iArr, 0, this.image.getWidth());
        DataBufferInt dataBufferInt2 = dataBufferInt;
        DataBufferInt dataBufferInt3 = new DataBufferInt(iArr, iArr.length);
        return dataBufferInt2;
    }
}
