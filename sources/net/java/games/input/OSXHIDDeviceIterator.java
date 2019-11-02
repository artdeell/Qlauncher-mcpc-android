package net.java.games.input;

import java.io.IOException;

final class OSXHIDDeviceIterator {
    private final long iterator_address = nCreateIterator();

    public OSXHIDDeviceIterator() throws IOException {
    }

    private static final native long nCreateIterator();

    private static final native OSXHIDDevice nNext(long j) throws IOException;

    private static final native void nReleaseIterator(long j);

    public final void close() {
        nReleaseIterator(this.iterator_address);
    }

    public final OSXHIDDevice next() throws IOException {
        return nNext(this.iterator_address);
    }
}
