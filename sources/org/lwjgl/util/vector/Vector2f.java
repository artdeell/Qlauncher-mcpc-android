package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vector2f extends Vector implements Serializable, ReadableVector2f, WritableVector2f {
    private static final long serialVersionUID = 1;

    /* renamed from: x */
    public float f259x;

    /* renamed from: y */
    public float f260y;

    public Vector2f() {
    }

    public Vector2f(float f, float f2) {
        set(f, f2);
    }

    public Vector2f(ReadableVector2f readableVector2f) {
        Vector2f vector2f = set(readableVector2f);
    }

    public static Vector2f add(Vector2f vector2f, Vector2f vector2f2, Vector2f vector2f3) {
        Vector2f vector2f4;
        Vector2f vector2f5 = vector2f;
        Vector2f vector2f6 = vector2f2;
        Vector2f vector2f7 = vector2f3;
        if (vector2f7 == null) {
            Vector2f vector2f8 = vector2f4;
            Vector2f vector2f9 = new Vector2f(vector2f5.f259x + vector2f6.f259x, vector2f5.f260y + vector2f6.f260y);
            return vector2f8;
        }
        vector2f7.set(vector2f5.f259x + vector2f6.f259x, vector2f5.f260y + vector2f6.f260y);
        return vector2f7;
    }

    public static float angle(Vector2f vector2f, Vector2f vector2f2) {
        Vector2f vector2f3 = vector2f;
        Vector2f vector2f4 = vector2f2;
        float dot = dot(vector2f3, vector2f4) / (vector2f3.length() * vector2f4.length());
        if (dot < -1.0f) {
            dot = -1.0f;
        } else if (dot > 1.0f) {
            dot = 1.0f;
        }
        return (float) Math.acos((double) dot);
    }

    public static float dot(Vector2f vector2f, Vector2f vector2f2) {
        Vector2f vector2f3 = vector2f;
        Vector2f vector2f4 = vector2f2;
        return (vector2f3.f259x * vector2f4.f259x) + (vector2f3.f260y * vector2f4.f260y);
    }

    public static Vector2f sub(Vector2f vector2f, Vector2f vector2f2, Vector2f vector2f3) {
        Vector2f vector2f4;
        Vector2f vector2f5 = vector2f;
        Vector2f vector2f6 = vector2f2;
        Vector2f vector2f7 = vector2f3;
        if (vector2f7 == null) {
            Vector2f vector2f8 = vector2f4;
            Vector2f vector2f9 = new Vector2f(vector2f5.f259x - vector2f6.f259x, vector2f5.f260y - vector2f6.f260y);
            return vector2f8;
        }
        vector2f7.set(vector2f5.f259x - vector2f6.f259x, vector2f5.f260y - vector2f6.f260y);
        return vector2f7;
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
            Vector2f vector2f = (Vector2f) obj2;
            if (!(this.f259x == vector2f.f259x && this.f260y == vector2f.f260y)) {
                return false;
            }
        }
        return true;
    }

    public final float getX() {
        return this.f259x;
    }

    public final float getY() {
        return this.f260y;
    }

    public float lengthSquared() {
        return (this.f259x * this.f259x) + (this.f260y * this.f260y);
    }

    public Vector load(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.f259x = floatBuffer2.get();
        this.f260y = floatBuffer2.get();
        return this;
    }

    public Vector2f negate(Vector2f vector2f) {
        Vector2f vector2f2;
        Vector2f vector2f3 = vector2f;
        if (vector2f3 == null) {
            Vector2f vector2f4 = vector2f2;
            Vector2f vector2f5 = new Vector2f();
            vector2f3 = vector2f4;
        }
        vector2f3.f259x = -this.f259x;
        vector2f3.f260y = -this.f260y;
        return vector2f3;
    }

    public Vector negate() {
        this.f259x = -this.f259x;
        this.f260y = -this.f260y;
        return this;
    }

    public Vector2f normalise(Vector2f vector2f) {
        Vector2f vector2f2;
        Vector2f vector2f3 = vector2f;
        float length = length();
        if (vector2f3 == null) {
            Vector2f vector2f4 = vector2f2;
            Vector2f vector2f5 = new Vector2f(this.f259x / length, this.f260y / length);
            return vector2f4;
        }
        vector2f3.set(this.f259x / length, this.f260y / length);
        return vector2f3;
    }

    public Vector scale(float f) {
        float f2 = f;
        this.f259x = f2 * this.f259x;
        this.f260y = f2 * this.f260y;
        return this;
    }

    public Vector2f set(ReadableVector2f readableVector2f) {
        ReadableVector2f readableVector2f2 = readableVector2f;
        this.f259x = readableVector2f2.getX();
        this.f260y = readableVector2f2.getY();
        return this;
    }

    public void set(float f, float f2) {
        float f3 = f2;
        this.f259x = f;
        this.f260y = f3;
    }

    public final void setX(float f) {
        float f2 = f;
        this.f259x = f2;
    }

    public final void setY(float f) {
        float f2 = f;
        this.f260y = f2;
    }

    public Vector store(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.f259x);
        FloatBuffer put2 = floatBuffer2.put(this.f260y);
        return this;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(64);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("Vector2f[");
        StringBuilder append2 = sb4.append(this.f259x);
        StringBuilder append3 = sb4.append(", ");
        StringBuilder append4 = sb4.append(this.f260y);
        StringBuilder append5 = sb4.append(']');
        return sb4.toString();
    }

    public Vector2f translate(float f, float f2) {
        float f3 = f2;
        this.f259x = f + this.f259x;
        this.f260y = f3 + this.f260y;
        return this;
    }
}
