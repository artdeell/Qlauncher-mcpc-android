package org.lwjgl.util.glu;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Util {
    private static IntBuffer scratch = BufferUtils.createIntBuffer(16);

    public Util() {
    }

    protected static int bytesPerPixel(int i, int i2) {
        int i3;
        int i4;
        int i5 = i2;
        switch (i) {
            case GL11.GL_COLOR_INDEX /*6400*/:
            case GL11.GL_STENCIL_INDEX /*6401*/:
            case GL11.GL_DEPTH_COMPONENT /*6402*/:
            case GL11.GL_RED /*6403*/:
            case GL11.GL_GREEN /*6404*/:
            case GL11.GL_BLUE /*6405*/:
            case GL11.GL_ALPHA /*6406*/:
            case GL11.GL_LUMINANCE /*6409*/:
                i3 = 1;
                break;
            case GL11.GL_RGB /*6407*/:
            case 32992:
                i3 = 3;
                break;
            case GL11.GL_RGBA /*6408*/:
            case 32993:
                i3 = 4;
                break;
            case GL11.GL_LUMINANCE_ALPHA /*6410*/:
                i3 = 2;
                break;
            default:
                i3 = 0;
                break;
        }
        switch (i5) {
            case GL11.GL_BYTE /*5120*/:
                i4 = 1;
                break;
            case GL11.GL_UNSIGNED_BYTE /*5121*/:
                i4 = 1;
                break;
            case GL11.GL_SHORT /*5122*/:
                i4 = 2;
                break;
            case GL11.GL_UNSIGNED_SHORT /*5123*/:
                i4 = 2;
                break;
            case GL11.GL_INT /*5124*/:
                i4 = 4;
                break;
            case GL11.GL_UNSIGNED_INT /*5125*/:
                i4 = 4;
                break;
            case GL11.GL_FLOAT /*5126*/:
                i4 = 4;
                break;
            case GL11.GL_BITMAP /*6656*/:
                i4 = 1;
                break;
            default:
                i4 = 0;
                break;
        }
        return i3 * i4;
    }

    protected static int ceil(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        return i3 % i4 == 0 ? i3 / i4 : 1 + (i3 / i4);
    }

    protected static int compPerPix(int i) {
        switch (i) {
            case GL11.GL_COLOR_INDEX /*6400*/:
            case GL11.GL_STENCIL_INDEX /*6401*/:
            case GL11.GL_DEPTH_COMPONENT /*6402*/:
            case GL11.GL_RED /*6403*/:
            case GL11.GL_GREEN /*6404*/:
            case GL11.GL_BLUE /*6405*/:
            case GL11.GL_ALPHA /*6406*/:
            case GL11.GL_LUMINANCE /*6409*/:
                return 1;
            case GL11.GL_RGB /*6407*/:
            case 32992:
                return 3;
            case GL11.GL_RGBA /*6408*/:
            case 32993:
                return 4;
            case GL11.GL_LUMINANCE_ALPHA /*6410*/:
                return 2;
            default:
                return -1;
        }
    }

    protected static void cross(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = fArr;
        float[] fArr5 = fArr2;
        float[] fArr6 = fArr3;
        fArr6[0] = (fArr4[1] * fArr5[2]) - (fArr4[2] * fArr5[1]);
        fArr6[1] = (fArr4[2] * fArr5[0]) - (fArr4[0] * fArr5[2]);
        fArr6[2] = (fArr4[0] * fArr5[1]) - (fArr4[1] * fArr5[0]);
    }

    protected static int glGetIntegerv(int i) {
        int i2 = i;
        Buffer rewind = scratch.rewind();
        GL11.glGetInteger(i2, scratch);
        return scratch.get();
    }

    protected static int nearestPower(int i) {
        int i2 = i;
        int i3 = 1;
        if (i2 == 0) {
            return -1;
        }
        while (i2 != 1) {
            if (i2 == 3) {
                return i3 << 2;
            }
            i2 >>= 1;
            i3 <<= 1;
        }
        return i3;
    }

    protected static float[] normalize(float[] fArr) {
        float[] fArr2 = fArr;
        float sqrt = (float) Math.sqrt((double) ((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1]) + (fArr2[2] * fArr2[2])));
        if (((double) sqrt) == 0.0d) {
            return fArr2;
        }
        float f = 1.0f / sqrt;
        fArr2[0] = f * fArr2[0];
        fArr2[1] = f * fArr2[1];
        fArr2[2] = f * fArr2[2];
        return fArr2;
    }
}
