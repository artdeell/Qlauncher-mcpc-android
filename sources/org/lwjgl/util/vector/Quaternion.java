package org.lwjgl.util.vector;

import java.nio.FloatBuffer;

public class Quaternion extends Vector implements ReadableVector4f {
    private static final long serialVersionUID = 1;

    /* renamed from: w */
    public float f255w;

    /* renamed from: x */
    public float f256x;

    /* renamed from: y */
    public float f257y;

    /* renamed from: z */
    public float f258z;

    public Quaternion() {
        Quaternion identity = setIdentity();
    }

    public Quaternion(float f, float f2, float f3, float f4) {
        set(f, f2, f3, f4);
    }

    public Quaternion(ReadableVector4f readableVector4f) {
        Quaternion quaternion = set(readableVector4f);
    }

    public static float dot(Quaternion quaternion, Quaternion quaternion2) {
        Quaternion quaternion3 = quaternion;
        Quaternion quaternion4 = quaternion2;
        return (quaternion3.f256x * quaternion4.f256x) + (quaternion3.f257y * quaternion4.f257y) + (quaternion3.f258z * quaternion4.f258z) + (quaternion3.f255w * quaternion4.f255w);
    }

    public static Quaternion mul(Quaternion quaternion, Quaternion quaternion2, Quaternion quaternion3) {
        Quaternion quaternion4;
        Quaternion quaternion5 = quaternion;
        Quaternion quaternion6 = quaternion2;
        Quaternion quaternion7 = quaternion3;
        if (quaternion7 == null) {
            Quaternion quaternion8 = quaternion4;
            Quaternion quaternion9 = new Quaternion();
            quaternion7 = quaternion8;
        }
        quaternion7.set((((quaternion5.f256x * quaternion6.f255w) + (quaternion5.f255w * quaternion6.f256x)) + (quaternion5.f257y * quaternion6.f258z)) - (quaternion5.f258z * quaternion6.f257y), (((quaternion5.f257y * quaternion6.f255w) + (quaternion5.f255w * quaternion6.f257y)) + (quaternion5.f258z * quaternion6.f256x)) - (quaternion5.f256x * quaternion6.f258z), (((quaternion5.f258z * quaternion6.f255w) + (quaternion5.f255w * quaternion6.f258z)) + (quaternion5.f256x * quaternion6.f257y)) - (quaternion5.f257y * quaternion6.f256x), (((quaternion5.f255w * quaternion6.f255w) - (quaternion5.f256x * quaternion6.f256x)) - (quaternion5.f257y * quaternion6.f257y)) - (quaternion5.f258z * quaternion6.f258z));
        return quaternion7;
    }

    public static Quaternion mulInverse(Quaternion quaternion, Quaternion quaternion2, Quaternion quaternion3) {
        Quaternion quaternion4;
        Quaternion quaternion5 = quaternion;
        Quaternion quaternion6 = quaternion2;
        Quaternion quaternion7 = quaternion3;
        float lengthSquared = quaternion6.lengthSquared();
        if (((double) lengthSquared) != 0.0d) {
            lengthSquared = 1.0f / lengthSquared;
        }
        if (quaternion7 == null) {
            Quaternion quaternion8 = quaternion4;
            Quaternion quaternion9 = new Quaternion();
            quaternion7 = quaternion8;
        }
        quaternion7.set(lengthSquared * ((((quaternion5.f256x * quaternion6.f255w) - (quaternion5.f255w * quaternion6.f256x)) - (quaternion5.f257y * quaternion6.f258z)) + (quaternion5.f258z * quaternion6.f257y)), lengthSquared * ((((quaternion5.f257y * quaternion6.f255w) - (quaternion5.f255w * quaternion6.f257y)) - (quaternion5.f258z * quaternion6.f256x)) + (quaternion5.f256x * quaternion6.f258z)), lengthSquared * ((((quaternion5.f258z * quaternion6.f255w) - (quaternion5.f255w * quaternion6.f258z)) - (quaternion5.f256x * quaternion6.f257y)) + (quaternion5.f257y * quaternion6.f256x)), lengthSquared * ((quaternion5.f255w * quaternion6.f255w) + (quaternion5.f256x * quaternion6.f256x) + (quaternion5.f257y * quaternion6.f257y) + (quaternion5.f258z * quaternion6.f258z)));
        return quaternion7;
    }

