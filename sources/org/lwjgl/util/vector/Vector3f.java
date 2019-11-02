package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vector3f extends Vector implements Serializable, ReadableVector3f, WritableVector3f {
    private static final long serialVersionUID = 1;

    /* renamed from: x */
    public float f261x;

    /* renamed from: y */
    public float f262y;

    /* renamed from: z */
    public float f263z;

    public Vector3f() {
    }

    public Vector3f(float f, float f2, float f3) {
        set(f, f2, f3);
    }

    public Vector3f(ReadableVector3f readableVector3f) {
        Vector3f vector3f = set(readableVector3f);
    }

    public static Vector3f add(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        Vector3f vector3f4;
        Vector3f vector3f5 = vector3f;
        Vector3f vector3f6 = vector3f2;
        Vector3f vector3f7 = vector3f3;
        if (vector3f7 == null) {
            Vector3f vector3f8 = vector3f4;
            Vector3f vector3f9 = new Vector3f(vector3f5.f261x + vector3f6.f261x, vector3f5.f262y + vector3f6.f262y, vector3f5.f263z + vector3f6.f263z);
            return vector3f8;
        }
        vector3f7.set(vector3f5.f261x + vector3f6.f261x, vector3f5.f262y + vector3f6.f262y, vector3f5.f263z + vector3f6.f263z);
        return vector3f7;
    }

    public static float angle(Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = vector3f;
        Vector3f vector3f4 = vector3f2;
        float dot = dot(vector3f3, vector3f4) / (vector3f3.length() * vector3f4.length());
        if (dot < -1.0f) {
            dot = -1.0f;
        } else if (dot > 1.0f) {
            dot = 1.0f;
        }
        return (float) Math.acos((double) dot);
    }

    public static Vector3f cross(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        Vector3f vector3f4;
        Vector3f vector3f5 = vector3f;
        Vector3f vector3f6 = vector3f2;
        Vector3f vector3f7 = vector3f3;
        if (vector3f7 == null) {
            Vector3f vector3f8 = vector3f4;
            Vector3f vector3f9 = new Vector3f();
            vector3f7 = vector3f8;
        }
        vector3f7.set((vector3f5.f262y * vector3f6.f263z) - (vector3f5.f263z * vector3f6.f262y), (vector3f6.f261x * vector3f5.f263z) - (vector3f6.f263z * vector3f5.f261x), (vector3f5.f261x * vector3f6.f262y) - (vector3f5.f262y * vector3f6.f261x));
        return vector3f7;
    }

    public static float dot(Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = vector3f;
        Vector3f vector3f4 = vector3f2;
        return (vector3f3.f261x * vector3f4.f261x) + (vector3f3.f262y * vector3f4.f262y) + (vector3f3.f263z * vector3f4.f263z);
    }

    public static Vector3f sub(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        Vector3f vector3f4;
        Vector3f vector3f5 = vector3f;
        Vector3f vector3f6 = vector3f2;
        Vector3f vector3f7 = vector3f3;
        if (vector3f7 == null) {
            Vector3f vector3f8 = vector3f4;
            Vector3f vector3f9 = new Vector3f(vector3f5.f261x - vector3f6.f261x, vector3f5.f262y - vector3f6.f262y, vector3f5.f263z - vector3f6.f263z);
            return vector3f8;
        }
        vector3f7.set(vector3f5.f261x - vector3f6.f261x, vector3f5.f262y - vector3f6.f262y, vector3f5.f263z - vector3f6.f263z);
        return vector3f7;
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
            Vector3f vector3f = (Vector3f) obj2;
            if (!(this.f261x == vector3f.f261x && this.f262y == vector3f.f262y && this.f263z == vector3f.f263z)) {
                return false;
            }
        }
        return true;
    }

    public final float getX() {
        return this.f261x;
    }

    public final float getY() {
        return this.f262y;
    }

    public float getZ() {
        return this.f263z;
    }

    public float lengthSquared() {
        return (this.f261x * this.f261x) + (this.f262y * this.f262y) + (this.f263z * this.f263z);
    }

    public Vector load(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        this.f261x = floatBuffer2.get();
        this.f262y = floatBuffer2.get();
        this.f263z = floatBuffer2.get();
        return this;
    }

    public Vector3f negate(Vector3f vector3f) {
        Vector3f vector3f2;
        Vector3f vector3f3 = vector3f;
        if (vector3f3 == null) {
            Vector3f vector3f4 = vector3f2;
            Vector3f vector3f5 = new Vector3f();
            vector3f3 = vector3f4;
        }
        vector3f3.f261x = -this.f261x;
        vector3f3.f262y = -this.f262y;
        vector3f3.f263z = -this.f263z;
        return vector3f3;
    }

    public Vector negate() {
        this.f261x = -this.f261x;
        this.f262y = -this.f262y;
        this.f263z = -this.f263z;
        return this;
    }

    public Vector3f normalise(Vector3f vector3f) {
        Vector3f vector3f2;
        Vector3f vector3f3 = vector3f;
        float length = length();
        if (vector3f3 == null) {
            Vector3f vector3f4 = vector3f2;
            Vector3f vector3f5 = new Vector3f(this.f261x / length, this.f262y / length, this.f263z / length);
            return vector3f4;
        }
        vector3f3.set(this.f261x / length, this.f262y / length, this.f263z / length);
        return vector3f3;
    }

    public Vector scale(float f) {
        float f2 = f;
        this.f261x = f2 * this.f261x;
        this.f262y = f2 * this.f262y;
        this.f263z = f2 * this.f263z;
        return this;
    }

    public Vector3f set(ReadableVector3f readableVector3f) {
        ReadableVector3f readableVector3f2 = readableVector3f;
        this.f261x = readableVector3f2.getX();
        this.f262y = readableVector3f2.getY();
        this.f263z = readableVector3f2.getZ();
        return this;
    }

    public void set(float f, float f2) {
        float f3 = f2;
        this.f261x = f;
        this.f262y = f3;
    }

    public void set(float f, float f2, float f3) {
        float f4 = f2;
        float f5 = f3;
        this.f261x = f;
        this.f262y = f4;
        this.f263z = f5;
    }

    public final void setX(float f) {
        float f2 = f;
        this.f261x = f2;
    }

    public final void setY(float f) {
        float f2 = f;
        this.f262y = f2;
    }

    public void setZ(float f) {
        float f2 = f;
        this.f263z = f2;
    }

    public Vector store(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        FloatBuffer put = floatBuffer2.put(this.f261x);
        FloatBuffer put2 = floatBuffer2.put(this.f262y);
        FloatBuffer put3 = floatBuffer2.put(this.f263z);
        return this;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(64);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("Vector3f[");
        StringBuilder append2 = sb4.append(this.f261x);
        StringBuilder append3 = sb4.append(", ");
        StringBuilder append4 = sb4.append(this.f262y);
        StringBuilder append5 = sb4.append(", ");
        StringBuilder append6 = sb4.append(this.f263z);
        StringBuilder append7 = sb4.append(']');
        return sb4.toString();
    }

    public Vector3f translate(float f, float f2, float f3) {
        float f4 = f2;
        float f5 = f3;
        this.f261x = f + this.f261x;
        this.f262y = f4 + this.f262y;
        this.f263z = f5 + this.f263z;
        return this;
    }
}
