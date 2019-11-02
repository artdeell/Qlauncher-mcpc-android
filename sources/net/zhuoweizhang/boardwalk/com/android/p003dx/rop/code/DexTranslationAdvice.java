package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.DexTranslationAdvice */
public final class DexTranslationAdvice implements TranslationAdvice {
    private static final int MIN_INVOKE_IN_ORDER = 6;
    public static final DexTranslationAdvice NO_SOURCES_IN_ORDER;
    public static final DexTranslationAdvice THE_ONE;
    private final boolean disableSourcesInOrder;

    static {
        DexTranslationAdvice dexTranslationAdvice;
        DexTranslationAdvice dexTranslationAdvice2;
        DexTranslationAdvice dexTranslationAdvice3 = dexTranslationAdvice;
        DexTranslationAdvice dexTranslationAdvice4 = new DexTranslationAdvice();
        THE_ONE = dexTranslationAdvice3;
        DexTranslationAdvice dexTranslationAdvice5 = dexTranslationAdvice2;
        DexTranslationAdvice dexTranslationAdvice6 = new DexTranslationAdvice(true);
        NO_SOURCES_IN_ORDER = dexTranslationAdvice5;
    }

    private DexTranslationAdvice() {
        this.disableSourcesInOrder = false;
    }

    private DexTranslationAdvice(boolean z) {
        this.disableSourcesInOrder = z;
    }

    private int totalRopWidth(RegisterSpecList registerSpecList) {
        RegisterSpecList registerSpecList2 = registerSpecList;
        int i = 0;
        for (int i2 = 0; i2 < registerSpecList2.size(); i2++) {
            i += registerSpecList2.get(i2).getCategory();
        }
        return i;
    }

    public int getMaxOptimalRegisterCount() {
        return 16;
    }

    public boolean hasConstantOperation(Rop rop, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        Rop rop2 = rop;
        RegisterSpec registerSpec3 = registerSpec;
        RegisterSpec registerSpec4 = registerSpec2;
        if (registerSpec3.getType() != Type.INT) {
            return false;
        }
        if (registerSpec4.getTypeBearer() instanceof CstInteger) {
            CstInteger cstInteger = (CstInteger) registerSpec4.getTypeBearer();
            switch (rop2.getOpcode()) {
                case 14:
                case 16:
                case 17:
                case 18:
                case 20:
                case 21:
                case 22:
                    return cstInteger.fitsIn16Bits();
                case 15:
                    return CstInteger.make(-cstInteger.getValue()).fitsIn16Bits();
                case 23:
                case 24:
                case 25:
                    return cstInteger.fitsIn8Bits();
                default:
                    return false;
            }
        } else if (!(registerSpec3.getTypeBearer() instanceof CstInteger) || rop2.getOpcode() != 15) {
            return false;
        } else {
            return ((CstInteger) registerSpec3.getTypeBearer()).fitsIn16Bits();
        }
    }

    public boolean requiresSourcesInOrder(Rop rop, RegisterSpecList registerSpecList) {
        return !this.disableSourcesInOrder && rop.isCallLike() && totalRopWidth(registerSpecList) >= 6;
    }
}
