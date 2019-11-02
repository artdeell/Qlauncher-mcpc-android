package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.IdItem */
public abstract class IdItem extends IndexedItem {
    private final CstType type;

    public IdItem(CstType cstType) {
        NullPointerException nullPointerException;
        CstType cstType2 = cstType;
        if (cstType2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("type == null");
            throw nullPointerException2;
        }
        this.type = cstType2;
    }

    public void addContents(DexFile dexFile) {
        TypeIdItem intern = dexFile.getTypeIds().intern(this.type);
    }

    public final CstType getDefiningClass() {
        return this.type;
    }
}
