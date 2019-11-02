package net.java.games.input;

import java.io.IOException;

final class DummyWindow {
    private final long hwnd_address = createWindow();

    public DummyWindow() throws IOException {
    }

    private static final native long createWindow() throws IOException;

    private static final native void nDestroy(long j) throws IOException;

    public final void destroy() throws IOException {
        nDestroy(this.hwnd_address);
    }

    public final long getHwnd() {
        return this.hwnd_address;
    }
}
