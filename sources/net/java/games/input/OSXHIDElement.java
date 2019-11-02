package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;

final class OSXHIDElement {
    private final OSXHIDDevice device;
    private final long element_cookie;
    private final ElementType element_type;
    private final Identifier identifier = computeIdentifier();
    private final boolean is_relative;
    private final int max;
    private final int min;
    private final UsagePair usage_pair;

    public OSXHIDElement(OSXHIDDevice oSXHIDDevice, UsagePair usagePair, long j, ElementType elementType, int i, int i2, boolean z) {
        UsagePair usagePair2 = usagePair;
        long j2 = j;
        ElementType elementType2 = elementType;
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        this.device = oSXHIDDevice;
        this.usage_pair = usagePair2;
        this.element_cookie = j2;
        this.element_type = elementType2;
        this.min = i3;
        this.max = i4;
        this.is_relative = z2;
    }

    private final Identifier computeIdentifier() {
        if (this.usage_pair.getUsagePage() == UsagePage.GENERIC_DESKTOP) {
            return ((GenericDesktopUsage) this.usage_pair.getUsage()).getIdentifier();
        }
        if (this.usage_pair.getUsagePage() == UsagePage.BUTTON) {
            return ((ButtonUsage) this.usage_pair.getUsage()).getIdentifier();
        }
        if (this.usage_pair.getUsagePage() == UsagePage.KEYBOARD_OR_KEYPAD) {
            return ((KeyboardUsage) this.usage_pair.getUsage()).getIdentifier();
        }
        return null;
    }

    private UsagePair getUsagePair() {
        return this.usage_pair;
    }

    /* access modifiers changed from: 0000 */
    public final float convertValue(float f) {
        float f2 = f;
        float f3 = 1.0f;
        if (this.identifier == Axis.POV) {
            switch ((int) f2) {
                case 0:
                    return 0.25f;
                case 1:
                    return 0.375f;
                case 2:
                    return 0.5f;
                case 3:
                    return 0.625f;
                case 4:
                    return 0.75f;
                case 5:
                    return 0.875f;
                case 6:
                    break;
                case 7:
                    return 0.125f;
                case 8:
                    return 0.0f;
                default:
                    f3 = 0.0f;
                    break;
            }
            return f3;
        } else if (!(this.identifier instanceof Axis) || this.is_relative) {
            return f2;
        } else {
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
    }

    /* access modifiers changed from: 0000 */
    public final long getCookie() {
        return this.element_cookie;
    }

    /* access modifiers changed from: 0000 */
    public final void getElementValue(OSXEvent oSXEvent) throws IOException {
        this.device.getElementValue(this.element_cookie, oSXEvent);
    }

    /* access modifiers changed from: 0000 */
    public final Identifier getIdentifier() {
        return this.identifier;
    }

    /* access modifiers changed from: 0000 */
    public final ElementType getType() {
        return this.element_type;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isAnalog() {
        return (this.identifier instanceof Axis) && this.identifier != Axis.POV;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isRelative() {
        return this.is_relative && (this.identifier instanceof Axis);
    }
}
