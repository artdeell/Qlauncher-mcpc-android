package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzhb
public final class zzfl {

    /* renamed from: com.google.android.gms.internal.zzfl$1 */
    static /* synthetic */ class C03671 {
        static final /* synthetic */ int[] zzCS = new int[Gender.values().length];

        static {
            zzCT = new int[ErrorCode.values().length];
            try {
                zzCT[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
                NoSuchFieldError noSuchFieldError = e;
            }
            try {
                zzCT[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
                NoSuchFieldError noSuchFieldError2 = e2;
            }
            try {
                zzCT[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
                NoSuchFieldError noSuchFieldError3 = e3;
            }
            try {
                zzCT[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
                NoSuchFieldError noSuchFieldError4 = e4;
            }
            try {
                zzCS[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
                NoSuchFieldError noSuchFieldError5 = e5;
            }
            try {
                zzCS[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
                NoSuchFieldError noSuchFieldError6 = e6;
            }
            try {
                zzCS[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
                NoSuchFieldError noSuchFieldError7 = e7;
            }
        }
    }

    public static int zza(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static AdSize zzb(AdSizeParcel adSizeParcel) {
        AdSize adSize;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        for (int i = 0; i < adSizeArr.length; i++) {
            if (adSizeArr[i].getWidth() == adSizeParcel2.width && adSizeArr[i].getHeight() == adSizeParcel2.height) {
                return adSizeArr[i];
            }
        }
        AdSize adSize2 = adSize;
        AdSize adSize3 = new AdSize(zza.zza(adSizeParcel2.width, adSizeParcel2.height, adSizeParcel2.zzuh));
        return adSize2;
    }

    public static MediationAdRequest zzj(AdRequestParcel adRequestParcel) {
        HashSet hashSet;
        MediationAdRequest mediationAdRequest;
        Date date;
        HashSet hashSet2;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        if (adRequestParcel2.zztE != null) {
            HashSet hashSet3 = hashSet2;
            HashSet hashSet4 = new HashSet(adRequestParcel2.zztE);
            hashSet = hashSet3;
        } else {
            hashSet = null;
        }
        MediationAdRequest mediationAdRequest2 = mediationAdRequest;
        Date date2 = date;
        Date date3 = new Date(adRequestParcel2.zztC);
        MediationAdRequest mediationAdRequest3 = new MediationAdRequest(date2, zzu(adRequestParcel2.zztD), hashSet, adRequestParcel2.zztF, adRequestParcel2.zztK);
        return mediationAdRequest2;
    }

    public static Gender zzu(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
