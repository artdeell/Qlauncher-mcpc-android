package net.zhuoweizhang.boardwalk.com.android.dex;

public final class Code {
    private final CatchHandler[] catchHandlers;
    private final int debugInfoOffset;
    private final int insSize;
    private final short[] instructions;
    private final int outsSize;
    private final int registersSize;
    private final Try[] tries;

    public static class CatchHandler {
        final int[] addresses;
        final int catchAllAddress;
        final int offset;
        final int[] typeIndexes;

        public CatchHandler(int[] iArr, int[] iArr2, int i, int i2) {
            int[] iArr3 = iArr2;
            int i3 = i;
            int i4 = i2;
            this.typeIndexes = iArr;
            this.addresses = iArr3;
            this.catchAllAddress = i3;
            this.offset = i4;
        }

        public int[] getAddresses() {
            return this.addresses;
        }

        public int getCatchAllAddress() {
            return this.catchAllAddress;
        }

        public int getOffset() {
            return this.offset;
        }

        public int[] getTypeIndexes() {
            return this.typeIndexes;
        }
    }

    public static class Try {
        final int catchHandlerIndex;
        final int instructionCount;
        final int startAddress;

        Try(int i, int i2, int i3) {
            int i4 = i2;
            int i5 = i3;
            this.startAddress = i;
            this.instructionCount = i4;
            this.catchHandlerIndex = i5;
        }

        public int getCatchHandlerIndex() {
            return this.catchHandlerIndex;
        }

        public int getInstructionCount() {
            return this.instructionCount;
        }

        public int getStartAddress() {
            return this.startAddress;
        }
    }

    public Code(int i, int i2, int i3, int i4, short[] sArr, Try[] tryArr, CatchHandler[] catchHandlerArr) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        short[] sArr2 = sArr;
        Try[] tryArr2 = tryArr;
        CatchHandler[] catchHandlerArr2 = catchHandlerArr;
        this.registersSize = i;
        this.insSize = i5;
        this.outsSize = i6;
        this.debugInfoOffset = i7;
        this.instructions = sArr2;
        this.tries = tryArr2;
        this.catchHandlers = catchHandlerArr2;
    }

    public CatchHandler[] getCatchHandlers() {
        return this.catchHandlers;
    }

    public int getDebugInfoOffset() {
        return this.debugInfoOffset;
    }

    public int getInsSize() {
        return this.insSize;
    }

    public short[] getInstructions() {
        return this.instructions;
    }

    public int getOutsSize() {
        return this.outsSize;
    }

    public int getRegistersSize() {
        return this.registersSize;
    }

    public Try[] getTries() {
        return this.tries;
    }
}
