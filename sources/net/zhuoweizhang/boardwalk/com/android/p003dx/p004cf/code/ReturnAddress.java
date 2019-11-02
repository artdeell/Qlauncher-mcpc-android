package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ReturnAddress */
public final class ReturnAddress implements TypeBearer {
    private final int subroutineAddress;

    public ReturnAddress(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("subroutineAddress < 0");
            throw illegalArgumentException2;
        }
        this.subroutineAddress = i2;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        return (obj2 instanceof ReturnAddress) && this.subroutineAddress == ((ReturnAddress) obj2).subroutineAddress;
    }

    public int getBasicFrameType() {
        return Type.RETURN_ADDRESS.getBasicFrameType();
    }

    public int getBasicType() {
        return Type.RETURN_ADDRESS.getBasicType();
    }

    public TypeBearer getFrameType() {
        return this;
    }

    public int getSubroutineAddress() {
        return this.subroutineAddress;
    }

    public Type getType() {
        return Type.RETURN_ADDRESS;
    }

    public int hashCode() {
        return this.subroutineAddress;
    }

    public boolean isConstant() {
        return false;
    }

    public String toHuman() {
        return toString();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("<addr:").append(Hex.m51u2(this.subroutineAddress)).append(">").toString();
    }
}
