package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {
    private final Intent mIntent;

    public UserRecoverableException(String str, Intent intent) {
        Intent intent2 = intent;
        super(str);
        this.mIntent = intent2;
    }

    public Intent getIntent() {
        Intent intent;
        Intent intent2 = intent;
        Intent intent3 = new Intent(this.mIntent);
        return intent2;
    }
}
