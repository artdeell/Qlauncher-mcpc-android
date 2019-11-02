package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteral32;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteral64;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.ArrayData */
public final class ArrayData extends VariableSizeInsn {
    private final Constant arrayType;
    private final int elemWidth;
    private final int initLength;
    private final CodeAddress user;
    private final ArrayList<Constant> values;

    public ArrayData(SourcePosition sourcePosition, CodeAddress codeAddress, ArrayList<Constant> arrayList, Constant constant) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        CodeAddress codeAddress2 = codeAddress;
        ArrayList<Constant> arrayList2 = arrayList;
        Constant constant2 = constant;
        super(sourcePosition, RegisterSpecList.EMPTY);
        if (codeAddress2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("user == null");
            throw nullPointerException3;
        } else if (arrayList2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("values == null");
            throw nullPointerException5;
        } else if (arrayList2.size() <= 0) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Illegal number of init values");
            throw illegalArgumentException3;
        } else {
            this.arrayType = constant2;
            if (constant2 == CstType.BYTE_ARRAY || constant2 == CstType.BOOLEAN_ARRAY) {
                this.elemWidth = 1;
            } else if (constant2 == CstType.SHORT_ARRAY || constant2 == CstType.CHAR_ARRAY) {
                this.elemWidth = 2;
            } else if (constant2 == CstType.INT_ARRAY || constant2 == CstType.FLOAT_ARRAY) {
                this.elemWidth = 4;
            } else if (constant2 == CstType.LONG_ARRAY || constant2 == CstType.DOUBLE_ARRAY) {
                this.elemWidth = 8;
            } else {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Unexpected constant type");
                throw illegalArgumentException5;
            }
            this.user = codeAddress2;
            this.values = arrayList2;
            this.initLength = arrayList2.size();
        }
    }

    /* access modifiers changed from: protected */
    public String argString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            StringBuffer append = stringBuffer4.append("\n    ");
            StringBuffer append2 = stringBuffer4.append(i);
            StringBuffer append3 = stringBuffer4.append(": ");
            StringBuffer append4 = stringBuffer4.append(((Constant) this.values.get(i)).toHuman());
        }
        return stringBuffer4.toString();
    }

    public int codeSize() {
        return 4 + ((1 + (this.initLength * this.elemWidth)) / 2);
    }

    /* access modifiers changed from: protected */
    public String listingString0(boolean z) {
        StringBuffer stringBuffer;
        boolean z2 = z;
        int address = this.user.getAddress();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        int size = this.values.size();
        StringBuffer append = stringBuffer4.append("fill-array-data-payload // for fill-array-data @ ");
        StringBuffer append2 = stringBuffer4.append(Hex.m51u2(address));
        for (int i = 0; i < size; i++) {
            StringBuffer append3 = stringBuffer4.append("\n  ");
            StringBuffer append4 = stringBuffer4.append(i);
            StringBuffer append5 = stringBuffer4.append(": ");
            StringBuffer append6 = stringBuffer4.append(((Constant) this.values.get(i)).toHuman());
        }
        return stringBuffer4.toString();
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        ArrayData arrayData;
        RegisterSpecList registerSpecList2 = registerSpecList;
        ArrayData arrayData2 = arrayData;
        ArrayData arrayData3 = new ArrayData(getPosition(), this.user, this.values, this.arrayType);
        return arrayData2;
    }

    public void writeTo(AnnotatedOutput annotatedOutput) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int size = this.values.size();
        annotatedOutput2.writeShort(768);
        annotatedOutput2.writeShort(this.elemWidth);
        annotatedOutput2.writeInt(this.initLength);
        switch (this.elemWidth) {
            case 1:
                for (int i = 0; i < size; i++) {
                    annotatedOutput2.writeByte((byte) ((CstLiteral32) ((Constant) this.values.get(i))).getIntBits());
                }
                break;
            case 2:
                for (int i2 = 0; i2 < size; i2++) {
                    annotatedOutput2.writeShort((short) ((CstLiteral32) ((Constant) this.values.get(i2))).getIntBits());
                }
                break;
            case 4:
                for (int i3 = 0; i3 < size; i3++) {
                    annotatedOutput2.writeInt(((CstLiteral32) ((Constant) this.values.get(i3))).getIntBits());
                }
                break;
            case 8:
                for (int i4 = 0; i4 < size; i4++) {
                    annotatedOutput2.writeLong(((CstLiteral64) ((Constant) this.values.get(i4))).getLongBits());
                }
                break;
        }
        if (this.elemWidth == 1 && size % 2 != 0) {
            annotatedOutput2.writeByte(0);
        }
    }
}
