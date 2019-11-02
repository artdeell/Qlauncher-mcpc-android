package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.ZeroRegisterDecodedInstruction */
public final class ZeroRegisterDecodedInstruction extends DecodedInstruction {
    public ZeroRegisterDecodedInstruction(InstructionCodec instructionCodec, int i, int i2, IndexType indexType, int i3, long j) {
        super(instructionCodec, i, i2, indexType, i3, j);
    }

    public int getRegisterCount() {
        return 0;
    }

    public DecodedInstruction withIndex(int i) {
        ZeroRegisterDecodedInstruction zeroRegisterDecodedInstruction;
        ZeroRegisterDecodedInstruction zeroRegisterDecodedInstruction2 = zeroRegisterDecodedInstruction;
        ZeroRegisterDecodedInstruction zeroRegisterDecodedInstruction3 = new ZeroRegisterDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral());
        return zeroRegisterDecodedInstruction2;
    }
}
