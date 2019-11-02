package org.lwjgl.opencl.api;

public final class CLImageFormat {
    public static final int STRUCT_SIZE = 8;
    private final int channelOrder;
    private final int channelType;

    public CLImageFormat(int i, int i2) {
        int i3 = i2;
        this.channelOrder = i;
        this.channelType = i3;
    }

    public int getChannelOrder() {
        return this.channelOrder;
    }

    public int getChannelType() {
        return this.channelType;
    }
}
