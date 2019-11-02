package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier.Axis;

class LinuxJoystickAxis extends AbstractComponent {
    private boolean analog;
    private float value;

    public LinuxJoystickAxis(Axis axis) {
        this(axis, true);
    }

    public LinuxJoystickAxis(Axis axis, boolean z) {
        Axis axis2 = axis;
        boolean z2 = z;
        super(axis2.getName(), axis2);
        this.analog = z2;
    }

    public final boolean isAnalog() {
        return this.analog;
    }

    public final boolean isRelative() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final float poll() throws IOException {
        return this.value;
    }

    /* access modifiers changed from: 0000 */
    public final void setValue(float f) {
        this.value = f;
        resetHasPolled();
    }
}
