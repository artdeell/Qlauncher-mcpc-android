package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller.PortType;
import net.java.games.input.Controller.Type;

public class LinuxCombinedController extends AbstractController {
    private LinuxAbstractController eventController;
    private LinuxJoystickAbstractController joystickController;

    LinuxCombinedController(LinuxAbstractController linuxAbstractController, LinuxJoystickAbstractController linuxJoystickAbstractController) {
        LinuxAbstractController linuxAbstractController2 = linuxAbstractController;
        LinuxJoystickAbstractController linuxJoystickAbstractController2 = linuxJoystickAbstractController;
        super(linuxAbstractController2.getName(), linuxJoystickAbstractController2.getComponents(), linuxAbstractController2.getControllers(), linuxAbstractController2.getRumblers());
        this.eventController = linuxAbstractController2;
        this.joystickController = linuxJoystickAbstractController2;
    }

    /* access modifiers changed from: protected */
    public boolean getNextDeviceEvent(Event event) throws IOException {
        return this.joystickController.getNextDeviceEvent(event);
    }

    public final PortType getPortType() {
        return this.eventController.getPortType();
    }

    public Type getType() {
        return this.eventController.getType();
    }

    public final void pollDevice() throws IOException {
        this.eventController.pollDevice();
        this.joystickController.pollDevice();
    }
}
