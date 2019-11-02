package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.SwitchData */
public final class SwitchData extends VariableSizeInsn {
    private final IntList cases;
    private final boolean packed;
    private final CodeAddress[] targets;
    private final CodeAddress user;

    public SwitchData(SourcePosition sourcePosition, CodeAddress codeAddress, IntList intList, CodeAddress[] codeAddressArr) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        CodeAddress codeAddress2 = codeAddress;
        IntList intList2 = intList;
        CodeAddress[] codeAddressArr2 = codeAddressArr;
        super(sourcePosition, RegisterSpecList.EMPTY);
        if (codeAddress2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("user == null");
            throw nullPointerException4;
        } else if (intList2 == null) {
            NullPointerException nullPointerException6 = nullPointerException2;
            NullPointerException nullPointerException7 = new NullPointerException("cases == null");
            throw nullPointerException6;
        } else if (codeAddressArr2 == null) {
            NullPointerException nullPointerException8 = nullPointerException;
            NullPointerException nullPointerException9 = new NullPointerException("targets == null");
            throw nullPointerException8;
        } else {
            int size = intList2.size();
            if (size != codeAddressArr2.length) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("cases / targets mismatch");
                throw illegalArgumentException3;
            } else if (size > 65535) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("too many cases");
                throw illegalArgumentException5;
            } else {
                this.user = codeAddress2;
                this.cases = intList2;
                this.targets = codeAddressArr2;
                this.packed = shouldPack(intList2);
            }
        }
    }

    private static long packedCodeSize(IntList intList) {
        IntList intList2 = intList;
        long j = (long) intList2.get(0);
        long j2 = 4 + (2 * (1 + (((long) intList2.get(intList2.size() - 1)) - j)));
        if (j2 <= 2147483647L) {
            return j2;
        }
        return -1;
    }

    private static boolean shouldPack(IntList intList) {
        IntList intList2 = intList;
        if (intList2.size() >= 2) {
            long packedCodeSize = packedCodeSize(intList2);
            long sparseCodeSize = sparseCodeSize(intList2);
            if (packedCodeSize < 0 || packedCodeSize > (sparseCodeSize * 5) / 4) {
                return false;
            }
        }
        return true;
    }

    private static long sparseCodeSize(IntList intList) {
        return 2 + (4 * ((long) intList.size()));
    }

    /* access modifiers changed from: protected */
    public String argString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        int length = this.targets.length;
        for (int i = 0; i < length; i++) {
            StringBuffer append = stringBuffer4.append("\n    ");
            StringBuffer append2 = stringBuffer4.append(this.cases.get(i));
            StringBuffer append3 = stringBuffer4.append(": ");
            StringBuffer append4 = stringBuffer4.append(this.targets[i]);
        }
        return stringBuffer4.toString();
    }

    public int codeSize() {
        return this.packed ? (int) packedCodeSize(this.cases) : (int) sparseCodeSize(this.cases);
    }

    public boolean isPacked() {
        return this.packed;
    }

    /* access modifiers changed from: protected */
    public String listingString0(boolean z) {
        StringBuffer stringBuffer;
        boolean z2 = z;
        int address = this.user.getAddress();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        int length = this.targets.length;
        StringBuffer append = stringBuffer4.append(this.packed ? "packed" : "sparse");
        StringBuffer append2 = stringBuffer4.append("-switch-payload // for switch @ ");
        StringBuffer append3 = stringBuffer4.append(Hex.m51u2(address));
        for (int i = 0; i < length; i++) {
            int address2 = this.targets[i].getAddress();
            int i2 = address2 - address;
            StringBuffer append4 = stringBuffer4.append("\n  ");
            StringBuffer append5 = stringBuffer4.append(this.cases.get(i));
            StringBuffer append6 = stringBuffer4.append(": ");
            StringBuffer append7 = stringBuffer4.append(Hex.m53u4(address2));
            StringBuffer append8 = stringBuffer4.append(" // ");
            StringBuffer append9 = stringBuffer4.append(Hex.m48s4(i2));
        }
        return stringBuffer4.toString();
    }

    public DalvInsn withRegisters(RegisterSpecList registerSpecList) {
        SwitchData switchData;
        RegisterSpecList registerSpecList2 = registerSpecList;
        SwitchData switchData2 = switchData;
        SwitchData switchData3 = new SwitchData(getPosition(), this.user, this.cases, this.targets);
        return switchData2;
    }

    public void writeTo(AnnotatedOutput annotatedOutput) {
        int i;
        int address;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int i2 = 0;
        int address2 = this.user.getAddress();
        int codeSize = Dops.PACKED_SWITCH.getFormat().codeSize();
        int length = this.targets.length;
        if (this.packed) {
            int i3 = length == 0 ? 0 : this.cases.get(0);
            int i4 = 1 + ((length == 0 ? 0 : this.cases.get(length - 1)) - i3);
            annotatedOutput2.writeShort(256);
            annotatedOutput2.writeShort(i4);
            annotatedOutput2.writeInt(i3);
            for (int i5 = 0; i5 < i4; i5++) {
                if (this.cases.get(i2) > i3 + i5) {
                    address = codeSize;
                } else {
                    address = this.targets[i2].getAddress() - address2;
                    i2++;
                }
                annotatedOutput2.writeInt(address);
            }
            return;
        }
        annotatedOutput2.writeShort(512);
        annotatedOutput2.writeShort(length);
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            annotatedOutput2.writeInt(this.cases.get(i6));
            i6++;
        }
        for (i = 0; i < length; i++) {
            annotatedOutput2.writeInt(this.targets[i].getAddress() - address2);
        }
    }
}
