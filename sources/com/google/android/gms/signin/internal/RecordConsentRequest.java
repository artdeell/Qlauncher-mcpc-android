package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR;
    final int mVersionCode;
    private final Account zzTI;
    private final String zzXd;
    private final Scope[] zzbhh;

    static {
        zzf zzf;
        zzf zzf2 = zzf;
        zzf zzf3 = new zzf();
        CREATOR = zzf2;
    }

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        Account account2 = account;
        Scope[] scopeArr2 = scopeArr;
        String str2 = str;
        this.mVersionCode = i;
        this.zzTI = account2;
        this.zzbhh = scopeArr2;
        this.zzXd = str2;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzTI;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public Scope[] zzFM() {
        return this.zzbhh;
    }

    public String zzmR() {
        return this.zzXd;
    }
}
