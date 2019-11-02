package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.FieldIdItem */
public final class FieldIdItem extends MemberIdItem {
    public FieldIdItem(CstFieldRef cstFieldRef) {
        super(cstFieldRef);
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        super.addContents(dexFile2);
        TypeIdItem intern = dexFile2.getTypeIds().intern(getFieldRef().getType());
    }

    public CstFieldRef getFieldRef() {
        return (CstFieldRef) getRef();
    }

    /* access modifiers changed from: protected */
    public int getTypoidIdx(DexFile dexFile) {
        return dexFile.getTypeIds().indexOf(getFieldRef().getType());
    }

    /* access modifiers changed from: protected */
    public String getTypoidName() {
        return "type_idx";
    }

    public ItemType itemType() {
        return ItemType.TYPE_FIELD_ID_ITEM;
    }
}
