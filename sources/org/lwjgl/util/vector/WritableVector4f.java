package org.lwjgl.util.vector;

public interface WritableVector4f extends WritableVector3f {
    void set(float f, float f2, float f3, float f4);

    void setW(float f);
}
