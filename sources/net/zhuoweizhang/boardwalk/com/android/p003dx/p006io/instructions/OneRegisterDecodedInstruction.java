package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.OneRegisterDecodedInstruction */
public final class OneRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a */
    private final int f176a;

    public OneRegisterDecodedInstruction(InstructionCodec instructionCodec, int i, int i2, IndexType indexType, int i3, long j, int i4) {
        int i5 = i4;
        super(instructionCodec, i, i2, indexType, i3, j);
        this.f176a = i5;
    }

    public int getA() {
        return this.f176a;
    }

    public int getRegisterCount() {
        return 1;
    }

    public DecodedInstruction withIndex(int i) {
        OneRegisterDecodedInstruction oneRegisterDecodedInstruction;
        OneRegisterDecodedInstruction oneRegisterDecodedInstruction2 = oneRegisterDecodedInstruction;
        OneRegisterDecodedInstruction oneRegisterDecodedInstruction3 = new OneRegisterDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral(), this.f176a);
        return oneRegisterDecodedInstruction2;
    }
}
