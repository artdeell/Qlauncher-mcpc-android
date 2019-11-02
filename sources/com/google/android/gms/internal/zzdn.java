package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.util.Map;

public class zzdn implements zzdf {
    private final zza zzzH;

    public interface zza {
        void zzb(RewardItemParcel rewardItemParcel);

        void zzbq();
    }

    public zzdn(zza zza2) {
        this.zzzH = zza2;
    }

    public static void zza(zzjp zzjp, zza zza2) {
        zzdn zzdn;
        zzdn zzdn2 = zzdn;
        zzdn zzdn3 = new zzdn(zza2);
        zzjp.zzhU().zza("/reward", (zzdf) zzdn2);
    }

    private void zze(Map<String, String> map) {
        RewardItemParcel rewardItemParcel;
        RewardItemParcel rewardItemParcel2;
        Map<String, String> map2 = map;
        try {
            int parseInt = Integer.parseInt((String) map2.get("amount"));
            String str = (String) map2.get(MimeTypeParser.TAG_TYPE);
            if (!TextUtils.isEmpty(str)) {
                RewardItemParcel rewardItemParcel3 = rewardItemParcel2;
                RewardItemParcel rewardItemParcel4 = new RewardItemParcel(str, parseInt);
                rewardItemParcel = rewardItemParcel3;
                this.zzzH.zzb(rewardItemParcel);
            }
        } catch (NumberFormatException e) {
            zzin.zzd("Unable to parse reward amount.", e);
        }
        rewardItemParcel = null;
        this.zzzH.zzb(rewardItemParcel);
    }

    private void zzf(Map<String, String> map) {
        Map<String, String> map2 = map;
        this.zzzH.zzbq();
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        zzjp zzjp2 = zzjp;
        Map<String, String> map2 = map;
        String str = (String) map2.get("action");
        if ("grant".equals(str)) {
            zze(map2);
        } else if ("video_start".equals(str)) {
            zzf(map2);
        }
    }
}
