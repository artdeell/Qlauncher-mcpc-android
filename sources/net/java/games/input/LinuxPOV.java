package net.java.games.input;

import java.io.IOException;

final class LinuxPOV extends LinuxComponent {
    private final LinuxEventComponent component_x;
    private final LinuxEventComponent component_y;
    private float last_x;
    private float last_y;

    public LinuxPOV(LinuxEventComponent linuxEventComponent, LinuxEventComponent linuxEventComponent2) {
        LinuxEventComponent linuxEventComponent3 = linuxEventComponent;
        LinuxEventComponent linuxEventComponent4 = linuxEventComponent2;
        super(linuxEventComponent3);
        this.component_x = linuxEventComponent3;
        this.component_y = linuxEventComponent4;
    }

    public float convertValue(float f, LinuxAxisDescriptor linuxAxisDescriptor) {
        StringBuffer stringBuffer;
        float f2 = f;
        LinuxAxisDescriptor linuxAxisDescriptor2 = linuxAxisDescriptor;
        float f3 = 1.0f;
        if (linuxAxisDescriptor2 == this.component_x.getDescriptor()) {
            this.last_x = f2;
        }
        if (linuxAxisDescriptor2 == this.component_y.getDescriptor()) {
            this.last_y = f2;
        }
        if (this.last_x == -1.0f && this.last_y == -1.0f) {
            f3 = 0.125f;
        } else if (!(this.last_x == -1.0f && this.last_y == 0.0f)) {
            if (this.last_x == -1.0f && this.last_y == 1.0f) {
                return 0.875f;
            }
            if (this.last_x == 0.0f && this.last_y == -1.0f) {
                return 0.25f;
            }
            if (this.last_x == 0.0f && this.last_y == 0.0f) {
                return 0.0f;
            }
            if (this.last_x == 0.0f && this.last_y == 1.0f) {
                return 0.75f;
            }
            if (this.last_x == 1.0f && this.last_y == -1.0f) {
                return 0.375f;
            }
            if (this.last_x == 1.0f && this.last_y == 0.0f) {
                return 0.5f;
            }
            if (this.last_x == 1.0f && this.last_y == 1.0f) {
                return 0.625f;
            }
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            LinuxEnvironmentPlugin.logln(stringBuffer2.append("Unknown values x = ").append(this.last_x).append(" | y = ").append(this.last_y).toString());
            return 0.0f;
        }
        return f3;
    }

    /* access modifiers changed from: protected */
    public final float poll() throws IOException {
        this.last_x = LinuxControllers.poll(this.component_x);
        this.last_y = LinuxControllers.poll(this.component_y);
        return convertValue(0.0f, null);
    }
}
