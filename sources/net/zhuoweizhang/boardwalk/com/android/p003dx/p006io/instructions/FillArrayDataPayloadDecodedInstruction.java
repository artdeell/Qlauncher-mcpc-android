package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.FillArrayDataPayloadDecodedInstruction */
public final class FillArrayDataPayloadDecodedInstruction extends DecodedInstruction {
    private final Object data;
    private final int elementWidth;
    private final int size;

    private FillArrayDataPayloadDecodedInstruction(InstructionCodec instructionCodec, int i, Object obj, int i2, int i3) {
        Object obj2 = obj;
        int i4 = i2;
        int i5 = i3;
        super(instructionCodec, i, 0, null, 0, 0);
        this.data = obj2;
        this.size = i4;
        this.elementWidth = i5;
    }

    public FillArrayDataPayloadDecodedInstruction(InstructionCodec instructionCodec, int i, byte[] bArr) {
        byte[] bArr2 = bArr;
        this(instructionCodec, i, bArr2, bArr2.length, 1);
    }

    public FillArrayDataPayloadDecodedInstruction(InstructionCodec instructionCodec, int i, int[] iArr) {
        int[] iArr2 = iArr;
        this(instructionCodec, i, iArr2, iArr2.length, 4);
    }

    public FillArrayDataPayloadDecodedInstruction(InstructionCodec instructionCodec, int i, long[] jArr) {
        long[] jArr2 = jArr;
        this(instructionCodec, i, jArr2, jArr2.length, 8);
    }

    public FillArrayDataPayloadDecodedInstruction(InstructionCodec instructionCodec, int i, short[] sArr) {
        short[] sArr2 = sArr;
        this(instructionCodec, i, sArr2, sArr2.length, 2);
    }

    public Object getData() {
        return this.data;
    }

    public short getElementWidthUnit() {
        return (short) this.elementWidth;
    }

    public int getRegisterCount() {
        return 0;
    }

    public int getSize() {
        return this.size;
    }

    public DecodedInstruction withIndex(int i) {
        UnsupportedOperationException unsupportedOperationException;
        int i2 = i;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("no index in instruction");
        throw unsupportedOperationException2;
    }
}
