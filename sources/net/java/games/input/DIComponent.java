package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;

final class DIComponent extends AbstractComponent {
    private final DIDeviceObject object;

    public DIComponent(Identifier identifier, DIDeviceObject dIDeviceObject) {
        DIDeviceObject dIDeviceObject2 = dIDeviceObject;
        super(dIDeviceObject2.getName(), identifier);
        this.object = dIDeviceObject2;
    }

    public final float getDeadZone() {
        return this.object.getDeadzone();
    }

    public final DIDeviceObject getDeviceObject() {
        return this.object;
    }

    public final boolean isAnalog() {
        return this.object.isAnalog();
    }

    public final boolean isRelative() {
        return this.object.isRelative();
    }

    /* access modifiers changed from: protected */
    public final float poll() throws IOException {
        return DIControllers.poll(this, this.object);
    }
}
