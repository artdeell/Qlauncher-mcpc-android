package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp.zza;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR;
    final int version;
    final int zzall;
    int zzalm;
    String zzaln;
    IBinder zzalo;
    Scope[] zzalp;
    Bundle zzalq;
    Account zzalr;

    static {
        zzi zzi;
        zzi zzi2 = zzi;
        zzi zzi3 = new zzi();
        CREATOR = zzi2;
    }

    public GetServiceRequest(int i) {
        int i2 = i;
        this.version = 2;
        this.zzalm = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzall = i2;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        String str2 = str;
        IBinder iBinder2 = iBinder;
        Scope[] scopeArr2 = scopeArr;
        Bundle bundle2 = bundle;
        Account account2 = account;
        this.version = i4;
        this.zzall = i5;
        this.zzalm = i6;
        this.zzaln = str2;
        if (i4 < 2) {
            this.zzalr = zzaO(iBinder2);
        } else {
            this.zzalo = iBinder2;
            this.zzalr = account2;
        }
        this.zzalp = scopeArr2;
        this.zzalq = bundle2;
    }

    private Account zzaO(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        Account account = null;
        if (iBinder2 != null) {
            account = zza.zza(zza.zzaP(iBinder2));
        }
        return account;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public GetServiceRequest zzb(zzp zzp) {
        zzp zzp2 = zzp;
        if (zzp2 != null) {
            this.zzalo = zzp2.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzc(Account account) {
        this.zzalr = account;
        return this;
    }

    public GetServiceRequest zzcG(String str) {
        this.zzaln = str;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        Collection<Scope> collection2 = collection;
        this.zzalp = (Scope[]) collection2.toArray(new Scope[collection2.size()]);
        return this;
    }

    public GetServiceRequest zzj(Bundle bundle) {
        this.zzalq = bundle;
        return this;
    }
}
