package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.FourRegisterDecodedInstruction */
public final class FourRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a */
    private final int f172a;

    /* renamed from: b */
    private final int f173b;

    /* renamed from: c */
    private final int f174c;

    /* renamed from: d */
    private final int f175d;

    public FourRegisterDecodedInstruction(InstructionCodec instructionCodec, int i, int i2, IndexType indexType, int i3, long j, int i4, int i5, int i6, int i7) {
        int i8 = i4;
        int i9 = i5;
        int i10 = i6;
        int i11 = i7;
        super(instructionCodec, i, i2, indexType, i3, j);
        this.f172a = i8;
        this.f173b = i9;
        this.f174c = i10;
        this.f175d = i11;
    }

    public int getA() {
        return this.f172a;
    }

    public int getB() {
        return this.f173b;
    }

    public int getC() {
        return this.f174c;
    }

    public int getD() {
        return this.f175d;
    }

    public int getRegisterCount() {
        return 4;
    }

    public DecodedInstruction withIndex(int i) {
        FourRegisterDecodedInstruction fourRegisterDecodedInstruction;
        FourRegisterDecodedInstruction fourRegisterDecodedInstruction2 = fourRegisterDecodedInstruction;
        FourRegisterDecodedInstruction fourRegisterDecodedInstruction3 = new FourRegisterDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral(), this.f172a, this.f173b, this.f174c, this.f175d);
        return fourRegisterDecodedInstruction2;
    }
}
