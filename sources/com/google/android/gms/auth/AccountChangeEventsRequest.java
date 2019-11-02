package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR;
    final int mVersion;
    Account zzTI;
    @Deprecated
    String zzVa;
    int zzVc;

    static {
        zzb zzb;
        zzb zzb2 = zzb;
        zzb zzb3 = new zzb();
        CREATOR = zzb2;
    }

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        Account account2;
        int i3 = i2;
        String str2 = str;
        Account account3 = account;
        this.mVersion = i;
        this.zzVc = i3;
        this.zzVa = str2;
        if (account3 != null || TextUtils.isEmpty(str2)) {
            this.zzTI = account3;
            return;
        }
        Account account4 = account2;
        Account account5 = new Account(str2, zzd.GOOGLE_ACCOUNT_TYPE);
        this.zzTI = account4;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzTI;
    }

    public String getAccountName() {
        return this.zzVa;
    }

    public int getEventIndex() {
        return this.zzVc;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzTI = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzVa = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzVc = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
