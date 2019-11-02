package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstKnownNull;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteral64;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.InsnFormat */
public abstract class InsnFormat {
    public static boolean ALLOW_EXTENDED_OPCODES = true;

    public InsnFormat() {
    }

    protected static int argIndex(DalvInsn dalvInsn) {
        IllegalArgumentException illegalArgumentException;
        int value = ((CstInteger) ((CstInsn) dalvInsn).getConstant()).getValue();
        if (value >= 0) {
            return value;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus insn");
        throw illegalArgumentException2;
    }

    protected static String branchComment(DalvInsn dalvInsn) {
        int targetOffset = ((TargetInsn) dalvInsn).getTargetOffset();
        return targetOffset == ((short) targetOffset) ? Hex.m47s2(targetOffset) : Hex.m48s4(targetOffset);
    }

    protected static String branchString(DalvInsn dalvInsn) {
        int targetAddress = ((TargetInsn) dalvInsn).getTargetAddress();
        return targetAddress == ((char) targetAddress) ? Hex.m51u2(targetAddress) : Hex.m53u4(targetAddress);
    }

    protected static short codeUnit(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i3 = i;
        int i4 = i2;
        if ((i3 & 255) != i3) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("low out of range 0..255");
            throw illegalArgumentException3;
        } else if ((i4 & 255) == i4) {
            return (short) (i3 | (i4 << 8));
        } else {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("high out of range 0..255");
            throw illegalArgumentException5;
        }
    }

