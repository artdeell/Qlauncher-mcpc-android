package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb.zza;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class zzx {
    public static String zza(Map<String, String> map) {
        return zzb(map, "ISO-8859-1");
    }

    public static zza zzb(zzi zzi) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        zza zza;
        zzi zzi2 = zzi;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzi2.zzA;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = (String) map.get("Date");
        if (str != null) {
            j3 = zzg(str);
        }
        String str2 = (String) map.get("Cache-Control");
        if (str2 != null) {
            String[] split = str2.split(",");
            z = false;
            long j6 = 0;
            long j7 = 0;
            for (int i = 0; i < split.length; i++) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j7 = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                        Exception exc = e;
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    try {
                        j6 = Long.parseLong(trim.substring(23));
                    } catch (Exception e2) {
                        Exception exc2 = e2;
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
            }
            j4 = j7;
            j5 = j6;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        String str3 = (String) map.get("Expires");
        long j8 = str3 != null ? zzg(str3) : 0;
        String str4 = (String) map.get("Last-Modified");
        long j9 = str4 != null ? zzg(str4) : 0;
        String str5 = (String) map.get("ETag");
        if (z2) {
            j2 = currentTimeMillis + (1000 * j4);
            j = z ? j2 : j2 + (1000 * j5);
        } else if (j3 <= 0 || j8 < j3) {
            j = 0;
            j2 = 0;
        } else {
            j = currentTimeMillis + (j8 - j3);
            j2 = j;
        }
        zza zza2 = zza;
        zza zza3 = new zza();
        zza zza4 = zza2;
        zza4.data = zzi2.data;
        zza4.zzb = str5;
        zza4.zzf = j2;
        zza4.zze = j;
        zza4.zzc = j3;
        zza4.zzd = j9;
        zza4.zzg = map;
        return zza4;
    }

    public static String zzb(Map<String, String> map, String str) {
        String str2 = str;
        String str3 = (String) map.get("Content-Type");
        if (str3 != null) {
            String[] split = str3.split(";");
            int i = 1;
            while (true) {
                if (i >= split.length) {
                    break;
                }
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    str2 = split2[1];
                    break;
                }
                i++;
            }
        }
        return str2;
    }

    public static long zzg(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            DateParseException dateParseException = e;
            return 0;
        }
    }
}
