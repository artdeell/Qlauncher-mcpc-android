package android.support.p000v4.text;

import android.os.Build.VERSION;
import java.util.Locale;

/* renamed from: android.support.v4.text.ICUCompat */
public class ICUCompat {
    private static final ICUCompatImpl IMPL;

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImpl */
    interface ICUCompatImpl {
        String maximizeAndGetScript(Locale locale);
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplBase */
    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        public String maximizeAndGetScript(Locale locale) {
            Locale locale2 = locale;
            return null;
        }
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplIcs */
    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatIcs.maximizeAndGetScript(locale);
        }
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplLollipop */
    static class ICUCompatImplLollipop implements ICUCompatImpl {
        ICUCompatImplLollipop() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatApi23.maximizeAndGetScript(locale);
        }
    }

    static {
        ICUCompatImplBase iCUCompatImplBase;
        ICUCompatImplIcs iCUCompatImplIcs;
        ICUCompatImplLollipop iCUCompatImplLollipop;
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            ICUCompatImplLollipop iCUCompatImplLollipop2 = iCUCompatImplLollipop;
            ICUCompatImplLollipop iCUCompatImplLollipop3 = new ICUCompatImplLollipop();
            IMPL = iCUCompatImplLollipop2;
        } else if (i >= 14) {
            ICUCompatImplIcs iCUCompatImplIcs2 = iCUCompatImplIcs;
            ICUCompatImplIcs iCUCompatImplIcs3 = new ICUCompatImplIcs();
            IMPL = iCUCompatImplIcs2;
        } else {
            ICUCompatImplBase iCUCompatImplBase2 = iCUCompatImplBase;
            ICUCompatImplBase iCUCompatImplBase3 = new ICUCompatImplBase();
            IMPL = iCUCompatImplBase2;
        }
    }

    public ICUCompat() {
    }

    public static String maximizeAndGetScript(Locale locale) {
        return IMPL.maximizeAndGetScript(locale);
    }
}
