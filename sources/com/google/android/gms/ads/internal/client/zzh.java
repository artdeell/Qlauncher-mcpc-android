package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzhb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzhb
public class zzh {
    public static final zzh zzug;

    static {
        zzh zzh;
        zzh zzh2 = zzh;
        zzh zzh3 = new zzh();
        zzug = zzh2;
    }

    protected zzh() {
    }

    public static zzh zzcO() {
        return zzug;
    }

    public AdRequestParcel zza(Context context, zzaa zzaa) {
        List list;
        SearchAdRequestParcel searchAdRequestParcel;
        AdRequestParcel adRequestParcel;
        ArrayList arrayList;
        SearchAdRequestParcel searchAdRequestParcel2;
        ArrayList arrayList2;
        Context context2 = context;
        zzaa zzaa2 = zzaa;
        Date birthday = zzaa2.getBirthday();
        long j = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzaa2.getContentUrl();
        int gender = zzaa2.getGender();
        Set keywords = zzaa2.getKeywords();
        if (!keywords.isEmpty()) {
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(keywords);
            list = Collections.unmodifiableList(arrayList3);
        } else {
            list = null;
        }
        boolean isTestDevice = zzaa2.isTestDevice(context2);
        int zzdd = zzaa2.zzdd();
        Location location = zzaa2.getLocation();
        Bundle networkExtrasBundle = zzaa2.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzaa2.getManualImpressionsEnabled();
        String publisherProvidedId = zzaa2.getPublisherProvidedId();
        SearchAdRequest zzda = zzaa2.zzda();
        if (zzda != null) {
            SearchAdRequestParcel searchAdRequestParcel3 = searchAdRequestParcel2;
            SearchAdRequestParcel searchAdRequestParcel4 = new SearchAdRequestParcel(zzda);
            searchAdRequestParcel = searchAdRequestParcel3;
        } else {
            searchAdRequestParcel = null;
        }
        Context applicationContext = context2.getApplicationContext();
        String str = null;
        if (applicationContext != null) {
            str = zzn.zzcS().zza(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        boolean isDesignedForFamilies = zzaa2.isDesignedForFamilies();
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        long j2 = j;
        Bundle bundle = networkExtrasBundle;
        int i = gender;
        List list2 = list;
        boolean z = isTestDevice;
        int i2 = zzdd;
        boolean z2 = manualImpressionsEnabled;
        String str2 = publisherProvidedId;
        SearchAdRequestParcel searchAdRequestParcel5 = searchAdRequestParcel;
        Location location2 = location;
        String str3 = contentUrl;
        Bundle zzdc = zzaa2.zzdc();
        Bundle customTargeting = zzaa2.getCustomTargeting();
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = new ArrayList(zzaa2.zzde());
        AdRequestParcel adRequestParcel3 = new AdRequestParcel(7, j2, bundle, i, list2, z, i2, z2, str2, searchAdRequestParcel5, location2, str3, zzdc, customTargeting, Collections.unmodifiableList(arrayList5), zzaa2.zzcZ(), str, isDesignedForFamilies);
        return adRequestParcel2;
    }

    public RewardedVideoAdRequestParcel zza(Context context, zzaa zzaa, String str) {
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel;
        String str2 = str;
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel2 = rewardedVideoAdRequestParcel;
        RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel3 = new RewardedVideoAdRequestParcel(zza(context, zzaa), str2);
        return rewardedVideoAdRequestParcel2;
    }
}
