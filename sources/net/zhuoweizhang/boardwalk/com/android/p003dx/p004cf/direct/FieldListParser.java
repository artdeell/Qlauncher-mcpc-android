package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.AttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Member;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.StdField;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.StdFieldList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.FieldListParser */
final class FieldListParser extends MemberListParser {
    private final StdFieldList fields;

    public FieldListParser(DirectClassFile directClassFile, CstType cstType, int i, AttributeFactory attributeFactory) {
        StdFieldList stdFieldList;
        super(directClassFile, cstType, i, attributeFactory);
        StdFieldList stdFieldList2 = stdFieldList;
        StdFieldList stdFieldList3 = new StdFieldList(getCount());
        this.fields = stdFieldList2;
    }

    /* access modifiers changed from: protected */
    public int getAttributeContext() {
        return 1;
    }

    public StdFieldList getList() {
        parseIfNecessary();
        return this.fields;
    }

    /* access modifiers changed from: protected */
    public String humanAccessFlags(int i) {
        return AccessFlags.fieldString(i);
    }

    /* access modifiers changed from: protected */
    public String humanName() {
        return "field";
    }

    /* access modifiers changed from: protected */
    public Member set(int i, int i2, CstNat cstNat, AttributeList attributeList) {
        StdField stdField;
        int i3 = i;
        StdField stdField2 = stdField;
        StdField stdField3 = new StdField(getDefiner(), i2, cstNat, attributeList);
        StdField stdField4 = stdField2;
        this.fields.set(i3, stdField4);
        return stdField4;
    }
}
