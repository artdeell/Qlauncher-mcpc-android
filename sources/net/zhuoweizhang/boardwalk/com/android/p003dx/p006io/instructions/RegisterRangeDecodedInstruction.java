package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.RegisterRangeDecodedInstruction */
public final class RegisterRangeDecodedInstruction extends DecodedInstruction {

    /* renamed from: a */
    private final int f177a;
    private final int registerCount;

    public RegisterRangeDecodedInstruction(InstructionCodec instructionCodec, int i, int i2, IndexType indexType, int i3, long j, int i4, int i5) {
        int i6 = i4;
        int i7 = i5;
        super(instructionCodec, i, i2, indexType, i3, j);
        this.f177a = i6;
        this.registerCount = i7;
    }

    public int getA() {
        return this.f177a;
    }

    public int getRegisterCount() {
        return this.registerCount;
    }

    public DecodedInstruction withIndex(int i) {
        RegisterRangeDecodedInstruction registerRangeDecodedInstruction;
        RegisterRangeDecodedInstruction registerRangeDecodedInstruction2 = registerRangeDecodedInstruction;
        RegisterRangeDecodedInstruction registerRangeDecodedInstruction3 = new RegisterRangeDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral(), this.f177a, this.registerCount);
        return registerRangeDecodedInstruction2;
    }
}
