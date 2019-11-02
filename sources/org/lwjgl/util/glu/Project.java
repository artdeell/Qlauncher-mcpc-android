package org.lwjgl.util.glu;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Project extends Util {
    private static final float[] IDENTITY_MATRIX = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final FloatBuffer finalMatrix = BufferUtils.createFloatBuffer(16);
    private static final float[] forward = new float[3];

    /* renamed from: in */
    private static final float[] f239in = new float[4];
    private static final FloatBuffer matrix = BufferUtils.createFloatBuffer(16);
    private static final float[] out = new float[4];
    private static final float[] side = new float[3];
    private static final FloatBuffer tempMatrix = BufferUtils.createFloatBuffer(16);

    /* renamed from: up */
    private static final float[] f240up = new float[3];

    public Project() {
    }

    private static boolean __gluInvertMatrixf(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        FloatBuffer floatBuffer3 = floatBuffer;
        FloatBuffer floatBuffer4 = floatBuffer2;
        FloatBuffer floatBuffer5 = tempMatrix;
        for (int i = 0; i < 16; i++) {
            FloatBuffer put = floatBuffer5.put(i, floatBuffer3.get(i + floatBuffer3.position()));
        }
        __gluMakeIdentityf(floatBuffer4);
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2;
            for (int i4 = i2 + 1; i4 < 4; i4++) {
                if (Math.abs(floatBuffer5.get(i2 + (i4 * 4))) > Math.abs(floatBuffer5.get(i2 + (i2 * 4)))) {
                    i3 = i4;
                }
            }
            if (i3 != i2) {
                for (int i5 = 0; i5 < 4; i5++) {
                    float f = floatBuffer5.get(i5 + (i2 * 4));
                    FloatBuffer put2 = floatBuffer5.put(i5 + (i2 * 4), floatBuffer5.get(i5 + (i3 * 4)));
                    FloatBuffer put3 = floatBuffer5.put(i5 + (i3 * 4), f);
                    float f2 = floatBuffer4.get(i5 + (i2 * 4));
                    FloatBuffer put4 = floatBuffer4.put(i5 + (i2 * 4), floatBuffer4.get(i5 + (i3 * 4)));
                    FloatBuffer put5 = floatBuffer4.put(i5 + (i3 * 4), f2);
                }
            }
            if (floatBuffer5.get(i2 + (i2 * 4)) == 0.0f) {
                return false;
            }
            float f3 = floatBuffer5.get(i2 + (i2 * 4));
            for (int i6 = 0; i6 < 4; i6++) {
                FloatBuffer put6 = floatBuffer5.put(i6 + (i2 * 4), floatBuffer5.get(i6 + (i2 * 4)) / f3);
                FloatBuffer put7 = floatBuffer4.put(i6 + (i2 * 4), floatBuffer4.get(i6 + (i2 * 4)) / f3);
            }
            for (int i7 = 0; i7 < 4; i7++) {
                if (i7 != i2) {
                    float f4 = floatBuffer5.get(i2 + (i7 * 4));
                    for (int i8 = 0; i8 < 4; i8++) {
                        FloatBuffer put8 = floatBuffer5.put(i8 + (i7 * 4), floatBuffer5.get(i8 + (i7 * 4)) - (f4 * floatBuffer5.get(i8 + (i2 * 4))));
                        FloatBuffer put9 = floatBuffer4.put(i8 + (i7 * 4), floatBuffer4.get(i8 + (i7 * 4)) - (f4 * floatBuffer4.get(i8 + (i2 * 4))));
                    }
                }
            }
        }
        return true;
    }

    private static void __gluMakeIdentityf(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        int position = floatBuffer2.position();
        FloatBuffer put = floatBuffer2.put(IDENTITY_MATRIX);
        Buffer position2 = floatBuffer2.position(position);
    }

    private static void __gluMultMatricesf(FloatBuffer floatBuffer, FloatBuffer floatBuffer2, FloatBuffer floatBuffer3) {
        FloatBuffer floatBuffer4 = floatBuffer;
        FloatBuffer floatBuffer5 = floatBuffer2;
        FloatBuffer floatBuffer6 = floatBuffer3;
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                FloatBuffer put = floatBuffer6.put(i2 + floatBuffer6.position() + (i * 4), (floatBuffer4.get(0 + floatBuffer4.position() + (i * 4)) * floatBuffer5.get(i2 + 0 + floatBuffer5.position())) + (floatBuffer4.get(1 + floatBuffer4.position() + (i * 4)) * floatBuffer5.get(i2 + 4 + floatBuffer5.position())) + (floatBuffer4.get(2 + floatBuffer4.position() + (i * 4)) * floatBuffer5.get(i2 + 8 + floatBuffer5.position())) + (floatBuffer4.get(3 + floatBuffer4.position() + (i * 4)) * floatBuffer5.get(i2 + 12 + floatBuffer5.position())));
            }
        }
    }

    private static void __gluMultMatrixVecf(FloatBuffer floatBuffer, float[] fArr, float[] fArr2) {
        FloatBuffer floatBuffer2 = floatBuffer;
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        for (int i = 0; i < 4; i++) {
            fArr4[i] = (fArr3[0] * floatBuffer2.get(i + 0 + floatBuffer2.position())) + (fArr3[1] * floatBuffer2.get(i + 4 + floatBuffer2.position())) + (fArr3[2] * floatBuffer2.get(i + 8 + floatBuffer2.position())) + (fArr3[3] * floatBuffer2.get(i + 12 + floatBuffer2.position()));
        }
    }

    public static void gluLookAt(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f;
        float f11 = f2;
        float f12 = f3;
        float f13 = f4;
        float f14 = f5;
        float f15 = f6;
        float f16 = f7;
        float f17 = f8;
        float f18 = f9;
        float[] fArr = forward;
        float[] fArr2 = side;
        float[] fArr3 = f240up;
        fArr[0] = f13 - f10;
        fArr[1] = f14 - f11;
        fArr[2] = f15 - f12;
        fArr3[0] = f16;
        fArr3[1] = f17;
        fArr3[2] = f18;
        float[] normalize = normalize(fArr);
        cross(fArr, fArr3, fArr2);
        float[] normalize2 = normalize(fArr2);
        cross(fArr2, fArr, fArr3);
        __gluMakeIdentityf(matrix);
        FloatBuffer put = matrix.put(0, fArr2[0]);
        FloatBuffer put2 = matrix.put(4, fArr2[1]);
        FloatBuffer put3 = matrix.put(8, fArr2[2]);
        FloatBuffer put4 = matrix.put(1, fArr3[0]);
        FloatBuffer put5 = matrix.put(5, fArr3[1]);
        FloatBuffer put6 = matrix.put(9, fArr3[2]);
        FloatBuffer put7 = matrix.put(2, -fArr[0]);
        FloatBuffer put8 = matrix.put(6, -fArr[1]);
        FloatBuffer put9 = matrix.put(10, -fArr[2]);
        GL11.glMultMatrix(matrix);
        GL11.glTranslatef(-f10, -f11, -f12);
    }

    public static void gluPerspective(float f, float f2, float f3, float f4) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        float f8 = (3.1415927f * (f / 2.0f)) / 180.0f;
        float f9 = f7 - f6;
        float sin = (float) Math.sin((double) f8);
        if (f9 != 0.0f && sin != 0.0f && f5 != 0.0f) {
            float cos = ((float) Math.cos((double) f8)) / sin;
            __gluMakeIdentityf(matrix);
            FloatBuffer put = matrix.put(0, cos / f5);
            FloatBuffer put2 = matrix.put(5, cos);
            FloatBuffer put3 = matrix.put(10, (-(f7 + f6)) / f9);
            FloatBuffer put4 = matrix.put(11, -1.0f);
            FloatBuffer put5 = matrix.put(14, (f7 * (-2.0f * f6)) / f9);
            FloatBuffer put6 = matrix.put(15, 0.0f);
            GL11.glMultMatrix(matrix);
        }
    }

    public static void gluPickMatrix(float f, float f2, float f3, float f4, IntBuffer intBuffer) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        IntBuffer intBuffer2 = intBuffer;
        if (f7 > 0.0f && f8 > 0.0f) {
            GL11.glTranslatef((((float) intBuffer2.get(2 + intBuffer2.position())) - (2.0f * (f5 - ((float) intBuffer2.get(0 + intBuffer2.position()))))) / f7, (((float) intBuffer2.get(3 + intBuffer2.position())) - (2.0f * (f6 - ((float) intBuffer2.get(1 + intBuffer2.position()))))) / f8, 0.0f);
            GL11.glScalef(((float) intBuffer2.get(2 + intBuffer2.position())) / f7, ((float) intBuffer2.get(3 + intBuffer2.position())) / f8, 1.0f);
        }
    }

    public static boolean gluProject(float f, float f2, float f3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, IntBuffer intBuffer, FloatBuffer floatBuffer3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        FloatBuffer floatBuffer4 = floatBuffer;
        FloatBuffer floatBuffer5 = floatBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer6 = floatBuffer3;
        float[] fArr = f239in;
        float[] fArr2 = out;
        fArr[0] = f4;
        fArr[1] = f5;
        fArr[2] = f6;
        fArr[3] = 1.0f;
        __gluMultMatrixVecf(floatBuffer4, fArr, fArr2);
        __gluMultMatrixVecf(floatBuffer5, fArr2, fArr);
        if (((double) fArr[3]) == 0.0d) {
            return false;
        }
        fArr[3] = 0.5f * (1.0f / fArr[3]);
        fArr[0] = 0.5f + (fArr[0] * fArr[3]);
        fArr[1] = 0.5f + (fArr[1] * fArr[3]);
        fArr[2] = 0.5f + (fArr[2] * fArr[3]);
        FloatBuffer put = floatBuffer6.put(0, (fArr[0] * ((float) intBuffer2.get(2 + intBuffer2.position()))) + ((float) intBuffer2.get(0 + intBuffer2.position())));
        FloatBuffer put2 = floatBuffer6.put(1, (fArr[1] * ((float) intBuffer2.get(3 + intBuffer2.position()))) + ((float) intBuffer2.get(1 + intBuffer2.position())));
        FloatBuffer put3 = floatBuffer6.put(2, fArr[2]);
        return true;
    }

    public static boolean gluUnProject(float f, float f2, float f3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, IntBuffer intBuffer, FloatBuffer floatBuffer3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f3;
        FloatBuffer floatBuffer4 = floatBuffer;
        FloatBuffer floatBuffer5 = floatBuffer2;
        IntBuffer intBuffer2 = intBuffer;
        FloatBuffer floatBuffer6 = floatBuffer3;
        float[] fArr = f239in;
        float[] fArr2 = out;
        __gluMultMatricesf(floatBuffer4, floatBuffer5, finalMatrix);
        if (!__gluInvertMatrixf(finalMatrix, finalMatrix)) {
            return false;
        }
        fArr[0] = f4;
        fArr[1] = f5;
        fArr[2] = f6;
        fArr[3] = 1.0f;
        fArr[0] = (fArr[0] - ((float) intBuffer2.get(0 + intBuffer2.position()))) / ((float) intBuffer2.get(2 + intBuffer2.position()));
        fArr[1] = (fArr[1] - ((float) intBuffer2.get(1 + intBuffer2.position()))) / ((float) intBuffer2.get(3 + intBuffer2.position()));
        fArr[0] = (2.0f * fArr[0]) - 1.0f;
        fArr[1] = (2.0f * fArr[1]) - 1.0f;
        fArr[2] = (2.0f * fArr[2]) - 1.0f;
        __gluMultMatrixVecf(finalMatrix, fArr, fArr2);
        if (((double) fArr2[3]) == 0.0d) {
            return false;
        }
        fArr2[3] = 1.0f / fArr2[3];
        FloatBuffer put = floatBuffer6.put(0 + floatBuffer6.position(), fArr2[0] * fArr2[3]);
        FloatBuffer put2 = floatBuffer6.put(1 + floatBuffer6.position(), fArr2[1] * fArr2[3]);
        FloatBuffer put3 = floatBuffer6.put(2 + floatBuffer6.position(), fArr2[2] * fArr2[3]);
        return true;
    }
}
