package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.annotation;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.annotation.AnnotationVisibility */
public enum AnnotationVisibility implements ToHuman {
    ;
    
    private final String human;

    private AnnotationVisibility(String str) {
        String str2 = r8;
        int i = r9;
        this.human = str;
    }

    public String toHuman() {
        return this.human;
    }
}
