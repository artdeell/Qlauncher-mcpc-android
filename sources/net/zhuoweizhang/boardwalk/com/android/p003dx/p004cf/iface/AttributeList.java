package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.AttributeList */
public interface AttributeList {
    int byteLength();

    Attribute findFirst(String str);

    Attribute findNext(Attribute attribute);

    Attribute get(int i);

    boolean isMutable();

    int size();
}
