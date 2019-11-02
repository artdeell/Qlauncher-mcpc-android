package android.support.p000v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat */
public class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    private static final AccessibilityServiceInfoVersionImpl IMPL;

    /* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl */
    static class AccessibilityServiceInfoIcsImpl extends AccessibilityServiceInfoStubImpl {
        AccessibilityServiceInfoIcsImpl() {
        }

        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(accessibilityServiceInfo);
        }

        public int getCapabilities(AccessibilityServiceInfo accessibilityServiceInfo) {
            return getCanRetrieveWindowContent(accessibilityServiceInfo) ? 1 : 0;
        }

        public String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getDescription(accessibilityServiceInfo);
        }

        public String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getId(accessibilityServiceInfo);
        }

        public ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getResolveInfo(accessibilityServiceInfo);
        }

        public String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getSettingsActivityName(accessibilityServiceInfo);
        }
    }

    /* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoJellyBeanMr2 */
    static class AccessibilityServiceInfoJellyBeanMr2 extends AccessibilityServiceInfoIcsImpl {
        AccessibilityServiceInfoJellyBeanMr2() {
        }

        public int getCapabilities(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatJellyBeanMr2.getCapabilities(accessibilityServiceInfo);
        }
    }

    /* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl */
    static class AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoVersionImpl {
        AccessibilityServiceInfoStubImpl() {
        }

        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
            AccessibilityServiceInfo accessibilityServiceInfo2 = accessibilityServiceInfo;
            return false;
        }

        public int getCapabilities(AccessibilityServiceInfo accessibilityServiceInfo) {
            AccessibilityServiceInfo accessibilityServiceInfo2 = accessibilityServiceInfo;
            return 0;
        }

        public String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
            AccessibilityServiceInfo accessibilityServiceInfo2 = accessibilityServiceInfo;
            return null;
        }

        public String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
            AccessibilityServiceInfo accessibilityServiceInfo2 = accessibilityServiceInfo;
            return null;
        }

        public ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
            AccessibilityServiceInfo accessibilityServiceInfo2 = accessibilityServiceInfo;
            return null;
        }

        public String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
            AccessibilityServiceInfo accessibilityServiceInfo2 = accessibilityServiceInfo;
            return null;
        }
    }

    /* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoVersionImpl */
    interface AccessibilityServiceInfoVersionImpl {
        boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo);

        int getCapabilities(AccessibilityServiceInfo accessibilityServiceInfo);

        String getDescription(AccessibilityServiceInfo accessibilityServiceInfo);

        String getId(AccessibilityServiceInfo accessibilityServiceInfo);

        ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo);

        String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo);
    }

    static {
        AccessibilityServiceInfoStubImpl accessibilityServiceInfoStubImpl;
        AccessibilityServiceInfoIcsImpl accessibilityServiceInfoIcsImpl;
        AccessibilityServiceInfoJellyBeanMr2 accessibilityServiceInfoJellyBeanMr2;
        if (VERSION.SDK_INT >= 18) {
            AccessibilityServiceInfoJellyBeanMr2 accessibilityServiceInfoJellyBeanMr22 = accessibilityServiceInfoJellyBeanMr2;
            AccessibilityServiceInfoJellyBeanMr2 accessibilityServiceInfoJellyBeanMr23 = new AccessibilityServiceInfoJellyBeanMr2();
            IMPL = accessibilityServiceInfoJellyBeanMr22;
        } else if (VERSION.SDK_INT >= 14) {
            AccessibilityServiceInfoIcsImpl accessibilityServiceInfoIcsImpl2 = accessibilityServiceInfoIcsImpl;
            AccessibilityServiceInfoIcsImpl accessibilityServiceInfoIcsImpl3 = new AccessibilityServiceInfoIcsImpl();
            IMPL = accessibilityServiceInfoIcsImpl2;
        } else {
            AccessibilityServiceInfoStubImpl accessibilityServiceInfoStubImpl2 = accessibilityServiceInfoStubImpl;
            AccessibilityServiceInfoStubImpl accessibilityServiceInfoStubImpl3 = new AccessibilityServiceInfoStubImpl();
            IMPL = accessibilityServiceInfoStubImpl2;
        }
    }

    private AccessibilityServiceInfoCompat() {
    }

    public static String capabilityToString(int i) {
        switch (i) {
            case 1:
                return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
            case 2:
                return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
            case 4:
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 8:
                return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
            default:
                return "UNKNOWN";
        }
    }

    public static String feedbackTypeToString(int i) {
        StringBuilder sb;
        int i2 = i;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("[");
        while (i2 > 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i2);
            i2 &= numberOfTrailingZeros ^ -1;
            if (sb4.length() > 1) {
                StringBuilder append2 = sb4.append(", ");
            }
            switch (numberOfTrailingZeros) {
                case 1:
                    StringBuilder append3 = sb4.append("FEEDBACK_SPOKEN");
                    break;
                case 2:
                    StringBuilder append4 = sb4.append("FEEDBACK_HAPTIC");
                    break;
                case 4:
                    StringBuilder append5 = sb4.append("FEEDBACK_AUDIBLE");
                    break;
                case 8:
                    StringBuilder append6 = sb4.append("FEEDBACK_VISUAL");
                    break;
                case 16:
                    StringBuilder append7 = sb4.append("FEEDBACK_GENERIC");
                    break;
            }
        }
        StringBuilder append8 = sb4.append("]");
        return sb4.toString();
    }

    public static String flagToString(int i) {
        switch (i) {
            case 1:
                return "DEFAULT";
            case 2:
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            case 4:
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            case 8:
                return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 16:
                return "FLAG_REPORT_VIEW_IDS";
            case 32:
                return "FLAG_REQUEST_FILTER_KEY_EVENTS";
            default:
                return null;
        }
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getCanRetrieveWindowContent(accessibilityServiceInfo);
    }

    public static int getCapabilities(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getCapabilities(accessibilityServiceInfo);
    }

    public static String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getDescription(accessibilityServiceInfo);
    }

    public static String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getId(accessibilityServiceInfo);
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getResolveInfo(accessibilityServiceInfo);
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getSettingsActivityName(accessibilityServiceInfo);
    }
}
