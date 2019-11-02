package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Attribute;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.BaseAttribute */
public abstract class BaseAttribute implements Attribute {
    private final String name;

    public BaseAttribute(String str) {
        NullPointerException nullPointerException;
        String str2 = str;
        if (str2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("name == null");
            throw nullPointerException2;
        }
        this.name = str2;
    }

    public String getName() {
        return this.name;
    }
}
