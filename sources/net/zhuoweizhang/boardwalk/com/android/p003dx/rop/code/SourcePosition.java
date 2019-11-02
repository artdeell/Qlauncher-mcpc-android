package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition */
public final class SourcePosition {
    public static final SourcePosition NO_INFO;
    private final int address;
    private final int line;
    private final CstString sourceFile;

    static {
        SourcePosition sourcePosition;
        SourcePosition sourcePosition2 = sourcePosition;
        SourcePosition sourcePosition3 = new SourcePosition(null, -1, -1);
        NO_INFO = sourcePosition2;
    }

    public SourcePosition(CstString cstString, int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        CstString cstString2 = cstString;
        int i3 = i;
        int i4 = i2;
        if (i3 < -1) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("address < -1");
            throw illegalArgumentException3;
        } else if (i4 < -1) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("line < -1");
            throw illegalArgumentException5;
        } else {
            this.sourceFile = cstString2;
            this.address = i3;
            this.line = i4;
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        boolean z = true;
        if (!(obj2 instanceof SourcePosition)) {
            z = false;
        } else if (this != obj2) {
            SourcePosition sourcePosition = (SourcePosition) obj2;
            if (this.address != sourcePosition.address || !sameLineAndFile(sourcePosition)) {
                return false;
            }
        }
        return z;
    }

    public int getAddress() {
        return this.address;
    }

    public int getLine() {
        return this.line;
    }

    public CstString getSourceFile() {
        return this.sourceFile;
    }

    public int hashCode() {
        return this.sourceFile.hashCode() + this.address + this.line;
    }

    public boolean sameLine(SourcePosition sourcePosition) {
        return this.line == sourcePosition.line;
    }

    public boolean sameLineAndFile(SourcePosition sourcePosition) {
        SourcePosition sourcePosition2 = sourcePosition;
        return this.line == sourcePosition2.line && (this.sourceFile == sourcePosition2.sourceFile || (this.sourceFile != null && this.sourceFile.equals(sourcePosition2.sourceFile)));
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(50);
        StringBuffer stringBuffer4 = stringBuffer2;
        if (this.sourceFile != null) {
            StringBuffer append = stringBuffer4.append(this.sourceFile.toHuman());
            StringBuffer append2 = stringBuffer4.append(":");
        }
        if (this.line >= 0) {
            StringBuffer append3 = stringBuffer4.append(this.line);
        }
        StringBuffer append4 = stringBuffer4.append('@');
        if (this.address < 0) {
            StringBuffer append5 = stringBuffer4.append("????");
        } else {
            StringBuffer append6 = stringBuffer4.append(Hex.m51u2(this.address));
        }
        return stringBuffer4.toString();
    }
}
