package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller.PortType;

final class LinuxKeyboard extends Keyboard {
    private final LinuxEventDevice device;
    private final PortType port;

    protected LinuxKeyboard(LinuxEventDevice linuxEventDevice, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr) throws IOException {
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        super(linuxEventDevice2.getName(), componentArr, controllerArr, rumblerArr);
        this.device = linuxEventDevice2;
        this.port = linuxEventDevice2.getPortType();
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        return LinuxControllers.getNextDeviceEvent(event, this.device);
    }

    public final PortType getPortType() {
        return this.port;
    }

    public final void pollDevice() throws IOException {
        this.device.pollKeyStates();
    }
}
