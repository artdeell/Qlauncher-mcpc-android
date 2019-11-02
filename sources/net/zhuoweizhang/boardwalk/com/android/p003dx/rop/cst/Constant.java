package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant */
public abstract class Constant implements ToHuman, Comparable<Constant> {
    public Constant() {
    }

    public final int compareTo(Constant constant) {
        Constant constant2 = constant;
        Class cls = getClass();
        Class cls2 = constant2.getClass();
        return cls != cls2 ? cls.getName().compareTo(cls2.getName()) : compareTo0(constant2);
    }

    /* access modifiers changed from: protected */
    public abstract int compareTo0(Constant constant);

    public abstract boolean isCategory2();

    public abstract String typeName();
}
