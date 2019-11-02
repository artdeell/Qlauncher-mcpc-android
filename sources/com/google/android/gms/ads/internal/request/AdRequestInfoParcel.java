package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import java.util.Collections;
import java.util.List;

@zzhb
public final class AdRequestInfoParcel implements SafeParcelable {
    public static final zzf CREATOR;
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final Bundle zzHA;
    public final boolean zzHB;
    public final Messenger zzHC;
    public final int zzHD;
    public final int zzHE;
    public final float zzHF;
    public final String zzHG;
    public final long zzHH;
    public final String zzHI;
    public final List<String> zzHJ;
    public final List<String> zzHK;
    public final long zzHL;
    public final CapabilityParcel zzHM;
    public final String zzHN;
    public final float zzHO;
    public final int zzHP;
    public final int zzHQ;
    public final Bundle zzHs;
    public final AdRequestParcel zzHt;
    public final PackageInfo zzHu;
    public final String zzHv;
    public final String zzHw;
    public final String zzHx;
    public final Bundle zzHy;
    public final int zzHz;
    public final NativeAdOptionsParcel zzrD;
    public final List<String> zzrH;
    public final String zzri;
    public final String zzrj;
    public final VersionInfoParcel zzrl;
    public final AdSizeParcel zzrp;

    @zzhb
    public static final class zza {
        public final ApplicationInfo applicationInfo;
        public final Bundle zzHA;
        public final boolean zzHB;
        public final Messenger zzHC;
        public final int zzHD;
        public final int zzHE;
        public final float zzHF;
        public final String zzHG;
        public final long zzHH;
        public final String zzHI;
        public final List<String> zzHJ;
        public final List<String> zzHK;
        public final CapabilityParcel zzHM;
        public final String zzHN;
        public final float zzHO;
        public final int zzHP;
        public final int zzHQ;
        public final Bundle zzHs;
        public final AdRequestParcel zzHt;
        public final PackageInfo zzHu;
        public final String zzHw;
        public final String zzHx;
        public final Bundle zzHy;
        public final int zzHz;
        public final NativeAdOptionsParcel zzrD;
        public final List<String> zzrH;
        public final String zzri;
        public final String zzrj;
        public final VersionInfoParcel zzrl;
        public final AdSizeParcel zzrp;

        public zza(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, List<String> list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel, CapabilityParcel capabilityParcel, String str7, float f2, int i3, int i4) {
            AdRequestParcel adRequestParcel2 = adRequestParcel;
            AdSizeParcel adSizeParcel2 = adSizeParcel;
            String str8 = str;
            ApplicationInfo applicationInfo3 = applicationInfo2;
            PackageInfo packageInfo2 = packageInfo;
            String str9 = str2;
            String str10 = str3;
            VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
            Bundle bundle4 = bundle2;
            List<String> list4 = list;
            List<String> list5 = list2;
            Bundle bundle5 = bundle3;
            boolean z2 = z;
            Messenger messenger2 = messenger;
            int i5 = i;
            int i6 = i2;
            float f3 = f;
            String str11 = str4;
            long j2 = j;
            String str12 = str5;
            List<String> list6 = list3;
            String str13 = str6;
            NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
            CapabilityParcel capabilityParcel2 = capabilityParcel;
            String str14 = str7;
            float f4 = f2;
            int i7 = i3;
            int i8 = i4;
            this.zzHs = bundle;
            this.zzHt = adRequestParcel2;
            this.zzrp = adSizeParcel2;
            this.zzrj = str8;
            this.applicationInfo = applicationInfo3;
            this.zzHu = packageInfo2;
            this.zzHw = str9;
            this.zzHx = str10;
            this.zzrl = versionInfoParcel2;
            this.zzHy = bundle4;
            this.zzHB = z2;
            this.zzHC = messenger2;
            this.zzHD = i5;
            this.zzHE = i6;
            this.zzHF = f3;
            if (list4 == null || list4.size() <= 0) {
                if (adSizeParcel2.zzum) {
                    this.zzHz = 4;
                } else {
                    this.zzHz = 0;
                }
                this.zzrH = null;
                this.zzHK = null;
            } else {
                this.zzHz = 3;
                this.zzrH = list4;
                this.zzHK = list5;
            }
            this.zzHA = bundle5;
            this.zzHG = str11;
            this.zzHH = j2;
            this.zzHI = str12;
            this.zzHJ = list6;
            this.zzri = str13;
            this.zzrD = nativeAdOptionsParcel2;
            this.zzHM = capabilityParcel2;
            this.zzHN = str14;
            this.zzHO = f4;
            this.zzHP = i7;
            this.zzHQ = i8;
        }
    }

