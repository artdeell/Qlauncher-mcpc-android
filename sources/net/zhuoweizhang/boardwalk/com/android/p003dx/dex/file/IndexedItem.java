package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.IndexedItem */
public abstract class IndexedItem extends Item {
    private int index = -1;

    public IndexedItem() {
    }

    public final int getIndex() {
        RuntimeException runtimeException;
        if (this.index >= 0) {
            return this.index;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("index not yet set");
        throw runtimeException2;
    }

    public final boolean hasIndex() {
        return this.index >= 0;
    }

    public final String indexString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append('[').append(Integer.toHexString(this.index)).append(']').toString();
    }

    public final void setIndex(int i) {
        RuntimeException runtimeException;
        int i2 = i;
        if (this.index != -1) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("index already set");
            throw runtimeException2;
        }
        this.index = i2;
    }
}
