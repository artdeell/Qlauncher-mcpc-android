package org.lwjgl.test.mapped;

import org.lwjgl.util.mapped.MappedObject;

public class MappedVec3 extends MappedObject {

    /* renamed from: x */
    public float f214x;

    /* renamed from: y */
    public float f215y;

    /* renamed from: z */
    public float f216z;

    public MappedVec3() {
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("[").append(this.f214x).append(",").append(this.f215y).append(",").append(this.f216z).append("]").toString();
    }
}
