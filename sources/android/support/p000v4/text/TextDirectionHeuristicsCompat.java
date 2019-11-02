package android.support.p000v4.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat */
public class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    public static final TextDirectionHeuristicCompat LTR;
    public static final TextDirectionHeuristicCompat RTL;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong */
    private static class AnyStrong implements TextDirectionAlgorithm {
        public static final AnyStrong INSTANCE_LTR;
        public static final AnyStrong INSTANCE_RTL;
        private final boolean mLookForRtl;

        static {
            AnyStrong anyStrong;
            AnyStrong anyStrong2;
            AnyStrong anyStrong3 = anyStrong;
            AnyStrong anyStrong4 = new AnyStrong(true);
            INSTANCE_RTL = anyStrong3;
            AnyStrong anyStrong5 = anyStrong2;
            AnyStrong anyStrong6 = new AnyStrong(false);
            INSTANCE_LTR = anyStrong5;
        }

        private AnyStrong(boolean z) {
            this.mLookForRtl = z;
        }

        public int checkRtl(CharSequence charSequence, int i, int i2) {
            CharSequence charSequence2 = charSequence;
            int i3 = i;
            int i4 = 1;
            boolean z = false;
            int i5 = i3;
            int i6 = i3 + i2;
            while (true) {
                if (i5 < i6) {
                    switch (TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charSequence2.charAt(i5)))) {
                        case 0:
                            if (this.mLookForRtl) {
                                i4 = 0;
                                break;
                            } else {
                                z = true;
                                continue;
                            }
                        case 1:
                            if (!this.mLookForRtl) {
                                break;
                            } else {
                                z = true;
                                continue;
                            }
                    }
                } else if (!z) {
                    return 2;
                } else {
                    if (!this.mLookForRtl) {
                        return 0;
                    }
                }
                i5++;
            }
            return i4;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$FirstStrong */
    private static class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong INSTANCE;

        static {
            FirstStrong firstStrong;
            FirstStrong firstStrong2 = firstStrong;
            FirstStrong firstStrong3 = new FirstStrong();
            INSTANCE = firstStrong2;
        }

        private FirstStrong() {
        }

        public int checkRtl(CharSequence charSequence, int i, int i2) {
            CharSequence charSequence2 = charSequence;
            int i3 = i;
            int i4 = 2;
            int i5 = i3 + i2;
            for (int i6 = i3; i6 < i5 && i4 == 2; i6++) {
                i4 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charSequence2.charAt(i6)));
            }
            return i4;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm */
    private interface TextDirectionAlgorithm {
        int checkRtl(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl */
    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.mAlgorithm = textDirectionAlgorithm;
        }

        private boolean doCheck(CharSequence charSequence, int i, int i2) {
            switch (this.mAlgorithm.checkRtl(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return defaultIsRtl();
            }
        }

        /* access modifiers changed from: protected */
        public abstract boolean defaultIsRtl();

        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            IllegalArgumentException illegalArgumentException;
            CharSequence charSequence2 = charSequence;
            int i3 = i;
            int i4 = i2;
            if (charSequence2 != null && i3 >= 0 && i4 >= 0 && charSequence2.length() - i4 >= i3) {
                return this.mAlgorithm == null ? defaultIsRtl() : doCheck(charSequence2, i3, i4);
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }

        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl((CharSequence) CharBuffer.wrap(cArr), i, i2);
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal */
    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        private TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            boolean z2 = z;
            super(textDirectionAlgorithm);
            this.mDefaultIsRtl = z2;
        }

        /* synthetic */ TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z, C00971 r10) {
            C00971 r3 = r10;
            this(textDirectionAlgorithm, z);
        }

        /* access modifiers changed from: protected */
        public boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    /* renamed from: android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale */
    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale INSTANCE;

        static {
            TextDirectionHeuristicLocale textDirectionHeuristicLocale;
            TextDirectionHeuristicLocale textDirectionHeuristicLocale2 = textDirectionHeuristicLocale;
            TextDirectionHeuristicLocale textDirectionHeuristicLocale3 = new TextDirectionHeuristicLocale();
            INSTANCE = textDirectionHeuristicLocale2;
        }

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        /* access modifiers changed from: protected */
        public boolean defaultIsRtl() {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    static {
        TextDirectionHeuristicInternal textDirectionHeuristicInternal;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal2;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal3;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal4;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal5;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal6 = textDirectionHeuristicInternal;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal7 = new TextDirectionHeuristicInternal(null, false, null);
        LTR = textDirectionHeuristicInternal6;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal8 = textDirectionHeuristicInternal2;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal9 = new TextDirectionHeuristicInternal(null, true, null);
        RTL = textDirectionHeuristicInternal8;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal10 = textDirectionHeuristicInternal3;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal11 = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false, null);
        FIRSTSTRONG_LTR = textDirectionHeuristicInternal10;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal12 = textDirectionHeuristicInternal4;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal13 = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true, null);
        FIRSTSTRONG_RTL = textDirectionHeuristicInternal12;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal14 = textDirectionHeuristicInternal5;
        TextDirectionHeuristicInternal textDirectionHeuristicInternal15 = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false, null);
        ANYRTL_LTR = textDirectionHeuristicInternal14;
    }

    public TextDirectionHeuristicsCompat() {
    }

    /* access modifiers changed from: private */
    public static int isRtlText(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* access modifiers changed from: private */
    public static int isRtlTextOrFormat(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
