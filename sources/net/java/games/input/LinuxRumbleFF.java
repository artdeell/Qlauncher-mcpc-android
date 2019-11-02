package net.java.games.input;

import java.io.IOException;

final class LinuxRumbleFF extends LinuxForceFeedbackEffect {
    public LinuxRumbleFF(LinuxEventDevice linuxEventDevice) throws IOException {
        super(linuxEventDevice);
    }

    /* access modifiers changed from: protected */
    public final int upload(int i, float f) throws IOException {
        int i2;
        int i3;
        int i4 = i;
        float f2 = f;
        if (f2 > 0.666666f) {
            i3 = (int) (32768.0f * f2);
            i2 = (int) (49152.0f * f2);
        } else if (f2 > 0.3333333f) {
            i3 = (int) (32768.0f * f2);
            i2 = 0;
        } else {
            i2 = (int) (49152.0f * f2);
            i3 = 0;
        }
        return getDevice().uploadRumbleEffect(i4, 0, 0, 0, -1, 0, i3, i2);
    }
}
