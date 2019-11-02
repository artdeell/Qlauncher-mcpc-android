package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR;
    final int mVersionCode;
    private final Account zzTI;
    private final int zzamq;
    private final GoogleSignInAccount zzamr;

    static {
        zzy zzy;
        zzy zzy2 = zzy;
        zzy zzy3 = new zzy();
        CREATOR = zzy2;
    }

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        Account account2 = account;
        int i3 = i2;
        GoogleSignInAccount googleSignInAccount2 = googleSignInAccount;
        this.mVersionCode = i;
        this.zzTI = account2;
        this.zzamq = i3;
        this.zzamr = googleSignInAccount2;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzTI;
    }

    public int getSessionId() {
        return this.zzamq;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }

    @Nullable
    public GoogleSignInAccount zzqW() {
        return this.zzamr;
    }
}
