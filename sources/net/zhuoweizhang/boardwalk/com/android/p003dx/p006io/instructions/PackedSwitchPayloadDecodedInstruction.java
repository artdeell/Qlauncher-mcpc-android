package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.PackedSwitchPayloadDecodedInstruction */
public final class PackedSwitchPayloadDecodedInstruction extends DecodedInstruction {
    private final int firstKey;
    private final int[] targets;

    public PackedSwitchPayloadDecodedInstruction(InstructionCodec instructionCodec, int i, int i2, int[] iArr) {
        int i3 = i2;
        int[] iArr2 = iArr;
        super(instructionCodec, i, 0, null, 0, 0);
        this.firstKey = i3;
        this.targets = iArr2;
    }

    public int getFirstKey() {
        return this.firstKey;
    }

    public int getRegisterCount() {
        return 0;
    }

    public int[] getTargets() {
        return this.targets;
    }

    public DecodedInstruction withIndex(int i) {
        UnsupportedOperationException unsupportedOperationException;
        int i2 = i;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("no index in instruction");
        throw unsupportedOperationException2;
    }
}
