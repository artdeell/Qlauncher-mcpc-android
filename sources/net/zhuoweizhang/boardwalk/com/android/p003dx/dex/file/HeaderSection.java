package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.HeaderSection */
public final class HeaderSection extends UniformItemSection {
    private final List<HeaderItem> list;

    public HeaderSection(DexFile dexFile) {
        HeaderItem headerItem;
        super(null, dexFile, 4);
        HeaderItem headerItem2 = headerItem;
        HeaderItem headerItem3 = new HeaderItem();
        HeaderItem headerItem4 = headerItem2;
        headerItem4.setIndex(0);
        this.list = Collections.singletonList(headerItem4);
    }

    public IndexedItem get(Constant constant) {
        Constant constant2 = constant;
        return null;
    }

    public Collection<? extends Item> items() {
        return this.list;
    }

    /* access modifiers changed from: protected */
    public void orderItems() {
    }
}
