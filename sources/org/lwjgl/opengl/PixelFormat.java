package org.lwjgl.opengl;

public final class PixelFormat implements PixelFormatLWJGL {
    private int accum_alpha;
    private int accum_bpp;
    private int alpha;
    private int bpp;
    private int colorSamples;
    private int depth;
    private boolean floating_point;
    private boolean floating_point_packed;
    private int num_aux_buffers;
    private boolean sRGB;
    private int samples;
    private int stencil;
    private boolean stereo;

    public PixelFormat() {
        this(0, 8, 0);
    }

    public PixelFormat(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public PixelFormat(int i, int i2, int i3, int i4) {
        this(0, i, i2, i3, i4);
    }

    public PixelFormat(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, 0, 0, 0, false);
    }

    public PixelFormat(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this(i, i2, i3, i4, i5, i6, i7, i8, z, false);
    }

    public PixelFormat(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2) {
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        int i14 = i7;
        int i15 = i8;
        boolean z3 = z;
        boolean z4 = z2;
        this.bpp = i;
        this.alpha = i9;
        this.depth = i10;
        this.stencil = i11;
        this.samples = i12;
        this.num_aux_buffers = i13;
        this.accum_bpp = i14;
        this.accum_alpha = i15;
        this.stereo = z3;
        this.floating_point = z4;
        this.floating_point_packed = false;
        this.sRGB = false;
    }

    private PixelFormat(PixelFormat pixelFormat) {
        PixelFormat pixelFormat2 = pixelFormat;
        this.bpp = pixelFormat2.bpp;
        this.alpha = pixelFormat2.alpha;
        this.depth = pixelFormat2.depth;
        this.stencil = pixelFormat2.stencil;
        this.samples = pixelFormat2.samples;
        this.colorSamples = pixelFormat2.colorSamples;
        this.num_aux_buffers = pixelFormat2.num_aux_buffers;
        this.accum_bpp = pixelFormat2.accum_bpp;
        this.accum_alpha = pixelFormat2.accum_alpha;
        this.stereo = pixelFormat2.stereo;
        this.floating_point = pixelFormat2.floating_point;
        this.floating_point_packed = pixelFormat2.floating_point_packed;
        this.sRGB = pixelFormat2.sRGB;
    }

    public int getAccumulationAlpha() {
        return this.accum_alpha;
    }

    public int getAccumulationBitsPerPixel() {
        return this.accum_bpp;
    }

    public int getAlphaBits() {
        return this.alpha;
    }

    public int getAuxBuffers() {
        return this.num_aux_buffers;
    }

    public int getBitsPerPixel() {
        return this.bpp;
    }

    public int getDepthBits() {
        return this.depth;
    }

    public int getSamples() {
        return this.samples;
    }

    public int getStencilBits() {
        return this.stencil;
    }

    public boolean isFloatingPoint() {
        return this.floating_point;
    }

    public boolean isSRGB() {
        return this.sRGB;
    }

    public boolean isStereo() {
        return this.stereo;
    }

    public PixelFormat withAccumulationAlpha(int i) {
        PixelFormat pixelFormat;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of alpha bits in the accumulation buffer specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.accum_alpha = i2;
        return pixelFormat4;
    }

    public PixelFormat withAccumulationBitsPerPixel(int i) {
        PixelFormat pixelFormat;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of bits per pixel in the accumulation buffer specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.accum_bpp = i2;
        return pixelFormat4;
    }

    public PixelFormat withAlphaBits(int i) {
        PixelFormat pixelFormat;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of alpha bits specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.alpha = i2;
        return pixelFormat4;
    }

    public PixelFormat withAuxBuffers(int i) {
        PixelFormat pixelFormat;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of auxiliary buffers specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.num_aux_buffers = i2;
        return pixelFormat4;
    }

    public PixelFormat withBitsPerPixel(int i) {
        PixelFormat pixelFormat;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of bits per pixel specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.bpp = i2;
        return pixelFormat4;
    }

    public PixelFormat withCoverageSamples(int i) {
        return withCoverageSamples(i, this.samples);
    }

    public PixelFormat withCoverageSamples(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        PixelFormat pixelFormat;
        int i3 = i;
        int i4 = i2;
        if (i4 < 0 || i3 < 0 || ((i4 == 0 && i3 > 0) || i4 < i3)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of coverage samples specified: ").append(i4).append(" - ").append(i3).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.samples = i4;
        pixelFormat4.colorSamples = i3;
        return pixelFormat4;
    }

    public PixelFormat withDepthBits(int i) {
        PixelFormat pixelFormat;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of depth bits specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.depth = i2;
        return pixelFormat4;
    }

    public PixelFormat withFloatingPoint(boolean z) {
        PixelFormat pixelFormat;
        boolean z2 = z;
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.floating_point = z2;
        if (z2) {
            pixelFormat4.floating_point_packed = false;
        }
        return pixelFormat4;
    }

    public PixelFormat withFloatingPointPacked(boolean z) {
        PixelFormat pixelFormat;
        boolean z2 = z;
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.floating_point_packed = z2;
        if (z2) {
            pixelFormat4.floating_point = false;
        }
        return pixelFormat4;
    }

    public PixelFormat withSRGB(boolean z) {
        PixelFormat pixelFormat;
        boolean z2 = z;
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.sRGB = z2;
        return pixelFormat4;
    }

    public PixelFormat withSamples(int i) {
        PixelFormat pixelFormat;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of samples specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.samples = i2;
        return pixelFormat4;
    }

    public PixelFormat withStencilBits(int i) {
        PixelFormat pixelFormat;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid number of stencil bits specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.stencil = i2;
        return pixelFormat4;
    }

    public PixelFormat withStereo(boolean z) {
        PixelFormat pixelFormat;
        boolean z2 = z;
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(this);
        PixelFormat pixelFormat4 = pixelFormat2;
        pixelFormat4.stereo = z2;
        return pixelFormat4;
    }
}
