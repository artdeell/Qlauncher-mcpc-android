package net.java.games.input;

import java.io.IOException;

class RawKeyboardInfo extends RawDeviceInfo {
    private final RawDevice device;
    private final int keyboard_mode;
    private final int num_function_keys;
    private final int num_indicators;
    private final int num_keys_total;
    private final int sub_type;
    private final int type;

    public RawKeyboardInfo(RawDevice rawDevice, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        this.device = rawDevice;
        this.type = i7;
        this.sub_type = i8;
        this.keyboard_mode = i9;
        this.num_function_keys = i10;
        this.num_indicators = i11;
        this.num_keys_total = i12;
    }

    public final Controller createControllerFromDevice(RawDevice rawDevice, SetupAPIDevice setupAPIDevice) throws IOException {
        RawKeyboard rawKeyboard;
        RawKeyboard rawKeyboard2 = rawKeyboard;
        RawKeyboard rawKeyboard3 = new RawKeyboard(setupAPIDevice.getName(), rawDevice, new Controller[0], new Rumbler[0]);
        return rawKeyboard2;
    }

    public final long getHandle() {
        return this.device.getHandle();
    }

    public final int getUsage() {
        return 6;
    }

    public final int getUsagePage() {
        return 1;
    }
}
