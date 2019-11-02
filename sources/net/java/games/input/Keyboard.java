package net.java.games.input;

import net.java.games.input.Component.Identifier.Key;
import net.java.games.input.Controller.Type;

public abstract class Keyboard extends AbstractController {
    protected Keyboard(String str, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr) {
        super(str, componentArr, controllerArr, rumblerArr);
    }

    public Type getType() {
        return Type.KEYBOARD;
    }

    public final boolean isKeyDown(Key key) {
        Component component = getComponent(key);
        return (component == null || component.getPollData() == 0.0f) ? false : true;
    }
}
