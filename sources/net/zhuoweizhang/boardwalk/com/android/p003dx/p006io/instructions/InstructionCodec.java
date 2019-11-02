package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import android.support.p000v4.view.InputDeviceCompat;
import java.io.EOFException;
import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.IndexType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.OpcodeInfo;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.InstructionCodec */
public enum InstructionCodec {
    ;

    /* access modifiers changed from: private */
    public static short asUnsignedUnit(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if ((-65536 & i2) == 0) {
            return (short) i2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus unsigned code unit");
        throw illegalArgumentException2;
    }

    /* access modifiers changed from: private */
    public static int byte0(int i) {
        return i & 255;
    }

    /* access modifiers changed from: private */
    public static int byte1(int i) {
        return 255 & (i >> 8);
    }

    private static int byte2(int i) {
        return 255 & (i >> 16);
    }

    private static int byte3(int i) {
        return i >>> 24;
    }

    /* access modifiers changed from: private */
    public static short codeUnit(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i3 = i;
        int i4 = i2;
        if ((i3 & InputDeviceCompat.SOURCE_ANY) != 0) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("bogus lowByte");
            throw illegalArgumentException3;
        } else if ((i4 & InputDeviceCompat.SOURCE_ANY) == 0) {
            return (short) (i3 | (i4 << 8));
        } else {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("bogus highByte");
            throw illegalArgumentException5;
        }
    }

