package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class IDirectInput {
    private final List devices;
    private final long idirectinput_address = createIDirectInput();
    private final DummyWindow window;

    public IDirectInput(DummyWindow dummyWindow) throws IOException {
        ArrayList arrayList;
        DummyWindow dummyWindow2 = dummyWindow;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.devices = arrayList2;
        this.window = dummyWindow2;
        try {
            enumDevices();
        } catch (IOException e) {
            IOException iOException = e;
            releaseDevices();
            release();
            throw iOException;
        }
    }

    private final void addDevice(long j, byte[] bArr, byte[] bArr2, int i, int i2, String str, String str2) throws IOException {
        StringBuffer stringBuffer;
        IDirectInputDevice iDirectInputDevice;
        String str3 = str2;
        try {
            IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
            IDirectInputDevice iDirectInputDevice3 = new IDirectInputDevice(this.window, j, bArr, bArr2, i, i2, str, str3);
            boolean add = this.devices.add(iDirectInputDevice2);
        } catch (IOException e) {
            IOException iOException = e;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            DirectInputEnvironmentPlugin.logln(stringBuffer2.append("Failed to initialize device ").append(str3).append(" because of: ").append(iOException).toString());
        }
    }

    private static final native long createIDirectInput() throws IOException;

    private final void enumDevices() throws IOException {
        nEnumDevices(this.idirectinput_address);
    }

    private final native void nEnumDevices(long j) throws IOException;

    private static final native void nRelease(long j);

    public final List getDevices() {
        return this.devices;
    }

    public final void release() {
        nRelease(this.idirectinput_address);
    }

    public final void releaseDevices() {
        for (int i = 0; i < this.devices.size(); i++) {
            ((IDirectInputDevice) this.devices.get(i)).release();
        }
    }
}
