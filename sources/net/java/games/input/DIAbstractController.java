package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Controller.Type;

final class DIAbstractController extends AbstractController {
    private final IDirectInputDevice device;
    private final Type type;

    protected DIAbstractController(IDirectInputDevice iDirectInputDevice, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr, Type type2) {
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        Type type3 = type2;
        super(iDirectInputDevice2.getProductName(), componentArr, controllerArr, rumblerArr);
        this.device = iDirectInputDevice2;
        this.type = type3;
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        return DIControllers.getNextDeviceEvent(event, this.device);
    }

    public final Type getType() {
        return this.type;
    }

    public final void pollDevice() throws IOException {
        this.device.pollAll();
    }

    /* access modifiers changed from: protected */
    public final void setDeviceEventQueueSize(int i) throws IOException {
        int i2 = i;
        this.device.setBufferSize(i2);
    }
}
