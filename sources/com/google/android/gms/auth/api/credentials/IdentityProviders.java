package com.google.android.gms.auth.api.credentials;

import android.accounts.Account;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.zzd;
import com.google.android.gms.common.internal.zzx;

public final class IdentityProviders {
    public static final String FACEBOOK = "https://www.facebook.com";
    public static final String GOOGLE = "https://accounts.google.com";
    public static final String LINKEDIN = "https://www.linkedin.com";
    public static final String MICROSOFT = "https://login.live.com";
    public static final String PAYPAL = "https://www.paypal.com";
    public static final String TWITTER = "https://twitter.com";
    public static final String YAHOO = "https://login.yahoo.com";

    private IdentityProviders() {
    }

    @Nullable
    public static final String getIdentityProviderForAccount(@NonNull Account account) {
        Account account2 = account;
        Object zzb = zzx.zzb(account2, (Object) "account cannot be null");
        if (zzd.GOOGLE_ACCOUNT_TYPE.equals(account2.type)) {
            return GOOGLE;
        }
        if ("com.facebook.auth.login".equals(account2.type)) {
            return FACEBOOK;
        }
        return null;
    }
}
