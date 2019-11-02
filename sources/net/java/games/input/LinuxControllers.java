package net.java.games.input;

import java.io.IOException;

final class LinuxControllers {
    private static final LinuxAbsInfo abs_info;
    private static final LinuxEvent linux_event;

    static {
        LinuxEvent linuxEvent;
        LinuxAbsInfo linuxAbsInfo;
        LinuxEvent linuxEvent2 = linuxEvent;
        LinuxEvent linuxEvent3 = new LinuxEvent();
        linux_event = linuxEvent2;
        LinuxAbsInfo linuxAbsInfo2 = linuxAbsInfo;
        LinuxAbsInfo linuxAbsInfo3 = new LinuxAbsInfo();
        abs_info = linuxAbsInfo2;
    }

    LinuxControllers() {
    }

    public static final boolean getNextDeviceEvent(Event event, LinuxEventDevice linuxEventDevice) throws IOException {
        boolean z;
        Event event2 = event;
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        synchronized (LinuxControllers.class) {
            while (true) {
                try {
                    if (!linuxEventDevice2.getNextEvent(linux_event)) {
                        z = false;
                        break;
                    }
                    LinuxAxisDescriptor descriptor = linux_event.getDescriptor();
                    LinuxComponent mapDescriptor = linuxEventDevice2.mapDescriptor(descriptor);
                    if (mapDescriptor != null) {
                        event2.set(mapDescriptor, mapDescriptor.convertValue((float) linux_event.getValue(), descriptor), linux_event.getNanos());
                        z = true;
                        break;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Class<LinuxControllers> cls = LinuxControllers.class;
                    throw th2;
                }
            }
        }
        return z;
    }

    public static final float poll(LinuxEventComponent linuxEventComponent) throws IOException {
        float value;
        RuntimeException runtimeException;
        StringBuffer stringBuffer;
        LinuxEventComponent linuxEventComponent2 = linuxEventComponent;
        synchronized (LinuxControllers.class) {
            try {
                int type = linuxEventComponent2.getDescriptor().getType();
                switch (type) {
                    case 1:
                        if (!linuxEventComponent2.getDevice().isKeySet(linuxEventComponent2.getDescriptor().getCode())) {
                            value = 0.0f;
                            break;
                        } else {
                            value = 1.0f;
                            break;
                        }
                    case 3:
                        linuxEventComponent2.getAbsInfo(abs_info);
                        value = (float) abs_info.getValue();
                        break;
                    default:
                        RuntimeException runtimeException2 = runtimeException;
                        StringBuffer stringBuffer2 = stringBuffer;
                        StringBuffer stringBuffer3 = new StringBuffer();
                        RuntimeException runtimeException3 = new RuntimeException(stringBuffer2.append("Unkown native_type: ").append(type).toString());
                        throw runtimeException2;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<LinuxControllers> cls = LinuxControllers.class;
                throw th2;
            }
        }
        return value;
    }
}
