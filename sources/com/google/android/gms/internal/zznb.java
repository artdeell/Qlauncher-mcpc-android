package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zznb {
    private static final Pattern zzaoi = Pattern.compile("\\\\.");
    private static final Pattern zzaoj = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    public static String zzcU(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            Matcher matcher = zzaoj.matcher(str2);
            StringBuffer stringBuffer2 = null;
            while (matcher.find()) {
                if (stringBuffer2 == null) {
                    StringBuffer stringBuffer3 = stringBuffer;
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer2 = stringBuffer3;
                }
                switch (matcher.group().charAt(0)) {
                    case 8:
                        Matcher appendReplacement = matcher.appendReplacement(stringBuffer2, "\\\\b");
                        break;
                    case 9:
                        Matcher appendReplacement2 = matcher.appendReplacement(stringBuffer2, "\\\\t");
                        break;
                    case 10:
                        Matcher appendReplacement3 = matcher.appendReplacement(stringBuffer2, "\\\\n");
                        break;
                    case 12:
                        Matcher appendReplacement4 = matcher.appendReplacement(stringBuffer2, "\\\\f");
                        break;
                    case 13:
                        Matcher appendReplacement5 = matcher.appendReplacement(stringBuffer2, "\\\\r");
                        break;
                    case '\"':
                        Matcher appendReplacement6 = matcher.appendReplacement(stringBuffer2, "\\\\\\\"");
                        break;
                    case '/':
                        Matcher appendReplacement7 = matcher.appendReplacement(stringBuffer2, "\\\\/");
                        break;
                    case '\\':
                        Matcher appendReplacement8 = matcher.appendReplacement(stringBuffer2, "\\\\\\\\");
                        break;
                }
            }
            if (stringBuffer2 != null) {
                StringBuffer appendTail = matcher.appendTail(stringBuffer2);
                return stringBuffer2.toString();
            }
        }
        return str2;
    }

    public static boolean zze(Object obj, Object obj2) {
        boolean z;
        Object obj3 = obj;
        Object obj4 = obj2;
        if (obj3 == null && obj4 == null) {
            z = true;
        } else {
            z = false;
            if (obj3 != null) {
                z = false;
                if (obj4 != null) {
                    if ((obj3 instanceof JSONObject) && (obj4 instanceof JSONObject)) {
                        JSONObject jSONObject = (JSONObject) obj3;
                        JSONObject jSONObject2 = (JSONObject) obj4;
                        z = false;
                        if (jSONObject.length() == jSONObject2.length()) {
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String str = (String) keys.next();
                                z = false;
                                if (jSONObject2.has(str)) {
                                    try {
                                        if (!zze(jSONObject.get(str), jSONObject2.get(str))) {
                                            return false;
                                        }
                                    } catch (JSONException e) {
                                        JSONException jSONException = e;
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                    } else if (!(obj3 instanceof JSONArray) || !(obj4 instanceof JSONArray)) {
                        return obj3.equals(obj4);
                    } else {
                        JSONArray jSONArray = (JSONArray) obj3;
                        JSONArray jSONArray2 = (JSONArray) obj4;
                        z = false;
                        if (jSONArray.length() == jSONArray2.length()) {
                            int i = 0;
                            while (i < jSONArray.length()) {
                                try {
                                    z = false;
                                    if (zze(jSONArray.get(i), jSONArray2.get(i))) {
                                        i++;
                                    }
                                } catch (JSONException e2) {
                                    JSONException jSONException2 = e2;
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return z;
    }
}
