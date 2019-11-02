package net.java.games.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class AWTMouse extends Mouse implements AWTEventListener {
    private static final int EVENT_BUTTON = 4;
    private static final int EVENT_X = 1;
    private static final int EVENT_Y = 2;
    private final List awt_events;
    private int event_state = 1;
    private final List processed_awt_events;

    static final class Axis extends AbstractComponent {
        private float value;

        public Axis(net.java.games.input.Component.Identifier.Axis axis) {
            net.java.games.input.Component.Identifier.Axis axis2 = axis;
            super(axis2.getName(), axis2);
        }

        public final boolean isAnalog() {
            return true;
        }

        public final boolean isRelative() {
            return false;
        }

        /* access modifiers changed from: protected */
        public final float poll() throws IOException {
            return this.value;
        }

        /* access modifiers changed from: protected */
        public final void setValue(float f) {
            float f2 = f;
            this.value = f2;
        }
    }

    static final class Button extends AbstractComponent {
        private float value;

        public Button(net.java.games.input.Component.Identifier.Button button) {
            net.java.games.input.Component.Identifier.Button button2 = button;
            super(button2.getName(), button2);
        }

        public final boolean isAnalog() {
            return false;
        }

        public final boolean isRelative() {
            return false;
        }

        /* access modifiers changed from: protected */
        public final float poll() throws IOException {
            return this.value;
        }

        /* access modifiers changed from: protected */
        public final void setValue(float f) {
            float f2 = f;
            this.value = f2;
        }
    }

    protected AWTMouse() {
        ArrayList arrayList;
        ArrayList arrayList2;
        super("AWTMouse", createComponents(), new Controller[0], new Rumbler[0]);
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList();
        this.awt_events = arrayList3;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = new ArrayList();
        this.processed_awt_events = arrayList5;
        Toolkit.getDefaultToolkit().addAWTEventListener(this, 131120);
    }

    private static final Component[] createComponents() {
        Axis axis;
        Axis axis2;
        Axis axis3;
        Button button;
        Button button2;
        Button button3;
        Component[] componentArr = new Component[6];
        Component[] componentArr2 = componentArr;
        Axis axis4 = axis;
        Axis axis5 = new Axis(net.java.games.input.Component.Identifier.Axis.f31X);
        componentArr2[0] = axis4;
        Component[] componentArr3 = componentArr;
        Axis axis6 = axis2;
        Axis axis7 = new Axis(net.java.games.input.Component.Identifier.Axis.f32Y);
        componentArr3[1] = axis6;
        Component[] componentArr4 = componentArr;
        Axis axis8 = axis3;
        Axis axis9 = new Axis(net.java.games.input.Component.Identifier.Axis.f33Z);
        componentArr4[2] = axis8;
        Component[] componentArr5 = componentArr;
        Button button4 = button;
        Button button5 = new Button(net.java.games.input.Component.Identifier.Button.LEFT);
        componentArr5[3] = button4;
        Component[] componentArr6 = componentArr;
        Button button6 = button2;
        Button button7 = new Button(net.java.games.input.Component.Identifier.Button.MIDDLE);
        componentArr6[4] = button6;
        Component[] componentArr7 = componentArr;
        Button button8 = button3;
        Button button9 = new Button(net.java.games.input.Component.Identifier.Button.RIGHT);
        componentArr7[5] = button8;
        return componentArr;
    }

    private final Button getButton(int i) {
        switch (i) {
            case 1:
                return (Button) getLeft();
            case 2:
                return (Button) getMiddle();
            case 3:
                return (Button) getRight();
            default:
                return null;
        }
    }

    private final void processButtons(int i, float f) {
        float f2 = f;
        Button button = getButton(i);
        if (button != null) {
            button.setValue(f2);
        }
    }

    private final void processEvent(AWTEvent aWTEvent) throws IOException {
        AWTEvent aWTEvent2 = aWTEvent;
        if (aWTEvent2 instanceof MouseWheelEvent) {
            Axis axis = (Axis) getWheel();
            axis.setValue(axis.poll() + ((float) ((MouseWheelEvent) aWTEvent2).getWheelRotation()));
        } else if (aWTEvent2 instanceof MouseEvent) {
            MouseEvent mouseEvent = (MouseEvent) aWTEvent2;
            Axis axis2 = (Axis) getY();
            ((Axis) getX()).setValue((float) mouseEvent.getX());
            axis2.setValue((float) mouseEvent.getY());
            switch (mouseEvent.getID()) {
                case 501:
                    processButtons(mouseEvent.getButton(), 1.0f);
                    return;
                case 502:
                    processButtons(mouseEvent.getButton(), 0.0f);
                    return;
                default:
                    return;
            }
        }
    }

    public final void eventDispatched(AWTEvent aWTEvent) {
        AWTEvent aWTEvent2 = aWTEvent;
        synchronized (this) {
            try {
                boolean add = this.awt_events.add(aWTEvent2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean getNextDeviceEvent(Event event) throws IOException {
        boolean z;
        boolean z2;
        RuntimeException runtimeException;
        StringBuffer stringBuffer;
        Event event2 = event;
        synchronized (this) {
            while (true) {
                try {
                    th = false;
                    if (!this.processed_awt_events.isEmpty()) {
                        AWTEvent aWTEvent = (AWTEvent) this.processed_awt_events.get(0);
                        if (aWTEvent instanceof MouseWheelEvent) {
                            MouseWheelEvent mouseWheelEvent = (MouseWheelEvent) aWTEvent;
                            event2.set(getWheel(), (float) mouseWheelEvent.getWheelRotation(), 1000000 * mouseWheelEvent.getWhen());
                            Object remove = this.processed_awt_events.remove(0);
                        } else if (aWTEvent instanceof MouseEvent) {
                            MouseEvent mouseEvent = (MouseEvent) aWTEvent;
                            long when = 1000000 * mouseEvent.getWhen();
                            switch (this.event_state) {
                                case 1:
                                    this.event_state = 2;
                                    event2.set(getX(), (float) mouseEvent.getX(), when);
                                    z2 = true;
                                    break;
                                case 2:
                                    this.event_state = 4;
                                    event2.set(getY(), (float) mouseEvent.getY(), when);
                                    z2 = true;
                                    break;
                                case 4:
                                    Object remove2 = this.processed_awt_events.remove(0);
                                    this.event_state = 1;
                                    Button button = getButton(mouseEvent.getButton());
                                    if (button != null) {
                                        switch (mouseEvent.getID()) {
                                            case 501:
                                                event2.set(button, 1.0f, when);
                                                z2 = true;
                                                break;
                                            case 502:
                                                event2.set(button, 0.0f, when);
                                                z2 = true;
                                                break;
                                            default:
                                                continue;
                                        }
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
                        } else {
                            continue;
                        }
                    }
                } finally {
                    z = th;
                    Throwable th = z;
                }
            }
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    public final void pollDevice() throws IOException {
        synchronized (this) {
            try {
                ((Axis) getWheel()).setValue(0.0f);
                for (int i = 0; i < this.awt_events.size(); i++) {
                    AWTEvent aWTEvent = (AWTEvent) this.awt_events.get(i);
                    processEvent(aWTEvent);
                    boolean add = this.processed_awt_events.add(aWTEvent);
                }
                this.awt_events.clear();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}
