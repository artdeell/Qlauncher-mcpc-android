package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttSourceFile */
public final class AttSourceFile extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "SourceFile";
    private final CstString sourceFile;

    public AttSourceFile(CstString cstString) {
        NullPointerException nullPointerException;
        CstString cstString2 = cstString;
        super(ATTRIBUTE_NAME);
        if (cstString2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("sourceFile == null");
            throw nullPointerException2;
        }
        this.sourceFile = cstString2;
    }

    public int byteLength() {
        return 8;
    }

    public CstString getSourceFile() {
        return this.sourceFile;
    }
}
