package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.TranslationAdvice */
public interface TranslationAdvice {
    int getMaxOptimalRegisterCount();

    boolean hasConstantOperation(Rop rop, RegisterSpec registerSpec, RegisterSpec registerSpec2);

    boolean requiresSourcesInOrder(Rop rop, RegisterSpecList registerSpecList);
}
