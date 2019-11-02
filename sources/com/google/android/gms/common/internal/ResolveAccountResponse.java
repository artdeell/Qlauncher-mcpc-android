package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp.zza;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR;
    final int mVersionCode;
    private boolean zzahx;
    IBinder zzakA;
    private ConnectionResult zzams;
    private boolean zzamt;

    static {
        zzz zzz;
        zzz zzz2 = zzz;
        zzz zzz3 = new zzz();
        CREATOR = zzz2;
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        IBinder iBinder2 = iBinder;
        ConnectionResult connectionResult2 = connectionResult;
        boolean z3 = z;
        boolean z4 = z2;
        this.mVersionCode = i;
        this.zzakA = iBinder2;
        this.zzams = connectionResult2;
        this.zzahx = z3;
        this.zzamt = z4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (!(obj2 instanceof ResolveAccountResponse)) {
                return false;
            }
            ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj2;
            if (!this.zzams.equals(resolveAccountResponse.zzams) || !zzqX().equals(resolveAccountResponse.zzqX())) {
                return false;
            }
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
    }

    public zzp zzqX() {
        return zza.zzaP(this.zzakA);
    }

    public ConnectionResult zzqY() {
        return this.zzams;
    }

    public boolean zzqZ() {
        return this.zzahx;
    }

    public boolean zzra() {
        return this.zzamt;
    }
}
