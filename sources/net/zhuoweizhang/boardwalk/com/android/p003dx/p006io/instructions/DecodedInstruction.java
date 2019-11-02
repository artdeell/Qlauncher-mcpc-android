package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import android.support.p000v4.view.InputDeviceCompat;
import java.io.EOFException;
import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.OpcodeInfo;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.Opcodes;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.DecodedInstruction */
public abstract class DecodedInstruction {
    private final InstructionCodec format;
    private final int index;
    private final IndexType indexType;
    private final long literal;
    private final int opcode;
    private final int target;

    public DecodedInstruction(InstructionCodec instructionCodec, int i, int i2, IndexType indexType2, int i3, long j) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        InstructionCodec instructionCodec2 = instructionCodec;
        int i4 = i;
        int i5 = i2;
        IndexType indexType3 = indexType2;
        int i6 = i3;
        long j2 = j;
        if (instructionCodec2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("format == null");
            throw nullPointerException2;
        } else if (!Opcodes.isValidShape(i4)) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("invalid opcode");
            throw illegalArgumentException2;
        } else {
            this.format = instructionCodec2;
            this.opcode = i4;
            this.index = i5;
            this.indexType = indexType3;
            this.target = i6;
            this.literal = j2;
        }
    }

    public static DecodedInstruction decode(CodeInput codeInput) throws EOFException {
        CodeInput codeInput2 = codeInput;
        int read = codeInput2.read();
        return OpcodeInfo.getFormat(Opcodes.extractOpcodeFromUnit(read)).decode(read, codeInput2);
    }

    public static DecodedInstruction[] decodeAll(short[] sArr) {
        ShortArrayCodeInput shortArrayCodeInput;
        DexException dexException;
        short[] sArr2 = sArr;
        DecodedInstruction[] decodedInstructionArr = new DecodedInstruction[sArr2.length];
        ShortArrayCodeInput shortArrayCodeInput2 = shortArrayCodeInput;
        ShortArrayCodeInput shortArrayCodeInput3 = new ShortArrayCodeInput(sArr2);
        ShortArrayCodeInput shortArrayCodeInput4 = shortArrayCodeInput2;
        while (shortArrayCodeInput4.hasMore()) {
            try {
                decodedInstructionArr[shortArrayCodeInput4.cursor()] = decode(shortArrayCodeInput4);
            } catch (EOFException e) {
                EOFException eOFException = e;
                DexException dexException2 = dexException;
                DexException dexException3 = new DexException((Throwable) eOFException);
                throw dexException2;
            }
        }
        return decodedInstructionArr;
    }

    public final void encode(CodeOutput codeOutput) {
        this.format.encode(this, codeOutput);
    }

    public int getA() {
        return 0;
    }

    public final short getAByte() {
        DexException dexException;
        StringBuilder sb;
        int a = getA();
        if ((a & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) a;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register A out of range: ").append(Hex.m54u8((long) a)).toString());
        throw dexException2;
    }

    public final short getANibble() {
        DexException dexException;
        StringBuilder sb;
        int a = getA();
        if ((a & -16) == 0) {
            return (short) a;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register A out of range: ").append(Hex.m54u8((long) a)).toString());
        throw dexException2;
    }

    public final short getAUnit() {
        DexException dexException;
        StringBuilder sb;
        int a = getA();
        if ((-65536 & a) == 0) {
            return (short) a;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register A out of range: ").append(Hex.m54u8((long) a)).toString());
        throw dexException2;
    }

    public int getB() {
        return 0;
    }

    public final short getBByte() {
        DexException dexException;
        StringBuilder sb;
        int b = getB();
        if ((b & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) b;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register B out of range: ").append(Hex.m54u8((long) b)).toString());
        throw dexException2;
    }

    public final short getBNibble() {
        DexException dexException;
        StringBuilder sb;
        int b = getB();
        if ((b & -16) == 0) {
            return (short) b;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register B out of range: ").append(Hex.m54u8((long) b)).toString());
        throw dexException2;
    }

    public final short getBUnit() {
        DexException dexException;
        StringBuilder sb;
        int b = getB();
        if ((-65536 & b) == 0) {
            return (short) b;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register B out of range: ").append(Hex.m54u8((long) b)).toString());
        throw dexException2;
    }

    public int getC() {
        return 0;
    }

    public final short getCByte() {
        DexException dexException;
        StringBuilder sb;
        int c = getC();
        if ((c & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) c;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register C out of range: ").append(Hex.m54u8((long) c)).toString());
        throw dexException2;
    }

    public final short getCNibble() {
        DexException dexException;
        StringBuilder sb;
        int c = getC();
        if ((c & -16) == 0) {
            return (short) c;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register C out of range: ").append(Hex.m54u8((long) c)).toString());
        throw dexException2;
    }

    public final short getCUnit() {
        DexException dexException;
        StringBuilder sb;
        int c = getC();
        if ((-65536 & c) == 0) {
            return (short) c;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register C out of range: ").append(Hex.m54u8((long) c)).toString());
        throw dexException2;
    }

    public int getD() {
        return 0;
    }

    public final short getDByte() {
        DexException dexException;
        StringBuilder sb;
        int d = getD();
        if ((d & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) d;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register D out of range: ").append(Hex.m54u8((long) d)).toString());
        throw dexException2;
    }

    public final short getDNibble() {
        DexException dexException;
        StringBuilder sb;
        int d = getD();
        if ((d & -16) == 0) {
            return (short) d;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register D out of range: ").append(Hex.m54u8((long) d)).toString());
        throw dexException2;
    }

    public final short getDUnit() {
        DexException dexException;
        StringBuilder sb;
        int d = getD();
        if ((-65536 & d) == 0) {
            return (short) d;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register D out of range: ").append(Hex.m54u8((long) d)).toString());
        throw dexException2;
    }

    public int getE() {
        return 0;
    }

    public final short getENibble() {
        DexException dexException;
        StringBuilder sb;
        int e = getE();
        if ((e & -16) == 0) {
            return (short) e;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register E out of range: ").append(Hex.m54u8((long) e)).toString());
        throw dexException2;
    }

    public final InstructionCodec getFormat() {
        return this.format;
    }

    public final int getIndex() {
        return this.index;
    }

    public final IndexType getIndexType() {
        return this.indexType;
    }

    public final short getIndexUnit() {
        return (short) this.index;
    }

    public final long getLiteral() {
        return this.literal;
    }

    public final int getLiteralByte() {
        DexException dexException;
        StringBuilder sb;
        if (this.literal == ((long) ((byte) ((int) this.literal)))) {
            return 255 & ((int) this.literal);
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Literal out of range: ").append(Hex.m54u8(this.literal)).toString());
        throw dexException2;
    }

    public final int getLiteralInt() {
        DexException dexException;
        StringBuilder sb;
        if (this.literal == ((long) ((int) this.literal))) {
            return (int) this.literal;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Literal out of range: ").append(Hex.m54u8(this.literal)).toString());
        throw dexException2;
    }

    public final int getLiteralNibble() {
        DexException dexException;
        StringBuilder sb;
        if (this.literal >= -8 && this.literal <= 7) {
            return 15 & ((int) this.literal);
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Literal out of range: ").append(Hex.m54u8(this.literal)).toString());
        throw dexException2;
    }

    public final short getLiteralUnit() {
        DexException dexException;
        StringBuilder sb;
        if (this.literal == ((long) ((short) ((int) this.literal)))) {
            return (short) ((int) this.literal);
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Literal out of range: ").append(Hex.m54u8(this.literal)).toString());
        throw dexException2;
    }

    public final int getOpcode() {
        return this.opcode;
    }

    public final short getOpcodeUnit() {
        return (short) this.opcode;
    }

    public abstract int getRegisterCount();

    public final short getRegisterCountUnit() {
        DexException dexException;
        StringBuilder sb;
        int registerCount = getRegisterCount();
        if ((-65536 & registerCount) == 0) {
            return (short) registerCount;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Register count out of range: ").append(Hex.m54u8((long) registerCount)).toString());
        throw dexException2;
    }

    public final int getTarget() {
        return this.target;
    }

    public final int getTarget(int i) {
        return this.target - i;
    }

    public final int getTargetByte(int i) {
        DexException dexException;
        StringBuilder sb;
        int target2 = getTarget(i);
        if (target2 == ((byte) target2)) {
            return target2 & 255;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Target out of range: ").append(Hex.m48s4(target2)).toString());
        throw dexException2;
    }

    public final short getTargetUnit(int i) {
        DexException dexException;
        StringBuilder sb;
        int target2 = getTarget(i);
        if (target2 == ((short) target2)) {
            return (short) target2;
        }
        DexException dexException2 = dexException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        DexException dexException3 = new DexException(sb2.append("Target out of range: ").append(Hex.m48s4(target2)).toString());
        throw dexException2;
    }

    public abstract DecodedInstruction withIndex(int i);
}
