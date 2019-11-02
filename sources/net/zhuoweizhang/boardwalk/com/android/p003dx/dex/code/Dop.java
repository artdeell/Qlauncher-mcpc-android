package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.OpcodeInfo;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.Opcodes;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.Dop */
public final class Dop {
    private final int family;
    private final InsnFormat format;
    private final boolean hasResult;
    private final int nextOpcode;
    private final int opcode;

    public Dop(int i, int i2, int i3, InsnFormat insnFormat, boolean z) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        InsnFormat insnFormat2 = insnFormat;
        boolean z2 = z;
        if (!Opcodes.isValidShape(i4)) {
            IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("bogus opcode");
            throw illegalArgumentException4;
        } else if (!Opcodes.isValidShape(i5)) {
            IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("bogus family");
            throw illegalArgumentException6;
        } else if (!Opcodes.isValidShape(i6)) {
            IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("bogus nextOpcode");
            throw illegalArgumentException8;
        } else if (insnFormat2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("format == null");
            throw nullPointerException2;
        } else {
            this.opcode = i4;
            this.family = i5;
            this.nextOpcode = i6;
            this.format = insnFormat2;
            this.hasResult = z2;
        }
    }

    public int getFamily() {
        return this.family;
    }

    public InsnFormat getFormat() {
        return this.format;
    }

    public String getName() {
        return OpcodeInfo.getName(this.opcode);
    }

    public int getNextOpcode() {
        return this.nextOpcode;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public Dop getOppositeTest() {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        switch (this.opcode) {
            case 50:
                return Dops.IF_NE;
            case 51:
                return Dops.IF_EQ;
            case 52:
                return Dops.IF_GE;
            case 53:
                return Dops.IF_LT;
            case 54:
                return Dops.IF_LE;
            case 55:
                return Dops.IF_GT;
            case 56:
                return Dops.IF_NEZ;
            case 57:
                return Dops.IF_EQZ;
            case 58:
                return Dops.IF_GEZ;
            case 59:
                return Dops.IF_LTZ;
            case 60:
                return Dops.IF_LEZ;
            case 61:
                return Dops.IF_GTZ;
            default:
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("bogus opcode: ").append(this).toString());
                throw illegalArgumentException2;
        }
    }

    public boolean hasResult() {
        return this.hasResult;
    }

    public String toString() {
        return getName();
    }
}
