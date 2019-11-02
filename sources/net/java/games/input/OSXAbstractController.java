package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller.PortType;
import net.java.games.input.Controller.Type;

final class OSXAbstractController extends AbstractController {
    private final PortType port;
    private final OSXHIDQueue queue;
    private final Type type;

    protected OSXAbstractController(OSXHIDDevice oSXHIDDevice, OSXHIDQueue oSXHIDQueue, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr, Type type2) {
        OSXHIDDevice oSXHIDDevice2 = oSXHIDDevice;
        OSXHIDQueue oSXHIDQueue2 = oSXHIDQueue;
        Type type3 = type2;
        super(oSXHIDDevice2.getProductName(), componentArr, controllerArr, rumblerArr);
        this.queue = oSXHIDQueue2;
        this.type = type3;
        this.port = oSXHIDDevice2.getPortType();
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        return OSXControllers.getNextDeviceEvent(event, this.queue);
    }

    public final PortType getPortType() {
        return this.port;
    }

    public Type getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public final void setDeviceEventQueueSize(int i) throws IOException {
        int i2 = i;
        this.queue.setQueueDepth(i2);
    }
}
