package org.lwjgl.test.mapped;

import org.lwjgl.util.mapped.MappedObject;

public class MappedFloat extends MappedObject {
    public float value;

    public MappedFloat() {
        test();
    }

    public void test() {
        this.value = 4.0f;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("MappedFloat[").append(this.value).append("]").toString();
    }
}
