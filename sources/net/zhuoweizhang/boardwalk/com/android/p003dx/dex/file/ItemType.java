package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.ItemType */
public enum ItemType implements ToHuman {
    ;
    
    private final String humanName;
    private final int mapValue;
    private final String typeName;

    private ItemType(int i, String str) {
        String str2 = str;
        String str3 = r10;
        int i2 = r11;
        this.mapValue = i;
        this.typeName = str2;
        if (str2.endsWith("_item")) {
            str2 = str2.substring(0, -5 + str2.length());
        }
        this.humanName = str2.replace('_', ' ');
    }

    public int getMapValue() {
        return this.mapValue;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String toHuman() {
        return this.humanName;
    }
}
