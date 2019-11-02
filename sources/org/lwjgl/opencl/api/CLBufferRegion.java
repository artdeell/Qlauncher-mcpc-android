package org.lwjgl.opencl.api;

import org.lwjgl.PointerBuffer;

public final class CLBufferRegion {
    public static final int STRUCT_SIZE = (2 * PointerBuffer.getPointerSize());
    private final int origin;
    private final int size;

    public CLBufferRegion(int i, int i2) {
        int i3 = i2;
        this.origin = i;
        this.size = i3;
    }

    public int getOrigin() {
        return this.origin;
    }

    public int getSize() {
        return this.size;
    }
}
