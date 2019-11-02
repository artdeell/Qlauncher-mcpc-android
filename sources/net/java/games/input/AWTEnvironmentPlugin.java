package net.java.games.input;

import net.java.games.util.plugins.Plugin;

public class AWTEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private final Controller[] controllers;

    public AWTEnvironmentPlugin() {
        AWTKeyboard aWTKeyboard;
        AWTMouse aWTMouse;
        Controller[] controllerArr = new Controller[2];
        Controller[] controllerArr2 = controllerArr;
        AWTKeyboard aWTKeyboard2 = aWTKeyboard;
        AWTKeyboard aWTKeyboard3 = new AWTKeyboard();
        controllerArr2[0] = aWTKeyboard2;
        Controller[] controllerArr3 = controllerArr;
        AWTMouse aWTMouse2 = aWTMouse;
        AWTMouse aWTMouse3 = new AWTMouse();
        controllerArr3[1] = aWTMouse2;
        this.controllers = controllerArr;
    }

    public Controller[] getControllers() {
        return this.controllers;
    }

    public boolean isSupported() {
        return true;
    }
}
