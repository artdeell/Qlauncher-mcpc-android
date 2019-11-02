package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput */
public interface AnnotatedOutput extends Output {
    void annotate(int i, String str);

    void annotate(String str);

    boolean annotates();

    void endAnnotation();

    int getAnnotationWidth();

    boolean isVerbose();
}
