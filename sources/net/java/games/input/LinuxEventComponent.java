package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Controller.Type;

final class LinuxEventComponent {
    static final boolean $assertionsDisabled;
    static Class class$net$java$games$input$LinuxEventComponent;
    private final Type button_trait;
    private final LinuxAxisDescriptor descriptor;
    private final LinuxEventDevice device;
    private final int flat;
    private final Identifier identifier;
    private final boolean is_relative;
    private final int max;
    private final int min;

    static {
        Class cls;
        if (class$net$java$games$input$LinuxEventComponent == null) {
            cls = class$("net.java.games.input.LinuxEventComponent");
            class$net$java$games$input$LinuxEventComponent = cls;
        } else {
            cls = class$net$java$games$input$LinuxEventComponent;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
    }

    public LinuxEventComponent(LinuxEventDevice linuxEventDevice, Identifier identifier2, boolean z, int i, int i2) throws IOException {
        LinuxAxisDescriptor linuxAxisDescriptor;
        LinuxAbsInfo linuxAbsInfo;
        Identifier identifier3 = identifier2;
        boolean z2 = z;
        int i3 = i;
        int i4 = i2;
        this.device = linuxEventDevice;
        this.identifier = identifier3;
        if (i3 == 1) {
            this.button_trait = LinuxNativeTypesMap.guessButtonTrait(i4);
        } else {
            this.button_trait = Type.UNKNOWN;
        }
        this.is_relative = z2;
        LinuxAxisDescriptor linuxAxisDescriptor2 = linuxAxisDescriptor;
        LinuxAxisDescriptor linuxAxisDescriptor3 = new LinuxAxisDescriptor();
        this.descriptor = linuxAxisDescriptor2;
        this.descriptor.set(i3, i4);
        if (i3 == 3) {
            LinuxAbsInfo linuxAbsInfo2 = linuxAbsInfo;
            LinuxAbsInfo linuxAbsInfo3 = new LinuxAbsInfo();
            LinuxAbsInfo linuxAbsInfo4 = linuxAbsInfo2;
            getAbsInfo(linuxAbsInfo4);
            this.min = linuxAbsInfo4.getMin();
            this.max = linuxAbsInfo4.getMax();
            this.flat = linuxAbsInfo4.getFlat();
            return;
        }
        this.min = Integer.MIN_VALUE;
        this.max = IDirectInputDevice.DIPROPRANGE_NOMAX;
        this.flat = 0;
    }

    static Class class$(String str) {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError();
            throw noClassDefFoundError2.initCause(classNotFoundException);
        }
    }

    /* access modifiers changed from: 0000 */
    public final float convertValue(float f) {
        float f2 = f;
        if (!(this.identifier instanceof Axis) || this.is_relative) {
            return f2;
        }
        if (this.min == this.max) {
            return 0.0f;
        }
        if (f2 > ((float) this.max)) {
            f2 = (float) this.max;
        } else if (f2 < ((float) this.min)) {
            f2 = (float) this.min;
        }
        return ((2.0f * (f2 - ((float) this.min))) / ((float) (this.max - this.min))) - 1.0f;
    }

    public final void getAbsInfo(LinuxAbsInfo linuxAbsInfo) throws IOException {
        AssertionError assertionError;
        LinuxAbsInfo linuxAbsInfo2 = linuxAbsInfo;
        if ($assertionsDisabled || this.descriptor.getType() == 3) {
            this.device.getAbsInfo(this.descriptor.getCode(), linuxAbsInfo2);
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    public final Type getButtonTrait() {
        return this.button_trait;
    }

    /* access modifiers changed from: 0000 */
    public final float getDeadZone() {
        return ((float) this.flat) / (2.0f * ((float) (this.max - this.min)));
    }

    public final LinuxAxisDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final LinuxEventDevice getDevice() {
        return this.device;
    }

    public final Identifier getIdentifier() {
        return this.identifier;
    }

    public final boolean isAnalog() {
        return (this.identifier instanceof Axis) && this.identifier != Axis.POV;
    }

    public final boolean isRelative() {
        return this.is_relative;
    }
}
