package org.lwjgl.input;

import java.util.ArrayList;
import net.java.games.input.Component;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Component.Identifier.Button;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import net.java.games.input.Rumbler;

class JInputController implements Controller {
    private ArrayList<Component> axes;
    private float[] axesMax;
    private float[] axesValue;
    private boolean[] buttonState;
    private ArrayList<Component> buttons;
    private float[] deadZones;
    private int index;
    private ArrayList<Component> pov;
    private float[] povValues;
    private Rumbler[] rumblers;
    private int rxaxis = -1;
    private int ryaxis = -1;
    private int rzaxis = -1;
    private Controller target;
    private int xaxis = -1;
    private int yaxis = -1;
    private int zaxis = -1;

    JInputController(int i, Controller controller) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i2 = i;
        Controller controller2 = controller;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = new ArrayList();
        this.buttons = arrayList4;
        ArrayList arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList();
        this.axes = arrayList6;
        ArrayList arrayList8 = arrayList3;
        ArrayList arrayList9 = new ArrayList();
        this.pov = arrayList8;
        this.target = controller2;
        this.index = i2;
        Component[] components = controller2.getComponents();
        int length = components.length;
        for (int i3 = 0; i3 < length; i3++) {
            Component component = components[i3];
            if (component.getIdentifier() instanceof Button) {
                boolean add = this.buttons.add(component);
            } else if (component.getIdentifier().equals(Axis.POV)) {
                boolean add2 = this.pov.add(component);
            } else {
                boolean add3 = this.axes.add(component);
            }
        }
        this.buttonState = new boolean[this.buttons.size()];
        this.povValues = new float[this.pov.size()];
        this.axesValue = new float[this.axes.size()];
        int i4 = 0;
        int i5 = 0;
        int length2 = components.length;
        for (int i6 = 0; i6 < length2; i6++) {
            Component component2 = components[i6];
            if (component2.getIdentifier() instanceof Button) {
                this.buttonState[i4] = component2.getPollData() != 0.0f;
                i4++;
            } else if (!component2.getIdentifier().equals(Axis.POV)) {
                this.axesValue[i5] = component2.getPollData();
                if (component2.getIdentifier().equals(Axis.f31X)) {
                    this.xaxis = i5;
                }
                if (component2.getIdentifier().equals(Axis.f32Y)) {
                    this.yaxis = i5;
                }
                if (component2.getIdentifier().equals(Axis.f33Z)) {
                    this.zaxis = i5;
                }
                if (component2.getIdentifier().equals(Axis.f28RX)) {
                    this.rxaxis = i5;
                }
                if (component2.getIdentifier().equals(Axis.f29RY)) {
                    this.ryaxis = i5;
                }
                if (component2.getIdentifier().equals(Axis.f30RZ)) {
                    this.rzaxis = i5;
                }
                i5++;
            }
        }
        this.axesMax = new float[this.axes.size()];
        this.deadZones = new float[this.axes.size()];
        for (int i7 = 0; i7 < this.axesMax.length; i7++) {
            this.axesMax[i7] = 1.0f;
            this.deadZones[i7] = 0.05f;
        }
        this.rumblers = controller2.getRumblers();
    }

    public int getAxisCount() {
        return this.axes.size();
    }

    public String getAxisName(int i) {
        return ((Component) this.axes.get(i)).getName();
    }

    public float getAxisValue(int i) {
        return this.axesValue[i];
    }

    public int getButtonCount() {
        return this.buttons.size();
    }

    public String getButtonName(int i) {
        return ((Component) this.buttons.get(i)).getName();
    }

    public float getDeadZone(int i) {
        return this.deadZones[i];
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.target.getName();
    }

    public float getPovX() {
        if (this.pov.size() != 0) {
            float f = this.povValues[0];
            if (f == 0.875f || f == 0.125f || f == 1.0f) {
                return -1.0f;
            }
            if (f == 0.625f || f == 0.375f || f == 0.5f) {
                return 1.0f;
            }
        }
        return 0.0f;
    }

    public float getPovY() {
        if (this.pov.size() != 0) {
            float f = this.povValues[0];
            if (f == 0.875f || f == 0.625f || f == 0.75f) {
                return 1.0f;
            }
            if (f == 0.125f || f == 0.375f || f == 0.25f) {
                return -1.0f;
            }
        }
        return 0.0f;
    }

    public float getRXAxisDeadZone() {
        if (this.rxaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.rxaxis);
    }

    public float getRXAxisValue() {
        if (this.rxaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.rxaxis);
    }

    public float getRYAxisDeadZone() {
        if (this.ryaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.ryaxis);
    }

    public float getRYAxisValue() {
        if (this.ryaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.ryaxis);
    }

    public float getRZAxisDeadZone() {
        if (this.rzaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.rzaxis);
    }

    public float getRZAxisValue() {
        if (this.rzaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.rzaxis);
    }

    public int getRumblerCount() {
        return this.rumblers.length;
    }

    public String getRumblerName(int i) {
        return this.rumblers[i].getAxisName();
    }

    public float getXAxisDeadZone() {
        if (this.xaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.xaxis);
    }

    public float getXAxisValue() {
        if (this.xaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.xaxis);
    }

    public float getYAxisDeadZone() {
        if (this.yaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.yaxis);
    }

    public float getYAxisValue() {
        if (this.yaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.yaxis);
    }

    public float getZAxisDeadZone() {
        if (this.zaxis == -1) {
            return 0.0f;
        }
        return getDeadZone(this.zaxis);
    }

    public float getZAxisValue() {
        if (this.zaxis == -1) {
            return 0.0f;
        }
        return getAxisValue(this.zaxis);
    }

    public boolean isButtonPressed(int i) {
        return this.buttonState[i];
    }

    public void poll() {
        Event event;
        ControllerEvent controllerEvent;
        ControllerEvent controllerEvent2;
        ControllerEvent controllerEvent3;
        ControllerEvent controllerEvent4;
        boolean poll = this.target.poll();
        Event event2 = event;
        Event event3 = new Event();
        Event event4 = event2;
        EventQueue eventQueue = this.target.getEventQueue();
        while (eventQueue.getNextEvent(event4)) {
            if (this.buttons.contains(event4.getComponent())) {
                int indexOf = this.buttons.indexOf(event4.getComponent());
                this.buttonState[indexOf] = event4.getValue() != 0.0f;
                ControllerEvent controllerEvent5 = controllerEvent4;
                ControllerEvent controllerEvent6 = new ControllerEvent(this, event4.getNanos(), 1, indexOf, false, false);
                Controllers.addEvent(controllerEvent5);
            }
            if (this.pov.contains(event4.getComponent())) {
                int indexOf2 = this.pov.indexOf(event4.getComponent());
                float povX = getPovX();
                float povY = getPovY();
                this.povValues[indexOf2] = event4.getValue();
                if (povX != getPovX()) {
                    ControllerEvent controllerEvent7 = controllerEvent3;
                    ControllerEvent controllerEvent8 = new ControllerEvent(this, event4.getNanos(), 3, 0, false, false);
                    Controllers.addEvent(controllerEvent7);
                }
                if (povY != getPovY()) {
                    ControllerEvent controllerEvent9 = controllerEvent2;
                    ControllerEvent controllerEvent10 = new ControllerEvent(this, event4.getNanos(), 4, 0, false, false);
                    Controllers.addEvent(controllerEvent9);
                }
            }
            if (this.axes.contains(event4.getComponent())) {
                Component component = event4.getComponent();
                int indexOf3 = this.axes.indexOf(component);
                float pollData = component.getPollData();
                if (Math.abs(pollData) < this.deadZones[indexOf3]) {
                    pollData = 0.0f;
                }
                if (Math.abs(pollData) < component.getDeadZone()) {
                    pollData = 0.0f;
                }
                if (Math.abs(pollData) > this.axesMax[indexOf3]) {
                    this.axesMax[indexOf3] = Math.abs(pollData);
                }
                float f = pollData / this.axesMax[indexOf3];
                ControllerEvent controllerEvent11 = controllerEvent;
                ControllerEvent controllerEvent12 = new ControllerEvent(this, event4.getNanos(), 2, indexOf3, indexOf3 == this.xaxis, indexOf3 == this.yaxis);
                Controllers.addEvent(controllerEvent11);
                this.axesValue[indexOf3] = f;
            }
        }
    }

    public void setDeadZone(int i, float f) {
        int i2 = i;
        float f2 = f;
        this.deadZones[i2] = f2;
    }

    public void setRXAxisDeadZone(float f) {
        setDeadZone(this.rxaxis, f);
    }

    public void setRYAxisDeadZone(float f) {
        setDeadZone(this.ryaxis, f);
    }

    public void setRZAxisDeadZone(float f) {
        setDeadZone(this.rzaxis, f);
    }

    public void setRumblerStrength(int i, float f) {
        int i2 = i;
        float f2 = f;
        this.rumblers[i2].rumble(f2);
    }

    public void setXAxisDeadZone(float f) {
        setDeadZone(this.xaxis, f);
    }

    public void setYAxisDeadZone(float f) {
        setDeadZone(this.yaxis, f);
    }

    public void setZAxisDeadZone(float f) {
        setDeadZone(this.zaxis, f);
    }
}
