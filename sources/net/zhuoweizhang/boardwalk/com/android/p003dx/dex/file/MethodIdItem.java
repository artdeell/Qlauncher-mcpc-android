package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstBaseMethodRef;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.MethodIdItem */
public final class MethodIdItem extends MemberIdItem {
    public MethodIdItem(CstBaseMethodRef cstBaseMethodRef) {
        super(cstBaseMethodRef);
    }

    public void addContents(DexFile dexFile) {
        DexFile dexFile2 = dexFile;
        super.addContents(dexFile2);
        ProtoIdItem intern = dexFile2.getProtoIds().intern(getMethodRef().getPrototype());
    }

    public CstBaseMethodRef getMethodRef() {
        return (CstBaseMethodRef) getRef();
    }

    /* access modifiers changed from: protected */
    public int getTypoidIdx(DexFile dexFile) {
        return dexFile.getProtoIds().indexOf(getMethodRef().getPrototype());
    }

    /* access modifiers changed from: protected */
    public String getTypoidName() {
        return "proto_idx";
    }

    public ItemType itemType() {
        return ItemType.TYPE_METHOD_ID_ITEM;
    }
}