    public static Quaternion negate(Quaternion quaternion, Quaternion quaternion2) {
        Quaternion quaternion3;
        Quaternion quaternion4 = quaternion;
        Quaternion quaternion5 = quaternion2;
        if (quaternion5 == null) {
            Quaternion quaternion6 = quaternion3;
            Quaternion quaternion7 = new Quaternion();
            quaternion5 = quaternion6;
        }
        quaternion5.f256x = -quaternion4.f256x;
        quaternion5.f257y = -quaternion4.f257y;
        quaternion5.f258z = -quaternion4.f258z;
        quaternion5.f255w = quaternion4.f255w;
        return quaternion5;
    }

    public static Quaternion normalise(Quaternion quaternion, Quaternion quaternion2) {
        Quaternion quaternion3;
        Quaternion quaternion4 = quaternion;
        Quaternion quaternion5 = quaternion2;
        float length = 1.0f / quaternion4.length();
        if (quaternion5 == null) {
            Quaternion quaternion6 = quaternion3;
            Quaternion quaternion7 = new Quaternion();
            quaternion5 = quaternion6;
        }
        quaternion5.set(length * quaternion4.f256x, length * quaternion4.f257y, length * quaternion4.f258z, length * quaternion4.f255w);
        return quaternion5;
    }

    public static Quaternion scale(float f, Quaternion quaternion, Quaternion quaternion2) {
        Quaternion quaternion3;
        float f2 = f;
        Quaternion quaternion4 = quaternion;
        Quaternion quaternion5 = quaternion2;
        if (quaternion5 == null) {
            Quaternion quaternion6 = quaternion3;
            Quaternion quaternion7 = new Quaternion();
            quaternion5 = quaternion6;
        }
        quaternion5.f256x = f2 * quaternion4.f256x;
        quaternion5.f257y = f2 * quaternion4.f257y;
        quaternion5.f258z = f2 * quaternion4.f258z;
        quaternion5.f255w = f2 * quaternion4.f255w;
        return quaternion5;
    }

    private Quaternion setFromMat(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f;
        float f11 = f2;
        float f12 = f3;
        float f13 = f4;
        float f14 = f5;
        float f15 = f6;
        float f16 = f7;
        float f17 = f8;
        float f18 = f9;
        float f19 = f18 + f10 + f14;
        if (((double) f19) >= 0.0d) {
            float sqrt = (float) Math.sqrt(1.0d + ((double) f19));
            this.f255w = 0.5f * sqrt;
            float f20 = 0.5f / sqrt;
            this.f256x = f20 * (f17 - f15);
            this.f257y = f20 * (f12 - f16);
            this.f258z = f20 * (f13 - f11);
            return this;
        }
        float max = Math.max(Math.max(f10, f14), f18);
        if (max == f10) {
            float sqrt2 = (float) Math.sqrt(1.0d + ((double) (f10 - (f14 + f18))));
            this.f256x = 0.5f * sqrt2;
            float f21 = 0.5f / sqrt2;
            this.f257y = f21 * (f11 + f13);
            this.f258z = f21 * (f16 + f12);
            this.f255w = f21 * (f17 - f15);
            return this;
        } else if (max == f14) {
            float sqrt3 = (float) Math.sqrt(1.0d + ((double) (f14 - (f18 + f10))));
            this.f257y = 0.5f * sqrt3;
            float f22 = 0.5f / sqrt3;
            this.f258z = f22 * (f15 + f17);
            this.f256x = f22 * (f11 + f13);
            this.f255w = f22 * (f12 - f16);
            return this;
        } else {
            float sqrt4 = (float) Math.sqrt(1.0d + ((double) (f18 - (f10 + f14))));
            this.f258z = 0.5f * sqrt4;
            float f23 = 0.5f / sqrt4;
            this.f256x = f23 * (f16 + f12);
            this.f257y = f23 * (f15 + f17);
            this.f255w = f23 * (f13 - f11);
            return this;
        }
    }

    public static Quaternion setFromMatrix(Matrix3f matrix3f, Quaternion quaternion) {
        Matrix3f matrix3f2 = matrix3f;
        return quaternion.setFromMat(matrix3f2.m00, matrix3f2.m01, matrix3f2.m02, matrix3f2.m10, matrix3f2.m11, matrix3f2.m12, matrix3f2.m20, matrix3f2.m21, matrix3f2.m22);
    }

