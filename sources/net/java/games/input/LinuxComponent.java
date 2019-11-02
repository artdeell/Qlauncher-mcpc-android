package net.java.games.input;

import java.io.IOException;

class LinuxComponent extends AbstractComponent {
    private final LinuxEventComponent component;

    public LinuxComponent(LinuxEventComponent linuxEventComponent) {
        LinuxEventComponent linuxEventComponent2 = linuxEventComponent;
        super(linuxEventComponent2.getIdentifier().getName(), linuxEventComponent2.getIdentifier());
        this.component = linuxEventComponent2;
    }

    /* access modifiers changed from: 0000 */
    public float convertValue(float f, LinuxAxisDescriptor linuxAxisDescriptor) {
        LinuxAxisDescriptor linuxAxisDescriptor2 = linuxAxisDescriptor;
        return getComponent().convertValue(f);
    }

    public final LinuxEventComponent getComponent() {
        return this.component;
    }

    public final float getDeadZone() {
        return this.component.getDeadZone();
    }

    public final boolean isAnalog() {
        return this.component.isAnalog();
    }

    public final boolean isRelative() {
        return this.component.isRelative();
    }

    /* access modifiers changed from: protected */
    public float poll() throws IOException {
        return convertValue(LinuxControllers.poll(this.component), this.component.getDescriptor());
    }
}
