package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

@zzhb
public abstract class zzby {
    @zzhb
    public static final zzby zzxs;
    @zzhb
    public static final zzby zzxt;
    @zzhb
    public static final zzby zzxu;

    static {
        C02811 r2;
        C02822 r22;
        C02833 r23;
        C02811 r0 = r2;
        C02811 r1 = new zzby() {
            public String zzb(@Nullable String str, String str2) {
                String str3 = str;
                return str2;
            }
        };
        zzxs = r0;
        C02822 r02 = r22;
        C02822 r12 = new zzby() {
            public String zzb(@Nullable String str, String str2) {
                String str3 = str;
                return str3 != null ? str3 : str2;
            }
        };
        zzxt = r02;
        C02833 r03 = r23;
        C02833 r13 = new zzby() {
            @Nullable
            private String zzM(@Nullable String str) {
                String str2 = str;
                if (!TextUtils.isEmpty(str2)) {
                    int i = 0;
                    int length = str2.length();
                    while (i < str2.length() && str2.charAt(i) == ',') {
                        i++;
                    }
                    while (length > 0 && str2.charAt(length - 1) == ',') {
                        length--;
                    }
                    if (!(i == 0 && length == str2.length())) {
                        return str2.substring(i, length);
                    }
                }
                return str2;
            }

            public String zzb(@Nullable String str, String str2) {
                StringBuilder sb;
                String str3 = str2;
                String zzM = zzM(str);
                String zzM2 = zzM(str3);
                if (TextUtils.isEmpty(zzM)) {
                    return zzM2;
                }
                if (TextUtils.isEmpty(zzM2)) {
                    return zzM;
                }
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return sb2.append(zzM).append(",").append(zzM2).toString();
            }
        };
        zzxu = r03;
    }

    public zzby() {
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        Map<String, String> map2 = map;
        String str3 = str;
        Object put = map2.put(str3, zzb((String) map2.get(str3), str2));
    }

    public abstract String zzb(@Nullable String str, String str2);
}
