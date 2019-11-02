package net.java.games.input;

import java.io.IOException;

final class DIKeyboard extends Keyboard {
    private final IDirectInputDevice device;

    protected DIKeyboard(IDirectInputDevice iDirectInputDevice, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr) {
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        super(iDirectInputDevice2.getProductName(), componentArr, controllerArr, rumblerArr);
        this.device = iDirectInputDevice2;
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        return DIControllers.getNextDeviceEvent(event, this.device);
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
