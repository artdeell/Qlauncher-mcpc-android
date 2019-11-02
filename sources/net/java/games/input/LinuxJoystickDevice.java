package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class LinuxJoystickDevice implements LinuxDevice {
    public static final int AXIS_MAX_VALUE = 32767;
    public static final int JS_EVENT_AXIS = 2;
    public static final int JS_EVENT_BUTTON = 1;
    public static final int JS_EVENT_INIT = 128;
    private final LinuxJoystickAxis[] axes;
    private final byte[] axisMap;
    private final char[] buttonMap;
    private final LinuxJoystickButton[] buttons;
    private boolean closed;
    private final Event event;
    private EventQueue event_queue;

    /* renamed from: fd */
    private final long f156fd;
    private final LinuxJoystickEvent joystick_event;
    private final String name;
    private final Map povXs;
    private final Map povYs;

    public LinuxJoystickDevice(String str) throws IOException {
        LinuxJoystickEvent linuxJoystickEvent;
        Event event2;
        HashMap hashMap;
        HashMap hashMap2;
        String str2 = str;
        LinuxJoystickEvent linuxJoystickEvent2 = linuxJoystickEvent;
        LinuxJoystickEvent linuxJoystickEvent3 = new LinuxJoystickEvent();
        this.joystick_event = linuxJoystickEvent2;
        Event event3 = event2;
        Event event4 = new Event();
        this.event = event3;
        HashMap hashMap3 = hashMap;
        HashMap hashMap4 = new HashMap();
        this.povXs = hashMap3;
        HashMap hashMap5 = hashMap2;
        HashMap hashMap6 = new HashMap();
        this.povYs = hashMap5;
        this.f156fd = nOpen(str2);
        try {
            this.name = getDeviceName();
            setBufferSize(32);
            this.buttons = new LinuxJoystickButton[getNumDeviceButtons()];
            this.axes = new LinuxJoystickAxis[getNumDeviceAxes()];
            this.axisMap = getDeviceAxisMap();
            this.buttonMap = getDeviceButtonMap();
        } catch (IOException e) {
            IOException iOException = e;
            close();
            throw iOException;
        }
    }

    private final void checkClosed() throws IOException {
        IOException iOException;
        if (this.closed) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException("Device is closed");
            throw iOException2;
        }
    }

    private final byte[] getDeviceAxisMap() throws IOException {
        return nGetAxisMap(this.f156fd);
    }

    private final char[] getDeviceButtonMap() throws IOException {
        return nGetButtonMap(this.f156fd);
    }

    private final String getDeviceName() throws IOException {
        return nGetName(this.f156fd);
    }

    private final boolean getNextDeviceEvent(LinuxJoystickEvent linuxJoystickEvent) throws IOException {
        return nGetNextEvent(this.f156fd, linuxJoystickEvent);
    }

    private final int getNumDeviceAxes() throws IOException {
        return nGetNumAxes(this.f156fd);
    }

    private final int getNumDeviceButtons() throws IOException {
        return nGetNumButtons(this.f156fd);
    }

    private final int getVersion() throws IOException {
        return nGetVersion(this.f156fd);
    }

    private static final native void nClose(long j) throws IOException;

    private static final native byte[] nGetAxisMap(long j) throws IOException;

    private static final native char[] nGetButtonMap(long j) throws IOException;

    private static final native String nGetName(long j) throws IOException;

    private static final native boolean nGetNextEvent(long j, LinuxJoystickEvent linuxJoystickEvent) throws IOException;

    private static final native int nGetNumAxes(long j) throws IOException;

    private static final native int nGetNumButtons(long j) throws IOException;

    private static final native int nGetVersion(long j) throws IOException;

    private static final native long nOpen(String str) throws IOException;

    private final void processEvent(LinuxJoystickEvent linuxJoystickEvent) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        LinuxJoystickEvent linuxJoystickEvent2 = linuxJoystickEvent;
        int number = linuxJoystickEvent2.getNumber();
        switch (-129 & linuxJoystickEvent2.getType()) {
            case 1:
                if (number < getNumButtons()) {
                    LinuxJoystickButton linuxJoystickButton = this.buttons[number];
                    if (linuxJoystickButton != null) {
                        float value = (float) linuxJoystickEvent2.getValue();
                        linuxJoystickButton.setValue(value);
                        this.event.set(linuxJoystickButton, value, linuxJoystickEvent2.getNanos());
                        break;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 2:
                if (number < getNumAxes()) {
                    LinuxJoystickAxis linuxJoystickAxis = this.axes[number];
                    if (linuxJoystickAxis != null) {
                        float value2 = ((float) linuxJoystickEvent2.getValue()) / 32767.0f;
                        linuxJoystickAxis.setValue(value2);
                        Map map = this.povXs;
                        Integer num5 = num;
                        Integer num6 = new Integer(number);
                        if (!map.containsKey(num5)) {
                            Map map2 = this.povYs;
                            Integer num7 = num2;
                            Integer num8 = new Integer(number);
                            if (!map2.containsKey(num7)) {
                                this.event.set(linuxJoystickAxis, value2, linuxJoystickEvent2.getNanos());
                                break;
                            } else {
                                Map map3 = this.povYs;
                                Integer num9 = num3;
                                Integer num10 = new Integer(number);
                                LinuxJoystickPOV linuxJoystickPOV = (LinuxJoystickPOV) map3.get(num9);
                                linuxJoystickPOV.updateValue();
                                this.event.set(linuxJoystickPOV, linuxJoystickPOV.getPollData(), linuxJoystickEvent2.getNanos());
                                break;
                            }
                        } else {
                            Map map4 = this.povXs;
                            Integer num11 = num4;
                            Integer num12 = new Integer(number);
                            LinuxJoystickPOV linuxJoystickPOV2 = (LinuxJoystickPOV) map4.get(num11);
                            linuxJoystickPOV2.updateValue();
                            this.event.set(linuxJoystickPOV2, linuxJoystickPOV2.getPollData(), linuxJoystickEvent2.getNanos());
                            break;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
        if (!this.event_queue.isFull()) {
            this.event_queue.add(this.event);
        }
    }

    public final void close() throws IOException {
        synchronized (this) {
            try {
                if (!this.closed) {
                    this.closed = true;
                    nClose(this.f156fd);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws IOException {
        close();
    }

    public final byte[] getAxisMap() {
        return this.axisMap;
    }

    public final char[] getButtonMap() {
        return this.buttonMap;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNextEvent(Event event2) throws IOException {
        boolean z;
        Event event3 = event2;
        synchronized (this) {
            try {
                th = this.event_queue.getNextEvent(event3);
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z;
    }

    public final int getNumAxes() {
        return this.axes.length;
    }

    public final int getNumButtons() {
        return this.buttons.length;
    }

    /* JADX INFO: finally extract failed */
    public final void poll() throws IOException {
        synchronized (this) {
            try {
                checkClosed();
                while (getNextDeviceEvent(this.joystick_event)) {
                    processEvent(this.joystick_event);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final void registerAxis(int i, LinuxJoystickAxis linuxJoystickAxis) {
        int i2 = i;
        LinuxJoystickAxis linuxJoystickAxis2 = linuxJoystickAxis;
        this.axes[i2] = linuxJoystickAxis2;
    }

    public final void registerButton(int i, LinuxJoystickButton linuxJoystickButton) {
        int i2 = i;
        LinuxJoystickButton linuxJoystickButton2 = linuxJoystickButton;
        this.buttons[i2] = linuxJoystickButton2;
    }

    public final void registerPOV(LinuxJoystickPOV linuxJoystickPOV) {
        Integer num;
        Integer num2;
        LinuxJoystickPOV linuxJoystickPOV2 = linuxJoystickPOV;
        LinuxJoystickAxis yAxis = linuxJoystickPOV2.getYAxis();
        LinuxJoystickAxis xAxis = linuxJoystickPOV2.getXAxis();
        int i = 0;
        while (i < this.axes.length && this.axes[i] != yAxis) {
            i++;
        }
        int i2 = 0;
        while (i2 < this.axes.length && this.axes[i2] != xAxis) {
            i2++;
        }
        Map map = this.povXs;
        Integer num3 = num;
        Integer num4 = new Integer(i);
        Object put = map.put(num3, linuxJoystickPOV2);
        Map map2 = this.povYs;
        Integer num5 = num2;
        Integer num6 = new Integer(i2);
        Object put2 = map2.put(num5, linuxJoystickPOV2);
    }

    public final void setBufferSize(int i) {
        EventQueue eventQueue;
        int i2 = i;
        synchronized (this) {
            try {
                EventQueue eventQueue2 = eventQueue;
                EventQueue eventQueue3 = new EventQueue(i2);
                this.event_queue = eventQueue2;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
