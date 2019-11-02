package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vector4f extends Vector implements Serializable, ReadableVector4f, WritableVector4f {
    private static final long serialVersionUID = 1;

    /* renamed from: w */
    public float f264w;

    /* renamed from: x */
    public float f265x;

    /* renamed from: y */
    public float f266y;

    /* renamed from: z */
    public float f267z;

    public Vector4f() {
    }

    public Vector4f(float f, float f2, float f3, float f4) {
        set(f, f2, f3, f4);
    }

    public Vector4f(ReadableVector4f readableVector4f) {
        Vector4f vector4f = set(readableVector4f);
    }

    public static Vector4f add(Vector4f vector4f, Vector4f vector4f2, Vector4f vector4f3) {
        Vector4f vector4f4;
        Vector4f vector4f5 = vector4f;
        Vector4f vector4f6 = vector4f2;
        Vector4f vector4f7 = vector4f3;
        if (vector4f7 == null) {
            Vector4f vector4f8 = vector4f4;
            Vector4f vector4f9 = new Vector4f(vector4f5.f265x + vector4f6.f265x, vector4f5.f266y + vector4f6.f266y, vector4f5.f267z + vector4f6.f267z, vector4f5.f264w + vector4f6.f264w);
            return vector4f8;
        }
        vector4f7.set(vector4f5.f265x + vector4f6.f265x, vector4f5.f266y + vector4f6.f266y, vector4f5.f267z + vector4f6.f267z, vector4f5.f264w + vector4f6.f264w);
        return vector4f7;
    }

    public static float angle(Vector4f vector4f, Vector4f vector4f2) {
        Vector4f vector4f3 = vector4f;
        Vector4f vector4f4 = vector4f2;
        float dot = dot(vector4f3, vector4f4) / (vector4f3.length() * vector4f4.length());
        if (dot < -1.0f) {
            dot = -1.0f;
        } else if (dot > 1.0f) {
            dot = 1.0f;
        }
        return (float) Math.acos((double) dot);
    }

    public static float dot(Vector4f vector4f, Vector4f vector4f2) {
        Vector4f vector4f3 = vector4f;
        Vector4f vector4f4 = vector4f2;
        return (vector4f3.f265x * vector4f4.f265x) + (vector4f3.f266y * vector4f4.f266y) + (vector4f3.f267z * vector4f4.f267z) + (vector4f3.f264w * vector4f4.f264w);
    }

    public static Vector4f sub(Vector4f vector4f, Vector4f vector4f2, Vector4f vector4f3) {
        Vector4f vector4f4;
        Vector4f vector4f5 = vector4f;
        Vector4f vector4f6 = vector4f2;
        Vector4f vector4f7 = vector4f3;
        if (vector4f7 == null) {
            Vector4f vector4f8 = vector4f4;
            Vector4f vector4f9 = new Vector4f(vector4f5.f265x - vector4f6.f265x, vector4f5.f266y - vector4f6.f266y, vector4f5.f267z - vector4f6.f267z, vector4f5.f264w - vector4f6.f264w);
            return vector4f8;
        }
        vector4f7.set(vector4f5.f265x - vector4f6.f265x, vector4f5.f266y - vector4f6.f266y, vector4f5.f267z - vector4f6.f267z, vector4f5.f264w - vector4f6.f264w);
        return vector4f7;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (obj2 == null) {
                return false;
            }
            if (getClass() != obj2.getClass()) {
                return false;
            }
            Vector4f vector4f = (Vector4f) obj2;
            if (!(this.f265x == vector4f.f265x && this.f266y == vector4f.f266y && this.f267z == vector4f.f267z && this.f264w == vector4f.f264w)) {
                return false;
            }
        }
        return true;
    }

    public float getW() {
        return this.f264w;
    }

    public final float getX() {
        return this.f265x;
    }

    public final float getY() {
        return this.f266y;
    }

    public float getZ() {
        return this.f267z;
    }

    public float lengthSquared() {
        return (this.f265x * this.f265x) + (this.f266y * this.f266y) + (this.f267z * this.f267z) + (this.f264w * this.f264w);
    }

    public Vector load(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.f265x = floatBuffer2.get();
        this.f266y = floatBuffer2.get();
        this.f267z = floatBuffer2.get();
        this.f264w = floatBuffer2.get();
        return this;
    }

    public Vector4f negate(Vector4f vector4f) {
        Vector4f vector4f2;
        Vector4f vector4f3 = vector4f;
        if (vector4f3 == null) {
            Vector4f vector4f4 = vector4f2;
            Vector4f vector4f5 = new Vector4f();
            vector4f3 = vector4f4;
        }
        vector4f3.f265x = -this.f265x;
        vector4f3.f266y = -this.f266y;
        vector4f3.f267z = -this.f267z;
        vector4f3.f264w = -this.f264w;
        return vector4f3;
    }

    public Vector negate() {
        this.f265x = -this.f265x;
        this.f266y = -this.f266y;
        this.f267z = -this.f267z;
        this.f264w = -this.f264w;
        return this;
    }

    public Vector4f normalise(Vector4f vector4f) {
        Vector4f vector4f2;
        Vector4f vector4f3 = vector4f;
        float length = length();
        if (vector4f3 == null) {
            Vector4f vector4f4 = vector4f2;
            Vector4f vector4f5 = new Vector4f(this.f265x / length, this.f266y / length, this.f267z / length, this.f264w / length);
            return vector4f4;
        }
        vector4f3.set(this.f265x / length, this.f266y / length, this.f267z / length, this.f264w / length);
        return vector4f3;
    }

    public Vector scale(float f) {
        float f2 = f;
        this.f265x = f2 * this.f265x;
        this.f266y = f2 * this.f266y;
        this.f267z = f2 * this.f267z;
        this.f264w = f2 * this.f264w;
        return this;
    }

    public Vector4f set(ReadableVector4f readableVector4f) {
        ReadableVector4f readableVector4f2 = readableVector4f;
        this.f265x = readableVector4f2.getX();
        this.f266y = readableVector4f2.getY();
        this.f267z = readableVector4f2.getZ();
        this.f264w = readableVector4f2.getW();
        return this;
    }

    public void set(float f, float f2) {
        float f3 = f2;
        this.f265x = f;
        this.f266y = f3;
    }

    public void set(float f, float f2, float f3) {
        float f4 = f2;
        float f5 = f3;
        this.f265x = f;
        this.f266y = f4;
        this.f267z = f5;
    }

    public void set(float f, float f2, float f3, float f4) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        this.f265x = f;
        this.f266y = f5;
        this.f267z = f6;
        this.f264w = f7;
    }

    public void setW(float f) {
        float f2 = f;
        this.f264w = f2;
    }

    public final void setX(float f) {
        float f2 = f;
        this.f265x = f2;
    }

    public final void setY(float f) {
        float f2 = f;
        this.f266y = f2;
    }

    public void setZ(float f) {
        float f2 = f;
        this.f267z = f2;
    }

    public Vector store(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.f265x);
        FloatBuffer put2 = floatBuffer2.put(this.f266y);
        FloatBuffer put3 = floatBuffer2.put(this.f267z);
        FloatBuffer put4 = floatBuffer2.put(this.f264w);
        return this;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("Vector4f: ").append(this.f265x).append(" ").append(this.f266y).append(" ").append(this.f267z).append(" ").append(this.f264w).toString();
    }

    public Vector4f translate(float f, float f2, float f3, float f4) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        this.f265x = f + this.f265x;
        this.f266y = f5 + this.f266y;
        this.f267z = f6 + this.f267z;
        this.f264w = f7 + this.f264w;
        return this;
    }
}
