package net.java.games.input;

import java.io.IOException;

abstract class RawDeviceInfo {
    RawDeviceInfo() {
    }

    public abstract Controller createControllerFromDevice(RawDevice rawDevice, SetupAPIDevice setupAPIDevice) throws IOException;

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof RawDeviceInfo) {
            RawDeviceInfo rawDeviceInfo = (RawDeviceInfo) obj2;
            if (rawDeviceInfo.getUsage() == getUsage() && rawDeviceInfo.getUsagePage() == getUsagePage()) {
                return true;
            }
        }
        return false;
    }

    public abstract long getHandle();

    public abstract int getUsage();

    public abstract int getUsagePage();

    public final int hashCode() {
        return getUsage() ^ getUsagePage();
    }
}
