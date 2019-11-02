package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LocalVariableList */
public final class LocalVariableList extends FixedSizeList {
    public static final LocalVariableList EMPTY;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.LocalVariableList$Item */
    public static class Item {
        private final CstString descriptor;
        private final int index;
        private final int length;
        private final CstString name;
        private final CstString signature;
        private final int startPc;

        public Item(int i, int i2, CstString cstString, CstString cstString2, CstString cstString3, int i3) {
            IllegalArgumentException illegalArgumentException;
            NullPointerException nullPointerException;
            NullPointerException nullPointerException2;
            IllegalArgumentException illegalArgumentException2;
            IllegalArgumentException illegalArgumentException3;
            int i4 = i;
            int i5 = i2;
            CstString cstString4 = cstString;
            CstString cstString5 = cstString2;
            CstString cstString6 = cstString3;
            int i6 = i3;
            if (i4 < 0) {
                IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("startPc < 0");
                throw illegalArgumentException4;
            } else if (i5 < 0) {
                IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("length < 0");
                throw illegalArgumentException6;
            } else if (cstString4 == null) {
                NullPointerException nullPointerException3 = nullPointerException2;
                NullPointerException nullPointerException4 = new NullPointerException("name == null");
                throw nullPointerException3;
            } else if (cstString5 == null && cstString6 == null) {
                NullPointerException nullPointerException5 = nullPointerException;
                NullPointerException nullPointerException6 = new NullPointerException("(descriptor == null) && (signature == null)");
                throw nullPointerException5;
            } else if (i6 < 0) {
                IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("index < 0");
                throw illegalArgumentException8;
            } else {
                this.startPc = i4;
                this.length = i5;
                this.name = cstString4;
                this.descriptor = cstString5;
                this.signature = cstString6;
                this.index = i6;
            }
        }

        /* access modifiers changed from: private */
        public CstString getSignature() {
            return this.signature;
        }

        public CstString getDescriptor() {
            return this.descriptor;
        }

        public int getIndex() {
            return this.index;
        }

        public int getLength() {
            return this.length;
        }

        public LocalItem getLocalItem() {
            return LocalItem.make(this.name, this.signature);
        }

        public int getStartPc() {
            return this.startPc;
        }

        public Type getType() {
            return Type.intern(this.descriptor.getString());
        }

        public boolean matchesAllButType(Item item) {
            Item item2 = item;
            return this.startPc == item2.startPc && this.length == item2.length && this.index == item2.index && this.name.equals(item2.name);
        }

        public boolean matchesPcAndIndex(int i, int i2) {
            int i3 = i;
            return i2 == this.index && i3 >= this.startPc && i3 < this.startPc + this.length;
        }

        public Item withSignature(CstString cstString) {
            Item item;
            Item item2 = item;
            Item item3 = new Item(this.startPc, this.length, this.name, this.descriptor, cstString, this.index);
            return item2;
        }
    }

    static {
        LocalVariableList localVariableList;
        LocalVariableList localVariableList2 = localVariableList;
        LocalVariableList localVariableList3 = new LocalVariableList(0);
        EMPTY = localVariableList2;
    }

    public LocalVariableList(int i) {
        super(i);
    }

    public static LocalVariableList concat(LocalVariableList localVariableList, LocalVariableList localVariableList2) {
        LocalVariableList localVariableList3;
        int i;
        LocalVariableList localVariableList4 = localVariableList;
        LocalVariableList localVariableList5 = localVariableList2;
        if (localVariableList4 == EMPTY) {
            return localVariableList5;
        }
        int size = localVariableList4.size();
        int size2 = localVariableList5.size();
        LocalVariableList localVariableList6 = localVariableList3;
        LocalVariableList localVariableList7 = new LocalVariableList(size + size2);
        LocalVariableList localVariableList8 = localVariableList6;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            localVariableList8.set(i2, localVariableList4.get(i2));
            i2++;
        }
        for (i = 0; i < size2; i++) {
            localVariableList8.set(size + i, localVariableList5.get(i));
        }
        localVariableList8.setImmutable();
        return localVariableList8;
    }

    public static LocalVariableList mergeDescriptorsAndSignatures(LocalVariableList localVariableList, LocalVariableList localVariableList2) {
        LocalVariableList localVariableList3;
        LocalVariableList localVariableList4 = localVariableList;
        LocalVariableList localVariableList5 = localVariableList2;
        int size = localVariableList4.size();
        LocalVariableList localVariableList6 = localVariableList3;
        LocalVariableList localVariableList7 = new LocalVariableList(size);
        LocalVariableList localVariableList8 = localVariableList6;
        for (int i = 0; i < size; i++) {
            Item item = localVariableList4.get(i);
            Item itemToLocal = localVariableList5.itemToLocal(item);
            if (itemToLocal != null) {
                item = item.withSignature(itemToLocal.getSignature());
            }
            localVariableList8.set(i, item);
        }
        localVariableList8.setImmutable();
        return localVariableList8;
    }

    public Item get(int i) {
        return (Item) get0(i);
    }

    public Item itemToLocal(Item item) {
        Item item2 = item;
        int size = size();
        for (int i = 0; i < size; i++) {
            Item item3 = (Item) get0(i);
            if (item3 != null && item3.matchesAllButType(item2)) {
                return item3;
            }
        }
        return null;
    }

    public Item pcAndIndexToLocal(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            Item item = (Item) get0(i5);
            if (item != null && item.matchesPcAndIndex(i3, i4)) {
                return item;
            }
        }
        return null;
    }

    public void set(int i, int i2, int i3, CstString cstString, CstString cstString2, CstString cstString3, int i4) {
        Item item;
        int i5 = i;
        Item item2 = item;
        Item item3 = new Item(i2, i3, cstString, cstString2, cstString3, i4);
        set0(i5, item2);
    }

    public void set(int i, Item item) {
        NullPointerException nullPointerException;
        int i2 = i;
        Item item2 = item;
        if (item2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("item == null");
            throw nullPointerException2;
        }
        set0(i2, item2);
    }
}
