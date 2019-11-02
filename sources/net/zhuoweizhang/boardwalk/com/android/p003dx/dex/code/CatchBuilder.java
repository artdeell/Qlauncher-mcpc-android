package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import java.util.HashSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.CatchBuilder */
public interface CatchBuilder {
    CatchTable build();

    HashSet<Type> getCatchTypes();

    boolean hasAnyCatches();
}
