package com.google.android.gms.auth;

import android.content.Intent;

public class UserRecoverableAuthException extends GoogleAuthException {
    private final Intent mIntent;

    public UserRecoverableAuthException(String str, Intent intent) {
        Intent intent2 = intent;
        super(str);
        this.mIntent = intent2;
    }

    public Intent getIntent() {
        Intent intent;
        if (this.mIntent == null) {
            return null;
        }
        Intent intent2 = intent;
        Intent intent3 = new Intent(this.mIntent);
        return intent2;
    }
}
