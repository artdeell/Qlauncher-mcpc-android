package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.LineNumberList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttLineNumberTable */
public final class AttLineNumberTable extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "LineNumberTable";
    private final LineNumberList lineNumbers;

    public AttLineNumberTable(LineNumberList lineNumberList) {
        NullPointerException nullPointerException;
        MutabilityException mutabilityException;
        LineNumberList lineNumberList2 = lineNumberList;
        super(ATTRIBUTE_NAME);
        try {
            if (lineNumberList2.isMutable()) {
                MutabilityException mutabilityException2 = mutabilityException;
                MutabilityException mutabilityException3 = new MutabilityException("lineNumbers.isMutable()");
                throw mutabilityException2;
            }
            this.lineNumbers = lineNumberList2;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("lineNumbers == null");
            throw nullPointerException3;
        }
    }

    public int byteLength() {
        return 8 + (4 * this.lineNumbers.size());
    }

    public LineNumberList getLineNumbers() {
        return this.lineNumbers;
    }
}
