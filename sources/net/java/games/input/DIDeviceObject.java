package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;

final class DIDeviceObject {
    private static final int WHEEL_SCALE = 120;
    private final int deadzone;
    private final IDirectInputDevice device;
    private final int flags;
    private final int format_offset;
    private final byte[] guid;
    private final int guid_type;

    /* renamed from: id */
    private final Identifier f99id;
    private final int identifier;
    private final int instance;
    private int last_event_value;
    private int last_poll_value;
    private final long max;
    private final long min;
    private final String name;
    private final int type;

    public DIDeviceObject(IDirectInputDevice iDirectInputDevice, Identifier identifier2, byte[] bArr, int i, int i2, int i3, int i4, int i5, String str, int i6) throws IOException {
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        Identifier identifier3 = identifier2;
        byte[] bArr2 = bArr;
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        String str2 = str;
        int i12 = i6;
        this.device = iDirectInputDevice2;
        this.f99id = identifier3;
        this.guid = bArr2;
        this.identifier = i8;
        this.type = i9;
        this.instance = i10;
        this.guid_type = i7;
        this.flags = i11;
        this.name = str2;
        this.format_offset = i12;
        if (!isAxis() || isRelative()) {
            this.min = -2147483648L;
            this.max = 2147483647L;
            this.deadzone = 0;
            return;
        }
        long[] rangeProperty = iDirectInputDevice2.getRangeProperty(i8);
        this.min = rangeProperty[0];
        this.max = rangeProperty[1];
        this.deadzone = iDirectInputDevice2.getDeadzoneProperty(i8);
    }

    public final float convertValue(float f) {
        float f2 = f;
        float f3 = 1.0f;
        if (getDevice().getType() == 18 && this.f99id == Axis.f33Z) {
            f3 = f2 / 120.0f;
        } else if (isButton()) {
            if ((128 & ((int) f2)) == 0) {
                return 0.0f;
            }
        } else if (this.f99id != Axis.POV) {
            return (!isAxis() || isRelative()) ? f2 : ((2.0f * (f2 - ((float) this.min))) / ((float) (this.max - this.min))) - 1.0f;
        } else {
            int i = (int) f2;
            if ((i & 65535) == 65535) {
                return 0.0f;
            }
            if (i >= 0 && i < 2250) {
                return 0.25f;
            }
            if (i < 6750) {
                return 0.375f;
            }
            if (i < 11250) {
                return 0.5f;
            }
            if (i < 15750) {
                return 0.625f;
            }
            if (i < 20250) {
                return 0.75f;
            }
            if (i < 24750) {
                return 0.875f;
            }
            if (i >= 29250) {
                return i < 33750 ? 0.125f : 0.25f;
            }
        }
        return f3;
    }

    public final int getDIIdentifier() {
        return this.identifier;
    }

    public final float getDeadzone() {
        return (float) this.deadzone;
    }

    public final IDirectInputDevice getDevice() {
        return this.device;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final int getFormatOffset() {
        return this.format_offset;
    }

    public final byte[] getGUID() {
        return this.guid;
    }

    public final int getGUIDType() {
        return this.guid_type;
    }

    public final Identifier getIdentifier() {
        return this.f99id;
    }

    public final int getInstance() {
        return this.instance;
    }

    public final long getMax() {
        return this.max;
    }

    public final long getMin() {
        return this.min;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRelativeEventValue(int i) {
        int i2 = i;
        synchronized (this) {
            try {
                th = this.device.areAxesRelative();
                if (!th) {
                    int i3 = i2 - this.last_event_value;
                    this.last_event_value = i2;
                    i2 = i3;
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return i2;
    }

    public final int getRelativePollValue(int i) {
        int i2 = i;
        synchronized (this) {
            try {
                th = this.device.areAxesRelative();
                if (!th) {
                    int i3 = i2 - this.last_poll_value;
                    this.last_poll_value = i2;
                    i2 = i3;
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return i2;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isAnalog() {
        return isAxis() && this.f99id != Axis.POV;
    }

    public final boolean isAxis() {
        return (3 & this.type) != 0;
    }

    public final boolean isButton() {
        return (12 & this.type) != 0;
    }

    public final boolean isRelative() {
        return isAxis() && (1 & this.type) != 0;
    }
}
