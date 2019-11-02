package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.TwoRegisterDecodedInstruction */
public final class TwoRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a */
    private final int f181a;

    /* renamed from: b */
    private final int f182b;

    public TwoRegisterDecodedInstruction(InstructionCodec instructionCodec, int i, int i2, IndexType indexType, int i3, long j, int i4, int i5) {
        int i6 = i4;
        int i7 = i5;
        super(instructionCodec, i, i2, indexType, i3, j);
        this.f181a = i6;
        this.f182b = i7;
    }

    public int getA() {
        return this.f181a;
    }

    public int getB() {
        return this.f182b;
    }

    public int getRegisterCount() {
        return 2;
    }

    public DecodedInstruction withIndex(int i) {
        TwoRegisterDecodedInstruction twoRegisterDecodedInstruction;
        TwoRegisterDecodedInstruction twoRegisterDecodedInstruction2 = twoRegisterDecodedInstruction;
        TwoRegisterDecodedInstruction twoRegisterDecodedInstruction3 = new TwoRegisterDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral(), this.f181a, this.f182b);
        return twoRegisterDecodedInstruction2;
    }
}
