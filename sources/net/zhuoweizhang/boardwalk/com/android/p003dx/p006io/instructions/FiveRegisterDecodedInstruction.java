package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.FiveRegisterDecodedInstruction */
public final class FiveRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a */
    private final int f167a;

    /* renamed from: b */
    private final int f168b;

    /* renamed from: c */
    private final int f169c;

    /* renamed from: d */
    private final int f170d;

    /* renamed from: e */
    private final int f171e;

    public FiveRegisterDecodedInstruction(InstructionCodec instructionCodec, int i, int i2, IndexType indexType, int i3, long j, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i4;
        int i10 = i5;
        int i11 = i6;
        int i12 = i7;
        int i13 = i8;
        super(instructionCodec, i, i2, indexType, i3, j);
        this.f167a = i9;
        this.f168b = i10;
        this.f169c = i11;
        this.f170d = i12;
        this.f171e = i13;
    }

    public int getA() {
        return this.f167a;
    }

    public int getB() {
        return this.f168b;
    }

    public int getC() {
        return this.f169c;
    }

    public int getD() {
        return this.f170d;
    }

    public int getE() {
        return this.f171e;
    }

    public int getRegisterCount() {
        return 5;
    }

    public DecodedInstruction withIndex(int i) {
        FiveRegisterDecodedInstruction fiveRegisterDecodedInstruction;
        FiveRegisterDecodedInstruction fiveRegisterDecodedInstruction2 = fiveRegisterDecodedInstruction;
        FiveRegisterDecodedInstruction fiveRegisterDecodedInstruction3 = new FiveRegisterDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral(), this.f167a, this.f168b, this.f169c, this.f170d, this.f171e);
        return fiveRegisterDecodedInstruction2;
    }
}
