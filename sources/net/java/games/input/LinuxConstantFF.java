package net.java.games.input;

import java.io.IOException;

final class LinuxConstantFF extends LinuxForceFeedbackEffect {
    public LinuxConstantFF(LinuxEventDevice linuxEventDevice) throws IOException {
        super(linuxEventDevice);
    }

    /* access modifiers changed from: protected */
    public final int upload(int i, float f) throws IOException {
        return getDevice().uploadConstantEffect(i, 0, 0, 0, 0, 0, Math.round(32767.0f * f), 0, 0, 0, 0);
    }
}
