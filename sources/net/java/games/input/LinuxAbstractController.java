package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller.PortType;
import net.java.games.input.Controller.Type;

final class LinuxAbstractController extends AbstractController {
    private final LinuxEventDevice device;
    private final PortType port;
    private final Type type;

    protected LinuxAbstractController(LinuxEventDevice linuxEventDevice, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr, Type type2) throws IOException {
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        Type type3 = type2;
        super(linuxEventDevice2.getName(), componentArr, controllerArr, rumblerArr);
        this.device = linuxEventDevice2;
        this.port = linuxEventDevice2.getPortType();
        this.type = type3;
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        return LinuxControllers.getNextDeviceEvent(event, this.device);
    }

    public final PortType getPortType() {
        return this.port;
    }

    public Type getType() {
        return this.type;
    }

    public final void pollDevice() throws IOException {
        this.device.pollKeyStates();
    }
}
