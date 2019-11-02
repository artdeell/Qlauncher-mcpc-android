package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.SparseSwitchPayloadDecodedInstruction */
public final class SparseSwitchPayloadDecodedInstruction extends DecodedInstruction {
    private final int[] keys;
    private final int[] targets;

    public SparseSwitchPayloadDecodedInstruction(InstructionCodec instructionCodec, int i, int[] iArr, int[] iArr2) {
        IllegalArgumentException illegalArgumentException;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        super(instructionCodec, i, 0, null, 0, 0);
        if (iArr3.length != iArr4.length) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("keys/targets length mismatch");
            throw illegalArgumentException2;
        }
        this.keys = iArr3;
        this.targets = iArr4;
    }

    public int[] getKeys() {
        return this.keys;
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
