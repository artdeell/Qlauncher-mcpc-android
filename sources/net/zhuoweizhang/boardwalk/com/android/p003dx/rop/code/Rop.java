package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop */
public final class Rop {
    public static final int BRANCH_GOTO = 3;
    public static final int BRANCH_IF = 4;
    public static final int BRANCH_MAX = 6;
    public static final int BRANCH_MIN = 1;
    public static final int BRANCH_NONE = 1;
    public static final int BRANCH_RETURN = 2;
    public static final int BRANCH_SWITCH = 5;
    public static final int BRANCH_THROW = 6;
    private final int branchingness;
    private final TypeList exceptions;
    private final boolean isCallLike;
    private final String nickname;
    private final int opcode;
    private final Type result;
    private final TypeList sources;

    public Rop(int i, Type type, TypeList typeList, int i2, String str) {
        this(i, type, typeList, StdTypeList.EMPTY, i2, false, str);
    }

    public Rop(int i, Type type, TypeList typeList, String str) {
        this(i, type, typeList, StdTypeList.EMPTY, 1, false, str);
    }

    public Rop(int i, Type type, TypeList typeList, TypeList typeList2, int i2, String str) {
        this(i, type, typeList, typeList2, i2, false, str);
    }

    public Rop(int i, Type type, TypeList typeList, TypeList typeList2, int i2, boolean z, String str) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        int i3 = i;
        Type type2 = type;
        TypeList typeList3 = typeList;
        TypeList typeList4 = typeList2;
        int i4 = i2;
        boolean z2 = z;
        String str2 = str;
        if (type2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("result == null");
            throw nullPointerException4;
        } else if (typeList3 == null) {
            NullPointerException nullPointerException6 = nullPointerException2;
            NullPointerException nullPointerException7 = new NullPointerException("sources == null");
            throw nullPointerException6;
        } else if (typeList4 == null) {
            NullPointerException nullPointerException8 = nullPointerException;
            NullPointerException nullPointerException9 = new NullPointerException("exceptions == null");
            throw nullPointerException8;
        } else if (i4 < 1 || i4 > 6) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("bogus branchingness");
            throw illegalArgumentException3;
        } else if (typeList4.size() == 0 || i4 == 6) {
            this.opcode = i3;
            this.result = type2;
            this.sources = typeList3;
            this.exceptions = typeList4;
            this.branchingness = i4;
            this.isCallLike = z2;
            this.nickname = str2;
        } else {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("exceptions / branchingness mismatch");
            throw illegalArgumentException5;
        }
    }

    public Rop(int i, Type type, TypeList typeList, TypeList typeList2, String str) {
        this(i, type, typeList, typeList2, 6, false, str);
    }

    public Rop(int i, TypeList typeList, TypeList typeList2) {
        this(i, Type.VOID, typeList, typeList2, 6, true, null);
    }

    public final boolean canThrow() {
        return this.exceptions.size() != 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (!(obj2 instanceof Rop)) {
                return false;
            }
            Rop rop = (Rop) obj2;
            if (!(this.opcode == rop.opcode && this.branchingness == rop.branchingness && this.result == rop.result && this.sources.equals(rop.sources) && this.exceptions.equals(rop.exceptions))) {
                return false;
            }
        }
        return true;
    }

    public int getBranchingness() {
        return this.branchingness;
    }

    public TypeList getExceptions() {
        return this.exceptions;
    }

    public String getNickname() {
        return this.nickname != null ? this.nickname : toString();
    }

    public int getOpcode() {
        return this.opcode;
    }

    public Type getResult() {
        return this.result;
    }

    public TypeList getSources() {
        return this.sources;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * this.opcode) + this.branchingness)) + this.result.hashCode())) + this.sources.hashCode())) + this.exceptions.hashCode();
    }

    public boolean isCallLike() {
        return this.isCallLike;
    }

    public boolean isCommutative() {
        switch (this.opcode) {
            case 14:
            case 16:
            case 20:
            case 21:
            case 22:
                return true;
            default:
                return false;
        }
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuilder sb;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(40);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append("Rop{");
        StringBuffer append2 = stringBuffer4.append(RegOps.opName(this.opcode));
        if (this.result != Type.VOID) {
            StringBuffer append3 = stringBuffer4.append(" ");
            StringBuffer append4 = stringBuffer4.append(this.result);
        } else {
            StringBuffer append5 = stringBuffer4.append(" .");
        }
        StringBuffer append6 = stringBuffer4.append(" <-");
        int size = this.sources.size();
        if (size == 0) {
            StringBuffer append7 = stringBuffer4.append(" .");
        } else {
            for (int i = 0; i < size; i++) {
                StringBuffer append8 = stringBuffer4.append(' ');
                StringBuffer append9 = stringBuffer4.append(this.sources.getType(i));
            }
        }
        if (this.isCallLike) {
            StringBuffer append10 = stringBuffer4.append(" call");
        }
        int size2 = this.exceptions.size();
        if (size2 == 0) {
            switch (this.branchingness) {
                case 1:
                    StringBuffer append11 = stringBuffer4.append(" flows");
                    break;
                case 2:
                    StringBuffer append12 = stringBuffer4.append(" returns");
                    break;
                case 3:
                    StringBuffer append13 = stringBuffer4.append(" gotos");
                    break;
                case 4:
                    StringBuffer append14 = stringBuffer4.append(" ifs");
                    break;
                case 5:
                    StringBuffer append15 = stringBuffer4.append(" switches");
                    break;
                default:
                    StringBuffer stringBuffer5 = stringBuffer4;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    StringBuffer append16 = stringBuffer5.append(sb2.append(" ").append(Hex.m50u1(this.branchingness)).toString());
                    break;
            }
        } else {
            StringBuffer append17 = stringBuffer4.append(" throws");
            for (int i2 = 0; i2 < size2; i2++) {
                StringBuffer append18 = stringBuffer4.append(' ');
                if (this.exceptions.getType(i2) == Type.THROWABLE) {
                    StringBuffer append19 = stringBuffer4.append("<any>");
                } else {
                    StringBuffer append20 = stringBuffer4.append(this.exceptions.getType(i2));
                }
            }
        }
        StringBuffer append21 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }
}
