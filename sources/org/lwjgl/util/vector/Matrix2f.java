package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Matrix2f extends Matrix implements Serializable {
    private static final long serialVersionUID = 1;
    public float m00;
    public float m01;
    public float m10;
    public float m11;

    public Matrix2f() {
        Matrix identity = setIdentity();
    }

    public Matrix2f(Matrix2f matrix2f) {
        Matrix2f load = load(matrix2f);
    }

    public static Matrix2f add(Matrix2f matrix2f, Matrix2f matrix2f2, Matrix2f matrix2f3) {
        Matrix2f matrix2f4;
        Matrix2f matrix2f5 = matrix2f;
        Matrix2f matrix2f6 = matrix2f2;
        Matrix2f matrix2f7 = matrix2f3;
        if (matrix2f7 == null) {
            Matrix2f matrix2f8 = matrix2f4;
            Matrix2f matrix2f9 = new Matrix2f();
            matrix2f7 = matrix2f8;
        }
        matrix2f7.m00 = matrix2f5.m00 + matrix2f6.m00;
        matrix2f7.m01 = matrix2f5.m01 + matrix2f6.m01;
        matrix2f7.m10 = matrix2f5.m10 + matrix2f6.m10;
        matrix2f7.m11 = matrix2f5.m11 + matrix2f6.m11;
        return matrix2f7;
    }

    public static Matrix2f invert(Matrix2f matrix2f, Matrix2f matrix2f2) {
        Matrix2f matrix2f3;
        Matrix2f matrix2f4 = matrix2f;
        Matrix2f matrix2f5 = matrix2f2;
        float determinant = matrix2f4.determinant();
        if (determinant == 0.0f) {
            return null;
        }
        if (matrix2f5 == null) {
            Matrix2f matrix2f6 = matrix2f3;
            Matrix2f matrix2f7 = new Matrix2f();
            matrix2f5 = matrix2f6;
        }
        float f = 1.0f / determinant;
        float f2 = f * (-matrix2f4.m01);
        float f3 = f * matrix2f4.m00;
        float f4 = f * (-matrix2f4.m10);
        matrix2f5.m00 = f * matrix2f4.m11;
        matrix2f5.m01 = f2;
        matrix2f5.m10 = f4;
        matrix2f5.m11 = f3;
        return matrix2f5;
    }

    public static Matrix2f load(Matrix2f matrix2f, Matrix2f matrix2f2) {
        Matrix2f matrix2f3;
        Matrix2f matrix2f4 = matrix2f;
        Matrix2f matrix2f5 = matrix2f2;
        if (matrix2f5 == null) {
            Matrix2f matrix2f6 = matrix2f3;
            Matrix2f matrix2f7 = new Matrix2f();
            matrix2f5 = matrix2f6;
        }
        matrix2f5.m00 = matrix2f4.m00;
        matrix2f5.m01 = matrix2f4.m01;
        matrix2f5.m10 = matrix2f4.m10;
        matrix2f5.m11 = matrix2f4.m11;
        return matrix2f5;
    }

    public static Matrix2f mul(Matrix2f matrix2f, Matrix2f matrix2f2, Matrix2f matrix2f3) {
        Matrix2f matrix2f4;
        Matrix2f matrix2f5 = matrix2f;
        Matrix2f matrix2f6 = matrix2f2;
        Matrix2f matrix2f7 = matrix2f3;
        if (matrix2f7 == null) {
            Matrix2f matrix2f8 = matrix2f4;
            Matrix2f matrix2f9 = new Matrix2f();
            matrix2f7 = matrix2f8;
        }
        float f = (matrix2f5.m01 * matrix2f6.m00) + (matrix2f5.m11 * matrix2f6.m01);
        float f2 = (matrix2f5.m00 * matrix2f6.m10) + (matrix2f5.m10 * matrix2f6.m11);
        float f3 = (matrix2f5.m01 * matrix2f6.m10) + (matrix2f5.m11 * matrix2f6.m11);
        matrix2f7.m00 = (matrix2f5.m00 * matrix2f6.m00) + (matrix2f5.m10 * matrix2f6.m01);
        matrix2f7.m01 = f;
        matrix2f7.m10 = f2;
        matrix2f7.m11 = f3;
        return matrix2f7;
    }

    public static Matrix2f negate(Matrix2f matrix2f, Matrix2f matrix2f2) {
        Matrix2f matrix2f3;
        Matrix2f matrix2f4 = matrix2f;
        Matrix2f matrix2f5 = matrix2f2;
        if (matrix2f5 == null) {
            Matrix2f matrix2f6 = matrix2f3;
            Matrix2f matrix2f7 = new Matrix2f();
            matrix2f5 = matrix2f6;
        }
        matrix2f5.m00 = -matrix2f4.m00;
        matrix2f5.m01 = -matrix2f4.m01;
        matrix2f5.m10 = -matrix2f4.m10;
        matrix2f5.m11 = -matrix2f4.m11;
        return matrix2f5;
    }

    public static Matrix2f setIdentity(Matrix2f matrix2f) {
        Matrix2f matrix2f2 = matrix2f;
        matrix2f2.m00 = 1.0f;
        matrix2f2.m01 = 0.0f;
        matrix2f2.m10 = 0.0f;
        matrix2f2.m11 = 1.0f;
        return matrix2f2;
    }

    public static Matrix2f setZero(Matrix2f matrix2f) {
        Matrix2f matrix2f2 = matrix2f;
        matrix2f2.m00 = 0.0f;
        matrix2f2.m01 = 0.0f;
        matrix2f2.m10 = 0.0f;
        matrix2f2.m11 = 0.0f;
        return matrix2f2;
    }

    public static Matrix2f sub(Matrix2f matrix2f, Matrix2f matrix2f2, Matrix2f matrix2f3) {
        Matrix2f matrix2f4;
        Matrix2f matrix2f5 = matrix2f;
        Matrix2f matrix2f6 = matrix2f2;
        Matrix2f matrix2f7 = matrix2f3;
        if (matrix2f7 == null) {
            Matrix2f matrix2f8 = matrix2f4;
            Matrix2f matrix2f9 = new Matrix2f();
            matrix2f7 = matrix2f8;
        }
        matrix2f7.m00 = matrix2f5.m00 - matrix2f6.m00;
        matrix2f7.m01 = matrix2f5.m01 - matrix2f6.m01;
        matrix2f7.m10 = matrix2f5.m10 - matrix2f6.m10;
        matrix2f7.m11 = matrix2f5.m11 - matrix2f6.m11;
        return matrix2f7;
    }

    public static Vector2f transform(Matrix2f matrix2f, Vector2f vector2f, Vector2f vector2f2) {
        Vector2f vector2f3;
        Matrix2f matrix2f2 = matrix2f;
        Vector2f vector2f4 = vector2f;
        Vector2f vector2f5 = vector2f2;
        if (vector2f5 == null) {
            Vector2f vector2f6 = vector2f3;
            Vector2f vector2f7 = new Vector2f();
            vector2f5 = vector2f6;
        }
        float f = (matrix2f2.m01 * vector2f4.f259x) + (matrix2f2.m11 * vector2f4.f260y);
        vector2f5.f259x = (matrix2f2.m00 * vector2f4.f259x) + (matrix2f2.m10 * vector2f4.f260y);
        vector2f5.f260y = f;
        return vector2f5;
    }

    public static Matrix2f transpose(Matrix2f matrix2f, Matrix2f matrix2f2) {
        Matrix2f matrix2f3;
        Matrix2f matrix2f4 = matrix2f;
        Matrix2f matrix2f5 = matrix2f2;
        if (matrix2f5 == null) {
            Matrix2f matrix2f6 = matrix2f3;
            Matrix2f matrix2f7 = new Matrix2f();
            matrix2f5 = matrix2f6;
        }
        float f = matrix2f4.m10;
        float f2 = matrix2f4.m01;
        matrix2f5.m01 = f;
        matrix2f5.m10 = f2;
        return matrix2f5;
    }

    public float determinant() {
        return (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public Matrix invert() {
        return invert(this, this);
    }

    public Matrix2f load(Matrix2f matrix2f) {
        return load(matrix2f, this);
    }

    public Matrix load(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.m00 = floatBuffer2.get();
        this.m01 = floatBuffer2.get();
        this.m10 = floatBuffer2.get();
        this.m11 = floatBuffer2.get();
        return this;
    }

    public Matrix loadTranspose(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.m00 = floatBuffer2.get();
        this.m10 = floatBuffer2.get();
        this.m01 = floatBuffer2.get();
        this.m11 = floatBuffer2.get();
        return this;
    }

    public Matrix2f negate(Matrix2f matrix2f) {
        return negate(this, matrix2f);
    }

    public Matrix negate() {
        return negate(this);
    }

    public Matrix setIdentity() {
        return setIdentity(this);
    }

    public Matrix setZero() {
        return setZero(this);
    }

    public Matrix store(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.m00);
        FloatBuffer put2 = floatBuffer2.put(this.m01);
        FloatBuffer put3 = floatBuffer2.put(this.m10);
        FloatBuffer put4 = floatBuffer2.put(this.m11);
        return this;
    }

    public Matrix storeTranspose(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.m00);
        FloatBuffer put2 = floatBuffer2.put(this.m10);
        FloatBuffer put3 = floatBuffer2.put(this.m01);
        FloatBuffer put4 = floatBuffer2.put(this.m11);
        return this;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(this.m00).append(' ').append(this.m10).append(' ').append(10);
        StringBuilder append2 = sb4.append(this.m01).append(' ').append(this.m11).append(' ').append(10);
        return sb4.toString();
    }

    public Matrix2f transpose(Matrix2f matrix2f) {
        return transpose(this, matrix2f);
    }

    public Matrix transpose() {
        return transpose(this);
    }
}