    protected static short codeUnit(int i, int i2, int i3, int i4) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if ((i5 & 15) != i5) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException4;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("n0 out of range 0..15");
            throw illegalArgumentException5;
        } else if ((i6 & 15) != i6) {
            IllegalArgumentException illegalArgumentException7 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException("n1 out of range 0..15");
            throw illegalArgumentException7;
        } else if ((i7 & 15) != i7) {
            IllegalArgumentException illegalArgumentException9 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("n2 out of range 0..15");
            throw illegalArgumentException9;
        } else if ((i8 & 15) == i8) {
            return (short) (i5 | (i6 << 4) | (i7 << 8) | (i8 << 12));
        } else {
            IllegalArgumentException illegalArgumentException11 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException("n3 out of range 0..15");
            throw illegalArgumentException11;
        }
    }

    protected static String cstComment(DalvInsn dalvInsn) {
        StringBuilder sb;
        CstInsn cstInsn = (CstInsn) dalvInsn;
        if (!cstInsn.hasIndex()) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(20);
        StringBuilder sb4 = sb2;
        int index = cstInsn.getIndex();
        StringBuilder append = sb4.append(cstInsn.getConstant().typeName());
        StringBuilder append2 = sb4.append('@');
        if (index < 65536) {
            StringBuilder append3 = sb4.append(Hex.m51u2(index));
        } else {
            StringBuilder append4 = sb4.append(Hex.m53u4(index));
        }
        return sb4.toString();
    }

    protected static String cstString(DalvInsn dalvInsn) {
        Constant constant = ((CstInsn) dalvInsn).getConstant();
        return constant instanceof CstString ? ((CstString) constant).toQuoted() : constant.toHuman();
    }

    protected static boolean isRegListSequential(RegisterSpecList registerSpecList) {
        RegisterSpecList registerSpecList2 = registerSpecList;
        int size = registerSpecList2.size();
        if (size >= 2) {
            int reg = registerSpecList2.get(0).getReg();
            for (int i = 0; i < size; i++) {
                RegisterSpec registerSpec = registerSpecList2.get(i);
                if (registerSpec.getReg() != reg) {
                    return false;
                }
                reg += registerSpec.getCategory();
            }
        }
        return true;
    }

    protected static String literalBitsComment(CstLiteralBits cstLiteralBits, int i) {
        StringBuffer stringBuffer;
        RuntimeException runtimeException;
        CstLiteralBits cstLiteralBits2 = cstLiteralBits;
        int i2 = i;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(20);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append("#");
        long intBits = cstLiteralBits2 instanceof CstLiteral64 ? ((CstLiteral64) cstLiteralBits2).getLongBits() : (long) cstLiteralBits2.getIntBits();
        switch (i2) {
            case 4:
                StringBuffer append2 = stringBuffer4.append(Hex.uNibble((int) intBits));
                break;
            case 8:
                StringBuffer append3 = stringBuffer4.append(Hex.m50u1((int) intBits));
                break;
            case 16:
                StringBuffer append4 = stringBuffer4.append(Hex.m51u2((int) intBits));
                break;
            case 32:
                StringBuffer append5 = stringBuffer4.append(Hex.m53u4((int) intBits));
                break;
            case 64:
                StringBuffer append6 = stringBuffer4.append(Hex.m54u8(intBits));
                break;
            default:
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
                throw runtimeException2;
        }
        return stringBuffer4.toString();
    }

    protected static String literalBitsString(CstLiteralBits cstLiteralBits) {
        StringBuffer stringBuffer;
        CstLiteralBits cstLiteralBits2 = cstLiteralBits;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append('#');
        if (cstLiteralBits2 instanceof CstKnownNull) {
            StringBuffer append2 = stringBuffer4.append("null");
        } else {
            StringBuffer append3 = stringBuffer4.append(cstLiteralBits2.typeName());
            StringBuffer append4 = stringBuffer4.append(' ');
            StringBuffer append5 = stringBuffer4.append(cstLiteralBits2.toHuman());
        }
        return stringBuffer4.toString();
    }

    protected static int makeByte(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i3 = i;
        int i4 = i2;
        if ((i3 & 15) != i3) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("low out of range 0..15");
            throw illegalArgumentException3;
        } else if ((i4 & 15) == i4) {
            return i3 | (i4 << 4);
        } else {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("high out of range 0..15");
            throw illegalArgumentException5;
        }
    }

    protected static short opcodeUnit(DalvInsn dalvInsn) {
        IllegalArgumentException illegalArgumentException;
        int opcode = dalvInsn.getOpcode().getOpcode();
        if (opcode >= 256 && opcode <= 65535) {
            return (short) opcode;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("opcode out of range 0..65535");
        throw illegalArgumentException2;
    }

    protected static short opcodeUnit(DalvInsn dalvInsn, int i) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        DalvInsn dalvInsn2 = dalvInsn;
        int i2 = i;
        if ((i2 & 255) != i2) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("arg out of range 0..255");
            throw illegalArgumentException3;
        }
        int opcode = dalvInsn2.getOpcode().getOpcode();
        if ((opcode & 255) == opcode) {
            return (short) (opcode | (i2 << 8));
        }
        IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("opcode out of range 0..255");
        throw illegalArgumentException5;
    }

    protected static String regListString(RegisterSpecList registerSpecList) {
        StringBuffer stringBuffer;
        RegisterSpecList registerSpecList2 = registerSpecList;
        int size = registerSpecList2.size();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(2 + (size * 5));
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append('{');
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                StringBuffer append2 = stringBuffer4.append(", ");
            }
            StringBuffer append3 = stringBuffer4.append(registerSpecList2.get(i).regString());
        }
        StringBuffer append4 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }

    protected static String regRangeString(RegisterSpecList registerSpecList) {
        StringBuilder sb;
        RegisterSpecList registerSpecList2 = registerSpecList;
        int size = registerSpecList2.size();
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(30);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("{");
        switch (size) {
            case 0:
                break;
            case 1:
                StringBuilder append2 = sb4.append(registerSpecList2.get(0).regString());
                break;
            default:
                RegisterSpec registerSpec = registerSpecList2.get(size - 1);
                if (registerSpec.getCategory() == 2) {
                    registerSpec = registerSpec.withOffset(1);
                }
                StringBuilder append3 = sb4.append(registerSpecList2.get(0).regString());
                StringBuilder append4 = sb4.append("..");
                StringBuilder append5 = sb4.append(registerSpec.regString());
                break;
        }
        StringBuilder append6 = sb4.append("}");
        return sb4.toString();
    }

    protected static boolean signedFitsInByte(int i) {
        int i2 = i;
        return ((byte) i2) == i2;
    }

    protected static boolean signedFitsInNibble(int i) {
        int i2 = i;
        return i2 >= -8 && i2 <= 7;
    }

    protected static boolean signedFitsInShort(int i) {
        int i2 = i;
        return ((short) i2) == i2;
    }

    protected static boolean unsignedFitsInByte(int i) {
        int i2 = i;
        return i2 == (i2 & 255);
    }

    protected static boolean unsignedFitsInNibble(int i) {
        int i2 = i;
        return i2 == (i2 & 15);
    }

    protected static boolean unsignedFitsInShort(int i) {
        int i2 = i;
        return i2 == (65535 & i2);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s) {
        annotatedOutput.writeShort(s);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s, int i) {
        int i2 = i;
        write(annotatedOutput, s, (short) i2, (short) (i2 >> 16));
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s, int i, short s2) {
        int i2 = i;
        write(annotatedOutput, s, (short) i2, (short) (i2 >> 16), s2);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s, int i, short s2, short s3) {
        int i2 = i;
        write(annotatedOutput, s, (short) i2, (short) (i2 >> 16), s2, s3);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s, long j) {
        long j2 = j;
        write(annotatedOutput, s, (short) ((int) j2), (short) ((int) (j2 >> 16)), (short) ((int) (j2 >> 32)), (short) ((int) (j2 >> 48)));
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s, short s2) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        short s3 = s2;
        annotatedOutput2.writeShort(s);
        annotatedOutput2.writeShort(s3);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s, short s2, short s3) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        short s4 = s2;
        short s5 = s3;
        annotatedOutput2.writeShort(s);
        annotatedOutput2.writeShort(s4);
        annotatedOutput2.writeShort(s5);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s, short s2, short s3, short s4) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        short s5 = s2;
        short s6 = s3;
        short s7 = s4;
        annotatedOutput2.writeShort(s);
        annotatedOutput2.writeShort(s5);
        annotatedOutput2.writeShort(s6);
        annotatedOutput2.writeShort(s7);
    }

    protected static void write(AnnotatedOutput annotatedOutput, short s, short s2, short s3, short s4, short s5) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        short s6 = s2;
        short s7 = s3;
        short s8 = s4;
        short s9 = s5;
        annotatedOutput2.writeShort(s);
        annotatedOutput2.writeShort(s6);
        annotatedOutput2.writeShort(s7);
        annotatedOutput2.writeShort(s8);
        annotatedOutput2.writeShort(s9);
    }

    public boolean branchFits(TargetInsn targetInsn) {
        TargetInsn targetInsn2 = targetInsn;
        return false;
    }

    public abstract int codeSize();

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        BitSet bitSet;
        DalvInsn dalvInsn2 = dalvInsn;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet();
        return bitSet2;
    }

    public abstract String insnArgString(DalvInsn dalvInsn);

    public abstract String insnCommentString(DalvInsn dalvInsn, boolean z);

    public abstract boolean isCompatible(DalvInsn dalvInsn);

    public final String listingString(DalvInsn dalvInsn, boolean z) {
        StringBuilder sb;
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z2 = z;
        String name = dalvInsn2.getOpcode().getName();
        String insnArgString = insnArgString(dalvInsn2);
        String insnCommentString = insnCommentString(dalvInsn2, z2);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(100);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(name);
        if (insnArgString.length() != 0) {
            StringBuilder append2 = sb4.append(' ');
            StringBuilder append3 = sb4.append(insnArgString);
        }
        if (insnCommentString.length() != 0) {
            StringBuilder append4 = sb4.append(" // ");
            StringBuilder append5 = sb4.append(insnCommentString);
        }
        return sb4.toString();
    }

    public abstract void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn);
}
