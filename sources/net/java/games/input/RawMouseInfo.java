package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier.Axis;

class RawMouseInfo extends RawDeviceInfo {
    private final RawDevice device;

    /* renamed from: id */
    private final int f157id;
    private final int num_buttons;
    private final int sample_rate;

    public RawMouseInfo(RawDevice rawDevice, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.device = rawDevice;
        this.f157id = i4;
        this.num_buttons = i5;
        this.sample_rate = i6;
    }

    public final Controller createControllerFromDevice(RawDevice rawDevice, SetupAPIDevice setupAPIDevice) throws IOException {
        Axis axis;
        Axis axis2;
        Axis axis3;
        RawMouse rawMouse;
        Button button;
        RawDevice rawDevice2 = rawDevice;
        SetupAPIDevice setupAPIDevice2 = setupAPIDevice;
        if (this.num_buttons == 0) {
            return null;
        }
        Component[] componentArr = new Component[(3 + this.num_buttons)];
        int i = 0 + 1;
        Component[] componentArr2 = componentArr;
        Axis axis4 = axis;
        Axis axis5 = new Axis(rawDevice2, Axis.f31X);
        componentArr2[0] = axis4;
        int i2 = i + 1;
        Component[] componentArr3 = componentArr;
        int i3 = i;
        Axis axis6 = axis2;
        Axis axis7 = new Axis(rawDevice2, Axis.f32Y);
        componentArr3[i3] = axis6;
        int i4 = i2 + 1;
        Component[] componentArr4 = componentArr;
        int i5 = i2;
        Axis axis8 = axis3;
        Axis axis9 = new Axis(rawDevice2, Axis.f33Z);
        componentArr4[i5] = axis8;
        int i6 = 0;
        int i7 = i4;
        while (true) {
            int i8 = i7;
            if (i6 < this.num_buttons) {
                int i9 = i8 + 1;
                Component[] componentArr5 = componentArr;
                int i10 = i8;
                Button button2 = button;
                Button button3 = new Button(rawDevice2, DIIdentifierMap.mapMouseButtonIdentifier(DIIdentifierMap.getButtonIdentifier(i6)), i6);
                componentArr5[i10] = button2;
                i6++;
                i7 = i9;
            } else {
                RawMouse rawMouse2 = rawMouse;
                RawMouse rawMouse3 = new RawMouse(setupAPIDevice2.getName(), rawDevice2, componentArr, new Controller[0], new Rumbler[0]);
                return rawMouse2;
            }
        }
    }

    public final long getHandle() {
        return this.device.getHandle();
    }

    public final int getUsage() {
        return 2;
    }

    public final int getUsagePage() {
        return 1;
    }
}
