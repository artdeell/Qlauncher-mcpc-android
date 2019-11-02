package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

public final class AccountPicker {
    private AccountPicker() {
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle) {
        return zza(account, arrayList, strArr, z, str, str2, strArr2, bundle, false);
    }

    public static Intent zza(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2) {
        return zza(account, arrayList, strArr, z, str, str2, strArr2, bundle, z2, 0, 0);
    }

    public static Intent zza(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2, int i, int i2) {
        return zza(account, arrayList, strArr, z, str, str2, strArr2, bundle, z2, i, i2, null, false);
    }

    public static Intent zza(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle, boolean z2, int i, int i2, String str3, boolean z3) {
        Intent intent;
        Account account2 = account;
        ArrayList<Account> arrayList2 = arrayList;
        String[] strArr3 = strArr;
        boolean z4 = z;
        String str4 = str;
        String str5 = str2;
        String[] strArr4 = strArr2;
        Bundle bundle2 = bundle;
        boolean z5 = z2;
        int i3 = i;
        int i4 = i2;
        String str6 = str3;
        boolean z6 = z3;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        if (!z6) {
            zzx.zzb(str6 == null, (Object) "We only support hostedDomain filter for account chip styled account picker");
        }
        Intent action = intent4.setAction(z6 ? "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE" : "com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        Intent intent5 = intent4.setPackage("com.google.android.gms");
        Intent putExtra = intent4.putExtra("allowableAccounts", arrayList2);
        Intent putExtra2 = intent4.putExtra("allowableAccountTypes", strArr3);
        Intent putExtra3 = intent4.putExtra("addAccountOptions", bundle2);
        Intent putExtra4 = intent4.putExtra("selectedAccount", account2);
        Intent putExtra5 = intent4.putExtra("alwaysPromptForAccount", z4);
        Intent putExtra6 = intent4.putExtra("descriptionTextOverride", str4);
        Intent putExtra7 = intent4.putExtra("authTokenType", str5);
        Intent putExtra8 = intent4.putExtra("addAccountRequiredFeatures", strArr4);
        Intent putExtra9 = intent4.putExtra("setGmsCoreAccount", z5);
        Intent putExtra10 = intent4.putExtra("overrideTheme", i3);
        Intent putExtra11 = intent4.putExtra("overrideCustomTheme", i4);
        Intent putExtra12 = intent4.putExtra("hostedDomainFilter", str6);
        return intent4;
    }
}
