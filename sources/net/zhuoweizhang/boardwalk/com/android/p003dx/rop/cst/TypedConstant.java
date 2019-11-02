package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.TypedConstant */
public abstract class TypedConstant extends Constant implements TypeBearer {
    public TypedConstant() {
    }

    public final int getBasicFrameType() {
        return getType().getBasicFrameType();
    }

    public final int getBasicType() {
        return getType().getBasicType();
    }

    public final TypeBearer getFrameType() {
        return this;
    }

    public final boolean isConstant() {
        return true;
    }
}
