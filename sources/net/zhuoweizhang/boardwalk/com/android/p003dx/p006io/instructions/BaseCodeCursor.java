package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.BaseCodeCursor */
public abstract class BaseCodeCursor implements CodeCursor {
    private final AddressMap baseAddressMap;
    private int cursor = 0;

    public BaseCodeCursor() {
        AddressMap addressMap;
        AddressMap addressMap2 = addressMap;
        AddressMap addressMap3 = new AddressMap();
        this.baseAddressMap = addressMap2;
    }

    /* access modifiers changed from: protected */
    public final void advance(int i) {
        this.cursor = i + this.cursor;
    }

    public final int baseAddressForCursor() {
        int i = this.baseAddressMap.get(this.cursor);
        return i >= 0 ? i : this.cursor;
    }

    public final int cursor() {
        return this.cursor;
    }

    public final void setBaseAddress(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.baseAddressMap.put(i3, i4);
    }
}
