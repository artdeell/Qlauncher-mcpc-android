package net.java.games.input;

import java.io.IOException;

final class RawMouse extends Mouse {
    private static final int EVENT_BUTTON_0 = 5;
    private static final int EVENT_BUTTON_1 = 6;
    private static final int EVENT_BUTTON_2 = 7;
    private static final int EVENT_BUTTON_3 = 8;
    private static final int EVENT_BUTTON_4 = 9;
    private static final int EVENT_DONE = 1;
    private static final int EVENT_X = 2;
    private static final int EVENT_Y = 3;
    private static final int EVENT_Z = 4;
    private final RawMouseEvent current_event;
    private final RawDevice device;
    private int event_state = 1;

    static final class Axis extends AbstractComponent {
        private final RawDevice device;

        public Axis(RawDevice rawDevice, net.java.games.input.Component.Identifier.Axis axis) {
            RawDevice rawDevice2 = rawDevice;
            net.java.games.input.Component.Identifier.Axis axis2 = axis;
            super(axis2.getName(), axis2);
            this.device = rawDevice2;
        }

        public final boolean isAnalog() {
            return true;
        }

        public final boolean isRelative() {
            return true;
        }

        /* access modifiers changed from: protected */
        public final float poll() throws IOException {
            RuntimeException runtimeException;
            StringBuffer stringBuffer;
            if (getIdentifier() == net.java.games.input.Component.Identifier.Axis.f31X) {
                return (float) this.device.getRelativeX();
            }
            if (getIdentifier() == net.java.games.input.Component.Identifier.Axis.f32Y) {
                return (float) this.device.getRelativeY();
            }
            if (getIdentifier() == net.java.games.input.Component.Identifier.Axis.f33Z) {
                return (float) this.device.getWheel();
            }
            RuntimeException runtimeException2 = runtimeException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            RuntimeException runtimeException3 = new RuntimeException(stringBuffer2.append("Unknown raw axis: ").append(getIdentifier()).toString());
            throw runtimeException2;
        }
    }

    static final class Button extends AbstractComponent {
        private final int button_id;
        private final RawDevice device;

        public Button(RawDevice rawDevice, net.java.games.input.Component.Identifier.Button button, int i) {
            RawDevice rawDevice2 = rawDevice;
            net.java.games.input.Component.Identifier.Button button2 = button;
            int i2 = i;
            super(button2.getName(), button2);
            this.device = rawDevice2;
            this.button_id = i2;
        }

        public final boolean isAnalog() {
            return false;
        }

        public final boolean isRelative() {
            return false;
        }

        /* access modifiers changed from: protected */
        public final float poll() throws IOException {
            return this.device.getButtonState(this.button_id) ? 1.0f : 0.0f;
        }
    }

    protected RawMouse(String str, RawDevice rawDevice, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr) throws IOException {
        RawMouseEvent rawMouseEvent;
        RawDevice rawDevice2 = rawDevice;
        super(str, componentArr, controllerArr, rumblerArr);
        RawMouseEvent rawMouseEvent2 = rawMouseEvent;
        RawMouseEvent rawMouseEvent3 = new RawMouseEvent();
        this.current_event = rawMouseEvent2;
        this.device = rawDevice2;
    }

    private static final boolean makeButtonEvent(RawMouseEvent rawMouseEvent, Event event, Component component, int i, int i2) {
        RawMouseEvent rawMouseEvent2 = rawMouseEvent;
        Event event2 = event;
        Component component2 = component;
        int i3 = i2;
        if ((i & rawMouseEvent2.getButtonFlags()) != 0) {
            event2.set(component2, 1.0f, rawMouseEvent2.getNanos());
            return true;
        } else if ((i3 & rawMouseEvent2.getButtonFlags()) == 0) {
            return false;
        } else {
            event2.set(component2, 0.0f, rawMouseEvent2.getNanos());
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        RuntimeException runtimeException;
        StringBuffer stringBuffer;
        Event event2 = event;
        boolean z = true;
        synchronized (this) {
            while (true) {
                try {
                    switch (this.event_state) {
                        case 1:
                            th = this.device.getNextMouseEvent(this.current_event);
                            if (!th) {
                                z = false;
                                break;
                            } else {
                                this.event_state = 2;
                                continue;
                            }
                        case 2:
                            int eventRelativeX = this.device.getEventRelativeX();
                            this.event_state = 3;
                            if (eventRelativeX != 0) {
                                event2.set(getX(), (float) eventRelativeX, this.current_event.getNanos());
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            int eventRelativeY = this.device.getEventRelativeY();
                            this.event_state = 4;
                            if (eventRelativeY != 0) {
                                event2.set(getY(), (float) eventRelativeY, this.current_event.getNanos());
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            int wheelDelta = this.current_event.getWheelDelta();
                            this.event_state = 5;
                            if (wheelDelta != 0) {
                                event2.set(getWheel(), (float) wheelDelta, this.current_event.getNanos());
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            this.event_state = 6;
                            if (makeButtonEvent(this.current_event, event2, getPrimaryButton(), 1, 2)) {
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            this.event_state = 7;
                            if (makeButtonEvent(this.current_event, event2, getSecondaryButton(), 4, 8)) {
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            this.event_state = 8;
                            if (makeButtonEvent(this.current_event, event2, getTertiaryButton(), 16, 32)) {
                                break;
                            } else {
                                continue;
                            }
                        case 8:
                            this.event_state = 9;
                            if (makeButtonEvent(this.current_event, event2, getButton3(), 64, 128)) {
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            this.event_state = 1;
                            if (makeButtonEvent(this.current_event, event2, getButton4(), 256, 512)) {
                                break;
                            } else {
                                continue;
                            }
                        default:
                            RuntimeException runtimeException2 = runtimeException;
                            StringBuffer stringBuffer2 = stringBuffer;
                            StringBuffer stringBuffer3 = new StringBuffer();
                            RuntimeException runtimeException3 = new RuntimeException(stringBuffer2.append("Unknown event state: ").append(this.event_state).toString());
                            throw runtimeException2;
                    }
                } finally {
                    Throwable th = th;
                    Throwable th2 = th;
                }
            }
        }
        return z;
    }

    public final void pollDevice() throws IOException {
        this.device.pollMouse();
    }

    /* access modifiers changed from: protected */
    public final void setDeviceEventQueueSize(int i) throws IOException {
        int i2 = i;
        this.device.setBufferSize(i2);
    }
}
