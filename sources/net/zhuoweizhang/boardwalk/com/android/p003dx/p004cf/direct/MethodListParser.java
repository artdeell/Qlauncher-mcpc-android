package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.AttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Member;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.StdMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.StdMethodList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.MethodListParser */
final class MethodListParser extends MemberListParser {
    private final StdMethodList methods;

    public MethodListParser(DirectClassFile directClassFile, CstType cstType, int i, AttributeFactory attributeFactory) {
        StdMethodList stdMethodList;
        super(directClassFile, cstType, i, attributeFactory);
        StdMethodList stdMethodList2 = stdMethodList;
        StdMethodList stdMethodList3 = new StdMethodList(getCount());
        this.methods = stdMethodList2;
    }

    /* access modifiers changed from: protected */
    public int getAttributeContext() {
        return 2;
    }

    public StdMethodList getList() {
        parseIfNecessary();
        return this.methods;
    }

    /* access modifiers changed from: protected */
    public String humanAccessFlags(int i) {
        return AccessFlags.methodString(i);
    }

    /* access modifiers changed from: protected */
    public String humanName() {
        return "method";
    }

    /* access modifiers changed from: protected */
    public Member set(int i, int i2, CstNat cstNat, AttributeList attributeList) {
        StdMethod stdMethod;
        int i3 = i;
        StdMethod stdMethod2 = stdMethod;
        StdMethod stdMethod3 = new StdMethod(getDefiner(), i2, cstNat, attributeList);
        StdMethod stdMethod4 = stdMethod2;
        this.methods.set(i3, stdMethod4);
        return stdMethod4;
    }
}
