package org.lwjgl.opengles;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

public final class ContextAttribs {
    private int version;

    public ContextAttribs() {
        this(2);
    }

    public ContextAttribs(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        if (3 < i2) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid OpenGL ES version specified: ").append(i2).toString());
            throw illegalArgumentException2;
        }
        this.version = i2;
    }

    private ContextAttribs(ContextAttribs contextAttribs) {
        this.version = contextAttribs.version;
    }

    public IntBuffer getAttribList() {
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(3);
        IntBuffer put = createIntBuffer.put(12440).put(this.version);
        IntBuffer put2 = createIntBuffer.put(12344);
        Buffer rewind = createIntBuffer.rewind();
        return createIntBuffer;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(32);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("ContextAttribs:");
        StringBuilder append2 = sb4.append(" Version=").append(this.version);
        return sb4.toString();
    }
}
