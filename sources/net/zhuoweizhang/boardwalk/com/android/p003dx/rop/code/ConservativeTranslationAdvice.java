package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.ConservativeTranslationAdvice */
public final class ConservativeTranslationAdvice implements TranslationAdvice {
    public static final ConservativeTranslationAdvice THE_ONE;

    static {
        ConservativeTranslationAdvice conservativeTranslationAdvice;
        ConservativeTranslationAdvice conservativeTranslationAdvice2 = conservativeTranslationAdvice;
        ConservativeTranslationAdvice conservativeTranslationAdvice3 = new ConservativeTranslationAdvice();
        THE_ONE = conservativeTranslationAdvice2;
    }

    private ConservativeTranslationAdvice() {
    }

    public int getMaxOptimalRegisterCount() {
        return IDirectInputDevice.DIPROPRANGE_NOMAX;
    }

    public boolean hasConstantOperation(Rop rop, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        Rop rop2 = rop;
        RegisterSpec registerSpec3 = registerSpec;
        RegisterSpec registerSpec4 = registerSpec2;
        return false;
    }

    public boolean requiresSourcesInOrder(Rop rop, RegisterSpecList registerSpecList) {
        Rop rop2 = rop;
        RegisterSpecList registerSpecList2 = registerSpecList;
        return false;
    }
}
