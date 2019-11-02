package org.lwjgl.test.mapped;

import java.nio.ByteBuffer;
import org.lwjgl.util.mapped.MappedField;
import org.lwjgl.util.mapped.MappedObject;

public class MappedSomething extends MappedObject {
    @MappedField(byteLength = 60)
    public ByteBuffer data;
    @MappedField(byteOffset = 12)
    public int shared;
    @MappedField(byteOffset = 0)
    public int used;

    public MappedSomething() {
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("MappedSomething[").append(this.used).append("]").toString();
    }
}
