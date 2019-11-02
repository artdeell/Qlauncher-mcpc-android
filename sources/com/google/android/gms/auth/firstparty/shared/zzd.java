package com.google.android.gms.auth.firstparty.shared;

public enum zzd {
    ;
    
    private final String zzZA;

    private zzd(String str) {
        String str2 = r8;
        int i = r9;
        this.zzZA = str;
    }

    public static boolean zza(zzd zzd) {
        zzd zzd2 = zzd;
        return zzYK.equals(zzd2) || zzYT.equals(zzd2) || zzYW.equals(zzd2) || zzYO.equals(zzd2) || zzYY.equals(zzd2) || zzZa.equals(zzd2) || zzb(zzd2);
    }

    public static boolean zzb(zzd zzd) {
        zzd zzd2 = zzd;
        return zzYD.equals(zzd2) || zzZb.equals(zzd2) || zzZc.equals(zzd2) || zzZd.equals(zzd2) || zzZe.equals(zzd2) || zzZf.equals(zzd2) || zzZg.equals(zzd2) || zzZh.equals(zzd2);
    }

    public static final zzd zzbY(String str) {
        String str2 = str;
        zzd zzd = null;
        zzd[] values = values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            zzd zzd2 = values[i];
            if (!zzd2.zzZA.equals(str2)) {
                zzd2 = zzd;
            }
            i++;
            zzd = zzd2;
        }
        return zzd;
    }

    public static boolean zzc(zzd zzd) {
        zzd zzd2 = zzd;
        return zzYH.equals(zzd2) || zzYI.equals(zzd2);
    }
}
