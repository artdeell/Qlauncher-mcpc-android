package net.java.games.input;

final class LinuxAxisDescriptor {
    private int code;
    private int type;

    LinuxAxisDescriptor() {
    }

    public final boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof LinuxAxisDescriptor) {
            LinuxAxisDescriptor linuxAxisDescriptor = (LinuxAxisDescriptor) obj2;
            if (linuxAxisDescriptor.type == this.type && linuxAxisDescriptor.code == this.code) {
                return true;
            }
        }
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.type ^ this.code;
    }

    public final void set(int i, int i2) {
        int i3 = i2;
        this.type = i;
        this.code = i3;
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("LinuxAxis: type = 0x").append(Integer.toHexString(this.type)).append(", code = 0x").append(Integer.toHexString(this.code)).toString();
    }
}
