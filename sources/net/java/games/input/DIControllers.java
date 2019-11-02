package net.java.games.input;

import java.io.IOException;

final class DIControllers {
    private static final DIDeviceObjectData di_event;

    static {
        DIDeviceObjectData dIDeviceObjectData;
        DIDeviceObjectData dIDeviceObjectData2 = dIDeviceObjectData;
        DIDeviceObjectData dIDeviceObjectData3 = new DIDeviceObjectData();
        di_event = dIDeviceObjectData2;
    }

    DIControllers() {
    }

    public static final boolean getNextDeviceEvent(Event event, IDirectInputDevice iDirectInputDevice) throws IOException {
        boolean z;
        Event event2 = event;
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        synchronized (DIControllers.class) {
            try {
                z = false;
                if (iDirectInputDevice2.getNextEvent(di_event)) {
                    DIDeviceObject mapEvent = iDirectInputDevice2.mapEvent(di_event);
                    DIComponent mapObject = iDirectInputDevice2.mapObject(mapEvent);
                    z = false;
                    if (mapObject != null) {
                        event2.set(mapObject, mapObject.getDeviceObject().convertValue((float) (mapEvent.isRelative() ? mapEvent.getRelativeEventValue(di_event.getData()) : di_event.getData())), di_event.getNanos());
                        z = true;
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<DIControllers> cls = DIControllers.class;
                throw th2;
            }
        }
        return z;
    }

    public static final float poll(Component component, DIDeviceObject dIDeviceObject) throws IOException {
        Component component2 = component;
        DIDeviceObject dIDeviceObject2 = dIDeviceObject;
        int pollData = dIDeviceObject2.getDevice().getPollData(dIDeviceObject2);
        return dIDeviceObject2.convertValue(dIDeviceObject2.isRelative() ? (float) dIDeviceObject2.getRelativePollValue(pollData) : (float) pollData);
    }
}
