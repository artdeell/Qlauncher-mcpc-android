package net.java.games.input;

import net.java.games.input.Controller.PortType;

final class LinuxInputID {
    private final int bustype;
    private final int product;
    private final int vendor;
    private final int version;

    public LinuxInputID(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        this.bustype = i;
        this.vendor = i5;
        this.product = i6;
        this.version = i7;
    }

    public final PortType getPortType() {
        return LinuxNativeTypesMap.getPortType(this.bustype);
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("LinuxInputID: bustype = 0x").append(Integer.toHexString(this.bustype)).append(" | vendor = 0x").append(Integer.toHexString(this.vendor)).append(" | product = 0x").append(Integer.toHexString(this.product)).append(" | version = 0x").append(Integer.toHexString(this.version)).toString();
    }
}
