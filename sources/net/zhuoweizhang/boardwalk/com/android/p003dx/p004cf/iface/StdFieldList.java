package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.StdFieldList */
public final class StdFieldList extends FixedSizeList implements FieldList {
    public StdFieldList(int i) {
        super(i);
    }

    public Field get(int i) {
        return (Field) get0(i);
    }

    public void set(int i, Field field) {
        set0(i, field);
    }
}
