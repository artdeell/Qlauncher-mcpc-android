package net.java.games.input;

public class ControllerEvent {
    private Controller controller;

    public ControllerEvent(Controller controller2) {
        this.controller = controller2;
    }

    public Controller getController() {
        return this.controller;
    }
}
