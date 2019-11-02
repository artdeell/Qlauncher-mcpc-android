package net.zhuoweizhang.boardwalk.com.android.p003dx.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.DexOptions */
public class DexOptions {
    public boolean forceJumbo = false;
    public int targetApiLevel = 13;

    public DexOptions() {
    }

    public String getMagic() {
        return DexFormat.apiToMagic(this.targetApiLevel);
    }
}