    private static short codeUnit(int i, int i2, int i3, int i4) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if ((i5 & -16) != 0) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException4;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("bogus nibble0");
            throw illegalArgumentException5;
        } else if ((i6 & -16) != 0) {
            IllegalArgumentException illegalArgumentException7 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException("bogus nibble1");
            throw illegalArgumentException7;
        } else if ((i7 & -16) != 0) {
            IllegalArgumentException illegalArgumentException9 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("bogus nibble2");
            throw illegalArgumentException9;
        } else if ((i8 & -16) == 0) {
            return (short) (i5 | (i6 << 4) | (i7 << 8) | (i8 << 12));
        } else {
            IllegalArgumentException illegalArgumentException11 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException("bogus nibble3");
            throw illegalArgumentException11;
        }
    }

    /* access modifiers changed from: private */
    public static DecodedInstruction decodeRegisterList(InstructionCodec instructionCodec, int i, CodeInput codeInput) throws EOFException {
        FiveRegisterDecodedInstruction fiveRegisterDecodedInstruction;
        FourRegisterDecodedInstruction fourRegisterDecodedInstruction;
        ThreeRegisterDecodedInstruction threeRegisterDecodedInstruction;
        TwoRegisterDecodedInstruction twoRegisterDecodedInstruction;
        OneRegisterDecodedInstruction oneRegisterDecodedInstruction;
        ZeroRegisterDecodedInstruction zeroRegisterDecodedInstruction;
        DexException dexException;
        StringBuilder sb;
        InstructionCodec instructionCodec2 = instructionCodec;
        int i2 = i;
        CodeInput codeInput2 = codeInput;
        int byte0 = byte0(i2);
        int nibble2 = nibble2(i2);
        int nibble3 = nibble3(i2);
        int read = codeInput2.read();
        int read2 = codeInput2.read();
        int nibble0 = nibble0(read2);
        int nibble1 = nibble1(read2);
        int nibble22 = nibble2(read2);
        int nibble32 = nibble3(read2);
        IndexType indexType = OpcodeInfo.getIndexType(byte0);
        switch (nibble3) {
            case 0:
                ZeroRegisterDecodedInstruction zeroRegisterDecodedInstruction2 = zeroRegisterDecodedInstruction;
                ZeroRegisterDecodedInstruction zeroRegisterDecodedInstruction3 = new ZeroRegisterDecodedInstruction(instructionCodec2, byte0, read, indexType, 0, 0);
                return zeroRegisterDecodedInstruction2;
            case 1:
                OneRegisterDecodedInstruction oneRegisterDecodedInstruction2 = oneRegisterDecodedInstruction;
                OneRegisterDecodedInstruction oneRegisterDecodedInstruction3 = new OneRegisterDecodedInstruction(instructionCodec2, byte0, read, indexType, 0, 0, nibble0);
                return oneRegisterDecodedInstruction2;
            case 2:
                TwoRegisterDecodedInstruction twoRegisterDecodedInstruction2 = twoRegisterDecodedInstruction;
                TwoRegisterDecodedInstruction twoRegisterDecodedInstruction3 = new TwoRegisterDecodedInstruction(instructionCodec2, byte0, read, indexType, 0, 0, nibble0, nibble1);
                return twoRegisterDecodedInstruction2;
            case 3:
                ThreeRegisterDecodedInstruction threeRegisterDecodedInstruction2 = threeRegisterDecodedInstruction;
                ThreeRegisterDecodedInstruction threeRegisterDecodedInstruction3 = new ThreeRegisterDecodedInstruction(instructionCodec2, byte0, read, indexType, 0, 0, nibble0, nibble1, nibble22);
                return threeRegisterDecodedInstruction2;
            case 4:
                FourRegisterDecodedInstruction fourRegisterDecodedInstruction2 = fourRegisterDecodedInstruction;
                FourRegisterDecodedInstruction fourRegisterDecodedInstruction3 = new FourRegisterDecodedInstruction(instructionCodec2, byte0, read, indexType, 0, 0, nibble0, nibble1, nibble22, nibble32);
                return fourRegisterDecodedInstruction2;
            case 5:
                FiveRegisterDecodedInstruction fiveRegisterDecodedInstruction2 = fiveRegisterDecodedInstruction;
                FiveRegisterDecodedInstruction fiveRegisterDecodedInstruction3 = new FiveRegisterDecodedInstruction(instructionCodec2, byte0, read, indexType, 0, 0, nibble0, nibble1, nibble22, nibble32, nibble2);
                return fiveRegisterDecodedInstruction2;
            default:
                DexException dexException2 = dexException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                DexException dexException3 = new DexException(sb2.append("bogus registerCount: ").append(Hex.uNibble(nibble3)).toString());
                throw dexException2;
        }
    }

    /* access modifiers changed from: private */
    public static DecodedInstruction decodeRegisterRange(InstructionCodec instructionCodec, int i, CodeInput codeInput) throws EOFException {
        RegisterRangeDecodedInstruction registerRangeDecodedInstruction;
        InstructionCodec instructionCodec2 = instructionCodec;
        int i2 = i;
        CodeInput codeInput2 = codeInput;
        int byte0 = byte0(i2);
        int byte1 = byte1(i2);
        RegisterRangeDecodedInstruction registerRangeDecodedInstruction2 = registerRangeDecodedInstruction;
        RegisterRangeDecodedInstruction registerRangeDecodedInstruction3 = new RegisterRangeDecodedInstruction(instructionCodec2, byte0, codeInput2.read(), OpcodeInfo.getIndexType(byte0), 0, 0, codeInput2.read(), byte1);
        return registerRangeDecodedInstruction2;
    }

    /* access modifiers changed from: private */
    public static void encodeRegisterList(DecodedInstruction decodedInstruction, CodeOutput codeOutput) {
        DecodedInstruction decodedInstruction2 = decodedInstruction;
        codeOutput.write(codeUnit(decodedInstruction2.getOpcode(), makeByte(decodedInstruction2.getE(), decodedInstruction2.getRegisterCount())), decodedInstruction2.getIndexUnit(), codeUnit(decodedInstruction2.getA(), decodedInstruction2.getB(), decodedInstruction2.getC(), decodedInstruction2.getD()));
    }

    /* access modifiers changed from: private */
    public static void encodeRegisterRange(DecodedInstruction decodedInstruction, CodeOutput codeOutput) {
        DecodedInstruction decodedInstruction2 = decodedInstruction;
        codeOutput.write(codeUnit(decodedInstruction2.getOpcode(), decodedInstruction2.getRegisterCount()), decodedInstruction2.getIndexUnit(), decodedInstruction2.getAUnit());
    }

    /* access modifiers changed from: private */
    public static int makeByte(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i3 = i;
        int i4 = i2;
        if ((i3 & -16) != 0) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("bogus lowNibble");
            throw illegalArgumentException3;
        } else if ((i4 & -16) == 0) {
            return i3 | (i4 << 4);
        } else {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("bogus highNibble");
            throw illegalArgumentException5;
        }
    }

    private static int nibble0(int i) {
        return i & 15;
    }

    private static int nibble1(int i) {
        return 15 & (i >> 4);
    }

    /* access modifiers changed from: private */
    public static int nibble2(int i) {
        return 15 & (i >> 8);
    }

    /* access modifiers changed from: private */
    public static int nibble3(int i) {
        return 15 & (i >> 12);
    }

    /* access modifiers changed from: private */
    public static short unit0(int i) {
        return (short) i;
    }

    /* access modifiers changed from: private */
    public static short unit0(long j) {
        return (short) ((int) j);
    }

    /* access modifiers changed from: private */
    public static short unit1(int i) {
        return (short) (i >> 16);
    }

    /* access modifiers changed from: private */
    public static short unit1(long j) {
        return (short) ((int) (j >> 16));
    }

    /* access modifiers changed from: private */
    public static short unit2(long j) {
        return (short) ((int) (j >> 32));
    }

    /* access modifiers changed from: private */
    public static short unit3(long j) {
        return (short) ((int) (j >> 48));
    }

    public abstract DecodedInstruction decode(int i, CodeInput codeInput) throws EOFException;

    public abstract void encode(DecodedInstruction decodedInstruction, CodeOutput codeOutput);
}
