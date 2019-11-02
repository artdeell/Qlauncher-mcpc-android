package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.StdAttributeList */
public final class StdAttributeList extends FixedSizeList implements AttributeList {
    public StdAttributeList(int i) {
        super(i);
    }

    public int byteLength() {
        int i = 2;
        for (int i2 = 0; i2 < size(); i2++) {
            i += get(i2).byteLength();
        }
        return i;
    }

    public Attribute findFirst(String str) {
        String str2 = str;
        int size = size();
        for (int i = 0; i < size; i++) {
            Attribute attribute = get(i);
            if (attribute.getName().equals(str2)) {
                return attribute;
            }
        }
        return null;
    }

    public Attribute findNext(Attribute attribute) {
        Attribute attribute2 = attribute;
        int size = size();
        for (int i = 0; i < size; i++) {
            if (get(i) == attribute2) {
                String name = attribute2.getName();
                for (int i2 = i + 1; i2 < size; i2++) {
                    Attribute attribute3 = get(i2);
                    if (attribute3.getName().equals(name)) {
                        return attribute3;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public Attribute get(int i) {
        return (Attribute) get0(i);
    }

    public void set(int i, Attribute attribute) {
        set0(i, attribute);
    }
}
