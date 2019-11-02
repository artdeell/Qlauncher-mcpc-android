package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.InnerClassList */
public final class InnerClassList extends FixedSizeList {

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.InnerClassList$Item */
    public static class Item {
        private final int accessFlags;
        private final CstType innerClass;
        private final CstString innerName;
        private final CstType outerClass;

        public Item(CstType cstType, CstType cstType2, CstString cstString, int i) {
            NullPointerException nullPointerException;
            CstType cstType3 = cstType;
            CstType cstType4 = cstType2;
            CstString cstString2 = cstString;
            int i2 = i;
            if (cstType3 == null) {
                NullPointerException nullPointerException2 = nullPointerException;
                NullPointerException nullPointerException3 = new NullPointerException("innerClass == null");
                throw nullPointerException2;
            }
            this.innerClass = cstType3;
            this.outerClass = cstType4;
            this.innerName = cstString2;
            this.accessFlags = i2;
        }

        public int getAccessFlags() {
            return this.accessFlags;
        }

        public CstType getInnerClass() {
            return this.innerClass;
        }

        public CstString getInnerName() {
            return this.innerName;
        }

        public CstType getOuterClass() {
            return this.outerClass;
        }
    }

    public InnerClassList(int i) {
        super(i);
    }

    public Item get(int i) {
        return (Item) get0(i);
    }

    public void set(int i, CstType cstType, CstType cstType2, CstString cstString, int i2) {
        Item item;
        int i3 = i;
        Item item2 = item;
        Item item3 = new Item(cstType, cstType2, cstString, i2);
        set0(i3, item2);
    }
}
