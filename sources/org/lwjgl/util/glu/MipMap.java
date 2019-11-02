package org.lwjgl.util.glu;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class MipMap extends Util {
    public MipMap() {
    }

    public static int gluBuild2DMipmaps(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer) {
        PixelStoreState pixelStoreState;
        int i7;
        boolean z;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        int i8 = i;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        ByteBuffer byteBuffer4 = byteBuffer;
        if (i10 < 1 || i11 < 1) {
            return 100901;
        }
        int bytesPerPixel = bytesPerPixel(i12, i13);
        if (bytesPerPixel == 0) {
            return 100900;
        }
        int glGetIntegerv = glGetIntegerv(GL11.GL_MAX_TEXTURE_SIZE);
        int nearestPower = nearestPower(i10);
        if (nearestPower > glGetIntegerv) {
            nearestPower = glGetIntegerv;
        }
        int nearestPower2 = nearestPower(i11);
        if (nearestPower2 > glGetIntegerv) {
            nearestPower2 = glGetIntegerv;
        }
        PixelStoreState pixelStoreState2 = pixelStoreState;
        PixelStoreState pixelStoreState3 = new PixelStoreState();
        PixelStoreState pixelStoreState4 = pixelStoreState2;
        GL11.glPixelStorei(GL11.GL_PACK_ROW_LENGTH, 0);
        GL11.glPixelStorei(GL11.GL_PACK_ALIGNMENT, 1);
        GL11.glPixelStorei(GL11.GL_PACK_SKIP_ROWS, 0);
        GL11.glPixelStorei(GL11.GL_PACK_SKIP_PIXELS, 0);
        if (nearestPower == i10 && nearestPower2 == i11) {
            byteBuffer2 = byteBuffer4;
            z = false;
            i7 = 0;
        } else {
            byteBuffer2 = BufferUtils.createByteBuffer(bytesPerPixel * nearestPower2 * (nearestPower + 4));
            int gluScaleImage = gluScaleImage(i12, i10, i11, i13, byteBuffer4, nearestPower, nearestPower2, i13, byteBuffer2);
            z = false;
            i7 = 0;
            if (gluScaleImage != 0) {
                i7 = gluScaleImage;
                z = true;
            }
            GL11.glPixelStorei(GL11.GL_UNPACK_ROW_LENGTH, 0);
            GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
            GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_ROWS, 0);
            GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_PIXELS, 0);
        }
        ByteBuffer byteBuffer5 = null;
        ByteBuffer byteBuffer6 = null;
        int i14 = 0;
        while (!z) {
            if (byteBuffer2 != byteBuffer4) {
                GL11.glPixelStorei(GL11.GL_UNPACK_ROW_LENGTH, 0);
                GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
                GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_ROWS, 0);
                GL11.glPixelStorei(GL11.GL_UNPACK_SKIP_PIXELS, 0);
            }
            GL11.glTexImage2D(i8, i14, i9, nearestPower, nearestPower2, 0, i12, i13, byteBuffer2);
            if (nearestPower == 1 && nearestPower2 == 1) {
                break;
            }
            int i15 = nearestPower < 2 ? 1 : nearestPower >> 1;
            int i16 = nearestPower2 < 2 ? 1 : nearestPower2 >> 1;
            if (byteBuffer5 == null) {
                byteBuffer5 = BufferUtils.createByteBuffer(bytesPerPixel * i16 * (i15 + 4));
                byteBuffer3 = byteBuffer5;
            } else if (byteBuffer6 == null) {
                byteBuffer6 = BufferUtils.createByteBuffer(bytesPerPixel * i16 * (i15 + 4));
                byteBuffer3 = byteBuffer6;
            } else {
                byteBuffer3 = byteBuffer6;
            }
            int gluScaleImage2 = gluScaleImage(i12, nearestPower, nearestPower2, i13, byteBuffer2, i15, i16, i13, byteBuffer3);
            if (gluScaleImage2 != 0) {
                i7 = gluScaleImage2;
                z = true;
            }
            byteBuffer2 = byteBuffer3;
            if (byteBuffer6 != null) {
                byteBuffer6 = byteBuffer5;
            }
            nearestPower = i15;
            nearestPower2 = i16;
            i14++;
        }
        pixelStoreState4.save();
        return i7;
    }

    public static int gluScaleImage(int i, int i2, int i3, int i4, ByteBuffer byteBuffer, int i5, int i6, int i7, ByteBuffer byteBuffer2) {
        int i8;
        int i9;
        PixelStoreState pixelStoreState;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        ByteBuffer byteBuffer3 = byteBuffer;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        ByteBuffer byteBuffer4 = byteBuffer2;
        int compPerPix = compPerPix(i);
        if (compPerPix == -1) {
            return 100900;
        }
        float[] fArr = new float[(compPerPix * i10 * i11)];
        float[] fArr2 = new float[(compPerPix * i13 * i14)];
        switch (i12) {
            case GL11.GL_UNSIGNED_BYTE /*5121*/:
                i8 = 1;
                break;
            case GL11.GL_FLOAT /*5126*/:
                i8 = 4;
                break;
            default:
                return GL11.GL_INVALID_ENUM;
        }
        switch (i15) {
            case GL11.GL_UNSIGNED_BYTE /*5121*/:
                i9 = 1;
                break;
            case GL11.GL_FLOAT /*5126*/:
                i9 = 4;
                break;
            default:
                return GL11.GL_INVALID_ENUM;
        }
        PixelStoreState pixelStoreState2 = pixelStoreState;
        PixelStoreState pixelStoreState3 = new PixelStoreState();
        PixelStoreState pixelStoreState4 = pixelStoreState2;
        int i16 = pixelStoreState4.unpackRowLength > 0 ? pixelStoreState4.unpackRowLength : i10;
        int ceil = i8 >= pixelStoreState4.unpackAlignment ? compPerPix * i16 : (pixelStoreState4.unpackAlignment / i8) * ceil(i8 * compPerPix * i16, pixelStoreState4.unpackAlignment);
        switch (i12) {
            case GL11.GL_UNSIGNED_BYTE /*5121*/:
                int i17 = 0;
                Buffer rewind = byteBuffer3.rewind();
                int i18 = 0;
                while (i18 < i11) {
                    int i19 = 0;
                    int i20 = (i18 * ceil) + (ceil * pixelStoreState4.unpackSkipRows) + (compPerPix * pixelStoreState4.unpackSkipPixels);
                    int i21 = i17;
                    while (true) {
                        int i22 = i21;
                        if (i19 < i10 * compPerPix) {
                            int i23 = i22 + 1;
                            int i24 = i20 + 1;
                            fArr[i22] = (float) (255 & byteBuffer3.get(i20));
                            i19++;
                            i20 = i24;
                            i21 = i23;
                        } else {
                            i18++;
                            i17 = i22;
                        }
                    }
                }
                break;
            case GL11.GL_FLOAT /*5126*/:
                int i25 = 0;
                Buffer rewind2 = byteBuffer3.rewind();
                int i26 = 0;
                while (i26 < i11) {
                    int i27 = 4 * ((i26 * ceil) + (ceil * pixelStoreState4.unpackSkipRows) + (compPerPix * pixelStoreState4.unpackSkipPixels));
                    int i28 = 0;
                    int i29 = i25;
                    while (true) {
                        int i30 = i29;
                        if (i28 < i10 * compPerPix) {
                            int i31 = i30 + 1;
                            fArr[i30] = byteBuffer3.getFloat(i27);
                            i27 += 4;
                            i28++;
                            i29 = i31;
                        } else {
                            i26++;
                            i25 = i30;
                        }
                    }
                }
                break;
            default:
                return 100900;
        }
        float f = ((float) i10) / ((float) i13);
        float f2 = ((float) i11) / ((float) i14);
        float[] fArr3 = new float[compPerPix];
        for (int i32 = 0; i32 < i14; i32++) {
            for (int i33 = 0; i33 < i13; i33++) {
                int i34 = (int) (f * ((float) i33));
                int i35 = (int) (f * ((float) (i33 + 1)));
                int i36 = (int) (f2 * ((float) i32));
                int i37 = (int) (f2 * ((float) (i32 + 1)));
                int i38 = 0;
                for (int i39 = 0; i39 < compPerPix; i39++) {
                    fArr3[i39] = 0.0f;
                }
                for (int i40 = i34; i40 < i35; i40++) {
                    for (int i41 = i36; i41 < i37; i41++) {
                        int i42 = compPerPix * (i40 + (i41 * i10));
                        for (int i43 = 0; i43 < compPerPix; i43++) {
                            fArr3[i43] = fArr3[i43] + fArr[i42 + i43];
                        }
                        i38++;
                    }
                }
                int i44 = compPerPix * (i33 + (i32 * i13));
                if (i38 == 0) {
                    int i45 = compPerPix * (i34 + (i36 * i10));
                    int i46 = 0;
                    int i47 = i44;
                    while (true) {
                        int i48 = i47;
                        if (i46 < compPerPix) {
                            int i49 = i48 + 1;
                            fArr2[i48] = fArr[i45 + i46];
                            i46++;
                            i47 = i49;
                        } else {
                            int i50 = i48;
                        }
                    }
                } else {
                    int i51 = 0;
                    int i52 = i44;
                    while (true) {
                        int i53 = i52;
                        if (i51 < compPerPix) {
                            int i54 = i53 + 1;
                            fArr2[i53] = fArr3[i51] / ((float) i38);
                            i51++;
                            i52 = i54;
                        } else {
                            int i55 = i53;
                        }
                    }
                }
            }
        }
        int i56 = pixelStoreState4.packRowLength > 0 ? pixelStoreState4.packRowLength : i13;
        int ceil2 = i9 >= pixelStoreState4.packAlignment ? compPerPix * i56 : (pixelStoreState4.packAlignment / i9) * ceil(i9 * compPerPix * i56, pixelStoreState4.packAlignment);
        switch (i15) {
            case GL11.GL_UNSIGNED_BYTE /*5121*/:
                int i57 = 0;
                int i58 = 0;
                while (i58 < i14) {
                    int i59 = 0;
                    int i60 = (i58 * ceil2) + (ceil2 * pixelStoreState4.packSkipRows) + (compPerPix * pixelStoreState4.packSkipPixels);
                    int i61 = i57;
                    while (true) {
                        int i62 = i61;
                        if (i59 < i13 * compPerPix) {
                            int i63 = i60 + 1;
                            int i64 = i62 + 1;
                            ByteBuffer put = byteBuffer4.put(i60, (byte) ((int) fArr2[i62]));
                            i59++;
                            i60 = i63;
                            i61 = i64;
                        } else {
                            i58++;
                            i57 = i62;
                        }
                    }
                }
                break;
            case GL11.GL_FLOAT /*5126*/:
                int i65 = 0;
                int i66 = 0;
                while (i66 < i14) {
                    int i67 = 4 * ((i66 * ceil2) + (ceil2 * pixelStoreState4.unpackSkipRows) + (compPerPix * pixelStoreState4.unpackSkipPixels));
                    int i68 = 0;
                    int i69 = i65;
                    while (true) {
                        int i70 = i69;
                        if (i68 < i13 * compPerPix) {
                            int i71 = i70 + 1;
                            ByteBuffer putFloat = byteBuffer4.putFloat(i67, fArr2[i70]);
                            i67 += 4;
                            i68++;
                            i69 = i71;
                        } else {
                            i66++;
                            i65 = i70;
                        }
                    }
                }
                break;
            default:
                return 100900;
        }
        return 0;
    }
}
