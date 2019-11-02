package android.support.p000v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.TextViewCompatDonut */
class TextViewCompatDonut {
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompatDonut";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    TextViewCompatDonut() {
    }

    static int getMaxLines(TextView textView) {
        TextView textView2 = textView;
        if (!sMaxModeFieldFetched) {
            sMaxModeField = retrieveField("mMaxMode");
            sMaxModeFieldFetched = true;
        }
        if (sMaxModeField != null && retrieveIntFromField(sMaxModeField, textView2) == 1) {
            if (!sMaximumFieldFetched) {
                sMaximumField = retrieveField("mMaximum");
                sMaximumFieldFetched = true;
            }
            if (sMaximumField != null) {
                return retrieveIntFromField(sMaximumField, textView2);
            }
        }
        return -1;
    }

    static int getMinLines(TextView textView) {
        TextView textView2 = textView;
        if (!sMinModeFieldFetched) {
            sMinModeField = retrieveField("mMinMode");
            sMinModeFieldFetched = true;
        }
        if (sMinModeField != null && retrieveIntFromField(sMinModeField, textView2) == 1) {
            if (!sMinimumFieldFetched) {
                sMinimumField = retrieveField("mMinimum");
                sMinimumFieldFetched = true;
            }
            if (sMinimumField != null) {
                return retrieveIntFromField(sMinimumField, textView2);
            }
        }
        return -1;
    }

    private static Field retrieveField(String str) {
        StringBuilder sb;
        String str2 = str;
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str2);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            NoSuchFieldException noSuchFieldException = e;
            String str3 = LOG_TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int e2 = Log.e(str3, sb2.append("Could not retrieve ").append(str2).append(" field.").toString());
            return field;
        }
    }

    private static int retrieveIntFromField(Field field, TextView textView) {
        StringBuilder sb;
        Field field2 = field;
        try {
            return field2.getInt(textView);
        } catch (IllegalAccessException e) {
            IllegalAccessException illegalAccessException = e;
            String str = LOG_TAG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int d = Log.d(str, sb2.append("Could not retrieve value of ").append(field2.getName()).append(" field.").toString());
            return -1;
        }
    }
}