    static {
        zzf zzf;
        zzf zzf2 = zzf;
        zzf zzf3 = new zzf();
        CREATOR = zzf2;
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3, long j2, CapabilityParcel capabilityParcel, String str8, float f2, int i5, int i6) {
        Bundle bundle4 = bundle;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        AdSizeParcel adSizeParcel2 = adSizeParcel;
        String str9 = str;
        ApplicationInfo applicationInfo3 = applicationInfo2;
        PackageInfo packageInfo2 = packageInfo;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        Bundle bundle5 = bundle2;
        int i7 = i2;
        List<String> list4 = list;
        Bundle bundle6 = bundle3;
        boolean z2 = z;
        Messenger messenger2 = messenger;
        int i8 = i3;
        int i9 = i4;
        float f3 = f;
        String str13 = str5;
        long j3 = j;
        String str14 = str6;
        List<String> list5 = list2;
        String str15 = str7;
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        List<String> list6 = list3;
        long j4 = j2;
        CapabilityParcel capabilityParcel2 = capabilityParcel;
        String str16 = str8;
        float f4 = f2;
        int i10 = i5;
        int i11 = i6;
        this.versionCode = i;
        this.zzHs = bundle4;
        this.zzHt = adRequestParcel2;
        this.zzrp = adSizeParcel2;
        this.zzrj = str9;
        this.applicationInfo = applicationInfo3;
        this.zzHu = packageInfo2;
        this.zzHv = str10;
        this.zzHw = str11;
        this.zzHx = str12;
        this.zzrl = versionInfoParcel2;
        this.zzHy = bundle5;
        this.zzHz = i7;
        this.zzrH = list4;
        this.zzHK = list6 == null ? Collections.emptyList() : Collections.unmodifiableList(list6);
        this.zzHA = bundle6;
        this.zzHB = z2;
        this.zzHC = messenger2;
        this.zzHD = i8;
        this.zzHE = i9;
        this.zzHF = f3;
        this.zzHG = str13;
        this.zzHH = j3;
        this.zzHI = str14;
        this.zzHJ = list5 == null ? Collections.emptyList() : Collections.unmodifiableList(list5);
        this.zzri = str15;
        this.zzrD = nativeAdOptionsParcel2;
        this.zzHL = j4;
        this.zzHM = capabilityParcel2;
        this.zzHN = str16;
        this.zzHO = f4;
        this.zzHP = i10;
        this.zzHQ = i11;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, long j2, CapabilityParcel capabilityParcel, String str8, float f2, int i4, int i5) {
        this(15, bundle, adRequestParcel, adSizeParcel, str, applicationInfo2, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, j, str6, list3, str7, nativeAdOptionsParcel, list2, j2, capabilityParcel, str8, f2, i4, i5);
    }

    public AdRequestInfoParcel(zza zza2, String str, long j) {
        zza zza3 = zza2;
        this(zza3.zzHs, zza3.zzHt, zza3.zzrp, zza3.zzrj, zza3.applicationInfo, zza3.zzHu, str, zza3.zzHw, zza3.zzHx, zza3.zzrl, zza3.zzHy, zza3.zzHz, zza3.zzrH, zza3.zzHK, zza3.zzHA, zza3.zzHB, zza3.zzHC, zza3.zzHD, zza3.zzHE, zza3.zzHF, zza3.zzHG, zza3.zzHH, zza3.zzHI, zza3.zzHJ, zza3.zzri, zza3.zzrD, j, zza3.zzHM, zza3.zzHN, zza3.zzHO, zza3.zzHP, zza3.zzHQ);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
