package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;

public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR;
    private final int mVersionCode;
    private final StringToIntConverter zzamF;

    static {
        zza zza;
        zza zza2 = zza;
        zza zza3 = new zza();
        CREATOR = zza2;
    }

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        StringToIntConverter stringToIntConverter2 = stringToIntConverter;
        this.mVersionCode = i;
        this.zzamF = stringToIntConverter2;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        StringToIntConverter stringToIntConverter2 = stringToIntConverter;
        this.mVersionCode = 1;
        this.zzamF = stringToIntConverter2;
    }

    public static ConverterWrapper zza(zza<?, ?> zza) {
        IllegalArgumentException illegalArgumentException;
        ConverterWrapper converterWrapper;
        zza<?, ?> zza2 = zza;
        if (zza2 instanceof StringToIntConverter) {
            ConverterWrapper converterWrapper2 = converterWrapper;
            ConverterWrapper converterWrapper3 = new ConverterWrapper((StringToIntConverter) zza2);
            return converterWrapper2;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        throw illegalArgumentException2;
    }

    public int describeContents() {
        zza zza = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        zza zza = CREATOR;
        zza.zza(this, parcel2, i2);
    }

    /* access modifiers changed from: 0000 */
    public StringToIntConverter zzrg() {
        return this.zzamF;
    }

    public zza<?, ?> zzrh() {
        IllegalStateException illegalStateException;
        if (this.zzamF != null) {
            return this.zzamF;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        throw illegalStateException2;
    }
}
