package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Matrix3f extends Matrix implements Serializable {
    private static final long serialVersionUID = 1;
    public float m00;
    public float m01;
    public float m02;
    public float m10;
    public float m11;
    public float m12;
    public float m20;
    public float m21;
    public float m22;

    public Matrix3f() {
        Matrix identity = setIdentity();
    }

    public static Matrix3f add(Matrix3f matrix3f, Matrix3f matrix3f2, Matrix3f matrix3f3) {
        Matrix3f matrix3f4;
        Matrix3f matrix3f5 = matrix3f;
        Matrix3f matrix3f6 = matrix3f2;
        Matrix3f matrix3f7 = matrix3f3;
        if (matrix3f7 == null) {
            Matrix3f matrix3f8 = matrix3f4;
            Matrix3f matrix3f9 = new Matrix3f();
            matrix3f7 = matrix3f8;
        }
        matrix3f7.m00 = matrix3f5.m00 + matrix3f6.m00;
        matrix3f7.m01 = matrix3f5.m01 + matrix3f6.m01;
        matrix3f7.m02 = matrix3f5.m02 + matrix3f6.m02;
        matrix3f7.m10 = matrix3f5.m10 + matrix3f6.m10;
        matrix3f7.m11 = matrix3f5.m11 + matrix3f6.m11;
        matrix3f7.m12 = matrix3f5.m12 + matrix3f6.m12;
        matrix3f7.m20 = matrix3f5.m20 + matrix3f6.m20;
        matrix3f7.m21 = matrix3f5.m21 + matrix3f6.m21;
        matrix3f7.m22 = matrix3f5.m22 + matrix3f6.m22;
        return matrix3f7;
    }

    public static Matrix3f invert(Matrix3f matrix3f, Matrix3f matrix3f2) {
        Matrix3f matrix3f3;
        Matrix3f matrix3f4 = matrix3f;
        Matrix3f matrix3f5 = matrix3f2;
        float determinant = matrix3f4.determinant();
        if (determinant == 0.0f) {
            return null;
        }
        if (matrix3f5 == null) {
            Matrix3f matrix3f6 = matrix3f3;
            Matrix3f matrix3f7 = new Matrix3f();
            matrix3f5 = matrix3f6;
        }
        float f = 1.0f / determinant;
        float f2 = ((-matrix3f4.m10) * matrix3f4.m22) + (matrix3f4.m12 * matrix3f4.m20);
        float f3 = (matrix3f4.m10 * matrix3f4.m21) - (matrix3f4.m11 * matrix3f4.m20);
        float f4 = ((-matrix3f4.m01) * matrix3f4.m22) + (matrix3f4.m02 * matrix3f4.m21);
        float f5 = (matrix3f4.m00 * matrix3f4.m22) - (matrix3f4.m02 * matrix3f4.m20);
        float f6 = ((-matrix3f4.m00) * matrix3f4.m21) + (matrix3f4.m01 * matrix3f4.m20);
        float f7 = (matrix3f4.m01 * matrix3f4.m12) - (matrix3f4.m02 * matrix3f4.m11);
        float f8 = ((-matrix3f4.m00) * matrix3f4.m12) + (matrix3f4.m02 * matrix3f4.m10);
        float f9 = (matrix3f4.m00 * matrix3f4.m11) - (matrix3f4.m01 * matrix3f4.m10);
        matrix3f5.m00 = ((matrix3f4.m11 * matrix3f4.m22) - (matrix3f4.m12 * matrix3f4.m21)) * f;
        matrix3f5.m11 = f5 * f;
        matrix3f5.m22 = f9 * f;
        matrix3f5.m01 = f4 * f;
        matrix3f5.m10 = f2 * f;
        matrix3f5.m20 = f3 * f;
        matrix3f5.m02 = f7 * f;
        matrix3f5.m12 = f8 * f;
        matrix3f5.m21 = f6 * f;
        return matrix3f5;
    }

    public static Matrix3f load(Matrix3f matrix3f, Matrix3f matrix3f2) {
        Matrix3f matrix3f3;
        Matrix3f matrix3f4 = matrix3f;
        Matrix3f matrix3f5 = matrix3f2;
        if (matrix3f5 == null) {
            Matrix3f matrix3f6 = matrix3f3;
            Matrix3f matrix3f7 = new Matrix3f();
            matrix3f5 = matrix3f6;
        }
        matrix3f5.m00 = matrix3f4.m00;
        matrix3f5.m10 = matrix3f4.m10;
        matrix3f5.m20 = matrix3f4.m20;
        matrix3f5.m01 = matrix3f4.m01;
        matrix3f5.m11 = matrix3f4.m11;
        matrix3f5.m21 = matrix3f4.m21;
        matrix3f5.m02 = matrix3f4.m02;
        matrix3f5.m12 = matrix3f4.m12;
        matrix3f5.m22 = matrix3f4.m22;
        return matrix3f5;
    }

    public static Matrix3f mul(Matrix3f matrix3f, Matrix3f matrix3f2, Matrix3f matrix3f3) {
        Matrix3f matrix3f4;
        Matrix3f matrix3f5 = matrix3f;
        Matrix3f matrix3f6 = matrix3f2;
        Matrix3f matrix3f7 = matrix3f3;
        if (matrix3f7 == null) {
            Matrix3f matrix3f8 = matrix3f4;
            Matrix3f matrix3f9 = new Matrix3f();
            matrix3f7 = matrix3f8;
        }
        float f = (matrix3f5.m01 * matrix3f6.m00) + (matrix3f5.m11 * matrix3f6.m01) + (matrix3f5.m21 * matrix3f6.m02);
        float f2 = (matrix3f5.m02 * matrix3f6.m00) + (matrix3f5.m12 * matrix3f6.m01) + (matrix3f5.m22 * matrix3f6.m02);
        float f3 = (matrix3f5.m00 * matrix3f6.m10) + (matrix3f5.m10 * matrix3f6.m11) + (matrix3f5.m20 * matrix3f6.m12);
        float f4 = (matrix3f5.m01 * matrix3f6.m10) + (matrix3f5.m11 * matrix3f6.m11) + (matrix3f5.m21 * matrix3f6.m12);
        float f5 = (matrix3f5.m02 * matrix3f6.m10) + (matrix3f5.m12 * matrix3f6.m11) + (matrix3f5.m22 * matrix3f6.m12);
        float f6 = (matrix3f5.m00 * matrix3f6.m20) + (matrix3f5.m10 * matrix3f6.m21) + (matrix3f5.m20 * matrix3f6.m22);
        float f7 = (matrix3f5.m01 * matrix3f6.m20) + (matrix3f5.m11 * matrix3f6.m21) + (matrix3f5.m21 * matrix3f6.m22);
        float f8 = (matrix3f5.m02 * matrix3f6.m20) + (matrix3f5.m12 * matrix3f6.m21) + (matrix3f5.m22 * matrix3f6.m22);
        matrix3f7.m00 = (matrix3f5.m00 * matrix3f6.m00) + (matrix3f5.m10 * matrix3f6.m01) + (matrix3f5.m20 * matrix3f6.m02);
        matrix3f7.m01 = f;
        matrix3f7.m02 = f2;
        matrix3f7.m10 = f3;
        matrix3f7.m11 = f4;
        matrix3f7.m12 = f5;
        matrix3f7.m20 = f6;
        matrix3f7.m21 = f7;
        matrix3f7.m22 = f8;
        return matrix3f7;
    }

    public static Matrix3f negate(Matrix3f matrix3f, Matrix3f matrix3f2) {
        Matrix3f matrix3f3;
        Matrix3f matrix3f4 = matrix3f;
        Matrix3f matrix3f5 = matrix3f2;
        if (matrix3f5 == null) {
            Matrix3f matrix3f6 = matrix3f3;
            Matrix3f matrix3f7 = new Matrix3f();
            matrix3f5 = matrix3f6;
        }
        matrix3f5.m00 = -matrix3f4.m00;
        matrix3f5.m01 = -matrix3f4.m02;
        matrix3f5.m02 = -matrix3f4.m01;
        matrix3f5.m10 = -matrix3f4.m10;
        matrix3f5.m11 = -matrix3f4.m12;
        matrix3f5.m12 = -matrix3f4.m11;
        matrix3f5.m20 = -matrix3f4.m20;
        matrix3f5.m21 = -matrix3f4.m22;
        matrix3f5.m22 = -matrix3f4.m21;
        return matrix3f5;
    }

    public static Matrix3f setIdentity(Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        matrix3f2.m00 = 1.0f;
        matrix3f2.m01 = 0.0f;
        matrix3f2.m02 = 0.0f;
        matrix3f2.m10 = 0.0f;
        matrix3f2.m11 = 1.0f;
        matrix3f2.m12 = 0.0f;
        matrix3f2.m20 = 0.0f;
        matrix3f2.m21 = 0.0f;
        matrix3f2.m22 = 1.0f;
        return matrix3f2;
    }

    public static Matrix3f setZero(Matrix3f matrix3f) {
        Matrix3f matrix3f2 = matrix3f;
        matrix3f2.m00 = 0.0f;
        matrix3f2.m01 = 0.0f;
        matrix3f2.m02 = 0.0f;
        matrix3f2.m10 = 0.0f;
        matrix3f2.m11 = 0.0f;
        matrix3f2.m12 = 0.0f;
        matrix3f2.m20 = 0.0f;
        matrix3f2.m21 = 0.0f;
        matrix3f2.m22 = 0.0f;
        return matrix3f2;
    }

    public static Matrix3f sub(Matrix3f matrix3f, Matrix3f matrix3f2, Matrix3f matrix3f3) {
        Matrix3f matrix3f4;
        Matrix3f matrix3f5 = matrix3f;
        Matrix3f matrix3f6 = matrix3f2;
        Matrix3f matrix3f7 = matrix3f3;
        if (matrix3f7 == null) {
            Matrix3f matrix3f8 = matrix3f4;
            Matrix3f matrix3f9 = new Matrix3f();
            matrix3f7 = matrix3f8;
        }
        matrix3f7.m00 = matrix3f5.m00 - matrix3f6.m00;
        matrix3f7.m01 = matrix3f5.m01 - matrix3f6.m01;
        matrix3f7.m02 = matrix3f5.m02 - matrix3f6.m02;
        matrix3f7.m10 = matrix3f5.m10 - matrix3f6.m10;
        matrix3f7.m11 = matrix3f5.m11 - matrix3f6.m11;
        matrix3f7.m12 = matrix3f5.m12 - matrix3f6.m12;
        matrix3f7.m20 = matrix3f5.m20 - matrix3f6.m20;
        matrix3f7.m21 = matrix3f5.m21 - matrix3f6.m21;
        matrix3f7.m22 = matrix3f5.m22 - matrix3f6.m22;
        return matrix3f7;
    }

    public static Vector3f transform(Matrix3f matrix3f, Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3;
        Matrix3f matrix3f2 = matrix3f;
        Vector3f vector3f4 = vector3f;
        Vector3f vector3f5 = vector3f2;
        if (vector3f5 == null) {
            Vector3f vector3f6 = vector3f3;
            Vector3f vector3f7 = new Vector3f();
            vector3f5 = vector3f6;
        }
        float f = (matrix3f2.m01 * vector3f4.f261x) + (matrix3f2.m11 * vector3f4.f262y) + (matrix3f2.m21 * vector3f4.f263z);
        float f2 = (matrix3f2.m02 * vector3f4.f261x) + (matrix3f2.m12 * vector3f4.f262y) + (matrix3f2.m22 * vector3f4.f263z);
        vector3f5.f261x = (matrix3f2.m00 * vector3f4.f261x) + (matrix3f2.m10 * vector3f4.f262y) + (matrix3f2.m20 * vector3f4.f263z);
        vector3f5.f262y = f;
        vector3f5.f263z = f2;
        return vector3f5;
    }

    public static Matrix3f transpose(Matrix3f matrix3f, Matrix3f matrix3f2) {
        Matrix3f matrix3f3;
        Matrix3f matrix3f4 = matrix3f;
        Matrix3f matrix3f5 = matrix3f2;
        if (matrix3f5 == null) {
            Matrix3f matrix3f6 = matrix3f3;
            Matrix3f matrix3f7 = new Matrix3f();
            matrix3f5 = matrix3f6;
        }
        float f = matrix3f4.m00;
        float f2 = matrix3f4.m10;
        float f3 = matrix3f4.m20;
        float f4 = matrix3f4.m01;
        float f5 = matrix3f4.m11;
        float f6 = matrix3f4.m21;
        float f7 = matrix3f4.m02;
        float f8 = matrix3f4.m12;
        float f9 = matrix3f4.m22;
        matrix3f5.m00 = f;
        matrix3f5.m01 = f2;
        matrix3f5.m02 = f3;
        matrix3f5.m10 = f4;
        matrix3f5.m11 = f5;
        matrix3f5.m12 = f6;
        matrix3f5.m20 = f7;
        matrix3f5.m21 = f8;
        matrix3f5.m22 = f9;
        return matrix3f5;
    }

    public float determinant() {
        return (this.m00 * ((this.m11 * this.m22) - (this.m12 * this.m21))) + (this.m01 * ((this.m12 * this.m20) - (this.m10 * this.m22))) + (this.m02 * ((this.m10 * this.m21) - (this.m11 * this.m20)));
    }

    public Matrix invert() {
        return invert(this, this);
    }

    public Matrix3f load(Matrix3f matrix3f) {
        return load(matrix3f, this);
    }

    public Matrix load(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.m00 = floatBuffer2.get();
        this.m01 = floatBuffer2.get();
        this.m02 = floatBuffer2.get();
        this.m10 = floatBuffer2.get();
        this.m11 = floatBuffer2.get();
        this.m12 = floatBuffer2.get();
        this.m20 = floatBuffer2.get();
        this.m21 = floatBuffer2.get();
        this.m22 = floatBuffer2.get();
        return this;
    }

    public Matrix loadTranspose(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.m00 = floatBuffer2.get();
        this.m10 = floatBuffer2.get();
        this.m20 = floatBuffer2.get();
        this.m01 = floatBuffer2.get();
        this.m11 = floatBuffer2.get();
        this.m21 = floatBuffer2.get();
        this.m02 = floatBuffer2.get();
        this.m12 = floatBuffer2.get();
        this.m22 = floatBuffer2.get();
        return this;
    }

    public Matrix3f negate(Matrix3f matrix3f) {
        return negate(this, matrix3f);
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
        FloatBuffer put3 = floatBuffer2.put(this.m02);
        FloatBuffer put4 = floatBuffer2.put(this.m10);
        FloatBuffer put5 = floatBuffer2.put(this.m11);
        FloatBuffer put6 = floatBuffer2.put(this.m12);
        FloatBuffer put7 = floatBuffer2.put(this.m20);
        FloatBuffer put8 = floatBuffer2.put(this.m21);
        FloatBuffer put9 = floatBuffer2.put(this.m22);
        return this;
    }

    public Matrix storeTranspose(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.m00);
        FloatBuffer put2 = floatBuffer2.put(this.m10);
        FloatBuffer put3 = floatBuffer2.put(this.m20);
        FloatBuffer put4 = floatBuffer2.put(this.m01);
        FloatBuffer put5 = floatBuffer2.put(this.m11);
        FloatBuffer put6 = floatBuffer2.put(this.m21);
        FloatBuffer put7 = floatBuffer2.put(this.m02);
        FloatBuffer put8 = floatBuffer2.put(this.m12);
        FloatBuffer put9 = floatBuffer2.put(this.m22);
        return this;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(this.m00).append(' ').append(this.m10).append(' ').append(this.m20).append(' ').append(10);
        StringBuilder append2 = sb4.append(this.m01).append(' ').append(this.m11).append(' ').append(this.m21).append(' ').append(10);
        StringBuilder append3 = sb4.append(this.m02).append(' ').append(this.m12).append(' ').append(this.m22).append(' ').append(10);
        return sb4.toString();
    }

    public Matrix3f transpose(Matrix3f matrix3f) {
        return transpose(this, matrix3f);
    }

    public Matrix transpose() {
        return transpose(this, this);
    }
}
