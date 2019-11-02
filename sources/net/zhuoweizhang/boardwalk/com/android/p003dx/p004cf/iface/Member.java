package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.Member */
public interface Member {
    int getAccessFlags();

    AttributeList getAttributes();

    CstType getDefiningClass();

    CstString getDescriptor();

    CstString getName();

    CstNat getNat();
}
