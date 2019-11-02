package android.support.p000v4.text;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

/* renamed from: android.support.v4.text.TextUtilsCompat */
public class TextUtilsCompat {
    /* access modifiers changed from: private */
    public static String ARAB_SCRIPT_SUBTAG = "Arab";
    /* access modifiers changed from: private */
    public static String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final TextUtilsCompatImpl IMPL;
    public static final Locale ROOT;

    /* renamed from: android.support.v4.text.TextUtilsCompat$TextUtilsCompatImpl */
    private static class TextUtilsCompatImpl {
        private TextUtilsCompatImpl() {
        }

        /* synthetic */ TextUtilsCompatImpl(C00981 r4) {
            C00981 r1 = r4;
            this();
        }

        private static int getLayoutDirectionFromFirstChar(@NonNull Locale locale) {
            Locale locale2 = locale;
            switch (Character.getDirectionality(locale2.getDisplayName(locale2).charAt(0))) {
                case 1:
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }

        public int getLayoutDirectionFromLocale(@Nullable Locale locale) {
            Locale locale2 = locale;
            if (locale2 != null && !locale2.equals(TextUtilsCompat.ROOT)) {
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale2);
                if (maximizeAndGetScript == null) {
                    return getLayoutDirectionFromFirstChar(locale2);
                }
                if (maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) || maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG)) {
                    return 1;
                }
            }
            return 0;
        }

        @NonNull
        public String htmlEncode(@NonNull String str) {
            StringBuilder sb;
            String str2 = str;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = sb2;
            for (int i = 0; i < str2.length(); i++) {
                char charAt = str2.charAt(i);
                switch (charAt) {
                    case '\"':
                        StringBuilder append = sb4.append("&quot;");
                        break;
                    case '&':
                        StringBuilder append2 = sb4.append("&amp;");
                        break;
                    case '\'':
                        StringBuilder append3 = sb4.append("&#39;");
                        break;
                    case '<':
                        StringBuilder append4 = sb4.append("&lt;");
                        break;
                    case '>':
                        StringBuilder append5 = sb4.append("&gt;");
                        break;
                    default:
                        StringBuilder append6 = sb4.append(charAt);
                        break;
                }
            }
            return sb4.toString();
        }
    }

    /* renamed from: android.support.v4.text.TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl */
    private static class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
        private TextUtilsCompatJellybeanMr1Impl() {
            super(null);
        }

        /* synthetic */ TextUtilsCompatJellybeanMr1Impl(C00981 r4) {
            C00981 r1 = r4;
            this();
        }

        public int getLayoutDirectionFromLocale(@Nullable Locale locale) {
            return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(locale);
        }

        @NonNull
        public String htmlEncode(@NonNull String str) {
            return TextUtilsCompatJellybeanMr1.htmlEncode(str);
        }
    }

    static {
        TextUtilsCompatImpl textUtilsCompatImpl;
        Locale locale;
        TextUtilsCompatJellybeanMr1Impl textUtilsCompatJellybeanMr1Impl;
        if (VERSION.SDK_INT >= 17) {
            TextUtilsCompatJellybeanMr1Impl textUtilsCompatJellybeanMr1Impl2 = textUtilsCompatJellybeanMr1Impl;
            TextUtilsCompatJellybeanMr1Impl textUtilsCompatJellybeanMr1Impl3 = new TextUtilsCompatJellybeanMr1Impl(null);
            IMPL = textUtilsCompatJellybeanMr1Impl2;
        } else {
            TextUtilsCompatImpl textUtilsCompatImpl2 = textUtilsCompatImpl;
            TextUtilsCompatImpl textUtilsCompatImpl3 = new TextUtilsCompatImpl(null);
            IMPL = textUtilsCompatImpl2;
        }
        Locale locale2 = locale;
        Locale locale3 = new Locale(LibrariesRepository.MOJANG_MAVEN_REPO, LibrariesRepository.MOJANG_MAVEN_REPO);
        ROOT = locale2;
    }

    public TextUtilsCompat() {
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        return IMPL.getLayoutDirectionFromLocale(locale);
    }

    @NonNull
    public static String htmlEncode(@NonNull String str) {
        return IMPL.htmlEncode(str);
    }
}
