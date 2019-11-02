package net.java.games.input;

import java.util.ArrayList;
import net.java.games.input.Controller.Type;

public class DirectAndRawInputEnvironmentPlugin extends ControllerEnvironment {
    private Controller[] controllers = null;
    private DirectInputEnvironmentPlugin dinputPlugin;
    private RawInputEnvironmentPlugin rawPlugin;

    public DirectAndRawInputEnvironmentPlugin() {
        DirectInputEnvironmentPlugin directInputEnvironmentPlugin;
        RawInputEnvironmentPlugin rawInputEnvironmentPlugin;
        DirectInputEnvironmentPlugin directInputEnvironmentPlugin2 = directInputEnvironmentPlugin;
        DirectInputEnvironmentPlugin directInputEnvironmentPlugin3 = new DirectInputEnvironmentPlugin();
        this.dinputPlugin = directInputEnvironmentPlugin2;
        RawInputEnvironmentPlugin rawInputEnvironmentPlugin2 = rawInputEnvironmentPlugin;
        RawInputEnvironmentPlugin rawInputEnvironmentPlugin3 = new RawInputEnvironmentPlugin();
        this.rawPlugin = rawInputEnvironmentPlugin2;
    }

    public Controller[] getControllers() {
        ArrayList arrayList;
        if (this.controllers == null) {
            boolean z = false;
            boolean z2 = false;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            Controller[] controllers2 = this.dinputPlugin.getControllers();
            Controller[] controllers3 = this.rawPlugin.getControllers();
            for (int i = 0; i < controllers3.length; i++) {
                boolean add = arrayList4.add(controllers3[i]);
                if (controllers3[i].getType() == Type.KEYBOARD) {
                    z = true;
                } else if (controllers3[i].getType() == Type.MOUSE) {
                    z2 = true;
                }
            }
            for (int i2 = 0; i2 < controllers2.length; i2++) {
                if (controllers2[i2].getType() == Type.KEYBOARD) {
                    if (!z) {
                        boolean add2 = arrayList4.add(controllers2[i2]);
                    }
                } else if (controllers2[i2].getType() != Type.MOUSE) {
                    boolean add3 = arrayList4.add(controllers2[i2]);
                } else if (!z2) {
                    boolean add4 = arrayList4.add(controllers2[i2]);
                }
            }
            this.controllers = (Controller[]) arrayList4.toArray(new Controller[0]);
        }
        return this.controllers;
    }

    public boolean isSupported() {
        return this.rawPlugin.isSupported() || this.dinputPlugin.isSupported();
    }
}
