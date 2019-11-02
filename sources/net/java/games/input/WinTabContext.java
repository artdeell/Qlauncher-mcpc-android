package net.java.games.input;

import java.util.ArrayList;

public class WinTabContext {
    private Controller[] controllers;
    private long hCTX;
    private DummyWindow window;

    public WinTabContext(DummyWindow dummyWindow) {
        this.window = dummyWindow;
    }

    private static final native void nClose(long j);

    private static final native int nGetNumberOfSupportedDevices();

    private static final native WinTabPacket[] nGetPackets(long j);

    private static final native long nOpen(long j);

    public void close() {
        synchronized (this) {
            try {
                nClose(this.hCTX);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public Controller[] getControllers() {
        IllegalStateException illegalStateException;
        if (this.hCTX != 0) {
            return this.controllers;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Context must be open before getting the controllers");
        throw illegalStateException2;
    }

    public void open() {
        ArrayList arrayList;
        synchronized (this) {
            try {
                this.hCTX = nOpen(this.window.getHwnd());
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = arrayList2;
                this = nGetNumberOfSupportedDevices();
                for (int i = 0; th < this; i = th + 1) {
                    WinTabDevice createDevice = WinTabDevice.createDevice(this, th);
                    if (createDevice != null) {
                        boolean add = arrayList4.add(createDevice);
                    }
                }
                this.controllers = (Controller[]) arrayList4.toArray(new Controller[0]);
            } finally {
                int i2 = th;
                Throwable th = i2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void processEvents() {
        synchronized (this) {
            try {
                WinTabPacket[] nGetPackets = nGetPackets(this.hCTX);
                for (int i = 0; i < nGetPackets.length; i++) {
                    ((WinTabDevice) getControllers()[0]).processPacket(nGetPackets[i]);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
