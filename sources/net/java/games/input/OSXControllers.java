package net.java.games.input;

import java.io.IOException;

final class OSXControllers {
    private static final OSXEvent osx_event;

    static {
        OSXEvent oSXEvent;
        OSXEvent oSXEvent2 = oSXEvent;
        OSXEvent oSXEvent3 = new OSXEvent();
        osx_event = oSXEvent2;
    }

    OSXControllers() {
    }

    public static final boolean getNextDeviceEvent(Event event, OSXHIDQueue oSXHIDQueue) throws IOException {
        boolean z;
        Event event2 = event;
        OSXHIDQueue oSXHIDQueue2 = oSXHIDQueue;
        synchronized (OSXControllers.class) {
            try {
                if (oSXHIDQueue2.getNextEvent(osx_event)) {
                    OSXComponent mapEvent = oSXHIDQueue2.mapEvent(osx_event);
                    event2.set(mapEvent, mapEvent.getElement().convertValue((float) osx_event.getValue()), osx_event.getNanos());
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<OSXControllers> cls = OSXControllers.class;
                throw th2;
            }
        }
        return z;
    }

    public static final float poll(OSXHIDElement oSXHIDElement) throws IOException {
        float f;
        OSXHIDElement oSXHIDElement2 = oSXHIDElement;
        synchronized (OSXControllers.class) {
            try {
                oSXHIDElement2.getElementValue(osx_event);
                th = oSXHIDElement2.convertValue((float) osx_event.getValue());
            } finally {
                f = th;
                Class<OSXControllers> cls = OSXControllers.class;
                Throwable th = f;
            }
        }
        return f;
    }
}
