package android.support.p000v4.text;

import java.util.Locale;

/* renamed from: android.support.v4.text.BidiFormatter */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    /* access modifiers changed from: private */
    public static final BidiFormatter DEFAULT_LTR_INSTANCE;
    /* access modifiers changed from: private */
    public static final BidiFormatter DEFAULT_RTL_INSTANCE;
    /* access modifiers changed from: private */
    public static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '‪';
    private static final char LRM = '‎';
    private static final String LRM_STRING = Character.toString(LRM);
    private static final char PDF = '‬';
    private static final char RLE = '‫';
    private static final char RLM = '‏';
    private static final String RLM_STRING = Character.toString(RLM);
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    /* renamed from: android.support.v4.text.BidiFormatter$Builder */
    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        public Builder(boolean z) {
            initialize(z);
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            BidiFormatter bidiFormatter;
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            BidiFormatter bidiFormatter2 = bidiFormatter;
            BidiFormatter bidiFormatter3 = new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat, null);
            return bidiFormatter2;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags = 2 | this.mFlags;
                return this;
            }
            this.mFlags = -3 & this.mFlags;
            return this;
        }
    }

    /* renamed from: android.support.v4.text.BidiFormatter$DirectionalityEstimator */
    private static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = new byte[1792];
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final String text;

        static {
            for (int i = 0; i < 1792; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(String str, boolean z) {
            String str2 = str;
            boolean z2 = z;
            this.text = str2;
            this.isHtml = z2;
            this.length = str2.length();
        }

        private static byte getCachedDirectionality(char c) {
            char c2 = c;
            return c2 < 1792 ? DIR_TYPE_CACHE[c2] : Character.getDirectionality(c2);
        }

        private byte skipEntityBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = -1 + this.charIndex;
                this.charIndex = i2;
                this.lastChar = str.charAt(i2);
                if (this.lastChar != '&') {
                    if (this.lastChar == ';') {
                        break;
                    }
                } else {
                    return 12;
                }
            }
            this.charIndex = i;
            this.lastChar = ';';
            return 13;
        }

        private byte skipEntityForward() {
            while (this.charIndex < this.length) {
                String str = this.text;
                int i = this.charIndex;
                this.charIndex = i + 1;
                char charAt = str.charAt(i);
                this.lastChar = charAt;
                if (charAt == ';') {
                    break;
                }
            }
            return 12;
        }

        private byte skipTagBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = -1 + this.charIndex;
                this.charIndex = i2;
                this.lastChar = str.charAt(i2);
                if (this.lastChar == '<') {
                    return 12;
                }
                if (this.lastChar == '>') {
                    break;
                } else if (this.lastChar == '\"' || this.lastChar == '\'') {
                    char c = this.lastChar;
                    while (this.charIndex > 0) {
                        String str2 = this.text;
                        int i3 = -1 + this.charIndex;
                        this.charIndex = i3;
                        char charAt = str2.charAt(i3);
                        this.lastChar = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.lastChar = '>';
            return 13;
        }

        private byte skipTagForward() {
            int i = this.charIndex;
            while (this.charIndex < this.length) {
                String str = this.text;
                int i2 = this.charIndex;
                this.charIndex = i2 + 1;
                this.lastChar = str.charAt(i2);
                if (this.lastChar == '>') {
                    return 12;
                }
                if (this.lastChar == '\"' || this.lastChar == '\'') {
                    char c = this.lastChar;
                    while (this.charIndex < this.length) {
                        String str2 = this.text;
                        int i3 = this.charIndex;
                        this.charIndex = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.lastChar = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.lastChar = '<';
            return 13;
        }

        /* access modifiers changed from: 0000 */
        public byte dirTypeBackward() {
            byte cachedDirectionality;
            this.lastChar = this.text.charAt(-1 + this.charIndex);
            if (Character.isLowSurrogate(this.lastChar)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                cachedDirectionality = Character.getDirectionality(codePointBefore);
            } else {
                this.charIndex = -1 + this.charIndex;
                cachedDirectionality = getCachedDirectionality(this.lastChar);
                if (this.isHtml) {
                    if (this.lastChar == '>') {
                        return skipTagBackward();
                    }
                    if (this.lastChar == ';') {
                        return skipEntityBackward();
                    }
                }
            }
            return cachedDirectionality;
        }

        /* access modifiers changed from: 0000 */
        public byte dirTypeForward() {
            byte cachedDirectionality;
            this.lastChar = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.lastChar)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                cachedDirectionality = Character.getDirectionality(codePointAt);
            } else {
                this.charIndex = 1 + this.charIndex;
                cachedDirectionality = getCachedDirectionality(this.lastChar);
                if (this.isHtml) {
                    if (this.lastChar == '<') {
                        return skipTagForward();
                    }
                    if (this.lastChar == '&') {
                        return skipEntityForward();
                    }
                }
            }
            return cachedDirectionality;
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
            if (r3 != 0) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
            if (r2 != 0) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
            if (r0.charIndex <= 0) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
            switch(dirTypeBackward()) {
                case 14: goto L_0x005b;
                case 15: goto L_0x005b;
                case 16: goto L_0x0065;
                case 17: goto L_0x0065;
                case 18: goto L_0x006f;
                default: goto L_0x005a;
            };
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005d, code lost:
            if (r3 != r1) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
            r1 = r1 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0067, code lost:
            if (r3 != r1) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
            r1 = r1 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x006f, code lost:
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            return 0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getEntryDir() {
            /*
                r6 = this;
                r0 = r6
                r4 = r0
                r5 = 0
                r4.charIndex = r5
                r4 = 0
                r1 = r4
                r4 = 0
                r2 = r4
                r4 = 0
                r3 = r4
            L_0x000b:
                r4 = r0
                int r4 = r4.charIndex
                r5 = r0
                int r5 = r5.length
                if (r4 >= r5) goto L_0x0044
                r4 = r3
                if (r4 != 0) goto L_0x0044
                r4 = r0
                byte r4 = r4.dirTypeForward()
                switch(r4) {
                    case 0: goto L_0x0030;
                    case 1: goto L_0x003b;
                    case 2: goto L_0x003b;
                    case 3: goto L_0x001e;
                    case 4: goto L_0x001e;
                    case 5: goto L_0x001e;
                    case 6: goto L_0x001e;
                    case 7: goto L_0x001e;
                    case 8: goto L_0x001e;
                    case 9: goto L_0x000b;
                    case 10: goto L_0x001e;
                    case 11: goto L_0x001e;
                    case 12: goto L_0x001e;
                    case 13: goto L_0x001e;
                    case 14: goto L_0x0021;
                    case 15: goto L_0x0021;
                    case 16: goto L_0x0026;
                    case 17: goto L_0x0026;
                    case 18: goto L_0x002b;
                    default: goto L_0x001e;
                }
            L_0x001e:
                r4 = r1
                r3 = r4
                goto L_0x000b
            L_0x0021:
                int r1 = r1 + 1
                r4 = -1
                r2 = r4
                goto L_0x000b
            L_0x0026:
                int r1 = r1 + 1
                r4 = 1
                r2 = r4
                goto L_0x000b
            L_0x002b:
                int r1 = r1 + -1
                r4 = 0
                r2 = r4
                goto L_0x000b
            L_0x0030:
                r4 = r1
                if (r4 != 0) goto L_0x0038
                r4 = -1
                r2 = r4
            L_0x0035:
                r4 = r2
                r0 = r4
            L_0x0037:
                return r0
            L_0x0038:
                r4 = r1
                r3 = r4
                goto L_0x000b
            L_0x003b:
                r4 = r1
                if (r4 != 0) goto L_0x0041
                r4 = 1
                r0 = r4
                goto L_0x0037
            L_0x0041:
                r4 = r1
                r3 = r4
                goto L_0x000b
            L_0x0044:
                r4 = r3
                if (r4 != 0) goto L_0x004a
                r4 = 0
                r0 = r4
                goto L_0x0037
            L_0x004a:
                r4 = r2
                if (r4 != 0) goto L_0x0035
            L_0x004d:
                r4 = r0
                int r4 = r4.charIndex
                if (r4 <= 0) goto L_0x0072
                r4 = r0
                byte r4 = r4.dirTypeBackward()
                switch(r4) {
                    case 14: goto L_0x005b;
                    case 15: goto L_0x005b;
                    case 16: goto L_0x0065;
                    case 17: goto L_0x0065;
                    case 18: goto L_0x006f;
                    default: goto L_0x005a;
                }
            L_0x005a:
                goto L_0x004d
            L_0x005b:
                r4 = r3
                r5 = r1
                if (r4 != r5) goto L_0x0062
                r4 = -1
                r0 = r4
                goto L_0x0037
            L_0x0062:
                int r1 = r1 + -1
                goto L_0x004d
            L_0x0065:
                r4 = r3
                r5 = r1
                if (r4 != r5) goto L_0x006c
                r4 = 1
                r0 = r4
                goto L_0x0037
            L_0x006c:
                int r1 = r1 + -1
                goto L_0x004d
            L_0x006f:
                int r1 = r1 + 1
                goto L_0x004d
            L_0x0072:
                r4 = 0
                r0 = r4
                goto L_0x0037
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.text.BidiFormatter.DirectionalityEstimator.getEntryDir():int");
        }

        /* access modifiers changed from: 0000 */
        public int getExitDir() {
            this.charIndex = this.length;
            int i = 0;
            int i2 = 0;
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case 0:
                        if (i == 0) {
                            break;
                        } else if (i2 == 0) {
                            i2 = i;
                            break;
                        } else {
                            continue;
                        }
                    case 1:
                    case 2:
                        if (i == 0) {
                            return 1;
                        }
                        if (i2 == 0) {
                            i2 = i;
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        break;
                    case 14:
                    case 15:
                        if (i2 == i) {
                            break;
                        } else {
                            i--;
                            continue;
                        }
                    case 16:
                    case 17:
                        if (i2 == i) {
                            return 1;
                        }
                        i--;
                        continue;
                    case 18:
                        i++;
                        continue;
                    default:
                        if (i2 == 0) {
                            i2 = i;
                            break;
                        } else {
                            continue;
                        }
                }
                return -1;
            }
            return 0;
        }
    }

    static {
        BidiFormatter bidiFormatter;
        BidiFormatter bidiFormatter2;
        BidiFormatter bidiFormatter3 = bidiFormatter;
        BidiFormatter bidiFormatter4 = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
        DEFAULT_LTR_INSTANCE = bidiFormatter3;
        BidiFormatter bidiFormatter5 = bidiFormatter2;
        BidiFormatter bidiFormatter6 = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
        DEFAULT_RTL_INSTANCE = bidiFormatter5;
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        int i2 = i;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat2 = textDirectionHeuristicCompat;
        this.mIsRtlContext = z;
        this.mFlags = i2;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat2;
    }

    /* synthetic */ BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat, C00961 r13) {
        C00961 r4 = r13;
        this(z, i, textDirectionHeuristicCompat);
    }

    private static int getEntryDir(String str) {
        DirectionalityEstimator directionalityEstimator;
        DirectionalityEstimator directionalityEstimator2 = directionalityEstimator;
        DirectionalityEstimator directionalityEstimator3 = new DirectionalityEstimator(str, false);
        return directionalityEstimator2.getEntryDir();
    }

    private static int getExitDir(String str) {
        DirectionalityEstimator directionalityEstimator;
        DirectionalityEstimator directionalityEstimator2 = directionalityEstimator;
        DirectionalityEstimator directionalityEstimator3 = new DirectionalityEstimator(str, false);
        return directionalityEstimator2.getExitDir();
    }

    public static BidiFormatter getInstance() {
        Builder builder;
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        return builder2.build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        Builder builder;
        Builder builder2 = builder;
        Builder builder3 = new Builder(locale);
        return builder2.build();
    }

    public static BidiFormatter getInstance(boolean z) {
        Builder builder;
        Builder builder2 = builder;
        Builder builder3 = new Builder(z);
        return builder2.build();
    }

    /* access modifiers changed from: private */
    public static boolean isRtlLocale(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private String markAfter(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        String str2 = str;
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str2, 0, str2.length());
        return (this.mIsRtlContext || (!isRtl && getExitDir(str2) != 1)) ? (!this.mIsRtlContext || (isRtl && getExitDir(str2) != -1)) ? "" : RLM_STRING : LRM_STRING;
    }

    private String markBefore(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        String str2 = str;
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str2, 0, str2.length());
        return (this.mIsRtlContext || (!isRtl && getEntryDir(str2) != 1)) ? (!this.mIsRtlContext || (isRtl && getEntryDir(str2) != -1)) ? "" : RLM_STRING : LRM_STRING;
    }

    public boolean getStereoReset() {
        return (2 & this.mFlags) != 0;
    }

    public boolean isRtl(String str) {
        String str2 = str;
        return this.mDefaultTextDirectionHeuristicCompat.isRtl((CharSequence) str2, 0, str2.length());
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        StringBuilder sb;
        String str2 = str;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat2 = textDirectionHeuristicCompat;
        boolean z2 = z;
        if (str2 == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat2.isRtl((CharSequence) str2, 0, str2.length());
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        if (getStereoReset() && z2) {
            StringBuilder append = sb4.append(markBefore(str2, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            StringBuilder append2 = sb4.append(isRtl ? (char) 8235 : 8234);
            StringBuilder append3 = sb4.append(str2);
            StringBuilder append4 = sb4.append(PDF);
        } else {
            StringBuilder append5 = sb4.append(str2);
        }
        if (z2) {
            StringBuilder append6 = sb4.append(markAfter(str2, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return sb4.toString();
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
    }
}
