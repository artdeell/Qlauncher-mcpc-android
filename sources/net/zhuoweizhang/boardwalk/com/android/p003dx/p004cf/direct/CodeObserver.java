package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteOps;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BytecodeArray.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.SwitchList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstDouble;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFloat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstKnownNull;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLong;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.CodeObserver */
public class CodeObserver implements Visitor {
    private final ByteArray bytes;
    private final ParseObserver observer;

    public CodeObserver(ByteArray byteArray, ParseObserver parseObserver) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        ByteArray byteArray2 = byteArray;
        ParseObserver parseObserver2 = parseObserver;
        if (byteArray2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("bytes == null");
            throw nullPointerException3;
        } else if (parseObserver2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("observer == null");
            throw nullPointerException5;
        } else {
            this.bytes = byteArray2;
            this.observer = parseObserver2;
        }
    }

    private String header(int i) {
        StringBuilder sb;
        StringBuilder sb2;
        int i2 = i;
        int unsignedByte = this.bytes.getUnsignedByte(i2);
        String opName = ByteOps.opName(unsignedByte);
        if (unsignedByte == 196) {
            int unsignedByte2 = this.bytes.getUnsignedByte(i2 + 1);
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            opName = sb3.append(opName).append(" ").append(ByteOps.opName(unsignedByte2)).toString();
        }
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        return sb5.append(Hex.m51u2(i2)).append(": ").append(opName).toString();
    }

    private void visitLiteralDouble(int i, int i2, int i3, long j) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        if (i6 != 1) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            str = sb3.append(" #").append(Hex.m54u8(j2)).toString();
        } else {
            str = LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        int i7 = i5;
        int i8 = i6;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        parseObserver.parsed(byteArray, i7, i8, sb5.append(header(i5)).append(str).append(" // ").append(Double.longBitsToDouble(j2)).toString());
    }

    private void visitLiteralFloat(int i, int i2, int i3, int i4) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (i7 != 1) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            str = sb3.append(" #").append(Hex.m53u4(i8)).toString();
        } else {
            str = LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        int i9 = i6;
        int i10 = i7;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        parseObserver.parsed(byteArray, i9, i10, sb5.append(header(i6)).append(str).append(" // ").append(Float.intBitsToFloat(i8)).toString());
    }

    private void visitLiteralInt(int i, int i2, int i3, int i4) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        String str2 = i7 == 1 ? " // " : " ";
        int unsignedByte = this.bytes.getUnsignedByte(i6);
        if (i7 == 1 || unsignedByte == 16) {
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            str = sb5.append("#").append(Hex.m46s1(i8)).toString();
        } else if (unsignedByte == 17) {
            StringBuilder sb7 = sb4;
            StringBuilder sb8 = new StringBuilder();
            str = sb7.append("#").append(Hex.m47s2(i8)).toString();
        } else {
            StringBuilder sb9 = sb3;
            StringBuilder sb10 = new StringBuilder();
            str = sb9.append("#").append(Hex.m48s4(i8)).toString();
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        int i9 = i6;
        int i10 = i7;
        StringBuilder sb11 = sb;
        StringBuilder sb12 = new StringBuilder();
        parseObserver.parsed(byteArray, i9, i10, sb11.append(header(i6)).append(str2).append(str).toString());
    }

    private void visitLiteralLong(int i, int i2, int i3, long j) {
        StringBuilder sb;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        String str = i6 == 1 ? " // " : " #";
        String s8 = i6 == 1 ? Hex.m46s1((int) j2) : Hex.m49s8(j2);
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        int i7 = i5;
        int i8 = i6;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        parseObserver.parsed(byteArray, i7, i8, sb2.append(header(i5)).append(str).append(s8).toString());
    }

    public int getPreviousOffset() {
        return -1;
    }

    public void setPreviousOffset(int i) {
    }

    public void visitBranch(int i, int i2, int i3, int i4) {
        StringBuilder sb;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        String u4 = i7 <= 3 ? Hex.m51u2(i8) : Hex.m53u4(i8);
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        int i9 = i6;
        int i10 = i7;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        parseObserver.parsed(byteArray, i9, i10, sb2.append(header(i6)).append(" ").append(u4).toString());
    }

    public void visitConstant(int i, int i2, int i3, Constant constant, int i4) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        Constant constant2 = constant;
        int i8 = i4;
        if (constant2 instanceof CstKnownNull) {
            visitNoArgs(i5, i6, i7, null);
        } else if (constant2 instanceof CstInteger) {
            visitLiteralInt(i5, i6, i7, i8);
        } else if (constant2 instanceof CstLong) {
            visitLiteralLong(i5, i6, i7, ((CstLong) constant2).getValue());
        } else if (constant2 instanceof CstFloat) {
            visitLiteralFloat(i5, i6, i7, ((CstFloat) constant2).getIntBits());
        } else if (constant2 instanceof CstDouble) {
            visitLiteralDouble(i5, i6, i7, ((CstDouble) constant2).getLongBits());
        } else {
            String str = LibrariesRepository.MOJANG_MAVEN_REPO;
            if (i8 != 0) {
                if (i5 == 197) {
                    StringBuilder sb4 = sb3;
                    StringBuilder sb5 = new StringBuilder();
                    str = sb4.append(", ").append(Hex.m50u1(i8)).toString();
                } else {
                    StringBuilder sb6 = sb2;
                    StringBuilder sb7 = new StringBuilder();
                    str = sb6.append(", ").append(Hex.m51u2(i8)).toString();
                }
            }
            ParseObserver parseObserver = this.observer;
            ByteArray byteArray = this.bytes;
            int i9 = i6;
            int i10 = i7;
            StringBuilder sb8 = sb;
            StringBuilder sb9 = new StringBuilder();
            parseObserver.parsed(byteArray, i9, i10, sb8.append(header(i6)).append(" ").append(constant2).append(str).toString());
        }
    }

    public void visitInvalid(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        this.observer.parsed(this.bytes, i5, i3, header(i5));
    }

    public void visitLocal(int i, int i2, int i3, int i4, Type type, int i5) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        Type type2 = type;
        int i10 = i5;
        boolean z = true;
        String u2 = i8 <= 3 ? Hex.m50u1(i9) : Hex.m51u2(i9);
        if (i8 != 1) {
            z = false;
        }
        String str = LibrariesRepository.MOJANG_MAVEN_REPO;
        if (i6 == 132) {
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            str = sb4.append(", #").append(i8 <= 3 ? Hex.m46s1(i10) : Hex.m47s2(i10)).toString();
        }
        String str2 = LibrariesRepository.MOJANG_MAVEN_REPO;
        if (type2.isCategory2()) {
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            str2 = sb6.append(z ? "," : " //").append(" category-2").toString();
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        StringBuilder sb8 = sb;
        StringBuilder sb9 = new StringBuilder();
        parseObserver.parsed(byteArray, i7, i8, sb8.append(header(i7)).append(z ? " // " : " ").append(u2).append(str).append(str2).toString());
    }

    public void visitNewarray(int i, int i2, CstType cstType, ArrayList<Constant> arrayList) {
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        CstType cstType2 = cstType;
        ArrayList<Constant> arrayList2 = arrayList;
        String str = i4 == 1 ? " // " : " ";
        String human = cstType2.getClassType().getComponentType().toHuman();
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        int i5 = i3;
        int i6 = i4;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        parseObserver.parsed(byteArray, i5, i6, sb2.append(header(i3)).append(str).append(human).toString());
    }

    public void visitNoArgs(int i, int i2, int i3, Type type) {
        int i4 = i;
        int i5 = i2;
        Type type2 = type;
        this.observer.parsed(this.bytes, i5, i3, header(i5));
    }

    public void visitSwitch(int i, int i2, int i3, SwitchList switchList, int i4) {
        StringBuffer stringBuffer;
        StringBuilder sb;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        SwitchList switchList2 = switchList;
        int i8 = i4;
        int size = switchList2.size();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100 + (size * 20));
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(header(i6));
        if (i8 != 0) {
            StringBuffer stringBuffer5 = stringBuffer4;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            StringBuffer append2 = stringBuffer5.append(sb2.append(" // padding: ").append(Hex.m53u4(i8)).toString());
        }
        StringBuffer append3 = stringBuffer4.append(10);
        for (int i9 = 0; i9 < size; i9++) {
            StringBuffer append4 = stringBuffer4.append("  ");
            StringBuffer append5 = stringBuffer4.append(Hex.m48s4(switchList2.getValue(i9)));
            StringBuffer append6 = stringBuffer4.append(": ");
            StringBuffer append7 = stringBuffer4.append(Hex.m51u2(switchList2.getTarget(i9)));
            StringBuffer append8 = stringBuffer4.append(10);
        }
        StringBuffer append9 = stringBuffer4.append("  default: ");
        StringBuffer append10 = stringBuffer4.append(Hex.m51u2(switchList2.getDefaultTarget()));
        this.observer.parsed(this.bytes, i6, i7, stringBuffer4.toString());
    }
}
