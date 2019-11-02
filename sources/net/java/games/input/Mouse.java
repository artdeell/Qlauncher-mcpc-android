package net.java.games.input;

import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Component.Identifier.Button;
import net.java.games.input.Controller.Type;

public abstract class Mouse extends AbstractController {
    protected Mouse(String str, Component[] componentArr, Controller[] controllerArr, Rumbler[] rumblerArr) {
        super(str, componentArr, controllerArr, rumblerArr);
    }

    public Component getBack() {
        return getComponent(Button.BACK);
    }

    public Component getButton3() {
        return getComponent(Button.f43_3);
    }

    public Component getButton4() {
        return getComponent(Button.f44_4);
    }

    public Component getExtra() {
        return getComponent(Button.EXTRA);
    }

    public Component getForward() {
        return getComponent(Button.FORWARD);
    }

    public Component getLeft() {
        return getComponent(Button.LEFT);
    }

    public Component getMiddle() {
        return getComponent(Button.MIDDLE);
    }

    public Component getPrimaryButton() {
        Component component = getComponent(Button.LEFT);
        if (component == null) {
            component = getComponent(Button.f41_1);
        }
        return component;
    }

    public Component getRight() {
        return getComponent(Button.RIGHT);
    }

    public Component getSecondaryButton() {
        Component component = getComponent(Button.RIGHT);
        if (component == null) {
            component = getComponent(Button.f42_2);
        }
        return component;
    }

    public Component getSide() {
        return getComponent(Button.SIDE);
    }

    public Component getTertiaryButton() {
        Component component = getComponent(Button.MIDDLE);
        if (component == null) {
            component = getComponent(Button.f43_3);
        }
        return component;
    }

    public Type getType() {
        return Type.MOUSE;
    }

    public Component getWheel() {
        return getComponent(Axis.f33Z);
    }

    public Component getX() {
        return getComponent(Axis.f31X);
    }

    public Component getY() {
        return getComponent(Axis.f32Y);
    }
}
