package net.java.games.input;

public interface ControllerListener {
    void controllerAdded(ControllerEvent controllerEvent);

    void controllerRemoved(ControllerEvent controllerEvent);
}
