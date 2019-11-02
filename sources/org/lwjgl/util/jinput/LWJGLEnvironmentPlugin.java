package org.lwjgl.util.jinput;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.util.plugins.Plugin;

public class LWJGLEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private final Controller[] controllers;

    public LWJGLEnvironmentPlugin() {
        LWJGLKeyboard lWJGLKeyboard;
        LWJGLMouse lWJGLMouse;
        Controller[] controllerArr = new Controller[2];
        Controller[] controllerArr2 = controllerArr;
        LWJGLKeyboard lWJGLKeyboard2 = lWJGLKeyboard;
        LWJGLKeyboard lWJGLKeyboard3 = new LWJGLKeyboard();
        controllerArr2[0] = lWJGLKeyboard2;
        Controller[] controllerArr3 = controllerArr;
        LWJGLMouse lWJGLMouse2 = lWJGLMouse;
        LWJGLMouse lWJGLMouse3 = new LWJGLMouse();
        controllerArr3[1] = lWJGLMouse2;
        this.controllers = controllerArr;
    }

    public Controller[] getControllers() {
        return this.controllers;
    }

    public boolean isSupported() {
        return true;
    }
}
