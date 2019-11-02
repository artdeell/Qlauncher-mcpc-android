package net.java.games.input;

import java.io.IOException;

class RawHIDInfo extends RawDeviceInfo {
    private final RawDevice device;
    private final int page;
    private final int product_id;
    private final int usage;
    private final int vendor_id;
    private final int version;

    public RawHIDInfo(RawDevice rawDevice, int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        this.device = rawDevice;
        this.vendor_id = i6;
        this.product_id = i7;
        this.version = i8;
        this.page = i9;
        this.usage = i10;
    }

    public final Controller createControllerFromDevice(RawDevice rawDevice, SetupAPIDevice setupAPIDevice) throws IOException {
        RawDevice rawDevice2 = rawDevice;
        SetupAPIDevice setupAPIDevice2 = setupAPIDevice;
        return null;
    }

    public final long getHandle() {
        return this.device.getHandle();
    }

    public final int getUsage() {
        return this.usage;
    }

    public final int getUsagePage() {
        return this.page;
    }
}
