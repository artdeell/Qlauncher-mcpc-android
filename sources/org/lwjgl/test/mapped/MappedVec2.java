package org.lwjgl.test.mapped;

import org.lwjgl.util.mapped.MappedObject;

public class MappedVec2 extends MappedObject {

    /* renamed from: x */
    public float f212x;

    /* renamed from: y */
    public float f213y;

    public MappedVec2() {
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("MappedVec2[").append(this.f212x).append(",").append(this.f213y).append("]").toString();
    }
}
