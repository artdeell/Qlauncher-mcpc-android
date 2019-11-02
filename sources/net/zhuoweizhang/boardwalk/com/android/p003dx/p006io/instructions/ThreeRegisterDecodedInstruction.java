package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.ThreeRegisterDecodedInstruction */
public final class ThreeRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a */
    private final int f178a;

    /* renamed from: b */
    private final int f179b;

    /* renamed from: c */
    private final int f180c;

    public ThreeRegisterDecodedInstruction(InstructionCodec instructionCodec, int i, int i2, IndexType indexType, int i3, long j, int i4, int i5, int i6) {
        int i7 = i4;
        int i8 = i5;
        int i9 = i6;
        super(instructionCodec, i, i2, indexType, i3, j);
        this.f178a = i7;
        this.f179b = i8;
        this.f180c = i9;
    }

    public int getA() {
        return this.f178a;
    }

    public int getB() {
        return this.f179b;
    }

    public int getC() {
        return this.f180c;
    }

    public int getRegisterCount() {
        return 3;
    }

    public DecodedInstruction withIndex(int i) {
        ThreeRegisterDecodedInstruction threeRegisterDecodedInstruction;
        ThreeRegisterDecodedInstruction threeRegisterDecodedInstruction2 = threeRegisterDecodedInstruction;
        ThreeRegisterDecodedInstruction threeRegisterDecodedInstruction3 = new ThreeRegisterDecodedInstruction(getFormat(), getOpcode(), i, getIndexType(), getTarget(), getLiteral(), this.f178a, this.f179b, this.f180c);
        return threeRegisterDecodedInstruction2;
    }
}
