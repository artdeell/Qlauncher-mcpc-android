package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller.Type;

final class LinuxJoystickAbstractController extends AbstractController {
    private final LinuxJoystickDevice device;

    protected LinuxJoystickAbstractController(LinuxJoystickDevice linuxJoystickDevice, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr) {
        LinuxJoystickDevice linuxJoystickDevice2 = linuxJoystickDevice;
        super(linuxJoystickDevice2.getName(), componentArr, controllerArr, rumblerArr);
        this.device = linuxJoystickDevice2;
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        return this.device.getNextEvent(event);
    }

    public Type getType() {
        return Type.STICK;
    }

    public final void pollDevice() throws IOException {
        this.device.poll();
    }

    /* access modifiers changed from: protected */
    public final void setDeviceEventQueueSize(int i) throws IOException {
        int i2 = i;
        this.device.setBufferSize(i2);
    }
}
