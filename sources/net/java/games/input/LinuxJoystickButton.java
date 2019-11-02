package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;

final class LinuxJoystickButton extends AbstractComponent {
    private float value;

    public LinuxJoystickButton(Identifier identifier) {
        Identifier identifier2 = identifier;
        super(identifier2.getName(), identifier2);
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
        float f2 = f;
        this.value = f2;
    }
}
