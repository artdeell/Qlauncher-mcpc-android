package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class zzaf {
    public static String zza(String str, String str2, Context context, AttributeSet attributeSet, boolean z, boolean z2, String str3) {
        StringBuilder sb;
        TypedValue typedValue;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String str4 = str2;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        boolean z3 = z;
        boolean z4 = z2;
        String str5 = str3;
        String attributeValue = attributeSet2 == null ? null : attributeSet2.getAttributeValue(str, str4);
        if (attributeValue != null && attributeValue.startsWith("@string/") && z3) {
            String substring = attributeValue.substring("@string/".length());
            String packageName = context2.getPackageName();
            TypedValue typedValue2 = typedValue;
            TypedValue typedValue3 = new TypedValue();
            TypedValue typedValue4 = typedValue2;
            try {
                Resources resources = context2.getResources();
                StringBuilder sb5 = sb4;
                StringBuilder sb6 = new StringBuilder();
                resources.getValue(sb5.append(packageName).append(":string/").append(substring).toString(), typedValue4, true);
            } catch (NotFoundException e) {
                NotFoundException notFoundException = e;
                String str6 = str5;
                StringBuilder sb7 = sb2;
                StringBuilder sb8 = new StringBuilder();
                int w = Log.w(str6, sb7.append("Could not find resource for ").append(str4).append(": ").append(attributeValue).toString());
            }
            if (typedValue4.string != null) {
                attributeValue = typedValue4.string.toString();
            } else {
                String str7 = str5;
                StringBuilder sb9 = sb3;
                StringBuilder sb10 = new StringBuilder();
                int w2 = Log.w(str7, sb9.append("Resource ").append(str4).append(" was not a string: ").append(typedValue4).toString());
            }
        }
        if (z4 && attributeValue == null) {
            String str8 = str5;
            StringBuilder sb11 = sb;
            StringBuilder sb12 = new StringBuilder();
            int w3 = Log.w(str8, sb11.append("Required XML attribute \"").append(str4).append("\" missing").toString());
        }
        return attributeValue;
    }
}
