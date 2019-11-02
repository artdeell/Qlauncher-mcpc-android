package org.lwjgl.opengl;

import java.nio.ByteBuffer;

abstract class LinuxPeerInfo extends PeerInfo {
    LinuxPeerInfo() {
        super(createHandle());
    }

    private static native ByteBuffer createHandle();

    private static native long nGetDisplay(ByteBuffer byteBuffer);

    private static native long nGetDrawable(ByteBuffer byteBuffer);

    public final long getDisplay() {
        return nGetDisplay(getHandle());
    }

    public final long getDrawable() {
        return nGetDrawable(getHandle());
    }
}
