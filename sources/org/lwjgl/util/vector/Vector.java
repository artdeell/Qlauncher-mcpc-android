package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public abstract class Vector implements Serializable, ReadableVector {
    protected Vector() {
    }

    public final float length() {
        return (float) Math.sqrt((double) lengthSquared());
    }

    public abstract float lengthSquared();

    public abstract Vector load(FloatBuffer floatBuffer);

    public abstract Vector negate();

    public final Vector normalise() {
        IllegalStateException illegalStateException;
        float length = length();
        if (length != 0.0f) {
            return scale(1.0f / length);
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Zero length vector");
        throw illegalStateException2;
    }

    public abstract Vector scale(float f);

    public abstract Vector store(FloatBuffer floatBuffer);
}
