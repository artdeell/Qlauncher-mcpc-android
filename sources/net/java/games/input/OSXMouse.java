package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller.PortType;

final class OSXMouse extends Mouse {
    private final PortType port;
    private final OSXHIDQueue queue;

    protected OSXMouse(OSXHIDDevice oSXHIDDevice, OSXHIDQueue oSXHIDQueue, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr) {
        OSXHIDDevice oSXHIDDevice2 = oSXHIDDevice;
        OSXHIDQueue oSXHIDQueue2 = oSXHIDQueue;
        super(oSXHIDDevice2.getProductName(), componentArr, controllerArr, rumblerArr);
        this.queue = oSXHIDQueue2;
        this.port = oSXHIDDevice2.getPortType();
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        return OSXControllers.getNextDeviceEvent(event, this.queue);
    }

    public final PortType getPortType() {
        return this.port;
    }

    /* access modifiers changed from: protected */
    public final void setDeviceEventQueueSize(int i) throws IOException {
        int i2 = i;
        this.queue.setQueueDepth(i2);
    }
}