    public static Quaternion setFromMatrix(Matrix4f matrix4f, Quaternion quaternion) {
        Matrix4f matrix4f2 = matrix4f;
        return quaternion.setFromMat(matrix4f2.m00, matrix4f2.m01, matrix4f2.m02, matrix4f2.m10, matrix4f2.m11, matrix4f2.m12, matrix4f2.m20, matrix4f2.m21, matrix4f2.m22);
    }

    public static Quaternion setIdentity(Quaternion quaternion) {
        Quaternion quaternion2 = quaternion;
        quaternion2.f256x = 0.0f;
        quaternion2.f257y = 0.0f;
        quaternion2.f258z = 0.0f;
        quaternion2.f255w = 1.0f;
        return quaternion2;
    }

    public float getW() {
        return this.f255w;
    }

    public final float getX() {
        return this.f256x;
    }

    public final float getY() {
        return this.f257y;
    }

    public float getZ() {
        return this.f258z;
    }

    public float lengthSquared() {
        return (this.f256x * this.f256x) + (this.f257y * this.f257y) + (this.f258z * this.f258z) + (this.f255w * this.f255w);
    }

    public Vector load(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.f256x = floatBuffer2.get();
        this.f257y = floatBuffer2.get();
        this.f258z = floatBuffer2.get();
        this.f255w = floatBuffer2.get();
        return this;
    }

    public Quaternion negate(Quaternion quaternion) {
        return negate(this, quaternion);
    }

    public Vector negate() {
        return negate(this, this);
    }

    public Quaternion normalise(Quaternion quaternion) {
        return normalise(this, quaternion);
    }

    public Vector scale(float f) {
        return scale(f, this, this);
    }

    public Quaternion set(ReadableVector4f readableVector4f) {
        ReadableVector4f readableVector4f2 = readableVector4f;
        this.f256x = readableVector4f2.getX();
        this.f257y = readableVector4f2.getY();
        this.f258z = readableVector4f2.getZ();
        this.f255w = readableVector4f2.getW();
        return this;
    }

    public void set(float f, float f2) {
        float f3 = f2;
        this.f256x = f;
        this.f257y = f3;
    }

    public void set(float f, float f2, float f3) {
        float f4 = f2;
        float f5 = f3;
        this.f256x = f;
        this.f257y = f4;
        this.f258z = f5;
    }

    public void set(float f, float f2, float f3, float f4) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        this.f256x = f;
        this.f257y = f5;
        this.f258z = f6;
        this.f255w = f7;
    }

    public final void setFromAxisAngle(Vector4f vector4f) {
        Vector4f vector4f2 = vector4f;
        this.f256x = vector4f2.f265x;
        this.f257y = vector4f2.f266y;
        this.f258z = vector4f2.f267z;
        float sin = (float) (Math.sin(0.5d * ((double) vector4f2.f264w)) / ((double) ((float) Math.sqrt((double) (((this.f256x * this.f256x) + (this.f257y * this.f257y)) + (this.f258z * this.f258z))))));
        this.f256x = sin * this.f256x;
        this.f257y = sin * this.f257y;
        this.f258z = sin * this.f258z;
        this.f255w = (float) Math.cos(0.5d * ((double) vector4f2.f264w));
    }

    public final Quaternion setFromMatrix(Matrix3f matrix3f) {
        return setFromMatrix(matrix3f, this);
    }

    public final Quaternion setFromMatrix(Matrix4f matrix4f) {
        return setFromMatrix(matrix4f, this);
    }

    public Quaternion setIdentity() {
        return setIdentity(this);
    }

    public void setW(float f) {
        float f2 = f;
        this.f255w = f2;
    }

    public final void setX(float f) {
        float f2 = f;
        this.f256x = f2;
    }

    public final void setY(float f) {
        float f2 = f;
        this.f257y = f2;
    }

    public void setZ(float f) {
        float f2 = f;
        this.f258z = f2;
    }

    public Vector store(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.f256x);
        FloatBuffer put2 = floatBuffer2.put(this.f257y);
        FloatBuffer put3 = floatBuffer2.put(this.f258z);
        FloatBuffer put4 = floatBuffer2.put(this.f255w);
        return this;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("Quaternion: ").append(this.f256x).append(" ").append(this.f257y).append(" ").append(this.f258z).append(" ").append(this.f255w).toString();
    }
}
