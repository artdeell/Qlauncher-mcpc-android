package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller.PortType;
import net.java.games.input.Controller.Type;

public abstract class AbstractController implements Controller {
    static final int EVENT_QUEUE_DEPTH = 32;
    private static final Event event;
    private final Controller[] children;
    private final Component[] components;
    private EventQueue event_queue;
    private final Map id_to_components;
    private final String name;
    private final Rumbler[] rumblers;

    static {
        Event event2;
        Event event3 = event2;
        Event event4 = new Event();
        event = event3;
    }

    protected AbstractController(String str, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr) {
        HashMap hashMap;
        EventQueue eventQueue;
        String str2 = str;
        Component[] componentArr2 = componentArr;
        Controller[] controllerArr2 = controllerArr;
        Rumbler[] rumblerArr2 = rumblerArr;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.id_to_components = hashMap2;
        EventQueue eventQueue2 = eventQueue;
        EventQueue eventQueue3 = new EventQueue(32);
        this.event_queue = eventQueue2;
        this.name = str2;
        this.components = componentArr2;
        this.children = controllerArr2;
        this.rumblers = rumblerArr2;
        for (int length = -1 + componentArr2.length; length >= 0; length--) {
            Object put = this.id_to_components.put(componentArr2[length].getIdentifier(), componentArr2[length]);
        }
    }

    public final Component getComponent(Identifier identifier) {
        return (Component) this.id_to_components.get(identifier);
    }

    public final Component[] getComponents() {
        return this.components;
    }

    public final Controller[] getControllers() {
        return this.children;
    }

    public final EventQueue getEventQueue() {
        return this.event_queue;
    }

    public final String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public abstract boolean getNextDeviceEvent(Event event2) throws IOException;

    public int getPortNumber() {
        return 0;
    }

    public PortType getPortType() {
        return PortType.UNKNOWN;
    }

    public final Rumbler[] getRumblers() {
        return this.rumblers;
    }

    public Type getType() {
        return Type.UNKNOWN;
    }

    public boolean poll() {
        boolean z;
        StringBuffer stringBuffer;
        synchronized (this) {
            try {
                Component[] components2 = getComponents();
                pollDevice();
                for (int i = 0; i < components2.length; i++) {
                    AbstractComponent abstractComponent = (AbstractComponent) components2[i];
                    if (abstractComponent.isRelative()) {
                        abstractComponent.setPollData(0.0f);
                    } else {
                        abstractComponent.resetHasPolled();
                    }
                }
                while (true) {
                    if (!getNextDeviceEvent(event)) {
                        break;
                    }
                    AbstractComponent abstractComponent2 = (AbstractComponent) event.getComponent();
                    float value = event.getValue();
                    if (!abstractComponent2.isRelative()) {
                        if (value != abstractComponent2.getEventValue()) {
                            abstractComponent2.setEventValue(value);
                        }
                    } else if (value != 0.0f) {
                        abstractComponent2.setPollData(value + abstractComponent2.getPollData());
                    }
                    if (!this.event_queue.isFull()) {
                        this.event_queue.add(event);
                    }
                }
                z = true;
            } catch (IOException e) {
                IOException iOException = e;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                ControllerEnvironment.logln(stringBuffer2.append("Failed to poll device: ").append(iOException.getMessage()).toString());
                z = false;
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void pollDevice() throws IOException {
    }

    /* access modifiers changed from: protected */
    public void setDeviceEventQueueSize(int i) throws IOException {
    }

    public final void setEventQueueSize(int i) {
        StringBuffer stringBuffer;
        EventQueue eventQueue;
        int i2 = i;
        try {
            setDeviceEventQueueSize(i2);
            EventQueue eventQueue2 = eventQueue;
            EventQueue eventQueue3 = new EventQueue(i2);
            this.event_queue = eventQueue2;
        } catch (IOException e) {
            IOException iOException = e;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            ControllerEnvironment.logln(stringBuffer2.append("Failed to create new event queue of size ").append(i2).append(": ").append(iOException).toString());
        }
    }

    public String toString() {
        return this.name;
    }
}
